package com.yw.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String date() {
		Date now=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String nowDate=dateFormat.format(now);
		return nowDate;
	}
}
