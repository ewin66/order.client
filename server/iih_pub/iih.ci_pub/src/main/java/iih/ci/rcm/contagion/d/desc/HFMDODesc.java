
package iih.ci.rcm.contagion.d.desc;

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
 * 手足口附卡 DO 元数据信息
 */
public class HFMDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.rcm.contagion.d.HFMDO";
	public static final String CLASS_DISPALYNAME = "手足口附卡";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_CONTAGION_CARD_HFM";
	public static final String TABLE_ALIAS_NAME = "a4";
	public static final String PRIMARYKEY_FIELDNAME="Id_contagion_hfm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HFMDODesc(){
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
		this.setKeyDesc(getId_contagion_hfmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_contagionADesc(tblDesc));
		this.add(getId_contagion_hfmADesc(tblDesc));
		this.add(getId_contagionADesc(tblDesc));
		this.add(getId_formADesc(tblDesc));
		this.add(getId_hfm_resultADesc(tblDesc));
		this.add(getCode_hfm_resultADesc(tblDesc));
		this.add(getName_hfm_resultADesc(tblDesc));
		this.add(getIs_zhongzhengADesc(tblDesc));
		this.add(getCode_zhongzhengADesc(tblDesc));
		this.add(getName_zhongzhengADesc(tblDesc));
		this.add(getHfm_result_codeADesc(tblDesc));
		this.add(getHfm_result_nameADesc(tblDesc));
		this.add(getZhongzheng_codeADesc(tblDesc));
		this.add(getZhongzheng_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_contagion_hfmCDesc(tblDesc));
		tblDesc.add(getId_contagion_hfmCDesc(tblDesc));
		tblDesc.add(getId_contagionCDesc(tblDesc));
		tblDesc.add(getId_formCDesc(tblDesc));
		tblDesc.add(getId_hfm_resultCDesc(tblDesc));
		tblDesc.add(getCode_hfm_resultCDesc(tblDesc));
		tblDesc.add(getName_hfm_resultCDesc(tblDesc));
		tblDesc.add(getIs_zhongzhengCDesc(tblDesc));
		tblDesc.add(getCode_zhongzhengCDesc(tblDesc));
		tblDesc.add(getName_zhongzhengCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 手足口附卡ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_contagion_hfmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_contagion_hfm",  getId_contagion_hfmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手足口附卡ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 父id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_contagionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_contagion",  getId_contagionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("父id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 表单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_formADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_form",  getId_formCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("表单");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实验室结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hfm_resultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hfm_result",  getId_hfm_resultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实验室结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 实验室结果code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_hfm_resultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hfm_result",  getCode_hfm_resultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实验室结果code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实验室结果name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hfm_resultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hfm_result",  getName_hfm_resultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实验室结果name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 重症患者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_zhongzhengADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_zhongzheng",  getIs_zhongzhengCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("重症患者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 重症患者code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_zhongzhengADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_zhongzheng",  getCode_zhongzhengCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("重症患者code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 重症患者name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_zhongzhengADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_zhongzheng",  getName_zhongzhengCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("重症患者name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHfm_result_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hfm_result_code",  getHfm_result_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a4b2","id_hfm_result=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHfm_result_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hfm_result_name",  getHfm_result_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a4b2","id_hfm_result=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZhongzheng_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zhongzheng_code",  getZhongzheng_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a4b3","is_zhongzheng=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZhongzheng_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zhongzheng_name",  getZhongzheng_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a4b3","is_zhongzheng=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取手足口附卡ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_contagion_hfmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_contagion_hfm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手足口附卡ID"); 
		return column;
	}
	/**
	 * 获取父id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_contagionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_contagion");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("父id"); 
		return column;
	}
	/**
	 * 获取表单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_formCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_form");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("表单"); 
		return column;
	}
	/**
	 * 获取实验室结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hfm_resultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hfm_result");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实验室结果"); 
		return column;
	}
	/**
	 * 获取实验室结果code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_hfm_resultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hfm_result");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实验室结果code"); 
		return column;
	}
	/**
	 * 获取实验室结果name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hfm_resultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hfm_result");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实验室结果name"); 
		return column;
	}
	/**
	 * 获取重症患者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_zhongzhengCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_zhongzheng");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("重症患者"); 
		return column;
	}
	/**
	 * 获取重症患者code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_zhongzhengCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_zhongzheng");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("重症患者code"); 
		return column;
	}
	/**
	 * 获取重症患者name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_zhongzhengCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_zhongzheng");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("重症患者name"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHfm_result_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hfm_result_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHfm_result_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hfm_result_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZhongzheng_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zhongzheng_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZhongzheng_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zhongzheng_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
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
