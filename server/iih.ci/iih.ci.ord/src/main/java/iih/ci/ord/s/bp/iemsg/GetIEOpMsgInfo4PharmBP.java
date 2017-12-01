package iih.ci.ord.s.bp.iemsg;

import java.util.Hashtable;

import iih.ci.ord.iemsg.d.IEOpPharmOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpPharmPresDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiOpDrugConfirmQry;
import iih.ci.ord.s.bp.iemsg.qry.CiOpDrugPresQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 生成集成平台药品医嘱服务数据信息操作BP
 * （门诊）
 */
public class GetIEOpMsgInfo4PharmBP {
	
	/**
	 * 生成集成平台药品医嘱服务数据信息
	 * （门诊）
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpPharmOrEnDTO[] exec(String id_wc_ors,String id_herb_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_wc_ors) && CiOrdUtils.isEmpty(id_herb_ors))return null;
		
		//获得医嘱签署信息
		IEOpPharmOrEnDTO rtn=getIEMsg4OrSignInfo(id_wc_ors,id_herb_ors);
		
		//获得处方信息
		String id_preses=pharmPresInfoHandle(id_wc_ors,id_herb_ors,rtn);
		
		//西成药处方数据信息计算与处理
		ieOpPresItms4DrugWcHandle(id_preses,rtn);
		
		//草药处方数据信息计算与处理
		ieOpPresItms4HerbHandle(id_preses,rtn);
		
		return new IEOpPharmOrEnDTO[]{rtn};
	}
	
	/**
	 * 西成药处方数据信息计算与处理
	 * @param id_preses
	 * @param rtn
	 * @throws BizException
	 */
	private void ieOpPresItms4HerbHandle(String id_preses,IEOpPharmOrEnDTO rtn) throws BizException{
		//获得草药处方明细信息
		GetIEOpMsgInfo4DrugHerbBP bp=new GetIEOpMsgInfo4DrugHerbBP();
		Hashtable<String,FArrayList2> list=bp.exec(id_preses);
		
		//空判断
		if(CiOrdUtils.isEmpty(list))return;
		
		//药品处方
		FArrayList2 list2=rtn.getId_iepharmpreses();
		if(CiOrdUtils.isEmpty(list2))return;
		IEOpPharmPresDTO presdto=null;
		String id_pres="";
		
		//遍历
		for(int i=0;i<list2.size();i++){
			presdto=(IEOpPharmPresDTO)list2.get(i);
			id_pres=presdto.getId_iepharmpres();
			if(CiOrdUtils.isEmpty(list.get(id_pres)))continue;
			presdto.setId_iepharmors(list.get(id_pres));
		}
	}
	
	/**
	 * 西成药处方数据信息计算与处理
	 * @param id_preses
	 * @param rtn
	 * @throws BizException
	 */
	private void ieOpPresItms4DrugWcHandle(String id_preses,IEOpPharmOrEnDTO rtn) throws BizException{
		//获得西成药处方明细信息
		GetIEOpMsgInfo4DrugWcBP bp=new GetIEOpMsgInfo4DrugWcBP();
		Hashtable<String,FArrayList2> list=bp.exec(id_preses);
		
		//空判断
		if(CiOrdUtils.isEmpty(list))return;
		
		//药品处方
		FArrayList2 list2=rtn.getId_iepharmpreses();
		if(CiOrdUtils.isEmpty(list2))return;
		IEOpPharmPresDTO presdto=null;
		String id_pres="";
		
		//遍历
		for(int i=0;i<list2.size();i++){
			presdto=(IEOpPharmPresDTO)list2.get(i);
			id_pres=presdto.getId_iepharmpres();
			if(CiOrdUtils.isEmpty(list.get(id_pres)))continue;
			presdto.setId_iepharmwcors(list.get(id_pres));
		}
	}
	
	/**
	 * 获得医嘱签署信息
	 * 患者、就诊、签署
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	private IEOpPharmOrEnDTO getIEMsg4OrSignInfo(String id_wc_ors,String id_herb_ors) throws BizException{
		String id_or=getOr(id_wc_ors,id_herb_ors);
		
		// 医嘱数据信息查询
		CiOpDrugConfirmQry qry = new CiOpDrugConfirmQry(id_or);
		IEOpPharmOrEnDTO[] rtns = (IEOpPharmOrEnDTO[]) AppFwUtil.getDORstWithDao(qry, IEOpPharmOrEnDTO.class);
	
		//返回
		if(CiOrdUtils.isEmpty(rtns))return null;
		rtns[0].setDomain_id("01");
		return rtns[0];
	}
	
	/**
	 * 获得药品处方数据信息
	 * 西成药 草药
	 * @param id_wc_ors
	 * @param id_herb_ors
	 * @param rtn
	 * @return
	 * @throws BizException
	 */
	private String pharmPresInfoHandle(String id_wc_ors,String id_herb_ors,IEOpPharmOrEnDTO rtn) throws BizException{
		String id_ors=getIDOrs(id_wc_ors,id_herb_ors);
		
		// 医嘱数据信息查询
		CiOpDrugPresQry qry = new CiOpDrugPresQry(id_ors);
		IEOpPharmPresDTO[] predtos=(IEOpPharmPresDTO[]) AppFwUtil.getDORstWithDao(qry, IEOpPharmPresDTO.class);
	
		//空判断
		if(CiOrdUtils.isEmpty(predtos))return null;
		
		//参数设置
		FArrayList2 list=new FArrayList2();
		String rtnstr="";
		
		//遍历
		for(IEOpPharmPresDTO o:predtos){
			list.add(o);
			rtnstr+=CiOrdUtils.COMMA_STR+o.getId_iepharmpres();
		}
		
		//设置处方集合数据信息
		rtn.setId_iepharmpreses(list);
		
		//返回
		return rtnstr.substring(1); 
	}

	/**
	 * 获得一个医嘱ID
	 * @param id_wc_ors
	 * @param id_herb_ors
	 * @return
	 */
	private String getOr(String id_wc_ors,String id_herb_ors){
		String id_ors=null;
		if(!CiOrdUtils.isEmpty(id_wc_ors)){id_ors=id_wc_ors;}
		else{id_ors=id_herb_ors;}
		
		return id_ors.split(CiOrdUtils.COMMA_STR)[0];
	}
	
	/**
	 * 合并医嘱ID字串
	 * @param id_wc_ors
	 * @param id_herb_ors
	 * @return
	 */
	private String getIDOrs(String id_wc_ors,String id_herb_ors){
		if(CiOrdUtils.isEmpty(id_wc_ors)){return id_herb_ors;}
		else{
			if(CiOrdUtils.isEmpty(id_herb_ors))return id_wc_ors;
			return id_wc_ors+CiOrdUtils.COMMA_STR+id_herb_ors;
		}
	}

	
}
