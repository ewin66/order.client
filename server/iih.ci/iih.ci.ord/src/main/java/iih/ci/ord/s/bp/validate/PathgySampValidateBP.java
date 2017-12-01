package iih.ci.ord.s.bp.validate;

import java.util.HashMap;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.i.ICiorapppathgyRService;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/*
 * 病理标本项目非空检查操作BP
 */
public class PathgySampValidateBP {
	/**
	 * 病理标本项目非空检查
	 * @throws BizException
	 */
	public void exec(CiorderAggDO[] aggors) throws BizException{
		Map<String,CiorderAggDO> mapAggDO=new HashMap<String,CiorderAggDO>();
		String strId = "";
		for (CiorderAggDO aggor : aggors) {
			if(aggor != null && aggor.getParentDO().getSd_srvtp().equals(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)){
				mapAggDO.put(aggor.getParentDO().getId_or(), aggor);
				strId += "'" + aggor.getParentDO().getId_or() + "',";
			}
		}
		if (mapAggDO.size() > 0) {
			ICiorapppathgyRService service = ServiceFinder.find(ICiorapppathgyRService.class);
			CiorapppathgyAggDO[] pathgys = service.find(" id_or in(" + strId.substring(0, strId.length() - 1) + ")",
					"", FBoolean.FALSE);
			if(!CiOrdUtils.isEmpty(pathgys)){
				String strPathgyName = "";
				for (CiorapppathgyAggDO pathgy : pathgys) {
					if (pathgy != null && pathgy.getChildrenDO().length <= 0)
						strPathgyName += "【" + mapAggDO.get(pathgy.getParentDO().getId_or()).getParentDO().getName_or() + "】,";
				}
				if (strPathgyName.length() > 0)
					throw new BizException(strPathgyName.substring(0, strPathgyName.length() - 1) + "没有标本信息，不可签署！");
        	}
		}
	}
}
