package com.clapps.ewaypayments;

import com.eway.payment.sdk.android.RapidConfigurationException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNEwayPaymentsModule extends ReactContextBaseJavaModule {

  private static final String SANDBOX_URL = "https://api.sandbox.ewaypayments.com";
  private static final String PRODUCTION_URL = "https://api.ewaypayments.com";
  private static  String URL = PRODUCTION_URL;

  private final ReactApplicationContext reactContext;

  private EwayPayments ewayPayments;
  private EWayCardDetail eWayCardDetail;
  private EWayCustomer eWayCustomer;
  private EWayPaymentDetail eWayPaymentDetail;
  protected static String KEY;

  public RNEwayPaymentsModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNEwayPayments";
  }

  @ReactMethod
  public void build(String key) {
    this.ewayPayments = new EwayPayments(key);
  }

  @ReactMethod
  public void sandbox() {
    this.URL = SANDBOX_URL;
  }

  @ReactMethod
  public void production() {
    this.URL = PRODUCTION_URL;
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
  public void pay(Promise promise) throws RapidConfigurationException {
    this.ewayPayments.pay(
            this.eWayCardDetail,
            this.eWayCustomer,
            this.eWayPaymentDetail,
            promise
    );
  }
}