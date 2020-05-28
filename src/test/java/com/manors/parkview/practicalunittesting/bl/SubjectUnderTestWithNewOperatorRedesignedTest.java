package com.manors.parkview.practicalunittesting.bl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class SubjectUnderTestWithNewOperatorRedesignedTest {
	private SubjectUnderTestWithNewOperatorRedesigned sut;
	private MyCollaborator collaborator;

	@Before
	public void initialize(){
		collaborator = mock(MyCollaborator.class);
		sut = new SubjectUnderTestWithNewOperatorRedesigned(collaborator);
	}

	@Test
	public void shouldTestSUTMethodWithNormalMockitoStubbing() throws Exception {
		 String result = "Pink Panther";
		 when(collaborator.actionMethod(Mockito.anyString())).thenReturn(result);

		 sut.methodWithNewOperator();
		 verify(collaborator, times(1)).process(result);
	}

	@Test
	public void testMethodWithNewOperator() throws Exception {
		assertTrue(true);
	}

}
