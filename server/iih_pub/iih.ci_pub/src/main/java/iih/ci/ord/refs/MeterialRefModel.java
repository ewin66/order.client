package iih.ci.ord.refs;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.mmcategory.d.MMCategoryDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.Context;
import xap.sys.appfw.orm.handle.dataobject.DOQuery;
import xap.sys.appfw.refinfo.RefGridModel;

public class MeterialRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { MeterialDO.CODE, MeterialDO.NAME,
				MeterialDO.SPEC, MeterialDO.PYCODE,
				MeterialDO.WBCODE, MeterialDO.MNECODE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MeterialDO.ID_MM, MeterialDO.ID_UNIT_PKGBASE,MeterialDO.ID_GRP,
				MeterialDO.ID_ORG, MeterialDO.FG_ACTIVE, MeterialDO.FG_PRICE,
				MeterialDO.FG_BATCH, MeterialDO.FG_SKIN, MeterialDO.ID_MMTP,
				MeterialDO.ID_SUP,  
				MeterialDO.NAME_UNIT_PKGBASE,MeterialDO.NAME_UNIT_PKGSP,
				MeterialDO.ID_UNIT_PKGSP,	MeterialDO.PRICE,MeterialDO.FACTOR_MB, MeterialDO.FACTOR_SB,MeterialDO.ID_MMCA,
				MeterialDO.SUP_NAME, MeterialDO.SD_PRIMODE, MeterialDO.RATE_PAP};
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[] { MeterialDO.CODE, MeterialDO.NAME,
				MeterialDO.PYCODE, MeterialDO.WBCODE, MeterialDO.MNECODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "物品编码", "物品名称", "物品规格", "通用名称", "拼音码", "五笔码",
				"助记码" };
	}

	@Override
	public String getPkFieldCode() {
		return MeterialDO.ID_MM;
	}

	@Override
	public String getRefCodeField() {
		return MeterialDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return MeterialDO.NAME;
	}

	@Override
	public String getTableName() {
		return new MeterialDO().getTableName();
	}

	@Override
	public List<String> getOrderPart() {
		List<String> orderPart = new ArrayList<String>();
		orderPart.add(MeterialDO.CODE);
		return orderPart;
	}
	
	@Override
	public String getRefSql() {
	
		String sql = null;
		try {
			sql = super.getRefSql();
			StringBuilder sb=new StringBuilder(sql);
			List<String> whereList = this.getWherePart();
			if (whereList.size() > 0) {
				for (String where : this.getWherePart()) {
					sb.append(" And (").append(where).append(") ");
				}
			}

		} finally {
			//this.removeWherePart(wherePart);
		}

		return sql;
	}
}
