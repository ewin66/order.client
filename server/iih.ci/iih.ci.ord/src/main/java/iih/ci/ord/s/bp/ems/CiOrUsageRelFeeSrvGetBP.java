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

/**
 * 获得医疗单用法费用对应服务信息操作BP
 */
public class CiOrUsageRelFeeSrvGetBP {
	/**
	 * 获得医疗单用法费用对应服务信息
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public UsageRelFeeSrvDO[] exec(CiEmsDTO ems)  throws BizException{
		//有效性校验 
		if(ems==null)return null;
		//参数
		String orgid=CiOrdAppUtils.getEnvContext().getOrgId();
		UsageRelFeeSrvDO[] rtn=null;
		
		//草药与非草药判断
		if(EmsType.HERB.equals(ems.getEmstype()) 
				&& OrSrvSplitUtil.isTrue(ems.getFg_boil())
				&& !CiOrdUtils.isEmpty(ems.getOrders_boil()) && ems.getOrders_boil()>0){
			rtn= CiOrdUtils.getPriBoilRelFeeSrvInfo(orgid,ems.getId_boil(), ems.getOrders_boil());
		}
//		else{  //2016-11-14 注释掉该部分逻辑   待煎与用法关联理论角度讲不应该是互斥的逻辑   
//			rtn= CiOrdUtils.getPriUsgRelFeeSrvInfo(ems.getId_route(), orgid, getEnWardDept(ems));
//		}
		rtn=routeRelFeeSrvHandle(ems,rtn,orgid); //2016-11-14 新增该部分逻辑代替上述注释的部分
		
		//标本类型  关联服务
		rtn=specimenTpRelSrvHandle(ems,rtn,orgid);//2016-08-29新增逻辑 调试时打开   测试无误后增加该逻辑
		
		//医嘱关联服务
		rtn=ciOrRelSrvHandle(ems,rtn);  //2016-08-15新增逻辑   调试时打开   测试无误后增加该逻辑
		//医嘱数组中为空的数据
		rtn = deleteNullUsageRelFeeSrvDO(rtn);//2016-09-02 zwq
		//结果数据处理
		setHpInfo(rtn,CiOrdUtils.getId_Hp(ems));
		
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
	private UsageRelFeeSrvDO[] routeRelFeeSrvHandle(CiEmsDTO ems,UsageRelFeeSrvDO[] rtn,String orgid) throws BizException{
		if(CiOrdUtils.isEmpty(ems))return rtn;
		if(!CiOrdUtils.isTrue(ems.getFg_mp_in()))return rtn;  //暂时按只有在院执行时才进行费用关联来计算
		UsageRelFeeSrvDO[] relfeeinfos= CiOrdUtils.getPriUsgRelFeeSrvInfo(ems.getId_route(), orgid, getEnWardDept(ems));
		//返回值处理
		return merge(rtn,relfeeinfos);
	}
	
	/**
	 * 获得患者所在病区或科室
	 * @param ems
	 * @return
	 * @throws BizException 
	 */
	private String getEnWardDept(CiEmsDTO ems) throws BizException{
		PatiVisitDO endo=CiOrdUtils.getPatiVisitDO(ems.getId_en());
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
	 * 医嘱关联服务数据信息处理
	 * @param ems
	 * @param rtn
	 * @return
	 * @throws BizException
	 */
	private UsageRelFeeSrvDO[] ciOrRelSrvHandle(CiEmsDTO ems,UsageRelFeeSrvDO[] rtn) throws BizException{
		UsageRelFeeSrvDO[] relsrvinfos=getCiOrRelSrvInfo(ems);
		return merge(rtn,relsrvinfos);
		
	}
	
	/**
	 * 标本关联服务数据信息处理
	 * @param ems
	 * @param rtn
	 * @param orgid
	 * @return
	 * @throws BizException
	 */
	private UsageRelFeeSrvDO[] specimenTpRelSrvHandle(CiEmsDTO ems,UsageRelFeeSrvDO[] rtn,String orgid) throws BizException{
		//类型与空判断
		if(!EmsType.LIS.equals(ems.getEmstype()))return rtn;
		if(CiOrdUtils.isEmpty(ems.getOrapplysheet())) return rtn;
		
		//参数  map中的key应该使用全路径+类名
		//String key=CiOrdUtils.getOrAppClizname(EmsType.LIS);
		OrdApLabDO labdo=(OrdApLabDO)ems.getOrapplysheet().get(EmsType.LIS.toString());
		
		//空判断
		if(CiOrdUtils.isEmpty(labdo) || CiOrdUtils.isEmpty(labdo.getSd_samptp()))return rtn;
		UsageRelFeeSrvDO[] relsrvinfos=null;
		if(CiOrdUtils.isOpWf(ems.getCode_entp())){//仅门诊 进行标本费用关联 住院由执行阶段关联   2016-11-24  新增容器关联费用逻辑   新逻辑测试时将下面第一行代码注释掉打开第二行代码 测试通过后提交
			//relsrvinfos=CiOrdUtils.getSpecimenTpRelFeeSrvInfo(labdo.getSd_samptp(),orgid,null);  //原有的逻辑  
			relsrvinfos=CiOrdUtils.getLisSrvSpecimenVesselTpRelFeeSrvInfos(labdo.getSd_samptp(),labdo.getSd_contp(),orgid,null,ems.getCode_entp(),OrSrvSourceFromEnum.SPECIMENVESSELRELFEE);
		}

		//返回值处理
		return merge(rtn,relsrvinfos);
	}
	
	/**
	 * 获得医嘱关联服务相关数据信息
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	private UsageRelFeeSrvDO[] getCiOrRelSrvInfo(CiEmsDTO ems) throws BizException{
		CiOrRelSrvGetBP bp=new CiOrRelSrvGetBP();
		return bp.exec(ems);
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
