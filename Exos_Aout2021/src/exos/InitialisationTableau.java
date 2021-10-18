package exos;

public class InitialisationTableau {

	/**
	 * Fonction permettant de retourner un tableau de taille d�finie remplit avec des valeurs d�finies
	 * @param n la taille du tableau
	 * @param defaultvalue la valeur de default
	 * @return table tableau de taille n
	 */
	
	public int[] tableauTailleN(int n, int defaultvalue) {
		int[] table = new int[n];
		
		for (int i = 0; i < table.length ;i++) {
			table[i] = defaultvalue;
		}
		
		return table;
	}
}
