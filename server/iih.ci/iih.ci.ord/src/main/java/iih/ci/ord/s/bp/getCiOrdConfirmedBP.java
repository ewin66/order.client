package iih.ci.ord.s.bp;

import iih.ci.ord.ciordems.d.OrConfirm;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.qry.getCiOrdConfirmedQry;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class getCiOrdConfirmedBP {
	
	public OrConfirm[] exec(OrConfirm confirm)throws BizException{
		
		OrConfirm[] cfmlist= getPatVist(confirm);
		if(CiOrdUtils.isEmpty(cfmlist))return null;
		String idors=getors(cfmlist);
		 getPatVist(cfmlist,idors);
		
		return cfmlist;
		
	}
	
	/**
	 * 获取就诊域的数据
	 * @param Pvlist
	 * @param ens
	 * @return
	 * @throws BizException
	 */
	private OrConfirm[] getPatVist(OrConfirm confirm) throws BizException{
		
	
		ITransQry qry = new getCiOrdConfirmedQry(confirm);
		OrConfirm[] rtn = (OrConfirm[]) AppFwUtil.getDORstWithDao(qry,OrConfirm.class);
		return rtn;
		
	}
	
	
	private List<String> getorslist(OrConfirm[] Pvlist){
		
		List<String> sb=new ArrayList<String>();
		for (OrConfirm orConfirm : Pvlist) {
			sb.add(orConfirm.getId_confirm());
			
		}
		
		return sb;
		
	}
	
	private String getors(OrConfirm[] Pvlist){
		
		StringBuilder sb=new StringBuilder();
		for (OrConfirm orConfirm : Pvlist) {
			if(sb.length()!=0){
			sb.append(",'"+orConfirm.getId_confirm()+"'");
			}else{
				
				sb.append("'"+orConfirm.getId_confirm()+"'");
	
				
			}
		}
		
		return sb.toString();
		
	}
	
	private List<CiOrderDO> getciors(String ors) throws DAException{
		
		String sql="select CI_OR.ID_OR,CI_OR.Sd_su_or,CI_OR.Sd_su_bl,CI_OR.Sd_su_mp,CI_OR.Dt_end,CI_OR.Fg_long "
				+ " FROM CI_ORDER CI_OR WHERE ID_OR IN ("+ors+")";
		DAFacade da=new DAFacade();
		List<CiOrderDO> ciors=(List<CiOrderDO>) da.execQuery(sql, new BeanListHandler(CiOrderDO.class));
		
		return ciors;
	}
	
	/**
	 * 获得医嘱域的数据
	 * @param Pvlist  
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	private void getPatVist(OrConfirm[] Pvlist,String idors) throws BizException{
		
			List<CiOrderDO> list=getciors(idors);			
			CiOrdUtils.getOrderStatus(list,true);
			for (CiOrderDO ciOrderDO : list) {
				OrConfirm cfm=getcfm8en(Pvlist,ciOrderDO.getId_or());
				if(cfm==null)
					continue;
				copyCfm8Or(cfm,ciOrderDO);
				
			}
		
		
	}
	
	
	private OrConfirm getcfm8en(OrConfirm[] Pvlist,String idor){
		OrConfirm cfm=null;
		for (OrConfirm orConfirm : Pvlist) {
			if(idor.equals(orConfirm.getId_confirm())){
				cfm=orConfirm;
				break;
			}
		}
		
		return cfm;
	}
	

	
	private OrConfirm copyCfm8Or(OrConfirm cfm,CiOrderDO cior){		

		cfm.setId_su_or(cior.getId_su_or());
		cfm.setName_su_or(cior.getSu_or_name());

		return cfm;
		
	}
	

}
