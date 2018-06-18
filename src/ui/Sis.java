package ui;

import java.awt.event.*;

import javax.swing.*;

import studentinfo.*;

public class Sis {
	static final int WIDTH = 300;
	static final int HEIGHT = 200;
	private JFrame frame = new JFrame();
	private CoursesPanel panel;

	public static void main(String[] args) {
		new Sis().show();
	}

	public Sis() {
		initialize();
	}

	private void initialize() {
		createCoursesPanel();

		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
	}

	void createCoursesPanel() {
		panel = new CoursesPanel();
		panel.addCourseAddListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				addCourse();

			}
		});
	}

	protected void addCourse() {
		Course course = new Course(panel.getText(CoursesPanel.DEPARTMENT_FIELD_NAME), panel.getText(CoursesPanel.NUMBER_FIELD_NAME));
		panel.addCourse(course);
	}

	public void show() {

		frame.setVisible(true);
	}

	public JFrame getFrame() {
		// TODO 自动生成的方法存根
		return frame;
	}

	public void close() {
		frame.dispose();
	}

}
