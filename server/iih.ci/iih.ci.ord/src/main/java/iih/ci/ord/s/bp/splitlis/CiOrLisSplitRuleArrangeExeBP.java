package iih.ci.ord.s.bp.splitlis;

import java.util.List;

import xap.mw.core.data.BizException;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.i.splitpres.ICiOrPresSplitRuleArrangePlugin;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.splitlis.d.CiOrdLisSplitList;
import iih.ci.ord.splitlis.d.ICiOrLisSplitRuleArrangePlugin;

/**
 *  获得分方规则编排插件并执行编排操作BP
 */
public class CiOrLisSplitRuleArrangeExeBP {

	/**
	 * 获得分方规则编排插件并执行编排
	 * @param orpressplitlists
	 * @throws BizException
	 */
	public  List<CiOrdLisSplitList> exec(List<CiOrdLisSplitList> orpressplitlists)throws BizException{
		//空判断
		if(CiOrdUtils.isEmpty(orpressplitlists))return null;
		
		//
		ICiOrLisSplitRuleArrangePlugin arrangeplugin=getCiOrPresSplitRuleArrangePlugin();
		orpressplitlists=arrangeplugin.exec(orpressplitlists);

		//返回值
		return orpressplitlists;
	}
	
	/**
	 * 获得临床医嘱分方规则编排插件接口
	 * @return
	 */
	private ICiOrLisSplitRuleArrangePlugin getCiOrPresSplitRuleArrangePlugin(){
		//获得临床医嘱在院执行标识默认值设置插件
		String pluginStr=CiOrdUtils.getOrgParamStr(ICiOrdNSysParamConst.SYS_PARAM_CiOrSplit4PresTransPlugin);
		
		//空判断
		if(CiOrdUtils.isEmpty(pluginStr))return new CiOrLisSplitRuleArrangeDefaultPlugin();
		
		try{
			Class<?> c = Class.forName(pluginStr);
		//	Class<?> c = Class.forName("iih.ci.ord.s.bp.splitpres.test.CiOrPresSplitRuleArrangeTestPlugin");
			return (ICiOrLisSplitRuleArrangePlugin) c.newInstance();
		}catch(Exception e){
			return new CiOrLisSplitRuleArrangeDefaultPlugin();
		}

	}
	 
}
