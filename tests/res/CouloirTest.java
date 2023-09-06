package tests.res;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import res.Athlete;
import res.Couloir;
import res.exceptions.StartDateNullException;

public class CouloirTest {

    @Test(expected = StartDateNullException.class)
    public void finirTemps_startDateNull_Ko() {
        Couloir couloir = new Couloir(404);

        couloir.finirTemps();

    }
    @Test
    public void finirTemps_Ok() {
        Couloir couloir = new Couloir(200);
        couloir.enregistrerTemps();

        Assertions.assertDoesNotThrow(couloir::finirTemps);

    }

    @Test
    public void toString_concurrentNull_Ko() {
        Couloir couloir = new Couloir(404);
        String expectedString = "Couloir n°404, concurrent : AUCUN";

        Assertions.assertEquals(expectedString, couloir.toString());
    }

    @Test
    public void toString_Ok() {
        Couloir couloir = new Couloir(200);
        couloir.affecterAthlete(new Athlete("Doe", "John"));
        String expectedString = "Couloir n°200, concurrent : Doe John";

        Assertions.assertEquals(expectedString, couloir.toString());
    }

}
