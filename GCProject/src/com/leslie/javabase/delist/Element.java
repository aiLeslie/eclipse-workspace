package com.leslie.javabase.delist;

public class Element<E> {
	public E data;
	public Element<E> next;
	
	public Element(E e) {
		data = e;
	}
	
}
