package entities;

import java.util.ArrayList;

import util.Directions;
import util.ObstacleDetect;
import util.OverFlowDetect;
import util.RndGen;


/**
 * Classe Heritee de Player
 * Representant l'IA controlee par l'ordinateur
 * @author Corentin.P
 *
 */
public class Ia extends Player {

	protected int[] firedirection;
	protected int lastdirection = -1;
	protected int finaldirection = -1;
	protected int distancetir = 1;
	protected int inversedirection = -1;
	protected int lastfire;

	
	/**
	 * Fonction permettant de remplir le tableau avec les positions des bateaux
	 * Generes de facon random
	 */
	public void placement() {
		// TODO DOC

		// Boucle For afin de parcourir shipsize
		for (int i = 0; i < (this.shipsize.length); i++) {

			int[] tborient = {};
			int ligne = 0;
			int colonne = 0;
			boolean okposinput = false;
			while (okposinput == false) {
				
				
				// Generation de deux chiffres entre 0 et 9
				ligne = RndGen.getRandomNumber(0, 10);
				colonne = RndGen.getRandomNumber(0, 10);

				// Detection Hors Grille
				int[] directions = OverFlowDetect.allDetect(colonne, ligne, this.shipsize[i]);
				// Detection Colision avec Autres Bateaux
				directions = ObstacleDetect.allDetect(colonne, ligne, shipsize[i], shippos, directions);

				// Verification du nombre d'orientations possibles
				try {
					tborient = Directions.nbDirec(directions, 1);
				} catch (Exception e) {
					continue;
				} // EO Try
				okposinput = true;

			} // EO While
			int orientation = -1;

			boolean validinput = false;
			
			// Boucle Selection Direction Random
			while (validinput == false) {
				orientation = RndGen.getRandomNumber(0, 4);
				
				// Boucle Parcourir tableau tborient
				for (int y = 0; y < tborient.length; y++) {
					if (orientation == tborient[y]) {
						validinput = true;
						break;
					}
				} // EO For


			} // EO While
			
			// Ajout des coordonees du bateau dans le tableau
			addShip(shipsize[i], colonne, ligne, orientation);
			

		} // EO for

	}

	

	/**
	 * Fonction de Controle de tir de l'IA
	 * En fonction de divers parametres
	 */
	public int[] fireAim() {
		int[] fireArray = new int[2];
		
		// Nouvelle fonction de controle de tir de l'ia (en developpement)
			
			
		// switch , 0 = false, 1 = true
		switch (this.lastfire) {
		// Cas où le dernier tir est un raté
		case 0:
			
			// Si InverseDirection est défini
			if (this.inversedirection != -1) {
				// On reinitialise InverseDirection
				this.inversedirection = -1;
				// On tir aléatoirement
				return getFireCoordo();
					
			} // EO if
			
			// Si FinalDirection est défini
			if (this.finaldirection != -1) {
				
				/*
				 * Switch en fonction de FinalDirection
				 * Définit InverseDirection la direction inverse de FinalDirection
				 */
				switch (this.finaldirection) {
					case 0:
						this.inversedirection = 1;
						break;
					case 1:
						this.inversedirection = 0;
						break;
					case 2:
						this.inversedirection = 3;
						break;
					case 3:
						this.inversedirection = 2;
						break;
				} // EO switch
				// On reinitialise FinalDirection
				this.finaldirection= -1;
				// On reset DistanceTir à 1
				this.distancetir = 1;
				// On récupère les coordonnees de tir avec inversedirection et distancetir
				return getFireCoordo(this.lastpos, this.inversedirection, this.distancetir);
			} // EO if
				
			if (this.firedirection != null) {
				
				
				// TODO retirer puis verifier autres directions
				break;
			}// EO if
				
			// Random Tir
			this.getFireCoordo();
			break;

			
			
			
		// Cas où le dernier tir est un touché
		case 1:
				
			// Si int InverseDirection est défini
			if (this.inversedirection != -1) {
				// TODO incrémenter l'indice de tir
				this.distancetir++;
				this.lastpos = getFireCoordo(this.lastpos, this.inversedirection, this.distancetir);
				return this.lastpos;
				
			} // EO if
				
			// Si int FinalDirection est défini
			if (this.finaldirection != -1) {
				this.distancetir++;
				this.lastpos = getFireCoordo(this.lastpos, this.finaldirection, this.distancetir);
				return this.lastpos;
			} // EO if
				
				
			// Si int[] FireDirection est définis
			if (this.firedirection != null) {
				this.finaldirection = this.lastdirection;
				this.firedirection = null;
				this.distancetir++;
				this.lastpos = getFireCoordo(this.lastpos, this.lastdirection, this.distancetir);
				return this.lastpos;
					
			} // EO if
				
			// Cas où rien n'est definit (firedirection,finaldirection,inversedirection)
			this.firedirection = OverFlowDetect.allDetect(this.lastpos, 1);
			this.getFireCoordo(lastpos, firedirection);
				
				
				
			break;
			} // EO switch

		this.lastpos=fireArray;
		return fireArray;

	}
	
	// Adder tir dans hitpos
		public void addfirepos(int[] fireArray, int cas) {
			
			switch (cas) {
			
			case 0:
				this.hitpos[fireArray[0]][fireArray[1]] = 2;
				this.lastfire = 0;
				break;
			case 1:
				this.hitpos[fireArray[0]][fireArray[1]] = 3;
				this.lastfire = 1;
				break;
			}
			
		}
	
	
//------------------------------------------------------------------------------
	
	
	public void setLastDirection(int newdirection) {
		this.lastdirection = newdirection;
	}
	
	
	
	
//------------------------------------------------------------------------------
	/*
	 * Regroupement des fonctions permettant de tirer 
	 * avec divers parametres via surcharge de parametres
	 * 
	 * */
	
	// Version random
	public int[] getFireCoordo() {
		int[] fireArray = new int[2];
		boolean verif = true;
		while (verif) {
			
		
			fireArray[0] = RndGen.getRandomNumber(1, 10); 
			fireArray[1] = RndGen.getRandomNumber(1, 10); 
			if (this.hitpos[fireArray[0]][fireArray[1]] == 0) {
				verif = false;
			}
		}
		
		return fireArray;
	}
	
	
	// Version avec des coordonees et un tableau de direction
	public int[] getFireCoordo(int[]lastpos, int[] firedirection) {
		int[] fireArray = new int[2];
		ArrayList<Integer> listdirec = new ArrayList<Integer>();
		for (int i = 0; i < firedirection.length ;i++) {
			if (firedirection[i] == 1) {
				listdirec.add(i);
			}
		}
		setLastDirection(RndGen.getRandomNumber(0, listdirec.size()));
		return fireArray;
	}
	
	
	
	// Versuion avec coordonnees, direction et distance de tir
	public int[] getFireCoordo(int[] lastpos, int direction, int distancetir) {
		// TODO Erreur, OverWrite de lastpos avec distancetir
		switch (direction) {
		case 0:
			lastpos[1] = lastpos[1] - distancetir;
			break;
		case 1:
			lastpos[1] = lastpos[1] + distancetir;
			break;
		case 2:
			lastpos[0] = lastpos[0] - distancetir;
			break;
		case 3:
			lastpos[0] = lastpos[0] + distancetir;
			break;
		}
		return lastpos;
	}
}
