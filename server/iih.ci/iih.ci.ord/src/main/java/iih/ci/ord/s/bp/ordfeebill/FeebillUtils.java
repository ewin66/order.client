package iih.ci.ord.s.bp.ordfeebill;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;

public class FeebillUtils {
	/**
	 * 是否为治疗模式（短流程模式）
	 * @param ord
	 * @return
	 */
	public static boolean IsTreatMode(CiOrderDO ord){
		return ord.getFg_quickwflow() != null && ord.getFg_quickwflow().booleanValue();
	}
	
	/**
	 * 是佛为临床项目费用
	 * @param srv
	 * @return
	 */
	public static boolean IsClinicalFee(OrdSrvDO srv){
		return srv.getEu_sourcemd() == OrSrvSourceFromEnum.PHYSIAN||
				srv.getEu_sourcemd() == OrSrvSourceFromEnum.AGENTFROMPRIMD||
				srv.getEu_sourcemd() == OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD;
	}
	
	/**
	 * 是否为费用项目
	 * @param srv
	 * @return
	 */
	public static boolean IsBl(OrdSrvDO srv){
		return srv.getFg_bl() != null && srv.getFg_bl().booleanValue();
	}
	
	
	
}
