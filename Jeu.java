import java.util.Scanner;

public class Jeu {

    MainDeDé mainDeDé = new MainDeDé();

    private int score = 0;

    boolean[] casDejaObtenu = {false, false, false, false, false, false, false};

    public final static int NB_YAMS = 0;
    public final static int NB_FULL = 1;
    public final static int NB_CARRE = 2;
    public final static int NB_BRELAN = 3;
    public final static int NB_PETITE_SUITE = 4;
    public final static int NB_GRANDE_SUITE = 5;
    public final static int NB_CHANCE = 6;

    /**
     * Construit un objet jeu avec les valeurs par défaut.
     */
    public Jeu() {

    }

    /**
     * Donne les points obtenus pour chaque cas au yams (0 points si la suite de dés ne remplit pas ce cas)
     *
     * @return les points obtenus pour chaque cas
     */
    public int[] getPointsObtenuPourChaqueCas() {

        int[] pointsObtenuPourChaqueCas = new int[7];

        pointsObtenuPourChaqueCas[NB_YAMS] = Combinaisons.estYams(mainDeDé.getMainDeDes()) ? 50 : 0;

        pointsObtenuPourChaqueCas[NB_FULL] = Combinaisons.estFull(mainDeDé.getMainDeDes()) ? 25 : 0;

        pointsObtenuPourChaqueCas[NB_CARRE] = Combinaisons.estCarre(mainDeDé.getMainDeDes()) * 4;

        pointsObtenuPourChaqueCas[NB_BRELAN] = Combinaisons.estBrelan(mainDeDé.getMainDeDes()) * 3;

        pointsObtenuPourChaqueCas[NB_PETITE_SUITE] = Combinaisons.estPetiteSuite(mainDeDé.getMainDeDes()) ? 30 : 0;

        pointsObtenuPourChaqueCas[NB_GRANDE_SUITE] = Combinaisons.estGrandeSuite(mainDeDé.getMainDeDes()) ? 40 : 0;

        pointsObtenuPourChaqueCas[NB_CHANCE] = mainDeDé.calculerTotal();

        return pointsObtenuPourChaqueCas;
    }

    /**
     * Calcule le cas qui rapporte le plus de point avec la suite de dés inscrit en paramètres
     *
     * @return le num du cas
     */
    public int getCas() {

        int[] pointsObtenuPourChaqueCas = getPointsObtenuPourChaqueCas();

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
     *
     * @param noCas le numéro du cas obtenu
     * @return le string du cas
     */
    public String getStrCas(int noCas) {

        String[] nomDesCas = {"un yams", "un full", "un carre", "un brelan", "une petite suite", "une grande suite", "la chance"};

        return nomDesCas[noCas];

    }

    /**
     * Écrit un message saisi en paramètre et demande la saisie d'un entier
     *
     * @param prompt message affiché
     * @return l'entier saisi
     */
    static int saisirInt(String prompt) {

        Scanner scanner = new Scanner(System.in);

        System.out.print(prompt);

        return scanner.nextInt();
    }

    /**
     * Fait la manche (pour obtenir la suite de dé finale de la manche)
     */
    public void faireLaManche() {

        Scanner scanner = new Scanner(System.in);

        int nbreEssai = 1;

        boolean continuer = true;

        // Les 5 dés sont lancés.
        mainDeDé.lancerTousLesDes();

        do {

            mainDeDé.afficherDee();

            int choix = saisirInt("\n1 : Relancer\n2 : garder\nVotre choix : ");

            if (choix == 1) {
                nbreEssai++;

                System.out.print("Quels dés tu veux relancer (taper la place des dés de 1 à 5 que vous voulez relancer. exemple : 125) : ");

                String deeARelancer = scanner.nextLine();

                // relance les dés saisis
                mainDeDé.relancerDes(deeARelancer);

            } else {
                continuer = false;
            }
        } while (nbreEssai < 3 && continuer);
    }

    /**
     * Ajoute le nombre de point écrit en paramètre au score.
     *
     * @param pointAAjouter Point à ajouter.
     */
    public void addPoints(int pointAAjouter) {
        score += pointAAjouter;
    }

    /**
     * @return le score
     */
    public int getScore() {
        return score;
    }
}
