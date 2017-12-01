
package iih.ci.ord.s.bp.assi;

import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.moreemsdto.d.MoreEmsParamDTO;
import iih.ci.ord.tmpl.d.CiOrTmplDTO;

import java.util.List;

import xap.mw.core.data.BizException;

/**
 * 
 * @author Administrator
 *
 */
public class getMoreEmsParamDTOBP {

	public MoreEmsParamDTO exec(CiEnContextDTO envinfo, OrTplNItmDO[] ortplItemDOs)throws BizException{
		ConvertOrtmlNItem2CiOrTmplBP bp = new ConvertOrtmlNItem2CiOrTmplBP(OrSourceFromEnum.IIHORTMPLHELPER);
		List<CiOrTmplDTO> ciOrtmplList = bp.exec(ortplItemDOs);
		if (ciOrtmplList == null)
			throw new BizException("选中的数据有错");
		// 映射成CiEmsDTO
		CiOrTmplAggDTOMappingCiEmsDTO ciEmsDTO = new CiOrTmplAggDTOMappingCiEmsDTO();
		return ciEmsDTO.Mapping(envinfo, ciOrtmplList.toArray(new CiOrTmplDTO[ciOrtmplList.size()]));
	}
}
