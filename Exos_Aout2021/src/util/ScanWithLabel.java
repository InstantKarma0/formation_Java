package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScanWithLabel {

	// Variable Globale
	public static Scanner scanner = new Scanner(System.in);

	
//-----------------------------------------------------------------------------
	//							String
	
	
	/**
	 * Permet de renvoyer un String incrit par l'utilisateur
	 * 
	 * @param ask String qui sera print afin de guider l'utilisateur
	 * @return String
	 */
	public static String scanString(String ask) {
		// On affiche le string afin d'aider l'utilisateur
		System.out.println(ask);
		
		// On recupere le string depuis la console
		String strret = ScanWithLabel.scanner.next();
		
		// On retourne le string
		return strret;

	}// EO Methode scanString

	
//-----------------------------------------------------------------------------
	//							Char
	
	
	/**
	 * Permet de renvoyer un caractere inscrit par l'utilisateur
	 * 
	 * @param ask String qui sera print afin de guider l'utilisateur
	 * @return caractere d'indice 0
	 */
	public static char scanChar(String ask) {
		
		// On recupere un caractere depuis la console
		char strret = scanString(ask).charAt(0);
		// On retourne ce caractere
		return strret;

	}// EO Methode scanChar

	
	/**
	 * Permet de renvoyer un caractere inscrit par l'utilisateur
	 * 
	 * @param ask String qui sera print afin de guider l'utilisateur
	 * @return caractere d'indice 0 en minuscule
	 */
	public static char scanLowerChar(String ask) {
		// On recupere un caractere depuis la console
		char charret = ScanWithLabel.scanChar(ask);
		// On transforme ce caractere en majuscule
		charret = Character.toLowerCase(charret);
		// On retourne le caractere
		return charret;

	}// EO scanLowerChar
	
	
	/**
	 * Permet de renvoyer un caractere inscrit par l'utilisateur
	 * 
	 * @param ask String qui sera print afin de guider l'utilisateur
	 * @return caractere d'indice 0 en majuscule
	 */
	public static char scanUpperChar(String ask) {
		
		// On recupere un caractere depuis la console
		char charret = ScanWithLabel.scanChar(ask);
		// On transforme ce caractere en majuscule 
		charret = Character.toUpperCase(charret);
		// On retourne ce caractere
		return charret;

	} // EO scanUpperChar

	// -------------------------------------------------------------------------
	// 									INT

	/**
	 * Renvoie un int inscrit par l'utilisateur depuis la commande avec gestion
	 * erreur InputMismatchException
	 * 
	 * @return int
	 */

	private static int scanInt() {

		int retour = 0;
		try {
			// On essaie de recuperer une valeur int
			retour = scanner.nextInt();

		} // EO TRY

		// Dans le cas où le scanner nous renvoie l'erreur InputMismatchException
		catch (InputMismatchException e) {

			// On vide le scanner
			scanner.next();
			// On indique a l'utilisateur que l'information n'est pas un int
			System.out.println("L'information entrée n'est pas un nombre entier");

		} // EO CATCH

		return retour;

	} // EO scanInt()

	/**
	 * Affiche le label de la demande Renvoie un Int incrit par l'utilisateur
	 * 
	 * @param ask String qui sera print afin de guider l'utilisateur
	 * @return Int
	 */
	public static int scanInt(String ask) {

		System.out.println(ask);
		return scanInt();

	}

	/**
	 * Version Surchargée de scanInt prenant en compte les erreur du type
	 * d'information Et des bornes supérieurs et inférieurs inclus
	 * 
	 * @param ask,      le string à afficher
	 * @param borneInf, la borne inférieure (incluse)
	 * @param borneSup, la borne supérieure (incluse)
	 * @return Le nombre récupéré
	 */

	public static int scanInt(String ask, int borneInf, int borneSup) {

		// on défini resultat a une valeur provocant un false dans le do while
		int resultat = borneInf - 1;

		do {

			resultat = scanInt(ask);

			// Dans le cas ou le nombre n'est pas entre les bornes
			if (!(resultat >= borneInf && resultat < borneSup)) {
				System.out.println("Le nombre n'est pas inclus entre " + borneInf + " et " + borneSup);
			} // EO IF

			// Condition tant que resultat n'est pas compris entre les deux bornes inclues
		} while (!(resultat >= borneInf && resultat < borneSup));

		// On renvoie le résultat
		return resultat;
	} // EO SCAN_INT(BORNES)

	/**
	 * Permet de renvoyer un long incrit par l'utilisateur
	 * TODO Mettre a jour avec exceptions
	 * @param ask String qui sera print afin de guider l'utilisateur
	 * @return long
	 */
	public static long scanLong(String ask) {

		System.out.println(ask);
		long longret = ScanWithLabel.scanner.nextLong();
		return longret;
	} // EO scanLong

	/**
	 * Permet de renvoyer un double incrit par l'utilisateur
	 * TODO Mettre a jour avec exceptions
	 * @param ask String qui sera print afin de guider l'utilisateur
	 * @return double
	 */
	public static double scanDouble(String ask) {

		System.out.println(ask);
		double doubleret = ScanWithLabel.scanner.nextDouble();
		return doubleret;
	} // EO scanDouble

}// EO Classe ScanWithLabel
