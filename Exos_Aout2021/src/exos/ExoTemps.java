package exos;

import java.util.Scanner;

public class ExoTemps {

	/**
	 * Fonction permettant de savoir l'heure qu'il sera dans 1 minute
	 */
	public static void fonction() {
		Scanner sc = new Scanner(System.in);
		
		
		// On demande l'heure et les minutes
		System.out.println("Inserez l'heure:");
		int heure = sc.nextInt();
		System.out.println("Inserez les minutes:");
		int minutes = sc.nextInt();
		
		// On incremente minutes
		minutes++;
		
		// Condition si minutes passe a 60 ou +
		if (minutes > 59) {
			
			// On incremente heure et on soustrait 60 à minutes
			heure++;
			minutes -= 60;
			
		}
		
		// On affiche l'heure qu'il sera dans 1 minute
		System.out.println("Dans 1 minute il sera" + heure + ":" + minutes);
		
		// On ferme le scanner
		sc.close();
	}
	
	
	
	/**
	 * Version surchargee avec parametres
	 * @param heure , l'heure actuelle
	 * @param minutes , les minutes actuelles
	 * @return Tableau de taille 2 avec heure et minutes
	 */
	public static int[] fonction(int heure, int minutes) {
		
		// On incremente minutes
		minutes++;
		
		// Conditions si minutes passe a 60 ou +
		if (minutes > 59) {
			
			// On incremente heure et on soustrait 60 à minutes
			minutes -= 60;
			heure++;
		}
		
		// On ajoute l'heure et les minutes dans un tableau t
		int[] t = new int[2];
		t[0] = heure;
		t[1] = minutes;

		// On retourne le tableau
		return t;
	}
}
