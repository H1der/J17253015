package report;

import junit.framework.TestSuite;
import report.RosterReporterTest;

public class AllTests {
    public static TestSuite suite() {

        junit.framework.TestSuite suite = new junit.framework.TestSuite();
		suite.addTestSuite(RosterReporterTest.class);
        suite.addTestSuite(CourseReportTest.class);
        suite.addTestSuite(ReportCard.class);
		return suite;
	}

}
