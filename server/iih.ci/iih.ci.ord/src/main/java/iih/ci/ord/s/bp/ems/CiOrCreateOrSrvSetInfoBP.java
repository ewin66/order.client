package iih.ci.ord.s.bp.ems;

import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.ordsrvset.d.desc.OrdSrvSetDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;

import java.util.ArrayList;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AuditInfoUtil;

/**
 * 创建临床医嘱相关服务套内项目集合信息操作BP
 */
public class CiOrCreateOrSrvSetInfoBP {
	/**
	 * 创建临床医嘱相关服务套内项目集合信息
	 * @param ems
	 * @param srvsetitemindexs
	 * @return
	 * @throws BizException
	 */
	public  ArrayList<OrdSrvSetDO> exec(CiEmsDTO ems,Integer[] srvsetitemindexs)  throws BizException{
		long startTime = System.currentTimeMillis();
		
		//检验逻辑
		if(!validateCheck(ems,srvsetitemindexs))return null;
		
		//参数设置
		String matchstr=CiOrdUtils.aryToString(srvsetitemindexs);
		ArrayList<OrdSrvSetDO> rtn=new ArrayList<OrdSrvSetDO>();
		String id_srv_set=CiOrdUtils.getIdSrvSet4Ems(ems,srvsetitemindexs);
		OrdSrvSetDO setitemdo=null;
		//遍历
		for(int i=1;i<ems.getEmssrvs().size();i++){
			if(CiOrdUtils.isInStr(Integer.toString(i), matchstr)){
				setitemdo=createOrdSrvSetDO(ems.getEmssrvs(),i,id_srv_set);
				if(setitemdo==null)continue;
				rtn.add(setitemdo);
			}
		}
		CiOrdUtils.getlogger().info("创建临床医嘱相关服务套内项目集合信息操作BP 耗时"+( System.currentTimeMillis()-startTime));
		if(rtn==null || rtn.size()==0)return null;
		return rtn;
	}
	
	/**
	 * 校验逻辑判断
	 * @param ems
	 * @param srvsetitemindexs
	 * @return
	 */
	private boolean validateCheck(CiEmsDTO ems,Integer[] srvsetitemindexs){
		if(ems==null || ems.getEmssrvs()==null || ems.getEmssrvs().size()==0 || srvsetitemindexs==null || srvsetitemindexs.length==0)return false;
		return true;
	}
	
	/**
	 * 创建临床医嘱服务套do数据信息
	 * @param emssrvdtos
	 * @param i
	 * @param id_srv_set
	 * @return
	 * @throws BizException 
	 */
	private OrdSrvSetDO createOrdSrvSetDO(FArrayList emssrvdtos,int i,String id_srv_set) throws BizException{
		CiEmsSrvDTO emssrvdto=(CiEmsSrvDTO)emssrvdtos.get(i);
		MedSrvSetItemDO srvinsetdo=CiOrdUtils.getBdSrvSetItem(id_srv_set,emssrvdto.getId_srv() ,FBoolean.TRUE);
		if(srvinsetdo==null)return null;
		OrdSrvSetDO rtn= getOrdSrvSetDO(emssrvdto);
		if(CiOrdUtils.isDODel(emssrvdto)){ordSrvSetDODelHandle(rtn);return rtn;}
		if(CiOrdUtils.isDOUnChange(emssrvdto)){return rtn;}
		if(CiOrdUtils.isEmpty(rtn)) rtn = new OrdSrvSetDO();
		//rtn.setId_orsrvset();
		//rtn.setId_orsrv();
		//rtn.setId_or();
		rtn.setId_srvsetdef(id_srv_set);
		rtn.setId_srvset(emssrvdto.getId_srv());
		//rtn.setSortno();
		rtn.setDes_srv(srvinsetdo.getDes());
		rtn.setId_srvsetrole(srvinsetdo.getId_srvsetrole());
		rtn.setSd_srvsetrole(srvinsetdo.getSd_srvsetrole());
		rtn.setId_medu(srvinsetdo.getId_medu());
		rtn.setQuan_medu(srvinsetdo.getQuan_medu());
		rtn.setId_freqdef(srvinsetdo.getId_freq());
		rtn.setId_body(emssrvdto.getId_body());
		rtn.setSd_body(emssrvdto.getSd_body());
		rtn.setBody_name(emssrvdto.getBody_name());
		rtn.setId_pos(emssrvdto.getId_pos());
		rtn.setSd_pos(emssrvdto.getSd_pos());
		rtn.setFg_clinical(srvinsetdo.getFg_clinical());
		rtn.setFg_clinical(srvinsetdo.getFg_clinical_bl());
		//关联数据信息设置
		ordSrvSetDORelInfoHandle(rtn,emssrvdto);

		return rtn;
	}
	
	/**
	 * 获得医嘱项目对应的套内项目DO数据信息
	 * @param emssrvdto
	 * @return
	 * @throws BizException
	 */
	private OrdSrvSetDO getOrdSrvSetDO(CiEmsSrvDTO emssrvdto) throws BizException{
		if(CiOrdUtils.isDONew(emssrvdto)){
			OrdSrvSetDO rtn=new OrdSrvSetDO();
			rtn.setStatus(DOStatus.NEW);
			return rtn;
		}else{
			String whereStr=OrdSrvSetDODesc.TABLE_ALIAS_NAME+".id_or='"+emssrvdto.getId_or()+"' and "+
							OrdSrvSetDODesc.TABLE_ALIAS_NAME+".Id_srvset='"+emssrvdto.getId_srv()+"'";
			OrdSrvSetDO[] rtn1=CiOrdAppUtils.getOrsrvsetQryService().find(whereStr, "", FBoolean.FALSE);
			if(CiOrdUtils.isEmpty(rtn1))return null;// 新增代码2016-11-28 status=0时，id_or为空（状态值 0：未变化，1：修改，2：新增，3：删除）
			return rtn1[0];
		}
		
	}
	
	/**
	 * 删除处理
	 * @param rtn
	 * @return
	 */
	private void ordSrvSetDODelHandle(OrdSrvSetDO rtn){
		//通过医嘱模板打开的医疗单调用的旧的医疗单创建方法
		//传入后台所有套内项目,status 不同在删除状态时rtn传过来为null需增加非null判断 
		if(CiOrdUtils.isEmpty(rtn)) rtn = new OrdSrvSetDO();
		rtn.setStatus(DOStatus.DELETED);
	}
	
	/**
	 * 关联数据信息设置
	 * @param rtn
	 * @param emssrvdto
	 */
	private void ordSrvSetDORelInfoHandle(OrdSrvSetDO rtn,CiEmsSrvDTO emssrvdto){
		if(CiOrdUtils.isDONew(emssrvdto)){
			AuditInfoUtil.addData(rtn);//设置设计信息
			rtn.setStatus(DOStatus.NEW);
		}else if(CiOrdUtils.isDOMod(emssrvdto)){
			AuditInfoUtil.updateData(rtn);//设置设计信息
			rtn.setStatus(DOStatus.UPDATED);
		}
	}

}
