package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.ReactExtOrsAndStopOrsDO;
import iih.ci.ord.cior.d.ValidateRtnInfoDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FDateTime;

/*
 * 临床医嘱的签署操作BP
 */
public class CiOrderSignStep1BP {
	/**
	 * 临床医嘱的签署（Step1）
	 * 临床医嘱的签署（Step1）
	 * 更新医嘱状态、被排斥医嘱停止、创建临床事件
	 * 门诊创建会话期间、门诊处方分方
	 * code_entp 就诊类型
	 * @param map
	 * @return
	 * @throws BizException
	 */
	public ValidateRtnInfoDTO exec(FMap2 map,String code_entp) throws BizException{
		if(CiOrdUtils.isEmpty(map))return null;
		
		//参数设置  场景数据准备
		FDateTime dt_cur=(FDateTime)map.get("dt_cur");
		CiOrderDO[] ciors=(CiOrderDO[])CiOrdUtils.list2Array((FArrayList)map.get("ciors"), CiOrderDO.class);
		ReactExtOrsAndStopOrsDO willstopors=(ReactExtOrsAndStopOrsDO)map.get("willstopors");
		//ValidateRtnInfoDTO dto=new ValidateRtnInfoDTO();
		
		//临床医嘱的签署（Step1）
		//更新医嘱状态、被排斥医嘱停止、创建临床事件 门诊创建会话期间、门诊处方分方
		CiOrderSignStep1aBP bp=new CiOrderSignStep1aBP();
		return bp.exec(ciors, willstopors, dt_cur,code_entp);
	}

}
