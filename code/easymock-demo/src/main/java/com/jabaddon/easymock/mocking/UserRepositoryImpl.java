package com.jabaddon.easymock.mocking;

public class UserRepositoryImpl implements UserRepository {
   @Override
   public User findById(Long userId) {
      return new User();
   }

   @Override
   public void persist(User user) {

   }
}
