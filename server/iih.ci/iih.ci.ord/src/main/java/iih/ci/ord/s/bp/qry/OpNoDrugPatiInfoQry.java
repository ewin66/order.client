package iih.ci.ord.s.bp.qry;

import org.apache.commons.lang.StringUtils;

import iih.ci.ord.dto.opdispensecond.d.OpDispenseCondDTO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class OpNoDrugPatiInfoQry implements ITransQry {
	
	
	private OpDispenseCondDTO cond;
	
	
	public OpNoDrugPatiInfoQry(OpDispenseCondDTO cond){
		this.cond=cond;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam=new SqlParam();
		
//		if(!StringUtils.isBlank(cond.getCard_code())){
//			//患者卡号
//			rtnParam.addParam(cond.getCard_code());
//			whereSQL.append("");
//		}
		
		if(!StringUtils.isBlank(cond.getPat_name())){
			//患者姓名
			rtnParam.addParam(cond.getPat_name());
			whereSQL.append(" and p.name=?");
		}
		
		if(!StringUtils.isBlank(cond.getPat_pycode())){
			//患者拼音
			rtnParam.addParam(cond.getPat_pycode());
			whereSQL.append(" and p.pycode=?");
		}
		
		if(!StringUtils.isBlank(cond.getId_pat()))
		{//患者ID
			rtnParam.addParam(cond.getId_pat());
			whereSQL.append(" and t.id_pati=? ");
		}
		
	 
//		if(cond.getDt_charge_end()!=null){
//			//付款日期结束
//			rtnParam.addParam(cond.getDt_charge_end());
//			whereSQL.append("");
//		}
		
//		if(cond.getDt_charge_start()!=null){
//			//付款日期开始
//			rtnParam.addParam(cond.getDt_charge_start());
//			whereSQL.append("");
//		}
		 
		return rtnParam;
	}



	 
	@Override
	public String getQrySQLStr() {
		return getQrySQLStr_();
	}
	
	 
	private String getQrySQLStr_(){
		//return " select distinct t.id_pati, t.id_en, p.id_pat, p.name name_pat, p.code code_pat from ci_pres t "
		return " select distinct t.id_pat as id_pati,t.id_en, p.id_pat, p.name name_pat, p.code code_pat from mp_dg_oep_dt t "
	         + " inner join pi_pat p on t.id_pat=p.id_pat "
	         + " where "+getOrgCondStr()+" t.code_entp='01' "
	         + " "+getPresTypeCondStr()+" and  "+getSrvTypeCondStr()+" "
	         + " and t.eu_su_mp<2";
	}
	
	/**
	 * 西成药 或草药串
	 * @return
	 */
	private String getSrvTypeCondStr(){
		if(isHerb()){return "(substr(t.sd_srvtp, 1, 4)='0103')";}
		return "(substr(t.sd_srvtp, 1, 4) = '0101' or substr(t.sd_srvtp, 1, 4) = '0102')";
	}
	
	/**
	 * 处方类型串
	 * @return
	 */
	private String getPresTypeCondStr(){
		return "";  //and (t.sd_prestp='')
	}
	
	/**
	 * 组织串
	 * @return
	 */
	private String getOrgCondStr(){
		return "";//t.id_org='' and t.id_grp='' and
	}
	
	private boolean isHerb(){
		return cond.getFg_herb().isValue();
	}

}
