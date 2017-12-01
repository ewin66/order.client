package iih.ci.ord.s.bp.ciprn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.ems.d.EmsPrnTmplRelPresDO;
import iih.bd.srv.ems.d.EmsPrnTmplRelSrvDO;
import iih.bd.srv.ems.d.EmsprntmplAggDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciprn.d.MatchResultDTO;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.s.bp.ciprn.qry.GetPres8OrdSrvDOQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;

public class MatchEmsprntmplBP {

	private String id_hp, sd_hptp, paramUsageScope;
	
	private int selectedIndex;
	
	private List<String> lstIdor, lstIdpres;
	
	private CiOrderDO[] ciOrderDOs;
	private List<String> lstIdor_Injection; //注射医嘱ID
    private List<CiPresDO> lstCiPresDOs;//处方
    private List<CiOrderDO> lstCiOrderDOs_App;//申请单医嘱
	
	public MatchEmsprntmplBP(String id_hp, String sd_hptp, String paramUsageScope, int selectedIndex, String[] idors, String[] idpres){
		this.id_hp = id_hp;
		this.sd_hptp = sd_hptp;
        this.selectedIndex = selectedIndex;
        this.lstIdor = (idors == null ? new ArrayList<String>() : java.util.Arrays.asList(idors));
        this.lstIdpres = (idpres == null ? new ArrayList<String>() : java.util.Arrays.asList(idpres));
        this.paramUsageScope = paramUsageScope;
        
        this.ciOrderDOs = new CiOrderDO[] {};
        this.lstIdor_Injection = new ArrayList<String>();
        this.lstCiPresDOs = new ArrayList<CiPresDO>();
        this.lstCiOrderDOs_App = new ArrayList<CiOrderDO>();
	}
	
	public MatchResultDTO[] exec(EmsprntmplAggDO[] aggDOs) throws BizException{
		getPrintData();
		Map<String, List<String>> map = matchUrlIDs(aggDOs);
		
		CiprnSaveTreatexecDataBP bp = new CiprnSaveTreatexecDataBP();
		bp.exec(this.lstIdor_Injection.toArray(new String[] {}), this.id_hp, this.sd_hptp);

		List<MatchResultDTO> lstdtos = new ArrayList<MatchResultDTO>();
		for (String key : map.keySet()) {
			MatchResultDTO dto = new MatchResultDTO();
			dto.setTmplurl(key);
			FArrayList lst = new FArrayList();
			for (String str : map.get(key)) {
				lst.append(str);
			}
			dto.setIds(lst);
			lstdtos.add(dto);
		}

		return lstdtos.toArray(new MatchResultDTO[] {});
	}
	
	

	private void getPrintData() throws BizException
    {
        switch (this.selectedIndex)
        {
            case 0:
            case 2:
                this.ciOrderDOs = CiprnUtils.GetCiOrderDOByIds(this.lstIdor);
                this.getPresAndInjectData();
                break;
            case 1:
                CiPresDO[] presDOs = CiprnUtils.GetCiPresDOs(this.lstIdpres);
                if (presDOs != null && presDOs.length > 0)
                    this.lstCiPresDOs = java.util.Arrays.asList(presDOs);
                break;
        }
    }
	
	private void getPresAndInjectData() throws BizException
    {
        if (this.ciOrderDOs == null || this.ciOrderDOs.length <= 0) return;

        this.lstCiPresDOs.clear();
        this.lstIdor_Injection.clear();

        List<String> lstIdroutes = StringUtils.isNullOrEmpty(this.paramUsageScope) ? new ArrayList<String>() : java.util.Arrays.asList(paramUsageScope.split(","));

        String strIdors = "";
        for (CiOrderDO order:this.ciOrderDOs)
        {
            switch (order.getSd_srvtp().substring(0, 2))
            {
                case IBdSrvDictCodeConst.SD_SRVTP_DRUG:
                    strIdors += ",'" + order.getId_or() + "'";
                    if (lstIdroutes.contains(order.getId_route()))
                    {
                        if (!lstIdor_Injection.contains(order.getId_or()))
                            lstIdor_Injection.add(order.getId_or());
                    }
                    break;
                default:
                    this.lstCiOrderDOs_App.add(order);
                    break;
            }
        }

        //处方
        if (strIdors.length() > 0)
        {
        	ITransQry qry = new GetPres8OrdSrvDOQry(strIdors.substring(1));
            OrdSrvDO[] ordSrvDOs = (OrdSrvDO[])AppFwUtil.getDORstWithDao(qry, OrdSrvDO.class);
            if (ordSrvDOs != null && ordSrvDOs.length > 0)
            {
                List<String> ids_pres = new ArrayList<String>();
                for (OrdSrvDO srv:ordSrvDOs)
                {
                    if (srv.getId_pres() != null)
                    {
                        if (!ids_pres.contains(srv.getId_pres()))
                            ids_pres.add(srv.getId_pres());
                    }
                }
                if (ids_pres.size() > 0)
                {
                    CiPresDO[] presDOs = CiprnUtils.GetCiPresDOs(ids_pres);
                    if (presDOs != null && presDOs.length > 0)
                        this.lstCiPresDOs = java.util.Arrays.asList(presDOs);
                }
            }
        }
    }

	private Map<String,List<String>> matchUrlIDs(EmsprntmplAggDO[] emsprntmplAggDOs){
		Map<String,List<String>> map=new HashMap<String,List<String>>();
		for (EmsprntmplAggDO aggDo:emsprntmplAggDOs){
            List<String> lstParamIds = new ArrayList<String>();
            if (aggDo.getParentDO().getSd_ciprintsheettp().equals(ICiDictCodeConst.SD_CIPRNSHEETTP_INJECAPP))//注射治疗单
            {
                matchInjc(lstParamIds);
            }
            else if (aggDo.getParentDO().getSd_ciprintsheettp().equals(ICiDictCodeConst.SD_CIPRNSHEETTP_COSTBILL))//诊疗费用清单
            {
                matchFee(lstParamIds);
            }
            else
            {
                if (!(!StringUtils.isNullOrEmpty(aggDo.getParentDO().getFg_mm_ciprnsheettp()) && aggDo.getParentDO().getFg_mm_ciprnsheettp().equals("Y") ?
                    matchPres(aggDo, lstParamIds) : matchApp(aggDo, lstParamIds)))
                    continue;
            }

            if (lstParamIds.size() > 0)
            {
                if (map.containsKey(aggDo.getParentDO().getTmplurl()))
                {
                    List<String> lst = map.get(aggDo.getParentDO().getTmplurl());
                    for (String id:lstParamIds)
                    {
                        if (!lst.contains(id)) map.get(aggDo.getParentDO().getTmplurl()).add(id);
                    }
                }
                else
                {
                	map.put(aggDo.getParentDO().getTmplurl(), lstParamIds);
                }
            }
        }
        return map;
    }

    private void matchInjc(List<String> lstParamIds){
        if (this.lstIdor_Injection != null && this.lstIdor_Injection.size() > 0){
        	lstParamIds.addAll(this.lstIdor_Injection);
        }
    }

    private void matchFee(List<String> lstParamIds)
    {
    	lstParamIds.addAll(this.lstIdor);
    }

    private boolean matchPres(EmsprntmplAggDO aggDo, List<String> lstParamIds)
    {
        if (this.lstCiPresDOs == null || this.lstCiPresDOs.size() <= 0) return false;
        //获得模板路径下的处方类型
        EmsPrnTmplRelPresDO[] relPresDOs = aggDo.getEmsPrnTmplRelPresDO();
        if (relPresDOs == null || relPresDOs.length <= 0) return false;
        List<EmsPrnTmplRelPresDO> lstRelPresDOsAdd = new ArrayList<EmsPrnTmplRelPresDO>();
        List<EmsPrnTmplRelPresDO> lstRelPresDOsRemove = new ArrayList<EmsPrnTmplRelPresDO>();
        for(EmsPrnTmplRelPresDO relPresDO:relPresDOs){
        	if (relPresDO.getEu_direct() != null){
                if (relPresDO.getEu_direct().intValue() > 0){
                    lstRelPresDOsAdd.add(relPresDO);
                }
                else{
                    lstRelPresDOsRemove.add(relPresDO);
                }
            }
        }

        for (EmsPrnTmplRelPresDO relPresDO:lstRelPresDOsAdd){
            for (CiPresDO presDo:this.lstCiPresDOs){
                boolean bMatch = false;
                switch (relPresDO.getEu_presprnrelfactortp()){
                    case "2":
                        if (StringUtils.isNullOrEmpty(presDo.getSd_prestpword())) continue;
                        List<String> prestpwordList = new ArrayList<String>();
                        prestpwordList = java.util.Arrays.asList(presDo.getSd_prestpword().split(","));
                        bMatch = prestpwordList.contains(relPresDO.getSd_prestpword());
                        break;
                    case "1":
                        if (StringUtils.isNullOrEmpty(presDo.getSd_prestp())) continue;
                        bMatch = presDo.getSd_prestp().equals(relPresDO.getSd_prestp());
                        break;
                }
                if (bMatch)
                {
                    if (!lstParamIds.contains(presDo.getId_pres()))
                        lstParamIds.add(presDo.getId_pres());
                }
            }
        }
        for (EmsPrnTmplRelPresDO relPresDO:lstRelPresDOsRemove)
        {
            for (CiPresDO presDo:this.lstCiPresDOs)
            {
                boolean bMatch = false;
                switch (relPresDO.getEu_presprnrelfactortp())
                {
                    case "2":
                        if (StringUtils.isNullOrEmpty(presDo.getSd_prestpword())) continue;
                        List<String> prestpwordList = new ArrayList<String>();
                        prestpwordList = java.util.Arrays.asList(presDo.getSd_prestpword().split(","));
                        bMatch = prestpwordList.contains(relPresDO.getSd_prestpword());
                        break;
                    case "1":
                        if (StringUtils.isNullOrEmpty(presDo.getSd_prestp())) continue;
                        bMatch = presDo.getSd_prestp().equals(relPresDO.getSd_prestp());
                        break;
                }
                if (bMatch)
                {
                    if (lstParamIds.contains(presDo.getId_pres()))
                        lstParamIds.remove(presDo.getId_pres());
                }
            }
        }
        return true;
    }

    private boolean matchApp(EmsprntmplAggDO aggDo, List<String> lstParamIds){
        if (lstCiOrderDOs_App.size() <= 0) return false;
        EmsPrnTmplRelSrvDO[] relSrvDOs = aggDo.getEmsPrnTmplRelSrvDO();
        if (relSrvDOs == null || relSrvDOs.length <= 0) return false;
        List<EmsPrnTmplRelSrvDO> lstRelSrvDOsAdd = new ArrayList<EmsPrnTmplRelSrvDO>();
        List<EmsPrnTmplRelSrvDO> lstRelSrvDOsRemove = new ArrayList<EmsPrnTmplRelSrvDO>();
        for(EmsPrnTmplRelSrvDO relSrvDO:relSrvDOs){
        	if (relSrvDO.getEu_direct() != null){
                if (relSrvDO.getEu_direct().intValue() > 0){
                    lstRelSrvDOsAdd.add(relSrvDO);
                }
                else{
                    lstRelSrvDOsRemove.add(relSrvDO);
                }
            }
        }

        for (EmsPrnTmplRelSrvDO item:lstRelSrvDOsAdd){
            for (CiOrderDO order:this.lstCiOrderDOs_App){
                boolean bMatch = false;
                switch (item.getEu_ofreftp()){
                    case "0":
                        bMatch = order.getSd_srvtp().startsWith(item.getSd_srvtp()) && item.getEu_direct() != null;
                        break;
                    case "1":
                        bMatch = order.getId_srv().equals(item.getId_srv()) && item.getEu_direct() != null;
                        break;
                }
                if (bMatch){
                    if (!lstParamIds.contains(order.getId_or()))
                        lstParamIds.add(order.getId_or());
                }
            }
        }

        for (EmsPrnTmplRelSrvDO item:lstRelSrvDOsRemove){
            for (CiOrderDO order:this.lstCiOrderDOs_App){
                boolean bMatch = false;
                switch (item.getEu_ofreftp()){
                    case "0":
                        bMatch = order.getSd_srvtp().startsWith(item.getSd_srvtp()) && item.getEu_direct() != null;
                        break;
                    case "1":
                        bMatch = order.getId_srv().equals(item.getId_srv()) && item.getEu_direct() != null;
                        break;
                }
                if (bMatch){
                    if (lstParamIds.contains(order.getId_or()))
                        lstParamIds.remove(order.getId_or());
                }
            }
        }
        return true;
    }

}
