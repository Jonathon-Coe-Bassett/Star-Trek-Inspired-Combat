import java.util.ArrayList;
import java.util.Scanner;
public class Mechanics
	{
		static Ship one, two, three, four, five, player, dev;
		static Ship enemy=randomShip();
		static Ship beforeCombat;
		static ArrayList<Ship> shipBay=new ArrayList<>();
		static boolean enemyShipLives, playerShipLives, enemyEvades, playerEvades;
		
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
				one=new Ship("SS. Booper Dooper", 5, 3, 7, 5, "The SS Booper Dooper is an older, louder model, but she still packs a punch. She has a slightly higher attack and good maneuverability, but sacrifices her shield power for accuracy.");
				two=new Ship("SS. Courage", 7, 3, 2, 8, "SS. Courage has seen her fair share of combat, but rumors say she still wants Imperial blood. She has custom high powered phasers and the best agility in the fleet, however she has low shields and her targeting computers are known to have errors.");	
				three=new Ship("SS. Titanic",9, 9, 2, 2, "Don't confuse this ship for the Titanic of old Earth legend; this one is truly un-sinkable! She has the best shield capacity and variety of weapons in the fleet, but her size makes her an easy target." );
				four=new Ship("SS. Tiny Tim", 3, 3, 7, 7, "Tiny Ship Tim lives up to her name. She's a small scouting model with low shields and only wields emergency phasers. Her small size, however, makes her a hard target to hit, and her bio-targeting computer makes her incredibly accurate.");
				five=new Ship("SS. McGuire", 4, 2, 4, 10, "The SS. McGuire's unique computer system balances between shield, attack, and RCS engines. This computer also has custom targeting subroutines, making the SS. McGuire rarely miss.");
				dev=new Ship("DEVSHIP", 100, 100, 100, 100, null);
				shipBay.add(one);
				shipBay.add(two);
				shipBay.add(three);
				shipBay.add(four);
				shipBay.add(five);
				shipBay.add(dev);


			}
		public static Ship randomShip()
		{
			int a=0;
			int b=0;
			int c=0;
			int d=0;
			int sum=0;
			while (sum != 20)
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
							player=shipBay.get(i);
							CombatRunner.player.setShip(player);
						}
				}
			System.out.println(CombatRunner.player.getName() + ", you have chosen the " + player.getName());
				} catch (Exception e)
				{
					System.out.println("Please enter an actual ship name.");
					chooseShip();
				}

		}
		public static void shipCombat()
		{
			enemyShipLives=true;
			playerShipLives=true;
			System.out.println("An enemy ship aproaches!");
			while (enemyShipLives && playerShipLives)
				{
					routePower();
					evasionChance();
					rollStats();
					checkWin();
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
				}
			else if (playerShipLives && !enemyShipLives)
				{
					System.out.println("We've penetrated their shields! The enemy ship is falling apart!");
					System.out.println("We've won!");
					//add flyTo method
				}
			else
				{
					System.out.println("Captain, We have both destroyed one another!");
					System.out.println("We have to get off this ship!");
					//add escape method
				}
			
		}
		public static void checkWin()
			{
				if (player.getShields()<=0)
					{
						playerShipLives=false;
					}
				if (enemy.getShields()<=0)
					{
						enemyShipLives=false;
					}
			}
		public static void routePower()
		{
			Scanner userInput=new Scanner(System.in);

			System.out.println(CombatRunner.player.getName()+" , should we route excess power to weapon's systems or shield systems?");
			System.out.println("a) Weapons");
			System.out.println("b) Shields");
			try
				{
			String choice=userInput.nextLine();
			choice=choice.toLowerCase();
			if (choice.equals("a") || choice.equals("weapons"))
				{
					player.setAttack(player.getAttack()+1);
					System.out.println("Phasers have been amplified.");
				}
			else if (choice.equals("b") || choice.equals("shields"))
				{
					player.setShields(player.getShields()+1);
					System.out.println("Shield power has increased.");
				}
			else
					{
						System.out.println("Orders unclear.");
						routePower();
					}
				} catch (Exception e)
				{
					System.out.println("Orders unclear, ");
					routePower();
				}
		}
		public static void evasionChance()
		{
			if (enemy.getEvade()>(rollDice(1, player.getAccuracy())))
				{
					enemyEvades=true;
				}
			else
				{
					enemyEvades=false;
				}
			if (player.getEvade()>(rollDice(1, enemy.getAccuracy())))
				{
					playerEvades=true;
				}
			else
				{
					playerEvades=false;
				}
		}
		public static void rollStats()
		{
			int damage;
			if (enemyEvades==false)
				{
				damage=player.getAttack();
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
			if (playerEvades==false)
				{
				damage=enemy.getAttack();
				damage=vs(damage, player.getShields());
				player.setShields(player.getShields()-damage);
				System.out.println("Their attack was successful! They lowered our shields!");
				}
			else
				{
					System.out.println("Their attack missed!");
				}
			System.out.println(CombatRunner.player.getName() + ", our shields are at " + player.getShields());
		}
		public static int vs(int a, int b)
		{
			int c=b-(rollDice(1, a));
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
	}
