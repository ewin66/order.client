package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.ci.ord.dto.blexorder.d.DiagTreatViewRntDataDTO;
import iih.ci.ord.dto.blexorder.d.OrGenSplitTpEnum;
import iih.ci.ord.dto.blexorder.d.OrLongTempEnum;
import iih.ci.ord.dto.blexorder.d.OrSplitOrderDTO;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import iih.ci.ord.dto.blexorder.d.TransSrvSplitOrderDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.en.pv.dto.d.IpBasicDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.mp.nr.foreign.d.GetTemDataParamDTO;
import iih.mp.nr.foreign.i.IForeignService;
import iih.mp.nr.temperaturechart.d.Temcharitemdto;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.d.desc.UdidocDODesc;
import xap.sys.xbd.udi.i.IUdidocRService;

public class getDiagTreatViewDataBP {

	private IUdidocRService service = ServiceFinder.find(IUdidocRService.class);
	private Map<String, List<UdidocDO>> map = new HashMap<>();

	public DiagTreatViewRntDataDTO exe(OrSrvSplitParamDTO orparams) throws BizException {
//        Date a=new Date();
//        Long al=(new Date()).getTime();hh
		if(orparams==null)return null;
		DiagTreatViewRntDataDTO rntdto = new DiagTreatViewRntDataDTO();
		FDateTime start=null;
		FDateTime end=null;  
		
		if(orparams.getDt_split_start()==null){
			IEnOutQryService enservice=ServiceFinder.find(IEnOutQryService.class);
			IpBasicDTO ip=enservice.getIpBasicInfo(orparams.getId_ens());
			start=ip.getDt_acpt();
		}else{
			
			start=(FDateTime)orparams.getDt_split_start();
		}
		if(orparams.getDt_split_end()==null){
			
		FDateTime	e1=CiOrdAppUtils.getServerDateTime();
//		Date d=new Date(e1.getYear(),e1.getMonth(),e1.getDay(),23,59,59);
		String dstr=e1.getYear()+"-"+e1.getMonth()+"-"+e1.getDay()+" "+23+":"+59+":"+59;
		end=new FDateTime(dstr);
		}else{
			end=(FDateTime)orparams.getDt_split_end();
		}
		rntdto.setDt_start(start);
		rntdto.setDt_end(end);
		IForeignService foreignservice = ServiceFinder.find(IForeignService.class);
		splitOrSplitSqlRsBP orbp = new splitOrSplitSqlRsBP();
		splitSrvSplitSqlRsBP srvbp = new splitSrvSplitSqlRsBP();
		setUdidocs();
		
		// 用药拆分数据
		OrSrvSplitParamDTO srvparam = new OrSrvSplitParamDTO();
		srvparam.setId_ens(orparams.getId_ens());
		srvparam.setDt_split_start(start);
		srvparam.setDt_split_end(end);
		srvparam.setEu_orlongtemp(OrLongTempEnum.ALL);
		srvparam.setEu_orgensplittp(OrGenSplitTpEnum.SPLITBYSRVMM);
		srvparam.setSd_srvtps(getSrvStr("drug"));
		TransSrvSplitOrderDTO[] srvdtos = srvbp.exec(srvparam);
		FArrayList2 fa = new FArrayList2();
		if (srvdtos != null)
			Collections.addAll(fa, srvdtos);
		rntdto.setDrugdata(fa);
		// 检验拆分数据
		OrSrvSplitParamDTO labparam = new OrSrvSplitParamDTO();
		labparam.setId_ens(orparams.getId_ens());
		labparam.setDt_split_start(start);
		labparam.setDt_split_end(end);
		labparam.setEu_orlongtemp(OrLongTempEnum.ALL);
		labparam.setEu_orgensplittp(OrGenSplitTpEnum.SPLITBYOR);
		labparam.setSd_srvtps(getSrvStr("lab"));
		OrSplitOrderDTO[] labdtos = orbp.exec(labparam);
		FArrayList2 labfa = new FArrayList2();
		if (labdtos != null)
			Collections.addAll(labfa, labdtos);
		rntdto.setLabdata(labfa);
		// 检查拆分数据
		OrSrvSplitParamDTO obsparam = new OrSrvSplitParamDTO();
		obsparam.setId_ens(orparams.getId_ens());
		obsparam.setDt_split_start(start);
		obsparam.setDt_split_end(end);
		obsparam.setEu_orlongtemp(OrLongTempEnum.ALL);
		obsparam.setEu_orgensplittp(OrGenSplitTpEnum.SPLITBYOR);
		obsparam.setSd_srvtps(getSrvStr("obs"));
		OrSplitOrderDTO[] obsdtos = orbp.exec(obsparam);
		FArrayList2 obsfa = new FArrayList2();
		if (obsdtos != null)
			Collections.addAll(obsfa, obsdtos);
		rntdto.setObsdata(obsfa);
		// 生命体征数据
		GetTemDataParamDTO tmpparam = new GetTemDataParamDTO();
		tmpparam.setId_ent(orparams.getId_ens());
		tmpparam.setDt_begin(start);
		tmpparam.setDt_end(end);
		tmpparam.setFg_temsheet(FBoolean.TRUE);
		Temcharitemdto[] temp1 = foreignservice.getTemData(tmpparam);
		FArrayList2 tmpfa = new FArrayList2();
		if (temp1 != null)
			Collections.addAll(tmpfa, temp1);
		rntdto.setBodysignsdata(tmpfa);
//		Date b=new Date();
//		Long bl=(new Date()).getTime();
		
		//病历文书
		GetCiMr4DiagTreatBP cimrbp=new GetCiMr4DiagTreatBP();
		Map<String,FArrayList2> cimrmap=cimrbp.exe(orparams.getId_ens(),start,end);
		rntdto.setCimrs(cimrmap.get("CiMrDO"));
		rntdto.setMrctmcas(cimrmap.get("MrCtmCaDO"));
		return rntdto;

	}

	private String getSrvStr(String code) {

		String str = null;

		StringBuilder s = new StringBuilder();
		List<UdidocDO> udis = map.get(code);
		for (UdidocDO udi : udis) {
			if(s.length()==0){
				s.append(udi.getCode());
			}else{
				s.append(","+udi.getCode());
			}
		}

		

		return s.toString();
	}

	private void setUdidocs() throws BizException {
		map.clear();

		String filter = getsrvfilter();
		UdidocDO[] udis = service.find(filter, "", FBoolean.TRUE);

		for (UdidocDO udidocDO : udis) {
			String udicode = udidocDO.getCode();
			if (udicode.startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)) {
				if (!map.containsKey("obs")) {
					List<UdidocDO> udilist = new ArrayList<UdidocDO>();
					udilist.add(udidocDO);
					map.put("obs", udilist);

				} else {
					List<UdidocDO> udilist = map.get("obs");
					udilist.add(udidocDO);
				}
			}

			if ((udicode.startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG) || udicode.startsWith(IBdSrvDictCodeConst.SD_SRVTP_CYDRUG)) && !udicode.equals(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_DSY)
					&& !udicode.equals(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_PSY)) {
				if (!map.containsKey("drug")) {
					List<UdidocDO> udilist = new ArrayList<UdidocDO>();
					udilist.add(udidocDO);
					map.put("drug", udilist);

				} else {
					List<UdidocDO> udilist = map.get("drug");
					udilist.add(udidocDO);
				}
			}

			if (udicode.startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)) {
				if (!map.containsKey("lab")) {
					List<UdidocDO> udilist = new ArrayList<UdidocDO>();
					udilist.add(udidocDO);
					map.put("lab", udilist);

				} else {
					List<UdidocDO> udilist = map.get("lab");
					udilist.add(udidocDO);
				}
			}
		}

	}

	private String getsrvfilter() {
		String aliname = UdidocDODesc.TABLE_ALIAS_NAME;
		return aliname + ".id_udidoclist ='" + IBdSrvDictCodeTypeConst.ID_SRVTP + "' and ((" + aliname + ".code like '" + IBdSrvDictCodeConst.SD_SRVTP_RIS + "%') or (" + aliname + ".code like '"
				+ IBdSrvDictCodeConst.SD_SRVTP_LIS + "%') or ((" + aliname + ".code like '" + IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG + "%' or " + aliname + ".code like '"
				+ IBdSrvDictCodeConst.SD_SRVTP_CYDRUG + "%') and (" + aliname + ".code<>'" + IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_DSY + "' and " + aliname + ".code<>'"
				+ IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_PSY + "')))  ";
	}

}
