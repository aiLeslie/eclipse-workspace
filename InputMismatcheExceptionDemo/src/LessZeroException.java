
public class LessZeroException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LessZeroException() {
		//super("输入数字不能小于零!");
		
	}
	
	public  LessZeroException( int value) {
		super("输入数字为" + value + " ,数字不能小于零");
	}

}
