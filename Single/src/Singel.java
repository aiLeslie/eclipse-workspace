/**
 * ��������
 * @author Administrator
 *ʹ�þ�̬ʵ�е���ģʽ,ֻ�ܻ��ĳ����һ��ʵ��
 */
public class Singel {
	private static Singel me = null ;//�ྲ̬����
	
	private Singel() {//�����췽����������Ϊ˽�е�,ֻ�������в��ܵ���
		me = this ;//�Ѷ���ĵ�ַ����me
	}
	
	public static Singel getInstance() {
		if(me != null )me = new Singel();//���meָ��Ϊ��(null),�ͽ���ʵ����
		
		return me;
	}
}
