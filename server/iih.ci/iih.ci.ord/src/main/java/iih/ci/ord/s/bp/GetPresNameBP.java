/**
 * 
 */
package iih.ci.ord.s.bp;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.recipedto.d.RecipeDTO;
import iih.ci.ord.s.bp.qry.GetPresNameQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @ClassName: GetPresNameBP
 * @Description:  医嘱的处方名称
 * @author Comsys-li_zheng
 * @date 2016年12月16日 上午11:49:39
 * @Package iih.ci.ord.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class GetPresNameBP {

	 public  FMap2 exec(String[] id_orsrvs)throws BizException{
		 FMap2 map = new FMap2();
		 GetPresNameQry qry = new GetPresNameQry(id_orsrvs);
		 OrdSrvDO[] Rtn = (OrdSrvDO[])AppFwUtil.getDORstWithDao(qry, OrdSrvDO.class);
		 if(Rtn != null && Rtn.length >0){
			for(OrdSrvDO srvdo:Rtn){
				map.put(srvdo.getId_orsrv(), srvdo.getName());
			} 
		 }
		 return map;
	 }
}
