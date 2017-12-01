package iih.ci.ord.s.bp.ems;

import java.util.ArrayList;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.pub.CiOrdUtils;

/**
 * 
 */
public class EmsHelper {
	/**
	 * 根据来源方式及来源服务ID获得派生的医疗单项目是否已经生成判断
	 * @param ems
	 * @param id_srv_src
	 * @param eu_sourcemd
	 * @param priby 专为套个数计价与加收用
	 * @return
	 * @throws BizException 
	 */
	public static boolean isEmsSrvsGenerated(CiEmsDTO ems,String id_srv_src,Integer[] eu_sourcemds,String priby) throws BizException{
		GetAgentEmsSrvs8EuSrcMdIDBP bp=new GetAgentEmsSrvs8EuSrcMdIDBP();
		ArrayList<CiEmsSrvDTO> list=bp.exec(ems, id_srv_src, eu_sourcemds,priby);
		if(CiOrdUtils.isEmpty(list))return  false;
		return true;
	}
	/**
	 * 判断套内的非临床项目前台是否已经生成
	 * @param orsrvdos
	 * @param id_srv_src  组合或套
	 * @param id_srv      组合或套内  的项目
	 * @return
	 */
	public static FBoolean isEmsSrvsGenerated(FArrayList emssrvs,String id_srv_set,String id_srv){
		//有效性校验
		if(CiOrdUtils.isEmpty(emssrvs) || CiOrdUtils.isEmpty(id_srv_set) || CiOrdUtils.isEmpty(id_srv))return null;
		//遍历
		for(int i=0;i<emssrvs.size();i++){
			if(((CiEmsSrvDTO)emssrvs.get(i)).getStatus()!=DOStatus.DELETED&&id_srv_set.equals(((CiEmsSrvDTO)emssrvs.get(i)).getId_srv_src()) && id_srv.equals(((CiEmsSrvDTO)emssrvs.get(i)).getId_srv())){
				return FBoolean.TRUE;
			}
		}
		
		return FBoolean.FALSE;
	}
}
