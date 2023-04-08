package CalendarExam;

public class Day {
	
	private int day;
	private int month;
	private int year = 2023;
	
	private int effectiveSteps;

	private String dayName;
	private String monthName;
	
	private boolean weekDay;
	
	private int[] monthsLastDay = {31,28,31,30,31,30,31,31,30,31,30,31}; // This is for invariance
	private int[] monthsFirstDayIndex = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5}; // This is 2023 index of the first day with respect to the calendar week - used for finding the day of the week
	
	private String[] dayNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}; 
	private String[] monthNames = {"January", "Febuary", "March", "April", "May", "June", "July", "August", 
			"September", "October", "November", "December"};
	
	public Day(int month, int day) { // if not given a year it is assumed it is 2023
		
		if(month < 1 || month > 12 || day < 1 || day > monthsLastDay[month-1]) {
			throw new IllegalArgumentException("Date is invalid");
		}
		
		this.day = day;
		this.month = month;
		
		monthName = monthNames[month-1];
		dayName = dayNames[(day-1+monthsFirstDayIndex[month-1])%7];
		checkWeekDay();
		
	}
	
	public Day(int month, int day, int year) { // This works for all years that apply to the Gregorian calendar
		
		if(isLeapYear(year) == true) {
			monthsLastDay[1] += 1;
		}
		
		if(month < 1 || month > 12 || day < 1 || day > monthsLastDay[month-1]) {
			throw new IllegalArgumentException("Date is invalid");
		}
		
		this.month = month;
		this.day = day;
		this.year = year;
		
		setMonthsFirstDayIndex(year);
		monthName = monthNames[month-1];
		dayName = dayNames[(day-1+monthsFirstDayIndex[month-1])%7];
		checkWeekDay();
		
	} 
	
	private void checkWeekDay() { // checks whether a day is a week day
		if(day + monthsFirstDayIndex[month-1] >= 8) {
			if((day-1+monthsFirstDayIndex[month-1])%7 != 0 && (day-1+monthsFirstDayIndex[month-1])%7 != 6) {
				weekDay = true;
			} else {
				weekDay = false;
			}
		} else {
			if(day + monthsFirstDayIndex[month-1] != 1 && day + monthsFirstDayIndex[month-1] != 7) {
				weekDay = true;
			} else {
				weekDay = false;
			}
		} 
	}
	
	private boolean isLeapYear(int year) { // check whether a year is a leap year
		if((year < 400 && year % 4 == 0 && year % 100 != 0) || (year >= 400 && year % 4 == 0 && (year % 100 != 0 || year % 100 == 0 && year % 400 == 0))) {
			return true;
		} else {
			return false;
		}
	}
	
	private void setMonthsFirstDayIndex(int year) { // Use this to set the index with respect to the year
		if(year > 2023) {
			indexMoreThan();
		} else if ( year < 2023) {
			indexLessThan();
		}
	}
	
	private void indexLessThan() { // if the year is less than 2023 then call this to re-index
		int dayShift;
		int dayShiftCount = 0;
		for(int i = year; i <= 2022; i++) {
			if(isLeapYear(i) == true) {
				dayShiftCount += 2;
			} else {
				dayShiftCount++;
			}
		}
		dayShift = dayShiftCount % 7;
		dayShift = 7 - dayShift;
		if(isLeapYear(year) == true) {
			for(int i = 0; i < 12; i++) {
				if(i == 0 || i == 1) {
					monthsFirstDayIndex[i] += dayShift-1;
				} else {
					monthsFirstDayIndex[i] += dayShift;
				}
			}
		} else {
			for(int i = 0; i < 12; i++) {
				monthsFirstDayIndex[i] += dayShift;
			}
		}
	}
	
	private void indexMoreThan() { // if the year is greater than 2023 then call this to re-index
		int dayShift;
		int dayShiftCount = 0;
		for(int i = 2024; i <= year; i++) {
			if(isLeapYear(i) == true) {
				dayShiftCount += 2;
			} else {
				dayShiftCount++;
			}
		}
		dayShift = dayShiftCount % 7;
		if(isLeapYear(year) == true) {
			for(int i = 0; i < 12; i++) {
				if(i == 0 || i == 1) {
					monthsFirstDayIndex[i] += dayShift-1;
				} else {
					monthsFirstDayIndex[i] += dayShift;
				}
			}
		} else {
			for(int i = 0; i < 12; i++) {
				monthsFirstDayIndex[i] += dayShift;
			}
		}
	}
	
	public void addSteps(int steps) {  
		if(weekDay == true) {
			effectiveSteps = steps;
		} else {
			effectiveSteps = (int) (1.5*steps);
		}
	}
	
	public int getSteps() {
		return effectiveSteps;
	}

	public String toString() {
		return "Date: " + month + "/" + day + "/" + year + "\nDay Name: " + dayName + "\nMonth Name: " + monthName +
				"\nWeekday: " + weekDay + "\nEffective Steps: " + effectiveSteps + "\n";
	}
	
	public boolean equals(Object o) {
		if(o instanceof Day d) {
			if(d.day == this.day && d.month == this.month && d.year == this.year && d.effectiveSteps == this.effectiveSteps) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
