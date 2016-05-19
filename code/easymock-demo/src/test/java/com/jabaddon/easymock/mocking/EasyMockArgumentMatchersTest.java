package com.jabaddon.easymock.mocking;

import org.easymock.EasyMock;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EasyMockArgumentMatchersTest {
   @Test
   public void testEq() {
      SomeService someService = mock(SomeService.class);

      expect(someService.someMethod(anyString(), eq(150)))
            .andReturn(false)
            .andReturn(true);

      replay(someService);

      assertThat(someService.someMethod("AnyString!", 150), is(false));
      assertThat(someService.someMethod("Other String!", 150), is(true));

      verify(someService);
   }

   @Test
   public void testStartsWithEndsWithContains() {
      SomeService someService = mock(SomeService.class);

      expect(someService.someMethod(startsWith("ABC"), eq(150))).andReturn(false);
      expect(someService.someMethod(and(startsWith("ABC"), endsWith("ABC")), gt(150))).andReturn(false);
      expect(someService.someMethod(contains("XYZ"), anyInt())).andReturn(true);

      replay(someService);

      assertThat(someService.someMethod("ABC AnyString!", 150), is(false));
      assertThat(someService.someMethod("ABC Other String! ABC", 151), is(false));
      assertThat(someService.someMethod("XYZ another string!", 34), is(true));

      verify(someService);
   }

   @Test(expected = RuntimeException.class)
   public void testIsA() {
      SomeService someService = mock(SomeService.class);

      expect(someService.someMethod(and(notNull(), isA(User.class))))
            .andThrow(new RuntimeException(""));

      replay(someService);

      someService.someMethod(new User());
   }
}
