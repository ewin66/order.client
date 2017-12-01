package iih.ci.ord.s.bp.qry;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetPatUnDoOrderListQry implements ITransQry {

	public String _id_ent = "";
	
	public GetPatUnDoOrderListQry(String[] id_ent){
		this._id_ent = setIdents(id_ent);
	}
	
	private String setIdents(String[] id_ents){
		for(String id_ent:id_ents){
			_id_ent += ",'"+id_ent+"'";
		}
		if(_id_ent== ""){
			return _id_ent;
		}
		return _id_ent.substring(1); 
	}
	
	
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		//sqlparam.addParam(this._id_ent);
		//sqlparam.addParam(this._id_ent);
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return GetSql();
	}

	 private String GetSql(){
		 StringBuffer sb = new StringBuffer();
		 sb.append(" select  distinct a.*,b.name as name_freq,c.name as name_route ");
		 sb.append(" from (");
		 sb.append("  select  distinct cior.id_or,cior.id_en,cior.id_su_or,  cior.content_or   as or_name,cior.des_or,cior.dt_effe, cior.dt_end, ");
		 sb.append("  orsrv.quan_medu,orsrv.id_medu,orsrv.id_route,orsrv.id_freq, ");
		 //sb.append("   dos.quan_dose as dose, ");// 暂时这样，用血备血有问题
		 sb.append("   orsrv.quan_medu as dose, ");
		 sb.append("   mm.spec ,bd.name name_su_or,bdmea.name as name_medu ");
		 sb.append("   from ci_or_srv orsrv ");
		 sb.append("  left outer join ci_order cior on cior.id_or = orsrv.id_or ");
		 sb.append("   left outer  join  CI_OR_SRV_DOSE dos  on  dos.id_or = cior.id_or ");
		 sb.append("  left outer join ci_or_srv_mm srvmm on orsrv.id_orsrv = srvmm.id_orsrv ");
		 sb.append("  left outer join bd_mm mm on mm.id_mm = srvmm.id_mm ");
		 sb.append("  left outer join  bd_udidoc bd on  bd.id_udidoc = cior.id_su_or ");
		 sb.append("   left join bd_measdoc  bdmea  on bdmea.id_measdoc =  orsrv.id_medu ");
		 sb.append("   where  cior.fg_long = 'N'  and orsrv.fg_or='Y' and cior.fg_pres_outp  ='N'  and cior.ds='0' ");
		 sb.append("   and (cior.sd_su_or != '"+ICiDictCodeConst.SD_SU_FINISH+"' and cior.sd_su_or != '"+ICiDictCodeConst.SD_SU_CHECKSTOP+"' and cior.sd_su_or != '"+ICiDictCodeConst.SD_SU_CHECKTHROUGH+"'  and cior.sd_su_or != '"+ICiDictCodeConst.SD_SU_CHECKCANCEL+"' ) ");
		 sb.append("  and cior.sd_srvtp  not like  '"+IBdSrvDictCodeConst.SD_SRVTP_PATIMAN+"%'  ");
		 sb.append("  and cior.id_en in ("+this._id_ent+")");
		 sb.append("   union all ");
		 
		 sb.append("  select  distinct cior.id_or,cior.id_en,cior.id_su_or,  cior.content_or  as or_name, cior.des_or,cior.dt_effe, cior.dt_end, ");
		 sb.append("  orsrv.quan_medu,orsrv.id_medu,orsrv.id_route,orsrv.id_freq, ");
		 sb.append("   dos.quan_dose as dose,mm.spec ,bd.name name_su_or,bdmea.name as name_medu ");
		 sb.append("   from ci_or_srv orsrv ");
		 sb.append("  left outer join ci_order cior on cior.id_or = orsrv.id_or ");
		 sb.append("   left outer  join  CI_OR_SRV_DOSE dos  on  dos.id_or = cior.id_or ");
		 sb.append("  left outer join ci_or_srv_mm srvmm on orsrv.id_orsrv = srvmm.id_orsrv ");
		 sb.append("  left outer join bd_mm mm on mm.id_mm = srvmm.id_mm ");
		 sb.append("  left outer join  bd_udidoc bd on  bd.id_udidoc = cior.id_su_or ");
		 sb.append("   left join bd_measdoc  bdmea  on bdmea.id_measdoc =  orsrv.id_medu ");
		 sb.append("  where  fg_long = 'Y' and orsrv.fg_or='Y' and cior.fg_pres_outp  ='N'  and cior.ds='0'");
		// sb.append("  and (cior.sd_su_or != '50' and cior.sd_su_or != '"+ICiDictCodeConst.SD_SU_FINISH+"' and cior.sd_su_or != '"+ICiDictCodeConst.SD_SU_CHECKCANCEL+"')");
		 sb.append("  and (  cior.sd_su_or != '"+ICiDictCodeConst.SD_SU_FINISH+"' and cior.sd_su_or != '"+ICiDictCodeConst.SD_SU_CHECKCANCEL+"' and cior.sd_su_or != '"+ICiDictCodeConst.SD_SU_CHECKSTOP+"')");
		 //sb.append("   and  cior.sd_su_mp ='0' ");
		 sb.append("   and cior.id_en in ("+this._id_ent+")" );
		 sb.append("   ) a  left   join  bd_freq b  on a.id_freq = b.id_freq ");
		 sb.append("   left   join bd_route c on a.id_route = c.id_route ");
		 sb.append("  order by  dt_effe desc ");
		 
		 
		 
		 return sb.toString();
	 }
	 
/*	 0  开立；10已 签署；
	 20 核对通过 ；
	 40 医生停止；
	 50 核对停止；
	 60 完成；
	 70 医生作废；
	 80 核对作废*/
	 
	 
/*	 --患者未处理完成的医嘱
select a.*, b.name name_freq, c.name name_route
  from (select cior.id_or,
               cior.id_su_or,
               cior.content_or or_name,
               cior.des_or,
               cior.dt_effe,
               cior.dt_end,
               orsrv.quan_medu,
               orsrv.id_medu,
               orsrv.id_route,
               orsrv.id_freq,
               dos.quan_dose dose,
               mm.spec,
               bd.name name_su_or,
               bdmea.name name_medu
          from ci_or_srv orsrv
          left outer join ci_order cior on cior.id_or = orsrv.id_or
          left outer join CI_OR_SRV_DOSE dos on dos.id_or = cior.id_or
          left outer join ci_or_srv_mm srvmm on orsrv.id_orsrv =
                                                srvmm.id_orsrv
          left outer join bd_mm mm on mm.id_mm = srvmm.id_mm
          left outer join bd_udidoc bd on bd.id_udidoc = cior.id_su_or
          left outer join bd_measdoc bdmea on bdmea.id_measdoc =
                                              orsrv.id_medu
         where cior.fg_long = 'N'
           and (cior.sd_su_or != '50' and cior.sd_su_or != '80' and cior.sd_su_or != '20')
           and cior.sd_srvtp !='1202'
           and cior.id_en = '0001AA10000000066ZUX'
        union all
        select cior.id_or,
               cior.id_su_or,
               cior.content_or or_name,
               cior.des_or,
               cior.dt_effe,
               cior.dt_end,
               orsrv.quan_medu,
               orsrv.id_medu,
               orsrv.id_route,
               orsrv.id_freq,
               dos.quan_dose dose,
               mm.spec,
               bd.name name_su_or,
               bdmea.name name_medu
          from ci_or_srv orsrv
          left outer join ci_order cior on cior.id_or = orsrv.id_or
          left outer join CI_OR_SRV_DOSE dos on dos.id_or = cior.id_or
          left outer join ci_or_srv_mm srvmm on orsrv.id_orsrv =
                                                srvmm.id_orsrv
          left outer join bd_mm mm on mm.id_mm = srvmm.id_mm
          left outer join bd_udidoc bd on bd.id_udidoc = cior.id_su_or
          left outer join bd_measdoc bdmea on bdmea.id_measdoc =
                                              orsrv.id_medu
         where fg_long = 'Y'
           and (cior.sd_su_or != '50' and cior.sd_su_or != '80')
           and cior.id_en = '0001AA10000000066ZUX') a
  left outer join bd_freq b on a.id_freq = b.id_freq
  left outer join bd_route c on a.id_route = c.id_route
        */
}
