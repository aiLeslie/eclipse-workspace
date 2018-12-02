package com.leslie.poet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import javax.lang.model.element.Modifier;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

public class Hello {
	private static String path = "src/com/leslie/poet/HelloWorld.java";

	public static void main(String[] args) throws IOException {
		int str = 0 >>> 16;
		System.out.println(str);

		Object obj = new Object();

		System.out.println(hash(obj));

		setOut();

		createHelloWorldSource();
	}

	static void setOut() throws FileNotFoundException {
		File file = new File(path);
		PrintStream out = new PrintStream(file);
		System.setOut(out);
	}

	static void createHelloWorldSource() throws IOException {
		MethodSpec main = MethodSpec.methodBuilder("main").addModifiers(Modifier.PUBLIC, Modifier.STATIC)
				.returns(void.class).addParameter(String[].class, "args")
				.addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!").build();

		TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld").addModifiers(Modifier.PUBLIC, Modifier.FINAL)
				.addMethod(main).build();

		JavaFile javaFile = JavaFile.builder("com.leslie.poet", helloWorld).build();

		javaFile.writeTo(System.out);
	}

	static final int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}
}
