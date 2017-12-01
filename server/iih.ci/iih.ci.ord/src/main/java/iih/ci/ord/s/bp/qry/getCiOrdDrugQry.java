package iih.ci.ord.s.bp.qry;

import iih.ci.ord.ciordems.d.OrConfirm;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getCiOrdDrugQry implements ITransQry{
	
	private String id_or;
	private String id_hp;

	
	public getCiOrdDrugQry(OrConfirm confirm){
		this.id_or=confirm.getId_confirm();
		this.id_hp=(confirm.getId_hp());

	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam param = new SqlParam();
		param.addParam(this.id_or);
	
		
		return param;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		String str="SELECT  CI_OR_SRV .id_or, CI_OR_SRV .id_hp ,CI_OR_SRV .id_medu id_unit_med, CI_OR_SRV.code_srv,BD_MM.Spec 	spec_mm,"
				+ "CI_OR_SRV .quan_medu quan_med, bd_measdoc.name 	name_unit_med,bd_freq.name 	name_freq,"
				+ "CI_OR_SRV .pri price, CI_OR_SRV .name name_srv, CI_OR_SRV .id_srvtp,CI_OR_SRV .sd_srvtp,"
				+ "BD_DEP .name name_dep, CI_OR_SRV .id_dep_mp id_dep,";
		str+="CI_OR_SRV.id_srv, CI_OR_SRV. id_orsrv, CI_OR_SRV. id_freq, CI_OR_SRV.fg_mm , CI_OR_SRV.id_srvca, ";
		str+=" CI_OR_SRV_MM.id_mm, CI_OR_SRV_MM.name_mm, CI_OR_SRV_MM.id_pgku_base id_unit_base ,CI_OR_SRV_MM.id_orsrvmm ,";
		str+=" CI_OR_SRV_MM.quan_num_base, CI_OR_SRV_MM.quan_den_base, CI_OR_SRV_MM. price_pgku_cur price_cur,";
		str+=" CI_OR_SRV_MM.id_pgku_cur id_unit_sale, CI_OR_SRV_MM.quan_cur, CI_OR_SRV_MM.factor factor_cb ";
		str+=" FROM CI_OR_SRV ";
		str+="  LEFT JOIN CI_OR_SRV_MM ON CI_OR_SRV. id_orsrv = CI_OR_SRV_MM.id_orsrv  ";
		str+=" left join bd_freq on bd_freq.id_freq= CI_OR_SRV.id_freq "
				+ " left join bd_mm on bd_mm.id_mm=ci_or_srv_mm.id_mm "
				 + " left join bd_measdoc on bd_measdoc.id_measdoc=CI_OR_SRV.id_medu ";
		str+="  LEFT JOIN BD_HP_SRVORCA ON BD_HP_SRVORCA. id_srv = CI_OR_SRV. id_srv  "
				+ "  LEFT JOIN BD_DEP ON BD_DEP. id_dep = CI_OR_SRV .id_dep_mp ";
		str+="  WHERE  CI_OR_SRV. id_or =? AND  CI_OR_SRV. fg_or = 'N' ";


		return str;
	}

}
