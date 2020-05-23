package com.manors.parkview.practicalunittesting.bl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.awaitility.Awaitility;
import org.junit.Test;

public class ServerTest {

	@Test
	public void testServer() throws Exception {
		assertTrue(true);
	}

	@Test
	public void testServe() throws Exception {
		assertTrue(true);
	}

	@Test
	public void shouldSaveTasks() throws InterruptedException {
		final ExecutorService executorService = Executors.newCachedThreadPool();
		final TaskService taskService = mock(TaskService.class);
		final Task task = mock(Task.class);
		final Request request = mock(Request.class);
		final Server server = new Server(executorService, taskService);
		List<Task> listOfTasks = Arrays.asList(task);
		when(request.getTasks()).thenReturn(listOfTasks);
		server.serve(request);

		Awaitility.await()
		.atMost(1, TimeUnit.SECONDS).with()
		.pollInterval(100, TimeUnit.MILLISECONDS).and().with()
		.until(new Callable<Boolean>() {

					@Override
					public Boolean call() throws Exception {
						try {
							verify(taskService).handle(task);
							return true;
						} catch (final AssertionError ae) {
						return false;
					}
				}
			});
	}
}
