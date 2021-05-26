//-------------------------------------------------------------------------------------
// Date de création : 18/02/2021                  Version :1.0
// Pseudo : bloodkingH7                           Nom : HOUNNANKAN Prince-Donald
//-------------------------------------------------------------------------------------


//--------------------------APPEL DES BIBLIOTHEQUES------------------------------------
//Bibliotheque pour entree de clavier
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
//-------------------------------------------------------------------------------------



//Declaration de la classe Joueur pour demande d'information
class  Player {
    //Declaration des attributs
    String nom_player, prenom_player, franchise, Poste;
    int num_maillot;
    double taille, poids, envergure,general;
    //Declaration de la fonction d'instanciation de l'objet Joueur

    public Player (String name_player, String prename_player, String team, int maillot, Double taille, Double poids, Double envergure, String position, Double general){  
        this.nom_player = name_player;
        this.prenom_player = prename_player;
        this.franchise = team;
        this.Poste = position;
        this.num_maillot = maillot; 
        this.taille = taille;
        this.poids = poids;
        this.envergure = envergure;
        this.general = general;
    }//Fin instanciation
    
}//Fin CLASSE player

class Stats {
    //Declaration des tableau pour attribut
    double [] finishing = new double [5];
    double [] playmaking = new double [3];
    double [] shooting = new double [3];
    double [] defense = new double [6];
    double [] physicals = new double [5];
    public Stats (double [] finish, double [] play, double [] shoot, double [] def, double [] physic){
        for (int i = 0; i<5; i++){this.finishing[i] = finish[i];}
        for (int j = 0; j<3; j++){this.playmaking[j] = play[j];}
        for (int k = 0; k<3; k++){this.shooting[k] = shoot[k];}
        for (int p = 0; p<6; p++){this.defense[p] = def[p];}
        for (int m = 0; m<5; m++){this.physicals[m] = physic[m];}
    }
}








public class App {

    static public void Fichier (Player P, Stats S) throws IOException{


        String [] tableau_defaut = {"NOM","PRENOM","EQUIPE","NUMERO MAILLOT","TAILLE (m)","POIDS (kg)","ENVERGURE (m)","POSTE","GENERALE"};

        String str = String.valueOf(P.num_maillot);
        String str1 = String.valueOf(P.taille);
        String str2 = String.valueOf(P.poids);
        String str3 = String.valueOf(envergure);
        String str4 = String.valueOf(general);
        //Tableau contenant info profil joueur
        String [] tableau_profil = {P.nom_player,P.prenom_player,P.franchise,str,str1,str2,str3,P.Poste,str4};
        //Tableau contenant stats pour chaque joueurs (Saison)

        


        //CREATION DU FICHIER
        HSSFWorkbook new_document = new HSSFWorkbook(); //creation nouveau document vide excel(sans feuille de calcul)
        HSSFSheet new_feuille = new_document.createSheet("PROFILE PLAYER");  //creation d'une feuille de calcul dans new_document (sans lignes ni colonnes)
        //Creation de la ligne par defaut dans PROFILE PLAYER (new_feuille) : "NOM" ""PRENOM" .....
        Row row_default = new_feuille.createRow((short)0);
        for (int p = 0; p<9; p++){
            Cell cellule = row_default.createCell(p);
            cellule.setCellValue(tableau_defaut[p]);
        }

        //Creation du reste des lignes et cellules pour le joueur
        Row row_1 = new_feuille.createRow((short)1);
        for (int p = 0; p<9; p++){
            Cell cellule_1 = row_1.createCell(p);
            cellule_1.setCellValue(tableau_profil[p]);
        }

        //Creation du fichier dans le dossier voulu
        File file = new File("C:/Users/Utilisateur/Desktop/TP_des_Cours_EN8LIGNES/Java Program/Basket_Stats_Calculator/Basketball_Calculator_Stats/BDD_PLAYERS.xls");
        file.getParentFile().mkdirs();

        try {
            FileOutputStream outFile = new FileOutputStream(file);
            new_document.write(outFile);
            new_document.close(); //Fermeture du fichier excel
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Created file: " + file.getAbsolutePath()); //Juste un message pour dire que le fichier a bien ete crée
    
    }



    
    //Declaration variables pour recuperer les entrées au clavier
    static Scanner clavier_nbr = new Scanner(System.in); //pour identifier les entrer de type Int au clavier
    static Scanner clavier_texte = new Scanner(System.in); //pour identifier les entrer de type String au clavier
    static Scanner clavier_nbr_virgule = new Scanner(System.in); //pour identifier les entrer de type Double au clavier

    //Variables pour permettre la recup des données par l'user
    static String nom_joueur, prenom_joueur, position_joueur, equipe_joueur;
    static int numero_joueur;
    static double tall, Kg, envergure,general;

    //Variables de stats
    static double [] finition = new double [5];
    static double [] tire = new double [3];
    static double [] organisation = new double [3];
    static double [] defence = new double [6];
    static double [] physicals = new double [5];

    static double somme1,somme2, somme3, somme4, somme5;
    static double moy_finition, moy_tire, moy_organisation, moy_defence, moy_physicals;

    //FONCTION PRINCIPALE
    public static void main(String[] args) throws Exception {
        
        //Demande des informations sur le JOUEUR
        System.out.println("Entrer le nom du joueur : ");
        nom_joueur = clavier_texte.nextLine();
        System.out.println("Entrer le prenom du joueur : ");
        prenom_joueur = clavier_texte.nextLine();
        System.out.println("Entrer la team du joueur : ");
        equipe_joueur = clavier_texte.nextLine();
        System.out.println("Entrer le numero de maillot du joueur : ");
        numero_joueur = clavier_nbr.nextInt();
        System.out.println("Entrer la taille du joueur : ");
        tall = clavier_nbr_virgule.nextDouble();
        System.out.println("Entrer le poids du joueur : ");
        Kg = clavier_nbr_virgule.nextDouble();
        System.out.println("Entrer l'envergure du joueur : ");
        envergure = clavier_nbr_virgule.nextDouble();
        System.out.println("Entrer la position du joueur : ");
        position_joueur = clavier_texte.nextLine();

        //Demande infos sur STATS du joueur
        for (int a = 0; a<5; a++){
            System.out.println("Valeurs attributs "+ a +" :");
            finition [a] = clavier_nbr_virgule.nextDouble();
            somme1 += finition[a];
        }
        moy_finition = somme1/5;

        for (int b = 0; b<3; b++){
            System.out.println("Valeurs attributs "+ b +" :");
            tire [b] = clavier_nbr_virgule.nextDouble();
            somme2 += tire[b];
        }
        moy_tire = somme2/3;

        for (int c = 0; c<3; c++){
            System.out.println("Valeurs attributs "+ c +" :");
            organisation [c] = clavier_nbr_virgule.nextDouble();
            somme3 += organisation[c];
        }
        moy_organisation = somme3/3;

        for (int d = 0; d<6; d++){
            System.out.println("Valeurs attributs "+ d +" :");
            defence[d] = clavier_nbr_virgule.nextDouble();
            somme4 += defence[d];
        }
        moy_defence = somme4/6;

        for (int e = 0; e<5; e++){
            System.out.println("Valeurs attributs "+ e +" :");
            physicals[e] = clavier_nbr_virgule.nextDouble();
            somme5 += physicals[e];
        }
        moy_physicals = somme5/5;

       
        //Calcul du general du joueur
        general = (int)(moy_defence + moy_finition + moy_organisation + moy_physicals + moy_tire)/5;

        //Instanciation du joueur cree par l'USER

        Player S = new Player(nom_joueur, prenom_joueur, equipe_joueur, numero_joueur, tall, Kg, envergure, position_joueur, general);
        Stats M = new Stats(finition, organisation, tire, defence, physicals);

        //Creation du Fichier ECXEL
        Fichier (S, M);
        
        clavier_nbr.close();
        clavier_texte.close();
        clavier_nbr_virgule.close();

        

    }//FIN FONCTION PRINCIPALE
}
