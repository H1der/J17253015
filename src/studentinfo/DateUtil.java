package studentinfo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	public Date createDate(int year, int month, int date) {
		GregorianCalendar calender = new GregorianCalendar();
		calender.clear();
		calender.set(Calendar.YEAR, year);
		calender.set(Calendar.YEAR, year);
		calender.set(Calendar.MONTH, month - 1);
		calender.set(Calendar.DAY_OF_MONTH, date);
		return calender.getTime();
	}
}
