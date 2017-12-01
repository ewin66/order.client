package iih.ci.ord.s.bp;

import iih.ci.ord.dto.orobsandlab.d.OrObsAandLabDTO;
import iih.ci.ord.s.bp.qry.getObsAndLabListQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;

public class getObsAndLabListBP {
	
	 /**
     * 检查 检验报告的类别分类数据
     * @param id_ent
     * @return OrObsAandLabDTO[]
     * @throws BizException
     */
   public  OrObsAandLabDTO[] exec(String id_ent,String type)throws BizException{
	   if(id_ent != null && id_ent !="" && type != null && type != "")
	   {
		   //DAFacade daFacade = new DAFacade();
		  
		   getObsAndLabListQry qry = new getObsAndLabListQry(id_ent,type);
		   OrObsAandLabDTO[] rnt = (OrObsAandLabDTO[])AppFwUtil.getDORstWithDao(qry, OrObsAandLabDTO.class);
	       return rnt;
	   }
	   return  null;
   }
	 /**
    * 检查 检验报告的时间分类数据
    * @param id_ent
    * @return OrObsAandLabDTO[]
    * @throws BizException
    */
   public  OrObsAandLabDTO[] execDateList(String id_ent,String type)throws BizException{
	   if(id_ent != null && id_ent !="" && type != null && type != "")
	   {
		   getObsAndLabListQry qry = new getObsAndLabListQry(id_ent,type);
		   OrObsAandLabDTO[] rnt = (OrObsAandLabDTO[])AppFwUtil.getDORstWithDao(qry, OrObsAandLabDTO.class);
	       return rnt;
	   }
	   return  null;
   }
}
