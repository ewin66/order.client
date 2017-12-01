package iih.ci.ord.s.bp.base.relsrv;

import java.util.Map;

import iih.ci.ord.ems.d.UsageRelFeeSrvDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.qry.CiOrLisSrvVesselRelFeeQry;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.utils.AppFwUtil;
/**
 * 获得检验项目容器类型关联服务费用信息操作BP
 */
public class GetLisSrvVesselRelFeeSrvBP {
	/**
	 * 获得检验项目容器类型关联服务费用信息
	 * @param id_org
	 * @param id_scope_dept
	 * @param code_entp
	 * @param sd_specimenvesseltp
	 * @param reltype
	 * @return
	 * @throws BizException
	 */
	public UsageRelFeeSrvDO exec(String id_org,String id_scope_dept,String code_entp,String sd_specimenvesseltp,Integer reltype) throws BizException{
		//有效性校验
		if(!validateCheck(id_org,id_scope_dept,code_entp,sd_specimenvesseltp,reltype)) return null;
		
		//获得查询串并查询
		CiOrLisSrvVesselRelFeeQry qry = new CiOrLisSrvVesselRelFeeQry(id_org,id_scope_dept,code_entp,sd_specimenvesseltp,reltype);
		Map<String,Object> map=CiOrdUtils.getRsMap(qry.getQrySQLStr0());
		//UsageRelFeeSrvDO[] rtns = (UsageRelFeeSrvDO[])AppFwUtil.getDORstWithDao(qry, UsageRelFeeSrvDO.class);
		if(CiOrdUtils.isEmpty(map))return null;

		//返回
		return  getUsageRelFeeSrvDO(map);
		 
	}

	/**
	 * 获得返回值
	 * @param map
	 * @return
	 */	private UsageRelFeeSrvDO getUsageRelFeeSrvDO(Map<String,Object> map){	
		UsageRelFeeSrvDO rtn=new UsageRelFeeSrvDO();
		if(!CiOrdUtils.isEmpty(map.get("id_srv"))){
			rtn.setId_srv((String)map.get("id_srv"));
		}
		if(!CiOrdUtils.isEmpty(map.get("id_unit"))){
			rtn.setId_unit((String)map.get("id_unit"));
		}
		if(!CiOrdUtils.isEmpty(map.get("quan_medu"))){
			String quan_medu = map.get("quan_medu").toString();
			rtn.setQuan_medu(new FDouble(quan_medu));
		}
		if(!CiOrdUtils.isEmpty(map.get("reltype"))){
			rtn.setReltype((Integer)map.get("reltype"));
		}
		return rtn;
	}
	
	/**
	 * 有效性校验
	 * @param id_pi
	 * @param id_pv
	 * @param id_srvreact
	 * @return
	 */
	private boolean validateCheck(String id_org,String id_scope_dept,String code_entp,String sd_specimenvesseltp,Integer reltype){
		if(CiOrdUtils.isEmpty(id_org) || CiOrdUtils.isEmpty(code_entp) || CiOrdUtils.isEmpty(sd_specimenvesseltp))return false;
		return true;
	}
}
