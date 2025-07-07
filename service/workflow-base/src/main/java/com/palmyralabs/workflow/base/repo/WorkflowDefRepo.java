package com.palmyralabs.workflow.base.repo;

import com.palmyralabs.workflow.definition.WorkflowDef;

public interface WorkflowDefRepo {
	WorkflowDef getDefinition(String workflowName, String version);

	WorkflowDef getDefinition(String workflowId);
}
