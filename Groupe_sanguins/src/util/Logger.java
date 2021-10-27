package util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Classe Permettant de generer des logs datees en langue sql et traduits en
 * francais
 * @author Corentin.P
 */
public class Logger {

	/* ------------------------------------------------------------------------
	 *								Attributs
	 * ------------------------------------------------------------------------
	 */
	private static String[] sqlSelect = {"select","*","from","where"," or "," and "};
	private static String[] wordSelect = {"Selectionner", "tout les champs", "depuis la table", "o�", " ou ", " et"};
	private static String[] sqlInsert = {"insert", "into", "values"};
	private static String[] wordInsert = {"Ajouter", "dans la table", "prenant comme valeur:"};
	
	/* ------------------------------------------------------------------------
	 * 								Methodes
	 * ------------------------------------------------------------------------
	 */
	
	/**
	 * Fonction permettant de generer et ecire les logs dans un fichier text
	 * ayant pour nom la date a laquelle la fonction est utilisee
	 * @param sql La requete SQL parametree (avec des '?')
	 * @param args Le tableau des parametres de la requete
	 * @param path Le chemin du dossier ou le fichier texte sera creer
	 * @return True ou False correspondant a la reussite de la fonction
	 */
	public static boolean logByDate(String sql, String[] args, String path) {
		
		// On genere puis ecris le log dans le fichier et on retourne le succes de la fonction
		return Files.writeByDay(path, create(sql, args));
	} // EO logByDate
	
	
	// ------------------------------------------------------------------------
	
	
	/**
	 * Fonction permettant de generer une ligne de log en fonction de la requete
	 * sql et des arguments passes
	 * @param sql La requette parametree SQL (avec les ?)
	 * @param args Le tableau des parametres de la requete SQL
	 */
	private static String create(String sql, String[] args) {
		
		// on initialise un String contenant la requette sql sans '?'
		String oSql = "SQL: " + replaceQuestionMark(sql, args);
		// on initialise un String contenant les informations temporelles
		// au moment o� la fonction est utilisee
		String date = Instant.now().atZone(ZoneId.of("Europe/Paris"))
				.format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
		
		// On met la requete SQL en minuscule
		sql = sql.toLowerCase();
		
		// Bouble for allant de 0 a la taille de sqlSelect
		for (int i = 0; i < sqlSelect.length; i++) {
			// On remplace les mots de la requette SQL
			sql = replaceAll(sql, sqlSelect[i], wordSelect[i]);
		} // EO For i
		
		// Bouble for allant de 0 a la taille de sqlInsert
		for (int y = 0; y < sqlInsert.length; y++) {
			// On remplace les mots de la requette SQL
			sql = replaceAll(sql, sqlInsert[y], wordInsert[y]);
		} // EO For y
		
		// On remplace les '?' par les arguments de la requete
		if (args != null) {
			sql = replaceQuestionMark(sql, args);
		}
		
		
		// on retourne le string avec toutes les informations requises pour le log
		return date + "\n"+ oSql + "\n" + "FR: " + sql + "\n\n";
		
		
	}// EO create
	
	
	// ------------------------------------------------------------------------
	
	
	/**
	 * Fonction permettant de remplacer les emplacements de parametres d'une
	 * requete parametree par les parametres contenus dans un tableau de string
	 * @param str La requete SQL
	 * @param args Le tableau des arguments de la requete
	 * @return La requete SQL completee
	 */
	private static String replaceQuestionMark(String str, String[] args) {
		
		// Boucle en fonction de la taille du tableau d'args
		for (int i = 0; i < args.length; i++) {
			// Boucle en fonction de la taille en caracteres de la requette
			for (int y = 0; y < str.length(); y++) {
				
				// Si le caractere de la requete a l'indice y est '?'
				if (str.charAt(y) == '?') {
					// On le remplace par le string contenu dans le tableau a l'indice y
					str = str.substring(0,y) + args[i] + str.substring(y+1);
					break;
				} // EO IF
			} // EO for y
		} // EO for i
		
		// On renvoie le string modifie
		return str;
		
	} // EO replaceQuestionMark
	
	
	// ------------------------------------------------------------------------
	
	/**
	 * Fonction permettant de remplacer des portions d'un string par un autre string
	 * @param str Le string dans lequelle on veut remplacer des portions
	 * @param search La portion que l'on veut remplacer
	 * @param subString Le string que l'on veut mettre a la place
	 * @return
	 */
	private static String replaceAll(String str, String search,String subString) {
		
		// Boucle avec i allant de 0 � la taille de str - la taille de search
		for (int i = 0; i < str.length()-(search.length());i ++) {
			
			// Si la portion du string str est egal a search
			if (str.substring(i, i + search.length()).equals(search)) {
				// On remplace la portion par subString
				str = str.substring(0, i) + subString + str.substring(i + search.length());
			} // EO IF
		} // EO for i
		
		// On retourne le String modifie
		return str;
		
	} // EO replaceAll
	
	
}
