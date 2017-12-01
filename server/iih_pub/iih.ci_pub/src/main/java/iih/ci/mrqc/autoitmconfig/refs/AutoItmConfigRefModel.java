/**
 * 
 */
/**
 * @author Administrator
 *
 */
package iih.ci.mrqc.autoitmconfig.refs;

import iih.ci.mrqc.autoitmconfig.d.AutoItmConfigDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class AutoItmConfigRefModel extends RefGridModel{
	
	@Override
	public String[] getShowFieldCode(){
		return new String[]{AutoItmConfigDO.REQ};
	}
	@Override
	public String[] getHiddenFieldCode(){
		return new String[]{AutoItmConfigDO.ID_QA_ITM_CONFIG};
	}
	@Override
	public String[] getShowFieldName(){
		return new String[]{"名称"};
	}
	@Override
	public String getPkFieldCode(){
		return AutoItmConfigDO.ID_QA_ITM_CONFIG;
	}
	@Override
	public String getTableName(){
		return new AutoItmConfigDO().getTableName();
	}
	@Override
	public String getRefCodeField(){
		return AutoItmConfigDO.PYCODE;
	}
	@Override
	public String getRefNameField(){
		return AutoItmConfigDO.REQ;
	}
	


}