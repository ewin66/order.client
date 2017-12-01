package iih.ci.ord.s.ems.biz.utils.orcontent.dto;

import java.util.List;

import iih.ci.ord.ciordems.d.EmsObsLap;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 检验医嘱内容拼接的DTO
 * @author zwq
 *
 */
public class LisOrContentParam extends BaseOrContentParam{

	private static final long serialVersionUID = 1L;
	public LisOrContentParam(String sd_srvtp,FBoolean fg_urgent,String name_samptp,String note,List<OrContentDTO> list){
		this.setSd_srvtp(sd_srvtp);
		this.setFg_urgent(fg_urgent);
		this.setName_samptp(name_samptp);
		this.setNote(note);
		String[] name_srvs = new String[list.size()];
		for(int i=0;i<list.size();i++){
			OrContentDTO obslap = list.get(i);
			name_srvs[i] = obslap.getName_srv();
		}
		this.setName_srvs(name_srvs);
	}
	/**
	 * 加急标识
	 * @return
	 */
	private FBoolean Fg_urgent;

	/**
	 * 标本sd
	 * @return
	 */
	private String Sd_samptp;
	
	/**
	 * 标本名称
	 * @return
	 */
	private String Name_samptp;
	public FBoolean getFg_urgent() {
		return Fg_urgent;
	}

	public void setFg_urgent(FBoolean fg_urgent) {
		Fg_urgent = fg_urgent;
	}

	public String getSd_samptp() {
		return Sd_samptp;
	}

	public void setSd_samptp(String sd_samptp) {
		Sd_samptp = sd_samptp;
	}

	public String getName_samptp() {
		return Name_samptp;
	}

	public void setName_samptp(String name_samptp) {
		Name_samptp = name_samptp;
	}

	
}
