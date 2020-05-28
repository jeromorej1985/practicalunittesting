package com.manors.parkview.practicalunittesting.bl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@PrepareForTest(SubjectUnderTestWithNewOperator.class)
@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"javax.management.*", "com.sun.org.apache.xerces.*", 
  "javax.xml.*", "org.xml.*", "org.w3c.dom.*",
  "com.sun.org.apache.xalan.*", "javax.activation.*", "jdk.internal.reflect.*"})
public class SubjectUnderTestWithNewOperatorTest {
	private SubjectUnderTestWithNewOperator sut;
	private MyCollaborator collaborator;

	@Before
	public void initialize() {
		sut = new SubjectUnderTestWithNewOperator();
		collaborator = mock(MyCollaborator.class);
	}

	@Test
	public void testMethodWithNewOperator() throws Exception {
		String resultString = "Blue Almonds";
		PowerMockito.whenNew(MyCollaborator.class).withNoArguments().thenReturn(collaborator);
		when(collaborator.actionMethod(Mockito.anyString())).thenReturn(resultString);

		sut.methodWithNewOperator();
		verify(collaborator, times(1)).process(resultString);
	}

}
