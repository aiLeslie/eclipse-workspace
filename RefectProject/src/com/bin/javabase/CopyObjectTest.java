package com.bin.javabase;

import java.lang.reflect.Field;

public class CopyObjectTest {
	public static void main(String[] args) {
		
		try {
			People ectype = (People) CopyObjectTest.copyObject(new People(517183,"�����",20));
			
			//ectype = (People) CopyObjectTest.copyObject(null);
			System.out.println("���ƶ���ɹ�");
			System.out.println("id:" + ectype.getId());
			System.out.println("name:" + ectype.getName());
			System.out.println("age:" + ectype.getAge());
			System.out.println(ectype.toString());
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.err.println("���ƶ���ʧ��");
		}
	}
	
	public static Object copyObject(Object obj) throws Exception{
		if(!(obj instanceof Object)) {
			throw new IllegalArgumentException();
		}
		//ͨ��Class�����new Instance()����Ŀ�����
		Class<?> classType = obj.getClass();
		@SuppressWarnings("deprecation")
		Object ectype = classType.newInstance();
		//��ȡClass�����get��set����
		for(Field field: classType.getDeclaredFields()) {
			//��һ�ַ���
//			String getMethodName = "get" + field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
//			String setMethodName = "set" + field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
//			//����Դ�����get������ȡ����ֵ
//			Method getMethod = classType.getDeclaredMethod(getMethodName, new Class[] {});
//			Object value = getMethod.invoke(obj, new Object[]{});
//			//����Ŀ���set������ȡ����ֵ
//			Method setMethod = classType.getDeclaredMethod(setMethodName,new Class[]{field.getType()});
//			setMethod.invoke(ectype,new Object[] {value});
			//�ڶ��ַ���
			field.setAccessible(true);
			field.set(ectype, field.get(obj)); 
		}
		return ectype;
	}

}
