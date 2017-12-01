package iih.ci.ord.s.ems.biz.utils;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.pp.bdprisamp.d.BdPriSampDO;
import iih.bd.pp.bdprisamp.d.desc.BdPriSampDODesc;
import iih.bd.pp.bdprisamp.i.IBdprisampRService;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.d.OrdApOutDO;
import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.d.SkinTestParamDTO;
import iih.ci.ord.dto.d.SkinTestRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ems.d.UsageRelFeeSrvDO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.DateUtils;
import iih.ci.ord.pub.d.AllergicPharmHandleMode;
import iih.ci.ord.s.bp.base.fc.GetOrMpCloseLoopTpBP;
import iih.ci.ord.s.bp.base.relsrv.GetLisSrvVesselRelFeeSrvBP;
import iih.ci.ord.s.bp.ems.CiOrDtLastBlCal4OpenBP;
import iih.ci.ord.s.bp.qry.CiOrLisSrvVesselRelFeeQry;
import iih.ci.ord.s.ems.define.StringList;
import iih.en.pv.dto.d.Ent4BannerDTO;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class OrderUtils {
	/**
	 * 获得临床医嘱结束时间信息
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public static  FDateTime[] getDtBeginEnd(String code_entp,FDateTime dt_begin_ui,FDateTime dt_end_ui,Integer use_days)  throws BizException{
		FDateTime[] rtn=new FDateTime[2];
		rtn[0]=dt_begin_ui;
		if(CiOrdUtils.isOpUrgentWf(code_entp)){//结束日期=开始日期
			FDateTime fd = new FDateTime();
			if(dt_end_ui== null){
				rtn[1]=fd.getDateTimeAfter(use_days);
			}else{
				rtn[1]=dt_end_ui;
			}
			
		}

		return rtn;
	}
	/**
	 * 获得医嘱过期时间
	 * @param ems
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	public static  FDateTime getDtInvalid(CiEnContextDTO ctx,FDateTime dt_begin_ui )  throws BizException{
		Integer hours=null;
		if(CiOrdUtils.isOpUrgentWf(ctx.getCode_entp())){
			// 2016-09-18  打开该代码注释 
			hours=ParamsetQryUtil.getParaInt(ctx.getId_org(), ICiOrdNSysParamConst.SYS_PARAM_OpOrValidTime);
			if(hours<=0)
			{
				hours=24;
			}
			return DateUtils.getDateTimeAfter(dt_begin_ui,hours);
		}
		
		return null;
	}
	public static  FDateTime getDtInvalid(String code_entp, String id_org,FDateTime dt_begin_ui )  throws BizException{
		Integer hours=null;
		if(CiOrdUtils.isOpUrgentWf(code_entp)){
			// 2016-09-18  打开该代码注释 
			hours=ParamsetQryUtil.getParaInt(id_org, ICiOrdNSysParamConst.SYS_PARAM_OpOrValidTime);
			if(hours<=0)
			{
				hours=24;
			}
			return DateUtils.getDateTimeAfter(dt_begin_ui,hours);
		}
		
		return null;
	}
	/**
	 * 获得最近医嘱生成日期
	 * @param id_freq
	 * @param dt_effe
	 * @param firstdaytimes
	 * @return
	 * @throws BizException
	 */
	public static FDateTime getLastDt(String id_freq,FDateTime dt_effe,Integer firstdaytimes,FBoolean fg_long) throws BizException{
		CiOrDtLastBlCal4OpenBP bp=new CiOrDtLastBlCal4OpenBP();
		return bp.exec(id_freq, dt_effe, firstdaytimes,fg_long);
	}
	/**
	 * 获得医嘱闭环类型id
	 * 
	 * @param ordo
	 * @return
	 * @throws BizException
	 */
	public static String getOrCLoopTpId(CiOrderDO ordo) throws BizException {
		try {
			GetOrMpCloseLoopTpBP bp = new GetOrMpCloseLoopTpBP();
			OrpltpDO[] cltpids = bp.exec(ordo);
			if (CiOrdUtils.isEmpty(cltpids))
				return null;
			return cltpids[0].getId_orpltp();
		} catch (Exception e) {
			Logger.error(e);
		}
		return null;
	}
	
	/**
	 * 获取皮试结果
	 * 
	 * @param drug
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	public static SkinTestRstDTO getSkinTestCheckResult(FBoolean fg_sdintest,String id_srv,String id_mm,String id_srvskin, CiEnContextDTO ctx) throws BizException {

		// 非皮试药品，不获取皮试校验结果
		if (!FBoolean.TRUE.equals(fg_sdintest)) {
			return null;
		}
		Ent4BannerDTO banner = ctx.getEnt4BannerDTO();
		SkinTestParamDTO param = new SkinTestParamDTO();
		param.setId_mm(id_mm);
		param.setId_org(ctx.getId_org());
		param.setId_pi(ctx.getId_pat());
		param.setDt_birth(FDate.getDate(banner.getDt_birth()));
		param.setId_srv(id_srv);
		param.setId_skinsrv(id_srvskin);
		return CiOrdAppUtils.getCiOrdQryService().skinTestLogicMainBP(param);
	}	
	/**
	 * 判断是否需要皮试
	 * @param id_srv
	 * @param mmdo
	 * @param ctx
	 * @return
	 * @throws BizException 
	 */
	public static FBoolean needFgSkinTest(CiEnContextDTO ctx,MeterialDO mmdo) throws BizException{
		SkinTestRstDTO rstdo=getSkinTestCheckResult(mmdo.getFg_skin(), mmdo.getId_srv(), mmdo.getId_mm(), mmdo.getId_srvskin(), ctx);
		if(rstdo.getAllergicpharmhandlemode()==AllergicPharmHandleMode.ALLERGICRESKINTEST ||
				rstdo.getAllergicpharmhandlemode()==AllergicPharmHandleMode.SKINALLERGICTEST ||
				rstdo.getAllergicpharmhandlemode()==AllergicPharmHandleMode.WAITSKINTESTRPT){
			return FBoolean.TRUE;
		}else{
			return FBoolean.FALSE;
		}
	}
	
	/**
	 *获取物品对应当前包装单位
	 * @param id_mm
	 * @param code_entp
	 * @return
	 * @throws BizException
	 */
	private  Map<String,MaterialUnitDTO> getMmUnit(String[] id_mms,String code_entp) throws BizException{
		IMaterialBaseInfoService service=ServiceFinder.find(IMaterialBaseInfoService.class);
		MaterialUnitDTO[] units=service.getMMunitByEntp(id_mms, code_entp);
		Map<String,MaterialUnitDTO> unitMap=new HashMap<String,MaterialUnitDTO>();
		for(MaterialUnitDTO unit:units){//取每个物品返回数据的第一条
			if(unitMap.containsKey(unit.getId_mm()))continue;
			unitMap.put(unit.getId_mm(), unit);
		}
		return unitMap;
	}
	
	public static FDateTime getConsTimeLimit(String id_unit,int quan_time,FDateTime dt_plan){
		
		if(quan_time==0)return dt_plan;
		if (id_unit == ICiDictCodeConst.ID_MEASDOC_TIME_DD)//天
        {
			int seconsds=(quan_time - 1)*24*60*60;
			dt_plan=dt_plan.addSeconds(seconsds);
			SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
			return new FDateTime(dateformat.format(dt_plan));
        }
        if (id_unit == ICiDictCodeConst.ID_MEASDOC_TIME_HH)//小时
        {
        	int seconsds=(quan_time - 1)*60*60;
            return dt_plan.addSeconds(seconsds);
        }
        if (id_unit == ICiDictCodeConst.ID_MEASDOC_TIME_MM)//分
        {
        	int seconsds=(quan_time - 1)*60;
            return dt_plan.addSeconds(seconsds);
        }
        if (id_unit == ICiDictCodeConst.ID_MEASDOC_TIME_SS)//秒
        {
        	return dt_plan.addSeconds(quan_time);
        }
        return dt_plan;
	}
	
	/**
	 * 生成主键方法
	 * @param size
	 * @return
	 */
	public static String[] GeneratePKs(int size){
		
		String[] szPK = new DBUtil().getOIDs(size);
		
		return szPK;
	}
	
	
	public static FBoolean IsMpInpatent(CiEnContextDTO ctx,String sd_srvtp, String id_route, FBoolean defv) throws BizException{
		//在院执行对象为空判断，不为空时无需设置值直接返回
		if(!CiOrdUtils.isEmpty(defv))
			return defv;
		
		//住院情形时，默认值设置
		if(CiOrdUtils.isIpWf(ctx.getCode_entp())){
			return FBoolean.TRUE;	
		}
		
		//门诊情形时，默认值设置处理
		if(CiOrdUtils.isOpWf(ctx.getCode_entp())){
			
			//非药品医嘱时
			if(!CiOrdUtils.isPharmacy(sd_srvtp)){
				return FBoolean.TRUE;
			}
			
			//草药医嘱时
			if(CiOrdUtils.isHerbOrder(sd_srvtp)){
				return FBoolean.FALSE;
			}
			// 没有给定用法，不能判断是否在院执行，默认为不在院执行
			if (CiOrdUtils.isEmpty(id_route))
			{
				return FBoolean.FALSE;
			}
			String grpableusgstr = SysParamUtils.getSysParam().getSYS_PARAM_CiPharmGrpableUsageScope().getOrgParam();
			if (CiOrdUtils.isEmpty(grpableusgstr))
				return FBoolean.FALSE;
			
			if (grpableusgstr.indexOf(id_route) >= 0)
				return FBoolean.TRUE;
				
		}
		//其他
		return FBoolean.FALSE;
	}
	
	/**
	 * 获取申清单信息
	 * @param szId_or 医嘱ID集合
	 * @return
	 * @throws BizException
	 */
	public static Object[] QryOrderAppSheetList(String[] szId_or) throws BizException{
		// 检验申请单保存
		OrdApLabDO[] szOrdApLabDO = CiOrdAppUtils.getOrapplisQryService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szOrdApLabDO)){
			return szOrdApLabDO;
		}
		// 检查申请单保存
		OrdApObsDO[] szOrdApObsDO = CiOrdAppUtils.getOrapprisQryService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szOrdApObsDO)){
			return szOrdApObsDO;
		}
		// 手术申请单保存
		CiorappsurgeryAggDO[] szCiorappsurgeryAggDO = CiOrdAppUtils.getOrappsurgeryQrytService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szCiorappsurgeryAggDO)){
			return szCiorappsurgeryAggDO;
		}
		// 备血申请单保存
		CiorappbtAggDO[] szCiorappbtAggDO = CiOrdAppUtils.getOrappbtQryService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szCiorappbtAggDO)){
			return szCiorappbtAggDO;
		}
		// 会诊申请单保存
		CiorappconsultAggDO[] szCiorappconsultAggDO = CiOrdAppUtils.getOrappconsultQryService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szCiorappconsultAggDO)){
			return szCiorappconsultAggDO;
		}
		// 用血申请单保存
		OrdAppBtUseDO[] szOrdAppBtUseDO = CiOrdAppUtils.getOrappbuQryService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szOrdAppBtUseDO)){
			return szOrdAppBtUseDO;
		}
		// 转科申请单保存
		OrdApTransDO[] szOrdApTransDO = CiOrdAppUtils.getOrapptransdepQryService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szOrdApTransDO)){
			return szOrdApTransDO;
		}
		// 出院带药生清单保存
		OrdApOutDO[] szOrdApOutDO = CiOrdAppUtils.getOrappoutQryService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szOrdApTransDO)){
			return szOrdApTransDO;
		}
		// 病理申请单保存
		CiorapppathgyAggDO[] szCiorapppathgyAggDO = CiOrdAppUtils.getOrapppathgyQryService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szCiorapppathgyAggDO)){
			return szCiorapppathgyAggDO;
		}
		return null;
	}

	/**
	 * 从DO模型中回去指定字段的值信息数组
	 * @param szInfo
	 * @param attr
	 * @return
	 */
	public static <T extends BaseDO> String[] ModelAttrValues(T[] szInfo,String attr){
		StringList strList = new StringList();
		for (T info : szInfo){
			strList.add(info.getAttrVal(attr).toString());
		}
		return strList.asArray();
	}

	/**
	 * 泛型设置DO 的id_or属性
	 * 
	 * @param szAppSheet
	 * @param id_or
	 * @return
	 */
	public static <T extends BaseDO> T[] UpdateOrderAppSheet(T[] szAppSheet, String id_or) {
		for (T info : szAppSheet) {
			info.setAttrVal("Id_or", id_or);
		}
		return szAppSheet;
	}


	/**
	 * 泛型设置aggdo 的id_or属性
	 * 
	 * @param szAppSheet
	 * @param id_or
	 * @return
	 */
	public static <T extends BaseAggDO> T[] UpdateOrderAppSheet(T[] szAppSheet, String id_or) {
		for (T info : szAppSheet) {
			info.getParentDO().setAttrVal("Id_or", id_or);
		}
		return szAppSheet;
	}

		/**
		 * 获得标本类型对应的费用集合
		 * 
		 * @param sd_specimentp
		 * @param id_scope_rel
		 * @param isscopedept是否科室范围
		 * @return
		 * @throws BizException
		 */
		public static BdPriSampDO[] getSpecimenTpRelFeeSrvInfo(String sd_specimentp, String id_scope_org)
				throws BizException {
			if(CiOrdUtils.isEmpty(sd_specimentp))return null;
			String tbaliasname = BdPriSampDODesc.TABLE_ALIAS_NAME;			
			BdPriSampDO[] do1 = ServiceFinder.find(IBdprisampRService.class).find(
					String.format(" %s.sd_samptp='%s' and %s.id_org='%s'", tbaliasname,sd_specimentp,tbaliasname,id_scope_org),
					"sd_samptp,sortno", FBoolean.FALSE);
			return do1;
		}

		/**
		 * 获得检验项目标本容器对应的费用集合
		 * 
		 * @param sd_specimenvesseltp
		 * @param id_org
		 * @param code_entp
		 * @param reltype
		 * @return
		 * @throws BizException
		 */
		public static Map<String, Object> getLisSrvVesselTpRelFeeSrvInfo(String sd_specimenvesseltp, String id_org,
				String code_entp) throws BizException {
			if(CiOrdUtils.isEmpty(sd_specimenvesseltp))return null;
			String wherestr=String.format(" select B.Id_Srv "
			          +" from bd_srv_sani A left outer join bd_srv B ON A.Id_Srv=B.Id_Srv  "
			          +" where A.Id_Org='%s' and A.Sd_Sanitp='%s' and B.Fg_Use_%s='Y' and B.Fg_Active='Y'",id_org,sd_specimenvesseltp,getEntpFldNameStr(code_entp));
			return (Map<String, Object>) (new DAFacade().execQuery(wherestr,	new MapHandler()));
		}
		
		/**
		 * 获得就诊类型对应的字段名
		 * 
		 * @param entp
		 * @return
		 */
		public static String getEntpFldNameStr(String entp) {
			if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(entp))
				return "op";
			if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(entp))
				return "ip";
			if (IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(entp))
				return "er";
			if (IBdFcDictCodeConst.SD_CODE_ENTP_PE.equals(entp))
				return "pe";
			if (IBdFcDictCodeConst.SD_CODE_ENTP_FA.equals(entp))
				return "fm";

			return "";
		}
}
