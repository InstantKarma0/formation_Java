package gestionArray;
/**
 * Classe de gestion d'un tableau de char
 * @author Corentin.P
 * @author Rodolphe
 *
 */
public class GestionTbChar {

	/**
	 * Fonction permettant d'ajouter un char dans un tableau de char
	 * 
	 * @author Rodolphe
	 * @param tb Le tableau où faire l'ajout
	 * @param ajout Le char a ajouter
	 * @return Un tableau avec le nouveau element en plus
	 */
	public static char[] push(char[] tb, char ajout) {
		
		// On défini un tableau ayant la taille de tb + 1
		char[] resultat = new char[tb.length+1];
		
		// On ajoute les elements de tb dans le nouveau tableau
		for (int i = 0; i < tb.length; i ++) {		
			resultat[i] = tb[i];
		}
		
		// On ajoute le char a ajouter a la fin du nouveau tableau
		resultat[resultat.length-1] = ajout;
		
		// On renvoie le nouveau tableau
		return resultat;
	}
	
	/**
	 * Fonction permettant de retirer une valeur du tableau a un indice fourni
	 * 
	 * @author Rodolphe
	 * @param tb Le tableau 
	 * @param indice L'indice de la valeur a retirer
	 * @return Le nouveau tableau de taille reduite de 1
	 */
	public static char[] pop(char[] tb, int indice) {
		// On declare un nouveau tableau avec une case en moins
		char[] resultat = new char[tb.length-1];
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
	 * Si le retour est egal à -1, la valeur n'a pas ete trouve
	 * 
	 * @param tb Le tableau dans lequel chercher
	 * @param value La valeur a chercher
	 * @return L'indice de la valeur
	 */
	public static int search(char[]tb, char value) {
		// On initialise l'indice a une valeur de base
		int resultat = -1;
		
		// On parcours le tableau
		for (int i = 0; i < tb.length; i++) {
			// Dans le cas où la valeur est dans le tableau
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
	 * @param tb Le tableau
	 * @param value La valeur a retirer
	 * @return Le tableau sans la valeur retiree
	 */
	public static char[] remove(char[] tb, char value) {
		// On déclare l'indice
		int indice;
		
		// On recupère l'indice de la valeur
		indice = search(tb, value);
		
		// Dans le cas où la valeur n'existe pas dans le tableau
		if (indice == -1) {
			// On renvoie le tableau non modifie
			return tb;
		} // EO if
		// On initialise un nouveau tableau sans la valeur qu'on veut retirer
		char[] resultat = pop(tb, indice);
		
		// On renvoie le tableau
		return resultat;
	} // EO remove
	
	
	/**
	 * Fonction permettant de renvoyer un tableau etant la fusion de deux tableaux
	 * @param tb Le tableau de base
	 * @param tbajout Le tableau a ajouter
	 * @return Un tableau etant la fusion des deux tableau
	 */
	public static char[] merge(char[] tb, char[] tbajout) {
		
		// On défini un tableau ayant la taille de tb + taille de tbajout
		char[] resultat = new char[tb.length + tbajout.length];
		// On déclare un nouveau indice
		int i;
		
		// On ajoute les elements de tb dans le nouveau tableau
		for (i = 0; i < tb.length; i ++) {
			resultat[i] = tb[i];
		}
		
		// On ajoute les elements de tbajout dans le nouveau tableau
		for (int y = 0; y < tbajout.length; y ++) {
			resultat [i+y] = tbajout[y];
		}
		
		// On retourne le nouveau tableau
		return resultat;
	}
	
	/**
	 * Fonction permettant de renvoyer un tableau de char depuis un tableau 
	 * original, allant de l'indice jusqu'a la fin du tableau original
	 * @param tableau Le tableau Original
	 * @param indice L'indice de debut
	 * @return Un tableau allant de l'indice a la fin
	 */
	public static char[] slice(char[] tableau, int indiceDebut) {
		
		// On defini un nouveau tableau de taille souhaite
		char[] resultat = new char[tableau.length-indiceDebut];
		
		/* On ajoute les valeurs du tableau d'origine depuis l'indice de debut
		*  jusqu'à la fin du tableau d'origine dans le nouveau tableau
		*/
		for (int i = 0; i < resultat.length; i ++) {
			resultat[i] = tableau[i+indiceDebut];
		} // EO for
		
		// On renvoie resultat
		return resultat;
	} // EO slice
	
	
	/**
	 * Fonction permettant de renvoyer un tableau de char depuis un tableau original
	 * ,allant de l'indice de debut a l'indice de fin (exclus) du tableau original
	 * @param tableau Le Tableau d'origine
	 * @param indiceDebut L'indice de debut
	 * @param indiceFin L'indice de fin (exclus)
	 * @return Le tableau entre l'indice de debut et l'indice de fin (exclus)
	 */
	public static char[] slice(char[] tableau, int indiceDebut, int indiceFin) {
		// On declare un nouveau tableau
		char[] resultat = new char[indiceFin-indiceDebut];
		
		// On ajoute les elements du tableau d'origine depuis l'indice de debut jusqu'à
		// l'indice de fin (exclus) dans le nouveau tableau
		for(int i = 0; i < resultat.length; i ++) {
			resultat[i] = tableau[indiceDebut+i];
		} // Eo for
		
		// On retourne resultat
		return resultat;
		
	} // EO slice
	
	/**
	 * Fonction permettant de renvoyer un tableau de tableaux contenant
	 * deux tableau resultant de la decoupe du tableau d'origine a l'indice fourni
	 * 
	 * @param tableau Le tableau d'origine
	 * @param indiceDecoupe L'indice où le tableau sera decoupe
	 * @return Un tableau de taille 2
	 */
	public static char[][] split(char[] tableau, int indiceDecoupe) {
		// On declare un nouveau tableau de tableaux de taille 2
		char[][] resultat = new char[2][];
		resultat[0] = new char[indiceDecoupe];
		resultat[1] = new char[tableau.length-resultat[0].length];
		// On initialise l'indice du tableau d'origine
		int i;
		
		// On ajoute les elements du tableau d'origine jusqu'à l'indice de decoupe
		// (exclus) dans la premiere ligne du nouveau tableau
		for (i = 0; i < indiceDecoupe; i++) {
			resultat[0][i] = tableau[i];
		} // EO for
		
		// On ajoute les elements du tableau d'origine depuis l'indice de decoupe
		// (inclus) dans la seconde ligne du nouveau tableau
		for (int y = 0; y < resultat[1].length; y++) {
			resultat[1][y] = tableau[y+i];
		} // EO for
	
		// On retourne resultat
		return resultat;
	} // EO split
	
}