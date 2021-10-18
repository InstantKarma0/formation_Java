package exos;

import gestionArray.GestionTbString;
import util.RndGen;
import util.ScanWithLabel;

public class DesignationRnd {

	
	
	
	static String[] session = {"Rodolphe","Baptiste","Pierre","Christophe",
			"Angéline","Ouhibou","Amira","Paula","Corentin"};
	
	
	
	
	
	public static void main() {
		
		String[] truc = session;
		System.out.println("Ce programme permet de désigner une"
				+ " personne parmis une liste de noms");
		ScanWithLabel.scanString("Entrez quelque chose dans la"
				+ " console pour commencer");
		
		int indice;
		String lui;
		
		for (int i = truc.length; i > 0; i--) {
			
			indice = RndGen.getRandomNumber(0, truc.length);
			lui = truc[indice];
			System.out.println(lui + " a été désigné(e).");
			
			truc = GestionTbString.pop(truc, indice);
			
			if (i == 1) {
				break;
			}
			
			ScanWithLabel.scanString("Entrez quelque chose dans la console pour continuer");
			
		} // EO FOR
		
		System.out.println("\nFin du Programme");
	

	}
}
