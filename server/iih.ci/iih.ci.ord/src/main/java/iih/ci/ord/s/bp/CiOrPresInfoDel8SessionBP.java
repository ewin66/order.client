package iih.ci.ord.s.bp;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.d.desc.OrdSrvDODesc;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pres.d.desc.CiPresDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

/*
 * 删除本次会话对应的处方数据信息操作BP
 */
public class CiOrPresInfoDel8SessionBP {
	/**
	 * 删除本次会话对应的处方数据信息
	 * @param sessid
	 * @throws BizException
	 */
	public void exec(String sessid) throws BizException{
		//有效性校验
		if (CiOrdUtils.isEmpty(sessid))return ;
		
		//获得会话对应的处方
		String whereStr=CiPresDODesc.TABLE_ALIAS_NAME+".id_session='"+sessid+"'";
		CiPresDO[] presdos=CiOrdAppUtils.getCiPresQryService().find(whereStr, "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(presdos))return ;//空判断
		
		//清医嘱项目中处方标识
		whereStr=OrdSrvDODesc.TABLE_ALIAS_NAME+".id_pres "+getPresIds(presdos);
		OrdSrvDO[] orsrvdos=CiOrdAppUtils.getOrSrvQryService().find(whereStr, "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(orsrvdos))return ;//空判断
		orSrvInfoMod(orsrvdos);
		CiOrdAppUtils.getOrSrvService().update(orsrvdos);
		
		//会话对应的处方删除
		CiOrdAppUtils.getCiPresService().logicDelete(presdos);
	}
	/**
	 * 获得会话关联的处方id
	 * @param presdos
	 * @return
	 */
	private String getPresIds(CiPresDO[] presdos){
		String rtn="";
		for(int i=0;i<presdos.length;i++){
			rtn+=CiOrdUtils.COMMA_STR+presdos[i].getId_pres();
		}
		rtn=rtn.substring(1);
		rtn=rtn.replaceAll(CiOrdUtils.COMMA_STR, CiOrdUtils.SQUOTE_MARK_STR+CiOrdUtils.COMMA_STR+CiOrdUtils.SQUOTE_MARK_STR);
		return "in ("+CiOrdUtils.SQUOTE_MARK_STR+rtn+CiOrdUtils.SQUOTE_MARK_STR+")";
	}
	/**
	 * 处方号置空
	 * @param orsrvdos
	 */
	private void orSrvInfoMod(OrdSrvDO[] orsrvdos){
		for(int i=0;i<orsrvdos.length;i++){
			orsrvdos[i].setId_pres(null);
			orsrvdos[i].setStatus(DOStatus.UPDATED);
		}
	}
	
}
