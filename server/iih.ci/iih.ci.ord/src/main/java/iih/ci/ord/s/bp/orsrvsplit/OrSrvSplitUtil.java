package iih.ci.ord.s.bp.orsrvsplit;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.bd.srv.freqdef.d.FreqdefAggDO;
import iih.bd.srv.freqdef.d.desc.FreqTimeDODesc;
import iih.bd.srv.freqdef.i.IFreqTimeDORService;
import iih.bd.srv.freqdef.i.IFreqdefMDORService;
import iih.bd.srv.freqdef.i.IFreqdefRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdFreqTimeDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.ciorder.d.desc.OrdFreqTimeDODesc;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ciorder.i.IOrdFreqTimeDORService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ci.ord.dto.blexorder.d.OrGenSplitTpEnum;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.ordsrvdose.d.desc.OrdSrvDoseDODesc;
import iih.ci.ord.ordsrvdose.i.IOrdsrvdoseRService;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.DateUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class OrSrvSplitUtil {

	private static final int ZERO_POWER = 0;
	
	/***
	 * 获得医嘱与服务拆分公共选择字段串
	 * 
	 * @param isOr
	 * @return
	 */
	public static String getPubOrSrvSqlStr(boolean isOr) {

		String rtn = "";
		String replaceChar = IOrAndSrvSplitConst.ORSRV_TABLE_ALIAS;
		if (isOr) {
			replaceChar = IOrAndSrvSplitConst.OR_TABLE_ALIAS;
		}
		rtn = (IOrAndSrvSplitConst.ORSRVSPLIT_PUB_OR_SSQL).replace(IOrAndSrvSplitConst.ORSRVFREQ_REPLACE_STR, replaceChar);
		return rtn;
	}

	/**
	 * 是否为空串判断
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isEmpty(String input) {

		return StringUtils.isBlank(input);
	}

	/**
	 * 英文逗号是否在字串中的判断
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isCommaInStr(String input) {
		if (input.indexOf(IOrAndSrvSplitConst.COMMA_STR) >= 0)
			return true;
		return false;

	}

	/***
	 * 获得字段及逗号分隔值集合的条件串
	 * 
	 * @param fldname
	 * @param idcodevs
	 * @param iswithand
	 * @return
	 */
	public static String getValuesCondStr(String fldname, String idcodevs, boolean iswithand) {
		return getValuesCondStr("", fldname, idcodevs, iswithand);
	}

	/***
	 * 获得字段及逗号分隔值集合的条件串
	 * 
	 * @param fldname
	 * @param idcodevs
	 * @param iswithand
	 * @return
	 */
	public static String getValueCondStr(String fldname, String idcodevs, boolean iswithand) {
		return getValueCondStr("", fldname, idcodevs, iswithand);
	}

	/***
	 * 获得字段及逗号分隔值集合的条件串
	 * 
	 * @param tblalias
	 * @param fldname
	 * @param idcodevs
	 * @param iswithand
	 * @return
	 */
	public static String getValuesCondStr(String tblalias, String fldname, String idcodevs, boolean iswithand) {
		if (OrSrvSplitUtil.isEmpty(idcodevs))
			return "";
		String catstr = getTblAliasFldNameStr(tblalias, fldname);
		String andstr = " ";
		if (iswithand)
			andstr = " and ";
		if (OrSrvSplitUtil.isCommaInStr(idcodevs)) {
			return andstr + catstr + " in (" + addSingleQuoteMark(idcodevs) + ")";
		} else {
			return andstr + catstr + " = '" + idcodevs + "'";
		}
	}

	/***
	 * 获得字段及单值集合的条件串
	 * 
	 * @param tblalias
	 * @param fldname
	 * @param v
	 * @param iswithand
	 * @return
	 */
	public static String getValueCondStr(String tblalias, String fldname, String v, boolean iswithand) {
		if (OrSrvSplitUtil.isEmpty(v))
			return "";
		String catstr = getTblAliasFldNameStr(tblalias, fldname);
		String andstr = " ";
		if (iswithand)
			andstr = " and ";
		return andstr + catstr + " = '" + v + "'";
	}

	/***
	 * 主键或编码串的各项增加单引号操作
	 * 
	 * @param idcodevs
	 * @return
	 */
	private static String addSingleQuoteMark(String idcodevs) {
		String ids = idcodevs.replaceAll(" ", "");
		return "'" + ids.replaceAll(",", "','") + "'";
	}

	/***
	 * 获得表别名与字段的连接串
	 * 
	 * @param tblalias
	 * @param fldname
	 * @return
	 */
	private static String getTblAliasFldNameStr(String tblalias, String fldname) {
		if (isEmpty(tblalias)) {
			return fldname;
		} else {
			return tblalias + "." + fldname;
		}
	}

	/***
	 * 根据医嘱服务分解类型获得表别名
	 * 
	 * @param orgensplittp
	 * @return
	 */
	public static String getOrSrvTblAlias(Integer orgensplittp) {
		if (orgensplittp.equals(OrGenSplitTpEnum.SPLITBYOR)) {
			return IOrAndSrvSplitConst.OR_TABLE_ALIAS;
		} else if (orgensplittp.equals(OrGenSplitTpEnum.SPLITBYFEESRV)) {
			return IOrAndSrvSplitConst.ORSRV_TABLE_ALIAS;
		} else if (orgensplittp.equals(OrGenSplitTpEnum.SPLITBYSRVMM)) {
			return IOrAndSrvSplitConst.ORSRV_TABLE_ALIAS;
		}
		return "";

	}

	/***
	 * 是否医嘱拆解类型
	 * 
	 * @param orgensplittp
	 * @return
	 */
	public static boolean isOrSplitType(Integer orgensplittp) {
		if (orgensplittp.equals(OrGenSplitTpEnum.SPLITBYOR)) {
			return true;
		} else if (orgensplittp.equals(OrGenSplitTpEnum.SPLITBYFEESRV)) {
			return false;
		} else if (orgensplittp.equals(OrGenSplitTpEnum.SPLITBYSRVMM)) {
			return false;
		}
		return false;

	}

	/***
	 * 获得服务器日期时间
	 * 
	 * @return
	 */
	public static FDateTime getServerDateTime() {
		TimeService ts = (TimeService) ServiceFinder.find(TimeService.class.getName());
		return ts.getUFDateTime();
	}

	/***
	 * FDateTime转换为标准日期时间串 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param dt
	 * @return
	 */
	public static String getFDateTimeStdStr(FDateTime dt) {
		return dt.toStdString();
	}

	/***
	 * 获得sql语句串所对应的Bean结果集合
	 * 
	 * @param sql
	 * @param c
	 * @return
	 * @throws BizException
	 */
	public static <T extends BaseDO> BaseDO[] getDORstWithDao(String sql, Class<T> c) throws BizException {
		DAFacade dao = new DAFacade();
		ArrayList<T> list = list = (ArrayList<T>) dao.execQuery(sql, new BeanListHandler(c));
		T[] queryVos = (T[]) list.toArray((T[]) Array.newInstance(c, 0));
		return queryVos;
	}

	/***
	 * 取时间两者小者
	 * 
	 * @param dt1
	 * @param dt2
	 * @return
	 */
	public static FDateTime getMinDT(FDateTime dt1, FDateTime dt2) {
		if(dt1 == null) return dt2;
		if(dt2 == null) return dt1;
		long days = dt1.getMillisAfter(dt2);
		if (days >= 0)
			return dt2;
		return dt1;
	}

	/***
	 * 取时间两者大者
	 * 
	 * @param dt1
	 * @param dt2
	 * @return
	 */
	public static FDateTime getMaxDT(FDateTime dt1, FDateTime dt2) {
		if(dt2 == null)	return dt1;
		if(dt1 == null) return dt2;
		if(dt1.before(dt2)){
			return dt2;
		}
		return dt1;
	}

	/***
	 * 根据传入的时间区间获得实际有效时间区间
	 * 
	 * @param effectiveDTs
	 *            有效的开始结束时间区间
	 * @param inputDTs
	 *            查询或分析的开始结束区间
	 * @return
	 */
	public static FDateTime[] getValidStartEndDT(FDateTime[] effectiveDTs, FDateTime[] inputDTs) {
		FDateTime[] rtns = new FDateTime[2];
		rtns[0] = getMaxDT(effectiveDTs[0], inputDTs[0]);
		rtns[1] = getMinDT(effectiveDTs[1], inputDTs[1]);
		if (isDtValidate(rtns))
			return rtns;
		return null;
	}

	/***
	 * 区间时间有效性校验
	 * 
	 * @param dtstart
	 * @param dtend
	 * @return
	 */
	public static boolean isDtValidate(FDateTime dtstart, FDateTime dtend) {
		if (dtstart == null || dtend == null)
			return true;
		long days = dtend.getMillisAfter(dtstart);
		if (days >= 0)
			return true;
		return false;
	}

	public static boolean isDtValidate(FDateTime dtstart, FDateTime dtend, FDateTime dt) {
		if(dt == null)	return false;
		long day1 = dtend.getMillisAfter(dt);
		long day0 = dt.getMillisAfter(dtstart);
		if (day1 >= 0 && day0 >= 0)
			return true;
		return false;
	}

	/***
	 * 区间时间有效性校验
	 * 
	 * @param dts
	 * @return
	 */
	public static boolean isDtValidate(FDateTime[] dts) {
		return isDtValidate(dts[0], dts[1]);
	}

	/***
	 * 业务类型是否为标准类型的判断（对树结构时 包含即为“相等”）
	 * 
	 * @param stdCode
	 * @param tranCode
	 * @param isinclude
	 *            是否包含即可
	 * @return
	 */
	public static boolean isDtSrvTypeSame(String stdCode, String tranCode, boolean isinclude) {
		if (!isinclude) { // 纯相等的情况
			if (stdCode.equals(tranCode)) {
				return true;
			} else {
				return false;
			}
		} else {// 包含的情况
			if (isEmpty(tranCode))
				return false;
			if (tranCode.indexOf(stdCode) == 0)
				return true;
			return false;
		}
	}

	/***
	 * 是否为TRUE
	 * 
	 * @param isA
	 * @return
	 */
	public static boolean isTrue(FBoolean isA) {
		if (isA == null)
			return false;
		return isA.booleanValue();
	}

	/***
	 * 获得频次数据信息
	 * 
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	public static FreqdefAggDO getFreqDefAggDO(String id_freq) throws BizException {
		IFreqdefRService rs = (IFreqdefRService) ServiceFinder.find(IFreqdefRService.class);
		FreqdefAggDO aggdo = rs.findById(id_freq);
		return aggdo;
	}

	/***
	 * 获得频次数据信息
	 * 
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	public static OrdSrvDoseDO[] getOrdSrvDoseDOs(String id_orsrv) throws BizException {
		IOrdsrvdoseRService rs = (IOrdsrvdoseRService) ServiceFinder.find(IOrdsrvdoseRService.class);
		OrdSrvDoseDO[] rtns = rs.find(OrdSrvDoseDODesc.TABLE_ALIAS_NAME + ".id_orsrv='" + id_orsrv + "'", "no_mp", new FBoolean(false));
		return rtns;
	}

	/***
	 * 获得医嘱频次执行时刻数据信息
	 * 
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	public static OrdFreqTimeDO[] getOrdFreqTimeDOs(String id_or) throws BizException {
		IOrdFreqTimeDORService rs = (IOrdFreqTimeDORService) ServiceFinder.find(IOrdFreqTimeDORService.class);
		OrdFreqTimeDO[] rtns = rs.find(OrdFreqTimeDODesc.TABLE_ALIAS_NAME + ".id_or='" + id_or + "'", "sortno", new FBoolean(false));
		return rtns;
	}
	
	/***
	 * 获得医嘱频次执行时刻数据信息
	 * 
	 * @param id_or
	 * @param dt_mp
	 * @return
	 * @throws BizException
	 */
	public static OrdFreqTimeDO[] getOrdFreqTimeDOs(String id_or,FDateTime dt_mp) throws BizException {
		String tblaliasname=OrdFreqTimeDODesc.TABLE_ALIAS_NAME;
		String datestr=DateUtils.getDateTimeStr(dt_mp.getBeginDate(),DateUtils.dateFormatStr);
		IOrdFreqTimeDORService rs = (IOrdFreqTimeDORService) ServiceFinder.find(IOrdFreqTimeDORService.class);
		
		OrdFreqTimeDO[] rtns = rs
				.find(tblaliasname + "." + OrdFreqTimeDO.ID_OR + "='" + id_or
						+ "' and " + tblaliasname + "." + OrdFreqTimeDO.WDNO
						+ ">='" + datestr+"'", "sortno", new FBoolean(false));
		return rtns;
	}

	/***
	 * 获得医嘱频次执行时刻的时间序列集合
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public static FDateTime[] getOrdFreqTimeDateTimes(String id_or) throws BizException {
		OrdFreqTimeDO[] os = getOrdFreqTimeDOs(id_or);
		if (os == null || os.length == 0)
			return null;
		FDateTime[] rtn = new FDateTime[os.length];
		for (int i = 0; i < os.length; i++) {
			// 暂时先不处理 主要的概念上是有问题
			// 算法逻辑上获得对应日期时间FDateTime即可
		}

		return null;// rtn;
	}

	/***
	 * 获得频次数据信息
	 * 
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	public static FreqTimeDO[] getFreqTimeDOs(String id_freq) throws BizException {
		IFreqTimeDORService rs = (IFreqTimeDORService) ServiceFinder.find(IFreqTimeDORService.class);
		FreqTimeDO[] rtns = rs.find(FreqTimeDODesc.TABLE_ALIAS_NAME + ".id_freq='" + id_freq + "'", "sortno", new FBoolean(false));
		return rtns;
	}

	/***
	 * 获得频次数据信息
	 * 
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	public static FreqDefDO getFreqDefDO(String id_freq) throws BizException {
		IFreqdefMDORService rs = (IFreqdefMDORService) ServiceFinder.find(IFreqdefMDORService.class);
		FreqDefDO fredo = rs.findById(id_freq);
		return fredo;
	}

	/***
	 * 是否是持续频次
	 * 
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	public static boolean isAlwaysFreq(String id_freq) throws BizException {
		FreqDefDO freqdo = getFreqDefDO(id_freq);
		if (freqdo == null)
			return false;
		String sd_frequnit = freqdo.getSd_frequnitct();
		if (isEmpty(sd_frequnit))
			return false;
		if (IBdSrvDictCodeConst.SD_FREQNUNITCT_ALWAYS.equals(sd_frequnit))
			return true;

		return false;
	}

	/***
	 * 是否持续频次
	 * 
	 * @param sd_frequnit
	 * @return
	 * @throws BizException
	 */
	public static boolean isAlwaysFreq1(String sd_frequnit) throws BizException {
		if (isEmpty(sd_frequnit))
			return false;
		if (IBdSrvDictCodeConst.SD_FREQNUNITCT_ALWAYS.equals(sd_frequnit))
			return true;

		return false;
	}

	/***
	 * 是否临时频次医嘱
	 * 
	 * @param sd_frequnit
	 * @return
	 * @throws BizException
	 */
	public static boolean isTemporaryFreq(String sd_frequnit) throws BizException {
		if (isEmpty(sd_frequnit))
			return false;
		if (IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE.equals(sd_frequnit))
			return true;

		return false;
	}

	/***
	 * 是否计划频次医嘱
	 * 
	 * @param sd_frequnit
	 * @return
	 * @throws BizException
	 */
	public static boolean isPlanFreq(String sd_frequnit) throws BizException {
		if (isEmpty(sd_frequnit))
			return false;
		if (IBdSrvDictCodeConst.SD_FREQNUNITCT_PLAN.equals(sd_frequnit))
			return true;

		return false;
	}

	/***
	 * 是否周期性频次医嘱
	 * 
	 * @param sd_frequnit
	 * @return
	 * @throws BizException
	 */
	public static boolean isPeriodFreq(String sd_frequnit) throws BizException {
		if (isEmpty(sd_frequnit))
			return false;
		// if(IBdSrvDictCodeConst.SD_FREQNUNITCT_HOUR.equals(sd_frequnit))return
		// true;
		if (IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY.equals(sd_frequnit))
			return true;
		if (IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK.equals(sd_frequnit))
			return true;
		//目前没有月频次的类型 2017-4-11 zwq ,后面添加的话，再加上
//		if (IBdSrvDictCodeConst.SD_FREQNUNITCT_MONTH.equals(sd_frequnit))
//			return true;
		return false;
	}

	/***
	 * 是否周期性周频次医嘱
	 * 
	 * @param sd_frequnit
	 * @return
	 * @throws BizException
	 */
	public static boolean isPeriodWeekFreq(String sd_frequnit) throws BizException {
		if (isEmpty(sd_frequnit))
			return false;
		if (IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK.equals(sd_frequnit))
			return true;
		return false;
	}

	/***
	 * 是否周期性月频次医嘱
	 * 
	 * @param sd_frequnit
	 * @return
	 * @throws BizException
	 */
	public static boolean isPeriodMonthFreq(String sd_frequnit) throws BizException {
		if (isEmpty(sd_frequnit))
			return false;
		//目前没有月频次的类型 2017-4-11 zwq ,后面添加的话，再加上
//		if (IBdSrvDictCodeConst.SD_FREQNUNITCT_MONTH.equals(sd_frequnit))
//			return true;
		return false;
	}

	/***
	 * 是否周期性天频次医嘱
	 * 
	 * @param sd_frequnit
	 * @return
	 * @throws BizException
	 */
	public static boolean isPeriodDayFreq(String sd_frequnit) throws BizException {
		if (isEmpty(sd_frequnit))
			return false;
		if (IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY.equals(sd_frequnit))
			return true;
		return false;
	}

	/***
	 * 是否周期性天频次医嘱
	 * 
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	public static boolean isPeriodDayFreqByID(String id_freq) throws BizException {
		FreqDefDO freq = getFreqDefDO(id_freq);
		if (freq == null)
			return false;
		if (isEmpty(freq.getSd_frequnitct()))
			return false;
		if (IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY.equals(freq.getSd_frequnitct()))
			return true;
		return false;
	}

	/***
	 * 是否周期性小时频次医嘱
	 * 
	 * @param sd_frequnit
	 * @return
	 * @throws BizException
	 */
	public static boolean isPeriodHourFreq(String sd_frequnit) throws BizException {
		if (isEmpty(sd_frequnit))
			return false;
		if (IBdSrvDictCodeConst.SD_FREQNUNITCT_HOUR.equals(sd_frequnit))
			return true;
		return false;
	}

	/***
	 * 获得开始结束时间的时长（秒）
	 * 
	 * @param dtstart
	 * @param dtend
	 * @return
	 */
	public static int getDateTimeLengthBySeconds(FDateTime dtstart, FDateTime dtend) {
		return dtend.getSecondsBetween(dtstart, dtend);
	}

	/***
	 * 获得起止时间内的日期数组
	 * 
	 * @param dtstart
	 * @param dtend
	 * @return
	 * @throws CiOrDataUtilNullException 
	 */
	public static FDateTime[] getDateArray(FDateTime dtstart, FDateTime dtend) {
		//int days = dtend.getDaysAfter(dtstart);
		int days = DateUtils.getDaysBetweenInterval(dtstart,dtend);//2016-09-13(xuxing)解决getDaysAfter方法只有了前后相差24小时，才会返回1，此处不适用
		if (days < 0) {
			days = 0;// 加一秒之后=》跨天，则按照当天处理
		}
		if (dtend.getBeginDate().equals(dtstart.getBeginDate())) {// 同一天的情形
			return new FDateTime[] { new FDateTime(dtend.getBeginDate(), new FTime("00:00:00")) };
		}
		FDateTime[] rtns = new FDateTime[days + 1];
		rtns[0] = new FDateTime(dtstart.getBeginDate(), new FTime("00:00:00"));
		for (int i = 1; i <= days; i++) {
			rtns[i] = rtns[0].getDateTimeAfter(i);
		}
		return rtns; // 2015-01-12 00:00:00返回的日期格式
	}

	/***
	 * 获得起止时间内满足的日时刻集合数组
	 * 
	 * @param dtstart
	 * @param dtend
	 * @return
	 */
	public static FDateTime[] getDateArrayByDay(FDateTime dtstart, FDateTime dtend, FTime[] daytimes) {
		FDateTime[] dates = getDateArray(dtstart, dtend);
		int iL = dates.length;
		int iN = daytimes.length;
		FDateTime dt = null;
		ArrayList<FDateTime> rtn = new ArrayList<FDateTime>();
		for (int i = 0; i < iL; i++) {
			FDate d = dates[i].getDate();
			for (int j = 0; j < iN; j++) {
				dt = new FDateTime(dates[i].getDate(), daytimes[j]);
				if (isDtValidate(dtstart, dtend, dt)) {
					rtn.add(dt);
				}
			}
		}
		if (rtn == null || rtn.size() == 0)
			return null;
		return (FDateTime[]) rtn.toArray((FDateTime[]) Array.newInstance(FDateTime.class, 0));
	}

	/***
	 * 获得有效时间序列集合数据
	 * 
	 * @param dtStd
	 * @param dtinput
	 * @return
	 */
	public static FDateTime[] getValidDateArray(FDateTime[] dtStd, FDateTime[] dtinput) {
		if (dtinput == null)
			return null;
		ArrayList<FDateTime> rtnlist = new ArrayList<FDateTime>();
		for (int i = 0; i < dtinput.length; i++) {
			if (isDtValidate(dtStd[0], dtStd[1], dtinput[i])) {
				rtnlist.add(dtinput[i]);
			}
		}
		if (rtnlist == null || rtnlist.size() == 0)
			return null;
		return (FDateTime[]) rtnlist.toArray((FDateTime[]) Array.newInstance(FDateTime.class, 0));

	}

	/***
	 * 获得起止时间内满足的月时刻集合数组
	 * 
	 * @param dtstart
	 * @param dtend
	 * @param freqtimes
	 * @return
	 */
	public static FDateTime[] getDateArrayByMonth(FDateTime dtstart, FDateTime dtend, FreqTimeDO[] freqtimes) {
		if (freqtimes == null)
			return null;
		FDateTime[] dates = getDateArray(dtstart, dtend);
		int iL = dates.length;
		Hashtable ht = getFreqTimeHt(freqtimes);
		FDateTime dt = null;
		int key = 0, key1 = 0;
		ArrayList<FDateTime> rtn = new ArrayList<FDateTime>();
		for (int i = 0; i < iL; i++) {
			key = dates[i].getDay();//
			if (ht.containsKey(key)) {
				dt = new FDateTime(dates[i].getDate(), (FTime) ht.get(key));
				if (isDtValidate(dtstart, dtend, dt)) {
					rtn.add(dt);
				}
			} else {
				key1 = getNumFromMonthEnd(key, dates[i].getDaysMonth()); // 获得月份天数
				if (ht.containsKey(key1)) {
					dt = new FDateTime(dates[i].getDate(), (FTime) ht.get(key1));
					if (isDtValidate(dtstart, dtend, dt)) {
						rtn.add(dt);
					}
				}
			}
		}

		return (FDateTime[]) rtn.toArray((FDateTime[]) Array.newInstance(FDateTime.class, 0));
	}

	/***
	 * 获得月末对应的倒数号数 月末为倒数第一天 ==-1
	 * 
	 * @param date
	 * @param daysOfMonth
	 * @return
	 */
	private static int getNumFromMonthEnd(int date, int daysOfMonth) {
		return date - daysOfMonth - 1;
	}

	/***
	 * 获得起止时间内满足的周时刻集合数组
	 * 
	 * @param dtstart
	 * @param dtend
	 * @param freqtimes
	 * @return
	 */
	public static FDateTime[] getDateArrayByWeek(FDateTime dtstart, FDateTime dtend, FreqTimeDO[] freqtimes) {
		if (freqtimes == null)
			return null;
		FDateTime[] dates = getDateArray(dtstart, dtend);
		int iL = dates.length;
		Hashtable ht = getFreqTimeHt(freqtimes);
		FDateTime dt = null;
		int key = 0;
		ArrayList<FDateTime> rtn = new ArrayList<FDateTime>();
		for (int i = 0; i < iL; i++) {
			key = dates[i].getWeek(); // dayofweek
			if (ht.containsKey(key)) {
				dt = new FDateTime(dates[i].getDate(), (FTime) ht.get(key));
				if (isDtValidate(dtstart, dtend, dt)) {
					rtn.add(dt);
				}
			}
		}

		return (FDateTime[]) rtn.toArray((FDateTime[]) Array.newInstance(FDateTime.class, 0));
	}

	/***
	 * 获得频次时刻键值对
	 * 
	 * @param freqtimes
	 * @return
	 */
	private static Hashtable getFreqTimeHt(FreqTimeDO[] freqtimes) {
		Hashtable ht = new Hashtable();
		for (int i = 0; i < freqtimes.length; i++) {
			ht.put(freqtimes[i].getWdno(), freqtimes[i].getTime_mp());
		}
		return ht;
	}

	/***
	 * 获得起止时间内满足的日时刻集合数组
	 * 
	 * @param dtstart
	 * @param dtend
	 * @param freqtimes
	 * @return
	 */
	public static FDateTime[] getDateArrayByDay(FDateTime dtstart, FDateTime dtend, FreqTimeDO[] freqtimes) {
		if (freqtimes == null)
			return null;
		return getDateArrayByDay(dtstart, dtend, getFTimes(freqtimes));
	}

	/***
	 * 根据频次时刻获得FTime数组
	 * 
	 * @param daytimes
	 * @return
	 */
	private static FTime[] getFTimes(FreqTimeDO[] daytimes) {
		if (daytimes == null)
			return null;
		FTime[] rtn = new FTime[daytimes.length];
		for (int i = 0; i < daytimes.length; i++) {
			rtn[i] = daytimes[i].getTime_mp();
		}
		return rtn;
	}

	/***
	 * 获得小时频次周期的时间序列数组
	 * 
	 * @param dstart
	 * @param dtend
	 * @param iperiods
	 * @return
	 */
	public static FDateTime[] getDateArrayByHour(FDateTime dstart, FDateTime dtend, int iperiods) {
		int hours = FDateTime.getHoursBetween(dstart, dtend);
		int[] divremains = getDivAndRemain(hours, iperiods);
		if (divremains[0] == 0)
			return null;
		FDateTime[] rtns = new FDateTime[divremains[0]];
		for (int i = 1; i <= divremains[0]; i++) {
			rtns[i - 1] = DateUtils.getDateTimeAfter(dstart,i*iperiods);
			// rtns[i-1]=dstart.getDateTimeAfter(iperiods);//2015-12-17；12小时一次误加成了12天一次
		}
		return rtns;
	}

	/***
	 * 取除数与余数
	 * 
	 * @param iput
	 * @param iperiods
	 * @return
	 */
	public static int[] getDivAndRemain(int iput, int iperiods) {
		int[] rtns = new int[] { 0, 0 };
		rtns[1] = iput % iperiods;
		rtns[0] = (iput - rtns[1]) / iperiods;

		return rtns;
	}

	/**
	 * quan/factor求分子分母的算法
	 * 
	 * @param quan
	 *            医疗用量
	 * @param factor
	 *            mb
	 * @return
	 */
	public static int[] getNumDen(FDouble quan, FDouble factor) {
		int[] rtns = new int[] { 0, 0 };
		int[] iquans=getNumBen(quan);
		int[] ifactors=getNumBen(factor);
		//int iquan = (int)Math.ceil(quan.doubleValue()); // 这个假设有可能不正确 需将传入的两个数据变为整型
		//int ifactor = factor.intValue();
		int inum=iquans[0]*ifactors[1];
		int iben=ifactors[0]*iquans[1];
		int imaxdiv = getMaxComDivisor(inum, iben);
		if(imaxdiv== 0){
			rtns[0] = 0  ;
			rtns[1] = 0;
		}else{
			rtns[0] = inum / imaxdiv;
			rtns[1] = iben / imaxdiv;
		}
		
		return rtns;
	}
	/**
	 * 获得对应的分数格式数据
	 * @param input
	 * @return
	 */
	private static int[] getNumBen(FDouble input){
		if(input==null)return new int[]{0,1};
		String sinput=input.toString();
		String[] sTs=sinput.split("\\.");
		if(sTs.length==1)return new int[]{input.intValue(),1};
		sTs[1]=numBenHandle(sTs[1]);
		return new int[]{Integer.valueOf(sTs[0]+sTs[1]),getNumV(sTs[1])};
		
	}
	private static String numBenHandle(String input){
		if(CiOrdUtils.isEmpty(input))return "";
		int iL=input.length();
		String rtnstr="";
		char[] szInput = input.toCharArray();
		for(int i=iL-1;i>=0;i--){
			if (szInput[i] != '0')
			{
				rtnstr = input.substring(0, i+1);
				break;
			}
		}
		return rtnstr;
	}
	/**
	 * 
	 * @param s
	 * @return
	 */
	private static int getNumV(String s){
		if(s==null || s.equals(""))return 1;
		String rtn="1";
		for(int i=0;i<s.length();i++){
			rtn+="0";
		}
		return Integer.valueOf(rtn);
	}

	/**
	 * 获得最大公约数
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static int getMaxComDivisor(int m, int n) {
		int k, y;
		if (m < n) {
			k = m;
			m = n;
			n = k;
		}
		if(n==0) return 0;
		while (m % n != 0) {
			y = m % n;
			m = n;
			n = y;
		}
		return n;
	}

 
	/***
	 * 相除后正向取整（取大数）,如1.45--》2
	 * 
	 * @param q1
	 * @param q2
	 * @return
	 */
	public static FDouble CeilingRoundAfterDiv(FDouble q1, FDouble q2) {
		FDouble db = q1.div(q2, ZERO_POWER, FDouble.ROUND_CEILING);
		return db;
	}

	/***
	 * FDouble取整
	 * 
	 * @param q1
	 * @param q2
	 * @return
	 */
	public static FDouble CeilingRound(FDouble q) {
		FDouble db = q.div(new FDouble(1), ZERO_POWER, FDouble.ROUND_CEILING);
		return db;
	}

	/***
	 * 根据id值获得医嘱项目DO
	 * 
	 * @param id_orsrv
	 * @return
	 * @throws BizException
	 */
	public static OrdSrvDO findOrdSrvDOByID(String id_orsrv) throws BizException {
		IOrdSrvDORService rs = (IOrdSrvDORService) ServiceFinder.find(IOrdSrvDORService.class);
		OrdSrvDO do1 = rs.findById(id_orsrv);
		return do1;
	}

	/***
	 * 根据id值获得医嘱项目do
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public static CiOrderDO findCiOrdDOByID(String id_or) throws BizException {
		ICiorderMDORService rs = (ICiorderMDORService) ServiceFinder.find(ICiorderMDORService.class);
		CiOrderDO do1 = rs.findById(id_or);
		return do1;
	}

	/***
	 * 根据id值获得医嘱项目对应的物品do
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public static OrdSrvMmDO findOrdSrvMmDOByID(String id_orsrvmm) throws BizException {
		IOrdsrvmmRService rs = (IOrdsrvmmRService) ServiceFinder.find(IOrdsrvmmRService.class);
		OrdSrvMmDO do1 = rs.findById(id_orsrvmm);
		return do1;
	}

	/***
	 * 根据id值及条件获得医嘱项目对应的物品do
	 * 
	 * @param id_orsrv
	 * @return
	 * @throws BizException
	 */
	public static OrdSrvMmDO findOrdSrvMmDO(String id_orsrv) throws BizException {
		IOrdsrvmmRService rs = (IOrdsrvmmRService) ServiceFinder.find(IOrdsrvmmRService.class);
		OrdSrvMmDO[] do1 = rs.find(OrdSrvMmDODesc.TABLE_ALIAS_NAME + ".id_orsrv='" + id_orsrv + "' ", "", new FBoolean(true));
		if (do1 == null || do1.length == 0)
			return null;
		if (do1.length > 1) {
			throw new BizException("医嘱项目【id_srv='" + id_orsrv + "'】对应的医嘱服务项目物品记录多条错误！");
		}
		return do1[0];
	}

	/***
	 * 根据id值及条件获得医嘱do
	 * 
	 * @param id_or
	 * @param condstr
	 * @return
	 * @throws BizException
	 */
	public static CiOrderDO findCiOrdDO(String id_or, String condstr) throws BizException {
		ICiorderMDORService rs = (ICiorderMDORService) ServiceFinder.find(ICiorderMDORService.class);
		if (!isEmpty(condstr))
			condstr = " and " + condstr;
		CiOrderDO[] do1 = rs.find(CiOrderDODesc.TABLE_ALIAS_NAME + ".id_or='" + id_or + condstr, "", new FBoolean(true));
		if (do1 == null || do1.length == 0)
			return null;
		return do1[0];
	}

	/**
	 * 是否为计划频次周期类型
	 * 
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	public static boolean isPlanFreq0(String id_freq) throws BizException {
		FreqDefDO freqdo = getFreqDefDO(id_freq);
		if (freqdo == null)
			return false;
		return isPlanFreq(freqdo.getSd_frequnitct());
	}

}
