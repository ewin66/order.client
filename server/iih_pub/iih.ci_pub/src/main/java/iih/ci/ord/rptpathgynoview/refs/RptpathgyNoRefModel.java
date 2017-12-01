package iih.ci.ord.rptpathgynoview.refs;

import iih.ci.ord.rptpathgynoview.d.RptpathgynoView;
import xap.sys.appfw.refinfo.RefGridModel;

public class RptpathgyNoRefModel extends RefGridModel{
	@Override
	public String[] getShowFieldCode() {
		return new String[] { RptpathgynoView.NO_APPLYFORM, RptpathgynoView.EN_CODE, RptpathgynoView.NAME_PAT,RptpathgynoView.SEX_NAME,
				RptpathgynoView.NAME_OR,RptpathgynoView.DT_EFFE,RptpathgynoView.PSN_NAME};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { RptpathgynoView.ID_RPTPATHGY };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "检查申请单号", "就诊号", "患者姓名", "性别", "医嘱名称","申请检查时间","申请医师"};
	}

	@Override
	public String getPkFieldCode() {
		return RptpathgynoView.ID_RPTPATHGY;
	}

	@Override
	public String getRefCodeField() {
		return RptpathgynoView.NO_APPLYFORM;
	}

	@Override
	public String getRefNameField() {
		return RptpathgynoView.NO_APPLYFORM;
	}

	@Override
	public String getTableName() {
		return new RptpathgynoView().getTableName();
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
		return new String[]{ RptpathgynoView.NO_APPLYFORM, RptpathgynoView.EN_CODE, RptpathgynoView.NAME_PAT,RptpathgynoView.SEX_NAME, RptpathgynoView.NAME_OR,RptpathgynoView.DT_EFFE,RptpathgynoView.PSN_NAME };
	}		

}
