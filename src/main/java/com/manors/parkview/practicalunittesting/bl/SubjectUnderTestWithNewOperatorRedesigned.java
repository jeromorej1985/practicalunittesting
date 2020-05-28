package com.manors.parkview.practicalunittesting.bl;

public class SubjectUnderTestWithNewOperatorRedesigned {
    private final MyCollaborator collaborator;

    public SubjectUnderTestWithNewOperatorRedesigned(MyCollaborator collaborator) {
        this.collaborator = collaborator;
    }

    public void methodWithNewOperator(){
        String resultString = collaborator.actionMethod("input String");
        collaborator.process(resultString);
    }
    
}