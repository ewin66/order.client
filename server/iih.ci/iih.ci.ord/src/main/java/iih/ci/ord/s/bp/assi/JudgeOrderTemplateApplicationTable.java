/**
 * 
 */
package iih.ci.ord.s.bp.assi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.dto.d.EmsDynamicParamDTO;
import iih.bd.srv.ems.d.EmsDO;
import iih.bd.srv.ems.d.EmsDynamicIndexDTO;
import iih.bd.srv.ems.i.IEmsregistryMDORService;
import iih.bd.srv.i.IBdSrvQryService;
import iih.bd.srv.medsrv.d.MedSrvConsDO;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.i.IMedSrvConsDORService;
import iih.bd.srv.medsrv.i.IMedSrvLisDORService;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import iih.ci.mr.pub.MrConst.IMrPubConst;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.CiordInviteConsDO;
import iih.ci.ord.cior.d.OrConsApAuditDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.d.OrdApBtViewItemDO;
import iih.ci.ord.cior.d.OrdApConsDO;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.cior.d.OrdApOutDO;
import iih.ci.ord.cior.d.OrdApPathgyDO;
import iih.ci.ord.cior.d.OrdApSugViewItemDO;
import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.cior.d.OrdOpEmpDO;
import iih.ci.ord.cior.d.OrdOpMmDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.en.pv.dto.d.Ent4BannerDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.group.d.GroupDO;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * @ClassName: JudgeOrderTemplateApplicationTable
 * @Description: 是否有申请表（有写入申请表）
 * @author Comsys-li_zheng
 * @date 2016年9月18日 下午4:02:37
 * @Package iih.ci.ord.s.bp.assi Copyright: Copyright (c) 2011 Company: 北大医疗信息技术有限责任公司
 */
public class JudgeOrderTemplateApplicationTable {

	/**
	 * 判断是否有申请表
	 * 
	 * @param ciEms
	 */
	public void JudgeOrederTemplateAppTabel(CiEmsDTO[] ciEms, CiEnContextDTO ciEnContext) throws BizException {

		if (ciEms != null && ciEms.length > 0) {
			String[] diag = CiOrdUtils.getDiag(ciEms[0].getId_en());
			for (CiEmsDTO ciemsDTO : ciEms) {
				//申请单号
				String ApplyNo = CiOrdUtils.getApplyNoCiEms(ciemsDTO);
				if (EmsType.PATHGY == ciemsDTO.getEmstype()) {
					//病理
					getciorapppathgy(ciemsDTO, ciemsDTO.getApplyno()==null?ApplyNo:ciemsDTO.getApplyno(), diag);
				} else if (EmsType.RIS == ciemsDTO.getEmstype()) {
					//检查
					getOrdApObsDO(ciemsDTO, ciemsDTO.getApplyno()==null?ApplyNo:ciemsDTO.getApplyno(), diag);
				} else if (EmsType.LIS == ciemsDTO.getEmstype()) {
					//检验	
					getOrdApLabDO(ciemsDTO, ciemsDTO.getApplyno()==null?ApplyNo:ciemsDTO.getApplyno(), diag);
				} else if (EmsType.OPER == ciemsDTO.getEmstype()) {
					//手术
					getOrdApOpDO(ciemsDTO, ciemsDTO.getApplyno()==null?ApplyNo:ciemsDTO.getApplyno(), diag);
				} else if (EmsType.CONS == ciemsDTO.getEmstype()) {
					//会诊	
					getOrdApConsDO(ciemsDTO, ciemsDTO.getApplyno()==null?ApplyNo:ciemsDTO.getApplyno(), diag, ciEnContext);
				} else if (EmsType.BT == ciemsDTO.getEmstype()) {
					//备血	
					getOrdApBtDO(ciemsDTO, ciemsDTO.getApplyno()==null?ApplyNo:ciemsDTO.getApplyno(), diag);
				} else if (EmsType.BTUSE == ciemsDTO.getEmstype()) {
					//用血
					getOrdAppBtUseDO(ciemsDTO, ciemsDTO.getApplyno()==null?ApplyNo:ciemsDTO.getApplyno(), diag);
				} else if (EmsType.OUTHOSP == ciemsDTO.getEmstype()) {
					// 出院
					getOrdAppOuthospDO(ciemsDTO, ciemsDTO.getApplyno()==null?ApplyNo:ciemsDTO.getApplyno(), diag, ciEnContext);
				}
			}
		}

	}

	/**
	 * 检查申请单
	 * 
	 * @param ciemsDTO
	 * @param ApplyNo 申请单号
	 * @param diag 诊断
	 * @throws BizException
	 */
	private void getOrdApObsDO(CiEmsDTO ciemsDTO, String ApplyNo, String[] diag) throws BizException {

		ciemsDTO.setApplyno(ApplyNo);
		OrdApObsDO obs = new OrdApObsDO();
		//obs.setSv(ciemsDTO.getSv());//
		obs.setStr_name_di(diag[0]);//诊断名称拼接
		obs.setStr_id_diitm(diag[2]);//临床诊断id拼接
		obs.setStr_code_di(diag[1]);//诊断编码拼接
		obs.setId_diitm(diag[3]);
		obs.setId_di(diag[7]);
		obs.setId_su_obs(ICiDictCodeConst.ID_CI_OBS_SQ);// 检查社情状态id
		obs.setSd_su_obs(ICiDictCodeConst.SD_CI_OBS_SQ);//检查申请状态编码
		obs.setSd_pps(ICiDictCodeConst.Sd_CI_OBS_OBJECTIVE);//检查目的编码
		obs.setDes_pps(ICiDictCodeConst.NAME_OBS_OBJECTIVE); //检查目的描述
		//obs.setPastillness(ciemsDTO.getPastillness());//既往病史
		obs.setNo_applyform(ApplyNo);//申请单号
		//obs.setName_diag(ciemsDTO.getName_diag());//诊断名称
		//obs.setModifiedtime(ciemsDTO.getModifiedtime());//最后修改时间
		//obs.setModifiedby(ciemsDTO.getModifiedby());//最后修改人
		obs.setId_su_obs(ICiDictCodeConst.ID_CI_OBS_SQ);//检查申请状态
		obs.setId_pps(ICiDictCodeConst.Id_CI_OBS_OBJECTIVE);//检查目的
		//obs.setId_orobs(ciemsDTO.getId_orobs());//医嘱检查申请主键标识
		//obs.setId_or(ciemsDTO.getId_or());//医嘱
		obs.setId_di(diag[7]);//临床诊断
		obs.setName_di(diag[4]);// 诊断名称 TODO 保留一个
		obs.setName_diag(diag[4]); // 诊断名称 TODO 保留一个
		obs.setId_diitm(diag[3]); // 诊断明细
		obs.setFg_urgent(ciemsDTO.getFg_urgent());//加急标识
		obs.setDt_plan(CiOrdAppUtils.getServerDateTime());//计划检查日期
		obs.setSd_pps(ICiDictCodeConst.Sd_CI_OBS_OBJECTIVE);
		obs.setId_pps(ICiDictCodeConst.Id_CI_OBS_OBJECTIVE);
		obs.setName_pps(ICiDictCodeConst.NAME_OBS_OBJECTIVE);
		//检查目的名称
		//obs.setDs(ciemsDTO.getDs());//
		//obs.setDes_sympsign(ciemsDTO.getDes_sympsign());//症状和体征
		//obs.setDes_pps(ciemsDTO.getDes_pps());//检查目的描述
		/*	obs.setDef9(ciemsDTO.getDef9());//客户扩展字段9
			obs.setDef8(ciemsDTO.getDef8());//客户扩展字段8
			obs.setDef7(ciemsDTO.getDef7());//客户扩展字段7
			obs.setDef6(ciemsDTO.getDef6());//客户扩展字段6
			obs.setDef50(ciemsDTO.getDef50());//客户扩展字段50
			obs.setDef5(ciemsDTO.getDef5());//客户扩展字段5
			obs.setDef49(ciemsDTO.getDef49());//客户扩展字段49
			obs.setDef48(ciemsDTO.getDef48());//客户扩展字段48
			obs.setDef47(ciemsDTO.getDef47());//客户扩展字段47
			obs.setDef46(ciemsDTO.getDef46());//客户扩展字段46
			obs.setDef45(ciemsDTO.getDef45());//客户扩展字段45
			obs.setDef44(ciemsDTO.getDef44());//客户扩展字段44
			obs.setDef43(ciemsDTO.getDef43());//客户扩展字段43
			obs.setDef42(ciemsDTO.getDef42());//客户扩展字段42
			obs.setDef41(ciemsDTO.getDef41());//客户扩展字段41
			obs.setDef40(ciemsDTO.getDef40());//客户扩展字段40
			obs.setDef4(ciemsDTO.getDef4());//客户扩展字段4
			obs.setDef39(ciemsDTO.getDef39());//客户扩展字段39
			obs.setDef38(ciemsDTO.getDef38());//客户扩展字段38
			obs.setDef37(ciemsDTO.getDef37());//客户扩展字段37
			obs.setDef36(ciemsDTO.getDef36());//客户扩展字段36
			obs.setDef35(ciemsDTO.getDef35());//客户扩展字段35
			obs.setDef34(ciemsDTO.getDef34());//客户扩展字段34
			obs.setDef33(ciemsDTO.getDef33());//客户扩展字段33
			obs.setDef32(ciemsDTO.getDef32());//客户扩展字段32
			obs.setDef31(ciemsDTO.getDef31());//客户扩展字段31
			obs.setDef30(ciemsDTO.getDef30());//客户扩展字段30
			obs.setDef3(ciemsDTO.getDef3());//客户扩展字段3
			obs.setDef29(ciemsDTO.getDef29());//客户扩展字段29
			obs.setDef28(ciemsDTO.getDef28());//客户扩展字段28
			obs.setDef27(ciemsDTO.getDef27());//客户扩展字段27
			obs.setDef26(ciemsDTO.getDef26());//客户扩展字段26
			obs.setDef25(ciemsDTO.getDef25());//客户扩展字段25
			obs.setDef24(ciemsDTO.getDef24());//客户扩展字段24
			obs.setDef23(ciemsDTO.getDef23());//客户扩展字段23
			obs.setDef22(ciemsDTO.getDef22());//客户扩展字段22
			obs.setDef21(ciemsDTO.getDef21());//客户扩展字段21
			obs.setDef20(ciemsDTO.getDef20());//客户扩展字段20
			obs.setDef2(ciemsDTO.getDef2());//客户扩展字段2
			obs.setDef19(ciemsDTO.getDef19());//客户扩展字段19
			obs.setDef18(ciemsDTO.getDef18());//客户扩展字段18
			obs.setDef17(ciemsDTO.getDef17());//客户扩展字段17
			obs.setDef16(ciemsDTO.getDef16());//客户扩展字段16
			obs.setDef15(ciemsDTO.getDef15());//客户扩展字段15
			obs.setDef14(ciemsDTO.getDef14());//客户扩展字段14
			obs.setDef13(ciemsDTO.getDef13());//客户扩展字段13
			obs.setDef12(ciemsDTO.getDef12());//客户扩展字段12
			obs.setDef11(ciemsDTO.getDef11());//客户扩展字段11
			obs.setDef10(ciemsDTO.getDef10());//客户扩展字段10
			obs.setDef1(ciemsDTO.getDef1());//客户扩展字段1
		*/
		obs.setCreatedtime(CiOrdAppUtils.getServerDateTime());//创建时间
		obs.setCreatedby(CiOrdAppUtils.getEnvContext().getUserId());//创建人
		obs.setClinicalzztz(this.getClinicalzztz(ciemsDTO));//临床症状及体征
		//obs.setBiopsy(ciemsDTO.getBiopsy());//检查组织描述
		//obs.setAuximtexam(ciemsDTO.getAuximtexam());//其它检查所见
		//obs.setAnnouncements(ciemsDTO.getAnnouncements());//注意事项
		obs.setStatus(DOStatus.NEW);
		ciemsDTO.setEmstype(EmsType.RIS);
		FMap map = new FMap();
		map.put(EmsType.RIS + "", obs);
		ciemsDTO.setOrapplysheet(map);
	}

	/**
	 * 获取病历中的主诉、现病史、体格检查内容（按主诉、现病史、体格检查顺序返回内容）
	 * 
	 * @param ciemsDTO
	 * @return
	 * @throws BizException
	 */
	private String getClinicalzztz(CiEmsDTO ciemsDTO) throws BizException {

		StringBuffer clinicalzztzBuffer = null;
		// 主诉、现病史、体格检查对应的编码
		List<String> codeElementList = Arrays.asList(IMrPubConst.DG_ZS, IMrPubConst.DG_XBS, IMrPubConst.DG_TGJC);
		IMrdocrefvalueRService imrdocrefvalueRService = (IMrdocrefvalueRService) ServiceFinder
				.find(IMrdocrefvalueRService.class);

		String idEn = ciemsDTO.getId_en();
		String whereStr = "id_ent='" + idEn + "' and code_element in('" + IMrPubConst.DG_ZS + "','" + IMrPubConst.DG_XBS
				+ "','" + IMrPubConst.DG_TGJC + "')";
		// 获取文书内容
		MrDocRefValueDO[] MrDocRefValueDOs = imrdocrefvalueRService.find(whereStr, null, FBoolean.FALSE);

		// 构造按主诉、现病史、体格检查顺序拼接内容字符串
		for (String codeElement : codeElementList) {
			for (MrDocRefValueDO mrDocRefValueDO : MrDocRefValueDOs) {
				if (codeElement.equals(mrDocRefValueDO.getCode_element())) {
					if (clinicalzztzBuffer == null) {
						clinicalzztzBuffer = new StringBuffer();
					}
					if (mrDocRefValueDO.getContent() == null) {
						continue;
					}
					clinicalzztzBuffer.append(mrDocRefValueDO.getContent())
							.append(System.getProperty("line.separator"));
				}
			}
		}

		return clinicalzztzBuffer == null ? "" : clinicalzztzBuffer.toString();
	}

	/**
	 * 备血医疗单
	 * 
	 * @param ciemsDTO
	 * @throws BizException
	 */
	private void getOrdApBtDO(CiEmsDTO ciemsDTO, String ApplyNo, String[] diag) throws BizException {
		CiorappbtAggDO agg = new CiorappbtAggDO();
		OrdApBtDO bt = new OrdApBtDO();
		bt.setName_diag(diag[4]);//诊断名称
		bt.setId_diitm(diag[3]);
		//bt.setId_apbt(ciemsDTO.getId_apbt());//备血申请
		//bt.setId_or(ciemsDTO.getId_or());//医嘱

		bt.setId_di(diag[7]);//临床诊断  1001Z7100000000Q8MPR
		bt.setStr_id_diitm(diag[2]);//临床诊断明细
		bt.setStr_code_di(diag[1]);//诊断编码拼接
		bt.setStr_name_di(diag[0]);//诊断名称拼接
		bt.setNo_applyform(ApplyNo);//输血申请单号
		//bt.setPregnant_num(ciemsDTO.getFg_);//孕几胎
		//bt.setParturition_cnt(ciemsDTO.getParturition_cnt());//生产数量

		// 输血史、输血目的、输血前监测项目说明、输血前监测项目说明编码、输血需求状态、备血申请状态
		String[] id_udidocs = new String[] { ICiDictCodeConst.ID_CI_BT_WSXS, ICiDictCodeConst.ID_CI_BT_QT,
				ICiDictCodeConst.ID_CI_BT_2SXZSXQJCXMYHZHDLRJJJCGWSJ, ICiDictCodeConst.ID_CI_BT_BYDTZ,
				ICiDictCodeConst.ID_CI_BT_YSQ };
		Map<String, UdidocDO> udidocMap = getUdidocById(id_udidocs);

		// 输血史SD对象
		UdidocDO his_bt = udidocMap.get(ICiDictCodeConst.ID_CI_BT_WSXS);
		bt.setId_his_bt(ICiDictCodeConst.ID_CI_BT_WSXS);//输血史标识
		bt.setSd_his_bt(ICiDictCodeConst.SD_CI_BT_WSXS);//输血史标识编码
		bt.setName_his_bt(his_bt.getName());

		// 输血目的SD对象
		UdidocDO pps_bt = udidocMap.get(ICiDictCodeConst.ID_CI_BT_QT);
		bt.setId_pps_bt(ICiDictCodeConst.ID_CI_BT_QT);//输血目的		
		bt.setSd_pps_bt(ICiDictCodeConst.SD_CI_BT_QT);//输血目的编码
		bt.setName_pps_bt(pps_bt.getName());

		//bt.setDes_pps_bt(ciemsDTO.getDes_pps_bt());//输血目的描述
		//bt.setFg_db(ciemsDTO.getFg_db());//献血史标识
		//bt.setNo_db(ciemsDTO.getNo_db());//献血证号
		// 输血前监测项目说明
		UdidocDO labitmexplain = udidocMap.get(ICiDictCodeConst.ID_CI_BT_2SXZSXQJCXMYHZHDLRJJJCGWSJ);
		bt.setId_labitmexplain(ICiDictCodeConst.ID_CI_BT_2SXZSXQJCXMYHZHDLRJJJCGWSJ);//输血前监测项目说明
		bt.setSd_labitmexplain(ICiDictCodeConst.SD_CI_BT_2SXZSXQJCXMYHZHDLRJJJCGWSJ);//输血前监测项目说明编码
		bt.setName_labitmexplain(labitmexplain.getName());//输血前监测项目说明

		// 输血需求状态
		UdidocDO demandsu_bt = udidocMap.get(ICiDictCodeConst.ID_CI_BT_BYDTZ);
		bt.setId_demandsu_bt(ICiDictCodeConst.ID_CI_BT_BYDTZ);//输血需求状态
		bt.setSd_demandsu_bt(ICiDictCodeConst.SD_CI_BT_BYDTZ);//输血需求状态编码
		bt.setName_demandsu_bt(demandsu_bt.getName());//输血需求状态名称

		//bt.setId_mode_bt(ciemsDTO.getId_mode_bt());//预定输血方式
		//bt.setSd_mode_bt(ciemsDTO.getSd_mode_bt());//预定输血方式编码

		bt.setCreatedby(CiOrdAppUtils.getEnvContext().getUserId());//创建人
		bt.setCreatedtime(CiOrdAppUtils.getServerDateTime());//创建时间
		//bt.setModifiedby(ciemsDTO.getModifiedby());//最后修改人
		//bt.setModifiedtime(ciemsDTO.getModifiedtime());//最后修改时间
		//bt.setNum_margin_bu(ciemsDTO.getNum_margin_bu());//可用于血量
		bt.setDt_bt_pl(CiOrdAppUtils.getServerDateTime() + "");//计划输血日期
		//
		UdidocDO su_bt = udidocMap.get(ICiDictCodeConst.ID_CI_BT_YSQ);
		bt.setSd_su_bt(ICiDictCodeConst.ID_CI_BT_YSQ);//备血申请状态
		bt.setId_su_bt(ICiDictCodeConst.SD_CI_BT_YSQ);//备血申请状态编码
		//		bt.setName_su_bt(su_bt.getName());//备血申请状态

		//bt.setFg_rpt(ciemsDTO.getFg_rpt());//报告标志
		//bt.setDs(ciemsDTO.getDs());//
		//bt.setSv(ciemsDTO.getSv());//
		bt.setStatus(DOStatus.NEW);
		agg.setParentDO(bt);
		OrdApBtViewItemDO item = new OrdApBtViewItemDO();
		item.setStatus(DOStatus.NEW);
		agg.setOrdApBtViewItemDO(new OrdApBtViewItemDO[] { item });

		//动态指标项 DO数据
		EmsDynamicIndexDTO[] dynamicIndexs = this.getEmsDynamicIndex(ciemsDTO);

		if (dynamicIndexs != null && dynamicIndexs.length > 0) {

			// 备血观察检验指标
			OrdApBtViewItemDO[] items = new OrdApBtViewItemDO[dynamicIndexs.length];
			for (int i = 0; i < dynamicIndexs.length; i++) {

				items[i] = new OrdApBtViewItemDO();
				// 项目结果值
				items[i].setVal_rstrptla(StringUtils.trimToEmpty(dynamicIndexs[i].getIndexval()));
				// 项目结果值域
				String val_restrptlab = dynamicIndexs[i].getEnumvalues() == null ? ""
						: "|" + dynamicIndexs[i].getEnumvalues().replace(',', '|');
				items[i].setVal_restrptlab(val_restrptlab);
				items[i].setSd_restrptlabtp(dynamicIndexs[i].getDatatype());
				items[i].setName_srv(dynamicIndexs[i].getShowname());
				items[i].setName_unit(dynamicIndexs[i].getUnitname());
				items[i].setId_unit(dynamicIndexs[i].getId_unit());
				items[i].setId_srv(dynamicIndexs[i].getId_srv());
				items[i].setStatus(DOStatus.NEW);
			}

			agg.setOrdApBtViewItemDO(items);
		}

		ciemsDTO.setEmstype(EmsType.BT);

		FMap map = new FMap();
		map.put(EmsType.BT + "", agg);
		ciemsDTO.setOrapplysheet(map);
	}

	/**
	 * 用血医疗单
	 * 
	 * @param ciemsDTO
	 */
	private void getOrdAppBtUseDO(CiEmsDTO ciemsDTO, String ApplyNo, String[] diag) {
		OrdAppBtUseDO bu = new OrdAppBtUseDO();
		//bu.setId_apbu(ciemsDTO.getId_apbu());//医嘱用血申请主键标识
		//bu.setId_or(ciemsDTO.getId_or());//医嘱
		bu.setDt_bu_plan(CiOrdAppUtils.getServerDateTime());//计划用血申请
		bu.setNo_applyform(ApplyNo);//用血申请单号
		bu.setCreatedby(CiOrdAppUtils.getEnvContext().getUserId());//创建人
		bu.setCreatedtime(CiOrdAppUtils.getServerDateTime());//创建时间
		//bu.setModifiedby(ciemsDTO.getModifiedby());//最后修改人
		//bu.setModifiedtime(ciemsDTO.getModifiedtime());//最后修改时间
		//bu.setDs(ciemsDTO.getDs());//
		//bu.setSv(ciemsDTO.getSv());//
		bu.setStatus(DOStatus.NEW);

		ciemsDTO.setEmstype(EmsType.BTUSE);
		FMap map = new FMap();
		map.put(EmsType.BTUSE + "", bu);
		ciemsDTO.setOrapplysheet(map);
	}

	/**
	 * 会诊医疗单
	 * 
	 * @param ciemsDTO
	 */
	private void getOrdApConsDO(CiEmsDTO ciemsDTO, String ApplyNo, String[] diag, CiEnContextDTO ciEnContext) throws BizException {
		IMedSrvConsDORService service = ServiceFinder.find(IMedSrvConsDORService.class);
		String whereStr = "Id_srv = '" + ciemsDTO.getId_srv() + "'";
		MedSrvConsDO[] medSrvCons = service.find(whereStr, "Id_srv", FBoolean.FALSE);
		CiorappconsultAggDO agg = new CiorappconsultAggDO();
		OrdApConsDO cons = new OrdApConsDO();
		//cons.setDt_constimelimit(ciemsDTO.getDt_constimelimit());//会诊失效时间 todo
		if (medSrvCons != null && medSrvCons.length > 0) {
			cons.setFg_audit_clidep(medSrvCons[0].getFg_audit_clidep());//是否需科室审批
			cons.setFg_audit_admdep(medSrvCons[0].getFg_audit_admdep());//是否需医务部审批 
		}

		cons.setCreatedtime(CiOrdAppUtils.getServerDateTime());//创建时间
		cons.setModifiedby(CiOrdAppUtils.getEnvContext().getUserId());//最后修改人
		//cons.setModifiedtime(ciemsDTO.getModifiedtime());//最后修改时间
		//cons.setDs(ciemsDTO.getDs());//
		//cons.setSv(ciemsDTO.getSv());//
		//cons.setId_apcons(ciemsDTO.getId_apcons());//医嘱会诊申请主键标识
		//cons.setId_or(ciemsDTO.getId_or());//医嘱
		cons.setNo_applyform(ApplyNo);//会诊申请单号
		//cons.setId_constp(ciemsDTO.getId_constp());//会诊类型（废弃不用了）
		//cons.setSd_constp(ciemsDTO.getSd_constp());//会诊类型编码（废弃不用了）
		cons.setDt_ap(CiOrdAppUtils.getServerDateTime());//申请时间
		//cons.setDes_emr(ciemsDTO.getDes_emr());//病历摘要
		cons.setDt_plan(CiOrdAppUtils.getServerDateTime());//计划会诊时间
		
		// 会诊地点 门诊为空， 住院是科室 病区 床位
		Ent4BannerDTO banner = ciEnContext.getEnt4BannerDTO();	
		if(ciEnContext.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) || ciEnContext.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET)){
			DeptDO dept = ciEnContext.getDept();
			// 会诊地址，取当前就诊科室所在地址，如果为空，使用就诊科室名称
			String place = StringUtils.isNotBlank(dept.getId_plc()) ? dept.getId_plc() :  dept.getName(); 
			cons.setPlace(place);//会诊地点
		}else if(ciEnContext.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)){					
			cons.setPlace(banner.getName_dep_phy() + banner.getName_dep_nur() + banner.getName_bed());//会诊地点	
		}
		
		//cons.setDes_psp(ciemsDTO.getDes_psp());//会诊目的
		cons.setId_su_cons(ICiDictCodeConst.ID_CI_CONS_DKSSP);//会诊申请状态
		cons.setSd_su_cons(ICiDictCodeConst.SD_CI_CONS_DKSSP);//会诊申请状态编码
		cons.setFg_urgent(FBoolean.FALSE);//加急标识
		//cons.setTel(ciemsDTO.getTel());//联系电话
		//cons.setDes_dep(ciemsDTO.getDes_dep());//医务部意见（废弃不用了）
		cons.setCreatedby(CiOrdAppUtils.getEnvContext().getUserId());//创建人

		cons.setStatus(DOStatus.NEW);
		agg.setParentDO(cons);

		CiordInviteConsDO invite = new CiordInviteConsDO();
		invite.setStatus(DOStatus.NEW);
		agg.setCiordInviteConsDO(new CiordInviteConsDO[] { invite });
		OrConsApAuditDO audit = new OrConsApAuditDO();
		audit.setStatus(DOStatus.NEW);
		agg.setOrConsApAuditDO(new OrConsApAuditDO[] { audit });

		ciemsDTO.setEmstype(EmsType.CONS);
		FMap map = new FMap();
		map.put(EmsType.CONS + "", agg);
		ciemsDTO.setOrapplysheet(map);
	}

	/**
	 * 病理医疗单
	 * 
	 * @param ciemsDTO
	 */
	private void getciorapppathgy(CiEmsDTO ciemsDTO, String ApplyNo, String[] diag) {
		CiorapppathgyAggDO agg = new CiorapppathgyAggDO();
		OrdApPathgyDO pathgy = new OrdApPathgyDO();

		pathgy.setStr_id_diitm(diag[2]);//临床诊断id拼接
		//pathgy.setName_diag(diag[1]);//诊断名称
		//pathgy.setId_appathgy(ciemsDTO.getId_appathgy());//病理申请单主键标识
		//pathgy.setId_or(ciemsDTO.getId_or());//医嘱
		pathgy.setNo_applyform(ApplyNo);//病理申请号
		//pathgy.setId_samptp(ciemsDTO.getId_samptp());//标本类型
		//pathgy.setSd_samptp(ciemsDTO.getSd_samptp());//标本类型编码
		if (!CiOrdUtils.isEmpty(ciemsDTO.getQuan_medu())) {
			pathgy.setQuan(Integer.parseInt(ciemsDTO.getQuan_medu() + ""));//标本需求量
		}
		MedSrvLisDO lisdo = CiOrdUtils.getMedSrvLisByIdSrv(ciemsDTO.getId_srv());
		if (!CiOrdUtils.isEmpty(lisdo)) {
			pathgy.setSd_samptp(lisdo.getSd_samptp());//标本类型
			pathgy.setId_samptp(lisdo.getId_samptp());//标本类型编码
			if (!CiOrdUtils.isEmpty(ciemsDTO.getQuan_medu())) {
				pathgy.setQuan(Integer.parseInt(lisdo.getQuan().toString() + ""));
			}
			pathgy.setSd_colltp(lisdo.getSd_colltp());//采集方法
			pathgy.setId_colltp(lisdo.getId_colltp());//采集方法编码
			pathgy.setDes_labsamp(lisdo.getDes_labsamp());//标本说明
			pathgy.setName_samptp(lisdo.getSamptp_name());
		}
		//pathgy.setSd_colltp(ciemsDTO.getSd_colltp());//采集方法编码
		//pathgy.setId_colltp(ciemsDTO.getId_colltp());//采集方法id
		//pathgy.setDes_labsamp(ciemsDTO.getDes_labsamp());//标本说明
		pathgy.setFg_urgent(FBoolean.FALSE);//加急
		pathgy.setId_di(diag[3]);//诊断
		pathgy.setName_diag(diag[4]);
		pathgy.setStr_code_di(diag[2]);//诊断编码拼接
		pathgy.setStr_name_di(diag[0]);//诊断名称拼接
		//pathgy.setAnnouncements(ciemsDTO.getAnnouncements());//检查要求
		//pathgy.setDes_sympsign(ciemsDTO.getDes_sympsign());//病情描述
		pathgy.setFg_outer(FBoolean.FALSE);//是否外院标志
		//pathgy.setNo_pathgy_old(ciemsDTO.getNo_pathgy_old());//既往病理号
		//pathgy.setDt_pathgy_old(ciemsDTO.getDt_pathgy_old());//既往检查日期
		//pathgy.setDi_pathgy_old(ciemsDTO.getDi_pathgy_old());//既往检查诊断
		GroupDO groupdo = CiOrdUtils.getGroupDO(CiOrdAppUtils.getEnvContext().getGroupId());
		if (!CiOrdUtils.isEmpty(groupdo)) {
			pathgy.setOrg_pathgy_old(groupdo.getName());//既往检查医院
		}
		//pathgy.setCollectdes(ciemsDTO.getCollectdes());//采集所见
		//pathgy.setId_emp(ciemsDTO.getId_emp());//采集者编码
		//pathgy.setId_dep(ciemsDTO.getId_dep());//采集者科室
		//pathgy.setDt_coll(ciemsDTO.getDt_coll());//标本采集时间
		pathgy.setId_su_pathgy(ICiDictCodeConst.ID_SU_PATHGY_YSQ);//病理申请状态id
		pathgy.setSd_su_pathgy(ICiDictCodeConst.SD_SU_PATHGY_YSQ);//病理申请状态
		pathgy.setNo_pathgy(ApplyNo);//病理号
		//pathgy.setDt_rptpathgy(ciemsDTO.getDt_rptpathgy());//报告发布时间
		pathgy.setCreatedby(CiOrdAppUtils.getEnvContext().getUserId());//创建人
		pathgy.setCreatedtime(CiOrdAppUtils.getServerDateTime());//创建时间
		//pathgy.setModifiedby(ciemsDTO.getModifiedby());//最后修改人
		//pathgy.setModifiedtime(ciemsDTO.getModifiedtime());//最后修改时间
		//pathgy.setDs(ciemsDTO.getDs());//
		//pathgy.setSv(ciemsDTO.getSv());//

		pathgy.setStatus(DOStatus.NEW);
		agg.setParentDO(pathgy);

		//病理标本 DO数据 助手添加的病理，不带入标本，因为标本每次不同需要页面维护，保存到数据库后返回页面手动修改标本
		/*OrdApPathgySampDO samp = new OrdApPathgySampDO();
		samp.setStatus(DOStatus.NEW);
		agg.setOrdApPathgySampDO(new OrdApPathgySampDO[]{samp});*/
		ciemsDTO.setEmstype(EmsType.PATHGY);
		FMap map = new FMap();
		map.put(EmsType.PATHGY + "", agg);
		ciemsDTO.setOrapplysheet(map);
	}

	/**
	 * 检验医疗单
	 * 
	 * @param ciemsDTO
	 * @throws BizException
	 */
	private void getOrdApLabDO(CiEmsDTO ciemsDTO, String ApplyNo, String[] diag) throws BizException {

		IMedSrvLisDORService imedSrvLisRService = (IMedSrvLisDORService) ServiceFinder.find(IMedSrvLisDORService.class);
		// 获取查询检验属性的id_srv 如果是套，取套内项目的第一个服务的id_srv,非套的取服务的id
		/*String id_srv = null;
		if (ciemsDTO.getFg_set() == FBoolean.TRUE) {
			FMap map = ciemsDTO.getSrvsetitms();
			FArrayList setItems = (FArrayList) map.get(ciemsDTO.getId_srv());
			OrdSrvSetDO ordSrvSet = (OrdSrvSetDO) setItems.get(0);
			id_srv = ordSrvSet.getId_srvset();
		
		} else {
			ciemsDTO.getId_srv();
		}
		
		MedSrvLisDO[] medSrvLiss = imedSrvLisRService.findByAttrValString(MedSrvLisDO.ID_SRV, id_srv);
		if (medSrvLiss == null || medSrvLiss.length == 0) {
			throw new BizException("检验服务【" + ciemsDTO.getName() + "】 未找到对应定义态检验属性数据，请核对！");
		}
		MedSrvLisDO medSrvLis = medSrvLiss[0];*/

		OrdApLabDO lab = new OrdApLabDO();
		lab.setId_diitm(diag[3]);
		//临床诊断子项（新增）
		/*lab.setDef8(ciemsDTO.getDef8());//
		lab.setDef9(ciemsDTO.getDef9());//
		lab.setDef10(ciemsDTO.getDef10());//
		lab.setDef11(ciemsDTO.getDef11());//
		lab.setDef12(ciemsDTO.getDef12());//
		lab.setDef13(ciemsDTO.getDef13());//
		lab.setDef14(ciemsDTO.getDef14());//
		lab.setDef15(ciemsDTO.getDef15());//
		lab.setDef16(ciemsDTO.getDef16());//
		lab.setDef17(ciemsDTO.getDef17());//
		lab.setDef18(ciemsDTO.getDef18());//
		lab.setDef19(ciemsDTO.getDef19());//
		lab.setDef20(ciemsDTO.getDef20());//
		lab.setDef21(ciemsDTO.getDef21());//
		lab.setDef22(ciemsDTO.getDef22());//
		lab.setDef23(ciemsDTO.getDef23());//
		lab.setDef24(ciemsDTO.getDef24());//
		lab.setDef25(ciemsDTO.getDef25());//
		lab.setDef26(ciemsDTO.getDef26());//
		lab.setDef27(ciemsDTO.getDef27());//
		lab.setDef28(ciemsDTO.getDef28());//
		lab.setDef29(ciemsDTO.getDef29());//
		lab.setDef30(ciemsDTO.getDef30());//
		lab.setDef31(ciemsDTO.getDef31());//
		lab.setDef32(ciemsDTO.getDef32());//
		lab.setDef33(ciemsDTO.getDef33());//
		lab.setDef34(ciemsDTO.getDef34());//
		lab.setDef35(ciemsDTO.getDef35());//
		lab.setDef36(ciemsDTO.getDef36());//
		lab.setDef37(ciemsDTO.getDef37());//
		lab.setDef38(ciemsDTO.getDef38());//
		lab.setDef39(ciemsDTO.getDef39());//
		lab.setDef40(ciemsDTO.getDef40());//
		lab.setDef41(ciemsDTO.getDef41());//
		lab.setDef42(ciemsDTO.getDef42());//
		lab.setDef43(ciemsDTO.getDef43());//
		lab.setDef44(ciemsDTO.getDef44());//
		lab.setDef45(ciemsDTO.getDef45());//
		lab.setDef46(ciemsDTO.getDef46());//
		lab.setDef47(ciemsDTO.getDef47());//
		lab.setDef48(ciemsDTO.getDef48());//
		lab.setDef49(ciemsDTO.getDef49());//
		lab.setDef50(ciemsDTO.getDef50());//
		*/ lab.setName_diag(diag[4]);//诊断名称显示
		//lab.setClinicalzztz(ciemsDTO.getClinicalzztz());//临床症状及体征
		//lab.setPastillness(ciemsDTO.getPastillness());//既往病史
		//lab.setAuximtexam(ciemsDTO.getAuximtexam());//其它检查所见
		//		lab.setDef1(ciemsDTO.getDef1());//
		//		lab.setDef2(ciemsDTO.getDef2());//
		//		lab.setDef3(ciemsDTO.getDef3());//
		//		lab.setDef4(ciemsDTO.getDef4());//
		//		lab.setDef5(ciemsDTO.getDef5());//
		//		lab.setDef6(ciemsDTO.getDef6());//
		//		lab.setDef7(ciemsDTO.getDef7());//
		//lab.setId_orlab(ciemsDTO.getId_orlab());//医嘱检验申请主键标识
		//lab.setId_or(ciemsDTO.getId_or());//医嘱
		lab.setId_di(diag[3]);//临床诊断
		lab.setStr_id_diitm(diag[2]);//临床诊断明细id拼接
		lab.setStr_code_di(diag[1]);//诊断编码拼接
		lab.setStr_name_di(diag[0]);//诊断名称拼接
		lab.setNo_applyform(ApplyNo);//申请单号
		lab.setId_srvca(ciemsDTO.getId_srvca());//检验分类
		lab.setDt_plan(CiOrdAppUtils.getServerDateTime());//计划检验日期
		lab.setId_pps(ICiDictCodeConst.Id_CI_OBS_OBJECTIVE);//检验目的
		lab.setSd_pps(ICiDictCodeConst.Sd_CI_OBS_OBJECTIVE);//检验目的编码
		//lab.setDes_pps(ciemsDTO.getDes_pps());//检验目的描述
		lab.setId_su_lab(ICiDictCodeConst.ID_CI_LAB_SQ);//检验过程状态
		lab.setSd_su_lab(ICiDictCodeConst.SD_CI_LAB_SQ);//检验过程状态编码
		//lab.setDes_sympsign(ciemsDTO.getDes_sympsign());//症状和体征
		//lab.setAnnouncements(ciemsDTO.getAnnouncements());//注意事项
		lab.setFg_urgent(FBoolean.FALSE);//加急标识

		//检验对象
		MedSrvLisDO medSrvLis = CiOrdUtils.getMedSrvLisDOByEmsSrv(ciemsDTO);
		if (CiOrdUtils.isEmpty(medSrvLis)) {
			throw new BizException("检验服务【" + ciemsDTO.getName() + "】 未找到对应定义态检验属性数据，请核对！");
		}

	
		lab.setSd_samptp(medSrvLis.getSd_samptp());//标本类型
		lab.setId_samptp(medSrvLis.getId_samptp());//标本类型编码
		lab.setName_samptp(medSrvLis.getSamptp_name());// 标本类型名称
		
		lab.setId_contp(medSrvLis.getId_contp());//容器类型
		lab.setSd_contp(medSrvLis.getSd_contp());//容器类型编码
		lab.setName_contp(medSrvLis.getName_contp()); // 容器类型名称
		
		lab.setId_labgroup(medSrvLis.getId_labgroup());// 检验分组
		lab.setSd_labgroup(medSrvLis.getSd_labgroup());// 检验编码
		
		lab.setQuan(medSrvLis.getQuan() == null ? null : medSrvLis.getQuan()); // 标本需求量
		lab.setId_unit_quan(medSrvLis.getId_unit_quan());//需求量单位
		
		lab.setId_sampcoltime(medSrvLis.getId_sampcoltime()); // 标本采集时间
		
		lab.setId_sampcollecttimetp(medSrvLis.getId_sampcollecttimetp());// 标本采集时间类型
		lab.setSd_sampcollecttimetp(medSrvLis.getSd_sampcollecttimetp());// 标本采集时间类型编码
		
		lab.setSd_colltp(medSrvLis.getSd_colltp());//采集方法
		lab.setId_colltp(medSrvLis.getId_colltp());//采集方法编码
		lab.setDes_labsamp(medSrvLis.getDes_labsamp());//标本说明		
		lab.setAnnouncements(medSrvLis.getNote());// 注意事项

		lab.setCreatedby(CiOrdAppUtils.getEnvContext().getUserId());//创建人
		lab.setCreatedtime(CiOrdAppUtils.getServerDateTime());//创建时间
		//lab.setModifiedby(ciemsDTO.getModifiedby());//最后修改人
		//lab.setModifiedtime(ciemsDTO.getModifiedtime());//最后修改时间
		//lab.setDs(ciemsDTO.getDs());//
		//lab.setSv(ciemsDTO.getSv());//

		lab.setStatus(DOStatus.NEW);
		ciemsDTO.setEmstype(EmsType.LIS);
		FMap map = new FMap();
		map.put(EmsType.LIS + "", lab);
		ciemsDTO.setOrapplysheet(map);
	}

	/**
	 * 手术医疗单
	 * 
	 * @param ciemsDTO
	 * @throws BizException
	 */
	private void getOrdApOpDO(CiEmsDTO ciemsDTO, String ApplyNo, String[] diag) throws BizException {
		CiorappsurgeryAggDO agg = new CiorappsurgeryAggDO();
		OrdApOpDO op = new OrdApOpDO();
		op.setName_diag(diag[4]);//诊断名称
		//op.setId_apop(ciemsDTO.getId_apop());//医嘱手术申请主键标识
		//op.setId_or(ciemsDTO.getId_or());//医嘱
		op.setId_di(diag[3]);//临床诊断
		op.setStr_id_diitm(diag[2]);//临床诊断明细
		op.setStr_code_di(diag[1]);//诊断编码拼接
		op.setStr_name_di(diag[0]);//诊断名称拼接
		op.setNo_applyform(ApplyNo);//手术申请单号
		op.setDt_plan(CiOrdAppUtils.getServerDateTime());//计划手术时间
		//op.setSugplantime(ciemsDTO.getSugplantime());//计划手术时长
		//op.setId_lvlsug(ciemsDTO.getId_lvlsug());//手术级别
		//op.setSd_lvlsug(ciemsDTO.getSd_lvlsug());//手术级别编码
		//op.setId_anestp(ciemsDTO.getId_anestp());//麻醉方法
		//op.setSd_anestp(ciemsDTO.getSd_anestp());//麻醉方法编码
		//op.setId_incitp(ciemsDTO.getId_incitp());//切口愈合分级
		//op.setSd_incitp(ciemsDTO.getSd_incitp());//切口愈合分级编码
		//op.setFg_allergy(ciemsDTO.getFg_allergy());//药物过敏标识
		//op.setFg_patho(ciemsDTO.getFg_patho());//冰冻病理标识
		op.setId_su_op(ICiDictCodeConst.ID_CI_OPER_YSQ);//手术申请状态
		op.setSd_su_op(ICiDictCodeConst.SD_CI_OPER_YSQ);//手术申请状态编码
		//op.setAnnouncements(ciemsDTO.getAnnouncements());//注意事项
		op.setId_srv(ciemsDTO.getId_srv());//手术名称
		op.setId_srv_code(ciemsDTO.getCode());//手术编码
		//op.setQuan_bt_paln(ciemsDTO.getQuan_bt_paln());//预期输血量
		op.setId_emp_operate(CiOrdAppUtils.getEnvContext().getUserId());//主刀医生
		//op.setId_emp_helper(ciemsDTO.getId_emp_helper());//第一助手
		//op.setId_sugbody(ciemsDTO.getId_sugbody());//体位id
		//op.setSd_sugbody(ciemsDTO.getSd_sugbody());// 体位编码
		//op.setSpecialreq(ciemsDTO.getSpecialreq());//特殊用物
		//op.setSpecialinstrument(ciemsDTO.getSpecialinstrument());//特殊仪器
		//op.setSpecialdes(ciemsDTO.getSpecialdes());//特殊准备
		//op.setFg_er_sug(ciemsDTO.getFg_er_sug());//急诊手术
		//op.setFg_xq_sug(ciemsDTO.getFg_xq_sug());//限期手术
		//op.setFg_zq_sug(ciemsDTO.getFg_zq_sug());//择期手术
		//op.setFg_new_sug(ciemsDTO.getFg_new_sug());//是否新开手术
		//op.setDs(ciemsDTO.getDs());//
		//op.setSv(ciemsDTO.getSv());//
		op.setStatus(DOStatus.NEW);
		agg.setParentDO(op);
		//手术人员 DO数据 
		OrdOpEmpDO opemp = new OrdOpEmpDO();
		opemp.setStatus(DOStatus.NEW);
		agg.setOrdOpEmpDO(new OrdOpEmpDO[] { opemp });
		//手术卫材 DO数据
		OrdOpMmDO opmm = new OrdOpMmDO();
		opmm.setStatus(DOStatus.NEW);
		agg.setOrdOpMmDO(new OrdOpMmDO[] { opmm });

		//动态指标项 DO数据
		EmsDynamicIndexDTO[] dynamicIndexs = this.getEmsDynamicIndex(ciemsDTO);

		if (dynamicIndexs != null && dynamicIndexs.length > 0) {

			OrdApSugViewItemDO[] items = new OrdApSugViewItemDO[dynamicIndexs.length];

			for (int i = 0; i < dynamicIndexs.length; i++) {

				items[i] = new OrdApSugViewItemDO();
				// 项目结果值
				items[i].setVal_rstrptla(StringUtils.trimToEmpty(dynamicIndexs[i].getIndexval()));
				// 项目结果值域
				String val_restrptlab = dynamicIndexs[i].getEnumvalues() == null ? ""
						: "|" + dynamicIndexs[i].getEnumvalues().replace(',', '|');
				items[i].setVal_restrptlab(val_restrptlab);
				items[i].setSd_restrptlabtp(dynamicIndexs[i].getDatatype());
				items[i].setName_srv(dynamicIndexs[i].getShowname());
				items[i].setName_unit(dynamicIndexs[i].getUnitname());
				items[i].setId_unit(dynamicIndexs[i].getId_unit());
				items[i].setId_srv(dynamicIndexs[i].getId_srv());
				items[i].setStatus(DOStatus.NEW);
			}

			agg.setOrdApSugViewItemDO(items);
		}

		ciemsDTO.setEmstype(EmsType.OPER);
		FMap map = new FMap();
		map.put(EmsType.OPER + "", agg);
		ciemsDTO.setOrapplysheet(map);
	}

	/**
	 * 出院申请单
	 * 
	 * @param ciemsDTO
	 * @param ApplyNo
	 * @param diag
	 */
	private void getOrdAppOuthospDO(CiEmsDTO ciemsDTO, String ApplyNo, String[] diag, CiEnContextDTO ciEnContext) {

		Ent4BannerDTO ent4BannerDTO = ciEnContext.getEnt4BannerDTO();
		OrdApOutDO ordApOut = new OrdApOutDO();
		ordApOut.setStatus(DOStatus.NEW);
		//		ordApOut.setId_orout( );//离院申请
		//		ordApOut.setId_or( );//医嘱

		if (CiOrdUtils.isCapitalInStr(ciemsDTO.getSd_srvtp(), IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH)) {

			ordApOut.setId_outtp(IBdFcDictCodeConst.ID_LVHOS_DEAD);//离院方式 死亡
			ordApOut.setSd_outtp(IBdFcDictCodeConst.SD_LVHOS_DEAD);//离院方式编码 死亡
			ordApOut.setFg_death(FBoolean.TRUE);//是否死亡
		} else {
			ordApOut.setId_outtp(IBdFcDictCodeConst.ID_LVHOS_WITHCI);//离院方式 医嘱离院
			ordApOut.setSd_outtp(IBdFcDictCodeConst.SD_LVHOS_WITHCI);//离院方式编码 医嘱离院
			ordApOut.setFg_death(FBoolean.FALSE);//是否死亡
		}

		ordApOut.setDt_timeout(CiOrdAppUtils.getServerDateTime());//离院时间
		ordApOut.setId_dep_out(ciemsDTO.getId_dept_en());//离院时科室
		ordApOut.setName_dep_out(ent4BannerDTO.getName_dep_phy());
		ordApOut.setId_dep_nur_out(ciemsDTO.getId_dept_ns());//离院时病区
		ordApOut.setName_dep_nur_out(ent4BannerDTO.getName_dep_nur());
		ordApOut.setId_bed_out(ent4BannerDTO.getId_bed());//离院时床位
		ordApOut.setName_bed_out(ent4BannerDTO.getName_bed());

		ordApOut.setFg_autopsy(FBoolean.FALSE);//死亡尸检标识

		/*
		ordApOut.setDes_outtp();//离院描述
		ordApOut.setFg_again31();//31日内再次计划住院标识
		ordApOut.setDes_again31();//31日内再入院目的		
		ordApOut.setDef1();//客户扩展字段1
		ordApOut.setDef2();//客户扩展字段2
		ordApOut.setDef3();//客户扩展字段3
		ordApOut.setDef4();//客户扩展字段4
		ordApOut.setDef5();//客户扩展字段5
		ordApOut.setDef6();//客户扩展字段6
		ordApOut.setDef7();//客户扩展字段7
		ordApOut.setDef8();//客户扩展字段8
		ordApOut.setDef9();//客户扩展字段9
		ordApOut.setDef10();//客户扩展字段10
		ordApOut.setCreatedby();//创建人
		ordApOut.setCreatedtime();//创建时间
		ordApOut.setModifiedby();//最后修改人
		ordApOut.setModifiedtime();//最后修改时间
		*/

		ciemsDTO.setEmstype(EmsType.OUTHOSP);
		FMap map = new FMap();
		map.put(EmsType.OUTHOSP + "", ordApOut);
		ciemsDTO.setOrapplysheet(map);
	}

	/**
	 * 获取动态指标
	 */
	private EmsDynamicIndexDTO[] getEmsDynamicIndex(CiEmsDTO ciemsDTO) throws BizException {

		// 医疗单服务类
		IEmsregistryMDORService emsRegistryService = (IEmsregistryMDORService) ServiceFinder
				.find(IEmsregistryMDORService.class);
		EmsDO emsDO = emsRegistryService.findById(ciemsDTO.getId_srvof());

		IBdSrvQryService qryService = (IBdSrvQryService) ServiceFinder.find(IBdSrvQryService.class);

		EmsDynamicParamDTO paramDto = new EmsDynamicParamDTO();
		paramDto.setId_ems(ciemsDTO.getId_srvof());

		// 指标跨就诊标识
		boolean fg_dyncitm_en = emsDO.getFg_dyncitm_crossentp() == FBoolean.TRUE ? true : false;
		paramDto.setFg_dyncitm_en(fg_dyncitm_en);

		// 指标周期类型
		paramDto.setEu_dyncitmunit(emsDO.getEu_dyncitmunit());
		paramDto.setId_ent(ciemsDTO.getId_en());
		paramDto.setId_pat(ciemsDTO.getId_pat());

		// 指标周期下数值
		paramDto.setDyncitmunitct(emsDO.getCnt_dyncitmunit());

		// 获取动态指标
		return qryService.getEmsDynamicIndexInfos(paramDto);

	}

	/**
	 * 跟id集合获取SD对象
	 */
	public static Map<String, UdidocDO> getUdidocById(String[] id_udidocs) throws BizException {

		Map<String, UdidocDO> udidocMap = new HashMap<String, UdidocDO>();
		if (CiOrdUtils.isEmpty(id_udidocs)) {
			return udidocMap;
		}

		IUdidocRService udidocRService = CiOrdAppUtils.getUdidocRService();
		UdidocDO[] udidocs = udidocRService.findByIds(id_udidocs, FBoolean.FALSE);
		for (UdidocDO udidoc : udidocs) {
			udidocMap.put(udidoc.getId_udidoc(), udidoc);
		}

		return udidocMap;

	}
}
