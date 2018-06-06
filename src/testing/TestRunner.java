package testing;

public class TestRunner {
    public static void main(String[] args) {
        junit.swingui.TestRunner.run(TestRunner.class);
    }

    public static junit.framework.Test suite() {
        return new SuiteBuilder().suite();
    }
}