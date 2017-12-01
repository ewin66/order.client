package iih.ci.ord.s.bp.validate.assi;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.s.bp.validate.assi.common.BaseEmsValidate4OtherBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检查医疗单有效性检查
 * @author qzwang
 *
 */
public class CiEmsValidate4RisBP extends BaseEmsValidate4OtherBP {

	@Override
	public boolean exec(CiEmsDTO emsDTO,List<String> errorList) throws BizException {
		// TODO Auto-generated method stub
		super.exec(emsDTO, errorList);
		
		// 检查总次数
		checkTimesCurInfo(emsDTO, errorList);
		
		// 患者信息和就诊信息
		checkPatDiInfo(emsDTO, errorList);
		
		// 检查执行科室信息
		checkDepInfo(emsDTO, errorList);
		
		// 申请单错误检查
		checkApplySheetInfo(emsDTO, errorList);
		
		// 服务套单选模式开立判断
		checkSetRatio(emsDTO, errorList);
		
		return errorList.size() == 0;
	}
	
	private void checkSetRatio(CiEmsDTO ems, List<String> errorList) throws BizException{
		MedSrvDO medSrv = ServiceFinder.find(IMedsrvMDORService.class).findById(ems.getId_srv());
		
		if (medSrv!= null && medSrv.getFg_setradio() == FBoolean.TRUE){
			errorList.add(String.format("【%s】为服务套单选模式，必须由医生选择套内项目", medSrv.getName()));
		}
	}
	
	private void checkPatDiInfo(CiEmsDTO ems, List<String> errorList){
		if (StringUtil.isEmpty(ems.getId_en())||
				StringUtil.isEmpty(ems.getId_entp())||
				StringUtil.isEmpty(ems.getId_pat()))
		{
			errorList.add("医疗单就诊相关信息不完整，请重新检查");
		}
	}
	
	private void checkDepInfo(CiEmsDTO ems, List<String> errorList){
		if (StringUtil.isEmpty(ems.getId_dep_mp())||
				StringUtil.isEmpty(ems.getName_dep_mp()))
		{
			errorList.add("执行科室信息不完整，请重新检查");
		}
	}
	
	private void checkTimesCurInfo(CiEmsDTO ems, List<String> errorList){
		if (ems.getTimes_cur().intValue() == 0){
			errorList.add("检查次数必须大于 0");
		}
	}
	
	private void checkApplySheetInfo(CiEmsDTO ems, List<String> errorList){
		FMap mapApplySheet = ems.getOrapplysheet();
		if (null != mapApplySheet && mapApplySheet.containsKey(EmsType.RIS.toString())){
			OrdApObsDO objOrdApObs = (OrdApObsDO) mapApplySheet.get(EmsType.RIS.toString());
			
			if (StringUtil.isEmpty(objOrdApObs.getId_di())||
					StringUtil.isEmpty(objOrdApObs.getName_di())){
				errorList.add("诊断信息不完整，请重新检查");
			}
			
			if (StringUtil.isEmpty(objOrdApObs.getNo_applyform())){
				errorList.add("没有申请单号，请重新检查");
			}
			
			if (StringUtil.isEmpty(objOrdApObs.getName_pps())||
					StringUtil.isEmpty(objOrdApObs.getId_pps())||
					StringUtil.isEmpty(objOrdApObs.getSd_pps())|| StringUtils.isEmpty(objOrdApObs.getDes_pps())){
				errorList.add("检查目的信息不完整");
			}
		}
		
	}

}
