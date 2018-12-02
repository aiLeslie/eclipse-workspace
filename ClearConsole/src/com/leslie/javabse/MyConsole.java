package com.leslie.javabse;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MyConsole {
	public static void clear() {

		try {
			Robot r = new Robot();
			r.mousePress(InputEvent.BUTTON3_MASK); // 按下鼠标右键
			r.mouseRelease(InputEvent.BUTTON3_MASK); // 释放鼠标右键
			r.keyPress(KeyEvent.VK_ALT); // 按下Ctrl键
			r.keyPress(KeyEvent.VK_TAB); // 按下R键
			r.keyRelease(KeyEvent.VK_TAB); // 释放R键
			r.keyRelease(KeyEvent.VK_ALT); // 释放Ctrl键
			r.delay(100);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		System.out.println("快来清理我啊!");
		clear();
		System.out.println("clear");
	}
}
