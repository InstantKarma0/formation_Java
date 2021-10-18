package util;

public class AsciiConvert {

	/**
	 * Fonction permettant de convertir un char en nombre (97 = 'a')
	 * @param ascii -> Charactere a convertir
	 * @return int -> Nombre resultant de la conversion
	 */
	public static int asciiToInt(char ascii) {
			
		return (int) ascii - 97;
		
	}

	

	
	/**
	 * Fonction permettant de convertir un nombre en char (début 'a' = 97)
	 * @param integer -> Nombre a convertir
	 * @return char -> Charactere resultant de la conversion
	 */
	public static char intToAscii(int integer) {
		
		return (char) (integer + 97);
	}
	
	
	
	// TODO Peut être les fonctions permettant de passer 'a' <-> 1 et 0 <-> 1
}
