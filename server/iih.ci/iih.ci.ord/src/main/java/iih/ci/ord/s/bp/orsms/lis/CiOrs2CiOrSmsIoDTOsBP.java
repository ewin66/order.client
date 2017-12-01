package iih.ci.ord.s.bp.orsms.lis;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.desc.OrdApLabDODesc;
import iih.ci.ord.cior.i.ICiorapplisRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.orsms.d.CiLisOrInfo4Sms;
import iih.ci.ord.pub.CiOrdUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 分方医嘱格式化为分方数据DTO操作BP
 */
public class CiOrs2CiOrSmsIoDTOsBP {
	/**
	 * 分方医嘱格式化为分方数据DTO
	 * @param ciors
	 * @return
	 * @throws BizException
	 */
	public CiLisOrInfo4Sms[] exec(CiOrderDO[] ciors)throws BizException{
		//获得医嘱集合对应的ID_or主键标识sql串片段
		ciors=handleLisOr(ciors);
		if(CiOrdUtils.isEmpty(ciors))return null;
			
		Map<String,OrdApLabDO> lisdos= getOrAps(ciors);
		List<CiLisOrInfo4Sms> smslist=new ArrayList<>();
		for (CiOrderDO lisor : ciors) {
			CiLisOrInfo4Sms sms=new CiLisOrInfo4Sms();
			sms.setOrdo(lisor);
			sms.setOrlisapdo(lisdos.get(lisor.getId_or()));
			smslist.add(sms);
		}
		 return  smslist.toArray(new CiLisOrInfo4Sms[0]);
	}
	
	private CiOrderDO[] handleLisOr(CiOrderDO[] ciors){
		
		List<CiOrderDO> orlist=new ArrayList<>();
		for (CiOrderDO ciOrderDO : ciors) {
			if(ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)){
				orlist.add(ciOrderDO);
			}
		}
		if(orlist.isEmpty())return null;
		
		return orlist.toArray(new CiOrderDO[0]);
	}
	
	private Map<String,OrdApLabDO> getOrAps(CiOrderDO[] ciors) throws BizException{
		Map<String,OrdApLabDO> map=new HashMap<String, OrdApLabDO>();
		String id_ors=getIdOrsSqlStr(ciors);
		ICiorapplisRService service=ServiceFinder.find(ICiorapplisRService.class);
		String filter=OrdApLabDODesc.TABLE_ALIAS_NAME+".id_or in("+id_ors+") ";
		OrdApLabDO[] lisdos=service.find(filter, null, FBoolean.FALSE);
		for (OrdApLabDO ordApLabDO : lisdos) {
			map.put(ordApLabDO.getId_or(), ordApLabDO);
		}
		return map;
		
	}
	
	/**
	 * 获得医嘱集合对应的ID_or主键标识sql串片段
	 * @param ciors
	 * @return
	 */
	private String getIdOrsSqlStr(CiOrderDO[] ciors){
		if(ciors==null && ciors.length==0 )return null;
		StringBuilder builder = new StringBuilder();
		Boolean first = true;
		for (CiOrderDO ci : ciors) {
			if (first) {
				first = false;
			} else {
				builder.append(',');
			}
			builder.append(String.format("'%s'", ci.getId_or()));
		}
		
		return builder.toString();
	}
	

	
}
