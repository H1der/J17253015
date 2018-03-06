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

}
