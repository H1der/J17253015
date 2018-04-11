package studentinfo;

import java.util.ArrayList;

public class Student {
    public enum Grade {
        A, B, C, D, E
    }

    ;

	private String name;
	private int credits;
    public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    public static final String IN_STATE = "CO";
    private String state = "";
    private ArrayList<Grade> grades = new ArrayList<Grade>();
    private GradingStrategy gradingStrategy = new RegularGradingStrategy();

    void setGradingStrategy(GradingStrategy gradingStrategy) {
        this.gradingStrategy = gradingStrategy;
    }

	public Student(String name) {
		this.name = name;
		credits = 0;
	}

	public String getName() {
		return name;
	}

	public boolean isFullTime() {
		return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
	}

	public int getCreadits() {
		return credits;
	}

	public void addCredits(int credits) {
		this.credits += credits;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isInState() {
		return state.equals(Student.IN_STATE);
	}

    public double getGpa() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for (Grade grade : grades) {
            total += gradingStrategy.getGradepointsFor(grade);
        }
        return total / grades.size();

    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

}
