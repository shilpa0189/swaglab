package utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeAndDate {
	public static String DateAndTime()
	{
	LocalDateTime dateTime =LocalDateTime.now();
	DateTimeFormatter dateTimeFormatter	=DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
	String dateAndTime=dateTime.format(dateTimeFormatter);
	return dateAndTime;
	}

}
