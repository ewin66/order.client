package iih.ci.ord.s.bp.assi;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.bd.fc.wf.d.EnumFlow;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.ExeDeptCalParamDTO;
import iih.ci.ord.emsdi.d.ExeWhDeptDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.GetDefaultEmsTp8SrvtpBP;
import iih.ci.ord.s.bp.base.fc.GetOrMpCloseLoopTpBP;
import iih.ci.ord.tmpl.d.CiOrBasicEleEnum;
import iih.ci.ord.tmpl.d.CiOrTmplDTO;
import iih.ci.ord.tmpl.d.LongTempOrEnum;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;

/**
 * 根据临床医嘱模板创建医疗单Ems数据操作BP
 * 单模板、单医疗单
 */
public class CiOrCreateEms4OrTmplBP {
	/**
	 * 根据临床医嘱模板数据创建医疗单数据
	 * @param context  患者就诊上下文信息
	 * @param ortmpl   临床医嘱模板
	 * @return
	 * @throws BizException
	 */
	public CiEmsDTO exec(CiEnContextDTO context,CiOrTmplDTO ortmpl) throws BizException{
		CiEmsDTO emsdto=new CiEmsDTO();
		
		//获得服务对象
		MedsrvAggDO srvaggdo=CiOrdAppUtils.getMedsrvRService().findById(ortmpl.getId_srv());
		if(CiOrdUtils.isEmpty(srvaggdo))return null;
		MedSrvDO bdsrvdo=srvaggdo.getParentDO();
		String[] vTmp=null;
		
		//患者就诊数据信息
		//emsdto.setId_or(); 
		emsdto.setId_grp(context.getId_grp());
		emsdto.setId_org(context.getId_org());
		emsdto.setId_pat(context.getId_pat());
		emsdto.setId_en(context.getId_en());
		emsdto.setFg_bb(context.getFg_bb());
		emsdto.setNo_bb(context.getNo_bb());
		emsdto.setId_entp(context.getId_entp());
		emsdto.setCode_entp(context.getCode_entp());
		emsdto.setId_dept_en(context.getId_dep_en());
		emsdto.setId_dept_ns(context.getId_dep_ns());
		
		//医疗单展示相关数据信息
		emsdto.setEmstype(getEmsType(bdsrvdo.getSd_srvtp()));
		SrvMatchEmsRstDTO emsmatchrst=CiOrdUtils.getFuncClassStr(context, bdsrvdo);
		emsdto.setId_srvof(emsmatchrst.getId_ems());
		emsdto.setFuncclassstr(emsmatchrst.getFuncclassstr());
		emsdto.setName_ems(emsmatchrst.getName_show());
		emsdto.setEmsappmode(context.getEmsappmode());
		emsdto.setCode(ortmpl.getCode());
		emsdto.setName(ortmpl.getName());
		//emsdto.setContent();
		emsdto.setDes_or(ortmpl.getDes_or());
		//emsdto.setNote();
		//emsdto.setApplyno();
		emsdto.setFg_urgent(FBoolean.FALSE);
		
		emsdto.setId_srv(ortmpl.getId_srv());
		emsdto.setFg_set(bdsrvdo.getFg_set());
		emsdto.setId_srvca(bdsrvdo.getId_srvca());
		emsdto.setInnercode_srvca(bdsrvdo.getSrvca_innercode());
		emsdto.setId_srvtp(bdsrvdo.getId_srvtp());
		emsdto.setSd_srvtp(bdsrvdo.getSd_srvtp());
		//emsdto.setId_srv_pkg(); //暂时未用到
		vTmp=getEmsStrFldV(ortmpl.getId_freq(),bdsrvdo,new String[]{MedSrvDO.ID_FREQ,MedSrvDO.FREQ_NAME,MedSrvDO.FREQCT,MedSrvDO.FREQUNITCT,MedSrvDO.SD_FREQUNITCT},CiOrBasicEleEnum.FREQDEF);
		emsdto.setId_freq(vTmp[0]);
		emsdto.setName_freq(vTmp[1]);
		emsdto.setFreqct(Integer.valueOf(vTmp[2]));
		emsdto.setFrequnitct(Integer.valueOf(vTmp[3]));
		emsdto.setSd_frequnitct(vTmp[4]);
		vTmp=getEmsStrFldV(ortmpl.getId_route(),bdsrvdo,new String[]{MedSrvDO.ID_ROUTE,MedSrvDO.ROUTE_NAME},CiOrBasicEleEnum.ROUTE);
		emsdto.setId_route(vTmp[0]);
		emsdto.setName_route(vTmp[1]);
		vTmp=getEmsStrFldV(ortmpl.getId_routedes(),bdsrvdo,new String[]{MedSrvDO.ID_ROUTEDES,MedSrvDO.ROUTEDES_NAME},CiOrBasicEleEnum.ROUTEDES);
		emsdto.setId_routedes(vTmp[0]);
		emsdto.setName_routedes(vTmp[1]);
		vTmp=getEmsStrFldV(ortmpl.getId_boil(),bdsrvdo,new String[]{MedSrvDO.ID_BOIL,MedSrvDO.BOIL_NAME},CiOrBasicEleEnum.BOIL);
		emsdto.setId_boil(vTmp[0]);
		emsdto.setName_boil(vTmp[1]);
		vTmp=getEmsStrFldV(ortmpl.getId_boildes(),bdsrvdo,new String[]{MedSrvDO.ID_BOILDES,MedSrvDO.BOILDES_NAME},CiOrBasicEleEnum.BOILDES);
		emsdto.setId_boildes(vTmp[0]);
		emsdto.setName_boildes(vTmp[1]);
		//emsdto.setId_unit_med();   //这个概念废弃不用了
		//emsdto.setName_unit_med(); //这个概念废弃不用了
		//emsdto.setQuan_medu();     //这个概念废弃不用了
		emsdto.setFg_boil(FBoolean.FALSE);
		emsdto.setDays_or(ortmpl.getDays_or());
		emsdto.setOrders(ortmpl.getOrders());
		//emsdto.setOrders_boil();
		emsdto.setTimes_cur(ortmpl.getTimes());
		emsdto.setFg_long(getFgLongV(ortmpl.getEu_long(),emsdto.getId_freq()));  //设置长期、临时医嘱属性

		emsdto.setId_su_or(ICiDictCodeConst.SD_SU_ID_OPEN);
		emsdto.setSd_su_or(ICiDictCodeConst.SD_SU_OPEN);
		emsdto.setId_dep_phy(context.getId_dep_or());
		//emsdto.setName_dep_phy();
		emsdto.setId_wg_or(context.getId_wg_or());
		emsdto.setId_emp_phy(context.getId_emp_or());
		//emsdto.setName_emp_phy();
		emsdto.setDt_begin(CiOrdAppUtils.getServerDateTime());   
		//emsdto.setDt_end();     
		//emsdto.setDt_invalid();
		ExeWhDeptDTO exeandwhdeptinfo=getMpDeptID(emsdto); //注意执行科室算法的位置要偏后  否则有些参数值不对 
		emsdto.setId_dep_mp(exeandwhdeptinfo.getId_dep_mp());   
		emsdto.setName_dep_mp(exeandwhdeptinfo.getName_dep_mp());
		
		emsdto.setFg_pmor(FBoolean.FALSE);
		//emsdto.setDes_pmor();
		emsdto.setFg_active_pm(FBoolean.FALSE);
		emsdto.setFg_ctlcp(FBoolean.FALSE);
		emsdto.setFg_mr(FBoolean.FALSE);
		emsdto.setFg_skintest(FBoolean.FALSE);
		//emsdto.setId_skintest_skip_reaso();
		//emsdto.setSd_skintest_skip_reaso();
		//emsdto.setId_reltp();
		//emsdto.setSd_reltp();
		//emsdto.setId_or_rel();
		emsdto.setFg_mp_in(FBoolean.FALSE);
		//emsdto.setTimes_mp_in();
		//emsdto.setTimes_firday_mp();
		emsdto.setFg_mp_bed(FBoolean.FALSE);
		emsdto.setFg_or_doc(FBoolean.TRUE);
		emsdto.setFg_pres_outp(FBoolean.FALSE);
		emsdto.setFg_syncfee(FBoolean.FALSE);
		//emsdto.setId_orrsttp();
		//emsdto.setSd_orrsttp();
		//emsdto.setId_orpltp();   //这个闭环逻辑应该放在   ems--》or层面比较经济
		
		//创建医疗单项目集合
		createEmssrvs(emsdto,context,ortmpl);  //emsdto.setEmssrvs(); 
		
		//emsdto.setSrvsetitms();
		//emsdto.setOrapplysheet();
		//emsdto.setMapkeys();
		//emsdto.setMapinfo();
		
		return emsdto;
	}
	
	/**
	 * 创建医疗单项目集合list
	 * @param emsdto
	 * @param context
	 * @param ortmpl
	 * @throws BizException
	 */
	private void createEmssrvs(CiEmsDTO emsdto,CiEnContextDTO context,CiOrTmplDTO ortmpl) throws BizException{
		CiOrCreateEmsSrvMms4OrTmplBP bp=new CiOrCreateEmsSrvMms4OrTmplBP();
		bp.exec(emsdto,context, ortmpl);
	}
	
	/**
	 * 获得医疗单类型
	 * @param sd_srvtp
	 * @return
	 * @throws BizException 
	 */
	private Integer getEmsType(String sd_srvtp) throws BizException{
		GetDefaultEmsTp8SrvtpBP bp=new GetDefaultEmsTp8SrvtpBP();
		return bp.exec(sd_srvtp);
	}
	
	/**
	 * 获得医嘱闭环类型id
	 * 
	 * @param ordo
	 * @return
	 * @throws BizException
	 */
	private String getOrCLoopTpId(CiOrderDO ordo) throws BizException {
		try {
			GetOrMpCloseLoopTpBP bp = new GetOrMpCloseLoopTpBP();
			OrpltpDO[] cltpids = bp.exec(ordo);
			if (CiOrdUtils.isEmpty(cltpids)){return null;}
			return cltpids[0].getId_orpltp();
		} catch (Exception e) {
			Logger.error(e);
		}
		return null;
	}
	
	/**
	 * 获得医疗单字符字段值数据信息
	 * 模板值优先 BDSrv次之
	 * @param id_biz
	 * @param bdsrvdo
	 * @param fldname
	 * @return
	 * @throws BizException 
	 */
	private String[] getEmsStrFldV(String id_biz,MedSrvDO bdsrvdo,String[] fldnames,Integer eletype) throws BizException{
		//参数
		int iN=fldnames.length;
		String[] rtns=new String[iN];
		
		//标准模板值非空时的处理逻辑
		if(!CiOrdUtils.isEmpty(id_biz)){
			return getEmsStrFldV(id_biz,iN,eletype);
		}
		
		//遍历
		for(int i=0;i<iN;i++){
			rtns[i]=(String)bdsrvdo.getAttrVal(fldnames[i]);
		}
		
		//返回结果
		return rtns;
	}
	/**
	 * 
	 * @param id_biz
	 * @param iN
	 * @param eletype
	 * @return
	 * @throws BizException 
	 */
	private String[] getEmsStrFldV(String id_biz,Integer iN,Integer eletype) throws BizException{
		String[] rtns=new String[iN];
		rtns[0]=id_biz;
		if(CiOrBasicEleEnum.FREQDEF.equals(eletype)){
			FreqDefDO freqdefdo=CiOrdAppUtils.getFreqdefMDORService().findById(id_biz);
			if(CiOrdUtils.isEmpty(freqdefdo)){
				rtns[1]=freqdefdo.getName();
				rtns[2]=CiOrdUtils.Integer2String(freqdefdo.getFreqct());
				rtns[3]=CiOrdUtils.Integer2String(freqdefdo.getFrequnitct());
				rtns[4]=freqdefdo.getSd_frequnitct();
			}
		}else if(CiOrBasicEleEnum.ROUTE.equals(eletype)){
			//名称不需要  暂时先不取值
		}else if(CiOrBasicEleEnum.ROUTEDES.equals(eletype)){
			//名称不需要  暂时先不取值
		}else if(CiOrBasicEleEnum.BOIL.equals(eletype)){
			//名称不需要  暂时先不取值
		}else if(CiOrBasicEleEnum.BOILDES.equals(eletype)){
			//名称不需要  暂时先不取值
		}
		
		return rtns;
	}
	
	/**
	 * 获得医嘱长期、临时值
	 * @param eu_long
	 * @param id_freq
	 * @return
	 * @throws BizException 
	 */
	private FBoolean getFgLongV(Integer eu_long,String id_freq) throws BizException{
		if(CiOrdUtils.isEmpty(eu_long)){return CiOrdUtils.getFglong8IdFreq(id_freq);}
		
		if(LongTempOrEnum.LONGTMPNULLOR.equals(eu_long)){
			return CiOrdUtils.getFglong8IdFreq(id_freq);
		}else if(LongTempOrEnum.LONGOR.equals(eu_long)){
			return FBoolean.TRUE;
		}else if(LongTempOrEnum.TEMPORARYOR.equals(eu_long)){
			return FBoolean.FALSE;
		}
		return FBoolean.FALSE;
	}
	
	/**
	 * 获得执行科室数据信息
	 * @param ordo
	 * @param ems
	 * @param srvinsetdo
	 * @param tmpdo
	 * @param srvrelmmdo
	 * @return
	 * @throws BizException
	 */
	private ExeWhDeptDTO getMpDeptID(CiEmsDTO ems) throws BizException{
		ExeDeptCalParamDTO param=getExeDeptCalParamDTO(ems);
		return CiOrdUtils.getMpDeptID(param);
	}
	
	/**
	 * 获得执行科室计算参数信息DTO
	 * @param ordo
	 * @param ems
	 * @param srvinsetdo
	 * @param tmpdo
	 * @param srvrelmmdo
	 * @return
	 */
	private ExeDeptCalParamDTO getExeDeptCalParamDTO(CiEmsDTO ems){
		ExeDeptCalParamDTO paramdto=new ExeDeptCalParamDTO();
		paramdto.setCode_entp(ems.getCode_entp());
		paramdto.setId_dep_en(ems.getId_dept_en());
		paramdto.setId_dep_or(ems.getId_dep_phy());
		paramdto.setId_dep_ns(ems.getId_dept_ns());
		paramdto.setFg_long(ems.getFg_long());
		paramdto.setId_srv(ems.getId_srv());
		//paramdto.setId_mm();
		paramdto.setSd_srvtp(ems.getSd_srvtp());
		paramdto.setId_srvca(ems.getId_srvca());
		paramdto.setInnercode_srvca(ems.getInnercode_srvca());
		paramdto.setId_route(ems.getId_route());
		paramdto.setDt_effe(ems.getDt_begin());
		//paramdto.setDef1();
		//paramdto.setDef2();
		//paramdto.setDef3();
		//paramdto.setDef4();
		//paramdto.setDef5();
		paramdto.setEu_wftp(EnumFlow.EXECUTEFLOW);  //只求执行科室
		
		return paramdto;
	}

}
