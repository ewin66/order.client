package iih.ci.ord.s.bp.ems;

import java.util.ArrayList;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.OrSrvSyncInfoDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

/**
 * 医嘱项目频次修正操作BP
 */
public class CiOrOrdSrvDOsFreqMod1BP {
	/**
	 * 医嘱项目频次修正操作
	 * @param ordsrvdos
	 * @param id_freq
	 * @throws BizException
	 */
	public void exec(ArrayList<OrdSrvDO> ordsrvdos,OrSrvSyncInfoDTO orsrvsyncinfo)  throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(ordsrvdos) || CiOrdUtils.isEmpty(orsrvsyncinfo))return ;
		OrdSrvDO orsrvdo=null;
		
		//遍历
		for(int i=0;i<ordsrvdos.size();i++){
			orsrvdo=ordsrvdos.get(i);
			if(DOStatus.NEW==orsrvdo.getStatus() || DOStatus.UPDATED==orsrvdo.getStatus()){
				orsrvdo.setId_freq(orsrvsyncinfo.getId_freq());
				if(!CiOrdUtils.isEmpty(orsrvsyncinfo.getFg_or())){
					orsrvdo.setFg_or(orsrvsyncinfo.getFg_or());   //缺少orsrvsyncinfo.getFg_or()==null的特殊处理逻辑
				}
			}
		}
		
	}

}
