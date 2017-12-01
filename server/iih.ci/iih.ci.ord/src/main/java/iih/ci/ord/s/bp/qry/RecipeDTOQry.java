/**
 * 
 */
package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @ClassName: RecipeDTOQry
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年3月14日 下午8:07:24
 * @Package iih.ci.ord.s.bp.qry
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class RecipeDTOQry implements ITransQry  {

	 private String  _pres;
	  public RecipeDTOQry(String pres){
		  this._pres = pres;
	  }
	/* (non-Javadoc)
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQryParameter(java.lang.StringBuffer)
	 */
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam  sqlparam = new SqlParam();
		 //sqlparam.addParam(this._pres);
		return sqlparam;
	}

	/* (non-Javadoc)
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQrySQLStr()
	 */
	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}
  
	 private String getSql(){
		 return "  select  "
     +" cipres.id_pres  id_pres,   "                                          
     +" ''  sortno ,        "                                    
     +" cipres.str_id_di didef_code ,"                                                
     +" cipres.str_name_di  didef_name,   "                                                  
     +" ''  mr_content,         "                                    
     +" cipres.id_dep_or id_dep_or, "                                                    
     +" cipres.id_emp_or  id_emp_or ,  "                                                  
     +"  DEP.Name  id_dep_name,   "                                          
     +" bd_psndoc.name  id_emp_name,   "                                
     +" cipres.id_prestp  id_prestp, "                                            
     +" cipres.sd_prestp  sd_prestp ,   "                                              
     +" ''  helpmedicineflag,   "                                                  
     +" cipres.dt_entry	dt_entry,  "				 	 	 	 	 	 				 	 			 	 	 	
	 +" 		'' des, 	"		 	 	 	 	 	 				 	 			 	 	 	
	 +"		'' registertradeno	, 	" 				 	 	 	 	 	 				 	 			 	 	 	
	 +"		'' billstype , 	 	"			 	 	 	 	 	 				 	 			 	 	 	
	 +"		'' hospital_dept_name ,"  				 	 	 	 	 	 				 	 			 	 	 	
 	 +"	  cipres.id_pati  id_pat	, " 	 				 	 	 	 	 	 				 	 			 	 	 	
	 +"  cipres.id_en  	id_en,"
	 + "  dep.code  code_dep, "
	 + "   udi.name   prestp_name,   CIPRES.fg_hp_pres recipetype "
     +"   from    ci_pres cipres "
     + "  left join bd_dep dep on dep.id_dep = cipres.id_dep_or"
     + "  left join bd_udidoc udi on udi.id_udidoc = cipres.id_prestp "
     +"   left outer join bd_psndoc bd_psndoc on  bd_psndoc.id_psndoc = CIPRES.ID_EMP_OR "
     + "  left join en_ent EN on EN.id_ent = cipres.id_en"
     + "   where EN.fg_canc='N' and cipres.id_pres  in("+this._pres+")";
	   
	 }
}
