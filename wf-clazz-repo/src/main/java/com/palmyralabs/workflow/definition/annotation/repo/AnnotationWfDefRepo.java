package com.palmyralabs.workflow.definition.annotation.repo;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.palmyralabs.workflow.base.repo.WorkflowDefRepo;
import com.palmyralabs.workflow.definition.TaskDef;
import com.palmyralabs.workflow.definition.WorkflowDef;
import com.palmyralabs.workflow.definition.annotation.WorkflowDefinition;
import com.palmyralabs.workflow.definition.annotation.util.WorkflowDefinitionCache;

public class AnnotationWfDefRepo implements WorkflowDefRepo {

	private final WorkflowDefinitionCache cache;

	public AnnotationWfDefRepo(String packageName) {
		cache = new WorkflowDefinitionCache();
		cache.init(packageName);
	}

	@Override
	public WorkflowDef getDefinition(String workflowName, String version) {
		return cache.getWorkflow(workflowName, version);
	}

	@Override
	public WorkflowDef getDefinition(String workflowDefId) {
		return cache.getWorkflow(workflowDefId);
	}

	@Override
	public Set<TaskDef> getAllTasks(String workflowDefId) {
		WorkflowDefinition wfDef = cache.getWorkflow(workflowDefId);
		if (null != wfDef)
			return wfDef.getAllTasks();
		return null;
	}

	@Override
	public TaskDef getTask(String workflowDefId, String taskId) {
		Collection<TaskDef> taskDefs = getAllTasks(workflowDefId);
		if (null != taskDefs) {
			for (TaskDef taskDef : taskDefs) {
				if (taskDef.getId().contentEquals(taskId)) {
					return taskDef;
				}
			}
		}
		return null;
	}

	@Override
	public List<TaskDef> getNextTasks(String workflowDefId, String taskId) {
		// TODO Auto-generated method stub
		return null;
	}

}
