package com.palmyralabs.workflow.definition.annotation.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import com.palmyralabs.workflow.definition.annotation.WorkflowDefinition;

public class ClassUtil {

	public static Class<?>[] getClasses(String packageName) throws IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		assert classLoader != null;
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList<File>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}

		ArrayList<Class<?>> classes = new ArrayList<Class<?>>();

		for (File directory : dirs) {
			findClasses(directory, packageName, classes);
		}
		return classes.toArray(new Class[classes.size()]);
	}

	private static void findClasses(File directory, String packageName, List<Class<?>> result) {
		if (!directory.exists()) {
			return;
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				assert !file.getName().contains(".");
				findClasses(file, packageName + "." + file.getName(), result);
			} else if (file.getName().endsWith(".class")) {
				try {
					Class<?> clazz = Class
							.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6));
					if (WorkflowDefinition.class.isAssignableFrom(clazz)
							&& !(Modifier.isAbstract(clazz.getModifiers()) || clazz.isInterface()))
						result.add(clazz);

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
