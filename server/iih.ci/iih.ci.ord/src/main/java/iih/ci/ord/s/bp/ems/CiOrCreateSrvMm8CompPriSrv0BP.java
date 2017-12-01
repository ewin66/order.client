package iih.ci.ord.s.bp.ems;

import java.util.ArrayList;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.exception.CiOrSrvCompPriMdRelPriSrvNullException;
import iih.ci.ord.s.bp.srvpri.CiOrSrvPriCalUtils;

/**
 * 获得组合定价模式医嘱项目对应的费用医嘱项目集合数据信息操作BP
 */
public class CiOrCreateSrvMm8CompPriSrv0BP {
	/**
	 * 获得组合定价模式医嘱项目对应的费用医嘱项目集合数据信息
	 * @param aggdo
	 * @param ems
	 * @param ipos
	 * @return
	 * @throws BizException
	 */
	public  ArrayList<OrdSrvDO> exec(CiorderAggDO aggdo,CiEmsDTO ems,Integer ipos)  throws BizException{
		 long startTime = System.currentTimeMillis();
		//有效性校验
		if(!validate(aggdo,ems,ipos))return null;
		
		//获得医疗单项目对应的组合价对应的服务集合

		PriStdSrvDTO[] pristdsrvdtos=getCompSrvPriStdSrv(ems,ipos);
		if(CiOrdUtils.isEmpty(pristdsrvdtos))throw new CiOrSrvCompPriMdRelPriSrvNullException();
		
		//参数设置
		ArrayList<OrdSrvDO> rtnList=new ArrayList<OrdSrvDO>(); 

		MedSrvDO[] medsrvdos=CiOrdUtils.getMedSrvInfoDOs(pristdsrvdtos);
		
		OrdSrvDO ordsrvdo=null;
		//FDouble quan=new FDouble(1);//((CiEmsSrvDTO)(ems.getEmssrvs().get(ipos))).getQuan_cur(); quan_cur仅用于物品  组合相关应该不是物品 2016-06-29修改
		FDouble quan = ((CiEmsSrvDTO)(ems.getEmssrvs().get(ipos))).getQuan_med();//2016-11-10修改
		if(CiOrdUtils.isEmpty(quan)){
			quan = new FDouble(1);
		}
		long startfor = System.currentTimeMillis();
		//遍历
		for(int i=0;i<pristdsrvdtos.length;i++){
			ordsrvdo=getSrvMm8CompPriSrv(aggdo,ems,ipos,pristdsrvdtos[i],medsrvdos[i],quan);
			if(CiOrdUtils.isEmpty(ordsrvdo))continue;
			rtnList.add(ordsrvdo);
		}
		
		CiOrdUtils.getlogger().info("获得组合定价模式医嘱项目对应的费用医嘱项目集合数据信息  循环  耗时"+(System.currentTimeMillis() -startfor));
		return rtnList;
	}
	
	/**
	 * 有效性校验
	 * @param aggdo
	 * @param ems
	 * @param ipos
	 * @return
	 */
	private boolean validate(CiorderAggDO aggdo,CiEmsDTO ems,Integer ipos){
		if(CiOrdUtils.isEmpty(aggdo) || CiOrdUtils.isEmpty(ems))return false;
		if(CiOrdUtils.isEmpty(ems.getEmssrvs()))return false;
		int iL=ems.getEmssrvs().size();
		if(ipos>=iL)return false;
			
		return  true;
	}
	
	/**
	 * 根据定价模式返回的价格服务生成医嘱项目（仅对组合定价模式的情形）
	 * 不包含套及套内项目情形
	 * @param aggdo
	 * @param ems
	 * @param ipos
	 * @param prisrv
	 * @param quan
	 * @return
	 * @throws BizException
	 */
	private OrdSrvDO getSrvMm8CompPriSrv(CiorderAggDO aggdo,CiEmsDTO ems,Integer ipos,PriStdSrvDTO prisrv,MedSrvDO prisrvdo,FDouble quan) throws BizException{
		CiOrCreateSrvMm8CompPriSrvNBP bp=new CiOrCreateSrvMm8CompPriSrvNBP();
		return bp.exec(aggdo, ems, ipos, prisrv,prisrvdo, quan);
	}
	
	/**
	 * 获得医疗单项目对应的组合价对应的服务集合
	 * @param ems
	 * @param ipos
	 * @return
	 * @throws BizException
	 */
	private PriStdSrvDTO[] getCompSrvPriStdSrv(CiEmsDTO ems,Integer ipos) throws BizException{
		String id_srv=CiOrdUtils.getEmsItemIdSrv(ems, ipos);
		return CiOrSrvPriCalUtils.CalSrvCompPrice(id_srv);
	}

}
