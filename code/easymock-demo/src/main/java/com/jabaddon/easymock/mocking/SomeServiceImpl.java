package com.jabaddon.easymock.mocking;

public class SomeServiceImpl implements SomeService {
   private final Collaborator collaborator;

   public SomeServiceImpl(Collaborator collaborator) {
      this.collaborator = collaborator;
   }

   @Override
   public void execute() {
      System.out.println(getClass().getName() + "->execute()");
      collaborator.help();
   }
}
