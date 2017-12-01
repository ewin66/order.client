package iih.ci.ord.s.bp.skintest;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AppFwUtil;
import iih.ci.ord.dto.d.ValidSkinOrInfo;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.log.OrdBizLogger;

/**
 * 获得患者有效皮试医嘱数据信息操作BP
 */
public class GetPiValidSkinTestOrInfoBP {
	/**
	 * 获得患者有效皮试医嘱数据信息
	 * @param id_pi
	 * @param id_skinsrv
	 * @param secttime
	 * @return
	 * @throws BizException
	 */
	public ValidSkinOrInfo[] exec(String id_pi,String id_skinsrv,FDateTime[] secttime)  throws BizException{ 
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		//有效性检验
		if(CiOrdUtils.isEmpty(id_pi) || CiOrdUtils.isEmpty(id_skinsrv) || CiOrdUtils.isEmpty(secttime))return null;
		
		//结果查询
		GetPiValidSkinTestOrQry qry=new GetPiValidSkinTestOrQry(id_pi,id_skinsrv,secttime);
		OrdBizLogger.info(ctx, "GetPiValidSkinTestOrInfoBP.exec.param——id_pi:"+id_pi+"  id_skinsrv:"+id_skinsrv+"  secttime:"+secttime);
		OrdBizLogger.info(ctx, "GetPiValidSkinTestOrInfoBP.exec.qry——"+qry.getQrySQLStr());
		ValidSkinOrInfo[] rtn = (ValidSkinOrInfo[])AppFwUtil.getDORstWithDao(qry, ValidSkinOrInfo.class);
		
		//返回结果
		return rtn;
	}
}
