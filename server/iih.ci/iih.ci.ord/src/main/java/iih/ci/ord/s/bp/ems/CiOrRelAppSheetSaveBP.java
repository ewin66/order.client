package iih.ci.ord.s.bp.ems;

import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.d.OrdApOutDO;
import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.CiOrappbtSaveBP;
import iih.ci.ord.s.bp.CiOrappbuSaveBP;
import iih.ci.ord.s.bp.CiOrappconsultSaveBP;
import iih.ci.ord.s.bp.CiOrapplisSaveBP;
import iih.ci.ord.s.bp.CiOrappoptSaveBP;
import iih.ci.ord.s.bp.CiOrappoutSaveBP;
import iih.ci.ord.s.bp.CiOrapppathgySaveBP;
import iih.ci.ord.s.bp.CiOrapprisSaveBP;
import iih.ci.ord.s.bp.CiOrapptransdepSaveBP;
import xap.mw.core.data.BizException;

/*
 * 医嘱对应的申请单保存处理操作BP
 */
public class CiOrRelAppSheetSaveBP {
	/**
	 * 医嘱对应的申请单保存处理
	 * @param orappmap
	 * @param id_ora
	 * @param iemstp
	 * @throws BizException
	 */
	public  void exec(Object orappmap,String id_or,int iemstp)  throws BizException{
		//有效性校验
		if(orappmap==null || CiOrdUtils.isEmpty(id_or) || iemstp==-1)return;
		
		//申请单数据保存
		if(EmsType.LIS.equals(iemstp)){
			OrapplisSave((OrdApLabDO)orappmap,id_or);;
		}else if(EmsType.RIS.equals(iemstp)){
			OrapprisSave((OrdApObsDO)orappmap,id_or);
		}else if(EmsType.OPER.equals(iemstp)){
			 OrappoptSave((CiorappsurgeryAggDO)orappmap,id_or);
		}else if(EmsType.PATHGY.equals(iemstp)){
			OrapppathgySave((CiorapppathgyAggDO)orappmap,id_or);
		}else if(EmsType.BT.equals(iemstp)){
			OrappbtSave((CiorappbtAggDO)orappmap,id_or);
		}else if(EmsType.CONS.equals(iemstp)){
			OrappconsultSave((CiorappconsultAggDO)orappmap,id_or);
		}else if(EmsType.BTUSE.equals(iemstp)){
			OrappbuSave((OrdAppBtUseDO)orappmap,id_or);
		}else if(EmsType.TRANSDEPT.equals(iemstp)){
			OrapptransdepSave((OrdApTransDO)orappmap,id_or);
		}else if(EmsType.OUTHOSP.equals(iemstp)){
			OrappoutSave((OrdApOutDO)orappmap,id_or);
		}
	}
	
	/**
	 * 会诊申请保存
	 * @throws BizException 
	 */
	private void OrappconsultSave(CiorappconsultAggDO orappmap,String id_or) throws BizException{
		CiOrappconsultSaveBP bp=new CiOrappconsultSaveBP();
		bp.exec(orappmap, id_or);
	}
	
	/**
	 * 手术申请保存
	 * @throws BizException 
	 */
	private void OrappoptSave(CiorappsurgeryAggDO orappmap,String id_or) throws BizException{
		CiOrappoptSaveBP bp=new CiOrappoptSaveBP();
		bp.exec(orappmap, id_or);
	}
	
	/**
	 * 病理申请保存
	 * @throws BizException 
	 */
	private void OrapppathgySave(CiorapppathgyAggDO orappmap,String id_or) throws BizException{
		CiOrapppathgySaveBP bp=new CiOrapppathgySaveBP();
		bp.exec(orappmap, id_or);
	}

	/**
	 * 备血申请保存
	 * @throws BizException 
	 */
	private void OrappbtSave(CiorappbtAggDO orappmap,String id_or) throws BizException{
		CiOrappbtSaveBP bp=new CiOrappbtSaveBP();
		bp.exec(orappmap, id_or);
	}
	
	/**
	 * 用血申请保存
	 * @throws BizException 
	 */
	private void OrappbuSave(OrdAppBtUseDO orappmap,String id_or) throws BizException{
		CiOrappbuSaveBP bp=new CiOrappbuSaveBP();
		bp.exec(orappmap, id_or);
	}
	
	/**
	 * 检验申请保存
	 * @throws BizException 
	 */
	private void OrapplisSave(OrdApLabDO orappmap,String id_or) throws BizException{
		CiOrapplisSaveBP bp=new CiOrapplisSaveBP();
		bp.exec(orappmap, id_or);
		
	}
	
	/**
	 * 出院申请保存
	 * @throws BizException 
	 */
	private void OrappoutSave(OrdApOutDO orappmap,String id_or) throws BizException{
		CiOrappoutSaveBP bp=new CiOrappoutSaveBP();
		bp.exec(orappmap, id_or);
	}
	
	/**
	 * 检查申请保存
	 * @throws BizException 
	 */
	private void OrapprisSave(OrdApObsDO orappmap,String id_or) throws BizException{
		CiOrapprisSaveBP bp=new CiOrapprisSaveBP();
		bp.exec(orappmap, id_or);
	}
	
	/**
	 * 转科申请保存
	 * @throws BizException 
	 */
	private void OrapptransdepSave(OrdApTransDO orappmap,String id_or) throws BizException{
		CiOrapptransdepSaveBP bp=new CiOrapptransdepSaveBP();
		bp.exec(orappmap, id_or);
	}

}
