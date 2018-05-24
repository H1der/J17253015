package studentinfo;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Logger;

abstract public class Session implements Comparable<Session>, Iterable<Student> {
    private int numberOfCredits;

    private Course course;
    private Vector<Student> students = new Vector<Student>();
    protected Date startDate;
    private URL url;

    public void setUrl(String urlString) throws SessionException {
        try {
            this.url = new URL(urlString);
        } catch (MalformedURLException e) {
            Log(e);
            throw new SessionException(e);
        }
    }

    private void Log(Exception e) {

    }

    public URL getUrl() {
        return url;
    }

    protected Session(Course course, Date startDate) {
        this.course = course;
        this.startDate = startDate;
    }

    public Iterator<Student> iterator() {
        return students.iterator();
    }

    public int compareTo(Session that) {
        int compare = this.getDepartment().compareTo(that.getDepartment());
        if (compare != 0) {
            return compare;
        }
        return this.getNumber().compareTo(that.getNumber());
    }

    void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public String getDepartment() {
        return course.getDepartment();
    }

    public String getNumber() {
        return course.getNumber();
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

    public Vector<Student> getAllStudents() {
        return students;
    }

    abstract protected int getSessionLength();

    public double averageGpaForPartTimeStudents() {
        double total = 0.0;
        int count = 0;
        for (Enumeration<Student> it = students.elements(); it.hasMoreElements(); ) {
            Student student = it.nextElement();
            if (student.isFullTime())
                continue;
            count++;
            total += student.getGpa();
        }

        if (count == 0)
            return 0.0;
        return total / count;
    }

}
