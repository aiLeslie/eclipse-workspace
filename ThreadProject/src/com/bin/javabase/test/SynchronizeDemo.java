package com.bin.javabase.test;

public class SynchronizeDemo {

	public static void main(String[] args) {
		System.out.println("多线程模拟取钱");
		Bank bank = new Bank();
		new BankThread(bank).start();
		new BankThread(bank).start();

	}

}

class Bank {
	private int money = 500;
	/**
	 * 取钱方法
	 * 
	 * @return 取钱数目
	 */

	synchronized public String getMoney(int number) {
		synchronized (this/**object*/) {//要的对象的锁才能进进来运行代码块,可以锁任何对象

			if (number < 0) {
				return Thread.currentThread().getName() + "你来错啦,这是取款器";
			} else if (number > money) {
				return Thread.currentThread().getName() + "的金额小于" + number + ",取钱失败(当前账户余额" + this.money + ")";
			} else if (money <= 0) {
				return Thread.currentThread().getName() + "的金额小于" + 0 + "(当前账户余额" + this.money + ")";
			} else {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}

				money -= number;
				System.out.println(Thread.currentThread().getName() + "成功取钱" + number);
				return this.money + "";
			}
		}
	}
}

class BankThread extends Thread {
	private Bank bank;

	@Override
	public void run() {
		System.out.println("账户余额为" + bank.getMoney(400));
	}

	public BankThread(Bank bank) {
		this.bank = bank;
	}
}
