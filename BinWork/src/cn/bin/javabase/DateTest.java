package cn.bin.javabase;

import java.util.Calendar;
import java.util.Locale;

public class DateTest {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance(new Locale("Chinese"));
		System.out.println(calendar.get(Calendar.DATE));
	}
}
