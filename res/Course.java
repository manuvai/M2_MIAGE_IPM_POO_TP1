package res;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Course {

    private String libelle;

    private List<Couloir> couloirList;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Couloir> getCouloirList() {
        return couloirList;
    }

    public void setCouloirList(List<Couloir> couloirList) {
        this.couloirList = couloirList;
    }

    public void affecterAthlete(Athlete athlete, int iCouloir) {
        if (Objects.nonNull(couloirList) && couloirList.size() > iCouloir) {
            couloirList.get(iCouloir)
                    .setAthlete(athlete);
        }
    }

    public void enregistrerTemps(int iCouloir) {
        if (Objects.nonNull(couloirList) && couloirList.size() > iCouloir) {
            couloirList.get(iCouloir)
                    .start();
        }
    }

    public void start() {
        if (Objects.nonNull(couloirList)) {
            couloirList.forEach(Couloir::start);
        }
    }
    public void stop() {
        if (Objects.nonNull(couloirList)) {
            couloirList.forEach(Couloir::stop);
        }
    }

    public Athlete getConcurrent(int iCouloir) {
        return Objects.isNull(couloirList) || couloirList.size() <= iCouloir
                ? null
                : couloirList.get(iCouloir)
                        .getAthlete();
    }

    public Athlete getVainqueur() {
        return Objects.isNull(couloirList) || couloirList.size() == 0
                ? null
                : couloirList.stream()
                        .filter(c -> Objects.nonNull(c) && Objects.nonNull(c.getAthlete()))
                        .max(Comparator.comparingDouble(Couloir::getTemps))
                        .orElseThrow(NoSuchElementException::new)
                        .getAthlete();
    }
}
