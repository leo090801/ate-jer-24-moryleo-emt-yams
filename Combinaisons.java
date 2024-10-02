public class Combinaisons {

    public enum TypeCombinaison {
        YAMS, FULL, CARRE, BRELAN, PETITE_SUITE, GRANDE_SUITE, NB_CHANCE
    }

    /**
     * calcule le nombre de chaque chiffre et calcule si il y a un brelan
     * @param dee les dés lancés
     * @return 0 si il n'y a pas de brelan et sinon l'entier qui correspond au brelan
     */
    public int estBrelan(int[] dee) {
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
     * Calcule le nombre de chaque chiffre et calcule si il y a un carre.
     * @param dee les dés lancés.
     * @return 0 s'il n'y a pas de carre et sinon l'entier qui correspond au carre.
     */
    public int estCarre(int[] dee) {
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
     * Calcule si la suite de dés forme un yams
     * @param dee La suite de Dés
     * @return true si c'est un yams false sinon
     */
    public boolean estYams(int[] dee) {

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
    public boolean estFull(int[] dee) {

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
     * calcule si les dés forme une grande suite
     * @param dee les dés lancés
     * @return true si c'est une grande suite et false sinon
     */
    public boolean estGrandeSuite(int[] dee) {

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
     * Calcule si les dés sont une petite suite.
     * @param dee Dés lancés
     * @return true si c'est une petite suite, false sinon
     */
    public boolean estPetiteSuite(int[] dee) {

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
}
