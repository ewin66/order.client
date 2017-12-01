package iih.ci.ord.s.bp.ems;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

/*
 * 根据医疗单项目数据设置医嘱项目对应的物品数据信息操作BP
 */
public class SetSkinOrInfoOfSkinSrv8EmsBP {
	/**
	 * 根据医疗单项目数据设置医嘱项目对应的物品数据信息
	 * @param srvdo
	 * @return
	 */
	public OrdSrvMmDO exec(OrdSrvDO srvdo,CiEmsSrvDTO srvdto) throws BizException{
		OrdSrvMmDO srvmmdo=new OrdSrvMmDO();
		if(CiOrdUtils.isDONew(srvdo)){
			createCiOrdSrvMmDO(srvmmdo,srvdo,srvdto,DOStatus.NEW);
			return srvmmdo;
		}
		srvmmdo=getCiSrvMmDO(srvdo.getId_orsrv());
		if(srvmmdo==null){
			if(OrSrvSplitUtil.isTrue(srvdto.getFg_mm())){
				srvmmdo=new OrdSrvMmDO();
				createCiOrdSrvMmDO(srvmmdo,srvdo,srvdto,DOStatus.NEW);
			}			
		}else{
			createCiOrdSrvMmDO(srvmmdo,srvdo,srvdto,DOStatus.UPDATED);
		}
		return srvmmdo;
	}
	
	/**
	 * 生成医嘱项目对应物品数据信息
	 * @param srvdo
	 * @param srvdto
	 * @return
	 */
	private void createCiOrdSrvMmDO(OrdSrvMmDO srvmmdo,OrdSrvDO srvdo,CiEmsSrvDTO srvdto,int status){

		srvmmdo.setId_orsrvmm(srvmmdo.getId_orsrvmm());
		srvmmdo.setId_orsrv(srvmmdo.getId_orsrv());
		srvmmdo.setId_mm(srvdto.getId_mm());
		srvmmdo.setCode_mm(srvdto.getCode_mm());
		srvmmdo.setName_mm(srvdto.getName_mm());
		srvmmdo.setId_pgku_cur(srvdto.getId_unit_sale());
		srvmmdo.setPrice_pgku_cur(srvdto.getPrice_cur());
		srvmmdo.setQuan_cur(srvdto.getQuan_cur());
		srvmmdo.setId_pgku_base(srvdto.getId_unit_base());
		 int[] numben=OrSrvSplitUtil.getNumDen(srvdto.getQuan_med(), srvdto.getFactor_mb());
		 srvmmdo.setQuan_num_base(numben[0]);
		 srvmmdo.setQuan_den_base(numben[1]);
		srvmmdo.setQuan_bed_medu(srvdto.getQuan_bed_medu());
		srvmmdo.setFactor(srvdto.getFactor_cb());
		srvmmdo.setFactor_mb(srvdto.getFactor_mb());
		srvmmdo.setId_dosage(srvdto.getId_dosage());
		srvmmdo.setSd_dosage(srvdto.getSd_dosage());
		srvmmdo.setId_pharm(srvdto.getId_pharm());
		srvmmdo.setSd_pharm(srvdto.getSd_pharm());
		srvmmdo.setId_val(srvdto.getId_val());
		srvmmdo.setSd_val(srvdto.getSd_val());
		srvmmdo.setId_pois(srvdto.getId_pois());
		srvmmdo.setSd_pois(srvdto.getSd_pois());
		srvmmdo.setId_anti(srvdto.getId_anti());
		srvmmdo.setSd_anti(srvdto.getSd_anti());
		srvmmdo.setId_mmtp(srvdto.getId_mmtp());
		srvmmdo.setSd_mmtp(srvdto.getSd_mmtp());
		//srvmmdo.setId_antipsy(srvdto.getId_antipsy());  //暂时没有这个概念
		//srvmmdo.setSd_antipsy(srvdto.getSd_antipsy());
		//srvmmdo.setFg_otc(srvdto.getFg_otc());
		srvmmdo.setDays_available(srvdto.getDays_available());//领可用天数（门诊用）
		srvmmdo.setStatus(status);
		
	}
	
	/**
	 * 医嘱项目关联物品数据
	 * @param id_or
	 * @throws BizException
	 */
	private OrdSrvMmDO getCiSrvMmDO(String id_orsrv) throws BizException{
		GetMmOfCiOrSrvBP bp=new GetMmOfCiOrSrvBP();
		return bp.exec(id_orsrv, true);
	}
}
