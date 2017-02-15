
public class Ship
	{
		private String name;
		private String description;
		private int attack;
		private int shields;
		private int evade;
		private int accuracy;
		public Ship (String n, int a, int s, int e, int ac, String d)
		{
			name=n;
			attack=a;
			shields=s;
			evade=e;
			accuracy=ac;
			description=d;
		}
		public String getDescription()
			{
				return description;
			}
		public void setDescription(String description)
			{
				this.description = description;
			}
		public String getName()
			{
				return name;
			}
		public void setName(String name)
			{
				this.name = name;
			}
		public int getAttack()
			{
				return attack;
			}
		public void setAttack(int attack)
			{
				this.attack = attack;
			}
		public int getShields()
			{
				return shields;
			}
		public void setShields(int shields)
			{
				this.shields = shields;
			}
		public int getEvade()
			{
				return evade;
			}
		public void setEvade(int evade)
			{
				this.evade = evade;
			}
		public int getAccuracy()
			{
				return accuracy;
			}
		public void setAccuracy(int accuracy)
			{
				this.accuracy = accuracy;
			}
		public static Ship testShip()
		{
			return new Ship("SHIP NAME", 1, 1, 1, 1, "SHIP DESCRIPTION");
		}
		public void printShipInfo()
		{
			System.out.println("Name: " + this.getName());
			System.out.println("Attack power: " + this.getAttack());
			System.out.println("Maximum shields: " + this.getShields());
			System.out.println("Evasion thruster capability: " + this.getEvade());
			System.out.println("Targeting computer accuracy: " + this.getAccuracy());
		}
	}
