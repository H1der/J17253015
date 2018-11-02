package qimo;

import javax.swing.JFrame;

import junit.framework.TestCase;

public class SisTest extends TestCase {
    private Sis sis;
    private JFrame frame;

    protected void setUp() {
        sis = new Sis();
        frame = sis.getFrame();
    }

    public void testCreate() {
        final double tolerance = 0.05;
        assertEquals(Sis.HEIGHT, frame.getSize().getHeight(), tolerance);
        assertEquals(Sis.WIDTH, frame.getSize().getWidth(), tolerance);
        assertEquals(JFrame.EXIT_ON_CLOSE, frame.getDefaultCloseOperation());
    }

    public void testShow() {
        sis.show();
        assertTrue(frame.isVisible());
    }
}
