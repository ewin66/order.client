package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.cior.d.desc.CiOrSessionDODesc;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AuditInfoUtil;

/*
 * 门急诊获得患者就诊最近一次签署回话医嘱集合数据信息操作BP
 */
public class OpLatelySessionOrsGetBP {
	/**
	 * 门急诊获得患者就诊最近一次签署回话医嘱集合数据信息
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	public void exec(String id_en,String[] idors) throws BizException{
		//获得最近一次会话数据信息
		String whereStr = CiOrSessionDODesc.TABLE_ALIAS_NAME + ".id_en='" + id_en + "'";
		CiOrSessionDO[] sessdos = CiOrdAppUtils.getCiorsessionQryService().find(whereStr, " dt_sign desc ",
				FBoolean.FALSE);

		//参数有效性判断
		if (CiOrdUtils.isEmpty(sessdos))
			return;
		
		String depid = CiOrdAppUtils.getEnvContext().getDeptId(); //科室id
		String empid = CiOrdAppUtils.getEnvContext().getUserId(); //人员id
		empid = CiOrdUtils.getPsnDocID(empid);
		
		//获取需要修改和删除的session
		List<CiOrSessionDO> sessionlist = new ArrayList<>();
		List<CiOrSessionDO> delsessionlist = new ArrayList<>();
		

		
		for (CiOrSessionDO sessdo : sessdos) {
			String sess_idors = sessdo.getId_ors();
			for (String idor : idors) {
				if (sess_idors.contains(idor)) {
					//从session中擦除该医嘱
					String[] orsarray = sess_idors.split(CiOrdUtils.COMMA_STR);
					if (orsarray.length == 1) {
						sessdo.setStatus(DOStatus.DELETED);
						delsessionlist.add(sessdo);
						moddeletelist(sessionlist,sessdo);
						
					} else if (orsarray.length > 1) {
						sess_idors = sess_idors.replaceFirst(idor, "");
						sess_idors = sess_idors.replaceAll(CiOrdUtils.COMMA_STR, " ");
//						sess_idors = sess_idors.replaceAll("\\s+ ", ",");
						String[] orsarraytmp = sess_idors.split(" ");
						StringBuilder sb =new StringBuilder();
						for (String s : orsarraytmp) {
							if(!s.equals("")){
								
								if(sb.length()==0){
									sb.append(s);
								}else{
									sb.append(","+s);
								}
								
							}
						}
						sess_idors=sb.toString();
						sessdo.setId_ors(sess_idors);
						sessdo.setFg_signcanc(FBoolean.TRUE);
						sessdo.setDt_signcanc(CiOrdAppUtils.getServerDateTime());
						sessdo.setId_dep_signcanc(depid);
						sessdo.setId_emp_signcanc(empid);
						AuditInfoUtil.updateData(sessdo);
						sessdo.setStatus(DOStatus.UPDATED);
						modupdatelist(sessionlist,sessdo);
					}
				}
			}
		}
		update(sessionlist.toArray(new CiOrSessionDO[sessionlist.size()]));
		delete(delsessionlist.toArray(new CiOrSessionDO[delsessionlist.size()]));   //uu
	}
	
	private void update(CiOrSessionDO[] sessionDOs) throws BizException{
		//更新数据
		if (!CiOrdUtils.isEmpty(sessionDOs)){
			CiOrdAppUtils.getCiorsessionService().update(sessionDOs);
		}
	}
	
	private void delete(CiOrSessionDO[] sessionDOs) throws BizException{
		//删除数据
		if (!CiOrdUtils.isEmpty(sessionDOs)){
			CiOrdAppUtils.getCiorsessionService().delete(sessionDOs);
		}
	}
	
	private void moddeletelist(List<CiOrSessionDO> sessionlist,CiOrSessionDO sessionDOs) throws BizException{
		//更新数据
		List<CiOrSessionDO> lissession= new ArrayList<>();
		if (sessionlist.size()>0){
			for (CiOrSessionDO ciOrSessionDO : sessionlist) {
				if(sessionDOs.getId_ciorsession().equals(ciOrSessionDO.getId_ciorsession())){
					lissession.add(ciOrSessionDO);
				}
			}
			sessionlist.removeAll(lissession);
		}
	}
	
	private void modupdatelist(List<CiOrSessionDO> sessionlist,CiOrSessionDO sessionDOs) throws BizException{
		//更新数据
		if (sessionlist.size()>0){
			for (CiOrSessionDO ciOrSessionDO : sessionlist) {
				if(sessionDOs.getId_ciorsession().equals(ciOrSessionDO.getId_ciorsession())){
					sessionlist.remove(ciOrSessionDO);
					sessionlist.add(sessionDOs);
					break;
					
				}
			}
			
		}else{
			sessionlist.add(sessionDOs);
		}
	}
	
}
