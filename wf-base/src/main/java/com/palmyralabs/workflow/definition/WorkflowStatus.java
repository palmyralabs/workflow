package com.palmyralabs.workflow.definition;

public enum WorkflowStatus {
	
	ACTIVE("AC"), DISABLED("DS"), DISCONTINUED("DC");

	private final String code;

	private WorkflowStatus(String code) {
		this.code = code;
	}

	public final String getCode() {
		return code;
	}

	public final WorkflowStatus getByCode(String code) {
		for (WorkflowStatus w : values()) {
			if (w.code.contentEquals(code)) {
				return w;
			}
		}
		return null;
	}
}
