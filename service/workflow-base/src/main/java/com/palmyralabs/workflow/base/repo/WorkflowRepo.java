package com.palmyralabs.workflow.base.repo;

import com.palmyralabs.workflow.Task;
import com.palmyralabs.workflow.Workflow;

public interface WorkflowRepo {
	String create(Workflow workflow);
	
	Workflow getWorkflow(String workflowId);
	
	Task getTask(String taskId);
	
	void update(String workflowId, Workflow workflow);
	
	String create(Task task);
	
	void update(String taskId, Task task);
}
