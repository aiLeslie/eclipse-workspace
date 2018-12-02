package com.bin.javabase.visitor;


import java.util.ArrayList;
import java.util.List;

public  class Composite implements IAcceptor{
	protected List<IAcceptor> components = new ArrayList<>();
	
	public Composite() {}
	
	public Composite(IAcceptor... acceptors) {
		for (IAcceptor acceptor : acceptors) {
			components.add(acceptor);
		}
		
	}

	public Composite addComponent(IAcceptor c) {
		components.add(c);
		return this;
	}

	@Override
	public void accept(IVisitor visitor) {
		
		components.forEach(action -> {
			visitor.visit(action);
		});
	}

	



}
