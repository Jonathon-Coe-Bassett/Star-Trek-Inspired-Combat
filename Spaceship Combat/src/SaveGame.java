import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveGame
	{
		
		public static void saveGame(Person p)
			{
				 String fileName = "save1.txt";

			        try {
			            // Assume default encoding.
			            FileWriter fileWriter =
			                new FileWriter(fileName);

			            // Always wrap FileWriter in BufferedWriter.
			            BufferedWriter bufferedWriter =
			                new BufferedWriter(fileWriter);

			            // Note that write() does not automatically
			            // append a newline character.
			           // bufferedWriter.write("^^^^");
			            bufferedWriter.write(p.getName());
			            bufferedWriter.newLine();
			            String health=Integer.toString(p.getHealth());
			            bufferedWriter.write(health);
			            bufferedWriter.newLine();
			            bufferedWriter.write(p.getWeapon().getName() + " / " + p.getWeapon().getMaker() + " / " + p.getWeapon().getModel() + " / " + p.getWeapon().getDamage());
			            bufferedWriter.newLine();
			            String g="m";
			            if(p.isGender())
			            	g="f";
			            bufferedWriter.write(g);
			            bufferedWriter.newLine();
			            bufferedWriter.write(p.getShip().getName() + " / " + p.getShip().getAttack() + " / " + p.getShip().getShields() + " / " + p.getShip().getEvade() + " / " + p.getShip().getAccuracy() + " / " + p.getShip().getDescription());
			            bufferedWriter.newLine();
			            bufferedWriter.write(Mechanics.shipBay.get(Mechanics.shipBay.size()-1).getName() + " / " + Mechanics.shipBay.get(Mechanics.shipBay.size()-1).getAttack() + " / " + Mechanics.shipBay.get(Mechanics.shipBay.size()-1).getShields() + " / " + Mechanics.shipBay.get(Mechanics.shipBay.size()-1).getEvade() + " / " + Mechanics.shipBay.get(Mechanics.shipBay.size()-1).getAccuracy() + " / " + Mechanics.shipBay.get(Mechanics.shipBay.size()-1).getDescription());
//			            bufferedWriter.write("We are writing");
//			            bufferedWriter.write(" the text to the file.");

			            // Always close files.
			            bufferedWriter.close();
			        }
			        catch(IOException ex) {
			            System.out.println(
			                "Error writing to file '"
			                + fileName + "'");
			        }
			            // Or we could just do this:
			            // ex.printStackTrace();
			        saveAnimation();
			}
			public static void testSaveGame()
			{
				 // The name of the file to open.
		        String fileName = "save1.txt";

		        // This will reference one line at a time
		        String line = null;

		        try {
		            // FileReader reads text files in the default encoding.
		            FileReader fileReader = 
		                new FileReader(fileName);

		            // Always wrap FileReader in BufferedReader.
		            BufferedReader bufferedReader = 
		                new BufferedReader(fileReader);

		            while((line = bufferedReader.readLine()) != null) {
		                System.out.println(line);
		            }	

		            // Always close files.
		            bufferedReader.close();			
		        }
		        catch(FileNotFoundException ex) {
		            System.out.println(
		                "Unable to open file '" + 
		                fileName + "'");				
		        }
		        catch(IOException ex) {
		            System.out.println(
		                "Error reading file '" 
		                + fileName + "'");					
		            // Or we could just do this: 
		            // ex.printStackTrace();
		        }
			}
//			public static Person loadGame()
//			{
//				String fileName = "save1.txt";
//				Person loadedPlayer=null;
//				String line=null;
//				try {
//		            // FileReader reads text files in the default encoding.
//		            FileReader fileReader = 
//		                new FileReader(fileName);
//
//		            // Always wrap FileReader in BufferedReader.
//		            BufferedReader bufferedReader = 
//		                new BufferedReader(fileReader);
//
//		            while((line = bufferedReader.readLine()) != null) {
//		                System.out.println(line);
//		            }
//		            bufferedReader.close();
//				}
//				catch(FileNotFoundException ex) {
//		            System.out.println(
//		                "Unable to open file '" + 
//		                fileName + "'");				
//		        }
//		        catch(IOException ex) {
//		            System.out.println(
//		                "Error reading file '" 
//		                + fileName + "'");					
//		            // Or we could just do this: 
//		            // ex.printStackTrace();
//		        }
//				
//				return loadedPlayer;
//			}
			public static Person loadGame() throws FileNotFoundException
			{
				Person loadedPlayer=Person.testPerson();
				Scanner file=new Scanner(new File("save1.txt"));
				loadedPlayer.setName(file.nextLine());
				//FIX ABOVE
				loadedPlayer.setHealth(Integer.parseInt(file.nextLine()));
//				String line=file.nextLine();
				loadedPlayer.setWeapon(loadWeapon(file.nextLine()));
				
				boolean g=false;
				if(file.nextLine().equals("f"))
					g=true;
				loadedPlayer.setGender(g);
				
				loadedPlayer.setShip(loadShip(file.nextLine()));
				Mechanics.shipBay.add(loadShip(file.nextLine()));
				return loadedPlayer;
			}
			public static Ship loadShip(String line)
			{
				/*name=n;
				attack=a;
				shields=s;
				evade=e;
				accuracy=ac;
				description=d;*/
				
				Ship ship=Ship.testShip();
				ship.setName(line.substring(0, line.indexOf(" / ")));
				line=line.substring(line.indexOf(" / ")+3);
				
				ship.setAttack(Integer.parseInt(line.substring(0, line.indexOf(" / "))));
				line=line.substring(line.indexOf(" / ")+3);
				
				ship.setShields(Integer.parseInt(line.substring(0, line.indexOf(" / "))));
				line=line.substring(line.indexOf(" / ")+3);

				ship.setEvade(Integer.parseInt(line.substring(0, line.indexOf(" / "))));
				line=line.substring(line.indexOf(" / ")+3);

				ship.setAccuracy(Integer.parseInt(line.substring(0, line.indexOf(" / "))));
				line=line.substring(line.indexOf(" / ")+3);

				ship.setDescription(line);
				return ship;
			}
			//gets information stored as a string, and makes a Weapon based on what is given.
			public static Weapon loadWeapon(String line)
			{
				Weapon weapon=WeaponList.testWeapon();
				
				weapon.setName(line.substring(0, line.indexOf(" / ")));
				line=line.substring(line.indexOf(" / ")+3);
				
				weapon.setMaker(line.substring(0, line.indexOf(" / ")));
				line=line.substring(line.indexOf(" / ")+3);
				
				char c=line.charAt(0);
				weapon.setModel(c);
				line=line.substring(line.indexOf(" / ")+3);
				
				int dam=Integer.parseInt(line);
				weapon.setDamage(dam);
				return weapon;
			}
			public static void testSave() throws FileNotFoundException
			{
				Person player=Person.testPerson();
				player.setHealth(20);
				SaveGame.saveGame(player);
				System.out.println("Saving is a sucess!");
				SaveGame.testSaveGame();
				System.out.println("File reading successful!");
				player=null;
				player=SaveGame.loadGame();
				System.out.println("Player loading successful!");
			}
			public static void saveAnimation()
			{
				Mechanics.print(" __________________          _-_");
				System.out.println();
				Mechanics.print(" \\________________|)____.---'---`---.____ ");
				System.out.println();
				Mechanics.print("                ||  \\----._________.----/");
				System.out.println();
				Mechanics.print("                ||     / ,' `---'");
				System.out.println();
				Mechanics.print("             ___||_,--'  -._");
				System.out.println();
				Mechanics.print("            /___          ||(-");
				System.out.println();
				Mechanics.print("                `---._____-'");
				System.out.println("");
			}
	}
