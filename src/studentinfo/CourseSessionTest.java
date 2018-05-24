package studentinfo;


import java.util.*;

public class CourseSessionTest extends SessionTest {

	private Course createCourse() {
		return new Course("ENGL", "101");
	}

	public void testCourseDates() {
        Date startDate = DateUtil.createDate(2003, 1, 6);
		Session session = createSession(createCourse(), startDate);
		Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
		assertEquals(sixteenWeeksOut, session.getEndDate());
	}

    public void testCount() {
		CourseSession.resetCount();
		createSession(createCourse(), new Date());
		assertEquals(1, CourseSession.getCount());
		createSession(createCourse(), new Date());
		assertEquals(2, CourseSession.getCount());
	}

	protected Session createSession(Course course, Date date) {

		return CourseSession.create(course, date);
    }


}
