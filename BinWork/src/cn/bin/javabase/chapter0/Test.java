package cn.bin.javabase.chapter0;

import java.util.Timer;
import java.util.TimerTask;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				synchronized (Test.class) {
					System.out.println(Thread.currentThread().getName() + "唤醒");
					Test.class.notifyAll();

				}

			}
		}, 3000);
		synchronized (Test.class) {
			System.out.println(Thread.currentThread().getName() + "线程等待");
			Test.class.wait();
			System.out.println("主线程end");
		}
		
		/**********************************************************************/
		/**
		 * 实验对象的多态属性 子类重写父类的方法后,父类的方法被子类同名方法覆盖 执行都是子类重写的方法
		 */
		/**********************************************************************/
		Son son = new Son();
		son.print();
		((Father) son).print();
		/**********************************************************************/

		/**********************************************************************/
		/**
		 * 连续使用赋值符号
		 */
		/**********************************************************************/

		// int x = 1, y = 2 , z =3;
		// x = y = z;
		// System.out.println("x = " + x);
		// System.out.println("y = " + y);
		// System.out.println("z = " + z);

		/**********************************************************************/
		/**
		 * 使用大数据类型向小数据类型转换
		 */
		/**********************************************************************/
		// System.out.println(Double.MAX_VALUE);
		// System.out.println((float)Double.MAX_VALUE);

		/**********************************************************************/
		/**
		 * 证明线程只能运行一次 如果直接调用run方法,可以运行多次,但是isAlive()只会返回false
		 */
		/**********************************************************************/
		// Thread thread = new Thread() {
		// public void run() {
		// System.out.println(this.isAlive());
		// System.out.println(this.getName());
		//
		// };
		// };
		// System.out.println(thread.isAlive());
		// thread.start();
		//// thread.start();
		//// thread.run();
		//// thread.run();
		// System.out.println(Thread.currentThread().getName());
		/**********************************************************************/

	}
}
