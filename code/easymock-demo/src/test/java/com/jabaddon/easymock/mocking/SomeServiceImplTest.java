package com.jabaddon.easymock.mocking;

import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

public class SomeServiceImplTest {

   private SomeService someService;
   private Collaborator mock;

   @Before
   public void setUp() throws Exception {
      mock = mock(Collaborator.class);
      someService = new SomeServiceImpl(mock);
   }

   @Test
   public void test_()  {
      mock.help();
      expectLastCall().times(2);

      replay(mock);

      someService.execute();

      verify(mock);
   }
}