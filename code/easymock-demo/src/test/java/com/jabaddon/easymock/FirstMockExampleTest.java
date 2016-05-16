package com.jabaddon.easymock;

import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.niceMock;
import static org.easymock.EasyMock.replay;

public class FirstMockExampleTest {

   private ClassUnderTest classUnderTest;

   private Collaborator collaborator;

   @Before
   public void setup() {
      collaborator = niceMock(Collaborator.class);
      classUnderTest = new ClassUnderTest();
      classUnderTest.setListener(collaborator);
   }

   @Test
   public void testRemoveNonExistingDocument() {
      replay(collaborator);
      classUnderTest.removeDocument("Does not exist");
   }
}
