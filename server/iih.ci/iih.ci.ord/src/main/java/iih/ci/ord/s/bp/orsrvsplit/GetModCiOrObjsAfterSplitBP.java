package iih.ci.ord.s.bp.orsrvsplit;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitOrModParamDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/***
 * 获得医嘱服务拆分后医嘱相关信息操作BP
 */
public class GetModCiOrObjsAfterSplitBP {
	/***
	 * 获得医嘱服务拆分后医嘱回写相关信息对象集合操作
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public BaseDO[] exec(OrSrvSplitOrModParamDTO param)  throws BizException{
		
		String id_orsrv=param.getId_orsrv();
		FDateTime dt_last_split=param.getDt_split_end();
		FDouble quan_bed_ap_medu=param.getQuan_bed_ap_medu();
		FBoolean isCharged=param.getFg_charged();
		
		//医嘱服务项目信息处理
		OrdSrvDO orsrv=orSrvInfoHandle(id_orsrv,dt_last_split,isCharged);
		
		//医嘱信息处理
		CiOrderDO order=orderInfoHandle(orsrv,isCharged);
		
        //医嘱服务项目对应物品信息处理
		OrdSrvMmDO orsrvmm=orSrvMmInfoHandle(id_orsrv,quan_bed_ap_medu,isCharged);
		
		return new BaseDO[]{order,orsrv,orsrvmm};
	}
	
	/***
	 * 医嘱服务项目信息处理
	 * @param id_orsrv
	 * @param dt_last_split
	 * @param isCharged
	 * @return
	 * @throws BizException
	 */
	private OrdSrvDO orSrvInfoHandle(String id_orsrv,FDateTime dt_last_split,FBoolean isCharged) throws BizException{
		OrdSrvDO orsrv=OrSrvSplitUtil.findOrdSrvDOByID(id_orsrv);
		if(orsrv==null){
			throw new BizException("医嘱服务项目【id_orsrv="+id_orsrv+"】不存在错误！");
		}
		orsrv.setDt_last_bl(dt_last_split);
		if(isCharged.isValue() && ICiDictCodeConst.SD_SU_BL_NONE.equals(orsrv.getSd_su_bl())){
			orsrv.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_ACCOUNT);
			orsrv.setId_su_bl(ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID);
		}
		orsrv.setStatus(DOStatus.UPDATED);
		return orsrv;
	}
	
	/***
	 * 医嘱信息处理
	 * @param id_or
	 * @param isCharged
	 * @return
	 * @throws BizException
	 */
	private CiOrderDO orderInfoHandle(OrdSrvDO orsrvdo,FBoolean isCharged) throws BizException{
		String id_or=orsrvdo.getId_or();
		CiOrderDO orderdo=OrSrvSplitUtil.findCiOrdDOByID(id_or);
		if(orderdo==null){
			throw new BizException("医嘱【id_or="+id_or+"】不存在错误！");
		}
		boolean fg=orDtLastBlHandle(orderdo,orsrvdo);//最近生成时间处理
		if(isCharged.isValue() && ICiDictCodeConst.SD_SU_BL_NONE.equals(orderdo.getSd_su_bl())){
			orderdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_ACCOUNT);
			orderdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID);
			orderdo.setStatus(DOStatus.UPDATED);
			return orderdo;
		}
		if (fg) {
			return orderdo;
		}
		return null;
	}
	
	/**
	 * 医嘱最近生成时间处理
	 * @param orderdo
	 * @param orsrvdo
	 */
	private boolean orDtLastBlHandle(CiOrderDO orderdo,OrdSrvDO orsrvdo){
		if(CiOrdUtils.isOrAndOrSrvFreqSame(orderdo, orsrvdo)){
			orderdo.setDt_last_bl(orsrvdo.getDt_last_bl());
			orderdo.setStatus(DOStatus.UPDATED);
			return true;
		}
		return false;
	}
	
	/***
	 * 医嘱项目对应物品信息处理
	 * @param id_orsrv
	 * @param quan_bed_ap_medu
	 * @param isCharged
	 * @return
	 * @throws BizException
	 */
	private OrdSrvMmDO orSrvMmInfoHandle(String id_orsrv,FDouble quan_bed_ap_medu,FBoolean isCharged) throws BizException{
		OrdSrvMmDO orsrvmm=null;
		if(isCharged.isValue() && quan_bed_ap_medu!=null){ // && quan_bed_ap_medu.compareTo(new FDouble(0))>0
			orsrvmm=OrSrvSplitUtil.findOrdSrvMmDO(id_orsrv);
			if(orsrvmm==null){
				throw new BizException("医嘱项目【id_orsrv="+id_orsrv+"】对应物品不存在错误！");
			}
			orsrvmm.setQuan_bed_medu(quan_bed_ap_medu);
			orsrvmm.setStatus(DOStatus.UPDATED);
			return orsrvmm;
		}
		return null;
	}
}