package report;

import junit.framework.TestCase;
import studentinfo.CourseSession;
import studentinfo.DateUtil;
import studentinfo.Student;
import static report.RosterReporter.NEWLINE;

public class RosterReporterTest extends TestCase {
	public void testRosterReport() {
		CourseSession session = CourseSession.create("ENGL", "101", DateUtil.createDate(2003, 1, 6));

		session.enroll(new Student("A"));
		session.enroll(new Student("B"));

		String rosterReport = new RosterReporter(session).getReport();
		System.out.println(rosterReport);
		assertEquals(RosterReporter.ROSTER_REPORT_HEADER + "A" + NEWLINE + "B" + NEWLINE
				+ RosterReporter.ROSTER_REPORT_FOOTER + "2" + NEWLINE, rosterReport);
	}

}
