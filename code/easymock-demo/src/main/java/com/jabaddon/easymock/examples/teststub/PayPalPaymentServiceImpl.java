package com.jabaddon.easymock.examples.teststub;

public class PayPalPaymentServiceImpl implements Service {

   public PayPalPaymentServiceImpl() {

   }

   @Override
   public CompletedPayment execute(ApprovedPayment approvedPayment) {
      /*
      JsonObject request = _payPalApiHelper.createExecutePaymentRequest(approvedPayment);
      JsonObject response = _payPalApi.executePaymentRequest(request);
      if (!_payPalApiHelper.isApproved(response)) {
         throw new NotApprovedException();
      }
      return _payPalApiHelper.parsePaymentResponse(response);
       */
      return null;
   }
}
