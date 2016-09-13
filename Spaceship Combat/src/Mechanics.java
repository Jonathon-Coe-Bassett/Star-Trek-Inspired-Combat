import java.util.ArrayList;
import java.util.Scanner;
public class Mechanics
	{
		static Ship one, two, three, four, five, player, dev;
		static ArrayList<Ship> shipBay=new ArrayList<>();
		static boolean enemyShipLives, playerShipLives;
		
		public static int rollDice (int a, int b)
			{
				int count=0;
				int total=0;
				while(count<a)
					{
						int roll=(int)((Math.random()*b)+1);	
						total=total+roll;
						count++;
					}
				return total;
				
			}
		public static void makeShips()
			{
				one=new Ship("SS. Booper Dooper", 5, 3, 7, 5, "The SS Booper Dooper is an older, louder model, yet she still packs a punch. She has slightly higher attack and good maneuverability, yet sacrifices shield power for accuracy.");
				two=new Ship("SS. Courage", 7, 3, 2, 8, "SS. Courage has seen her fair share of combat, yet rumors say she still wants Imperial blood. She has custom high powered phasers and the best agility in the fleet, however she has low shields and her targeting computers are known to have errors.");	
				three=new Ship("SS. Titanic",10, 10, 1, 1, "Don't confuse this ship for the Titanic of old Earth legend; This one is truly unsinkable! She has the best Shield capacity and variety of weapons in the fleet, yet her size makes her an easy target." );
				four=new Ship("SS. Tiny Ship Tim", 3, 3, 7, 7, "Tiny Ship Tim lives up to her name. She's a small scouting model with low shields and only weilds emergency phasers. Her small size, however, makes her a hard target to hit and her bio-targeting computer make her incredibly acurate.");
				five=new Ship("SS. McGuire", 4, 4, 4, 8, "The SS. McQuire's unique computer system evenly routes power between shield, attack, and RCS engines. This computer also has custom targeting subroutines, making the SS. mcGuire rarely miss.");
				dev=new Ship("DEVSHIP", 100, 100, 100, 100, null);
				shipBay.add(one);
				shipBay.add(two);
				shipBay.add(three);
				shipBay.add(four);
				shipBay.add(five);
				shipBay.add(dev);


			}
		public static void chooseShip()
		{
			System.out.println("Now, you are lucky enough to chose which ship you pilot. Enter the name of the ship you wish to pilot into your terminal.");
			for (int i=0; i<shipBay.size(); i++)
				{
					Ship print=shipBay.get(i);
					if (print.getName().equals("DEVSHIP"))
						{
							System.out.println("  ");
						}
					else
						{
						System.out.println(print.getName());
						System.out.println(print.getDescription());
						}
				}			
			Scanner userInput=new Scanner(System.in);
			String choice=userInput.nextLine();
			choice=choice.toLowerCase();
			for (int i=0; i<shipBay.size(); i++)
				{
					String name=shipBay.get(i).getName();
					name=name.toLowerCase();
					if (choice.equals(name))
						{
							player=shipBay.get(i);
						}
				}
			System.out.println(CombatRunner.captain + ", you have chosen the " + player.getName());

		}
		public static void Combat()
		{
			enemyShipLives=true;
			playerShipLives=true;
			System.out.println("An enemy ship aproaches!");
			while (enemyShipLives && playerShipLives)
				{
					routePower();
					for (int i=0; i<7; i++)
						{
						sleep(300);
						System.out.print(".");
						}
					System.out.println("");

				}
			
		}
		public static void routePower()
		{
			Scanner userInput=new Scanner(System.in);

			System.out.println("Captain, should we route excess power to weapons systems or shield systems?");
			System.out.println("a) Weapons");
			System.out.println("b) Shields");
			String choice=userInput.nextLine();
			choice=choice.toLowerCase();
			if (choice.equals("a") || choice.equals("weapons"))
				{
					player.setAttack(player.getAttack()+1);
					System.out.println("Phasers have been amplified.");
				}
			else if (choice.equals("b") || choice.equals("shields"));
				{
					player.setShields(player.getShields()+1);
					System.out.println("Shield power has increased.");
				}
		}
		public static void rollStats()
		{
			
		}
		public static void sleep(int a)
		{
			try
				{
					Thread.sleep(a);
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
