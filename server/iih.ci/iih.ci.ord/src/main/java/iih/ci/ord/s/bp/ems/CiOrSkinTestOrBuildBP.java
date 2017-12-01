package iih.ci.ord.s.bp.ems;

import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 生成皮试医嘱信息操作BP
 */
public class CiOrSkinTestOrBuildBP {
	/**
	 * 生成皮试医嘱信息操作
	 * @param id_srv
	 * @param ems
	 * @return   
	 * @throws BizException
	 */
	public CiEmsDTO  exec(String id_srv,CiEmsDTO ems)  throws BizException{
		//校验逻辑
		if(OrSrvSplitUtil.isEmpty(id_srv))return null;
		
		//获得服务对象
		MedsrvAggDO srvaggdo=CiOrdAppUtils.getMedsrvRService().findById(id_srv);
		 
		//创建皮试医嘱相关医疗单信息
		CiEmsDTO skinEms=createSkinEms(srvaggdo,ems);
		
		return skinEms;
	}
	
	/**
	 * 创建皮试医嘱对应的医疗单信息
	 * @param srvaggdo
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	private CiEmsDTO createSkinEms(MedsrvAggDO srvaggdo,CiEmsDTO ems) throws BizException{
		CiOrCreateEms4SkinTestBP bp=new CiOrCreateEms4SkinTestBP();
		return bp.exec(srvaggdo, ems);
	}
}
