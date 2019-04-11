package zj.util;

public class Time24 {
	int hour;
	int min;
	int sec;

	public Time24(int hour, int min, int sec) {
		super();
		this.hour = hour;
		this.min = min;
		this.sec = sec;
		rationalize();
	}

	private void rationalize() {
		int inc = sec / 60;
		sec %= 60;
		min += inc;
		inc = min / 60;
		min %= 60;
		inc = hour / 24;
		hour %= 24;

	}

	@Override
	public String toString() {
		return "Time24 [hour=" + hour + ", min=" + min + ", sec=" + sec
				+ ", getHour()=" + getHour() + ", getMin()=" + getMin()
				+ ", getSec()=" + getSec() + ", toString()=" + super.toString()
				+ "]";
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getSec() {
		return sec;
	}

	public void setSec(int sec) {
		this.sec = sec;
	}

	void incSec() {
		sec++;
		rationalize();
	}

	void incMin() {
		min++;
		rationalize();
	}

	void incHour() {
		hour++;
		rationalize();
	}

	public static void main(String[] args) {
		Time24 a = new Time24(1, 2, 3);
		System.out.println(a);
		a.incHour();
		System.out.println(a);
	}
}
