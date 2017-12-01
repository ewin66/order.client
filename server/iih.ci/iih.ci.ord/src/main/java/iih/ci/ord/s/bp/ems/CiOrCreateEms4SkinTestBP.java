package iih.ci.ord.s.bp.ems;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialRService;
import iih.bd.srv.ems.d.EmsMatchRstDTO;
import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.i.IBdSrvQryService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.d.MedSrvRelMmDTO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.GetDefaultEmsTp8SrvtpBP;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;


/**
 * 创建皮试医嘱相关的医疗单数据操作BP
 */
public class CiOrCreateEms4SkinTestBP {
	
	/**
	 * 创建皮试医嘱相关的医疗单数据
	 * @param srvaggdo
	 * @param ems
	 * @param ht
	 * @return
	 * @throws BizException
	 */
	public CiEmsDTO exec(MedsrvAggDO srvaggdo,CiEmsDTO ems) throws BizException{
		if(ems==null || srvaggdo==null)return null;

		MedSrvDO srvdo=srvaggdo.getParentDO();
		CiEmsDTO skinems=new CiEmsDTO();
		 
		skinems.setEu_orsrcmdtp(OrSourceFromEnum.IIHORRELAUTOGEN);
		//skinems.setId_or();
		skinems.setId_pat(ems.getId_pat());
		skinems.setId_en(ems.getId_en());
		skinems.setId_entp(ems.getId_entp());
		skinems.setCode_entp(ems.getCode_entp());
		skinems.setId_srvtp(srvdo.getId_srvtp());
		skinems.setSd_srvtp(srvdo.getSd_srvtp());
		skinems.setId_srv(srvdo.getId_srv());//zwq 2016-11-04
		//skinems.setId_srv_set();
		//skinems.setId_srv_pkg();
		skinems.setFg_long(FBoolean.FALSE);
		skinems.setEmstype(getEmsType(srvdo.getSd_srvtp()));
		String[] freqs=getFreqInfos();
		skinems.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
		skinems.setName_freq(IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE);
		skinems.setId_route(srvdo.getId_route());
		//skinems.setName_route();
		skinems.setId_routedes(srvdo.getId_routedes());
		//skinems.setName_routedes();
		//skinems.setId_boil(srvdo.getId_boil());
		//skinems.setName_boil();
		//skinems.setId_boildes();
		//skinems.setName_boildes();
		skinems.setFg_boil(FBoolean.FALSE);
		//skinems.setDays_or();
		//skinems.setOrders();
		//skinems.setOrders_boil();
		//skinems.setCode();
		//skinems.setName();
		//skinems.setContent();
		//skinems.setNote();
		skinems.setId_emp_phy(ems.getId_emp_phy());
		skinems.setName_emp_phy(ems.getName_emp_phy());
		skinems.setId_dep_phy(ems.getId_dep_phy());
		skinems.setId_dept_en(ems.getId_dept_en());//zwq 2016-08-18
		skinems.setId_dept_ns(ems.getId_dept_ns());//zwq 2016-08-18
		skinems.setName_dep_phy(ems.getName_dep_phy());
		skinems.setId_wg_or(ems.getId_wg_or());
		FDateTime dt_begin=CiOrdUtils.getSkinTestOrBeginDt(ems); //2016-07-14  增加的新逻辑皮试与用药在同一天（不过日原则）
		skinems.setDt_begin(dt_begin);//ems.getDt_begin());
		skinems.setDt_end(dt_begin);//ems.getDt_begin());
		skinems.setDt_invalid(ems.getDt_invalid());
		skinems.setFg_bb(ems.getFg_bb());
		skinems.setNo_bb(ems.getNo_bb());
		skinems.setFg_pmor(ems.getFg_pmor());
		skinems.setDes_pmor(ems.getDes_pmor());
		skinems.setFg_active_pm(ems.getFg_active_pm());
		skinems.setFg_set(srvdo.getFg_set()); //zwq 2016-09-13
		//skinems.setId_reltp();
		//skinems.setSd_reltp();
		//skinems.setId_or_rel();
		skinems.setFg_ctlcp(FBoolean.FALSE);
		skinems.setFg_mr(FBoolean.FALSE);
		skinems.setFg_skintest(FBoolean.TRUE);
		//skinems.setFg_skintest(FBoolean.FALSE);//创建皮试医嘱，为啥要把皮试标志设置为false；改成上面true标识 2017-04-17 zwq
		//添加医疗单的路径和id lizheng 2016-5-28
		EmsMatchRstDTO retdto = null;
		retdto = getmedSrvMatchEms(ems,srvdo);
		if(retdto != null)
		{
			skinems.setFuncclassstr(retdto.getFuncclassstr());
			skinems.setFg_quickwflow(retdto.getFg_quickwflow());
		}
		skinems.setId_srvof(ems.getId_srvof());
		//skinems.setId_skintest_skip_reaso();
		//skinems.setSd_skintest_skip_reaso();
		if(CiOrdUtils.isOpUrgentWf(skinems.getCode_entp())){
			skinems.setFg_mp_in(FBoolean.TRUE);
			skinems.setTimes_cur(1);
			skinems.setTimes_mp_in(1);
		}else{
			skinems.setFg_mp_in(FBoolean.FALSE);
			//skinems.setTimes_mp_in();
		}
		skinems.setFg_mp_bed(ems.getFg_mp_bed());
		skinems.setTimes_firday_mp(0);
		skinems.setFg_or_doc(FBoolean.TRUE);
		skinems.setId_su_or(ICiDictCodeConst.SD_SU_ID_OPEN);
		skinems.setSd_su_or(ICiDictCodeConst.SD_SU_OPEN);
		skinems.setStatus(DOStatus.NEW); 
		FArrayList emssrvdos=getEmsSrvs(srvaggdo,ems);
		if(emssrvdos!=null && emssrvdos.size()!=0){
			skinems.setEmssrvs(emssrvdos);
		}
		
		//skinems.setCiorfreqtimes(null);
		return skinems;
	}
	
	
	
	/**
	 * 获得频次信息
	 * @return
	 * @throws BizException
	 */
	private String[] getFreqInfos() throws BizException{
		FreqDefDO do1=CiOrdUtils.getOnceFreqDefDO();
		String[] rtns=new String[]{"",""};
		if(do1==null)return rtns;
		rtns[0]=do1.getId_freq();
		rtns[1]=do1.getName();
		return rtns;
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
	 * 获得医疗单服务项目
	 * @param srvaggdo
	 * @param ems
	 * @return
	 * @throws BizException 
	 */
	private FArrayList getEmsSrvs(MedsrvAggDO srvaggdo,CiEmsDTO ems) throws BizException{
		FArrayList list=new FArrayList();
		
		//皮试服务对应的医疗单服务项目
		CiEmsSrvDTO mainsrvdto=createCiEmsSrvDTO(null,srvaggdo,ems);
		list.add(mainsrvdto);
		
		MedSrvDO bdsrvdo=srvaggdo.getParentDO();
		if(OrSrvSplitUtil.isTrue(bdsrvdo.getFg_set())){
			MedSrvSetItemDO[] srvsetitmdos=srvaggdo.getMedSrvSetItemDO();
			CiEmsSrvDTO srvdto=null;
			for(int i=0;i<srvsetitmdos.length;i++){
				srvdto=createCiEmsSrvDTO(mainsrvdto.getId_srv(),srvsetitmdos[i],CiOrdAppUtils.getMedsrvRService().findById(srvsetitmdos[i].getId_srv_itm()),ems);				
				list.add(srvdto);
			}
		}
		return list;
	}
	
	/**
	 * 创建医疗单项目DTO数据
	 * @param bdsrvdo
	 * @param ems
	 * @return
	 * @throws BizException 
	 */
	private CiEmsSrvDTO createCiEmsSrvDTO(String id_srv_set,MedSrvSetItemDO setItemDo,MedsrvAggDO srvaggdo,CiEmsDTO ems) throws BizException{
		MedSrvDO bdsrvdo=srvaggdo.getParentDO();
		CiEmsSrvDTO emssrvdto=new CiEmsSrvDTO();
		 //emssrvdto.setId_orsrv();
		 //emssrvdto.setId_or();
		 //emssrvdto.setSortno();
		 emssrvdto.setId_srv(bdsrvdo.getId_srv());
		 emssrvdto.setId_srv_set(id_srv_set);
		 emssrvdto.setId_srvtp(bdsrvdo.getId_srvtp());
		 emssrvdto.setSd_srvtp(bdsrvdo.getSd_srvtp());
		 emssrvdto.setCode_srv(bdsrvdo.getCode());
		 emssrvdto.setName_srv(bdsrvdo.getName());
		 emssrvdto.setId_srvca(bdsrvdo.getId_srvca());
		 
		 //套内项目的剂量、剂量单位、频次使用套内明细的信息
		 //emssrvdto.setId_unit_med(bdsrvdo.getId_unit_med());
		 emssrvdto.setId_unit_med(setItemDo.getId_medu());
		 //emssrvdto.setName_unit_med();
		 //emssrvdto.setQuan_med(bdsrvdo.getQuan_med());
		 emssrvdto.setQuan_med(setItemDo.getQuan_medu());
		//emssrvdto.setId_freq(bdsrvdo.getId_freq());
		 emssrvdto.setId_freq(setItemDo.getId_freq());
		 
		 emssrvdto.setPrice(getPrice(bdsrvdo.getId_srv(),bdsrvdo.getId_primd())); 
		 //emssrvdto.setName_freq();
		 emssrvdto.setId_route(bdsrvdo.getId_route());
		 //emssrvdto.setName_route();
		 emssrvdto.setId_routedes(bdsrvdo.getId_routedes());
		 //emssrvdto.setName_routedes();
		 emssrvdto.setId_boil(bdsrvdo.getId_boil());
		 //emssrvdto.setName_boil();
		 emssrvdto.setId_boildes(bdsrvdo.getId_boildes());
		 //emssrvdto.setName_boildes();
		 emssrvdto.setFg_dose_anoma(FBoolean.FALSE);
		 emssrvdto.setDes_srv(bdsrvdo.getDes());
		 emssrvdto.setFg_mm(bdsrvdo.getFg_mm());
		 emssrvdto.setFg_set(bdsrvdo.getFg_set());
		 emssrvdto.setFg_or(bdsrvdo.getFg_or());
		 emssrvdto.setFg_bl(bdsrvdo.getFg_bl());//(bdsrvdo.getFg_bl());
		 emssrvdto.setFg_self(FBoolean.FALSE);
		 emssrvdto.setFg_outp(FBoolean.FALSE);
		 emssrvdto.setFg_propc(FBoolean.FALSE);
		 emssrvdto.setFg_treat(FBoolean.FALSE);
		 //emssrvdto.setId_org_srv();
		 emssrvdto.setId_dep_srv(ems.getId_dep_phy());
		 //emssrvdto.setId_ward_srv();
		 emssrvdto.setId_emp_srv(ems.getId_emp_phy());
		 //emssrvdto.setDt_create_srv();
		 //emssrvdto.setId_dep(getMpDeptID(ems,emssrvdto));  //调到最后
		 //emssrvdto.setId_dep(getMpDeptID(ems,emssrvdto)[0]);  //调到最后  lizheng  调到此处 2016-08-05 zwq
		 //emssrvdto.setName_dep();
		 //emssrvdto.setDt_last_bl();
		 //emssrvdto.setId_dep_wh(getMpDeptID(ems,emssrvdto)[1]);
		 emssrvdto.setEu_blmd(bdsrvdo.getEu_blmd());
		 emssrvdto.setId_primd(bdsrvdo.getId_primd()); //2016-06-29 新增字段
		 emssrvdto.setFg_selfsrv(bdsrvdo.getFg_ctm());
		 //emssrvdto.setId_srv_src(srvdto.getId_srv_src());
		 //emssrvdto.setQuan_total_medu(srvdto.getQuan_total_medu());
		 //emssrvdto.setFg_selfpay(null);//2016-07-08新增自费标识
		 //emssrvdto.setId_orsrvmm();
		 if(OrSrvSplitUtil.isTrue(bdsrvdo.getFg_mm())){
			 MedSrvRelMmDTO srvrelmmdo=CiOrdUtils.getSrvRelDefaultMmDTO(bdsrvdo.getId_srv(),CiOrdAppUtils.getEnvContext().getOrgId(),ems.getId_dep_phy());
			 MeterialDO mmdo=null;
			 MedSrvDrugDO medSrvDrugDO =CiOrdUtils.getBdSrvDrugDO(bdsrvdo.getId_srv());
			 if(srvrelmmdo!=null){mmdo=CiOrdAppUtils.getMaterialQryService().findById(srvrelmmdo.getId_mm());}
			 if(mmdo!=null){
				 //查找就诊类型下默认的总量单位，换算系数等
				 MaterialUnitDTO[] materUnit = CiOrdAppUtils.getMaterialBaseInfoyService().getMMunitByEntp(new String[]{mmdo.getId_mm()}, ems.getCode_entp());
				 MaterialUnitDTO materialUnitDTO = null;
				 if(!CiOrdUtils.isEmpty(materUnit)){
					 materialUnitDTO = materUnit[0];
				 }
				 emssrvdto.setId_mm(mmdo.getId_mm());
				 emssrvdto.setCode_mm(mmdo.getCode());
				 emssrvdto.setName_mm(mmdo.getName());
				 emssrvdto.setSpec_mm(mmdo.getSpec());
				 if(CiOrdUtils.isEmpty(materialUnitDTO)){
					 emssrvdto.setId_unit_sale(mmdo.getId_unit_pkgsp());
					 emssrvdto.setName_unit_sale(mmdo.getName_unit_pkgsp());
				 }else{
					 emssrvdto.setId_unit_sale(materialUnitDTO.getId_measdoc());
					 emssrvdto.setName_unit_sale(materialUnitDTO.getMeasdoc_name());
				 }
				 //设置取整模式
				 if(IEnDictCodeConst.SD_DIAGTYPE_OUTPATIENT.equals(ems.getCode_entp())){//门诊
					 emssrvdto.setSd_roundmd(mmdo.getSd_opmutp());
				 }else if(IEnDictCodeConst.SD_DIAGTYPE_HOSPITAL_IN.equals(ems.getCode_entp())){//住院
					 emssrvdto.setSd_roundmd(mmdo.getSd_mupkgutp());
				 }
				 emssrvdto.setId_unit_base(mmdo.getId_unit_pkgbase());
				 emssrvdto.setName_unit_base(mmdo.getName_unit_pkgbase());
				 int[] numben=OrSrvSplitUtil.getNumDen(bdsrvdo.getQuan_med(), mmdo.getFactor_mb());
				 emssrvdto.setQuan_num_base(numben[0]);
				 emssrvdto.setQuan_den_base(numben[1]);
				 emssrvdto.setPrice_cur(getMaterialStockPrice(emssrvdto.getId_dep(),srvrelmmdo.getId_mm(),emssrvdto.getId_unit_sale()));
				 //emssrvdto.setQuan_cur();
				 //emssrvdto.setQuan_base();
				 //emssrvdto.setQuan_bed_medu();
				 emssrvdto.setFactor_cb(mmdo.getFactor_sb());
				 emssrvdto.setFactor_mb(mmdo.getFactor_mb());
				 if(!CiOrdUtils.isEmpty(medSrvDrugDO)){
					 emssrvdto.setId_dosage(medSrvDrugDO.getId_dosage());
					 emssrvdto.setSd_dosage(medSrvDrugDO.getSd_dosage());
					 emssrvdto.setId_pharm(medSrvDrugDO.getId_pharm());
					 emssrvdto.setSd_pharm(medSrvDrugDO.getSd_pharm());
					 emssrvdto.setId_pois(medSrvDrugDO.getId_pois());
					 emssrvdto.setSd_pois(medSrvDrugDO.getSd_pois());
					 emssrvdto.setId_anti(medSrvDrugDO.getId_anti());
					 emssrvdto.setSd_anti(medSrvDrugDO.getSd_anti());
				 }
				 emssrvdto.setId_mmtp(mmdo.getId_mmtp());
				 emssrvdto.setSd_mmtp(mmdo.getSd_mmtp());
				 emssrvdto.setId_val(mmdo.getId_val());
				 emssrvdto.setSd_val(mmdo.getSd_val());
				 emssrvdto.setIndica(mmdo.getIndica());
				 emssrvdto.setConstr(mmdo.getConstr());
				 emssrvdto.setReact(mmdo.getReact());
				 emssrvdto.setGuide(mmdo.getUsage());
				 //emssrvdto.setFg_otc(mmdo.getFg_otc());  //物品中需要增加此字段
			 }
		 }
		 //emssrvdto.setEmsfreqdose();
		 //emssrvdto.setId_body();
		 //emssrvdto.setSd_body();
		 //emssrvdto.setId_pos();
		 //emssrvdto.setSd_pos();
		 //emssrvdto.setBody_name();
		 emssrvdto.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);
		 emssrvdto.setStatus(DOStatus.NEW);
		 
		return emssrvdto;
	}
	
	/**
	 * 创建医疗单项目DTO数据
	 * @param bdsrvdo
	 * @param ems
	 * @return
	 * @throws BizException 
	 */
	private CiEmsSrvDTO createCiEmsSrvDTO(String id_srv_set,MedsrvAggDO srvaggdo,CiEmsDTO ems) throws BizException{
		MedSrvDO bdsrvdo=srvaggdo.getParentDO();
		CiEmsSrvDTO emssrvdto=new CiEmsSrvDTO();
		 //emssrvdto.setId_orsrv();
		 //emssrvdto.setId_or();
		 //emssrvdto.setSortno();
		 emssrvdto.setId_srv(bdsrvdo.getId_srv());
		 emssrvdto.setId_srv_set(id_srv_set);
		 emssrvdto.setId_srvtp(bdsrvdo.getId_srvtp());
		 emssrvdto.setSd_srvtp(bdsrvdo.getSd_srvtp());
		 emssrvdto.setCode_srv(bdsrvdo.getCode());
		 emssrvdto.setName_srv(bdsrvdo.getName());
		 emssrvdto.setId_srvca(bdsrvdo.getId_srvca());
		 emssrvdto.setId_unit_med(bdsrvdo.getId_unit_med());
		 //emssrvdto.setName_unit_med();
		 emssrvdto.setQuan_med(bdsrvdo.getQuan_med());
		 emssrvdto.setPrice(getPrice(bdsrvdo.getId_srv(),bdsrvdo.getId_primd())); 
		 emssrvdto.setId_freq(bdsrvdo.getId_freq());
		 //emssrvdto.setName_freq();
		 emssrvdto.setId_route(bdsrvdo.getId_route());
		 //emssrvdto.setName_route();
		 emssrvdto.setId_routedes(bdsrvdo.getId_routedes());
		 //emssrvdto.setName_routedes();
		 emssrvdto.setId_boil(bdsrvdo.getId_boil());
		 //emssrvdto.setName_boil();
		 emssrvdto.setId_boildes(bdsrvdo.getId_boildes());
		 //emssrvdto.setName_boildes();
		 emssrvdto.setFg_dose_anoma(FBoolean.FALSE);
		 emssrvdto.setDes_srv(bdsrvdo.getDes());
		 emssrvdto.setFg_mm(bdsrvdo.getFg_mm());
		 emssrvdto.setFg_set(bdsrvdo.getFg_set());
		 emssrvdto.setFg_or(bdsrvdo.getFg_or());
		 emssrvdto.setFg_bl(bdsrvdo.getFg_bl());//(bdsrvdo.getFg_bl());
		 emssrvdto.setFg_self(FBoolean.FALSE);
		 emssrvdto.setFg_outp(FBoolean.FALSE);
		 emssrvdto.setFg_propc(FBoolean.FALSE);
		 emssrvdto.setFg_treat(FBoolean.FALSE);
		 //emssrvdto.setId_org_srv();
		 emssrvdto.setId_dep_srv(ems.getId_dep_phy());
		 //emssrvdto.setId_ward_srv();
		 emssrvdto.setId_emp_srv(ems.getId_emp_phy());
		 //emssrvdto.setDt_create_srv();
		 //emssrvdto.setId_dep(getMpDeptID(ems,emssrvdto));  //调到最后
		 //emssrvdto.setId_dep(getMpDeptID(ems,emssrvdto)[0]);  //调到最后  lizheng  调到此处 2016-08-05 zwq
		 //emssrvdto.setName_dep();
		 //emssrvdto.setDt_last_bl();
		 //emssrvdto.setId_dep_wh(getMpDeptID(ems,emssrvdto)[1]);
		 emssrvdto.setEu_blmd(bdsrvdo.getEu_blmd());
		 emssrvdto.setId_primd(bdsrvdo.getId_primd()); //2016-06-29 新增字段
		 emssrvdto.setFg_selfsrv(bdsrvdo.getFg_ctm());
		 //emssrvdto.setId_srv_src(srvdto.getId_srv_src());
		 //emssrvdto.setQuan_total_medu(srvdto.getQuan_total_medu());
		 //emssrvdto.setFg_selfpay(null);//2016-07-08新增自费标识
		 //emssrvdto.setId_orsrvmm();
		 if(OrSrvSplitUtil.isTrue(bdsrvdo.getFg_mm())){
			 MedSrvRelMmDTO srvrelmmdo=CiOrdUtils.getSrvRelDefaultMmDTO(bdsrvdo.getId_srv(),CiOrdAppUtils.getEnvContext().getOrgId(),ems.getId_dep_phy());
			 MeterialDO mmdo=null;
			 MedSrvDrugDO medSrvDrugDO =CiOrdUtils.getBdSrvDrugDO(bdsrvdo.getId_srv());
			 if(srvrelmmdo!=null){mmdo=CiOrdAppUtils.getMaterialQryService().findById(srvrelmmdo.getId_mm());}
			 if(mmdo!=null){
				 emssrvdto.setId_mm(mmdo.getId_mm());
				 emssrvdto.setCode_mm(mmdo.getCode());
				 emssrvdto.setName_mm(mmdo.getName());
				 emssrvdto.setSpec_mm(mmdo.getSpec());
				 emssrvdto.setId_unit_sale(mmdo.getId_unit_pkgsp());
				 emssrvdto.setName_unit_sale(mmdo.getName_unit_pkgsp());
				 emssrvdto.setId_unit_base(mmdo.getId_unit_pkgbase());
				 emssrvdto.setName_unit_base(mmdo.getName_unit_pkgbase());
				 int[] numben=OrSrvSplitUtil.getNumDen(bdsrvdo.getQuan_med(), mmdo.getFactor_mb());
				 emssrvdto.setQuan_num_base(numben[0]);
				 emssrvdto.setQuan_den_base(numben[1]);
				 emssrvdto.setPrice_cur(getMaterialStockPrice(emssrvdto.getId_dep(),srvrelmmdo.getId_mm(),mmdo.getId_unit_pkgsp()));
				 //emssrvdto.setQuan_cur();
				 //emssrvdto.setQuan_base();
				 //emssrvdto.setQuan_bed_medu();
				 emssrvdto.setFactor_cb(mmdo.getFactor_sb());
				 emssrvdto.setFactor_mb(mmdo.getFactor_mb());
				 if(!CiOrdUtils.isEmpty(medSrvDrugDO)){
					 emssrvdto.setId_dosage(medSrvDrugDO.getId_dosage());
					 emssrvdto.setSd_dosage(medSrvDrugDO.getSd_dosage());
					 emssrvdto.setId_pharm(medSrvDrugDO.getId_pharm());
					 emssrvdto.setSd_pharm(medSrvDrugDO.getSd_pharm());
					 emssrvdto.setId_pois(medSrvDrugDO.getId_pois());
					 emssrvdto.setSd_pois(medSrvDrugDO.getSd_pois());
					 emssrvdto.setId_anti(medSrvDrugDO.getId_anti());
					 emssrvdto.setSd_anti(medSrvDrugDO.getSd_anti());
				 }
				 emssrvdto.setId_mmtp(mmdo.getId_mmtp());
				 emssrvdto.setSd_mmtp(mmdo.getSd_mmtp());
				 emssrvdto.setId_val(mmdo.getId_val());
				 emssrvdto.setSd_val(mmdo.getSd_val());
				 emssrvdto.setIndica(mmdo.getIndica());
				 emssrvdto.setConstr(mmdo.getConstr());
				 emssrvdto.setReact(mmdo.getReact());
				 emssrvdto.setGuide(mmdo.getUsage());
				 //emssrvdto.setFg_otc(mmdo.getFg_otc());  //物品中需要增加此字段
			 }
		 }
		 //emssrvdto.setEmsfreqdose();
		 //emssrvdto.setId_body();
		 //emssrvdto.setSd_body();
		 //emssrvdto.setId_pos();
		 //emssrvdto.setSd_pos();
		 //emssrvdto.setBody_name();
		 emssrvdto.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);
		 emssrvdto.setStatus(DOStatus.NEW);
		 
		return emssrvdto;
	}
	

	/**
	 * 获得服务对应的执行科室
	 * @return
	 * @throws BizException
	 */
	private String[] getMpDeptID(CiEmsDTO ems,CiEmsSrvDTO emssrvdto) throws BizException{
		String[] deptInfo = new String[]{"",""};
		OrWfExDeptParamDTO param=getOrWfExDeptParam(ems,emssrvdto);
		CiOrSrvExecuteDeptGetBP bp=new CiOrSrvExecuteDeptGetBP();
		OrWfExDeptDTO[] do1=bp.exec(param);
		if(do1==null || do1.length==0) throw new BizException();
	     for(int i=0;i<do1.length;i++){
	    	 OrWfExDeptDTO dto = do1[0];
	    	 if(dto.getEu_wftp()==null)
	    	 {
	    		 deptInfo[0] = dto.getId_dept();
	    		 deptInfo[1] = dto.getId_dept();
	    		 return deptInfo;
	    	 }
	    	  if(dto.getEu_wftp().equals("1")){
	    		  deptInfo[0] = dto.getId_dept();
	    	  }else if(dto.getEu_wftp().equals("2")){
	    		  deptInfo[1] = dto.getId_dept();
	    	  }
	     }
		return deptInfo;
	}
	private OrWfExDeptParamDTO getOrWfExDeptParam(CiEmsDTO ems,CiEmsSrvDTO emssrvdto){
		OrWfExDeptParamDTO param=new OrWfExDeptParamDTO();
		param.setCode_entp(ems.getCode_entp());
		param.setSd_srvtp(emssrvdto.getSd_srvtp());
		param.setId_srvca(emssrvdto.getId_srvca());
		param.setId_usage(emssrvdto.getId_route());
		param.setRecurstr(CiOrdUtils.getFg_longStr(ems.getFg_long()));
		//param.setWeekno();
		//param.setTimestr();
		param.setId_srv(emssrvdto.getId_srv());
		param.setId_mm(emssrvdto.getId_mm());
		param.setId_dept_en(ems.getId_dept_en());
		param.setId_dept_ns(ems.getId_dept_ns());
		param.setId_dept_or(ems.getId_dep_phy());
		//param.setId_dept_ex();
		param.setReserv1(emssrvdto.getId_srv_set());  //所属套
		//param.setReserv2();
		//param.setReserv3();		

		return param;
	}
	
	
	/**
	 * 获得服务价格
	 * @param id_srv
	 * @param id_primd
	 * @return
	 * @throws BizException
	 */
	private FDouble getPrice(String id_srv,String id_primd) throws BizException{
		CiOrCalSrvPriceBP bp=new CiOrCalSrvPriceBP();
		return bp.exec(id_srv, id_primd);
	}
	
	/**
	 * 获得价格  结存量信息
	 * @param id_dep
	 * @param id_mm
	 * @param id_unit
	 * @return
	 * @throws BizException
	 */
	private FDouble  getMaterialStockPrice(String id_dep,String id_mm,String id_unit)  throws BizException{
		CiOrGetMmPriceBP bp=new CiOrGetMmPriceBP();
		return bp.exec(id_dep, id_mm, id_unit);
	}
	
	/**
	 * 根据医疗用量获得医嘱项目对应物品相关数据
	 * @param quan_medu
	 * @param factor_mb
	 * @param factor_cb
	 * @return
	 */
	private FDouble[] getMmQuanInfos(FDouble quan_medu,FDouble factor_mb,FDouble factor_cb){
		 //emssrvdto.setQuan_num_base();
		 //emssrvdto.setQuan_den_base();
		 //emssrvdto.setQuan_cur();
		 //emssrvdto.setQuan_base();	
		
		
		return null;
	}
	/**
	 * 医疗单匹配
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private  EmsMatchRstDTO getmedSrvMatchEms(CiEmsDTO ems, MedSrvDO srvdo)throws BizException {
		 
		SrvMatchEmsParamDTO param = new SrvMatchEmsParamDTO();
		param.setId_grp(CiOrdAppUtils.getEnvContext().getGroupId());
		param.setId_org(CiOrdAppUtils.getEnvContext().getOrgId());
		param.setId_dept(ems.getId_dept_en());
		param.setId_srv(srvdo.getId_srv());
		param.setSd_srvtp(srvdo.getSd_srvtp());
		param.setCode_entp(ems.getCode_entp());
		param.setDt_or(ems.getDt_begin());
		param.setEmsappmode(1);
		param.setId_emp(CiOrdAppUtils.getEnvContext().getUserId());
		return ServiceFinder.find(IBdSrvQryService.class).medSrvMatchEms(param);
	}
	
}
