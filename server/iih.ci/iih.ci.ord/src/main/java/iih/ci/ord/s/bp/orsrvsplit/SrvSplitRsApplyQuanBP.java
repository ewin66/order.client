package iih.ci.ord.s.bp.orsrvsplit;

import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.exception.ExceptionUtils;

/***
 * 服务拆分结果请领量计算操作BP
 *
 */
public class SrvSplitRsApplyQuanBP {
	/***
	 * 服务拆分结果请领量计算操作
	 * 
	 * @param srvsplitorders
	 * @return
	 * @throws BizException
	 */
	public SrvSplitOrderDTO[] exec(SrvSplitOrderDTO[] srvsplitorders)
			throws BizException {
		// 有效性判断
		if (srvsplitorders == null || srvsplitorders.length == 0)
			return null;

		// 按申请类型对服务拆分结果进行分组
		Hashtable ht = getSrvSplitRsGrp(srvsplitorders);

		// 服务拆分时申请数量计算
		ArrayList<SrvSplitOrderDTO> rtnlist = ApplyQuanHandle(ht);

		if (rtnlist == null || rtnlist.size() == 0)
			return null;
		return (SrvSplitOrderDTO[]) rtnlist.toArray((SrvSplitOrderDTO[]) Array
				.newInstance(SrvSplitOrderDTO.class, 0));

	}

	/***
	 * 服务拆分时申请数量计算的处理逻辑
	 * 
	 * @param ht
	 * @return
	 */
	private ArrayList<SrvSplitOrderDTO> ApplyQuanHandle(Hashtable ht)throws BizException {
		if (ht == null || ht.size() == 0)
			return null;
		ArrayList<SrvSplitOrderDTO> rtnlist = new ArrayList<SrvSplitOrderDTO>();

		ArrayList<SrvSplitOrderDTO> tmlist = null;
		Hashtable tmht = null;

		// 出院带药类型
		tmlist = (ArrayList<SrvSplitOrderDTO>) ht
				.get(IOrAndSrvSplitConst.SPLITRS_GRPTP_OUTP);
		outPApplyQuanHandle(rtnlist, tmlist);

		// 草药
		tmlist = (ArrayList<SrvSplitOrderDTO>) ht
				.get(IOrAndSrvSplitConst.SPLITRS_GRPTP_HERB);
		herbApplyQuanHandle(rtnlist, tmlist);

		// 按次取整
		tmlist = (ArrayList<SrvSplitOrderDTO>) ht
				.get(IOrAndSrvSplitConst.SPLITRS_GRPTP_NBYT);
		roundByTimesApplyQuanHandle(rtnlist, tmlist);

		// 按批取整
		tmht = (Hashtable) ht.get(IOrAndSrvSplitConst.SPLITRS_GRPTP_NBYB);
		roundByBatchApplyQuanHandle(rtnlist, tmht);

		// 余量法
		tmht = (Hashtable) ht.get(IOrAndSrvSplitConst.SPLITRS_GRPTP_REMAINS);
		remiansApplyQuanHandle(rtnlist, tmht);

		// 病区合用法
		tmht = (Hashtable) ht.get(IOrAndSrvSplitConst.SPLITRS_GRPTP_WDSUM);
		wardSumApplyQuanHandle(rtnlist, tmht);

		// 只按服务
		tmht = (Hashtable) ht.get(IOrAndSrvSplitConst.SPLITRS_GRPTP_SRV);
		srvApplyQuanHandle(rtnlist, tmht);

		return rtnlist;
	}

	/***
	 * 出院带药申请量计算
	 * 
	 * @param rtn
	 * @param tmlist
	 */
	private void outPApplyQuanHandle(ArrayList<SrvSplitOrderDTO> rtn,
			ArrayList<SrvSplitOrderDTO> tmlist) {
		// 有效性校验
		if (tmlist == null || tmlist.size() == 0)
			return;

		SrvSplitOrderDTO splitorder = null;
		FDouble quan = null;
		// 遍历
		for (int i = 0; i < tmlist.size(); i++) {
			splitorder = tmlist.get(i);
			if (splitorder == null)
				continue;
			//quan = getOutPQuan(splitorder.getQuan_cur(), splitorder.getFactor());
			//splitorder.setQuan_mp_ap(quan);
			splitorder.setQuan_mp_ap(splitorder.getQuan_cur());
			splitorder.setId_pkgu_ap(splitorder.getId_pkgu_cur());
			rtn.add(splitorder);
		}
	}

	private FDouble getOutPQuan(FDouble quan, FDouble factor) {
		return quan.multiply(factor);
	}

	/***
	 * 草药申请量计算
	 * 
	 * @param rtn
	 * @param tmlist
	 */
	private void herbApplyQuanHandle(ArrayList<SrvSplitOrderDTO> rtn,
			ArrayList<SrvSplitOrderDTO> tmlist) {
		// 有效性校验
		if (tmlist == null || tmlist.size() == 0)
			return;

		SrvSplitOrderDTO splitorder = null;
		FDouble quan = null;
		// 遍历
		for (int i = 0; i < tmlist.size(); i++) {
			splitorder = tmlist.get(i);
			if (splitorder == null)
				continue;
			quan = getHerbQuan(splitorder.getQuan_medu(),
					splitorder.getFactor_mb(), splitorder.getQuan_or());
			//				- splitorder.getOrders_boil());不需要减去代煎付数
			splitorder.setQuan_mp_ap(quan);
			splitorder.setId_pkgu_ap(splitorder.getId_pkgu_base());
			rtn.add(splitorder);
		}
	}

	private FDouble getHerbQuan(FDouble quan_med, FDouble factor_mb,
			Integer orders) {
		return quan_med.multiply(new FDouble(orders)).div(factor_mb);
	}

	/***
	 * 按次取整申请量计算
	 * 
	 * @param rtn
	 * @param tmlist
	 */
	private void roundByTimesApplyQuanHandle(ArrayList<SrvSplitOrderDTO> rtn,
			ArrayList<SrvSplitOrderDTO> tmlist) {
		// 有效性校验
		if (tmlist == null || tmlist.size() == 0)
			return;

		SrvSplitOrderDTO splitorder = null;
		FDouble quan = null;
		// 遍历
		for (int i = 0; i < tmlist.size(); i++) {
			splitorder = tmlist.get(i);
			if (splitorder == null)
				continue;
			quan = getRoundByTimesQuan(splitorder.getQuan_medu(),splitorder.getFactor_mb());
			splitorder.setQuan_mp_ap(quan);
			splitorder.setId_pkgu_ap(splitorder.getId_pkgu_base());
			rtn.add(splitorder);
		}
	}

	private FDouble getRoundByTimesQuan(FDouble quan_med, FDouble factor_mb) {
		return OrSrvSplitUtil.CeilingRoundAfterDiv(quan_med, factor_mb);
	}

	/***
	 * 按批取整申请量计算
	 * 
	 * @param rtn
	 * @param tmht
	 */
	private void roundByBatchApplyQuanHandle(ArrayList<SrvSplitOrderDTO> rtn,
			Hashtable tmht) {
		// 有效性校验
		if (tmht == null || tmht.size() == 0)
			return;

		String key = "";
		FDouble quan = null;
		SrvSplitOrderDTO first = null;
		ArrayList<SrvSplitOrderDTO> tmlist = null;
		Enumeration<String> keys = tmht.keys();

		// 遍历
		while (keys.hasMoreElements()) {
			tmlist = (ArrayList<SrvSplitOrderDTO>) tmht.get(keys.nextElement());
			if (tmlist == null || tmlist.size() == 0) {
			} else {
				quan = sum(tmlist);
				first = tmlist.get(0);
				quan = OrSrvSplitUtil.CeilingRoundAfterDiv(quan,first.getFactor_mb());
				first.setQuan_mp_ap(quan);
				first.setId_pkgu_ap(first.getId_pkgu_base());
				
				// 全部设置请领包装单位
				for (SrvSplitOrderDTO item : tmlist) {
					item.setId_pkgu_ap(item.getId_pkgu_base());
				}
				
				rtn.addAll(tmlist);
			}
		}

	}

	private FDouble sum(ArrayList<SrvSplitOrderDTO> srvsplitdtos) {
		FDouble rtn = new FDouble(0);
		if (srvsplitdtos == null || srvsplitdtos.size() == 0)
			return rtn;

		for (int i = 0; i < srvsplitdtos.size(); i++) {
			rtn = rtn.add(srvsplitdtos.get(i).getQuan_medu() == null ? FDouble.ZERO_DBL
							: srvsplitdtos.get(i).getQuan_medu());
		}
		return rtn;// OrSrvSplitUtil.CeilingRound(rtn);
	}

	/***
	 * 按余量法申请量计算
	 * 
	 * @param rtn
	 * @param tmht
	 * @throws BizException
	 */
	private void remiansApplyQuanHandle(ArrayList<SrvSplitOrderDTO> rtn,
			Hashtable tmht) throws BizException{
		// 有效性校验
		if (tmht == null || tmht.size() == 0)
			return;

		String key = "";
		FDouble[] quans = null;
		SrvSplitOrderDTO first = null;
		ArrayList<SrvSplitOrderDTO> tmlist = null;
		Enumeration<String> keys = tmht.keys();

		// 遍历
		while (keys.hasMoreElements()) {
			tmlist = (ArrayList<SrvSplitOrderDTO>) tmht.get(keys.nextElement());
			if (tmlist == null || tmlist.size() == 0) {
			} else {
				quans = getSumAndQuanBedMedu(tmlist);
				first = tmlist.get(0);
				if(quans[1].add(quans[2]).sub(quans[3]).doubleValue() >0){ 
					if (quans[0].compareTo(quans[1].add(quans[2]).sub(quans[3])) >= 0) {// 不是总量小于余量
						first.setQuan_mp_ap(OrSrvSplitUtil.CeilingRoundAfterDiv(
								quans[0].sub(quans[1].add(quans[2]).sub(quans[3])),
								first.getFactor_mb()));
					}
				}else{
					first.setQuan_mp_ap(OrSrvSplitUtil.CeilingRoundAfterDiv(
							quans[0],first.getFactor_mb()));
				}
					
				// 全部设置请领包装单位
				for (SrvSplitOrderDTO item : tmlist) {
					item.setId_pkgu_ap(item.getId_pkgu_base());
				}

			}

			rtn.addAll(tmlist); 
		}

	}

	/*** 
	 * 获得有效开始时间
	 * 
	 * @param s
	 * @param dt_last
	 * @return
	 */
	private FDateTime getStartTime(FDateTime s, FDateTime dt_last) {
		if (s == null) {
			return dt_last;
		} else if (dt_last == null) {
			return s;
		} else if (s.before(dt_last)) {
			return dt_last;
		}
		return s;
	}

	private FDouble[] getSumAndQuanBedMedu(
			ArrayList<SrvSplitOrderDTO> srvsplitdtos) throws BizException{
		FDouble[] rtn = new FDouble[] { new FDouble(0), new FDouble(0),new FDouble(0),new FDouble(0) };//请领总量、床旁余量、床旁在途量、未执行量
		if (srvsplitdtos == null || srvsplitdtos.size() == 0)
			return null;
		//取得新分解的第一条数据
		SrvSplitOrderDTO firstNew = null;
		for(SrvSplitOrderDTO srvdto : srvsplitdtos){
			if(srvdto.getStatus()==DOStatus.NEW){
				firstNew = srvdto;
			    break;
			}
		}
		if(firstNew == null)
			firstNew = srvsplitdtos.get(0);
		// 获得已发放未执行有效时间
		FDateTime[] validSE = new FDateTime[] {
				new FDateTime(), new FDateTime(firstNew.getDt_mp_plan().getMillis() - 1) };
		
		for (int i = 0; i < srvsplitdtos.size(); i++) {
			rtn[0] = rtn[0].add(srvsplitdtos.get(i).getQuan_medu());
		}
	
			String sd_frequnit = firstNew.getSd_frequnit() 	;
			FreqTimeDO[] freqtimedos = getFreqTimeDOs(firstNew.getId_freq(), new Hashtable());
			FDateTime[] dts = getPeriodFreqTimes(validSE, freqtimedos,sd_frequnit);
			// ly修改，床旁余量取一条数据 --
			rtn[1] = firstNew.getQuan_bed_medu()==null?FDouble.ZERO_DBL:firstNew.getQuan_bed_medu();
			rtn[2] = firstNew.getQuan_bed_ap_medu()==null?FDouble.ZERO_DBL:firstNew.getQuan_bed_ap_medu();
			if (dts != null && dts.length > 0)
				rtn[3] = firstNew.getQuan_medu().multiply(dts.length);
		 

		return rtn;
	}

	/***
	 * 获得医嘱频次时刻DO集合数据
	 * 
	 * @param id_freq
	 * @param freqHt
	 * @return
	 * @throws BizException
	 */
	private FreqTimeDO[] getFreqTimeDOs(String id_freq, Hashtable freqHt)
			throws BizException {
		GetFreqTimeDOsBP bp = new GetFreqTimeDOsBP();
		return bp.exec(id_freq, freqHt);
	}

	/***
	 * 获得周期频次类型时间序列数组数据
	 * 
	 * @param validSE
	 * @param freqtimedos
	 * @param sd_frequnit
	 * @return
	 * @throws BizException
	 */
	private FDateTime[] getPeriodFreqTimes(FDateTime[] validSE,
			FreqTimeDO[] freqtimedos, String sd_frequnit) throws BizException {
		FDateTime[] dts = null;
		if(validSE[0].after(validSE[1]))
			return null;
		if (OrSrvSplitUtil.isPeriodDayFreq(sd_frequnit)) {// 天处理逻辑 只支持1天N次
			dts = OrSrvSplitUtil.getDateArrayByDay(validSE[0], validSE[1],
					freqtimedos);
		} else if (OrSrvSplitUtil.isPeriodWeekFreq(sd_frequnit)) { // 周处理逻辑
																	// 业务上只支持1周N次的数据
			dts = OrSrvSplitUtil.getDateArrayByWeek(validSE[0], validSE[1],
					freqtimedos);
		} else if (OrSrvSplitUtil.isPeriodMonthFreq(sd_frequnit)) { // 月的处理逻辑
																	// 业务上只支持1月N次的数据
																	// 月末倒数第一天
																	// 1、2、3、4.。。。、-3-2、-1
			dts = OrSrvSplitUtil.getDateArrayByMonth(validSE[0], validSE[1],
					freqtimedos);
		}
		return dts;
	}

	/***
	 * 按合用法申请量计算
	 * 
	 * @param rtn
	 * @param tmht
	 */
	private void wardSumApplyQuanHandle(ArrayList<SrvSplitOrderDTO> rtn,
			Hashtable tmht) {
		// 有效性校验
		if (tmht == null || tmht.size() == 0)
			return;

		String key = "";
		FDouble quan = null;
		SrvSplitOrderDTO first = null;
		ArrayList<SrvSplitOrderDTO> tmlist = null;
		Enumeration<String> keys = tmht.keys();

		// 遍历
		while (keys.hasMoreElements()) {
			tmlist = (ArrayList<SrvSplitOrderDTO>) tmht.get(keys.nextElement());
			if (tmlist == null || tmlist.size() == 0) {
			} else {
				quan = sum(tmlist);
				first = tmlist.get(0);
				quan = OrSrvSplitUtil.CeilingRoundAfterDiv(quan,
						first.getFactor_mb()); 
				first.setQuan_medu(quan);
				first.setId_pkgu_ap(first.getId_pkgu_base());
				
				// 全部设置请领包装单位
				for (SrvSplitOrderDTO item : tmlist) {
					item.setId_pkgu_ap(item.getId_pkgu_base());
				}
				
				rtn.addAll(tmlist);
			}

//			rtn.addAll(tmlist);
		}

	}

	/***
	 * 仅按服务申请量计算
	 * 
	 * @param rtn
	 * @param tmht
	 */
	private void srvApplyQuanHandle(ArrayList<SrvSplitOrderDTO> rtn,
			Hashtable tmht) {
		// 有效性校验
		if (tmht == null || tmht.size() == 0)
			return;

		String key = "";
		FDouble quan = null;
		SrvSplitOrderDTO first = null;
		ArrayList<SrvSplitOrderDTO> tmlist = null;
		Enumeration<String> keys = tmht.keys();

		// 遍历
		while (keys.hasMoreElements()) {
			tmlist = (ArrayList<SrvSplitOrderDTO>) tmht.get(keys.nextElement());
			if (tmlist == null || tmlist.size() == 0) {
			} else {
				quan = sum(tmlist);
				first = tmlist.get(0);
				first.setQuan_mp_ap(quan);
				first.setId_pkgu_ap(first.getId_medu());
				rtn.addAll(tmlist);
			}
		}
	}

	/***
	 * 按申请类型对服务拆分结果进行分组
	 * 
	 * @param srvsplitorders
	 * @return
	 * @throws BizException
	 */
	private Hashtable getSrvSplitRsGrp(SrvSplitOrderDTO[] srvsplitorders)
			throws BizException {
		SrvSplitRsGrpByAppTypeBP bp = new SrvSplitRsGrpByAppTypeBP();
		return bp.exec(srvsplitorders);
	}
}
