/**  
 * Project Name:iih.ci.ord  
 * File Name:DiagSaveBP.java  
 * Package Name:iih.ci.ord.s.ems.biz.op.diag  
 * Date:2017年8月11日下午12:53:48  
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
/**  
 * Project Name:iih.ci.ord  
 * File Name:DiagSaveBP.java  
 * Package Name:iih.ci.ord.s.ems.biz.op.diag  
 * Date:2017年8月11日下午12:53:48  
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.  
 *  
 */  
  
package iih.ci.ord.s.ems.biz.op.diag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.xbd.udi.d.UdidocDO;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.hp.bdhpindicationdto.service.i.IHpQueService;
import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.cidiag.d.desc.CiDiagDODesc;
import iih.ci.diag.cidiag.i.ICidiagCudService;
import iih.ci.diag.cidiag.i.ICidiagMDORService;
import iih.ci.diag.cidiag.i.ICidiagRService;
import iih.ci.diag.dto.d.DIDTO;
import iih.ci.diag.i.ICidiagMaintainService;
import iih.ci.ord.ciorder.d.HpBeyondEnum;
import iih.ci.ord.d.ems.di.DiagRstDTO;
import iih.ci.ord.d.ems.di.DiagSaveDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.s.ems.biz.op.base.bp.DiagBaseSaveBP;
import iih.ci.ord.s.ems.biz.utils.DiagFireEventUtils;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.entdi.i.IEntdiCudService;
import iih.en.pv.entdi.i.IEntdiRService;


/**
 * 
 * ClassName: DiagSaveBP <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason: TODO ADD REASON(可选). <br/>  
 * date: 2017年8月11日 下午12:53:59 <br/>  
 *  
 * @author wangqingzhu  
 * @version   
 * @since JDK 1.8
 */
public class DiagSaveBP extends DiagBaseSaveBP {
	/**
	 * 诊断体系缓存map
	 */
	private Map<String,UdidocDO> diagSysMap;
	@Override
	public DiagRstDTO save(DiagSaveDTO diSaveInfo) throws BizException {
		FArrayList doucumentlist=diSaveInfo.getDocument();
		if(doucumentlist==null || doucumentlist.size()<0)return null;
		//诊断体系
		if(diagSysMap==null){
			getUdidocMap();
		}
		//创建诊断AggDO
		CidiagAggDO aggdo=creatDiAggInfo(doucumentlist,diSaveInfo.getEnContext());
		// 诊断保存
		CidiagAggDO[] ret=getICidiagCudService().save( new CidiagAggDO[]{aggdo});

		//删除就诊域的原由的诊断
		EntDiDO[] entDiDOs = getIEntdiRService().find(
				"a0.id_ent ='" + aggdo.getParentDO().getId_en() + "'", "id_ent", FBoolean.FALSE);
		if (entDiDOs != null && entDiDOs.length > 0) {
			getIEntdiCudService().delete(entDiDOs);
		}
		//保存就诊的当前诊断
		EntDiDO[] entdidos=getEntDiDO(aggdo.getParentDO().getId_en());
		if(entdidos!=null)getIEntdiCudService().save(entdidos);
		//诊断的集成平台事件
		DiagFireEventUtils.IEDiagFireEvent(ret[0]);
		DiagRstDTO rst=new DiagRstDTO();
		FArrayList agglist=new FArrayList();
		agglist.add(aggdo);
		rst.setDocument(agglist);
		return rst;
	}
	/**
	 * 创建诊断AggDo
	 * @param doucumentlist
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	private CidiagAggDO creatDiAggInfo(FArrayList doucumentlist,CiEnContextDTO ctx) throws BizException{
		DIDTO diDTO=(DIDTO)doucumentlist.get(0);
		CidiagAggDO agg = new CidiagAggDO();
		if(StringUtils.isNotEmpty(diDTO.getId_didef())){
			List<String> idDiDefList=new ArrayList<String>();
			List<CiDiagItemDO> itemlist=new ArrayList<CiDiagItemDO>();
			StringBuffer des = new StringBuffer();//诊断描述
			//非空诊断保存
			if (StringUtils.isNotEmpty(diDTO.getId_di())) {
				//新增
				CiDiagDO parentdo=new CiDiagDO();
				mergeCiDiagDOInfo(diDTO,parentdo);
				agg.setParentDO(parentdo);

				for(Object obj:doucumentlist){
					DIDTO dto=(DIDTO)obj;
					CiDiagItemDO itemdo=new CiDiagItemDO();
					mergeCiDiagItemDOInfo(dto,itemdo);
					itemlist.add(itemdo);
					idDiDefList.add(dto.getId_didef());
					des.append(getDiagDes(itemdo));
				}
			}else{
				//编辑
				agg=getICidiagRService().findById(diDTO.getId_di());
				mergeCiDiagDOInfo(diDTO,agg.getParentDO());
				Map<String, CiDiagItemDO> diitemmap =getCidiItemKeyValue(agg.getCiDiagItemDO());
				CiDiagItemDO itemdo=new CiDiagItemDO();
				for(Object obj:doucumentlist){
					DIDTO dto=(DIDTO)obj;
					if (dto.getId_diitm() != null) {
						if (diitemmap.containsKey(dto.getId_diitm())) {
							itemdo = diitemmap.get(dto.getId_diitm());
							itemdo.setStatus(DOStatus.UPDATED);
							diitemmap.remove(dto.getId_diitm());
						} else {
							itemdo = new CiDiagItemDO();
							//ciDiagitem.setId_diitm(item.getId_diitm());
							itemdo.setStatus(DOStatus.NEW);
						}

					} else {
						itemdo.setStatus(DOStatus.NEW);
					}
					mergeCiDiagItemDOInfo(dto,itemdo);
					itemlist.add(itemdo);
					idDiDefList.add(dto.getId_didef());
					des.append(getDiagDes(itemdo));
				}
				
			}

			//诊断描述
			agg.getParentDO().setDes_di(des.toString());
			// 获取保外诊断判断结果，key值诊断定义id， value true 保内诊断，Y 保外诊断
			String idDidefs[] = idDiDefList.toArray(new String[idDiDefList.size()]);
			Map<String, FBoolean> map = null;
			setDiagItemHpTp(map,idDidefs,agg.getCiDiagItemDO(),ctx, diDTO.getId_entp());
			StringBuffer idDidefHpExt=new StringBuffer();
			if (map != null && map.size() > 0) {
				for (Object obj : doucumentlist) {
					DIDTO didto=(DIDTO)obj;
					// 判断是否存在保外诊断
					if (map.containsKey(didto.getId_didef()) && map.get(didto.getId_didef()) == FBoolean.FALSE) {
						didto.setEu_hpbeyond(HpBeyondEnum.HPEXTERNALDIAG);
						idDidefHpExt.append("," + didto.getId_didef());
					}
				}
			}
			if(itemlist.size()>0)agg.setCiDiagItemDO(itemlist.toArray(new CiDiagItemDO[itemlist.size()]));
			//签署
			if (diDTO.getFg_sign().isValue()) {
				if (idDidefHpExt.length() > 0) {
					//判断是否有医嘱  有是有使用的诊断
					ctx.setDes_bhpjudgerst(idDidefHpExt.toString().substring(1));
					getICiOrdMaintainService().updateCiOrderBhpjudgerst(ctx);
				}
			}
		}else{
			//空诊断保存
			CiDiagDO parentdo=new CiDiagDO();
			mergeCiDiagDOInfo(diDTO,parentdo);
			agg.setParentDO(parentdo);
		}
		return agg;
	}

	
	//诊断项目的 key  value
		private Map<String, CiDiagItemDO> getCidiItemKeyValue(CiDiagItemDO[] ciditem){
			if (ciditem == null)
				return null;
			Map<String, CiDiagItemDO> map = new HashMap<String, CiDiagItemDO>();
			for (CiDiagItemDO item : ciditem) {
				map.put(item.getId_diitm(), item);
			}
			return map;
		}
	

	/**
	 * 取得就诊的当前诊断
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	private  EntDiDO[] getEntDiDO(String id_en) throws BizException{

		CidiagAggDO[] aggs =  getCiDiCurrent(id_en);
		List<EntDiDO> entdis = new ArrayList<EntDiDO>();
		if(aggs != null){
			boolean Fg_maj = false;
			for(CidiagAggDO agg:aggs){
				int i = 0;
				if (agg.getCiDiagItemDO() != null && agg.getCiDiagItemDO().length > 0) {
					for (CiDiagItemDO item : agg.getCiDiagItemDO()) {
						EntDiDO entdi = new EntDiDO();
						entdi.setId_org(agg.getParentDO().getId_org());
						entdi.setId_grp(agg.getParentDO().getId_grp());
						entdi.setId_ent(agg.getParentDO().getId_en());
						entdi.setId_didef_dis(item.getId_didef());
						entdi.setName_didef_dis(item.getId_didef_name());
						entdi.setSupplement(item.getSupplement());
						entdi.setId_ditp(agg.getParentDO().getId_ditp());
						entdi.setSd_ditp(agg.getParentDO().getSd_ditp());
						entdi.setId_didef_syn(item.getId_didef_syn());
						entdi.setName_didef_syn(item.getDidef_syn_name());
						entdi.setId_dep(Context.get().getDeptId());
						entdi.setName_bddi(item.getId_didef_name());
						entdi.setDt_diag(agg.getParentDO().getDt_di());
						entdi.setId_diitm(item.getId_diitm());
						entdi.setId_emp_phy(agg.getParentDO().getId_emp_sign());
						entdi.setSd_cdsystp(item.getSd_disys());
						entdi.setId_cdsystp(item.getId_disys());
						entdi.setFg_chronic(item.getFg_chronic());
						entdi.setFg_special(item.getFg_special());
						if (item.getId_didef_code() != null) {
							entdi.setCode_didef_dis(item.getId_didef_code());
						} else {
							entdi.setCode_didef_dis(item.getId_didef_syn_code());
						}

						entdi.setSortno(i);
						entdi.setId_parent(item.getId_parent());
						entdi.setInnercode(item.getInnercode());
						entdi.setFg_self(item.getFg_self());
						entdi.setId_di(item.getId_di());
						//entdi.setDes(dto.getSupply());
						//只有一个主诊断
						if (item.getFg_majdi().booleanValue() && !Fg_maj) {
							entdi.setFg_maj(item.getFg_majdi());
							Fg_maj = true;
						} else {
							entdi.setFg_maj(item.getFg_majdi());
						}

						//entdi.setFg_flupci(dto.getFg_flupci());
						//item.setFg_infedi(entdi.get);
						entdi.setFg_suspdi(item.getFg_suspdi());
						//entdi.setFg_sym(dto.getFg_sym());
						//entdi.setDes_di(agg.getParentDO().getDes_di());
						entdi.setId_infectiontp(item.getId_infectiontp());
						entdi.setSd_infectiontp(item.getSd_infectiontp());
						entdi.setStatus(DOStatus.NEW);
						entdis.add(entdi);
						i++;
					}
				}				
			}
		}else{
			return null;
		}
		return  entdis.toArray(new EntDiDO[]{});
	}

	/**
	 * 诊断主表信息合并
	 * @param diDTO
	 * @param cidiag
	 * @throws BizException
	 */
	private void mergeCiDiagDOInfo(DIDTO diDTO,CiDiagDO cidiag) throws BizException {
		cidiag.setId_dep(diDTO.getId_dep());
		cidiag.setFg_sign(diDTO.getFg_sign());
		if (cidiag.getFg_sign().isValue()) {
			cidiag.setDt_sign(diDTO.getDt_sign());
			cidiag.setId_dep_sign(diDTO.getId_dep_sign());
			cidiag.setId_emp_sign(diDTO.getId_emp_sign());
		}
		cidiag.setId_emp_create(diDTO.getId_emp_create());
		cidiag.setId_dep_create(diDTO.getId_dep_create());
		cidiag.setDt_create(diDTO.getDt_create());
		cidiag.setId_di(diDTO.getId_di());
		cidiag.setId_grp(Context.get().getGroupId());
		cidiag.setId_org(Context.get().getOrgId());
		cidiag.setId_pat(diDTO.getId_pat());
		cidiag.setId_entp(diDTO.getId_entp());
		cidiag.setCode_entp(diDTO.getCode_entp());
		cidiag.setId_en(diDTO.getId_en());
		cidiag.setId_ditp(diDTO.getId_ditp());
		cidiag.setSd_ditp(diDTO.getSd_ditp());
		cidiag.setDes_di(diDTO.getDes_di());
		cidiag.setDt_di(diDTO.getDt_di());

		StringBuffer sb = new StringBuffer();
		//暂时注释
		//sb.append(diDTO.getId_disys()); 
		sb.append(" ");
		sb.append(diDTO.getId_disys_name());
		//sb.append(diDTO.getId_emp_create_name());
		//sb.append(diDTO.getDt_di());
		sb.append(" ");
		cidiag.setDes_di(sb.toString());
	}

	/**
	 * 诊断子表信息合并
	 * @param ciDiagitem
	 * @param item
	 * @throws BizException
	 */
	private void mergeCiDiagItemDOInfo(DIDTO item,CiDiagItemDO ciDiagitem)	throws BizException {
		ciDiagitem.setId_diitm(item.getId_diitm());
		ciDiagitem.setId_di(item.getId_di());
		//			ciDiagitem.setSortno(i + "");

		if (item.getDidef_name() != null) {
			ciDiagitem.setId_didef(item.getId_didef());
			ciDiagitem.setId_didef_code(item.getDidef_code());
			ciDiagitem.setId_didef_name(item.getDidef_name());
		} else {
			ciDiagitem.setId_didef(item.getDi_disease());
			ciDiagitem.setId_didef_code(item.getId_disease_code());
			ciDiagitem.setId_didef_name(item.getId_disease_name());
		}
		ciDiagitem.setId_didef_syn(item.getId_didef_syn());
		ciDiagitem.setId_didef_syn_code(item.getId_didef_syn_code());
		ciDiagitem.setId_didef_syn_name(item.getId_didef_syn_name());
		//ciDiagitem.setDes(item.getDes());
		ciDiagitem.setFg_majdi(item.getFg_majdi());
		ciDiagitem.setFg_suspdi(item.getFg_suspdi());
		//ciDiagitem.setFg_infedi(item.getFg_infedi());
		//ciDiagitem.setId_parent(item.getId_parent());
		//ciDiagitem.setInnercode(item.getInnercode());
		//ciDiagitem.setFg_flupci(item.getFg_flupci());
		//ciDiagitem.setFg_sym(item.getFg_sym());
		ciDiagitem.setSupplement(item.getSupplement());
		ciDiagitem.setId_disys(item.getId_disys());
		if (this.diagSysMap != null ) {
			ciDiagitem.setSd_disys(this.diagSysMap.get(item.getId_disys()).getCode());
			ciDiagitem.setId_disys_name(this.diagSysMap.get(item.getId_disys()).getName());
		}
		ciDiagitem.setDi_standard(item.getDi_standard());
		ciDiagitem.setDi_standard_code(item.getDi_standard_code());
		ciDiagitem.setDi_standard_name(item.getDi_standard_name());
		ciDiagitem.setFg_self(item.getFg_self());
		ciDiagitem.setInnercode(item.getInnercode());
		ciDiagitem.setId_parent(item.getId_par());
		ciDiagitem.setFg_ur(item.getFg_ur());
		ciDiagitem.setFg_chronic(item.getFg_chronic()); //慢性病标志
		ciDiagitem.setFg_special(item.getFg_special());//特种病标志
		ciDiagitem.setId_infectiontp(item.getId_infectiontp());
		ciDiagitem.setSd_infectiontp(item.getSd_infectiontp());
	}

	private void setDiagItemHpTp(Map<String, FBoolean> map,String[] idDiDefList,CiDiagItemDO[] itemList,CiEnContextDTO ctx,String entp) throws BizException{
		// 获取保外诊断判断结果，key值诊断定义id， value true 保内诊断，Y 保外诊断
		if (StringUtils.isNotEmpty(ctx.getId_hp())) {

			map = getIHpQueService().BdHpDiJudge(ctx.getId_hp(), idDiDefList, entp);
		}

		//设置诊断明细
		if (itemList != null && itemList.length > 0) {
			CiDiagItemDO[] items = new CiDiagItemDO[itemList.length];
			int i = 0;

			String[] id_didef = new String[itemList.length];
			if (map != null && map.size() > 0) {
				for (CiDiagItemDO item : itemList) {
					if (map.containsKey(item.getId_didef())) {
						if (map.get(item.getId_didef()) == FBoolean.FALSE) {
							item.setEu_hpbeyond(HpBeyondEnum.HPEXTERNALDIAG);//医保外
						} else {
							item.setEu_hpbeyond(HpBeyondEnum.HPDIAG);//医保内
						}
					}
					items[i] = item;
					id_didef[i] = item.getId_didef();
					i++;
				}
			} else {
				for (CiDiagItemDO item : itemList) {
					item.setEu_hpbeyond(HpBeyondEnum.NONMEDICARE);
					items[i] = item;
					id_didef[i] = item.getId_didef();
					i++;
				}
			}
			itemList=items;
		}
	}

	/**
	 * 获得诊断描述拼接
	 * @param itemdos
	 * @return
	 */
	private String getDiagDes(CiDiagItemDO item){
		StringBuffer des = new StringBuffer();
			// 西医内容拼接
			if (item.getId_disys() == ICiDictCodeConst.ID_CI_DISYS_XYZDTX) {
				des.append(item.getSortno() + "," + item.getDidef_name());
				//des.append("\n");
				if (item.getSupplement() != null && item.getSupplement() != "") {
					des.append("——" + item.getSupplement());
				}

				des.append("          \n");

			} else if (item.getId_disys() == ICiDictCodeConst.ID_CI_DISYS_ZYZDTX) {
				//中医内容拼接
				des.append(item.getId_disys_name() + " ");
				des.append(item.getSortno() + "," + item.getId_didef_name());
				des.append(" \n");
				des.append(item.getId_didef_syn_name());
				des.append("         \n");
			} else {
				//其它
				des.append(item.getSortno() + "," + item.getDidef_name());
				//des.append("\n");
				if (item.getSupplement() != null && item.getSupplement() != "") {
					des.append("——" + item.getSupplement());
				}
				des.append("         \n");
			}
		return des.toString();
	}

	private ICidiagMDORService getICidiagMDORService(){
		return ServiceFinder.find(ICidiagMDORService.class);
	}


	private ICidiagRService getICidiagRService(){
		return ServiceFinder.find(ICidiagRService.class);
	}

	private IHpQueService getIHpQueService(){
		return (IHpQueService)ServiceFinder.find(IHpQueService.class);
	}
	private ICiOrdMaintainService getICiOrdMaintainService(){
		return (ICiOrdMaintainService)ServiceFinder.find(ICiOrdMaintainService.class);
	}

	/**
	 * 临床诊断  agg 
	 * @return
	 */
	public static ICidiagCudService getICidiagCudService(){
		return ServiceFinder.find(ICidiagCudService.class);
	}
	/**
	 *  诊断
	 * @return
	 */
	public static ICidiagMaintainService getCidiagMaintainServiceImpl(){
		return ServiceFinder.find(ICidiagMaintainService.class);
	}
	/**
	 * 就诊诊断
	 * @return
	 */
	public static IEntdiRService getIEntdiRService(){
		return ServiceFinder.find(IEntdiRService.class);
}
	/**
	 * 就诊诊断
	 * @return
	 */
	public static IEntdiCudService getIEntdiCudService(){
		return ServiceFinder.find(IEntdiCudService.class);
	}

	/**
	 * 查询诊断体系，并缓存Map结构，key 诊断体系id， value 诊断体系名称
	 * @throws BizException
	 */
	public void getUdidocMap() throws BizException {
		String  qry = "select  * from bd_udidoc where id_udidoclist ='"+ICiDictCodeConst.CI_DISYS+"'";
		DAFacade daface=new DAFacade();
		List<UdidocDO> rtn = (List<UdidocDO>) daface.execQuery(qry, new BeanListHandler(UdidocDO.class));
		if (rtn != null && rtn.size() > 0) {
			diagSysMap = new HashMap<String, UdidocDO>();
			for (UdidocDO udidoc : rtn) {
				diagSysMap.put(udidoc.getId_udidoc(), udidoc);
			}
		}
	}
	public CidiagAggDO[] getCiDiCurrent(String id_en) throws BizException {
		if (id_en == null)
			return null;
		//患者的当前诊断
		CidiagAggDO[] agg = null;
		List<CiDiagDO> cidiagDOList = this.getListCiDiagDO(id_en);

		if (cidiagDOList != null && cidiagDOList.size() > 0) {
			String sql = getCiDiagIdDiSql(cidiagDOList);
			agg = getICidiagRService().find(sql, CiDiagDO.ID_DI, FBoolean.FALSE);
		}

		if (agg == null || agg.length == 0) {
			new BizException("当前诊断为空");
		}
		return agg;
	}
	/**
	 * 当前诊断的主键集合
	 * 
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	private List<CiDiagDO> getListCiDiagDO(String id_en) throws BizException {
		DAFacade facade = new DAFacade();
		String sql = " dt_sign in (" 
				+ " select max(dt_sign) from ci_di where id_en ='" + id_en
				+ "' and  fg_sign ='Y' and sd_ditp !='" + ICiDictCodeConst.SD_SUPPLY + "'" + " union all  "
				+ " select dt_sign from ci_di where id_en ='" + id_en + "'  and fg_sign ='Y' and sd_ditp ='"
				+ ICiDictCodeConst.SD_SUPPLY + "'" + " and dt_sign>("
				+ " select max(dt_sign) from ci_di where id_en ='" + id_en + "' and  fg_sign ='Y' and sd_ditp !='"
				+ ICiDictCodeConst.SD_SUPPLY + "'" + " ))";

		List<CiDiagDO> CiDiagDOList = (List<CiDiagDO>) facade.findByCond(CiDiagDO.class, sql, CiDiagDO.DT_DI);
		return CiDiagDOList;
	}


	/**
	 * sql
	 * 
	 * @param cidiagDOList
	 * @return
	 * @throws BizException
	 */
	private String getCiDiagIdDiSql(List<CiDiagDO> cidiagDOList) throws BizException {
		if (cidiagDOList == null || cidiagDOList.size() == 0)
			new BizException("诊断集合为空");
		String sql = "";
		if (cidiagDOList.size() > 0) {
			sql = CiDiagDODesc.TABLE_ALIAS_NAME + "." + CiDiagDO.ID_DI + " in (";
			for (CiDiagDO cidido : cidiagDOList) {
				sql += "'" + cidido.getId_di() + "',";
			}
			sql = sql.substring(0, sql.lastIndexOf(","));
			sql += " )";
		}
		return sql;
	}
}


  
