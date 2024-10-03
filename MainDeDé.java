public class MainDeDé {
    private int[] mainDeDes = new int[5];

    /**
     * Construit une main de dé basique.
     */
    public MainDeDé() {

    }

    /**
     * Simule le lancer d'un dée
     * @return le résultat du lancer
     */
    public int lancerDee() {
        return (int)(Math.random() * 6 + 1);
    }

    /**
     * Calcule le total des 5 lancers de dés.
     * @return le total des résultats des dés.
     */
    public int calculerTotal() {

        int total = 0;

        for (int mainDeDe : mainDeDes) {
            total += mainDeDe;
        }

        return total;
    }

    /**
     * Relance les dés passé en paramètre.
     * @param deeARelancer Dés à relancer.
     */
    public void relancerDes(String deeARelancer) {

        // Relance les dés indiqués dans la chaîne de charactères passés en paramètres
        for (int index = 0; index < deeARelancer.length(); index++) {
            mainDeDes[Integer.parseInt(String.valueOf(deeARelancer.charAt(index))) - 1] = lancerDee();
        }
    }

    /**
     * Lance les 5 dés.
     */
    public void lancerTousLesDes() {
        for (int indexArray = 0; indexArray < mainDeDes.length; indexArray++) {
            mainDeDes[indexArray] = lancerDee();
        }
    }

    /**
     * @return la liste des 5 dés
     */
    public int[] getMainDeDes() {
        return mainDeDes;
    }

    /**
     * Affiche les dés
     * @param dee dés à afficher
     */
    public  void afficherDee() {

        System.out.print("Résultat : ");

        for (int indexArray = 0; indexArray < mainDeDes.length; indexArray++) {
            System.out.print(mainDeDes[indexArray] + " ");
        }
        System.out.print("\n");
    }
}
