package studentinfo;

import java.util.*;

import junit.framework.TestCase;

public class CourseTest extends TestCase {
    public void testCreate() {
        Course course = new Course("CMSC", "120");
        assertEquals("CMSC", course.getDepartment());
        assertEquals("120", course.getNumber());
    }

    public void testEquality() {
        Course courseA = new Course("NURS", "201");
        Course courseAprime = new Course("NURS", "201");
        assertEquals(courseA, courseAprime);

        Course courseB = new Course("ARTH", "330");
        assertFalse(courseA.equals(courseB));

        assertEquals(courseA, courseA);

        Course courseAprime2 = new Course("NURS", "201");
        assertEquals(courseAprime, courseAprime2);
        assertEquals(courseA, courseAprime2);

        assertEquals(courseAprime, courseA);

        assertEquals(courseA, courseAprime);

        assertFalse(courseA.equals(null));

        assertFalse(courseA.equals("CMSC-120"));

    }

    public void testHashCode() {
        Course courseA = new Course("NURS", "201");
        Course courseAprime = new Course("NURS", "201");


        assertEquals(courseA.hashCode(), courseAprime.hashCode());

        assertEquals(courseA.hashCode(), courseA.hashCode());
    }

    public void testHashCodePerformance() {
        final int count = 10000;
        long start = System.currentTimeMillis();
        Map<Course, String> map = new HashMap<Course, String>();
        for (int i = 0; i < count; i++) {
            Course course = new Course("C" + i, "" + i);
            map.put(course, "");
        }
        long stop = System.currentTimeMillis();
        long elapsed = stop - start;
        final long arbitraryThreshold = 200;
        assertTrue("elapsed time=" + elapsed, elapsed < arbitraryThreshold);
    }
}
