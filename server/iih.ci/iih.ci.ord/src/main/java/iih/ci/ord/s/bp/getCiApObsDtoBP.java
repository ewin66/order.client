package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.dto.appobsdto.d.AppObsDto;
import iih.ci.ord.s.bp.qry.getCiApObsDtoIdEnQry;
import iih.ci.ord.s.bp.qry.getCiApObsDtoIdPatAndDateQry;
import iih.ci.ord.s.bp.qry.getCiApObsDtoIdPatQry;
import iih.ci.ord.s.bp.qry.getCiApObsDtoNoApplyFormQry;
import iih.ci.ord.s.bp.qry.GetCiApObsDtoQry;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 检查申请未执行列表
 * @author li_zheng
 *
 */
public class getCiApObsDtoBP {
	
	
	
	
	
	  /**
	   * 检查申请 未执行的列表
	   * @param id_dep_exe  执行科室
	   * @param entps     就诊类型
	   * @param dtSignB   开始时间
	   * @param dtSignE   结束时间
	   * @return  AppObsDto[]  
	   * @throws BizException
	   */
	public PagingRtnData<AppObsDto> execPage(PaginationInfo pg,String id_dep_exe,String[] entps,FDateTime dtSignB,
		  FDateTime dtSignE,String[] sd_su_bl)throws BizException{
		 if(dtSignB == null || dtSignE == null)  new BizException("parameter dtSignB ,dtSignE is null");
		 String sql = getSql(entps,sd_su_bl);
		  SqlParam param = new SqlParam();
		  param.addParam(id_dep_exe);
			//sqlparam.addParam(getEntps(this._entps));
		  param.addParam(convert(dtSignB.getDate()," 00:00:00"));
		  param.addParam(convert(dtSignE.getDate()," 23:59:59"));
		 return  getRtnData(pg, sql, param);
	}
	
	   private FDateTime convert(FDate fdateTime,String  format){
		   if(fdateTime != null && !fdateTime.equals("")){
			   return new FDateTime(fdateTime,new FTime(format));
		   }else{
			   return null;
		   }
		 
	   }
	private String getSql(String[] entps,String[] sd_su_bl){
	    return  " Select   distinct  "+ 
	         " ci_order.id_or,   "+ 
	         " ci_order.Id_Dep_Or,   "+ 
	         " ci_order.name_or,  "+ 
	         " ci_order.content_or,   "+ 
	         " ci_order.id_en,     "+ 
	         " ci_order.ID_ENTP,   "+ 
	         " ci_order.Id_Dep_Mp Id_dep_mp,"+
	         " obs.dt_plan dt_effe,    "+  
	         " ci_order.id_emp_sign,  "+  
	         " psndoc.name name_emp_sign, "+ 
	         " ci_order.id_dep_sign,  "+ 
	         " bddep.name name_dep_sign, "+ 
	         " '' id_srvset,   "+ 
	         " ci_order.name_or name_srv, "+ 
	         " ci_order.id_srv, "+
	         " '' body_name,  "+ 
	         " '' sd_pos,     "+ 
	         " '' quan_medu,   "+ 
	         " '' id_medu,   "+ 
	         " pat.sd_sex,  "+ 
	         " pat.dt_birth,  "+ 
	         " obs.fg_urgent  fg_urgent,  "+ 
	         " obs.sd_su_obs "+ 
	         " From CI_ORDER "+ 
	         " inner join ci_ap_obs obs on obs.id_or = ci_order.id_or and obs.sd_su_obs ='0'  "+ 
	         //" left outer join ci_or_srv  on ci_order.id_or = ci_or_srv.id_or  and ci_or_srv.fg_or='Y' "+  当服务套时查询错误，改为使用ci_order中的主服务
	         " left outer join pi_pat  pat on pat.id_pat = ci_order.Id_Pat "+   
	         " left outer join bd_psndoc psndoc on psndoc.id_psndoc = ci_order.id_emp_sign  "+ 
	         " left outer join bd_dep bddep on bddep.id_dep = ci_order.Id_Dep_Sign   "+ 
	         " where   ( ci_order.sd_su_or ='"+ICiDictCodeConst.SD_SU_CHECKTHROUGH+"'"+
	         " or  ci_order.sd_su_or ='"+ICiDictCodeConst.SD_SU_SIGN+"')"+
	         " and obs.sd_su_obs = '0'  "+
	         " and  CI_ORDER.Sd_Su_Bl in ("+StrMerge(sd_su_bl)+") "+
	         " and ci_order.code_entp  in  "+getEntps(entps)+
	         " and ci_order.id_dep_mp = ?"+
	         " and ci_order.dt_effe >= ? and  ci_order.dt_effe <= ?";
	}
	
	
	/**
	 * 字符合并
	 * 
	 * @param str
	 * @return
	 */
	private  String StrMerge(String[] strs) {

		if (strs.length == 0)
			return "";
		String resultStr = "";
		for (String str : strs) {
			resultStr += ((resultStr.length() == 0 ? "" : ",") + "'" + str + "'");
		}

		return resultStr;
	}
	
	 /**
	  * 
	  * @param entps
	  * @return
	  */
	 private String getEntps(String[] entps){
		 if(entps == null || entps.length == 0) new BizException("就诊类型为空！"); 
		 String entp = "";
		 entp += "(";
		 for(String tp:entps){
			 entp += "'"+tp +"',";
		 }
		 entp = entp.substring(0, entp.lastIndexOf(","));
		 entp += ")";
		 return entp;
	 }
	/**
	 * 查询数据
	 * 
	 * @param pg
	 * @param sql
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<AppObsDto> getRtnData(PaginationInfo pg, String sql, SqlParam param) throws BizException{
		PagingServiceImpl<AppObsDto> pageQryService = new PagingServiceImpl<AppObsDto>();
		return pageQryService.findByPageInfo(new AppObsDto(), pg, sql, "", param);
	}
	
	
	
	  /**
	   * 检查申请 未执行的列表
	   * @param id_dep_exe  执行科室
	   * @param entps     就诊类型
	   * @param dtSignB   开始时间
	   * @param dtSignE   结束时间
	   * @return  AppObsDto[]  
	   * @throws BizException
	   */
	public AppObsDto[] exec(String id_dep_exe,String[] entps,FDateTime dtSignB,
  		  FDateTime dtSignE)throws BizException{
		 if(dtSignB == null || dtSignE == null)  new BizException("parameter dtSignB ,dtSignE is null");
		GetCiApObsDtoQry qry = new GetCiApObsDtoQry(id_dep_exe,entps,dtSignB,dtSignE);
		AppObsDto[] rtn = (AppObsDto[])AppFwUtil.getDORstWithDao(qry, AppObsDto.class);
		return rtn;
	}
	
	
	
	
	   /**
	    * 检查申请 未执行的列表 根据就诊id_en
	    * @param id_en
	    * @return AppObsDto
	    * @throws BizException
	    */
	public AppObsDto[]  getCiApObsDtoIdEnt(String id_en)throws BizException{
		 if(id_en == null)  new BizException("parameter id_en  is null");
		getCiApObsDtoIdEnQry qry = new getCiApObsDtoIdEnQry(id_en,"");
		AppObsDto[] rtn = (AppObsDto[])AppFwUtil.getDORstWithDao(qry, AppObsDto.class);
		return rtn;
	}
	
	   /**
	    * 检查申请 未执行的列表 根据就诊id_en
	    * @param id_en
	    * @return AppObsDto
	    * @throws BizException
	    */
	public AppObsDto[]  getCiApObsDtoIdEnt2(String id_en)throws BizException{
		 if(id_en == null)  new BizException("parameter id_en  is null");
		getCiApObsDtoIdEnQry qry = new getCiApObsDtoIdEnQry(id_en,"2");
		AppObsDto[] rtn = (AppObsDto[])AppFwUtil.getDORstWithDao(qry, AppObsDto.class);
		return rtn;
	}
	 /**
	   * 检查医嘱及部位查询接口（根据申请单编号查询）
	   * @return  AppObsDto[]  
	   * @throws BizException
	   */
	 public AppObsDto[] getCiApObsDtoNOApplyForm(String no_ApplyForm)throws BizException{
		 if(no_ApplyForm == null)  new BizException("parameter no_ApplyForm  is null");
		  String[] sd_su_bl =  {"0","1"};
		 getCiApObsDtoNoApplyFormQry qry = new getCiApObsDtoNoApplyFormQry(no_ApplyForm,"",sd_su_bl);
			AppObsDto[] rtn = (AppObsDto[])AppFwUtil.getDORstWithDao(qry, AppObsDto.class);
			return rtn;
	 }
	 /**
	   * 检查医嘱及部位查询接口（根据申请单编号查询）
	   * @return  AppObsDto[]  
	   * @throws BizException
	   */
	 public AppObsDto[] getCiApObsDtoNOApplyForm2(String no_ApplyForm,String[] sd_su_bl)throws BizException{
		 if(no_ApplyForm == null  || sd_su_bl== null || sd_su_bl.length==0)  new BizException("parameter no_ApplyForm  is null");
		 getCiApObsDtoNoApplyFormQry qry = new getCiApObsDtoNoApplyFormQry(no_ApplyForm,"2", sd_su_bl);
			AppObsDto[] rtn = (AppObsDto[])AppFwUtil.getDORstWithDao(qry, AppObsDto.class);
			return rtn;
	 }
	 /**
	   * 检查医嘱及部位查询接口（根据患者ID查询）
	   * @return  AppObsDto[]  
	   * @throws BizException
	   */
	 public  AppObsDto[]  getCiApObsDtoIdPat(String id_pat )throws BizException{
		 if(id_pat == null)  new BizException("parameter id_pat  is null");
		 String[] sd_su_bl =  {"0","1"};
		 getCiApObsDtoIdPatQry qry = new getCiApObsDtoIdPatQry(id_pat,"",sd_su_bl);
			AppObsDto[] rtn = (AppObsDto[])AppFwUtil.getDORstWithDao(qry, AppObsDto.class);
			return rtn;
	 }
	 /**
	   * 检查医嘱及部位查询接口（根据患者ID查询）
	   * @return  AppObsDto[]  
	   * @throws BizException
	   */
	 public  AppObsDto[]  getCiApObsDtoIdPat2(String id_pat,String[] sd_su_bl )throws BizException{
		 if(id_pat == null || sd_su_bl== null || sd_su_bl.length==0)  new BizException("parameter id_pat  is null");
		   getCiApObsDtoIdPatQry qry = new getCiApObsDtoIdPatQry(id_pat,"2",sd_su_bl);
			AppObsDto[] rtn = (AppObsDto[])AppFwUtil.getDORstWithDao(qry, AppObsDto.class);
			return rtn;
	 }
	/**
	 * 查询患者的检查申请单
	 * @param id_pat 患者id
	 * @param dtSignB 开始时间
	 * @param dtSignE 结束时间
	 * @param obs_su  检查的状态
	 * @return AppObsDto[] 返回的集合
	 * @throws BizException
	 */
	public AppObsDto[] getCiApObsDtoIdPatAndDate(String[] id_pat,FDateTime dtSignB,FDateTime dtSignE,String[] obs_su) throws BizException{
		if(dtSignB == null)  new BizException("parameter dtSignB  is null");
		getCiApObsDtoIdPatAndDateQry qry = new  getCiApObsDtoIdPatAndDateQry(id_pat,dtSignB,dtSignE,obs_su);
		AppObsDto[] rtn = (AppObsDto[])AppFwUtil.getDORstWithDao(qry, AppObsDto.class);
		return rtn;
	}
}
