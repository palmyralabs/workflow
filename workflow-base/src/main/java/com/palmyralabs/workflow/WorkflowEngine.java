package com.palmyralabs.workflow;

public interface WorkflowEngine {
	/**
	 * 
	 * @param workflowName
	 * @param version
	 * @param initialData
	 * @return workflowId
	 */
	String execute(String workflowName, String version, Object initialData);

	/**
	 * 
	 * @param workflowName
	 * @param initialData
	 * @return workflowId
	 */
	String execute(String workflowName, Object initialData);

	/**
	 * Initialize the workflow engine
	 */
	void initialize();

	/**
	 * Shutdown the engine, gracefully shutting down the tasks and stops 
	 * the thread-pool.
	 */
	void shutDown();

	/**
	 * Pause the workflow by the given workflow Id
	 * @param workflowId
	 */
	void pause(String workflowId);

	/**
	 * resume the workflow by the given workflow Id;
	 * @param workflowId
	 */
	void resume(String workflowId);
}
