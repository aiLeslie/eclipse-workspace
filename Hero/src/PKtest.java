
public class PKtest {
	public static void main(String []args) {
		Hero hero1 = new Warrior(1314,"����",0,0);
		Hero hero2 = new Warrior(1314,"����",50,50);
		Tower tower = new Tower("Dota",0,0);
		hero1.pk(hero2);
		tower.pk(hero2);
	}
}
