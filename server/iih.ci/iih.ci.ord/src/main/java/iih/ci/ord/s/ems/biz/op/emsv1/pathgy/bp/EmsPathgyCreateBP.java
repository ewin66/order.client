package iih.ci.ord.s.ems.biz.op.emsv1.pathgy.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedSrvLisDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import iih.ci.ord.ciordems.d.EmsPathgyItemDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.d.ems.ems.EmsCrtDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.ems.biz.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.biz.op.base.bp.EmsBaseCreateBP;
import iih.ci.ord.s.ems.biz.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.biz.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsExtInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsPriceUtils;
import iih.ci.ord.s.ems.biz.utils.StringCodingUtils;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 病理医疗单创建逻辑
 * 
 * @author wangqingzhu
 *
 */
public class EmsPathgyCreateBP extends EmsBaseCreateBP {

	/**
	 * 创建医疗单UI对象
	 */
	@Override
	public EmsRstDTO[] create(EmsCrtDTO[] emsarray) throws BizException {
		EmsCrtDTO ems = emsarray[0];
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();
		EmsRstDTO rst = new EmsRstDTO();

		// 获取主服务信息
		MedsrvAggDO aggDO = ServiceFinder.find(IMedsrvRService.class).findById(ems.getId_srv());
		if (aggDO == null) {
			throw new BizException("查询主服务信息失败！", CiOrdemsErrorCodeEnum.ERRORCODE_EMS_MAINSRV_NULL);
		}

		// 合成主UI模型对象
		EmsPathgyItemDO emsModel = getCache(L1SessionKeyWith(ems.getEnContext()), ems.getId_srv());

		FDateTime tm = CiOrdAppUtils.getServerDateTime();
		if (null == emsModel) {
			emsModel = emsModelFrom(aggDO.getParentDO());
			putCache(L1SessionKeyWith(ems.getEnContext()), ems.getId_srv(), emsModel);
		}

		{
			emsModel.setNo_applyform(CiOrdUtils.getApplyNo(aggDO.getParentDO().getSd_srvtp()));// 申请单号
			emsModel.setId_emp_coll(ems.getEnContext().getPsnInfo().getId_psndoc());// 采集者id
			emsModel.setName_emp_coll(ems.getEnContext().getPsnInfo().getName()); // 采集者
			emsModel.setId_emp_create(ems.getEnContext().getPsnInfo().getId_psndoc());// 申请医生id
			emsModel.setName_emp_create(ems.getEnContext().getPsnInfo().getName());// 申请医师
			emsModel.setDes_sympsign(this.clinicalzztzFrom(ems.getEnContext().getId_en())); // 病情描述
			emsModel.setOrg_pathgy_old(ems.getEnContext().getOrg().getName());// 既往病理医院
			emsModel.setDt_coll(tm);// 采集时间 SINGLE
			emsModel.setDt_begin_ui(tm); // SINGLE
			emsModel.setDt_end_ui(new FDateTime(tm.getBeginDate().getDateAfter(1), tm.getUFTime()));
			emsModel.setDt_create(tm);// 申请时间 SINGLE
			emsModel.setDt_pathgy_old(tm);// 既往病理日期
		}

		//诊断信息
		DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(ems.getEnContext().getId_en());
		if (diagOutlineInfo != null) {
			emsModel.setId_di(diagOutlineInfo.getId_di());// 主诊断的主项目id
			emsModel.setId_diitm(diagOutlineInfo.getId_diitm());// 主诊断id
			emsModel.setName_diag(diagOutlineInfo.getName_diag());// 主诊断名称
			emsModel.setStr_code_di(diagOutlineInfo.getStr_code_di());// 诊断编码拼接
			emsModel.setStr_name_di(diagOutlineInfo.getStr_name_di());// 诊断名称拼接
			emsModel.setStr_id_diitm(diagOutlineInfo.getStr_id_diitm());// 诊断子项目id拼接

			OrderEmsExtInfoUtils.SetDiInfo(rst, diagOutlineInfo.toFMap());
		}

		// 获取执行科室
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ems.getEnContext(), aggDO.getParentDO(), "", "");
		if (null == wf) {
			// 封装错误信息
			FArrayList errorlist = new FArrayList();
			errorlist.append("获取执行科室失败");
			OrderEmsExtInfoUtils.SetErrMsg(rst, errorlist);
			rsts.add(rst);
			return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
		}
		emsModel.setId_dep_coll(wf.getFirstid_mp_dept());
		emsModel.setName_dep_coll(wf.getFirstname_mp_dept());
		emsModel.setId_mp_dep(wf.getFirstid_mp_dept());
		emsModel.setName_mp_dep(wf.getFirstname_mp_dept());
		// 计算价格
		emsModel.setPrice(OrderEmsPriceUtils.calculatePrice(aggDO.getParentDO(), ems.getEnContext().getEnt4BannerDTO()
				.getId_pripat()));
		emsModel.setStatus(DOStatus.NEW);
		// 主服务对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, aggDO.getParentDO());
		// 保存执行科室过滤条件
		OrderEmsExtInfoUtils.SetMpDepFilter(rst, wf.getId_mp_depts());
		// 保存物资流向
		OrderEmsExtInfoUtils.SetWhDepFilter(rst, wf.getId_dept_whs());
		OrderEmsExtInfoUtils.SetWhDepId(rst, wf.getId_dept_wh());
		OrderEmsExtInfoUtils.SetWhDepName(rst, wf.getName_dept_wh());

		rst.setDocument(this.handleReturnDocument(emsModel));
//		rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(emsModel.serializeJson()));
		rst.setEmsDriver(EmsType.PATHGY.toString());
		rsts.add(rst);
		return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
	}

	/**
	 * 获取病理服务基础数据信息
	 * 
	 * @param med
	 * @return
	 * @throws BizException
	 */
	private EmsPathgyItemDO emsModelFrom(MedSrvDO med) throws BizException {
		EmsPathgyItemDO ems = new EmsPathgyItemDO();

		MedSrvLisDO[] labs = ServiceFinder.find(IMedSrvLisDORService.class).find(
				String.format("a1.id_srv = '%s'", med.getId_srv()), "", FBoolean.FALSE);

		MedSrvLisDO lab = new MedSrvLisDO();
		if (null == labs || labs.length == 0) {
			throw new BizException("获取标本信息失败，请检查基础数据！");
		}
		lab = labs[0];

		// 界面展示，绑定赋值数据
		ems.setId_srv(med.getId_srv()); // 病理项目id REF 医疗服务 20 医疗服务
		ems.setName_srv(med.getName()); // 病理项目 SINGLE String 50
		// ems.setId_di // 诊断id REF 医疗服务_疾病诊断定
		// ems.setName_di // 诊断 SINGLE String 50
		ems.setFg_urgent(FBoolean.TRUE);// 加急标识 SINGLE FBoolean
		ems.setId_samptp(lab.getId_samptp());// 标本类型id REF 标本类型_自定义档案
		ems.setSd_samptp(lab.getSd_samptp());// 标本类型编码 SINGLE String 50
		ems.setName_samptp(lab.getSamptp_name());// 标本类型 SINGLE String 50
		// ems.setId_dep_coll //标本采集科室id REF 部门 20
		// ems.setName_dep_coll //标本采集科室 SINGLE String

		ems.setUse_days(1);

		GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
		Integer totalTimes = totalTimesBP.getTotalTimes(med.getId_freq(), ems.getUse_days());
		ems.setTimes_cur(totalTimes);

		ems.setQuan(med.getQuan_med().intValue());// 标本数量
		ems.setId_colltp(lab.getId_colltp());// 采集方法id
		ems.setSd_colltp(lab.getSd_colltp());// 采集方法编号
		ems.setDes_labsamp(lab.getDes_labsamp());// 标本说明

		// 界面填写数据，不绑定数据
		// ems.setAnnouncements // 检查要求 SINGLE String 150

		// SINGLE 备注
		// 300
		// ems.setFg_outer //外院标志 SINGLE FBoolean
		// 本院：选择既往病理号、既往病理诊断、既往病理日期、既往病理医院为本院
		// 外院：医生勾选外院标志，既往病理号置空，既往病理诊断、既往病理日期、既往病理医院手填
		// ems.setNo_pathgy_old //既往病理号 SINGLE String
		// ems.setId_di_pathgy_old //既往病理诊断id REF 医疗服务_疾病诊
		// ems.setName_di_pathgy_old //既往病理诊断 SINGLE String
		// ems.setCollectdes //采集所见 SINGLE String 50

		// 界面未展示数据，绑定时未获取值
		////// headDo.Emsappathgy.Id_ordpathgyitem //主键id SINGLE String 50
		////// headDo.Emsappathgy.Id_or //医嘱id SINGLE String 20
		////// headDo.Emsappathgy.Id_orsrv //医嘱服务id SINGLE String 50
		////// headDo.Emsappathgy.No_pathgy //病理号 SINGLE String 50
		////// headDo.Emsappathgy.Dt_rptpathgy //报告发布时间 SINGLE FDateTim
		////// headDo.Emsappathgy.Str_id_di /诊断idi拼接字符串 SINGLE Stri
		////// headDo.Emsappathgy.Str_name_di //诊断名字拼接字符串 SINGLE Stri
		////// headDo.Emsappathgy.Sv //版本号
		////// headDo.Emsappathgy.Name_colltp //采集方法名称

		return ems;
	}

	/**
	 * 临床体征
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private String clinicalzztzFrom(String id_ent) throws BizException {
		// 临床症状和体征
		StringBuffer clinialBuffer = null;

		IMrdocrefvalueRService mrdocservice = ServiceFinder.find(IMrdocrefvalueRService.class);
		String sql = String.format("id_ent='%s' and code_element in ('%s','%s','%s')", id_ent,
				ICiDictCodeConst.CODE_ELEMENT_MAINSUIT, ICiDictCodeConst.CODE_ELEMENT_NOWDISEASE,
				ICiDictCodeConst.CODE_ELEMENT_TEST);

		MrDocRefValueDO[] szMrDocRefValueDO = mrdocservice.find(sql, "", FBoolean.FALSE);
		if (szMrDocRefValueDO != null && szMrDocRefValueDO.length > 0) {
			clinialBuffer = new StringBuffer();
			MrDocRefValueDO itemMainSuit = null, itemNowDise = null, itemTest = null;
			for (MrDocRefValueDO o : szMrDocRefValueDO) {
				// 主诉
				if (itemMainSuit == null && o.getCode_element().equals(ICiDictCodeConst.CODE_ELEMENT_MAINSUIT)) {
					itemMainSuit = o;
				}
				// 现病史
				if (itemNowDise == null && o.getCode_element().equals(ICiDictCodeConst.CODE_ELEMENT_NOWDISEASE)) {
					itemNowDise = o;
				}
				// 体格检查
				if (itemTest == null && o.getCode_element().equals(ICiDictCodeConst.CODE_ELEMENT_TEST)) {
					itemTest = o;
				}
			}
			if (itemMainSuit != null && !CiOrdUtils.isEmpty(itemMainSuit.getContent())) {
				clinialBuffer.append("以" + itemMainSuit.getContent() + "之主诉就诊。").append(System.lineSeparator());
			}

			if (itemNowDise != null && !CiOrdUtils.isEmpty(itemNowDise.getContent())) {
				clinialBuffer.append(itemNowDise.getContent()).append(System.lineSeparator());
			}

			if (itemTest != null && !CiOrdUtils.isEmpty(itemTest.getContent())) {
				clinialBuffer.append(itemTest.getContent());
			}
			return clinialBuffer.toString();
		}
		return null;
	}
}
