package com.jabaddon.easymock.mocking;

public interface FraudDetectionService {
   void verify(Customer customer, Address billingAddress, Address shippingAddress, CreditCard number, PaymentTransaction paymentTransaction);
}
