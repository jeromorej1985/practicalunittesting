package com.manors.parkview.practicalunittesting.bl;

public class SubjectUnderTestWithNewOperatorRefactored {

    public void methodWithNewOperator(){
        MyCollaborator collaborator = createCollaborator();
        String resultString = collaborator.actionMethod("input String");
        collaborator.process(resultString);
    }

    // method extracted for the purpose of testing
    protected MyCollaborator createCollaborator() {
        return new MyCollaborator();
    }
}