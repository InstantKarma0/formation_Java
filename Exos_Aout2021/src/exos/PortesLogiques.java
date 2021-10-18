package exos;

import java.util.ArrayList;
import java.util.List;

import util.ScanWithLabel;

public class PortesLogiques {

	public static void calculLogiques() {
		
		int more = 0;
		
		List<Boolean> boolLi = new ArrayList<Boolean>();
		
		// Boucle Permettant de demander à l'utilisateur de rentrer des informations
		// Tant qu'il n'y a pas 2 entrées ou plus dans le tableau
		do  {
			
			// On demande la valeur de a entre 0 et 1 inclus
			int a = -1;
			while (a < 0 || a > 1 ) {
				System.out.println("Valeur n°" + (boolLi.size()+1));
				a = ScanWithLabel.scanInt("Quel est la valeur du Booleen? \n"
						+ "0 = True\n"
						+ "1 = False\n");
			}
		
		
			// Dans le cas ou a est egal a 0, on ajoute un booleen true dans la liste
			if (a == 0) {
				boolLi.add(true);
				
			// Dans le cas ou a est egal a 1, on ajoute un booleen false dans la liste	
			} else {
				boolLi.add(false);
			}
			
			
			// Dans le cas ou la taille de la liste est superieur a 1 (2 ou +)
			if (boolLi.size() > 1) {
				do {
					more = 1;
					// on demande si l'utilisateur veut ajouter une valeur en plus
					more = ScanWithLabel.scanInt("Voulez vous ajouter une nouvelle valeur?"
							+ "(Default = non) \n"
							+ "0 = Oui\n"
							+ "1 = Non\n");
				} while (more < 0 || more > 1);
				
			}
		
		} while (boolLi.size() < 2 || more == 0 );
		
		
		// On demande à l'utilisateur de nous renseigner sur la porte logique qu'il souhaite
		int c = -1;
		while (c < 0 || c > 1 ) {
			c = ScanWithLabel.scanInt("Quel est la porte logique souhaité? \n"
					+ "0 = ET\n"
					+ "1 = OU\n");
		}
		
		
		// SI c = 0 (Porte Logique ET)
		if (c == 0) {
			// On parcours la liste boolLi en cherchant un false
			for (int i = 0; i < boolLi.size(); i++) {
				// Si on trouve un false
				if (boolLi.get(i) == false) {
					// On affiche que le resultat est faux
					System.out.println("Le résultat est Faux!");
					// On sort de la boucle
					break;
					
				}
				
				// Si aucun false n'est trouvé à la fin de la boucle
				if (i == boolLi.size()-1) {
					// On affiche que le resultat est vrai
					System.out.println("Le résultat est Vrai!");
				}
			}
			
		// PORTE LOGIQUE OU
		} else {
			
			// On parcours le tableau a la recherche d'un true
			for (int i = 0; i < boolLi.size(); i++) {
				// Si on trouve un true
				if (boolLi.get(i) == true) {
					// On affiche que le resultat est vrai
					System.out.println("Le résultat est Vrai!");
					// On sort de la boucle
					break;
				}
				
				// Si aucun true n'est trouvé à la fin de la boucle
				if (i == boolLi.size()-1) {
					// On affiche que le resultat est faux
					System.out.println("Le résultat est Faux!");
				}
			}
			
		}
	
	
	}
}
