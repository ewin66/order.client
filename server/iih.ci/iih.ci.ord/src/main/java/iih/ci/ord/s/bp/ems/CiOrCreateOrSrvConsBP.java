/**
 * 
 */
package iih.ci.ord.s.bp.ems;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.CiordInviteConsDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;

/**
 * @ClassName: CiOrCreateOrSrvConsBP
 * @Description: 生成会诊的医嘱项目信息
 * @author Comsys-li_zheng
 * @date 2016年6月3日 下午5:33:26
 * @Package iih.ci.ord.s.bp.ems
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class CiOrCreateOrSrvConsBP {
    /**
     * 会诊医嘱，项目的集合，邀请科室（一个科室一条服务项目，邀请多个科室多条服务项目）
     * @param ems
     * @param orsrvdos
     * @return
     * @throws BizException
     */
	public OrdSrvDO[] exe(CiEmsDTO ems,OrdSrvDO[] orsrvdos) throws BizException{
		FMap map = ems.getOrapplysheet();
		if(orsrvdos == null) return null;
	    if(map == null) return orsrvdos;
		List<OrdSrvDO> list = new ArrayList<OrdSrvDO>();
		CiorappconsultAggDO  agg= (CiorappconsultAggDO)map.get(EmsType.CONS+"");
		if(agg != null  ){
		 CiordInviteConsDO[] inviteCons=agg.getCiordInviteConsDO();
		  for(CiordInviteConsDO item:inviteCons){
			  if(item.getId_dep() != null){
				for(OrdSrvDO srvDO:orsrvdos){
					//String[] ids = new DBUtil().getOIDs(1);
					OrdSrvDO srv=  this.createSrvDO(srvDO, item.getId_dep());
				    // srvDO.setId_orsrv(ids[0]);
					 list.add(srv);
				 } 
				  
			   }
		  }
		}else{
			return orsrvdos;
		}
	
		return list.toArray(new OrdSrvDO[list.size()]);
	}
	
    /**
     * 
     * @param srvDO  医嘱项目对象
     * @param Id_dep_mp  执行科室
     * @return
     * @throws BizException
     */
	private OrdSrvDO createSrvDO(OrdSrvDO srvDO,String Id_dep_mp)throws BizException{
		if(srvDO.getId_or() == null){
			OrdSrvDO NewSrvDO = new OrdSrvDO();
			 try {
				org.apache.commons.beanutils.BeanUtils.copyProperties(NewSrvDO, srvDO);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 NewSrvDO.setFg_feertnable(FBoolean.TRUE);
			 NewSrvDO.setStatus(DOStatus.NEW);
			 NewSrvDO.setId_dep_mp(Id_dep_mp);
			
			 //以上暂时注释
			//srvDO.setStatus(DOStatus.NEW);
			//srvDO.setId_dep_mp(Id_dep_mp);
			return NewSrvDO;
		}else if(srvDO.getId_or() != null && srvDO.getStatus() !=DOStatus.DELETED){
			srvDO.setId_dep_mp(Id_dep_mp);
			srvDO.setStatus(DOStatus.UPDATED);
			return srvDO;
		}
		return null;
	}
}
