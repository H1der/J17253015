package report;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;
import studentinfo.Student;
import studentinfo.Student.Grade;

public class ReportCardTest extends TestCase {
    private ReportCard card;

    protected void setUp() {
        card = new ReportCard();
    }
    public void testMessage() {
        ReportCard card = new ReportCard();
        assertEquals(ReportCard.A_MESSAGE, card.getMessage(Student.Grade.A));
        assertEquals(ReportCard.B_MESSAGE, card.getMessage(Student.Grade.B));
        assertEquals(ReportCard.C_MESSAGE, card.getMessage(Student.Grade.C));
        assertEquals(ReportCard.D_MESSAGE, card.getMessage(Student.Grade.D));
        assertEquals(ReportCard.F_MESSAGE, card.getMessage(Student.Grade.F));
    }

    public void testKeys() {
        Set<Student.Grade> expectedGrades = new HashSet<Student.Grade>();
        expectedGrades.add(Grade.A);
        expectedGrades.add(Grade.B);
        expectedGrades.add(Grade.C);
        expectedGrades.add(Grade.D);
        expectedGrades.add(Grade.F);

        Set<Student.Grade> grades = new HashSet<Student.Grade>();
        for (Student.Grade grade : card.getMessages().keySet())
            grades.add(grade);
        assertEquals(expectedGrades, grades);
    }
}
