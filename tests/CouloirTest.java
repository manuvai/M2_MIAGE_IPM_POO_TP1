package tests;

import org.junit.Assert;
import org.junit.Test;
import res.Couloir;

public class CouloirTest {

    @Test
    public void getTemps_startDateNull_Ko() {

        // GIVEN
        Couloir c = new Couloir();

        // WHEN
        Double result = c.getTemps();

        // THEN
        Assert.assertNull(result);
    }

    @Test
    public void getTemps_endDateNull_Ko() {

        // GIVEN
        Couloir c = new Couloir();
        c.start();

        // WHEN
        Double result = c.getTemps();

        // THEN
        Assert.assertNull(result);
    }

    @Test
    public void getTemps_Ok() {

        // GIVEN
        Couloir c = new Couloir();
        c.start();
        c.stop();

        // WHEN
        Double result = c.getTemps();

        // THEN
        Assert.assertNotNull(result);
    }

}
