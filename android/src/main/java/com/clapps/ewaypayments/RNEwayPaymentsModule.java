package com.clapps.ewaypayments;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNEwayPaymentsModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private final EwayPayments ewayPayments;

  private EWayCardDetail eWayCardDetail;
  private EWayCustomer eWayCustomer;
  private EWayPaymentDetail eWayPaymentDetail;
  protected static String KEY;

  public RNEwayPaymentsModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    this.ewayPayments = new EwayPayments();
  }

  @Override
  public String getName() {
    return "RNEwayPayments";
  }

  @ReactMethod
  public void setUpKey(String key) {
    RNEwayPaymentsModule.KEY = key;
  }

  @ReactMethod
  public void setCardDetail(
          String name,
          String number,
          String month,
          String year,
          String cvn
  ) {
    this.eWayCardDetail = new EWayCardDetail(name, number, month, year, cvn) ;
  }

  @ReactMethod
  public void setCustomerDetail(String firstName, String lastName) {
    this.eWayCustomer = new EWayCustomer(firstName, lastName);
  }

  @ReactMethod
  public void setPaymentDetail(String currencyCode, Integer totalAmount, String invoiceDescription) {
    this.eWayPaymentDetail = new EWayPaymentDetail(currencyCode, totalAmount, invoiceDescription);
  }

  @ReactMethod
  public void pay() {
    this.ewayPayments.pay(
            this.eWayCardDetail,
            this.eWayCustomer,
            this.eWayPaymentDetail
    );
  }
}