package iih.ci.ord.refs;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;

import java.util.List;

import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;

public class CiordPrintPatRefModel extends RefGridModel {

	/**
	 * 参照显示的字段
	 * 
	 * @return
	 */
	@Override
	public String[] getShowFieldCode() {
		// TODO Auto-generated method stub   
		return new String[] { "name_bed", "code", "name_pat"};
	}

	/**
	 * 参照隐藏的字段
	 * 
	 * @return
	 */
	@Override
	public String[] getHiddenFieldCode() {
		// TODO Auto-generated method stub
		return new String[] { "id_pat", "id_ent", "id_entp", "code_entp", "id_dep_phy", "name_dep_phy", "id_dep_nur", "name_dep_nur", "code_amr_ip"};
	}

	/**
	 * 显示字段的显示名称
	 * 
	 * @return
	 */
	@Override
	public String[] getShowFieldName() {
		// TODO Auto-generated method stub
		return new String[] { "床号", "就诊号", "姓名"};
	}

	/**
	 * 主键
	 * 
	 * @return
	 */
	@Override
	public String getPkFieldCode() {
		// TODO Auto-generated method stub
		return "id_ent";
	}

	@Override
	public String getRefCodeField() {
		// TODO Auto-generated method stub
		return "id_ent";
	}

	@Override
	public String getRefNameField() {
		// TODO Auto-generated method stub
		return "name_pat";
	}
	
	/**
	 * 按输入内容查询时，查询条件字段
	 * 
	 * @return
	 */
	@Override
	public String[] getBlurFields() {
		return new String[]{"code", "name_pat"};
	}

	/**
	 * 按输入内容查询时，自定义查询条件字段
	 * 
	 * @return
	 */
	@Override
	public RefResultSet filterRefBlurValue(String blurValue, PaginationInfo pg) {
		
		String[] fields = this.getBlurFields();
		if (fields == null)
			fields = this.getShowFieldCode();
		
		StringBuilder buf = new StringBuilder();
		
		buf.append("( 1<>1");
		for(String field : fields) {
			
			buf.append(" or lower(" + this.getTableName() + "." + field + ") like lower('%" + blurValue + "%')");
		}
		buf.append(" or lower(t2.name_bed) like lower('%");
		buf.append(blurValue);
		buf.append("%')");
		buf.append(")");
		
		String str = buf.toString();
		this.addWherePart(str);
		try {
			if (pg == null)
				return this.getRefData();
			else
				return this.getRefData(pg);
		} finally {
			this.removeWherePart(str);
		}
	}

	/**
	 * 查询sql语句
	 * 
	 * @return
	 */
	@Override
	public String getRefSql() {
		// TODO Auto-generated method stub
		String refSql = "SELECT t2.name_bed,t1.code,t1.name_pat,t1.id_pat,t1.id_ent,t1.id_entp,t1.code_entp,"
				      + "t1.id_dep_phy,t3.name as name_dep_phy,t1.id_dep_nur,t4.name as name_dep_nur,t2.code_amr_ip  "
				      + " FROM EN_ENT t1 INNER JOIN EN_ENT_IP t2 ON t2.id_ent = t1.id_ent  "
				      + " INNER JOIN BD_DEP t3 ON t3.id_dep = t1.id_dep_phy "
				      + " INNER JOIN BD_DEP t4 ON t4.id_dep = t1.id_dep_nur "
                      + " WHERE t1.fg_ip='Y' And t1.code_entp='"+IBdFcDictCodeConst.SD_CODE_ENTP_IP+"'";
		
        StringBuilder sb = new StringBuilder(refSql);
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sb.append(" And ").append(where);
			}
		}
		
		sb.append(" order by t2.name_bed");
		return sb.toString();
	}

	/**
	 * 主表
	 * 
	 * @return
	 */
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "t1";
	}
}
