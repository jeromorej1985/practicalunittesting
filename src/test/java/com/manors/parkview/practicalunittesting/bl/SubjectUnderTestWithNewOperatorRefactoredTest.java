package com.manors.parkview.practicalunittesting.bl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class SubjectUnderTestWithNewOperatorRefactoredTest {
	private SubjectUnderTestWithNewOperatorRefactored sut;
	private MyCollaborator collaborator;

	@Before
	public void initialize() {
		sut = new SubjectUnderTestWithNewOperatorRefactoredSubclassed();
		collaborator = mock(MyCollaborator.class);
		
	}

	@Test
	public void shouldAllowCollaboratorToBeInjectedByParentClass() throws Exception {
		String result = "Yellow Tail Snapper";
		when(collaborator.actionMethod(Mockito.anyString())).thenReturn(result);

		sut.methodWithNewOperator();
		verify(collaborator, times(1)).process(result);
	}

	@Test
	public void testCreateCollaborator() throws Exception {
		assertTrue(true);
	}

	private class SubjectUnderTestWithNewOperatorRefactoredSubclassed extends SubjectUnderTestWithNewOperatorRefactored {
		@Override 
		protected MyCollaborator createCollaborator() {
			return collaborator;
		}
	}

}
