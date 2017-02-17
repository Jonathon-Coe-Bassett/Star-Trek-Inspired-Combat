import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Mechanics
	{
		//static Ship one, two, three, four, five, dev;
		private static Ship playerShip;
		private static final Ship original=CombatRunner.player.getShip();
		public static Ship enemy;
		public static Ship beforeCombat;
		static ArrayList<Ship> shipBay=new ArrayList<>();
		private static boolean enemyShipLives, playerShipLives, enemyEvades, playerEvades;
		private static Mechanics m=new Mechanics();
		
		public int rollDice (int a, int b)
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
		public static boolean yn()
			{
				System.out.println("Answer yes[y] or no[n].");
				Scanner ui=new Scanner(System.in);
				String in=ui.nextLine();
				if(in.equals("y") || in.equals("yes"))
						return true;
				return false;
			}
		public static void makeShips()
			{
				shipBay.add(new Ship("DEVSHIP", 1000, 1000, 1000, 1000, null));
				shipBay.add(new Ship("SS. Booper Dooper", 5, 3, 7, 5, "The SS Booper Dooper is an older, louder model, but she still packs a punch. She has a slightly higher attack and good maneuverability, but sacrifices her shield power for accuracy."));
				shipBay.add(new Ship("SS. Courage", 7, 3, 2, 8, "SS. Courage has seen her fair share of combat, but rumors say she still wants Imperial blood. She has custom high powered phasers and the best agility in the fleet, however she has low shields and her targeting computers are known to have errors."));
				shipBay.add(new Ship("Imperial Star Destroyer", 10, 6, 3, 3, "This vessel is a captured Imperial ship, yet she's different from the ordinary somehow, and the captured crew members kept saying something about someone named Dark Vaiter."));
				shipBay.add(new Ship("SS. Titanic",9, 9, 2, 2, "Don't confuse this ship for the Titanic of old Earth legend; this one is truly un-sinkable! She has the best shield capacity and variety of weapons in the fleet, but her size makes her an easy target." ));
				shipBay.add(new Ship("SS. Tiny Tim", 3, 3, 7, 7, "Tiny Ship Tim lives up to her name. She's a small scouting model with low shields and only wields emergency phasers. Her small size, however, makes her a hard target to hit, and her bio-targeting computer makes her incredibly accurate."));
				shipBay.add(new Ship("SS. McGuire", 4, 2, 4, 10, "The SS. McGuire's unique computer system balances between shield, attack, and RCS engines. This computer also has custom targeting subroutines, making the SS. McGuire rarely miss."));
				shipBay.add(new Ship("USS. Enterprise", 6, 6, 6, 6, "Strangely, this vessel feels almost homely... as if from a dream."));	
			}
		public static Ship randomShip(int total)
		{
			int a=0;
			int b=0;
			int c=0;
			int d=0;
			int sum=0;
			while (sum != total)
				{
					a=(int) (Math.random()*8)+1;
					b=(int) (Math.random()*8)+1;
					c=(int) (Math.random()*8)+1;
					d=(int) (Math.random()*8)+1;
					
					sum=a+b+c+d;
				}
			Ship enemy=new Ship("Enemy", a, b, c, d, null);
			//System.out.println(enemy.getAttack() + enemy.getShields() + enemy.getAccuracy() + enemy.getEvade());
			return enemy;
		}
		public static void chooseShip()
		{
			System.out.println("Now, you are lucky enough to chose which ship you pilot. Enter the name of the ship you wish to pilot.");
			for (int i=0; i<shipBay.size(); i++)
				{
					Ship print=shipBay.get(i);
					if (print.getName().equals("DEVSHIP"))
						{
							System.out.println(" ");
						}
					else
						{
						System.out.println(print.getName());
						System.out.println("	" + print.getDescription());
						sleep(100);
						}
				}			
			try
				{
			Scanner userInput=new Scanner(System.in);
			String choice=userInput.nextLine();
			choice=choice.toLowerCase();
			for (int i=0; i<shipBay.size(); i++)
				{
					String name=shipBay.get(i).getName();
					name=name.toLowerCase();
					if (choice.equals(name))
						{
							playerShip=shipBay.get(i);
							CombatRunner.player.setShip(playerShip);
						}
				}
			System.out.println(CombatRunner.player.getName() + ", you have chosen the " + playerShip.getName());
				} catch (Exception e)
				{
					System.out.println("Please enter an actual ship name.");
					chooseShip();
				}

		}
		public static void shipCombat() throws IOException
		{
			enemy=new Ship(randomShip(CombatRunner.difficulty));
			playerShip=CombatRunner.player.getShip();
			enemyShipLives=true;
			playerShipLives=true;
			System.out.println("An enemy ship aproaches!");
			while (enemyShipLives && playerShipLives)
				{
					
					m.routePower();
					m.evasionChance();
					m.rollStats();
					m.checkWin();
					for (int i=0; i<7; i++)
						{
						sleep(300);
						System.out.print(".");
						}
					System.out.println("");

				}
			if (enemyShipLives && !playerShipLives)
				{
					System.out.println("Our shields have been penetrated! We have to evacuate!");
					System.out.println("We have to get off of this ship!");
					//add escape method
					
					System.out.println("GAME OVER.");
					CombatRunner.homeScreen();
				}
			else if (playerShipLives && !enemyShipLives)
				{
					System.out.println("We've penetrated their shields! The enemy ship is falling apart!");
					System.out.println("We've won!");
					playerShip=original;
					System.out.println("All systems normaliazing.");
					//add flyTo method
				}
			else
				{
					System.out.println("Captain, We have both destroyed one another!");
					System.out.println("We have to get off this ship!");
					//add escape method
					System.out.println("GAME OVER.");
					CombatRunner.homeScreen();
				}
			
		}
		public  void checkWin()
			{
				if (playerShip.getShields()<=0)
					{
						playerShipLives=false;
					}
				if (enemy.getShields()<=0)
					{
						enemyShipLives=false;
					}
			}
		public  void routePower()
		{
			Scanner userInput=new Scanner(System.in);

			System.out.println(CombatRunner.player.getName()+" , should we route excess power to weapon's systems or shield systems?");
			System.out.println("a) Weapons");
			System.out.println("b) Shields");
			System.out.println("c) Scanners");
			try
				{
			String choice=userInput.nextLine();
			choice=choice.toLowerCase();
			if (choice.equals("a") || choice.equals("weapons"))
				{
					playerShip.setAttack(playerShip.getAttack()+1);
					System.out.println("Phasers have been amplified.");
				}
			else if (choice.equals("b") || choice.equals("shields"))
				{
					playerShip.setShields(playerShip.getShields()+1);
					System.out.println("Shield power has increased.");
				}
			else if (choice.equals("c") || choice.equals("scanners"))
				{
					System.out.println("Enemy stats are as follows:");
					enemy.printShipInfo();
				}
			else
					{
						System.out.println("Orders unclear.");
						routePower();
					}
				} catch (Exception e)
				{
					System.out.println("Orders unclear.");
					routePower();
				}
		}
		public void evasionChance()
		{
			if (enemy.getEvade()>(rollDice(1, playerShip.getAccuracy())))
				{
					enemyEvades=true;
				}
			else
				{
					enemyEvades=false;
				}
			if (playerShip.getEvade()>(rollDice(1, enemy.getAccuracy())))
				{
					playerEvades=true;
				}
			else
				{
					playerEvades=false;
				}
		}
		public void rollStats()
		{
			int damage;
			if (!enemyEvades)
				{
				damage=playerShip.getAttack();
				damage=vs(damage, enemy.getShields());
				enemy.setShields(enemy.getShields()-damage);
				System.out.println(CombatRunner.player.getName() + " , we did " + damage + " damage to their shields!");
				}
			else
				{
					System.out.println("Our attack missed!");
				}
			for (int i=0; i<7; i++)
				{
				sleep(300);
				System.out.print(".");
				}
			System.out.println("");
			if (!playerEvades)
				{
				damage=enemy.getAttack();
				damage=vs(damage, playerShip.getShields());
				playerShip.setShields(playerShip.getShields()-damage);
				System.out.println("Their attack was successful! They lowered our shields!");
				}
			else
				{
					System.out.println("Their attack missed!");
				}
			System.out.println(CombatRunner.player.getName() + ", our shields are at " + playerShip.getShields());
		}
		public static int vs(int a, int b)
		{
			int c=b-(m.rollDice(1, a));
			if (c<0)
				{
					c *= -1;
				}
			return c;
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
		public static void print(String s)
		{
			for(int i=0; i<s.length(); i++)
				{
					System.out.print(s.charAt(i));
					sleep(10);
				}
		}
	}
