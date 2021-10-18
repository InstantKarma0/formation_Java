package exos;

// Packages permettant de g�rer la lecture/�criture/cr�ation de fichier
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

// Importation de Package permettant de g�n�rer une date
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


import java.util.List;

public class File {


	
	
	public static void test() {

		// On d�finit les chemins absolus vers les fichiers utilis�s
		FileSystem fs = FileSystems.getDefault();
		// Fichier d'entree d'informations
		Path fIn = fs.getPath("C:/test/In.txt");
		// Fichier de sortie d'informations
		Path fOut = fs.getPath("C:/test/Out.txt");
		
		// On d�clare une liste afin de le remplir des informations du fichier
		List<String> liste = null;
		
		try {
			// On essaie de lire les lignes du fichier
			liste = Files.readAllLines(fIn);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// on r�cup�re la date de naissance et on s�pare les jours des mois et des annees
		String[] date = liste.get(2).split(" ");
		
		// On calcule l'age via la fonction calculAge en fonction de la date de naissance
		int age = calculAge(Integer.valueOf(date[0]), Integer.valueOf(date[1]), Integer.valueOf(date[2]));
		
		
		try {
			// On essaie d'�crire les informations sur le fichier de sortie
			Files.writeString(fOut, liste.get(0) +" "+ liste.get(1) +" "+ age );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} // EO test
	
	
	
	/**
	 * Fonction permettant de calculer un age en fonction de sa date de naissance
	 * et de la date du jour
	 * 
	 * @param jour Le jour de naissance
	 * @param mois Le mois de naissance
	 * @param year L'annee de naissance
	 * @return Int l'age calcul�
	 */
	public static int calculAge(int jour, int mois, int year) {
		
		
		// On r�cup�re la date du jour sous forme yyyy-MM-dd
		String test = Instant.now().atZone(ZoneId.of("Europe/Paris"))
				.format(DateTimeFormatter.ISO_LOCAL_DATE);
		
		
		/* On d�coupe ce string en trois string
		* nowDate[0] = Annee
		* nowDate[1] = Mois
		* nowDate[2] = Jour
		*/
		String[] nowDate = test.split("-");
		
		// On initialise age
		int age = 0;
		
		// On calcule l'age en fonction de l'annee actuelle et celle de naissance
		age = (Integer.valueOf(nowDate[0])) - year;
		
		// Dans le cas ou le mois d'anniverssaire n'est pas encore pass�
		if (Integer.valueOf(nowDate[1]) < mois) {
			age--;
		}
		
		// Dans le cas ou le mois d'anniverssaire correspond au mois actuel
		if (Integer.valueOf(nowDate[1]) == mois) {
			
			// Dans le cas ou le jour n'est pas encore pass�
			if (Integer.valueOf(nowDate[2]) < jour) {
				age--;
			}
		}
		
		// On renvoie l'age calcul�
		return age;
	}
}
