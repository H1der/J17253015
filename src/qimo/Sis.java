package qimo;

import javax.swing.JFrame;

public class Sis {
    static final int WIDTH = 350;
    static final int HEIGHT = 200;

    private JFrame frame = new JFrame();

    public static void main(String[] args) {
        new Sis().show();
    }

    public Sis() {
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void show() {
//		JFrame frame = new JFrame();
//		frame.setSize(WIDTH,HEIGHT);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        // TODO �Զ����ɵķ������
        return frame;
    }
}
