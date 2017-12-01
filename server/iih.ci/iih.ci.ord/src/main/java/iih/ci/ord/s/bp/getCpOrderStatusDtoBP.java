/**
 * 
 */
package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.cporderstatusdto.d.CpOrderStatusDto;
import iih.ci.ord.s.bp.qry.GetCpOrderStatusDtoQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @ClassName: getCpOrderStatusDtoBP
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年3月10日 上午11:09:50
 * @Package iih.ci.ord.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getCpOrderStatusDtoBP {
  
	public String[] getCpOrderStatusDto(CpOrderStatusDto cpOrderStatus)throws BizException{
		if(cpOrderStatus ==  null || cpOrderStatus.getId_en() == null || cpOrderStatus.getCode_srv() == null) throw new BizException(" parameter :cpOrderStatus  is null or id_en is null");
		GetCpOrderStatusDtoQry qry = new GetCpOrderStatusDtoQry(cpOrderStatus);
		CiOrderDO[] rtn =  (CiOrderDO[])AppFwUtil.getDORstWithDao(qry, CiOrderDO.class);
		if(rtn == null ) return null;
		return getOrderStatus(rtn);
	}
	
	/**
	 * 
	 *  0 未开立（签署）
		1 已开立未签署（签署）
		2 已签署
		3 已执行
		<0- 错误码

	 * @param rtn
	 * @return
	 */
	private String[] getOrderStatus(CiOrderDO[] rtn){
		String [] status = new String[rtn.length];
		  int i = 0;
		 for(CiOrderDO ciorder: rtn){
			 if(ciorder.getSd_su_mp()== "3"){
				 status[i] = "3";
			 }else{
				
				 if(ICiDictCodeConst.SD_SU_OPEN.equals(ciorder.getSd_su_or())){
					 status[i] = "1";
				  }else if(ICiDictCodeConst.SD_SU_SIGN.equals(ciorder.getSd_su_or())
						  || ICiDictCodeConst.SD_SU_CHECKTHROUGH.equals(ciorder.getSd_su_or())
						  || ICiDictCodeConst.SD_SU_DOCTORSTOP.equals(ciorder.getSd_su_or())
						  || ICiDictCodeConst.SD_SU_CHECKSTOP.equals(ciorder.getSd_su_or())  ){
					  status[i] = "2";
				  }else if( ICiDictCodeConst.SD_SU_CANCEL.equals(ciorder.getSd_su_or())
						   ||ICiDictCodeConst.SD_SU_CHECKCANCEL.equals(ciorder.getSd_su_or())){
					  status[i] = "0";
				  }else{
					  status[i] = "-1"; 
				  }
				 
			 }
		 }
		return status;
		
	}
}
