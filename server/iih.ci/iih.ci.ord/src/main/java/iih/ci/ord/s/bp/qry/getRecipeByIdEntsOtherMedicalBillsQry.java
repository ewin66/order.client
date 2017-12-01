/**
 * 
 */
package iih.ci.ord.s.bp.qry;

import iih.ci.ord.pub.CiOrdUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @ClassName: getRecipeByIdEntsOtherMedicalBillsQry
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年8月29日 下午8:25:11
 * @Package iih.ci.ord.s.bp.qry
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getRecipeByIdEntsOtherMedicalBillsQry implements ITransQry {
	   private String _id_ents;
		public getRecipeByIdEntsOtherMedicalBillsQry(String[] id_ents){
			this._id_ents =getId_ents(id_ents);
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
			 sb.append(" select  ci_order.code_or  id_pres,'' sortno, '' didef_code,");
			 sb.append("   '' didef_name, '' mr_content,ci_order.id_dep_or id_dep_or, ");
			 sb.append("  '' code_dep, '' depcode_hp,'' depname_hp , ci_order.id_emp_or id_emp_or,   ");
			 sb.append("   bd_dep.name id_dep_name,  bd_psndoc.name id_emp_name,  ");
			 sb.append("   '' id_prestp ,'' sd_prestp,'' helpmedicineflag,  ci_order.dt_effe dt_entry,");
			 sb.append("  ci_order.des_or  des, ''registertradeno ,'' billstype, '' hospital_dept_name,  ");
			 sb.append("   ci_order.id_pat id_pat ,ci_order.id_en id_en,'' prestp_name,p.fg_selfpay recipetype,  ");
			 sb.append("   '' remark  ");
			 sb.append("  from ci_order ci_order    ");
			 sb.append("  left outer join ci_or_srv ci_or_srv on ci_order.id_or = ci_or_srv.id_or ");
			 sb.append("  left outer join bd_dep bd_dep on bd_dep.id_dep = ci_order.id_dep_or  ");
			 sb.append("  left outer join  bd_psndoc bd_psndoc on bd_psndoc.id_psndoc = ci_order.id_emp_or    ");
			 sb.append("  where  ci_order.sd_srvtp not like '01%'   ");
			 sb.append(" and  ci_order.id_en in ("+this._id_ents+")");

		     return sb.toString();
		}
		
		/**
		 * 
		 * @param id_ents
		 * @return
		 */
		private String getId_ents(String[] id_ents){
			return CiOrdUtils.IdsConveretCharacterString(id_ents);
		}
	}

