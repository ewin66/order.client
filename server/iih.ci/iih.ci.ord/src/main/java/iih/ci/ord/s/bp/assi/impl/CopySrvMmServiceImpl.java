package iih.ci.ord.s.bp.assi.impl;

import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.d.desc.MeterialDODesc;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.bp.assi.service.AbstractAssiCopy;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 拷贝物品相关属性
 * @author HUMS
 *
 */
public class CopySrvMmServiceImpl extends AbstractAssiCopy<MedSrvDO, CiEmsSrvDTO> {

	@Override
	protected void copyPropertys(MedSrvDO medSrv, CiEmsSrvDTO srvdto) throws BizException {


		MeterialAggDO meterialAgg = null;
		if (StringUtils.isNotBlank(srvdto.getId_mm())) {
			meterialAgg = CiOrdAppUtils.getIMeterialRService().findById(srvdto.getId_mm());
		} else {
			String whereStr = MeterialDODesc.TABLE_ALIAS_NAME + "." + MeterialDO.ID_SRV + " = '" + medSrv.getId_srv() + "'";
			MeterialAggDO[] meterAggDO = CiOrdAppUtils.getIMeterialRService().find(whereStr, MeterialDO.ID_SRV, FBoolean.FALSE);
			if (meterAggDO != null && meterAggDO.length > 0) {
				meterialAgg = meterAggDO[0];
			}
		}

		if (meterialAgg == null) {
			return;
		}
		
		MeterialDO meterial = meterialAgg.getParentDO();
		srvdto.setFg_skintest(meterial.getFg_skin());
		// srvdto.setQuan_cur(tmplSrv.getQuan_cur());//总量_当前
		/// srvdto.setQuan_base(meterial.getQuan_base());//总量_基本
		srvdto.setId_mm(meterial.getId_mm());// 物品id
		srvdto.setName_mm(meterial.getName());// 物品名称
		srvdto.setSpec_mm(meterial.getSpec());// 规格
		// 获取物品的有效单位
		MaterialUnitDTO[] materIalUnits = imaterialInfoService.getMMunitByEntp(new String[]{srvdto.getId_mm()},envinfo.getCode_entp());
		srvdto.setId_unit_sale(materIalUnits[0].getId_measdoc());// 零售单位
		srvdto.setName_unit_sale(materIalUnits[0].getMeasdoc_name());// 零售单位名称	
		
		srvdto.setId_unit_base(meterial.getId_unit_pkgbase());// 基本单位
		srvdto.setName_unit_base(meterial.getPkgbase_name());// 基本单位名称
		// srvdto.setQuan_num_base(meterial.getParentDO().getQuan_num_base());//单次数量_分子
		// srvdto.setQuan_den_base(meterial.getParentDO().getQuan_den_base());//单次数量_分母
		// srvdto.setPrice_cur(tmplSrv.getPrice_cur());//参考价当前
		// srvdto.setQuan_bed_medu(tmplSrv.getQuan_bed_medu());//床边量_医学
		srvdto.setFactor_cb(meterial.getFactor_sb());// 当前基本换算系数
		srvdto.setFactor_mb(meterial.getFactor_mb());// 医疗基本换算系数
		// srvdto.setFactor(getSaleFactor(meterial,srvdto.getId_unit_sale()));//总量单位换算系数
		FDouble pricce = this.getMMPrice(meterial.getId_mm(), meterial.getId_unit_pkgbase());
		srvdto.setPrice_cur(pricce);
		srvdto.setPrice(pricce);
		if (iih.bd.bc.udi.pub.IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(envinfo.getCode_entp())) {
			srvdto.setSd_roundmd(meterial.getSd_mupkgutp());// 住院-取整方式
		} else {
			srvdto.setSd_roundmd(meterial.getSd_opmutp());// 门诊-取整方式
		}

		// 获取药品属性 代优化 查询位置不对
		String whereStr = MedSrvDrugDO.ID_SRV + "='" + medSrv.getId_srv() + "'";
		MedSrvDrugDO[] drugDO = CiOrdAppUtils.getIMedSrvDrugDORService().find(whereStr, MedSrvDrugDO.ID_SRV, FBoolean.FALSE);
		if (drugDO != null && drugDO.length > 0) {
			srvdto.setId_dosage(drugDO[0].getId_dosage());// 药品剂型
			srvdto.setSd_dosage(drugDO[0].getSd_dosage());// 药品剂型编码
			srvdto.setId_pharm(drugDO[0].getId_pharm());// 药理分类
			srvdto.setSd_pharm(drugDO[0].getSd_pharm());// 药理分类编码
			srvdto.setId_pois(drugDO[0].getId_pois());// 毒麻分类
			srvdto.setSd_pois(drugDO[0].getSd_pois());// 毒麻分类编码
			srvdto.setId_anti(drugDO[0].getId_anti());// 抗菌药分类
			srvdto.setSd_anti(drugDO[0].getSd_anti());// 抗菌药分类编码
		}	

		srvdto.setId_mmtp(meterial.getId_mmtp());// 物品类型
		srvdto.setSd_mmtp(meterial.getSd_mmtp());// 物品类型编码
		srvdto.setName_mmtp(meterial.getMmca_name());// 物品类型名称
		srvdto.setId_sup(meterial.getId_sup());// 厂家
		srvdto.setName_sup(meterial.getFactory_name());// 厂家名称
		srvdto.setCode_mm(meterial.getCode());// 物品编码
		srvdto.setSd_val(meterial.getSd_val());// 价值分类编码
		srvdto.setId_val(meterial.getId_val());// 价值分类
		srvdto.setIndica(meterial.getIndica());// 适应症
		srvdto.setConstr(meterial.getConstr());// 禁忌症
		srvdto.setReact(meterial.getReact());// 不良反应
//		 srvdto.setGuide(meterial.getGuide());//主要作用
		srvdto.setFg_otc(meterial.getFg_otc());// OTC标识	
				
		srvdto.setPrice(meterial.getPrice());// 零售价
	
		
	}

}
