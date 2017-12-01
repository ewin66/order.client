package iih.ci.ord.s.ems.driver;

import java.util.HashMap;
import java.util.Map;

import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.s.ems.driver.base.IOrderEmsDriver;
import iih.ci.ord.s.ems.driver.op.EmsApBtDriver;
import iih.ci.ord.s.ems.driver.op.EmsApBuDriver;
import iih.ci.ord.s.ems.driver.op.EmsConsDriver;
import iih.ci.ord.s.ems.driver.op.EmsDrugsDriver;
import iih.ci.ord.s.ems.driver.op.EmsHerbsDriver;
import iih.ci.ord.s.ems.driver.op.EmsLisDriver;
import iih.ci.ord.s.ems.driver.op.EmsOpsDriver;
import iih.ci.ord.s.ems.driver.op.EmsPathgyDriver;
import iih.ci.ord.s.ems.driver.op.EmsRisDriver;
import iih.ci.ord.s.ems.driver.op.EmsTreatDriver;

public class EmsDriverFactory {
	private static EmsDriverFactory instance = new EmsDriverFactory();
	private Map<String,IOrderEmsDriver> mapDriver=new HashMap<String,IOrderEmsDriver>();
	
	private EmsDriverFactory(){
		
	}
	
	/**
	 * 临时方法 -- 应该从医疗单维护中获取
	 */
	private void initReg(){
		mapDriver.put(EmsType.COMMONDRUG.toString(), new EmsDrugsDriver()) ; //通用药品
		mapDriver.put( EmsType.RIS.toString(), new EmsRisDriver()) ; //检查
		mapDriver.put( EmsType.LIS.toString(), new EmsLisDriver()) ; //检验
		mapDriver.put( EmsType.IV.toString(), new EmsDrugsDriver()) ; //Iv药
		mapDriver.put( EmsType.HERB.toString(), new EmsHerbsDriver()) ; //草药
		mapDriver.put( EmsType.OPER.toString(), new EmsOpsDriver()) ; //手术
		mapDriver.put( EmsType.PATHGY.toString(), new EmsPathgyDriver()) ; //病理
		mapDriver.put( EmsType.BT.toString(), new EmsApBtDriver()) ; //备血
		mapDriver.put( EmsType.COMMON.toString(), new EmsTreatDriver()) ; //简洁
		mapDriver.put( EmsType.CONS.toString(), new EmsConsDriver()) ; //会诊
//		mapDriver.put( EmsType.SKINTEST.toString(), new EmsDrugsDriver()) ; //皮试医疗单
		mapDriver.put( EmsType.BTUSE.toString(), new EmsApBuDriver()) ; //用血
//		mapDriver.put( EmsType.TRANSDEPT.toString(), new EmsDrugsDriver()) ; //转科
//		mapDriver.put( EmsType.OUTHOSP.toString(), new EmsDrugsDriver()) ; //出院
//		mapDriver.put( EmsType.TRANSWARD.toString(), new EmsDrugsDriver()) ; //转病区
	}
	
	public static EmsDriverFactory GetInstance(){
		instance.initReg();
		return instance;
	}
	
	public IOrderEmsDriver find(String et){
		IOrderEmsDriver drv = mapDriver.get(et);
		return drv;
	}
}
