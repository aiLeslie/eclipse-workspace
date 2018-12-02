package com.leslie.javabase;



public class Test {	
	// run config: -verbose:class -verbose:gc
	// jps命令:  查看正在运行java进程
	// jcmd命令: 运行java命令
	public static void main(String[] args) {
		// 查看类加载实例代码
		System.out.println("HelloWorld!");
		
		// 核心类库加载器(c/c++实现,所以不是Java类型所以为null)
		System.out.println(Object.class.getClassLoader()); // Bootstrap加载器 
		
		// 用户程序类加载器
		System.out.println(Test.class.getClassLoader().getParent());
	}
	
	public void printMsg(String msg) {
		System.out.println("第二次修改");
		System.out.println(msg);
	}
}
