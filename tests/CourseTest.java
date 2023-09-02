package tests;

import org.junit.Assert;
import org.junit.Test;
import res.Athlete;
import res.Couloir;
import res.Course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class CourseTest {

    @Test
    public void getVainqueur_couloirListNull_Ko() {
        // GIVEN
        Course c = new Course();

        // WHEN
        Athlete a = c.getVainqueur();

        // THEN
        Assert.assertNull(a);
    }
    @Test
    public void getVainqueur_couloirListEmpty_Ko() {
        // GIVEN
        Course c = new Course();
        c.setCouloirList(new ArrayList<>());

        // WHEN
        Athlete a = c.getVainqueur();

        // THEN
        Assert.assertNull(a);
    }
    @Test(expected = NoSuchElementException.class)
    public void getVainqueur_couloirListWithNoAthlete_Ko() {
        // GIVEN
        Course c = new Course();
        c.setCouloirList(Collections.singletonList(new Couloir()));

        // WHEN
        c.getVainqueur();
    }
}
