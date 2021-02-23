package core;

public class Pokemon {
	public int id;
	public static int counter=0;
	public final String surname;
	public float size;
	public int level=1;
	public Specie specie;
	public int xp=0;
	public int hp;
	public int strength;

	public Pokemon(String surname, float size, int level, Specie specie) {
		this.id = counter;
		counter++;
		this.surname = surname;
		this.size = size;
		if(level<=0 || level>5){
			System.out.println("Niveau incorrect pour "+surname);
		}else{
			this.level = level;
		}
		this.specie = specie;
		this.hp=specie.initialHp;
		this.strength=specie.initialStrength;
	}

	public static int getLevelFromXp(int xp) {
		int res=1;
		if(xp>=5) {
			res = 2;
		}
		if(xp>=15) {
			res = 3;
		}
		if(xp>=30) {
			res = 4;
		}
		if(xp>=100) {
			res = 5;
		}
		return res;
	}

	public void attack(Pokemon target) {
		target.hp-=strength;
	}

	public void receiveXP(int toto){
		xp+=toto;
		level = getLevelFromXp(xp);
	}

	public void eatSweet(Sweet s){
		if(s.alreadyEaten){
			System.out.println("Avertissement : bonbon déjà mangé");
		}else{
			receiveXP(s.xp);
			s.alreadyEaten=true;
		}
	}

	public Pokemon(String surname, float size, int level, Specie specie, int xp) {
		this(surname,size,level,specie);
		this.xp=xp;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", surname=" + surname + ", size=" + size + ", level=" + level + ", specie="
				+ specie + ", xp=" + xp + ", hp=" + hp + ", strength=" + strength + "]";
	}






}
