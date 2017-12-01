
package iih.ci.ord.cior.d.desc;

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
 * 交叉备血结果单明细 DO 元数据信息
 */
public class CiOrdBtTestItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.ord.cior.d.CiOrdBtTestItmDO";
	public static final String CLASS_DISPALYNAME = "交叉备血结果单明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_RPT_BTTESTITM";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_rptbttestitm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiOrdBtTestItmDODesc(){
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
		this.setKeyDesc(getId_rptbttestitmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_rptbttestADesc(tblDesc));
		this.add(getId_rptbttestitmADesc(tblDesc));
		this.add(getId_rptbttestADesc(tblDesc));
		this.add(getId_tbADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getId_srv_btADesc(tblDesc));
		this.add(getBarcode_bbADesc(tblDesc));
		this.add(getNum_bbADesc(tblDesc));
		this.add(getId_unit_bbADesc(tblDesc));
		this.add(getId_abo_btADesc(tblDesc));
		this.add(getSd_abo_btADesc(tblDesc));
		this.add(getId_rh_btADesc(tblDesc));
		this.add(getSd_rh_btADesc(tblDesc));
		this.add(getId_testitmmethADesc(tblDesc));
		this.add(getSd_testitmmethADesc(tblDesc));
		this.add(getId_testitmres_mADesc(tblDesc));
		this.add(getSd_testitmres_mADesc(tblDesc));
		this.add(getId_testitmres_sADesc(tblDesc));
		this.add(getSd_testitmres_sADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getId_emp_testitmADesc(tblDesc));
		this.add(getId_emp_retestitmADesc(tblDesc));
		this.add(getDt_restitmADesc(tblDesc));
		this.add(getFg_stADesc(tblDesc));
		this.add(getId_mmADesc(tblDesc));
		this.add(getId_unit_pkgspADesc(tblDesc));
		this.add(getCode_btADesc(tblDesc));
		this.add(getName_btADesc(tblDesc));
		this.add(getDt_stADesc(tblDesc));
		this.add(getId_emp_stADesc(tblDesc));
		this.add(getName_bt_srvADesc(tblDesc));
		this.add(getCode_bt_srvADesc(tblDesc));
		this.add(getUnit_bb_nameADesc(tblDesc));
		this.add(getAbo_nameADesc(tblDesc));
		this.add(getRh_nameADesc(tblDesc));
		this.add(getBt_method_nameADesc(tblDesc));
		this.add(getBt_rsm_nameADesc(tblDesc));
		this.add(getBt_rss_nameADesc(tblDesc));
		this.add(getTest_nameADesc(tblDesc));
		this.add(getRetest_nameADesc(tblDesc));
		this.add(getMm_nameADesc(tblDesc));
		this.add(getPkgsp_unit_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_rptbttestitmCDesc(tblDesc));
		tblDesc.add(getId_rptbttestitmCDesc(tblDesc));
		tblDesc.add(getId_rptbttestCDesc(tblDesc));
		tblDesc.add(getId_tbCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getId_srv_btCDesc(tblDesc));
		tblDesc.add(getBarcode_bbCDesc(tblDesc));
		tblDesc.add(getNum_bbCDesc(tblDesc));
		tblDesc.add(getId_unit_bbCDesc(tblDesc));
		tblDesc.add(getId_abo_btCDesc(tblDesc));
		tblDesc.add(getSd_abo_btCDesc(tblDesc));
		tblDesc.add(getId_rh_btCDesc(tblDesc));
		tblDesc.add(getSd_rh_btCDesc(tblDesc));
		tblDesc.add(getId_testitmmethCDesc(tblDesc));
		tblDesc.add(getSd_testitmmethCDesc(tblDesc));
		tblDesc.add(getId_testitmres_mCDesc(tblDesc));
		tblDesc.add(getSd_testitmres_mCDesc(tblDesc));
		tblDesc.add(getId_testitmres_sCDesc(tblDesc));
		tblDesc.add(getSd_testitmres_sCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getId_emp_testitmCDesc(tblDesc));
		tblDesc.add(getId_emp_retestitmCDesc(tblDesc));
		tblDesc.add(getDt_restitmCDesc(tblDesc));
		tblDesc.add(getFg_stCDesc(tblDesc));
		tblDesc.add(getId_mmCDesc(tblDesc));
		tblDesc.add(getId_unit_pkgspCDesc(tblDesc));
		tblDesc.add(getCode_btCDesc(tblDesc));
		tblDesc.add(getName_btCDesc(tblDesc));
		tblDesc.add(getDt_stCDesc(tblDesc));
		tblDesc.add(getId_emp_stCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 备血检验结果明细属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rptbttestitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rptbttestitm",  getId_rptbttestitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备血检验结果明细");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备血检验结果主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rptbttestADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rptbttest",  getId_rptbttestCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备血检验结果主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 取血单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tb",  getId_tbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("取血单");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno",  getSortnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血液服务项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srv_btADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv_bt",  getId_srv_btCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血液服务项目");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 血袋条形码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBarcode_bbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Barcode_bb",  getBarcode_bbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血袋条形码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血袋规格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_bbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_bb",  getNum_bbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("血袋规格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血袋规格单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_bbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_bb",  getId_unit_bbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血袋规格单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 配血血型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_abo_btADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_abo_bt",  getId_abo_btCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("配血血型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 配血血型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_abo_btADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_abo_bt",  getSd_abo_btCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("配血血型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 配血RH属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rh_btADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rh_bt",  getId_rh_btCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("配血RH");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 配血RH编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_rh_btADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_rh_bt",  getSd_rh_btCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("配血RH编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交叉配血方法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_testitmmethADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_testitmmeth",  getId_testitmmethCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交叉配血方法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 交叉配血方法编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_testitmmethADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_testitmmeth",  getSd_testitmmethCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交叉配血方法编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交叉配血结果—主测属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_testitmres_mADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_testitmres_m",  getId_testitmres_mCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交叉配血结果—主测");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 交叉配血结果—主测编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_testitmres_mADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_testitmres_m",  getSd_testitmres_mCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交叉配血结果—主测编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交叉配血结果—次侧属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_testitmres_sADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_testitmres_s",  getId_testitmres_sCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交叉配血结果—次侧");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 交叉配血结果—次侧编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_testitmres_sADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_testitmres_s",  getSd_testitmres_sCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交叉配血结果—次侧编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 建议属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("建议");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 配血人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_testitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_testitm",  getId_emp_testitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("配血人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 复核人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_retestitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_retestitm",  getId_emp_retestitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("复核人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 配血时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_restitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_restitm",  getDt_restitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("配血时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否已取血属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_stADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_st",  getFg_stCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否已取血");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mm",  getId_mmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 零售包装单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_pkgspADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_pkgsp",  getId_unit_pkgspCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("零售包装单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 血液编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_btADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_bt",  getCode_btCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血液编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血液名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_btADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bt",  getName_btCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血液名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 取血时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_stADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_st",  getDt_stCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("取血时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 取血人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_stADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_st",  getId_emp_stCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("取血人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bt_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bt_srv",  getName_bt_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a1b7","id_srv_bt=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_bt_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_bt_srv",  getCode_bt_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a1b7","id_srv_bt=id_srv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计量单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUnit_bb_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Unit_bb_name",  getUnit_bb_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计量单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a1b8","id_unit_bb=id_measdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAbo_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Abo_name",  getAbo_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b2","id_abo_bt=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRh_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rh_name",  getRh_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b3","id_rh_bt=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBt_method_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bt_method_name",  getBt_method_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b4","id_testitmmeth=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBt_rsm_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bt_rsm_name",  getBt_rsm_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b9","id_testitmres_m=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBt_rss_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bt_rss_name",  getBt_rss_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b10","id_testitmres_s=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 配血人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTest_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Test_name",  getTest_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("配血人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b5","id_emp_testitm=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 复核人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRetest_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Retest_name",  getRetest_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("复核人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b6","id_emp_retestitm=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMm_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mm_name",  getMm_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a1b11","id_mm=id_mm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 包装单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPkgsp_unit_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pkgsp_unit_name",  getPkgsp_unit_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("包装单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM_PKGU a1b12","id_unit_pkgsp=id_mmpkgu","mmpkguname"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取备血检验结果明细表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rptbttestitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rptbttestitm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("备血检验结果明细"); 
		return column;
	}
	/**
	 * 获取备血检验结果主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rptbttestCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rptbttest");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备血检验结果主键"); 
		return column;
	}
	/**
	 * 获取取血单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tb");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("取血单"); 
		return column;
	}
	/**
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 获取血液服务项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srv_btCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv_bt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血液服务项目"); 
		return column;
	}
	/**
	 * 获取血袋条形码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBarcode_bbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Barcode_bb");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血袋条形码"); 
		return column;
	}
	/**
	 * 获取血袋规格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_bbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_bb");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("血袋规格"); 
		return column;
	}
	/**
	 * 获取血袋规格单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_bbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_bb");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血袋规格单位"); 
		return column;
	}
	/**
	 * 获取配血血型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_abo_btCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_abo_bt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("配血血型"); 
		return column;
	}
	/**
	 * 获取配血血型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_abo_btCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_abo_bt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("配血血型编码"); 
		return column;
	}
	/**
	 * 获取配血RH表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rh_btCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rh_bt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("配血RH"); 
		return column;
	}
	/**
	 * 获取配血RH编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_rh_btCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_rh_bt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("配血RH编码"); 
		return column;
	}
	/**
	 * 获取交叉配血方法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_testitmmethCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_testitmmeth");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交叉配血方法"); 
		return column;
	}
	/**
	 * 获取交叉配血方法编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_testitmmethCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_testitmmeth");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交叉配血方法编码"); 
		return column;
	}
	/**
	 * 获取交叉配血结果—主测表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_testitmres_mCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_testitmres_m");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交叉配血结果—主测"); 
		return column;
	}
	/**
	 * 获取交叉配血结果—主测编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_testitmres_mCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_testitmres_m");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交叉配血结果—主测编码"); 
		return column;
	}
	/**
	 * 获取交叉配血结果—次侧表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_testitmres_sCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_testitmres_s");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交叉配血结果—次侧"); 
		return column;
	}
	/**
	 * 获取交叉配血结果—次侧编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_testitmres_sCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_testitmres_s");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交叉配血结果—次侧编码"); 
		return column;
	}
	/**
	 * 获取建议表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("建议"); 
		return column;
	}
	/**
	 * 获取配血人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_testitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_testitm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("配血人"); 
		return column;
	}
	/**
	 * 获取复核人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_retestitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_retestitm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("复核人"); 
		return column;
	}
	/**
	 * 获取配血时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_restitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_restitm");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("配血时间"); 
		return column;
	}
	/**
	 * 获取是否已取血表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_stCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_st");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否已取血"); 
		return column;
	}
	/**
	 * 获取物品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品"); 
		return column;
	}
	/**
	 * 获取零售包装单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_pkgspCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_pkgsp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("零售包装单位"); 
		return column;
	}
	/**
	 * 获取血液编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_btCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_bt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血液编号"); 
		return column;
	}
	/**
	 * 获取血液名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_btCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血液名称"); 
		return column;
	}
	/**
	 * 获取取血时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_stCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_st");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("取血时间"); 
		return column;
	}
	/**
	 * 获取取血人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_stCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_st");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("取血人"); 
		return column;
	}
	/**
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bt_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bt_srv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_bt_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_bt_srv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务编码"); 
		return column;
	}
	/**
	 * 获取计量单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUnit_bb_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Unit_bb_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计量单位名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAbo_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Abo_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRh_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rh_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBt_method_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bt_method_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBt_rsm_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bt_rsm_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBt_rss_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bt_rss_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取配血人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTest_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Test_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("配血人姓名"); 
		return column;
	}
	/**
	 * 获取复核人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRetest_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Retest_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("复核人姓名"); 
		return column;
	}
	/**
	 * 获取物品名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMm_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mm_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品名称"); 
		return column;
	}
	/**
	 * 获取包装单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPkgsp_unit_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pkgsp_unit_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("包装单位名称"); 
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
