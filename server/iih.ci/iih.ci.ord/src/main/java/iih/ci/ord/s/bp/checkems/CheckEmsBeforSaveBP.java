package iih.ci.ord.s.bp.checkems;

import xap.mw.core.data.BizException;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciordems.d.ext.CheckParamDTO;
import iih.ci.ord.ciordems.d.ext.CheckRstDTO;

public class CheckEmsBeforSaveBP {
	
	public CheckRstDTO exec(CheckParamDTO paramDto) throws BizException{
		switch(paramDto.getSd_srvtp().substring(0, 2)){
		case IBdSrvDictCodeConst.SD_SRVTP_OP://手术
			CheckOpEmsBP bp=new CheckOpEmsBP();
			return bp.exce(paramDto);			
		}
		return null;
	}

}
