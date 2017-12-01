package iih.ci.ord.s.ems.biz.meta;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.d.MedSrvRelMmDTO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 基础数据服务物品对象
 * @author wangqingzhu
 *
 */
public class BdSrvMmInfo {
	
	private MedSrvDO bdSrvInfo;

	private MedSrvDrugDO srvDrugInfo;
	
	private MeterialDO mmInfo;
	
	private Object uiModel;
	
	
	public BdSrvMmInfo(){}
	
	
	public BdSrvMmInfo(Object uiModel){
		
		this.uiModel = uiModel;
	}
	
	public BdSrvMmInfo(MedSrvDO bdSrvInfo,Object uiModel){
		this.bdSrvInfo = bdSrvInfo;
		this.uiModel = uiModel;
	}
	
	public BdSrvMmInfo(MedSrvDO bdSrvInfo){
		this.bdSrvInfo = bdSrvInfo;
		
	}
	
	public BdSrvMmInfo(MeterialDO mmInfo){
		this.mmInfo = mmInfo;
	
	}
	
	public BdSrvMmInfo(MedSrvDO bdSrvInfo,MeterialDO mmInfo){
		this.bdSrvInfo = bdSrvInfo;
		this.mmInfo = mmInfo;
		
	}
	
	public MedSrvDO getBdSrvInfo() {
		return bdSrvInfo;
	}
	public void setBdSrvInfo(MedSrvDO bdSrvInfo) {
		this.bdSrvInfo = bdSrvInfo;
	}

	public MeterialDO getMmInfo() {
		return mmInfo;
	}
	
	public void setMmInfo(MeterialDO mmInfo) {
		this.mmInfo = mmInfo;
	}
	
	public MedSrvDrugDO getSrvDrugInfo() {
		return srvDrugInfo;
	}

	public void setSrvDrugInfo(MedSrvDrugDO srvDrugInfo) {
		this.srvDrugInfo = srvDrugInfo;
	}

	public Object getUiModel() {
		return uiModel;
	}

	public void setUiModel(Object uiModel) {
		this.uiModel = uiModel;
	}

	/**
	 * 创建物品信息
	 * @param srvInfo 诊疗项目
	 * @param id_org 当前组织
	 * @param id_dep_or 当前科室
	 * @return 是否成功
	 * @throws BizException
	 */
	public boolean createSrvMmInfo(String id_org, String id_dep_or) throws BizException{
		if (null == bdSrvInfo){
			return false;
		}
		
		MedSrvRelMmDTO srvrelmmdo=CiOrdUtils.getSrvRelDefaultMmDTO(bdSrvInfo.getId_srv(),id_org,id_dep_or);
		if (null != srvrelmmdo){
			this.mmInfo = ServiceFinder.find(IMeterialMDORService.class).findById(srvrelmmdo.getId_mm());
			 MedSrvDrugDO[] szMedSrvDrugDO = ServiceFinder.find(IMedSrvDrugDORService.class).findByAttrValString(MedSrvDrugDO.ID_SRV, bdSrvInfo.getId_srv());
			 assert !CiOrdUtils.isEmpty(szMedSrvDrugDO) : String.format("【%s】服务药品属性为空", bdSrvInfo.getName());
			 if (!CiOrdUtils.isEmpty(szMedSrvDrugDO)){
				 this.srvDrugInfo = szMedSrvDrugDO[0];
			 }
		}
		return true;
	}
	
	/**
	 * 创建物品信息
	 * @param srvInfo 诊疗项目
	 * @param id_org 当前组织
	 * @param id_dep_or 当前科室
	 * @return 是否成功
	 * @throws BizException
	 */
	public boolean createSrvMmInfo(MedSrvDO srvInfo, String id_org, String id_dep_or) throws BizException{
		if (null == srvInfo){
			return false;
		}
		this.bdSrvInfo = srvInfo;
		MedSrvRelMmDTO srvrelmmdo=CiOrdUtils.getSrvRelDefaultMmDTO(srvInfo.getId_srv(),id_org,id_dep_or);
		if (null != srvrelmmdo){
			this.mmInfo = ServiceFinder.find(IMeterialMDORService.class).findById(srvrelmmdo.getId_mm());
			 MedSrvDrugDO[] szMedSrvDrugDO = ServiceFinder.find(IMedSrvDrugDORService.class).findByAttrValString(MedSrvDrugDO.ID_SRV, bdSrvInfo.getId_srv());
			 assert !CiOrdUtils.isEmpty(szMedSrvDrugDO) : String.format("【%s】服务药品属性为空", bdSrvInfo.getName());
			 if (!CiOrdUtils.isEmpty(szMedSrvDrugDO)){
				 this.srvDrugInfo = szMedSrvDrugDO[0];
			 }
		}
		return true;
	}
	
	/**
	 * 创建物品信息（默认关联物品）
	 * @param id_srv 诊疗项目ID
	 * @param id_org 当前组织
	 * @param id_dep_or 当前科室
	 * @return 是否成功
	 * @throws BizException
	 */
	public boolean createSrvMmInfo(String id_srv, String id_org, String id_dep_or) throws BizException{
		if (null == id_srv){
			return false;
		}
		this.bdSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findById(id_srv);
		
		return createSrvMmInfo(this.bdSrvInfo, id_org, id_dep_or);
	}
	/**
	 * 创建物品信息
	 * @param id_srv 诊疗项目服务ID
	 * @param id_mm 物品ID
	 * @param id_org 当前组织
	 * @param id_dep_or 当前科室
	 * @return
	 * @throws BizException
	 */
	public boolean createSrvMmInfo(String id_srv,String id_mm, String id_org, String id_dep_or) throws BizException{
		if (CiOrdUtils.isEmpty(id_srv)||CiOrdUtils.isEmpty(id_mm)){
			return false;
		}
		this.bdSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findById(id_srv);
		
		this.mmInfo = ServiceFinder.find(IMeterialMDORService.class).findById(id_mm);
		
		MedSrvDrugDO[] szMedSrvDrugDO = ServiceFinder.find(IMedSrvDrugDORService.class).findByAttrValString(MedSrvDrugDO.ID_SRV, bdSrvInfo.getId_srv());
		 assert !CiOrdUtils.isEmpty(szMedSrvDrugDO) : String.format("【%s】服务药品属性为空", bdSrvInfo.getName());
		 if (!CiOrdUtils.isEmpty(szMedSrvDrugDO)){
			 this.srvDrugInfo = szMedSrvDrugDO[0];
		 }
		
		return true;
	}
	/**
	 * 是否为医疗服务物品
	 * @return
	 */
	public boolean isMm(){
		return this.getMmInfo() != null && CiOrdUtils.isTrue( this.getBdSrvInfo().getFg_mm() );
	}
}
