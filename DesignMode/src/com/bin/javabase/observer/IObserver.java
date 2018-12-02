package com.bin.javabase.observer;

public abstract class IObserver {
	protected Subject subject;

	public abstract void update();

}
