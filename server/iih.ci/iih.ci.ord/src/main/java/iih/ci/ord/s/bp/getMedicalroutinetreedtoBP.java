/**
 * 
 */
package iih.ci.ord.s.bp;

import iih.ci.ord.dto.appobsdto.d.AppObsDto;
import iih.ci.ord.dto.medicalroutinetreedto.d.Medicalroutinetreedto;
import iih.ci.ord.s.bp.qry.GetMedicalroutinetreedtoQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @ClassName: getMedicalroutinetreedtoBP
 * @Description: 医技常规模板
 * @author Comsys-li_zheng
 * @date 2016年10月27日 下午8:48:19
 * @Package iih.ci.ord.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getMedicalroutinetreedtoBP {

	public  Medicalroutinetreedto[] exce(String _entp) throws BizException{
			GetMedicalroutinetreedtoQry qry = new GetMedicalroutinetreedtoQry();
			qry.exec(_entp);
			Medicalroutinetreedto[] rtn = (Medicalroutinetreedto[])AppFwUtil.getDORstWithDao(qry, Medicalroutinetreedto.class);
			return rtn;
	
	}
}
