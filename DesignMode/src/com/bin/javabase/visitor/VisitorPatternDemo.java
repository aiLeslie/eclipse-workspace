package com.bin.javabase.visitor;

public class VisitorPatternDemo {
	public static void main(String[] args) {
		new Composite()
			.addComponent(new Note())
			.accept(new NoteVisitor());
	}
}
