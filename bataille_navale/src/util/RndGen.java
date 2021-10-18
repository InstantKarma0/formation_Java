package util;

public class RndGen {

	/**
	 * Fonction permettant de generer un nombre compris entre les bornes definies
	 * @param min Borne minimum
	 * @param max Borne maximale
	 * @return Int nombre genere aleatoirement
	 */
	
	public static int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}
}
