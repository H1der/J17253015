
import junit.framework.TestSuite;

public class AllTests {
	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(report.AllTests.suite());
		suite.addTest(studentinfo.AllTests.suite());
        suite.addTest(summer.AllTests.suite());
        suite.addTestSuite(SuperClassTest.class);
		return suite;
	}

}
