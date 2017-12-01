package iih.ci.ord.s.bp.validate.assi;

import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.s.bp.validate.assi.common.BaseEmsValidate4OtherBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检验医疗单检查
 * @author qzwang
 *
 */
public class CiEmsValidate4LisBP extends BaseEmsValidate4OtherBP {

	@Override
	public boolean exec(CiEmsDTO emsDTO,List<String> errorList) throws BizException {
		// TODO Auto-generated method stub
		super.exec(emsDTO, errorList);
		
		// 患者信息和就诊信息
		checkPatDiInfo(emsDTO, errorList);
		
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
	
	private void checkApplySheetInfo(CiEmsDTO ems, List<String> errorList){
		
	}

}
