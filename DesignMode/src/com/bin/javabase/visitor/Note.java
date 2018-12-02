package com.bin.javabase.visitor;

public class Note implements IAcceptor{

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
	
	
	public String read() {
		return "My name is Note!";
	}


}
