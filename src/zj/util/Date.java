package zj.util;

public class Date {
	/**
	 * （年+年/4+年/400-年/100-年基数+月基数+日）/7＝……余星期几 注：式中分数均取整 年基数，平年1,闰年2,
	 * 月基数，1、平年：一月0, 二月3, 三月3, 四月6, 五月1, 六月4, 七月0, 八月3, 九月5, 十月0, 十一月3, 十二月5.
	 * 2、闰年：一月0, 二月3, 三月4, 四月0, 五月2, 六月5, 七月0, 八月3, 九月6, 十月1, 十一月4, 十二月6.
	 * 
	 * 如：1949年10月1日是星期几？ （1949+1949/4+1949/400-1949/100-1+0+1）/7
	 * ＝（1949+487+4-19-1+0+1）/7 ＝345……6
	 */
	final static int YJS[][] = { { 0, 0, 3, 3, 6, 1, 4, 0, 3, 5, 0, 3, 5 },
		{ 0, 0, 3, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6 } };
	int getWeek() {
		int index = isleap() ? 1 : 0;
		int ljs = 1 + index;
		int yjs = YJS[index][month];
		int k = (year + year / 4 + year / 400 - year / 100 - ljs + yjs + day) % 7;
		if (k == 0)
			k += 7;
		return k;

	}

	private boolean isleap() {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}

	final static Date START = new Date(1900, 01, 1);

	final static int MONTHOFDAY[][] = {
			{ 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
			{ 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } };

	final static String[] MONTHNAME = "UNAME January February March April May June July Augus September October November December"
			.split("\\s+");
	final static String[] WEEKNAME = " MONDAY TUESDAY WEDNSDAY THURSDAY FRIDAY SATUARDAY SUNDAY"
			.split("\\s+");
	int year = 1900;
	int month = 01;
	int day = 01;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Date(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public static void main(String[] args) {
		// (1).美国总统林肯遇刺,1865年4月14日,星期5;
		// (2).美国独立纪念日,1776年7月4日,星期日;
		// (3).日本偷袭珍珠港,1941年1941年12月7日;
		System.out.println(new Date(1865, 4, 14).getWeek());
		System.out.println(new Date(1776, 7, 4).getWeek());
		System.out.println(new Date(1941, 12, 7).getWeek());
		System.out.println(new Date(2014, 4, 22).getWeek());
		System.out.println(new Date(1900, 1, 1).getWeek());

		Date d = new Date(1980, 04, 23);
		Date a = new Date(2014, 04, 23);
		System.out.println(d.getWeek());
		System.out.println(a.differ(d));
	}

	private int differ(Date that) {

		return that.differ() - this.differ();
	}

	private int differ() {

		int sum = 0;
		for (int i = START.year; i < this.year; i++)
			if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
				sum += 366;
			} else
				sum += 365;
		int index = isleap() ? 1 : 0;
		for (int i = 1; i < month; i++)
			sum += MONTHOFDAY[index][i];
		sum += day;
		return sum;
	}

	@Override
	public String toString() {
		return "Date [year=" + year + ", month=" + month + ", day=" + day
				+ ", getYear()=" + getYear() + ", getMonth()=" + getMonth()
				+ ", getDay()=" + getDay() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
