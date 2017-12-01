package iih.ci.ord.s.bp.ciprn;

import iih.bd.res.workstation.d.WorkStationPcDO;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.paramset.d.ParamSetDO;
import xap.sys.devcfg.paramset.i.IParamsetCudService;
import xap.sys.devcfg.paramset.i.IParamsetRService;
import xap.sys.devcfg.paramtmplset.d.ParamTmplSetDO;
import xap.sys.devcfg.paramtmplset.i.IParamtmplsetRService;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 打印接配置
 * @author Young
 *
 */
public class CiprnPrinterBP {

	private static final String CI_PRINTER = "CIPRN0001";// 报表打印机名称

	private String id_pc = "";

	public CiprnPrinterBP() throws DAException {
		String clientHost = xap.mw.core.data.Context.get().getClientHost();// 活动pcid
		DAFacade dafacade = new DAFacade();
		@SuppressWarnings("unchecked")
		List<WorkStationPcDO> workStationPcDOList = (List<WorkStationPcDO>) dafacade.findByCond(WorkStationPcDO.class, " pcid='" + clientHost + "'", new String[] { "id_pc" });
		id_pc = workStationPcDOList.toArray(new WorkStationPcDO[0])[0].getId_pc();
	}

	public FBoolean SaveReportPrinter(String printerName) throws BizException {
		if (StringUtils.isNullOrEmpty(printerName))
			return FBoolean.FALSE;
		if (!StringUtils.isNullOrEmpty(id_pc)) {
			IParamsetRService paramsetRService = ServiceFinder.find(IParamsetRService.class);
			ParamSetDO[] paramDos = paramsetRService.find(" a0.id_instance='" + id_pc + "' and a0.paramcode='"
					+ CI_PRINTER + "'", "", FBoolean.FALSE);

			if (paramDos != null && paramDos.length > 0) {
				paramDos[0].setValue(printerName);
				paramDos[0].setId_instance(id_pc);
				paramDos[0].setId_org(Context.get().getOrgId());
				paramDos[0].setStatus(DOStatus.UPDATED);
				paramDos[0].setAttrVal(ParamSetDO.DS, 0);
				new DAFacade().updateDOArray(paramDos, new String[] { ParamSetDO.VALUE });
			} else {
				IParamtmplsetRService paramtmplsetRService = ServiceFinder.find(IParamtmplsetRService.class);
				ParamTmplSetDO[] paramTmplSetDOArr = paramtmplsetRService.find(" paramcode='" + CI_PRINTER + "'", "", FBoolean.FALSE);
				if (paramTmplSetDOArr != null && paramTmplSetDOArr.length > 0) {
					ParamSetDO newparamDo = new ParamSetDO();
					newparamDo.setId_paramtmplset(paramTmplSetDOArr[0].getId_paramtmplset());
					newparamDo.setParamcode(paramTmplSetDOArr[0].getParamcode());
					newparamDo.setParamname(paramTmplSetDOArr[0].getParamname());
					newparamDo.setValue(printerName);
					newparamDo.setId_instance(id_pc);
					newparamDo.setId_org(Context.get().getOrgId());
					newparamDo.setCreatedby("00000000000000000000");
					newparamDo.setIseditable(FBoolean.TRUE);
					newparamDo.setIsctldownlevel(FBoolean.FALSE);
					newparamDo.setStatus(DOStatus.NEW);
					IParamsetCudService paramsetCudService = ServiceFinder.find(IParamsetCudService.class);
					paramsetCudService.save(new ParamSetDO[] { newparamDo });
				}
			}
			
			return FBoolean.TRUE;
		}

		return FBoolean.FALSE;
	}

	public String GetReportPrinter() throws BizException {
		if (!StringUtils.isNullOrEmpty(id_pc)) {
			return ParamsetQryUtil.getParaStringByInstance(id_pc, CI_PRINTER);
		}
		return null;
	}
}
