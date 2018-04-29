package summer;

import junit.framework.TestSuite;

public class AllTests {
    public static TestSuite suite() {
        junit.framework.TestSuite suite = new junit.framework.TestSuite();
        suite.addTestSuite(SummerCourseSessionTest.class);
        suite.addTestSuite(FibonacciTest.class);
        return suite;
    }
}
