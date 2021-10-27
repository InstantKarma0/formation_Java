package gestionArray;
/**
 * Classe de gestion d'un tableau de float
 * @author Corentin.P @InstantKarma0
 * @author Rodolphe.D @Rod-Gala
 *
 */
public class GestionTbFloat {

	/**
	 * Fonction permettant d'ajouter un float dans un tableau de float
	 * 
	 * @author Rodolphe
	 * @param tb, le tableau ou faire l'ajout
	 * @param ajout, le float a ajouter
	 * @return Un tableau avec le nouveau element en plus
	 */
	public static float[] push(float[] tb, float ajout) {
		
		// On defini un tableau ayant la taille de tb + 1
		float[] resultat = new float[tb.length+1];
		
		// On ajoute les elements de tb dans le nouveau tableau
		for (int i = 0; i < tb.length; i ++) {		
			resultat[i] = tb[i];
		}
		
		// On ajoute le float a ajouter a la fin du nouveau tableau
		resultat[tb.length-1] = ajout;
		
		// On renvoie le nouveau tableau
		return resultat;
	}
	
	/**
	 * Fonction permettant de retirer une valeur du tableau a un indice fourni
	 * 
	 * @author Rodolphe
	 * @param tb , le tableau 
	 * @param indice, l'indice de la valeur a retirer
	 * @return le nouveau tableau de taille reduite de 1
	 */
	public static float[] pop(float[] tb, int indice) {
		// On declare un nouveau tableau avec une case en moins
		float[] resultat = new float[tb.length-1];
		// On initialise un indice correspondant a celui du tableau d'origine
		int y = 0;
		
		// On ajoute les valeurs dans le nouveau tableau
		for (int i = 0; i < tb.length; i++) {
			// Si i est egal a l'indice que l'on veut retirer
			if (i == indice) {
				// On court-circuite la boucle
				continue;
			} // EO if
			resultat[y] = tb[i];
			y++;
		} // EO for
		
		// On retourne resultat
		return resultat;
	} // EO pop
	
	/**
	 * Fonction permettant de chercher une valeur dans un tableau et 
	 * retourner son indice
	 * Si le retour est egal a -1, la valeur n'a pas ete trouve
	 * 
	 * @param tb, le tableau dans lequel chercher
	 * @param value, la valeur a chercher
	 * @return l'indice de la valeur
	 */
	public static int search(float[]tb, float value) {
		// On initialise l'indice a une valeur de base
		int resultat = -1;
		
		// On parcours le tableau
		for (int i = 0; i < tb.length; i++) {
			// Dans le cas ou la valeur est dans le tableau
			if (tb[i] == value) {
				// On recupere la valeur de l'indice
				resultat = i;
				// On court-circuit la boucle
				break;
			} // EO if
		} // EO for
		
		// On renvoie resultat
		return resultat;
	} // EO search
	
	/**
	 * Fonction permettant de retourner un tableau en supprimant une entree
	 * en fonction de sa valeur
	 * 
	 * Si la valeur n'existe pas dans le tableau, la fonction renvoie le tableau
	 * non modifie
	 * 
	 * @param tb, Le tableau
	 * @param value, La valeur a retirer
	 * @return
	 */
	public static float[] remove(float[]tb, float value) {
		// On declare l'indice
		int indice;
		
		// On recupere l'indice de la valeur
		indice = search(tb, value);
		
		// Dans le cas ou la valeur n'existe pas dans le tableau
		if (indice == -1) {
			// On renvoie le tableau non modifie
			return tb;
		} // EO if
		// On initialise un nouveau tableau sans la valeur qu'on veut retirer
		float[] resultat = pop(tb, indice);
		
		// On renvoie le tableau
		return resultat;
	} // EO remove
	
	
	/**
	 * Fonction permettant de renvoyer un tableau etant la fusion de deux tableaux
	 * @param tb Tableau de base
	 * @param tbajout Tableau a ajouter
	 * @return Un tableau etant la fusion des deux tableau
	 */
	public static float[] merge(float[] tb, float[] tbajout) {
		
		// On defini un tableau ayant la taille de tb + taille de tbajout
		float[] resultat = new float[tb.length + tbajout.length];
		// On declare un nouveau indice
		int i;
		
		// On ajoute les elements de tb dans le nouveau tableau
		for (i = 0; i < tb.length; i ++) {
			resultat[i] = tb[i];
		}
		
		// On ajoute les elements de tbajout dans le nouveau tableau
		for (int y = 0; y < tbajout.length; y ++) {
			resultat [i+y+1] = tbajout[y];
		}
		
		// On retourne le nouveau tableau
		return resultat;
	}
	
	/**
	 * Fonction permettant de renvoyer un tableau de float depuis un tableau 
	 * original, allant de l'indice jusqu'a la fin du tableau original
	 * @param tableau Le tableau Original
	 * @param indice L'indice de debut
	 * @return Un tableau allant de l'indice a la fin
	 */
	public static float[] slice(float[] tableau, int indiceDebut) {
		
		// On defini un nouveau tableau de taille souhaite
		float[] resultat = new float[tableau.length-indiceDebut];
		
		/* On ajoute les valeurs du tableau d'origine depuis l'indice de debut
		*  jusqu'a la fin du tableau d'origine dans le nouveau tableau
		*/
		for (int i = 0; i < resultat.length; i ++) {
			resultat[i] = tableau[i+indiceDebut];
		} // EO for
		
		// On renvoie resultat
		return resultat;
	} // EO slice
	
	
	/**
	 * Fonction permettant de renvoyer un tableau de float depuis un tableau original
	 * ,allant de l'indice de debut a l'indice de fin (exclus) du tableau original
	 * @param tableau , Le Tableau d'origine
	 * @param indiceDebut
	 * @param indiceFin
	 * @return
	 */
	public static float[] slice(float[] tableau, int indiceDebut, int indiceFin) {
		// On declare un nouveau tableau
		float[] resultat = new float[indiceFin-indiceDebut];
		
		// On ajoute les elements du tableau d'origine depuis l'indice de debut jusqu'a
		// l'indice de fin (exclus) dans le nouveau tableau
		for(int i = 0; i < tableau.length; i ++) {
			resultat[i] = tableau[indiceDebut+i];
		} // Eo for
		
		// On retourne resultat
		return resultat;
		
	} // EO slice
	
	/**
	 * Fonction permettant de renvoyer un tableau de tableau contenant
	 * deux tableau resultant de la decoupe du tableau d'origine a l'indice fourni
	 * @param tableau, Le tableau d'origine
	 * @param indiceDecoupe, L'indice ou le tableau sera decoupe
	 * @return Un tableau de tableaux de taille 2
	 */
	public static float[][] split(float[] tableau, int indiceDecoupe) {
		// On declare un nouveau tableau de tableaux de taille 2
		float[][] resultat = new float[2][];
		// On initialise l'indice du tableau d'origine
		int i;
		
		// On ajoute les elements du tableau d'origine jusqu'a l'indice de decoupe
		// (exclus) dans la premiere ligne du nouveau tableau
		for (i = 0 ;i < indiceDecoupe; i++) {
			resultat[0][i] = tableau[i];
		} // EO for
		
		// On incremente i pour correspondre a la valeur de l'indice
		i++;
		
		// On ajoute les elements du tableau d'origine depuis l'indice de decoupe
		// (inclus) dans la seconde ligne du nouveau tableau
		for (int y = 0; y < tableau.length; y++) {
			resultat[1][y] = tableau[y+i];
		} // EO for
	
		// On retourne resultat
		return resultat;
	} // EO split
	
}