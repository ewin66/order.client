package iih.ci.ord.s.bp.ems;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.exception.CiOrSrvMmRelSkinSrvNullException;

/**
 * 获得皮试医嘱信息操作BP
 */
public class CiOrSkinTestOrInfoGet {
	/**
	 * 获得皮试医嘱信息
	 * @param ems
	 * @param id_mm
	 * @return
	 * @throws BizException
	 */
	public CiOrAggAndRelDatum exec(CiEmsDTO ems,String id_mm) throws BizException{
		String id_srvskin=CiOrdUtils.getMmRelSkinSrv(id_mm);
		if(CiOrdUtils.isEmpty(id_srvskin))throw new CiOrSrvMmRelSkinSrvNullException();
		
		//获得皮试医疗单数据
		CiOrSkinTestOrBuildBP bp=new CiOrSkinTestOrBuildBP();
		CiEmsDTO skinems=bp.exec(id_srvskin,ems);
		//默认值设置
		defaultValueSet(ems);
		//生成皮试医嘱及关联信息数据
		CiOrEms2OrAggAndRelInfoBP bp1=new CiOrEms2OrAggAndRelInfoBP();
		CiOrAggAndRelDatum reldatum = bp1.exec(skinems);
		//库存校验
		validateDrugCount(reldatum);
		return reldatum;
	}
	
	/**
	 * 医疗单默认值设置处理逻辑
	 * @param ems
	 * @throws BizException
	 */
	private void defaultValueSet(CiEmsDTO ems) throws BizException{
		if(ems==null)return;
		
		CiEmsDefaultValueSetBP bp=new CiEmsDefaultValueSetBP();
		bp.exec(ems);
	}
	/**
	 * 
	 * @param reldatum
	 * @throws BizException
	 */
	private void validateDrugCount(CiOrAggAndRelDatum reldatum) throws BizException{
		OrdSrvDO[] ordsrvs = reldatum.getOraggdo().getOrdSrvDO();
		if(CiOrdUtils.isEmpty(reldatum.getOrattachht())||CiOrdUtils.isEmpty(reldatum.getOrattachht().get(OrdSrvMmDODesc.CLASS_FULLNAME)))
				return;
		FMap mmMap = (FMap)reldatum.getOrattachht().get(OrdSrvMmDODesc.CLASS_FULLNAME);
		Map<String,String[]> mapParams = new HashMap<String,String[]>();
		for(OrdSrvDO srvdo : ordsrvs){
			if(srvdo.getStatus()!=DOStatus.DELETED&&srvdo.getFg_mm()==FBoolean.TRUE){
				String key = srvdo.getId_srv()+"_"+srvdo.getId_mm();
				List<OrdSrvMmDO> mmdos = (List<OrdSrvMmDO>)mmMap.get(key);
				//获得服务对应的物品信息
				OrdSrvMmDO mmdo = null;
				for(OrdSrvMmDO mm :mmdos){
					if(mm.getStatus()!=DOStatus.DELETED)
					{
						mmdo = mm;
					}
				}
				String[] params = new String[5];
				String keyId = CiOrdUtils.getKeyId(srvdo.getId_mm(),srvdo.getId_dep_wh(),mmdo.getId_pgku_cur());
				if(!CiOrdUtils.isEmpty(keyId)){
					mapParams.put(keyId, params);
					params[0] = srvdo.getId_mm();
					params[1] = srvdo.getId_dep_wh();
					params[2] = mmdo.getId_pgku_cur();
					params[3] = srvdo.getName_srv();
					params[4] = mmdo.getQuan_cur()==null?"0":mmdo.getQuan_cur().toString();
				}
			}
		}
		if(!mapParams.isEmpty()){
			String refusedMsg = CiOrdUtils.ValidateDrugCount(mapParams);
			if(!CiOrdUtils.isEmpty(refusedMsg)){
				throw new BizException(refusedMsg);
			}
		}
	}
}
