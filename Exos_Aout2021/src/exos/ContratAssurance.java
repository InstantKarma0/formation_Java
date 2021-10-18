package exos;

import util.ScanWithLabel;

public class ContratAssurance {
	
	//------------------------------------------------------------------------------
	
	//                        D�claration des Variables
	
	// Int Age correspond � l'age du b�n�ficiaire
	int age = -1;
	
	// Int dureePermis correspond � la dur�e en ann�e depuis l'obtention du permis
	int dureePermis = -1;
	
	// int nbAccident correspond au nombre d'accidents provoqu�s par le b�n�ficiare
	int nbAccident = -1;
	
	/* int dureeContrat correspond � la dur�e en annee depuis 
	*  que le b�n�ficiaire est assur� chez nous
	*/
	int dureeContrat = -1;
	
	// int numContrat correpond au type de contract du b�n�ficiaire
	int numContrat;
	
	// String[] typeContrats correspond aux noms des differents contrats
	static String[] typeContrats = {"Bleu", "Vert", "Orange", "Rouge"};
	
	// Int pts correspond au nombre de points par le systeme de points
	int pts = 1;
	
	//------------------------------------------------------------------------------
	
	/**
	 * Fonction Permettant de d�finir le type de contrat en fonction des
	 * donnees entrees par l'utilisateur
	 */
	public void choixContrat() {
		
		//----------------------------------------------------------------------
		
		//                    R�cup�ration des donn�es
		
		// On r�cup�re l'age de la personne
		while (this.age < 0) {
			this.age = ScanWithLabel.scanInt("Quel est votre age ? (en ann�es)");
		}
		
		// On r�cup�re la dur�e depuis l'obtention du permis
		while (dureePermis <= 0) {
			this.dureePermis = ScanWithLabel.scanInt("Depuis combien d'ann�es avez"
					+ " vous votre permis ?");
		}
		
		// On r�cup�re le nombre d'accidents causees
		while (nbAccident <= 0) {
			this.nbAccident = ScanWithLabel.scanInt("De combien d'accidents �tes "
					+ "vous reponsable ?");
		}
		
		// On r�cup�re la duree depuis le d�but de l'assurrance
		while (dureeContrat <= 0) {
			this.dureeContrat = ScanWithLabel.scanInt("Depuis combien d'ann�es"
					+ " �tes vous assurez ?");
		}
 
		//----------------------------------------------------------------------
		
		//                   TRAITEMENT DES DONNEES
		
		// Condition If Age inf�rieur � 25 ans et Dur�ePermis sup�rieur � 2 ans
		if (this.age < 25 && this.dureePermis < 2) {
			
			// Condition If le nombre d'accident est diff�rent de 0
			if (this.nbAccident != 0) {
				System.out.println("Nous ne voulons pas vous assurer.");
			
			// Si le nombre d'accident est �gal � 0
			} else {
				System.out.println("Nous vous proposons un contrat "
						+ typeContrats[3] + ".");
				// on affecte le numero de contrat correspondant (ici 3 = rouge)
				this.numContrat = 3;
				
			} // EO IF
		} // EO IF
		

		
		/*	Condition Si l'age est inf�rieur � 25 ans et dur�ePermis sup�rieur � 2 ans
		 * 									OU
		 *  Condition Si l'age est sup�rieur � 25 ans et dur�ePermis inf�rieur � 2 ans
		 */
		else if ((this.age < 25 && this.dureePermis >= 2) ||
				(this.age >= 25 && this.dureePermis < 2)) {
			
			// Switch en fonction du nombre d'accidents
			switch (this.nbAccident) {
			
				// Dans le cas o� nbAccident = 0
				case 0:
					System.out.println("Nous vous proposons un contrat "
							+ typeContrats[2] + ".");
					
					// on affecte le numero de contrat correspondant (ici 2 = orange)
					this.numContrat = 2;
					break; // EO CASE 0
					
				// Dans le cas o� nbAccident = 1
				case 1:
					System.out.println("Nous vous proposons un contrat "
							+ typeContrats[3] + ".");
					
					// on affecte le numero de contrat correspondant (ici 3 = rouge)
					this.numContrat = 3;
					break; // EO CASE 1
					
				// Dans le cas o� nbAccident est sup�rieur � 1
				default:
					System.out.println("Nous ne voulons pas vous assurer.");
				// EO DEFAULT
					
			} // EO SWITCH
			
		} // EO ELSE IF
		
		
		
		// Dans le cas o� Age sup�rieur � 25 ans et Dur�ePermis sup�rieur � 2 ans
		else {
			
			// Switch en fonction du nombre d'accidents
			switch (this.nbAccident) {
			
				// Dans le cas o� nbAccident = 0
				case 0:
					System.out.println("Nous vous proposons un contrat "
							+ typeContrats[1] + ".");
					
					// on affecte le numero de contrat correspondant (ici 1 = vert)
					this.numContrat = 1;
					break; // EO CASE 0
					
					
				// Dans le cas o� nbAccident = 1
				case 1:
					System.out.println("Nous vous proposons un contrat "
							+ typeContrats[2] + ".");
					
					// on affecte le numero de contrat correspondant (ici 2 = orange)
					this.numContrat = 2;
					break; // EO CASE 1
					
				// Dans le cas o� nbAccident = 2
				case 2:
					System.out.println("Nous vous proposons un contrat "
							+ typeContrats[3] + ".");
					
					// on affecte le numero de contrat correspondant (ici 3 = rouge)
					this.numContrat = 3;
					break; // EO CASE 2
					
				// Dans le cas o� nbAccident sup�rieur a 2
				default:
					System.out.println("Nous ne voulons pas vous assurer.");
				// EO DEFAULT
					
			}// EO SWITCH
		
		} // EO ELSE
		
	} // EO CHOIX_CONTRAT
	
	
	
	/**
	 *  Fonction Permettant de d�finir le type de contrat en s'appuyant sur un
	 *  syst�me de points defini par les donnees entrees par l'utilisateur
	 */
	public void choixContratByPts() {
		// ----------------------------------------------------------------------

		// 						R�cup�ration des donn�es

		// On r�cup�re l'age de la personne
		while (this.age < 0) {
			this.age = ScanWithLabel.scanInt("Quel est votre age ? (en ann�es)");
		}

		// On r�cup�re la dur�e depuis l'obtention du permis
		while (dureePermis <= 0) {
			this.dureePermis = ScanWithLabel.scanInt("Depuis combien d'ann�es avez" 
				+ " vous votre permis ?");
		}

		// On r�cup�re le nombre d'accidents causees
		while (nbAccident <= 0) {
			this.nbAccident = ScanWithLabel.scanInt("De combien d'accidents �tes "
				+ "vous reponsable ?");
		}

		// On r�cup�re la duree depuis le d�but de l'assurrance
		while (dureeContrat <= 0) {
			this.dureeContrat = ScanWithLabel.scanInt("Depuis combien d'ann�es"
				+ " �tes vous assurez ?");
		}

		// ----------------------------------------------------------------------
		
		//						Traitement des donnees
	
		// Condition If Age inf�rieur � 25 ans
		if (this.age < 25) {
			
			// On ajoute un point
			this.pts++;
			
		} // EO IF
		
		
		// Condition If DureePermis inferieur a 2 ans
		if (this.dureePermis < 2) {
			
			// On ajoute un point
			this.pts++;
			
		} // EO IF
		
		
		// Condition If nombre d'accidents est diff�rent de 0
		if (this.nbAccident != 0) {
			
			// On ajoute des points equivalents au nombre d'accidents
			this.pts = this.pts + this.nbAccident;
			
		} // EO IF
		
		
		
		
		// Switch en fonction du nombre de points apr�s calculs precedents
		switch (this.pts) {
		
		
			// Dans le cas o� pts = 1
			case 1:
				System.out.println("Nous vous proposons un contrat "
						+ typeContrats[1] + ".");
				
				// on affecte le numero de contrat correspondant (ici 1 = vert)
				this.numContrat = 1;
				break; // EO CASE 1
				
				
			// Dans le cas o� pts = 2
			case 2:
				System.out.println("Nous vous proposons un contrat "
						+ typeContrats[2] + ".");
				
				// on affecte le numero de contrat correspondant (ici 2 = orange)
				this.numContrat = 2;
				break; // EO CASE 2
				
				
			// Dans le cas o� pts = 3
			case 3:
				System.out.println("Nous vous proposons un contrat "
						+ typeContrats[3] + ".");
				
				// on affecte le numero de contrat correspondant (ici 3 = rouge)
				this.numContrat = 3;
				break; // EO CASE 3
				
				
			// Dans le cas o� pts superieur a 3
			default:
				System.out.println("Nous ne voulons pas vous assurer.");
				
		} // EO SWITCH
		
		this.contratAugmentation();
		
		
	} // EO CHOIX_CONTRAT_BY_PTS
	
	
	
	/**
	 * Fonction Permettant de v�rifier 
	 * Si la duree depuis laquellele b�n�ficiaire est assur� > 5 ans
	 *  
	 * Et dans ce cas lui changer son contrat pour un autre contrat
	 * plus avantageux
	 */
	public void contratAugmentation() {
		
		// Condition si dureeContrat sup�rieur � 5 ans
		if (this.dureeContrat >= 5) {
			// On change son type de contrat (plus numContrat est petit et mieux le contrat est
			this.numContrat--;
			System.out.println("F�licitation! Pour vous remercier de "
					+ "votre fid�lit�, votre contract de type "
					+ typeContrats[this.numContrat + 1]
					+ " est pass� en contract de type "
					+ typeContrats[this.numContrat]
					+ " .");
			
		} else {
			System.out.println("Apr�s votre 5�me ann�e chez nous, vous pouvez "
					+ "profiter d'un contrat pr�f�rentiel. Il vous reste encore"
					+ " " + (5-this.dureeContrat) + " ann�es afin de pouvoir"
					+ " en b�n�ficier.");
		
		} // EO IF
		
	} // EO CONTRATAUGMENTATION
	
} // EO CONTRATASSURANCE
