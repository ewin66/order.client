
package iih.ci.mr.nu.obstetrics.birthrec.d.desc;

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
 * 产程经过记录 DO 元数据信息
 */
public class BirthrecProDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.obstetrics.birthrec.d.BirthrecProDO";
	public static final String CLASS_DISPALYNAME = "产程经过记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_NU_BIRTHRECPRO";
	public static final String TABLE_ALIAS_NAME = "a0b5";
	public static final String PRIMARYKEY_FIELDNAME="Id_birthrecpro";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BirthrecProDODesc(){
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
		this.setKeyDesc(getId_birthrecproADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_birthinfoADesc(tblDesc));
		this.add(getId_birthrecproADesc(tblDesc));
		this.add(getId_birthinfoADesc(tblDesc));
		this.add(getTmADesc(tblDesc));
		this.add(getQmADesc(tblDesc));
		this.add(getTfwADesc(tblDesc));
		this.add(getGdADesc(tblDesc));
		this.add(getYsADesc(tblDesc));
		this.add(getMbADesc(tblDesc));
		this.add(getGscxADesc(tblDesc));
		this.add(getSzyADesc(tblDesc));
		this.add(getGsjgADesc(tblDesc));
		this.add(getSsyADesc(tblDesc));
		this.add(getTxADesc(tblDesc));
		this.add(getTwADesc(tblDesc));
		this.add(getRqADesc(tblDesc));
		this.add(getEu_gsqrADesc(tblDesc));
		this.add(getBzADesc(tblDesc));
		this.add(getGkADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_birthrecproCDesc(tblDesc));
		tblDesc.add(getId_birthrecproCDesc(tblDesc));
		tblDesc.add(getId_birthinfoCDesc(tblDesc));
		tblDesc.add(getTmCDesc(tblDesc));
		tblDesc.add(getQmCDesc(tblDesc));
		tblDesc.add(getTfwCDesc(tblDesc));
		tblDesc.add(getGdCDesc(tblDesc));
		tblDesc.add(getYsCDesc(tblDesc));
		tblDesc.add(getMbCDesc(tblDesc));
		tblDesc.add(getGscxCDesc(tblDesc));
		tblDesc.add(getSzyCDesc(tblDesc));
		tblDesc.add(getGsjgCDesc(tblDesc));
		tblDesc.add(getSsyCDesc(tblDesc));
		tblDesc.add(getTxCDesc(tblDesc));
		tblDesc.add(getTwCDesc(tblDesc));
		tblDesc.add(getRqCDesc(tblDesc));
		tblDesc.add(getEu_gsqrCDesc(tblDesc));
		tblDesc.add(getBzCDesc(tblDesc));
		tblDesc.add(getGkCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 唯一标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_birthrecproADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_birthrecpro",  getId_birthrecproCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("唯一标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者信息id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_birthinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_birthinfo",  getId_birthinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者信息id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎膜属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tm",  getTmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎膜");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qm",  getQmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎方位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTfwADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tfw",  getTfwCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎方位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 高低属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Gd",  getGdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("高低");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 羊水属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getYsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ys",  getYsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("羊水");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脉搏属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mb",  getMbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("脉搏");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宫缩持续属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGscxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Gscx",  getGscxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("宫缩持续");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舒张压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSzyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Szy",  getSzyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("舒张压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宫缩间隔属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGsjgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Gsjg",  getGsjgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("宫缩间隔");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收缩压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSsyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ssy",  getSsyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("收缩压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎心属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tx",  getTxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("胎心");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体温属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTwADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tw",  getTwCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("体温");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rq",  getRqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宫缩强弱属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_gsqrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_gsqr",  getEu_gsqrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("宫缩强弱");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bz",  getBzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宫口属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Gk",  getGkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宫口");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取唯一标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_birthrecproCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_birthrecpro");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("唯一标识"); 
		return column;
	}
	/**
	 * 获取患者信息id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_birthinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_birthinfo");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者信息id"); 
		return column;
	}
	/**
	 * 获取胎膜表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎膜"); 
		return column;
	}
	/**
	 * 获取签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签名"); 
		return column;
	}
	/**
	 * 获取胎方位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTfwCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tfw");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎方位"); 
		return column;
	}
	/**
	 * 获取高低表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Gd");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("高低"); 
		return column;
	}
	/**
	 * 获取羊水表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getYsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ys");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("羊水"); 
		return column;
	}
	/**
	 * 获取脉搏表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mb");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("脉搏"); 
		return column;
	}
	/**
	 * 获取宫缩持续表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGscxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Gscx");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("宫缩持续"); 
		return column;
	}
	/**
	 * 获取舒张压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSzyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Szy");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("舒张压"); 
		return column;
	}
	/**
	 * 获取宫缩间隔表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGsjgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Gsjg");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("宫缩间隔"); 
		return column;
	}
	/**
	 * 获取收缩压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSsyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ssy");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("收缩压"); 
		return column;
	}
	/**
	 * 获取胎心表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tx");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("胎心"); 
		return column;
	}
	/**
	 * 获取体温表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTwCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tw");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("体温"); 
		return column;
	}
	/**
	 * 获取日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rq");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("日期"); 
		return column;
	}
	/**
	 * 获取宫缩强弱表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_gsqrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_gsqr");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("宫缩强弱"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bz");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取宫口表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Gk");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宫口"); 
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
