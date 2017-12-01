package iih.ci.ord.s.bp.validate;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.FArrayList;
/**
 * 医保和临床路径的审核判断
 * @author zhangwq
 *
 */
public class OrDoctorCheckValidateBP {
	/**
	 * 
	 * @param aggors
	 * @return
	 */
	public FArrayList exec(CiorderAggDO[] aggors){
		if(CiOrdUtils.isEmpty(aggors)) return null;
		FArrayList list = new FArrayList();
		for(CiorderAggDO agg : aggors){
			CiOrderDO ord = agg.getParentDO();
			//只要有医保或临床路径未判断，都会打开医嘱审核界面，医嘱审核界面中包含全部内容，所以只要判断其中一个就可以了
			if (ord.getEu_hpindicjudge() == HpIndicJudgeEnum.WAITINGJUDGE
					|| ord.getEu_uncporjudge() == HpIndicJudgeEnum.WAITINGJUDGE) {
				list.append(ord.getId_or());
			}
		}
		return list;
	}
}
