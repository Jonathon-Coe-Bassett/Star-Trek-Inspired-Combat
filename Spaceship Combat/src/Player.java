
public class Player
	{
		private String name;
		private int health;
		private Weapon weapon;
		private boolean gender;
		private Ship ship;
		public Player(String n, int h, Weapon w, boolean g, Ship s)
		{
			name=n;
			health=h;
			weapon=w;
			gender=g;
			ship=s;
		}
		public String getName()
			{
				return name;
			}
		public void setName(String name)
			{
				this.name = name;
			}
		public int getHealth()
			{
				return health;
			}
		public void setHealth(int health)
			{
				this.health = health;
			}
		public Weapon getWeapon()
			{
				return weapon;
			}
		public void setWeapon(Weapon weapon)
			{
				this.weapon = weapon;
			}
		public boolean isGender()
			{
				return gender;
			}
		public void setGender(boolean gender)
			{
				this.gender = gender;
			}
		public Ship getShip()
			{
				return ship;
			}
		public void setShip(Ship ship)
			{
				this.ship = ship;
			}
		
	}
