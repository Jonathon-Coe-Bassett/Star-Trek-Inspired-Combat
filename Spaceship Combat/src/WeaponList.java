import java.util.ArrayList;
//This class might be entirely redundant
import java.util.Scanner;
public class WeaponList
	{
		static ArrayList<Weapon> arsenal=new ArrayList<>();
		public static Weapon testWeapon()
		{
			return new Weapon("WEAPON NAME", "WEAPON MAKER", 'a', 10);
		}
	}
