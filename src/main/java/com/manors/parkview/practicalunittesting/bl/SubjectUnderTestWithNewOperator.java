package com.manors.parkview.practicalunittesting.bl;

public class SubjectUnderTestWithNewOperator {

    public void methodWithNewOperator(){
        MyCollaborator collaborator = new MyCollaborator();
        String resultString = collaborator.actionMethod("input String");
        collaborator.process(resultString);
    }
    
}