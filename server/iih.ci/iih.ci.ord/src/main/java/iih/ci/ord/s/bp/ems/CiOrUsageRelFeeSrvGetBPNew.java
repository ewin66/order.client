package iih.ci.ord.s.bp.ems;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.UsageRelFeeSrvDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 获得医疗单用法费用对应服务信息操作BP
 */
public class CiOrUsageRelFeeSrvGetBPNew {
	/**
	 * 获得医疗单用法费用对应服务信息
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public UsageRelFeeSrvDO[] exec(Boolean fg_herb,String id_en,Integer orders_boil,String id_boil,String id_route)  throws BizException{
		//有效性校验 
//		if(ems==null)return null;
		//参数
		String orgid=CiOrdAppUtils.getEnvContext().getOrgId();
		UsageRelFeeSrvDO[] rtn=null;
		
		//草药与非草药判断
		if(fg_herb==true){
			rtn= CiOrdUtils.getPriBoilRelFeeSrvInfo(orgid,id_boil,orders_boil);
		}
//		else{  //2016-11-14 注释掉该部分逻辑   待煎与用法关联理论角度讲不应该是互斥的逻辑   
//			rtn= CiOrdUtils.getPriUsgRelFeeSrvInfo(ems.getId_route(), orgid, getEnWardDept(ems));
//		}
		rtn=routeRelFeeSrvHandle(id_route,id_en,rtn,orgid); //2016-11-14 新增该部分逻辑代替上述注释的部分
		
		//医嘱数组中为空的数据
		rtn = deleteNullUsageRelFeeSrvDO(rtn);//2016-09-02 zwq
		//结果数据处理
//		setHpInfo(rtn,CiOrdUtils.getId_Hp(ems));//???获得主医保
		
		return rtn;
	}
	
	/**
	 * 医嘱用法关联费用处理逻辑
	 * @param ems
	 * @param rtn
	 * @param orgid
	 * @return
	 * @throws BizException
	 */
	private UsageRelFeeSrvDO[] routeRelFeeSrvHandle(String id_route,String id_en,UsageRelFeeSrvDO[] rtn,String orgid) throws BizException{
		if(CiOrdUtils.isEmpty(id_route))return rtn;
//		if(!CiOrdUtils.isTrue(ems.getFg_mp_in()))return rtn;  //暂时按只有在院执行时才进行费用关联来计算???判断放到调用处
		UsageRelFeeSrvDO[] relfeeinfos= CiOrdUtils.getPriUsgRelFeeSrvInfo(id_route, orgid, getEnWardDept(id_en));
		//返回值处理
		return merge(rtn,relfeeinfos);
	}
	
	/**
	 * 获得患者所在病区或科室
	 * @param ems
	 * @return
	 * @throws BizException 
	 */
	private String getEnWardDept(String id_en) throws BizException{
		PatiVisitDO endo=CiOrdUtils.getPatiVisitDO(id_en);
		if(endo==null)return "";
		if(!OrSrvSplitUtil.isEmpty(endo.getId_dep_nur()))return endo.getId_dep_nur();
		return endo.getId_dep_phy(); 
	}
	
	/**
	 * 设置主医保信息
	 * 增加医保信息
	 * @param rtn
	 * @param ems
	 */
	private void setHpInfo(UsageRelFeeSrvDO[] rtn,String id_hp){
		//有效性判断
		if(CiOrdUtils.isEmpty(rtn))return;
		//遍历
		for(int i=0;i<rtn.length;i++){
			if(rtn[i] != null){
				rtn[i].setDef1(id_hp);
			}
		
		}
	}
	
	
	
	
	
	/**
	 * 合并处理
	 * @param rtn
	 * @param relsrv
	 * @return
	 */
	private UsageRelFeeSrvDO[] merge(UsageRelFeeSrvDO[] rtn,UsageRelFeeSrvDO[] relsrv){
		if(CiOrdUtils.isEmpty(relsrv))return rtn;
		if(CiOrdUtils.isEmpty(rtn))return relsrv;
		int iN=rtn.length+relsrv.length;
		UsageRelFeeSrvDO[] rtnlist=new UsageRelFeeSrvDO[iN];
		for(int i=0;i<iN;i++){
			if(i<rtn.length){
				rtnlist[i]=rtn[i];
			}else{
				rtnlist[i]=relsrv[i-rtn.length];
			}
		}
		
		return rtnlist;
	}
	/**
	 * 移除数组中为空的数据
	 * @param usAgeArray
	 * @return
	 */
	private UsageRelFeeSrvDO[] deleteNullUsageRelFeeSrvDO(UsageRelFeeSrvDO[] usAgeArray){
		if(CiOrdUtils.isEmpty(usAgeArray)) return null;
		List<UsageRelFeeSrvDO> usAges = new ArrayList<UsageRelFeeSrvDO>();
		for(UsageRelFeeSrvDO usage : usAgeArray){
			if(usage==null || "null".equals(usage)) continue;
			usAges.add(usage);
		}
		if(usAges.size()==0) return null;
		return usAges.toArray(new UsageRelFeeSrvDO[usAges.size()]);
	}
}
