package iih.ci.ord.s.bp.base.relsrv;

import java.lang.reflect.InvocationTargetException;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.RelSrvTacticDO;
import iih.bd.srv.oth.d.BdRelSrvParamDTO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ems.d.UsageRelFeeSrvDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.function.CalQuan8ExternFunBP;
import iih.ci.ord.s.bp.exception.StrFactorDefException;
import iih.ci.ord.s.bp.exception.StrFactorDenoNullException;
import iih.ci.ord.s.bp.exception.StrFactorNullException;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/*
 * 获得医疗单关联服务数据信息操作BP
 * 通过关联服务策略因素项匹配获得对应关联服务列表数据信息 
 */
public class GetCiRelSrvInfo8RelSrvTacticBP {
	
	/**
	 * 获得医疗单关联服务数据信息
	 * 通过关联服务策略因素项匹配获得对应关联服务列表数据信息
	 * @param param
	 * @return
	 * @throws BizException
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public UsageRelFeeSrvDO[] exec(RelSrvTacticDO[] relsrvdos,BdRelSrvParamDTO param)  throws BizException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		//有效性校验 
		if(!isValidateCheck(relsrvdos))return null;
		
		//参数设置
		UsageRelFeeSrvDO[] rtn=new UsageRelFeeSrvDO[relsrvdos.length];
		
		//获得匹配的关联服务DO数据
		for(int i=0;i<relsrvdos.length;i++){
			if (IBdSrvDictCodeConst.SD_QUANCALMD_FIXV.equals(relsrvdos[i]
					.getSd_quancalmd())) {//固定
				rtn[i]=getRelFeeSrvDO(relsrvdos[i]);
			} else if (IBdSrvDictCodeConst.SD_QUANCALMD_RATIO
					.equals(relsrvdos[i].getSd_quancalmd())) {//比例
				rtn[i]=getRatioRelFeeSrvDO(relsrvdos[i], param,"关联服务策略比例法时，");
			} else if (IBdSrvDictCodeConst.SD_QUANCALMD_EXTERNALFUNC
					.equals(relsrvdos[i].getSd_quancalmd())) {//外挂
				rtn[i]=getExternFunRelFeeSrvDO(relsrvdos[i], param,"关联服务策略外挂函数法时，");
			} else {

			}
		}
		
		return rtn;
	}
	
	/**
	 * 有效性校验
	 * @param param
	 * @return
	 */
	private boolean isValidateCheck(RelSrvTacticDO[] relsrvdos){
		if(CiOrdUtils.isEmpty(relsrvdos)) return false;

		return true;
	}
	
	/**
	 * 创建关联服务数据信息
	 * （固定法）
	 * @param relsrvdo
	 * @return
	 */
	private UsageRelFeeSrvDO getRelFeeSrvDO(RelSrvTacticDO relsrvdo){
		UsageRelFeeSrvDO rtn=new UsageRelFeeSrvDO();
		rtn.setId_srv(relsrvdo.getId_srv());
		rtn.setId_unit(relsrvdo.getId_unit());
		rtn.setQuan_medu(relsrvdo.getQuan_medu());
		rtn.setReltype(OrSrvSourceFromEnum.RELSRVTACTIC);
		//rtn.setDef1(def1);
		if(!CiOrdUtils.isValidateTransData(rtn.getQuan_medu()))return null;
		return rtn;
	}
	
	/**
	 * 创建关联服务数据信息
	 * （比例法）
	 * @param relsrvdo
	 * @return
	 * @throws StrFactorDenoNullException 
	 * @throws StrFactorDefException 
	 * @throws StrFactorNullException 
	 */
	private UsageRelFeeSrvDO getRatioRelFeeSrvDO(RelSrvTacticDO relsrvdo,BdRelSrvParamDTO param,String appScene) throws StrFactorNullException, StrFactorDefException, StrFactorDenoNullException{
		UsageRelFeeSrvDO rtn=new UsageRelFeeSrvDO();
		rtn.setId_srv(relsrvdo.getId_srv());
		rtn.setId_unit(relsrvdo.getId_unit());
		rtn.setQuan_medu(getQuan8Factor(relsrvdo,param,appScene));
		rtn.setReltype(OrSrvSourceFromEnum.RELSRVTACTIC);
		//rtn.setDef1(def1);
		if(!CiOrdUtils.isValidateTransData(rtn.getQuan_medu()))return null;
		return rtn;
	}
	
	/**
	 * 创建关联服务数据信息
	 * （外挂函数）
	 * @param relsrvdo
	 * @param param
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws BizException 
	 */
	private UsageRelFeeSrvDO getExternFunRelFeeSrvDO(RelSrvTacticDO relsrvdo,BdRelSrvParamDTO param,String appScene) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, BizException{
		UsageRelFeeSrvDO rtn=new UsageRelFeeSrvDO();
		rtn.setId_srv(relsrvdo.getId_srv());
		rtn.setId_unit(relsrvdo.getId_unit());
		rtn.setQuan_medu(getQuan8ExternFun(relsrvdo,param,appScene));
		rtn.setReltype(OrSrvSourceFromEnum.RELSRVTACTIC);
		//rtn.setDef1(def1);
		if(!CiOrdUtils.isValidateTransData(rtn.getQuan_medu()))return null;
		return rtn;
	}
	
	/**
	 * 按比例系数获得关联服务用量值
	 * @param relsrvdo
	 * @param param
	 * @return
	 * @throws StrFactorDenoNullException 
	 * @throws StrFactorDefException 
	 * @throws StrFactorNullException 
	 */
	private FDouble getQuan8Factor(RelSrvTacticDO relsrvdo,BdRelSrvParamDTO param,String appScene) throws StrFactorNullException, StrFactorDefException, StrFactorDenoNullException{
		return CiOrdUtils.getQuan8Factor(param.getQuan_medu(),
				relsrvdo.getFactor(), relsrvdo.getPrecise(),
				relsrvdo.getSd_roundmd(),appScene);
	}
	
	/**
	 * 按外挂函数获得关联服务用量值
	 * @param relsrvdo
	 * @param param
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws BizException 
	 */
	private FDouble getQuan8ExternFun(RelSrvTacticDO relsrvdo,BdRelSrvParamDTO param,String appScene) throws BizException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		CalQuan8ExternFunBP bp=new CalQuan8ExternFunBP();
		return bp.exec(relsrvdo.getFullclassname_externfun(), relsrvdo.getParamv_externfun(), relsrvdo.getCnt_externfunparam(), appScene,new String[]{param.getQuan_medu().toString()});
	}
	
}
