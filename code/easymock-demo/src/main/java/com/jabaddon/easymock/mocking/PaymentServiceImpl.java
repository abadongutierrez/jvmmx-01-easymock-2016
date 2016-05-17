package com.jabaddon.easymock.mocking;

public class PaymentServiceImpl implements PaymentService {
   private final FraudDetectionService fraudDetectionService;
   private final CustomerService customerService;

   public PaymentServiceImpl(FraudDetectionService fraudDetectionService, CustomerService customerService) {
      this.fraudDetectionService = fraudDetectionService;
      this.customerService = customerService;
   }

   @Override
   public PaymentTransaction charge(Customer customer, CreditCard creditCard, MonetaryAmount amount) {
      // some complex code
      PaymentTransaction paymentTransaction = new PaymentTransaction();
      // more some complex code

      Address billingAddress = customerService.getConfiguredBillingAddress(customer);
      Address shippingAddress = customerService.getConfiguredShippingAddress(customer);
      fraudDetectionService.verify(customer, billingAddress, shippingAddress, creditCard, paymentTransaction);

      // even more complex code
      return paymentTransaction;
   }
}
