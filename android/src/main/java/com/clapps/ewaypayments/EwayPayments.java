package com.clapps.ewaypayments;

import com.eway.payment.sdk.android.RapidAPI;
import com.eway.payment.sdk.android.RapidConfigurationException;
import com.eway.payment.sdk.android.beans.CardDetails;
import com.eway.payment.sdk.android.beans.Customer;
import com.eway.payment.sdk.android.beans.Payment;
import com.eway.payment.sdk.android.beans.Transaction;
import com.eway.payment.sdk.android.beans.TransactionType;

import java.io.IOException;
import java.util.UUID;

public class EwayPayments {

  public EwayPayments() {
    RapidAPI.RapidEndpoint = "Sandbox";
  }

  public void pay(
          EWayCardDetail eWayCardDetail,
          EWayCustomer eWayCustomer,
          EWayPaymentDetail eWayPaymentDetail
  ) {
    // KEY
    RapidAPI.PublicAPIKey = RNEwayPaymentsModule.KEY;

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
      RapidAPI.submitPayment(transaction);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (RapidConfigurationException $error) {
      $error.printStackTrace();
    }
  }
}