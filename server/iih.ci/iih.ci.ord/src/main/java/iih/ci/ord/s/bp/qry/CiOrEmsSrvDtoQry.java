package iih.ci.ord.s.bp.qry;

import iih.ci.ord.ortmpl.d.CiEmsSrvQryParamDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiOrEmsSrvDtoQry implements ITransQry {

	private CiEmsSrvQryParamDTO _paramdto;

	public CiOrEmsSrvDtoQry(CiEmsSrvQryParamDTO paramdto) {
		_paramdto=paramdto;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();
		param.addParam(_paramdto.getId_org());
		param.addParam(_paramdto.getId_dep());
		param.addParam(_paramdto.getCode_entp());
		param.addParam(_paramdto.getId_srv());
		if(!CiOrdUtils.isEmpty(_paramdto.getId_mm())){
			param.addParam(_paramdto.getId_mm());
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {

		return getSqlStr();
	}

	public String getSqlStr() {
		return " select  '' as id_orsrv,'' as id_or,0 as sortno,A.id_srv,'' as id_srv_set,A.id_srvtp,A.sd_srvtp,A.Code as code_srv, "
			  +" A.Name as name_srv,A.id_srvca,A.id_unit_med,B.Name as name_unit_med,A.quan_med,A.Pri as price,A.id_freq,C.Name as name_freq,A.id_route, "
			  +" D.name as name_route,A.id_routedes,E.Name as name_routedes,A.id_boil,F.Name as name_boil,A.id_boildes,G.name as name_boildes, "
			  +" null as fg_dose_anoma,A.Des as des_srv,A.fg_mm,A.fg_set,A.fg_or,A.fg_bl,null fg_self,null as fg_outp,null as fg_propc,null as fg_treat, "
			  +" null as id_org_srv,null as id_dep_srv,null as id_ward_srv,null as id_emp_srv,null as dt_create_srv,null as id_dep,null asname_dep,null as dt_last_bl, "
			  +" A.eu_blmd,A.Srvca_Innercode as innercode_srvca,A.Fg_Ctm as fg_selfsrv,A.id_primd,C.sd_frequnitct,C.frequnitct,C.freqct "
			  +" ,A.Id_Unit_Med as id_unit_cg,B.Name as name_unit_cg,null as quan_cgbase,null as factor_cm,null as sd_roundmd_cg "
			  //bd_mm 
			  +" ,'' as id_orsrvmm,H.id_mm as id_mm,H.Code as code_mm,H.name as name_mm,H.spec as spec_mm,H.Id_Unit_Pkgsp as id_unit_sale,I.Name as name_unit_sale "
			  +" ,H.Id_Unit_Pkgbase as id_unit_base,J.name as name_unit_base,null as quan_num_base,null as quan_den_base,H.price as price_cur,null as quan_cur,null as quan_base "
			  +" ,null  as quan_bed_medu,H.Factor_Sb as factor_cb,H.Factor_Mb as factor_mb,H.id_mmtp,H.sd_mmtp,H.id_val,H.sd_val,H.fg_otc,H.Fg_Skin as fg_skintest "
			  +" ,J1.name as name_mmtp,H.id_sup,J2.Name as name_sup,H.id_srvskin,'' as sd_roundmd "
			  //--bd_srv_drug
			  +" ,K.id_dosage,K.sd_dosage,K.id_pharm,K.sd_pharm,K.id_pois,K.sd_pois,K.id_anti,K.sd_anti,K.indica,K.constr,K.react,K.guide "
			  //--bd_srv_obs
			  +" ,L.id_body,L.sd_body,M.name as body_name,L.id_pos,L.sd_pos,N.name as pos_name,null as fg_indic,0 as eu_sourcemd,null as srv_sv,null as mm_sv "
			  //--bd_hp
			  +" ,O.id_hp,O.id_hpsrvtp,O.sd_hpsrvtp,P.name as name_hpsrvtp,O.Des as limit "
			  //--trans data
			  +" ,'' as id_skintest_skip_reason,'' as sd_skintest_skip_reason,'' as id_reltp,'' as sd_reltp,'' as id_or_rel,null as fg_skintest_rst,'' as id_srv_src,null as quan_total_medu "
			  +" ,null as fg_selfpay,'' as id_dep_wh,'' as name_dep_wh,null as amt_total,null as amt_cur,null as quan_stock,'' as priby,null as fg_base,H.sd_owtp as calfld1 "
			  +" from bd_srv A  "
			  +"      left outer join bd_measdoc B ON A.Id_Unit_Med=B.Id_Measdoc "
			  +"      left outer join bd_freq C ON A.Id_Freq=C.Id_Freq "
			  +"      left outer join bd_route D ON A.Id_Route=D.id_route "
			  +"      left outer join bd_route_des E ON A.Id_Routedes=E.Id_Routedes "
			  +"      left outer join bd_boil F ON A.id_boil=F.Id_Boil "
			  +"      left outer join bd_boil_des G ON A.id_boildes=G.id_boildes "
     
			  +"      left outer join (select bd_mm.*,bd_srv_rel_mm.sd_owtp from bd_srv_rel_mm left outer join bd_mm  ON bd_srv_rel_mm.id_mm=bd_mm.id_mm where bd_srv_rel_mm.id_srv='0001AA1000000005U511' and ((bd_srv_rel_mm.id_org='0001HY1000000000OH85' and bd_srv_rel_mm.sd_owtp='0') or (bd_srv_rel_mm.id_dep='1001HY1000000001VSO5' and bd_srv_rel_mm.sd_owtp='1'))) H ON A.Id_Srv=H.Id_Srv "
			  +"      left outer join bd_measdoc I ON H.Id_Unit_Pkgsp=I.Id_Measdoc "
			  +"      left outer join bd_measdoc J ON H.Id_Unit_Pkgsp=J.Id_Measdoc "
			  +"      left outer join bd_udidoc J1 ON H.Id_Mmtp=J1.Id_Udidoc "
			  +"      left outer join bd_sup J2 ON H.Id_Sup=J2.Id_Sup "
     
			  +"      left outer join bd_srv_drug K ON A.Id_Srv=K.Id_Srv "
     
			  +"      left outer join bd_srv_obs L ON A.Id_Srv=L.Id_Srv "
			  +"      left outer join bd_udidoc M ON L.Id_Body=M.Id_Udidoc "
			  +"      left outer join bd_udidoc N ON L.Id_Body=N.Id_Udidoc "
     
			  +"      left outer join bd_hp_srvorca O ON A.Id_Srv=O.Id_Srv and O.Id_Hp='' "
			  +"      left outer join bd_udidoc P ON O.Id_Hpsrvtp=P.Id_Udidoc "
     
			  +" where A.id_srv='0001AA1000000005U511' and H.id_mm='0001AA100000000A2QNV' order by calfld1 desc";
	}
}
