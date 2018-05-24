package studentinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Student {
    public enum Grade {
        A(4), B(3), C(2), D(1), F(0);

        private int points;

        Grade(int points) {
            this.points = points;
        }

        int getPoints() {
            return points;
        }
    }

    public enum Flag {
        ON_CAMPUS(1),
        TAX_EXEMPT(2),
        MINOR(4),
        TROUBLEMAKER(8);

        private int mask;

        Flag(int mask) {
            this.mask = mask;
        }
    }

    private int settings = 0X0;

    private String id;
	private String name;
	private int credits;
    public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    public static final String IN_STATE = "CO";
    public static final Object MAX_NAME_PARTS = 3;
    private String state = "";
    private ArrayList<Grade> grades = new ArrayList<Grade>();
    private GradingStrategy gradingStrategy = new BasicGradingStrategy();
    private String firstName = "";
    private String middleName = "";
    private String lastName;
    private List<Integer> charges = new ArrayList<Integer>();
    static final String TOO_MANY_NAME_PARTS_MSG = "Student name '%s' contains more than %d parts";
    final static Logger logger = Logger.getLogger(Student.class.getName());

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    void setGradingStrategy(GradingStrategy gradingStrategy) {
        this.gradingStrategy = gradingStrategy;
    }

    public Student(String fullName) {
        this.name = fullName;

        credits = 0;
        List<String> nameParts = split(fullName);
        final int maximumNumberOfNameParts = 3;
        if (nameParts.size() > maximumNumberOfNameParts) {
            String message = String.format(Student.TOO_MANY_NAME_PARTS_MSG, fullName, MAX_NAME_PARTS);
            Student.logger.info(message);
            throw new StudentNameFormatException(message);
        }
        setName(nameParts);
    }


    private void setName(List<String> nameParts) {
        this.lastName = removeLast(nameParts);
        String name = removeLast(nameParts);
        if (nameParts.isEmpty())
            this.firstName = name;
        else {
            this.middleName = name;
            this.firstName = removeLast(nameParts);
        }
    }

    private String removeLast(List<String> list) {
        if (list.isEmpty())
            return "";
        return list.remove(list.size() - 1);
    }

    private List<String> split(String fullName) {
        List<String> results = new ArrayList<String>();

        StringBuffer word = new StringBuffer();
        for (int index = 0; index < name.length(); index++) {
            char ch = name.charAt(index);
            if (!Character.isWhitespace(ch))
                word.append(ch);
            else if (word.length() > 0) {
                results.add(word.toString());
                word = new StringBuffer();
            }
        }
        if (word.length() > 0)
            results.add(word.toString());
        return results;
    }

    public static int countChars(String input, char ch) {
        int i;
        int count;
        for (i = 0, count = 0; i < input.length(); i++)
            if (input.charAt(i) == ch)
                count++;
        return count;
    }

    public List<String> tokenize(String string) {
        List<String> resulits = new ArrayList<String>();

        StringBuffer word = new StringBuffer();
        int index = 0;
        while (index < string.length()) {
            char ch = string.charAt(index);
            if (ch != ' ') {
                word.append(ch);
            } else if (word.length() > 0) {
                resulits.add(word.toString());
                word = new StringBuffer();
            }
            index++;
        }
        if (word.length() > 0)
            resulits.add(word.toString());

        return resulits;

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
        Student.logger.fine("begin getGpa " + System.currentTimeMillis());
        if (grades.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for (Grade grade : grades) {
            total += gradingStrategy.getGradepointsFor(grade);
        }
        Student.logger.fine("begin getGpa " + System.currentTimeMillis());
        return total / grades.size();

    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public void addCharge(int charge) {
        charges.add(new Integer(charge));
    }

    public Object totalCharges() {
        int total = 0;
        for (Integer charge : charges)
            total += charge.intValue();
        return total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void unset(Flag... flags) {
        for (Flag flag : flags)
            settings &= ~flag.mask;
    }

    public boolean isOn(Flag flag) {
        // TODO �Զ����ɵķ������
        return (settings & flag.mask) == flag.mask;
    }

    public boolean isOff(Flag flag) {
        // TODO �Զ����ɵķ������
        return !isOn(flag);
    }

    public void set(Flag... flags) {
        for (Flag flag : flags)
            settings |= flag.mask;
    }

}
