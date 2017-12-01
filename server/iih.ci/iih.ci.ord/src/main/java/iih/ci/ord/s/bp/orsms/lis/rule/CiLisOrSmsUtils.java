package iih.ci.ord.s.bp.orsms.lis.rule;

public class CiLisOrSmsUtils {
	
	
	public static final String CILISOR_SMS_SAMPTPANDSRVCA_RULE_ID="CiLisOrSmsSamptpAndSrvcaRule";  //
	public static final String CILISOR_SMS_SAMPTPANDSRVCA_NOTINSAMPTP_ID="CiLisOrSmsNotInSamptpRule"; 
	public static final String CILISOR_SMS_NOTINRULE_ID="CiLisOrSmsNotInRule"; 
	//0001Z7100000000GJRD1血清     0001Z7100000000GJRJG 尿   0001Z7100000000GJRII骨髓
	
	
	public static final String CILISOR_SMS_SAMPTP_NOTINRULE_ID="CiLisOrSmsSamptpNotInRule"; //已废弃
	public static final String CILISOR_SMS_SAMPTP_RULE_VALUE="0001Z7100000000GJRD1| ;0001Z7100000000GJRJG| ;0001Z7100000000GJRII| "; 
	
	public static final String CILISOR_SMS_RULE_SPLITOR=",";
	public static final String CILISOR_SMS_RULEGRP_SPLITOR=";";
	public static final String CILISOR_SMS_RULEGRP_SPLITCA="\\|";
	public static final String CILISOR_SMS_RULE_NOTIN="!";
	public static final String CILISOR_SMS_LEFTBRACKET="(";
	public static final String CILISOR_SMS_RIGHTBRACKET=")";
	
	
	public static final String CILISOR_SMS_NOTICE_SPLITOR=",";
	public static final String CILISOR_SMS_NOTICE_LINESPLITOR="&";
	
	public static final int CILISOR_SMS_PRECISION=2; 
	
	public static final String CILISOR_SMS_SPECIAL= "090104";//特需标志
	/**
	 * 
	 * @return
	 */
	public static String getCiLisOrSmsSamptpRuleBy(){
		return CILISOR_SMS_SAMPTP_RULE_VALUE;
	}
	
	
	/**
	 * 就诊信息SQL串
	 * 
	 */
	public static final String CILISOR_SMS_EN_SQL=
			" select A.id_ent,B.fg_maj,B.fg_fundpay,C.sd_svrtp "
		   +" from  en_ent  A "
		   +"      left outer join en_ent_hp B ON B.Id_Ent=A.Id_Ent"
		   +"      left outer join en_ent_op C ON C.Id_Ent=A.Id_Ent"

		   +" where A.Id_Ent='%1$s'"; 
	
	
	public static final String CILISOR_SMS_ORSRV_SQL=
			" SELECT ID_ORSRV,ID_OR,Fg_bl,Eu_sourcemd,Fg_mm,Quan_total_medu,Pri FROM CI_OR_SRV ";
}
