package iih.ci.ord.labordernoview.i.refs;

import iih.ci.ord.labordernoview.d.LabOrderNoView;
import xap.sys.appfw.refinfo.RefGridModel;

public class LabOrderNoRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { LabOrderNoView.NO_APPLYFORM, LabOrderNoView.EN_CODE, LabOrderNoView.NAME_PAT, 
				LabOrderNoView.NAME_OR};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { LabOrderNoView.ID_ORLAB };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "检验申请单号", "就诊号", "患者姓名", "医嘱名称"};
	}

	@Override
	public String getPkFieldCode() {
		return LabOrderNoView.ID_ORLAB;
	}

	@Override
	public String getRefCodeField() {
		return LabOrderNoView.NO_APPLYFORM;
	}

	@Override
	public String getRefNameField() {
		return LabOrderNoView.NO_APPLYFORM;
	}

	@Override
	public String getTableName() {
		return new LabOrderNoView().getTableName();
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
		return new String[]{ LabOrderNoView.NO_APPLYFORM, LabOrderNoView.EN_CODE, LabOrderNoView.NAME_PAT, LabOrderNoView.NAME_OR };
	}		
}
