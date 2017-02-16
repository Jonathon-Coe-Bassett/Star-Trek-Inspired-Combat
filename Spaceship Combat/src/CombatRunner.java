import java.util.Scanner;
import java.io.*;
public class CombatRunner
	{
		public static Person player=new Person(null, 10, null, false, null);
		public static String they, their; 
		public static boolean playGame=true;
		static Scanner save;
		public static int difficulty=10;
		public static void main(String[] argsv) throws IOException
			{
				
				homeScreen();
				
				System.out.println("Welcome to the Federation Spaceport! would you like to rebuild your ship?");
				System.out.println("Currently, you are using the " + player.getShip().getName());
				if(Mechanics.yn())
				player.setShip(ShipCreation.buildShip());
				player.askSave();
				System.out.println("Off to adventure!");
				System.out.println("For now, you'll just be defensing the Federation's colony Exerpa from the enemy.");
				while(playGame)
					{
						Mechanics.shipCombat();
						player.askSave();
						System.out.println("Would you like to stop playing for now? Any unsaved progress will be lost.");
						if(Mechanics.yn())
							{
								System.out.println("Thanks for playing!");
								playGame=false;
							}
						difficulty+=5;
						Mechanics.enemy=Mechanics.randomShip(difficulty);
					}
			}
		public static void homeScreen() throws FileNotFoundException
		{
			System.out.println("Welcome!");
			System.out.println("1) LOAD GAME");
			System.out.println("2) NEW GAME");
			Scanner userInput=new Scanner(System.in);
			int in=userInput.nextInt();
			if(in==1)
				{
					player=SaveGame.loadGame();
					System.out.println("We shall continue, " + player.getName() + "!");
				}
			else if(in==2)
				{
					greetNewPlayer();
					Mechanics.makeShips();
					Mechanics.sleep(100);
					Mechanics.chooseShip();
					Mechanics.shipCombat();
					player.askSave();
				}
			else if (in==113)
				{
					SaveGame.testSave();
					System.out.println("");
				}
			else
				homeScreen();
		}
		public static void greetNewPlayer() throws FileNotFoundException
			{
				save=new Scanner(new File("save1.txt"));
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
						break;
					}
				if (gender.equals("male") || gender.equals("boy"))
					{
						player.setGender(false);
						they="he";
						their="his";
						genderNotChosen=false;
						break;
					}
				System.out.println("Pick a real gender, please");
					}
				player.setWeapon(new Weapon("Captain's Pistol", "Wickwire Weaponry", 'a', 1));
				Weapon.arsenal.add(player.getWeapon());
				System.out.println("You are equiped with a " + player.getWeapon().getName() + " manufactured by " + player.getWeapon().getMaker() + ", model " + player.getWeapon().getModel() + ". Standard for all Federation captains.");
				Mechanics.sleep(1000);
				System.out.println("");
			}

	}
