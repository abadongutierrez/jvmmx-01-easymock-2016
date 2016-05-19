package com.jabaddon.easymock.mocking;

import org.junit.Test;

import static org.easymock.EasyMock.*;

public class IExpectationSettersNumCallsTest {
   @Test
   public void testExpectedReturnTimes() {
      UserService userService = mock(UserService.class);

      User user = new User();
      user.setId(101L);
      expect(userService.findById(1L)).andReturn(user);
      expect(userService.findById(1L)).andReturn(user);
      expect(userService.findById(1L)).andReturn(user);

      replay(userService);

      //verify(userService);
   }

   @Test
   public void testExpectedVoidTimes() {
      UserService userService = mock(UserService.class);

      User user = new User();
      user.setId(101L);
      userService.activate(1L);
      expectLastCall();

      replay(userService);

      //verify(userService);
   }
}
