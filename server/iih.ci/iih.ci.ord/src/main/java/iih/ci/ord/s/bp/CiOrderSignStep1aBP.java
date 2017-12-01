package iih.ci.ord.s.bp;



import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.cg.service.d.CgTypeEnum;
import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.cior.d.ReactExtOrsAndStopOrsDO;
import iih.ci.ord.cior.d.ValidateRtnInfoDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.s.bp.ciprn.CiprnSaveAppPathgyDataBP;
import iih.ci.ord.s.bp.ciprn.CiprnSaveAppRisDataBP;
import iih.ci.ord.s.bp.orsms.lis.CiLisOrSmsHandlerBP;
import iih.ci.ord.s.bp.splitpres.CiOrPresSplitHandleBP;
import iih.en.pv.dto.d.Ent4BannerDTO;

import java.util.ArrayList;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.businessevent.IEventType;

/*
 * 临床医嘱的签署操作BP（Step1）
 * 
 * 更新医嘱状态、被排斥医嘱停止、
 * 门诊创建会话期间、门诊处方分方
 */
public class CiOrderSignStep1aBP {
	/**
	 * 临床医嘱的签署（Step1）
	 * 更新医嘱状态、被排斥医嘱停止、创建临床事件
	 * 门诊创建会话期间、门诊处方分方
	 * @param ciors
	 * @param willstopors
	 * @param dt_cur
	 * @return
	 * @throws BizException
	 */
	public ValidateRtnInfoDTO exec(CiOrderDO[] ciors,ReactExtOrsAndStopOrsDO willstopors,FDateTime dt_cur,String code_entp) throws BizException{
		ValidateRtnInfoDTO dto=new ValidateRtnInfoDTO();
		
		if(ciors==null || ciors.length==0)return dto;

		//更新医嘱状态为签署
		UpdateOrdStatusInfo1BP bp1=new UpdateOrdStatusInfo1BP();
		bp1.exec(ciors, null, ICiDictCodeConst.SD_SU_SIGN);
		
		//排斥时，排斥的有效医嘱停止处理逻辑 仅住院
		CiOrValidFgLongOrStopBP bp2=new CiOrValidFgLongOrStopBP();
		ArrayList<CiOrderDO> reactstopors=bp2.exec(willstopors, dt_cur);
		
		//创建门诊医嘱会话区间
		CiOrOpSessionInsertBP bp3=new CiOrOpSessionInsertBP();
		CiOrSessionDO sessiondo=bp3.exec(ciors, dt_cur);
		
//		//签署时，按规则自动分方  仅门急诊使用
//		PresSplitRuleArrangeBP bp4=new PresSplitRuleArrangeBP();
//		bp4.exec(ciors,sessiondo,code_entp);
		
		
		//签署时，按规则自动分方  仅门急诊使用  新接口 可配置第三方插件
		CiOrPresSplitHandleBP bp4=new CiOrPresSplitHandleBP();
		bp4.exec(ciors,sessiondo);
		
		//检验合单   仅门急诊使用
		CiLisOrSmsHandlerBP bp5=new CiLisOrSmsHandlerBP();
		bp5.exec(ciors, sessiondo);
		
		//保存检查打印数据    仅门急诊使用
		CiprnSaveAppRisDataBP bpRis=new CiprnSaveAppRisDataBP();
		bpRis.exec(ciors, sessiondo);
		
		//保存病理打印数据   仅门急诊使用
		CiprnSaveAppPathgyDataBP bpPathgy=new CiprnSaveAppPathgyDataBP();
		bpPathgy.exec(ciors, sessiondo);
		
		//生成门诊费用清单打印数据
		CiEnContextDTO context = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		if(context !=  null){
			Ent4BannerDTO banner = context.getEnt4BannerDTO();
			if( banner != null && (banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) ||
					banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET))){
				//生成保存门诊费用清单打印数据 
				String[] id_ors = new String[ciors.length];
				 int i = 0;
				  for(CiOrderDO ciorder: ciors){
					  id_ors[i] = ciorder.getId_or();
					  i++;
				  }
				CiOrdAppUtils.getICiprintExtService().SaveFeeBillsData(id_ors,banner.getId_hp(),banner.getSd_hptp());
				
				//高端商保记账
				//高端商保判断是每条医嘱的金额 不能超过限制的 金额
				if(banner.getSd_hptp() != null && banner.getSd_hptp().startsWith("2")){
					String id_psndoc = context.getPsnInfo().getId_psndoc();
					CiOrdAppUtils.getIBLOrderAppendBillService().SetOrderAppendBill_ByItms_ci_kljz_new(banner.getId_ent(),banner.getCode_entp(),CgTypeEnum.CG_HPCG,id_psndoc);
				}
			}
		}
		
		CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID,IEventType.TYPE_UPDATE_AFTER,ciors);

		
		//返回值空判断
		if(CiOrdUtils.isEmpty(reactstopors)){
			CiOrderSignHelper.orReactStopOrPromptRtnHandle(dto,ciors);
			return dto;
		}
		
		//返回
		CiOrderSignHelper.orReactStopOrPromptRtnHandle(dto,ciors,reactstopors);
		return dto;
	}

}
