package iih.ci.ord.s.bp.skintest;

import iih.bd.srv.oth.d.BizCntDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 需皮试用药的药品存在有效的已执行用药记录判断操作BP
 */
public class ExistValidIsNeedSkinExOrBP {
	/**
	 * 需皮试用药的药品存在有效的已执行用药记录判断
	 * @param id_pi
	 * @param id_srv
	 * @param id_mm
	 * @param secttime
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String id_pi,String id_srv,String id_mm,FDateTime[] secttime)  throws BizException{ 
		//有效性判断
		if(CiOrdUtils.isEmpty(id_pi) || CiOrdUtils.isEmpty(id_srv) || CiOrdUtils.isEmpty(secttime))return null;
		
		//进行结果查询
		ExistValidIsNeedSkinExOrQry qry=new ExistValidIsNeedSkinExOrQry(id_pi,id_srv,id_mm,secttime);
		BizCntDTO[] rtn = (BizCntDTO[])AppFwUtil.getDORstWithDao(qry, BizCntDTO.class);
		
		//返回值处理
		if(rtn==null || rtn.length==0)return FBoolean.FALSE;
		if(rtn[0].getCnt()>0)return FBoolean.TRUE;
		return FBoolean.FALSE;
	}
}
