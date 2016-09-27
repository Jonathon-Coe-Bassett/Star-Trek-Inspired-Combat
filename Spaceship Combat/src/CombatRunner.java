import java.util.Scanner;
public class CombatRunner
	{
		public static Player player;

		public static void main(String[] args)
			{
				greetPlayer();
				Mechanics.makeShips();
				Mechanics.sleep(100);
				Mechanics.chooseShip();
				Mechanics.Combat();
			}
		public static void greetPlayer()
			{
				System.out.println("You are a new Federation captain. What is your name?");
				Scanner userInput=new Scanner(System.in);
				player.setName(("Captain ")+userInput.nextLine());
				System.out.println("Welcome to the Federation, " + player.getName() + "!" );
				System.out.println("What is your gender?");
				boolean genderNotChosen=true;
				while (genderNotChosen)
					{
				String gender=userInput.nextLine();
				gender=gender.toLowerCase();
				if (gender.equals("female") || gender.equals("girl"))
					{
						player.setGender(true);
					}
				if (gender.equals("male") || gender.equals("boy"))
					{
						player.setGender(false);
					}
					}
				//test
			}

	}
