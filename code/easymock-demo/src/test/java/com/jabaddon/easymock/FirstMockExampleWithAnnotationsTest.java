package com.jabaddon.easymock;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.replay;

@RunWith(EasyMockRunner.class)
public class FirstMockExampleWithAnnotationsTest {
   @TestSubject
   private ClassUnderTest classUnderTest = new ClassUnderTest();

   @Mock(type = MockType.NICE)
   private Collaborator collaborator;

   @Test
   public void testRemoveNonExistingDocument() {
      replay(collaborator);
      classUnderTest.removeDocument("Does not exist");
   }

}
