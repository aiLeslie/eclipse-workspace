package com.leslie.javabse;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MyConsole {
	public static void clear() {

		try {
			Robot r = new Robot();
			r.mousePress(InputEvent.BUTTON3_MASK); // ��������Ҽ�
			r.mouseRelease(InputEvent.BUTTON3_MASK); // �ͷ�����Ҽ�
			r.keyPress(KeyEvent.VK_ALT); // ����Ctrl��
			r.keyPress(KeyEvent.VK_TAB); // ����R��
			r.keyRelease(KeyEvent.VK_TAB); // �ͷ�R��
			r.keyRelease(KeyEvent.VK_ALT); // �ͷ�Ctrl��
			r.delay(100);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		System.out.println("���������Ұ�!");
		clear();
		System.out.println("clear");
	}
}
