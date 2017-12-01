package iih.ci.ord.s.bp;

import iih.bd.srv.ortpl.d.OrTplItmDO;
import iih.bd.srv.ortpl.d.OrTplItmDtDO;
import iih.bd.srv.ortpl.d.OrTplItmSetDO;
import iih.bd.srv.ortpl.d.SrvortplitemAggDO;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.CiOrContentManager;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/*
 * 医嘱模板 保存操作BP
 */
public class OrTplItemSaveBP {
	/**
	 * 医嘱模板保存
	 * @param aggdos
	 * @throws BizException
	 */
	public void exec(SrvortplitemAggDO[] aggdos) throws BizException{
		if(aggdos==null || aggdos.length==0)return;
		createOrdContent(aggdos);
		CiOrdAppUtils.getISrvortplitemCudService().save(aggdos);
	}
	/**
	 * 创建医嘱内容
	 * @param aggdos
	 * @throws BizException 
	 */
	public void createOrdContent(SrvortplitemAggDO[] aggdos) throws BizException{
		for(int i=0;i<aggdos.length;i++){
			SrvortplitemAggDO aggdo = aggdos[i];
			OrTplItmDO itemDo = aggdo.getParentDO();
			CiEmsDTO ems = new CiEmsDTO();
			ems.setSd_srvtp(itemDo.getSd_srvtp());
			ems.setOrders(0);
			FArrayList farray = new FArrayList();
			if(itemDo.getFg_set()!=null&&itemDo.getFg_set().booleanValue()){
				OrTplItmSetDO[] setdoArr = aggdo.getOrTplItmSetDO();
				for(int j=0;setdoArr!=null&&j<setdoArr.length;j++)
				{
					OrTplItmSetDO setDo = setdoArr[j];
					CiEmsSrvDTO item = new CiEmsSrvDTO();
					item.setName_srv(setDo.getName_srv());
					farray.add(item);
				}
			}else if(itemDo.getFg_set()!=null&&!itemDo.getFg_set().booleanValue())
			{
				OrTplItmDtDO[] dtdoArr = aggdo.getOrTplItmDtDO();
				for(int j=0;dtdoArr!=null&&j<dtdoArr.length;j++)
				{
					OrTplItmDtDO dtDo = dtdoArr[j];
					CiEmsSrvDTO item = new CiEmsSrvDTO();
					item.setName_srv(dtDo.getName_srv());
					item.setQuan_med(dtDo.getQuan_med());
					item.setName_unit_med(dtDo.getName_unit_med());
					farray.add(item);
					ems.setName_route(dtDo.getName_route());
					ems.setName_freq(dtDo.getName_freq());
					ems.setName_routedes(dtDo.getName_route());
				}
			}else{
				continue;
			}
			ems.setEmssrvs(farray);
			itemDo.setContent_or(CiOrContentManager.getCiOrContentStr(ems));
		}
	}
}
