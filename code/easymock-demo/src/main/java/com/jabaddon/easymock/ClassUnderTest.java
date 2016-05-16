package com.jabaddon.easymock;

public class ClassUnderTest {

   private Collaborator collaborator;

   public ClassUnderTest() {
   }

   public void removeDocument(String docName) {
      collaborator.documentRemoved(docName);
   }

   public void setListener(Collaborator collaborator) {
      this.collaborator = collaborator;
   }
}
