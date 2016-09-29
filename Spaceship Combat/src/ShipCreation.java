import java.util.Scanner;
public class ShipCreation
	{
		private static int days=25;
		
		
		public static Ship buildShip()
		{
			Ship ship =null;
			System.out.println("After your impressive performance in defending the Federation headquarters, you are now allowed to oversee and dictate the building of your new ship!");
			System.out.println("You have " + days + " days total to build this ship before your next mission. You can spend any number of days on different ship systems.");
			ship.setAttack(attack());
			ship.setShields(shields());
			ship.setAccuracy(accuracy());
			System.out.println("The remaining " + days + " days will be spent constructing the evasion thrusters.");
			ship.setEvade(days);
			
			Scanner userInput=new Scanner(System.in);
			System.out.println("And finally, what should the name of your ship be?");
			ship.setName(userInput.nextLine());
			return ship;
			
		}
		public static int attack()
		{
			int time;
			Scanner userInput=new Scanner(System.in);
			System.out.println("How many days should we spend on the weapons system?");
			time=userInput.nextInt();
			days-=time;
			return(time);
		}
		public static int shields()
		{
			int time;
			Scanner userInput=new Scanner(System.in);
			System.out.println("How many days should we spend on the shield generating system?");
			time=userInput.nextInt();
			days-=time;
			return (time);
		}
		public static int accuracy()
		{
			int time;
			Scanner userInput=new Scanner(System.in);
			System.out.println("How many days should we spend on the targeting computers?");
			time=userInput.nextInt();
			days-=time;
			return (time);
		}
	}
