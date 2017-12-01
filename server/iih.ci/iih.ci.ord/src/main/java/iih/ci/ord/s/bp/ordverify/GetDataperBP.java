package iih.ci.ord.s.bp.ordverify;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.dataper.i.IDataperExtQry;
import xap.sys.permfw.dataper.d.DataPerRuleDO;

/**
 * 取得数据权限处理类
 * 优先取得用户权限，如果没有数据则取得角色权限
 * @author ly
 *
 */
public class GetDataperBP {
	
	private final String SHEETCODE = "47102005";//审核数据权限编码
	private IDataperExtQry iDataQry = ServiceFinder.find(IDataperExtQry.class);
	
	/**
	 * 取得数据权限
	 * @param ruleCode 规则编码
	 * @return
	 * @throws BizException
	 */
	public String exec() throws BizException{
		
		//取得用户权限
		String result = this.getUserData();
		
		String result2 = this.getRoleData();
		
		if(StringUtil.isEmpty(result))
			return result2;
		
		if(StringUtil.isEmpty(result2))
			return result;
		
		return result + " or " + result2;
	}
	
	/**
	 * 取得用户权限数据
	 * @param result
	 */
	private String getUserData() throws BizException{
		
		List<DataPerRuleDO> listruledo = iDataQry.getSysDataperRuleByUser(
				Context.get().getUserId(), SHEETCODE);
		
		if (listruledo == null || listruledo.size() == 0)
			return null;
		
		String whereSql = "";
		for (DataPerRuleDO ruleDo : listruledo) {
			String sql = iDataQry.getwhere(ruleDo);
			
			sql = this.removeAnd(sql);
			
			if(whereSql.length()>0){
				whereSql += " or ";
			}
			whereSql += "(" + sql + ")";
		}
		
		return whereSql;
	}
	
	/**
	 * 取得角色权限数据
	 * @param result
	 */
	private String getRoleData() throws BizException{
		
		List<DataPerRuleDO> listruledo = iDataQry.getSysDataperRuleByUserRole(
				Context.get().getUserId(), SHEETCODE);
		
		if (listruledo == null || listruledo.size() == 0)
			return null;
		
		
		String whereSql = "";
		for (DataPerRuleDO ruleDo : listruledo) {
			String sql = iDataQry.getwhere(ruleDo);
			
			sql = this.removeAnd(sql);
			
			if(whereSql.length()>0){
				whereSql += " or ";
			}
			whereSql += "(" + sql + ")";
		}
		
		return whereSql;
	}
	
	/**
	 * 去掉条件开头的and
	 * @param whereSql
	 * @return
	 */
	private String removeAnd(String whereSql){
		
		if(whereSql.startsWith("and")){
			return whereSql.substring(4, whereSql.length());
		}
		
		return whereSql;
	}
}
