package iih.ci.ord.s.bp.ems_v1;

import java.util.List;

import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;

public class EmsBaseItemBP implements IEmsItemBP {
	/**
	 * 患者就诊信息上下文
	 */
	private CiEnContextDTO ciEnContext = null;
	/**
	 * 纯费用列表
	 */
	private List<CiEmsSrvDTO> feeSrvList = null;
	
	
	
	public EmsBaseItemBP(CiEnContextDTO ctx){
		ciEnContext = ctx;
	}
	
	public CiEnContextDTO getCiEnContext() {
		return ciEnContext;
	}

	public void setCiEnContext(CiEnContextDTO ciEnContext) {
		this.ciEnContext = ciEnContext;
	}
	
	public List<CiEmsSrvDTO> getFeeSrvList() {
		return feeSrvList;
	}

	public void setFeeSrvList(List<CiEmsSrvDTO> feeSrvList) {
		this.feeSrvList = feeSrvList;
	}

	public  FMap2 getViewModel(String id_srv,String id_mm) throws BizException{
		return null;
	}

	public  FMap2 getViewModel(CiOrderDO ord) throws BizException{
		return null;
	}
	
	public  CiOrderDO save(EmsDrugItemDO vm) throws BizException{
		return null;
	}

	@Override
	public boolean load(String id_or) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean load(CiOrderDO o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean load(OrTplNItmDO tmpl) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Object append(String id_srv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object append(String id_srv, String id_mm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object remove(String id_srv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEmsItemBP copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<?> getServiceList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getMasterService() {
		// TODO Auto-generated method stub
		return null;
	}
}
