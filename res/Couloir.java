package res;

import res.exceptions.StartDateNullException;

import java.util.Date;
import java.util.Objects;

public class Couloir {
    private int numCouloir;

    private Date startDate;
    private Date endDate;
    private Athlete concurrent;

    public Couloir(int inNumCouloir) {
        numCouloir = inNumCouloir;
    }

    public void enregistrerTemps() {
        startDate = new Date();
    }

    public void finirTemps() {
        if (Objects.isNull(startDate)) {
            throw new StartDateNullException();
        }

        endDate = new Date();

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

    public Long getTemps() {

        return Objects.isNull(startDate) || Objects.isNull(endDate)
                ? null
                : endDate.getTime() - startDate.getTime();

    }
}
