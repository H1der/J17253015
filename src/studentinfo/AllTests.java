package studentinfo;
import junit.framework.TestCase;
import report.RosterReporterTest;

public class AllTests extends TestCase {
	public static junit.framework.TestSuite suite() {

		junit.framework.TestSuite suite = new junit.framework.TestSuite();
		suite.addTestSuite(StudentTest.class);
		suite.addTestSuite(CourseSessionTest.class);
		suite.addTestSuite(CharacterTest.class);
		suite.addTestSuite(RosterReporterTest.class);
		suite.addTestSuite(DateUtilTest.class);
		return suite;
	}

}
