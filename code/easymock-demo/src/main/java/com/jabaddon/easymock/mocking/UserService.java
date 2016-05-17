package com.jabaddon.easymock.mocking;

public interface UserService {
   User findById(Long userId);

   void activate(Long userId);
}
