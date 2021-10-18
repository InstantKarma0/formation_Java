package exos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import util.ScanWithLabel;

public class TriMots {

	
	public static void test() {
		
		
		   
		        ArrayList<String> prenom = new ArrayList<>();
		        //On créer une list qui va pouvoir contenir des String 
		        Scanner Saisie = new Scanner (System.in);
		        for (int i = 0; i < 10; i++){
		            int indice = i+1;
		            System.out.println("Prénom n°"+indice);
		            prenom.add(Saisie.next());
		        }//EO for
		        //On récupère les prénoms de chacun
		        Saisie.close();
		        Collections.sort(prenom);
		        //On trie notre list
		        System.out.println("Ordre Final :");
		        System.out.println(prenom);
		        //On affiche
		    }//EO main
		//EO OrdrePrénom
	
	
	public static void tri() {
		
		ArrayList<String> liste = new ArrayList<String>();
		
		int anotherOne = 0;
		while (anotherOne == 0) {
			liste.add(ScanWithLabel.scanString("Inserez un nouveau mot"));
			anotherOne = ScanWithLabel.scanInt("Vous vous ajouter un autre mot? "
					+ "0 = oui , 1 = non");
		} // EO While
		
		
		/*
		 * for (int i = liste.size(); i > 1; i--) {
		 * 
		 * 
		 * 
		 * }
		 */
		
		
		liste.sort(null);
		
		
		String[] tb = new String[liste.size()];
		tb = liste.toArray(tb);
		
		
		
		System.out.println("Les 3 premiers mots sont triés?" + Arrays.toString(tb));
		
	}
	
	/**
	 * Fonction permettant de comparer deux string par ordre alphabetique.
	 * 
	 * @param un , 1er string
	 * @param deux , 2nd string
	 * @return int, 0 = String 1 en premier, 1 = String 2 en premier
	 */
	
	public static int comparaisonLettre(String un, String deux) {
		
		int max;
		int mot;
		
		if (un.length() < deux.length()) {
			max = un.length();
			mot = 0;
		} else {
			max = deux.length();
			mot = 1;
		} // EO IF
		
		
		
		for(int i = 0; i < max; i++) {
			if (un.charAt(i) != deux.charAt(i)) {
				
				if (un.charAt(i) < deux.charAt(i)) {
					return 0;
				} else {
					return 1;
				} // EO IF
			} // EO IF
		} // EO FOR
		
		// Dans le cas où aucun différence n'est trouvée jusqu'à la fin du plus
		// petit mot
		
		return mot;
		
	} // EO COMPARAISON_LETTRE
}
