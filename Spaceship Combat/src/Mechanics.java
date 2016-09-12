
public class Mechanics
	{
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
				Ship one=new Ship("SS. Booper Dooper", 5, 3, 7, 5, "The SS Booper Dooper is an older, louder model, yet she still packs a punch. She has slightly higher attack and good maneuverability, yet sacrifices shield power for accuracy.");
				Ship two=new Ship("SS. Courage", 7, 3, 2, 8, "SS. Courage has seen her fair share of combat, yet rumors say she still wants Imperial blood. She has custom high powered phasers and the best agility in the fleet, however she has low shields and her targeting computers are known to have errors.");	
				Ship three=new Ship("SS. Titanic",10, 10, 1, 1, "Don't confuse this ship for the Titanic of old Earth legend; This one is truly unsinkable! She has the best Shield capacity and variety of weapons in the fleet, yet her size makes her an easy target." );
				Ship four=new Ship("SS. Tiny Ship Tim", 3, 3, 7, 7, "Tiny Ship Tim lives up to her name. She's a small scouting model with low shields and only weilds emergency phasers. Her small size, however, makes her a hard target to hit and her curcular----");
				//finish ships
			}
	}
