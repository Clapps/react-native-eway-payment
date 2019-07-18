//
//  RNEwayPayments.swift
//  RNEwayPayments
//
//  Created by Julian Rodriguez Nicastro on 16/07/2019.
//  Copyright © 2019 Facebook. All rights reserved.
//

import Foundation

// CalendarManager.swift

@objc(PaymentManager)
class PaymentManager: NSObject {
    
    private var bridge: RCTBridge!  // this is synthesized
    
    private var cardDetail : CardDetail
    private var customerDetail : CustomerDetail
    private var paymentDetail : PaymentDetail
    
    @objc func build(key: String) -> Void {
        let transaction = Transaction()

    }
    
    @objc func pay() -> Void {
        print("JUDI")
        
    }
    
    @objc func setCardDetail(name: String, number: String, month: String, year: String, cvn: String){
        self.cardDetail = CardDetail(name: name,
                                     number: number,
                                     month: month,
                                     year: year,
                                     cvn: cvn)
    }
    
    @objc func setCustomerDetail(name: String, lastName: String){
        self.customerDetail = CustomerDetail(name: name,
                                             lastName: lastName)
    }
    
    @objc func setPaymentDetail(currencyCode: String, totalAmount: Int, invoiceDescription: String){
        self.customerDetail = CustomerDetail(currencyCode: currencyCode,
                                             totalAmount: totalAmount,
                                             invoiceDescription:invoiceDescription)
    }
    
}

@objc(CardDetail)
class CardDetail: NSObject {
    
    private var name : String
    private var number : String
    private var month : String
    private var year : String
    private var cvn : String
    
    internal init(name: String, number: String, month: String, year: String, cvn: String) {
        self.name = name
        self.number = number
        self.month = month
        self.year = year
        self.cvn = cvn
    }
}

@objc(CustomerDetail)
class CustomerDetail: NSObject {
    
    private var name : String
    private var lastName : String
    
    internal init(name: String, lastName: String) {
        self.name = name
        self.lastName = number
    }
}

@objc(PaymentDetail)
class PaymentDetail: NSObject {

    private var currencyCode : String
    private var totalAmount : Int
    private var invoiceDescription : String
    
    internal init(currencyCode: String, totalAmount: Int, invoiceDescription: String) {
        self.currencyCode = currencyCode
        self.totalAmount = totalAmount
        self.invoiceDescription = invoiceDescription
    }
}
