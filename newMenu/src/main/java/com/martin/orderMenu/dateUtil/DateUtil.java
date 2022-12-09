package com.martin.orderMenu.dateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static final String LOG_FORMAT = "yyMMddHHmmss";
	
	private static final ThreadLocal<SimpleDateFormat> sdfLocal = 
			new ThreadLocal<SimpleDateFormat>();
	
	public static String getFormatTime(String format) {
		SimpleDateFormat sdf = getSDFLocal();
		sdf.applyPattern(format);
		return sdf.format(new Date());
	}
	
	private static final SimpleDateFormat getSDFLocal() {
		if(sdfLocal.get() == null) {
			sdfLocal.set(new SimpleDateFormat());
		}
		return sdfLocal.get();
	}
}
