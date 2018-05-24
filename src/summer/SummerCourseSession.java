package summer;


import java.util.Date;

import studentinfo.Course;
import studentinfo.Session;

public class SummerCourseSession extends Session {
    public static Session create(Course course, Date StarDate) {
        return new SummerCourseSession(course, StarDate);
    }

    private SummerCourseSession(Course course, Date startDate) {
        super(course, startDate);
    }

    protected int getSessionLength() {
        return 8;
    }


}
