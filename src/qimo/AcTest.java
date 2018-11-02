package qimo;

import junit.framework.TestCase;

public class AcTest extends TestCase {
    public void testAc() {
        Ac ac = new Ac();
        assertEquals(12, ac.area(3, 4));
    }
}
