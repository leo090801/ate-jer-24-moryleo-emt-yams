import java.util.Scanner;

public class Main {

    public static final int NBRE_DE_DEE = 5;

    /**
     * simule le lancer d'un dée
     * @return le résultat du lancer
     */
    static int lancerDee() {
        return (int)(Math.random() * 6 + 1);
    }

    /**
     * lancer 5 dés et retourne les 5 résultats
     * @return la valeur des 5 dés
     */
    static int[] lancerTousLesDes(int nbreDeDee) {
        int[] dee = new int[nbreDeDee];

        for (int indexArray = 0; indexArray < dee.length; indexArray++) {
            dee[indexArray] = lancerDee();
        }

        return dee;
    }

    /**
     * calculer le total des 5 lancers de dés
     * @param dee Résultat des dés
     * @return le total des résultats des dés
     */
    static int calculerTotal(int[] dee) {

        int total = 0;

        for (int i = 0; i < dee.length; i++) {
            total += dee[i];
        }

        return total;
    }

    static void afficherDee(int[] dee) {

        System.out.print("Résultat : ");

        for (int indexArray = 0; indexArray < dee.length; indexArray++) {
            System.out.print(dee[indexArray] + " ");
        }
        System.out.print("\n");
    }

    /**
     * Écrit un message saisi en paramètre et demande la saisie d'un entier
     * @param prompt message affiché
     * @return l'entier saisi
     */
    static int saisirInt(String prompt) {

        Scanner scanner = new Scanner(System.in);

        System.out.print(prompt);

        return scanner.nextInt();
    }

    /**
     * Relance les dés passé en paramètre
     * @param dee Dés du jeu.
     * @param deeARelancer Dés à relancer.
     */
    public static void relancerDes(int[] dee, String deeARelancer) {

        // Relance les dés indiqués dans la chaîne de charactères passés en paramètres
        for (int index = 0; index < deeARelancer.length(); index++) {
           dee[Integer.parseInt(String.valueOf(deeARelancer.charAt(index))) - 1] = lancerDee();
        }
    }



    public static void main(String[] args) {

        // Les 5 dés, qui sont lancés.
        int[] dee = lancerTousLesDes(5);

        boolean continuer = true;

        Scanner scanner = new Scanner(System.in);

        int nbreEssai = 1;

        do {

            afficherDee(dee);
            System.out.println("Total : " + calculerTotal(dee));

            int choix = saisirInt("\n1 : Relancer\n2 : garder\nVotre choix : ");

            if (choix == 1) {
                nbreEssai++;

                System.out.print("Quels dés tu veux relancer (taper la place des dés de 1 à 5 que vous voulez relancer. exemple : 125) : ");

                String deeARelancer = scanner.nextLine();

                // relance les dés saisis
                relancerDes(dee, deeARelancer);

            } else {
                continuer = false;
            }
        } while (nbreEssai < 3 && continuer);

        afficherDee(dee);

        System.out.println("Total final : " + calculerTotal(dee));
    }
}