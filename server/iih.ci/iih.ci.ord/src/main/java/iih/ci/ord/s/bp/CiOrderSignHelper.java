package iih.ci.ord.s.bp;

import java.util.ArrayList;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.cior.d.ReactExtOrsAndStopOrsDO;
import iih.ci.ord.cior.d.ValidateRtnInfoDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.validate.OrMutexValidateBP;
import iih.ci.ord.s.bp.validate.SrvDoctorRtValidateBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/*
 * 临床医嘱的签署
 */
public class CiOrderSignHelper {

	/**
	 * 医嘱签署检查校验通过，设置返回值数据信息
	 * @param dto
	 * @param ciors
	 * @param reactstopors
	 */
	public static void orReactStopOrPromptRtnHandle(ValidateRtnInfoDTO dto,
			CiOrderDO[] ciors, ArrayList<CiOrderDO> reactstopors) {
		dto.setPhaseno(99); // 阶段99 检查校验通过
		dto.setScenedatum(null);
		FMap2 rtnvalue = new FMap2();
		Object[] obs= CiOrdUtils.mergeObjAry(ciors,
				CiOrdUtils.list2Array(reactstopors, CiOrderDO.class));
		CiOrderDO[] cis=new CiOrderDO[obs.length];
		int i=0;
		for (Object obj : obs) {
			cis[i]=(CiOrderDO)obj;
			i++;
		}
		// rtnvalue.put("ciors", cis);// // json 序列化与反序列化 不能识别 [] 数组，改为如下 -- wangqzh - 2017-6-8
		rtnvalue.put("ciors", CiOrdUtils.array2FArrayList(ciors));// json 序列化与反序列化 不能识别 [] 数组
		dto.setRtnvalue(rtnvalue);
		dto.setFg_rtnscene(FBoolean.FALSE);
	}
	
	/**
	 * 医嘱签署检查校验通过，设置返回值数据信息
	 * @param dto
	 * @param ciors
	 */
	public static void orReactStopOrPromptRtnHandle(ValidateRtnInfoDTO dto,CiOrderDO[] ciors){
		dto.setPhaseno(99);  //阶段99   检查校验通过
		dto.setScenedatum(null);
		FMap2 rtnvalue=new FMap2();
		rtnvalue.put("ciors", CiOrdUtils.array2FArrayList(ciors));
		dto.setRtnvalue(rtnvalue);
		dto.setFg_rtnscene(FBoolean.FALSE);
	}

	/**
	 * 创建门诊医嘱会话区间
	 * @param ciors
	 * @param dt_cur
	 * @return
	 * @throws BizException
	 */
	public static CiOrSessionDO createCiOrSessionDO(CiOrderDO[] ciors,FDateTime dt_cur) throws BizException{
		CiOrOpSessionInsertBP bp=new CiOrOpSessionInsertBP();
		return bp.exec(ciors, dt_cur);
	}
	
}
