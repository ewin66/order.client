package iih.ci.ord.s.bp.srvref;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

import java.util.List;

import org.springframework.util.CollectionUtils;

import iih.ci.ord.srvref.d.CiSrvRefParamDTO;
import iih.ci.ord.srvref.d.CiSrvRefResultDTO;

/**
 * 获得服务参照结果数据集合操作BP
 */
public class GetSrvRefRstDatumBP {
	/**
	 * 获得服务参照结果数据集合
	 * 
	 * @param paramdto
	 * @return
	 * @throws BizException
	 */
	public CiSrvRefResultDTO[] exec(CiSrvRefParamDTO paramdto) throws BizException {

		List<CiSrvRefResultDTO> dtoList = null;

		// 获取医嘱服务主体查询语句
		GetBasicSrvRefSqlStrBP basicBp = new GetBasicSrvRefSqlStrBP(paramdto);
		String sqlStr = basicBp.exec();
		dtoList = (List<CiSrvRefResultDTO>) new DAFacade().execQuery(sqlStr,
				new BeanListHandler(CiSrvRefResultDTO.class));
		CiSrvRefResultDTO[] result = (CiSrvRefResultDTO[]) dtoList.toArray(new CiSrvRefResultDTO[dtoList.size()]);
		return result;

	}
}
