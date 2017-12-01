package iih.ci.ord.s.bp.assi.impl.cimes.op;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.s.bp.assi.impl.cimes.base.OpBaseCopyCalCiEmsProperty;
import xap.mw.core.data.BizException;

/**
 * 草药CiEms属性拷贝
 * 
 * @author HUMS
 *
 */
public class OpCopyHerbsPropertyImpl extends OpBaseCopyCalCiEmsProperty {

	/**
	 * 设置备注
	 * 
	 * @param ciEms
	 */
	@Override
	protected void setCiEmsNote(CiEmsDTO ciEms) throws BizException {

		StringBuffer buffer = new StringBuffer(); // 草药 
		if (ciEms.getSd_srvtp() != null && ciEms.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
			MedSrvDO medSrv = medSrvMap.get(ciEms.getId_srv());
			CiEmsSrvDTO ciEmsSrv = (CiEmsSrvDTO) ciEms.getEmssrvs().get(0);
			// TODO 有必要判断 ciEmsSrv.getQuan_med() 是否为空吗？ 
			buffer.append(" " + ciEms.getName_boil());
			buffer.append(" " + ciEmsSrv.getQuan_med() + " " + medSrv.getMed_name());
			buffer.append("," + ciEms.getName_freq());
			buffer.append("," + ciEms.getName_route());

		} else {
			// ciEms.setNote();
		}

		ciEms.setNote(buffer.toString());
	}
}
