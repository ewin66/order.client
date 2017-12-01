package iih.ci.ord.s.ems.biz.op.tmpl.meta;

import java.util.ArrayList;

import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.ci.ord.s.ems.define.StringList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 模板明细列表
 * @author wangqingzhu
 *
 */
public class OrderTmplDetailList extends ArrayList<OrTplNItmDO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医疗单id
	 */
	private String id_ems;
	
	/**
	 * 医疗单驱动
	 */
	private String funcDriver;
	
	private FBoolean fg_quickwFlow;

	public String getId_ems() {
		return id_ems;
	}

	public void setId_ems(String id_ems) {
		this.id_ems = id_ems;
	}

	public String getFuncDriver() {
		return funcDriver;
	}

	public void setFuncDriver(String funcDriver) {
		this.funcDriver = funcDriver;
	}

	public FBoolean getFg_quickwFlow() {
		return fg_quickwFlow;
	}

	public void setFg_quickwFlow(FBoolean fg_quickwFlow) {
		this.fg_quickwFlow = fg_quickwFlow;
	}
	
	public String[] asSrvNameArray(){
		StringList ls = new StringList();
		for (OrTplNItmDO o : this){
			ls.add(o.getOrtplnitm_srv_name());
		}
		return ls.asArray();
	}
	
}
