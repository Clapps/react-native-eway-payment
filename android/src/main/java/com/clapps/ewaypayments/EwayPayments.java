package com.clapps.ewaypayments;

import com.eway.payment.sdk.android.RapidAPI;
import com.eway.payment.sdk.android.RapidConfigurationException;
import com.eway.payment.sdk.android.beans.CardDetails;
import com.eway.payment.sdk.android.beans.Customer;
import com.eway.payment.sdk.android.beans.Payment;
import com.eway.payment.sdk.android.beans.Transaction;
import com.eway.payment.sdk.android.beans.TransactionType;
import com.eway.payment.sdk.android.entities.SubmitPayResponse;
import com.facebook.react.bridge.Promise;

import java.io.IOException;
import java.util.UUID;

public class EwayPayments {

  public EwayPayments(String key) {
    RapidAPI.RapidEndpoint = "https://api.sandbox.ewaypayments.com";
    RapidAPI.PublicAPIKey = key;
  }

  public void pay(
          EWayCardDetail eWayCardDetail,
          EWayCustomer eWayCustomer,
          EWayPaymentDetail eWayPaymentDetail,
          Promise promise
  ) throws RapidConfigurationException {
    // CARD DETAIL
    String name = eWayCardDetail.name;
    String number = eWayCardDetail.number;
    String month = eWayCardDetail.month;
    String year = eWayCardDetail.year;
    String cvn = eWayCardDetail.cvn;

    // CUSTOMER
    String firstName = eWayCustomer.firstName;
    String lastName = eWayCustomer.lastName;

    // PAYMENT
    String currencyCode = eWayPaymentDetail.currencyCode;
    Integer totalAmount = eWayPaymentDetail.totalAmount;
    String invoiceDescription = eWayPaymentDetail.invoiceDescription;

    CardDetails cardDetails = new CardDetails();
    cardDetails.setName(name);
    cardDetails.setNumber(number);
    cardDetails.setExpiryMonth(month);
    cardDetails.setExpiryYear(year);
    cardDetails.setCVN(cvn);

    Customer customer = new Customer();
    customer.setFirstName(firstName);
    customer.setLastName(lastName);
    customer.setCardDetails(cardDetails);

    Payment payment = new Payment();
    payment.setCurrencyCode(currencyCode);
    payment.setTotalAmount(totalAmount);

    payment.setInvoiceNumber(UUID.randomUUID().toString());
    payment.setInvoiceReference(UUID.randomUUID().toString());
    payment.setInvoiceDescription(invoiceDescription);

    Transaction transaction = new Transaction();
    transaction.setCustomer(customer);
    transaction.setTransactionType(TransactionType.Purchase);
    transaction.setPayment(payment);

    try {
      SubmitPayResponse response = RapidAPI.submitPayment(transaction);
      promise.resolve(response.getStatus());
    } catch (IOException e) {
      promise.reject(e.getMessage());
    } catch (RapidConfigurationException $error) {
      promise.reject($error.getErrorCodes());
    }
  }
}