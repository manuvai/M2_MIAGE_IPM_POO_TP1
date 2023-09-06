package tests.res;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import res.Athlete;
import res.Couloir;
import res.Course;
import res.exceptions.IndexCouloirOutOfBounds;
import tests.mocks.CourseMock;

public class CourseTest {

    CourseMock courseMock;

    @Before
    public void setup() {
        courseMock = new CourseMock();
    }

    @Test(expected = IndexCouloirOutOfBounds.class)
    public void affecterAthleteDansCouloir_iCouloirOutBounds_Ko() {
        Course course = new Course("Course 404", new Couloir[] {});

        course.affecterAthleteDansCouloir(new Athlete("Ano", "Nymous"), 1);
    }
    @Test
    public void affecterAthleteDansCouloir_Ok() {
        Course course = new Course("Course 200", new Couloir[] {new Couloir(200)});

        Assertions.assertDoesNotThrow(() -> course
                .affecterAthleteDansCouloir(new Athlete("Ano", "Nymous"), 1));

    }

    @Test(expected = IndexCouloirOutOfBounds.class)
    public void enregistrerTempsCouloir_iCouloirOutBounds_Ko() {
        Course course = new Course("Course 404", new Couloir[] {});

        course.enregistrerTempsCouloir(1);

    }
    @Test
    public void enregistrerTempsCouloir_Ok() {
        Course course = new Course("Course 200", new Couloir[] {new Couloir(200)});

        Assertions.assertDoesNotThrow(() -> course
                .enregistrerTempsCouloir(1));

    }

    @Test(expected = IndexCouloirOutOfBounds.class)
    public void finirTempsCouloir_iCouloirOutBounds_Ko() {
        Course course = new Course("Course 404", new Couloir[] {});

        course.finirTempsCouloir(1);

    }
    @Test
    public void finirTempsCouloir_Ok() {
        Course course = new Course("Course 200", new Couloir[] {new Couloir(200)});
        course.enregistrerTempsCouloir(1);

        Assertions.assertDoesNotThrow(() -> course
                .finirTempsCouloir(1));

    }

    @Test(expected = IndexCouloirOutOfBounds.class)
    public void recupererConcurrentCouloir_iCouloirOutBounds_Ko() {
        Course course = new Course("Course 404", new Couloir[] {});

        course.recupererConcurrentCouloir(1);
    }
    @Test
    public void recupererConcurrentCouloir_Ok() {
        Athlete anonymous = new Athlete("Ano", "Nymous");
        Course course = new Course("Course 200", new Couloir[] {new Couloir(200)});
        course.affecterAthleteDansCouloir(anonymous, 1);

        Assertions.assertEquals(anonymous, course.recupererConcurrentCouloir(1));

    }
    @Test
    public void recupererVainqueur_CouloirsNull_Ko() {
        // GIVEN
        Course course = courseMock.getCourseWithoutCouloirs();

        // WHEN
        Athlete vainqueur = course.recupererVainqueur();

        // THEN
        Assertions.assertNull(vainqueur);

    }

    @Test
    public void recupererVainqueur_CouloirsEmpty_Ko() {
        // GIVEN
        Course course = courseMock.getCourseWithEmptyCouloirs();

        // WHEN
        Athlete vainqueur = course.recupererVainqueur();

        // THEN
        Assertions.assertNull(vainqueur);

    }
    @Test
    public void recupererVainqueur_CouloirsOnlyOneConcurrent_Ok() {
        // GIVEN
        Course course = courseMock.getCourseWithOnlyOneConcurrent();
        Athlete expectedVainqueur = new Athlete("Doe", "John");

        // WHEN
        Athlete actualVainqueur = course.recupererVainqueur();

        // THEN
        Assertions.assertEquals(expectedVainqueur, actualVainqueur);

    }
    @Test
    public void recupererVainqueur_MultipleConcurrents_Ok() throws InterruptedException {
        // GIVEN
        Course course = courseMock.getCourseWithMultipleConcurrents();
        Athlete expectedVainqueur = new Athlete("Doe", "John");

        // WHEN
        Athlete actualVainqueur = course.recupererVainqueur();

        // THEN
        Assertions.assertEquals(expectedVainqueur, actualVainqueur);

    }

}
