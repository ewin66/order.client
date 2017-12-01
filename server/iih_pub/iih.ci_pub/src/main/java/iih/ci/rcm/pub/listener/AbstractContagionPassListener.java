package iih.ci.rcm.pub.listener;

import iih.bd.bc.event.pub.IMrEventConst;
import iih.ci.mr.cimrpatinfodto.d.CiMrPatInfoDTO;
import iih.ci.mr.i.ICiMrIPService;
import iih.ci.mr.pub.MrConst.IMrPubConst;
import iih.ci.rcm.contagion.d.ContagionDO;
import iih.ci.rcm.contagion.d.HFMDO;
import iih.ci.rcm.contagion.d.HepatitisBDO;
import iih.ci.rcm.contagion.d.StdDO;
import iih.ci.rcm.contagion.d.SyphilisDO;
import iih.ci.rcm.contagion.i.IHFMDORService;
import iih.ci.rcm.contagion.i.IHepatitisBDORService;
import iih.ci.rcm.contagion.i.IStdDORService;
import iih.ci.rcm.contagion.i.ISyphilisDORService;
import iih.ci.rcm.hospitalcontagiondto.d.HospitalContagionDTO;
import iih.ci.rcm.pub.ReportConst.IReportPubConst;

import java.util.Arrays;

import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IEventType;

public class AbstractContagionPassListener extends
		AbstractContagionDOUpdateAfterListener {

	@SuppressWarnings("unchecked")
	@Override
	protected void doActionCiMrDOChange(ContagionDO[] contagionDOs)
			throws BizException {
		ContagionDO contagionDO = contagionDOs[0];

		if (contagionDO == null
				|| contagionDO.getId_con_cardsu() == null
				|| !IReportPubConst.Id_con_cardsu_ok.contains(contagionDO
						.getId_con_cardsu())) {
			return;
		}
		HospitalContagionDTO hospitalContagionDTO = new HospitalContagionDTO();
		hospitalContagionDTO.setId_contagion(contagionDO.getId_contagion());

		FArrayList list = new FArrayList();
		list.addAll(Arrays.asList(contagionDO));
		hospitalContagionDTO.setLs_contagion(list);

		FArrayList list1 = new FArrayList();
		IStdDORService std = ServiceFinder.find(IStdDORService.class);
		StdDO[] stds = std.find(
				"a1.id_contagion = '" + contagionDO.getId_contagion() + "'",
				null, FBoolean.FALSE);
		list1.add(stds.length > 0 ? stds[0] : null);
		hospitalContagionDTO.setLs_std(list1);
		

		ISyphilisDORService syphilis = ServiceFinder
				.find(ISyphilisDORService.class);
		SyphilisDO[] syphs = syphilis.find(
				"a3.id_contagion = '" + contagionDO.getId_contagion() + "'",
				null, FBoolean.FALSE);
		FArrayList list2 = new FArrayList();
		list2.add(syphs.length > 0 ? syphs[0] : null);
		hospitalContagionDTO.setLs_syphilis(list2);


		IHFMDORService hfm = ServiceFinder.find(IHFMDORService.class);
		HFMDO[] hfms = hfm.find(
				"a4.id_contagion = '" + contagionDO.getId_contagion() + "'",
				null, FBoolean.FALSE);
		FArrayList list3 = new FArrayList();
		list3.add(hfms.length > 0 ? hfms[0] : null);
		hospitalContagionDTO.setLs_hfm(list3);


		IHepatitisBDORService hepat = ServiceFinder
				.find(IHepatitisBDORService.class);
		HepatitisBDO[] hepats = hepat.find(
				"a2.id_contagion = '" + contagionDO.getId_contagion() + "'",
				null, FBoolean.FALSE);
		FArrayList list4 = new FArrayList();
		list4.add(hepats.length > 0 ? hepats[0] : null);
		hospitalContagionDTO.setLs_hepatitisb(list4);


		ICiMrIPService ipservice = ServiceFinder.find(ICiMrIPService.class);
		FArrayList list5 = new FArrayList();
		FArrayList list6 = new FArrayList();
		CiMrPatInfoDTO[] patinfoDTOs = ipservice.getCiMrPatInfoDTO(contagionDO.getId_ent());
		int crb_idx = 0;
		if(patinfoDTOs.length>0){
			for (int i = 0; i < patinfoDTOs.length; i++) {
				//现住址
				patinfoDTOs[i].setName_province(contagionDO.getProvince_name());
				patinfoDTOs[i].setStreet(contagionDO.getStreet());
				patinfoDTOs[i].setVillage(contagionDO.getVillage());
				patinfoDTOs[i].setHousenum(contagionDO.getHousenum()+"号");
				//户籍地址
				patinfoDTOs[i].setResidence(contagionDO.getAreafullname());
				patinfoDTOs[i].setTel_num(contagionDO.getMob());
				patinfoDTOs[i].setTel(contagionDO.getTel());
				patinfoDTOs[i].setHzjzxm(contagionDO.getHzjzxm());
				patinfoDTOs[i].setEu_rqfl_name(contagionDO.getEu_rqfl_name());
				patinfoDTOs[i].setEu_rqfl_code(contagionDO.getEu_rqfl_code());
				patinfoDTOs[i].setEu_blfl_name(contagionDO.getEu_blfl_name());
				patinfoDTOs[i].setEu_blfl_code(contagionDO.getEu_blfl_code());
				patinfoDTOs[i].setWorkunit(contagionDO.getWorkunit());
				patinfoDTOs[i].setRevised_name(contagionDO.getRevised_name());
				patinfoDTOs[i].setRetreat_reason(contagionDO.getRetreat_reason());
				patinfoDTOs[i].setEu_nldw_name(contagionDO.getEu_nldw_name());
				patinfoDTOs[i].setEu_brsy_code(contagionDO.getEu_brsy_code());
				patinfoDTOs[i].setEu_brsy_name(contagionDO.getEu_brsy_name());
				patinfoDTOs[i].setEu_rqfl_code(contagionDO.getEu_rqfl_code());
				patinfoDTOs[i].setEu_rqfl_name(contagionDO.getEu_rqfl_name());
				patinfoDTOs[i].setExact_age(contagionDO.getExact_age());
				patinfoDTOs[i].setEu_bklb_code(contagionDO.getEu_bklb_code());
				patinfoDTOs[i].setEu_bklb_name(contagionDO.getEu_bklb_name());
				patinfoDTOs[i].setFbrq(contagionDO.getFbrq());
				patinfoDTOs[i].setZdrq(contagionDO.getZdrq());
				patinfoDTOs[i].setSwrq(contagionDO.getSwrq());
				patinfoDTOs[i].setCode(contagionDO.getCode());
				patinfoDTOs[i].setSd_con_cardsu(contagionDO.getSd_con_cardsu());
				patinfoDTOs[i].setName_con_cardsu(contagionDO.getName_con_cardsu());
				patinfoDTOs[i].setReport_unit_code(contagionDO.getReport_unit_code());
				patinfoDTOs[i].setReport_unit_name(contagionDO.getReport_unit_name());
				patinfoDTOs[i].setDoctor_card(contagionDO.getDoctor_card());
				patinfoDTOs[i].setEu_jlcrb_code(contagionDO.getEu_jlcrb_code());
				patinfoDTOs[i].setEu_jlcrb_name(contagionDO.getEu_jlcrb_name());
				patinfoDTOs[i].setEu_ylcrb_code(contagionDO.getEu_ylcrb_code());
				patinfoDTOs[i].setEu_ylcrb_name(contagionDO.getEu_ylcrb_name());
				patinfoDTOs[i].setEu_blcrb_code(contagionDO.getEu_blcrb_code());
				patinfoDTOs[i].setEu_blcrb_name(contagionDO.getEu_blcrb_name());
				patinfoDTOs[i].setSd_other_diseases(contagionDO.getSd_other_diseases());
				patinfoDTOs[i].setName_other_diseases(contagionDO.getName_other_diseases());
				patinfoDTOs[i].setSd_emp_entry(contagionDO.getSd_emp_entry());
				patinfoDTOs[i].setName_emp_entry(contagionDO.getName_emp_entry());
				patinfoDTOs[i].setDt_contagion(contagionDO.getDt_contagion());
				patinfoDTOs[i].setCode_eu_bqfl(contagionDO.getCode_eu_bqfl());
				patinfoDTOs[i].setName_eu_bqfl(contagionDO.getName_eu_bqfl());
				patinfoDTOs[i].setRemarks(contagionDO.getRemarks());
				if(contagionDO.getEu_jlcrb_code()!=null&&contagionDO.getEu_jlcrb_name()!=null){
					//甲类传染病 赋值给 集成平台
					patinfoDTOs[i].setCode_congation_type(contagionDO.getEu_jlcrb_code());
					patinfoDTOs[i].setName_congation_type("甲类传染病");
					patinfoDTOs[i].setCode_congationnew(contagionDO.getEu_jlcrb_code());
					patinfoDTOs[i].setName_congationnew(contagionDO.getEu_jlcrb_name());
					patinfoDTOs[i].setFg_crb("true");
					crb_idx = 0;
				}
				if(contagionDO.getEu_ylcrb_code()!=null&&contagionDO.getEu_ylcrb_name()!=null){
					//乙类传染病 赋值给 集成平台
					patinfoDTOs[i].setCode_congation_type(contagionDO.getEu_ylcrb_code());
					patinfoDTOs[i].setName_congation_type("乙类传染病");
					patinfoDTOs[i].setCode_congationnew(contagionDO.getEu_ylcrb_code());
					patinfoDTOs[i].setName_congationnew(contagionDO.getEu_ylcrb_name());
					patinfoDTOs[i].setFg_crb("true");
					crb_idx = 1;
				}
				if(contagionDO.getEu_blcrb_code()!=null&&contagionDO.getEu_blcrb_name()!=null){
					//丙类传染病 赋值给 集成平台
					patinfoDTOs[i].setCode_congation_type(contagionDO.getEu_blcrb_code());
					patinfoDTOs[i].setName_congation_type("丙类传染病");
					patinfoDTOs[i].setCode_congationnew(contagionDO.getEu_blcrb_code());
					patinfoDTOs[i].setName_congationnew(contagionDO.getEu_blcrb_name());
					patinfoDTOs[i].setFg_crb("true");
					crb_idx = 2;
				}
				if(contagionDO.getSd_other_diseases()!=null&&contagionDO.getName_other_diseases()!=null){
					//其他传染病 赋值给 集成平台
					patinfoDTOs[i].setCode_congation_type(contagionDO.getSd_other_diseases());
					patinfoDTOs[i].setName_congation_type("其他法定管理以及重点监测传染病");
					patinfoDTOs[i].setCode_congationnew(contagionDO.getSd_other_diseases());
					patinfoDTOs[i].setName_congationnew(contagionDO.getName_other_diseases());
					patinfoDTOs[i].setFg_crb("true");
					crb_idx = 3;
				}
			}
			
		}
		for(int i =0;i<4;i++) {
			if(crb_idx==i) {
				list6.addAll(Arrays.asList(patinfoDTOs));
			} else {
				CiMrPatInfoDTO e = new CiMrPatInfoDTO();
				e.setCode_congation_type("传染病类型code");
				e.setName_congation_type("传染病类型名称");
				e.setCode_congationnew("传染病code");
				e.setName_congationnew("传染病名称");
				e.setFg_crb("false");
				list6.add(e);
			}
		}
		
		list5.addAll(Arrays.asList(patinfoDTOs));
//		list1.add(auditDTOs);
		hospitalContagionDTO.setLs_patient(list5);
		
		list6.addAll(Arrays.asList(patinfoDTOs));
		hospitalContagionDTO.setLs_crb(list6);
		
		// BusinessEvent mrEvent = new
		// BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_CONTAGION_PASS,
		// IEventType.TYPE_UPDATE_AFTER, hospitalContagionDTO);
		// EventDispatcher.fireEvent(mrEvent);

		DomainBusinessUserObj buo = new DomainBusinessUserObj(
				hospitalContagionDTO, IMrPubConst.MZ, "", "0");
		
		// by ldq 2017-08-07
		if (hospitalContagionDTO.getLs_patient() != null) {
			FArrayList fa = (FArrayList) hospitalContagionDTO.getLs_patient();
			if (fa.size() > 0) {
				CiMrPatInfoDTO pa = (CiMrPatInfoDTO) fa.get(0);
				Integer enTimes = null;
				if (pa.getTimes_op() != null&&pa.getCode_ent().equals("01")) {
					enTimes = Integer.parseInt(pa.getTimes_op());
				}
				if (pa.getTimes_ip() != null&&pa.getCode_ent().equals("03")) {
					enTimes = Integer.parseInt(pa.getTimes_ip());
				}
				MsgObj msgObj = new MsgObj("0", pa.getCode_pat(), enTimes,
						pa.getCode_ent(), null, null, null);
				buo.setMsgObj(msgObj);
			}
		}
		
		BusinessEvent event = new BusinessEvent(
				IMrEventConst.EVENT_SOURCE_MR_CONTAGION_PASS,
				IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener =ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
//		try {
//			EventDispatcher.fireEvent(event);
//		} catch (BizException e) {
//			e.printStackTrace();
//		}

	}

	// private <T> FArrayList setDOValues( Class<T> serviceInterface , String
	// whereStr , Object dos ){
	// FArrayList list = new FArrayList();
	// T t = ServiceFinder.find(serviceInterface);
	//
	// return list;
	// }

}
