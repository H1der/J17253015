package report;

import java.util.ArrayList;
import java.util.Collections;

import studentinfo.CourseSession;

public class CourseReport extends CourseReportTest {

    private ArrayList<CourseSession> sessions = new ArrayList<CourseSession>();
    final String NEWLINE = System.getProperty("line.separator");

    public void add(CourseSession session) {
        sessions.add(session);
    }

    public String text() {
        Collections.sort(sessions);
        StringBuilder builder = new StringBuilder();
        for (CourseSession session : sessions)
            builder.append(session.getDepartment() + " " + session.getNumber() + NEWLINE);
        return builder.toString();
    }


}
