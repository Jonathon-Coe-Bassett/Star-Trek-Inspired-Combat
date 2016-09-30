import java.util.Scanner;
public class CombatRunner
	{
		public static Person player=new Person(null, 10, null, false, null);
		public static String they, their; 

		public static void main(String[] argsv)
			{
				greetPlayer();
				/*Mechanics.makeShips();
				Mechanics.sleep(100);
				Mechanics.chooseShip();
				Mechanics.shipCombat();*/
				player.setShip(ShipCreation.buildShip());
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
						they="she";
						their="her";
						genderNotChosen=false;
					}
				if (gender.equals("male") || gender.equals("boy"))
					{
						player.setGender(false);
						they="he";
						their="his";
						genderNotChosen=false;
					}
					}
				player.setWeapon(new Weapon("Captain's Pistol", "Wickwire Weaponry", 'a', 1));
				Weapon.arsenal.add(player.getWeapon());
				System.out.println("You are equiped with a " + player.getWeapon().getName() + " manufactured by " + player.getWeapon().getMaker() + ", model " + player.getWeapon().getModel() + ". Standard for all Federation captains.");
				Mechanics.sleep(1000);
				System.out.println("");
			}

	}
