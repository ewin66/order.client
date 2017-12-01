package iih.ci.ord.s.bp.base.hp;

import iih.bd.pp.hp.i.IHpExtService;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.i.IHpsrvorcaRService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 在对应医疗保险计划下，获得服务所属目录数据信息操作BP
 * 多个服务的情形
 * <String,HpSrvOrCaDO>
 */
public class GetHpCatalogInfo4SrvsBP {
	/**
	 * 在对应医疗保险计划下，获得服务所属目录数据信息
	 * <String,HpSrvOrCaDO>
	 * @param id_hp
	 * @param id_srvs
	 * @return
	 * @throws BizException
	 */
	public FMap exec(String id_hp, String[] id_srvs)  throws BizException{
		//有效性校验
		if(!validateCheck(id_hp,id_srvs))return null;
		
		//参数设置
		 
		HPSrvorcaDO hpdo=null;
		FMap map=new FMap();
		
		//遍历
		for(String id_srv:id_srvs){
			hpdo=findHp(id_hp,id_srv);
			if(CiOrdUtils.isEmpty(hpdo))continue;
			map.put(id_srv, hpdo);
		}
		
		//返回
		return map;
	}
	public   HPSrvorcaDO findHp(String id_hp, String id_Srv) throws BizException{
		IHpsrvorcaRService hpService=(IHpsrvorcaRService)ServiceFinder.find(IHpsrvorcaRService.class.getName());
		//return hpService.getHpSrvTpByCode(hpCode,id_Srv)
		String whereStr = HPSrvorcaDO.ID_HP +"='"+id_hp+"' and  "+ HPSrvorcaDO.ID_SRV +" ='"+id_Srv+"'";
		HPSrvorcaDO[] orca =  hpService.find(whereStr,HPSrvorcaDO.ID_HPSRVTP,FBoolean.FALSE);
		if(orca != null && orca.length >0){
			return orca[0];
		}else{
			throw new BizException("没有找医保信息");
		}
	}
	/**
	 * 有效性校验
	 * @param id_hp
	 * @param id_srvs
	 * @return
	 */
	private boolean validateCheck(String id_hp, String[] id_srvs){
		if(CiOrdUtils.isEmpty(id_hp) || CiOrdUtils.isEmpty(id_srvs))return false;
		return true;
	}
	
//	select * from bd_hp_srvorca AA left outer join bd_srvca BB ON AA.Id_Srvca=BB.Id_Srvca
//			where AA.Id_Hp='0001AA100000000AB6VP' and AA.Eu_Srvorca=0 and instr((select srvca_innercode from bd_srv where id_srv='0001AA1000000008GRPC'),BB.Innercode)=1;
	
}
