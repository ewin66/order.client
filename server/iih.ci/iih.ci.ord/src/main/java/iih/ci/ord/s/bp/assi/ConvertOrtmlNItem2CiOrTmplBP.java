package iih.ci.ord.s.bp.assi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.tmpl.d.CiOrTmplDTO;
import iih.ci.ord.tmpl.d.CiOrTmplSrvDTO;
import iih.ci.ord.tmpl.d.LongTempOrEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 将OrTplNItmDO对象集合 转换为标准医嘱模板CiOrTmplDTO对象集合 BP
 * 
 * @author HUMS
 *
 */
public class ConvertOrtmlNItem2CiOrTmplBP {

	// 数据来源	
	private String eu_orsrcmdtp;

	public ConvertOrtmlNItem2CiOrTmplBP(String eu_orsrcmdtp) {
		this.eu_orsrcmdtp = eu_orsrcmdtp;
	}

	public List<CiOrTmplDTO> exec(OrTplNItmDO[] orTplNItms) throws BizException {
		return this.getCiortmplAggDTO(orTplNItms);
	}

	/**
	 * 医嘱助手-医嘱模板映射成逻辑的医嘱模板
	 * 
	 * @param ortplItemDO
	 * @return
	 * @throws BizException
	 */
	private List<CiOrTmplDTO> getCiortmplAggDTO(OrTplNItmDO[] orTplNItms) throws BizException {
		if (orTplNItms == null || orTplNItms.length == 0)
			return null;
		// 医嘱模板
		FMap2 map = OrtemplateGrouping(orTplNItms);
		if (map == null || map.size() == 0)
			return null;
		
		List<CiOrTmplDTO> tmpList = new ArrayList<CiOrTmplDTO>();
		//医嘱模板的优化
		@SuppressWarnings("unchecked")
		List<String> ortmplList = (List<String>) map.get("ortmplList");
		Map<String,OrTmplDO> ortmplDOMap = OptimaizationOrTplNItmDO(ortmplList);
		map.remove("ortmplList");
		for (Object list : map.values()) {
			@SuppressWarnings("unchecked")
			List<OrTplNItmDO> temp = (List<OrTplNItmDO>) list;
			if (temp != null && temp.size() > 0) {
				FArrayList srvlist = new FArrayList();
				CiOrTmplDTO aggdto = new CiOrTmplDTO();
				OrTplNItmDO orTplItem = temp.get(0);
				// 映射医嘱
				MappingFieldOrder(aggdto, orTplItem, ortmplDOMap);

				String strIdsrv = "";
				for (OrTplNItmDO itmDO : temp) {
					strIdsrv += ",'" + itmDO.getId_srv() + "'";
				}
				
				GetMedsrvQry qry = new GetMedsrvQry(strIdsrv.substring(1));
				MedSrvDO[] medSrvDOs = (MedSrvDO[]) AppFwUtil.getDORstWithDao(qry, MedSrvDO.class);
				
				Map<String, MedSrvDO> mapMedSrvDOs = new HashMap<String, MedSrvDO>();
				for (MedSrvDO srvDO : medSrvDOs) {
					if (!mapMedSrvDOs.containsKey(srvDO.getId_srv())) {
						mapMedSrvDOs.put(srvDO.getId_srv(), srvDO);
					}
				}

				for (int i = 0; i < temp.size(); i++) {
					// 映射医嘱的项目
					srvlist.append(MappinfieldOrderSrv(aggdto, temp.get(i), mapMedSrvDOs.get(orTplItem.getId_srv())));

				}
				aggdto.setOrtmplsrvs(srvlist);
				tmpList.add(aggdto);
			}
		}

		return tmpList;
	}
	
	/**
     * 医嘱项目 一个医嘱模板的 是一条医嘱
     * @param map
     * @param ortplItemDO
     * @throws BizException
     */
	@SuppressWarnings("unchecked")
	private FMap2 OrtemplateGrouping(OrTplNItmDO[] ortplItems)
			throws BizException {
		FMap2 map = new FMap2();
		List<OrTplNItmDO> itemlist = null;
		List<String> ortmplList = new ArrayList<String>();
		for (OrTplNItmDO item : ortplItems) {
			ortmplList.add(item.getId_ortmpl());
			String key = item.getId_ortmpl() + item.getIdentical_ortmpl() + item.getSd_srvtp().substring(0, 2);
			if (map.containsKey(key)) {
				itemlist = (List<OrTplNItmDO>) map.get(key);
				itemlist.add(item);
			} else {
				List<OrTplNItmDO> temp = new ArrayList<OrTplNItmDO>();
				temp.add(item);
				map.put(key, temp);
			}
		}
		map.put("ortmplList", ortmplList);
		return map;
	}

	/**
	 * 查询出医嘱模板集合
	 * 
	 * @param map
	 * @return
	 * @throws BizException
	 */
	private Map<String,OrTmplDO> OptimaizationOrTplNItmDO(List<String> list) throws BizException {
		if (list == null || list.size() == 0)
			return null;
		Map<String,OrTmplDO> orTemplmap = new HashMap<String,OrTmplDO>();
		String[] ids = list.toArray(new String[0]);
		OrTmplDO[] ortmpl = CiOrdAppUtils.getIOrtmplMDORService().findByIds(ids, FBoolean.FALSE);
		if (ortmpl != null && ortmpl.length > 0) {
			for (OrTmplDO ortmplDO : ortmpl) {
				orTemplmap.put(ortmplDO.getId_ortmpl(), ortmplDO);
			}
		}
		return orTemplmap;
	}

	/**
	 * 套本身
	 * 
	 * @param ortmpl
	 * @return
	 * @throws BizException
	 */
	private OrTplNItmDO MappingOrSetItem(OrTplNItmDO orTplItem) throws BizException {
		MedSrvDO medsrvDO = CiOrdAppUtils.getMedsrvMDORService().findById(orTplItem.getId_srv());
		if (medsrvDO != null) {
			OrTplNItmDO item = new OrTplNItmDO();
			item.setId_srv(medsrvDO.getId_srv());
			item.setOrtplnitm_srv_name(medsrvDO.getName());
			item.setId_ortmpl(orTplItem.getId_ortmpl());
			item.setId_boil(medsrvDO.getId_boil());
			item.setId_boildes(medsrvDO.getId_boildes());
			item.setQuan_med(medsrvDO.getQuan_med());
			item.setId_freq(medsrvDO.getId_freq());
			//item.setId_mm(medsrvDO.getId_mm);
			item.setId_ortmplitm(medsrvDO.getId_srv());
			item.setId_route(medsrvDO.getId_route());
			item.setId_routedes(medsrvDO.getId_routedes());
			item.setId_srvtp(medsrvDO.getId_srvtp());
			item.setSd_srvtp(medsrvDO.getSd_srvtp());
			item.setId_unit_med(medsrvDO.getId_unit_med());
			item.setOrtplnitm_boildes_name(medsrvDO.getBoil_name());
			item.setOrtplnitm_freq_name(medsrvDO.getFreq_name());
			item.setOrtplnitm_route_name(medsrvDO.getRoute_name());
			item.setOrtplnitm_routedes_name(medsrvDO.getRoutedes_name());
			item.setOrtplnitm_unit_name(medsrvDO.getMed_name());
			return item;
		}
		return null;
	}

	/**
	 * 医嘱 字段映射
	 * 
	 * @param dto
	 * @param orTplItem
	 */
	private void MappingFieldOrder(CiOrTmplDTO dto, OrTplNItmDO orTplItem, Map<String,OrTmplDO> ortmplDOMap) throws BizException {

		//OrTmplDO orTmplDO = CiOrdAppUtils.getIOrtmplMDORService().findById(orTplItem.getId_ortmpl());
		OrTmplDO orTmplDO = ortmplDOMap.get(orTplItem.getId_ortmpl());
		// dto.setId_ciortmpl(orTplItem.getId_ciortmpl());//临床医嘱模板主键标识
		// dto.setOrtmplsrvs(orTplItem.getOrtmplsrvs());//医嘱模板项目列表
		dto.setEu_orsrcmdtp(this.eu_orsrcmdtp);// 临床医嘱来源类型
		dto.setId_orsrc_main(orTplItem.getId_ortmpl());// 来源ID_主 医嘱模板主表
		dto.setId_orsrc_sub(orTplItem.getId_ortmplitm());// 来源ID_子 医嘱模板明细
		
		dto.setCode(orTplItem.getOrtplnitm_srv_code());// 编码
		// tId_srv_set 计算字段，前台赋值
		if (orTplItem.getId_srv_set() != null && orTplItem.getId_srv_set() != "") {
			//dto.setName(orTplItem.getOrtplnitm_mm_name());// 名称
			dto.setId_srv(orTplItem.getId_srv_set());//   套 id
			dto.setFg_set(FBoolean.TRUE);
		} else {
			dto.setName(orTplItem.getOrtplnitm_srv_name());// 名称
			dto.setId_srv(orTplItem.getId_srv());
			dto.setFg_set(FBoolean.FALSE);
		}

		if(orTmplDO != null){
			dto.setDes_or(orTmplDO.getDes());
		} 
		dto.setId_srvtp(orTplItem.getId_srvtp());// 医嘱类型
		dto.setSd_srvtp(orTplItem.getSd_srvtp());// 医嘱类型编码
		dto.setEu_long(LongTempOrEnum.TEMPORARYOR);// 长期临时类型
		dto.setId_freq(orTplItem.getId_freq());// 医嘱频次
		dto.setId_route(orTplItem.getId_route());// 用法
		dto.setId_routedes(orTplItem.getId_routedes());// 用法要求
		dto.setId_boil(orTplItem.getId_boil());// 煎法
		dto.setId_boildes(orTplItem.getId_boildes());// 煎法要求
		dto.setDays_or(orTplItem.getDays_or());// 医嘱天数
		dto.setOrders(orTplItem.getOrders());// 医嘱付数
		// dto.setFg_boil(orTemplateDO.getfg);//代煎标识

		if (dto.getDays_or() == null) {
			dto.setDays_or(orTmplDO != null && orTmplDO.getDays_or() != null ? orTmplDO.getDays_or() : 1);// 医嘱天数
		  }

		// 草药设置医嘱付数
		if (CiOrdUtils.isHerbOrder(dto.getSd_srvtp()) && dto.getOrders() == null) {
			dto.setOrders(orTmplDO != null && orTmplDO.getOrders() != null ? orTmplDO.getOrders() : 7);// 医嘱付数
		}
	}

	/**
	 * 映射医嘱的项目
	 * 
	 * @param aggDTO
	 * @param orTplItem
	 */
	private CiOrTmplSrvDTO MappinfieldOrderSrv(CiOrTmplDTO ciOrtemplateDTO, OrTplNItmDO orTplItem, MedSrvDO medSrvDO) throws BizException {

		CiOrTmplSrvDTO srvDTO = new CiOrTmplSrvDTO();
		// srvDTO.setId_ciortmplsrv(orTplItem.getId_ciortmplsrv());//临床医嘱模板项目主键标识
		// srvDTO.setId_ciortmpl(orTplItem.getId_ciortmpl());//临床医嘱模板
		srvDTO.setSortno(orTplItem.getSortno());// 序号
		srvDTO.setId_srv(orTplItem.getId_srv());// 服务
		// srvDTO.setOrtplnitm_srv_name(orTplItem.getOrtplnitm_srv_name());
		// srvDTO.setFg_selfsrv(medSrvDO.getFg_selfsrv());//自定义服务标识
		// srvDTO.setName_selfsrv(medSrvDO.get);//自定义服务名
		srvDTO.setFg_set(medSrvDO.getFg_set());// 套标识
		srvDTO.setId_srvtp(orTplItem.getId_srvtp());// 服务类型
		srvDTO.setSd_srvtp(orTplItem.getSd_srvtp());// 服务类型编码
		srvDTO.setId_freq(StringUtils.isNullOrEmpty(orTplItem.getId_freq())?
				medSrvDO.getId_freq():orTplItem.getId_freq());// 频次
		srvDTO.setId_route(StringUtils.isNullOrEmpty(orTplItem.getId_route())?
				medSrvDO.getId_route():orTplItem.getId_route());// 用法
		srvDTO.setId_routedes(StringUtils.isNullOrEmpty(orTplItem.getId_routedes())?
				medSrvDO.getId_routedes():orTplItem.getId_routedes());// 要求
		srvDTO.setId_boil(StringUtils.isNullOrEmpty(orTplItem.getId_boil())?
				medSrvDO.getId_boil():orTplItem.getId_boil());// 煎法
		srvDTO.setId_boildes(StringUtils.isNullOrEmpty(orTplItem.getId_boildes())?
				medSrvDO.getId_boildes():orTplItem.getId_boildes());// 中医要求
		srvDTO.setId_unit_med(StringUtils.isNullOrEmpty(orTplItem.getId_unit_med())?
				medSrvDO.getId_unit_med():orTplItem.getId_unit_med());// 医学单位
		srvDTO.setQuan_med(orTplItem.getQuan_med() == null?
				medSrvDO.getQuan_med():orTplItem.getQuan_med());// 医学单位数值
		// srvDTO.setQuan_total_medu(orTplItem.getQuan_total_medu());//服务总量
		srvDTO.setQuan_total_medu(orTplItem.getQuan_med());// todo
		srvDTO.setId_dep_mp(orTplItem.getId_dep_mp());// 执行科室
		srvDTO.setId_mm(orTplItem.getId_mm());// 关联物品

		// srvDTO.setSrvsetitms(orTplItem.getSrvsetitms());//套内项目集合
		return srvDTO;
	}

}
