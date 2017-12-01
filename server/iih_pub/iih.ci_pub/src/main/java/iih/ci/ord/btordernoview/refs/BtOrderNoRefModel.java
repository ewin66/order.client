package iih.ci.ord.btordernoview.refs;

import iih.ci.ord.btordernoview.d.BtOrderNoView;
import xap.sys.appfw.refinfo.RefGridModel;

public class BtOrderNoRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { BtOrderNoView.NO_APPLYFORM, BtOrderNoView.EN_CODE, BtOrderNoView.NAME_PAT,
				BtOrderNoView.BLOOD_COMP};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { BtOrderNoView.ID_APBT };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "备血申请单号", "就诊号", "患者姓名", "申请输血成分"};
	}

	@Override
	public String getPkFieldCode() {
		return BtOrderNoView.ID_APBT;
	}

	@Override
	public String getRefCodeField() {
		return BtOrderNoView.NO_APPLYFORM;
	}

	@Override
	public String getRefNameField() {
		return BtOrderNoView.NO_APPLYFORM;
	}

	@Override
	public String getTableName() {
		return new BtOrderNoView().getTableName();
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
		return new String[]{ BtOrderNoView.NO_APPLYFORM, BtOrderNoView.EN_CODE, BtOrderNoView.NAME_PAT, BtOrderNoView.BLOOD_COMP };
	}		
}
