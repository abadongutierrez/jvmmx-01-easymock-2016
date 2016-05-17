package com.jabaddon.easymock.mocking;

public interface CustomerService {
   Address getConfiguredBillingAddress(Customer customer);

   Address getConfiguredShippingAddress(Customer customer);
}
