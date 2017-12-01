package iih.ci.ord.s.bp.ordpres;

import iih.ci.ord.dto.ordpres.d.OrdPresDTO;
import iih.ci.ord.dto.ordpres.d.PresDrugDTO;
import iih.ci.ord.dto.ordpres.d.PresPrintParamDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获得医嘱处方信息操作BP（处方打印后台组织数据用）
 */
public class GetOrdPresInfo4PrintBP {
	/**
	 * 获得患者就诊医嘱处方信息
	 * @param id_en 就诊Id
	 * @param ids_orpres  重打或补打处方时处方Id数组
	 * @return
	 * @throws BizException
	 */
	public OrdPresDTO[] exec(PresPrintParamDTO param) throws BizException{
		if(!validateCheck(param))return null;
		String id_en=param.getId_en();
		String ids_orpres=param.getId_preses();
		
		//处方查询条件
		GetOrdPresInfoQry qry = new GetOrdPresInfoQry(id_en,ids_orpres);
		
		//获得处方信息
		OrdPresDTO[] ordpreses = (OrdPresDTO[])AppFwUtil.getDORstWithDao(qry, OrdPresDTO.class);
		if(CiOrdUtils.isEmpty(ordpreses))return null;
		
		//获得处方明细信息
		GetOrdPresItemsInfoQry itmsqry=new GetOrdPresItemsInfoQry();
		for(int i=0;i<ordpreses.length;i++){//遍历
			//设置医嘱处方对应的处方明细信息
			setOrdPresItmsInfo(ordpreses[i],itmsqry,param);
		}
		
		return ordpreses;	
	}
	
	/**
	 * 有效性校验
	 * @param param
	 * @return
	 */
	private boolean validateCheck(PresPrintParamDTO param){
		//有效性校验		
		if(CiOrdUtils.isEmpty(param))return false;
		if(CiOrdUtils.isEmpty(param.getId_en()) && CiOrdUtils.isEmpty(param.getId_preses()))return false;
		
		return true;
	}
	
	/**
	 * 设置医嘱处方对应的处方明细信息
	 * @param orpresdto
	 * @param itmsqry
	 * @throws BizException
	 */
	private void setOrdPresItmsInfo(OrdPresDTO orpresdto,GetOrdPresItemsInfoQry itmsqry,PresPrintParamDTO param) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(orpresdto) || CiOrdUtils.isEmpty(itmsqry))return;
		
		//设置查询参数
		itmsqry.setQryParameter(orpresdto.getId_pres());
		
		//获得处方明细信息
		PresDrugDTO[] presdrugs=(PresDrugDTO[])AppFwUtil.getDORstWithDao(itmsqry, PresDrugDTO.class);
		if(CiOrdUtils.isEmpty(presdrugs))return;
		
		//设置处方对应的明细信息
		orpresdto.setPresdrugs(CiOrdUtils.array2FArrayList(presdrugs));
		
		//处方数据加工处理
		ordPresDatumHandle(orpresdto,param);
	}
	
	/**
	 * 处方数据处理
	 * 如总金额、执行科室等数据的处理
	 * @param orpresdto
	 */
	private void ordPresDatumHandle(OrdPresDTO orpresdto,PresPrintParamDTO param){
		//参数设置
		FArrayList list=orpresdto.getPresdrugs();
		PresDrugDTO presdrug=(PresDrugDTO)list.get(0);
		FDouble amt_total=new FDouble(0);
		
		//设置处方相关信息
		orpresdto.setAge(param.getAge());
		orpresdto.setDes_alcla(param.getDes_alcla());
		orpresdto.setName_dep_mp(presdrug.getName_dep_mp());
		
		//遍历
		for(int i=0;i<list.size();i++){
			presdrug=(PresDrugDTO)list.get(0);
			amt_total.add(presdrug.getAmt_real());
		}
		//设置处方总金额信息
		orpresdto.setAmt_total(amt_total);
	}
}
