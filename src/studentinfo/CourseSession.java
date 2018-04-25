package studentinfo;

import java.util.*;

public class CourseSession implements Comparable<CourseSession> {
	public static final String NEWLINE = System.getProperty("line.separator");
	public static final String ROSTER_REPORT_HEADER = "Student" + NEWLINE + "----" + NEWLINE;
	public static final String ROSTER_REPORT_FOOTER = NEWLINE + "#students=";
	private static int count;
	private int numberOfCredits;

	private String department;
	private String number;
	private ArrayList<Student> students = new ArrayList<Student>();
	protected Date startDate;

	protected CourseSession(String department, String number, Date startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}

	void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	public String getDepartment() {
		return department;
	}

	public String getNumber() {
		return number;
	}

	public int getNumberOfStudents() {
		return students.size();
	}

	public void enroll(Student student) {
		student.addCredits(numberOfCredits);
		students.add(student);
	}

	Student get(int index) {
		return students.get(index);
	}

	public Date getEndDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(getStartDate());
		int daysInWeek = 7;
		int daysFromFridayToMonday = 3;
		int numberOfDays = getSessionLength() * daysInWeek - daysFromFridayToMonday;
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		return calendar.getTime();
	}

	protected Date getStartDate() {
		return startDate;
	}

	public ArrayList<Student> getAllStudents() {
		return students;
	}

	protected int getSessionLength() {
		return 16;
	}
	
	public static int getCount() {
		return count;
	}

	public static void resetCount() {
		count = 0;
	}

	private static void incrementCount() {
		count = count + 1;
	}

	public static CourseSession create(String department, String number, Date startDate) {
		incrementCount();
		return new CourseSession(department, number, startDate);

	}

	public int compareTo(CourseSession that) {
		int compare = this.getDepartment().compareTo(that.getDepartment());
		if (compare == 0) {
			compare = this.getNumber().compareTo(that.getNumber());
		}
		return compare;

	}

}
