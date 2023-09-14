package res;

import res.exceptions.IndexCouloirOutOfBounds;

import java.util.Arrays;
import java.util.Objects;

public class Course {

    private String libelle;

    private Couloir[] couloirs;

    public Course(String inLibelle) {
        this(inLibelle, new Couloir[0]);
    }

    public Course(String inLibelle, Couloir[] inCouloirs) {
        libelle = inLibelle;
        couloirs = inCouloirs;
    }

    public void ajouterCouloir(Couloir couloir) {
        if (Objects.nonNull(couloir)) {
            Couloir[] newCouloirs = new Couloir[couloirs.length + 1];

            for (int i = 0; i < couloirs.length; i++) {
                newCouloirs[i] = couloirs[i];
            }

            newCouloirs[newCouloirs.length - 1] = couloir;

            couloirs = newCouloirs;
        }
    }

    public String getLibelle() {
        return libelle;
    }

    public void affecterAthleteDansCouloir(Athlete athlete, int iCouloir) {
        if (iCouloir > couloirs.length || iCouloir < 1) {
            throw new IndexCouloirOutOfBounds();
        }
        couloirs[iCouloir - 1].affecterAthlete(athlete);

    }

    public void enregistrerTempsCouloir(int iCouloir, float inTemps) {
        if (iCouloir > couloirs.length) {
            throw new IndexCouloirOutOfBounds();
        }

        couloirs[iCouloir - 1].enregistrerTemps(inTemps);

    }

    public Athlete recupererConcurrentCouloir(int iCouloir) {
        if (iCouloir > couloirs.length) {
            throw new IndexCouloirOutOfBounds();
        }

        return couloirs[iCouloir - 1].recupererConcurrent();
    }

    public Athlete recupererVainqueur() {
        Couloir couloirVainqueur = null;

        if (Objects.nonNull(couloirs)) {
            for (Couloir couloirActuel : couloirs) {
                if (Objects.nonNull(couloirActuel) && Objects.nonNull(couloirActuel.recupererConcurrent())) {
                    float tempsCouloirConcurrent = couloirActuel.getTemps();

                    if (Objects.isNull(couloirVainqueur) || tempsCouloirConcurrent < couloirVainqueur.getTemps()) {
                        couloirVainqueur = couloirActuel;
                    }

                }
            }
        }

        return Objects.isNull(couloirVainqueur)
                ? null
                : couloirVainqueur.recupererConcurrent();
    }

    public void affichage() {
        Utils.println(toString());
    }

    public String toString() {
        return "Course ".concat(getLibelle())
                .concat("\n\tCouloirs : ").concat(Arrays.toString(couloirs));
    }

}
