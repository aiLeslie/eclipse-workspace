
public class Warrior extends Hero {
	protected final int distance = 100;  
	public Warrior(){
		super();
		}
	
	public  Warrior(long id,String name,int x,int y) {
		super(id,name);
		setX(x);
		setY(y);
		
	}
	
	@Override
	public boolean canFightByDistance(Assailable hero) {
		if(getDistance(/*getX(),getY(),*/hero.getX(),hero.getY() ) <= distance 
		&&  this.getHp() > 0 && hero.getHp() > 0) {System.out.println("����һ��Ư������~~");
		return true;
		}
		if(getDistance(/*getX(),getY(),*/hero.getX(),hero.getY() ) > distance )System.out.println("Ŀ���ɫ������Ĺ�����Χ,����ʧ��");
		return false;
	}

	@Override
	public void fight(Assailable hero) {
		int attack;
		attack = (int)(Math.random()*10000) % 10;
		this.setAttack(attack);
		hero.setHp(hero.getHp() - attack);
		
	}
	
	
}



