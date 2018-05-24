package studentinfo;

import junit.framework.TestSuite;
import report.RosterReporterTest;

public class AllTests {
	public static TestSuite suite() {
		junit.framework.TestSuite suite = new junit.framework.TestSuite();
		suite.addTestSuite(StudentTest.class);
		suite.addTestSuite(CourseSessionTest.class);
		suite.addTestSuite(CharacterTest.class);
		suite.addTestSuite(RosterReporterTest.class);
		suite.addTestSuite(DateUtilTest.class);
		suite.addTestSuite(HonorsGradingStategyTest.class);
		suite.addTestSuite(BasicGradingStrategyTest.class);
		suite.addTestSuite(ScorerTest.class);
        suite.addTestSuite(StudentDirectoryTest.class);
        suite.addTestSuite(AccountTest.class);
		return suite;
	}
}
