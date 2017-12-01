package iih.ci.ord.s.ems.biz.ip;

import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.ci.ord.ciordems.d.EmsConsItemDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.d.ems.ems.EmsCrtDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.d.ems.ems.EmsSaveDTO;
import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import xap.mw.core.data.BizException;

public class EmsConsAction extends EmsBaseAction {
	@Override
	public EmsRstDTO[] create(EmsCrtDTO[] emsarray) throws BizException {
		EmsRstDTO[] rsts = super.create(emsarray);
		// 获取主服务信息
		MedsrvAggDO aggDO = getMedSrvInfo(emsarray[0].getId_srv());
		if (aggDO == null) {
			throw new BizException("查询主服务信息失败！");
		}
		// 合成主UI模型对象
		EmsConsItemDO emsModel = null;
		
    
		
//		rst.setEmsType(EmsType.CONS);
		
		return rsts;
	}

	

	@Override
	public EmsRstDTO save(EmsSaveDTO ems) throws BizException {
		// TODO Auto-generated method stub
		return super.save(ems);
	}

	
}
