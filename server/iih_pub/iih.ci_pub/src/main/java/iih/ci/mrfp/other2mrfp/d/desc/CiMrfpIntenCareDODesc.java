
package iih.ci.mrfp.other2mrfp.d.desc;

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
 * 重症监护 DO 元数据信息
 */
public class CiMrfpIntenCareDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mrfp.other2mrfp.d.CiMrfpIntenCareDO";
	public static final String CLASS_DISPALYNAME = "重症监护";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_mrfp_intencare";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_mrfp_intencare";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiMrfpIntenCareDODesc(){
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
		this.setKeyDesc(getId_mrfp_intencareADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_cimrfpotherADesc(tblDesc));
		this.add(getId_mrfp_intencareADesc(tblDesc));
		this.add(getId_cimrfpotherADesc(tblDesc));
		this.add(getName_intencareADesc(tblDesc));
		this.add(getTime_in_intencareADesc(tblDesc));
		this.add(getTime_out_intencareADesc(tblDesc));
		this.add(new DsAttr(dsColumn,this));
		this.add(new SvAttr(svColumn,this));
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getId_mrfp_intencareCDesc(tblDesc));
		tblDesc.add(getId_mrfp_intencareCDesc(tblDesc));
		tblDesc.add(getId_cimrfpotherCDesc(tblDesc));
		tblDesc.add(getName_intencareCDesc(tblDesc));
		tblDesc.add(getTime_in_intencareCDesc(tblDesc));
		tblDesc.add(getTime_out_intencareCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 重症监护主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrfp_intencareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrfp_intencare",  getId_mrfp_intencareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("重症监护主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病案首页其他信息主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cimrfpotherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cimrfpother",  getId_cimrfpotherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案首页其他信息主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 重症监护室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_intencareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_intencare",  getName_intencareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("重症监护室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进重症监护室时间（年月日时分）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTime_in_intencareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Time_in_intencare",  getTime_in_intencareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("进重症监护室时间（年月日时分）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出重症监护室时间（年月日时分）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTime_out_intencareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Time_out_intencare",  getTime_out_intencareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("出重症监护室时间（年月日时分）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取重症监护主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrfp_intencareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrfp_intencare");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("重症监护主键"); 
		return column;
	}
	/**
	 * 获取病案首页其他信息主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cimrfpotherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cimrfpother");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病案首页其他信息主键"); 
		return column;
	}
	/**
	 * 获取重症监护室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_intencareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_intencare");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("重症监护室名称"); 
		return column;
	}
	/**
	 * 获取进重症监护室时间（年月日时分）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTime_in_intencareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Time_in_intencare");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("进重症监护室时间（年月日时分）"); 
		return column;
	}
	/**
	 * 获取出重症监护室时间（年月日时分）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTime_out_intencareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Time_out_intencare");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出重症监护室时间（年月日时分）"); 
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
