package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciord.d.OrSrvAgentInfoDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.d.OrSuModRtnInfoDTO;
import iih.ci.ord.idvproperty.d.IdVProperty;
import iih.ci.ord.pub.CiOrPubUtils;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.CiOrUseBtRollBackBP;
import iih.ci.ord.s.bp.splitpres.RrevokeOrderHandlePresBP;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AuditInfoUtil;

/**
 * 更新临床医嘱状态及相关信息操作BP
 */
public class UpdateOrdStatusInfo0BP {
	/**
	 * 更新临床医嘱状态及相关信息
	 * MM
	 * @param id_ors
	 * @param dt_end
	 * @param sd_su_or
	 * @return
	 * @throws BizException
	 */
	public  OrSuModRtnInfoDTO[] exec(IdVProperty[] id_ors,FDateTime dt_end,String sd_su_or)  throws BizException{
		//有效性校验
		validateCheck(id_ors,dt_end,sd_su_or);
		
		//获得医嘱
		Object[] os=CiOrdUtils.getIdVPropInfo(id_ors);
		CiOrderDO[] orders=CiOrdAppUtils.getOrQryService().findByIds((String[])os[0], new FBoolean(false));
		//将撤回的用血医嘱查找出来，条件（1、是用血医嘱，2、医嘱状态是开立）
		ArrayList<CiOrderDO> useBtrollBacks = new ArrayList<CiOrderDO>();
		for(CiOrderDO ciorder : orders){
			if(CiOrderTypeEnum.USEBTORDER.equals(CiOrPubUtils
					.getCiOrderType(ciorder)) && ICiDictCodeConst.SD_SU_OPEN.equals(sd_su_or)){
				useBtrollBacks.add(ciorder);
			}
			
		}
		//设置医嘱状态
		ArrayList<OrSuModRtnInfoDTO> rtninfos=new ArrayList<OrSuModRtnInfoDTO>();
		CiOrderDO[] ors=getValidOrders(orders,dt_end,sd_su_or,rtninfos,(Hashtable)os[1]);
		
		//医嘱及事件保存
		ciOrStatusRelInfoSave(ors,sd_su_or);
		String[] id_ors_temp = this.getIdOrders(ors);
//		if(ICiDictCodeConst.SD_SU_OPEN.equals(sd_su_or)){
//			//撤回时，如果存在服务已经判断过特殊病标志，应该将特殊病标志设置为N未判断状态
//			resetSpecill(id_ors_temp);
//		}
        if(ICiDictCodeConst.SD_SU_DOCTORSTOP.equals(sd_su_or)){
        	//执行域响应医嘱停止操作
			CiOrdAppUtils.getIResponseOrderHandelService().responseOrStop(id_ors_temp);
        }
        
       if(ICiDictCodeConst.SD_SU_CANCEL.equals(sd_su_or)){
    		//执行域响应医嘱作废操作
			CiOrdAppUtils.getIResponseOrderHandelService().responseOrInvalid(id_ors_temp);
        }
       	//执行用血医嘱的回撤逻辑
       if(useBtrollBacks.size()>0){
    	   CiOrUseBtRollBackBP rollbak = new CiOrUseBtRollBackBP();
    	   rollbak.exe(useBtrollBacks.toArray(new CiOrderDO[useBtrollBacks.size()]));
       }
       //执行患者核对信息的删除
	   //CiOrdUtils.delOrSrvAgentInfoDO((String[])os[0]);
       
		if(rtninfos==null || rtninfos.size()==0)return null;
		return (OrSuModRtnInfoDTO[]) rtninfos.toArray((OrSuModRtnInfoDTO[]) Array.newInstance(OrSuModRtnInfoDTO.class, 0));

	}
	/**
	 * 重置特殊病标志
	 * @param id_ors_temp
	 * @throws BizException 
	 */
	private void resetSpecill(String[] id_ors_temp) throws BizException {
		if(CiOrdUtils.isEmpty(id_ors_temp)||id_ors_temp.length==0)return;
		String id_ors = "'"+id_ors_temp.toString().replace(",", "','");
		OrdSrvDO[] ordSrvDOs = CiOrdAppUtils.getOrSrvQryService().find(String.format("id_or in (%s) and fg_specill='Y'", id_ors), "", FBoolean.FALSE);
		for(OrdSrvDO srv : ordSrvDOs){
			srv.setFg_specill(FBoolean.FALSE);
		}
		CiOrdAppUtils.getOrSrvService().update(ordSrvDOs);
	}
	/**
	 * 医嘱id
	 * @param ors
	 * @return
	 */
	private String[] getIdOrders(CiOrderDO[] ors){
		if(ors == null) return null;
		String[] id_ors = new String[ors.length];
		 int i =0;
		for(CiOrderDO order:ors){
			id_ors[i] = order.getId_or();
			++i;
		}
		return id_ors;
	}
	
	
	/**
	 * 有效性校验
	 * @param id_ors
	 * @param dt_end
	 * @param sd_su_or
	 * @throws BizException
	 */
	private void validateCheck(IdVProperty[] id_ors,FDateTime dt_end,String sd_su_or) throws BizException{
		if(id_ors==null || id_ors.length==0)return;
		
		//状态校验
		if(!CiOrdUtils.orStatusValidateCheck4Mod(sd_su_or)){
			throw new BizException("传入的状态值不正确！");
		}
	}
	
	/**
	 * 医嘱状态及相关信息处理
	 * @param orders
	 * @param dt_end
	 * @param sd_su_or
	 * @return
	 * @throws BizException 
	 */
	private CiOrderDO[] getValidOrders(CiOrderDO[] orders,FDateTime dt_end,String sd_su_or,ArrayList<OrSuModRtnInfoDTO> rtninfos,Hashtable os) throws BizException{
		ArrayList<CiOrderDO> rtns=new ArrayList<CiOrderDO>();
		CiOrderDO or=null;
		FDateTime dtNow=CiOrdAppUtils.getServerDateTime();
		String id_org=CiOrdAppUtils.getEnvContext().getOrgId();
		String id_dep=CiOrdAppUtils.getEnvContext().getDeptId();
		String id_emp=CiOrdAppUtils.getEnvContext().getUserId();
		id_emp=CiOrdUtils.getPsnDocID(id_emp);
		for(int i=0;i<orders.length;i++){
			or=orders[i];
			AuditInfoUtil.updateData(or);
			if(ICiDictCodeConst.SD_SU_SIGN.equals(sd_su_or)){
				if(or.getFg_sign().isValue()){rtninfos.add(getOrderRelSuInfo(or,sd_su_or));}else{
					or.setId_su_or(ICiDictCodeConst.SD_SU_ID_SIGN);
					or.setSd_su_or(sd_su_or);
					or.setFg_sign(new FBoolean(true));
					or.setDt_sign(dtNow);
					or.setId_dep_sign(id_dep);
					or.setId_emp_sign(id_emp);
					or.setStatus(DOStatus.UPDATED);
					or.setFg_chk_stop(new FBoolean(false));
					rtns.add(or);
				}
			}else if(ICiDictCodeConst.SD_SU_CHECKTHROUGH.equals(sd_su_or)){
				if(or.getFg_chk().isValue()){rtninfos.add(getOrderRelSuInfo(or,sd_su_or));}else{
					or.setId_su_or(ICiDictCodeConst.SD_SU_ID_CHECKTHROUGH);
					or.setSd_su_or(sd_su_or);
					or.setFg_chk(new FBoolean(true));
					or.setDt_chk(dtNow);
					or.setId_dep_chk(id_dep);
					or.setId_emp_chk(id_emp);
					or.setStatus(DOStatus.UPDATED);
					rtns.add(or);
				}
			}else if(ICiDictCodeConst.SD_SU_CANCEL.equals(sd_su_or)){
				if(or.getFg_canc().isValue()){rtninfos.add(getOrderRelSuInfo(or,sd_su_or));}else{
					or.setId_su_or(ICiDictCodeConst.SD_SU_ID_CANCEL);
					or.setSd_su_or(sd_su_or);
					or.setFg_canc(new FBoolean(true));
					or.setDt_canc(dtNow);
					or.setId_dep_canc(id_dep);
					or.setId_emp_canc(id_emp);	
					or.setStatus(DOStatus.UPDATED);
					rtns.add(or);
				}
			}else if(ICiDictCodeConst.SD_SU_CHECKCANCEL.equals(sd_su_or)){
				if(or.getFg_chk_canc().isValue()){rtninfos.add(getOrderRelSuInfo(or,sd_su_or));}else{
					or.setId_su_or(ICiDictCodeConst.SD_SU_ID_CHECKCANCEL);
					or.setSd_su_or(sd_su_or);
					or.setFg_chk_canc(new FBoolean(true));
					or.setDt_chk_canc(dtNow);
					or.setId_dep_chk_canc(id_dep);
					or.setId_emp_chk_canc(id_emp);	
					or.setStatus(DOStatus.UPDATED);
					rtns.add(or);
				}
			}else if(ICiDictCodeConst.SD_SU_DOCTORSTOP.equals(sd_su_or)){
				//未停止核对的有效医嘱，可反复修改停止时间； 王琪
				//if(or.getFg_stop().isValue()){rtninfos.add(getOrderRelSuInfo(or,sd_su_or));}else{
					//or.setId_su_or(ICiDictCodeConst.SD_SU_ID_DOCTORSTOP);
					or.setFg_stop(new FBoolean(true));
					//or.setSd_su_or(sd_su_or);//没有40状态
					or.setDt_stop(dtNow);
					or.setId_dep_stop(id_dep);
					or.setId_emp_stop(id_emp);	
					or.setDt_end(dt_end);
					or.setDt_stop(dt_end);
					or.setStatus(DOStatus.UPDATED);
					rtns.add(or);
				//}
			}else if(ICiDictCodeConst.SD_SU_CHECKSTOP.equals(sd_su_or)){
				if(or.getFg_chk_stop().isValue()){rtninfos.add(getOrderRelSuInfo(or,sd_su_or));}else{
					or.setId_su_or(ICiDictCodeConst.SD_SU_ID_CHECKSTOP);
					or.setSd_su_or(sd_su_or);
					or.setFg_chk_stop(new FBoolean(true));
					or.setDt_chk_stop(dtNow);
					or.setId_dep_chk_stop(id_dep);
					or.setId_emp_chk_stop(id_emp);	
					or.setStatus(DOStatus.UPDATED);
					rtns.add(or);
				}
			}else if(ICiDictCodeConst.SD_SU_OPEN.equals(sd_su_or)){
				if(or.getFg_chk_stop().isValue()){rtninfos.add(getOrderRelSuInfo(or,sd_su_or));}else{
					or.setId_su_or(ICiDictCodeConst.SD_SU_ID_OPEN);
					or.setSd_su_or(sd_su_or);
//					or.setFg_chk_stop(new FBoolean(true));
					or.setFg_sign(new FBoolean(false));
					or.setDt_sign(null);
					or.setId_dep_sign(null);
					or.setId_emp_sign(null);
					//or.setDt_last_bl(or.getDt_effe());//2017-2-28经三位po及孟老师确认，目前撤回时，把Dt_last_bl字段的值改成了生效时间，这个逻辑不对，删除掉这个赋值逻辑。
					or.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
					or.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
//					or.setDt_chk_stop(dtNow);
//					or.setId_dep_chk_stop(id_dep);
//					or.setId_emp_chk_stop(id_emp);	
					or.setStatus(DOStatus.UPDATED);
					//处理医嘱撤回的
					RrevokeOrderHandlePresBP bp = new RrevokeOrderHandlePresBP();
					bp.execOrders(orders);
					rtns.add(or);
				}
			}
		}
		if(rtns==null || rtns.size()==0)return null;
		return (CiOrderDO[]) rtns.toArray((CiOrderDO[]) Array.newInstance(CiOrderDO.class, 0));
	}
	
	/**
	 * 获得医嘱状态修改返回信息
	 * @param or
	 * @param sd_su_or
	 * @return
	 */
	private OrSuModRtnInfoDTO getOrderRelSuInfo(CiOrderDO or,String sd_su_or){
		OrSuModRtnInfoDTO rtn=new OrSuModRtnInfoDTO();
		if(ICiDictCodeConst.SD_SU_SIGN.equals(sd_su_or)){
			rtn.setId(or.getId_or());
			rtn.setDt_biz(or.getDt_sign());
			rtn.setId_dept(or.getId_dep_sign());
			//rtn.setCode_dept(Code_dept);
			//rtn.setName_dept(Name_emp);
			rtn.setId_emp(or.getId_emp_sign());
			//rtn.setCode_emp(Code_dept);
			//rtn.setName_emp(Name_emp);
		}else if(ICiDictCodeConst.SD_SU_CHECKTHROUGH.equals(sd_su_or)){
			rtn.setId(or.getId_or());
			rtn.setDt_biz(or.getDt_chk());
			rtn.setId_dept(or.getId_dep_chk());
			//rtn.setCode_dept(Code_dept);
			//rtn.setName_dept(Name_emp);
			rtn.setId_emp(or.getId_emp_chk());
			//rtn.setCode_emp(Code_dept);
			//rtn.setName_emp(Name_emp);
		}else if(ICiDictCodeConst.SD_SU_CANCEL.equals(sd_su_or)){
			rtn.setId(or.getId_or());
			rtn.setDt_biz(or.getDt_canc());
			rtn.setId_dept(or.getId_dep_canc());
			//rtn.setCode_dept(Code_dept);
			//rtn.setName_dept(Name_emp);
			rtn.setId_emp(or.getId_emp_canc());
			//rtn.setCode_emp(Code_dept);
			//rtn.setName_emp(Name_emp);
		}else if(ICiDictCodeConst.SD_SU_CHECKCANCEL.equals(sd_su_or)){
			rtn.setId(or.getId_or());
			rtn.setDt_biz(or.getDt_chk_canc());
			rtn.setId_dept(or.getId_dep_chk_canc());
			//rtn.setCode_dept(Code_dept);
			//rtn.setName_dept(Name_emp);
			rtn.setId_emp(or.getId_emp_chk_canc());
			//rtn.setCode_emp(Code_dept);
			//rtn.setName_emp(Name_emp);
		}else if(ICiDictCodeConst.SD_SU_DOCTORSTOP.equals(sd_su_or)){
			rtn.setId(or.getId_or());
			rtn.setDt_biz(or.getDt_stop());
			rtn.setId_dept(or.getId_dep_stop());
			//rtn.setCode_dept(Code_dept);
			//rtn.setName_dept(Name_emp);
			rtn.setId_emp(or.getId_emp_stop());
			//rtn.setCode_emp(Code_dept);
			//rtn.setName_emp(Name_emp);
		}else if(ICiDictCodeConst.SD_SU_CHECKSTOP.equals(sd_su_or)){
			rtn.setId(or.getId_or());
			rtn.setDt_biz(or.getDt_chk_stop());
			rtn.setId_dept(or.getId_dep_chk_stop());
			//rtn.setCode_dept(Code_dept);
			//rtn.setName_dept(Name_emp);
			rtn.setId_emp(or.getId_emp_chk_stop());
			//rtn.setCode_emp(Code_dept);
			//rtn.setName_emp(Name_emp);
		}
		return rtn;
	}
	
	/**
	 * 医嘱及事件保存
	 * @param ors
	 * @param sd_su_or
	 * @throws BizException
	 */
	private void ciOrStatusRelInfoSave(CiOrderDO[] ors,String sd_su_or) throws BizException{
		CiOrdAppUtils.getOrService().update(ors); 
		
		//医嘱事件创建保存 时机应该选择为 签署阶段
		ciEventInfoSave(ors,sd_su_or);
	}
	
	/**
	 * 临床事件保存
	 * @param ors
	 * @param sd_su_or
	 * @throws BizException
	 */
	private void ciEventInfoSave(CiOrderDO[] ors,String sd_su_or) throws BizException{
		//有效性校验
		if(ors==null || ors.length==0)return;
		if(!ICiDictCodeConst.SD_SU_SIGN.equals(sd_su_or))return;
		//医嘱事件创建保存 时机应该选择为 签署阶段
		CiOrEventsSaveBP bp=new CiOrEventsSaveBP();
		bp.exec(ors);
	}
}
