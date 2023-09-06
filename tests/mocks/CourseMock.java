package tests.mocks;

import res.Athlete;
import res.Couloir;
import res.Course;

public class CourseMock {

    public Course getCourseWithoutCouloirs() {

        return new Course("404", null);
    }
    public Course getCourseWithEmptyCouloirs() {

        return new Course("404", new Couloir[]{});
    }
    public Course getCourseWithOnlyOneConcurrent() {

        Course course = new Course("404", new Couloir[]{new Couloir(200)});

        course.affecterAthleteDansCouloir(new Athlete("Doe", "John"), 1);
        course.enregistrerTempsCouloir(1);
        course.finirTempsCouloir(1);

        return course;
    }
    public Course getCourseWithMultipleConcurrents() throws InterruptedException {

        Course course = new Course("404", new Couloir[]{new Couloir(200), new Couloir(201), new Couloir(202)});

        course.affecterAthleteDansCouloir(new Athlete("Doe", "John"), 1);
        course.enregistrerTempsCouloir(1);
        course.finirTempsCouloir(1);

        course.affecterAthleteDansCouloir(new Athlete("Doe", "John"), 2);
        course.enregistrerTempsCouloir(2);
        Thread.sleep(100);
        course.finirTempsCouloir(2);

        course.affecterAthleteDansCouloir(new Athlete("Doe", "John"), 3);
        course.enregistrerTempsCouloir(3);
        Thread.sleep(200);
        course.finirTempsCouloir(3);

        return course;
    }
}
