package exos;

import util.ScanWithLabel;

public class VerificationDate {
	
	// jour correspond au numero du jour
	int jour = 0;
	
	// mois correspond au numero du mois
	int mois = 0;
	
	// annee correspond au numero de l'annee
	int annee = 0;
	
	public void verification() {
		
		//----------------------------------------------------------------------
		
		//						Recuperation de donnees
		
		// On récupère le numéro du jour
		while (!(jour > 0 && jour < 32)) {
			this.jour = ScanWithLabel.scanInt("Veuillez indiquer le numéro du jour");
		}
		
		// On récupère le numéro du mois
		while (!(mois > 0 && mois < 13)) {
			this.mois = ScanWithLabel.scanInt("Veuillez indiquer le numéro du mois");
		}
		
		// On récupère le numéro de l'annee
		this.annee = ScanWithLabel.scanInt("Veuillez indiquer l'annee");
		
		//----------------------------------------------------------------------
		
		// maxdays correspond au nombre de jour maximum dans un mois
		int maxdays = 0;
		
		switch (mois) {
			case 1,3,5,7,8,10,12:
				maxdays = 31;
				break;
			case 4,6,9,11:
				maxdays = 30;
				break;
			case 2:
				maxdays = this.verifFevrier();
		}
		
		/* On verifie si le numero donnee par l'utilisateur est inferieur ou
		*  egal au nombre maximum de jour dans le mois
		*/
		// Si le numero du jour est inferieur ou egal a maxdays
		if (this.jour <= maxdays) {
			System.out.println("La date est valide");
		// Si le numero du jour est superieur ou egal a maxdays
		} else {
			System.out.println("La date n'est pas valide");
		} // EO IF
		
		
	} // EO VERIFICATION
	
	
	
	
	public int verifFevrier() {
		
		// On defini la variable max correspondant au nombre maximum dans un mois
		int max = 0;
		
		/*
		 * DANS LE CAS OU LE MOIS EST FEVRIER (MOIS = 2)
		 * Il faut verifier si l'annee est bissextile ou non
		 */
		
		// Dans le cas ou l'annee est divisible par 4 ou 400 = bissextile
		if (this.mois % 400 == 0 || this.mois % 4 == 0) {
			
			// On affecte 28 a maxdays
			max = 28;
		} // EO IF
		
		// Cas particulier si l'annee est divisible par 100 = non bissextile
		if (this.mois % 100 == 0) {
			
			// On affecte 29 a maxdays
			max = 29;
		} // EO IF
		
		// On renvoie la valeur max
		return max;
	}
	
} // EO CLASSE
