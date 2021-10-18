package exos;

public class AffichageTableau {

	
	public void affichageTableau(int[] tableau) {
		for (int i = 0; i < tableau.length; i++) {
			System.out.println("La valeur n°" + i+1 + " du tableau est: " + tableau[i]);
		}
		
	}
}
