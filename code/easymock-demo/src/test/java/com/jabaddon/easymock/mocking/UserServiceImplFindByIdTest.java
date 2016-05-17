package com.jabaddon.easymock.mocking;

import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserServiceImplFindByIdTest {

   private UserService userService;
   private UserRepository userRepositoryMock;

   @Before
   public void setUp() throws Exception {
      // 1. Create Mock Object
      userRepositoryMock = mock(UserRepository.class);
      userService = new UserServiceImpl(userRepositoryMock);
   }

   @Test
   public void findById()  {
      // 2. Record the expected behaviour
      User user = new User();
      expect(userRepositoryMock.findById(1L)).andReturn(user);

      // 3. Switch mock object to replay state
      replay(userRepositoryMock);

      User userById = userService.findById(1L);

      assertThat(userById, is(user));
   }
}