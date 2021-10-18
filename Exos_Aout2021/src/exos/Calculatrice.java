package exos;

import java.math.BigInteger;

import util.ScanWithLabel;


public class Calculatrice {

	/**
	 * Classe permettant de diriger l'utilisateur sur les differentes
	 * fontionnalitees de la calculatrice
	 */
	public static void main() {
		
		// On affiche le menu et on demande le choix de l'utilisateur
		int choix = ScanWithLabel.scanInt(menu() + "Choisissez l'opération", 1, 6);
		
		// Switch en fonction du choix de l'utilisateur
		switch (choix) {
		
		// Cas 1 = Addition
		case 1:
			addition();
			break;
		
		// Cas 2 = Soustraction
		case 2:
			soustraction();
			break;
		
		// Cas 3 = Multiplication
		case 3:
			multiplication();
			break;
			
		// Cas 4 = Division
		case 4:
			division();
			break;
		
		// Cas 5 = Modulo
		case 5:
			modulo();
			break;
		
		// Cas 6 = Factoriel
		case 6:
			factoriel();
			break;
		}
		
	}
	
	public static String menu() {
		String menu = "Menu: \n"
				+ "1) Addition \n"
				+ "2) Soustration \n"
				+ "3) Multiplication \n"
				+ "4) Division \n"
				+ "5) Modulo \n"
				+ "6) Factoriel \n\n";
		return menu;
		
	}
	
	public static void addition() {
		// On demande deux nombres a l'utilisateur
		int a =ScanWithLabel.scanInt("Premier nombre =");
		int b =ScanWithLabel.scanInt("Second nombre =");
		// On affiche le resultat de l'addition
		System.out.println("Le résultat de " + a + " + " + b + " est " + (a+b));
	}
	
	public static void soustraction() {
		// On demande deux nombres a l'utilisateur
		int a =ScanWithLabel.scanInt("Premier nombre =");
		int b =ScanWithLabel.scanInt("Second nombre =");
		// On affiche le resultat de la soustraction
		System.out.println("Le résultat de " + a + " - " + b + " est " + (a-b));
	}
	
	public static void multiplication() {
		// On demande deux nombres a l'utilisateur
		int a =ScanWithLabel.scanInt("Premier nombre =");
		int b =ScanWithLabel.scanInt("Second nombre =");
		// On affiche le resultat de la multiplication
		System.out.println("Le résultat de " + a + " * " + b + " est " + (a*b));
	}
	
	public static void division() {
		// On demande la dividende et le diviseur a l'utilisateur
		int a =ScanWithLabel.scanInt("Dividende =");
		int b =ScanWithLabel.scanInt("Diviseur =");
		// Dans le cas ou le diviseur est 0
		if (b == 0) {
			// On affiche l'impossibilite de l'operation
			System.out.println("Il est impossible de diviser par 0 !");
			// Si le diviseur n'est pas 0
		} else {
			// On affiche le resultat de la division
			System.out.println("Le résultat de " + a + " / " + b + " est " + (a/b));
		}
		
	}
	
	public static void modulo() {
		// On demande deux nombres a l'utilisateur
		int a =ScanWithLabel.scanInt("Premier nombre =");
		int b =ScanWithLabel.scanInt("Second nombre =");
		// On affiche le resultat du modulo
		System.out.println("Le résultat de " + a + " % " + b + " est " + (a%b));
	}
	
	public static void factoriel() {
		
		// On demande un nombre a l'utilisateur
		int a = ScanWithLabel.scanInt("Nombre =");		
		
		// Si le nombre demande est 0 on retourne le resultat de !0
		if (a == 0) {
			System.out.println("Le résultat de !0 est 1");
		// Sinon
		} else {
			// On déclare un tres grand nombre
			BigInteger resultat = new BigInteger("1");
				
			// Boucle avec i allant de 1 au nombre demande inclu
			for (int i = 1; i <= a; i++) {
				// On multiplie le resultat de la boucle precedente avec i
				resultat = resultat.multiply(BigInteger.valueOf(i));
			}
			
			// On affiche le resultat du factoriel
			System.out.println("Le résultat de !" + a + " est " + resultat.toString());
		}

	}
	
	
}
