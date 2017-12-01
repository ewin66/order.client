package iih.ci.ord.s.ems.biz.utils.orcontent.dto;

import java.util.List;

import iih.ci.ord.ciordems.d.EmsObsLap;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 检验医嘱内容拼接的DTO
 * @author zwq
 *
 */
public class OprOrContentParam extends BaseOrContentParam{

	private static final long serialVersionUID = 1L;
	public OprOrContentParam(String sd_srvtp,FDateTime dt_begin,String name_routedes,String note,List<OrContentDTO> list){
		this.setSd_srvtp(sd_srvtp);
		this.setDt_begin(dt_begin);
		this.setName_routedes(name_routedes);
		this.setNote(note);
		String[] name_srvs = new String[list.size()];
		for(int i=0;i<list.size();i++){
			OrContentDTO opr = list.get(i);
			name_srvs[i] = opr.getName_srv();
		}
		this.setName_srvs(name_srvs);
	}
	/**
	 * 用法
	 * @return
	 */
	private String Name_routedes;

	/**
	 * 开始日期
	 * @return
	 */
	private FDateTime Dt_begin;
	public String getName_routedes() {
		return Name_routedes;
	}

	public void setName_routedes(String name_routedes) {
		Name_routedes = name_routedes;
	}

	public FDateTime getDt_begin() {
		return Dt_begin;
	}

	public void setDt_begin(FDateTime dt_begin) {
		Dt_begin = dt_begin;
	}
	

	
}
