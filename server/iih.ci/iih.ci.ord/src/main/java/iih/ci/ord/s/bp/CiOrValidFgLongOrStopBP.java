package iih.ci.ord.s.bp;

import java.util.ArrayList;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.mutex.d.SrvReactDTO;
import iih.ci.ord.cior.d.CiOrReactLogDO;
import iih.ci.ord.cior.d.CiorderAggExtDO;
import iih.ci.ord.cior.d.OrReactType;
import iih.ci.ord.cior.d.ReactExtOrsAndStopOrsDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.mp.OrMpPlanHandle4CiOrStopBP;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import iih.ci.ord.s.bp.validate.CiOrSrvReactInfo8OrIdGetBP;
import iih.mp.nr.splitplan.i.IResponseOrderHandelService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AuditInfoUtil;

/*
 * 临床在执行的有效长期医嘱“停止”操作BP
 */
public class CiOrValidFgLongOrStopBP {
	/**
	 * 临床在执行的有效长期医嘱“停止”
	 * @param ciors
	 * @param dt_cur
	 * @return
	 * @throws BizException
	 */
	public ArrayList<CiOrderDO> exec(ReactExtOrsAndStopOrsDO reactandstopors,FDateTime dt_cur) throws BizException{
		//有效性校验
		if (CiOrdUtils.isEmpty(reactandstopors)
				|| CiOrdUtils.isEmpty(reactandstopors.getStopordos()))
			return null;
		
		//医嘱重新分组
		ArrayList<CiOrderDO> needupdateors=new ArrayList<CiOrderDO>();
		ArrayList<CiOrderDO> needstopors=new ArrayList<CiOrderDO>();
		FArrayList ciorlist=reactandstopors.getStopordos();
		CiOrderDO  cior=null;
		FDateTime dt_end=null,dt_max=null;//调整之后 dt_max逻辑要删除
		setCommonData();
		ArrayList<CiOrReactLogDO> reactlogs=new ArrayList<CiOrReactLogDO>();
		for(int i=0;i<ciorlist.size();i++){
			cior=(CiOrderDO)ciorlist.get(i);
			reactlogs.addAll(createCiOrReactLogDO(cior,reactandstopors.getReactextdos(),dt_cur));
			dt_end=getOrDtEnd(cior.getDt_last_mp(),dt_cur);
			if(OrSrvSplitUtil.isTrue(cior.getFg_sign()) && 
			   !OrSrvSplitUtil.isTrue(cior.getFg_chk()) && OrSrvSplitUtil.isTrue(cior.getFg_long())){//仅修改医嘱截止时间  
				//李政 添加只有长期医嘱才可以停止 2016-6-2  bug  75345
			
				cior.setDt_end(dt_end); //dt_cur); 2016-07-14 增加该逻辑判断
				//li_cheng修改
				cior.setFg_stop(FBoolean.TRUE);
				String id_org=CiOrdAppUtils.getEnvContext().getOrgId();
				String id_dep=CiOrdAppUtils.getEnvContext().getDeptId();
				//String id_emp=CiOrdAppUtils.getEnvContext().getUserId();
				String id_emp =CiOrdAppUtils.getEnvContext().getStuffId();
				cior.setDt_stop(dt_cur);
				cior.setId_dep_stop(id_dep);
				cior.setId_emp_stop(id_emp);	
				AuditInfoUtil.updateData(cior);
				cior.setStatus(DOStatus.UPDATED);
				needupdateors.add(cior);

			}else{//医嘱停止
				cior.setDt_end(dt_end);
				dt_max=OrSrvSplitUtil.getMaxDT(dt_max, dt_end);
				needstopors.add(cior);
			}

		}
		
		//医嘱变化信息保存
		if(!CiOrdUtils.isEmpty(needupdateors)){
			CiOrdAppUtils.getOrService().update(
					(CiOrderDO[]) CiOrdUtils.list2Array(needupdateors,
							CiOrderDO.class));
		}
		
		//更新医嘱状态未停止
		if(!CiOrdUtils.isEmpty(needstopors)){
			ciOrderStopHandleWithMp(needstopors,dt_max);
		}
		
		//医嘱互斥日志记录保存
		if(!CiOrdUtils.isEmpty(reactlogs)){
			CiOrReactLogDO[] ci=(CiOrReactLogDO[]) CiOrdUtils.list2Array(reactlogs,
					CiOrReactLogDO.class);
			CiOrdAppUtils.getOrreactlogService().insert(ci);
		}
		
		//返回
		return CiOrdUtils.mergeArrayList(needstopors, needupdateors);
	}
	
	/**
	 * 获得医嘱结束时间逻辑
	 * @param dt_last_mp
	 * @param dt_cur
	 * @return
	 */
	private FDateTime getOrDtEnd(FDateTime dt_last_mp,FDateTime dt_cur){
		if(CiOrdUtils.isEmpty(dt_last_mp))return dt_cur;
		if(dt_last_mp.after(dt_cur))return dt_last_mp;
		return dt_cur;
	}
	
	
	private String depid=null;    //科室id
	private String empid=null;    //人员id	
	/**
	 * 生成医嘱互斥日志记录
	 * @param stopor
	 * @param reactextdos
	 * @return
	 * @throws BizException 
	 */
	private ArrayList<CiOrReactLogDO> createCiOrReactLogDO(CiOrderDO stopor,
			FArrayList reactextdos, FDateTime dt_cur) throws BizException {
		//CiorderAggExtDO
		ArrayList<CiOrReactLogDO> rtnlist=new ArrayList<CiOrReactLogDO>();
		ArrayList<String[]> reactinfos=getReactInfos(stopor,reactextdos);
		CiOrReactLogDO rtn=null;
		String[] reactinfo=null;
		for(int i=0;i<reactinfos.size();i++){
			reactinfo=reactinfos.get(i);
			 rtn=new CiOrReactLogDO();
			 //rtn.setId_ciorreactlog();
			 rtn.setId_or(reactinfo[0]);
			 rtn.setId_or_react(stopor.getId_or());  //被排斥、要停止的医嘱
			 rtn.setId_reacttp(reactinfo[1]);
			 rtn.setSd_reacttp(reactinfo[2]);
			 rtn.setDt_react(dt_cur);
			 rtn.setId_dep_react(depid);
			 rtn.setId_emp_react(empid);
			 rtn.setDt_end_orreact(stopor.getDt_end());
			 rtn.setStatus(DOStatus.NEW);
			 AuditInfoUtil.addData(rtn);
			 rtnlist.add(rtn);
		}
		return rtnlist;
	}
	
	/**
	 * 获得排斥医嘱相关信息
	 * 排斥医嘱id  排斥类型id  排斥类型sd
	 * @param stopor
	 * @param reactextdos
	 * @return
	 * @throws BizException 
	 */
	private ArrayList<String[]> getReactInfos(CiOrderDO stopor,FArrayList reactextdos) throws BizException{
		CiorderAggExtDO extdo=(CiorderAggExtDO)reactextdos.get(0);
		ArrayList<String[]> rtn=new ArrayList<String[]>();
		String[] reactinfo=new String[3];
		if(OrReactType.EXCLUDEALL==extdo.getReacttype()){//全排斥的情形
			reactinfo[0]=extdo.getAggdo().getParentDO().getId_or();
			reactinfo[1]=IBdSrvDictCodeConst.SD_REACTTP_EXCLUDEALL_ID;
			reactinfo[2]=IBdSrvDictCodeConst.SD_REACTTP_EXCLUDEALL;
			rtn.add(reactinfo);
		} else if (OrReactType.EXCLUDEGRPIN_SINGLE == extdo.getReacttype()
				|| OrReactType.EXCLUDEGRPIN_MULTI == extdo.getReacttype()) {
			reactinfo[1]=IBdSrvDictCodeConst.SD_REACTTP_GRPINEXCLUDE_ID;
			reactinfo[2]=IBdSrvDictCodeConst.SD_REACTTP_GRPINEXCLUDE;
			if(reactextdos.size()==1){//组内排斥的情形
				reactinfo[0]=extdo.getAggdo().getParentDO().getId_or();
				rtn.add(reactinfo);
			}else{//多组内排斥医嘱的情形
				SrvReactDTO[] reactdos=getSrvReact8OrId(stopor.getId_or());
				if(CiOrdUtils.isEmpty(reactdos))return null;
				for(int i=0;i<reactextdos.size();i++){
					extdo=(CiorderAggExtDO)reactextdos.get(i);
					if(isSrvReact(extdo.getId_reacts(),reactdos)){
						reactinfo=new String[3];
						reactinfo[1]=IBdSrvDictCodeConst.SD_REACTTP_GRPINEXCLUDE_ID;
						reactinfo[2]=IBdSrvDictCodeConst.SD_REACTTP_GRPINEXCLUDE;				
						reactinfo[0]=extdo.getAggdo().getParentDO().getId_or();
						rtn.add(reactinfo);
					}
				}
			}
		}
		return rtn;
	}
	
	/**
	 * 设置公共数据信息
	 * @throws BizException
	 */
	private  void setCommonData() throws BizException{
		depid=CiOrdAppUtils.getEnvContext().getDeptId();    //科室id
		empid=CiOrdAppUtils.getEnvContext().getUserId();    //人员id
		empid=CiOrdUtils.getPsnDocID(empid);
	}
	
	/**
	 * 获得医嘱排斥组相关信息
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	private SrvReactDTO[] getSrvReact8OrId(String id_or) throws BizException{
		CiOrSrvReactInfo8OrIdGetBP bp=new CiOrSrvReactInfo8OrIdGetBP();
		return bp.exec(id_or);
	}
	
	/**
	 * 获得排斥组连接串
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	private boolean isSrvReact(String id_reacts,SrvReactDTO[] srvreactdtos) throws BizException{
		for(int i=0;i<srvreactdtos.length;i++){
			if(CiOrdUtils.isInStr(srvreactdtos[i].getId_srvreact(), id_reacts)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 医嘱停止时：拆分数据的反向处理逻辑
	 * @param needstopors
	 * @param dt_end
	 * @throws BizException
	 */
	private void orMpPlanHandle4CiOrStop(CiOrderDO[] needstopors,FDateTime dt_end) throws BizException{
		OrMpPlanHandle4CiOrStopBP bp=new OrMpPlanHandle4CiOrStopBP();
		bp.exec(needstopors, dt_end);
	}
	
	/**
	 *  医嘱停止
	 * @param needstopors
	 * @param dt_cur
	 * @throws BizException
	 */
	private void ciOrderStopBasic(CiOrderDO[] needstopors,FDateTime dt_cur) throws BizException{
		CiOrderStopBasicBP bp1=new CiOrderStopBasicBP();
		bp1.exec(needstopors, dt_cur);
	}
	
	/**
	 * 医嘱停止处理
	 * 含医嘱执行计划数据相关处理逻辑
	 * @param needstopors
	 * @param dt_cur
	 * @throws BizException
	 */
	private void ciOrderStopHandleWithMp(ArrayList<CiOrderDO> needstopors,FDateTime dt_max) throws BizException{
		//数据转换
		CiOrderDO[] ciors=(CiOrderDO[]) CiOrdUtils.list2Array(needstopors,CiOrderDO.class);
		
		//医嘱停止基本处理
		ciOrderStopBasic(ciors,null);
		
		//医嘱停止时，医嘱执行计划相关数据处理
		orMpPlanHandle4CiOrStop(ciors,dt_max);
	}
}
