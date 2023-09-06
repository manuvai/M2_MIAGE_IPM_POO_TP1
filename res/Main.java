package res;

import java.util.Objects;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Définition de l'athlète martin
        Athlete martin = new Athlete("DUPONT", "Martin");
        martin.affichage();

        // Définition de l'athlète Alex
        Athlete alex = new Athlete("DOE", "Alex");

        // Définition du couloir 1
        Couloir couloir1 = new Couloir(1);
        couloir1.affichage();

        couloir1.affecterAthlete(martin);
        couloir1.affichage();

        // Définition du couloir 2
        Couloir couloir2 = new Couloir(2);
        couloir2.affecterAthlete(alex);

        // Définition du couloir 3
        Couloir couloir3 = new Couloir(3);

        Couloir[] couloirs = new Couloir[] {couloir1, couloir2, couloir3};

        // Définition de la course
        Course course = new Course("La course des Chocos", couloirs);
        course.affecterAthleteDansCouloir(new Athlete("BERNARD", "Tapis"), 2);
        course.affichage();

        // Affichage du concurrent du couloir 2
        Utils.println("\nConcurrent du couloir 2 : ");
        Objects.requireNonNull(course.recupererConcurrentCouloir(2))
                .affichage();

        // Enregistrement des temps
        course.enregistrerTempsCouloir(1);
        Thread.sleep(200);

        course.enregistrerTempsCouloir(2);
        Thread.sleep(900);

        course.enregistrerTempsCouloir(3);
        Thread.sleep(100);

        // Affichage du vainqueur
        Utils.println("\nLe vainqueur de la course est : ");
        Objects.requireNonNull(course.recupererVainqueur())
                .affichage();

    }
}
