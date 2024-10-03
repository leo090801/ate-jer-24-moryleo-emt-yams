import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /**
     * Retourne la chaine de charactères qui correspond au cas obtenu.
     * @param noCas le numéro du cas obtenu
     * @return le string du cas
     */
    public static String getStrCas(int noCas) {

        String[] nomDesCas = { "un yams", "un full", "un carre", "un brelan", "une petite suite", "une grande suite", "la chance" };

        return nomDesCas[noCas];

    }

    public static void main(String[] args) {

        Jeu jeu = new Jeu();

        for (int noManche = 0; noManche < 5; noManche++) {

            // fait la manche
            jeu.faireLaManche();

            jeu.mainDeDé.afficherDee();

            int casObtenu = jeu.getCas();

            if (!(casObtenu == 6 && jeu.casDejaObtenu[6])) {
                jeu.casDejaObtenu[casObtenu] = true;

                jeu.addPoints(jeu.getPointsObtenuPourChaqueCas()[casObtenu]);

                System.out.println("Vous avez obtenu " + jeu.getStrCas(casObtenu) + ".");

                System.out.println("points obtenu : " + jeu.getPointsObtenuPourChaqueCas()[casObtenu] + ".");

            } else {
                System.out.println("Vous avez rien obtenu.");
            }

            System.out.println("points totaux : " + jeu.getScore() + ".");

        }
    }
}