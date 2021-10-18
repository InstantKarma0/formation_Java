package db.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


/**
 * Classe modulaire de gestion des connections a la base de donnée
 * @author Corentin.P
 *
 */
class Sql {
	
	
	/**
	 * Classe Permettant de se connecter a une base de donnee
	 * de recuperer une reponse a partir d'une requette
	 * parametree depuis une liste d'arguments,
	 * pour le renvoyer sous forme de tableau a 2 dimensions
	 * 
	 * @param request Le String de la requete
	 * @param args Le tableau de string contenant les arguments
	 * @param type Le type de la requete (post, get, update)
	 * @return Un tableau a deux dimensions
	 */
	static ResultSet connect(String request, String[] args, String type) {
		
		
		
		
		// On déclare la variable conn
		Connection conn = null;
		// On déclare la variable result
		ResultSet result = null;
		
		PreparedStatement pst = null;
		
		// On instancie la connection avec la dB
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/groupesanguin?"
					+ "user=root&password=&useJDBCCompliantTimezoneShift=true&"
					+ "useLegacyDatetimeCode=false&serverTimezone=UTC");
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			System.out.println(e2.getMessage());
		}	catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} // EO Try/Catch/Catch
		
		/*---------------------------------------------------------------------
		 *						Preparation de la requete
		 *---------------------------------------------------------------------* 
		 */
		
		
		// On essaie de faire une requete parametree (Protection Injection SQL)
		try {
			
			pst = conn.prepareStatement(request);
			
			// On parcours les elements du tableau d'arguments
			for (int i = 0; i < args.length ;i ++) {
				try {
					/* On essaie de le transformer en int et le mettre dans la
					 * requete parametree
					 */
					pst.setInt(i+1, Integer.valueOf(args[i]));
					
					// Si on a une erreur de type NumberFormatException
				} catch (NumberFormatException e) {
					
					// On met le string dans la fonction parametree
					pst.setString(i+1, args[i]);
				}// EO Try/Catch
			} // EO For
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.print(e1.getMessage());
		} // EO Try/Catch
		
		/*---------------------------------------------------------------------
		 * 							Connection BDD
		 * --------------------------------------------------------------------
		 */
		
		/*
		*	On essaie d'instancier la connection vers la base de donnee et de
		*	recuperer le resultat de la requete
		*/
		try {
			
			switch (type) {
				case "get":
					result = pst.executeQuery();
					break;
				case "post":
					pst.execute();
					result = null;
					
					break;
					
			} // EO Switch
			
		} catch (SQLException d) {
			System.out.println(d.getMessage());
		} // EO Try/Catch
		
		return result;
	} // EO connect
	
	//------------------------------------------------------------------------------
	
	/**
	 * Fonction Permettant de faire une requete a la base de donnee et 
	 * de traiter la reponse a la requete
	 * @param request La requete a la base de donnees
	 * @param args Un tableau de String avec les parametres de la requete
	 * @return null si la requete n'a aucun resultat, un tableau a deux 
	 * dimensions si la requete a des resultats
	 */
	static String[][] get(String request, String[] args) {
		
		// On recupere le resultat 
		ResultSet result = null;
		
		result = connect(request, args, "get");
		
		
		// On déclare la variable rsmd , metadonnees de la reponse
		ResultSetMetaData rsmd;
		
		// On initialise le nombre de colonnes et de lignes de la reponse
		int column_count = 0;
		int row_count = 0;
		
		
		// Si la reponse de la requete n'est pas null
		if (result != null) {
			try {
				// On place le curseur a la fin de la reponse
				result.last();
				// On recupere le nombre de colonnes
				row_count = result.getRow();
				// On revient au debut de la reponse
				result.first();
				
				// On recupere les metadonnees de la requettes
				rsmd = result.getMetaData();
				// On recupere le nombre de colones depuis les metadonnees
				column_count = rsmd.getColumnCount();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // EO Try/Catch
		   
		} // EO if
		
		String[][] total ;
		
		// Cas ou il n'y a pas de resultats
		if (row_count == 0) {
			// On met total a null
			total = null;
			// On retourne total
			return total;
		} // EO if
		
		// On initialise un tableau de tableaux avec les tailles de la reponse
		total = new String[row_count][column_count];
		// On initialise un sous-tableau
		String[] liste = null;

		// Bloc Try/Catch
		try {
			// Tant que i est inferieur au nombre de lignes
			for (int i = 0; i < row_count; i++) {
				// On initialise le sous tableau avec le nombre des fields 
				liste = new String[column_count];
				
				// Tant que i est inferieur ou egal au nombre de colonnes
				for (int y = 1; y <= column_count; y++) {
					// On ajoute le string au sous tableau
					liste[y-1] = result.getString(y);
				}
				// On ajoute le sous tableau au tableau principal
				total[i]= liste;
				
				// On place le curseur a la prochaine ligne
				result.next();
			} // EO fOR
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // EO Try/Catch
					
		// On retourne le tableau complet
		return total;
	} // EO get
	
	
	/**
	 * Fonction permettant d'inserer une nouvelle entitee dans la base de donnee
	 * @param request La requete a la base de donnees
	 * @param args Un tableau de String avec les parametres de la requete
	 * @return Un boolean en fonction du succes de la requete
	 */
	static boolean post(String request, String[] args) {
		// On déclare un booleen avec la valeur de faux
		boolean confirm = false;
		
		// On essaie d'executer la requete
		try {
			// Si la requete ne nous renvoie pas d'erreur
			connect(request, args, "post");
			// confirm prend la valeur de vrai
			confirm = true;
			
			// Si la requete nous renvoie une erreur
		} catch (Exception e) {
			// confirm prend la valeur faux
			confirm = false;
		} // EO Try/Catch
		
		// On retourne faux
		return confirm;
	}
	
	
	
}
