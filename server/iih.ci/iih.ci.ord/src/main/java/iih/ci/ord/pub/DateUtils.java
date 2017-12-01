package iih.ci.ord.pub;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;

import xap.mw.coreitf.d.Calendars;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.coreitf.d.ICalendar;

public class DateUtils {
	public static String dateTimeFormatStr="yyyy-MM-dd HH:mm:ss";
	public static String dateFormatStr="yyyy-MM-dd";
	private static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private static SimpleDateFormat dayFormat = new SimpleDateFormat(
			"yyyy-MM-dd");

	private static SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

	private static SimpleDateFormat monthFormat = new SimpleDateFormat(
			"yyyy-MM");

	private static SimpleDateFormat hourFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:00");

	private static SimpleDateFormat minuteFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm");

	private static SimpleDateFormat shortTimeFormat = new SimpleDateFormat(
			"HH:mm:ss");

	private static SimpleDateFormat millisecondFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss SSS");

	public static String getCurYear() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat fmt = (SimpleDateFormat) yearFormat.clone();
		String date = fmt.format(calendar.getTime());
		return date;
	}

	public static String getCurMonth() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat fmt = (SimpleDateFormat) monthFormat.clone();
		String date = fmt.format(calendar.getTime());
		return date;
	}

	public static String getCurQuarter() {
		String year = getCurYear();
		String yearMonth = getCurMonth();
		int monthCount = yearMonth.length();

		String month = yearMonth.substring(monthCount - 2, monthCount);

		int intMonth = Integer.valueOf(month).intValue();
		int intQuarter = (intMonth % 3 == 0) ? intMonth / 3 : intMonth / 3 + 1;

		return year + "-Q-" + intQuarter;
	}

	public static String getCurTime() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat fmt = (SimpleDateFormat) dateFormat.clone();
		String date = fmt.format(calendar.getTime());
		return date;
	}

	public static String getCurShortTime() {
		Calendar calendar = Calendar.getInstance();

		SimpleDateFormat fmt = (SimpleDateFormat) shortTimeFormat.clone();
		String time = fmt.format(calendar.getTime());
		return time;
	}

	public static SimpleDateFormat getDateFormat() {
		SimpleDateFormat fmt = (SimpleDateFormat) dateFormat.clone();
		return fmt;
	}

	public static SimpleDateFormat getMonthFormat() {
		SimpleDateFormat fmt = (SimpleDateFormat) monthFormat.clone();
		return fmt;
	}

	public static SimpleDateFormat getMinuteFormat() {
		SimpleDateFormat fmt = (SimpleDateFormat) minuteFormat.clone();
		return fmt;
	}

	public static SimpleDateFormat getDayFormat() {
		SimpleDateFormat fmt = (SimpleDateFormat) dayFormat.clone();
		return fmt;
	}

	public static SimpleDateFormat getYearFormat() {
		SimpleDateFormat fmt = (SimpleDateFormat) yearFormat.clone();
		return fmt;
	}

	public static SimpleDateFormat getHourFormat() {
		SimpleDateFormat fmt = (SimpleDateFormat) hourFormat.clone();
		return fmt;
	}

	public static SimpleDateFormat getMillisecondFormat() {
		SimpleDateFormat fmt = (SimpleDateFormat) millisecondFormat.clone();
		return fmt;
	}

	public static String getCurTimeWithMillisecond() {
		Calendar calendar = Calendar.getInstance();
		String date = getMillisecondFormat().format(calendar.getTime());
		return date;
	}

	public static long getCurTimeInt() {
		return System.currentTimeMillis();
	}

	public static String getCurDay() {
		Calendar calendar = Calendar.getInstance();
		String day = getDayFormat().format(calendar.getTime());
		return day;
	}

	public static String getCurHour() {
		Calendar calendar = Calendar.getInstance();
		String day = getHourFormat().format(calendar.getTime());
		return day;
	}

	public static boolean checkDate(String pDateObj) {
		boolean ret = true;
		if ((pDateObj == null) || (pDateObj.length() < 1)) {
			ret = false;
		}
		try {
			String[] arr = pDateObj.split("-");

			int year = new Integer(arr[0]).intValue();

			int month = new Integer(arr[1]).intValue();

			int day = new Integer(arr[2]).intValue();

			Calendar cal = Calendar.getInstance();

			cal.setLenient(false);
			cal.set(year, month - 1, day);

			cal.getTime();
		} catch (Exception e) {
			ret = false;
		}
		return ret;
	}

	public static long diffMillisecond(String startTime, String endTime)
			throws ParseException {
		SimpleDateFormat format = getMillisecondFormat();
		Date dstartTime = format.parse(startTime);
		Date dendTime = format.parse(endTime);
		return dendTime.getTime() - dstartTime.getTime();
	}

	public static Date convertStrToDate(String srcDateStr) {
		if ((srcDateStr == null) || (srcDateStr.trim().length() == 0))
			return null;
		try {
			SimpleDateFormat format = getDayFormat();
			if (srcDateStr.indexOf("/") > 0) {
				format = new SimpleDateFormat("yyyy/MM/dd");
			}

			return format.parse(srcDateStr);
		} catch (ParseException e) {
		}
		return null;
	}

	public static String millis2Str(long time) {
		if (time < 0L) {
			return null;
		}
		return getMillisecondFormat().format(new Date(time));
	}

	public static int getDayNum(int year, int month) {
		boolean leapYear = isLeapYear(year);
		int dayMount = 31;
		switch (month) {
		case 2:
			dayMount = (leapYear) ? 29 : 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			dayMount = 30;
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		}
		return dayMount;
	}

	public static boolean isAllowDate(String strDate) {
		if ((strDate == null) || (strDate.trim().length() == 0)) {
			return true;
		}
		if (strDate.trim().length() != 10) {
			return false;
		}
		for (int i = 0; i < 10; ++i) {
			char c = strDate.trim().charAt(i);
			if ((i == 4) || (i == 7)) {
				if (c != '-')
					return false;
			} else if ((c < '0') || (c > '9')) {
				return false;
			}
		}
		int year = Integer.parseInt(strDate.trim().substring(0, 4));
		int month = Integer.parseInt(strDate.trim().substring(5, 7));
		if ((month < 1) || (month > 12)) {
			return false;
		}
		int day = Integer.parseInt(strDate.trim().substring(8, 10));
		int[] MONTH_LENGTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] LEAP_MONTH_LENGTH = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30,
				31 };
		int daymax = (isLeapYear(year)) ? LEAP_MONTH_LENGTH[(month - 1)]
				: MONTH_LENGTH[(month - 1)];

		return ((day >= 1) && (day <= daymax));
	}

	public static boolean isLeapYear(int year) {
		return ((year % 4 == 0) && (((year % 100 != 0) || (year % 400 == 0))));
	}

	public static String getValidUFODateString(String sDate) {
		try {
			if (isAllowDate(sDate)) {
				return sDate;
			}

			int index = sDate.indexOf("-");
			if (index < 1) {
				return null;
			}
			int year = Integer.parseInt(sDate.trim().substring(0, index));

			String sTemp = sDate.trim().substring(index + 1);
			index = sTemp.indexOf("-");
			if (index < 1) {
				return null;
			}
			String strMonth = sTemp.trim().substring(0, index);
			if (strMonth.startsWith("0")) {
				strMonth = strMonth.substring(1);
			}
			int month = Integer.parseInt(strMonth);

			if ((month < 1) || (month > 12)) {
				return null;
			}
			String strDay = sTemp.trim().substring(index + 1);
			if (strDay.startsWith("0")) {
				strDay = strDay.substring(1);
			}
			int day = Integer.parseInt(strDay);

			int[] MONTH_LENGTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30,
					31 };
			int[] LEAP_MONTH_LENGTH = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31,
					30, 31 };
			int daymax = (isLeapYear(year)) ? LEAP_MONTH_LENGTH[(month - 1)]
					: MONTH_LENGTH[(month - 1)];
			if ((day < 1) || (day > daymax)) {
				day = daymax;
			}
			String strYear = String.valueOf(year);
			for (int i = strYear.length(); i < 4; ++i) {
				strYear = "0" + strYear;
			}
			strMonth = String.valueOf(month);
			if (strMonth.length() < 2) {
				strMonth = "0" + strMonth;
			}
			strDay = String.valueOf(day);
			if (strDay.length() < 2) {
				strDay = "0" + strDay;
			}
			return strYear + "-" + strMonth + "-" + strDay;
		} catch (Exception e) {
		}
		return null;
	}

	public static String getStrFullDate(String strDate) {
		int index = strDate.indexOf("-");
		if (index < 1) {
			index = strDate.indexOf("/");
			if (index < 1) {
				return strDate;
			}
		}

		String year = strDate.trim().substring(0, index);

		String strMonth = null;
		String strDay = null;
		String sTemp = strDate.trim().substring(index + 1);
		index = sTemp.indexOf("-");
		if (index < 1) {
			index = sTemp.indexOf("/");
			if (index < 1) {
				strMonth = sTemp;
				strDay = "01";
			}
		}

		if (strMonth == null) {
			strMonth = sTemp.trim().substring(0, index);
		}

		if (strDay == null) {
			strDay = sTemp.trim().substring(index + 1);
		}

		return year + "-" + strMonth + "-" + strDay;
	}

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
		DateFormat dfa = dateFormat;// new
									// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dfa.parse(sDate);
	}

	public static int getDayOfWeek(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal.get(7);
	}

	public static String getCurrentTime() {
		return getFormatDateTime(new java.util.Date(), "yyyy-MM-dd HH:mm:ss");
	}

	public static String getFormatDateTime(java.util.Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static FDateTime getDateTimeAfter(FDateTime dt, int hours) {
		long utcTime = Calendars.getMillis(dt.getBeginDate(), dt.getUFTime(),
				Calendars.getGMTDefault());
		return new FDateTime(utcTime + ICalendar.MILLIS_PER_HOUR * hours);
	}
	
	public static FDateTime getDateTime(Integer year,Integer month,Integer day){
		String monthstr="";
		if(month==null || month==0){
			monthstr="01";
		}else{
			if(month<10){
				monthstr="0"+Integer.toString(month);
			}else{
				monthstr=Integer.toString(month);
			}
		}
		String daystr="";
		if(day==null || day==0){
			daystr="01";
		}else{
			if(day<10){
				daystr="0"+Integer.toString(day);
			}else{
				daystr=Integer.toString(day);
			}
		}
		return new FDateTime(Integer.toString(year)+"-"+monthstr+"-"+daystr+" 00:00:00");
	}
	
	/**
	 * 获得日期时间对应的时间对象
	 * @param dt
	 * @return
	 */
	public static FTime getFTime8Dt(FDateTime dt){
		if(dt==null)return null;
		return dt.getUFTime();
	}
	
	/**
	 * 获得日期时间所在周的周次串
	 * @param dt
	 * @return
	 */
	public static String getWeekNoStr4Dt(FDateTime dt){
		if(dt==null)return null;
		return Integer.toString(dt.getWeek());
	}
	
	/**
	 * 获取时间区间之间相差的天数
	 * @param b
	 * @param e
	 * @return
	 * @throws CiOrDataUtilNullException
	 * @author xuxing2016-09-13（由于系统的getDaysAfter：相隔时间满24小时才返回相差一天）
	 */
	public static int getDaysBetweenInterval(FDateTime b,FDateTime e)
	{
		if (b==null||e==null) {
			return -1;
		}
		
		return e.getBeginDate().getDaysAfter(b.getBeginDate());
	}
}
