package iih.ci.ord.s.bp.rationaldrug.dttong;

import iih.ci.ord.dto.ordrationaldrugdto.d.OrdRationalDrugDTO;
import iih.ci.ord.s.bp.rationaldrug.dttong.qry.GetRationalDrugDTOQry;
import iih.en.pv.dto.d.Ent4BannerDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 大通合理用药，获取指定医嘱对应的药品BP
 * 
 * @author hums
 *
 */
public class GetRationalDrugBP {

	public OrdRationalDrugDTO[] exec(Ent4BannerDTO bannerDTO, String[] ordIds) throws BizException {

		// 获取合理用药中药品的查询对象
		GetRationalDrugDTOQry qry = new GetRationalDrugDTOQry(bannerDTO, ordIds);
		OrdRationalDrugDTO[] rtn = (OrdRationalDrugDTO[]) AppFwUtil.getDORstWithDao(qry, OrdRationalDrugDTO.class);

		return rtn;
	}
}
