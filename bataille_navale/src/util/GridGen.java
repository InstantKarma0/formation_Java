package util;

public class GridGen {

	static String topgrid = "    1   2   3   4   5   6   7   8   9   10\n";
	static String lineseparator = "   ----------------------------------------\n";
	
	
	public static void gridConsole(int[][] shippos) {
		String grid = "";
		
		grid = grid + topgrid + lineseparator;
		for (int i = 0; i < shippos.length; i++) {
			String linegrid = "";
			linegrid = linegrid + Character.toUpperCase(AsciiConvert.intToAscii(i)) + " |";
			for (int y = 0; y < shippos[i].length; y++) {
				switch (shippos[i][y]) {
				case 0:
					linegrid = linegrid + "   ";
					break;
				case 1:
					linegrid = linegrid + " B ";
					break;
				case 2:
					linegrid = linegrid + " X ";
					break;
				case 3:
					linegrid = linegrid + " T ";
					break;
				}
				linegrid = linegrid + "|";
			}
			linegrid = linegrid + "\n";
			grid = grid + linegrid + lineseparator;
			
		}
		System.out.println(grid);
	}
}
