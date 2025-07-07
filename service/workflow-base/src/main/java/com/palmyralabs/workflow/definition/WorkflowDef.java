package com.palmyralabs.workflow.definition;

import java.util.List;
import java.util.Set;

public interface WorkflowDef {
	
	String getId();
	
	String getName();
	
	String getVersion();
	
	Set<TaskDef> getAllTasks();
	
	TaskDef getTask(String taskId);
	
	List<TaskDef> getNextTasks(String taskId);
	
}
