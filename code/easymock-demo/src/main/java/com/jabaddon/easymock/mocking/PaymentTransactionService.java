package com.jabaddon.easymock.mocking;

public interface PaymentTransactionService {
   PaymentTransaction createNewTransaction(Customer customer, CreditCard creditCard, MonetaryAmount amount);

   void apply(PaymentTransaction paymentTransaction);
}
