package iih.ci.ord.s.bp.orsrvsplit;

import iih.ci.ord.dto.blexorder.d.OrSplitOrderDTO;
import xap.mw.core.data.BizException;

/***
 * 医嘱拆分后的拆分医嘱克隆操作BP
 */
public class OrSplitOrderCloneBP {
	/***
	 * 医嘱拆分后的拆分医嘱克隆操作
	 * @param orsplitorder
	 * @return
	 * @throws BizException
	 */
	public OrSplitOrderDTO exec(OrSplitOrderDTO orsplitorder)  throws BizException{
		
		//ly修改
		return (OrSplitOrderDTO)orsplitorder.clone();
		
		//return clone(orsplitorder);
	}
	
	/***
	 * 客隆算法
	 * @param orsplitorder
	 * @return
	 */
	private OrSplitOrderDTO clone(OrSplitOrderDTO orsplitorder){
		OrSplitOrderDTO rtn=new OrSplitOrderDTO();
		rtn.setId_or(orsplitorder.getId_or());
		rtn.setId_grp(orsplitorder.getId_grp());
		rtn.setId_org(orsplitorder.getId_org());
		rtn.setId_pat(orsplitorder.getId_pat());
		rtn.setId_entp(orsplitorder.getId_entp());
		rtn.setCode_entp(orsplitorder.getCode_entp());
		rtn.setId_en(orsplitorder.getId_en());
		rtn.setFg_bb(orsplitorder.getFg_bb());
		rtn.setNo_bb(orsplitorder.getNo_bb());
		rtn.setName_or(orsplitorder.getName_or());
		rtn.setContent_or(orsplitorder.getContent_or());
		rtn.setId_su_or(orsplitorder.getId_su_or());
		rtn.setSd_su_or(orsplitorder.getSd_su_or());
		rtn.setDt_effe(orsplitorder.getDt_effe());
		rtn.setDt_end(orsplitorder.getDt_end());
		rtn.setDt_invalid(orsplitorder.getDt_invalid());
		rtn.setFg_long(orsplitorder.getFg_long());
		rtn.setFg_boil(orsplitorder.getFg_boil());
		rtn.setQuan_or(orsplitorder.getQuan_or());
		rtn.setOrders_boil(orsplitorder.getOrders_boil());
		rtn.setFg_skintest(orsplitorder.getFg_skintest());
		rtn.setFg_mp_bed(orsplitorder.getFg_mp_bed());
		rtn.setDt_stop(orsplitorder.getDt_stop());
		
		rtn.setDt_create(orsplitorder.getDt_create());
		rtn.setId_org_create(orsplitorder.getId_org_create());
		rtn.setId_dep_create(orsplitorder.getId_dep_create());
		rtn.setId_emp_create(orsplitorder.getId_emp_create());
		rtn.setId_srvtp(orsplitorder.getId_srvtp());
		rtn.setSd_srvtp(orsplitorder.getSd_srvtp());
		rtn.setId_route(orsplitorder.getId_route());
		rtn.setId_routedes(orsplitorder.getId_routedes());
		rtn.setId_boil(orsplitorder.getId_boil());
		rtn.setId_boildes(orsplitorder.getId_boildes());
		rtn.setId_freq(orsplitorder.getId_freq());
		rtn.setId_frequnit(orsplitorder.getId_frequnit());
		rtn.setSd_frequnit(orsplitorder.getSd_frequnit());
		rtn.setFrequnitcnt(orsplitorder.getFrequnitcnt());
		rtn.setFreqcnt(orsplitorder.getFreqcnt());
		rtn.setDt_mp_plan(orsplitorder.getDt_mp_plan());
		
		return rtn;
	}
}
