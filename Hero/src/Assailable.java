/**
 * 可攻击接口 - 只要实现本接口,就相当于具备了可实施攻击对象
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
	 * 根据距离判断,是否攻击另一个具备攻击能力对象
	 * @param assa
	 * @return
	 */
	public abstract boolean canFightByDistance(Assailable assa);
	
	
	/**
	 * 攻击另一个具备攻击能力对象
	 * @param assa
	 */
	public abstract void fight(Assailable assa);
	
	public abstract void pk(Assailable assa);

}
