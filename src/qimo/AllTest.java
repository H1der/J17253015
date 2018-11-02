package qimo;

import junit.framework.TestSuite;

public class AllTest {
    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(AcTest.class);
        return suite;
    }
}
