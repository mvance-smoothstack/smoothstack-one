/**
 * 
 */
package com.smoothstack.basics.five;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author max
 *
 */
public class DateTimeAPIUse {

	/**
	 * @param args
	 * @return 
	 */
	public static void main(String[] args) {
		Date now = new Date();
		
		Instant birthday = now.toInstant();
		System.out.println("The Instant class can be used to store points in time with nanosecond precision. "
				+ "For example, if someone were born right now, that person's birthday would be: ");
		System.out.println(birthday.toString() + " " + birthday.getNano());
		System.out.println("--------------------------------------------------");
		
		
		ZoneId est = ZoneId.of("America/New_York");
		LocalDate localNow = LocalDate.now(est);
		DayOfWeek currentDay = DayOfWeek.from(localNow);
		currentDay = currentDay.minus(1);
		//by starting with 1 day back, we make sure that if it's Thursday right now, we look back to the previous Thursday
		int daysBack = 1;
		while (currentDay != DayOfWeek.THURSDAY) {
			daysBack++;
			currentDay = currentDay.minus(1);
		}
		System.out.println("The DayOfWeek class handles operations regarding the day of the week. "
				+ "For example, the previous Thursday from now is: ");
		System.out.println(localNow.minusDays(daysBack));
		System.out.println("--------------------------------------------------");
		
		
		/*
		 * 3. A ZoneId directly specifies a time zone. A ZoneOffset specifies a time zone
		 * relative to GMT/UTC by number of hours and minutes to add or subtract.
		 */
		
		ZoneId cst = ZoneId.of("America/Chicago");
		ZonedDateTime zonedBirthday = birthday.atZone(cst);
		System.out.println("The Instant class provides a method, atZone, for converting an Instant to a ZonedDateTime. "
				+ "For example, right now in CST is: ");
		System.out.println(zonedBirthday);
		System.out.println("ZonedDateTime implements the toInstant method from ChronoZonedDateTime, which converts it to an Instant.");
		System.out.println(zonedBirthday.toInstant());
		System.out.println("--------------------------------------------------");
		
		
		System.out.println("Given 2016, its months are: ");
		int year = 2016;
		LocalDate checkYear = LocalDate.of(year, 12, 31);	//month and day not important in this example; end of year chosen arbitrarily
		for (int monthNum = 1; monthNum <= 12; monthNum++) {
			Month current = Month.of(monthNum);
			System.out.println(current + ": " + current.length(checkYear.isLeapYear()));
		}
		System.out.println("--------------------------------------------------");
		
		
		System.out.println("Given March of this year:");
		LocalDate checkDaysOfWeek = LocalDate.of(2021, 3, 1);
		for (int dayNum = 0; dayNum < checkDaysOfWeek.getMonth().length(checkDaysOfWeek.isLeapYear()); dayNum++) {
			if (checkDaysOfWeek.plusDays(dayNum).getDayOfWeek() == DayOfWeek.MONDAY) {
				System.out.println(checkDaysOfWeek.plusDays(dayNum).toString());
			}
		}
		System.out.println("--------------------------------------------------");
		
		
		System.out.println("Given a few days in October - November 2020:");
		LocalDate isFriday13 = LocalDate.of(2020, 11, 13);
		LocalDate isFriday = LocalDate.of(2020, 11, 20);
		LocalDate is13 = LocalDate.of(2020, 10, 13);
		System.out.println(isFriday.toString() + " is Friday the 13th: " + checkFriday13(isFriday));
		System.out.println(is13.toString() + " is Friday the 13th: " + checkFriday13(is13));
		System.out.println(isFriday13.toString() + " is Friday the 13th: " + checkFriday13(isFriday13));
	}
	
	public static boolean checkFriday13(LocalDate theDate) {
		if ((theDate.getDayOfMonth() == 13) && (theDate.getDayOfWeek() == DayOfWeek.FRIDAY)) {
			return true;
		} else {
			return false;
		}
	}

}
