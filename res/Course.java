package res;

import res.exceptions.IndexCouloirOutOfBounds;

import java.util.Arrays;
import java.util.Objects;

public class Course {

    private String libelle;

    private Couloir[] couloirs;

    public Course(String inLibelle, Couloir[] inCouloirs) {
        libelle = inLibelle;
        couloirs = inCouloirs;
    }

    public String getLibelle() {
        return libelle;
    }

    public void affecterAthleteDansCouloir(Athlete athlete, int iCouloir) {
        if (iCouloir > couloirs.length) {
            throw new IndexCouloirOutOfBounds();
        }
        couloirs[iCouloir - 1].affecterAthlete(athlete);

    }

    public void enregistrerTempsCouloir(int iCouloir) {
        if (iCouloir > couloirs.length) {
            throw new IndexCouloirOutOfBounds();
        }

        couloirs[iCouloir - 1].enregistrerTemps();

    }

    public void finirTempsCouloir(int iCouloir) {
        if (iCouloir > couloirs.length) {
            throw new IndexCouloirOutOfBounds();
        }

        couloirs[iCouloir - 1].finirTemps();
    }

    public Athlete recupererConcurrentCouloir(int iCouloir) {
        if (iCouloir > couloirs.length) {
            throw new IndexCouloirOutOfBounds();
        }

        return couloirs[iCouloir - 1].recupererConcurrent();
    }

    public Athlete recupererVainqueur() {
        Couloir couloirVainqueur = null;

        if (Objects.nonNull(couloirs) && couloirs.length > 0) {
            for (int i = 0; i < couloirs.length; i++) {
                if (Objects.nonNull(couloirs[i])
                        && Objects.nonNull(couloirs[i].recupererConcurrent())

                ) {
                    Long tempsCouloirConcurrent = couloirs[i].getTemps();

                    if (Objects.nonNull(tempsCouloirConcurrent)
                            && (Objects.isNull(couloirVainqueur) || tempsCouloirConcurrent < couloirVainqueur.getTemps())
                    ) {
                        couloirVainqueur = couloirs[i];
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
        return "Course ".concat(libelle)
                .concat("\n\tCouloirs : ").concat(Arrays.toString(couloirs));
    }

}
