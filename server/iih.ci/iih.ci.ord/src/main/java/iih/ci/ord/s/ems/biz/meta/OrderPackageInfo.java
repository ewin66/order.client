package iih.ci.ord.s.ems.biz.meta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.DOStatus;

/**
 * 医嘱包计算结构 ，用来保存过程中使用
 * @author wangqingzhu
 *
 */
public class OrderPackageInfo {
	/**
	 * 医疗单模型对象
	 */
	private Object uiModel;
	/**
	 * 医嘱基础数据对象集合
	 */
	private BdSrvInfoList bdSrvList;
	/**
	 * 医嘱信息
	 */
	private CiOrderDO orderInfo;
	
	
	private int status = DOStatus.NEW;
	
	
	/**
	 * 医嘱服务物品信息数组
	 */
	private OrderSrvMmList orderSrvMmList;
	/**
	 * 医嘱服务套内项目数组
	 */
	private OrderSrvSetList orderSrvSetList;
	/**
	 * 变动用药信息数组
	 */
	private OrderSrvDoseList orderSrvDoseList;
	/**
	 * 申请单信息
	 */
	private ObjectList orderAppSheetList;
	/**
	 * 医嘱服务关联医嘱服务包
	 */
	private Map<String,OrderPackageInfo> orderPakageInfoMap;
	
	/**
	 * 扩展信息对象
	 */
	private ObjectList extInfoList = new ObjectList();
	
	
	
	//

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getUiModel() {
		return uiModel;
	}

	public OrderPackageInfo setUiModel(Object uiModel) {
		this.uiModel = uiModel;
		return this;
	}

	
	public CiOrderDO getOrderInfo() {
		return orderInfo;
	}

	public OrderPackageInfo setOrderInfo(CiOrderDO orderInfo) {
		this.orderInfo = orderInfo;
		return this;
	}
	
	public OrdSrvDO[] getOrderSrvList() {
		if (CiOrdUtils.isEmpty(this.orderSrvMmList)){
			return null;
		}
		OrderSrvList listOrderSrvInfo = new OrderSrvList();
		for (OrderSrvMmInfo info : orderSrvMmList){
			listOrderSrvInfo.add(info.getOrderSrvInfo());
		}
		return listOrderSrvInfo.asArray();
	}


	public BdSrvInfoList getBdSrvList() {
		return bdSrvList;
	}

	public void setBdSrvList(BdSrvInfoList bdSrvList) {
		this.bdSrvList = bdSrvList;
	}
	
	public void setBdSrvList(MedSrvDO[] szInfo) {
		this.bdSrvList = new BdSrvInfoList(szInfo);// bdSrvList;
	}

	public OrderSrvMmList getOrderSrvMmList() {
		return orderSrvMmList;
	}

	public void setOrderSrvMmList(OrderSrvMmList orderSrvMmList) {
		this.orderSrvMmList = orderSrvMmList;
	}

	public OrderSrvSetList getOrderSrvSetList() {
		return orderSrvSetList;
	}

	public void setOrderSrvSetList(OrderSrvSetList orderSrvSetList) {
		this.orderSrvSetList = orderSrvSetList;
	}

	public OrderSrvDoseList getOrderSrvDoseList() {
		return orderSrvDoseList;
	}

	public void setOrderSrvDoseList(OrderSrvDoseList orderSrvDoseList) {
		this.orderSrvDoseList = orderSrvDoseList;
	}

	public ObjectList getOrderAppSheetList() {
		return orderAppSheetList;
	}

	public void setOrderAppSheetList(ObjectList orderAppSheetList) {
		this.orderAppSheetList = orderAppSheetList;
	}

	public ObjectList getExtInfoList() {
		return extInfoList;
	}

	public void setExtInfoList(ObjectList extInfoList) {
		this.extInfoList = extInfoList;
	}

	public Map<String, OrderPackageInfo> getOrderPakageInfoMap() {
		return orderPakageInfoMap;
	}

	public OrderPackageInfo setOrderPakageInfoMap(Map<String, OrderPackageInfo> orderPakageInfoMap) {
		this.orderPakageInfoMap = orderPakageInfoMap;
		return this;
	}

	public List<OrdSrvMmDO> asOrderSrvMmList() {
		List<OrdSrvMmDO> listOrdSrvMmDO = new ArrayList<OrdSrvMmDO>();
		for (OrderSrvMmInfo info : this.getOrderSrvMmList()){
			listOrdSrvMmDO.add(info.getOrderSrvMmInfo());
		}
		return listOrdSrvMmDO;
	}
	
	public OrderPackageInfo append(OrderSrvMmList orderSrvMmList){
		if (this.orderSrvMmList != null){
			this.orderSrvMmList.append(orderSrvMmList);
		}
		else{
			this.orderSrvMmList = orderSrvMmList;
		}
		return this;
	}
	
	public OrderPackageInfo append(OrderSrvSetList orderSrvSetList){
		if (this.orderSrvSetList != null){
			this.orderSrvSetList.append(orderSrvSetList);
		}
		else{
			this.orderSrvSetList = orderSrvSetList;
		}
		return this;
	}
	
	public boolean isSet(){
		return CiOrdUtils.isTrue(this.orderInfo.getFg_set());
	}
	
	public boolean isNew(){
		return this.status == DOStatus.NEW;
	}
	
	public boolean isUpdate(){
		return this.status == DOStatus.UPDATED;
	}
	
	public boolean isUnChanged(){
		return this.status == DOStatus.UNCHANGED;
	}
	
	public boolean isOrderSrvMmListEmpty(){
		return CiOrdUtils.isEmpty(this.orderSrvMmList);
	}
	
	public boolean isOrderSrvSetListEmpty(){
		return CiOrdUtils.isEmpty(this.orderSrvSetList);
	}
	
	public MedSrvDO getMainSrvInfo(){
		if (!CiOrdUtils.isEmpty(this.bdSrvList))
		{
			return this.bdSrvList.get(0);
		}
		
		return null;
	}
}
