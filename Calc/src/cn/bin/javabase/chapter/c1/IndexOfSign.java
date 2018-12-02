package cn.bin.javabase.chapter.c1;

import java.util.Scanner;

public class IndexOfSign {
	public static IndexOfSign end = null;// 当前IndexOfSign对象
	public static IndexOfSign head = null;// 链表IndexOfSign头对象

	public char sign;// 符号
	public int index;// 下标
	public IndexOfSign next;// 下一个IndexOfSign对象
	public IndexOfSign previous;// 前一个IndexOfSign对象

	public static void main(String[] args) throws Exception {
		String result = null;// 接受用户的输入
		System.out.print("请输入你的算式:");
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			result = scanner.next();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (scanner != null)scanner.close();
		}
		double total = Double.MIN_VALUE;// 结果为浮点型最小值

		IndexOfSign.findSign(result);// 创建 IndexOfSign对象链表
		/**
		 * 借接受用户的输入字符串类型创建带缓存字符串对象 方便后面截取字符串
		 */
		StringBuffer calc = new StringBuffer(result);

		// 遍历IndexOfSign对象链表
		IndexOfSign temp = head;
		/***
		 * 
		 */
		while (temp != null) {
			System.out.println("符号下标:" + temp.index + "\t符号:" + temp.sign);
			temp = temp.next;
		}

		temp = head;

		/**
		 * 遍历IndexOfSign对象链表 开始计算结果
		 */
		String number1 = null, number2 = null, textNumber = null;

		while (temp != null) {
			if (temp.sign == '*')// 如果链表IndexOfSign对象符号为乘法
			{
				if (temp.previous == null) {
					number1 = calc.substring(0, temp.index);
				} else {
					number1 = calc.substring(temp.previous.index + 1, temp.index);
				}

				if (temp.next == null) {
					number2 = calc.substring(temp.index + 1, calc.length());
				} else {
					number2 = calc.substring(temp.index + 1, temp.next.index);
				}

				textNumber = Double.parseDouble(number1) * Double.parseDouble(number2) + "";

				if (temp.previous != null && temp.next != null) {
					calc.replace(temp.previous.index + 1, temp.next.index, textNumber);
				} else if (temp.previous == null && temp.next != null) {
					calc.replace(0, temp.next.index, textNumber);
				} else if (temp.previous != null && temp.next == null) {
					calc.replace(temp.previous.index + 1, calc.length(), textNumber);
				} else if (temp.previous == null && temp.next == null) {
					calc.replace(0, calc.length(), textNumber);
				}
				head = null;
				end = null;
				IndexOfSign.findSign(calc.toString());

				temp = head;
				continue;
			}

			if (temp.sign == '/') {
				if (temp.previous == null) {
					number1 = calc.substring(0, temp.index);
				} else {
					number1 = calc.substring(temp.previous.index + 1, temp.index);
				}

				if (temp.next == null) {
					number2 = calc.substring(temp.index + 1, calc.length());
				} else {
					number2 = calc.substring(temp.index + 1, temp.next.index);
				}

				textNumber = Double.parseDouble(number1) / Double.parseDouble(number2) + "";

				if (temp.previous != null && temp.next != null) {
					calc.replace(temp.previous.index + 1, temp.next.index, textNumber);
				} else if (temp.previous == null && temp.next != null) {
					calc.replace(0, temp.next.index, textNumber);
				} else if (temp.previous != null && temp.next == null) {
					calc.replace(temp.previous.index + 1, calc.length(), textNumber);
				} else if (temp.previous == null && temp.next == null) {
					calc.replace(0, calc.length(), textNumber);
				}
				head = null;
				end = null;
				IndexOfSign.findSign(calc.toString());

				temp = head;
				continue;
			}

			temp = temp.next;
		}

		Minus.findMinusNumber(calc);
		if (Minus.minusHead != null) {
			total = 0;
			Minus minus = Minus.minusHead;
			/***
			 * 
			 */
			while (minus != null) {
				System.out.println("符号:" + minus.sign + "\t数值:" + minus.number);
				minus = minus.next;
			}

			minus = Minus.minusHead;

			/**
			 * 
			 */
			while (minus != null) {
				if (minus.sign == '+')
					total += minus.number;
				else if (minus.sign == '-')
					total -= minus.number;
				minus = minus.next;
			}
		}

		else
			total = Double.parseDouble(calc.toString());
		System.out.println("result = " + total);

	}

	public static void findSign(String result) {
		head = null;
		end = null;

		for (int i = 0; i < result.length(); i++) {
			if (result.charAt(i) == '+') {
				if (head == null) {
					head = new IndexOfSign();
					end = head;
					end.index = i;
					end.sign = '+';

				} else {

					end.next = new IndexOfSign();
					end.next.previous = end;
					end.next.index = i;
					end.next.sign = '+';
					end = end.next;

				}

			}

			if (result.charAt(i) == '-') {
				if (head == null) {
					head = new IndexOfSign();
					end = head;
					end.index = i;
					end.sign = '-';

				} else {

					end.next = new IndexOfSign();
					end.next.previous = end;
					end.next.index = i;
					end.next.sign = '-';
					end = end.next;

				}

			}

			if (result.charAt(i) == '*') {
				if (head == null) {
					head = new IndexOfSign();
					end = head;
					end.index = i;
					end.sign = '*';

				} else {

					end.next = new IndexOfSign();
					end.next.previous = end;
					end.next.index = i;
					end.next.sign = '*';
					end = end.next;

				}

			}

			if (result.charAt(i) == '/') {
				if (head == null) {
					head = new IndexOfSign();
					end = head;
					end.index = i;
					end.sign = '/';

				} else {

					end.next = new IndexOfSign();
					end.next.previous = end;
					end.next.index = i;
					end.next.sign = '/';
					end = end.next;

				}

			}
		}
	}

}
