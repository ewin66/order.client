/**
 * 
 */
package iih.ci.diag.cidiag.ref;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.desc.CiDiagItemDODesc;
import xap.mw.core.data.BizRuntimeException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * @ClassName: RefCiDiagItemDO
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年12月14日 下午2:20:45
 * @Package iih.ci.diag.cidiag.ref Copyright: Copyright (c) 2011 Company: 北大医疗信息技术有限责任公司
 */
public class RefCiDiagItemDO extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { CiDiagItemDO.ID_DIDEF_NAME, CiDiagItemDO.ID_DIDEF_CODE, CiDiagItemDO.SUPPLEMENT };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { CiDiagItemDO.ID_DIDEF, CiDiagItemDO.ID_DI, CiDiagItemDO.ID_DIITM };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "诊断名称", "诊断编码", "补充说明" };
	}

	@Override
	public String getPkFieldCode() {
		return CiDiagItemDO.ID_DIITM;
	}

	@Override
	public String getRefCodeField() {
		return CiDiagItemDO.ID_DIITM;
	}

	@Override
	public String getRefNameField() {
		return CiDiagItemDO.ID_DIDEF_NAME;
	}
	
	@Override
	public RefResultSet filterRefBlurValue(String blurValue, PaginationInfo pg) {
		String[] fields = this.getBlurFields();
		if (fields == null) {
			fields = this.getShowFieldCode();
		}
		blurValue = blurValue.toLowerCase();
		blurValue = blurValue.replaceAll("[ ]+", "%");
		blurValue = blurValue == "%" ? "" : blurValue;

		StringBuffer sb = new StringBuffer();
		sb.append(" (");
		sb.append("lower(bd_di_def.Name) like ");
		sb.append("?");
		sb.append(" or ");
		sb.append("lower(bd_di_def.Pycode) like ");
		sb.append("?");
		sb.append(" or ");
		sb.append("lower(bd_di_def.Wbcode) like ");
		sb.append("?");
		sb.append(" or ");
		sb.append("lower(bd_di_def.Mnecode) like ");
		sb.append("?");
		sb.append(") ");
		this.getParam().addParam(blurValue + "%");
		this.getParam().addParam(blurValue + "%");
		this.getParam().addParam(blurValue + "%");

		this.getParam().addParam(blurValue + "%");

		this.addWherePart(sb.toString());
		try {
			if (pg == null)
				return this.getRefData();
			else
				return this.getRefData(pg);
		} finally {
			this.removeWherePart(sb.toString());
		}
	}

	@Override
	public void addWherePart(String wherePart) {
		
		getWherePart().add(wherePart);
	}

	@Override
	public String getRefSql() {

		String wherePart = "";

		String id_ent = (String) this.getExtendAttributeValue("id_ent");
		String sql = "";
		if (StringUtils.isNotEmpty(id_ent)) {

			String id_dis = getIdDI(id_ent);
			if (!StringUtils.isEmpty(id_dis)) {
				wherePart = " id_di in (" + id_dis + ")";
				this.addWherePart(wherePart);
			} else {
				sql = defaultSql();
				String whereStr = "";
				List<String> whereList = this.getWherePart();
				for (String part : whereList) {
					whereStr += " and " + part;
				}
				if (whereList.size() > 0)
					sql += " where " + whereStr.substring(4);
			}
		}

		if (StringUtils.isEmpty(sql)) {
			sql = super.getRefSql();
		}

		return sql;
	}
	
	

	@Override
	public List<String[]> getWhereFieldCode() {
		// TODO Auto-generated method stub
		List<String[]> lstWhereCol = new ArrayList<String[]>();
		lstWhereCol.add(new String[]{"Id_didef","Id_didef"});
		return lstWhereCol;
	}

	@Override
	public List<String> getRefTableName() {
		// TODO Auto-generated method stub
		List<String> lstb = new ArrayList<String>();
		lstb.add("bd_di_def");
		return lstb;
	}

	@Override
	public String getTableName() {
		return CiDiagItemDODesc.TABLE_NAME;
	}

	@SuppressWarnings("unchecked")
	private String getIdDI(String id_en) {
		// 拼接诊断id，Id_di
		StringBuffer idDiBuffer = new StringBuffer();
		DAFacade facade = new DAFacade();
		String sql = " dt_sign in ("
				+" select max(dt_sign) from ci_di where id_en ='"+id_en+"' and  fg_sign ='Y' and sd_ditp !='"+ICiDictCodeConst.SD_SUPPLY+"'"
				+"  union all  "
				+ "  select dt_sign from ci_di where id_en ='"+id_en+"'  and fg_sign ='Y' and sd_ditp ='"+ICiDictCodeConst.SD_SUPPLY+"'"
				+ " and dt_sign>("
				+" select max(dt_sign) from ci_di where id_en ='"+id_en+"' and  fg_sign ='Y' and sd_ditp !='"+ICiDictCodeConst.SD_SUPPLY+"'"
				+" ))  ";

		List<CiDiagDO> CiDiagDOList = null;
		try {
			CiDiagDOList = (List<CiDiagDO>) facade.findByCond(CiDiagDO.class, sql, CiDiagDO.DT_DI);
		} catch (DAException e) {

			throw new BizRuntimeException("诊断查询语句异常！");
		}

		if (CiDiagDOList != null && CiDiagDOList.size() > 0) {

			for (CiDiagDO diagDO : CiDiagDOList) {
				idDiBuffer.append(",'" + diagDO.getId_di() + "'");
			}
			return idDiBuffer.substring(1);
		}

		return null;
	}

	/**
	 * 通过诊断定义查询诊断（当本次就诊没有诊断时调用该方法）
	 * 
	 * @return
	 */
	public String defaultSql() {

		return "select bd_di_def.name as Id_didef_name, bd_di_def.code as Id_didef_code, '' as Supplement, bd_di_def.id_didef as Id_didef, bd_di_def.id_didef as id_di, bd_di_def.id_didef as id_diitm from bd_di_def bd_di_def";
	}
}
