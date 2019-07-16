package com.clapps.ewaypayments;

public class EWayPaymentDetail {
    String currencyCode = null;
    Integer totalAmount = null;
    String invoiceDescription = null;

    public EWayPaymentDetail(String currencyCode, Integer totalAmount, String invoiceDescription) {
        this.currencyCode = currencyCode;
        this.totalAmount = totalAmount;
        this.invoiceDescription = invoiceDescription;
    }
}
