package iih.ci.ord.s.bp.orsrvsplit;

import java.lang.reflect.Field;

import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import xap.mw.core.data.BizException;

/***
 * 服务拆分后的服务拆分医嘱克隆操作BP
 */
public class SrvSplitOrderCloneBP {
	/***
	 * 服务拆分后的服务拆分医嘱克隆操作
	 * @param orsplitorder
	 * @return
	 * @throws BizException
	 */
	public SrvSplitOrderDTO exec(SrvSplitOrderDTO srvsplitorder)  throws BizException{
		
		//ly修改
		return (SrvSplitOrderDTO)srvsplitorder.clone();
		//return clone(srvsplitorder);
	}
	
	/***
	 * 客隆算法
	 * @param orsplitorder
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	private SrvSplitOrderDTO clone(SrvSplitOrderDTO srvsplitorder){
		SrvSplitOrderDTO rtn=new SrvSplitOrderDTO();
		rtn.setId_or(srvsplitorder.getId_or());
		rtn.setId_grp(srvsplitorder.getId_grp());
		rtn.setId_org(srvsplitorder.getId_org());
		rtn.setId_pat(srvsplitorder.getId_pat());
		rtn.setId_entp(srvsplitorder.getId_entp());
		rtn.setCode_entp(srvsplitorder.getCode_entp());
		rtn.setId_en(srvsplitorder.getId_en());
		rtn.setFg_bb(srvsplitorder.getFg_bb());
		rtn.setNo_bb(srvsplitorder.getNo_bb());
		rtn.setContent_or(srvsplitorder.getContent_or());
		rtn.setName_or(srvsplitorder.getName_or());
		rtn.setId_su_or(srvsplitorder.getId_su_or());
		rtn.setSd_su_or(srvsplitorder.getSd_su_or());
		rtn.setDt_effe(srvsplitorder.getDt_effe());
		rtn.setDt_end(srvsplitorder.getDt_end());
		rtn.setDt_invalid(srvsplitorder.getDt_invalid());
		rtn.setFg_long(srvsplitorder.getFg_long());
		rtn.setFg_boil(srvsplitorder.getFg_boil());
		rtn.setQuan_or(srvsplitorder.getQuan_or());
		rtn.setOrders_boil(srvsplitorder.getOrders_boil());
		rtn.setFg_skintest(srvsplitorder.getFg_skintest());
		rtn.setFg_mp_bed(srvsplitorder.getFg_mp_bed());
		rtn.setDt_stop(srvsplitorder.getDt_stop());
		rtn.setName_pati(srvsplitorder.getName_pati());
		rtn.setGender(srvsplitorder.getGender());
		rtn.setDt_birth(srvsplitorder.getDt_birth());
		rtn.setNo_bed(srvsplitorder.getNo_bed());
		rtn.setOrattachinfos(srvsplitorder.getOrattachinfos());
		
		rtn.setId_orsrv(srvsplitorder.getId_orsrv());
		rtn.setId_srv(srvsplitorder.getId_srv());
		rtn.setCode_srv(srvsplitorder.getCode_srv());
		rtn.setName_srv(srvsplitorder.getName_srv());
		rtn.setSortno(srvsplitorder.getSortno());
		rtn.setId_srvca(srvsplitorder.getId_srvca());
		rtn.setFg_mm(srvsplitorder.getFg_mm());
		rtn.setId_medu(srvsplitorder.getId_medu());
		rtn.setQuan_medu(srvsplitorder.getQuan_medu());
		rtn.setFg_pres_outp(srvsplitorder.getFg_pres_outp());
		rtn.setFg_or(srvsplitorder.getFg_or());
		rtn.setEu_blmd(srvsplitorder.getEu_blmd());
		rtn.setFg_bl(srvsplitorder.getFg_bl());
		rtn.setFg_indic(srvsplitorder.getFg_indic());
		rtn.setFg_dose_anoma(srvsplitorder.getFg_dose_anoma());
		rtn.setDt_last_bl(srvsplitorder.getDt_last_bl());
		rtn.setDt_last_mp(srvsplitorder.getDt_last_mp());
		rtn.setId_org_mp(srvsplitorder.getId_org_mp());
		rtn.setId_dep_mp(srvsplitorder.getId_dep_mp());
		
		rtn.setId_mm(srvsplitorder.getId_mm());
		rtn.setId_mmtp(srvsplitorder.getId_mmtp());
		rtn.setSd_mmtp(srvsplitorder.getSd_mmtp());
		rtn.setCode_mm(srvsplitorder.getCode_mm());
		rtn.setName_mm(srvsplitorder.getName_mm());
		rtn.setId_pkgu_base(srvsplitorder.getId_pkgu_base());
		rtn.setId_pkgu_cur(srvsplitorder.getId_pkgu_cur());
		rtn.setFactor(srvsplitorder.getFactor());
		rtn.setQuan_num_base(srvsplitorder.getQuan_num_base());
		rtn.setQuan_den_base(srvsplitorder.getQuan_den_base());
		rtn.setQuan_cur(srvsplitorder.getQuan_cur());
		rtn.setQuan_bed_medu(srvsplitorder.getQuan_bed_medu());
		rtn.setFg_otc(srvsplitorder.getFg_otc());
		rtn.setId_val(srvsplitorder.getId_val());
		rtn.setSd_val(srvsplitorder.getSd_val());

		rtn.setDt_create(srvsplitorder.getDt_create());
		rtn.setId_org_create(srvsplitorder.getId_org_create());
		rtn.setId_dep_create(srvsplitorder.getId_dep_create());
		rtn.setId_emp_create(srvsplitorder.getId_emp_create());
		rtn.setId_srvtp(srvsplitorder.getId_srvtp());
		rtn.setSd_srvtp(srvsplitorder.getSd_srvtp());
		rtn.setId_route(srvsplitorder.getId_route());
		rtn.setId_routedes(srvsplitorder.getId_routedes());
		rtn.setId_boil(srvsplitorder.getId_boil());
		rtn.setId_boildes(srvsplitorder.getId_boildes());
		rtn.setId_freq(srvsplitorder.getId_freq());
		rtn.setId_frequnit(srvsplitorder.getId_frequnit());
		rtn.setSd_frequnit(srvsplitorder.getSd_frequnit());
		rtn.setFrequnitcnt(srvsplitorder.getFrequnitcnt());
		rtn.setFreqcnt(srvsplitorder.getFreqcnt());
		
		rtn.setDt_mp_plan(srvsplitorder.getDt_mp_plan());
		rtn.setQuan_mp_ap(srvsplitorder.getQuan_mp_ap());
		rtn.setId_pkgu_ap(srvsplitorder.getId_pkgu_ap());
		rtn.setQuan_bed_ap_medu(srvsplitorder.getQuan_bed_ap_medu());
		
		return rtn;
	}
}
