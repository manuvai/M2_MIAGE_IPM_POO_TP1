package res;

import java.util.Objects;

public class Couloir {
    private int numCouloir;
    private float temps;
    private Athlete concurrent;

    public Couloir(int inNumCouloir) {
        numCouloir = inNumCouloir;
        enregistrerTemps(Float.POSITIVE_INFINITY);
    }

    public void enregistrerTemps(float inTemps) {
        temps = inTemps;
    }

    public void affecterAthlete(Athlete athlete) {
        concurrent = athlete;
    }

    public Athlete recupererConcurrent() {
        return concurrent;
    }

    public void affichage() {
        Utils.println(toString());
    }

    @Override
    public String toString() {
        String nomConcurrent = "AUCUN";

        if (Objects.nonNull(concurrent)) {
            nomConcurrent = concurrent.toString();
        }

        return "Couloir n°".concat(Integer.toString(numCouloir))
                .concat(", concurrent : ").concat(nomConcurrent);
    }

    public float getTemps() {

        return temps;

    }
}
