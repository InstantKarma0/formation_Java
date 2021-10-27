package util;

public class ObstacleDetect {

	
	/**
	 * Fonction appellant les 4 fonctions de detection en fonction des directions possibles
	 * @param colonne -> Le num�ro de la colonne
	 * @param ligne -> Le num�ro de la ligne = (int) ligne - 97
	 * @param shipsize -> la taille du bateau actuel
	 * @param shippos -> Tableau Multidimentionnel de taille 10x10 avec les emplacements pris par les bateaux
	 * @param posibilities -> Tableau de taille 4 regroupant les direction possible re�u de la detection hors grille
	 * @return posibilities -> Nouvelle affectation du tableau avec les direction apres detection colision
	 * @throws Exception Tableau sans posibilitees
	 */
	public static int[] allDetect(int colonne, int ligne, int shipsize, int[][] shippos, int[] posibilities) {
	
		if (posibilities[0] == 1) {
			posibilities[0] = leftDetect(colonne, ligne, shipsize, shippos);
		} // EO If
		if (posibilities[1] == 1) {
			posibilities[1] = rightDetect(colonne, ligne, shipsize, shippos);
		} // EO If
		if (posibilities[2] == 1) {
			posibilities[2] = upDetect(colonne, ligne, shipsize, shippos);
		} // EO If
		if (posibilities[3] == 1) {
			posibilities[3] = downDetect(colonne, ligne, shipsize, shippos);
		} // EO If
		
		
		return posibilities;
	}
	
		// D�bordement Gauche
		private static int leftDetect(int colonne, int ligne, int shipsize, int[][] shippos) {
			
			for (int i = colonne; i > colonne - shipsize; i--) {
				if (shippos[ligne][i] != 0) {
					return 0;
					
				}
			}
			return 1;
		}
		
		// D�bordement Droite
		private static int rightDetect(int colonne, int ligne, int shipsize, int[][] shippos) {
			
			for (int i = colonne; i < colonne + shipsize; i++) {
				if (shippos[ligne][i] != 0) {
					return 0;
				}
				
			}
			return 1;
		}
		
		// D�bordement Haut
		private static int upDetect(int colonne,int ligne, int shipsize, int[][] shippos) {
			for (int i = ligne; i > ligne - shipsize; i--) {
				if (shippos[i][colonne] != 0) {
					return 0;
					
				}
			}
			return 1;
		}
		
		// D�bordement Bas
		private static int downDetect(int colonne,int ligne, int shipsize, int[][] shippos) {
			for (int i = ligne; i < ligne + shipsize; i++) {
				if (shippos[i][colonne] != 0) {
					return 0;
				}
			}
			return 1;
		}
		
		
		
}
