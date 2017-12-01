package iih.ci.ord.s.bp.srvpri;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;

public class CiOrSrvSetNotClinicalItemsBP {
	/**
	 * 查询套内项目,包含临床和非临床
	 * @param param
	 * @throws BizException
	 */
	public void exec(BdSrvPriCalParamDTO param) throws BizException{
		MedSrvSetItemDO[] srvSetArray= CiOrdAppUtils.getMedSrvSetItemRService().find(String.format("a8.fg_active='Y' and a8.id_srv='%s'", param.getId_srv()), "", FBoolean.FALSE);
		if (srvSetArray == null || srvSetArray.length == 0) return ; // 套内临床项目为空时候，直接返回
		String[] id_srvs = new String[srvSetArray.length];
		int i=0;
		for (MedSrvSetItemDO medSrvSetItem :srvSetArray)
        {
			id_srvs[i] = medSrvSetItem.getId_srv_itm();
            i++;
        }
		MedsrvAggDO[] srvaggarray = CiOrdAppUtils.getMedsrvRService().findByIds(id_srvs, FBoolean.FALSE);
		if (null == srvaggarray || 0 == srvaggarray.length)
			return;
			
		FArrayList items = new FArrayList();
		for(MedsrvAggDO srvAgg : srvaggarray)
		{
			BdSrvPriCalParamDTO calparam = new BdSrvPriCalParamDTO();
			calparam.setId_srv(srvAgg.getParentDO().getId_srv());
			calparam.setId_primd(srvAgg.getParentDO().getId_primd());
			calparam.setName_srv(srvAgg.getParentDO().getName());
			calparam.setNum(1);
			items.add(calparam);
		}
		param.setSrvsetitms(items);
	}
	/**
	 * 查询套内非临床的项目
	 * @param param
	 * @throws BizException
	 */
	public void notClinicalItems(BdSrvPriCalParamDTO param) throws BizException{
		MedSrvSetItemDO[] srvSetArray= CiOrdAppUtils.getMedSrvSetItemRService().find(String.format("a8.fg_clinical='N' and a8.fg_active='Y' and a8.id_srv='%s'", param.getId_srv()), "", FBoolean.FALSE);
		String[] id_srvs = new String[srvSetArray.length];
		int i=0;
		for (MedSrvSetItemDO medSrvSetItem :srvSetArray)
        {
			id_srvs[i] = medSrvSetItem.getId_srv_itm();
            i++;
        }
		MedsrvAggDO[] srvaggarray = CiOrdAppUtils.getMedsrvRService().findByIds(id_srvs, FBoolean.FALSE);
		FArrayList items = new FArrayList();
		if (null == srvaggarray || 0 == srvaggarray.length){
			param.setSrvsetitms(items);
			return;
		}
			
		for(MedsrvAggDO srvAgg : srvaggarray)
		{
			BdSrvPriCalParamDTO calparam = new BdSrvPriCalParamDTO();
			calparam.setId_srv(srvAgg.getParentDO().getId_srv());
			calparam.setId_primd(srvAgg.getParentDO().getId_primd());
			calparam.setName_srv(srvAgg.getParentDO().getName());
			calparam.setNum(1);
			items.add(calparam);
		}
		param.setSrvsetitms(items);
	}
}
