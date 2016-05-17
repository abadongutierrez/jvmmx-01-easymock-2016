package com.jabaddon.easymock.mocking;

import java.util.Random;

public class CollaboratorImpl implements Collaborator {
   @Override
   public void help() {
      System.out.println(getClass().getName() + "->" + "help()");
   }
}
