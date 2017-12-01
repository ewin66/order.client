package iih.ci.ord.s.bp.ciprn;

import iih.bd.srv.ems.d.EmsprntmplAggDO;
import iih.bd.srv.ems.i.IEmsprntmplRService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class GetEmsprntmplBP {

	private String id_psn, id_dep, id_grp, id_org;
	
	public GetEmsprntmplBP(String id_psn, String id_dep, String id_grp, String id_org){
		this.id_psn = id_psn;
        this.id_dep = id_dep;
        this.id_grp = id_grp;
        this.id_org = id_org;
	}
	
	public EmsprntmplAggDO[] getAllEmsprntmplAggDOs() throws BizException{
		IEmsprntmplRService service = ServiceFinder.find(IEmsprntmplRService.class);
        String strSql = String.format(" a0.id_grp='%s' and a0.id_org='%s' and a0.fg_active='Y'", this.id_grp, this.id_org);
        EmsprntmplAggDO[] aggDOs = service.find(strSql, null, FBoolean.FALSE);
        
        //各级别的打印模板分开
        List<EmsprntmplAggDO> lstAggDOs_h = new ArrayList<EmsprntmplAggDO>();//全院
        List<EmsprntmplAggDO> lstAggDOs_d = new ArrayList<EmsprntmplAggDO>();//科室
        List<EmsprntmplAggDO> lstAggDOs_p = new ArrayList<EmsprntmplAggDO>();//个人
        for(EmsprntmplAggDO aggDO:aggDOs){
        	switch(aggDO.getParentDO().getSd_srvorrt())
            {
                case "0":
                    lstAggDOs_h.add(aggDO);
                    break;
                case "1":
                    if (this.id_dep.equals(aggDO.getParentDO().getId_dept()))
                        lstAggDOs_d.add(aggDO);
                    break;
                case "2":
                    if (this.id_psn.equals(aggDO.getParentDO().getId_dept()))
                        lstAggDOs_p.add(aggDO);
                    break;
            }
        }
        
        
        //科室和全院的打印模板类型与个人打印模板一致，记录科室和全院打印模板的序号，从集合中去除
        List<Integer> lstindex_d = new ArrayList<Integer>();
        List<Integer> lstindex_h = new ArrayList<Integer>();
        for(EmsprntmplAggDO aggdo_p:lstAggDOs_p)
        {
            for (int i = 0; i < lstAggDOs_d.size(); i++)
            {
                if (lstAggDOs_d.get(i).getParentDO().getSd_ciprintsheettp().equals(aggdo_p.getParentDO().getSd_ciprintsheettp()))
                    lstindex_d.add(i);
            }

            for (int i = 0; i < lstAggDOs_h.size(); i++)
            {
                if (lstAggDOs_h.get(i).getParentDO().getSd_ciprintsheettp().equals(aggdo_p.getParentDO().getSd_ciprintsheettp()))
                    lstindex_h.add(i);
            }
        }
        for (int i = lstindex_d.size() - 1; i >= 0; i--)
        {
            lstAggDOs_d.remove(lstindex_d.get(i).intValue());
        }
        for (int i = lstindex_h.size() - 1; i >= 0; i--)
        {
            lstAggDOs_h.remove(lstindex_h.get(i).intValue());
        }

        //全院的打印模板类型与科室打印模板一致，记录全院打印模板的序号，从集合中去除
        lstindex_h.clear();
        for (EmsprntmplAggDO aggdo_d:lstAggDOs_d)
        {
            for (int i = 0; i < lstAggDOs_h.size(); i++)
            {
                if (lstAggDOs_h.get(i).getParentDO().getSd_ciprintsheettp().equals(aggdo_d.getParentDO().getSd_ciprintsheettp()))
                    lstindex_h.add(i);
            }
        }
        for (int i = lstindex_h.size() - 1; i >= 0; i--)
            lstAggDOs_h.remove(lstindex_h.get(i).intValue());

        lstAggDOs_h.addAll(lstAggDOs_d);
        lstAggDOs_h.addAll(lstAggDOs_p);

        return lstAggDOs_h.toArray(new EmsprntmplAggDO[]{});
	}
	
}
