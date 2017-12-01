package iih.ci.ord.s.ems.biz.op.calcpri;

import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.s.ems.biz.itf.ICalcPriModeProxy;
import xap.mw.core.data.BizException;

/**
 * 费用接口代理基类
 * @author wangqingzhu
 *
 */
public class BaseCalcPriModeProxy implements ICalcPriModeProxy {

	protected String name;
	protected String id_srv;
	protected int num;

	public BaseCalcPriModeProxy(String id_srv,String name, int num){
		this.id_srv = id_srv;
		this.num = num;
		this.name = name;
	}
	
	@Override
	public PriStdSrvDTO[] Calc() throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toDesction() {
		// TODO Auto-generated method stub
		return "未定义描述";
	}

	@Override
	public int getEuSource() {
		// TODO Auto-generated method stub
		return OrSrvSourceFromEnum.PHYSIAN;
	}

}
