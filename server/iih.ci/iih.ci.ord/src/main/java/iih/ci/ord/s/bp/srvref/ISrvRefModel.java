package iih.ci.ord.s.bp.srvref;

import xap.mw.core.data.BizException;

/**
 * 服务参照模型接口
 */
public interface ISrvRefModel {
	public abstract String[] getAllFields();         //获得参照关联的全部字段集
	public abstract void setSelectFields(String[] selectFields);//设置查询选择字段集
	public abstract String[] getSelectFields();      //获得查询选择字段集 new String[]{"fldname1","fldname2","fldname3"}[]                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
	public abstract void setSrvDescFields(String[] descFields); //设置参照服务描述字段集new String[]{"Sd_srvtp,fldname1,fldname2","Sd_srvtp,fn1,fn2,fn3"}
	public abstract String[] getSrvDescFields();     //获得参照服务描述字段集
	public abstract SrvRefTypeInfo[] getSrvRefInfo();//获得服务参照数据信息
	public abstract String getFixedWhereStr();       //获得条件串中 固定条件部分
	public abstract String getDynamicWhereStr();     //获得条件串中 动态条件部分
	public abstract String getIndividualWhereStr();  //获得条件串中 个性化条件部分
	public abstract String getDepSrvLimitWhereStr() throws BizException ; //获得条件串中  科室服务限制条件部分
	public abstract String getEmsSpecWhereStr() throws BizException;
	public abstract String getSrvDescSelectStr();
	public abstract boolean existsMMDefField();      //存在物品定义字段
	public abstract boolean getFg_srvMmNameMerge();      //是否服务与物品名称合并显示
	public abstract void setFg_srvMmNameMerge(boolean fg_srvMmNameMerge);//设置服务与物品名称合并显示标识
	public abstract String getSQLStr() throws BizException;              //获得SQL语句串
	
}