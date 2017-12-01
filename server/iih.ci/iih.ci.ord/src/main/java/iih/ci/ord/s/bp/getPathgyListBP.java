package iih.ci.ord.s.bp;

import iih.ci.ord.ordappathgy.d.OrdApPathgyDTO;
import iih.ci.ord.s.bp.qry.getPathgyListQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class getPathgyListBP {
	
	 /**
     * 病理报告的类别分类数据
     * @param id_ent
     * @return OrObsAandLabDTO[]
     * @throws BizException
     */
   public  OrdApPathgyDTO[] exec(String id_ent)throws BizException{
	   if(id_ent != null && id_ent !="" )
	   {
		  
		   getPathgyListQry qry = new getPathgyListQry(id_ent);
		   OrdApPathgyDTO[] rnt = (OrdApPathgyDTO[])AppFwUtil.getDORstWithDao(qry, OrdApPathgyDTO.class);
	       return rnt;
	   }
	   return  null;
   }

}
