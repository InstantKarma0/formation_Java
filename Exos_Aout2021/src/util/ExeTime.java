package util;

/**
 * Classe de recuperation du temps d'execution
 * @author Corentin
 * 
 */

public class ExeTime {
	
	/**
	 * Définit le temps de debut de programme
	 * @param None
	 * @return Variable de type long
	 * 
	 */
	public static long getTimeDebut(){
		long td = System.currentTimeMillis();
		return td;
	}// EO getTimeDebut
	
	
	/**
	 * Définit le temps de fin de programme
	 * @param None
	 * @return Variable de type long
	 */
	public static long getTimeFin() {
		long tf = System.currentTimeMillis();
		return tf;
	}// EO getTimeFin
	
	
	/**
	 * Calcule le temps d'execution en milisecondes
	 * @param td (tempsDébut) de type long
	 * @param tf (tempsFin) de type long
	 * @return Le temps d'execution, Variable de type long
	 */
	public static long getExeTime(long td, long tf) {
		return tf - td;
	}// EO getExeTime
	
}// EO Classe ExeTime