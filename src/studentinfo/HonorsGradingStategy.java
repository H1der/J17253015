package studentinfo;

public class HonorsGradingStategy extends BasicGradingStrategy {
    public int getGradepointsFor(Student.Grade grade) {
        int points = super.getGradepointsFor(grade);
        if (points > 0)
            points += 1;
        return points;
    }

}
