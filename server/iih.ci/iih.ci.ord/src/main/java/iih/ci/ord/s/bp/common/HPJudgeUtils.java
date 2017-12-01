package iih.ci.ord.s.bp.common;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bl.hp.bdhpindicationdto.d.BdHpIndicationDTO;
import iih.ci.ord.dto.hp.BdHpIndicDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class HPJudgeUtils {
	
    public static String SD_HP_JUDGE_METHOD_DOC_CONFIRM = "21";
    public static String SD_HP_JUDGE_METHOD_NO_CONTROL = "01";
    public static String SD_HP_JUDGE_METHOD_SYS_CONFIRM = "11";
    public static String SD_HP_JUDGE_METHOD_SYS_JUD_DOCCONFIRM = "12";
     /// <summary>
     /// 判断自费标识(保内、保外)
     /// </summary>
     /// <param name="hpdto"></param>
     /// <returns></returns>
     public static boolean isSelfPay(BdHpIndicationDTO hpdto) {
         if (hpdto == null)
         {
             return true;
         }
         String sd_hpsrvtp = hpdto.getSd_hpsrvtp();//医保类型
         String code_hpindicjudged = hpdto.getCode_hpindicjudged();//判断方式
         //丙类 
         if (CiOrdUtils.isEmpty(sd_hpsrvtp) || sd_hpsrvtp.equals(IBdPpCodeTypeConst.SD_HP_BJ_THREE))
         {
             return true;
         }
         else
         {
             if (CiOrdUtils.isEmpty(code_hpindicjudged))
             {
                 return true;
             }
             else if (code_hpindicjudged.equals(SD_HP_JUDGE_METHOD_NO_CONTROL))
             { //不控制
                 return false;
             }
             else if (code_hpindicjudged.equals(SD_HP_JUDGE_METHOD_SYS_CONFIRM))
             {
            	 return !CiOrdUtils.isTrue(hpdto.getFg_indic());
                
             }
             else if (code_hpindicjudged.equals(SD_HP_JUDGE_METHOD_SYS_JUD_DOCCONFIRM))
             {
                 return false;
             }
             else if (code_hpindicjudged.equals(SD_HP_JUDGE_METHOD_DOC_CONFIRM))
             {
                 return false; 
             }
         }
         return true;
     }
     /// <summary>
     /// 判断控件是否能编辑
     /// </summary>
     /// <param name="hpdto"></param>
     /// <returns></returns>
     public boolean isCanEdit(BdHpIndicationDTO hpdto)
     {
         if (hpdto == null)
         {
             return false;
         }
         String sd_hpsrvtp = hpdto.getSd_hpsrvtp();//医保类型
         //丙类 
         if (CiOrdUtils.isEmpty(sd_hpsrvtp) || sd_hpsrvtp.equals(IBdPpCodeTypeConst.SD_HP_BJ_THREE))
         {
             return false;
         }
         String code_hpindicjudged = hpdto.getCode_hpindicjudged();//判断方式
         if (CiOrdUtils.isEmpty(code_hpindicjudged))
         {
             return false;
         }
         else if (code_hpindicjudged.equals(SD_HP_JUDGE_METHOD_NO_CONTROL))
         { //不控制
             return false;
         }
         else if (code_hpindicjudged.equals(SD_HP_JUDGE_METHOD_SYS_CONFIRM))
         {
             return false;
         }
         else if (code_hpindicjudged.equals(SD_HP_JUDGE_METHOD_SYS_JUD_DOCCONFIRM))
         {
             return true;
         }
         else if (code_hpindicjudged.equals(SD_HP_JUDGE_METHOD_SYS_JUD_DOCCONFIRM))
         {
             return true;
         }
         return true;
     }
     /// <summary>
     /// 查询医保规则
     /// </summary>
     /// <param name="id_srv"></param>
     /// <param name="id_mm"></param>
     /// <param name="patinfo"></param>
     /// <returns></returns>
     public BdHpIndicationDTO getBdHpIndicationDTO(String id_srv, String id_mm, CiEnContextDTO contextdto) throws BizException
     {
         if (CiOrdUtils.isEmpty(id_srv) || contextdto == null ) {
             return null;
         }
         
         ICiOrdQryService service = ServiceFinder.find(ICiOrdQryService.class);
         BdHpIndicDTO bdhpindic = service.getBdHpIndicationDTO(id_srv, id_mm, contextdto);
         if (bdhpindic != null)
         {
             BdHpIndicationDTO bdHpIndication = new BdHpIndicationDTO();
             bdHpIndication.deSerializeJson(bdhpindic.serializeJson());
             return bdHpIndication;
         }
         else {
             return null;
         }
     }
 
}
