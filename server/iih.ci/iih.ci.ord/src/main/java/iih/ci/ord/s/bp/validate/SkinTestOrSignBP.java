package iih.ci.ord.s.bp.validate;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.d.AllergicHandleModeEnum;
import iih.ci.ord.s.bp.skintest.GetAllergicHisHandleModeBP;
import iih.ci.ord.skintest.d.CiSkinTestRstDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/*
 * 皮试医嘱签署检查操作BP
 */
public class SkinTestOrSignBP {
	/**
	 * 皮试医嘱检查
	 * @throws BizException
	 */
	public void exec(CiorderAggDO[] aggors) throws BizException{
		for(CiorderAggDO aggor:aggors){
			if(!aggor.getParentDO().getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)){
				continue;
			}
			OrdSrvDO[] orsrvDOs = aggor.getOrdSrvDO();
		       //皮试医嘱医院处理模式
		       Integer AllergicHandleModeEnum = 9;
		       for(OrdSrvDO ordSrvDO :orsrvDOs){
		    	   //判断是否是皮试医嘱服务
		    	   if(this.isSkinTestOr(ordSrvDO).booleanValue()){
		    		   //是否有皮试结果
		    		   if(isHasSkinRet(ordSrvDO).booleanValue()){
		    			   CiSkinTestRstDO rstDo = CiOrdUtils.getCiSkinTestRstDO(ordSrvDO.getId_or_rel());
		    			   //皮试医嘱是否存在
		    			   if(!CiOrdUtils.isEmpty(rstDo)){
		    				   String sd_rst = rstDo.getSd_rst_skintest();
		    				   if(!CiOrdUtils.isEmpty(sd_rst)){
		    					   if(sd_rst.startsWith("1")){//阳性
		    						   if(AllergicHandleModeEnum ==9 ){
		    							   GetAllergicHisHandleModeBP bp=new GetAllergicHisHandleModeBP();
		    							   AllergicHandleModeEnum = bp.exec(ordSrvDO.getId_or());
		    						   }
		    						   if(AllergicHandleModeEnum==0||AllergicHandleModeEnum==1){
		    							   throw new BizException("医嘱"+aggor.getParentDO().getName_or() +"的皮试结果为阳性，禁止开立！");
		    						   }
		    					   }
		    				   }
		    			   }else{
		    				   throw new BizException("医嘱"+aggor.getParentDO().getName_or() +"的皮试医嘱不存在！");
		    			   }
		    		   }else{
		    			   //关联的皮试医嘱
		    			   String id_or_skin = ordSrvDO.getId_or_rel();
		    			   CiSkinTestRstDO[] skintest = CiOrdAppUtils.getCiskintestrstQryService().find(String.format("id_or='%s'",id_or_skin),"", FBoolean.FALSE);;
		    			   if(CiOrdUtils.isEmpty(skintest)){
		    				   throw new BizException("未检测到药品【"+ordSrvDO.getName_srv()+"】的过敏信息，请删除后重新开立！");
		    			   }else{
		    				   if(!isAdmitDrugOrBeforeSkinTestRst(aggor.getParentDO().getId_org()).booleanValue()){
		        				   throw new BizException("医嘱"+aggor.getParentDO().getName_or() +"的皮试结果未出！");
		        			   }
		    			   }   
		    		   }
		    	   }
		       }
		}
	}
	/**
	 * 判断是否是皮试医嘱
	 * @param ordSrvDO
	 * @return
	 */
	private FBoolean isSkinTestOr(OrdSrvDO ordSrvDO){
		if(!CiOrdUtils.isEmpty(ordSrvDO.getFg_skintest())&&ordSrvDO.getFg_skintest().booleanValue()){
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}
	/**
	 * 是否有皮试结果
	 * @param ordSrvDO
	 * @return
	 */
	private FBoolean isHasSkinRet(OrdSrvDO ordSrvDO){
		if(!CiOrdUtils.isEmpty(ordSrvDO.getFg_skintest_rst())&&ordSrvDO.getFg_skintest_rst().booleanValue()){
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}
	/**
	 * 无皮试医嘱结果时是否可以签署皮试液医嘱参数
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	private FBoolean isAdmitDrugOrBeforeSkinTestRst(String id_org)  throws BizException{ 
		//获得参数值
		FBoolean rtn=ParamsetQryUtil.getParaBoolean(id_org, ICiOrdNSysParamConst.SYS_PARAM_IsAdmitDrugOrBeforeSkinTestRst);
		return rtn;
	}
}
