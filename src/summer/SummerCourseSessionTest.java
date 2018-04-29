package summer;

import java.util.Date;

import studentinfo.DateUtil;
import studentinfo.Session;
import studentinfo.SessionTest;

public class SummerCourseSessionTest extends SessionTest {
    public void testEndDate() {
        Date startDate = DateUtil.createDate(2003, 6, 9);
        Session session = createSession("ENGL", "200", startDate);
        Date eightweeksOut = DateUtil.createDate(2003, 8, 1);
        assertEquals(eightweeksOut, session.getEndDate());
    }

    protected Session createSession(String department, String number, Date date) {
        return SummerCourseSession.create(department, number, date);
    }
}
