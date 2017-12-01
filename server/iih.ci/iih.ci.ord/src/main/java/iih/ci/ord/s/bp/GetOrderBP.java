package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.i.IHpsrvorcaRService;
import iih.bd.srv.medsrv.d.MedSrvRelMmDO;
import iih.bd.srv.medsrv.i.IMedsrvRelMmRService;
import iih.bl.hp.bdhpindicationdto.d.BdHpIndicationDTO;
import iih.ci.ord.ciordems.d.EmsHeadDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.hp.HpService;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.qry.CiorderDrugQry;
import iih.mm.itf.material.d.MaterialDTO;
import iih.mm.itf.material.d.QueryCondDTO;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import iih.mm.itf.material.i.IMaterialService;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetOrderBP {

	static final String fldname = "id_primd";

	public EmsHeadDO exec(String id_srv, CiEnContextDTO ctx) throws BizException{
		return exec(id_srv,ctx.getId_hp(),ctx.getCode_entp(),ctx);
	}
	/**
	 * 页面所需所有信息
	 * 
	 * @param id_srv
	 * @return EmsHeadDO
	 * @throws BizException
	 */
	public EmsHeadDO exec(String id_srv, String id_hp, String code_entp ,CiEnContextDTO ciEnContextDTO)
			throws BizException {
		if (StringUtils.isBlank(id_srv))
			return null;
		EmsHeadDO emsDo = new EmsHeadDO();
		CiorderDrugQry qry = new CiorderDrugQry(id_srv, fldname);
		// 物品单位服务
		IMaterialBaseInfoService materService = ServiceFinder
				.find(IMaterialBaseInfoService.class);
		DAFacade cade = new DAFacade();
		List<EmsOrDrug> mm = (List<EmsOrDrug>) cade.execQuery(
				qry.getQrySQLStr(), new BeanListHandler(EmsOrDrug.class));
		String idsrvs = id_srv.replace("'", "");
		String[] id_srvArray = idsrvs.split(",");
		// 获取医保信息
		Map<String, HPSrvorcaDO> hpMap = null;
		BdHpIndicationDTO[]  hpIndiccation = null;
		//TODO：医保信息调整后改动
	
		 

		FArrayList list = new FArrayList();
		List<String> mmIds = new ArrayList<String>();
		for(EmsOrDrug drug :mm){
			if(!CiOrdUtils.isEmpty(drug.getId_mm())){
				mmIds.add(drug.getId_mm());
			}
		}
		MaterialUnitDTO[] materUnit=null;
		if(mmIds.size()>0){
			materUnit = materService.getMMunitByEntp(mmIds.toArray(new String[mmIds.size()]), code_entp);
		}
		for (EmsOrDrug object : mm) {
			/*if (hpMap != null && hpMap.size() != 0) {
				object.setName_hp(hpMap.get(object.getId_srv()).getName());// 医保
				object.setLimit(hpMap.get(object.getId_srv()).getDes());// 报销限制条件
*/				// TODO:单次剂量 =医学单位值/系数 单次数量应该改为 string类型
				// 根据物品和单位类型参数配置 获取物品的单位集合
				//关于医保信息，一个服务一个一医保信息（多个物品暂时不考虑）
			if(ciEnContextDTO != null && ciEnContextDTO.getId_hp() != null && ciEnContextDTO.getId_hp() !=""&&FBoolean.TRUE==ciEnContextDTO.getFg_hpfundpay()
					&& ciEnContextDTO.getEu_hpbeyond() != null && ciEnContextDTO.getEu_hpbeyond().equals("0")){
				  //hpMap = findHps(id_hp, id_srvArray);
				  hpIndiccation =  HpService.getMedSrvHpService(id_srv,object.getId_mm(), ciEnContextDTO);
			   
				if(hpIndiccation != null && hpIndiccation.length >0){
					object.setFg_treat(hpIndiccation[0].getFg_indic());
					if(!CiOrdUtils.isEmpty(object.getFg_treat())&&!object.getFg_treat().booleanValue()){
						object.setFg_selfpay(FBoolean.TRUE);
					}else{
						object.setFg_selfpay(FBoolean.FALSE);
					}
					object.setLimit(hpIndiccation[0].getDes_hplimit());
					object.setId_hp(id_hp);
					object.setSd_hpsrvtp(hpIndiccation[0].getSd_hpsrvtp());
					if(!CiOrdUtils.isEmpty(object.getSd_hpsrvtp())){
						object.setId_hpsrvtp(CiOrdUtils.idHpSrvtpFromSdHpSrvtp(object.getSd_hpsrvtp()));
					}
					//object.setId_hpsrvtp(hpIndiccation[0].getId_hpsrvtp());
					//object.setName_hp(hpIndiccation[0].);
					object.setBdHpIndicationDTO(new FArrayList().append(hpIndiccation[0]));
				}
				}else{
					object.setFg_selfpay(FBoolean.TRUE);
				}
				
			//}
			// if(object.getQuan_med()!=null && object.getFactor_mb()!=null){
			// DecimalFormat df = new DecimalFormat("0.00");
			// double
			// t=(object.getQuan_med().toDouble()/object.getFactor_mb().toDouble());
			// object.setQuan_base(new FDouble(df.format(t)));
			// }
			// 总量单位不使用
			// @SuppressWarnings("unused")
			// String unittype=getUnitParam.getUnitParam(null,
			// ICiOrdSysParamConst.SYS_PARAM_IPPKGUTP);
			/*
			 * if(unittype!=null) { unittype= "'"+ unittype.replaceAll(",",
			 * "','")+"'"; }
			 */
			// @SuppressWarnings("unchecked")
			// List<EmsOrDrug> unitList = (List<EmsOrDrug>)
			// cade.execQuery(qry.GeUnitByMmAndParmSQL(object.getId_mm(),unittype),new
			// BeanListHandler(EmsOrDrug.class));
			if (object.getFg_mm().booleanValue() && object.getId_mm() == null)
				throw new BizException(object.getName_srv()
						+ " 没有绑定物品 或者 物品没有启用");
			if (object.getFg_mm().booleanValue() && object.getId_mm() != null) {
				if (materUnit != null && materUnit.length > 0) {
					String strUnit = "";
					int i = 0;
					String ids = "",names="",factors="";
					for (MaterialUnitDTO dto : materUnit) {
						if(object.getId_mm().equals(dto.getId_mm())){
							if (i == 0) {
								object.setId_unit_sale(dto.getId_measdoc());
								object.setFactor_cb(dto.getFactor());//基本包装单位和总量单位间的换算系数
								object.setName_unit_sale(dto.getMeasdoc_name());
								object.setPrice(dto.getPrice());//单价
							}
							ids+= "," + dto.getId_measdoc();
							names+=","+dto.getMeasdoc_name();
							if(CiOrdUtils.isEmpty(dto.getFactor())){
								factors+=",1";
							}else{
								factors+=","+dto.getFactor();
							}
							i++;
							strUnit += ",'" + dto.getId_measdoc() + "'";
						}
					}

					if (strUnit == "")
						throw new BizException(" 物品" + object.getName_mm()
								+ "没有对应的单位");

					object.setStr_unit_pkg_ids(strUnit.substring(1));
					FMap fmap = new FMap();
					if(!CiOrdUtils.isEmpty(ids)){
						fmap.put(ICiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_ID_MEASDOC, ids.substring(1));
						
					}
					if(!CiOrdUtils.isEmpty(names)){
						fmap.put(ICiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_MEASDOC_NAME, names.substring(1));
					}
					if(!CiOrdUtils.isEmpty(factors)){
						fmap.put("factor", factors.substring(1));
					}
					object.setRelativefieldmap(fmap);
					// object.setName_unit_sale(unitList.get(0).getName_unit_sale());
					// object.setId_unit_sale(unitList.get(0).getId_unit_sale());
					// object.setName_unit_med(unitList.get(0).getName_unit_med());
					// object.setId_unit_med(unitList.get(0).getId_unit_med());
				}
			} else {
				object.setStr_unit_pkg_ids(object.getId_unit_med());
				FMap fmap = new FMap();
				fmap.put(ICiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_ID_MEASDOC,object.getId_unit_med());
				fmap.put(ICiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_MEASDOC_NAME,object.getName_unit_med());
				object.setRelativefieldmap(fmap);
			}

			list.add(object);
		}
		
		emsDo.setEmsdrugitems(list);

		return emsDo;

	}

	public EmsOrDrug[] getMmByMmtp(String mmtp) throws BizException {
		if (StringUtils.isBlank(mmtp))
			return null;
		CiorderDrugQry qry = new CiorderDrugQry(mmtp);

		DAFacade cade = new DAFacade();
		List<EmsOrDrug> mm = (List<EmsOrDrug>) cade.execQuery(
				qry.getMmByMmtp(), new BeanListHandler(EmsOrDrug.class));
		// String[] id_srvArray=id_srv.split(",");
		// 获取医保信息
		// Map<String,HpSrvOrCaDO> hpMap=findHps(id_hp,id_srvArray);

		// FArrayList list = new FArrayList();
		// for (EmsDrugItemDO object : mm) {
		// object.setName_heath(hpMap.get(object.getId_srv()).getName());//医保
		// object.setLimit(hpMap.get(object.getId_srv()).getDes());//报销限制条件
		// list.add(object);
		// }
		// emsDo.setEmsdrugitems(list);

		return mm.toArray(new EmsOrDrug[0]);

	}

	/**
	 * 获取通用药品信息
	 * 
	 * @param id_org
	 * @param id_srv
	 * @param id_dept_mp
	 * @param id_dept_phy
	 * @param id_hp
	 * @return
	 * @throws BizException
	 */
	public EmsOrDrug[] getSrvVsMm(String id_org, String id_srvs,
			String id_dept_mp, String id_dept_phy, String id_hp)
			throws BizException {
		if (id_org == null || id_srvs == null || id_dept_mp == null
				|| id_dept_phy == null || id_hp == null) {
			return null;
		}
		String[] id_srvArray = id_srvs.split(",");
		List<EmsOrDrug> mmlist = new ArrayList<EmsOrDrug>();
		// 服务关联物品id集合
		Map<String, Map<String, MedSrvRelMmDO>> mmMaps = getMmids(id_srvArray);
		StringBuffer mms = new StringBuffer("");
		for (String id_srv : mmMaps.keySet()) {
			Map<String, MedSrvRelMmDO> srvMap = mmMaps.get(id_srv);
			if (srvMap == null)
				continue;
			for (String id_mm : srvMap.keySet()) {
				// id_mms+=id_mm+",";
				mms.append(id_mm + ",");
			}
			if (mms.length() > 2) {
				mms.deleteCharAt((mms.length() - 2));
			}
		}

		QueryCondDTO conditio = new QueryCondDTO();
		conditio.setId_org(id_org);
		// conditio.setId_mms(id_mms);
		conditio.setId_mms(mms.toString());
		conditio.setId_whs(id_dept_mp);
		conditio.setId_dept(id_dept_phy);
		// 获取物品信息
		MaterialDTO[] mmdtos = findMm(conditio);
		// 获取医保信息
		Map<String, HPSrvorcaDO> hpMap = findHps(id_hp, id_srvArray);

		if (mmdtos.length != 0) {
			for (String id_srv : id_srvArray) {
				for (MaterialDTO dto : mmdtos) {
					EmsOrDrug mm = new EmsOrDrug();
					if(hpMap != null){
						mm.setName_heath(hpMap.get(id_srv).getName());// 医保
						mm.setLimit(hpMap.get(id_srv).getDes());// 报销限制条件
					}
					mm.setId_srv(id_srv);
					mm.setName_mm(dto.getName());
					mm.setId_mm(dto.getId_mm());
					mm.setSpec_mm(dto.getSpec());
					mm.setVender(dto.getName_sup());
					mm.setPrice(dto.getPrice_sale());
					mm.setFactor_cb(dto.getFactor_sb());
					mm.setFactor_mb(dto.getFactor_mb());
					mm.setId_unit_sale(dto.getSale_pkgu_id());
					mm.setName_unit_sale(dto.getSale_pkgu_name());
					mm.setId_unit_base(dto.getBase_pkgu_id());
					mm.setName_unit_base(dto.getBase_pkgu_name());
					mm.setFact_count(dto.getStock_num());// 库存
					mm.setFg_skintest(dto.getFg_skin());// 皮试标志
					mm.setSortno(mmMaps.get(id_srv).get(dto.getId_mm())
							.getSortno());
					mm.setSd_dosage(dto.getSd_dosage());// 药品剂型
					mm.setSd_pharm(dto.getSd_pharm());// 药品分类
					mm.setSd_pois(dto.getSd_pois());// 毒麻药分类
					mm.setSd_anti(dto.getSd_anti());// 抗菌药分类
					mm.setSd_mmtp(dto.getSd_mmtp());// 物品分类
					// mm.setSd_val();//价值分类
					// mm.setSd_antipsy();//抗精神分类
					mmlist.add(mm);
				}
			}
		}

		return mmlist.toArray(new EmsOrDrug[0]);
	}

	/**
	 * 根据服务id和医保类型查找医保DO
	 * 
	 * @param hpCode
	 * @param idSrv
	 * @return HpSrvOrCaDO
	 * @throws BizException
	 */
	public HPSrvorcaDO findHp(String id_hp, String id_Srv) throws BizException {
		IHpsrvorcaRService hpService=(IHpsrvorcaRService)ServiceFinder.find(IHpsrvorcaRService.class.getName());
		if(id_hp== null || id_hp =="") return null;
		String whereStr = HPSrvorcaDO.ID_HP +"='"+id_hp+"' and  "+ HPSrvorcaDO.ID_SRV +" ='"+id_Srv+"'";
		HPSrvorcaDO[] orca =  hpService.find(whereStr,HPSrvorcaDO.ID_HPSRVTP,FBoolean.FALSE);
		if(orca != null && orca.length >0){
			return orca[0];
		}else{
			throw new BizException("没有找医保信息");
		}
	}

	public Map<String, HPSrvorcaDO> findHps(String id_hp, String[] id_srvs)
			throws BizException {
		// return hpService.getHpSrvTpByCode(hpCode,id_Srv);
         if(id_hp == null || id_hp ==""||(CiOrdUtils.isEmpty(id_srvs))) return null;
         String idsrvs="",idmms="";
         if(!CiOrdUtils.isEmpty(id_srvs)){
        	 idsrvs = CiOrdUtils.SQUOTE_MARK_STR+id_srvs.toString().replaceAll(CiOrdUtils.COMMA_STR,CiOrdUtils.SQUOTE_MARK_STR+ CiOrdUtils.COMMA_STR+CiOrdUtils.SQUOTE_MARK_STR)+CiOrdUtils.SQUOTE_MARK_STR;
         }
//         if(!CiOrdUtils.isEmpty(id_mms)){
//        	 idmms = CiOrdUtils.SQUOTE_MARK_STR+id_mms.toString().replaceAll(CiOrdUtils.COMMA_STR,CiOrdUtils.SQUOTE_MARK_STR+ CiOrdUtils.COMMA_STR+CiOrdUtils.SQUOTE_MARK_STR)+CiOrdUtils.SQUOTE_MARK_STR;
//         }
		IHpsrvorcaRService hpService=(IHpsrvorcaRService)ServiceFinder.find(IHpsrvorcaRService.class.getName());
		String whereStr = HPSrvorcaDO.ID_HP +"='"+id_hp+"' and  "+ HPSrvorcaDO.ID_SRV +" in ("+idsrvs+")";
		HPSrvorcaDO[] orca =  hpService.find(whereStr,HPSrvorcaDO.ID_HPSRVTP,FBoolean.FALSE);
		Map<String, HPSrvorcaDO> hpMap = new HashMap<String, HPSrvorcaDO>();
		if (!CiOrdUtils.isEmpty(orca)) {
			for (HPSrvorcaDO hpdo : orca) {
				if (hpdo == null)
					continue;
				hpMap.put(hpdo.getId_srv(), hpdo);
			}
		}
		return hpMap;
	}

	/**
	 * 调用物品信息
	 * 
	 * @return
	 * @throws BizException
	 */
	public MaterialDTO[] findMm(QueryCondDTO conditio) throws BizException {
		IMaterialService mmService = (IMaterialService) ServiceFinder
				.find(IMaterialService.class.getName());
		MaterialDTO[] mmdto = mmService.query(conditio);
		return mmdto;
	}

	/**
	 * 查询服务关联的物品
	 * 
	 * @param id_srv
	 * @return MedSrvRelMmDO[]
	 * @throws BizException
	 */
	public Map<String, Map<String, MedSrvRelMmDO>> getMmids(String[] id_srvs)
			throws BizException {
		IMedsrvRelMmRService hpService = (IMedsrvRelMmRService) ServiceFinder
				.find(IMedsrvRelMmRService.class.getName());
		Map<String, Map<String, MedSrvRelMmDO>> maps = new HashMap<String, Map<String, MedSrvRelMmDO>>();

		for (String id : id_srvs) {
			Map<String, MedSrvRelMmDO> map = new HashMap<String, MedSrvRelMmDO>();
			MedSrvRelMmDO[] mms = hpService.find("a11.id_srv='" + id + "'",
					"sortno", FBoolean.FALSE);
			for (MedSrvRelMmDO mm : mms) {
				map.put(id, mm);
			}
			maps.put(id, map);
		}
		return maps;
	}
}
