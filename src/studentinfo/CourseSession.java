package studentinfo;

import java.util.*;

public class CourseSession extends Session {
	private static int count;

    public static CourseSession create(Course course, Date startDate) {

        return new CourseSession(course, startDate);
    }

    protected CourseSession(Course course, Date startDate) {
        super(course, startDate);
		CourseSession.incrementCount();
	}

	protected int getSessionLength() {
		return 16;
	}

	public static int getCount() {
		return count;
	}

	public static void resetCount() {
		count = 0;
	}

	private static void incrementCount() {
		++count;
	}

}
