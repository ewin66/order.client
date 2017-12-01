package iih.ci.ord.s.bp.assi;

import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.tmpl.d.CiOrTmplDTO;
import iih.ci.ord.tmpl.d.CiOrTmplSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 根据临床医嘱模板项目创建医疗单项目集合数据操作BP
 * 医疗单项目及物品信息创建
 * （集合信息）
 */
public class CiOrCreateEmsSrvMms4OrTmplBP {
	/**
	 * 根据临床医嘱模板项目数据创建医疗单项目数据
	 * 医疗单项目及物品信息创建
	 * （集合信息）
	 * @param emsdto  医疗单头信息
	 * @param context  患者就诊上下文信息
	 * @param ortmpl   临床医嘱模板
	 * @return
	 * @throws BizException
	 */
	public void exec(CiEmsDTO emsdto,CiEnContextDTO context,CiOrTmplDTO ortmpl) throws BizException{
		//获得医嘱模板项目集合list
		FArrayList ortmplsrvs=ortmpl.getOrtmplsrvs();
		CiEmsSrvDTO emssrvdto=null;
		
		//遍历
		for(int i=0;i<ortmplsrvs.size();i++){
			//创建医疗单项目数据信息
			emssrvdto=createEmsSrvDTO(emsdto,(CiOrTmplSrvDTO)ortmplsrvs.get(i));
			
			//添加到医疗单项目列表
			ortmplsrvs.add(emssrvdto);
		}
		
		//添加到医疗单项目列表集合中
		if(!CiOrdUtils.isEmpty(ortmplsrvs)){emsdto.setEmssrvs(ortmplsrvs);}
		
	}
	
	/**
	 * 创建医疗单项目数据信息
	 * @param emsdto
	 * @param ortmplsrv
	 * @return
	 */
	private CiEmsSrvDTO createEmsSrvDTO(CiEmsDTO emsdto,CiOrTmplSrvDTO ortmplsrv){
		CiEmsSrvDTO emssrvdto=new CiEmsSrvDTO();
		if(emsdto.getId_srv().equals(ortmplsrv.getId_srv()))
		//emssrvdto.setId_orsrv();
		//emssrvdto.setId_or();
		//emssrvdto.setSortno();
		
		//emssrvdto.setId_srv();
		//emssrvdto.setId_srv_set();
		//emssrvdto.setId_srvtp();
		//emssrvdto.setSd_srvtp();
		//emssrvdto.setCode_srv();
		//emssrvdto.setName_srv();
		//emssrvdto.setId_srvca();
		//emssrvdto.setId_unit_med();
		//emssrvdto.setName_unit_med();
		//emssrvdto.setQuan_med();
		//emssrvdto.setPrice();
		//emssrvdto.setId_freq();
		//emssrvdto.setName_freq();
		//emssrvdto.setId_route();
		//emssrvdto.setName_route();
		//emssrvdto.setId_routedes();
		//emssrvdto.setName_routedes();
		//emssrvdto.setId_boil();
		//emssrvdto.setName_boil();
		//emssrvdto.setId_boildes();
		//emssrvdto.setName_boildes();
		//emssrvdto.setFg_dose_anoma();
		//emssrvdto.setDes_srv();
		//emssrvdto.setFg_mm();
		//emssrvdto.setFg_set();
		//emssrvdto.setFg_or();
		//emssrvdto.setFg_bl();
		//emssrvdto.setFg_self();
		//emssrvdto.setFg_outp();
		//emssrvdto.setFg_propc();
		//emssrvdto.setFg_treat();
		emssrvdto.setId_org_srv(emsdto.getId_org());   //这里可不赋值，到order中设置
		emssrvdto.setId_dep_srv(emsdto.getId_dep_phy());//这里可不赋值，到order中设置
		emssrvdto.setId_ward_srv(emsdto.getId_dept_ns());//这里可不赋值，到order中设置
		emssrvdto.setId_emp_srv(emsdto.getId_emp_phy());//这里可不赋值，到order中设置
		emssrvdto.setDt_create_srv(CiOrdAppUtils.getServerDateTime());//这里可不赋值，到order中设置		
		//emssrvdto.setId_dep();
		//emssrvdto.setName_dep();
		//emssrvdto.setDt_last_bl();
		//emssrvdto.setEu_blmd();
		//emssrvdto.setId_orsrvmm();
		//emssrvdto.setId_mm();
		//emssrvdto.setCode_mm();
		//emssrvdto.setName_mm();
		//emssrvdto.setSpec_mm();
		//emssrvdto.setId_unit_sale();
		//emssrvdto.setName_unit_sale();
		//emssrvdto.setId_unit_base();
		//emssrvdto.setName_unit_base();
		//emssrvdto.setQuan_num_base();
		//emssrvdto.setQuan_den_base();
		//emssrvdto.setPrice_cur();
		//emssrvdto.setQuan_cur();
		//emssrvdto.setQuan_base();
		//emssrvdto.setQuan_bed_medu();
		//emssrvdto.setFactor_cb();
		//emssrvdto.setFactor_mb();
		//emssrvdto.setId_dosage();
		//emssrvdto.setSd_dosage();
		//emssrvdto.setId_pharm();
		//emssrvdto.setSd_pharm();
		//emssrvdto.setId_pois();
		//emssrvdto.setSd_pois();
		//emssrvdto.setId_anti();
		//emssrvdto.setSd_anti();
		//emssrvdto.setId_mmtp();
		//emssrvdto.setSd_mmtp();
		//emssrvdto.setId_val();
		//emssrvdto.setSd_val();
		//emssrvdto.setIndica();
		//emssrvdto.setConstr();
		//emssrvdto.setReact();
		//emssrvdto.setGuide();
		//emssrvdto.setFg_otc();
		//emssrvdto.setEmsfreqdose();
		//emssrvdto.setId_body();
		//emssrvdto.setSd_body();
		//emssrvdto.setBody_name();
		//emssrvdto.setId_pos();
		//emssrvdto.setSd_pos();
		//emssrvdto.setPos_name();
		//emssrvdto.setFg_indic();
		//emssrvdto.setEu_sourcemd();
		//emssrvdto.setSrv_sv();
		//emssrvdto.setMm_sv();
		//emssrvdto.setFg_skintest();
		//emssrvdto.setId_skintest_skip_reason();
		//emssrvdto.setSd_skintest_skip_reason();
		//emssrvdto.setId_reltp();
		//emssrvdto.setSd_reltp();
		//emssrvdto.setId_or_rel();
		//emssrvdto.setFg_skintest_rst();
		//emssrvdto.setFg_selfsrv();
		//emssrvdto.setId_srv_src();
		//emssrvdto.setQuan_total_medu();
		//emssrvdto.setId_primd();
		//emssrvdto.setFg_selfpay();
		//emssrvdto.setId_hp();
		//emssrvdto.setId_hpsrvtp();
		//emssrvdto.setSd_hpsrvtp();
		//emssrvdto.setId_dep_wh();
		//emssrvdto.setEmsagentinfo();
		//emssrvdto.setInnercode_srvca();
		//emssrvdto.setSd_frequnitct();
		//emssrvdto.setFrequnitct();
		//emssrvdto.setFreqct();
		//emssrvdto.setName_hpsrvtp();
		//emssrvdto.setLimit();
		//emssrvdto.setAmt_total();
		//emssrvdto.setName_dep_wh();
		//emssrvdto.setId_unit_cg();
		//emssrvdto.setName_unit_cg();
		//emssrvdto.setQuan_cgbase();
		//emssrvdto.setFactor_cm();
		//emssrvdto.setSd_roundmd_cg();
		//emssrvdto.setName_mmtp();
		//emssrvdto.setId_sup();
		//emssrvdto.setName_sup();
		//emssrvdto.setSd_roundmd();
		//emssrvdto.setAmt_cur();
		//emssrvdto.setQuan_stock();
		//emssrvdto.setId_srvskin();
		//emssrvdto.setMapkeys();
		//emssrvdto.setMapinfo();
		//emssrvdto.setPriby();
		//emssrvdto.setFg_base();
		return emssrvdto;
	}
	
}
