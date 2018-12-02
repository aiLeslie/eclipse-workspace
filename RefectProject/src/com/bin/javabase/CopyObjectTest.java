package com.bin.javabase;

import java.lang.reflect.Field;

public class CopyObjectTest {
	public static void main(String[] args) {
		
		try {
			People ectype = (People) CopyObjectTest.copyObject(new People(517183,"李玮斌",20));
			
			//ectype = (People) CopyObjectTest.copyObject(null);
			System.out.println("复制对象成功");
			System.out.println("id:" + ectype.getId());
			System.out.println("name:" + ectype.getName());
			System.out.println("age:" + ectype.getAge());
			System.out.println(ectype.toString());
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.err.println("复制对象失败");
		}
	}
	
	public static Object copyObject(Object obj) throws Exception{
		if(!(obj instanceof Object)) {
			throw new IllegalArgumentException();
		}
		//通过Class对象的new Instance()构建目标对象
		Class<?> classType = obj.getClass();
		@SuppressWarnings("deprecation")
		Object ectype = classType.newInstance();
		//获取Class对象的get和set方法
		for(Field field: classType.getDeclaredFields()) {
			//第一种方法
//			String getMethodName = "get" + field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
//			String setMethodName = "set" + field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
//			//调用源对象的get方法获取属性值
//			Method getMethod = classType.getDeclaredMethod(getMethodName, new Class[] {});
//			Object value = getMethod.invoke(obj, new Object[]{});
//			//调用目标的set方法获取属性值
//			Method setMethod = classType.getDeclaredMethod(setMethodName,new Class[]{field.getType()});
//			setMethod.invoke(ectype,new Object[] {value});
			//第二种方法
			field.setAccessible(true);
			field.set(ectype, field.get(obj)); 
		}
		return ectype;
	}

}
