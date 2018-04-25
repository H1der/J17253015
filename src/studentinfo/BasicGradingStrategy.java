package studentinfo;


public class BasicGradingStrategy implements GradingStrategy {

    public int getGradepointsFor(Student.Grade grade) {
        return grade.getPoints();
    }


}
