package iih.ci.ord.s.bp.orsrvsplit;

/**
 * 
 * @author Administrator
 *@version 2017-03-17 医嘱拆分查询增加ci_order.fg_pres_outp
 */
public interface IOrAndSrvSplitConst {
	/***
	 * OR=ci_order   SRV=ci_or_srv    MM=ci_or_srv_mm    FREQ=Z
	 */
	public static final String OR_TABLE_ALIAS="ci_order";
	public static final String ORSRV_TABLE_ALIAS="ci_or_srv";
	public static final String ORSRVMM_TABLE_ALIAS="ci_or_srv_mm";
	public static final String ENIP_TABLE_ALIAS="X";
	public static final String SEXUDI_TABLE_ALIAS="U";
	public static final String EN_TABLE_ALIAS="Y";
	public static final String FREQDEF_TABLE_ALIAS="Z";
	public static final String ORSRVFREQ_REPLACE_STR="$";
	public static final String COMMA_STR=",";
	public static final String AND_STR="and";
	
	public static final String ATTACHINFO_TABLE_LIS="ci_ap_lab"; //医嘱检验申请表名
	public static final String ATTACHINFO_TABLE_RIS="ci_ap_obs"; //医嘱检查申请表名
	
	//分组类型
	public static final String SPLITRS_GRPTP_OUTP="4";  //出院带药类型
	public static final String SPLITRS_GRPTP_HERB="5";  //草药
	public static final String SPLITRS_GRPTP_NBYT="0";  //按此取整
	public static final String SPLITRS_GRPTP_NBYB="1";      //按批取整
	public static final String SPLITRS_GRPTP_REMAINS="2";      //余量法
	public static final String SPLITRS_GRPTP_WDSUM="3";      //病区合用法
	public static final String SPLITRS_GRPTP_SRV="6";      //只按服务
	
	//分组归类模式
	public static final String SPLITRS_GRPRANGEMODE_WD="7";   //同一药品按同病区归类  仅合用法有效
	public static final String SPLITRS_GRPRANGEMODE_PI="8";   //同一药品按同一患者归类
	public static final String SPLITRS_GRPRANGEMODE_PV="9";   //同一药品按患者同一次就诊归类
	public static final String SPLITRS_GRPRANGEMODE_OR="10";  //同一药品按患者就诊的同一条医嘱归类
	public static final String SPLITRS_GRPRANGEMODE_ORSRV="11";  //同一药品按患者同一医嘱项目归类
	
	public static final Integer TIME_HOUR_SECONDS=3600;
	public static final Integer TIME_DAY_SECONDS=86400;
	
	/***
	 * 医嘱服务拆分_医嘱_基本选择字段sql串
	 */
	public static final String ORSRVSPLIT_OR_BASE_SSQL = "SELECT "
			+ "ci_order.id_or,ci_order.id_grp,ci_order.id_org,ci_order.id_pat,ci_order.id_entp,ci_order.code_entp,ci_order.id_en,y.name_pat as name_pati,u.name as gender,y.dt_birth_pat as dt_birth,x.name_bed as no_bed,ci_order.fg_bb,ci_order.no_bb,ci_order.content_or,ci_order.name_or,ci_order.code_or,ci_order.des_or,ci_order.id_srvtp as id_orsrvtp,ci_order.sd_srvtp as sd_orsrvtp,ci_order.id_su_or,ci_order.sd_su_or,"   
			+ "ci_order.dt_effe,ci_order.dt_end,ci_order.dt_invalid,ci_order.fg_long,ci_order.fg_boil,ci_order.orders as quan_or,ci_order.orders_boil,ci_order.fg_skintest,ci_order.fg_mp_bed,ci_order.dt_stop,"
			+ "ci_order.id_org_or as id_org_create,ci_order.id_dep_or as id_dep_create,ci_order.id_dep_chk as id_dep_nur,ci_order.id_emp_or as id_emp_create,ci_order.dt_last_bl as dt_last_bl_or,ci_order.sd_su_mp as or_mp_status,ci_order.fg_pres_outp,";  //2016-06-08医嘱新增dt_last_bl字段   2016-07-27执行状态从ci_order中获取
	/***
	 * 医嘱服务拆分_公共_医嘱选择字段sql串
	 */
    public static final String ORSRVSPLIT_PUB_OR_SSQL = ""			
			+ "$.dt_entry as dt_create,$.id_srvtp,$.sd_srvtp,$.id_route,$.id_routedes,$.id_boil,$.id_boildes,$.id_freq,Z.ID_FREQUNITCT as id_frequnit,"
			+ "Z.Sd_Frequnitct as sd_frequnit,Z.FREQUNITCT as frequnitcnt,Z.Freqct as freqcnt,'' as dt_mp_plan ";
    /***
     * 医嘱服务拆分_医嘱拆分_医嘱表关联sql串
     */
	public static final String ORSRVSPLIT_ORSPLIT_BASE_FSQL = ""				
			+ " FROM  ci_order"
			+ "     LEFT OUTER JOIN bd_freq Z ON ci_order.Id_Freq=Z.Id_Freq "
			+ "     INNER JOIN en_ent y on ci_order.Id_En=y.id_ent "
			+ "     LEFT OUTER JOIN en_ent_ip x on y.id_ent=x.id_ent "
			+ "     LEFT OUTER JOIN bd_udidoc u on y.id_sex_pat=u.id_udidoc ";
	/***
	 * 医嘱服务拆分_服务_基本选择字段sql串
	 */
	public static final String ORSRVSPLIT_SRV_BASE_SSQL = ""
			+ "ci_or_srv.id_orsrv,ci_or_srv.id_srv,ci_or_srv.code_srv,ci_or_srv.Name as name_srv,ci_or_srv.sortno,ci_or_srv.id_srvca,ci_or_srv.fg_mm,ci_or_srv.id_medu,ci_or_srv.quan_medu,ci_or_srv.fg_pres_outp,ci_or_srv.fg_or,ci_or_srv.eu_blmd,"
			+ "ci_or_srv.fg_bl,ci_or_srv.fg_indic,ci_or_srv.fg_dose_anoma,ci_or_srv.dt_last_bl,ci_or_srv.dt_last_mp,ci_or_srv.id_org_mp,ci_or_srv.id_dep_mp,";
	/***
	 * 医嘱服务拆分_物品_基本选择字段sql串
	 */	
	public static final String ORSRVSPLIT_MM_BASE_SSQL = ""	
			+ "ci_or_srv_mm.id_mm,ci_or_srv_mm.id_mmtp,ci_or_srv_mm.sd_mmtp,ci_or_srv_mm.code_mm,ci_or_srv_mm.name_mm,ci_or_srv_mm.Id_Pgku_Base as id_pkgu_base,ci_or_srv_mm.Id_Pgku_Cur as id_pkgu_cur,ci_or_srv_mm.factor,ci_or_srv_mm.factor_mb,ci_or_srv_mm.quan_num_base,"
			+ "ci_or_srv_mm.quan_den_base,ci_or_srv_mm.quan_cur,ci_or_srv_mm.fg_otc,ci_or_srv_mm.id_val,ci_or_srv_mm.sd_val,ci_or_srv_mm.quan_bed_medu,ci_or_srv_mm.price_pgku_cur,D.sd_mupkgutp pkuroundmode,";
	/***
	 * 医嘱服务拆分_公共_其他选择字段sql串
	 */
	public static final String ORSRVSPLIT_PUB_OTH_SSQL = ""	
			+ ",0 as quan_mp_ap,'' as id_pkgu_ap,0 as quan_bed_ap_medu ";
	
	/***
	 * 医嘱服务拆分_医嘱拆分_服务表关联sql串
	 */
	public static final String ORSRVSPLIT_SRVSPLIT_BASE_FSQL = ""		
			+ " FROM ci_or_srv"
			+ "     INNER JOIN ci_order ON ci_order.Id_Or=ci_or_srv.Id_Or"
			+ "     LEFT OUTER JOIN bd_freq Z ON ci_or_srv.Id_Freq=Z.Id_Freq "
			+ "     INNER JOIN en_ent y on ci_order.Id_En=y.id_ent "
			+ "     LEFT OUTER JOIN en_ent_ip x on y.id_ent=x.id_ent "
			+ "     LEFT OUTER JOIN bd_udidoc u on y.id_sex_pat=u.id_udidoc ";
	
	/***
	 * 医嘱服务拆分_医嘱拆分_服务表关联sql串
	 */
	public static final String ORSRVMMSPLIT_SRVSPLIT_BASE_FSQL = ""		
			+ " FROM ci_or_srv"
			+ "     INNER JOIN ci_order ON ci_order.Id_Or=ci_or_srv.Id_Or"
			+ "     LEFT OUTER JOIN bd_freq Z ON ci_or_srv.Id_Freq=Z.Id_Freq "
			+ "     LEFT OUTER JOIN ci_or_srv_mm ON ci_or_srv.Id_Orsrv=ci_or_srv_mm.Id_Orsrv "
			+ "     LEFT OUTER JOIN bd_mm D ON ci_or_srv_mm.Id_MM=D.Id_MM "
			+ "     INNER JOIN en_ent y on ci_order.Id_En=y.id_ent "
			+ "     LEFT OUTER JOIN en_ent_ip x on y.id_ent=x.id_ent "
			+ "     LEFT OUTER JOIN bd_udidoc u on y.id_sex_pat=u.id_udidoc ";

	/***
	 * 医嘱就诊表关联sql串
	 */
	public static final String OREN_BASE_FSQL = "     LEFT OUTER JOIN en_ent Y ON ci_order.Id_En=Y.ID_ENT";	
	

}
