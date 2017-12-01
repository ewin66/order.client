package iih.ci.ord.s.bp.splitpres;

public interface PresConstant {
	
	//毒麻
	public static final String POISONOUSANESTHESIA =  "PoisonousAnesthesia";
	//精神一	
	public static final String MENTAL1 = "0";
	//精神二	
	public static final String MENTAL2 = "1";
	//管控	
	public static final String CONTROL = "control";
	//一般 General;
	public static final String ORDINARY = "Ordinary";
	
	//一个处方的药品个数
	 public static final int NUM =5;
	//一个处方的药品个数（草药）
	 public static final int HERBAL_DRUG =30;
	//一个处方的金额
	public static final double ant =500;
	//一个处方的金额(草药)
	public static final double HERBAL_DRUGANT =500000;//待定
	//一个处方的金额
	public static final int Mentalant =1;
	//一个处方的金额(草药)
	public static final double Mental_DRUGANT =500000;//待定
	//
	
	
	
	//处方类型
	
//	  //管控
//    public static final String SD_childmed  = "03";
//    public static final String ID_childmed  = "0001AA1000000002PNFS";
    //一般
    public static final String SD_ORDINARY  = "99";
    public static final String ID_ORDINARY  = "0001AA1000000002PNFC";
//	
	 public static final String  ID_PRESTP = "0001ZZ2000000000005M";
	//管控
    public static final String SD_Contrl = "02";
    public static final String ID_Contrl  = "0001AA1000000002PNFL";
    //精一
    public static final String SD_MENTAL1  = "00";
    public static final String ID_MENTAL1  = "0001AA1000000001UGR4";
    //精二
    public static final String SD_MENTAL2  = "01";
    public static final String ID_MENTAL2  = "0001AA1000000001UGR5";
    
    //儿科普通西药
    public static final String SD_childmed  = "03";
    public static final String ID_childmed  = "0001AA1000000002PNFM";
    //儿科成药
    public static final String SD_childready  = "04";
    public static final String ID_childready  = "0001AA1000000002PNFN";
    //急诊普通西药
    public static final String SD_OCONTROL  = "05";
    public static final String ID_CONTROL  = "0001AA1000000002PNFO";
    //急诊成药
    public static final String SD_emready  = "06";
    public static final String ID_emready  = "0001AA1000000002PNFP";
    //草药
    public static final String SD_HERBAL  = "07";
    public static final String ID_HERBAL  = "0001AA1000000002PNFQ";
    //普通西药 
    public static final String SD_EMERGENCY   = "08";
    public static final String ID_EMERGENCY   = "0001AA1000000002PNFR";    
    //成药
     public static final String SD_WESTERNMEDICINE ="09";
     public static final String ID_WESTERNMEDICINE ="0001AA1000000002QHIX";
        //草药
     public static final String SD_HERBALMEDICINE ="10";
     public static final String ID_HERBALMEDICINE ="0001AA1000000002QHIY";
     //医保 
     public static final String SD_INSURANCE ="11";
     public static final String ID_INSURANCE ="0001AA1000000002QHIZ";
    //注射
     public static final String SD_INJECTIONMEDICINE ="12";
     public static final String ID_INJECTIONMEDICINE ="0001AA1000000002QHJ0";
     //大输液
     public static final String SD_INFUSION_SOLUTIONS ="13";
     public static final String ID_INFUSION_SOLUTIONS ="1000AA1000000000099D";
}
