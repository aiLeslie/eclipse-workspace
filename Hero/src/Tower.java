
public class Tower implements Assailable {
	private String name;
	private int hp;
	private int x;
	private int y;
	private final int attack = 10;
	private final int distance = 20;
	

	public Tower() {
		this.name = "Tower";
		this.hp = 60;
	}
	
	public Tower(String name,int x,int y) {
		this();
		this.name = name;
		setX(x);
		setY(y);
	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public String getName() {
		
		return name;
	}

	@Override
	public void setX(int x) {
		this.x = x;

	}

	@Override
	public int getX() {
		
		return x;
	}

	@Override
	public void setY(int y) {
		this.y = y;

	}

	@Override
	public int getY() {
		
		return y;
	}

	@Override
	public int getHp() {
		
		return hp;
	}

	@Override
	public void setHp(int hp) {
		this.hp = hp;

	}

	@Override
	public boolean canFightByDistance(Assailable assa) {
		if(Math.sqrt(Math.pow(x - this.getX(),2) + Math.pow(y - this.getY(),2)) > distance)
		return false;
		
		else return true;
	}

	@Override
	public void fight(Assailable assa) {
		assa.setHp(assa.getHp() - attack);

	}
	@Override
	public  void pk(Assailable assa) {
		if(canFightByDistance(assa) && assa.getHp() > 0 && hp > 0 ) {
			fight(assa);
			System.out.println(this.name + "向" + assa.getName() + "进行猛烈的攻击");
			
		}
		else System.out.println(this.name + "正在锁定" + assa.getName() + "为目标,现在暂时无法攻击");
		printState(assa);
	}
	
	
	public void printState(Assailable assa) {System.out.println("-----------------------");
	System.out.printf("%-8s%-5s%s   %s\n","name","hp","x坐标","y坐标");
	System.out.printf("%-7s\t%-5d%-6d%-6d\n",getName(),getHp(),getX(),getY());
	//System.out.println(getName().length());
	System.out.printf("%-7s\t%-5d%-6d%-6d\n",assa.getName(),assa.getHp(),assa.getX(),assa.getY());
	//System.out.println(assa.getName().length());
	System.out.println("-----------------------");
	System.out.println();
	}
}
