package util;

import java.util.Scanner;

public class ScanWithLabel {

	// Variable Globale 
	public static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Permet de renvoyer un charactere inscrit par l'utilisateur
	 * @param ask String qui sera print afin de guider l'utilisateur
	 * @return charactere d'indice 0
	 */
	public static char scanChar(String ask) {
			
		System.out.println(ask);
		char strret = ScanWithLabel.scanner.next().charAt(0);
		return strret;
		
	}// EO Methode scanChar

	/**
	 * Permet de renvoyer un charactere inscrit par l'utilisateur
	 * @param ask String qui sera print afin de guider l'utilisateur
	 * @return charactere d'indice 0
	 */
	public static char scanLowerChar(String ask) {
			
		System.out.println(ask);
		char charret = ScanWithLabel.scanner.next().charAt(0);
		charret = Character.toLowerCase(charret);
		return charret;
		
	}// 
	
	/**
	 * Permet de renvoyer un String incrit par l'utilisateur
	 * @param ask String qui sera print afin de guider l'utilisateur
	 * @return String
	 */
	public static String scanString(String ask) {
		
		System.out.println(ask);
		String strret = ScanWithLabel.scanner.next();
		return strret;
		
	}// EO Methode scanString
	
	
	/**
	 * Permet de renvoyer un Int incrit par l'utilisateur
	 * @param ask String qui sera print afin de guider l'utilisateur
	 * @return Int
	 */
	public static int scanInt(String ask) {
		
		System.out.println(ask);
		int intret = ScanWithLabel.scanner.nextInt();
		return intret;
	}
	
	
	/**
	 * Permet de renvoyer un long incrit par l'utilisateur
	 * @param ask String qui sera print afin de guider l'utilisateur
	 * @return long
	 */
	public static long scanLong(String ask) {
		
		System.out.println(ask);
		long longret = ScanWithLabel.scanner.nextLong();
		return longret;
	}
	
	
	/**
	 * Permet de renvoyer un double incrit par l'utilisateur
	 * @param ask String qui sera print afin de guider l'utilisateur
	 * @return double
	 */
	public static double scanDouble(String ask) {
		
		System.out.println(ask);
		double doubleret = ScanWithLabel.scanner.nextDouble();
		return doubleret;
	}
	
	
	
}// EO Classe ScanWithLabel
