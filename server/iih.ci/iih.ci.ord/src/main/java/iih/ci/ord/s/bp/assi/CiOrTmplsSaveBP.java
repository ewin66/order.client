package iih.ci.ord.s.bp.assi;

import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.CiOrEmsListSaveBP;
import iih.ci.ord.s.bp.validate.CiOrPvContextValidateBP;
import iih.ci.ord.tmpl.d.CiOrTmplDTO;
import iih.ci.ord.tmpl.d.CiOrTmplSaveRtnDTO;
import xap.mw.core.data.BizException;

/**
 * 临床医嘱模板保存操作BP
 * 临床医嘱助手生成多医疗单保存的总入口
 */
public class CiOrTmplsSaveBP {
	/**
	 * 临床医嘱模板保存
	 * 医嘱模板生成医嘱保存总入口方法
	 * @param context  上下文信息
	 * @param ortmpls  医嘱模板列表
	 * @return
	 * @throws BizException
	 */
	public CiOrTmplSaveRtnDTO exec(CiEnContextDTO context,CiOrTmplDTO[] ortmpls) throws BizException{
		//有效性检查
		if(!validateCheck(context,ortmpls))return null;
		
		//根据临床医嘱模板获得医疗单Ems数据列表
		CiEmsDTO[] emsdtos=ciOrCreateEms4OrTmpls(context,ortmpls);
		
		//临床医嘱保存
		ciOrEmsListSave(emsdtos);
		
		return null;
	}
	
	/**
	 * 有效性检查
	 * @param context
	 * @param ortmpls
	 * @return
	 * @throws BizException 
	 */
	private boolean validateCheck(CiEnContextDTO context,CiOrTmplDTO[] ortmpls) throws BizException{
		//基本校验
		if(CiOrdUtils.isEmpty(context)  || CiOrdUtils.isEmpty(ortmpls))return false;
		
		//患者就诊上下文数据有效性检验
		contextValidateCheck(context);
		
		return true;
	}
	
	/**
	 * 患者就诊上下文数据有效性校验
	 * @param context
	 * @return
	 * @throws BizException 
	 */
	private boolean contextValidateCheck(CiEnContextDTO context) throws BizException{
		CiOrPvContextValidateBP bp=new CiOrPvContextValidateBP();
		return bp.exec(context);
	}
	
	/**
	 * 根据临床医嘱模板获得医疗单Ems数据列表
	 * @param context
	 * @param ortmpls
	 * @return
	 * @throws BizException
	 */
	private CiEmsDTO[] ciOrCreateEms4OrTmpls(CiEnContextDTO context,CiOrTmplDTO[] ortmpls) throws BizException{
		CiOrCreateEms4OrTmplsBP bp=new CiOrCreateEms4OrTmplsBP();
		return bp.exec(context, ortmpls);
	}
	
	/**
	 * CI医嘱开立医疗单集合保存
	 * @param emsdtos
	 * @return
	 * @throws BizException
	 */
	private CiorderAggDO[] ciOrEmsListSave(CiEmsDTO[] emsdtos) throws BizException{
		CiOrEmsListSaveBP bp=new CiOrEmsListSaveBP();
		return bp.exec(emsdtos);
	}
}
