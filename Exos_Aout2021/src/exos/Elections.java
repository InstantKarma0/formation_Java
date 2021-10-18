package exos;

public class Elections {

	public static void main() {
		int voteA = 0;
		int voteB = 0;
		int voteC = 0;
		int voteD = 0;
		
		int voteTotal = voteA + voteB + voteC + voteD;
		
		if (voteA >= (voteTotal/2)) {
			System.out.println("A Gagne au premier tour");
		} else if (voteA >= (voteTotal/8)) {
			
			// Ballotage
			if (voteA < voteB || voteA < voteC || voteA < voteD) {
				System.out.println("A passe au 2nd tour, ballotage defavorble");
				
			} else {
				System.out.println("A passe au 2nd tour, ballotage favorable");
			}
			
			
		} else {
			System.out.println("A est battu");
		}
		
		
		
	}
	
}
