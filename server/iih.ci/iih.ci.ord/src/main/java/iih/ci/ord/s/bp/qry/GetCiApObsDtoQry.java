package iih.ci.ord.s.bp.qry;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetCiApObsDtoQry implements ITransQry {
   
	private static String defaultDatePattern = "yyyy-MM-dd 00:00:00";
	 
	private String _id_dep_exe;
	private String[] _entps;
	private FDateTime _dtSignB;
	private FDateTime _dtSignE;
	
	 public GetCiApObsDtoQry(String id_dep_exe,String[] entps,FDateTime dtSignB,
	  		  FDateTime dtSignE){
			this._id_dep_exe  = id_dep_exe;
			this._entps = entps;
	
			this._dtSignB = convert(dtSignB.getDate()," 00:00:00");
			this._dtSignE = convert(dtSignE.getDate()," 23:59:59");
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(this._id_dep_exe);
		//sqlparam.addParam(getEntps(this._entps));
		sqlparam.addParam(this._dtSignB);
		sqlparam.addParam(this._dtSignE);
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}

	 private String getSql(){
		 return " Select   distinct   "+
				" CI_ORDER.id_or, "+
				" CI_ORDER.Id_Dep_Or,  "+
				" CI_ORDER. name_or,  "+
				" CI_ORDER. content_or,  "+
				" CI_ORDER. id_en,     "+
				" CI_ORDER.ID_ENTP,   "+
				" obs.dt_plan dt_effe,    "+
				" CI_ORDER. id_emp_sign,  "+
				" psndoc.name  name_emp_sign,"+
				" CI_ORDER. id_dep_sign, "+
				" bddep.name  name_dep_sign,"+
				" CI_OR_SRV_SET.id_srvset,  "+
				" ci_or_srv.name  name_srv,"+
				" ci_or_srv.id_srv,"+
				" CI_OR_SRV_SET.body_name, "+
				" CI_OR_SRV_SET.sd_pos,    "+
				" CI_OR_SRV_SET.quan_medu,  "+
				" CI_OR_SRV_SET.id_medu,   "+
				" pat.sd_sex, "+
				" pat.dt_birth, "+
				" obs.fg_urgent  fg_urgent, "+
				 " obs.sd_su_obs"+
				" From CI_ORDER" +
				"  inner join ci_ap_obs obs on obs.id_or = ci_order.id_or and obs.sd_su_obs ='0' "+
				" left outer join ci_or_srv  on CI_ORDER.id_or = ci_or_srv.id_or  "+
				" left outer join CI_OR_SRV_SET on CI_ORDER.id_or= CI_OR_SRV_SET.id_or "+
				" left outer join pi_pat  pat on pat.id_pat = CI_ORDER.Id_Pat  "+
				" left outer join bd_psndoc psndoc on psndoc.id_psndoc = CI_ORDER.id_emp_sign  "+
				"left outer join bd_dep bddep on bddep.id_dep = CI_ORDER.Id_Dep_Sign  "+
				" where   ( CI_ORder.sd_su_or ='"+ICiDictCodeConst.SD_SU_CHECKTHROUGH+"'"+
				  "  or  CI_ORder.sd_su_or ='"+ICiDictCodeConst.SD_SU_SIGN+"')"+
				  "  and obs.sd_su_obs = '0'  and CI_OR_SRV.fg_bl ='Y' "+
				 "  and ci_order.code_entp  in  "+getEntps(this._entps)+
				 "   and CI_OR_SRV.id_dep_mp = ?"+
				 "  and  CI_ORDER.Sd_Su_Bl !='2' "+
				 " and CI_ORDER.dt_effe >= ? and  CI_ORDER.dt_effe <= ?"
				;
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
	 
	   private FDateTime convert(FDate fdateTime,String  format){
		   if(fdateTime != null && !fdateTime.equals("")){
			   return new FDateTime(fdateTime,new FTime(format));
		   }else{
			   return null;
		   }
		 
	   }
	 /** 
	     * 获得默认的 date pattern 
	     */  
	    public static String getDatePattern()  
	    {  
	        return defaultDatePattern;  
	    }  
	 //测试 sql
	/* Select 
	 CI_ORDER.id_or,
	 CI_ORDER.Id_Dep_Or, --开立部门
	 CI_ORDER. name_or,  -- //医嘱名称 
	 CI_ORDER. content_or,  --//医嘱内容
	 CI_ORDER. id_en,      --//就诊id
	 CI_ORDER.ID_ENTP,    --//就诊类型
	 CI_ORDER. dt_effe,     --//计划检查时间（生效日期）
	 CI_ORDER. id_emp_sign,  --//签署人
	 psndoc.name  name_emp_sign,
	 CI_ORDER. id_dep_sign,   --//签署科室
	 bddep.name  name_dep_sign,
	 CI_OR_SRV_SET.id_srvset,  --//找到服务名称
	 ci_or_srv.name  name_srv,
	 CI_OR_SRV_SET.body_name, --//部位名称
	 CI_OR_SRV_SET.sd_pos,    --//体位名称
	 CI_OR_SRV_SET.quan_medu,  --//医学单位数值
	 CI_OR_SRV_SET.id_medu,    --//医学单位
	 pat.sd_sex,
	 pat.dt_birth
	 From CI_ORDER
	 left outer join ci_or_srv  on CI_ORDER.id_or = ci_or_srv.id_or
	 left outer join CI_OR_SRV_SET on CI_ORDER.id_or= CI_OR_SRV_SET.id_or
	 left outer join pi_pat  pat on pat.id_pat = CI_ORDER.Id_Pat
	 left outer join bd_psndoc psndoc on psndoc.id_psndoc = CI_ORDER.id_emp_sign
	 left outer join bd_dep bddep on bddep.id_dep = CI_ORDER.Id_Dep_Sign
	 where 
	    CI_ORder.sd_su_or ='20'
	  and ci_order in ('00','10','30')
	  and CI_ORDER.dt_effe > '' and  CI_ORDER.dt_effe <''
	  and CI_OR_SRV.id_dep_mp =''*/
}
