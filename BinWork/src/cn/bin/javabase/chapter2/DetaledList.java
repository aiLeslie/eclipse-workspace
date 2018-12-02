package cn.bin.javabase.chapter2;

public class DetaledList {

	public DetaledList() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[]args) {
		System.out.println("吃货账单");
		System.out.println("-------------------------------");
		System.out.printf("%-10s\t%-4s\t%-2s\t%-20s\n","商品名称","单价","数量","备注");
		System.out.printf("%-10s\t%-4s\t%-2s\t%-20s\n","德芙巧克力","30.9","10","丝滑牛奶252g新旧包装随机发货装");
		System.out.printf("%-10s\t%-4s\t%-2s\t%-20s\n","素食辣条","9.9","20","无辣不欢,约就现在");
		System.out.printf("%-10s\t%-4s\t%-2s\t%-20s\n","原味海苔","32.2","15","网络爆款,先脆口感");
	}
	
	

}
