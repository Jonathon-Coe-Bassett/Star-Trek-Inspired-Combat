import java.util.Scanner;
public class ShipCreation
	{
		private static int days=30;
		
		
		public static Ship buildShip()
		{
			Ship ship=new Ship("UNNAMED", 0, 0, 0, 0, null);
			System.out.println("After your impressive performances in defending the Federation, you are now allowed to oversee and dictate the building of your new ship!");
			System.out.println("You have " + days + " days total to build your ship before your next mission. You can spend any number of days on different ship systems.");
			//while(days>0)
				{
			ship.setAttack(attack());
			ship.setShields(shields());
			ship.setAccuracy(accuracy());
			System.out.println("The remaining " + days + " days will be spent constructing the evasion thrusters.");
			ship.setEvade(days);
			System.out.println("");
				}
			System.out.println("The specs of your ship are as follows: ");
			ship.printShipInfo();
			Scanner userInput=new Scanner(System.in);
			System.out.println("And finally, what should the name of your ship be?");
			ship.setName(userInput.nextLine());
			System.out.println("The " + ship.getName() + " is ready for her first mission, " + CombatRunner.player.getName() + "!");
			return ship;
			
		}
		private static int askNum()
		{
			int j=0;
			if(days!=0)
				{
			Scanner userInput=new Scanner(System.in);
			j=userInput.nextInt();
			if (j>days)
				{
					System.out.println("We don't have that time.");
					askNum();
				}
			else if(j<1)
				{
					System.out.println("Don't be an idiot.");
					askNum();
				}
				}
			else
				{
				System.out.println("We don't have any time for building that.");
				System.out.println("");
				}
			
			return j;
		}
		public static int attack()
		{
			int time;
			System.out.println("How many days should we spend on the weapons system?");
			time=askNum();
			days-=time;
			return(time);
		}
		public static int shields()
		{
			int time;
			System.out.println("How many days should we spend on the shield generating system?");
			time=askNum();
			days-=time;
			return (time);
		}
		public static int accuracy()
		{
			int time;
			System.out.println("How many days should we spend on the targeting computers?");
			time=askNum();
			days-=time;
			return (time);
		}
	}
