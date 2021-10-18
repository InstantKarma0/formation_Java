package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


/**
 * Classe de gestion de lecture et ecriture sur fichier
 * @author Corentin.P
 *
 */
class Files {

	/**
	 * Fonction Permettant d'ecrire a la suite d'un fichier
	 * Creer le fichier si celui ci n'existe pas
	 * @param path Le chemin absolu vers le fichier text
	 * @param line Le String a inscrire dans le fichier
	 * @return True si la fonction s'est effectuee correctement, False si la
	 * fonction a rencontrer une erreur
	 * @throws IOException 
	 */
	static boolean write(String path, String line) throws IOException {
		
		
		// On declare nos Object d'ecriture sur fichier
		FileWriter writer;
		BufferedWriter output;
		
		// Block Try/Catch
		try {
			writer = new FileWriter(path, true);
			output = new BufferedWriter(writer);
			output.write(line);
			output.close();
			return true;
		} catch (IOException e) {
			throw e;
		} // EO Try/Catch
	
	} // EO Write
	
	
	// ------------------------------------------------------------------------
	
	
	/**
	 * Fonction permettant d'ecrire dans un fichier
	 * @param path Le chemin vers le fichier
	 * @param line Le string a inscrire
	 * @return True ou False en fonction de la reussite de la fonction
	 */
	static boolean writeByfilePath(String path, String line) {
		
		// Block Try/Catch
		try {
			// Fonction d'ecriture
			return write(path, line); 
		} catch (IOException e) {
			// Si il y a une erreur 
			return false;
		} // EO Try/Catch
	} // EO WriteByFilePath
	
	
	// ------------------------------------------------------------------------
	
	
	/**
	 * Fonction Permettant d'ecrire dans un fichier portant le nom de la date
	 * a laquelle la fonction a ete effectuee
	 * @param folderPath Le chemin vers le dossier contenant les fichiers texte
	 * @param line Le string a inscrire dans le fichier
	 * @return True ou False en fonction de la reussite de la fonction
	 */
	static boolean writeByDay(String folderPath, String line) {
		// On initialise n
		
		String date = Instant.now().atZone(ZoneId.of("Europe/Paris"))
				.format(DateTimeFormatter.ISO_LOCAL_DATE);
		date = folderPath+ "\\" + date + ".txt";
		try {
			return write(date, line);
		} catch (IOException e) {
			return false;
		} // EO Try/Catch
		
	}// EO writeByDay
	
	
} // EO Files Class
