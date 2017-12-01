package iih.ci.ord.s.bp.validate.assi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.dto.d.SkinTestParamDTO;
import iih.ci.ord.dto.d.SkinTestRstDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.bp.validate.assi.common.BaseEmsValidate4OtherBP;
import iih.ci.ord.s.bp.validate.assi.common.CanCombDrugValidateBP;
import iih.pi.overview.overview.d.PiPatDO;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 西成药检查
 * @author qzwang
 *
 */
public class CiEmsValidate4DrugBP extends BaseEmsValidate4OtherBP {

	@Override
	public boolean exec(CiEmsDTO emsDTO,List<String> errorList) throws BizException {
		// TODO Auto-generated method stub
		
		super.exec(emsDTO,errorList);
		
		// 检查成组药品
		checkCombDurgInfo(emsDTO,errorList);
		
		//皮试医嘱判断逻辑
		checkSrvSkinLogic(emsDTO,errorList);
		
		// 频次信息检查
		checkSrvFreqInfo(emsDTO,errorList);
		
		// 用法信息检查
		checkSrvRouteInfo(emsDTO, errorList);

		// 空药品
		checkEmptyDrugInfo(emsDTO.getEmssrvs(),errorList);
		
		// 药品重复检查
		checkSameDrugInfo(emsDTO.getEmssrvs(),errorList);
		
		// 剂|总量必须大于0
		checkDrugQuanInfo(emsDTO.getEmssrvs(),errorList);
		
		// 用药天数必须大于0
		checkUseDayInfo(emsDTO,errorList);
		
		return errorList.size() == 0;
	}

	private void checkSrvSkinLogic(CiEmsDTO emsDTO,List<String> errorList) throws BizException {
		FArrayList emssrvs =  emsDTO.getEmssrvs();
		for(int i=0;i<emssrvs.size();i++){
			CiEmsSrvDTO emssrv = (CiEmsSrvDTO)emssrvs.get(i);
			if(emssrv.getFg_skintest()!=FBoolean.TRUE) continue;
			SkinTestParamDTO param = new SkinTestParamDTO();
	        param.setId_mm(emssrv.getId_mm());
	        param.setId_org(emsDTO.getId_org()); 
	        param.setId_pi(emsDTO.getId_pat());
	        PatDO piPatDO = CiOrdAppUtils.getIPatiMDORService().findById(emsDTO.getId_pat());
	        if(piPatDO!=null)param.setDt_birth(piPatDO.getDt_birth());
	        param.setId_srv(emssrv.getId_srv());
	        param.setId_skinsrv(emssrv.getId_srvskin());
	        SkinTestRstDTO retDTO = CiOrdAppUtils.getCiOrdQryService().skinTestLogicMainBP(param);
	        String code = String.valueOf(retDTO.getAllergicpharmhandlemode());
	        //禁用
	        if (code.equals("0"))
	        {
	        	new BizException("患者于" + retDTO.getDt_act() + "对" + emssrv.getName_mm() + "过敏！");
	        }//再皮试1;皮试逻辑，3
	        else if (code.equals("1") || code.equals("3"))
	        {
	        	emssrv.setSd_reltp(ICiDictCodeConst.CODE_SKIN_SKIN);
	        	emssrv.setFg_skintest(FBoolean.TRUE);
	        }//强制使用2
	        else if (code.equals("2"))
	        {
	        	//强制使用需要医生填写强制使用原因，要抛到前台去
	        	errorList.add("强制使用需要医生填写强制使用原因，要抛到前台去");
	        	//emssrv.setSd_reltp(ICiDictCodeConst.CODE_SKIN_FORCEUSE);
	        	//emssrv.setFg_skintest(FBoolean.FALSE);
	        }//直接使用，不皮试4
	        else if (code.equals("4"))
	        {
	            emssrv.setSd_reltp(ICiDictCodeConst.CODE_SKIN_FORCEUSE);
	            emssrv.setFg_skintest(FBoolean.FALSE);
	        }//测试了，未出结果5
	        else if (code.equals("5"))
	        {
	            emssrv.setSd_reltp(ICiDictCodeConst.CODE_SKIN_NORESULT);
	            emssrv.setFg_skintest(FBoolean.TRUE);
	            emssrv.setId_or_rel(retDTO.getId_skinor());
	        }
		}
		
	}
	
	
}
