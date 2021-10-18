package exos;

import java.util.ArrayList;

import util.ScanWithLabel;

public class Tableau {
	
	
	/* ------------------------------------------------------------------------
	 * 							Les Attributs
	 * ------------------------------------------------------------------------
	 */
	
	// La valeur par default des cases du tInt7
	private int defaultvalue;
	
	// Le tableau
	private int[] tInt7;
	
	String[] menu = {"Quitter", "Visualiser le tInt7", 
			"Modifier une valeur du tInt7", "Supprimer une valeur du tInt7", 
			"Chercher une valeur dans le tInt7"};	
	
	/* ------------------------------------------------------------------------
	 * 							Le Constructeur
	 * ------------------------------------------------------------------------
	 */
	
	/**
	 * Constructeur de la classe tInt7
	 * @param taille la taille du tInt7
	 * @param defaultvalue la valeur par default des cases du tableau
	 */
	public Tableau(int taille, int defaultvalue) {
		// On definit la variable defaultvalue
		this.defaultvalue = defaultvalue;
		
		// On definit la taille du tableau a partir de taille
		this.tInt7 = new int[taille];
		
		// On remplit le tableau avec la valeur par default
		for (int i = 0; i < tInt7.length; i++) {
			tInt7[i] = defaultvalue;
		} // EO IF
		
		this.create();
		
	} // EO CONSTRUCTEUR

	/* ------------------------------------------------------------------------
	 * 							Les Methodes
	 * ------------------------------------------------------------------------
	 */
	
	
	/**
	 * Fonction de menu dirigeant vers les fonctions du CRUD
	 */
	public void menu() {
		
		// On initialise le boolean de la boucle
		boolean b = true;
		
		
		// Boucle DO
		do {
			// On affiche le menu
			displayMenu();
			
			// On recupere le choix de l'utilisateur
			int choix = ScanWithLabel.scanInt("Quel est votre choix", 1, this.menu.length);
			
			// Switch en fonction de choix
			switch(choix) {
			
				// Cas 1
				case 1:
					this.read();
					break;
				case 2:
					this.read();
					this.update(ScanWithLabel.scanInt("Quelle case voulez vous modifier", 1, this.tInt7.length)-1,
							ScanWithLabel.scanInt("Quelle valeur voulez vous mettre a la place?", 1, 100));
					break;
				case 3:
					this.read();
					this.delete(ScanWithLabel.scanInt("Quelle case voulez vous supprimer?", 1, this.tInt7.length)-1);
					break;
				case 4:
					this.read();
					this.search(ScanWithLabel.scanInt("Quelle valeur voulez vous chercher?", 1, 100));
					break;
			} // EO SWITCH
			
			if (ScanWithLabel.scanInt("Voulez vous continuer?\n"
					+ "0) Oui\n"
					+ "1) Non", 0, 2) == 1) {
				
				b = false;
			} // EO IF
			
		} while(b); // EO DO WHILE
		
		System.out.println("Fin du Programme.");
	
	} // EO MENU
	
	/**
	 * Fonction permettant d'afficher le menu
	 */
	private void displayMenu() {
		String e = "Menu:\n";
		for (int i = 1; i < menu.length; i++) {
			e = e + i + ") " + menu[i] + "\n";
		}
		System.out.println(e);
	}// EO DisplayMenu
	
	
	
	
	/**
	 * Remplissage du tableau en fonction de ce que nous indique l'utilisateur
	 */
	private void create() {
		
		for (int i = 0; i < tInt7.length; i++ ) {
			this.tInt7[i] = ScanWithLabel.scanInt("Saisir la valeur n°"+ (i+1) + " entre 1 et 99", 1, 100);
		} // EO FOR
		read();
	}
	
	/**
	 * Retourne le tableau dans la console
	 */
	private void read() {
		
		int[] tb = this.tInt7;
		
		String line =   "---------------------------------------------\n";
		String saisie = "               Valeur Saisie                 \n";
		
		
		
		String out = "";
		
		out = out + line + saisie + line + "\n";
		
		for (int i = 0; i < tb.length; i++ ) {
			out = out + " " + tb[i] + " |" ;
		}
		
		System.out.println(out);
	}
	
	
	/**
	 * Met a jour une valeur avec un indice defini
	 * @param indice, emplacement de la valeur a modifier
	 * @param newvalue, nouvelle valeur a affecter
	 */
	private void update(int indice, int newvalue) {
		
		this.tInt7[indice] = newvalue;
		System.out.println("La valeur dans la case n°"+ (indice+1) + " a maintenant la valeur " + newvalue);
		
	}// EO UPDATE
	
	
	/**
	 * Remet une valeur d'un indice defini a la valeur par default
	 * @param indice
	 */
	private void delete(int indice) {
		
		this.tInt7[indice] = this.defaultvalue;
		System.out.println("La valeur dans la case n°"+ (indice+1) + " a été supprimée.");
	}
	
	
	
	/**
	 * Cherche si la valeur est présente dans le tableau et indique l'indice
	 * @param recherche
	 */
	private void search(int recherche) {
		
		ArrayList<Integer> tbResultat = new ArrayList<Integer>();
		for (int i = 0; i < this.tInt7.length; i++) {
			if (this.tInt7[i] == recherche) {
				tbResultat.add(i+1);
			}
		}
		
		
		if (tbResultat.isEmpty()) {
			System.out.println("La valeur n'est pas présente dans le tableau");
			
		} else if (tbResultat.size() == 1) {
			System.out.println("La valeur est présente à la case numero: " + tbResultat.get(0));
			
			
		} else {
			String nbs = "";
			for (int i = 0; 1 < tbResultat.size(); i ++) {
				nbs = nbs + " " + tbResultat.get(i);
			}
			System.out.println("La valeur est présente dans les cases ");
		}
	}
	
	/* ------------------------------------------------------------------------
	 * 								Getter
	 * ------------------------------------------------------------------------
	 */
	
	public int getDefaultValue() {
		return this.defaultvalue;
	}
	
	public int[] getTInt7() {
		return this.tInt7;
	}
	
	/* ------------------------------------------------------------------------
	 * 								Setter
	 * ------------------------------------------------------------------------
	 */
	
	public void setDefaultValue(int newValue) {
		this.defaultvalue = newValue;
	}
	
	public void setTInt7(int[] newTableau) {
		this.tInt7 = newTableau;
	}
	
}