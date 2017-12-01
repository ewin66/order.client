package iih.ci.ord.s.bp.ordprn;

import iih.ci.ord.dto.ordprintdto.d.OrdPrintParamDTO;
import iih.ci.ord.ordprn.d.OrdPrintDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 重置医嘱保存BP
 * 
 * @author hums
 *
 */
public class OrdPrintDOResetSaveBP {

	public OrdPrintDO[] exec(OrdPrintParamDTO paramDTO, OrdPrintDO[] printDos) throws BizException {

		this.save(paramDTO, printDos);
		return null;
	}

	/**
	 * 保存重整后的医嘱
	 * @param paramDTO
	 * @param printDos
	 * @return
	 * @throws BizException
	 */
	private String[] save(OrdPrintParamDTO paramDTO, OrdPrintDO[] printDos) throws BizException {

		this.updateSavedOrdPrintDO(paramDTO);
		
		return new DAFacade().insertDOs(printDos);
	}

	/**
	 * 将已经保存的打印医嘱状态设置为重整状态
	 * 
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */
	private int updateSavedOrdPrintDO(OrdPrintParamDTO paramDTO) throws BizException {

		FDateTime serverTime = CiOrdAppUtils.getServerDateTime();

		SqlParam param = new SqlParam();
		param.addParam(FBoolean.TRUE);
		param.addParam(serverTime);
		param.addParam(serverTime);
		param.addParam(serverTime);
		param.addParam(paramDTO.getId_en());
		param.addParam(FBoolean.FALSE);
		String sql = "update ci_or_prn prn set prn.fg_reformed = ? , prn.dt_reform = ? , prn.modifiedtime = ?, sv= ? where  id_en = ? and prn.fg_reformed = ?";

		return new DAFacade().execUpdate(sql, param);

	}
}
