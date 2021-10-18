package prep;

import java.util.Scanner;

public class Pmode {
	
	// TODO DOC

	public static Scanner sc = new Scanner(System.in);
	
	
	public static int select() {
		int smode;
		System.out.println("Selectionner un mode de jeu:"
				+ "\n0 = Mode 1 joueur."
				+ "\n1 = Mode 2 joueurs.");
			
		smode = sc.nextInt();
			
		return smode;
	}
}
