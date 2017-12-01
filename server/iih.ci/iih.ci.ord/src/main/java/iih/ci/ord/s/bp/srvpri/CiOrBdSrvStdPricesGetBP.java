package iih.ci.ord.s.bp.srvpri;

import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.primd.i.IPriCalService;
import iih.ci.ord.pub.CiOrSrvPriHelper;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.exception.SrvPluginPrimdUnImplementException;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/**
 * 临床医嘱选择服务，服务价格计算操作BP
 */
public class CiOrBdSrvStdPricesGetBP {
	/**
	 * 临床医嘱选择服务，服务价格计算
	 * @param id_srv  医疗服务id
	 * @param id_primd 付款策略
	 * @param num      套时，的个数定价 或个数加收的个数数量
	 * @param srvsetitms      套合计价时，套内项目信息 BdSrvPriCalParamDTO
	 * @return
	 * @throws BizException
	 */
	public PriStdSrvDTO[] exec(BdSrvPriCalParamDTO param)  throws BizException{
		//有效性判断处理
		if(!validateCheck(param))return null;
		if(CiOrdUtils.isEmpty(param.getId_primd()))
		{
			param.setId_primd(CiOrdAppUtils.getMedsrvMDORService().findById(param.getId_srv()).getId_primd());
		}
		String id_primd=param.getId_primd(),id_srv=param.getId_srv();
		Integer num=param.getNum();
		
		IPriCalService ipricalsrv=CiOrdAppUtils.getPriCalService();
		if(CiOrSrvPriHelper.isSrvSelfPrimd(id_primd)){//本服务定价
			return getPriStdSrvDTOs(id_srv,ipricalsrv.CalSingleSrvStdPrice(id_srv),new FDouble(1));
		}else if(CiOrSrvPriHelper.isSrvsetMemberSumPrimd(id_primd)){//合计价
			//传入的主要参数应为 srvsetitms
			return getSrvSetSumPri(param);
		}else if(CiOrSrvPriHelper.isSrvsetMemCntAdditionalPrimd(id_primd)){//个数加收
			return comPriStdHandle(ipricalsrv.CalSrvSetMUPrices(id_srv, num),id_srv);
		}else if(CiOrSrvPriHelper.isSrvsetMemberCntPrimd(id_primd)){//个数定价
			return comPriStdHandle(ipricalsrv.CalSrvSetFIXPrices(id_srv, num),id_srv);
		}else if(CiOrSrvPriHelper.isSrvRelMmPrimd(id_primd)){//对应物品价格
			//return getPriceSum(ipricalsrv.CalSrvSetFIXPrices(id_srv, num));
			//调用对应药品价格计算接口
		}else if(CiOrSrvPriHelper.isSrvCompPrimd(id_primd)){//组合定价
			return comPriStdHandle(ipricalsrv.CalSrvCompPrice(id_srv),id_srv);
		}else if(CiOrSrvPriHelper.isSrvFreePrimd(id_primd)){//不收费
			return getPriStdSrvDTOs(id_srv,new FDouble(0),new FDouble(1));
		}else if(CiOrSrvPriHelper.isSrvPluginPrimd(id_primd)){//外挂插件
			throw new SrvPluginPrimdUnImplementException();
		}
		
		return null;
		
	}
	
	/**
	 * 创建服务标准价
	 * @param id_srv
	 * @param pri
	 * @return
	 */
	private PriStdSrvDTO[] getPriStdSrvDTOs(String id_srv,FDouble pri,FDouble quan){
		PriStdSrvDTO rtn=new PriStdSrvDTO();
		rtn.setId_srv(id_srv);
		rtn.setQuan(quan);
		rtn.setPrice(pri);
		rtn.setName_srv(id_srv);
		return new PriStdSrvDTO[]{rtn};
	}
	
	/**
	 * 有效性校验
	 * @param id_srv
	 * @param id_primd
	 * @return
	 */
	private boolean validateCheck(BdSrvPriCalParamDTO param){
		if(CiOrdUtils.isEmpty(param))return false;
		if(CiOrdUtils.isEmpty(param.getId_srv()) || 
		   CiOrdUtils.isEmpty(param.getId_primd()))return false;
		return true;
	}
	

	/**
	 * 获得套合计价模式总价
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private PriStdSrvDTO[] getSrvSetSumPri(BdSrvPriCalParamDTO param) throws BizException{
		CiOrSrvSetStdPriMdGetBP bp=new CiOrSrvSetStdPriMdGetBP();
		return bp.exec(param);
	}
	
	/**
	 * 组合定价时   返回的标准服务 价   中标记所属的组合服务
	 * @param stdpris
	 * @param id_srv_com
	 * @return
	 */
	private PriStdSrvDTO[] comPriStdHandle(PriStdSrvDTO[] stdpris,String id_srv_com){
		if(CiOrdUtils.isEmpty(stdpris))return null;
		for(int i=0;i<stdpris.length;i++){
			stdpris[i].setName_srv(id_srv_com); //借用  name字段  表示  该费用项所属 服务
		}
		return stdpris;
	}
}
