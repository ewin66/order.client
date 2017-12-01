package iih.ci.ord.s.bp.iemsg;

import iih.bd.bc.event.pub.IBdSrvIEEventConst;
import iih.bd.bc.udi.pub.ICiDictCodeTypeConst;

public interface ICiIEMsgRelSqlConst {
	/**
	 * 医嘱确认数据信息SQL串 20170517yjb
	 * 药品、检查、检验、。。。。。等均用此
	 */
	public static final String CI_IE_ORCONFIRM_SQL=
			" select A.id_en as id_iepharmoren,B.code as patientid,B.BARCODE_CHIS as patientseqnum,F.Times_Ip as admiss_times,"
		   +" D.CODE as deptcode,D.Name as deptname,E.code as wardcode,E.name as wardname,F.NAME_BED as bedcode,"
		   +" C.Name_Pat as name,C.Sd_Sex_Pat as sexid,C.Dt_Birth_Pat as birthdaydate,null as age,%1$s as confirm_date,"
		   +" G.Code as confirm_nurse_code,G.name as confirm_nurse_name,H.orgcode as orgcode,H.name as orgname "
		   +" from ci_order A"
		   +"      left outer join pi_pat B ON A.Id_Pat=B.Id_Pat"
		   +"      left outer join en_ent C ON A.Id_En=C.Id_Ent"
		   +"      left outer join bd_dep D ON C.Id_Dep_Phy=D.ID_DEP"
		   +"      left outer join bd_dep E ON C.Id_Dep_Nur=E.Id_Dep"
		   +"      left outer join en_ent_ip F ON C.Id_Ent=F.Id_Ent "
		   +"      left outer join bd_psndoc G ON %2$s=G.Id_Psndoc"
		   +"      left outer join bd_org H ON H.Id_ORG=A.Id_ORG "
		   +" where A.id_or='%3$s'"; 
	/**
	 * 西成药医嘱数据信息SQL串 20170517yjb
	 */
	public static final String CI_IE_ORDRUGWC_SQL=
			" select A.Id_Or as id_iepharmwcor,A.Id_En as id_iepharmoren,A.code_or as xy_zcy_order_code,"
		   +" A3.Code as xy_zcy_order_type_code,A3.name as xy_zcy_order_type_name,A.Des_Or as xy_zcy_yz_memo,A4.Code as xy_zcy_fre_code,"
		   +" A4.name as xy_zcy_fre_name,A5.Code as xy_zcy_yytj_code,A5.Name as xy_zcy_yytj_name,A1.Quan_Medu as xy_zcy_cjl,A6.Name as xy_zcy_cjlunit,"
		   +" A2.Quan_Cur as xy_zcy_zyl,A7.Name as xy_zcy_zylunit,A9.Code as xy_zcy_yz_old_dept_code,A9.Name as xy_zcy_yz_old_dept_name,"
		   +" A10.Code as xy_zcy_yz_old_ward_code,A10.name as xy_zcy_yz_old_ward_name,A2.Code_Mm as xy_zcy_yw_code,"
		   +" (case when Z1.CODE='1000' then '00' when Z1.CODE='1001' THEN '01' ELSE '' END ) as xy_zcy_bz_no,A1.Sd_Hpsrvtp as xy_zcy_yw_yb_code,A12.name as xy_zcy_yw_yb_name,A.Dt_Entry as xy_zcy_yz_date,"
		   +" A13.code as xy_zcy_yz_doctor_no,A13.Name as xy_zcy_yz_doctor_name,A.Dt_Sign as xy_zcy_yz_confirm_date,A14.Code as xy_zcy_yz_confirm_code,"
		   +" A14.Name as xy_zcy_yz_confirm_name,A15.Code as xy_zcy_exe_dept_code,A15.Name as xy_zcy_exe_dept_name,A.Id_Or as xy_zcy_f_order_no,"
		   +" (select p.sd_reacttp from bd_srv_react p inner join bd_srv_react_itm q on p.id_srvreact=q.id_srvreact where q.id_srv=A1.Id_Srv) as xy_zcy_hc_order_type_code,"
		   +" '' as xy_zcy_hc_order_type_name,'' as xy_zcy_fybj_code,"
		   +" '' as xy_zcy_fybj_name,A1.NOTE_SRV as xy_zcy_jt,A1.Fg_Indic as xy_zcy_is_sy,(case when A1.Fg_Indic='Y' then '适应' else '非适应' end) as xy_zcy_is_syresult,A1.Fg_Skintest as xy_zcy_is_ps,"
		   +" (case when A1.FG_SKINTEST_RST='Y' then (select t1.name from ci_skin_test t left outer join bd_udidoc t1 on t.id_rst_skintest=t1.id_udidoc where id_or=A1.Id_Or)  else '' end) as xy_zcy_is_psresult,"
		   +" (case when A4.Sd_Frequnitct='0' and A4.Code='ST' then 'Y' else 'N' end) as xy_zcy_is_jj,'' as xy_zcy_is_jjresult,null as xy_zcy_is_yg,null as xy_zcy_is_ygresult,"
		   +" null as xy_zcy_lyl,null as xy_zcy_lylunit,A1.Dt_Last_Mp as xy_zcy_exe_date,A.Dt_End as xy_zcy_stop_date,A.Orders as cy_fs_count,null as cy_fs_unit,null as route_code,null as route_no "
		   
		   +" from ci_order A "
		   +"      inner join ci_or_srv A1 ON A.Id_Or=A1.Id_Or"
		   +"      left outer join ci_or_srv_mm A2 ON A1.Id_Orsrv=A2.Id_Orsrv"
		   +"      left outer join bd_udidoc A3 ON A.Id_Srvtp=A3.Id_Udidoc"
		   +"      left outer join bd_freq A4 ON A.Id_Freq=A4.Id_Freq"
		   +"      left outer join bd_route A5 ON A.Id_Route=A5.id_route"
		   +"      left outer join bd_measdoc A6 ON A1.Id_Medu=A6.Id_Measdoc"
		   +"      left outer join bd_measdoc A7 ON A2.Id_Pgku_Cur=A7.Id_Measdoc"
		   +"      left outer join en_ent A8 ON A.Id_En=A8.Id_Ent"
		   +"      left outer join bd_dep A9 ON A8.Id_Dep_Phy=A9.Id_Dep"
		   +"      left outer join bd_dep A10 ON A8.Id_Dep_Nur=A10.Id_Dep"
		   +"      left outer join bd_mm A11 ON A2.Id_Mm=A11.Id_Mm"
		   +"      left outer join bd_udidoc A12 ON A1.Id_Hpsrvtp=A12.Id_Udidoc"
		   +"      left outer join bd_psndoc A13 ON A.Id_Emp_Or=A13.Id_Psndoc"
		   +"      left outer join bd_psndoc A14 ON A.Id_Emp_Sign=A14.Id_Psndoc"
		   +"      left outer join bd_dep A15 ON A1.Id_Dep_Mp=A15.Id_Dep"
		   +"	   LEFT OUTER JOIN CI_OR_SRV_MM Y ON A1.ID_ORSRV=Y.ID_ORSRV "
		   +"	   LEFT OUTER JOIN BD_MM_PKGU Z ON (Z.ID_MM = Y.ID_MM AND Z.ID_UNIT_PKG=Y.ID_PGKU_CUR) "
		   +"	   LEFT OUTER JOIN BD_MM_PKGUTP Z1 ON Z.ID_MMPKGUTP=Z1.ID_MMPKGUTP "
		   +" where A1.Fg_Or='Y' and %1$s order by A1.Id_Or,A1.Sortno";
	/**
	 * 草药医嘱数据信息SQL串 20170517yjb
	 */
	public static final String CI_IE_ORDRUGHERB_SQL=	
			" select A.Id_Or as id_iepharmor,A.Id_En as id_iepharmoren,A.code_or as xy_zcy_order_code,"
		   +" A3.Code as xy_zcy_order_type_code,A3.name as xy_zcy_order_type_name,A.Des_Or as xy_zcy_yz_memo,A4.Code as xy_zcy_fre_code,"
		   +" A4.name as xy_zcy_fre_name,A5.Code as xy_zcy_yytj_code,A5.Name as xy_zcy_yytj_name,null as xy_zcy_cjl,null as xy_zcy_cjlunit,"
		   +" null as xy_zcy_zyl,null as xy_zcy_zylunit,A9.Code as xy_zcy_yz_old_dept_code,A9.Name as xy_zcy_yz_old_dept_name,"
		   +" A10.Code as xy_zcy_yz_old_ward_code,A10.name as xy_zcy_yz_old_ward_name,null as xy_zcy_yw_code,"
		   +" (case when Z1.CODE='1000' then '00' when Z1.CODE='1001' THEN '01' ELSE '' END ) as xy_zcy_bz_no,null as xy_zcy_yw_yb_code,null as xy_zcy_yw_yb_name,A.Dt_Entry as xy_zcy_yz_date,"
		   +" A13.code as xy_zcy_yz_doctor_no,A13.Name as xy_zcy_yz_doctor_name,A.Dt_Sign as xy_zcy_yz_confirm_date,A14.Code as xy_zcy_yz_confirm_code,"
		   +" A14.Name as xy_zcy_yz_confirm_name,A15.Code as xy_zcy_exe_dept_code,A15.Name as xy_zcy_exe_dept_name,null as xy_zcy_f_order_no,"
		   +" null as xy_zcy_hc_order_type_code,'' as xy_zcy_hc_order_type_name,'' as xy_zcy_fybj_code,"
		   +" '' as xy_zcy_fybj_name,null as xy_zcy_jt,null as xy_zcy_is_sy,null as xy_zcy_is_syresult,'N' as xy_zcy_is_ps,"
		   +" '' as xy_zcy_is_psresult,(case when A4.Sd_Frequnitct='0' and A4.Code='ST' then 'Y' else 'N' end) as xy_zcy_is_jj,'' as xy_zcy_is_jjresult,null as xy_zcy_is_yg,null as xy_zcy_is_ygresult,"
		   +" null as xy_zcy_lyl,null as xy_zcy_lylunit,A.Dt_Last_Mp as xy_zcy_exe_date,A.Dt_End as xy_zcy_stop_date,A.Orders as cy_fs_count,'付' as cy_fs_unit"
		   
		   +" from ci_order A "
		   +"      left outer join bd_udidoc A3 ON A.Id_Srvtp=A3.Id_Udidoc"
		   +"      left outer join bd_freq A4 ON A.Id_Freq=A4.Id_Freq   "
		   +"      left outer join bd_route A5 ON A.Id_Route=A5.id_route"
		   +"      left outer join en_ent A8 ON A.Id_En=A8.Id_Ent"
		   +"      left outer join bd_dep A9 ON A8.Id_Dep_Phy=A9.Id_Dep"
		   +"      left outer join bd_dep A10 ON A8.Id_Dep_Nur=A10.Id_Dep "
		   +"      left outer join bd_psndoc A13 ON A.Id_Emp_Or=A13.Id_Psndoc"
		   +"      left outer join bd_psndoc A14 ON A.Id_Emp_Sign=A14.Id_Psndoc"
		   +"      left outer join bd_dep A15 ON A.Id_Dep_Mp=A15.Id_Dep"
		   +"	   left outer join ci_or_srv A1 ON A.id_or=A1.id_or"
		   +"	   LEFT OUTER JOIN CI_OR_SRV_MM Y ON A1.ID_ORSRV=Y.ID_ORSRV"
		   +"	   LEFT OUTER JOIN BD_MM_PKGU Z ON (Z.ID_MM = Y.ID_MM AND Z.ID_UNIT_PKG=Y.ID_PGKU_CUR)"
		   +"	   LEFT OUTER JOIN BD_MM_PKGUTP Z1 ON Z.ID_MMPKGUTP=Z1.ID_MMPKGUTP"
	       +" where %1$s ";
	/**
	 * 草药医嘱对应药品数据信息SQL串 20170517yjb
	 */
	public static final String CI_IE_ORDRUGHERB_MM_SQL=	
			" select A2.ID_ORSRVMM as id_iepharmormm,A1.Id_Or as id_iepharmor,A2.QUAN_CUR as cy_weight,"
		   +" B1.Name as cy_weightunit,A2.Code_Mm as cy_yp_code,'' as cy_bz_no,B2.Code as cy_tsyf_code,B2.Name as cy_tsyf,"
		   +" 'false' as cy_fswgbj,'' as cy_fswgbj_result,A1.Sd_Hpsrvtp as cy_ywyb_type_code,B3.Name as cy_ywyb_type_name"
		   
		   +" from ci_or_srv A1"
		   +"      left outer join ci_or_srv_mm A2 ON A1.Id_Orsrv=A2.Id_Orsrv"
		   +"      left outer join bd_measdoc B1 ON A2.Id_Pgku_Cur=B1.Id_Measdoc"
		   +"      left outer join bd_boil_des B2 ON A1.Id_Boildes=B2.Id_Boildes"
		   +"      left outer join bd_udidoc B3 ON A1.Id_Hpsrvtp=B3.Id_Udidoc"
		   +" where %1$s and A1.Fg_Or='Y' order by A1.ID_OR,A1.Sortno";
	/**
	 * 检验申请单数据信息SQL串
	 * 住院(废弃)
	 */
	public static final String CI_IE_APPLIS_ALL_SQL_bak=	
			" select A.id_en as id_ielisoren,B.code as patientid,B.BARCODE_CHIS as patientseqnum,E.code as wardcode,E.name as wardname,F.NAME_BED as bedcode, "
		   +" B.Id_Code as idcard,C.Telno_Pat as telephone,C.Name_Pat as name,C.Sd_Sex_Pat as sexid,C.Dt_Birth_Pat as birthdaydate,'' as age, "
		   +" C.Addr_Pat as homeaddress,'' as postal,G.ORGCODE as hospitalid,G.Name as hospitalname,A.Dt_Chk as confirm_date, "
		   +" H.Code as confirm_nurse_code,H.Name as confirm_nurse_name,I.Code as admiss_type,I.Name as admiss_typename, "
		   +" (case when F.Times_Ip is null then 0 else F.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as admiss_times, "
		   +" '' as workunitcode,B.Workunit as workunitname,A.Dt_Entry as orderdatetime,K.Code as orderbyid,K.Name as orderbyname,L.Code as locationid,L.Name as locationname, "
		   +" (case when M.FG_MAJDI='Y' then '12' when M.FG_MAJDI='N' then '13' else '' end) as diag_type,M.ID_DIDEF_CODE as diag_code,M.ID_DIDEF_NAME as diag_name,A.Dt_Entry as enterdatetime_start,A.Dt_Entry as enterdatetime_end,K.Code as enterbyid,K.Name as enterbyname, "

		   +" A.Id_Or as id_ielisor,A.id_en as id_ielisoren,'' as id_ielisoritms,Q.NO_APPLYFORM as applyno,N.Code as ordertype,N.Name as ordername,A.Dt_Effe as applydate, "
		   +" '' as privacy,O.Sd_Rpttp as reportremark_type,O.SD_SU_LAB as reportremark,(case when M.FG_MAJDI='Y' then '12' when M.FG_MAJDI='N' then '13' else '' end) asdiag_type,M.ID_DIDEF_CODE as diag_code,M.ID_DIDEF_NAME as diag_name, "

		   +" Q.ID_ORLAB as id_ielisoritm,A.Id_Or as id_ielisor,A.Code_Or as medicaladvicecode,A.Id_Srv as testcode,P.name as testname,'' as priorityid,Q.Sd_Pps as jydescode,R.Name as jydesname, "
		   +" '' as collectposition,'' as labnum,Q.Sd_Samptp as labtype,S.Name as labname,'' as collectdatetime, "
		   +" Q.SD_CONTP as containerid,T.Name as containername,'' as collectbyid,'' as collectbyname,'' as collectaddressid,V.Code as exec_dept_code,V.Name as exec_dept_name,'' as charge_price_total,'' as suppliesprice,'' as memotype,'' as labneed "

		   +" from ci_ap_lab Q left outer join ci_order A on Q.Id_Or=A.Id_Or "
		   +" left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
   		   +" left outer join en_ent C ON A.Id_En=C.Id_Ent "
   		   +" left outer join bd_dep D ON C.Id_Dep_Phy=D.ID_DEP "
   		   +" left outer join bd_dep E ON C.Id_Dep_Nur=E.Id_Dep "
   		   +" left outer join en_ent_ip F ON C.Id_Ent=F.Id_Ent  "
   		   +" left outer join bd_org G ON A.Id_Org=G.Id_Org "
   		   +" left outer join bd_psndoc H ON H.Id_Psndoc=A.Id_Emp_Chk "
   		   +" left outer join bd_entp I ON I.Id_Entp=A.Id_Entp "
   		   +" left outer join en_ent_op J ON A.Id_En=J.Id_Ent "
   		   +" left outer join bd_psndoc K ON K.Id_Psndoc=A.Id_Emp_Or "
   		   +" left outer join bd_dep L ON A.Id_Dep_Or=L.ID_DEP "
   		   +" left outer join ci_di_itm M ON Q.Id_Diitm=M.ID_DIITM "
   		   +" left outer join bd_srvca N ON N.Id_Srvca=A.Id_Srvca "
   		   +" left outer join ci_rpt_lab O ON Q.Id_Orlab=O.Id_Orlab "
   		   +" left outer join bd_srv P ON P.id_srv=A.Id_Srv "
   		   +" left outer join bd_udidoc R ON R.Id_Udidoc=Q.Id_Pps "
   		   +" left outer join bd_udidoc S ON S.Id_Udidoc=Q.Id_Samptp "
   		   +" left outer join bd_udidoc T ON T.Id_Udidoc=Q.Id_Contp "
   		   +" left outer join bd_udidoc U ON U.Id_Udidoc=Q.Id_Colltp "
   		   +" left outer join bd_dep V ON V.Id_Dep=A.Id_Dep_Mp	"
		   +" where %1$s";
	/**
	 * 检验申请单数据信息SQL串
	 * 住院（新）
	 */
	public static final String CI_IE_APPLIS_ALL_SQL=	
			" select A.id_en as id_ielisoren,B.code as patient_id,B.CODE_AMR_IP as p_bar_code,E.code as ward_code,E.name as ward_code_name,F.NAME_BED as bed_no, "
		   +" B.Id_Code as social_no,C.Name_Pat as name,B.Tel as home_tel,B.Mob as cellphone,C.Sd_Sex_Pat as sex,C.Dt_Birth_Pat as birthday,'' as age, "
		   +" C.Addr_Pat as home_street,'' as post_code,'' as work_place_code, D.Code as deptcode,D.NAME as deptname, "
		   +" B.Workunit as work_place,G.ORGCODE as hospital_code,G.Name as hospital_name,A.Dt_Entry as enter_date,K.Code as apply_doctor,K.Name as apply_doctor_name, "
		   +" L.Code as apply_unit,L.Name as apply_unit_name,A.Dt_Sign as confirm_date,H.Code as confirm_opera,H.Name as confirm_opera_name, "
		   +" A.Dt_Effe as input_begindate,A.Dt_End as input_enddate,H.Code as input_opera,H.Name as input_opera_name, "
		   +" (case when F.Times_Ip is null then 0 else F.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as times, "
		   +" W.code as visit_type,W.Name as visit_type_name,G.CODE as yq_code,G.Name as yz_code_name, "
		   +" (case when M.FG_MAJDI='Y' then '12' when M.FG_MAJDI='N' then '13' else '' end) as diag_type,M.ID_DIDEF_CODE as diag_code,M.ID_DIDEF_NAME as diag_str, "

		   +" A.Id_Or as id_ielisor,A.id_en as id_ielisoren,'' as id_ielisoritms,Q.NO_APPLYFORM as jy_applyserial1,N.Code as order_type, "
		   +" N.Name as order_type_name,A.Dt_Effe as apply_date,'' as is_private,(case when M.FG_MAJDI='Y' then '12' when M.FG_MAJDI='N' then '13' else '' end) as diag_type,M.ID_DIDEF_CODE as diag_name,M.ID_DIDEF_NAME as diag_str, "

		   +" Q.ID_ORLAB as id_ielisoritm,A.Id_Or as id_ielisor,A.Code_Or as yz_no,P.code as jy_applyserial,P.name as jyname,'' as priority,A.Dt_Effe as yz_start_date,A.Dt_End as yz_stop_date, "
		   +" X.Code as yz_frequency,X.Name as yz_frequency_name,Q.Sd_Pps as descp_code,R.Name as description,'' as collect_ragion, "
		   +" '' as sample_id,Q.Sd_Samptp as sample_class,S.Name assample_code_name,'' as collect_time,Q.SD_CONTP as container_code, "
		   +" T.Name as container_code_name,'' as collecter_code,'' as collecter_code_name,'' as collecter_place,V.Code as exec_code, "
		   +" V.Name as exec_code_name,'' as test_price,'' as supply_price,'' as commenttp,Q.ANNOUNCEMENTS as sample_request,'' as isstest,'' as stest,(case when A.Fg_Urgent='Y' then '1' else '0' end) as is_em,(case when A.Fg_Urgent='Y' then 'true' else 'false' end) as is_em_r,'' as isyg,'' as yg, "
		   +" P.sd_iemsgca as iemsgca_code,P1.name as iemsgca_name , P1.ctrl1 as iemsgca_typename "

		   +" from ci_ap_lab Q left outer join ci_order A on Q.Id_Or=A.Id_Or "
		   +"       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
   		   +"       left outer join en_ent C ON A.Id_En=C.Id_Ent "
		   +"       left outer join bd_dep D ON C.Id_Dep_Phy=D.ID_DEP "
		   +"       left outer join bd_dep E ON C.Id_Dep_Nur=E.Id_Dep "  // 病区
		   +"       left outer join en_ent_ip F ON C.Id_Ent=F.Id_Ent  "
		   +"       left outer join bd_org G ON A.Id_Org=G.Id_Org "
		   +"       left outer join bd_psndoc H ON H.Id_Psndoc=A.Id_Emp_Sign "
		   +"       left outer join bd_entp I ON I.Id_Entp=A.Id_Entp "
		   +"       left outer join en_ent_op J ON A.Id_En=J.Id_Ent "
		   +"       left outer join bd_psndoc K ON K.Id_Psndoc=A.Id_Emp_Or "
		   +"       left outer join bd_dep L ON A.Id_Dep_Or=L.ID_DEP "
		   +"       left outer join ci_di_itm M ON Q.Id_Diitm=M.ID_DIITM "
		   +"       left outer join bd_srvca N ON N.Id_Srvca=A.Id_Srvca "
		   +"       left outer join ci_rpt_lab O ON Q.Id_Orlab=O.Id_Orlab "
		   +"       left outer join bd_srv P ON P.id_srv=A.Id_Srv "
		   +"       left outer join bd_udidoc R ON R.Id_Udidoc=Q.Id_Pps "
		   +"       left outer join bd_udidoc S ON S.Id_Udidoc=Q.Id_Samptp "
		   +"       left outer join bd_udidoc T ON T.Id_Udidoc=Q.Id_Contp "
		   +"       left outer join bd_udidoc U ON U.Id_Udidoc=Q.Id_Colltp "
		   +"       left outer join bd_dep V ON V.Id_Dep=A.Id_Dep_Mp "
		   +"       left outer join pi_pat_ca W ON W.Id_Patca=B.Id_Paticate "
		   +"       left outer join bd_freq X ON X.Id_Freq=A.Id_Freq	 "
		   +"		left outer join bd_udidoc P1 ON P.Code_rel7 = P1.Id_Udidoc	 "
		   +" where %1$s  ";
	/**
	 * 检验申请单数据信息SQL串 已记账
	 * （门诊） G.CODE
	 */
	public static final String CI_IE_APPLIS_OP_ALL_SQL=	
			" select A.id_en as id_ielisoren,B.code as patient_id,B.BARCODE_CHIS as p_bar_code,E.code as ward_code,E.name as ward_code_name,F.NAME_BED as bed_no, "
					   +" B.Id_Code as social_no,C.Name_Pat as name,B.Tel as home_tel,B.Mob as cellphone,C.Sd_Sex_Pat as sex,C.Dt_Birth_Pat as birthday,'' as age, "
					   +" C.Addr_Pat as home_street,'' as post_code,'' as work_place_code, D.Code as patient_deptcode,D.NAME as patient_deptname, "
					   +" B.Workunit as work_place,G.ORGCODE as hospital_code,G.Name as hospital_name,A.Dt_Entry as enter_date,K.Code as apply_doctor,K.Name as apply_doctor_name, "
					   +" L.Code as apply_unit,L.Name as apply_unit_name,A.Dt_Sign as confirm_date,H.Code as confirm_opera,H.Name as confirm_opera_name, "
					   +" A.Dt_Effe as input_begindate,A.Dt_End as input_enddate,H.Code as input_opera,H.Name as input_opera_name, "
					   +" (case when F.Times_Ip is null then 0 else F.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as times, "
					   +" W.code as visit_type,W.Name as visit_type_name,G.CODE as yq_code,G.Name as yz_code_name, "
					   +" (case when M.FG_MAJDI='Y' then '12' when M.FG_MAJDI='N' then '13' else '' end) as diag_type,M.ID_DIDEF_CODE as diag_code,M.ID_DIDEF_NAME as diag_str, "

					   +" A.Id_Or as id_ielisor,A.id_en as id_ielisoren,'' as id_ielisoritms,Q.NO_APPLYFORM as jy_applyserial1,N.Code as order_type, "
					   +" N.Name as order_type_name,A.Dt_Effe as apply_date,'' as is_private,(case when M.FG_MAJDI='Y' then '12' when M.FG_MAJDI='N' then '13' else '' end) as diag_type,M.ID_DIDEF_CODE as diag_name,M.ID_DIDEF_NAME as diag_str, "

					   +" Q.ID_ORLAB as id_ielisoritm,A.Id_Or as id_ielisor,A.Code_Or as yz_no,P.code as jy_applyserial,P.name as jyname,'' as priority,A.Dt_Effe as yz_start_date,A.Dt_End as yz_stop_date, "
					   +" X.Code as yz_frequency,X.Name as yz_frequency_name,Q.Sd_Pps as descp_code,R.Name as description,'' as collect_ragion, "
					   +" '' as sample_id,Q.Sd_Samptp as sample_class,S.Name as sample_code_name,'' as collect_time,Q.SD_CONTP as container_code, "
					   +" T.Name as container_code_name,'' as collecter_code,'' as collecter_code_name,'' as collecter_place,V.Code as exec_code, "
					   +" V.Name as exec_code_name,Z4.price_ratio as test_price,'' as supply_price,'' as commenttp,Q.ANNOUNCEMENTS as sample_request,'' as isstest,'' as stest,(case when A.Fg_Urgent='Y' then '1' else '0' end) as is_em,(case when A.Fg_Urgent='Y' then 'true' else 'false' end) as is_em_r,'' as isyg,'' as yg, "
					   +" P.sd_iemsgca as iemsgca_code,(case when Z3.name='未记账' then '099' when Z3.name='已记账' then  P1.name end) as iemsgca_name , P1.ctrl1 as iemsgca_typename "

					   +" from ci_ap_lab Q left outer join ci_order A on Q.Id_Or=A.Id_Or "
					   +"       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
			   		   +"       left outer join en_ent C ON A.Id_En=C.Id_Ent "
					   +"       left outer join bd_dep D ON C.Id_Dep_Phy=D.ID_DEP "
					   +"       left outer join bd_dep E ON C.Id_Dep_Nur=E.Id_Dep " 
					   +"       left outer join en_ent_ip F ON C.Id_Ent=F.Id_Ent  "
					   +"       left outer join bd_org G ON A.Id_Org=G.Id_Org "
					   +"       left outer join bd_psndoc H ON H.Id_Psndoc=A.Id_Emp_Sign "
					   +"       left outer join bd_entp I ON I.Id_Entp=A.Id_Entp "
					   +"       left outer join en_ent_op J ON A.Id_En=J.Id_Ent "
					   +"       left outer join bd_psndoc K ON K.Id_Psndoc=A.Id_Emp_Or "
					   +"       left outer join bd_dep L ON A.Id_Dep_Or=L.ID_DEP "
					   +"       left outer join ci_di_itm M ON Q.Id_Diitm=M.ID_DIITM "
					   +"       left outer join bd_srvca N ON N.Id_Srvca=A.Id_Srvca "
					   +"       left outer join ci_rpt_lab O ON Q.Id_Orlab=O.Id_Orlab "
					   +"       left outer join bd_srv P ON P.id_srv=A.Id_Srv "
					   +"       left outer join bd_udidoc R ON R.Id_Udidoc=Q.Id_Pps "
					   +"       left outer join bd_udidoc S ON S.Id_Udidoc=Q.Id_Samptp "
					   +"       left outer join bd_udidoc T ON T.Id_Udidoc=Q.Id_Contp "
					   +"       left outer join bd_udidoc U ON U.Id_Udidoc=Q.Id_Colltp "
					   +"       left outer join bd_dep V ON V.Id_Dep=A.Id_Dep_Mp "
					   +"       left outer join pi_pat_ca W ON W.Id_Patca=B.Id_Paticate "
					   +"       left outer join bd_freq X ON X.Id_Freq=A.Id_Freq	 "
//					   +"		left outer join bd_udidoc P1 ON P.Code_rel7 = P1.Id_Udidoc	 "
					   +"		left outer join bd_udidoc P1 ON P.Id_iemsgca = P1.Id_Udidoc	 "
//					   +"		left outer join ci_or_srv Z2 ON A.Id_or=Z2.Id_or "
					   +"		left outer join bd_udidoc Z3 ON (Z3.id_udidoc ='"+ICiDictCodeTypeConst.ID_SU_BL_0+"'and Z3.id_udidoclist='"+ICiDictCodeTypeConst.SD_SU_BL+"')"
					   //bd_srv_price 更换为 view_price_rp
					   +"		left outer join view_price_rp Z4 ON Z4.Id_Srv=A.Id_Srv and Z4.id_pripat = C.Id_Pripat"
					   +" where %1$s  ";	
	/**
	 * 检验申请单数据信息SQL串 未记账
	 * （门诊） G.CODE
	 */
	public static final String CI_IE_APPLIS_OP_ALL_SQL_1=	
			" select A.id_en as id_ielisoren,B.code as patient_id,B.BARCODE_CHIS as p_bar_code,E.code as ward_code,E.name as ward_code_name,F.NAME_BED as bed_no, "
					   +" B.Id_Code as social_no,C.Name_Pat as name,B.Tel as home_tel,B.Mob as cellphone,C.Sd_Sex_Pat as sex,C.Dt_Birth_Pat as birthday,'' as age, "
					   +" C.Addr_Pat as home_street,'' as post_code,'' as work_place_code, D.Code as patient_deptcode,D.NAME as patient_deptname, "
					   +" B.Workunit as work_place,G.ORGCODE as hospital_code,G.Name as hospital_name,A.Dt_Entry as enter_date,K.Code as apply_doctor,K.Name as apply_doctor_name, "
					   +" L.Code as apply_unit,L.Name as apply_unit_name,A.Dt_Sign as confirm_date,H.Code as confirm_opera,H.Name as confirm_opera_name, "
					   +" A.Dt_Effe as input_begindate,A.Dt_End as input_enddate,H.Code as input_opera,H.Name as input_opera_name, "
					   +" (case when F.Times_Ip is null then 0 else F.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as times, "
					   +" W.code as visit_type,W.Name as visit_type_name,G.CODE as yq_code,G.Name as yz_code_name, "
					   +" (case when M.FG_MAJDI='Y' then '12' when M.FG_MAJDI='N' then '13' else '' end) as diag_type,M.ID_DIDEF_CODE as diag_code,M.ID_DIDEF_NAME as diag_str, "

					   +" A.Id_Or as id_ielisor,A.id_en as id_ielisoren,'' as id_ielisoritms,Q.NO_APPLYFORM as jy_applyserial1,N.Code as order_type, "
					   +" N.Name as order_type_name,A.Dt_Effe as apply_date,'' as is_private,(case when M.FG_MAJDI='Y' then '12' when M.FG_MAJDI='N' then '13' else '' end) as diag_type,M.ID_DIDEF_CODE as diag_name,M.ID_DIDEF_NAME as diag_str, "

					   +" Q.ID_ORLAB as id_ielisoritm,A.Id_Or as id_ielisor,A.Code_Or as yz_no,P.code as jy_applyserial,P.name as jyname,'' as priority,A.Dt_Effe as yz_start_date,A.Dt_End as yz_stop_date, "
					   +" X.Code as yz_frequency,X.Name as yz_frequency_name,Q.Sd_Pps as descp_code,R.Name as description,'' as collect_ragion, "
					   +" '' as sample_id,Q.Sd_Samptp as sample_class,S.Name as sample_code_name,'' as collect_time,Q.SD_CONTP as container_code, "
					   +" T.Name as container_code_name,'' as collecter_code,'' as collecter_code_name,'' as collecter_place,V.Code as exec_code, "
					   +" V.Name as exec_code_name,Z4.price_ratio as test_price,'' as supply_price,'' as commenttp,Q.ANNOUNCEMENTS as sample_request,'' as isstest,'' as stest,(case when A.Fg_Urgent='Y' then '1' else '0' end) as is_em,(case when A.Fg_Urgent='Y' then 'true' else 'false' end) as is_em_r,'' as isyg,'' as yg, "
					   +" P.sd_iemsgca as iemsgca_code,(case when Z3.name='未记账' then '099' when Z3.name='已记账' then  P1.name end) as iemsgca_name , P1.ctrl1 as iemsgca_typename "

					   +" from ci_ap_lab Q left outer join ci_order A on Q.Id_Or=A.Id_Or "
					   +"       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
			   		   +"       left outer join en_ent C ON A.Id_En=C.Id_Ent "
					   +"       left outer join bd_dep D ON C.Id_Dep_Phy=D.ID_DEP "
					   +"       left outer join bd_dep E ON C.Id_Dep_Nur=E.Id_Dep " 
					   +"       left outer join en_ent_ip F ON C.Id_Ent=F.Id_Ent  "
					   +"       left outer join bd_org G ON A.Id_Org=G.Id_Org "
					   +"       left outer join bd_psndoc H ON H.Id_Psndoc=A.Id_Emp_Sign "
					   +"       left outer join bd_entp I ON I.Id_Entp=A.Id_Entp "
					   +"       left outer join en_ent_op J ON A.Id_En=J.Id_Ent "
					   +"       left outer join bd_psndoc K ON K.Id_Psndoc=A.Id_Emp_Or "
					   +"       left outer join bd_dep L ON A.Id_Dep_Or=L.ID_DEP "
					   +"       left outer join ci_di_itm M ON Q.Id_Diitm=M.ID_DIITM "
					   +"       left outer join bd_srvca N ON N.Id_Srvca=A.Id_Srvca "
					   +"       left outer join ci_rpt_lab O ON Q.Id_Orlab=O.Id_Orlab "
					   +"       left outer join bd_srv P ON P.id_srv=A.Id_Srv "
					   +"       left outer join bd_udidoc R ON R.Id_Udidoc=Q.Id_Pps "
					   +"       left outer join bd_udidoc S ON S.Id_Udidoc=Q.Id_Samptp "
					   +"       left outer join bd_udidoc T ON T.Id_Udidoc=Q.Id_Contp "
					   +"       left outer join bd_udidoc U ON U.Id_Udidoc=Q.Id_Colltp "
					   +"       left outer join bd_dep V ON V.Id_Dep=A.Id_Dep_Mp "
					   +"       left outer join pi_pat_ca W ON W.Id_Patca=B.Id_Paticate "
					   +"       left outer join bd_freq X ON X.Id_Freq=A.Id_Freq	 "
//					   +"		left outer join bd_udidoc P1 ON P.Code_rel7 = P1.Id_Udidoc	 "
					   +"		left outer join bd_udidoc P1 ON P.Id_iemsgca = P1.Id_Udidoc	 "
//					   +"		left outer join ci_or_srv Z2 ON A.Id_or=Z2.Id_or "
					   +"		left outer join bd_udidoc Z3 ON (Z3.id_udidoc ='"+ICiDictCodeTypeConst.ID_SU_BL_1+"' and Z3.id_udidoclist='"+ICiDictCodeTypeConst.SD_SU_BL+"')"
					   //bd_srv_price 更换为 view_price_rp
					   +"		left outer join view_price_rp Z4 ON Z4.Id_Srv=A.Id_Srv and Z4.id_pripat = C.Id_Pripat"
					   +" where %1$s  ";
	/**
	 * 检查申请单数据信息SQL串
	 * （住院）
	 * 套时部位得单独求取
	 */
	public static final String CI_IE_APPRIS_ALL_SQL=
						" select A.id_en as id_ierisoren,B.code as patientid,C.Name_Pat as name,W.code as patient_type,B.Id_Code as idcard,C.Telno_Pat as telephone,C.Addr_Pat as homeaddress, "
					   +" C.SD_MARI_PAT as marrycode,B.Sd_Nation as folkcode,B.SD_OCCU as procode,U.Name as proname,B.Workunit as workunitname,B.Sd_Country as countrycode,T.Name as countryname,'' as r_tel,'' as r_name, "
					   +" S.CODE as ybcode,S.Sd_Patcardtp,C.Sd_Sex_Pat as sexid,C.Dt_Birth_Pat as birthdaydate,'' as age,B.CODE_AMR_IP as patientseqnum, "
					   +" (case when F.Times_Ip is null then 0 else F.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as admiss_times "
					   +" ,D.code as deptcode,D.name as deptname,E.code as wardcode,E.name as wardname,F.NAME_BED as bedcode,G.CODE as hos_code,G.NAME as hos_name "
					   +" ,A.Dt_Chk as confirm_date,H.Code as confirm_nurse_code,H.NAME as confirm_nurse_name "
					   +" ,(case when M.FG_MAJDI='Y' then '12' when M.FG_MAJDI='N' then '13' else '' end) as diag_type_code,(case when M.FG_MAJDI='Y' then '主要诊断' when M.FG_MAJDI='N' then '次要诊断' else '' end) as diag_type_name,X.Dt_Sign as diag_date,M.ID_DIDEF_CODE as diag_code,M.ID_DIDEF_NAME as diag_name "
					   +" ,A.Id_Or as id_ierisor,A.id_en as id_ierisoren,'' as id_ierisoritms,Q.NO_APPLYFORM as sqd_jccode,N.Code as sqd_ordertypecode,N.Name as sqd_ordertypename, "
					   +" R.Name as sdsqd_sqddetail,A.Dt_Effe as sqd_sqddate,'' as sqd_bbh,'' as sqd_bbhtype,'' as sqd_bbyq,A.Dt_Last_Mp as sqd_zxsj,L.Name as sqd_deptname,L.Code as sqd_deptcode,Q.ANNOUNCEMENTS as sqd_sqzysx "

					   +" ,Q.Id_Orobs as id_ierisoritm,A.Id_Or as id_ierisor,A.Code_Or as yz_ordercode,P.code as yz_jccode,P.name as yz_jcname,'' as jgbz,A.Dt_Effe as yz_start_time,A.dt_end as yz_stop_time "
					   +" ,Y.Code as xy_zcy_fre_code,Y.Name as xy_zcy_fre_name,'' as yz_jcffcode,'' as yz_jcffname,V.Sd_Body as yz_jcbwcode,Z.Name as yz_jcbwname,'' as is_ps,'' as is_psresult,A.Fg_Urgent as is_jj ,'' as is_jjresult,'' as is_yg,'' as is_ygresult "
					   +" , '' as eu_vip, "
					   + " P.sd_iemsgca as iemsgca_code,P1.name as iemsgca_name , P1.ctrl1 as iemsgca_typename"

					   +" from ci_ap_obs Q left outer join ci_order A on Q.Id_Or=A.Id_Or "
					   +"       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
					   +"       left outer join en_ent C ON A.Id_En=C.Id_Ent "
					   +"       left outer join bd_dep D ON C.Id_Dep_Phy=D.ID_DEP "
					   +"       left outer join bd_dep E ON C.Id_Dep_Nur=E.Id_Dep "
					   +"       left outer join en_ent_ip F ON C.Id_Ent=F.Id_Ent  "
					   +"       left outer join bd_org G ON A.Id_Org=G.Id_Org "
					   +"       left outer join bd_psndoc H ON H.Id_Psndoc=A.Id_Emp_Chk "
					   +"       left outer join en_ent_op J ON A.Id_En=J.Id_Ent "
					   +"       left outer join bd_dep L ON A.Id_Dep_Or=L.ID_DEP "
					   +"       left outer join en_ent_di M1 ON Q.Id_Di=M1.ID_entdi "//在检查医嘱属性表里ci_ap_obs存储的id_di是就诊诊断表en_ent_di里的ID_entdi，与其他诊断表里的ID_DI不一致，此处临时更改
					   +"       left outer join ci_di_itm M ON M1.ID_DIITM=M.ID_DIITM "
					   +"       left outer join ci_di X ON M1.Id_Di=X.Id_Di "
					   +"       left outer join bd_srvca N ON N.Id_Srvca=A.Id_Srvca "
					   +"       left outer join bd_srv P ON P.id_srv=A.Id_Srv "
					   +"       left outer join bd_udidoc R ON R.Id_Udidoc=Q.Id_Pps "
					   +"       left outer join pi_pat_card S ON S.ID_PAT=B.Id_Pat and S.Sd_Patcardtp='04' "
					   +"       left outer join bd_udidoc T ON T.Id_Udidoc=B.Id_Nation "
					   +"       left outer join bd_udidoc U ON U.Id_Udidoc=B.Id_Occu "
					   +"       left outer join pi_pat_ca W ON W.Id_Patca=B.Id_Paticate "
					   +"       left outer join bd_freq Y ON A.Id_Freq=Y.Id_Freq "
 					   +"       left outer join bd_srv_obs V ON V.Id_Srv=A.Id_Srv "
					   +"       left outer join bd_udidoc Z ON V.Id_Body=Z.Id_Udidoc "	
					   +"		left outer join bd_udidoc P1 ON P.Code_rel7 = P1.Id_Udidoc	 "
					   +" where %1$s";	 
	/**
	 * 检查申请单数据信息SQL串 已记账
	 * （门诊）
	 * 套时部位得单独求取
	 */
	public static final String CI_IE_APPRIS_OP_ALL_SQL=
						" select A.id_en as id_ierisoren,B.code as patient_id,B.BARCODE_CHIS as p_bar_code,E.code as ward_code,E.name as ward_code_name,F.name_bed as bed_no,(case when B.id_idtp = '@@@@AA1000000000MNLZ' then B.Id_Code else '' end) as social_no, "
			   		   +" S.CODE as addition_no,C.Name_Pat as name,C.Telno_Pat as home_tel,C.Sd_Sex_Pat as sexid,C.Dt_Birth_Pat as birthday,'' as age,C.ADDR_PAT as home_street,C.Sd_Mari_Pat as marry_code,B.Sd_Nation as nation_code, "
					   +" B.Sd_Occu as occupation_type,U.Name as occupation_type_name,B.Workunit as work_unit,B.Sd_Country as country_code,O.Name as country_code_name, "
					   +" '' as relation_tel,'' as relation_tel_name, D.code as  code_dep_ns,D.name as name_dep_ns,G.orgCode as org_code,G.name as org_name,"
					   +" G.Name as apply_hospital,A.dt_sign as enter_date,K.code as apply_doctor,K.name as apply_doctor_name, "
					   +" L.Code as apply_unit,L.Name as apply_unit_name,A.Dt_Chk as confirm_date,H.Code as confirm_opera,H.Name as confirm_opera_name,W.Name as response_type, "
					   +" (case when F.Times_Ip is null then 0 else F.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as times, "
					   +" (case when M.FG_MAJDI='Y' then '12' when M.FG_MAJDI='N' then '13' else '' end) as diag_type_code,(case when M.FG_MAJDI='Y' then '主要诊断' when M.FG_MAJDI='N' then '次要诊断' else '' end) as diag_type_name,X.Dt_Sign as diag_input_date,M.ID_DIDEF_CODE as diag_code,M.ID_DIDEF_NAME as diag_str "
					   
					   +" ,A.Id_Or as id_ierisor,A.id_en as id_ierisoren,'' as id_ierisoritms,Q.NO_APPLYFORM as apply_serial,(case when substr(A.sd_srvtp,0,2)='02' then '"+IBdSrvIEEventConst.SD_SRVTP_JCL+"' when substr(A.sd_srvtp,0,2) ='03' then '"+IBdSrvIEEventConst.SD_SRVTP_HYL+"'  else '' end) as exam_type,(case when substr(A.sd_srvtp,0,2)='02' then '检查' when substr(A.sd_srvtp,0,2) ='03' then '化验'  else '' end) as exam_type_name "
					   +" ,R.Name as exam_content,A.Dt_Sign as exam_request_date,'' as samp_bar_code,'' as samp_type,'' as samp_content,A.Dt_Last_Mp as exam_exec_date,VV.Name as exec_unit,VV.Code as sqd_deptcode,Q.Announcements as note, "

					   +" Q.Id_Orobs as id_ierisoritm,A.Id_Or as id_ierisor,Q.NO_APPLYFORM as exam_serial,substr(P.code,3) as exam_sub_type,P.name as exam_sub_type_name,"
					   +" '' as order_pri,A.dt_effe as dt_effe,A.dt_end as dt_end,"
					   +" Z1.Code as yz_frequency,Z1.Name as yz_frequency_name,'' as exam_sub_fftype,'' as exam_sub_fftype_name,(case when P.fg_set='N' then V.Sd_Body else  Z4.code end) as exam_region,"
					   +" (case when P.fg_set='N' then Z.name else Z4.name end) as exam_region_name ,"
					   +" '' as isstest, '' as stest, A.fg_urgent as is_em, '' as is_em_r,'' as isyg, '' as yg,'' as vip_val, "
					   +" P.sd_iemsgca as iemsgca_code,(case when Z3.name='未记账' then '099' when Z3.name='已记账' then  P1.name end) as iemsgca_name , P1.ctrl1 as iemsgca_typename"

					   +" from ci_ap_obs Q left outer join ci_order A on Q.Id_Or=A.Id_Or "
					   +"       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
					   +"       left outer join en_ent C ON A.Id_En=C.Id_Ent "
					   +"       left outer join bd_dep D ON C.Id_Dep_Phy=D.ID_DEP " // D就诊科室
					   +"       left outer join bd_dep E ON C.Id_Dep_Nur=E.Id_Dep " // E就诊病区
					   +"       left outer join en_ent_ip F ON C.Id_Ent=F.Id_Ent  " // 门诊就诊
					   +"       left outer join bd_org G ON A.Id_Org=G.Id_Org " // 机构
					   +"       left outer join bd_psndoc H ON H.Id_Psndoc=A.Id_Emp_Chk "
					   +"       left outer join en_ent_op J ON A.Id_En=J.Id_Ent "
					   +"       left outer join bd_psndoc K ON K.Id_Psndoc=A.Id_Emp_Or "
					   +"       left outer join bd_dep L ON A.Id_Dep_Or=L.ID_DEP "
                       +"       left outer join en_ent_di M1 ON Q.Id_Di=M1.ID_entdi "//在检查医嘱属性表里ci_ap_obs存储的id_di是就诊诊断表en_ent_di里的ID_entdi，与其他诊断表里的ID_DI不一致，此处临时更改
					   +"       left outer join ci_di_itm M ON M1.ID_DIITM=M.ID_DIITM "
					   +"       left outer join ci_di X ON M1.Id_Di=X.Id_Di "
					   +"       left outer join bd_srvca N ON N.Id_Srvca=A.Id_Srvca "
					   +"       left outer join bd_udidoc O ON O.Id_Udidoc=B.Id_Country "
					   +"       left outer join bd_srv P ON P.id_srv=A.Id_Srv "
					   +"       left outer join bd_udidoc R ON R.Id_Udidoc=Q.Id_Pps " // 检查目的
					   +"       left outer join pi_pat_card S ON S.ID_PAT=B.Id_Pat and S.Sd_Patcardtp='04' " // 医保卡
					   +"       left outer join bd_udidoc T ON T.Id_Udidoc=B.Id_Nation "
					   +"       left outer join bd_udidoc U ON U.Id_Udidoc=B.Id_Occu "
					   +"       left outer join bd_dep VV ON VV.Id_Dep=A.Id_Dep_Mp "
					   +"       left outer join pi_pat_ca W ON W.Id_Patca=B.Id_Paticate "
					   +"       left outer join bd_freq Y ON A.Id_Freq=Y.Id_Freq "
					   +"       left outer join bd_srv_obs V ON V.Id_Srv=A.Id_Srv "
					   +"       left outer join bd_udidoc Z ON V.Id_Body=Z.Id_Udidoc    "
					   +"		left outer join bd_freq Z1 ON Z1.Id_Freq=A.Id_Freq	 "
					   +"		left outer join bd_udidoc P1 ON P.Id_iemsgca = P1.Id_Udidoc	 "
					   +"		left outer join ci_or_srv C1 ON A.id_or=C1.id_or and C1.fg_or = 'Y'"
//					   +"		left outer join ci_or_srv Z2 ON A.Id_or=Z2.Id_or "
					   +"		left outer join bd_udidoc Z3 ON (Z3.id_udidoc ='"+ICiDictCodeTypeConst.ID_SU_BL_0+"'and Z3.id_udidoclist='"+ICiDictCodeTypeConst.SD_SU_BL+"')"
					   +"		left outer join ci_or_srv_set Z5 on Z5.id_or = A.id_or and  Z5.fg_clinical = 'Y'   and Z5.id_body is not null"
					   +"		left outer join bd_udidoc Z4 ON Z4.Id_Udidoc = Z5.Id_Body"
					   //+ "(Z4.Id_Udidoc in (select Z5.id_body from ci_or_srv_set Z5 where Z5.id_or = A.id_or and Z5.fg_clinical = 'Y' and Z5.id_body is not null ))"
	   				   +" where %1$s";
	
	
	/**
	 * 检查申请单数据信息SQL串 未记账
	 * （门诊）
	 * 套时部位得单独求取
	 */
	public static final String CI_IE_APPRIS_OP_ALL_SQL_1=
						" select A.id_en as id_ierisoren,B.code as patient_id,B.barcode_chis as p_bar_code,E.code as ward_code,E.name as ward_code_name,F.name_bed as bed_no,(case when B.id_idtp = '@@@@AA1000000000MNLZ' then B.Id_Code else '' end) as social_no, "
			   		   +" S.CODE as addition_no,C.Name_Pat as name,C.Telno_Pat as home_tel,C.Sd_Sex_Pat as sexid,C.Dt_Birth_Pat as birthday,'' as age,C.ADDR_PAT as home_street,C.Sd_Mari_Pat as marry_code,B.Sd_Nation as nation_code, "
					   +" B.Sd_Occu as occupation_type,U.Name as occupation_type_name,B.Workunit as work_unit,B.Sd_Country as country_code,O.Name as country_code_name, "
					   +" '' as relation_tel,'' as relation_tel_name, D.code as  code_dep_ns,D.name as name_dep_ns,G.orgCode as org_code,G.name as org_name,"
					   +" G.Name as apply_hospital,A.dt_sign as enter_date,K.code as apply_doctor,K.name as apply_doctor_name, "
					   +" L.Code as apply_unit,L.Name as apply_unit_name,A.Dt_Chk as confirm_date,H.Code as confirm_opera,H.Name as confirm_opera_name,W.Name as response_type, "
					   +" (case when F.Times_Ip is null then 0 else F.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as times, "
					   +" (case when M.FG_MAJDI='Y' then '12' when M.FG_MAJDI='N' then '13' else '' end) as diag_type_code,(case when M.FG_MAJDI='Y' then '主要诊断' when M.FG_MAJDI='N' then '次要诊断' else '' end) as diag_type_name,X.Dt_Sign as diag_input_date,M.ID_DIDEF_CODE as diag_code,M.ID_DIDEF_NAME as diag_str "
					   
					   +" ,A.Id_Or as id_ierisor,A.id_en as id_ierisoren,'' as id_ierisoritms,Q.NO_APPLYFORM as apply_serial,(case when substr(A.sd_srvtp,0,2)='02' then '"+IBdSrvIEEventConst.SD_SRVTP_JCL+"' when substr(A.sd_srvtp,0,2) ='03' then '"+IBdSrvIEEventConst.SD_SRVTP_HYL+"'  else '' end) as exam_type,(case when substr(A.sd_srvtp,0,2)='02' then '检查' when substr(A.sd_srvtp,0,2) ='03' then '化验'  else '' end) as exam_type_name "
					   +" ,R.Name as exam_content,A.Dt_Sign as exam_request_date,'' as samp_bar_code,'' as samp_type,'' as samp_content,A.Dt_Last_Mp as exam_exec_date,VV.Name as exec_unit,VV.Code as sqd_deptcode,Q.Announcements as note, "

					   +" Q.Id_Orobs as id_ierisoritm,A.Id_Or as id_ierisor,Q.NO_APPLYFORM as exam_serial,substr(P.code,3) as exam_sub_type,P.name as exam_sub_type_name,"
					   +" '' as order_pri,A.dt_effe as dt_effe,A.dt_end as dt_end,"
					   +" Z1.Code as yz_frequency,Z1.Name as yz_frequency_name,'' as exam_sub_fftype,'' as exam_sub_fftype_name,(case when P.fg_set='N' then V.Sd_Body else  Z4.code end) as exam_region,"
					   +" (case when P.fg_set='N' then Z.name else Z4.name end) as exam_region_name ,"
					   +" '' as isstest, '' as stest, A.fg_urgent as is_em, '' as is_em_r,'' as isyg, '' as yg,'' as vip_val, "
					   +" P.sd_iemsgca as iemsgca_code,(case when Z3.name='未记账' then '099' when Z3.name='已记账' then  P1.name end) as iemsgca_name , P1.ctrl1 as iemsgca_typename"

					   +" from ci_ap_obs Q left outer join ci_order A on Q.Id_Or=A.Id_Or "
					   +"       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
					   +"       left outer join en_ent C ON A.Id_En=C.Id_Ent "
					   +"       left outer join bd_dep D ON C.Id_Dep_Phy=D.ID_DEP " // D就诊科室
					   +"       left outer join bd_dep E ON C.Id_Dep_Nur=E.Id_Dep " // E就诊病区
					   +"       left outer join en_ent_ip F ON C.Id_Ent=F.Id_Ent  " // 门诊就诊
					   +"       left outer join bd_org G ON A.Id_Org=G.Id_Org " // 机构
					   +"       left outer join bd_psndoc H ON H.Id_Psndoc=A.Id_Emp_Chk "
					   +"       left outer join en_ent_op J ON A.Id_En=J.Id_Ent "
					   +"       left outer join bd_psndoc K ON K.Id_Psndoc=A.Id_Emp_Or "
					   +"       left outer join bd_dep L ON A.Id_Dep_Or=L.ID_DEP "
                       +"       left outer join en_ent_di M1 ON Q.Id_Di=M1.ID_entdi "//在检查医嘱属性表里ci_ap_obs存储的id_di是就诊诊断表en_ent_di里的ID_entdi，与其他诊断表里的ID_DI不一致，此处临时更改
					   +"       left outer join ci_di_itm M ON M1.ID_DIITM=M.ID_DIITM "
					   +"       left outer join ci_di X ON M1.Id_Di=X.Id_Di "
					   +"       left outer join bd_srvca N ON N.Id_Srvca=A.Id_Srvca "
					   +"       left outer join bd_udidoc O ON O.Id_Udidoc=B.Id_Country "
					   +"       left outer join bd_srv P ON P.id_srv=A.Id_Srv "
					   +"       left outer join bd_udidoc R ON R.Id_Udidoc=Q.Id_Pps " // 检查目的
					   +"       left outer join pi_pat_card S ON S.ID_PAT=B.Id_Pat and S.Sd_Patcardtp='04' " // 医保卡
					   +"       left outer join bd_udidoc T ON T.Id_Udidoc=B.Id_Nation "
					   +"       left outer join bd_udidoc U ON U.Id_Udidoc=B.Id_Occu "
					   +"       left outer join bd_dep VV ON VV.Id_Dep=A.Id_Dep_Mp "
					   +"       left outer join pi_pat_ca W ON W.Id_Patca=B.Id_Paticate "
					   +"       left outer join bd_freq Y ON A.Id_Freq=Y.Id_Freq "
					   +"       left outer join bd_srv_obs V ON V.Id_Srv=A.Id_Srv "
					   +"       left outer join bd_udidoc Z ON V.Id_Body=Z.Id_Udidoc    "
					   +"		left outer join bd_freq Z1 ON Z1.Id_Freq=A.Id_Freq	 "
					   +"		left outer join bd_udidoc P1 ON P.Id_iemsgca = P1.Id_Udidoc	 "
					   +"		left outer join ci_or_srv C1 ON A.id_or=C1.id_or and C1.fg_or = 'Y'"
//					   +"		left outer join ci_or_srv Z2 ON A.Id_or=Z2.Id_or "
					   +"		left outer join bd_udidoc Z3 ON (Z3.id_udidoc ='"+ICiDictCodeTypeConst.ID_SU_BL_1+"'and Z3.id_udidoclist='"+ICiDictCodeTypeConst.SD_SU_BL+"')"
					   +"		left outer join ci_or_srv_set Z5 on Z5.id_or = A.id_or and  Z5.fg_clinical = 'Y'   and Z5.id_body is not null"
					   +"		left outer join bd_udidoc Z4 ON Z4.Id_Udidoc = Z5.Id_Body"
					   //+ "(Z4.Id_Udidoc in (select Z5.id_body from ci_or_srv_set Z5 where Z5.id_or = A.id_or and Z5.fg_clinical = 'Y' and Z5.id_body is not null ))"
	   				   +" where %1$s";
	/**
	 * 病理申请单数据信息SQL串
	 * （住院）
	 */
	public static final String CI_IE_APPPATH_ALL_SQL=
						" select A.id_en as id_ierisoren,B.code as patientid,C.Name_Pat as name,W.code as patient_type,B.Id_Code as idcard,C.Telno_Pat as telephone,C.Addr_Pat as homeaddress, "
					   +" C.SD_MARI_PAT as marrycode,B.Sd_Nation as folkcode,B.SD_OCCU as procode,U.Name as proname,B.Workunit as workunitname,B.Sd_Country as countrycode,T.Name as countryname,'' as r_tel,'' as r_name, "
					   +" S.CODE as ybcode,S.Sd_Patcardtp,C.Sd_Sex_Pat as sexid,C.Dt_Birth_Pat as birthdaydate,'' as age,B.CODE_AMR_IP as patientseqnum, "
					   +" (case when F.Times_Ip is null then 0 else F.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as admiss_times "
					   +" ,D.code as deptcode,D.name as deptname,E.code as wardcode,E.name as wardname,F.NAME_BED as bedcode,G.ORGCODE as hos_code,G.NAME as hos_name "
					   +" ,A.Dt_Chk as confirm_date,H.Code as confirm_nurse_code,H.NAME as confirm_nurse_name "
					   +" ,(case when M.FG_MAJDI='Y' then '12' when M.FG_MAJDI='N' then '13' else '' end) as diag_type_code,(case when M.FG_MAJDI='Y' then '主要诊断' when M.FG_MAJDI='N' then '次要诊断' else '' end) as diag_type_name,X.Dt_Sign as diag_date,M.ID_DIDEF_CODE as diag_code,M.ID_DIDEF_NAME as diag_name "
					   +" ,A.Id_Or as id_ierisor,A.id_en as id_ierisoren,'' as id_ierisoritms,Q.NO_APPLYFORM as sqd_jccode,N.Code as sqd_ordertypecode,N.Name as sqd_ordertypename "
					   +" ,'' as sdsqd_sqddetail,A.Dt_Effe as sqd_sqddate,'' as sqd_bbh,Q.sd_samptp as sqd_bbhtype,'' as sqd_bbyq,A.Dt_Last_Mp as sqd_zxsj,L.Name as sqd_deptname,L.Code as sqd_deptcode,Q.ANNOUNCEMENTS as sqd_sqzysx "

					   +" ,'' as id_ierisoritm,A.Id_Or as id_ierisor,A.Code_Or as yz_ordercode,P.code as yz_jccode,P.name as yz_jcname,'' as jgbz,A.Dt_Effe as yz_start_time,A.dt_end as yz_stop_time "
					   +" ,Y.Code as xy_zcy_fre_code,Y.Name as xy_zcy_fre_name,'' as yz_jcffcode,'' as yz_jcffname,V.Sd_Body as yz_jcbwcode,Z.Name as yz_jcbwname,'' as is_ps,'' as is_psresult,A.Fg_Urgent as is_jj,'' as is_jjresult, '' as is_yg,'' as is_ygresult "
					   +" , '' as eu_vip, "
					   + " P.sd_iemsgca as iemsgca_code,P1.name as iemsgca_name , P1.ctrl1 as iemsgca_typename"

					   +" from ci_ap_pathgy Q left outer join ci_order A on Q.Id_Or=A.Id_Or "
					   +"       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
					   +"       left outer join en_ent C ON A.Id_En=C.Id_Ent "
					   +"       left outer join bd_dep D ON C.Id_Dep_Phy=D.ID_DEP "
					   +"       left outer join bd_dep E ON C.Id_Dep_Nur=E.Id_Dep "
					   +"       left outer join en_ent_ip F ON C.Id_Ent=F.Id_Ent  "
					   +"       left outer join bd_org G ON A.Id_Org=G.Id_Org "
					   +"       left outer join bd_psndoc H ON H.Id_Psndoc=A.Id_Emp_Chk "
					   +"       left outer join en_ent_op J ON A.Id_En=J.Id_Ent "
					   +"       left outer join bd_dep L ON A.Id_Dep_Or=L.ID_DEP "
					   +"       left outer join en_ent_di M1 ON Q.Id_Di=M1.ID_entdi "//在医嘱属性表里ci_ap_pathgy存储的id_di是就诊诊断表en_ent_di里的ID_entdi，与其他诊断表里的ID_DI不一致，此处临时更改
					   +"       left outer join ci_di_itm M ON M1.ID_DIITM=M.ID_DIITM "
					   +"       left outer join ci_di X ON M1.Id_Di=X.Id_Di "
					   +"       left outer join bd_srvca N ON N.Id_Srvca=A.Id_Srvca "
					   +"       left outer join bd_srv P ON P.id_srv=A.Id_Srv "
					   +"       left outer join pi_pat_card S ON S.ID_PAT=B.Id_Pat and S.Sd_Patcardtp='04' "
					   +"       left outer join bd_udidoc T ON T.Id_Udidoc=B.Id_Nation "
					   +"       left outer join bd_udidoc U ON U.Id_Udidoc=B.Id_Occu "
					   +"       left outer join pi_pat_ca W ON W.Id_Patca=B.Id_Paticate "
					   +"       left outer join bd_freq Y ON A.Id_Freq=Y.Id_Freq "
 					   +"       left outer join bd_srv_obs V ON V.Id_Srv=A.Id_Srv "
					   +"       left outer join bd_udidoc Z ON V.Id_Body=Z.Id_Udidoc "
					   +"		left outer join bd_udidoc P1 ON P.Code_rel7 = P1.Id_Udidoc	 "
 					   
					   +" where %1$s";	 
	/**
	 * 病理申请单数据信息SQL串
	 * （门诊）
	 * 套时部位得单独求取
	 */
	public static final String CI_IE_APPPATH_OP_ALL_SQL=
						" select A.id_en as id_ierisoren,B.code as patient_id,B.BARCODE_CHIS as p_bar_code,E.code as ward_code,E.name as ward_code_name,F.NAME_BED as bed_no,B.Id_Code as social_no, "
			   		   +" S.CODE as addition_no,C.Name_Pat as name,C.Telno_Pat as home_tel,C.Sd_Sex_Pat as sexid,C.Dt_Birth_Pat as birthday,'' as age,C.ADDR_PAT as home_street,C.Sd_Mari_Pat as marry_code,B.Sd_Nation as nation_code, "
					   +" B.Sd_Occu as occupation_type,U.Name as occupation_type_name,B.Workunit as work_unit,B.Sd_Country as country_code,O.Name as country_code_name, "
					   +" '' as relation_tel,'' as relation_tel_name, D.code as  code_dep_ns,D.name as name_dep_ns,G.orgCode as org_code,G.name as org_name," 
					   +" G.Name as apply_hospital,A.Dt_Effe as enter_date,K.code as apply_doctor,K.name as apply_doctor_name, "
					   +" L.Code as apply_unit,L.Name as apply_unit_name,A.Dt_Chk as confirm_date,H.Code as confirm_opera,H.CODE as confirm_opera_name,W.Name as response_type, "
					   +" (case when F.Times_Ip is null then 0 else F.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as times, "
					   +" (case when M.FG_MAJDI='Y' then '12' when M.FG_MAJDI='N' then '13' else '' end) as diag_type_code,(case when M.FG_MAJDI='Y' then '主要诊断' when M.FG_MAJDI='N' then '次要诊断' else '' end) as diag_type_name,X.Dt_Sign as diag_input_date,M.ID_DIDEF_CODE as diag_code,M.ID_DIDEF_NAME as diag_str "

					   +" ,A.Id_Or as id_ierisor,A.id_en as id_ierisoren,'' as id_ierisoritms,Q.NO_APPLYFORM as apply_serial,N.Code as exam_type,N.Name as exam_type_name "
					   +" ,'' as exam_content,A.Dt_Sign as exam_request_date,'' as samp_bar_code,Q.sd_samptp as samp_type,'' as samp_content,A.Dt_Last_Mp as exam_exec_date,VV.Name as exec_unit,VV.Code as sqd_deptcode,Q.Announcements as note, "

					   +" '' as id_ierisoritm,Q.NO_APPLYFORM as id_ierisor,Q.NO_APPLYFORM as exam_serial,substr(P.code,3) as exam_sub_type,P.name as exam_sub_type_name,"
					   + " '' as order_pri,A.dt_effe as dt_effe,A.dt_end as dt_end,"
					   + " Y.Code as yz_frequency,Y.Name as yz_frequency_name,'' as exam_sub_fftype,'' as exam_sub_fftype_name,V.Sd_Body as exam_region,Z.Name as exam_region_name, "
					   + " '' as isstest, '' as stest, A.fg_urgent as is_em, '' as is_em_r,'' as isyg, '' as yg,'' as vip_val, "
					   + " P.sd_iemsgca as iemsgca_code,(case when Z3.name='未记账' then '099' when Z3.name='已记账' then  P1.name end) as iemsgca_name  , P1.ctrl1 as iemsgca_typename"

					   +" from ci_ap_pathgy Q left outer join ci_order A on Q.Id_Or=A.Id_Or "
					   +"       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
					   +"       left outer join en_ent C ON A.Id_En=C.Id_Ent "
					   +"       left outer join bd_dep D ON C.Id_Dep_Phy=D.ID_DEP "
					   +"       left outer join bd_dep E ON C.Id_Dep_Nur=E.Id_Dep "
					   +"       left outer join en_ent_ip F ON C.Id_Ent=F.Id_Ent  "
					   +"       left outer join bd_org G ON A.Id_Org=G.Id_Org "
					   +"       left outer join bd_psndoc H ON H.Id_Psndoc=A.Id_Emp_Chk "
					   +"       left outer join en_ent_op J ON A.Id_En=J.Id_Ent "
					   +"       left outer join bd_psndoc K ON K.Id_Psndoc=A.Id_Emp_Or "
					   +"       left outer join bd_dep L ON A.Id_Dep_Or=L.ID_DEP "
					   +"       left outer join en_ent_di M1 ON Q.Id_Di=M1.ID_entdi "//在医嘱属性表里ci_ap_pathgy存储的id_di是就诊诊断表en_ent_di里的ID_entdi，与其他诊断表里的ID_DI不一致，此处临时更改
					   +"       left outer join ci_di_itm M ON M1.ID_DIITM=M.ID_DIITM "
					   +"       left outer join ci_di X ON M1.Id_Di=X.Id_Di "
					   +"       left outer join bd_srvca N ON N.Id_Srvca=A.Id_Srvca "
					   +"       left outer join bd_udidoc O ON O.Id_Udidoc=B.Id_Country "
					   +"       left outer join bd_srv P ON P.id_srv=A.Id_Srv "
					   +"       left outer join pi_pat_card S ON S.ID_PAT=B.Id_Pat and S.Sd_Patcardtp='04' "
					   +"       left outer join bd_udidoc T ON T.Id_Udidoc=B.Id_Nation "
					   +"       left outer join bd_udidoc U ON U.Id_Udidoc=B.Id_Occu "
					   +"       left outer join bd_dep VV ON VV.Id_Dep=A.Id_Dep_Mp "
					   +"       left outer join pi_pat_ca W ON W.Id_Patca=B.Id_Paticate "
					   +"       left outer join bd_freq Y ON A.Id_Freq=Y.Id_Freq "
					   +"       left outer join bd_srv_obs V ON V.Id_Srv=A.Id_Srv "
					   +"       left outer join bd_udidoc Z ON V.Id_Body=Z.Id_Udidoc "
//					   +"		left outer join bd_udidoc P1 ON P.Code_rel7 = P1.Id_Udidoc	 "
					   +"		left outer join bd_udidoc P1 ON P.Id_iemsgca = P1.Id_Udidoc	 "
					   +"		left outer join bd_udidoc Z3 ON (Z3.id_udidoc ='"+ICiDictCodeTypeConst.ID_SU_BL_1+"'and Z3.id_udidoclist='"+ICiDictCodeTypeConst.SD_SU_BL+"')"
					   +"		left outer join ci_or_srv_set Z5 on Z5.id_or = A.id_or and  Z5.fg_clinical = 'Y'   and Z5.id_body is not null  "
					   +"		left outer join bd_udidoc Z4 ON Z4.Id_Udidoc = Z5.Id_Body "
					   //+ "(Z4.Id_Udidoc in (select Z5.id_body from ci_or_srv_set Z5 where Z5.id_or = A.id_or and Z5.fg_clinical = 'Y' and Z5.id_body is not null ))"
	   				   +" where %1$s";
	
	/**
	 * 门诊药品医嘱就诊信息SQL串 20170517yjb
	 * 仅门诊药品用   代理人信息得单独求取
	 */
	public static final String CI_IE_ORPHARM_OP_CONFIRM_SQL=
			"select A.id_en as id_iepharmoren,B.code as patientid,B.BARCODE_CHIS as p_bar_code,F.Times_Op as times, "
			+ "D.CODE as dept_code,D.Name as deptname,J.orgcode as orgcode,J.name as orgname,"
		    + "C.Name_Pat as patientname,C.Sd_Sex_Pat as sex,C.Dt_Birth_Pat as birthday,'' as age, "
		    + "'' as relationcode,'' as dbsocialid,'' as dbname,E.Code as responsetypecode,E.Name as responsetypename, "
		    + "H.Code as insurrancecode,H.Name as insurrancetype,I.Code as insurranceno "
		   
		   +" from ci_order A "
		   +"       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
		   +"       left outer join en_ent C ON A.Id_En=C.Id_Ent "
		   +"       left outer join bd_dep D ON C.Id_Dep_Phy=D.ID_DEP "
		   +"       left outer join en_ent_op F ON C.Id_Ent=F.Id_Ent "
		   +"       left outer join pi_pat_ca E ON E.Id_Patca=B.Id_Paticate "
		   +"       left outer join bd_hp G ON G.Id_Hp=C.Id_Hp "
		   +"       left outer join (select * from bd_udidoc where id_udidoclist='@@@@ZZ200000000000A2' ) H ON H.Code=G.Sd_Hptp "
		   +"       left outer join bd_cust I ON I.ID_CUST=G.ID_CUST "
		   + "      left outer join bd_org J ON J.ID_ORG=A.ID_ORG "	
		   +" where A.id_or=?"; 
	/**
	 * 门诊药品处方数据信息SQL串 20170517yjb
	 * 仅门诊药品用 
	 */
	public static final String CI_IE_ORPHARM_OP_PRES_SQL=
			"select A.ID_PRES as id_iepharmpres,A.Id_En as id_iepharmoren,null as id_iepharmwcors,G.code ||'_'||F.Times_Op||'_'||A.Sd_Prestp||'_'||A.Code as orderno, "
			+ "A.Sd_Prestp as ordertypecode,B.name as ordertypename,C.Code as doctorcode,C.Name as doctorname,A.Dt_Entry as ordertime, "
		    + "D.Code as deptcode,D.Name as deptname,E.code as checkdoctorcode,E.name as checkdoctorname,A.Dt_Entry as checktime "

		   +" from ci_pres A "
		   +"       left outer join bd_udidoc B ON B.Id_Udidoc=A.Id_Prestp "
		   +"       left outer join bd_psndoc C ON C.Id_Psndoc=A.Id_Emp_Or "
		   +"       left outer join bd_dep D ON D.Id_Dep=A.Id_Dep_Or "
		   +"       left outer join bd_psndoc E ON A.Id_Emp=E.Id_Psndoc "
		   +"		left outer join en_ent_op F ON F.Id_Ent=A.Id_En "
		   +"		left outer join pi_pat G ON A.id_pati=G.id_pat "
		   +" where A.Id_Pres in (select distinct p.id_pres from ci_or_srv p where %1$s)";
	
	/**
	 * 就诊单元门诊药品处方数据信息SQL串 20170517yjb
	 * 仅门诊药品用 
	 */
	public static final String CI_IE_ORPHARM_OP_PRES8IDEN_SQL=
			"select A.ID_PRES as id_iepharmpres,A.Id_En as id_iepharmoren,null as id_iepharmwcors,A.code||'_'||A.id_pres as orderno , "//A.Code as orderno  | F.code||'_'||G.times_op||'_'||A.SD_PRESTP||'_'||A.code as orderno
			+ "A.Sd_Prestp as ordertypecode,B.name as ordertypename,C.Code as doctorcode,C.Name as doctorname,A.Dt_Entry as ordertime, "
		    + "D.Code as deptcode,D.Name as deptname,E.code as checkdoctorcode,E.name as checkdoctorname,A.Dt_Entry as checktime "

		   +" from  ci_pres A "
		   +"       left outer join bd_udidoc B ON B.Id_Udidoc=A.Id_Prestp "
		   +"       left outer join bd_psndoc C ON C.Id_Psndoc=A.Id_Emp_Or "
		   +"       left outer join bd_dep D ON D.Id_Dep=A.Id_Dep_Or "
		   +"       left outer join bd_psndoc E ON A.Id_Emp=E.Id_Psndoc "
		   +"		left outer join pi_pat F ON F.id_pat = A.id_pati"
		   +"       left outer join en_ent_op G ON A.Id_En=G.Id_Ent "
		   +" where A.Id_Pres in (select distinct p.id_pres  from ci_or_srv p where %1$s ) ";
	/**
	 * 门诊西成药处方数据信息SQL串 20170517yjb
	 * 仅门诊西成药用
	 */
	public static final String CI_IE_ORDRUGWC_OP_SQL=
			"select  A1.Id_Orsrv as id_iepharmwcor,A1.Id_Pres as id_iepharmpres,A1.id_orsrv as yzno,'03' as medicine_type,"
			+" (case when Z2.code_entp='00' then '10' when Z2.code_entp='01' then '02' end) as ordertypecode,(case when Z2.code_entp='00' then '门诊西药' when Z2.code_entp='01' then '急诊西药' end) as ordertypename,A1.Sd_Hpsrvtp as ybtypecode,R.Name as ybtypename,S.Code as frqcode,S.Name as frqname, "
		    +" A.Days_Or as persdays,T.Code as drugscode,T.Name as drugsname,A1.Quan_Medu as dosage,U.Name as dosageunit, "
		    +" V.Quan_Cur as amount,W.Name as amountunit,V.Quan_Cur as getamount,W.Name as getunit,V.Code_Mm as ypcode,(case when Z1.CODE='1000' then '00' when Z1.CODE='1001' THEN '01' ELSE '' END ) as packserial,'' as parentno,A1.NOTE_SRV as advice, "
		    +" X.Code as exunitcode,X.Name as exunitname, "
		    +" (case when A1.Fg_Skintest='Y' then 'true' else 'false' end) as is_ps,(case when A1.FG_SKINTEST_RST='Y' then (select t1.name from ci_skin_test t left outer join bd_udidoc t1 on t.id_rst_skintest=t1.id_udidoc where t.id_or=A1.Id_Or) else '' end) as is_psresult, "
		    +" (case when A1.Fg_Indic='Y' then 'true' else 'false' end ) as is_syz,(case when A1.Fg_Indic='Y' then '适应' else '非适应' end) as is_syzresult, "
		    +" (case when S.Sd_Frequnitct='0' and S.Code='ST' then 'true' else 'false' end) as is_jj,(case when A.Fg_Urgent='Y' then '加急' when A.Fg_Urgent='N' then '非加急' else '' end) as is_jjresult, "
		    +" '' as is_yg,'' as is_ygresult "

		   +" from ci_or_srv A1 "
		   +"      inner join ci_order A ON A.Id_Or=A1.Id_Or "
		   
		   +"      left outer join ci_pres P ON P.Id_Pres=A1.Id_Pres "
		   +"      left outer join bd_udidoc Q ON Q.Id_Udidoc=P.Id_Prestp "
		   +"      left outer join bd_udidoc R ON R.Id_Udidoc=A1.Id_Hpsrvtp "
		   +"      left outer join bd_freq S ON S.Id_Freq=A1.Id_Freq  "
		   +"      left outer join bd_route T ON T.Id_Route=A1.Id_Route "
		   +"      left outer join bd_measdoc U ON U.Id_Measdoc=A1.Id_Medu "
		   +"      left outer join ci_or_srv_mm V ON V.ID_ORSRV=A1.Id_Orsrv "
		   +"      left outer join bd_measdoc W ON W.Id_Measdoc=V.Id_Pgku_Cur "
		   +"      left outer join bd_dep X ON X.ID_DEP=A1.Id_Dep_Wh "
		   //+"	   LEFT OUTER JOIN CI_OR_SRV_MM Y ON A1.ID_ORSRV=Y.ID_ORSRV "
		   +"	   LEFT OUTER JOIN BD_MM_PKGU Z ON (Z.ID_MM = V.ID_MM AND Z.ID_UNIT_PKG=V.ID_PGKU_CUR) "
		   +"	   LEFT OUTER JOIN BD_MM_PKGUTP Z1 ON Z.ID_MMPKGUTP=Z1.ID_MMPKGUTP "
		   +"	   LEFT OUTER JOIN en_ent Z2 ON A.id_en=Z2.id_ent "
		   +" where  %1$s ";  //A1.Id_Pres	临时方案 将包装序号packserial用单位代替
	/**
	 * 门诊草药处方数据信息SQL串 20170517yjb
	 * 仅门诊草药用
	 */
	public static final String CI_IE_ORDRUGHERB_OP_SQL=
			" select A1.Id_Orsrv as id_iepharmor,A1.Id_Pres as id_iepharmpres,null as id_iepharmormms,A.id_or as yzno,'04' as medicine_type, "
			+" '04' as ordertypeno,'草药饮片' as ordertypename,S.Code as frqcode,S.Name as frqname, "
		    +" A.Orders as amount,'付' as amountunit,X.Code as execunitcode,X.Name as exeunitname,A1.NOTE_SRV as advice, "
		    +" A1.Fg_Skintest as is_ps,(case when A1.FG_SKINTEST_RST='Y' then (select t1.name from ci_skin_test t left outer join bd_udidoc t1 on t.id_rst_skintest=t1.id_udidoc where id_or=A1.Id_Or) else '' end) as is_psresult, "
		    +" A1.Fg_Indic as is_syz,(case when A1.Fg_Indic='Y' then '适应' else '非适应' end) as is_syzresult,"
		    +" (case when S.Sd_Frequnitct='0' and S.Code='ST' then 'Y' else 'N' end) as is_jj,(case when A.Fg_Urgent='Y' then '加急' when A.Fg_Urgent='N' then '非加急' else '' end) as is_jjresult, "
		    +" '' as is_yg,'' as is_ygresult "
		   
		   +" from ci_or_srv A1 "
		   +"      inner join ci_order A ON A.Id_Or=A1.Id_Or "
		   +"      left outer join ci_pres P ON P.Id_Pres=A1.Id_Pres "
		   +"      left outer join bd_udidoc Q ON Q.Id_Udidoc=P.Id_Prestp "
		   +"      left outer join bd_freq S ON S.Id_Freq=A1.Id_Freq  "
		   +"      left outer join bd_dep X ON X.ID_DEP=A1.Id_Dep_Wh "
		
		   +" where  %1$s ";  //A1.Id_Pres	
	/**
	 * 门诊草药处方明细成分数据信息SQL串 20170517yjb
	 * 仅门诊草药用
	 * 草药成分数据
	 */
	public static final String CI_IE_ORDRUGHERB_MM_OP_SQL=
			" select A2.Id_Orsrvmm as id_iepharmormm,A1.ID_PRES as id_iepharmor,A2.Quan_Cur as weight,T.Name as weightunit,A2.CODE_MM as ypcode, "
		   +" (case when Z1.CODE='1000' then '00' when Z1.CODE='1001' THEN '01' ELSE '' END ) as packserial,U.Code as methocode,U.name as methoname,'07' as nmwamount,'true' as isnmwamount,A1.Sd_Hpsrvtp as ybtypecode,R.Name as ybtypename "
		   
		   +" from ci_or_srv A1  "
		   +"      inner join ci_order A ON A.Id_Or=A1.Id_Or "
		   +"      left outer join ci_or_srv_mm A2 ON A1.Id_Orsrv=A2.Id_Orsrv "
		   +"      left outer join ci_pres P ON P.Id_Pres=A1.Id_Pres "
		   +"      left outer join bd_measdoc T ON T.Id_Measdoc=A2.Id_Pgku_Cur  "
		   +"      left outer join bd_boil U ON U.Id_Boil=A1.Id_Boil  "
		   +"      left outer join bd_udidoc R ON R.Id_Udidoc=A1.Id_Hpsrvtp "
		   +"	   LEFT OUTER JOIN CI_OR_SRV_MM Y ON A1.ID_ORSRV=Y.ID_ORSRV "
		   +"	   LEFT OUTER JOIN BD_MM_PKGU Z ON (Z.ID_MM = Y.ID_MM AND Z.ID_UNIT_PKG=Y.ID_PGKU_CUR) "
		   +"	   LEFT OUTER JOIN BD_MM_PKGUTP Z1 ON Z.ID_MMPKGUTP=Z1.ID_MMPKGUTP "
		   +" where  %1$s  and A1.Fg_Or='Y' ";  //A1.Id_Pres  临时方案 将包装序号packserial用单位代替
	/**
	 * 门诊作废医嘱数据信息SQL串
	 * 仅门诊作废医嘱使用
	 */
	public static final String CI_IE_ORCANCEL_OP_SQL=
			" select A.Id_En as id_ieorcancstpen,B.code as patient_id,X.Code as exec_unit,X.Name as exec_unit_name,'01' as domain_id, "
		   +"  (case when F.Times_Ip is null then 0 else F.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as times "
		   +"  ,A.ID_OR as id_ieorcancstp,A.Id_En as id_ieorcancstpen,A.Code_Or as order_id,N.Code as order_type,'' as sample_no, "
		   +" A.Dt_Canc as cancel_date,K.Code as cancel_opera,K.Name as cancel_opera_name,' ' as cancel_reason,'' as mutex_order_no,'' as mutex_order_type,'' as mutex_order_name, "
		   //IE集成平台差异对比新增 2017-06-22 18:04:40
		   +"	P.code as dept_code,P.name as dept_name,O.orgcode as org_code,O.name as org_name,'1' as sequence_number "
		   //end
		   +" from ci_order A  "
		   +"      left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
		   +"      left outer join en_ent C ON A.Id_En=C.Id_Ent  "
		   +"      left outer join en_ent_ip F ON C.Id_Ent=F.Id_Ent "
		   +"      left outer join en_ent_op J ON A.Id_En=J.Id_Ent "
		   +"      left outer join bd_dep X ON X.ID_DEP=A.Id_Dep_Mp "
		   +"      left outer join bd_srvca N ON N.Id_Srvca=A.Id_Srvca "
		   +"      left outer join bd_psndoc K ON K.Id_Psndoc=A.Id_Emp_Canc"
		   //IE集成平台差异对比新增 2017-06-22 18:05:00
		   +"	   LEFT OUTER JOIN bd_org O ON A.id_org_or=O.id_org  "
		   +"	   LEFT OUTER JOIN bd_dep P ON C.id_dep_phy =P.id_dep  "
		   //end
		   +" where  %1$s ";  //A.Id_or
	/**
	 * 住院作废核对或停核医嘱数据信息SQL串
	 * 仅住院作废核对或停核医嘱使用
	 */
	public static final String CI_IE_ORCANCEL_SQL=
			" select A.Id_En as id_ieorcancstpen,B.code as patientid,X.Code as exec_dept_code,X.Name as exec_dept_name,'02' as domain_id, "
		   +" (case when F.Times_Ip is null then 0 else F.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as admiss_times, "
		   +" A.ID_OR as id_ieorcancstp,A.Code_Or as orderno,N.Code as ordertype,'' as bbno, "
		   +" (case when A.Fg_Canc='Y' then A.Dt_Chk else A.Dt_Stop end) as canceltime, "
		   +" (case when A.Fg_Canc='Y' then K.Code else L.Code end) as cancelpersoncode, "
		   +" (case when A.Fg_Canc='Y' then K.Name else L.Name end) as cancelpersonname, "
		   +" '' as yz_cancel_yy,'' as hc_order_no,'' as hc_order_type_no,'' as hc_order_type_name, "
		   //IE集成平台差异对比后新增 begin 2017-05-18 19:39:08
		   +"	P.code as dept_code,P.name as dept_name,O.orgcode as org_code,O.name as org_name,'1' as sequence_number"
		   //end
		   +" from ci_order A  "
		   +"       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
		   +"       left outer join en_ent C ON A.Id_En=C.Id_Ent  "
		   +"       left outer join en_ent_ip F ON C.Id_Ent=F.Id_Ent "
		   +"       left outer join en_ent_op J ON A.Id_En=J.Id_Ent "
		   +"       left outer join bd_dep X ON X.ID_DEP=A.Id_Dep_Mp "
		   +"       left outer join bd_srvca N ON N.Id_Srvca=A.Id_Srvca "
		   +"       left outer join bd_psndoc K ON K.Id_Psndoc=A.Id_Emp_Canc "
		   +"       left outer join bd_psndoc L ON L.Id_Psndoc=A.Id_Emp_Stop "
		   // IE集成平台差异对比后新增 begin 2017-05-18 19:39:10
		   +"		LEFT OUTER JOIN bd_dep P ON C.id_dep_phy =P.id_dep  "
		   +"		LEFT OUTER JOIN bd_org O ON A.id_org_or=O.id_org  "	
		   //end
		   +" where  %1$s ";  //A.Id_or		 
	/**
	 * 住院手术医嘱数据信息SQL串
	 * 仅住院手术医嘱使用
	 */
	public static final String CI_IE_OROP_SQL=
			" select Q.Id_Apop as id_ieoporen,B.code as patientid,C.Name_Pat as name,C.Sd_Sex_Pat as sexid,C.Dt_Birth_Pat as birthdaydate,'' as age,B.Id_Code as idcard,C.Telno_Pat as telephone,C.ADDR_PAT as homeaddress "
		   +" ,S.Code as ybcode,B.BARCODE_CHIS as patientseqnum,(case when H.Times_Ip is null then 0 else H.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as admiss_times "
		   +" ,I.code as deptcode,I.name as deptname,G.Code as wardcode,G.Name as wardname,H.NAME_BED as bedcodeo,K.orgcode as hos_code,K.name as hos_name,A.Dt_Chk as confirm_date,R.Code as confirm_nurse_code,R.Name as confirm_nurse_name,N.Code as orderbyid,N.Name as orderbyname "
		   +" ,O.code as locationid,O.name as locationname,C.Dt_Entry as visit_date,Q.Dt_Plan as op_datetime,L.Code as op_doctor,L.Name as op_doctor_name,M.code as exec_code,M.name as exec_code_name,'01' as isstest,'不皮试' as stest,'03' as is_em,(case when A.Fg_Urgent='Y' then '加急'  else '不加急' end) as is_em_r,'' as isyg,'' as yg,'' as is_frozen_flag,'' as frozen_flag "
		   +" ,'' as is_urgent_select_flag,'' as urgent_select_flag, Q.Announcements as comment1,'' as response_type_code,'' as response_type_name,(case when P.FG_MAJDI='Y' then '12' when P.FG_MAJDI='N' then '13' else '' end) as diag_type,(case when P.FG_MAJDI='Y' then '主要诊断' when P.FG_MAJDI='N' then '次要诊断' else '' end) as diag_type_name "
		   +" ,P.ID_DIDEF_CODE as diag_code,P.ID_DIDEF_NAME as diag_str,A.Code_Or as yz_no,Q.NO_APPLYFORM as op_record_id,Q.NO_APPLYFORM as op_code,D.Name as op_code_name "
		   +" ,Q.ANNOUNCEMENTS as op_describe,A.Dt_Entry as apply_date,Q.Sd_Lvlsug as op_scale,E.name as op_scale_name,Q.Sd_Anestp as anaesthesia_method_code,F.Name as anaesthesia_method_name,'02' as domain_id "
		   +" from ci_ap_sug Q left outer join ci_order A on Q.Id_Or=A.Id_Or "
		   +"       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
		   +"       left outer join en_ent C ON A.Id_En=C.Id_Ent "
		   +"       left outer join bd_srv D ON Q.Id_Srv=D.Id_Srv "
		   +"       left outer join bd_udidoc E ON E.Id_Udidoc=Q.Id_Lvlsug "
		   +"       left outer join bd_udidoc F ON F.Id_Udidoc=Q.Id_Anestp "
		   +"       left outer join bd_dep G ON G.Id_Dep=C.Id_Dep_Nur "
		   +"       left outer join en_ent_ip H ON C.Id_Ent=H.Id_Ent  "
		   +"       left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Phy "
		   +"       left outer join en_ent_op J ON A.Id_En=J.Id_Ent "
		   +"       left outer join pi_pat_card S ON S.ID_PAT=B.Id_Pat and S.Sd_Patcardtp='04' "
		   +"       left outer join bd_org K ON A.Id_Org=K.Id_Org "
		   +"       left outer join bd_psndoc L ON L.Id_Psndoc=Q.Id_Emp_Operate "
		   +"       left outer join bd_dep M ON M.Id_Dep=A.Id_Dep_Mp "
		   +"       left outer join bd_psndoc N ON N.Id_Psndoc=A.Id_Emp_Sign "
		   +"       left outer join bd_dep O ON O.Id_Dep=A.Id_Dep_Sign "
           +"       left outer join en_ent_di M1 ON Q.Id_Di=M1.ID_entdi "//在检查医嘱属性表里ci_ap_sug存储的id_di是就诊诊断表en_ent_di里的ID_entdi，与其他诊断表里的ID_DI不一致，此处临时更改
		   +"       left outer join ci_di_itm P ON M1.Id_Diitm=P.ID_DIITM "
		   +"       left outer join bd_psndoc R ON R.Id_Psndoc=A.Id_Emp_Chk	 "
		   +" where  %1$s ";  //A.Id_or	
	/**
	 * 门诊手术医嘱数据信息SQL串
	 * 仅门诊手术医嘱使用
	 */
	public static final String CI_IE_OROP_OP_SQL=
			" select Q.Id_Apop as id_ieoporen,B.code as patient_id,A.Code_Or as yz_no,Q.NO_APPLYFORM as op_record_id,D.Code as op_code,D.Name as op_code_name,Q.ANNOUNCEMENTS as op_describe "
		   +" ,A.Dt_Entry as apply_date,Q.Sd_Lvlsug as op_scale,E.name as op_scale_name,Q.Sd_Anestp as anaesthesia_method_code,F.Name as anaesthesia_method_name,B.BARCODE_CHIS as p_bar_code	"
		   +" ,G.name as ward_code_name,G.Code as ward_code,H.NAME_BED as bed_no,B.Id_Code as social_no,S.Code as addition_no1,C.Name_Pat as name,C.Telno_Pat as home_tel,C.Sd_Sex_Pat as sex,C.Dt_Birth_Pat as birthday,'' as age "
		   +" ,C.ADDR_PAT as home_street,I.code as patient_dept,I.name as patient_dept_name,K.orgcode as hospital_code,K.name as hospital_name,Q.Dt_Plan as op_datetime "
		   +" ,L.Code as op_doctor,L.name as op_doctor_name,M.code as exec_code,M.name as exec_code_name,N.code as apply_user,N.name as apply_user_name "
		   +" ,O.code as dept_code,O.name as dept_code_name,'' as check_date,'' as check_opera,'' as check_opera_name,A.fg_skintest as isstest,A.fg_skintest as stest "
		   +" ,'03' as is_em,(case when A.Fg_Urgent='Y' then 'true'  else 'false' end) as is_em_r,'' as is_frozen_flag,'' as frozen_flag,'' as is_urgent_select_flag,'' as urgent_select_flag " 
		   +" ,Q.Announcements as comment1,(case when H.Times_Ip is null then 0 else H.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as admit_times,C.Dt_Entry  as visit_date,'' as response_type_code,'' as response_type_name "
		   +" ,(case when P.FG_MAJDI='Y' then '12' when P.FG_MAJDI='N' then '13' else '' end) as diag_type,(case when P.FG_MAJDI='Y' then '主要诊断' when P.FG_MAJDI='N' then '次要诊断' else '' end) as diag_type_name,P.ID_DIDEF_CODE as diag_code,P.ID_DIDEF_NAME as diag_str,'' as isyg,'' as yg,'01' as domain_id "
		   +" from ci_ap_sug Q left outer join ci_order A on Q.Id_Or=A.Id_Or "
		   +"       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
		   +"       left outer join en_ent C ON A.Id_En=C.Id_Ent "
		   +"       left outer join bd_srv D ON Q.Id_Srv=D.Id_Srv "
		   +"       left outer join bd_udidoc E ON E.Id_Udidoc=Q.Id_Lvlsug "
		   +"       left outer join bd_udidoc F ON F.Id_Udidoc=Q.Id_Anestp "
		   +"       left outer join bd_dep G ON G.Id_Dep=C.Id_Dep_Nur "
		   +"       left outer join en_ent_ip H ON C.Id_Ent=H.Id_Ent  "
		   +"       left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Phy "
		   +"       left outer join en_ent_op J ON A.Id_En=J.Id_Ent "
		   +"       left outer join pi_pat_card S ON S.ID_PAT=B.Id_Pat and S.Sd_Patcardtp='04' "
		   +"       left outer join bd_org K ON A.Id_Org=K.Id_Org "
		   +"       left outer join bd_psndoc L ON L.Id_Psndoc=Q.Id_Emp_Operate "
		   +"       left outer join bd_dep M ON M.Id_Dep=A.Id_Dep_Mp "
		   +"       left outer join bd_psndoc N ON N.Id_Psndoc=A.Id_Emp_Or "
		   +"       left outer join bd_dep O ON O.Id_Dep=A.Id_Dep_Or "
+"       left outer join en_ent_di M1 ON Q.Id_Di=M1.ID_entdi "//在检查医嘱属性表里ci_ap_sug存储的id_di是就诊诊断表en_ent_di里的ID_entdi，与其他诊断表里的ID_DI不一致，此处临时更改
		   +"       left outer join ci_di_itm P ON M1.Id_Diitm=P.ID_DIITM "
		   +" where  %1$s ";  //A.Id_or	
	/**
	 * 住院治疗医嘱就诊信息SQL串
	 * 治疗处置
	 */
	public static final String CI_IE_ORTREAT_CONFIRM_SQL=
			" select A.Id_En as id_ietreatoren,B.code as patientid,C.Name_Pat as name,C.Sd_Sex_Pat as sexid,'' as age,C.Dt_Birth_Pat as birthdaydate,B.BARCODE_CHIS as patientseqnum, "
		   +" (case when H.Times_Ip is null then 0 else H.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as admiss_times, "
		   +" I.Code as deptcode,I.Name as deptname,G.Code as wardcode,G.Name as wardname,H.NAME_BED as bedcode,A.Dt_Chk as confirm_date,R.Code as confirm_nurse_code,R.Name as confirm_nurse_name,'02' as domain_id "
		   +" from ci_order A "
		   +"       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
		   +"       left outer join en_ent C ON A.Id_En=C.Id_Ent "
		   +"       left outer join en_ent_ip H ON C.Id_Ent=H.Id_Ent  "
		   +"       left outer join en_ent_op J ON A.Id_En=J.Id_Ent "
		   +"       left outer join bd_dep G ON G.Id_Dep=C.Id_Dep_Nur "
		   +"       left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Phy "
		   +"       left outer join bd_psndoc R ON R.Id_Psndoc=A.Id_Emp_Chk "	
		   +" where A.id_or=?"; 	
	/**
	 * 门诊治疗医嘱就诊信息SQL串 20170517yjb
	 * 治疗处置
	 */
	public static final String CI_IE_ORTREAT_CONFIRM_OP_SQL=
			"select A.Id_En as id_ietreatoren,'' as ietreatfees,B.code as patient_id,B.BARCODE_CHIS as p_bar_code, "
           +" C.Name_Pat as name,C.Sd_Sex_Pat as sex,'' as age,C.Dt_Birth_Pat as birthday,I.code as apply_unit,I.name as apply_unit_name, "
		   +" (case when H.Times_Ip is null then 0 else H.Times_Ip end)+(case when J.Times_Op is null then 0 else J.Times_Op end) as admiss_times, "
		   +" G.code as ward_code,G.Name as ward_code_name,H.NAME_BED as bed_no,A.Dt_Chk as confrim_date, "
		   +" R.Code as confirm_opera,R.Name as confrim_opera_name,'01' as domain_id,D.orgcode as orgcode,D.name as orgname "
		   +" from ci_order A "
		   +"       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
		   +"       left outer join en_ent C ON A.Id_En=C.Id_Ent "
		   +"       left outer join en_ent_ip H ON C.Id_Ent=H.Id_Ent  "
		   +"       left outer join en_ent_op J ON A.Id_En=J.Id_Ent "
		   +"       left outer join bd_dep G ON G.Id_Dep=C.Id_Dep_Nur "
		   +"       left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Phy "
		   +"       left outer join bd_psndoc R ON R.Id_Psndoc=A.Id_Emp_Chk "
		   +"       left outer join bd_org D ON D.Id_org=A.Id_org "
		   +" where A.id_or=? "; 
	/**
	 * 住院治疗医嘱信息SQL串
	 * 治疗处置
	 */
	public static final String CI_IE_ORTREAT_ITM_SQL=
			" select A1.Id_Orsrv as id_ietreator,A.Id_En as id_ietreatoren,A.Code_Or as zl_no,A1.Id_Orsrv as order_code,D.Code as order_type_code,D.Name as order_type_name,A1.NOTE_SRV as yz_memo,E.Code as yz_code,E.Name as yz_name,F.Name as bz_no, "
		   +" A1.Quan_Medu as yz_unit,F.Name as yz_unit_code,G.code as fre_no,G.name as fre_name,I.code as yz_ward_code,I.name as yz_ward_name,G.code as yz_dept_code,G.name as yz_dept_name,A.Dt_Entry as yz_date,J.Code as yz_doctor_code,J.Name as yz_doctor_name, "
		   +" A.Dt_Chk as yz_confirm_date,K.code as yz_confirm_doctor_code,K.name as yz_confirm_doctor_name,L.code as exe_dept_code,L.name as exe_dept_name,'' as f_order_code,'' as hc_order_type_code,'' as hc_order_type_name, "
		   +" A.Dt_Effe as yz_start_time,A.Dt_End as yz_stop_time,A1.Fg_Indic as is_sy,(case when A1.Fg_Indic='Y' then 'true' when A1.Fg_Indic='N' then 'false' else '' end) as is_syresult,(case when G.Sd_Frequnitct='0' and G.Code='ST' then 'Y' else 'N' end) as is_jj, "
		   +" (case when A.Fg_Urgent='Y' then 'true' when A.Fg_Urgent='N' then 'false' else '' end) as is_jjresult,'' as is_yg,'' as is_ygresult,M.Code as yb_type_code,M.name as yb_type_name,'' as jt,'' as fybj_code,'' as fybj_name "
		   +" from ci_or_srv A1 left outer join ci_order A  ON A1.Id_Or=A.Id_Or "
 		   +"      left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
		   +"      left outer join en_ent C ON A.Id_En=C.Id_Ent "
		   +"      left outer join bd_srvca D ON A1.Id_Srvca=D.Id_Srvca "
		   +"      left outer join bd_srv E ON E.Id_Srv=A1.Id_Srv "
		   +"      left outer join bd_measdoc F ON F.Id_Measdoc=A1.Id_Medu "
		   +"      left outer join bd_freq G ON G.Id_Freq=A1.Id_Freq "
		   +"      left outer join bd_dep H ON H.Id_Dep=C.Id_Dep_Phy "
		   +"      left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Nur "
		   +"      left outer join bd_psndoc J ON J.Id_Psndoc=A1.Id_Emp_Srv "
		   +"      left outer join bd_psndoc K ON K.Id_Psndoc=A.Id_Emp_Chk "
		   +"      left outer join bd_dep L ON L.Id_Dep=A1.Id_Dep_Mp "
		   +"      left outer join bd_udidoc M ON M.id_udidoc=A1.Id_Hpsrvtp	"
	   	   +" where %1$s and A1.Fg_or='Y'";  //A1.Id_or
	
	/**
	 * 门诊治疗医嘱信息SQL串 20170517yjb
	 * 治疗处置
	 */
	public static final String CI_IE_ORTREAT_ITM_OP_SQL=
			"select A1.Id_Orsrv as id_ietreator,A.Id_En as id_ietreatoren,A1.id_pres as order_no,A1.id_orsrv as yz_no,"
			+ "D.Code as order_type,D.Name as order_type_name,A1.Note_Srv as yz_comment,E.Code as yz_code,E.Name as yz_name,F.Name as pack_serial, "
		    + "A1.Quan_Total_Medu as charge_amount,F.Name as spe_external,G.code as freq_code,G.name as freq_code_name,H.code as yz_olddept_code,H.name as yz_olddept_name,"
		    + "I.code as yz_oldward_code,I.name as yz_oldward_name,A.Dt_Entry as enter_date,J.Code as doctor_code,J.Name as doctor_name, "
		    + "A.Dt_Sign as confirm_date,K.code as confirm_opera,K.name as confirm_opera_name,L.code as exec_sn,L.Name as exec_name,A1.Id_Orsrv as parent_no, "
		    + "'' as incompatibleyz_no,'' as incompatibleyz_type_code,A.Dt_Effe as begin_time,A.Dt_End as end_time,M.Code as charge_gourp,M.Name as charge_group_name_external,'' as comment1,'' as sginfee_code,'' as sginfee_name, "
		    + "A1.Fg_Skintest as is_ps,(case when A1.Fg_Skintest='Y' then 'true' when A1.Fg_Skintest='N' then 'false' else '' end) as is_psresult, "
            + "A1.Fg_Indic as is_syz,(case when A1.Fg_Indic='Y' then 'true' when A1.Fg_Indic='N' then 'false' else '' end) as is_syzresult, "
            + "(case when G.Sd_Frequnitct='0' and G.Code='ST' then 'Y' else 'N' end) as is_jj,(case when A.Fg_Urgent='Y' then '加急' when A.Fg_Urgent='N' then '非加急' else '' end) as is_jjresult, "
            //添加就诊次数 begin 2017-06-28 10:53:34
            +"   (case when H1.Times_Ip is null then 0 else H1.Times_Ip end) +(case when J1.Times_Op is null then 0 else J1.Times_Op end) as admiss_times, "
            //end
            + "'' as is_yg,'' as is_ygresult,null as route_code,null as route_no "
		   
		   +"    from ci_or_srv A1 left outer join ci_order A ON A1.Id_Or=A.Id_Or "
		   +"      left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
		   +"      left outer join en_ent C ON A.Id_En=C.Id_Ent "
		   +"      left outer join bd_srv E ON E.Id_Srv=A1.Id_Srv "
		   +"      left outer join bd_srvca D ON E.Id_Srvca=D.Id_Srvca "
		   +"      left outer join bd_measdoc F ON F.Id_Measdoc=A1.Id_Medu "
		   +"      left outer join bd_freq G ON G.Id_Freq=A1.Id_Freq "
		   +"      left outer join bd_dep H ON H.Id_Dep=C.Id_Dep_Phy "
		   +"      left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Nur "
		   +"      left outer join bd_psndoc J ON J.Id_Psndoc=A1.Id_Emp_Srv "
		   +"      left outer join bd_psndoc K ON K.Id_Psndoc=A.Id_Emp_Sign "
		   +"      left outer join bd_dep L ON L.Id_Dep=A1.Id_Dep_Mp "
		   +"      left outer join bd_udidoc M ON M.id_udidoc=A1.Id_Hpsrvtp "
		   //添加就诊次数  处方序号 begin 2017-06-28 10:54:05
		   +"      left outer join en_ent_ip H1 ON C.Id_Ent=H1.Id_Ent  "
		   +"      left outer join en_ent_op J1 ON A.Id_En=J1.Id_Ent "
//		   +"	   left outer join ci_pres C1 ON A1.id_pres =C1.id_pres"
		   //end
	   	   +"      where %1$s and A1.Fg_or='Y'";
	/**
	 * 住院医嘱核对确认数据信息SQL串
	 * 其它医嘱
	 */
	public static final String CI_IE_OROTH_CONFIRM_SQL=
			" select A.Id_En as id_ieothoren,C.Name_Pat as name,C.Sd_Sex_Pat as sexid,'' as age,C.Dt_Birth_Pat as birthdaydate,B.BARCODE_CHIS as patientseqnum, "
		   +"   (case when H.Times_Ip is null then 0 else H.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as admiss_times, "
		   +" I.Code as deptcode,I.Name as deptname,G.Code as wardcode,G.Name as wardname,H.NAME_BED as bedcode,A.Dt_Chk as confirm_date,R.Code as confirm_nurse_code,R.Name as confirm_nurse_name,'02' as domain_id, "
		   //IE集成平台差异比对 新增 begin 2017-05-19 13:56:55
		   +"	O.orgcode AS org_code,O. NAME AS org_name "
		   //end
		   +" from ci_order A "
		   +"       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
		   +"       left outer join en_ent C ON A.Id_En=C.Id_Ent "
		   +"       left outer join en_ent_ip H ON C.Id_Ent=H.Id_Ent  "
		   +"       left outer join en_ent_op J ON A.Id_En=J.Id_Ent "
		   +"       left outer join bd_dep G ON G.Id_Dep=C.Id_Dep_Nur "
		   +"       left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Phy "
		   +"       left outer join bd_psndoc R ON R.Id_Psndoc=A.Id_Emp_Chk "
		   //IE集成平台差异对比新增begin 2017-05-19 13:57:43
		   +"		LEFT OUTER JOIN bd_org O ON A .id_org_or = O.id_org"
		   //end
		   +" where A.id_or=? "; 
	/**
	 * 住院医嘱核对确认明细数据信息SQL串
	 * 其它医嘱
	 */
	public static final String CI_IE_OROTH_ITM_SQL=
			" select A1.Id_Orsrv as id_ieothor,A.Id_En as id_ieothoren,A.Code_Or as order_code,D.code as order_type_code,D.Name as order_type_name,A1.Note_Srv as yz_memo,E.code as yz_code,E.name as yz_name, "
		   +" H.code as yz_dept_code,H.name as yz_dept_name,I.code as yz_ward_code,I.name as yz_ward_name,A.Dt_Entry as yz_date,J.Code as yz_doctor_code,J.Name as yz_doctor_name,A.Dt_Chk as yz_confirm_date, "
		   +" K.code as yz_confirm_doctor_code,K.name as yz_confirm_doctor_name,L.code as exe_dept_code,L.name as exe_dept_name,A.Code_Or as f_order_code,'' as hc_order_type_code,'' as hc_order_type_name, "
		   +" A.Dt_Effe as yz_start_time,A.Dt_End as yz_stop_time,'03' as is_jj,(case when A.Fg_Urgent='Y' then '加急' when A.Fg_Urgent='N' then '非加急' else '' end) as is_jjresult,'' as jt,'' as fybj_code,'' as fybj_name, "
		   //IE集成平台差异对比新增 begin 2017-05-19 13:49:57
		   +" A1.Fg_Indic AS is_syz,(CASE WHEN A1.Fg_Indic = 'Y' THEN '适应' ELSE '非适应' END) AS is_syzresult, "
		   +" A1.Fg_Skintest AS is_ps,(CASE WHEN A1.FG_SKINTEST_RST = 'Y' THEN (SELECT t1. NAME "
		   +" FROM ci_skin_test T LEFT OUTER JOIN bd_udidoc t1 ON T .id_rst_skintest = t1.id_udidoc "
		   +" WHERE id_or = A1.Id_Or) ELSE '' END) AS is_psresult, "
		   +" NULL AS xy_zcy_is_yg,NULL AS xy_zcy_is_ygresult,	NULL AS route_code,NULL AS route_no,"
		   +" O.orgcode as org_code,O.name as org_name "
		   //end
		   +" from ci_or_srv A1 left outer join ci_order A  ON A1.Id_Or=A.Id_Or "
		   +"      left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
		   +"      left outer join en_ent C ON A.Id_En=C.Id_Ent "
		   +"      left outer join bd_srvca D ON A1.Id_Srvca=D.Id_Srvca "
		   +"      left outer join bd_srv E ON E.Id_Srv=A1.Id_Srv "
		   +"      left outer join bd_measdoc F ON F.Id_Measdoc=A1.Id_Medu "
		   +"      left outer join bd_freq G ON G.Id_Freq=A1.Id_Freq "
		   +"      left outer join bd_dep H ON H.Id_Dep=C.Id_Dep_Phy "
		   +"      left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Nur "
		   +"      left outer join bd_psndoc J ON J.Id_Psndoc=A1.Id_Emp_Srv "
		   +"      left outer join bd_psndoc K ON K.Id_Psndoc=A.Id_Emp_Chk "
	       +"      left outer join bd_dep L ON L.Id_Dep=A1.Id_Dep_Mp "
		   //IE集成平台差异对比新增 begin 2017-05-22 09:43:00
		   +"	   LEFT OUTER JOIN bd_org O ON A.id_org_or = O.id_org"
		   //end
	   	   +" where %1$s and A1.Fg_or='Y'";  //A1.Id_or
	/**
	 * 住院护理医嘱就诊信息SQL串 20170517yjb
	 * 护理医嘱
	 */
	public static final String CI_IE_ORNS_CONFIRM_SQL=
			" select A.Id_En as id_iensoren,B.code as patientid,C.Name_Pat as name,C.Sd_Sex_Pat as sexid,'' as age,C.Dt_Birth_Pat as birthdaydate,B.BARCODE_CHIS as patientseqnum, "
		   +" (case when H.Times_Ip is null then 0 else H.Times_Ip end)+(case when J.Times_Op is null then 0 else J.Times_Op end) as admiss_times, "
		   +" I.Code as deptcode,I.Name as deptname,G.Code as wardcode,G.Name as wardname,H.NAME_BED as bedcode,A.Dt_Chk as confirm_date,R.Code as confirm_nurse_code,R.Name as confirm_nurse_name,'02' as domain_id, "
		   +" D.orgcode as orgcode,D.name as orgname "
		   +"     from ci_order A "
		   +"       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
		   +"       left outer join en_ent C ON A.Id_En=C.Id_Ent "
		   +"       left outer join en_ent_ip H ON C.Id_Ent=H.Id_Ent  "
		   +"       left outer join en_ent_op J ON A.Id_En=J.Id_Ent "
		   +"       left outer join bd_dep G ON G.Id_Dep=C.Id_Dep_Nur "
		   +"       left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Phy "
		   +"       left outer join bd_psndoc R ON R.Id_Psndoc=A.Id_Emp_Chk "
		   +"       left outer join bd_org D ON D.Id_org=A.Id_org "	
		   +" where A.id_or=?"; 	
	/**
	 * 住院护理医嘱信息SQL串 20170517yjb
	 * 护理医嘱
	 */
	public static final String CI_IE_ORNS_ITM_SQL=
			" select A1.Id_Orsrv as id_iensor,A.Id_En as id_iensoren,A.code_or as order_code,D.Code as order_type_code,D.Name as order_type_name, "
			+ "H.code as yz_dept_code,H.name as yz_dept_name,I.code as yz_ward_code,I.name as yz_ward_name, "
		    + "E.code as yz_code,E.name as yz_name,A1.Note_Srv as yz_memo,A1.Quan_Medu as yz_unit,F.code as yz_unit_code, "
		    + "G.code as fre_no,G.name as fre_name,A.Dt_Effe as yz_start_time,A.Dt_End as yz_stop_time,J.code as yz_doctor_code,J.name as yz_doctor_name,A.Dt_Entry as yz_date, "
		    + "L.code as exe_dept_code,L.name as exe_dept_name,'' as jt,'' as hc_order_type_code,'' as hc_order_type_name,A.Code_Or as f_order_code, "
		    + "K.Code as yz_confirm_doctor_code,K.name as yz_confirm_doctor_name,A.Dt_Chk as yz_confirm_date,'' as fybj_code,'' as fybj_name,A1.Pri as jg,F.Name as jgdw, "
		    + "A1.Fg_Skintest as is_ps,(case when A1.Fg_Skintest='Y' then '需皮试' when A1.Fg_Skintest='N' then '不需皮试' else '' end) as is_psresult,"
		    + "A1.Fg_Indic as is_syz,(case when A1.Fg_Indic='Y' then '适应症' when A1.Fg_Indic='N' then '非适应症' else '' end) as is_syzresult, "
		    + "(case when G.Sd_Frequnitct='0' and G.Code='ST' then 'Y' else 'N' end) as is_jj,(case when A.Fg_Urgent='Y' then '加急' when A.Fg_Urgent='N' then '非加急' else '' end) as is_jjresult, "
		    + "'' as is_yg,'' as is_ygresult,null as route_code,null as route_no "

		   +" from ci_or_srv A1 left outer join ci_order A  ON A1.Id_Or=A.Id_Or "
		   +"      left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
		   +"      left outer join en_ent C ON A.Id_En=C.Id_Ent "
		   +"      left outer join bd_srvca D ON A1.Id_Srvca=D.Id_Srvca "
		   +"      left outer join bd_srv E ON E.Id_Srv=A1.Id_Srv "
		   +"      left outer join bd_measdoc F ON F.Id_Measdoc=A1.Id_Medu "
		   +"      left outer join bd_freq G ON G.Id_Freq=A1.Id_Freq "
		   +"      left outer join bd_dep H ON H.Id_Dep=C.Id_Dep_Phy " 
		   +"      left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Nur "
		   +"      left outer join bd_psndoc J ON J.Id_Psndoc=A1.Id_Emp_Srv "
		   +"      left outer join bd_psndoc K ON K.Id_Psndoc=A.Id_Emp_Chk "
		   +"      left outer join bd_dep L ON L.Id_Dep=A1.Id_Dep_Mp "	
	   	   +" where %1$s and A1.Fg_or='Y'";  //A1.Id_or	
	/**
	 * 门诊用血申请数据信息SQL串
	 * 用血医嘱  
	 * ABO Rh血型得单独服务求取
	 */
	public static final String CI_IE_ORBU_OP_SQL=
			" select A1.id_or as id_iebtuseoren,A.Id_Pat as patient_id,B.BARCODE_CHIS as p_bar_code,C.Name_Pat as name,C.Sd_Sex_Pat as sex,C.Dt_Birth_Pat as brithday,'' as age,I.code as apply_unit,I.name as apply_unit_name,G.code as  ward_code,G.name as ward_code_name,H.NAME_BED as bed_no,S.Code as hospital_code,S.Name as hospital_name "
		   +" ,(case when H.Times_Ip is null then 0 else H.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as times  "
		   +" ,Q.NO_APPLYFORM as bill_id,'' as use_sn,'' as get_times,A.Code_Or as yz_no,T.code as blood_class,T.name as blood_class_name,A1.Quan_Medu as use_amount,A1.name as use_amount_code  "
		   +" ,Q.Dt_Bu_Plan as use_date,'' as abo_type,'' as abo_type_name,'' as rh_d,'' as rh_d_name,'' as is_lg,'' as is_lg_r,W.code as app_doctor,W.name as app_doctor_name,W.MOBILE as app_tel,'' as op_loc,'' as op_loc_name,'' as op_tel,'' as visit_type,'01' as domain_id  "
		   +"  from ci_or_srv A1   "
		   +"       left outer join ci_order A ON A1.Id_Or=A.Id_Or  "
		   +"       left outer join ci_ap_bu Q ON Q.id_or=A.Id_Or  "
		   +"       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat  "
		   +"       left outer join en_ent C ON A.Id_En=C.Id_Ent  "
		   +"       left outer join en_ent_ip H ON C.Id_Ent=H.Id_Ent  " 
		   +"       left outer join en_ent_op J ON A.Id_En=J.Id_Ent  "
		   +"       left outer join bd_dep G ON G.Id_Dep=C.Id_Dep_Nur  "
		   +"       left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Phy  "
		   +"       left outer join bd_psndoc R ON R.Id_Psndoc=A.Id_Emp_Chk   "
		   +"       left outer join bd_psndoc W ON W.Id_Psndoc=A.Id_Emp_Or  "
		   +"       left outer join bd_org S ON S.Id_Org=A.Id_Org  "
		   +"       left outer join bd_srv T ON T.Id_Srv=A1.Id_Srv  "
		   +"       left outer join bd_measdoc U ON U.Id_Measdoc=A1.Id_Medu  "
		  // +"       --left outer join ci_order AA ON A.id_or_rel=AA.Id_Or
		  //+"       --left outer join ci_ap_bt V ON V.Id_Or=AA.Id_Or	
		   +"		 where A1.Sd_Srvtp like '14%' and ";	 //A1.id_or	  
	/**
	 * 住院用血申请数据信息SQL串
	 * 用血医嘱  
	 * ABO Rh血型得单独服务求取
	 */
	public static final String CI_IE_ORBU_SQL=
			" select Q.id_or as id_iebtuseoren,B.code as patientid,C.Name_Pat as name,C.Sd_Sex_Pat as sexid,'' as age,C.Dt_Birth_Pat as birthdaydate,B.BARCODE_CHIS as patientseqnum,I.code as deptcode,I.name as deptname,G.code as wardcode,G.name as wardname,H.NAME_BED as bedcode "
		   +" ,(case when H.Times_Ip is null then 0 else H.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as admiss_times,A.Dt_Chk as confirm_date,R.Code as confirm_nurse_code,R.Name as confirm_nurse_name "
		   +" ,Q.NO_APPLYFORM as sx_code,'' as qx_code,'' as qx_times,A.Code_Or as order_no,T.code as xy_code,T.name as xy_name,A1.Quan_Medu as qx_count,A1.name as qx_unit "
		   +" ,Q.Dt_Bu_Plan as qx_date,'' as abo_code,'' as abo_name,'' as rh_code,'' as rh_name,W.code as doctor_code,W.name as doctor_name,W.MOBILE as doctor_tel,'' as ssj_code,'' ssj_name,'' as ssj_tel,'02' as domain_id,"
		   +" S.Orgcode as orgcode,S.NAME as orgname"//lxy20170518
		   +"  from ci_or_srv A1   "
		   +"       left outer join ci_order A ON A1.Id_Or=A.Id_Or  "
		   +"       left outer join ci_ap_bu Q ON Q.id_or=A.Id_Or  "
		   +"       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat  "
		   +"       left outer join en_ent C ON A.Id_En=C.Id_Ent  "
		   +"       left outer join en_ent_ip H ON C.Id_Ent=H.Id_Ent  " 
		   +"       left outer join en_ent_op J ON A.Id_En=J.Id_Ent  "
		   +"       left outer join bd_dep G ON G.Id_Dep=C.Id_Dep_Nur  "
		   +"       left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Phy  "
		   +"       left outer join bd_psndoc R ON R.Id_Psndoc=A.Id_Emp_Chk   "
		   +"       left outer join bd_psndoc W ON W.Id_Psndoc=A.Id_Emp_Or  "
		   +"       left outer join bd_org S ON S.Id_Org=A.Id_Org  "
		   +"       left outer join bd_srv T ON T.Id_Srv=A1.Id_Srv  "
		   +"       left outer join bd_measdoc U ON U.Id_Measdoc=A1.Id_Medu  "
		  // +"       --left outer join ci_order AA ON A.id_or_rel=AA.Id_Or
		  //+"       --left outer join ci_ap_bt V ON V.Id_Or=AA.Id_Or	
		   +"		 where %1$s  ";	 //A1.id_or	 
	/**
	 * 住院备血申请数据信息SQL串
	 * 备血医嘱  rownum要替换为top
	 * ABO Rh血型得单独服务求取
	 */
	public static final String CI_IE_ORBT_MAIN_SQL=
			" select Q.id_or as id_iebtoren,null as iebtdiags,null as iebtillhiss,null as iebtnumlisitms,null as iebtcdlisitms,null as iebtstrlisitms, "
		   +" B.code as patientid,C.Name_Pat as name,C.Sd_Sex_Pat as sexid,'' as age,C.Dt_Birth_Pat as birthdaydate,B.BARCODE_CHIS as patientseqnum "
		   +" ,(case when H.Times_Ip is null then 0 else H.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as admiss_times "
		   +" ,I.code as deptcode,I.name as deptname,G.Code as wardcode,G.Name as wardname,H.Name_Bed as bedcode,B.Id_Code as idcard,C.Telno_Pat as telephone,C.Addr_Pat as homeaddress,K.STREET as birthplace "
		   +" ,C.Sd_Mari_Pat as marrycode,'' as brxxsycode "
		   +" ,(select top 1 conttel from en_ent_cont DDD where Id_Ent=C.Id_Ent and Eu_Entconttp='1') as r_tel,(select top 1 NAME from en_ent_cont where Id_Ent=C.Id_Ent and Eu_Entconttp='1') as r_name "
		   +" ,A.Code_Entp as admiss_type,L.NAME as fbcode,C.Dt_Entry as jzdate,M.code as sxmdcode,M.name as sxmdname,T.code as sxbzcode,T.name as sxbzname,'' as abocode,'' as abovalue,'' as rhcode,'' as rhvalue "
		   +" ,Q.NO_APPLYFORM as sqdcode,A.Des_Or as sq_memo,A.Dt_Entry as sqdate,'' as emrgid,'' as emrgname,A1.Quan_Medu as sqxl,U.name as dw,Q.Dt_Bt_Pl as yxdate,R.code as sqdoctorcode,R.name as sqdoctorname,X.code as sqdeptcode,X.name as sqdeptname,W.code as shdoctorcode,W.name as shdoctorname,A.Code_Or as ordercode,'01' as domain_id "
		   +"  from ci_or_srv A1  "
		   +"       left outer join ci_order A ON A1.Id_Or=A.Id_Or "
		   +"       left outer join ci_ap_bt Q ON Q.id_or=A.Id_Or "
		   +"       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
		   +"       left outer join en_ent C ON A.Id_En=C.Id_Ent "
		   +"       left outer join en_ent_ip H ON C.Id_Ent=H.Id_Ent  "
		   +"       left outer join en_ent_op J ON A.Id_En=J.Id_Ent "
		   +"       left outer join bd_dep G ON G.Id_Dep=C.Id_Dep_Nur "
		   +"       left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Phy "
		   +"       left outer join bd_psndoc R ON R.Id_Psndoc=A.Dt_Sign  "
		   +"       left outer join bd_psndoc W ON W.Id_Psndoc=A.Id_Emp_Chk "
		   +"       left outer join bd_dep X ON X.Id_Dep=A.Id_Dep_Sign "
		   +"       left outer join bd_org S ON S.Id_Org=A.Id_Org "
		   +"       left outer join bd_srv T ON T.Id_Srv=A1.Id_Srv "
		   +"       left outer join bd_measdoc U ON U.Id_Measdoc=A1.Id_Medu  "
		   +"       left outer join pi_pat_addr K ON K.Id_Pat=B.Id_Pat and K.Sd_Addrtp='6' "
		   +"       left outer join bd_pri_pat L ON L.Id_Pripat=B.Id_Patpritp "
		   +"       left outer join bd_udidoc M ON M.Id_Udidoc=Q.Id_Pps_Bt "
		   +"       where %1$s ";	//A1.id_or
	/**
	 * 门诊备血申请数据信息SQL串
	 * 备血医嘱  rownum要替换为top
	 * ABO Rh血型得单独服务求取
	 */
	public static final String CI_IE_ORBT_MAIN_OP_SQL=
			" select Q.id_or as id_iebtoren,null as iebtdiags,null as iebtillhiss,null as iebtnumlisitms,null as iebtcdlisitms,null as iebtstrlisitms "
		   +" ,B.code as patientid,C.Name_Pat as name,C.Sd_Sex_Pat as sex,C.Dt_Birth_Pat as birthday,'' as age,C.Addr_Pat as address,C.Sd_Mari_Pat as marriagecode,(select NAME from en_ent_cont where Id_Ent=C.Id_Ent and Eu_Entconttp='1') as contacttel "
		   +" ,'' as contactname,K.STREET as birthplace,B.Id_Code as socialno,'' as bloodno,B.BARCODE_CHIS as pbarcode,G.code as wardno,G.name as wardname,H.Name_Bed as bedno,c.telno_pat as tel "
		   +" ,'' as privatecode,I.Code as deptcode,I.Name as deptname,L.Name as feeclass,(case when H.Times_Ip is null then 0 else H.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as times,A.Code_Entp as jztype "
		   +" ,J.Dt_Valid_b as visit_date,Q.NO_APPLYFORM as applyno,A.Des_Or as comment1,A.Dt_Entry as applytime,'' as emergencycode,'' as emergencyname,A1.Quan_Medu as bloodamount,U.Name as bloodunit,Q.Dt_Bt_Pl as usetime,Q.SD_PPS_BT as sxmdcode,M.Name as sxmdname,T.code as bloodcode,T.name as bloodname "
		   +" ,'' as abocode,'' as abovalue,'' as rhcode,'' as rhvalue,W.Code as iapplydoctor,W.Name as applydoctorname,X.code as applydept,X.Name as applydeptname,R.code as respdoctor,R.Name as respdoctorname,A.Code_Or as yz_no,'01' as domain_id, "
		   +" S.Orgcode as orgcode,S.NAME as orgname"//lxy20170518
		   +"  from ci_or_srv A1  "
		   +"       left outer join ci_order A ON A1.Id_Or=A.Id_Or "
		   +"       left outer join ci_ap_bt Q ON Q.id_or=A.Id_Or "
		   +"       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat "
		   +"       left outer join en_ent C ON A.Id_En=C.Id_Ent "
		   +"       left outer join en_ent_ip H ON C.Id_Ent=H.Id_Ent  "
		   +"       left outer join en_ent_op J ON A.Id_En=J.Id_Ent "
		   +"       left outer join bd_dep G ON G.Id_Dep=C.Id_Dep_Nur "
		   +"       left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Phy "
		   +"       left outer join bd_psndoc R ON R.Id_Psndoc=A.Id_Emp_Sign  "
		   +"       left outer join bd_psndoc W ON W.Id_Psndoc=A.Id_Emp_Or "
		   +"       left outer join bd_dep X ON X.Id_Dep=A.Id_Dep_Or "
		   +"       left outer join bd_org S ON S.Id_Org=A.Id_Org "
		   +"       left outer join bd_srv T ON T.Id_Srv=A1.Id_Srv "
		   +"       left outer join bd_measdoc U ON U.Id_Measdoc=A1.Id_Medu  "
		   +"       left outer join pi_pat_addr K ON K.Id_Pat=B.Id_Pat and K.Sd_Addrtp='6' "
		   +"       left outer join bd_pri_pat L ON L.Id_Pripat=B.Id_Patpritp "
		   +"       left outer join bd_udidoc M ON M.Id_Udidoc=Q.Id_Pps_Bt "
		   +"       where A1.Sd_Srvtp like '14%' and ";	//A1.id_or
	/**
	 * 门急诊检查检验IE集成平台查询SQL
	 */
	public static final String CI_OP_LISRIS_IE_SQL=
			"select cior.id_or as id_or,srv.SD_IEMSGCA as iemsgca_code,pat.code as patient_id,entop.times_op as times,execdep.code as exec_unit,"
			+" execdep.name as exec_unit_name,dep1.code as dept_code,dep1.name as dept_name,"
		    +" org.orgcode as org_code,org.name as org_name,cior.applyno as order_id,"
			+" (case when substr(cior.sd_srvtp,0,2)='02' then '"+IBdSrvIEEventConst.SD_SRVTP_JCL+"' when substr(cior.sd_srvtp,0,2) ='03' then '"+IBdSrvIEEventConst.SD_SRVTP_HYL+"'  else '' end) as order_type"
		    +" from ci_order cior" 
		    +" left join pi_pat pat on cior.id_pat = pat.id_pat"
		    +" left join en_ent_op entop on cior.id_en = entop.id_ent" 
		    +" left join bd_dep execdep on cior.id_dep_mp = execdep.id_dep"
		    +" left join bd_dep dep1 on cior.id_dep_or = dep1.id_dep"
		    +" left join bd_org org on cior.id_org = org.id_org"
		    +" left join bd_srvca srvca on cior.id_srvca=srvca.id_srvca"
		    +" left join bd_srv srv on cior.id_srv = srv.id_srv"
		    +" where cior.id_or %s";
	/**
	 * 就诊单元门诊药品处方数据信息SQL串 20170711zwq
	 * 仅门诊药品用 
	 */
	public static final String CI_IE_ORPHARM_OP_IDPRES_SQL=
			"select A.ID_PRES as id_iepharmpres,A.Id_En as id_iepharmoren,null as id_iepharmwcors,A.code||'_'||A.id_pres as orderno , "//A.Code as orderno  | F.code||'_'||G.times_op||'_'||A.SD_PRESTP||'_'||A.code as orderno
			+ "A.Sd_Prestp as ordertypecode,B.name as ordertypename,C.Code as doctorcode,C.Name as doctorname,A.Dt_Entry as ordertime, "
		    + "D.Code as deptcode,D.Name as deptname,E.code as checkdoctorcode,E.name as checkdoctorname,A.Dt_Entry as checktime "

		   +" from  ci_pres A "
		   +"       left outer join bd_udidoc B ON B.Id_Udidoc=A.Id_Prestp "
		   +"       left outer join bd_psndoc C ON C.Id_Psndoc=A.Id_Emp_Or "
		   +"       left outer join bd_dep D ON D.Id_Dep=A.Id_Dep_Or "
		   +"       left outer join bd_psndoc E ON A.Id_Emp=E.Id_Psndoc "
		   +"		left outer join pi_pat F ON F.id_pat = A.id_pati"
		   +"       left outer join en_ent_op G ON A.Id_En=G.Id_Ent "
		   +" where A.Id_Pres in (%1$s) ";
	
	/**
	 * BS302根据就诊查询当前所有已签署未收费 未作废的医嘱
	 */
	public static final String CI_IE_OP_8IDEN_SQL=
			" select A.ID_OR as  id_or,A.SD_SRVTP as sd_srvtp,A.SD_SU_BL as sd_su_bl from ci_order A"
			+" where %s  ";
}
