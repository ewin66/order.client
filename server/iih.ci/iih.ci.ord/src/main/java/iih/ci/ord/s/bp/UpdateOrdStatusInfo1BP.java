package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.d.OrSuModRtnInfoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.splitpres.RrevokeOrderHandlePresBP;

import java.lang.reflect.Array;
import java.util.ArrayList;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AuditInfoUtil;

/**
 * 更新临床医嘱状态及相关信息操作BP
 */
public class UpdateOrdStatusInfo1BP {
	/**
	 * 更新临床医嘱状态及相关信息
	 * MM
	 * @param orders
	 * @param dt_end
	 * @param sd_su_or
	 * @return
	 * @throws BizException
	 */
	public  OrSuModRtnInfoDTO[] exec(CiOrderDO[] orders,FDateTime dt_end,String sd_su_or)  throws BizException{
		//有效性校验
		validateCheck(sd_su_or);
	
		//设置医嘱状态
		ArrayList<OrSuModRtnInfoDTO> rtninfos = new ArrayList<OrSuModRtnInfoDTO>();
		CiOrderDO[] ors = getValidOrders(orders, dt_end, sd_su_or, rtninfos);
		
		//医嘱及事件保存
		CiOrderDO[] rtnors=ciOrStatusRelInfoSave(ors,sd_su_or);   //保存更新走相应的校验操作
		
		if(rtninfos==null || rtninfos.size()==0)return null;
		return (OrSuModRtnInfoDTO[]) rtninfos.toArray((OrSuModRtnInfoDTO[]) Array.newInstance(OrSuModRtnInfoDTO.class, 0));
	}
	
	/**
	 * 有效性校验
	 * @param sd_su_or
	 * @throws BizException
	 */
	private void validateCheck(String sd_su_or) throws BizException{

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
	private CiOrderDO[] getValidOrders(CiOrderDO[] orders, FDateTime dt_end, String sd_su_or,
			ArrayList<OrSuModRtnInfoDTO> rtninfos) throws BizException {
		ArrayList<CiOrderDO> rtns = new ArrayList<CiOrderDO>();
		CiOrderDO or = null;
		FDateTime dtNow = CiOrdAppUtils.getServerDateTime();
		String id_org = CiOrdAppUtils.getEnvContext().getOrgId();
		String id_dep = CiOrdAppUtils.getEnvContext().getDeptId();
		String id_emp = CiOrdUtils.getPsnDocID(CiOrdAppUtils.getEnvContext().getUserId());
		for (int i = 0; i < orders.length; i++) {
			or = orders[i];
			AuditInfoUtil.updateData(or);
			if (ICiDictCodeConst.SD_SU_OPEN.equals(sd_su_or)) {//医嘱
				if (!or.getFg_sign().isValue()) {
					rtninfos.add(getOrderRelSuInfo(or, sd_su_or));
				} else {
					or.setId_su_or(ICiDictCodeConst.SD_SU_ID_OPEN);
					or.setSd_su_or(sd_su_or);
					or.setFg_sign(new FBoolean(false));
					or.setDt_sign(null);
					or.setId_dep_sign(null);
					or.setId_emp_sign(null);
					or.setDt_last_bl(or.getDt_effe());
					or.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
					or.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
					or.setFg_flush2mr(FBoolean.FALSE);//写会病历标识	
					or.setStatus(DOStatus.UPDATED);
					rtns.add(or);
				}
			} else if (ICiDictCodeConst.SD_SU_SIGN.equals(sd_su_or)) {
				if (or.getFg_sign().isValue()) {
					rtninfos.add(getOrderRelSuInfo(or, sd_su_or));
				} else {
					or.setId_su_or(ICiDictCodeConst.SD_SU_ID_SIGN);
					or.setSd_su_or(sd_su_or);
					or.setFg_sign(new FBoolean(true));
					or.setDt_sign(dtNow);
					or.setId_dep_sign(id_dep);
					or.setId_emp_sign(id_emp);
					or.setStatus(DOStatus.UPDATED);
					rtns.add(or);
				}
			} else if (ICiDictCodeConst.SD_SU_CHECKTHROUGH.equals(sd_su_or)) {
				if (or.getFg_chk().isValue()) {
					rtninfos.add(getOrderRelSuInfo(or, sd_su_or));
				} else {
					if(!or.getSd_su_or().equals(ICiDictCodeConst.SD_SU_FINISH)){//医嘱状态为完成不修改完成状态  li_cheng
					or.setId_su_or(ICiDictCodeConst.SD_SU_ID_CHECKTHROUGH);
					or.setSd_su_or(sd_su_or);
					}
					or.setFg_chk(new FBoolean(true));
					or.setDt_chk(dtNow);
					or.setId_dep_chk(id_dep);
					or.setId_emp_chk(id_emp);
					or.setStatus(DOStatus.UPDATED);
					rtns.add(or);
				}
			} else if (ICiDictCodeConst.SD_SU_CANCEL.equals(sd_su_or)) {
				if (or.getFg_canc().isValue()) {
					rtninfos.add(getOrderRelSuInfo(or, sd_su_or));
				} else {
					or.setId_su_or(ICiDictCodeConst.SD_SU_ID_CANCEL);
					or.setSd_su_or(sd_su_or);
					or.setFg_canc(new FBoolean(true));
					or.setDt_canc(dtNow);
					or.setId_dep_canc(id_dep);
					or.setId_emp_canc(id_emp);
					or.setStatus(DOStatus.UPDATED);
					rtns.add(or);
				}
			} else if (ICiDictCodeConst.SD_SU_CHECKCANCEL.equals(sd_su_or)) {
				if (or.getFg_chk_canc().isValue()) {
					rtninfos.add(getOrderRelSuInfo(or, sd_su_or));
				} else {
					if(!or.getSd_su_or().equals(ICiDictCodeConst.SD_SU_FINISH)){//医嘱状态为完成不修改完成状态  li_cheng
					or.setId_su_or(ICiDictCodeConst.SD_SU_ID_CHECKCANCEL);
					or.setSd_su_or(sd_su_or);
					}
					or.setFg_chk_canc(new FBoolean(true));
					or.setDt_chk_canc(dtNow);
					or.setId_dep_chk_canc(id_dep);
					or.setId_emp_chk_canc(id_emp);
					or.setStatus(DOStatus.UPDATED);
					rtns.add(or);
				}
			} else if (ICiDictCodeConst.SD_SU_DOCTORSTOP.equals(sd_su_or)) {
				or.setFg_stop(new FBoolean(true));
				or.setDt_stop(dtNow);
				or.setId_dep_stop(id_dep);
				or.setId_emp_stop(id_emp);
				if (!CiOrdUtils.isEmpty(dt_end)) { //2016-07-14 增加该判断逻辑  
					or.setDt_end(dt_end);
					or.setDt_invalid(dt_end);
				} else {
					or.setDt_invalid(or.getDt_end());
				}
				or.setStatus(DOStatus.UPDATED);
				rtns.add(or);
			} else if (ICiDictCodeConst.SD_SU_CHECKSTOP.equals(sd_su_or)) {
				if (or.getFg_chk_stop().isValue()) {
					rtninfos.add(getOrderRelSuInfo(or, sd_su_or));
				} else {
				   if(!or.getSd_su_or().equals(ICiDictCodeConst.SD_SU_FINISH)){//医嘱状态为完成不修改完成状态  li_cheng
					or.setId_su_or(ICiDictCodeConst.SD_SU_ID_CHECKSTOP);
					or.setSd_su_or(sd_su_or);
				   }
					or.setFg_chk_stop(new FBoolean(true));
					or.setDt_chk_stop(dtNow);
					or.setId_dep_chk_stop(id_dep);
					or.setId_emp_chk_stop(id_emp);
					or.setStatus(DOStatus.UPDATED);
					rtns.add(or);
				}
			}
		}
		if (rtns == null || rtns.size() == 0)
			return null;
		return (CiOrderDO[]) rtns.toArray((CiOrderDO[]) Array.newInstance(CiOrderDO.class, 0));
	}
	
	/**
	 * 获得他人已做状态修改情况信息
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
	private CiOrderDO[] ciOrStatusRelInfoSave(CiOrderDO[] ors,String sd_su_or) throws BizException{
		CiOrderDO[] rtnors=CiOrdAppUtils.getOrService().update(ors); 

		String[] id_ors_temp = this.getIdOrders(ors);
        if(ICiDictCodeConst.SD_SU_DOCTORSTOP.equals(sd_su_or)&&!CiOrdUtils.isEmpty(id_ors_temp)){
        	//执行域响应医嘱停止操作
			CiOrdAppUtils.getIResponseOrderHandelService().responseOrStop(id_ors_temp);
        }
		//医嘱事件创建保存 时机应该选择为 签署阶段
		ciEventInfoSave(ors,sd_su_or);
		
		return rtnors;
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
