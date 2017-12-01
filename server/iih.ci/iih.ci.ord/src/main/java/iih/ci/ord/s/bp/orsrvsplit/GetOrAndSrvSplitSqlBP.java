package iih.ci.ord.s.bp.orsrvsplit;

import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import xap.mw.core.data.BizException;

/***
 * 获得执行与记费的医嘱或服务拆分时的有效医嘱sql字串操作BP
 */
public class GetOrAndSrvSplitSqlBP {
	/***
	 * 获得执行与记费的医嘱或服务拆分时的有效医嘱sql字串
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public  String exec(OrSrvSplitParamDTO param)  throws BizException{
		//参数有效性校验
		paramValidate(param);
		
		//获得拆分基本sql字符串
		String basesql=getOrSrvSplitBaseSql(param.getEu_orgensplittp());
		
		//获得医嘱
		String condsql=getCondStr(param);
		
		//返回值处理
		return basesql+condsql;
	}
	
	/***
	 * 参数有效性校验
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	private void paramValidate(OrSrvSplitParamDTO param) throws BizException{
		OrSrvSplitParamValidateBP bp=new OrSrvSplitParamValidateBP();
		bp.exec(param);

	}
	
	/***
	 * 获得拆分基本字符串
	 * @param orgensplittp
	 * @return
	 * @throws BizException
	 */
	private String getOrSrvSplitBaseSql(Integer orgensplittp) throws BizException{
		GetOrSrvSplitBaseSqlBP bp=new GetOrSrvSplitBaseSqlBP();
		return bp.exec(orgensplittp);
	}
	
	/***
	 * 获得拆分条件字符串
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private String getCondStr(OrSrvSplitParamDTO param) throws BizException{
		GetOrSrvSplitCondSqlBP bp=new GetOrSrvSplitCondSqlBP();
		return bp.exec(param);
	}
}
