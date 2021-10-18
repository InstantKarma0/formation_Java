package exos;

public class Imbrication {

	/**
	 * Fonction generant un tableau carre de taille definie
	 * @param taille, taille du tableau a generer
	 */
	public static void genTb(int taille) {
		
		// Boucle for allant de 0 à taille
		for (int i = 0;i < taille; i++) {
			// Declaration du string ligne 
			String ligne = "";
			
			// Boucle for allant de 0 a taille
			for (int y = 0;y < taille; y++) {
				// On ajoute la valeur de Y + un espace
				ligne = ligne + (y+1)+ " ";
			}
			// On affiche la ligne dans la console
			System.out.println(ligne);
		}	
	}
}
