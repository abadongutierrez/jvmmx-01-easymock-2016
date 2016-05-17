package com.jabaddon.easymock.mocking;

public interface UserRepository {
   User findById(Long userId);

   void persist(User user);
}
