package ui;

import javax.swing.*;

public class Sis {
    static final int WIDTH = 350;
    static final int HEIGHT = 500;

    public static void main(String[] args) {
        new Sis().show();
    }

    public void show() {
        JFrame frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
