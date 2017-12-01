package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据服务id查询 服务关联的物品
 *
 */
public class CiorderDrugQry  implements ITransQry{

	private String _id;
	private String _fldname;
	private String _mmtp;
	
	
	

	/**
	 * 
	 * @param id id_srv
	 * @param fldname 字段名称（暂时没用）
	 */
	public CiorderDrugQry(String id,String fldname){
		_id=id;
		_fldname=fldname;
	}
	public CiorderDrugQry(String mmtp){
		_mmtp=mmtp;
	}
	
	 
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(_id);
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		return " SELECT '' as name_heath, '' as limit,A.id_srvtp,A.sd_srvtp,A.id_srv,A.code as code_srv, A.name as name_srv,A.id_unit_med,"
               +" B.id_mm,B.spec as spec_mm,B.name as name_mm,B.price,B.des as des_mm,B.sup_name as name_sup,B.code as code_mm ,"
               +" drug.id_dosage id_dosage,drug.sd_dosage sd_dosage,drug.id_pharm id_pharm,drug.sd_pharm sd_pharm, '' id_antipsy,"
               +" drug.sd_pois sd_pois,drug.id_pois id_pois,drug.id_anti id_anti,drug.sd_anti sd_anti,drug.fg_pois fg_pois,drug.fg_anti fg_anti,B.id_mmtp,B.sd_mmtp,"
               +" B.factor_sb as factor_cb,factor_mb,B.sd_opmutp,B.sd_mupkgutp,B.id_val,B.sd_val,'' id_antipsy, '' sd_antipsy,D.name as name_unit_med,"
    		   +" C.id_measdoc as id_unit_sale,C.name as name_unit_sale , E.id_measdoc as id_unit_base, E.name as name_unit_base,"
    		   +" A.quan_med,A.id_freq,A.id_route,A.id_routedes,A.id_boil,A.id_boildes,B.Id_Srvskin,B.Fg_skin as fg_skintest, A.fg_mm,A.fg_ctm,F.name as Name_boildes,freq.freqct,freq.SD_FREQUNITCT,"
    		   +" A.sd_mmbind_op,A.sd_mmbind_er,A.fg_bl "
    		   +" FROM BD_SRV A LEFT OUTER JOIN bd_mm B on A.id_srv = B.id_srv  and B.ds ='0' and A.id_srv in ( '"+_id+"') "
    		   +" left outer join bd_srv_drug  drug on drug.id_srv = A.ID_SRV"
    		   +" LEFT OUTER JOIN bd_measdoc C on B.id_unit_pkgsp=C.id_measdoc "
    		   +" LEFT OUTER JOIN bd_measdoc D on A.id_unit_med=D.id_measdoc"
    		   +" LEFT OUTER JOIN bd_measdoc E on B.id_unit_pkgbase=E.id_measdoc "
    		   +" LEFT OUTER  JOIN bd_boil_des F  on A.Id_Boildes = F.Id_Boildes "
    		   +" Left outer join bd_freq freq on freq.id_freq = A.id_freq"
              +" WHERE  B.fg_active =  'Y' and A.id_srv in ( '"+_id+"')";   //原有的sql串放到文档最后了
	}

	public String getMmByMmtp() {

		if(_mmtp==null)return null;
		String str="select '' as name_heath, '' as limit"
				+ ",t2.id_mm,t2.spec as spec_mm,t2.name as name_mm,t2.price,t2.des as des,t2.sup_name as vender";
		str+=" from bd_mm t2";
		str+="  where t2.id_mmtp='"+_mmtp+"'";
		return str;
	}
 
   //根据物品和单位类型参数配置 获取物品的单位集合
	public String GeUnitByMmAndParmSQL(String id_mm,String id_unit_pkgtps) {
		String str="select WM_CONCAT(id_unit_pkg) as Str_unit_pkg_ids from bd_mm_pkgu  t    where  id_mmpkgutp  in("+id_unit_pkgtps+")   and id_mm='"+id_mm+"' and ds=0";
		return str;
	}
	
//	String str="select '' as name_heath, '' as limit,t.id_srvtp,t.sd_srvtp,t.id_srv,t.code as code_srv, t.name as name_srv,t.id_unit_med"
//			+ ",t2.id_mm,t2.spec as spec_mm,t2.name as name_mm,t2.price,t2.des as des_mm,t2.sup_name as name_sup,";
//	str+="t2.code as code_mm ,t2.id_dosage,t2.sd_dosage,t2.id_pharm,t2.sd_pharm,id_pois,"
//			+ "t2.sd_pois,t2.id_anti,t2.sd_anti,t2.id_mmtp,t2.sd_mmtp,t2.factor_sb as factor_cb,factor_mb,"
//			+ "t2.id_val,t2.sd_val,t2.id_antipsy,t2.sd_antipsy,"
//	        + " t2.id_unit_med,t4.name as name_unit_med, t3.id_measdoc as id_unit_sale,  t3.name as name_unit_sale , t5.id_measdoc as id_unit_base, t5.name as name_unit_base"
//	 +",t.quan_med,t.id_freq,t.id_route,t.id_routedes,t.id_boil,t.id_boildes";
//	str+=" from BD_SRV t";
//	str+="   join bd_srv_rel_mm t1" 
//	 + " on t.id_srv = t1.id_srv" 
//	 + "   join bd_mm t2" 
//	 + "  on t1.id_mm = t2.id_mm"
//	 + " left join" 
//	+" bd_measdoc t3 on t2.id_unit_pkgsp=t3.id_measdoc" 
//	+" left join" 
//	+" bd_measdoc t4 on t2.id_unit_med=t4.id_measdoc" 
//	+" left join" 
//	+" bd_measdoc t5 on t2.id_unit_pkgbase=t5.id_measdoc" ;
//	str+="  where ";
//	str+="  t.id_srv in ( '"+_id+"')";	// TODO Auto-generated method stub
//	return str;	

}
