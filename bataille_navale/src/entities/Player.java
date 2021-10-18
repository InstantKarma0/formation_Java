package entities;

import util.AsciiConvert;
import util.Directions;
import util.ObstacleDetect;
import util.OverFlowDetect;
import util.ScanWithLabel;


public class Player {
	
	// TODO DOC

	protected int hitpoints = 17;
	protected int[] shipsize = {5,4,3,3,2};
	protected String[] shipname = {
			"Porte Avion",
			"Croiseur",
			"Contre-torpilleur","Contre-torpilleur",
			"Torpilleur"};
	protected int[][] shippos = new int[10][10];
	protected int[][] hitpos = new int[10][10];
	protected int[] lastpos = new int[2];

	
	
	
	/**
	 * 
	 */
	public void placement() {
		for (int i = 0; i < (this.shipsize.length); i++) {
			
			int [] tborient = {};
			int ligne = 0;
			int colonne = 0;
			boolean okposinput = false;
			while (okposinput == false) {
				System.out.println(this.shipname[i]
						+ " Taille: "
						+ this.shipsize[i]
						+ " cases.");
				ligne = AsciiConvert.asciiToInt(ScanWithLabel.scanLowerChar("Indiquez la lettre de la ligne"));
				colonne = ScanWithLabel.scanInt("Indiquez le numéro de la colonne") - 1;
				
				// Detection emplacement déjà occupé
				
				if (this.shippos[ligne][colonne] == 1) {
					System.out.println("Cet emplacement est déjà occupé par un autre bateau.\n" +
							"Veuillez en choisir un autre.\n"); 
					continue; 
				}
				
				// Detection Hors Grille
				int[] directions = OverFlowDetect.allDetect(colonne, ligne, this.shipsize[i]);
				// Detection Colision avec Autres Bateaux
				directions = ObstacleDetect.allDetect(colonne, ligne, shipsize[i], shippos, directions);
				
				// Verification du nombre d'orientations possibles
				try {
					tborient = Directions.nbDirec(directions);
				} catch (Exception e) {
					System.out.println("Nous ne pouvons pas placer le bateau depuis ses coordonées.\n"
							+ "D'autres bateaux entrent en colision.\n"
							+ "Veuillez Choisir de nouvelles coordonées\n");
					continue;
				} // EO Try
				okposinput = true;
				
				
				
			} // EO While
			int orientation = -1;
			boolean validinput = false;
			while (validinput == false) {
				orientation = Directions.menuDirec();
				for (int y = 0; y < tborient.length; y++) {
					if (orientation == tborient[y]) {
						validinput = true;
						break;
					}
				} // EO For
				
				if (validinput == true) {
					continue;
				} else {
					System.out.println("L'orientation saisie n'est pas une orientation valide.\n");
				} // EO If
					
			}// EO While
			
			
			addShip(shipsize[i], colonne, ligne, orientation);
			// TODO Verification Globale
			
		} // EO for
			
				
	}
	
	// Ajout des coordonees des bateaux
	public void addShip(int shipsize, int colonne, int ligne, int orientation) {
		int[][] shippos = getShipPos();
		
		switch (orientation) {
		
		// Orientation Gauche
		case 0:
			for (int i = colonne; i > colonne - shipsize; i--) {
				shippos[ligne][i] = 1;
			}
			break;
			
		// Orientation Droite
		case 1:
			for (int i = colonne; i < colonne + shipsize; i++) {
				shippos[ligne][i] = 1;
			}
			break;
			
		// Orientation Haut
		case 2:
			for (int i = ligne; i > ligne - shipsize; i--) {
				
				shippos[i][colonne] = 1;
			}
			break;
			
		// Orientation Bas
		case 3:
			for (int i = ligne; i < ligne + shipsize; i++) {
				shippos[i][colonne] = 1;
			}
			break;
		}
		setShippos(shippos);
	}
	
	
	public int[] fireAim() {
		// TODO Boucle vérification
		int[] fireArray = new int[2];
		System.out.println("Entrez les coordonées de tir.");
		fireArray[0] = AsciiConvert.asciiToInt(ScanWithLabel.scanLowerChar("Indiquez la lettre de la ligne"));
		fireArray[1] = ScanWithLabel.scanInt("Indiquez le numéro de la colonne") - 1;
		
		return fireArray;
	}
	
//------------------------------------------------------------------------------
								//Getter et Setter
	// Getter shipPos
	public int[][] getShipPos() {
		return this.shippos;
	}
	
	// Getter hitPos
	public int[][] getHitPos() {
		return this.hitpos;
	}
 	
	
	// Setter Hitpoints
	public void setHitpoints(int newValue) {
		this.hitpoints = newValue;
	}
	
	// Getter Hitpoints
	public int getHitpoints() {
		return this.hitpoints;
	}
	
	// Hitpoints--
	public void decrHitpoints(int decreaseValue) {
		this.hitpoints = this.hitpoints - decreaseValue;
	}
	
	// Setter Shippos
	public void setShippos(int[][] newArray) {
		this.shippos = newArray;
	}
	
	// Adder tir dans hitpos
	public void addfirepos(int[] fireArray, int cas) {
		
		switch (cas) {
		
		case 0:
			this.hitpos[fireArray[0]][fireArray[1]] = 2;
			break;
		case 1:
			this.hitpos[fireArray[0]][fireArray[1]] = 3;
			break;
		}
		
	}

	public int checkfire(int[] fireArray) {
		
		if (this.shippos[fireArray[0]][fireArray[1]] == 1) {
			this.shippos[fireArray[0]][fireArray[1]] = 3;
			this.decrHitpoints(1);
			return 1;
		}
		this.shippos[fireArray[0]][fireArray[1]] = 2;
		return 0;
		
	}
	
	
	
}
