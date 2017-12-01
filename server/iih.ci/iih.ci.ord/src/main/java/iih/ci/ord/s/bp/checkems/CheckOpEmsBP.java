package iih.ci.ord.s.bp.checkems;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.kernel.SqlParam;
import iih.ci.ord.ciordems.d.ext.CheckOpRstDTO;
import iih.ci.ord.ciordems.d.ext.CheckParamDTO;
import iih.ci.ord.ciordems.d.ext.CheckRstDTO;

public class CheckOpEmsBP {

	public CheckRstDTO exce(CheckParamDTO paramDto) throws BizException{
		CheckRstDTO rst=new CheckRstDTO();
		List<CheckOpRstDTO> rntlist=getReturnMsg(paramDto.getId_en(),paramDto.getSd_srvtp().substring(0, 2));
		if(rntlist!=null && rntlist.size()>0){
			FArrayList rtnmsg=new FArrayList();
			for(CheckOpRstDTO dto:rntlist){
				rtnmsg.add(dto);
			}
			rst.setRtnMsgList(rtnmsg);
		}
		return rst;
	}

	private List<CheckOpRstDTO> getReturnMsg(String id_en,String sd_srvtp) throws BizException{
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append("select A.Id_Or, A.Id_Srv, B.Dt_Plan, C.ctrl1 as eu_anesca" )
		.append("  from ci_order A" )
		.append("  left join ci_ap_sug B"  ) 
		.append("  on B.Id_Or = A.Id_Or"  ) 
		.append("  left join bd_udidoc C"  ) 
		.append("  on C.Id_Udidoc = B.Id_Anestp"  ) 
		.append("  where A.Fg_Canc = 'N'"  ) 
		.append("  and A.Sd_Su_Bl <> 2"  ) 
		.append("  and C.ctrl1='0'"  )
		.append("  and A.Sd_Srvtp like '")
		.append(sd_srvtp  )
		.append("%'"  )
		.append("  and A.Id_En='" )
		.append(id_en  )
		.append("'"  );
		
		
		DAFacade daf = new DAFacade();
		return (List<CheckOpRstDTO>)daf.execQuery(sqlSB.toString(), new BeanHandler(CheckOpRstDTO.class));
	}

}
