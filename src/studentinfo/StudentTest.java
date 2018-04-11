package studentinfo;

import junit.framework.TestCase;
import studentinfo.Student.Grade;

public class StudentTest extends TestCase {
    private static final double GRADE_TOLERANCE = 0.05;

    public void testCreate() {
        final String firstStudentName = "Jane Doe";
        Student student = new Student(firstStudentName);
        assertEquals(firstStudentName, student.getName());

        final String secondStudentName = "Joe Blow";
        Student secodStudent = new Student(secondStudentName);
        assertEquals(secondStudentName, secodStudent.getName());
    }

    public void testCalculateGpa() {
        Student student = new Student("a");
        assertGpa(student, 0.0);
        student.addGrade(Grade.A);
        assertGpa(student, 4.0);
        student.addGrade(Grade.B);
        assertGpa(student, 3.5);
        student.addGrade(Grade.C);
        assertGpa(student, 3.0);
        student.addGrade(Grade.D);
        assertGpa(student, 2.5);
        student.addGrade(Grade.E);
        assertGpa(student, 2.0);

    }

    public void testCalcuateHonorsStudentGpa() {
        assertGpa(createHonorsStudent(), 0.0);
        assertGpa(createHonorsStudent(Grade.A), 5.0);
        assertGpa(createHonorsStudent(Grade.B), 4.0);
        assertGpa(createHonorsStudent(Grade.C), 3.0);
        assertGpa(createHonorsStudent(Grade.D), 2.0);
        assertGpa(createHonorsStudent(Grade.E), 0.0);

    }

    private Student createHonorsStudent(Grade grade) {
        Student student = createHonorsStudent();
        student.addGrade(grade);
        return student;
    }

    private Student createHonorsStudent() {
        Student student = new Student("a");
        student.setGradingStrategy(new HonorsGradingStategy());
        return student;
    }

    private void assertGpa(Student student, double expectedGpa) {
        assertEquals(expectedGpa, student.getGpa(), GRADE_TOLERANCE);
    }

	public void testFullTime() {
		Student student = new Student("a");
		assertFalse(student.isFullTime());
	}

    public void testCredits() {
		Student student = new Student("a");
		assertEquals(0, student.getCreadits());
		assertFalse(student.isFullTime());

        student.addCredits(3);
		assertEquals(3, student.getCreadits());
		assertFalse(student.isFullTime());

        student.addCredits(4);
		assertEquals(7, student.getCreadits());
		assertFalse(student.isFullTime());

        student.addCredits(5);
		assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME, student.getCreadits());
		assertTrue(student.isFullTime());
	}

    public void testInstate() {
		Student student = new Student("a");
		assertFalse(student.isInState());
		student.setState(Student.IN_STATE);
		assertTrue(student.isInState());
		student.setState("MD");
		assertFalse(student.isInState());
	}
}
