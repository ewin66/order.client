package iih.ci.ord.dto.reportstatus.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumRptTp {

    @DmEnumDesc(name="检验报告",description="检验报告")
	public static final Integer RPTLAB=1; //检验报告
    @DmEnumDesc(name="检查报告",description="检查报告")
	public static final Integer RPTOBS=2; //检查报告
    @DmEnumDesc(name="病理报告",description="病理报告")
	public static final Integer RPTPATHGY=3; //病理报告
}	
