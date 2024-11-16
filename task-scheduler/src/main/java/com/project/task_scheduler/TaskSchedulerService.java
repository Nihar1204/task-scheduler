package com.project.task_scheduler;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class TaskSchedulerService {
    private final PriorityQueue<Task> taskQueue;
    private final ExecutorService executor;

    public TaskSchedulerService() {
        this.taskQueue = new PriorityQueue<>();
        this.executor = Executors.newFixedThreadPool(3); // Customize as needed
    }

    public void addTask(Task task) {
        taskQueue.add(task);
    }

    @Async
    public void executeTasks() {
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            if (task != null) {
                executor.submit(() -> {
                    try {
                        System.out.println("Executing task: " + task.getTaskName());
                        Thread.sleep(task.getExecutionTime());
                        System.out.println("Task completed: " + task.getTaskName());
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.err.println("Task interrupted: " + task.getTaskName());
                    }
                });
            }
        }
    }

    public void shutdownScheduler() {
        executor.shutdown();
    }
}