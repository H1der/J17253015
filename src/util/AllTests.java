package util;

import junit.framework.TestSuite;
import report.RosterReporterTest;

public class AllTests {
    public static TestSuite suite() {

        junit.framework.TestSuite suite = new junit.framework.TestSuite();
        suite.addTestSuite(PasswordGeneratorTest.class);
        return suite;
    }

}
