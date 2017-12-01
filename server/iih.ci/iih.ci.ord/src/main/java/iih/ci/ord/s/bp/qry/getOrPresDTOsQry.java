package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getOrPresDTOsQry implements ITransQry{
	
//	private String id_dep_nur;
//	private String sd_su_or;
//	private String fg_long;
//	private String id_dep_phy;
	private String id_en;
	
	public getOrPresDTOsQry(String id_en){

		this.id_en=id_en;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam param = new SqlParam();
		if(this.id_en!=null)
		param.addParam(this.id_en);

		
		return param;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		String str="select pres.name Name_prestp ,pres.id_pres,pres.ID_SRVTP, pres.SD_SRVTP, pres.ID_EN, pres.CODE, pres.SD_PRESTP,pres.id_dep_mp, ";
		str+="pres.ID_DI, pres.FG_PRN, pres.ID_ORG, pres.ID_EMP_OR, pres.ID_DEP_OR,pres.FG_HP_PRES,srv.NAME name_srv,mm.PRICE_PGKU_CUR pri,dep.NAME name_dep_mp,psn.NAME name_emp_or ";
		str+=" from ci_pres pres left  join  CI_OR_SRV srv on srv.ID_PRES=pres.ID_PRES and srv.fg_pres_outp='Y'";
		str+=" left join CI_OR_SRV_MM mm on mm.ID_ORSRV=srv.ID_ORSRV ";
		str+=" left join bd_dep dep on dep.ID_DEP=pres.ID_DEP_mp ";
		str+=" left join bd_psndoc psn on  pres.ID_EMP_OR=psn.ID_PSNDOC ";
		if(this.id_en!=null)
			str+=" where pres.id_en=? ";
		    str += " and srv.sd_srvtp like '01%' ";//分方只对药品
		str+=" order by pres.SV desc";
		return str;
	}


}
