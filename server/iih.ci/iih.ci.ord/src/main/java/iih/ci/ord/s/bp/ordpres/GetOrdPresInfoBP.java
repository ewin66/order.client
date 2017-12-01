package iih.ci.ord.s.bp.ordpres;

import iih.ci.ord.dto.ordpres.d.OrdPresDTO;
import iih.ci.ord.dto.ordpres.d.PresDrugDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获得医嘱处方信息操作BP
 * （一次就诊）
 */
public class GetOrdPresInfoBP {
	/**
	 * 获得患者就诊医嘱处方信息
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	public OrdPresDTO[] exec(String id_en) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_en))return null;
		
		//处方查询条件
		GetOrdPresInfoQry qry = new GetOrdPresInfoQry(id_en,null);
		
		//获得处方信息
		OrdPresDTO[] ordpreses = (OrdPresDTO[])AppFwUtil.getDORstWithDao(qry, OrdPresDTO.class);
		if(CiOrdUtils.isEmpty(ordpreses))return null;
		
		//获得处方明细信息
		GetOrdPresItemsInfoQry itmsqry=new GetOrdPresItemsInfoQry();
		for(int i=0;i<ordpreses.length;i++){//遍历
			//设置医嘱处方对应的处方明细信息
			setOrdPresItmsInfo(ordpreses[i],itmsqry);
		}
		
		return ordpreses;	
	}
	
	/**
	 * 设置医嘱处方对应的处方明细信息
	 * @param orpresdto
	 * @param itmsqry
	 * @throws BizException
	 */
	private void setOrdPresItmsInfo(OrdPresDTO orpresdto,GetOrdPresItemsInfoQry itmsqry) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(orpresdto) || CiOrdUtils.isEmpty(itmsqry))return;
		
		//设置查询参数
		itmsqry.setQryParameter(orpresdto.getId_pres());
		
		//获得处方明细信息
		PresDrugDTO[] presdrugs=(PresDrugDTO[])AppFwUtil.getDORstWithDao(itmsqry, PresDrugDTO.class);
		if(CiOrdUtils.isEmpty(presdrugs))return;
		
		//设置处方对应的明细信息
		orpresdto.setPresdrugs(CiOrdUtils.array2FArrayList(presdrugs));
	}
}
