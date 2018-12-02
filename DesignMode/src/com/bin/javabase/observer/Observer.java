package com.bin.javabase.observer;

public class Observer extends IObserver {

	public Observer(Subject subject) {
		super.subject = subject;
		super.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("subject update: " + subject.getState());
	}

}
