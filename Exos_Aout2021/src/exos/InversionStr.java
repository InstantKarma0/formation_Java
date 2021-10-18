package exos;

import java.util.Scanner;

/**
 * Inversion de String sans .reverse
 * @author cocod
 *
 */

public class InversionStr {

	/**
	 * Fonction permettant d'inverser un string
	 */
	public static void inverse() {
		
		// Recuperation du prenom
		Scanner sc = new Scanner(System.in);
		System.out.println("Prenom:");
		
		
		String origine = sc.nextLine();
		
		// Initialisation de la chaine inversee
		String reversedStr = "";
		
		
		// Boucle avec i allant de length prenom à 0
		for (int i = origine.length(); i > 0; i--) {
			// On ajoute le charactere present à l'indice i-1 à la chaine de charactère
			reversedStr = reversedStr + origine.charAt(i-1);
		}// EO For
		
		
		// On affiche le resultat dans la console
		System.out.println("Le prenom inversé est: " + reversedStr);
		
		// On ferme le scanner
		sc.close();
	}
	
	/**
	 * Version Surchargee
	 * @param str String a inverser
	 * @return String Inverse
	 */
	public static String inverse(String str) {
		
		// Initialisation de la chaine inversee
		String reversedStr = "";
		
		
		// Boucle avec i allant de length prenom à 0
		for (int i = str.length(); i > 0; i--) {
			// On ajoute le charactere present à l'indice i-1 à la chaine de charactère
			reversedStr = reversedStr + str.charAt(i-1);
		}// EO For
		
		
		// On affiche le resultat dans la console
		System.out.println("Le prenom inversé est: " + reversedStr);
		
		// On ferme le scanner
		return reversedStr;
	}
	
	public static String inverseHalf(String str) {
		char tempo;
		StringBuilder test = new StringBuilder(str);
		
		for (int i = 0; i < (test.length()/2);i++) {
			tempo = test.charAt(i);
			test.setCharAt(i, test.charAt(test.length()-i-1));
			test.setCharAt(test.length()-1-i, tempo);
		}
		
		str = test.toString();
		return str;
	}
}
