package exos;

import util.ScanWithLabel;

public class ContratAssurance {
	
	//------------------------------------------------------------------------------
	
	//                        Déclaration des Variables
	
	// Int Age correspond à l'age du bénéficiaire
	int age = -1;
	
	// Int dureePermis correspond à la durée en année depuis l'obtention du permis
	int dureePermis = -1;
	
	// int nbAccident correspond au nombre d'accidents provoqués par le bénéficiare
	int nbAccident = -1;
	
	/* int dureeContrat correspond à la durée en annee depuis 
	*  que le bénéficiaire est assuré chez nous
	*/
	int dureeContrat = -1;
	
	// int numContrat correpond au type de contract du bénéficiaire
	int numContrat;
	
	// String[] typeContrats correspond aux noms des differents contrats
	static String[] typeContrats = {"Bleu", "Vert", "Orange", "Rouge"};
	
	// Int pts correspond au nombre de points par le systeme de points
	int pts = 1;
	
	//------------------------------------------------------------------------------
	
	/**
	 * Fonction Permettant de définir le type de contrat en fonction des
	 * donnees entrees par l'utilisateur
	 */
	public void choixContrat() {
		
		//----------------------------------------------------------------------
		
		//                    Récupération des données
		
		// On récupère l'age de la personne
		while (this.age < 0) {
			this.age = ScanWithLabel.scanInt("Quel est votre age ? (en années)");
		}
		
		// On récupère la durée depuis l'obtention du permis
		while (dureePermis <= 0) {
			this.dureePermis = ScanWithLabel.scanInt("Depuis combien d'années avez"
					+ " vous votre permis ?");
		}
		
		// On récupère le nombre d'accidents causees
		while (nbAccident <= 0) {
			this.nbAccident = ScanWithLabel.scanInt("De combien d'accidents êtes "
					+ "vous reponsable ?");
		}
		
		// On récupère la duree depuis le début de l'assurrance
		while (dureeContrat <= 0) {
			this.dureeContrat = ScanWithLabel.scanInt("Depuis combien d'années"
					+ " êtes vous assurez ?");
		}
 
		//----------------------------------------------------------------------
		
		//                   TRAITEMENT DES DONNEES
		
		// Condition If Age inférieur à 25 ans et DuréePermis supérieur à 2 ans
		if (this.age < 25 && this.dureePermis < 2) {
			
			// Condition If le nombre d'accident est différent de 0
			if (this.nbAccident != 0) {
				System.out.println("Nous ne voulons pas vous assurer.");
			
			// Si le nombre d'accident est égal à 0
			} else {
				System.out.println("Nous vous proposons un contrat "
						+ typeContrats[3] + ".");
				// on affecte le numero de contrat correspondant (ici 3 = rouge)
				this.numContrat = 3;
				
			} // EO IF
		} // EO IF
		

		
		/*	Condition Si l'age est inférieur à 25 ans et duréePermis supérieur à 2 ans
		 * 									OU
		 *  Condition Si l'age est supérieur à 25 ans et duréePermis inférieur à 2 ans
		 */
		else if ((this.age < 25 && this.dureePermis >= 2) ||
				(this.age >= 25 && this.dureePermis < 2)) {
			
			// Switch en fonction du nombre d'accidents
			switch (this.nbAccident) {
			
				// Dans le cas où nbAccident = 0
				case 0:
					System.out.println("Nous vous proposons un contrat "
							+ typeContrats[2] + ".");
					
					// on affecte le numero de contrat correspondant (ici 2 = orange)
					this.numContrat = 2;
					break; // EO CASE 0
					
				// Dans le cas où nbAccident = 1
				case 1:
					System.out.println("Nous vous proposons un contrat "
							+ typeContrats[3] + ".");
					
					// on affecte le numero de contrat correspondant (ici 3 = rouge)
					this.numContrat = 3;
					break; // EO CASE 1
					
				// Dans le cas où nbAccident est supérieur à 1
				default:
					System.out.println("Nous ne voulons pas vous assurer.");
				// EO DEFAULT
					
			} // EO SWITCH
			
		} // EO ELSE IF
		
		
		
		// Dans le cas où Age supérieur à 25 ans et DuréePermis supérieur à 2 ans
		else {
			
			// Switch en fonction du nombre d'accidents
			switch (this.nbAccident) {
			
				// Dans le cas où nbAccident = 0
				case 0:
					System.out.println("Nous vous proposons un contrat "
							+ typeContrats[1] + ".");
					
					// on affecte le numero de contrat correspondant (ici 1 = vert)
					this.numContrat = 1;
					break; // EO CASE 0
					
					
				// Dans le cas où nbAccident = 1
				case 1:
					System.out.println("Nous vous proposons un contrat "
							+ typeContrats[2] + ".");
					
					// on affecte le numero de contrat correspondant (ici 2 = orange)
					this.numContrat = 2;
					break; // EO CASE 1
					
				// Dans le cas où nbAccident = 2
				case 2:
					System.out.println("Nous vous proposons un contrat "
							+ typeContrats[3] + ".");
					
					// on affecte le numero de contrat correspondant (ici 3 = rouge)
					this.numContrat = 3;
					break; // EO CASE 2
					
				// Dans le cas où nbAccident supérieur a 2
				default:
					System.out.println("Nous ne voulons pas vous assurer.");
				// EO DEFAULT
					
			}// EO SWITCH
		
		} // EO ELSE
		
	} // EO CHOIX_CONTRAT
	
	
	
	/**
	 *  Fonction Permettant de définir le type de contrat en s'appuyant sur un
	 *  système de points defini par les donnees entrees par l'utilisateur
	 */
	public void choixContratByPts() {
		// ----------------------------------------------------------------------

		// 						Récupération des données

		// On récupère l'age de la personne
		while (this.age < 0) {
			this.age = ScanWithLabel.scanInt("Quel est votre age ? (en années)");
		}

		// On récupère la durée depuis l'obtention du permis
		while (dureePermis <= 0) {
			this.dureePermis = ScanWithLabel.scanInt("Depuis combien d'années avez" 
				+ " vous votre permis ?");
		}

		// On récupère le nombre d'accidents causees
		while (nbAccident <= 0) {
			this.nbAccident = ScanWithLabel.scanInt("De combien d'accidents êtes "
				+ "vous reponsable ?");
		}

		// On récupère la duree depuis le début de l'assurrance
		while (dureeContrat <= 0) {
			this.dureeContrat = ScanWithLabel.scanInt("Depuis combien d'années"
				+ " êtes vous assurez ?");
		}

		// ----------------------------------------------------------------------
		
		//						Traitement des donnees
	
		// Condition If Age inférieur à 25 ans
		if (this.age < 25) {
			
			// On ajoute un point
			this.pts++;
			
		} // EO IF
		
		
		// Condition If DureePermis inferieur a 2 ans
		if (this.dureePermis < 2) {
			
			// On ajoute un point
			this.pts++;
			
		} // EO IF
		
		
		// Condition If nombre d'accidents est différent de 0
		if (this.nbAccident != 0) {
			
			// On ajoute des points equivalents au nombre d'accidents
			this.pts = this.pts + this.nbAccident;
			
		} // EO IF
		
		
		
		
		// Switch en fonction du nombre de points après calculs precedents
		switch (this.pts) {
		
		
			// Dans le cas où pts = 1
			case 1:
				System.out.println("Nous vous proposons un contrat "
						+ typeContrats[1] + ".");
				
				// on affecte le numero de contrat correspondant (ici 1 = vert)
				this.numContrat = 1;
				break; // EO CASE 1
				
				
			// Dans le cas où pts = 2
			case 2:
				System.out.println("Nous vous proposons un contrat "
						+ typeContrats[2] + ".");
				
				// on affecte le numero de contrat correspondant (ici 2 = orange)
				this.numContrat = 2;
				break; // EO CASE 2
				
				
			// Dans le cas où pts = 3
			case 3:
				System.out.println("Nous vous proposons un contrat "
						+ typeContrats[3] + ".");
				
				// on affecte le numero de contrat correspondant (ici 3 = rouge)
				this.numContrat = 3;
				break; // EO CASE 3
				
				
			// Dans le cas où pts superieur a 3
			default:
				System.out.println("Nous ne voulons pas vous assurer.");
				
		} // EO SWITCH
		
		this.contratAugmentation();
		
		
	} // EO CHOIX_CONTRAT_BY_PTS
	
	
	
	/**
	 * Fonction Permettant de vérifier 
	 * Si la duree depuis laquellele bénéficiaire est assuré > 5 ans
	 *  
	 * Et dans ce cas lui changer son contrat pour un autre contrat
	 * plus avantageux
	 */
	public void contratAugmentation() {
		
		// Condition si dureeContrat supérieur à 5 ans
		if (this.dureeContrat >= 5) {
			// On change son type de contrat (plus numContrat est petit et mieux le contrat est
			this.numContrat--;
			System.out.println("Félicitation! Pour vous remercier de "
					+ "votre fidélité, votre contract de type "
					+ typeContrats[this.numContrat + 1]
					+ " est passé en contract de type "
					+ typeContrats[this.numContrat]
					+ " .");
			
		} else {
			System.out.println("Après votre 5ème année chez nous, vous pouvez "
					+ "profiter d'un contrat préférentiel. Il vous reste encore"
					+ " " + (5-this.dureeContrat) + " années afin de pouvoir"
					+ " en bénéficier.");
		
		} // EO IF
		
	} // EO CONTRATAUGMENTATION
	
} // EO CONTRATASSURANCE
