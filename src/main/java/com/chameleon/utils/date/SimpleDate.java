package com.chameleon.utils.date;



import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.Date;



/** @author */

public class SimpleDate

{



	public final static int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);

	public final static int CURRENT_MONTH = Calendar.getInstance().get(Calendar.MONTH);

	public final static int CURRENT_DAY = Calendar.getInstance().get(Calendar.DATE);

	public static final String MONTHS[] = { "January", "February", "March", "April", "May", "June", "July", "August",

			"September", "October", "November", "December" };



	private Calendar calendar = Calendar.getInstance();

	private int month = calendar.get(Calendar.MONTH);

	private int day = calendar.get(Calendar.DATE);

	private int year = calendar.get(Calendar.YEAR);



	public Calendar getCalendar()

	{

		return calendar;

	}



	public static Timestamp getTimestamp()

	{

		return new Timestamp(new java.util.Date().getTime());

	}



	public void setCalendar(Calendar calendar)

	{

		this.calendar = calendar;

		month = this.calendar.get(Calendar.MONTH);

		day = this.calendar.get(Calendar.DATE);

		year = this.calendar.get(Calendar.YEAR);

	}



	public int getMonth()

	{

		return month;

	}



	public void setMonth(int month)

	{

		this.month = month;

		calendar.set(Calendar.MONTH, month);

	}



	public int getDay()

	{

		return day;

	}



	public void setDay(int day)

	{

		this.day = day;

		calendar.set(Calendar.DATE, day);

	}



	public int getYear()

	{

		return year;

	}



	public void setYear(int year)

	{

		this.year = year;

		calendar.set(Calendar.YEAR, year);

	}



	public SimpleDate advanceDay(int days)

	{

		calendar.add(Calendar.DATE, days);

		day = calendar.get(Calendar.DATE);

		return this;

	}



	public SimpleDate advanceMonth(int months)

	{

		calendar.add(Calendar.MONTH, months);

		month = calendar.get(Calendar.MONTH);

		return this;

	}



	public SimpleDate advanceYear(int years)

	{

		calendar.add(Calendar.YEAR, years);

		year = calendar.get(Calendar.YEAR);

		return this;

	}



	public String getMonthString()

	{

		return MONTHS[month];

	}



	public String toString(String format)

	{

		SimpleDateFormat simpleDate = new SimpleDateFormat(format);

		Date date = calendar.getTime();

		String dateString = simpleDate.format(date);

		return dateString;

	}



	public boolean isBefore(SimpleDate date)

	{

		return calendar.before(date);

	}



	public boolean isAfter(SimpleDate date)

	{

		return calendar.after(date);

	}



	public int compareTo(SimpleDate date)

	{

		return calendar.compareTo(date.getCalendar());

	}



	public int compareCalendarTo(Calendar calendar)

	{

		return this.calendar.compareTo(calendar);

	}



	/** @author HFARAZ

	 *         Method to get the hour */

	public int getHour()

	{

		Date date = new Date();

		calendar.setTime(date);

		return calendar.get(Calendar.HOUR_OF_DAY);

	}



	/** @author HFARAZ

	 *         Method to get the minutes */

	public int getMinute()

	{

		Date date = new Date();

		calendar.setTime(date);

		return calendar.get(Calendar.MINUTE);

	}



	/** @author HFARAZ */

	public static String getCurrentDate(String format)

	{

		Date date = new Date();

		return new SimpleDateFormat(format).format(date);

	}



	/** @author HFARAZ

	 *         Method to get Tomorrow's Date in a certain format */

	public String getTomorrowDate(String format)

	{



		// get a date to represent "today"

		Date today = calendar.getTime();



		// add one day to the date/calendar

		calendar.add(Calendar.DAY_OF_YEAR, 1);



		// now get "tomorrow"

		Date tomorrow = calendar.getTime();

		return new SimpleDateFormat(format).format(tomorrow);

	}



	/** @author HFARAZ

	 *         Method to get the current day of the week */

	public String getCurrentDay()

	{

		int today = calendar.get(Calendar.DAY_OF_WEEK);

		String dayOfTheWeek = "";



		switch (today)

		{

		case Calendar.SUNDAY:

			dayOfTheWeek = "SUNDAY";

			break;

		case Calendar.MONDAY:

			dayOfTheWeek = "MONDAY";

			break;

		case Calendar.TUESDAY:

			dayOfTheWeek = "TUESDAY";

			break;

		case Calendar.WEDNESDAY:

			dayOfTheWeek = "WEDNESDAY";

			break;

		case Calendar.THURSDAY:

			dayOfTheWeek = "THURSDAY";

			break;

		case Calendar.FRIDAY:

			dayOfTheWeek = "FRIDAY";

			break;

		case Calendar.SATURDAY:

			dayOfTheWeek = "SATURDAY";

			break;

		}

		return dayOfTheWeek;

	}



	/** @author HFARAZ

	 *         Method to get the tomorrow's day */

	public String getTomorrowsDay()

	{

		int today = calendar.get(Calendar.DAY_OF_WEEK);

		int tomorrow = today + 1;

		String dayOfTheWeek = "";



		switch (tomorrow)

		{

		case Calendar.SUNDAY:

			dayOfTheWeek = "SUNDAY";

			break;

		case Calendar.MONDAY:

			dayOfTheWeek = "MONDAY";

			break;

		case Calendar.TUESDAY:

			dayOfTheWeek = "TUESDAY";

			break;

		case Calendar.WEDNESDAY:

			dayOfTheWeek = "WEDNESDAY";

			break;

		case Calendar.THURSDAY:

			dayOfTheWeek = "THURSDAY";

			break;

		case Calendar.FRIDAY:

			dayOfTheWeek = "FRIDAY";

			break;

		case Calendar.SATURDAY:

			dayOfTheWeek = "SATURDAY";

			break;

		}

		return dayOfTheWeek;

	}


	public String getCurrentTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("hh:mm aa");
    	String currentTime = dateFormat.format(new Date()).toString();
    	return currentTime;
	}

}