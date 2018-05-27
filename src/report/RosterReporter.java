package report;

import studentinfo.CourseSession;
import studentinfo.Session;
import studentinfo.Student;

import java.io.*;

public class RosterReporter {
	public static final String NEWLINE = System.getProperty("line.separator");
    public static final String ROSTER_REPORT_HEADER = "Student%n-%n";
    public static final String ROSTER_REPORT_FOOTER = NEWLINE + "%n# students = %d%n";

    private Session session;
    private Writer writer;

    RosterReporter(Session session) {
		this.session = session;
	}

	public String getReport() {
		StringBuilder buffer = new StringBuilder();
		writeHeader(buffer);
		writeBody(buffer);
		writeFooter(buffer);
		return buffer.toString();
	}

	private void writeFooter(StringBuilder buffer) {

		buffer.append(ROSTER_REPORT_FOOTER + session.getAllStudents().size() + NEWLINE);
	}

	private void writeBody(StringBuilder buffer) {
		for (Student student : session.getAllStudents()) {
			buffer.append(student.getName());
			buffer.append(NEWLINE);
		}
	}

	private void writeHeader(StringBuilder buffer) {

		buffer.append(ROSTER_REPORT_HEADER);
	}

    public void writeReport(Writer writer) throws IOException {
        this.writer = writer;
        writerHeader();
        writerBody();
        writerFooter();
    }

    private void writerFooter() throws IOException {
        writer.write(String.format(ROSTER_REPORT_FOOTER, session.getAllStudents().size()));
    }

    private void writerBody() throws IOException {
        for (Student student : session.getAllStudents())
            writer.write(String.format(student.getName() + "%n"));
    }

    private void writerHeader() throws IOException {
        writer.write(String.format(ROSTER_REPORT_HEADER));
    }

    public void writeReport(String filename) throws IOException {
        Writer bufferedWriter = new BufferedWriter(new FileWriter(filename));

        try {
            writeReport(bufferedWriter);
        } finally {
            bufferedWriter.close();
        }
    }

}
