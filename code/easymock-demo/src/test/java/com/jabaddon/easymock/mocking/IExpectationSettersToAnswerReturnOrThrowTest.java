package com.jabaddon.easymock.mocking;

import org.easymock.IAnswer;
import org.junit.Test;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.replay;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class IExpectationSettersToAnswerReturnOrThrowTest {

   @Test
   public void testAnswer() {
      UserService userService = mock(UserService.class);
      // record state
      expect(userService.findById(1L)).andAnswer(new IAnswer<User>() {
         @Override
         public User answer() throws Throwable {
            User user = new User();
            user.setId(101L);
            return user;
         }
      });

      // switch to replay state
      replay(userService);

      User userbyId = userService.findById(1L);

      assertThat(userbyId.getId(), is(101L));
   }

   @Test
   public void testReturn() {
      UserService userService = mock(UserService.class);
      // record state
      User user = new User();
      user.setId(101L);
      expect(userService.findById(1L)).andReturn(user);

      // switch to replay state
      replay(userService);

      User userbyId = userService.findById(1L);

      assertThat(userbyId, is(user));
      assertThat(userbyId.getId(), is(101L));
   }

   @Test(expected = RuntimeException.class)
   public void testThrow() {
      UserService userService = mock(UserService.class);
      // record state
      User user = new User();
      user.setId(101L);
      expect(userService.findById(1L)).andThrow(new RuntimeException("POOOOM!"));

      // switch to replay state
      replay(userService);

      userService.findById(1L);
   }
}
