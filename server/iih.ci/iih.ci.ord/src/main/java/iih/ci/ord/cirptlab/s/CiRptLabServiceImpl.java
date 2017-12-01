package iih.ci.ord.cirptlab.s;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.i.ICiorapplisRService;
import iih.ci.ord.cirptlab.d.CiRptLabDO;
import iih.ci.ord.cirptlab.d.CiRptLabItmDO;
import iih.ci.ord.cirptlab.d.CirptlabAggDO;
import iih.ci.ord.cirptlab.i.ICiRptLabService;
import iih.ci.ord.cirptlab.i.ICirptlabRService;
import iih.ci.ord.s.bp.rpt.CiReportCommBP;

/**
 * 检验报告单录入节点自定义服务接口。
 * @author wu.junhui
 *
 */
public class CiRptLabServiceImpl implements ICiRptLabService {

	@Override
	public CirptlabAggDO getRptLabByReqNo(String reqNo) throws BizException {
		//◎ 根据检验申请单号查找检验报告单，如果能够找到直接返回检验报告单信息。
		CirptlabAggDO cirptlabAggDO = findRptLabByReqNo(reqNo);
		if (cirptlabAggDO != null) {
			return cirptlabAggDO;
		}
		
		//◎根据检验申请单号查找检验申请单，如果没找到直接返回空。
		OrdApLabDO ordApLabDO = findLabByReqNo(reqNo);
		if (ordApLabDO == null) {
			return null;
		}
		
		//◎根据检验申请单信息构造检验报告单并返回。
		cirptlabAggDO = new CirptlabAggDO();
		//--------主信息
		CiRptLabDO ciRptLabDO = new CiRptLabDO();
		cirptlabAggDO.setParentDO(ciRptLabDO);
		//申请单号
		ciRptLabDO.setNo_applyform(ordApLabDO.getNo_applyform());
		//检验申请单主键
		ciRptLabDO.setId_orlab(ordApLabDO.getId_orlab());
		//医嘱主键
		String orId = ordApLabDO.getId_or();
		ciRptLabDO.setId_or(orId);
		//设置就诊Id、就诊号、患者姓名
		Map<String,Object> entInfo = CiReportCommBP.findEntInfoByOrId(orId);
		if (entInfo != null) {
			ciRptLabDO.setId_ent((String)entInfo.get("id_ent"));
			ciRptLabDO.setEnt_code((String)entInfo.get("ent_code"));
			ciRptLabDO.setName_pat((String)entInfo.get("name_pat"));
		}
		
		//明细信息
		List<CiRptLabItmDO> rptLabItmDOList = new ArrayList<CiRptLabItmDO>();
		List<Map<String,Object>> labItems = findLabItems(ordApLabDO);
		int sortNo = 1;
		if (labItems != null) {
			for (Map<String,Object> labItem:labItems) {
				CiRptLabItmDO labItemDO = new CiRptLabItmDO();
				//检验项目服务
				labItemDO.setId_srv((String)labItem.get("id_srv"));
				labItemDO.setName_srv((String)labItem.get("name_srv"));
				//序号
				labItemDO.setSortno(sortNo);
				sortNo++;
				//最大值
				Object valMax = labItem.get("std_hi");
				if (valMax != null) {
					labItemDO.setVal_max(valMax.toString());
				}
				//最小值
				Object valMin = labItem.get("std_lo");
				if (valMin != null) {
					labItemDO.setVal_min(valMin.toString());
				}
				//参考值
				Object rptlabtpObj = labItem.get("sd_restrptlabtp");
				String rptLabType = null;
				if (rptlabtpObj == null) {
					rptLabType = IBdSrvDictCodeConst.SD_RSTRPTLABTP_NUM;
				} else {
					rptLabType = rptlabtpObj.toString();
				}
				String refVal = "";
				if (IBdSrvDictCodeConst.SD_RSTRPTLABTP_NUM.equals(rptLabType)
					&& valMin != null
					&& valMax != null) {
					refVal = valMin + "-" + valMax;
				} else if (IBdSrvDictCodeConst.SD_RSTRPTLABTP_COMB.equals(rptLabType)) {
					if (valMin != null) {
						refVal = valMin.toString();
					} else if (valMax != null) {
						refVal = valMax.toString();
					}
				}
				
				labItemDO.setVal_reference(refVal);	
				//单位
				labItemDO.setId_unit((String)labItem.get("id_unit_nuit"));
				labItemDO.setUnit_name((String)labItem.get("name_unit"));
				
				//检验结果值类型
				labItemDO.setSd_restrptlabtp(rptLabType);
				//检验结果值域
				if (IBdSrvDictCodeConst.SD_RSTRPTLABTP_COMB.equals(rptLabType)) {
					labItemDO.setVal_range((String)labItem.get("val_range"));
				}
				
				rptLabItmDOList.add(labItemDO);
			}
		}
		cirptlabAggDO.setCiRptLabItmDO(rptLabItmDOList.toArray(new CiRptLabItmDO[0]));
		
		return cirptlabAggDO;
	}
	
	private List<Map<String,Object>> findLabItems(OrdApLabDO ordApLabDO) throws BizException {
		String orId = ordApLabDO.getId_or();
		Map<String,Object> orInfo =  CiReportCommBP.findCiOrderInfoByOrId(orId);
		String strFgSet = (String)orInfo.get("fg_set");
		boolean fgSet = false;
		if("Y".equals(strFgSet)) {
			fgSet = true;
		} 
		String srvId = (String) orInfo.get("id_srv");
		
		StringBuffer sql = new StringBuffer();
		sql.append("select");
		sql.append("  srv.id_srv,");
		sql.append("  srv.name as name_srv,");
		sql.append("  lab.std_lo,");
		sql.append("  lab.std_hi,");
		sql.append("  lab.id_unit_nuit,");
		sql.append("  unit.name as name_unit,");
		sql.append("  lab.sd_restrptlabtp,");
		sql.append("  lab.val_restrptlab as val_range ");
		if (!fgSet) {
			sql.append("from ");
			sql.append("  BD_SRV_LAB lab");
			sql.append("  left join BD_SRV srv on lab.id_srv = srv.id_srv ");	
			sql.append("  left join Bd_Measdoc unit on lab.id_unit_nuit=unit.id_measdoc ");	
			sql.append("where ");
			sql.append("  srv.ds=0 ");
			sql.append("  and srv.id_srv='" + srvId + "' ");
		} else {
			sql.append("from ");
			sql.append("  CI_OR_SRV_SET srv_set ");
			sql.append("  left join BD_SRV srv on srv_set.id_srvset = srv.id_srv ");	
			sql.append("  left join BD_SRV_LAB lab on lab.id_srv = srv.id_srv ");	
			sql.append("  left join Bd_Measdoc unit on lab.id_unit_nuit=unit.id_measdoc ");
			sql.append("where ");
			sql.append("  srv_set.ds=0 ");
			sql.append("  and srv_set.id_srvsetdef='" + srvId + "' ");
			sql.append("  and srv_set.id_or ='" + orId + "' ");
			sql.append("  and srv_set.fg_clinical = 'Y' ");
			sql.append("order by srv_set.sortno ");
		}
		
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> result = (List<Map<String, Object>>) new DAFacade()
				.execQuery(sql.toString(), new MapListHandler());
		
		return result;		
	}
	
	private OrdApLabDO findLabByReqNo(String reqNo) throws BizException {
		StringBuffer whereStr = new StringBuffer();
		whereStr.append(" a0.no_applyform='" + reqNo + "'");
		ICiorapplisRService ciorapprisRService = ServiceFinder.find(ICiorapplisRService.class);
		OrdApLabDO[] ordApObsDOs = ciorapprisRService.find(whereStr.toString(), null, FBoolean.TRUE);
		
		if (ordApObsDOs == null || ordApObsDOs.length <= 0) {
			return null;
		}
		return ordApObsDOs[0];
	}
	
	/** 
	 * 根据检查申请单号获取检查申请单。
	 */
	private CirptlabAggDO findRptLabByReqNo(String reqNo) throws BizException {
		StringBuffer whereStr = new StringBuffer();
		whereStr.append(" a0.no_applyform='" + reqNo + "'");
		ICirptlabRService cirptlabRService = ServiceFinder.find(ICirptlabRService.class);
		CirptlabAggDO[] ciRptLabAggDOs = cirptlabRService.find(whereStr.toString(), null, FBoolean.FALSE);
		
		if (ciRptLabAggDOs == null || ciRptLabAggDOs.length <= 0) {
			return null;
		}
		return ciRptLabAggDOs[0];
	}
}
