package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import iih.ci.ord.s.bp.validate.CiOrValidateBP;
import iih.ci.ord.s.bp.validate.MethodConstants;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 临床医嘱及相关信息删除操作BP
 */
public class CiOrDeleteBP {
	/**
	 * 临床医嘱删除
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public  void exec(String id_or)  throws BizException{
		//有效性校验
		if(OrSrvSplitUtil.isEmpty(id_or))return;
		
		//获得医嘱聚集
		CiorderAggDO aggdo=CiOrdAppUtils.getOrAggQryService().findById(id_or);
		if(aggdo== null) return;
		//li_cheng 删除校验
		CiOrValidateBP validate=new CiOrValidateBP();
		if(!validate.exec(new CiorderAggDO[]{aggdo}, MethodConstants.DELETE_VALIDATE)){
			return ;
		}
		Integer emstype=getEmsType(aggdo.getParentDO().getSd_srvtp());
		if(aggdo==null)return;
		
		//医嘱项目对应物品删除
		if(aggdo.getOrdSrvDO()!= null){
			OrdSrvDO[] orsrvDO = aggdo.getOrdSrvDO();
			ciOrSrvMmDelete(getOrsrvs(orsrvDO));
		}
		
		
		//医嘱项目对应的变动剂量删除
		ciOrSrvDoseDelete(id_or);
		
		//医嘱或项目对应的套内项目删除
		ciOrSrvSetDelete(id_or);
		
		//医嘱对应的检验申请相关信息的删除
		if(emstype.equals(EmsType.LIS)){ciOrdApLabDODelete(id_or);}
		
		//医嘱对应的检查申请相关信息的删除
		if(emstype.equals(EmsType.RIS)){ciOrdApObsDODelete(id_or);}
		
		//医嘱对应的会诊申请相关信息的删除
		if(emstype.equals(EmsType.CONS)){ciOrdApConsDODelete(id_or);}
		
		//医嘱对应的皮试相关结果的删除 
		ciOrSkinTestRstDelete(aggdo);
		
		//备血对应的申请单相关信息的删除
		if(emstype.equals(EmsType.BT)){ciOrdApbtDODelete(id_or);}
		
		//手术对应申请单相关的信息的删除
		if(emstype.equals(EmsType.OPER)){ciOrdApOpDODelete(id_or);}
		
		//病理对应的申请单相关的信息的删除
		if(emstype.equals(EmsType.PATHGY)){ciOrdApPathgyDODelete(id_or);}
		
		//用血对应的申请单相关信息的删除
		if(emstype.equals(EmsType.BTUSE)){ciOrdApbuDODelete(id_or);};
		
		//转科对应的申请单相关信息的删除
		if(emstype.equals(EmsType.TRANSDEPT)){ciOrdAptransdeptDODelete(id_or);};
		
		//出院对应的申请单相关信息的删除
		if(emstype.equals(EmsType.OUTHOSP)){ciOrdApoutDODelete(id_or);};
		
		//皮试医嘱删除
		FBoolean fg_skintest = aggdo.getParentDO().getFg_skintest();
		if(!CiOrdUtils.isEmpty(fg_skintest)&&fg_skintest.booleanValue()){
			ciOrdSkintestDelete(id_or);
		}
		
		//临床医嘱数据信息删除
		ciOrDelete(aggdo);
		
		//医嘱相关临床事件的删除处理
		ciOrEventDelete(id_or);
		
		//处方相关数据的删除  暂不做处理
	}
	
	/**
	 * 医嘱项目关联物品数据删除
	 * @param id_or
	 * @throws BizException
	 */
	private void ciOrSrvMmDelete(String[] idorsrvs) throws BizException{
		CiOrMmDeleteBP bp=new CiOrMmDeleteBP();
		bp.exec(idorsrvs);
	}
	
	/**
	 * 医嘱项目关联变动剂量数据删除
	 * @param id_or
	 * @throws BizException
	 */
	private void ciOrSrvDoseDelete(String id_or) throws BizException{
		CiOrSrvDoseDeleteBP bp=new CiOrSrvDoseDeleteBP();
		bp.exec(id_or);
	}
	
	/**
	 * 医嘱或医嘱项目关联套内项目数据删除
	 * @param id_or
	 * @throws BizException
	 */
	private void ciOrSrvSetDelete(String id_or) throws BizException{
		CiOrSrvSetDeleteBP bp=new CiOrSrvSetDeleteBP();
		bp.exec(id_or);
	}
	
	/**
	 * 医嘱对应的皮试相关结果的删除
	 * @param id_or
	 * @throws BizException
	 */
	private void ciOrSkinTestRstDelete(CiorderAggDO aggdo) throws BizException{
		//参数设置
		CiOrderDO ordo=aggdo.getParentDO();
		
		//有效性判断
		if(!ICiDictCodeConst.SD_RELTYPE_SKINTEST.equals(ordo.getSd_reltp()))return;
		if(CiOrdUtils.isEmpty(ordo.getId_reltp()))return;
		
		//删除皮试结果
		CiOrskintestrstDeleteBP bp=new CiOrskintestrstDeleteBP();
		bp.exec(ordo.getId_or());
	}
	
	/**
	 * 医嘱检验申请单相关数据删除
	 * @param id_or
	 * @throws BizException
	 */
	private void ciOrdApLabDODelete(String id_or) throws BizException{
		CiOrapplisDeleteBP bp=new CiOrapplisDeleteBP();
		bp.exec(id_or);
	}
	
	/**
	 * 医嘱检查申请单相关数据删除
	 * @param id_or
	 * @throws BizException
	 */
	private void ciOrdApObsDODelete(String id_or) throws BizException{
		CiOrapplisDeleteBP bp=new CiOrapplisDeleteBP();
		bp.exec(id_or);
	}
	
	/**
	 * 医嘱会诊申请相关数据删除
	 * @param id_or
	 * @throws BizException
	 */
	private void ciOrdApConsDODelete(String id_or) throws BizException{
		CiOrappconsultDeleteBP bp=new CiOrappconsultDeleteBP();
		bp.exec(id_or);
	}
	
	/**
	 * 医嘱手术申请相关数据删除
	 * @param id_or
	 * @throws BizException
	 */
	private void ciOrdApOpDODelete(String id_or) throws BizException{
		CiOrappoptDeleteBP bp=new CiOrappoptDeleteBP();
		bp.exec(id_or);
	}
	
	/**
	 * 医嘱病理申请相关数据删除
	 * @param id_or
	 * @throws BizException
	 */
	private void ciOrdApPathgyDODelete(String id_or) throws BizException{
		CiOrapppathgyDeleteBP bp=new CiOrapppathgyDeleteBP();
		bp.exec(id_or);
	}
	
	/**
	 * 医嘱输血申请相关数据删除
	 * @param id_or
	 * @throws BizException
	 */
	private void ciOrdApbtDODelete(String id_or) throws BizException{
		CiOrappbtDeleteBP bp=new CiOrappbtDeleteBP();
		bp.exec(id_or);
	}
	
	/**
	 * 医嘱用血申请相关数据删除
	 * @param id_or
	 * @throws BizException
	 */
	private void ciOrdApbuDODelete(String id_or) throws BizException{
		CiOrappbuDeleteBP bp=new CiOrappbuDeleteBP();
		bp.exec(id_or);
	}
	
	/**
	 * 医嘱出院申请相关数据删除
	 * @param id_or
	 * @throws BizException
	 */
	private void ciOrdApoutDODelete(String id_or) throws BizException{
		CiOrappoutDeleteBP bp=new CiOrappoutDeleteBP();
		bp.exec(id_or);
	}
	
	/**
	 * 医嘱转科申请相关数据删除
	 * @param id_or
	 * @throws BizException
	 */
	private void ciOrdAptransdeptDODelete(String id_or) throws BizException{
		CiOrapptransdepDeleteBP bp=new CiOrapptransdepDeleteBP();
		bp.exec(id_or);
	}
	
	/**
	 * 获得默认医疗单类型
	 * @param sd_srvtp
	 * @return
	 * @throws BizException
	 */
	private Integer getEmsType(String sd_srvtp) throws BizException{
		GetDefaultEmsTp8SrvtpBP bp=new GetDefaultEmsTp8SrvtpBP();
		return bp.exec(sd_srvtp);
	}
	
	/**
	 * 删除医嘱对应的临床事件
	 * @param id_or
	 * @throws BizException 
	 */
	private void ciOrEventDelete(String id_or) throws BizException{
		CiOrEventsDeleteBP bp=new CiOrEventsDeleteBP();
		bp.exec(id_or);
	}
	
	/**
	 * 临床医嘱删除
	 * @param aggdo
	 * @throws BizException
	 */
	private void ciOrDelete(CiorderAggDO aggdo) throws BizException{
		CiOrdAppUtils.getOrAggService().delete(new CiorderAggDO[]{aggdo});
	}
	private void ciOrdSkintestDelete(String id_or) throws BizException{
		CiOrSkintestDeleteBP bp = new CiOrSkintestDeleteBP();
		bp.exec(id_or);
	}
	/***
	 *  id_orsrv 数据组
	 * @param orsrvDO
	 * @return
	 * @throws BizException
	 */
	private String[] getOrsrvs(OrdSrvDO[] orsrvDO)throws BizException{
		 if(orsrvDO == null)  return null;
		 
		  String[] idsrv = new String[orsrvDO.length];
		  int i =0;
		  for(OrdSrvDO srvDO:orsrvDO){
			  idsrv[i] = srvDO.getId_orsrv();
			  i++;
		  }
		  return idsrv;
	}
}
