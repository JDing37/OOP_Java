package CalendarExam;

import java.util.ArrayList;

public class DateTester {
	
	public static void main(String[] args) {
		
		//Code to test all of January
		
		ArrayList<Day> january = new ArrayList<Day>();
		
		for(int k = 0; k < 31; k++) { 
			january.add(new Day(1,1));
		}
		
		january.add(0,new Holiday(1,1,"New Year's Day")); 
		january.remove(1);
		january.add(1,new Holiday(1,2,"New Year's Holiday"));
		january.remove(2);
		january.add(2,new Holiday(1,3,"Tenth of Tevet"));
		january.remove(3);
		january.add(3,new SnowDay(1,4));
		january.remove(4);
		((SnowDay) january.get(3)).addSnow(3);
		((SnowDay) january.get(3)).addSnow(10);
		january.add(4,new WorkDay(1,5,5));
		january.remove(5);
		january.add(5,new Holiday(1,6, "Epiphany"));
		january.remove(6);
		january.add(6,new WorkDay(1,7,7));
		january.remove(7);
		january.add(8,new Holiday(1,9,"Coming of Age Day"));
		january.remove(9);
		january.add(10,new WorkDay(1,11,9));
		january.remove(11);
		january.add(11,new SnowDay(1,12));
		january.remove(12);
		((SnowDay) january.get(11)).addSnow(7);
		january.add(16,new SnowDay(1,17));
		january.remove(17);
		((SnowDay) january.get(16)).addSnow(3);
		((SnowDay) january.get(16)).addSnow(6);
		((SnowDay) january.get(16)).addSnow(5);
		january.add(19,new WorkDay(1,20,9));
		january.remove(20);
		january.add(20,new Holiday(1,21,"Spring Festival"));
		january.remove(21);
		
		for(int i = 7; i < 31; i++) {
			if(i != 8 && i != 10 && i != 11 && i != 16 && i != 19 && i != 20) {
				january.add(i, new Day(1,i+1));
				january.remove(i+1);
			}
		}
		
		january.get(3).addSteps(1000);
		january.get(4).addSteps(1500);
		january.get(7).addSteps(1000);
		january.get(8).addSteps(5000);
		january.get(12).addSteps(3000);
		january.get(14).addSteps(5000);
		january.get(18).addSteps(2000);
		january.get(19).addSteps(5000);
		january.get(24).addSteps(1000);
		
		int janSteps = 0;
		int janSnow = 0;
		int janHours = 0;
		for(int k = 0; k < 31; k++) {
			janSteps += january.get(k).getSteps();
			if(january.get(k) instanceof SnowDay) {
				janSnow += ((SnowDay) january.get(k)).getSnowFall();
			}
			if(january.get(k) instanceof WorkDay) {
				janHours += ((WorkDay) january.get(k)).getWorkHours();
			}
			System.out.println(january.get(k));
		}
		
		System.out.println("Total steps in January: " + janSteps);
		System.out.println("Total snow fall in January: " + janSnow);
		System.out.println("Total hours worked in January: " + janHours);
		System.out.println();
		
		// end of January test code
		
		// test equals method
		
		/*
		
		SnowDay piDay = new SnowDay(3, 14, 2012);
		SnowDay samePiDay = new SnowDay(3, 14, 2012);
		SnowDay differentPiDay = new SnowDay(3, 14, 2011);
		Day completelyDifferentDay = new Day(4, 15, 1783);
		
		piDay.addSnow(2);
		samePiDay.addSnow(2);
		System.out.println(piDay.equals(samePiDay));
		System.out.println(piDay.equals(differentPiDay));
		System.out.println(piDay.equals(completelyDifferentDay));
		
		*/
		
		// end of equals test
		
		// test all of 2023
		
		/*
				
		ArrayList<Day> twentyTwentyThree = new ArrayList<Day>();
		
		int[] monthsLastDayOne = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		for(int i = 1; i <= 12; i++) {
			for(int j = 1; j <= monthsLastDayOne[i-1]; j++) {
				twentyTwentyThree.add(new Day(i, j));
				System.out.println(twentyTwentyThree.get(twentyTwentyThree.size()-1));
			}
		}
		
		*/
		
		// end of 2023 test
		
		// test all of 1969 - "One step for man, One giant leap for mankind"
		
		/*
				
		ArrayList<Day> sixtyNine = new ArrayList<Day>();
		
		int[] monthsLastDayTwo = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		for(int i = 1; i <= 12; i++) {
			for(int j = 1; j <= monthsLastDayTwo[i-1]; j++) {
				sixtyNine.add(new Day(i, j, 1969));
				System.out.println(sixtyNine.get(sixtyNine.size()-1));
			}
		}
		
		*/
		
		// end of 1969 test
		
		
	}

}
