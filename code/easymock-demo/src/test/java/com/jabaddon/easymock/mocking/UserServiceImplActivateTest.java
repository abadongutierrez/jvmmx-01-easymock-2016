package com.jabaddon.easymock.mocking;

import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;

public class UserServiceImplActivateTest {
   private UserService userService;
   private UserRepository userRepositoryMock;

   @Before
   public void setUp() throws Exception {
      // 1. Create Mock Object
      userRepositoryMock = mock(UserRepository.class);
      userService = new UserServiceImpl(userRepositoryMock);
   }

   @Test
   public void activate()  {
      // 2. Record the expected behaviour
      User user = new User();
      userRepositoryMock.persist(user);
      expectLastCall();
      expect(userRepositoryMock.findById(1L)).andReturn(user);

      // 3. Switch mock object to replay state
      replay(userRepositoryMock);

      userService.activate(1L);
   }
}
