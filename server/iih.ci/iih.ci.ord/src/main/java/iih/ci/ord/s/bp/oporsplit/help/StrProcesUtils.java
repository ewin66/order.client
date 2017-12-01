package iih.ci.ord.s.bp.oporsplit.help;

import xap.mw.core.utils.StringUtil;

public class StrProcesUtils {

	/**
	 * 字符分割
	 * 
	 * @param str
	 * @return
	 */
	public static String[] StrSplit(String str) {

		if (StringUtil.isEmpty(str))
			return null;

		String[] resultStr = str.split(",");

		return resultStr;
	}

	/**
	 * 字符合并
	 * 
	 * @param str
	 * @return
	 */
	public static String StrMerge(String[] strs) {

		if (strs.length == 0)
			return null;
		String resultStr = "";
		for (String str : strs) {
			resultStr += ((resultStr.length() == 0 ? "" : ",") + "'" + str + "'");
		}

		return resultStr;
	}

	/**
	 * 获取where条件串
	 * 
	 * @param str
	 * @return
	 */
	public static String getWhereStr(String str) {

		String reString = "";

		if (StringUtil.isEmpty(str))
			return null;

		String[] strArry = StrSplit(str);

		if (strArry != null && strArry.length > 0) {

			if (strArry.length == 1) {

				reString = " = " + StrMerge(strArry);

			} else {

				reString = " in (" + StrMerge(strArry) + ")";
			}
		}

		return reString;
	}

}
