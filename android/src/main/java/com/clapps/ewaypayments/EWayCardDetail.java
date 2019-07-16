package com.clapps.ewaypayments;

public class EWayCardDetail {
    String name = null;
    String number = null;
    String month = null;
    String year = null;
    String cvn = null;

    EWayCardDetail(
            String name,
            String number,
            String month,
            String year,
            String cvn
    ) {
        this.name = name;
        this.number = number;
        this.month = month;
        this.year = year;
        this.cvn = cvn;
    }
}
