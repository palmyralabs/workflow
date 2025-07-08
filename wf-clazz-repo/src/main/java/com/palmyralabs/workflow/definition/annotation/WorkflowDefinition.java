package com.palmyralabs.workflow.definition.annotation;

import java.util.Set;

import com.palmyralabs.workflow.definition.TaskDef;
import com.palmyralabs.workflow.definition.WorkflowDef;

public interface WorkflowDefinition extends WorkflowDef{
	Set<TaskDef> getAllTasks();
}
