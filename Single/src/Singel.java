/**
 * 对象单例化
 * @author Administrator
 *使用静态实行单例模式,只能获得某个类一个实例
 */
public class Singel {
	private static Singel me = null ;//类静态属性
	
	private Singel() {//将构造方法访问属性为私有的,只有在类中才能调用
		me = this ;//把对象的地址赋给me
	}
	
	public static Singel getInstance() {
		if(me != null )me = new Singel();//如果me指向为空(null),就进行实例化
		
		return me;
	}
}
