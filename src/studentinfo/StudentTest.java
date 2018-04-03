package studentinfo;
import junit.framework.TestCase;

public class StudentTest extends TestCase {
	public void testCreate() {
		final String firstStudentName = "Jane Doe";
		Student student = new Student(firstStudentName);
		assertEquals(firstStudentName, student.getName());
		
		final String secondStudentName = "Joe Blow";
		Student secodStudent = new Student(secondStudentName);
		assertEquals(secondStudentName, secodStudent.getName());
		
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
