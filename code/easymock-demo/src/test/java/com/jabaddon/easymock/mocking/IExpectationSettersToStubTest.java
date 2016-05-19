package com.jabaddon.easymock.mocking;

import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IExpectationSettersToStubTest {
   @Test
   public void testStubReturn() {
      UserService userService = mock(UserService.class);
      // record state
      User user = new User();
      user.setId(101L);
      expect(userService.findById(1L)).andReturn(user);
      expect(userService.findById(not(eq(1L)))).andStubReturn(null);

      // switch to replay state
      replay(userService);

      User userbyId = userService.findById(1L);
      // we dont care about this calls
      userService.findById(2L);
      userService.findById(3L);

      assertThat(userbyId, is(user));
      assertThat(userbyId.getId(), is(101L));
   }
}
