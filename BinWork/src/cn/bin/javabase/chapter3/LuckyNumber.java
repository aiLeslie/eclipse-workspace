package cn.bin.javabase.chapter3;
/**
 * 
* 项目名称：BinWork   
* 类名称：LuckyNumber   
* 类描述：
* 创建人：李玮斌   
* 创建时间：2017年10月15日 下午3:30:07   
* @version 1.0
* 在任意一个四位整数中，如果该数的个位数
* 和百位数之和大于16，并且十位数和千位数
* 之和小于3，就称这种数为“老九幸运数“，
* 请小伙伴编程计算出在1000~9999中，一共
* 有多少个满足老九幸运数的四位整数呢，打
* 印出最终的个数！
 */
public class LuckyNumber {

	
	public static void main (String []args) {
		int count = 0;
		System.out.println("幸运数列表如下");

		for(int i = 1000; i < 10000;i++) 
		{
			if (i % 10 + i / 100 % 10 > 16 && i / 10 % 10 + i / 1000 % 10 < 3) {
				count++;
				if((count - 1) % 3 == 0)System.out.println();
				System.out.print(i + "\t");
				
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println("一共有" + count + "个幸运数");
	}
}
