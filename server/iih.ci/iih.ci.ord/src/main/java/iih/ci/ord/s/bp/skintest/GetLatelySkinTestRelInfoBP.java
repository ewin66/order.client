package iih.ci.ord.s.bp.skintest;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.dto.d.SkinTestParamDTO;
import iih.ci.ord.dto.d.SkinTestUsePharmRstDTO;
import iih.ci.ord.dto.d.ValidSkinOrInfo;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.d.NDaysValidThingEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 获得患者最近皮试或用药相关数据结果信息操作BP
 */
class GetLatelySkinTestRelInfoBP {
	private static int DAYS_VALIDATE_NULL=1;
	/**
	 * 获得患者最近皮试或用药相关数据结果信息
	 * @param  skintestparam
	 * @throws BizException
	 */
	public SkinTestUsePharmRstDTO exec(SkinTestParamDTO skintestparam)  throws BizException{
		
		if(skintestparam.getId_org()==null)skintestparam.setId_org(Context.get().getOrgId());
		//获得有效天数  如：1或3天
		int days=getDays4SkinTestInfo(skintestparam.getId_org(),skintestparam.getDt_birth());
		
		//获得天的计算模式
		Integer paramvint=ParamsetQryUtil.getParaInt(skintestparam.getId_org(),ICiOrdNSysParamConst.SYS_PARAM_DtCalEffModeWithinNDays);
		
		//获得有效皮试医嘱时间区间
		FDateTime[] dts=CiOrdUtils.getTimeSection(CiOrdAppUtils.getServerDateTime(),days,paramvint);

		//需皮试用药的药品存在有效的已执行用药记录判断
		if(existValidisNeedSkinExOr(skintestparam.getId_pi(),skintestparam.getId_srv(),skintestparam.getId_mm(),dts).booleanValue())return getSkinTestUsePharmRst(NDaysValidThingEnum.WITHEXECUSEPHARM,null,null);
		//获得患者有效皮试医嘱数据信息
		ValidSkinOrInfo[] validskinorinfo=getPiValidSkinTestOrInfo(skintestparam.getId_pi(),skintestparam.getId_skinsrv(),dts);
		if(!CiOrdUtils.isEmpty(validskinorinfo)) return getValidSkinOrRstType(validskinorinfo);
		
		return getSkinTestUsePharmRst(NDaysValidThingEnum.NOEXECUSEPHARM,null,null);
	}
	
	/**
	 * 获得近期有效皮试医嘱结果类型
	 * 需要重写一下（以最近一次结果为准）
	 * @param validskinorinfo
	 * @return
	 */
	private SkinTestUsePharmRstDTO getValidSkinOrRstType(ValidSkinOrInfo[] validskinorinfo ){
		int iN=validskinorinfo.length;
		int iYang=0,iYin=0,iNoRst=0;
		FDateTime dt_act=null;//过敏时间
		String id_skinor=validskinorinfo[0].getId_or();
		for(int i=0;i<1;i++){  //for(int i=0;i<iN;i++){
			if(CiOrdUtils.isCapitalInStr(validskinorinfo[i].getSd_rst_skintest(), ICiDictCodeConst.SD_RST_SKINTEST_L1_PLUS)){
				iYang+=1;
				dt_act = validskinorinfo[i].getDt_act();
			}else if(CiOrdUtils.isCapitalInStr(validskinorinfo[i].getSd_rst_skintest(), ICiDictCodeConst.SD_RST_SKINTEST_L1_MINUS)){
				iYin+=1;
			}else{
				iNoRst+=1;
			}
		}
		
		if(iYang>0)return getSkinTestUsePharmRst(NDaysValidThingEnum.SKINTESTYANG,null,dt_act);
		if(iYin>0)return getSkinTestUsePharmRst(NDaysValidThingEnum.SKINTESTYIN,id_skinor,null);
		if(iNoRst>0)return getSkinTestUsePharmRst(NDaysValidThingEnum.WAITSKINTESTRST,id_skinor,null);
		return getSkinTestUsePharmRst(NDaysValidThingEnum.OTHER,null,null);
	}
	/**
	 * 获得皮试或用药结果DTO数据信息
	 * @param ndaysvalidrst
	 * @param id_orskin
	 * @return
	 */
	private SkinTestUsePharmRstDTO getSkinTestUsePharmRst(Integer ndaysvalidrst,String id_orskin,FDateTime dt_act){
		SkinTestUsePharmRstDTO rtn=new SkinTestUsePharmRstDTO();
		rtn.setNdaysvalidrst(ndaysvalidrst);
		if(!CiOrdUtils.isEmpty(dt_act)){
			rtn.setDt_act(dt_act);
		}
		if(!CiOrdUtils.isEmpty(id_orskin)){
			rtn.setId_orskin(id_orskin);
		}
		return rtn;
	}
	
	/**
	 * 获得皮试信息数据时的有效天数
	 * @param id_org
	 * @param dt_birth
	 * @return
	 * @throws BizException
	 */
	private int getDays4SkinTestInfo(String id_org,FDate dt_birth) throws BizException{
		if(CiOrdUtils.isEmpty(dt_birth))return DAYS_VALIDATE_NULL;
		//0~168,1;169~,3  年龄月，有效天数
		String paramvstr=ParamsetQryUtil.getParaString(id_org, ICiOrdNSysParamConst.SYS_PARAM_AllergicSkinTestValidPeriodStr);
		if(CiOrdUtils.isEmpty(paramvstr))return DAYS_VALIDATE_NULL; 
		int monthAge=CiOrdUtils.getAgeMonth(dt_birth, 0);
		String[] params=paramvstr.split(CiOrdUtils.SEMICOLON_STR);
		int[] mmdays=new int[3];
		for(int i=0;i<params.length;i++){
			mmdays=getMinMaxDaysInfo(params[i]);
			if(mmdays==null)continue;
			if(monthAge>=mmdays[0] && monthAge<=mmdays[1]){return mmdays[2];}
		}
		return DAYS_VALIDATE_NULL;
	}
	/**
	 * 获得最小、最大、天数数据信息
	 * @param minmaxdaystr
	 * @return
	 */
	private int[] getMinMaxDaysInfo(String minmaxdaystr){
		if(CiOrdUtils.isEmpty(minmaxdaystr))return null;
		String[] mmdays=minmaxdaystr.split(CiOrdUtils.COMMA_STR);
		String[] minmxstr=mmdays[0].split(CiOrdUtils.TILDE_STR);
		return new int[]{Integer.parseInt(minmxstr[0]),
				Integer.parseInt(minmxstr.length==1?CiOrdUtils.MAX_AGEMONTH_NULL:minmxstr[1])
				,Integer.parseInt(mmdays[1])};
	}
	
	/**
	 * 获得患者有效皮试医嘱数据信息
	 * @param id_pi
	 * @param id_skinsrv
	 * @param secttime
	 * @return
	 * @throws BizException
	 */
	private ValidSkinOrInfo[] getPiValidSkinTestOrInfo(String id_pi,String id_skinsrv,FDateTime[] secttime) throws BizException{
		GetPiValidSkinTestOrInfoBP bp=new GetPiValidSkinTestOrInfoBP();
		return bp.exec(id_pi, id_skinsrv, secttime);
	}
	
	/**
	 * 需皮试用药的药品存在有效的已执行用药记录判断
	 * @param id_pi
	 * @param id_srv
	 * @param secttime
	 * @return
	 * @throws BizException 
	 */
	private FBoolean existValidisNeedSkinExOr(String id_pi,String id_srv,String id_mm,FDateTime[] secttime) throws BizException{
		ExistValidIsNeedSkinExOrBP bp=new ExistValidIsNeedSkinExOrBP();
		return bp.exec(id_pi, id_srv,id_mm, secttime);
	}

}
