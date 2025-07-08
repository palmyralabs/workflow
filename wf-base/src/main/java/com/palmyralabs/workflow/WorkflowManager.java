package com.palmyralabs.workflow;

public interface WorkflowManager {
	
	void saveData(String workflowId, String taskExecutionId, Object data);

	Object getData(String workflowId, String taskExecutionId);
	
	void submitAction(String workflowId, String taskId, String action);
	
	void submitAction(String workflowId, String taskId, String action, Object data);
}
