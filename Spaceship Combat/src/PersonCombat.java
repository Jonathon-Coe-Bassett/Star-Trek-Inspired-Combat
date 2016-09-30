
public class PersonCombat
	{
		public static Person randomPerson(String name, int a)
		{
			Person r=new Person(name, (int) (Math.random()*a)+1, null, false, null);
			return r;
			
		}
	}
