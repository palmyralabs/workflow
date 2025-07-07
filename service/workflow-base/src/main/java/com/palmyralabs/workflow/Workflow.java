package com.palmyralabs.workflow;

import java.util.List;

public interface Workflow {
	String getId();
	
	String getWorkflowName();
	
	String getWorkflowVersion();
	
	List<Task> getTasks();
	
	List<Task> getNextTasks();
	
	List<Task> getCurrentTasks();
	
	Task getCurrentTask();
	
	Task getNextTask(String taskId);	
}
