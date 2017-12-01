package iih.ci.ord.s.ems.biz.meta;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.pub.CiOrdUtils;

/**
 * 默认创建医嘱参数
 * @author wangqingzhu
 *
 */
public class DefaultCreateParam {

	private BdSrvMmInfoList bdSrvMmInfoList;
	private Object uiModel;
	
	
	public DefaultCreateParam(BdSrvMmInfoList bdSrvMmInfoList , Object uiModel){
		this.bdSrvMmInfoList = bdSrvMmInfoList;
		
		this.uiModel = uiModel;
	}
	
	/**
	 * 单药品默认医疗单参数构造方法
	 * @param srvInfo
	 * @param mmInfo
	 * @param uiModel
	 */
	public DefaultCreateParam(MedSrvDO srvInfo, MeterialDO mmInfo, Object uiModel){
		this.bdSrvMmInfoList = new BdSrvMmInfoList();
		this.bdSrvMmInfoList.add(new BdSrvMmInfo(srvInfo,mmInfo));
		this.uiModel = uiModel;
	}
	
	/**
	 * 创建药品默认医疗单参数 成组药
	 * @param szMedSrvInfo
	 * @param szMmInfo
	 * @param uiModel
	 */
	public DefaultCreateParam(MedSrvDO[] szMedSrvInfo, MeterialDO[] szMmInfo, Object uiModel){
		this.bdSrvMmInfoList = new BdSrvMmInfoList();
		int index = 0;
		for (MedSrvDO srvInfo : szMedSrvInfo){
			this.bdSrvMmInfoList.add(new BdSrvMmInfo(srvInfo,szMmInfo[index++]));
	}
		this.uiModel = uiModel;
	}
	
	/**
	 * 非药品创建默认医疗单参数集合
	 * @param szMedSrvInfo
	 * @param uiModel
	 */
	public DefaultCreateParam(MedSrvDO[] szMedSrvInfo, Object uiModel){
		this.bdSrvMmInfoList = new BdSrvMmInfoList();
		for (MedSrvDO srvInfo : szMedSrvInfo){
			this.bdSrvMmInfoList.add(new BdSrvMmInfo(srvInfo));
		}
		this.uiModel = uiModel;
	}

	/**
	 * 非药品默认创建医疗单参数构造方法
	 * @param srvInfo
	 * @param uiModel
	 */
	public DefaultCreateParam(MedSrvDO srvInfo, Object uiModel){
		this.bdSrvMmInfoList = new BdSrvMmInfoList();
		this.bdSrvMmInfoList.add(new BdSrvMmInfo(srvInfo));
		
		this.uiModel = uiModel;
	}

	/**
	 * 提取参数服务ID数组
	 * @return
	 */
	public String[] asIdSrvArray(){
		
		return this.bdSrvMmInfoList != null?bdSrvMmInfoList.asIdSrvArray() : null;
	}


	public BdSrvMmInfoList getBdSrvMmInfoList() {
		return bdSrvMmInfoList;
	}


	public void setBdSrvMmInfoList(BdSrvMmInfoList bdSrvMmInfoList) {
		this.bdSrvMmInfoList = bdSrvMmInfoList;
	}


	public Object getUiModel() {
		return uiModel;
	}

	public void setUiModel(Object uiModel) {
		this.uiModel = uiModel;
	}
	
	public BdSrvMmInfo getMainSrvInfo(){
		if (!CiOrdUtils.isEmpty(bdSrvMmInfoList)){
			return this.bdSrvMmInfoList.get(0);
		}
		return null;
	}
	
}
