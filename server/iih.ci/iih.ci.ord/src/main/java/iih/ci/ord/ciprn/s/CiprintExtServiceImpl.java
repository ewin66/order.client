package iih.ci.ord.ciprn.s;

import java.util.Map;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.ems.d.EmsprntmplAggDO;
import iih.ci.ord.ciprn.d.MatchResultDTO;
import iih.ci.ord.ciprn.i.ICiprintExtService;
import iih.ci.ord.s.bp.ciprn.CheckAllOrsBlRefoundBP;
import iih.ci.ord.s.bp.ciprn.CiprnDeleteAppLisDataBP;
import iih.ci.ord.s.bp.ciprn.CiprnDeleteAppPathgyDataBP;
import iih.ci.ord.s.bp.ciprn.CiprnDeleteAppRisDataBP;
import iih.ci.ord.s.bp.ciprn.CiprnDeleteFeeBillsDataBP;
import iih.ci.ord.s.bp.ciprn.CiprnDeleteTreateexecDataBP;
import iih.ci.ord.s.bp.ciprn.CiprnPrinterBP;
import iih.ci.ord.s.bp.ciprn.CiprnSaveTreatexecDataBP;
import iih.ci.ord.s.bp.ciprn.CiprnUpdateFeeBillsPrtCntBP;
import iih.ci.ord.s.bp.ciprn.CiprnUpdateTreateExecPrtCntBP;
import iih.ci.ord.s.bp.ciprn.GetEmsprntmplBP;
import iih.ci.ord.s.bp.ciprn.MatchEmsprntmplBP;
import iih.ci.ord.s.bp.ciprn.UpdateCiPrintBlsettledBP;
import iih.ci.ord.s.bp.ciprn.UpdateCiPrintPrepayBP;
import iih.ci.ord.s.bp.ciprn.UpdatePrintFgBP;
import iih.ci.ord.s.bp.ciprn.CiprnSaveFeeBillsDataBP;

/**
 * 临床打印单服务接口
 * @author Young
 *
 */
@Service(serviceInterfaces = { ICiprintExtService.class }, binding = Binding.JSONRPC)
public class CiprintExtServiceImpl implements ICiprintExtService {

	/**
	 * 保存费用清单打印对象集合
	 */
	@Override
	public FBoolean SaveFeeBillsData(String[] idors,String Id_hp,String Sd_hptp) throws BizException {
		CiprnSaveFeeBillsDataBP bp=new CiprnSaveFeeBillsDataBP();
		return bp.exec(idors, Id_hp, Sd_hptp);
	}
	
	/**
	 * 更新保存费用清单打印标识和打印次数
	 */
	@Override
	public FBoolean UpadateFeeBillsPrtCnt(String[] idors) throws BizException{
		CiprnUpdateFeeBillsPrtCntBP bp=new CiprnUpdateFeeBillsPrtCntBP();
		return bp.exec(idors);
	}
	
	/**
	 * 删除费用清单数据
	 */
	@Override
	public FBoolean DeleteFeeBillsData(String[] idors) throws BizException{
		CiprnDeleteFeeBillsDataBP bp = new CiprnDeleteFeeBillsDataBP();
		return bp.exec(idors, true);
	}
	
	/**
	 * 保存诊疗执行单打印对象集合
	 */
	@Override
	public FBoolean SaveTreatexecData(String[] idors,String Id_hp,String Sd_hptp) throws BizException{
		CiprnSaveTreatexecDataBP bp=new CiprnSaveTreatexecDataBP();
		return bp.exec(idors, Id_hp, Sd_hptp);
	}
	
	/**
	 * 更新保存诊疗执行单打印标识和打印次数
	 */
	@Override
	public FBoolean UpdateTreateExecPrtCnt(String[] idors) throws BizException{
		CiprnUpdateTreateExecPrtCntBP bp =new CiprnUpdateTreateExecPrtCntBP();
		return bp.exec(idors,ICiDictCodeConst.SD_CIPRNSHEETTP_INJECAPP);
	}
	
	/**
	 * 删除诊疗执行单数据
	 */
	@Override
	public FBoolean DeleteTreateExecData(String[] idors) throws BizException{
		CiprnDeleteTreateexecDataBP bp=new CiprnDeleteTreateexecDataBP();
		return bp.exec(idors);
	}
	
	/**
	 * 删除检验合单数据
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean DeleteAppLisData(String[] idors) throws BizException{
		CiprnDeleteAppLisDataBP bp=new CiprnDeleteAppLisDataBP();
		return bp.exec(idors);
	}
	
	/**
	 * 删除检查单数据
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean DeleteAppRisData(String[] idors) throws BizException{
		CiprnDeleteAppRisDataBP bp=new CiprnDeleteAppRisDataBP();
		return bp.exec(idors);
	}
	
	/**
	 * 删除病理单数据
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean DeleteAppPathgyData(String[] idors) throws BizException{
		CiprnDeleteAppPathgyDataBP bp=new CiprnDeleteAppPathgyDataBP();
		return bp.exec(idors);
	}
	
	/**
	 * 医嘱打印标识修改和次数累加
	 * @param mapprnids
	 * @param fg_prn
	 * @throws BizException
	 */
	@Override
	public void UpdatePrintFgprn(FMap2 mapprnids) throws BizException {
		UpdatePrintFgBP bp = new UpdatePrintFgBP();
		bp.exe(mapprnids);
	}
	
	/**
	 * 获得本机设置的报表打印机名称
	 * 
	 * @return
	 */
	@Override
	public String GetReportPrinter() throws BizException {
		CiprnPrinterBP bp = new CiprnPrinterBP();
		return bp.GetReportPrinter();
	}

	/**
	 * 保存小票打印机
	 * @param printerName
	 * @return
	 */
	@Override
	public FBoolean SaveReportPrinter(String printerName) throws BizException {
		CiprnPrinterBP bp = new CiprnPrinterBP();
		return bp.SaveReportPrinter(printerName);
	}
	
	/**
	 * 更新临床打印表费用结算标识
	 * @param map_iden_strBillNOs (key:id_en; value:单据号字符串'billNO','billNO','billNO'...)
	 * @param fg_blsettled
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean UpdateCiPrintBlsettled(Map<String,String> map_iden_strBillNOs, FBoolean fg_blsettled) throws BizException{
		UpdateCiPrintBlsettledBP bp=new UpdateCiPrintBlsettledBP();
		return bp.exec(map_iden_strBillNOs, fg_blsettled);
	}
	
	/**
	 * 更新临床打印表预付费标志
	 * @param id_en
	 * @param map_billtp_billNOs key:单据类型(01 药品，02 检查，03检验 ，04 诊疗费用),value:单据号数组
	 * @param Fg_hecominsur
	 * @param Fg_prepay
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean UpdateCiPrintPrepay(String id_en, Map<String,String[]> map_billtp_billNOs, FBoolean fg_hecominsur, FBoolean fg_prepay) throws BizException{
		UpdateCiPrintPrepayBP bp=new UpdateCiPrintPrepayBP();
		return bp.exec(id_en, map_billtp_billNOs, fg_hecominsur, fg_prepay);
	}
	
	@Override
	public EmsprntmplAggDO[] GetEmsprntmpl(String id_psn, String id_dep, String id_grp, String id_org) throws BizException{
		GetEmsprntmplBP bp = new GetEmsprntmplBP(id_psn, id_dep, id_grp, id_org);
		return bp.getAllEmsprntmplAggDOs();
	}
	
	@Override
	public MatchResultDTO[] MatchEmsprntmpl(EmsprntmplAggDO[] aggDOs, String id_hp, String sd_hptp, String paramUsageScope, int selectedIndex, String[] idors, String[] idpres) throws BizException{
		MatchEmsprntmplBP bp = new MatchEmsprntmplBP(id_hp, sd_hptp, paramUsageScope, selectedIndex, idors, idpres);
		return bp.exec(aggDOs);
	}
	
	@Override
	public FBoolean CheckAllOrsBlRefound(String[] idors) throws BizException {
		CheckAllOrsBlRefoundBP bp = new CheckAllOrsBlRefoundBP();
		return bp.exec(idors);
	}
}
