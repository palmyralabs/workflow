package com.palmyralabs.workflow.base.repo;

import java.util.List;
import java.util.Set;

import com.palmyralabs.workflow.definition.TaskDef;
import com.palmyralabs.workflow.definition.WorkflowDef;

public interface WorkflowDefRepo {
	
	WorkflowDef getDefinition(String workflowName, String version);

	WorkflowDef getDefinition(String workflowDefId);

	Set<TaskDef> getAllTasks(String workflowDefId);

	TaskDef getTask(String workflowDefId, String taskId);

	List<TaskDef> getNextTasks(String workflowDefId, String taskId);
	
}