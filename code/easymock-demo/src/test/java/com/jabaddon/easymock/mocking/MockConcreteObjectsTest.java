package com.jabaddon.easymock.mocking;

import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class MockConcreteObjectsTest {
   @Test
   public void test() {
      User user = mock(User.class);

      expect(user.getId()).andReturn(101L);

      replay(user);

      assertThat(user.getId(), is(101L));
      assertThat(new User().getId(), is(nullValue()));

      verify(user);
   }
}
