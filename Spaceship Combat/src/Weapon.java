
public class Weapon
	{
		private String name;
		private String maker;
		private char model;
		private int damage;
		
		public Weapon (String n, String m, char md, int d)
		{
			name=n;
			maker=m;
			model=md;
			damage=d;
		}

		public String getName()
			{
				return name;
			}

		public void setName(String name)
			{
				this.name = name;
			}

		public String getMaker()
			{
				return maker;
			}

		public void setMaker(String maker)
			{
				this.maker = maker;
			}

		public char getModel()
			{
				return model;
			}

		public void setModel(char model)
			{
				this.model = model;
			}

		public int getDamage()
			{
				return damage;
			}

		public void setDamage(int damage)
			{
				this.damage = damage;
			}
		
		
	}
