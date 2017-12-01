package iih.ci.ord.s.bp.ems;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;

/*
 * 根据医疗单项目数据设置医嘱项目对应的变动剂量数据信息操作BP
 */
public class SetDoseInfoOfOrSrv8EmsBP {
	/**
	 * 根据医疗单项目数据设置医嘱项目对应的变动剂量数据信息
	 * @param srvdo
	 * @return
	 */
	public OrdSrvDoseDO[] exec(OrdSrvDO srvdo,CiEmsSrvDTO srvdto) throws BizException{
		OrdSrvDoseDO[] srvdoses=null;
		if(CiOrdUtils.isDONew(srvdo)){
			return getOrdSrvDoses(srvdto.getEmsfreqdose());
		}
		srvdoses=getCiSrvDoseDOs(srvdo.getId_orsrv());
		if(srvdoses==null){
			if(OrSrvSplitUtil.isTrue(srvdto.getFg_dose_anoma())){
				return getOrdSrvDoses(srvdto.getEmsfreqdose());
			}			
		}else{
			
		}
		return srvdoses;
	}
	
	/**
	 * 获得变动用量数据
	 * @param freqdosary
	 * @return
	 */
	private OrdSrvDoseDO[] getOrdSrvDoses(FArrayList freqdosary){
		if(freqdosary==null || freqdosary.size()==0)return null;
		OrdSrvDoseDO[] rtns=new OrdSrvDoseDO[freqdosary.size()];
		for(int i=0;i<freqdosary.size();i++){
			rtns[i]=(OrdSrvDoseDO)freqdosary.get(i);
		}
		return rtns;
	}
	
	/**
	 * 医嘱项目关联变动剂量数据
	 * @param id_or
	 * @throws BizException
	 */
	private OrdSrvDoseDO[] getCiSrvDoseDOs(String id_orsrv) throws BizException{
		GetDoseOfCiOrSrvBP bp=new GetDoseOfCiOrSrvBP();
		return bp.exec(id_orsrv, true);
	}
}
