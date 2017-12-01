package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.i.ICiorappbtMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.pub.CiOrPubUtils;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

public class UseBtOrNumMarginBuValidateBP {
	public void exe(CiorderAggDO[] aggors) throws BizException{
		//1、筛选出用血医疗单,用血医疗单按照同一个备血医嘱分组
		Map<String,List<OrdSrvDO>> map = getTeamCiOrder(aggors);
		//3、判断每一组用血申请量的总和与对应备血医嘱的可用血余量
		if(map.isEmpty()){
			return;
		}
		OrdApBtDO[] apbtArray = getOrdApBtDO(map);
		
		for(OrdApBtDO apbtdo : apbtArray){
			String btIdOr = apbtdo.getId_or();
			List<OrdSrvDO> orderDoList = map.get(btIdOr);
			FDouble quanCur = new FDouble(0);
			String srv_names = "";
			for(OrdSrvDO ordSrvDO : orderDoList){
				FDouble quanMedu = ordSrvDO.getQuan_medu();
				quanCur = quanCur.add(quanMedu);
				srv_names+=("【"+ordSrvDO.getName_srv()+"】,");
			}
			
			if(!CiOrdUtils.isEmpty(apbtdo.getNum_margin_bu())&&apbtdo.getNum_margin_bu().toDouble() < quanCur.toDouble()){
				throw new BizException("服务项目"+srv_names+"可用血余量不足！");
			}
		}
	}
	/**
	 * 筛选出用血医疗单,用血医疗单按照同一个备血医嘱分组
	 * @param aggors
	 * @return
	 * @throws BizException
	 */
	private Map<String,List<OrdSrvDO>> getTeamCiOrder(CiorderAggDO[] aggors) throws BizException{
		Map<String,List<OrdSrvDO>> map = new HashMap<String,List<OrdSrvDO>>();
		for(CiorderAggDO orAggDo : aggors){
			CiOrderDO ordo = orAggDo.getParentDO();
			if (IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE.equals(ordo.getSd_srvtp())){
				if(!CiOrdUtils.isEmpty(ordo.getId_or_rel())){
					if(map.containsKey(ordo.getId_or_rel())){
						map.get(ordo.getId_or_rel()).add(orAggDo.getOrdSrvDO()[0]);
					}else{
						List<OrdSrvDO> buBtOrAggDos = new ArrayList<OrdSrvDO>();
						buBtOrAggDos.add(orAggDo.getOrdSrvDO()[0]);
						map.put(ordo.getId_or_rel(), buBtOrAggDos);
					}
				}else{
					throw new BizException("");
				}
			}
		}
		return map;
	}
	private OrdApBtDO[]  getOrdApBtDO(Map<String,List<OrdSrvDO>> map) throws BizException{
		Set<String> keySet = map.keySet();
		StringBuffer ids = new StringBuffer();
		int i=0;
		for(String key : keySet){
			ids.append("'"+key+"'");
			if(i!=keySet.size()-1){
				ids.append(",");
			}
			i++;
		}
		ICiorappbtMDORService btService = CiOrdAppUtils.getICiorappbtMDORService();
		OrdApBtDO[] apbtArray = btService.find(String.format("id_or in (%s)", ids), "", FBoolean.FALSE);
		return apbtArray;
	}
}
