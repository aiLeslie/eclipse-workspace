package com.leslie.javabase;
/**
 * 
* 项目名称：GCProject   
* 类名称：Node   
* 类描述：节点
* 创建人：李玮斌   
* 创建时间：2018年7月7日 下午10:55:02   
* @version 1.0
 */
public class Node {
	public String name;
	public Node next;
	public Node(String name) {
		super();
		this.name = name;
	}
	/**
	 * 对象在堆内存中状态:
	 * 
	 * 可达状态
	 * 恢复状态
	 * 不可达状态
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// 有一条路径到达第一个节点 因此对象处于可达状态 垃圾回收机制不会回收它
		Node n1 = new Node("第一个节点"); 
		
		// 有两条路径到达第二个节点 因此对象处于可达状态 垃圾回收机制不会回收它
		Node n2 = new Node("第二个节点");
		
		// 没有路径到达第三个节点 因此对象成为垃圾 垃圾回收机制将会回收它
		@SuppressWarnings("unused")
		Node n3 = new Node("第三个节点");
		
		n1.next = n2;
		n3 = n2;
		n2 = null;
		
		
		/**
		 * 第一个节点: 有一条路径到达第一个节点 因此对象处于可达状态 垃圾回收机制不会回收它 (n1引用)
		 * 第二个节点:有两条路径到达第二个节点 因此对象处于可达状态 垃圾回收机制不会回收它 (n1.next和 n3 引用)
		 * 第三个节点: 没有路径到达第三个节点 因此对象成为垃圾 垃圾回收机制将会回收它 (没有引用)
		 */
	}
	
}
