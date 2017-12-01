package iih.ci.ord.s.ems.biz.op.tmpl.meta;

import java.util.ArrayList;
import java.util.Collection;

import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;

/**
 * 模板驱动分组表 （同类型医疗单）
 * @author wangqingzhu
 *
 */
public class OrderTmplGroupList extends ArrayList<OrderTmplDetailList>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SrvMatchEmsRstDTO srvMatchEmsRstInfo;

	public OrderTmplGroupList(){}
	public OrderTmplGroupList(Collection<OrderTmplDetailList> c) {
		this.addAll(c);
	}
	
	public SrvMatchEmsRstDTO getSrvMatchEmsRstInfo() {
		return srvMatchEmsRstInfo;
	}

	public void setSrvMatchEmsRstInfo(SrvMatchEmsRstDTO srvMatchEmsRstInfo) {
		this.srvMatchEmsRstInfo = srvMatchEmsRstInfo;
	}
	@Override
	public boolean add(OrderTmplDetailList e) {
		// TODO Auto-generated method stub
		if(null != getSrvMatchEmsRstInfo()){
			e.setId_ems(getSrvMatchEmsRstInfo().getId_ems());
			e.setFuncDriver(getSrvMatchEmsRstInfo().getFuncclassstr());
			e.setFg_quickwFlow(getSrvMatchEmsRstInfo().getFg_quickwflow());
		}
		return super.add(e);
	}
	@Override
	public void add(int index, OrderTmplDetailList e) {
		// TODO Auto-generated method stub
		if(null != getSrvMatchEmsRstInfo()){
			e.setId_ems(getSrvMatchEmsRstInfo().getId_ems());
			e.setFuncDriver(getSrvMatchEmsRstInfo().getFuncclassstr());
			e.setFg_quickwFlow(getSrvMatchEmsRstInfo().getFg_quickwflow());
		}
		super.add(index, e);
	}
	@Override
	public boolean addAll(Collection<? extends OrderTmplDetailList> c) {
		// TODO Auto-generated method stub
		if(null != getSrvMatchEmsRstInfo()){
			for (OrderTmplDetailList e:c){
				e.setId_ems(getSrvMatchEmsRstInfo().getId_ems());
				e.setFuncDriver(getSrvMatchEmsRstInfo().getFuncclassstr());
				e.setFg_quickwFlow(getSrvMatchEmsRstInfo().getFg_quickwflow());
			}
		}
		return super.addAll(c);
	}
	@Override
	public boolean addAll(int index, Collection<? extends OrderTmplDetailList> c) {
		if(null != getSrvMatchEmsRstInfo()){
			for (OrderTmplDetailList e:c){
				e.setId_ems(getSrvMatchEmsRstInfo().getId_ems());
				e.setFuncDriver(getSrvMatchEmsRstInfo().getFuncclassstr());
				e.setFg_quickwFlow(getSrvMatchEmsRstInfo().getFg_quickwflow());
			}
		}
		return super.addAll(index, c);
	}
	
	
	
}
