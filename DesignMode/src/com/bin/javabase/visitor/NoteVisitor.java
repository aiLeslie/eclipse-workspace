package com.bin.javabase.visitor;

public class NoteVisitor implements IVisitor{

	@Override
	public void visit(IAcceptor acceptor) {
		
		if(acceptor instanceof Note) {
			
			Note note = (Note)acceptor;
			
			System.out.println(note.toString());
			
			System.out.println(note.read());
			
			System.out.println("我看完笔记");
			
		}
		
	}

}
