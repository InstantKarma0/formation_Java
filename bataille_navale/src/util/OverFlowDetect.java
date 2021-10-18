package util;
/**
 * 
 * @author Corentin 2021
 *	Classe Contenant des fonction permettant de verifier si la 
 *	position calculee est contenue dans une grille 10x10
 */

public class OverFlowDetect {
	
	/**
	 * Fonction permettant de retourner un tableau avec les posibilitees
	 * de direction en fonction d'une position et d'une distance de tir
	 * @param pos Tableau d'int de taille 2 representant la position d'un tir
	 * @param distance , int la distance de tir
	 * @return int[] un tableau de taille 4
	 */

	public static int[] allDetect(int[] pos, int distance) {
		int[] posibilities = new int[4];
		posibilities[0] = leftDetect(pos[1], distance);
		posibilities[1] = rightDetect(pos[1], distance);
		posibilities[2] = upDetect(pos[0], distance);
		posibilities[3] = downDetect(pos[0], distance);
		return posibilities;
	}
	
	
	/**
	 * Fonction permettant de vérifier si les coordonnees calculees par la 
	 * distance et la position du tir ne sortent pas de la grille 10x10
	 * 
	 * @param tir , int[] Position du tir
	 * @param distance, int La distance du tir
	 * @param direction, int La direction du tir
	 * @return
	 */
	public static int oneDetect(int[] tir, int distance, int direction) {
		
		/* Switch en fonction de la direction proposee
		 * 0 = gauche
		 * 1 = droite
		 * 2 = haut
		 * 3 = bas
		 */
		
		switch (direction) {
		case 0:
			return leftDetect(tir[1], distance);
		case 1:
			return rightDetect(tir[1], distance);
			
		case 2:
			return upDetect(tir[0], distance);

		case 3:
			return downDetect(tir[0], distance);
		default:
			return 2;
		}
	}
	
	
	
	
	/**
	 * 
	 * @param colonne
	 * @param ligne
	 * @param shipsize
	 * @return
	 */
	
	public static int[] allDetect(int colonne, int ligne, int shipsize) {
		int[] posibilities = new int[4];
		posibilities[0] = leftDetect(colonne, shipsize);
		posibilities[1] = rightDetect(colonne, shipsize);
		posibilities[2] = upDetect(ligne, shipsize);
		posibilities[3] = downDetect(ligne, shipsize);
		return posibilities;
	}
	
	
	
//------------------------------------------------------------------------------
	
	// Débordement Gauche
	public static int leftDetect(int colonne, int shipsize) {
		
		// Si la position calculée est en dehors de la grille par la gauche
		if (colonne - (shipsize-1) < 0){
			return 0;
		}
		return 1;
	}
	
	// Débordement Droite
	public static int rightDetect(int colonne, int shipsize) {
		
		// Si la position calculée est en dehors de la grille par la droite
		if (colonne + (shipsize-1) > 9){
			return 0;
		}
		return 1;
	}
	
	// Débordement Haut
	public static int upDetect(int ligne, int shipsize) {
		
		// Si la position calculée est en dehors de la grille par la haut
		if (ligne - (shipsize-1) < 0){
			return 0;
		}
		return 1;
	}
	
	// Débordement Bas
	public static int downDetect(int ligne, int shipsize) {
		
		// Si la position calculée est en dehors de la grille par la bas
		if (ligne + (shipsize-1) > 9){
			return 0;
		}
		return 1;
	}
}
