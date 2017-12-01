
package iih.ci.ord.consrpt.d.desc;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import xap.sys.appfw.orm.desc.db.ColumnDesc;
import xap.sys.appfw.orm.desc.db.DsColumn;
import xap.sys.appfw.orm.desc.db.SvColumn;
import xap.sys.appfw.orm.desc.db.TableDesc;
import xap.sys.appfw.orm.desc.ent.dataobject.Attr;
import xap.sys.appfw.orm.desc.ent.dataobject.DODesc;
import xap.sys.appfw.orm.desc.ent.dataobject.DsAttr;
import xap.sys.appfw.orm.desc.ent.dataobject.SvAttr;
import xap.mw.coreitf.i.IAttrDesc;
import xap.mw.coreitf.i.IColumnDesc;
import xap.mw.coreitf.i.ITableDesc;
import xap.mw.coreitf.d.FType;
import java.math.BigDecimal;

/**
 * 会诊记录单 DO 元数据信息
 */
public class CiOrdConsRptDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.ord.consrpt.d.CiOrdConsRptDO";
	public static final String CLASS_DISPALYNAME = "会诊记录单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_rpt_cons";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_rptcons";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiOrdConsRptDODesc(){
		init();
	}
	
	/**
	 * 数据初始化
	 */
	private void init(){		
		this.setResID(CLASS_RESID);
		this.setResNode(CLASS_RESMODULE);
		this.setLabel(CLASS_DISPALYNAME);
		this.setEntityName(CLASS_FULLNAME);
		ITableDesc tblDesc=getTableDesc();
		this.setKeyDesc(getId_rptconsADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_rptconsADesc(tblDesc));
		this.add(getId_apconsADesc(tblDesc));
		this.add(getDt_actualADesc(tblDesc));
		this.add(getAdviceADesc(tblDesc));
		this.add(getId_emp_rptADesc(tblDesc));
		this.add(getId_dep_rptADesc(tblDesc));
		this.add(getDt_rptADesc(tblDesc));
		this.add(getId_emp_hostADesc(tblDesc));
		this.add(getId_place_actualADesc(tblDesc));
		this.add(getSd_su_rptADesc(tblDesc));
		this.add(getId_su_rptADesc(tblDesc));
		this.add(getName_placeADesc(tblDesc));
		this.add(getName_emp_rptADesc(tblDesc));
		this.add(getName_dep_rptADesc(tblDesc));
		this.add(getName_emp_hostADesc(tblDesc));
		this.add(getName_place_actualADesc(tblDesc));
		this.add(new DsAttr(dsColumn,this));
		this.add(new SvAttr(svColumn,this));
		this.setIsRefTableInfo(true);
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getId_rptconsCDesc(tblDesc));
		tblDesc.add(getId_rptconsCDesc(tblDesc));
		tblDesc.add(getId_apconsCDesc(tblDesc));
		tblDesc.add(getDt_actualCDesc(tblDesc));
		tblDesc.add(getAdviceCDesc(tblDesc));
		tblDesc.add(getId_emp_rptCDesc(tblDesc));
		tblDesc.add(getId_dep_rptCDesc(tblDesc));
		tblDesc.add(getDt_rptCDesc(tblDesc));
		tblDesc.add(getId_emp_hostCDesc(tblDesc));
		tblDesc.add(getId_place_actualCDesc(tblDesc));
		tblDesc.add(getSd_su_rptCDesc(tblDesc));
		tblDesc.add(getId_su_rptCDesc(tblDesc));
		tblDesc.add(getName_placeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rptconsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rptcons",  getId_rptconsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊申请单id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_apconsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apcons",  getId_apconsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊申请单id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际会诊时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_actualADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_actual",  getDt_actualCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("实际会诊时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊意见属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdviceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Advice",  getAdviceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊意见");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_rptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_rpt",  getId_emp_rptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报告人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 报告科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_rptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_rpt",  getId_dep_rptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报告科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 报告时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_rptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_rpt",  getDt_rptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("报告时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊主持属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_hostADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_host",  getId_emp_hostCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊主持");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 实际会诊地点属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_place_actualADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_place_actual",  getId_place_actualCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实际会诊地点");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 会诊记录状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_su_rptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_su_rpt",  getSd_su_rptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊记录状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊记录状态id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_su_rptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_su_rpt",  getId_su_rptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊记录状态id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊地点名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_placeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_place",  getName_placeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊地点名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告人名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_rptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_rpt",  getName_emp_rptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报告人名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b2","id_emp_rpt=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告部门属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_rptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_rpt",  getName_dep_rptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报告部门");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b3","id_dep_rpt=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊主持名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_hostADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_host",  getName_emp_hostCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊主持名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b7","id_emp_host=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 地点名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_place_actualADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_place_actual",  getName_place_actualCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("地点名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_plc a0b8","id_place_actual=id_plc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rptconsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rptcons");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主键"); 
		return column;
	}
	/**
	 * 获取会诊申请单id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_apconsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apcons");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊申请单id"); 
		return column;
	}
	/**
	 * 获取实际会诊时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_actualCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_actual");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("实际会诊时间"); 
		return column;
	}
	/**
	 * 获取会诊意见表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdviceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Advice");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊意见"); 
		return column;
	}
	/**
	 * 获取报告人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_rptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_rpt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报告人"); 
		return column;
	}
	/**
	 * 获取报告科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_rptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_rpt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报告科室"); 
		return column;
	}
	/**
	 * 获取报告时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_rptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_rpt");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("报告时间"); 
		return column;
	}
	/**
	 * 获取会诊主持表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_hostCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_host");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊主持"); 
		return column;
	}
	/**
	 * 获取实际会诊地点表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_place_actualCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_place_actual");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实际会诊地点"); 
		return column;
	}
	/**
	 * 获取会诊记录状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_su_rptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_su_rpt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊记录状态编码"); 
		return column;
	}
	/**
	 * 获取会诊记录状态id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_su_rptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_su_rpt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊记录状态id"); 
		return column;
	}
	/**
	 * 获取会诊地点名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_placeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_place");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊地点名称"); 
		return column;
	}
	/**
	 * 获取报告人名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_rptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_rpt");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报告人名称"); 
		return column;
	}
	/**
	 * 获取报告部门表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_rptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_rpt");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报告部门"); 
		return column;
	}
	/**
	 * 获取会诊主持名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_hostCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_host");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊主持名称"); 
		return column;
	}
	/**
	 * 获取地点名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_place_actualCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_place_actual");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("地点名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
	}

	/**
	 * 设置实体审计信息数据映射关系
	 */
	private void setIAuditInfoFldMap(){
	}
	
}
