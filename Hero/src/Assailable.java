/**
 * �ɹ����ӿ� - ֻҪʵ�ֱ��ӿ�,���൱�ھ߱��˿�ʵʩ��������
 * @author Administrator
 *
 */
public interface Assailable {
	public abstract void setName(String name);
	public abstract String getName();
	public abstract void setX(int x);
	public abstract int getX();
	public abstract void setY(int y);
	public abstract int getY();
	public abstract int getHp();
	public abstract void setHp(int hp);
	/**
	 * ���ݾ����ж�,�Ƿ񹥻���һ���߱�������������
	 * @param assa
	 * @return
	 */
	public abstract boolean canFightByDistance(Assailable assa);
	
	
	/**
	 * ������һ���߱�������������
	 * @param assa
	 */
	public abstract void fight(Assailable assa);
	
	public abstract void pk(Assailable assa);

}
