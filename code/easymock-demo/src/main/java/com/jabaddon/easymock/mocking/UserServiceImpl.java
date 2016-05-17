package com.jabaddon.easymock.mocking;

public class UserServiceImpl implements UserService {
   private final UserRepository userRepository;

   public UserServiceImpl(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Override
   public User findById(Long userId) {
      return userRepository.findById(userId);
   }

   @Override
   public void activate(Long userId) {
      User user = userRepository.findById(userId);
      user.activate(true);
      userRepository.persist(user);
   }
}
