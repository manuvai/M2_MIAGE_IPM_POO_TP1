package res;

import java.util.Objects;

public class Athlete {
    private String nom;

    private String prenom;

    public Athlete(String inNom, String inPrenom) {
        nom = inNom;
        prenom = inPrenom;
    }

    public void affichage() {
        if (Objects.nonNull(toString())) {
            Utils.println(this);

        }
    }

    @Override
    public String toString() {
        return Objects.isNull(nom) || Objects.isNull(prenom)
                ? null
                : nom.concat(" ").concat(prenom);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Athlete athlete)) return false;
        return Objects.equals(nom, athlete.nom) && Objects.equals(prenom, athlete.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom);
    }
}
