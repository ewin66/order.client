package iih.ci.ord.ciprn.i;

import iih.bd.srv.ems.d.EmsprntmplAggDO;
import iih.ci.ord.ciprn.d.MatchResultDTO;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;

/**
 * 临床打印单服务接口
 * @author Young
 *
 */
public interface ICiprintExtService {

	/**
	 * 保存费用清单打印对象集合
	 * @param idors 医嘱ID集合
	 * @param Id_hp 主医保ID
	 * @param Sd_hptp 医保类型编码
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean SaveFeeBillsData(String[] idors,String Id_hp,String Sd_hptp) throws BizException;
	
	/**
	 * 更新保存费用清单打印标识和打印次数
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean UpadateFeeBillsPrtCnt(String[] idors) throws BizException;
	
	/**
	 * 删除费用清单数据
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean DeleteFeeBillsData(String[] idors) throws BizException;
	
	/**
	 * 保存诊疗执行单打印对象集合
	 * @param idors
	 * @param Id_hp 
	 * @param Sd_hptp 
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean SaveTreatexecData(String[] idors,String Id_hp,String Sd_hptp) throws BizException;
	
	/**
	 * 更新保存诊疗执行单打印标识和打印次数
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean UpdateTreateExecPrtCnt(String[] idors) throws BizException;
	
	/**
	 * 删除诊疗执行单数据
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean DeleteTreateExecData(String[] idors) throws BizException;
	
	/**
	 * 删除检验合单数据
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean DeleteAppLisData(String[] idors) throws BizException;
	
	/**
	 * 删除检查单数据
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean DeleteAppRisData(String[] idors) throws BizException;
	
	/**
	 * 删除病理单数据
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean DeleteAppPathgyData(String[] idors) throws BizException;
	
	/**
	 * 医嘱打印标识修改和次数累加
	 * @param mapprnids
	 * @param fg_prn
	 * @throws BizException
	 */
	public abstract void UpdatePrintFgprn(FMap2 mapprnids) throws BizException;
	
	/**
	 * 更新临床打印表费用结算标识
	 * @param map_iden_strBillNOs key:id_en,value:单据号字符串('···','···','···')
	 * @param fg_blsettled
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean UpdateCiPrintBlsettled(Map<String,String> map_iden_strBillNOs, FBoolean fg_blsettled) throws BizException;
	
	/**
	 * 更新临床打印表预付费标志
	 * @param id_en
	 * @param map_billtp_billNOs key:单据类型(01 药品，02 检查，03检验 ，04 诊疗费用),value:单据号数组
	 * @param Fg_hecominsur 高端商报标志
	 * @param Fg_prepay 预付费记账标志
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean UpdateCiPrintPrepay(String id_en, Map<String,String[]> map_billtp_billNOs, FBoolean fg_hecominsur, FBoolean fg_prepay) throws BizException;
	
	/**
     * 获得本机设置的小票打印机名称
     * @param printTp 打印类型
     * @return
     */
	public abstract String GetReportPrinter() throws BizException;
	
	/**
	 * 保存小票打印机设置
	 * @param printerName
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean SaveReportPrinter(String printerName) throws BizException;
	
	public abstract EmsprntmplAggDO[] GetEmsprntmpl(String id_psn, String id_dep, String id_grp, String id_org) throws BizException;
	
	public abstract MatchResultDTO[] MatchEmsprntmpl(EmsprntmplAggDO[] aggDOs, String id_hp, String sd_hptp, String paramUsageScope, int selectedIndex, String[] idors, String[] idpres) throws BizException;
	
	/**
	 * 校验是否全部退费医嘱
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean CheckAllOrsBlRefound(String[] idors) throws BizException;
}
