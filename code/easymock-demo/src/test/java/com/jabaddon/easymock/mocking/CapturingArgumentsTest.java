package com.jabaddon.easymock.mocking;

import org.easymock.Capture;
import org.easymock.CaptureType;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CapturingArgumentsTest {
   @Test
   public void testCapture() {
      SomeService someService = mock(SomeService.class);

      Capture<User> userCaptured = Capture.newInstance(CaptureType.ALL);
      expect(someService.someMethod(capture(userCaptured))).andStubReturn(false);

      replay(someService);

      someService.someMethod(createUser(1L));
      someService.someMethod(createUser(2L));
      someService.someMethod(createUser(3L));
      someService.someMethod(createUser(4L));

      assertThat(userCaptured.getValues().size(), is(4));
      assertThat(userCaptured.getValues().get(0).getId(), is(1L));
      assertThat(userCaptured.getValues().get(1).getId(), is(2L));
      assertThat(userCaptured.getValues().get(2).getId(), is(3L));
      assertThat(userCaptured.getValues().get(3).getId(), is(4L));
   }

   private User createUser(long id) {
      User user = new User();
      user.setId(id);
      return user;
   }
}
