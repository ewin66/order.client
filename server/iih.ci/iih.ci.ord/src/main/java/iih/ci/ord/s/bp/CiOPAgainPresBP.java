package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeTypeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.iemsg.d.IEOpPharmOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpPharmPresDTO;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.s.bp.cfg.CiRuleCfgExecutorBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4DrugHerbBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4DrugWcBP;
import iih.ci.ord.s.bp.iemsg.qry.CiOpDrugConfirmQry;
import iih.ci.ord.s.bp.iemsg.qry.CiOpDrugPres8idenQry;
import iih.ci.ord.s.bp.qry.CiOPAgainPresBPQry;
import iih.ci.ord.s.bp.splitpres.CiOrPresSplitList2CiOrPresHandleBP;
import iih.ci.ord.s.bp.splitpres.CiOrPresSplitMpHandleBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
/**
 * 医嘱门诊的重新分方
 * 
 * @author li_zheng
 *
 */
public class CiOPAgainPresBP {
     /**
      * 医嘱门诊的重新分方
      * @param id_ent
      * @param sd_entp
      * @return
      * @throws BizException
      */
	 public   CiOrderDO[] exec(String id_en,String id_dep_sign,String sd_entp,CiEnContextDTO ciEnContextDTO)throws BizException{
		  // 判断 本次就诊，有可以撤回的医嘱吗
		// return getCiOrderIdOr(id_ent,sd_entp);
		  // 有调用撤回的方法
		  
		  // 调用签署的方法
	/*	   String[] id_ors = getOpenCiOrderIdOr(id_en,sd_entp);
			 if(id_ors != null){
				  CiOrderSignBP bp = new CiOrderSignBP();
				  bp.exec(id_ors, ciEnContextDTO); 
			 }*/
		  //
		 /** BS302逻辑更改 重新分方操作时，触发NEW类型消息。将本次就诊最新医嘱传递给平台。其中通过传递空处方信息，实现处方全部删除业务。
		 //在重分方前根据就诊号缓存下当前的处方数据
		IEOpPharmOrEnDTO[] rtns = null;
		String id_or = getIdOr(id_en);
		// 获得医嘱签署信息
		IEOpPharmOrEnDTO rtn = getIEMsg4OrSignInfo(id_or);
		if (rtn != null) {
			// 获得处方信息
			String id_preses = pharmPresInfoHandle(rtn, id_en);// "1001Z7100000000GWQMU"

			// 西成药处方数据信息计算与处理
			ieOpPresItms4DrugWcHandle(id_preses, rtn);

			// 草药处方数据信息计算与处理
			ieOpPresItms4HerbHandle(id_preses, rtn);
			rtns = new IEOpPharmOrEnDTO[] { rtn };
		}
		*/
//		return CiOrderBackSign(id_en, id_dep_sign, sd_entp, rtns);
		return CiOrderBackSign(id_en, id_dep_sign, sd_entp);
	      
	 }
	 /**
	  * IE集成平台 使用 根据就诊号取出任意一个未记账的idor 2017-07-12 17:04:43  by yzh
	  * @param iden
	  * @return
	  * @throws BizException
	  */
	 private String getIdOr(String iden)throws BizException{
		 DAFacade dafacade = new DAFacade();
		StringBuffer sqlb = new StringBuffer();
		sqlb.append(" select a.id_or from ci_order a where a.id_en ='");
		sqlb.append(iden);
		sqlb.append("' and a.id_su_bl = '");
		sqlb.append(ICiDictCodeTypeConst.ID_SU_BL_1);
		sqlb.append("' and rownum = 1 ");
		List<String> list = (List<String>) dafacade.execQuery(sqlb.toString(), new ColumnListHandler());
		String id_or = "";
		for (int i = 0; i < list.size(); i++) {
			id_or = list.get(0);
		}
		return id_or;
	 }

		/**
		 * IE集成平台获得医嘱签署信息 患者、就诊、签署
		 * by yzh 2017-07-12 17:09:21
		 * @param id_or
		 * @return
		 * @throws BizException
		 */
		private IEOpPharmOrEnDTO getIEMsg4OrSignInfo(String id_or) throws BizException {

			// 医嘱数据信息查询
			CiOpDrugConfirmQry qry = new CiOpDrugConfirmQry(id_or);
			IEOpPharmOrEnDTO[] rtns = (IEOpPharmOrEnDTO[]) AppFwUtil.getDORstWithDao(qry, IEOpPharmOrEnDTO.class);

			//返回
			if (CiOrdUtils.isEmpty(rtns))
				return null;

			//设置域id
			rtns[0].setDomain_id("01");
			//计算年龄
			rtns[0].setAge(AgeCalcUtil.getAge(rtns[0].getBirthday()));

			return rtns[0];
		}
		/**
		 * 获得药品处方数据信息 西成药 草药
		 * 
		 * @param id_wc_ors
		 * @param id_herb_ors
		 * @param rtn
		 * @return
		 * @throws BizException
		 */
		private String pharmPresInfoHandle( IEOpPharmOrEnDTO rtn, String id_en)
				throws BizException {
			

			// 医嘱数据信息查询
			CiOpDrugPres8idenQry qry = new CiOpDrugPres8idenQry(id_en);
			IEOpPharmPresDTO[] predtos = (IEOpPharmPresDTO[]) AppFwUtil.getDORstWithDao(qry, IEOpPharmPresDTO.class);
			//空判断
			if (CiOrdUtils.isEmpty(predtos))
				return null;

		

			//参数设置
			FArrayList2 list = new FArrayList2();
			String rtnstr = "";

			//遍历
			for (IEOpPharmPresDTO o : predtos) {
				list.add(o);
				rtnstr += CiOrdUtils.COMMA_STR + o.getId_iepharmpres();
			}

			//设置未收费处方集合数据信息
			rtn.setId_iepharmpreses(list);

			if (rtnstr.equals(""))
				return null;
			//返回
			return rtnstr.substring(1);
		}
		/**
		 * IE集成平台西成药处方数据信息计算与处理
		 * by yzh 2017-07-12 17:11:47 
		 * @param id_preses
		 * @param rtn
		 * @throws BizException
		 */
		private void ieOpPresItms4DrugWcHandle(String id_preses, IEOpPharmOrEnDTO rtn) throws BizException {

			if (id_preses == null)
				return;
			//获得西成药处方明细信息
			GetIEOpMsgInfo4DrugWcBP bp = new GetIEOpMsgInfo4DrugWcBP();
			Hashtable<String, FArrayList2> list = bp.exec(id_preses);

			//空判断
			if (CiOrdUtils.isEmpty(list))
				return;

			//药品处方
			FArrayList2 list2 = rtn.getId_iepharmpreses();
			if (CiOrdUtils.isEmpty(list2))
				return;
			IEOpPharmPresDTO presdto = null;
			String id_pres = "";

			//遍历
			for (int i = 0; i < list2.size(); i++) {
				presdto = (IEOpPharmPresDTO) list2.get(i);
				id_pres = presdto.getId_iepharmpres();
				if (CiOrdUtils.isEmpty(list.get(id_pres)))
					continue;
				presdto.setId_iepharmwcors(list.get(id_pres));
			}
		}
		/**
		 * IE集成平台西成药处方数据信息计算与处理
		 * by yzh 2017-07-12 17:15:20
		 * @param id_preses
		 * @param rtn
		 * @throws BizException
		 */
		private void ieOpPresItms4HerbHandle(String id_preses, IEOpPharmOrEnDTO rtn) throws BizException {

			if (id_preses == null)
				return;
			//获得草药处方明细信息
			GetIEOpMsgInfo4DrugHerbBP bp = new GetIEOpMsgInfo4DrugHerbBP();
			Hashtable<String, FArrayList2> list = bp.exec(id_preses);

			//空判断
			if (CiOrdUtils.isEmpty(list))
				return;

			//药品处方
			FArrayList2 list2 = rtn.getId_iepharmpreses();
			if (CiOrdUtils.isEmpty(list2))
				return;
			IEOpPharmPresDTO presdto = null;
			String id_pres = "";

			//遍历
			for (int i = 0; i < list2.size(); i++) {
				presdto = (IEOpPharmPresDTO) list2.get(i);
				id_pres = presdto.getId_iepharmpres();
				if (CiOrdUtils.isEmpty(list.get(id_pres)))
					continue;
				presdto.setId_iepharmors(list.get(id_pres));
			}
		}
	 /**
	  * 
	  * @param id_ent
	  * @param sd_entp
	  * @return
	  */
	 private CiOrderDO[] getCiOrderIdOr(String id_ent,String sd_entp)throws BizException{
		 String whereStr = CiOrderDO.ID_EN +" ='"+id_ent+"' and  "
	                       +CiOrderDO.CODE_ENTP+" ='"+sd_entp+"' and "
	                       +CiOrderDO.SD_SU_MP +" ='0' and "
	                       +CiOrderDO.SD_SRVTP +" like '01%' ";
		 CiOrderDO[] ciOrderDOs  = 	CiOrdAppUtils.getOrQryService().find(whereStr, CiOrderDO.ID_OR, FBoolean.FALSE);
		 return ciOrderDOs;
	 }
	 
	 
	 /**
	  * 
	  * @param id_ent
	  * @param sd_entp
	  * @return
	  */
	 private String[] getOpenCiOrderIdOr(String id_ent,String sd_entp)throws BizException{
		 String whereStr = CiOrderDO.ID_EN +" ='"+id_ent+"' and  "
	                       +CiOrderDO.CODE_ENTP+" ='"+sd_entp+"' and "
	                       +CiOrderDO.SD_SU_OR +" ='0'  and "
		                   +CiOrderDO.SD_SRVTP +" like '0101%' ";
		 CiOrderDO[] ciOrderDOS  = 	CiOrdAppUtils.getOrQryService().find(whereStr, CiOrderDO.ID_OR, FBoolean.FALSE);
		  if(ciOrderDOS != null && ciOrderDOS.length >0){
			  String[] id_ors = new String[ciOrderDOS.length];
			  int i =0;
			  for(CiOrderDO ciorder: ciOrderDOS){
				  id_ors[i]= ciorder.getId_or();
				  ciorder.setFg_flush2mr(FBoolean.TRUE);
				  ciorder.setStatus(DOStatus.UPDATED);
				  i++;
			  }
			  //
			  CiOrdAppUtils.getOrService().save(ciOrderDOS);
			  return id_ors;
		  }
		 return null;
	 }
	 
	 /**
	  * 撤回医嘱
	  * @param ids
	  * @param sd_entp
	  * @return
	  * @throws BizException
	  */
	private CiOrderDO[] CiOrderBackSign(String id_en, String id_dep_sign, String sd_entp) throws BizException {

		CiOPAgainPresBPQry qry = new CiOPAgainPresBPQry(id_dep_sign, sd_entp, id_en);
		OrderPresSplitDTO[] rtn = (OrderPresSplitDTO[]) AppFwUtil.getDORstWithDao(qry, OrderPresSplitDTO.class);

		if (rtn != null && rtn.length > 0) {

			List<CiOrPresSplitList> orpressplitlists = CiOrPresSplitDTO2CiOrPresSplitList(rtn);

			CiRuleCfgExecutorBP cfgExecutorBp = new CiRuleCfgExecutorBP();
			List<CiOrPresSplitList> presList = cfgExecutorBp.execSplitPres(orpressplitlists);
			
			// ICiOrPresSplitRuleArrangePlugin arrangeplugin=CiOrdUtils.getCiOrPresSplitRuleArrangePlugin();
			// orpressplitlists=arrangeplugin.exec(orpressplitlists);

			CiOrPresSplitList2CiOrPresHandleBP bp = new CiOrPresSplitList2CiOrPresHandleBP();
			CiPresDO[] cipres = bp.exec(presList, null);

			CiOrPresSplitMpHandleBP bps = new CiOrPresSplitMpHandleBP();
			bps.exec(cipres);

			// 这样返回还是有问题的，应该确定接口返回值 ？？？？
			List<CiOrderDO> listOrder = new ArrayList<CiOrderDO>();
			for (OrderPresSplitDTO p : rtn) {
				CiOrderDO ord = new CiOrderDO();
				ord.setId_or(p.getId_or());
				// IE集成平台需要使用的数据 begin
				ord.setId_en(p.getId_en());
				ord.setFg_sign(FBoolean.TRUE);
				ord.setFg_chk(p.getFg_chk());
				ord.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
				ord.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
				ord.setCode_entp(p.getCode_entp());
				ord.setSd_srvtp(p.getSd_srvtp());
				// end
				listOrder.add(ord);
			}
			//如果重分方前有已存在的处方则发送删除事件
			 //if (rtns != null) {
			 //	 CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_AGAIN_DEL, IEventType.TYPE_UPDATE_AFTER, rtns);
			 //}
			//保存成功后往集成平台同步数据，发送处方新增事件
			CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_AGAIN_NEW, IEventType.TYPE_UPDATE_AFTER,  listOrder.toArray(new CiOrderDO[0]));
			return listOrder.toArray(new CiOrderDO[listOrder.size()]);
		}
		return null;
	}
	 
		/**
		 * 分方数据DTO到临床医嘱分方数据信息列表数据
		 * @param orderpresdtos
		 * @return
		 */
	    private List<CiOrPresSplitList> CiOrPresSplitDTO2CiOrPresSplitList( OrderPresSplitDTO[] orderpresdtos){
	   	 List<CiOrPresSplitList> orderpresList = new ArrayList<CiOrPresSplitList>();
	   	 List Dtolist = new ArrayList<OrderPresSplitDTO>();
	   	CiOrPresSplitList orderPres = new CiOrPresSplitList();
	   	 if(orderpresdtos == null ) return orderpresList;
	   	 for(OrderPresSplitDTO dto:orderpresdtos){
	   	//li_cheng 2017/3/31  增加fg_or 过滤
	   		 if(islegal(dto))
	   		 Dtolist.add(dto);
	   	 }
	   	 orderPres.setOrderList(Dtolist);
	   	 orderpresList.add(orderPres) ;
	   	 return orderpresList;
	    }
	    
	    
	    private Boolean islegal(OrderPresSplitDTO dto){
	    	
	    	Boolean flag=false;
	    	 if(dto.getFg_or()!=null&&dto.getFg_or()==FBoolean.TRUE)
	    		 flag=true;
	    	return flag;
	    }
	 
}
