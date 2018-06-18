package ui;

import studentinfo.*;

public class CourseDisplayAdapter extends Course {

    public CourseDisplayAdapter(Course course) {
        super(course.getDepartment(), course.getNumber());
    }

    @Override
    public String toString() {
        return String.format("%s-%s", getDepartment(), getNumber());
    }

}
