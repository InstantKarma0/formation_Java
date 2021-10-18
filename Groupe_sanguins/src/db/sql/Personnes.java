package db.sql;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import util.Logger;

public class Personnes {
    static Scanner Saisie = new Scanner (System.in);
    /**
     * Fonction permettant d'obtenir les personnes étant du groupe sanguin saisie par l'utilisateur 
     * @param groupeName
     */
    public static String [][] searchGroupePersonneFromGroupeName (String groupeName){
        String [] groupeStrings = {groupeName};
        return Sql.get("SELECT p.nom FROM personnes p WHERE p.groupe = (SELECT g.id FROM groupe_sanguin g WHERE g.nom = ?" , groupeStrings );

    }//EO searchGroupePersonneFromGroupeName

    /**
     * Fonction permettant d'obtenir les personnes en fontion de leur nom ET de leur prenom
     * @param nom
     * @param prenom
     * @return
     */
    public static String [][] searchPersonneFromNomANDPrenom (String nom, String prenom){
        String [] groupeParam = {nom , nom , prenom};
        return Sql.get("SELECT p.prenom, p.nom, p.age, (SELECT g.nom FROM groupe_sanguin g WHERE g.id = (SELECT p.groupe_id FROM personnes p WHERE p.nom = ? )) FROM personnes p WHERE p.nom = ? AND p.prenom = ?", groupeParam);
    }//EO searchPersonneFromANDprenom

    /**
     * Fonction permettant d'ajouter une nouvelles entrée dans la base de données
     * @param nom
     * @param prenom
     * @param age
     * @param groupeSanguin sous forme "AB+"
     * @return un boolean
     */
    private static boolean addBDD (String nom, String prenom, int age , String groupeSanguin){
        String [] groupeAjout = {prenom,nom, String.valueOf(age) ,groupeSanguin};
        return Sql.post("INSERT INTO personnes (prenom , nom, age , groupe_id) VALUES (? , ?, ? , (SELECT id FROM groupe_sanguin WHERE nom = ?))", groupeAjout);
    }//EO addBDD

    /**
     * Fonction permet de demander et de vérifier le prenom, le nom, l'age et le groupe sanguin de l'utilsateur avant de 
     * les entrer dans la base de données
     */
    public static void verifSaisieAddBDD (){
        String nom ;
        String prenom ;
        int age = -1;
        String groupeSanguin;

        do {
            System.out.print("Veuillez nous donner votre nom : ");
            nom = Saisie.next();
        }while (!(nom.matches("^[A-Z][a-zàâäöôéèëêùïî$$-]{1,20}$")));
        do{
            System.out.print("Votre prenom : ");
            prenom = Saisie.next();
        }while(!(prenom.matches("^[A-Z][a-zàâäöôéèëêùïî$$-]{1,20}$")));
        do{
            System.out.print("Votre age :");
            try {
                age = Saisie.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Erreur veuillez saisir un age valide");
                Saisie.next();
            }//EO try catch
        }while(!(age >= 1 && age <= 120));
        do{
            System.out.print("Votre groupe sanguin :");
            groupeSanguin = Saisie.next();
            
            if (!(groupeSanguin.matches("^[A][B][+|-]|[A|B|O][+|-]$"))) {
            	System.out.println("Veuillez saisir un groupe sanguin valide.");
            }
        }while(!(groupeSanguin.matches("^[A][B][+|-]|[A|B|O][+|-]$")));

        if (addBDD(nom, prenom, age, groupeSanguin)) {
        	System.out.println("Vous avez bien été enregistré dans la base de donnée.");
        } else {
        	System.out.println("Une erreur est survenue, veuillez reessayer plus tard.");
        }

    }//EO verifSaisieAddBDD

    /**
     * Fonction permettant de récuperer la liste des donneurs en fonction 
     * d'un groupe danguin donner qui sera vérifié
     */
    public static void getDonneurs(){
        String groupeSanguin ;
        String [][] retourRequete;
        do{
            System.out.print("Quel est votre groupe sanguin ? :");
            groupeSanguin = Saisie.next();
        }while(!(groupeSanguin.matches("^[A][B][+|-]|[A|B|O][+|-]$")));
        retourRequete = getDonneursFromGroupName(groupeSanguin);
        System.out.print("Le groupe sanguin " + groupeSanguin + " peut donner au(x) groupe(s) ");
        for (int i = 0 ; i < retourRequete.length; i++){
            System.out.print(Arrays.toString(retourRequete[i]));
        }//EO for
    }//EO getDonneurs

    /**
     * Fonction permettant de récuperer la liste des receveurs en fonction 
     * d'un groupe danguin donner qui sera vérifié
     */
    public static void getReceveurs(){
        String groupeSanguin ;
        String [][] retourRequete ;
        do{
            System.out.print("Quel est votre groupe sanguin ? :");
            groupeSanguin = Saisie.next();
        }while(!(groupeSanguin.matches("^[A][B][+|-]|[A|B|O][+|-]$")));
        retourRequete = getReceveursFromGroupName(groupeSanguin);
        System.out.print("Le groupe sanguin " + groupeSanguin + " peut recevoir du/des groupe(s) ");
        for (int i = 0 ; i < retourRequete.length; i++){
            System.out.print(Arrays.toString(retourRequete[i]));
        }//EO for
    }//EO getReceveurs

    /**
     * Fonction contenant la requete Sql permettant de récuperer les donneurs 
     * en fontion du nom du groupe sanguin
     * @param groupeSanguin
     * @return
     */
    private static String[][] getDonneursFromGroupName(String groupeSanguin){
        String [] groupeName = {groupeSanguin};
        Logger.logByDate("SELECT nom FROM groupe_sanguin WHERE id IN (SELECT id_donneur FROM donneur WHERE id_groupe_sanguin = (SELECT id FROM groupe_sanguin WHERE nom = ?))", groupeName, "D:/logs/user_logs");
        return Sql.get("SELECT nom FROM groupe_sanguin WHERE id IN (SELECT id_donneur FROM donneur WHERE id_groupe_sanguin = (SELECT id FROM groupe_sanguin WHERE nom = ?))", groupeName);

    }//EO getDonneursFromGroupName

    /**
     * Fonction contenant la requete Sql permettant de récuperer les receveurs
     * en fontion du nom du groupe sanguin
     * @param groupeSanguin
     * @return
     */
    private static String[][] getReceveursFromGroupName (String groupeSanguin){
        String [] groupeName = {groupeSanguin};
        return Sql.get("SELECT nom FROM groupe_sanguin WHERE id IN (SELECT id_receveur FROM receveur WHERE id_groupe_sanguin = (SELECT id FROM groupe_sanguin WHERE nom = ?))", groupeName);
    }//EO getReceveursFromGroupName

}// EO Personnes
