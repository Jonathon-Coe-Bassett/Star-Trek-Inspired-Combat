import java.util.Scanner;
public class CombatRunner
	{
		public static String name;

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
				name=("Captain ")+userInput.nextLine();
				System.out.println("Welcome to the Federation, " + name + "!" );
			}

	}
