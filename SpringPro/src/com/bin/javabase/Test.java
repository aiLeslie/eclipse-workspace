package com.bin.javabase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test<T> {
	private ClassPathXmlApplicationContext context;
	private String path = "ApplicationContext.xml";
	private T t;

	public Test() {
		context = new ClassPathXmlApplicationContext(path);
	}

	public Test(String path) {
		setPath(path);
	}

	public void setPath(String path) {
		if (path != null && path.length() > 0) {
			this.path = path;
		}
		context = new ClassPathXmlApplicationContext(path);
	}

	
	@SuppressWarnings("unchecked")
	public T getInstance(String id) {
		if (context == null) {
			throw new RuntimeException("Context is invalidate!");
		}
		try {
			t = (T) context.getBean(id);
			return t;
		} catch (ClassCastException e) {
			return null;
		}

	}
}
