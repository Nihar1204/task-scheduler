package com.project.task_scheduler;

import org.springframework.stereotype.Component;

@Component
public class TaskRunner {

	private final TaskSchedulerService taskSchedulerService;
	
	public TaskRunner(TaskSchedulerService taskSchedulerService) {
		this.taskSchedulerService = taskSchedulerService;
	}
	
	public void runTask() {
		System.out.println("Running scheduled tasks...");
		taskSchedulerService.executeTasks();
	}
}
