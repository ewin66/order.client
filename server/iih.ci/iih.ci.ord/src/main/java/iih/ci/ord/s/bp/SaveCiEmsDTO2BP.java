package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.Hashtable;

import iih.ci.ord.cior.d.ValidateRtnInfoDTO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.common.CiOrParamUtils;
import iih.ci.ord.s.bp.ems.CiOrAggAndRelDatum;
import iih.ci.ord.s.bp.ems.CiOrAttachInfoUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
/**
 * 保存提示信息返回
 * @author li_zheng
 *
 */
public class SaveCiEmsDTO2BP {

	
public ValidateRtnInfoDTO SaveCiEmsDTO2(CiorderAggDO oragginfo,CiEnContextDTO CiEnContext) throws BizException{
		
	
	/*//获得皮试医嘱及其相关实体数据信息
	ArrayList<CiOrAggAndRelDatum> skintestagginfos=null;
//	if(isKinTest(ems)){skintestagginfos=getSkinTestOrInfos(ems,oragginfo);}
//	else{delskintests=getOrRelSkinTestOrAggs(oragginfo.getOraggdo());}
	skintestagginfos=getSkinTestOrInfos(oragginfo);  //将替换上述两行代码

	//聚集医嘱VO实体数据保存
	CiorderAggDO[] aggors=null;
	//如果存在医保，设置医保id_hp
	CiOrdUtils.setIdHpValue(oragginfo,skintestagginfos);
	//aggors=saveAggDO(oragginfo,skintestagginfos,delskintests,ems.getEmstype());
	aggors=saveAggDON(oragginfo,skintestagginfos,null,ems.getEmstype());  //将替换上述一行代码
	
	ValidateRtnInfoDTO dto=new ValidateRtnInfoDTO();
	FMap2 orderAggMap2 = new FMap2();

	if(aggors != null){
		orderAggMap2.put("aggors", CiOrdUtils.array2FArrayList(aggors));
		dto.setScenedatum(orderAggMap2);
		return dto;
	}else{
		orderAggMap2.put("aggors", CiOrdUtils.array2FArrayList(new CiorderAggDO[]{ new CiorderAggDO()}));
		dto.setScenedatum(orderAggMap2); ;
		return dto;
	}*/
	 return null;	
 }

/**
 * 获得皮试医嘱及相关附加数据信息
 * @param ems
 * @param oragginfo
 * @return
 * @throws BizException
 *//*
private ArrayList<CiOrAggAndRelDatum> getSkinTestOrInfos(CiOrAggAndRelDatum oragginfo) throws BizException{
	//新增皮试自动生成启动参数逻辑控制  2016-11-25 
	if(!CiOrParamUtils.IsAutoGenSkinTestOrEnable(CiOrParamUtils.getOrgID(oragginfo)))return null;
	
	//有效性判断
	skinorkeys=new ArrayList<String>();
	if(CiOrdUtils.isEmpty(oragginfo))return null;
	
	//获得医嘱关联皮试医嘱数据信息
	Hashtable ht=oragginfo.getOrattachht();
	if(CiOrdUtils.isEmpty(ht))return null;
	FMap map=CiOrAttachInfoUtils.getRelSkinOrDOMap(ht);
	
	//参数定义
	ArrayList<CiOrAggAndRelDatum> list=new ArrayList<CiOrAggAndRelDatum>();
	CiOrAggAndRelDatum reldatum;
	
	if(map!=null)
	{
		//遍历
		for(String key: map.keySet()){
			reldatum=(CiOrAggAndRelDatum)map.get(key);
			if(CiOrdUtils.isEmpty(reldatum))continue;
			list.add(reldatum);
			skinorkeys.add(key);
		}
	}
	//返回值处理
	if(list!=null && list.size()!=0)return list;
	return null;
}*/

}
