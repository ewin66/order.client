package iih.ci.rcm.refer;

import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.refs.AdminAreaRefModel;

/**
 * 
 * @author tangws
 * @date 2017年6月3日 下午7:12:40
 *
 */
public class AdminArea4MrRefModel extends AdminAreaRefModel {

	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = 7163990070389242878L;

	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return AdminAreaDO.FULLNAME;
	}

	/**
	 * 显示字段名
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[] { AdminAreaDO.CODE, AdminAreaDO.FULLNAME };
	}

	/**
	 * 隐藏字段数组
	 */
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { AdminAreaDO.ID_ADMINAREA, AdminAreaDO.ID_PARENT,
				AdminAreaDO.NAME, AdminAreaDO.ZIPCODE, AdminAreaDO.SHORTNAME };
	}

	/**
	 * 查询字段名数组
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { AdminAreaDO.NAME, AdminAreaDO.CODE,
				AdminAreaDO.PYCODE, AdminAreaDO.WBCODE, AdminAreaDO.MNECODE,
				AdminAreaDO.SHORTNAME, AdminAreaDO.FULLNAME };
	}
}
