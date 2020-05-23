package com.manors.parkview.practicalunittesting.util;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class AutomicIdGeneratorTest {
	private IdGenerator idGen = new AutomicIdGenerator();

	@Test
	public void idsShouldBeUnique() throws Exception {
		Long idA = idGen.nextId();
		Long idB = idGen.nextId();


		String errorMessage = String.format("idA: %d should not be equal to idB: %d.", idA, idB);
		assertNotEquals(errorMessage, idA, idB);
	}

}
