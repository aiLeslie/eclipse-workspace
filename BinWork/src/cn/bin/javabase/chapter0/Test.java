package cn.bin.javabase.chapter0;

import java.util.Timer;
import java.util.TimerTask;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				synchronized (Test.class) {
					System.out.println(Thread.currentThread().getName() + "����");
					Test.class.notifyAll();

				}

			}
		}, 3000);
		synchronized (Test.class) {
			System.out.println(Thread.currentThread().getName() + "�̵߳ȴ�");
			Test.class.wait();
			System.out.println("���߳�end");
		}
		
		/**********************************************************************/
		/**
		 * ʵ�����Ķ�̬���� ������д����ķ�����,����ķ���������ͬ���������� ִ�ж���������д�ķ���
		 */
		/**********************************************************************/
		Son son = new Son();
		son.print();
		((Father) son).print();
		/**********************************************************************/

		/**********************************************************************/
		/**
		 * ����ʹ�ø�ֵ����
		 */
		/**********************************************************************/

		// int x = 1, y = 2 , z =3;
		// x = y = z;
		// System.out.println("x = " + x);
		// System.out.println("y = " + y);
		// System.out.println("z = " + z);

		/**********************************************************************/
		/**
		 * ʹ�ô�����������С��������ת��
		 */
		/**********************************************************************/
		// System.out.println(Double.MAX_VALUE);
		// System.out.println((float)Double.MAX_VALUE);

		/**********************************************************************/
		/**
		 * ֤���߳�ֻ������һ�� ���ֱ�ӵ���run����,�������ж��,����isAlive()ֻ�᷵��false
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
