package com.bin.javabase.observer;

public interface ISubject {
	int getState();

	void setState(int state);

	void attach(Observer observer);

	void notifyAllObservers();
}
