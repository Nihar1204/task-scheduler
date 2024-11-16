package com.project.task_scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskSchedulerController {

    @Autowired
    private TaskSchedulerService taskSchedulerService;

    @PostMapping("/add")
    public String addTask(@RequestBody Task task) {
        taskSchedulerService.addTask(task);
        return "Task added!";
    }

    @GetMapping("/execute")
    public String executeTasks() {
        taskSchedulerService.executeTasks();
        return "Tasks execution started!";
    }
}