package com.palmyralabs.workflow.definition;

public interface WorkflowDef {
	
	String getId();
	
	String getName();
	
	String getVersion();
	
	WorkflowStatus getStatus();
	
}