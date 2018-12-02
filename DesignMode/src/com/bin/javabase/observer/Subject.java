package com.bin.javabase.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject implements ISubject{
	private List<Observer> observers = new ArrayList<Observer>();
	private int state;
	@Override
	public int getState() {
    return state;
 }
	@Override
	public void setState(int state) {
    this.state = state;
    notifyAllObservers();
 }
	@Override
	public void attach(Observer observer){
    observers.add(observer);      
 }
	@Override
	public void notifyAllObservers(){
    for (Observer observer : observers) {
       observer.update();
    }
 }
}
