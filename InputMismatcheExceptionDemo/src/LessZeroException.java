
public class LessZeroException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LessZeroException() {
		//super("�������ֲ���С����!");
		
	}
	
	public  LessZeroException( int value) {
		super("��������Ϊ" + value + " ,���ֲ���С����");
	}

}
