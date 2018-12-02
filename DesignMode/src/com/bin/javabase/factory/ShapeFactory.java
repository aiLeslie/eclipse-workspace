package com.bin.javabase.factory;

import com.bin.javabase.factory.shapes.Circle;
import com.bin.javabase.factory.shapes.Rectangle;
import com.bin.javabase.factory.shapes.Shape;
import com.bin.javabase.factory.shapes.Square;

/**
 * 工厂模式（Factory Pattern）是 Java 中最常用的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 * 在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。
 * 
 * 项目名称：DesignMode 类名称：ShapeFactory 类描述： 创建人：李玮斌 创建时间：2018年7月25日 下午3:20:15
 * 
 * @version 1.0
 */
public class ShapeFactory {
	public final String CIRCLE_SHAPE = "CIRCLE";
	public final String RECTANGLE_SHAPE = "RECTANGLE";
	public final String SQUARE_SHAPE = "SQUARE";

	// 使用 getShape 方法获取形状类型的对象
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
