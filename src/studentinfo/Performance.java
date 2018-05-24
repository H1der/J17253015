package studentinfo;

public class Performance {
    private int[] tests = {};

    public void setNumberOfTests(int numberOfTests) {
        tests = new int[numberOfTests];
    }

    public void set(int testNumber, int score) {
        tests[testNumber] = score;
    }

    public int get(int testNumber) {
        return tests[testNumber];
    }

    public double average() {
        if (tests.length == 0)
            return 0.0;
        double total = 0.0;
        for (int i = 0; i < tests.length; i++)
            total += tests[i];
        return total / tests.length;
    }

    public void setScores(int score1, int score2, int score3, int score4) {
        tests = new int[]{score1, score2, score3, score4};
    }

}
