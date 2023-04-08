package CalendarExam;

public class Holiday extends Day {

	private String name;

	public Holiday(int day, int month, String name) {
		super(day, month);
		this.name = name;
	}
	
	public Holiday(int day, int month, int year, String name) {
		super(day, month, year);
		this.name = name;
	}
	
	public void addSteps(int steps) {
		int effectiveSteps = 3*steps;
		super.addSteps(effectiveSteps);
	}
	
	public String toString() {
		return super.toString() + "Holiday name: " + name + "\n";
	}
	
	public boolean equals(Object o) {
		if(o instanceof Holiday d) {
			if(super.equals(d) == true && d.name == this.name) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
