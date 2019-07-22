#import "RNEwayPayments.h"
#import <React/RCTLog.h>

@implementation RNEwayPayments

Customer *customer;
CardDetails *cardDetails;
Payment *payment;

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(build:(NSString *)key) {
    [[RapidAPI sharedManager] setRapidEndpoint:@"https://api.sandbox.ewaypayments.com/"];
    [[RapidAPI sharedManager] setPublicAPIKey:key];

    customer = [[Customer alloc] init];
    cardDetails = [[CardDetails alloc] init];
    payment = [[Payment alloc] init];
}

RCT_EXPORT_METHOD(sandbox) {
    [[RapidAPI sharedManager] setRapidEndpoint:@"https://api.sandbox.ewaypayments.com/"];
}

RCT_EXPORT_METHOD(production) {
    [[RapidAPI sharedManager] setRapidEndpoint:@"https://api.ewaypayments.com/"];
}

RCT_EXPORT_METHOD(setCardDetail:(NSString *)name
                  number:(NSString *)number
                  month:(NSString *)month
                  year:(NSString *)year
                  cvn:(NSString *)cvn
                  ) {
    cardDetails.Name = name;
    cardDetails.Number = number;
    cardDetails.ExpiryMonth = month;
    cardDetails.ExpiryYear = year;
    cardDetails.CVN = cvn;
}

RCT_EXPORT_METHOD(setCustomerDetail:(NSString *)name
                  lastName:(NSString *)lastName
) {
    customer.FirstName = name;
    customer.LastName = lastName;
}

RCT_EXPORT_METHOD(setPaymentDetail:(NSString *)currencyCode
                  totalAmount:(nonnull int *)totalAmount
                  invoiceDescription:(NSString *)invoiceDescription
) {
    payment.Payment = totalAmount;
    payment.InvoiceDescription = invoiceDescription;
    payment.CurrencyCode = currencyCode;
}

RCT_REMAP_METHOD(pay,
                  findEventsWithResolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject
) {
    Transaction *transaction = [[Transaction alloc] init];
    customer.CardDetails = cardDetails;
    transaction.Customer = customer;
    transaction.Payment = payment;

    [RapidAPI submitPayment:transaction completed:^(SubmitPaymentResponse *submitPaymentResponse) {
        NSString *submissionID = submitPaymentResponse.SubmissionID;
        NSString *error = submitPaymentResponse.Errors;
        if ([error isEqual:@"<null>"]) {
            resolve(submissionID);
        } else {
            NSError *error = nil;
            NSLog(@"%@",error);
            reject(@"PAYMENT_ERROR", submitPaymentResponse.Errors, error);
        }
    }];
}

@end
