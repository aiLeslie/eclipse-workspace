package com.leslie.chunwan;
import java.io.IOException;
import java.util.Properties;

public class ChunWanTest {
	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Director director = new Director();//���ݶ���ʵ����
		Singer singer = new Singer("leslie");//�質��Ա����ʵ����
		Dancer dancer = new Dancer("��Խ����");//�赸��Ա����ʵ����
		AcrossActor acrossActor = new AcrossActor("�빮");
		
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

