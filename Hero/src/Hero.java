
/**
 * 英雄类 (抽象类)
 * @author Administrator
 *
 */
public abstract class Hero implements Assailable {
	private long id;
	private String name;
	private int level;
	private int maxHp;
	private int hp;
	private int attack;
	private int x;
	private int y;
	
	
	public Hero(){
		this.setName("默认英雄");
		this.id = 00000;
		this.setHp(100);
		this.setMaxHp(200);
	}
	
	public Hero(long id, String name) {
		this();
		setId(id);
		setName(name);
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getMaxHp() {
		return maxHp;
	}
	
	public void setMaxHp(int maxHp) {
		if(maxHp <0 || maxHp >100)maxHp = 0;//如果传入的HP不在0~100之间置为一
		
		this.maxHp = maxHp;
	}
	@Override
	public int getHp() {
		return hp;
	}
	@Override
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	@Override
	public int getX() {
		return x;
	}
	@Override
	public void setX(int x) {
		this.x = x;
	}
	@Override
	public int getY() {
		return y;
	}
	@Override
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * 判断当前英雄是否能够攻击传入的英雄对象
	 * @return
	 */
	public abstract boolean canFightByDistance(Assailable hero);

	
	/**
	 * 与攻击的英雄对象,默认随机生成攻击力
	 */
	public abstract void fight(Assailable hero);

	
	/**
	 * 计算距离能否攻击传入的英雄
	 * 如果可以攻击就调用fight();
	 * 打印结果两英雄状态
	 */
	public void pk(Assailable hero) {
		if(canFightByDistance(hero) && hp > 0 && hero.getHp() > 0)
			fight(hero);
		
		printState(hero);
		
	}
	/**
	 * 传入两英雄的坐标计算两英雄的距离
	 * 返回距离值
	 */
	public double getDistance(int x,int y/*int x1,int y1,int x2,int y2*/)
	{
		return Math.sqrt(Math.pow(x - this.getX(),2/*x1 - x2,2*/) + Math.pow(y - this.getY(),2/*y1 - y2,2*/));
	}
	
	public void printState(Assailable assa) {System.out.println("-----------------------");
	System.out.printf("%-8s%-5s%s   %s\n","name","hp","x坐标","y坐标");
	System.out.printf("%-8s\t%-5d%-6d%-6d\n",getName(),getHp(),getX(),getY());
	System.out.printf("%-8s\t%-5d%-6d%-6d\n",assa.getName(),assa.getHp(),assa.getX(),assa.getY());
	System.out.println("-----------------------");
	System.out.println();
	}
				
}
