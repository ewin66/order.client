package iih.ci.ord.s.bp.validate;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

public class CiOrValidateBP {

	public CiOrValidateBP() {

	}

	public Boolean exec(CiorderAggDO[] aggors, String method)
			throws BizException {
		Boolean flag = true;
		switch (method) {
		case MethodConstants.CHECK_VALIDATE:
			flag=this.checkValidate(aggors);
			break;
		case MethodConstants.SAVE_VALIDATE:
			flag=this.saveValidate(aggors);
			break;

		case MethodConstants.CANCEL_VALIDATE:
			flag=this.cancelValidate(aggors);
			break;
		case MethodConstants.SIGN_VALIDATE:
			flag=this.signValidate(aggors);
			break;
		case MethodConstants.CANCEL_SIGN_VALIDATE:
			flag=this.cancelSignValidate(aggors);
			break;
		case MethodConstants.STOP_VALIDATE:
			flag=this.stopValidate(aggors);
			break;

		case MethodConstants.DELETE_VALIDATE:
			flag=this.deleteValidate(aggors);
			break;
		default:
			break;
		}
		return flag;

	}
	
	public Boolean checkValidate(CiorderAggDO[] aggors) throws BizException {
		Boolean flag = false;
		for (CiorderAggDO ciorderAggDO : aggors) {
			CiOrderDO cido = ciorderAggDO.getParentDO();
			
			 
	           
	            			if ((cido.getFg_sign() == FBoolean.TRUE&&cido.getFg_chk() == FBoolean.FALSE)) {

	            				flag = true;
	            				
	            			}else
	            			if ((cido.getFg_chk_canc() == FBoolean.FALSE&&cido.getFg_canc() == FBoolean.TRUE)) {
	            				
	            				flag = true;
	            				
	            			}
	            			else
	                    	if ((cido.getFg_chk_stop() == FBoolean.FALSE&&cido.getFg_canc() == FBoolean.FALSE&& cido.getFg_stop() == FBoolean.TRUE )) {
	                    				
	                    				flag = true;
	                    				
	                    	}
	                    
	                if(!flag)
	                	break;
	            }
		
		
		// 返回
				return flag;
	
		
		
	}
	//保存校验
	public Boolean saveValidate(CiorderAggDO[] aggors) throws BizException {
		Boolean flag = true;
		for (CiorderAggDO ciorderAggDO : aggors) {
			CiOrderDO cido = ciorderAggDO.getParentDO();
		//	if(cido.getfg)
		}
		// 返回
		return flag;
	}
	//作废校验
	public Boolean cancelValidate(CiorderAggDO[] aggors) throws BizException {
		Boolean flag = true;
		for (CiorderAggDO ciorderAggDO : aggors) {
			CiOrderDO cido = ciorderAggDO.getParentDO();
		if(!(cido.getFg_chk()==FBoolean.TRUE&&cido.getSd_su_mp().equals("0")&&cido.getFg_canc()==FBoolean.FALSE)){
			flag = false;
			break;
		}
		}
		// 返回
		return flag;
	}
	//签署校验
	public Boolean signValidate(CiorderAggDO[] aggors) throws BizException {
		Boolean flag = true;
		for (CiorderAggDO ciorderAggDO : aggors) {
			CiOrderDO cido = ciorderAggDO.getParentDO();
			if(cido.getFg_sign()==FBoolean.FALSE){
				flag = false;
				break;
			}
		}
		// 返回
		return flag;
	}
	//撤回签署校验
	public Boolean cancelSignValidate(CiorderAggDO[] aggors) throws BizException {
		Boolean flag = true;
		for (CiorderAggDO ciorderAggDO : aggors) {
			CiOrderDO cido = ciorderAggDO.getParentDO();
			if(!(cido.getFg_sign()==FBoolean.TRUE&&cido.getFg_chk()==FBoolean.FALSE)){
				flag = false;
				break;
			}
		}
		// 返回
		return flag;
	}
	//停止校验
	public Boolean stopValidate(CiorderAggDO[] aggors) throws BizException {
		Boolean flag = true;
		for (CiorderAggDO ciorderAggDO : aggors) {
			CiOrderDO cido = ciorderAggDO.getParentDO();
			if(!(cido.getFg_long()==FBoolean.TRUE&&cido.getFg_chk()==FBoolean.TRUE&&cido.getFg_canc()==FBoolean.FALSE&&cido.getDt_end().before(new FDateTime()))){
				flag = false;
				break;
			}
		}
		// 返回
		return flag;
	}
	//删除校验
	public Boolean deleteValidate(CiorderAggDO[] aggors) throws BizException {
		Boolean flag = true;
		for (CiorderAggDO ciorderAggDO : aggors) {
			CiOrderDO cido = ciorderAggDO.getParentDO();
			if(cido.getFg_sign()==FBoolean.TRUE){
				flag = false;
				break;
			}
		}
		// 返回
		return flag;
	}

}

