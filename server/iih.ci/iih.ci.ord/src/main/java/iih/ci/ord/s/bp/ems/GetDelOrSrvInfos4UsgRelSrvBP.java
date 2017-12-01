package iih.ci.ord.s.bp.ems;

import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.UsageRelFeeSrvDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;

import java.util.ArrayList;
import java.util.Hashtable;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

/*
 * 获得用法关联已删除的医嘱项目及相关信息集合操作BP
 */
public class GetDelOrSrvInfos4UsgRelSrvBP {
	/**
	 * 获得用法关联已删除的医嘱项目及相关信息集合
	 * @param aggdo
	 * @param relfeesrvdos
	 * @param ht
	 * @return
	 * @throws BizException
	 */
	public ArrayList<OrdSrvDO> exec(CiorderAggDO aggdo,UsageRelFeeSrvDO[] relfeesrvdos,Hashtable ht)  throws BizException{
		if(CiOrdUtils.isDONew(aggdo.getParentDO())){
			return null;
		}else{
			if(aggdo.getOrdSrvDO()==null)return null;
			ArrayList<OrdSrvDO> rtn=new ArrayList<OrdSrvDO>();
			OrdSrvDO[] orsrvdos=aggdo.getOrdSrvDO();
			for(int i=0;i<orsrvdos.length;i++){
				if(OrSrvSourceFromEnum.USAGERELFEE.equals(orsrvdos[i].getEu_sourcemd())
						|| OrSrvSourceFromEnum.BOILRELFEE.equals(orsrvdos[i].getEu_sourcemd())){
					if(!isOrdSrvDOIn(orsrvdos[i],relfeesrvdos)){
						orsrvdos[i].setStatus(DOStatus.DELETED);
						rtn.add(orsrvdos[i]);
						ciOrSrvRelMmHandle(orsrvdos[i],ht);
					}
				}
			}
			return rtn;
		}

	}
	
	/**
	 * 医嘱项目对应的用法关联的服务中是否还存在的判断
	 * @param orsrvdo
	 * @param relfeesrvdos
	 * @return
	 */
	private boolean isOrdSrvDOIn(OrdSrvDO orsrvdo,UsageRelFeeSrvDO[] relfeesrvdos){
		if(relfeesrvdos==null || relfeesrvdos.length==0)return false;
		for(int i=0;i<relfeesrvdos.length;i++){
			if(relfeesrvdos[i].getId_srv().equals(orsrvdo.getId_srv())){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 医嘱项目对应的物品逻辑处理
	 * @param orsrvdo
	 * @param ht
	 * @throws BizException
	 */
	private void ciOrSrvRelMmHandle(OrdSrvDO orsrvdo,Hashtable ht) throws BizException{
		if(OrSrvSplitUtil.isTrue(orsrvdo.getFg_mm())){//医嘱项目对应物品记录处理
			String id_orsrv=orsrvdo.getId_orsrv();
			OrdSrvMmDO mmdo=getSrvmm(id_orsrv);
			if(mmdo==null)return;
			CiOrAttachInfoUtils.addOrdSrvMmDO(ht, id_orsrv, mmdo);
		}
	}
	
	/**
	 * 医嘱项目对应的物品数据获得
	 * @param id_orsrv
	 * @return
	 * @throws BizException
	 */
	private OrdSrvMmDO getSrvmm(String id_orsrv) throws BizException{
		GetMmOfCiOrSrvBP bp=new GetMmOfCiOrSrvBP();
		return bp.exec(id_orsrv, true);
	}
	
	
}
