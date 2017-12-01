package iih.ci.ord.s.bp;

import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.s.bp.qry.GetConsPatListQry;
import iih.ci.ord.s.bp.qry.getDepsNumQry;
import iih.en.que.dto.d.MedTechAppDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;



public class getDepsNumBP {
	
	public String exec(String id_dep){
		
		getDepsNumQry qry = new getDepsNumQry(id_dep);
		Integer depnum=null;
		try {
			depnum = (Integer) new DAFacade()
			.execQuery(qry.getQrySQLStr(), qry.getQryParameter(null),
					new ColumnHandler());
		} catch (DAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(depnum>1)
		return "Y";
		else
			return "N";		
	}
	

}
