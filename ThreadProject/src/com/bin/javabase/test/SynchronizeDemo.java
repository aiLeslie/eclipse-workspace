package com.bin.javabase.test;

public class SynchronizeDemo {

	public static void main(String[] args) {
		System.out.println("���߳�ģ��ȡǮ");
		Bank bank = new Bank();
		new BankThread(bank).start();
		new BankThread(bank).start();

	}

}

class Bank {
	private int money = 500;
	/**
	 * ȡǮ����
	 * 
	 * @return ȡǮ��Ŀ
	 */

	synchronized public String getMoney(int number) {
		synchronized (this/**object*/) {//Ҫ�Ķ���������ܽ��������д����,�������κζ���

			if (number < 0) {
				return Thread.currentThread().getName() + "��������,����ȡ����";
			} else if (number > money) {
				return Thread.currentThread().getName() + "�Ľ��С��" + number + ",ȡǮʧ��(��ǰ�˻����" + this.money + ")";
			} else if (money <= 0) {
				return Thread.currentThread().getName() + "�Ľ��С��" + 0 + "(��ǰ�˻����" + this.money + ")";
			} else {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}

				money -= number;
				System.out.println(Thread.currentThread().getName() + "�ɹ�ȡǮ" + number);
				return this.money + "";
			}
		}
	}
}

class BankThread extends Thread {
	private Bank bank;

	@Override
	public void run() {
		System.out.println("�˻����Ϊ" + bank.getMoney(400));
	}

	public BankThread(Bank bank) {
		this.bank = bank;
	}
}
