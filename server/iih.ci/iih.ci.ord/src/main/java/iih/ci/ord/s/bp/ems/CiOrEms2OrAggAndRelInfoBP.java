package iih.ci.ord.s.bp.ems;

import java.util.Hashtable;

import org.apache.commons.lang.StringUtils;

import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/**
 * 由医疗单信息获得临床医嘱及相关附加信息操作BP
 */
public class CiOrEms2OrAggAndRelInfoBP {
	private boolean isAdd=true;   //是否新建医嘱
	/**
	 * 由医疗单信息获得临床医嘱及相关附加信息
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public  CiOrAggAndRelDatum exec(CiEmsDTO ems)  throws BizException{
		//有效性判断
		if(!isValidate(ems))return null;
		
		//参数设置
		CiOrAggAndRelDatum datum=new CiOrAggAndRelDatum();
		// 设置入径标志
		datum.setFg_cp(ems.getFg_cp());
		//根据id_ord获得医嘱聚集DO实体数据
		CiorderAggDO aggorder=getCiorderAggDO(ems.getId_or());
		datum.setOraggdo(aggorder);
		
		//医嘱数据处理
		Hashtable ht=aggCiOrderHandle(aggorder,ems);
		if(ht!=null && ht.size()!=0){datum.setOrattachht(ht);}
		
		return datum;
	}
	
	/**
	 * 有效性判断
	 * @param ems
	 * @return
	 */
	private boolean isValidate(CiEmsDTO ems){
		if(ems==null)return false;
		
		return true;
	}
	
	/**
	 * 根据pk_ord获得医嘱聚集VO实体数据
	 * @param pk_ord
	 * @return
	 * @throws BusinessException 
	 */
	private CiorderAggDO getCiorderAggDO(String id_or) throws BizException{
		if(StringUtils.isBlank(id_or))
		{
			return  new CiorderAggDO();
		}
		isAdd=false;
		CiorderAggDO agg = CiOrdAppUtils.getOrAggQryService().findById(id_or);
//		if(!CiOrdUtils.isEmpty(agg)&&!CiOrdUtils.isEmpty(agg.getOrdSrvDO())){
//			for(OrdSrvDO srv : agg.getOrdSrvDO()){
//				srv.setEu_hpdoctorjudge(this.orSrvEuHpToEmsSrvEuHp(srv.getFg_hpindicjudged()));
//			}
//		}
		return agg;
	}
	
	/**
	 * 医嘱数据处理
	 * @param aggorder
	 * @param emsheadvo
	 * @throws BusinessException 
	 */
	private Hashtable aggCiOrderHandle(CiorderAggDO aggorder,CiEmsDTO ems) throws BizException{
		if(isAdd){//新增医嘱处理逻辑
			return aggCiOrderNewHandle(aggorder,ems);
		}else{//医嘱信息修改处理逻辑
			return aggCiOrderModHandle(aggorder,ems);
		}
	}
	
	/**
	 * 新增医嘱数据处理
	 * @param aggorder
	 * @param ems
	 * @throws BizException
	 */
	private Hashtable aggCiOrderNewHandle(CiorderAggDO aggorder,CiEmsDTO ems) throws BizException{
		//生成并设置主对象
		CiOrEms2NewOrAggBP bp=new CiOrEms2NewOrAggBP();
		return bp.exec(aggorder, ems);
	}
	

	
	/**
	 * 修改医嘱数据处理
	 * @param aggOrder
	 * @param emsheadvo
	 * @throws BusinessException 
	 */
	private Hashtable aggCiOrderModHandle(CiorderAggDO aggorder,CiEmsDTO ems) throws BizException{
		CiOrEms2ModOrAggBP bp=new CiOrEms2ModOrAggBP();
		return bp.exec(aggorder, ems);
	}
	private Integer orSrvEuHpToEmsSrvEuHp(Integer orsrvEuHp){
		if(orsrvEuHp==null||orsrvEuHp==HpIndicJudgeEnum.NONEEDJUDGE||orsrvEuHp==HpIndicJudgeEnum.JUDGED){
			return 1;//医生已判断
		}else{
			return 0;//医生未判断
		}
	}
}
