package com.leslie.chunwan;
import java.io.IOException;
import java.util.Properties;

public class ChunWanTest {
	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Director director = new Director();//导演对象实例化
		Singer singer = new Singer("leslie");//歌唱演员对象实例化
		Dancer dancer = new Dancer("村越理奇");//舞蹈演员对象实例化
		AcrossActor acrossActor = new AcrossActor("冯巩");
		
		director.action(singer);
		System.out.println();
		
		director.action(dancer);
		System.out.println();
		
		director.action(acrossActor);
		System.out.println();
		
		
		
		Properties props = new Properties();
		
		props.load(ChunWanTest.class.getResourceAsStream("Actor.config.properties"));
		
		Actor actor = (Actor)Class.forName(props.getProperty("acrossactor")).newInstance();
		
		director.action(actor);
		
		
	}
	
	
	
}

