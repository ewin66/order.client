package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
/*
 * 获得临床在执行的有效长期医嘱数据信息操作BP
 */
public class CiOrValidFgLongOrQryBP {
	/**
	 * 获得临床在执行的有效长期医嘱数据信息（全排斥停止医嘱用）
	 * @param id_en
	 * @param dt_cur
	 * @return
	 * @throws BizException
	 */
	public CiOrderDO[] exec(String id_en,FDateTime dt_cur) throws BizException{
		if(CiOrdUtils.isEmpty(id_en))return null;
		String whereStr=getValidFgLongSQLStr(id_en,dt_cur);
		return CiOrdAppUtils.getCiorderMDORService().find(whereStr, "", FBoolean.FALSE);
	}
	
	/**
	 * 获得基本SQL串,不包含出院带药
	 * @param id_en
	 * @return
	 */
	private String getValidFgLongSQLStr(String id_en,FDateTime dt_cur){
		StringBuilder sb=new StringBuilder();
		String tblaliasname=CiOrderDODesc.TABLE_ALIAS_NAME;
		sb.append(tblaliasname+".id_en='"+id_en+"'");
		sb.append(" and "+tblaliasname+".fg_pres_outp='N'");
//		sb.append(" and ((("+tblaliasname+".fg_sign='Y' and "+tblaliasname+".fg_chk='N')");
//		sb.append(" or ("+tblaliasname+".fg_chk='Y' and "+tblaliasname+".fg_canc='N'))");
//		sb.append(" and not ("+tblaliasname+".fg_stop='Y' and "+tblaliasname+".fg_chk_stop='Y'))");  //2016-08-08 增加该逻辑：已经停止且核对过的长期医嘱不在医生临床阶段停嘱而是执行层面做执行取消相关操作
		sb.append(" and "+tblaliasname+".fg_sign = 'Y'");
		sb.append(" and "+tblaliasname+".fg_chk_stop = 'N'");
		sb.append(" and "+tblaliasname+".fg_canc = 'N'");
		sb.append(" and "+tblaliasname+".sd_su_or != '"+ICiDictCodeConst.SD_SU_FINISH+"'");
		//2017-2-6新增测试sql
		sb.append(" and "+tblaliasname+".fg_long='Y'");
		if(dt_cur != null){
			sb.append(" and "+tblaliasname+".dt_effe<='"+OrSrvSplitUtil.getFDateTimeStdStr(dt_cur)+"'");
			sb.append(" and "+tblaliasname+".dt_end>='"+OrSrvSplitUtil.getFDateTimeStdStr(dt_cur)+"' ");
		
		}
			return sb.toString();
	}
}
