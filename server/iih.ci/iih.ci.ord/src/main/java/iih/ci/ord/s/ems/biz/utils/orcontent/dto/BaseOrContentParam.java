package iih.ci.ord.s.ems.biz.utils.orcontent.dto;

import java.util.List;

import iih.ci.ord.ciordems.d.EmsOrDrug;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDouble;

/**
 * 医嘱内容拼接的参数类
 * @author zwq
 *
 */
public class BaseOrContentParam{
	public BaseOrContentParam(){}
	public BaseOrContentParam(String sd_srvtp,String note_or,List<OrContentDTO> drugs){
		this.setSd_srvtp(sd_srvtp);
		this.setNote(note_or);
		String[] name_srvs = new String[drugs.size()];
		FDouble[] quan_meds = new FDouble[drugs.size()];
		String[] name_unit_meds = new String[drugs.size()];
		for(int i=0;i<drugs.size();i++){
			OrContentDTO drug = drugs.get(i);
			name_srvs[i] = drug.getName_srv();
			quan_meds[i] = drug.getQuan_med();
			name_unit_meds[i] = drug.getName_unit_med();
		}
		this.setName_srvs(name_srvs);
		this.setQuan_meds(quan_meds);
		this.setName_unit_meds(name_unit_meds);
	}
	/**
	 * 服务类型
	 * @return
	 */
	private String Sd_srvtp;
	/**
	 * 备注
	 * @return
	 */
	private String Note;
	/**
	 * 服务名称
	 * @return
	 */
	private String[] Name_srvs;
	/**
	 * 剂量
	 * @return
	 */
	private FDouble[] Quan_meds;
	/**
	 * 剂量单位
	 * @return
	 */
	private String[] Name_unit_meds;
	/**
	 * 使用天数
	 * @return
	 */
	private Integer Use_days;
	public String getSd_srvtp() {
		return Sd_srvtp;
	}
	public void setSd_srvtp(String sd_srvtp) {
		Sd_srvtp = sd_srvtp;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	public String[] getName_srvs() {
		return Name_srvs;
	}
	public void setName_srvs(String[] name_srvs) {
		Name_srvs = name_srvs;
	}
	public FDouble[] getQuan_meds() {
		return Quan_meds;
	}
	public void setQuan_meds(FDouble[] quan_meds) {
		Quan_meds = quan_meds;
	}
	public String[] getName_unit_meds() {
		return Name_unit_meds;
	}
	public void setName_unit_meds(String[] name_unit_meds) {
		Name_unit_meds = name_unit_meds;
	}
	public Integer getUse_days() {
		return Use_days;
	}
	public void setUse_days(Integer use_days) {
		Use_days = use_days;
	}
	
}
