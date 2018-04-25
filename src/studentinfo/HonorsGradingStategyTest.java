package studentinfo;

import junit.framework.TestCase;

public class HonorsGradingStategyTest extends TestCase {
    public void testGetGradePoints() {
        BasicGradingStrategy strategy = new BasicGradingStrategy();
        assertEquals(4, strategy.getGradepointsFor(Student.Grade.A));
        assertEquals(3, strategy.getGradepointsFor(Student.Grade.B));
        assertEquals(2, strategy.getGradepointsFor(Student.Grade.C));
        assertEquals(1, strategy.getGradepointsFor(Student.Grade.D));
        assertEquals(0, strategy.getGradepointsFor(Student.Grade.F));

    }
}
