package iih.ci.ord.s.bp.ems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.d.CiOrAggAndRelInfo;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.hp.HpMedicalInsurance;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.GetCiOderBlSrvBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.mapping.DORsReferMap;

/**
 * 由医疗单信息获得临床医嘱及关联信息操作BP
 * 关联信息：医嘱项目物品信息
 */
public class CiOrEmsGetOrAggAndRelInfoBP {
	/**
	 * 由医疗单信息获得临床医嘱及关联信息
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public  CiOrAggAndRelInfo exec(CiEmsDTO ems)  throws BizException{
		// 过滤脏数据(isDeleted)
		handleClearDirtyData(ems);
		//默认值设置
		CiEmsDefaultValueSetBP bp=new CiEmsDefaultValueSetBP();
		bp.exec(ems);
		//由医疗单信息获得临床医嘱及相关附加信息
		CiOrAggAndRelDatum orandreldatum=getCiOrAggAndRelDatum(ems);
		CiOrdUtils.setIdHpValue(orandreldatum,null);
		//有效性判断
		if(CiOrdUtils.isEmpty(orandreldatum))return null;
		if(CiOrdUtils.IsMedicalInsuranceEnable()==FBoolean.TRUE){
			FArrayList2 diagList  = CiOrdUtils.getDiagItemList(orandreldatum.getOraggdo().getParentDO().getId_en());
			HpMedicalInsurance.setMedicalInsurance(orandreldatum,diagList);	
		}
		//数据返回
		return getCiOrAggAndRelInfo(orandreldatum);
	}
	
	/**
	 * 过滤掉脏数据
	 * @param ems
	 */
	private void handleClearDirtyData(CiEmsDTO ems)
	{
		FArrayList emssrvs = ems.getEmssrvs();
		int count = emssrvs.size();
		for(int i = count-1;i>=0;i--){
			CiEmsSrvDTO srvdto = (CiEmsSrvDTO)emssrvs.get(i);
			if(srvdto.getStatus()==DOStatus.DELETED){
				emssrvs.remove(i);
			}
		}
	}
	
	/**
	 * 由医疗单信息获得临床医嘱及相关附加信息
	 * @param ems
	 * @return
	 * @throws BizException 
	 */
	private CiOrAggAndRelDatum getCiOrAggAndRelDatum(CiEmsDTO ems) throws BizException{
		CiOrEms2OrAggAndRelInfoBP bp=new CiOrEms2OrAggAndRelInfoBP();
		return bp.exec(ems);
	}
	
	/**
	 * 获得临床医嘱及关联信息
	 * @return
	 */
	private CiOrAggAndRelInfo getCiOrAggAndRelInfo(CiOrAggAndRelDatum datum){
		CiOrAggAndRelInfo rtn=new CiOrAggAndRelInfo();
		
		//设置医嘱聚集
		aggNameHandle(datum.getOraggdo());
		rtn.setOrAggDO(datum.getOraggdo());
		
		//设置医嘱项目对应的物品信息
		if(!CiOrdUtils.isEmpty(datum.getOrattachht())){
			FMap map=mapNameHandle(CiOrAttachInfoUtils.getOrdSrvMmDOMap(datum.getOrattachht()));
			rtn.setOrSrvMmMap(map);
		}
		
		//设置费用服务备注信息
		if(!CiOrdUtils.isEmpty(datum.getOraggdo())){
			if(!CiOrdUtils.isEmpty(datum.getOraggdo().getOrdSrvDO())){
				OrdSrvDO[] srvdos=datum.getOraggdo().getOrdSrvDO();
				List<String> idsrvlist=new ArrayList<String>();
				for(OrdSrvDO srvdo:srvdos){
					idsrvlist.add(srvdo.getId_srv());
				}
				FMap bldesMap=getBlSrvDes(idsrvlist.toArray(new String[idsrvlist.size()]) );
				if(bldesMap!=null && bldesMap.size()!=0){
					rtn.setBlSrvMap(bldesMap);
				}
			}
		}
		

		//返回
		return  rtn;
	}
	
	/**
	 * 医嘱项目关联名称处理
	 * @param aggdo
	 */
	private void aggNameHandle(CiorderAggDO aggdo){
		OrdSrvDO[] orsrvdos=aggdo.getOrdSrvDO();
		if(CiOrdUtils.isEmpty(orsrvdos))return;
		orsrvdos=new DORsReferMap<OrdSrvDO>(OrdSrvDO.class).convert(orsrvdos);
		for(OrdSrvDO srvDO : orsrvdos){
			if(!CiOrdUtils.isEmpty(srvDO.getSd_hpsrvtp())&&CiOrdUtils.isEmpty(srvDO.getId_hpsrvtp())){
				srvDO.setId_hpsrvtp(CiOrdUtils.idHpSrvtpFromSdHpSrvtp(srvDO.getSd_hpsrvtp()));
				srvDO.setName_hpsrvtp(CiOrdUtils.nameHpSrvtpFromSdHpSrvtp(srvDO.getSd_hpsrvtp()));
			}
		}
		aggdo.setOrdSrvDO(orsrvdos);
	}
	
	/**
	 * 医嘱项目对应的物品信息关联名称
	 * @param mmmap
	 * @return
	 */
	private FMap mapNameHandle(FMap mmmap){
		//有效性校验
		if(CiOrdUtils.isEmpty(mmmap))return null;
		
		//返回
		return getOrSrvMmDOMap(mmmap);
		
	}
	
	/**
	 * 医嘱项目对应的物品信息关联名称
	 * @param mmmap
	 * @return
	 */
	private FMap getOrSrvMmDOMap(FMap mmmap){
		//参数设置
		Iterator kvpairs = mmmap.entrySet().iterator();
		Map.Entry entry=null;
		String key="";
		int iN=mmmap.size();
		
		String[] keys=new String[iN];
		
		List<OrdSrvMmDO> list =  new ArrayList();
		List<OrdSrvMmDO> listtmp =  new ArrayList();
		//遍历
		for(int i = 0; i<iN; i++)
		{
			entry= (Map.Entry) kvpairs.next();
			String[] srr= entry.getKey().toString().split("_");
			if(srr != null && srr.length >0)
			keys[i] = srr[1];
			listtmp =  (List<OrdSrvMmDO>) entry.getValue();
			for(int j =0;j<listtmp.size();j++){
				list.add(listtmp.get(j));
			}
		   // orsrvmmdos[i] =(OrdSrvMmDO) (entry.getValue());
		}
		OrdSrvMmDO[] orsrvmmdos=new OrdSrvMmDO[list.size()];
		orsrvmmdos = list.toArray(new OrdSrvMmDO[list.size()]);
		orsrvmmdos=new DORsReferMap<OrdSrvMmDO>(OrdSrvMmDO.class).convert(orsrvmmdos);
		return getMap(keys,orsrvmmdos);
	}
	
	/**
	  * 
	  * @param srvmmmap
	  * @return
	  */
	 private  List<String> getMap(FMap srvmmmap){
		 List  list = new ArrayList();
		if(srvmmmap != null ){
			Iterator entrys = srvmmmap.entrySet().iterator();
			while (entrys.hasNext()) {
				Map.Entry entry = (Map.Entry) entrys.next();
				list.add(entry.getKey().toString());
			  }
		}
		 return list;
	 }
	/**
	 * 获得Map数据
	 * @param keys
	 * @param vs
	 * @return
	 */
	private FMap getMap(String[] keys,OrdSrvMmDO[] vs){
		FMap map=new FMap();
		for(int i = 0; i<keys.length; i++){
			map.put(keys[i], vs[i]);
		}
		//返回值
		return map;
	}
	
	/**
	 * 获取费用服务备注
	 * @param id_or
	 * @return
	 */
	private FMap getBlSrvDes(String[] id_srvs){
		GetCiOderBlSrvBP blsrvdesbp=new GetCiOderBlSrvBP();
		try {
			return blsrvdesbp.getCiordBlSrvByIdsrvs(id_srvs);
		} catch (BizException e) {
			e.printStackTrace();
		}
		return null;
	}

}
