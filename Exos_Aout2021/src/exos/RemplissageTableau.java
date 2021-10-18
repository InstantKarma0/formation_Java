package exos;

import java.util.Scanner;

public class RemplissageTableau {
	
	Scanner sc = new Scanner(System.in);
	
	public int[] remplissageTableau(int[] tableau) {
		
		for (int i = 0; i < tableau.length; i++) {
			
			System.out.println("Saisir la valeur n°" + (i+1) + " entre [1..99] : " );
			tableau[i] = sc.nextInt();
		}
		
		return tableau;
	}
}
