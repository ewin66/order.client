package iih.ci.ord.s.ems.biz.utils.orcontent.dto;

import java.util.List;

import iih.ci.ord.ciordems.d.EmsOrDrug;
import xap.mw.core.data.FArrayList;

/**
 * 用于西成药医嘱内容拼接的DTO
 * @author zwq
 *
 */
public class DrugOrContentParam extends BaseOrContentParam{

	private static final long serialVersionUID = 1L;
	public DrugOrContentParam(String sd_srvtp,String name_freq,Integer use_days,String name_route,String note_or,List<OrContentDTO> drugs){
		super( sd_srvtp, note_or, drugs);
		boolean[] fg_selfs = new boolean[drugs.size()];
		for(int i=0;i<drugs.size();i++){
			OrContentDTO drug = drugs.get(i);
			fg_selfs[i] = drug.isFg_self();
		}
		this.setName_freq(name_freq);
		this.setName_route(name_route);
		this.setFg_selfs(fg_selfs);
		this.setUse_days(use_days);
	}
	/**
	 * 用法
	 * @return
	 */
	private String Name_route;
	/**
	 * 频次
	 * @return
	 */
	private String Name_freq;
	/**
	 * 自备药标识
	 * @return
	 */
	private boolean[] Fg_selfs;
	public String getName_route() {
		return Name_route;
	}
	public void setName_route(String name_route) {
		Name_route = name_route;
	}
	public String getName_freq() {
		return Name_freq;
	}
	public void setName_freq(String name_freq) {
		Name_freq = name_freq;
	}
	public boolean[] getFg_selfs() {
		return Fg_selfs;
	}
	public void setFg_selfs(boolean[] fg_selfs) {
		Fg_selfs = fg_selfs;
	}
	
}
