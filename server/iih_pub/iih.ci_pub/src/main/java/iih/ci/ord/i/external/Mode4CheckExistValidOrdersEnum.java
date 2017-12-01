package iih.ci.ord.i.external;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface Mode4CheckExistValidOrdersEnum {

	@DmEnumDesc(name = "是否存在未作废未退费医嘱", description = "是否存在未作废未退费医嘱")
	public static final String ORDERSTATUS0 = "0";
	@DmEnumDesc(name = "是否存在有效医嘱", description = "是否存在有效医嘱")
	public static final String ORDERSTATUS1 = "1";
	@DmEnumDesc(name = "是否存在已交费的有效医嘱", description = "是否存在已交费的有效医嘱")
	public static final String ORDERSTATUS2 = "2";
}
