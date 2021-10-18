package main;


import java.util.InputMismatchException;
import java.util.Scanner;
import db.sql.Personnes;

public class Main {
	static Scanner Saisie = new Scanner (System.in);
	public static void main(String[] args) {
		int choix = -1;
		do {
		System.out.println("------------------MENU------------------");
		System.out.println("1. S'ajouter à la base de données");
		System.out.println("2. Savoir de quel groupe sanguin peut-on recevoir");
		System.out.println("3. Savoir de quel groupe sanguin peut-on donner");
			try{
				choix = Saisie.nextInt();
			}catch (InputMismatchException e){
				System.out.println("Erreur de saisie veuillez entrer 1 ou 2");
			}//EO try catch
		}while(!(choix >= 1 && choix <=3));
		//Affichage du menu et vérification de la saisie

		switch (choix){
			case 1 :
				Personnes.verifSaisieAddBDD();
				break ;
			case 2 :
				Personnes.getReceveurs();
				break ;
			case 3 :
				Personnes.getDonneurs();
				break;
		}//EO switch
		//Switch permettant de pointer le choix de l'utilisateur vers la bonne fonction
		
	}// EO main

}//EO Main
