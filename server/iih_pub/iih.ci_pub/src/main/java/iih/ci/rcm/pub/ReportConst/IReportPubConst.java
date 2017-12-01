package iih.ci.rcm.pub.ReportConst;

public interface IReportPubConst {

	/// <summary>
    /// 新增 (未上报)
    /// </summary>
    public static final String STAGE_NEW_CODE = "01";
    /// <summary>
    /// 待审核
    /// </summary>
    public static final String STAGE_WAITCHECK_CODE = "02";
    /// <summary>
    /// 审核通过 
    /// </summary>
    public static final String STAGE_PASS_CODE = "03";
    /// <summary>
    /// 驳回 
    /// </summary>
    public static final String STAGE_REJECT_CODE = "04";
    
    //传染病主卡状态
    public static final String Id_con_cardsu_new = "@@@@AA1000000001S7Q9";//主卡新建状态id
    public static final String Code_con_cardsu_new = "1";//主卡新建状态CODE
    public static final String Name_con_cardsu_new = "新建";//主卡新建状态NAME

    public static final String Id_con_cardsu_tj = "@@@@AA1000000001S7QA";//主卡已提交状态id
    public static final String Code_con_cardsu_tj = "2";//主卡新建状态CODE
    public static final String Name_con_cardsu_tj = "已提交";//主卡新建状态NAME

    public static final String Id_con_cardsu_ok = "@@@@AA1000000001S7QB";//主卡通过状态id
    public static final String Code_con_cardsu_ok = "3";//主卡通过状态CODE
    public static final String Name_con_cardsu_ok = "审核通过";//主卡通过状态NAME
}
