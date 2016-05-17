package com.jabaddon.easymock.mocking;

import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.niceMock;
import static org.easymock.EasyMock.replay;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class PaymentServiceImplChargeTest {
   private PaymentService paymentService;
   private CustomerService customerService;
   private FraudDetectionService fraudDetectionService;

   @Before
   public void setUp() throws Exception {
      // what if we change to mock?
      customerService = mock(CustomerService.class);
      fraudDetectionService = niceMock(FraudDetectionService.class);

      paymentService = new PaymentServiceImpl(fraudDetectionService, customerService);
   }

   @Test
   public void test() {
      replay(customerService, fraudDetectionService);

      Customer customer = new Customer();
      CreditCard creditCard = new CreditCard();
      MonetaryAmount monetaryAmount = new MonetaryAmount(1500, "USD");

      PaymentTransaction paymentTransaction = paymentService.charge(customer, creditCard, monetaryAmount);

      assertThat(paymentTransaction, is(not(nullValue())));
   }

}