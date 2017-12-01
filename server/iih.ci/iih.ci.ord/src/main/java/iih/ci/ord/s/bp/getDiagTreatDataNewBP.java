package iih.ci.ord.s.bp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.ci.ord.dto.blexorder.d.DiagTreatKeyPointRntDataDTO;
import iih.ci.ord.dto.blexorder.d.OrGenSplitTpEnum;
import iih.ci.ord.dto.blexorder.d.OrLongTempEnum;
import iih.ci.ord.dto.blexorder.d.OrSplitOrderDTO;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import iih.mp.nr.foreign.d.GetTemDataParamDTO;
import iih.mp.nr.foreign.i.IForeignService;
import iih.mp.nr.temperaturechart.d.Temcharitemdto;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.d.desc.UdidocDODesc;
import xap.sys.xbd.udi.i.IUdidocRService;

public class getDiagTreatDataNewBP {

	private IUdidocRService service = ServiceFinder.find(IUdidocRService.class);
	private Map<String, List<UdidocDO>> map = new HashMap<>();

	public DiagTreatKeyPointRntDataDTO[] exe(String id_en, FDateTime start, FDateTime end,String viewmod) throws BizException {

		IForeignService foreignservice = ServiceFinder.find(IForeignService.class);
		splitOrSplitSqlRsBP orbp = new splitOrSplitSqlRsBP();
		splitSrvSplitSqlRsBP srvbp = new splitSrvSplitSqlRsBP();
		setUdidocs();
		List<FDate> fl=new ArrayList<>();
		List<DiagTreatKeyPointRntDataDTO> rntlist = new ArrayList<>();
		Map<String, DiagTreatKeyPointRntDataDTO> dmap=new HashMap<>();

		setDate4Dic(fl,dmap, start,  end);
		// 检验拆分数据
		OrSrvSplitParamDTO labparam = new OrSrvSplitParamDTO();
		labparam.setId_ens(id_en);
		labparam.setDt_split_start(start);
		labparam.setDt_split_end(end);
		labparam.setEu_orlongtemp(OrLongTempEnum.ALL);
		labparam.setEu_orgensplittp(OrGenSplitTpEnum.SPLITBYOR);
		labparam.setSd_srvtps(getSrvStr("lab"));
		OrSplitOrderDTO[] labdtos = orbp.exec(labparam);
        if(labdtos!=null){
		//按日期分类
		for (OrSplitOrderDTO o : labdtos) {

			FDate a=o.getDt_mp_plan().getDate();
			if(dmap.containsKey(a.toString())){
				DiagTreatKeyPointRntDataDTO tmp = dmap.get(a.toString());
				FArrayList2 labfa =tmp.getLabdata();
				if(labfa==null){
					labfa=new FArrayList2();
					tmp.setLabdata(labfa);
				}
				labfa.add(o);

			}
		}
        }
		// 检查拆分数据
		OrSrvSplitParamDTO obsparam = new OrSrvSplitParamDTO();
		obsparam.setId_ens(id_en);
		obsparam.setDt_split_start(start);
		obsparam.setDt_split_end(end);
		obsparam.setEu_orlongtemp(OrLongTempEnum.ALL);
		obsparam.setEu_orgensplittp(OrGenSplitTpEnum.SPLITBYOR);
		obsparam.setSd_srvtps(getSrvStr("obs"));
		OrSplitOrderDTO[] obsdtos = orbp.exec(obsparam);

		if(obsdtos!=null){
		//按日期分类
		for (OrSplitOrderDTO o : obsdtos) {

			FDate a=o.getDt_mp_plan().getDate();
			if(dmap.containsKey(a.toString())){
				DiagTreatKeyPointRntDataDTO tmp = dmap.get(a.toString());
				FArrayList2 labfa =tmp.getObsdata();
				if(labfa==null){
					labfa=new FArrayList2();
					tmp.setObsdata(labfa);
				}
				labfa.add(o);
				
			}
		}
		}
		// 生命体征数据
		GetTemDataParamDTO tmpparam = new GetTemDataParamDTO();
		tmpparam.setId_ent(id_en);
		tmpparam.setDt_begin(start);
		tmpparam.setDt_end(end);
		tmpparam.setFg_temsheet(FBoolean.TRUE);
		Temcharitemdto[] temp1 = foreignservice.getTemData(tmpparam);
if(temp1!=null){
		//按日期分类
		for (Temcharitemdto o : temp1) {

			FDate a=o.getLogtime().getDate();
			if(dmap.containsKey(a.toString())){
				DiagTreatKeyPointRntDataDTO tmp = dmap.get(a.toString());
				FArrayList2 labfa =tmp.getBodysignsdata();
				if(labfa==null){
					labfa=new FArrayList2();
					tmp.setBodysignsdata(labfa);
				}
				labfa.add(o);	
				
			}
		}
}
		//获取药品数据
		OrSrvSplitParamDTO srvparam = new OrSrvSplitParamDTO();
		srvparam.setId_ens(id_en);
		srvparam.setDt_split_start(start);
		srvparam.setDt_split_end(end);
		srvparam.setEu_orlongtemp(OrLongTempEnum.ALL);
		srvparam.setEu_orgensplittp(OrGenSplitTpEnum.SPLITBYSRVMM);
		srvparam.setSd_srvtps(getSrvStr("drug"));
		SrvSplitOrderDTO[] srvdtos = null;
		if(srvdtos!=null){
      	////按日期分类
        	for (SrvSplitOrderDTO srvSplitOrderDTO : srvdtos) {
        		FDate a=srvSplitOrderDTO.getDt_mp_plan().getDate();
    			if(dmap.containsKey(a.toString())){
    				DiagTreatKeyPointRntDataDTO tmp = dmap.get(a.toString());
    				FArrayList2 labfa =tmp.getDrugdata();
    				if(labfa==null){
    					labfa=new FArrayList2();
    					tmp.setDrugdata(labfa);
    				}
    				labfa.add(srvSplitOrderDTO);	
    				
    			}
			}
		}
        //数据组装
        for (FDate fDate : fl) {
        	rntlist.add(dmap.get(fDate.toString()));
		}
		return rntlist.toArray(new DiagTreatKeyPointRntDataDTO[0]);

	}

	private String getSrvStr(String code) {

		String str = null;

		String s = "";
		List<UdidocDO> udis = map.get(code);
		for (UdidocDO udi : udis) {
			s += udi.getCode() + ",";
		}

		str = s.substring(0, s.length() - 2);

		return str;
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
				+ IBdSrvDictCodeConst.SD_SRVTP_CYDRUG + "%') and (" + aliname + ".code!='" + IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_DSY + "' and " + aliname + ".code!='"
				+ IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_PSY + "')))  ";
	}
	
	private void setDate4Dic(List<FDate> fl,Map<String, DiagTreatKeyPointRntDataDTO> dmap, FDateTime start, FDateTime end){
	//	start.getDate().getDateAfter(1);
		int len=start.getDate().getDaysBetween(start.getDate(), end.getDate());
		int i=0;
		
		for(i=0;i<=len;i++){
			FDate f=start.getDate().getDateAfter(i);
			DiagTreatKeyPointRntDataDTO dto=new DiagTreatKeyPointRntDataDTO();
			dto.setDt_keypoint(f);
			dmap.put(f.toString(), dto);
			fl.add(f);
		}
	}

}
