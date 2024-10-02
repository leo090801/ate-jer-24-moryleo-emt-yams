import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public final static int NB_YAMS = 0;
    public final static int NB_FULL = 1;
    public final static int NB_CARRE = 2;
    public final static int NB_BRELAN = 3;
    public final static int NB_PETITE_SUITE = 4;
    public final static int NB_GRANDE_SUITE = 5;
    public final static int NB_CHANCE = 6;

    public static final int NBRE_DE_DEE = 5;

    /**
     * Simule le lancer d'un dée
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

    /**
     * affiche les dés
     * @param dee dés à afficher
     */
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

    /**
     * calcule le nombre de chaque chiffre et calcule si il y a un brelan
     * @param dee les dés lancés
     * @return 0 si il n'y a pas de brelan et sinon l'entier qui correspond au brelan
     */
    public static int estBrelan(int[] dee) {
        int[] nbreDeDesPourChaqueNombre = new int[6];

        // Compte le nombre de fois qu'il y a eu chaque chiffre.
        for (int indexDee = 0; indexDee < dee.length; indexDee++) {
            nbreDeDesPourChaqueNombre[dee[indexDee] - 1]++;
        }

        return nbreDeDesPourChaqueNombre[0] >= 3 ? 1 :
                nbreDeDesPourChaqueNombre[1] >= 3 ? 2 :
                nbreDeDesPourChaqueNombre[2] >= 3 ? 3 :
                nbreDeDesPourChaqueNombre[3] >= 3 ? 4 :
                nbreDeDesPourChaqueNombre[4] >= 3 ? 5 :
                nbreDeDesPourChaqueNombre[5] >= 3 ? 6 : 0;
    }

    /**
     * calcule le nombre de chaque chiffre et calcule si il y a un carre
     * @param dee les dés lancés
     * @return 0 si il n'y a pas de carre et sinon l'entier qui correspond au carre
     */
    public static int estCarre(int[] dee) {
        int[] nbreDeDesPourChaqueNombre = new int[6];

        // Compte le nombre de fois qu'il y a eu chaque chiffre.
        for (int indexDee = 0; indexDee < dee.length; indexDee++) {
            nbreDeDesPourChaqueNombre[dee[indexDee] - 1]++;
        }

        return nbreDeDesPourChaqueNombre[0] >= 4 ? 1 :
                nbreDeDesPourChaqueNombre[1] >= 4 ? 2 :
                nbreDeDesPourChaqueNombre[2] >= 4 ? 3 :
                nbreDeDesPourChaqueNombre[3] >= 4 ? 4 :
                nbreDeDesPourChaqueNombre[4] >= 4 ? 5 :
                nbreDeDesPourChaqueNombre[5] >= 4 ? 6 : 0;
    }

    /**
     * calcule si les dés sont une petite suite
     * @param dee Dés lancés
     * @return true si c'est une petite suite, false sinon
     */
    public static boolean estPetiteSuite(int[] dee) {

        int nbreSuite = 1;

        int nbreLePlusBas = 1;

        // Compte le nombre de fois qu'il y a eu chaque chiffre.
        for (int compteur = 0; compteur < 3; compteur++) {
            nbreLePlusBas = compteur;

            nbreSuite = nbreLePlusBas;

            for (int compteur2 = 0; compteur2 < dee.length; compteur2++) {

                for (int indexDes = 0; indexDes < dee.length; indexDes++) {
                    if (dee[indexDes] == nbreSuite + 1) {
                        nbreSuite++;
                    }
                }
            }
            if (nbreSuite >= nbreLePlusBas + 4) {
                break;
            }
        }

        return nbreSuite >= nbreLePlusBas + 4;
    }

    /**
     * calcule si les dés forme une grande suite
     * @param dee les dés lancés
     * @return true si c'est une grande suite et false sinon
     */
    public static boolean estGrandeSuite(int[] dee) {

        int nbreSuite = 1;

        int nbreLePlusBas = 1;

        // Compte le nombre de fois qu'il y a eu chaque chiffre.
        for (int compteur = 0; compteur < 2; compteur++) {
            nbreLePlusBas = compteur;

            nbreSuite = nbreLePlusBas;

            for (int compteur2 = 0; compteur2 < dee.length; compteur2++) {

                for (int indexDes = 0; indexDes < dee.length; indexDes++) {
                    if (dee[indexDes] == nbreSuite + 1) {
                        nbreSuite++;
                    }
                }
            }
            if (nbreSuite >= nbreLePlusBas + 5) {
                break;
            }
        }

        return nbreSuite >= nbreLePlusBas + 5;
    }

    /**
     * calcule si la suite de dés forme un yams
     * @param dee La suite de Dés
     * @return true si c'est un yams false sinon
     */
    public static boolean estYams(int[] dee) {

        int[] nbreDeDesPourChaqueNombre = new int[6];

        // Compte le nombre de fois qu'il y a eu chaque chiffre.
        for (int indexDee = 0; indexDee < dee.length; indexDee++) {
            nbreDeDesPourChaqueNombre[dee[indexDee] - 1]++;
        }

        return nbreDeDesPourChaqueNombre[0] == 5 ||
                nbreDeDesPourChaqueNombre[1] == 5 ||
                nbreDeDesPourChaqueNombre[2] == 5 ||
                nbreDeDesPourChaqueNombre[3] == 5 ||
                nbreDeDesPourChaqueNombre[4] == 5 ||
                nbreDeDesPourChaqueNombre[5] == 5;
    }

    /**
     * calcule si la suite de dés forme un full
     * @param dee La suite de Dés.
     * @return true si c'est un full false sinon
     */
    public static boolean estFull(int[] dee) {

        int[] nbreDeDesPourChaqueNombre = new int[6];

        // Compte le nombre de fois qu'il y a eu chaque chiffre.
        for (int indexDee = 0; indexDee < dee.length; indexDee++) {
            nbreDeDesPourChaqueNombre[dee[indexDee] - 1]++;
        }

        boolean aBrelan = false;

        boolean aPaire = false;

        for (int nombre : nbreDeDesPourChaqueNombre) {
            if (nombre == 2) {
                aPaire = true;
            } else if (nombre == 3) {
                aBrelan = true;
            }
        }

        return aPaire && aBrelan;
    }

    /**
     * Donne les points obtenus pour chaque cas au yams (0 points si la suite de dés ne remplit pas ce cas)
     * @param suiteDeDee la suite de dés
     * @return les points obtenus pour chaque cas
     */
    public static int[] getPointsObtenuPourChaqueCas(int[] suiteDeDee) {

        int[] pointsObtenuPourChaqueCas = new int[7];

        pointsObtenuPourChaqueCas[NB_YAMS] = estYams(suiteDeDee) ? 50 : 0;

        pointsObtenuPourChaqueCas[NB_FULL] = estFull(suiteDeDee) ? 25 : 0;

        pointsObtenuPourChaqueCas[NB_CARRE] = estCarre(suiteDeDee) * 4;

        pointsObtenuPourChaqueCas[NB_BRELAN] = estBrelan(suiteDeDee) * 3;

        pointsObtenuPourChaqueCas[NB_PETITE_SUITE] = estPetiteSuite(suiteDeDee) ? 30 : 0;

        pointsObtenuPourChaqueCas[NB_GRANDE_SUITE] = estGrandeSuite(suiteDeDee) ? 40 : 0;

        pointsObtenuPourChaqueCas[NB_CHANCE] = calculerTotal(suiteDeDee);

        return pointsObtenuPourChaqueCas;
    }

    /**
     * Calcule le cas qui rapporte le plus de point avec la suite de dés inscrit en paramètres
     * @param suiteDeDee La suite de dés
     * @return le num du cas
     */
    public static int getCas(int[] suiteDeDee, boolean[] casDejaObtenu) {

        int[] pointsObtenuPourChaqueCas = getPointsObtenuPourChaqueCas(suiteDeDee);

        int casPlusGrand = 0;

        int lePlusDePoints = 0;

        for (int indexArray = 0; indexArray < 6; indexArray++) {
            if (pointsObtenuPourChaqueCas[indexArray] > lePlusDePoints && !casDejaObtenu[indexArray]) {
                casPlusGrand = indexArray;
                lePlusDePoints = pointsObtenuPourChaqueCas[indexArray];
            }
        }

        if (lePlusDePoints == 0) {
            casPlusGrand = 6;
        }

        return casPlusGrand;
    }

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

        Scanner scanner = new Scanner(System.in);

        int points = 0;

        boolean[] casDejaObtenu = { false, false, false, false, false, false, false };

        for (int noManche = 0; noManche < 5; noManche++) {

            int nbreEssai = 1;

            boolean continuer = true;

            // Les 5 dés, qui sont lancés.
            int[] dee = lancerTousLesDes(5);

            do {

                afficherDee(dee);

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

            int casObtenu = getCas(dee, casDejaObtenu);

            if (!(casObtenu == 6 && casDejaObtenu[6])) {
                casDejaObtenu[casObtenu] = true;

                points += getPointsObtenuPourChaqueCas(dee)[casObtenu];

                System.out.println("Vous avez obtenu " + getStrCas(casObtenu) + ".");

                System.out.println("points obtenu : " + getPointsObtenuPourChaqueCas(dee)[casObtenu] + ".");

            } else {
                System.out.println("Vous avez rien obtenu.");
            }

            System.out.println("points totaux : " + points + ".");

        }
    }
}