package com.bin.javabase.factory;

import com.bin.javabase.factory.shapes.Circle;
import com.bin.javabase.factory.shapes.Rectangle;
import com.bin.javabase.factory.shapes.Shape;
import com.bin.javabase.factory.shapes.Square;

/**
 * ����ģʽ��Factory Pattern���� Java ����õ����ģʽ֮һ���������͵����ģʽ���ڴ�����ģʽ�����ṩ��һ�ִ����������ѷ�ʽ��
 * �ڹ���ģʽ�У������ڴ�������ʱ����Կͻ��˱�¶�����߼���������ͨ��ʹ��һ����ͬ�Ľӿ���ָ���´����Ķ���
 * 
 * ��Ŀ���ƣ�DesignMode �����ƣ�ShapeFactory �������� �����ˣ������ ����ʱ�䣺2018��7��25�� ����3:20:15
 * 
 * @version 1.0
 */
public class ShapeFactory {
	public final String CIRCLE_SHAPE = "CIRCLE";
	public final String RECTANGLE_SHAPE = "RECTANGLE";
	public final String SQUARE_SHAPE = "SQUARE";

	// ʹ�� getShape ������ȡ��״���͵Ķ���
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		return null;
	}
}
