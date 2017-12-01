/**
 * 
 */
package iih.ci.ord.s.bp.qry;

import iih.ci.ord.pub.CiOrdUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @ClassName: getRecipeByIdPresQry
 * @Description: 药品处方信息
 * @author Comsys-li_zheng
 * @date 2016年9月6日 下午5:07:05
 * @Package iih.ci.ord.s.bp.qry
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getRecipeByIdPresQry implements ITransQry {
	   private String _id_pres;
		public getRecipeByIdPresQry(String[] id_pres){
			this._id_pres =getId_ents(id_pres);
		}
		/* (non-Javadoc)
		 * @see xap.sys.appfw.orm.utils.ITransQry#getQryParameter(java.lang.StringBuffer)
		 */
		@Override
		public SqlParam getQryParameter(StringBuffer arg0) {
			// TODO Auto-generated method stub
			SqlParam param = new SqlParam();
			return param;
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
			StringBuffer sb = new StringBuffer();
			 sb.append(" select   cipres.id_pres  id_pres,");
			 sb.append("  ''  sortno , cipres.str_id_di didef_code , ");
			 sb.append("  cipres.str_name_di  didef_name,    ");
			 sb.append("  ''  mr_content,  cipres.id_dep_or id_dep_or,   ");
			 sb.append("  cipres.id_emp_or  id_emp_or ,");
			 sb.append("  cipres.id_dep_or  id_dep_name,  ");
			 sb.append("  bd_psndoc.name  id_emp_name,  ");
			 sb.append("  cipres.id_prestp  id_prestp,  ");
			 sb.append("  cipres.sd_prestp  sd_prestp ,     ");
			 sb.append("  ''  helpmedicineflag,  ");
			 sb.append("  cipres.dt_entry  dt_entry,  ");
			 sb.append("  ''  des, '' registertradeno  ,   ");
			 sb.append(" '' billstype , '' hospital_dept_name ,  ");
			 sb.append(" cipres.id_pati  id_pat  ,  ");
			 sb.append(" cipres.id_en    id_en, ");
			 sb.append(" cipres.fg_hp_pres  recipetype, ");
			 sb.append(" dep.code  code_dep, ");
			 sb.append(" udi.name   prestp_name ");
			 sb.append(" from    ci_pres cipres  ");
			 sb.append("   left join bd_dep dep on dep.id_dep = cipres.id_dep_or ");
			 sb.append("    left join bd_udidoc udi on udi.id_udidoc = cipres.id_prestp ");
			 sb.append("  left join bd_psndoc bd_psndoc on bd_psndoc.id_psndoc =cipres.id_emp_or ");
			 sb.append("    where cipres.id_pres in ("+this._id_pres+")");
		     return sb.toString();
		}
		
		/**
		 * 
		 * @param id_ents
		 * @return
		 */
		private String getId_ents(String[] id_pres){
			return CiOrdUtils.IdsConveretCharacterString(id_pres);
		}
	}
