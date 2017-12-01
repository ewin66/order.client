package iih.ci.ord.s.bp.assi;

import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.tmpl.d.CiOrTmplDTO;
import xap.mw.core.data.BizException;

/**
 * 根据临床医嘱模板列表数据创建医疗单Ems数据列表操作BP
 * 多单模板、多单医疗单
 */
public class CiOrCreateEms4OrTmplsBP {
	/**
	 * 根据临床医嘱模板列表数据创建医疗单Ems数据列表
	 * @param context  患者就诊上下文信息
	 * @param ortmpls   临床医嘱模板
	 * @return
	 * @throws BizException
	 */
	public CiEmsDTO[] exec(CiEnContextDTO context,CiOrTmplDTO[] ortmpls) throws BizException{
		//有效性检验
		if(CiOrdUtils.isEmpty(ortmpls))return null;
		
		//参数
		int iL=ortmpls.length;
		CiEmsDTO[] emsdtos=new CiEmsDTO[iL];
		
		//遍历
		for(int i=0;i<iL;i++){
			emsdtos[i]=getEms4OrTmpl(context,ortmpls[i]);
		}
		
		//返回
		return emsdtos;
	}
	
	/**
	 * 根据临床医嘱模板数据创建医疗单EMS数据
	 * @param context
	 * @param ortmpl
	 * @return
	 * @throws BizException
	 */
	private CiEmsDTO getEms4OrTmpl(CiEnContextDTO context,CiOrTmplDTO ortmpl) throws BizException{
		CiOrCreateEms4OrTmplBP bp=new CiOrCreateEms4OrTmplBP();
		return bp.exec(context, ortmpl);
	}
}
