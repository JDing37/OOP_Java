package CalendarExam;

public class WorkDay extends Day {

	private int hours;

	public WorkDay(int day, int month, int hours) {
		super(day, month);
		this.hours = hours;
	}
	
	public WorkDay(int day,  int month, int year, int hours) {
		super(day, month, year);
		this.hours = hours;
	}
	
	public void addSteps(int steps) {
		int effectiveSteps = 0*steps;
		super.addSteps(effectiveSteps);
	}
	
	public int getWorkHours() {
		return hours;
	}

	public String toString() {
		return super.toString() + "Hours Worked: " + hours + "\n";
	}
	
	public boolean equals(Object o) {
		if(o instanceof WorkDay d) {
			if(super.equals(d) == true && d.hours == this.hours) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
