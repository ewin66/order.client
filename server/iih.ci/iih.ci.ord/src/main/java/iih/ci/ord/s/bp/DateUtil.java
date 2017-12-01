package iih.ci.ord.s.bp;

import org.apache.commons.lang.StringUtils;

import xap.mw.coreitf.d.Calendars;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.ICalendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**
	 * 按格式获得时间串
	 * 
	 * @param sDate
	 * @param formatStr
	 * @return
	 */
	public static String getDateTimeStr(Object oDate, String formatStr) {
		if (oDate == null)
			return "";
		try {
			return getDateTimeStr(oDate.toString(), formatStr);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 按格式获得时间串
	 * 
	 * @param sDate
	 * @param formatStr
	 * @return
	 */
	public static String getDateTimeStr(String sDate, String formatStr) {
		try {
			if (StringUtils.isBlank(sDate))
				return "";
			if (StringUtils.isBlank(formatStr))
				return sDate;
			DateFormat dfa = new SimpleDateFormat(formatStr);
			Calendar cal = Calendar.getInstance();
			cal.setTime(stringToDate(sDate));
			return dfa.format(cal.getTime());
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 按格式获得时间串
	 * 
	 * @param date
	 * @param formatStr
	 * @return
	 */
	public static String getDateTimeStr(Date date, String formatStr) {
		if (StringUtils.isBlank(formatStr))
			return date.toString();
		DateFormat dfa = new SimpleDateFormat(formatStr);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return dfa.format(cal.getTime());
	}

	/**
	 * 按格式获得时间串
	 * 
	 * @param date
	 * @param formatStr
	 * @return
	 */
	public static String getDateTimeStr(FDate date, String formatStr) {
		if (StringUtils.isBlank(formatStr))
			return date.toString();
		DateFormat dfa = new SimpleDateFormat(formatStr);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date.toDate());
		return dfa.format(cal.getTime());
	}

	public static Date stringToDate(String sDate) throws Exception {
		DateFormat dfa = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dfa.parse(sDate);
	}

}
