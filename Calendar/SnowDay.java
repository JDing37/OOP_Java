package CalendarExam;

public class SnowDay extends Day {

	private int snowFall;

	public SnowDay(int day, int month) {
		super(day, month);
	}
	
	public SnowDay(int day, int month, int year) {
		super(day, month, year);
	}
	
	public void addSteps(int steps) {
		int effectiveSteps = 2*steps;
		super.addSteps(effectiveSteps);
	}
	
	public void addSnow(int unit) {
		snowFall += unit;
	}
	
	public int getSnowFall() {
		return snowFall;
	}
	
	public String toString() {
		return super.toString() + "Snow Fall: " + snowFall + "\n";
	}
	
	public boolean equals(Object o) {
		if(o instanceof SnowDay d) {
			if(super.equals(d) == true && d.snowFall == this.snowFall) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
