package com.jabaddon.easymock.mocking;

public interface PaymentService {
   PaymentTransaction charge(Customer customer, CreditCard creditCard, MonetaryAmount amount);
}
