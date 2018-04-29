package summer;


import java.util.Date;

import studentinfo.CourseSession;
import studentinfo.Session;

public class SummerCourseSession extends Session {
    public static SummerCourseSession create(String department, String number, Date StarDate) {
        return new SummerCourseSession(department, number, StarDate);
    }

    private SummerCourseSession(String department, String number, Date startDate) {
        super(department, number, startDate);
    }

    protected int getSessionLength() {
        return 8;
    }

}
