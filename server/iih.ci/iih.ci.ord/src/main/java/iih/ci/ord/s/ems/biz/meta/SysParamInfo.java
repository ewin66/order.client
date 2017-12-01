package iih.ci.ord.s.ems.biz.meta;

import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class SysParamInfo {
	private String globalParam;
	private String groupParam;
	private String orgParam;
	private String deptParam;
	
	private static Context context=Context.get();
	private String syscode;
	
	public SysParamInfo(String syscode){
		this.syscode=syscode;
	}
	public String getGlobalParam() {
		if(CiOrdUtils.isEmpty(this.globalParam)){
			return getParam(context.getSysId());
		}else{
			return globalParam;
		}
	}
	public void setGlobalParam(String globalParam) {
		this.globalParam = globalParam;
	}
	public String getGroupParam() {
		if(CiOrdUtils.isEmpty(this.globalParam)){
			return getParam(context.getGroupId());
		}else{
			return groupParam;
		}
		
	}
	public void setGroupParam(String groupParam) {
		this.groupParam = groupParam;
	}
	public String getOrgParam() {
		if(CiOrdUtils.isEmpty(this.orgParam)){
			return getParam(context.getOrgId());
		}else{
			return orgParam;
		}
	}
	public void setOrgParam(String orgParam) {
		this.orgParam = orgParam;
	}
	public String getDeptParam() {
		if(CiOrdUtils.isEmpty(this.deptParam)){
			return getParam(context.getDeptId());
		}else{
			return deptParam;
		}
	}
	public void setDeptParam(String deptParam) {
		this.deptParam = deptParam;
	}
	
	private String getParam(String id){
		if(id==null)return null;
		try {
			return ParamsetQryUtil.getParaString(id,syscode);
		} catch (BizException e) {
			e.printStackTrace();
			return null;
		}

	}

}
