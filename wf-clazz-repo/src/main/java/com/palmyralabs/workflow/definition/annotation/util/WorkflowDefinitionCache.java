package com.palmyralabs.workflow.definition.annotation.util;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.palmyralabs.workflow.definition.annotation.WorkflowDefinition;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WorkflowDefinitionCache {
	private final Map<String, WorkflowDefinition> cache = new HashMap<String, WorkflowDefinition>();

	public WorkflowDefinition getWorkflow(String workflowName, String version) {
		return cache.get(workflowName + "_" + version);
	}
	
	public WorkflowDefinition getWorkflow(String workflowId) {
		return cache.get(workflowId);
	}

	public void init(String packageName) {
		try {
			Class<?>[] classes = ClassUtil.getClasses(packageName);

			for (Class<?> clazz : classes) {
				Constructor<?>[] cons = clazz.getDeclaredConstructors();
				if (cons.length > 0) {
					try {
						WorkflowDefinition obj = (WorkflowDefinition)cons[0].newInstance();
						cache.put(obj.getId(), obj);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						log.error("Error while invoking constructor", e);
					}
				}
			}

		} catch (IOException e) {
			log.error("Error while loading the package " + packageName, e);
		}
	}
}
