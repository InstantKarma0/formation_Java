package bataille_navale;

import prep.Pmode;
import util.Affichage;
import util.ClearConsole;
import util.ExeTime;
import util.ScanWithLabel;
import display.Fenetre;
import entities.*;

public class Main {
	
	// TODO DOC

	public static void main(String[] args) {
		
		
		
		
		// Create 2 instances of Player
		Player J1 = new Player();
		Player J2 = new Player();
		//Fenetre fun = new Fenetre(J1.getShipPos());

		// Selecte the Game Mode
		int mode = Pmode.select();
		// If mode == 0 , J2 become a IA instance
		if (mode == 0) {
			J2 = new Ia();
		}
		

		// Every Player setup their ships
		J1.placement();
		J2.placement();
		
		
		int winner = -1;
		Player current = J1;
		Player other = J2;
		int turn = 0;
		while (winner < 0) {
			turn++;
			
			 
			
			 
			 // Affichage des deux grilles
			 if (!(current instanceof Ia)) {
				 if (current == J1) { System.out.println("Tour du joueur 1");
				 } else {
				 System.out.println("Tour du joueur 2"); 
				 } // EO If
				 
				 Affichage.fullDisplay(current.getHitPos(),current.getShipPos());
			 }
				 
			 
			
			
			int[] fireArray = current.fireAim();
			int hit = other.checkfire(fireArray);
			
			if (hit == 1) { System.out.println("Touch�!"); } else {
			System.out.println("Rat�!"); }
			// EO If
			
			current.addfirepos(fireArray, hit);
			
			if (other.getHitpoints() == 0) {
				if (J2.getHitpoints() < J1.getHitpoints()) {
					winner = 0;
					continue;
				} else {
					winner = 1;
					continue;
				}// EO IF
			} // EO If
			
			Player transi = current;
			current = other;
			other = transi;
			transi = null;
			
			if (!(current instanceof Ia)) {
				ClearConsole.clean();
				ClearConsole.clean();
			}
			
			
			
		} // EO While
		
		System.out.println("le joueur "+ (winner+1) + " a gagn� en " + (turn/2) + " tours.");
		
		long tf = ExeTime.getTimeFin();
		System.out.println(ExeTime.getExeTime(td, tf) + " ms");
	} // EO Main

} // EO Program
