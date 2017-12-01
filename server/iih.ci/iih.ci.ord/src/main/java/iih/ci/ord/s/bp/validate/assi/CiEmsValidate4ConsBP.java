package iih.ci.ord.s.bp.validate.assi;

import java.util.List;

import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.CiordInviteConsDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.s.bp.validate.assi.common.BaseEmsValidate4OtherBP;

/**
 * 会诊医疗单有效性检查
 * @author lxy
 *
 */
public class CiEmsValidate4ConsBP extends BaseEmsValidate4OtherBP {

	@Override
	public boolean exec(CiEmsDTO emsDTO,List<String> errorList) {

		CiorappconsultAggDO agg=(CiorappconsultAggDO)emsDTO.getOrapplysheet().get(EmsType.CONS) ;
		if(agg!=null){
			CiordInviteConsDO[] invitelist=agg.getCiordInviteConsDO();
			if(invitelist.length!=0){
				boolean flag=false;
				for(CiordInviteConsDO invite:invitelist){
					if(("").equals(invite.getId_dep()) || invite.getId_dep().equals(null))flag=true;
				}
				if(flag)errorList.add("请填写受邀科室！！");
			}else{
				errorList.add("缺少会诊受邀方信息！");
			}
		}

		return errorList.size()==0;
	}


}
