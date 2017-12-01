package iih.ci.ord.srvpri.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 服务价格计算入口参数 DTO数据 
 * 
 */
public class BdSrvPriCalParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医疗服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 价格策略
	 * @return String
	 */
	public String getId_primd() {
		return ((String) getAttrVal("Id_primd"));
	}
	/**
	 * 价格策略
	 * @param Id_primd
	 */
	public void setId_primd(String Id_primd) {
		setAttrVal("Id_primd", Id_primd);
	}
	/**
	 * 套加收或定价个数
	 * @return Integer
	 */
	public Integer getNum() {
		return ((Integer) getAttrVal("Num"));
	}
	/**
	 * 套加收或定价个数
	 * @param Num
	 */
	public void setNum(Integer Num) {
		setAttrVal("Num", Num);
	}
	/**
	 * 合计价套内项目信息
	 * @return FArrayList
	 */
	public FArrayList getSrvsetitms() {
		return ((FArrayList) getAttrVal("Srvsetitms"));
	}
	/**
	 * 合计价套内项目信息
	 * @param Srvsetitms
	 */
	public void setSrvsetitms(FArrayList Srvsetitms) {
		setAttrVal("Srvsetitms", Srvsetitms);
	}
	/**
	 * 医疗服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 医疗服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
}