//
//  RNEwayPaymentsBridge.m
//  RNEwayPayments
//
//  Created by Julian Rodriguez Nicastro on 16/07/2019.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import "RNEwayPayments-Bridging-Header.h"

@interface RCT_EXTERN_MODULE(PaymentManager, NSObject)

RCT_EXPORT_MODULE();

RCT_EXTERN_METHOD(build:(NSString *)key)

RCT_EXTERN_METHOD(setCardDetail:
                  (NSString *)name
                  number:(NSString *)number
                  month:(NSString *)month
                  year:(NSString *)year
                  cvn:(NSString *)cvn
                  )

RCT_EXTERN_METHOD(setCustomerDetail:
                  (NSString *)name
                  lastName:(NSString *)lastName
                  )

RCT_EXTERN_METHOD(setPaymentDetail:
                  (NSString *)currencyCode
                  totalAmount:(nonnull NSNumber *)totalAmount
                  invoiceDescription:(NSString *)invoiceDescription
                  )

RCT_EXTERN_METHOD(pay:(void))

@end
