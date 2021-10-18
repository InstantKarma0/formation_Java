package util;

public class Affichage {

	public static void fullDisplay(int[][] shippos, int[][] hitpos) {
		gridDisplay(shippos);
		gridDisplay(hitpos);
		
	}
	
	
	public static void gridDisplay(int[][] grid) {
		GridGen.gridConsole(grid);
		
	}
}
