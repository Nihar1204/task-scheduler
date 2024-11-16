package com.project.task_scheduler;


public class Task implements Comparable<Task> {
    private String taskName;
    private int priority;
    private long executionTime;

    public Task(String taskName, int priority, long executionTime) {
        this.taskName = taskName;
        this.priority = priority;
        this.executionTime = executionTime;
    }

    // Getters and setters...
    public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(long executionTime) {
		this.executionTime = executionTime;
	}
    

    @Override
    public int compareTo(Task other) {
        return Integer.compare(other.priority, this.priority);
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", priority=" + priority +
                ", executionTime=" + executionTime +
                '}';
    }

	
}