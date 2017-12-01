package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvCudService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.i.ICiOrdQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 计算医嘱服务临床项目价格
 * @author qzwang
 *
 */
public class GetOrSrvPriceBP {

	/**
	 * 根据医嘱数组id，计算临床项目的价格
	 * @param id_ors 医嘱id数组
	 * @return
	 * @throws BizException
	 */
	public PriStdSrvDTO[] exec(String[] id_ors) throws BizException {
		if (null == id_ors || id_ors.length == 0)
			return null;
		List<PriStdSrvDTO> ls = new ArrayList<PriStdSrvDTO>();
		ICiOrdQryService ordQryService = ServiceFinder.find(ICiOrdQryService.class);
		IMedsrvRService medsrvCrudServiceImpl = ServiceFinder.find(IMedsrvRService.class);

		if (null == ordQryService)
			return null;
		
		FMap fMap = ordQryService.getCiEmsDTO(id_ors);

		// 根据医嘱id获取医疗单信息
		for (String id_or : id_ors) {
			CiEmsDTO emsDto = (CiEmsDTO)fMap.get(id_or);
			
			// 获取id对应的服务
			MedsrvAggDO medSrvAggDO = medsrvCrudServiceImpl.findById(emsDto.getId_srv());
			MedSrvDO medSrvDO = null;
			if (null != medSrvAggDO) {
				medSrvDO = medSrvAggDO.getParentDO();
			}
			
			// 建立服务价格对象
			PriStdSrvDTO priStdSrvDTO = new PriStdSrvDTO();
			priStdSrvDTO.setId_srv(emsDto.getId_srv());
			priStdSrvDTO.setName_srv(emsDto.getName());
			ls.add(priStdSrvDTO);
			if (null == medSrvDO) {
				priStdSrvDTO.setPrice(FDouble.ZERO_DBL);
			} else {
				priStdSrvDTO.setPrice(GetOrderSvrPrice(medSrvDO.getId_primd(),emsDto.getEmssrvs()));
			}
		}

		return ls.toArray(new PriStdSrvDTO[ls.size()]);
	}

	/**
	 * 根据计价模式，计算医疗单中的临床项目的费用价格
	 * @param id_primd
	 * @param srvs
	 * @return
	 */
	private FDouble GetOrderSvrPrice(String id_primd, FArrayList srvs) {
		switch (id_primd) {
		case IBdPrimdCodeConst.ID_PRI_SRV_COMP:
		case IBdPrimdCodeConst.ID_PRI_SRV:
			return ((CiEmsSrvDTO) srvs.get(0)).getPrice();
		case IBdPrimdCodeConst.ID_PRI_SRVSET_AMOUNT:
			double price = 0;
			for (Object obj : srvs) {
				CiEmsSrvDTO srv = (CiEmsSrvDTO) obj;
				if (srv.getFg_or() == FBoolean.TRUE && srv.getFg_bl() == FBoolean.TRUE) {
					price += (srv.getPrice() == null ? 0 : srv.getPrice().getDouble());
				}
			}
			return new FDouble(price);

		}
		return FDouble.ZERO_DBL;
	}
}
