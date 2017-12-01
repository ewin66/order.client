package iih.ci.ord.obsordernoview.refs;

import iih.ci.ord.obsordernoview.d.ObsOrderNoView;
import xap.sys.appfw.refinfo.RefGridModel;

public class ObsOrderNoRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { ObsOrderNoView.NO_APPLYFORM, ObsOrderNoView.EN_CODE, ObsOrderNoView.NAME_PAT,
				ObsOrderNoView.NAME_OR};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { ObsOrderNoView.ID_OROBS };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "检查申请单号", "就诊号", "患者姓名", "医嘱名称"};
	}

	@Override
	public String getPkFieldCode() {
		return ObsOrderNoView.ID_OROBS;
	}

	@Override
	public String getRefCodeField() {
		return ObsOrderNoView.NO_APPLYFORM;
	}

	@Override
	public String getRefNameField() {
		return ObsOrderNoView.NO_APPLYFORM;
	}

	@Override
	public String getTableName() {
		return new ObsOrderNoView().getTableName();
	}

	@Override
	public String getRefSql() {
		StringBuffer wherePartBuffer = new StringBuffer();
		wherePartBuffer.append("ds=0");

		String wherePart = wherePartBuffer.toString();
		this.addWherePart(wherePart);
		String sql = null;
		try {
			sql = super.getRefSql();
		} finally {
			this.removeWherePart(wherePart);
		}

		return sql;
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[]{ ObsOrderNoView.NO_APPLYFORM, ObsOrderNoView.EN_CODE, ObsOrderNoView.NAME_PAT, ObsOrderNoView.NAME_OR };
	}		
}
