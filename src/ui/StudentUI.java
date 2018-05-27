package ui;

import java.io.*;
import java.util.*;

import studentinfo.Student;

public class StudentUI {
    static final String MENU = "(A)dd or (Q)uit?";
    static final String ADD_OPTION = "A";
    static final String QUIT_OPTION = "Q";
    static final String NAME_PROMPT = "Name: ";
    static final String ADDED_MESSAGE = "Added";

    private BufferedReader reader;
    private BufferedWriter writer;
    private List<Student> students = new ArrayList<Student>();

    public StudentUI() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void run() throws IOException {
        String line;

        do {
            writer(MENU);
            line = reader.readLine();
            if (line.equals(ADD_OPTION))
                addStudent();
        } while (!line.equals(QUIT_OPTION));
    }

    private void addStudent() throws IOException {
        writer(NAME_PROMPT);
        String name = reader.readLine();

        students.add(new Student(name));
        writeln(ADDED_MESSAGE);

    }

    private void writeln(String line) throws IOException {
        writer(line);
        writer.newLine();
        writer.flush();
    }

    private void writer(String line) throws IOException {
        writer.write(line, 0, line.length());
        writer.flush();
    }

    List<Student> getAddedStudents() {
        return students;
    }
}
