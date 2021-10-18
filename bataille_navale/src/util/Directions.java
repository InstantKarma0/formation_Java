package util;

import java.util.ArrayList;

public class Directions {
	
	// TODO DOCUMENTATION

	protected static String[] directions = {"gauche","droite","haut","bas"};
	
	// Vérification si il y a des directions possibles
	public static int[] nbDirec(int[] posibilities) throws Exception {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < posibilities.length; i++) {
			if (posibilities[i] == 1) {
				al.add(i);
				
				System.out.println(retFormatedDirec(i)+ "\n");
			}
		}
		int[] nb = al.stream().mapToInt(i -> i).toArray();
		if (nb.length ==0) {
			throw new Exception("Le tableau ne presente pas de posibilitees");
		}
		return nb;
	}
	
	
	// Version pour l'ia (retrait des system.out)
	public static int[] nbDirec(int[] posibilities, int ia) throws Exception {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < posibilities.length; i++) {
			if (posibilities[i] == 1) {
				al.add(i);
				
			}
		}
		int[] nb = al.stream().mapToInt(i -> i).toArray();
		if (nb.length ==0) {
			throw new Exception("Le tableau ne presente pas de posibilitees");
		}
		return nb;
	}
	
	
	public static String retDirec(int i) {
		return directions[i];
	}
	
	public static String retFormatedDirec(int i) {
		switch (i) {
			case 0:
			case 1:
				return "Le bateau peut être placé vers la " + retDirec(i);
			case 2:
			case 3:
				return "Le bateau peut être placé vers le " + retDirec(i);
		}
		return null;
		
	}
	
	public static int menuDirec() {
		String menu = "Choisissez l'orientation du bateau\n";
		
		for (int i = 0; i < directions.length; i++) {	
			menu = menu + i + " = " + directions[i] + "\n";
		}
		
		int direction = ScanWithLabel.scanInt(menu);
		return direction;
	}
}