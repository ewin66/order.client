package iih.ci.ord.s.bp;

import iih.ci.ord.dto.outdeptcheckorder.d.OutDeptCheckOrderDTO;
import iih.ci.ord.s.bp.qry.OutDeptCheckOrderQry;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class OutDeptCheckOrderBP {

	/**
	 * 
	 * @param id_en
	 * @return  OutDeptCheckOrderDTO[]
	 * @throws BizException
	 */
	public   OutDeptCheckOrderDTO[] exec(String id_en)throws BizException{
		  if(StringUtils.isBlank(id_en))return null;
			OutDeptCheckOrderQry pqr  =new OutDeptCheckOrderQry(id_en);
			OutDeptCheckOrderDTO[] rnt = (OutDeptCheckOrderDTO[])AppFwUtil.getDORstWithDao(pqr, OutDeptCheckOrderDTO.class);
		    // 判断 一条医嘱 多个项目  时 拼接 执行科室   TODO
			
			
			return rnt;
	}
}
