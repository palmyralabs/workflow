package com.palmyralabs.workflow.definition.annotation.base;

import com.palmyralabs.workflow.definition.WorkflowStatus;
import com.palmyralabs.workflow.definition.annotation.WorkflowDefinition;

public abstract class AbstractWorkflowDefinition implements WorkflowDefinition{

	@Override
	public String getId() {
		return getName() + "_" + getVersion();
	}

	@Override
	public String getVersion() {
		return "v1";
	}

	@Override
	public WorkflowStatus getStatus() {
		return WorkflowStatus.ACTIVE;
	}

}
