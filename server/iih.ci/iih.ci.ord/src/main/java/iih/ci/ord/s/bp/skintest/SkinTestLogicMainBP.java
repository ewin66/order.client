package iih.ci.ord.s.bp.skintest;

import iih.ci.ord.dto.d.SkinTestParamDTO;
import iih.ci.ord.dto.d.SkinTestRstDTO;
import iih.ci.ord.dto.d.SkinTestUsePharmRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.d.AllergicHandleModeEnum;
import iih.ci.ord.pub.d.AllergicPharmHandleMode;
import iih.ci.ord.pub.d.NDaysValidThingEnum;
import iih.ci.ord.s.bp.exception.AllergicHisCheckPharmForbiddenException;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.pi.overview.overview.d.PiPatAlDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 皮试判断与处理逻辑操作BP
 */
public class SkinTestLogicMainBP {
	/**
	 * 皮试主线处理与判断逻辑
	 * @param skintestparam SkinTestParamDTO
	 * @return AllergicPharmHandleMode
	 * @throws BizException
	 */
	public SkinTestRstDTO exec(SkinTestParamDTO skintestparam) throws BizException{
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		//获得本院过敏处理模式
		Integer allergicHisMode=getAllergicHisHandleMode(skintestparam.getId_org());
		//allergicHisMode = 2;
		
		// 获得近期有效皮试医嘱信息数据 NDaysValidThingEnum
		SkinTestUsePharmRstDTO skintestrstinfo0 = getLatelySkinTestRelRstInfo(skintestparam);
		Integer skintestrstinfo = skintestrstinfo0.getNdaysvalidrst();
		if (NDaysValidThingEnum.WITHEXECUSEPHARM.equals(skintestrstinfo))
			return getSkinTestRstDTO(AllergicPharmHandleMode.DIRECTUSEEXCLUDEALLERGIC, null,null);
		if (NDaysValidThingEnum.SKINTESTYANG.equals(skintestrstinfo))
			return getSkinTestRstDTO(SkinTestYangHandle(allergicHisMode), null,skintestrstinfo0.getDt_act());
		if (NDaysValidThingEnum.SKINTESTYIN.equals(skintestrstinfo))
			return getSkinTestRstDTO(AllergicPharmHandleMode.DIRECTUSEEXCLUDEALLERGIC, null,null);
		if (NDaysValidThingEnum.WAITSKINTESTRST.equals(skintestrstinfo))
			return getSkinTestRstDTO(AllergicPharmHandleMode.WAITSKINTESTRPT,skintestrstinfo0.getId_orskin(), null);
		if (NDaysValidThingEnum.NOEXECUSEPHARM.equals(skintestrstinfo)||NDaysValidThingEnum.OTHER.equals(skintestrstinfo)){
			//存在过敏史数据信息处理逻辑
			PiPatAlDO pipatdo = isExistsAllergicHisInfo(skintestparam.getId_org(),skintestparam.getId_pi(),skintestparam.getId_mm());
			if(pipatdo != null){
				return getSkinTestRstDTO(SkinTestYangHandle(allergicHisMode),null,pipatdo.getDt_act());
			}else{
				return getSkinTestRstDTO(AllergicPharmHandleMode.SKINALLERGICTEST,null,null);
			}
		}
		//return getSkinTestRstDTO(AllergicPharmHandleMode.SKINALLERGICTEST,null, null);
		return getSkinTestRstDTO(AllergicPharmHandleMode.UNKNOWN,null,null);  //这种情况应该不会发生
	}
	
	/**
	 * 设置皮试逻辑结果DTO
	 * @param input
	 * @param id_skintest
	 * @return
	 */
	private SkinTestRstDTO getSkinTestRstDTO(Integer input,String id_skinor,FDateTime dt_act){
		SkinTestRstDTO rtn=new SkinTestRstDTO();
		rtn.setAllergicpharmhandlemode(input);
		if(!CiOrdUtils.isEmpty(id_skinor)){
			rtn.setId_skinor(id_skinor);
		}
		if(!CiOrdUtils.isEmpty(dt_act)){
			rtn.setDt_act(dt_act);
		}
		return rtn;
	}
	
	/**
	 * 是否存在过敏史数据信息
	 * @param id_org
	 * @param id_pi
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private PiPatAlDO isExistsAllergicHisInfo(String id_org,String id_pi,String id_mm) throws BizException{
		IsExistsPatiAllergicHisBP bp=new IsExistsPatiAllergicHisBP();
		return bp.exec(id_org, id_pi, id_mm);
	}
	
	/**
	 * 获得过敏史的处理模式（本院）
	 * @param id_org
	 * @return
	 * @throws BizException 
	 */
	private Integer getAllergicHisHandleMode(String id_org) throws BizException{
		GetAllergicHisHandleModeBP bp=new GetAllergicHisHandleModeBP();
		return bp.exec(id_org);
	}
	
	/**
	 * 获得患者最近皮试或用药相关数据结果信息
	 * @param id_org
	 * @param id_pi
	 * @param dt_birth
	 * @param id_srv
	 * @param id_skinsrv
	 * @return
	 * @throws BizException
	 */
	private SkinTestUsePharmRstDTO getLatelySkinTestRelRstInfo(SkinTestParamDTO skintestparam) throws BizException{
		GetLatelySkinTestRelInfoBP bp=new GetLatelySkinTestRelInfoBP();
		return bp.exec(skintestparam);
	}
	
	/**
	 * 过敏处理模式
	 * @param allergicHisMode
	 * @return
	 * @throws AllergicHisCheckPharmForbiddenException
	 */
	private Integer SkinTestYangHandle(Integer allergicHisMode) throws AllergicHisCheckPharmForbiddenException{
//		if(AllergicHandleModeEnum.FORBIDDEN.equals(allergicHisMode)){
//			throw new AllergicHisCheckPharmForbiddenException();//禁用的处理
//		}else{
			return allergicHisMode;  //阳性禁用，再皮试或强制使用
			
//		}
	}
}
