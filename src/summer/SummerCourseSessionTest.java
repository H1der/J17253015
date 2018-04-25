package summer;

import java.util.Date;

import junit.framework.TestCase;
import studentinfo.CourseSession;
import studentinfo.DateUtil;

public class SummerCourseSessionTest extends TestCase {
    public void testEndDate() {
        Date startDate = DateUtil.createDate(2003, 6, 9);
        CourseSession session = SummerCourseSession.create("ENGL", "200", startDate);
        Date eightweeksOut = DateUtil.createDate(2003, 8, 1);
        assertEquals(eightweeksOut, session.getEndDate());
    }
}
