package iih.ci.ord.s.bp;

import iih.ci.ord.cirptobs.d.CiRptObsDO;
import iih.ci.ord.dto.d.LabDTO;
import iih.ci.ord.s.bp.qry.getLabItmsQry;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

public class getLabItmsBP {
	
	public LabDTO[] exec(String idpat, int num, String[] srvlist) throws BizException{
		FDateTime ft=new FDateTime();
		FDateTime ft2=ft.getDateTimeBefore(num);
		StringBuilder sb=new StringBuilder();
		Boolean flag=true;
		for (String s : srvlist) {
			if(flag){
				flag=false;
			}else{
			     sb.append(",");
			}
			sb.append(String.format("'%s'", s));
		}
		getLabItmsQry qry=new getLabItmsQry(idpat,sb.toString(),ft.toString(),ft2.toString());
		LabDTO[] rtn =  (LabDTO[])AppFwUtil.getDORstWithDao(qry, LabDTO.class);
		 return rtn;

		}

}
