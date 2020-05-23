package com.manors.parkview.practicalunittesting.util;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import com.google.code.tempusfugit.concurrency.ConcurrentRule;
import com.google.code.tempusfugit.concurrency.RepeatingRule;
import com.google.code.tempusfugit.concurrency.annotations.Concurrent;
import com.google.code.tempusfugit.concurrency.annotations.Repeating;

import org.junit.Test;

import ch.powerunit.Rule;

public class AutomicIdGeneratorParallelTest {

    @Rule
    public ConcurrentRule concurrently = new ConcurrentRule();

    @Rule
    public RepeatingRule repeatedly = new RepeatingRule();

    private IdGenerator idGen = new AutomicIdGenerator();
    private Set<Long> ids = new HashSet<>(100);

    @Test
    @Concurrent(count = 10)
    @Repeating(repetition = 140)
    public void idsShouldBeUnique() throws Exception {
        assertTrue(ids.add(idGen.nextId()));
    }
    
}