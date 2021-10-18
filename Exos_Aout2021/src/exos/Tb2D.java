package exos;

public class Tb2D {

	
	public static void affichage() {
		int[][] tb = {{1,2,5,8},{4,7,3,2}};
		String upDown = "+----------+----------+----------+----------+";
		String ligne = "";
		System.out.println(upDown);
		for (int i = 0; i < tb.length; i ++) {
			ligne+="| ";
			for (int y = 0; y < tb[i].length; y++) {
				ligne = ligne + "tb[" + i + "][" + y + "] | ";
			}
			System.out.println(ligne + "\n" + upDown);
			ligne = "";
		}
		
	}
}
