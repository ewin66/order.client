package iih.ci.ord.s.bp;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.s.bp.qry.GetOrderDrugsSplitDateNewQry;
import iih.ci.ord.s.bp.qry.GetOrderDrugsSplitDateQry;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 取得分方的数据
 * @author li_zheng
 *
 */
public class GetOrderDrugsSplitDateBP {
	
     /**
      *   取得分方的数据
      * @param id_en
      * @param id_pat
      * @return rtn
      * @throws BizException
      */
     @Deprecated
	 public  OrderPresSplitDTO[] exec(String id_en,String id_pat) throws BizException{ 
		 if(id_en == null || id_pat == null )return null;
		 GetOrderDrugsSplitDateQry qry = new GetOrderDrugsSplitDateQry(id_en,id_pat);
		 OrderPresSplitDTO rtn[] = (OrderPresSplitDTO[])AppFwUtil.getDORstWithDao(qry, OrderPresSplitDTO.class);
		 return  rtn;
	 }
	 
	 /**
	  * 门诊的分方
      *   取得分方的数据
      * @param id_en
      * @param id_pat
      * @return rtn
      * @throws BizException
      */
     
	 public  OrderPresSplitDTO[] execnew(CiOrderDO[] ciorder,String code_entp) throws BizException{ 
		 if(ciorder==null && ciorder.length==0 )return null;
			StringBuilder builder = new StringBuilder();
			Boolean first = true;
			for (CiOrderDO ci : ciorder) {
				if (first) {
					first = false;
				} else {
					builder.append(',');
				}
				builder.append(String.format("'%s'", ci.getId_or()));

			}
		 GetOrderDrugsSplitDateNewQry qry = new GetOrderDrugsSplitDateNewQry(ciorder[0].getId_en(),builder.toString(),code_entp);
		 OrderPresSplitDTO rtn[] = (OrderPresSplitDTO[])AppFwUtil.getDORstWithDao(qry, OrderPresSplitDTO.class);
		 return  rtn;
	 }
}
