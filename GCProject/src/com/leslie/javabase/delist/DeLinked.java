package com.leslie.javabase.delist;

public class DeLinked<E> {
	private Element<E> first;
	private Element<E> last;

	public DeLinked() {
		super();

	}

	public boolean isEmpty() {
		if (first == null || last == null) {
			return true;
		} else {
			return false;
		}
	}

	public void insertFirst(E e) {
		Element<E> node = new Element<>(e);
		if (isEmpty()) {
			last = node;
		} else {
			node.next = first;
		}

		first = node;
	}

	public void insertLast(E e) {
		Element<E> node = new Element<>(e);
		if (isEmpty()) {
			first = node;
		} else {
			last.next = node;

		}
		last = node;
	}

	public String firstToString() {

		return foreEach(first);

	}

	public String lastToString() {

		return foreEach(last);

	}

	private String foreEach(Element<E> e) {
		StringBuilder builder = new StringBuilder();
		while (e != null) {

			builder.append(e.data);
			builder.append(" -> ");
			e = e.next;
		}
		builder.append("null");
		builder.append("\n");
		return builder.toString();
	}
	
	@Override
	public String toString() {
		return firstToString() + lastToString();
	}

	public static void main(String[] args) {
		DeLinked<Long> deLinked = new DeLinked<>();
//		deLinked.insertFirst(2L);
//		System.out.println(deLinked.toString());
//
//		deLinked.insertFirst(1L);
//		System.out.println(deLinked.toString());

		deLinked.insertLast(3L);
		System.out.println(deLinked.toString());
		
		deLinked.insertLast(5L);
		System.out.println(deLinked.toString());

		deLinked.insertLast(4L);
		System.out.println(deLinked.toString());

	}

}
