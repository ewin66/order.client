package iih.ci.ord.s.bp.qry;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetConsDTOQry implements ITransQry {
	private String _id_dep;
	private String _cons_su;

	public GetConsDTOQry(String id_dep,String str){
		_id_dep=id_dep;
		_cons_su=str;
	}
	

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(_id_dep);
		rtnParam.addParam(_cons_su);
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		//		String str="select distinct t1.id_invitecons as id_emsconsitem,";
		//		str+="t2.id_apcons as id_srv,t2.id_or,t2.fg_urgent,t2.dt_plan,t2.place as name_place,t2.des_emr,t2.des_psp,";
		//		str+="t2.id_constp,t2.sd_constp,t2.id_su_cons,t2.sd_su_cons,";
		//		str+="t3.dt_entry as dt_creat,t3.id_emp_or   as  id_emp_cons,t3.id_en,";
		//		str+="t4.name_pat,";
		//		str+="t5.name as name_su_cons,t6.name as name_dep_cons,t7.name as name_emp_cons,";
		//		str+="t10.name as name_di,t11.id_bed as bed_no,t12.name as name_constp";
		//		str+=" from ci_invite_cons t1 left join ci_ap_cons t2 on t1.id_apcons = t2.id_apcons";
		//		str+=" left join ci_order t3 on t2.id_or = t3.id_or";
		//		str+=" left join en_ent t4 on t3.id_en = t4.id_ent";
		//		str+=" left join bd_udidoc t5 on t2.id_su_cons = t5.id_udidoc";
		//		str+=" left join bd_dep t6 on t3.id_dep_or = t6.id_dep";
		//		str+=" left join bd_psndoc t7 on t3.id_emp_or = t7.id_psndoc";
		//		str+=" left join ci_di t8 on t3.id_en = t8.id_ent ";
		//		str+=" left join ci_di_itm t9 on t8.id_cidi = t9.id_cidi and t9.fg_majdi='Y'";
		//		str+=" left join bd_di_def t10 on t9.id_di = t10.id_di";
		//		str+=" left join en_ent_ip t11 on t3.id_en = t11.id_ent";
		//		str+=" left join bd_udidoc t12 on t2.id_constp = t12.id_udidoc";
		//		str+=" where t1.id_dep = '"+_id_dep+"' ";
		//		str+=" and t3.sd_su_or in ('"+ICiDictCodeConst.SD_SU_SIGN+"','"+ICiDictCodeConst.SD_SU_CHECKTHROUGH+"')";
		//		str+=" and t3.ds='0'";
		//		if(!_cons_su.equals("")){
		//			str+=_cons_su;
		//		}
		//		str+=" order by t3.dt_entry desc";

		String wherestr="select distinct "+
//						"t1.id_invitecons id_emsconsitem,\n" +
//				"       t1.id_emp,\n" + 
				"       t2.id_apcons,\n" + 
//				"       t2.id_or,\n" + 
				"       t2.fg_urgent,\n" + 
				"       t2.dt_plan,\n" + 
//				"       t2.place         name_place,\n" + 
//				"       t2.des_emr,\n" + 
//				"       t2.des_psp,\n" + 
//				"       t2.id_constp,\n" + 
//				"       t2.sd_constp,\n" + 
//				"       t2.id_su_cons,\n" + 
				"       t2.sd_su_cons,\n" + 
				"       t3.dt_entry,\n" + 
//				"       t3.id_emp_or     id_emp_cons,\n" + 
				"       t3.id_en,\n" + 
				"       t4.name_pat,\n" + 
				"       t4.code    code_en,\n" + 
				"       t5.name          name_su_cons,\n" + 
				"       t6.name          name_dep_or,\n" + 
//				"       t7.name          emp_name,\n" + 
//				"       t8.ID_DIDEF_DIS id_di,\n" + 
//				"       t8.NAME_DIDEF_DIS name_di,\n" + 
				"       t12.name_bed       pat_bedno,\n" + 
				"       t13.fg_emptitlelimit,\n" +
				"       t13.id_emptitle,\n" +
				"       t13.sd_emptitle,\n" +
				"       t13.fg_inorg\n" + 
				"  from ci_invite_cons t1\n" + 
				"  left outer join ci_ap_cons t2\n" + 
				"    on t1.id_apcons = t2.id_apcons\n" + 
				"  left outer join ci_order t3\n" + 
				"    on t2.id_or = t3.id_or\n" + 
				"  left outer join en_ent t4\n" + 
				"    on t3.id_en = t4.id_ent\n" + 
				"  left outer join bd_udidoc t5\n" + 
				"    on t2.id_su_cons = t5.id_udidoc\n" + 
				"  left outer join bd_dep t6\n" + 
				"    on t3.id_dep_or = t6.id_dep\n" + 
//				"  left outer join bd_psndoc t7\n" + 
//				"    on t3.id_emp_or = t7.id_psndoc\n" + 
//				"    left join en_ent_di t8\n" + 
//				"    on t3.id_en=t8.id_ent and t8.fg_maj='Y'\n" + 
				"  left outer join en_ent_ip t11\n" + 
				"    on t3.id_en = t11.id_ent\n" + 
				"  left outer join en_ent_bed t12\n" + 
				"    on t11.id_bed = t12.id_bed\n" + 
				"  left outer join bd_srv_cons t13\n" + 
				"    on t3.id_srv = t13.id_srv\n" + 
				" where \n" + //t1.id_dep = '"+_id_dep+"'
				" t3.sd_su_or in ('"+ICiDictCodeConst.SD_SU_SIGN+"','"+ICiDictCodeConst.SD_SU_CHECKTHROUGH+"')\n" + 
				"   and t3.ds = '0'\n"
//				" and t11.fg_doc_commit='N'"
				;  
		if(!_cons_su.equals("")){
			wherestr+=_cons_su;
		} 
		wherestr+=" order by t3.dt_entry desc";
		
		return wherestr;
	}

}
