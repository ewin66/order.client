/**
 * 
 */
package iih.ci.ord.s.bp;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.dto.orsrvguide.d.OrSrvGuideDTO;
import iih.ci.ord.s.bp.qry.getOrSrvGuideDTOQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @ClassName: getOrSrvGuideDTOBP
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年4月6日 下午4:43:16
 * @Package iih.ci.ord.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getOrSrvGuideDTOBP {

 public   OrSrvGuideDTO[] getOrSrvGuideDTO( String[] id_orsrv)throws BizException{
	      getOrSrvGuideDTOQry qry = new getOrSrvGuideDTOQry(id_orsrv);
	     OrSrvGuideDTO[] rtn = (OrSrvGuideDTO[]) AppFwUtil.getDORstWithDao(qry,OrSrvGuideDTO.class);
		return rtn;
	 }
}
