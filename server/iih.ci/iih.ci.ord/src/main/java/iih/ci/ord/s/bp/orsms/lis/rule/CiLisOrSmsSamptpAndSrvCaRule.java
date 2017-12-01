package iih.ci.ord.s.bp.orsms.lis.rule;
import iih.ci.ord.i.orsms.ICiLisOrSmsRule;
import iih.ci.ord.orsms.d.CiLisOrInfo4Sms;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;
import iih.ci.ord.s.bp.orsms.lis.cfg.EmsMergeRulesCfg;
import iih.ci.ord.s.bp.orsms.lis.cfg.GroupRuleConfigure;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;

/**
 * 临床检验医嘱标本类型分单规则
 */
public class CiLisOrSmsSamptpAndSrvCaRule implements ICiLisOrSmsRule {

	List<CiLisOrSmsIoDTO> outList;
	SamptpAndSrcCaBP bp=new SamptpAndSrcCaBP();
	@Override
	public List<CiLisOrSmsIoDTO> exec(List<CiLisOrSmsIoDTO> lisorlist) throws BizException {

		outList = new ArrayList<CiLisOrSmsIoDTO>();
		if (lisorlist != null) {
			AnalyzeCiLisOrSmsList(lisorlist);
		}
		return outList;

	}

	/**
	 * 
	 * @param orderpresSplitList
	 * @throws BizException 
	 */
	private void AnalyzeCiLisOrSmsList(List<CiLisOrSmsIoDTO> orderpresSplitList) throws BizException {
		String byStr = CiLisOrSmsUtils.getCiLisOrSmsSamptpRuleBy();
		GroupRuleConfigure fid = EmsMergeRulesCfg.getInstance().getRuleByID(CiLisOrSmsUtils.CILISOR_SMS_SAMPTPANDSRVCA_RULE_ID);
		if (fid != null){
		 byStr = fid.getValues();
		bp.AnalyzeRules(byStr);
		for (CiLisOrSmsIoDTO LisOrSmsIo : orderpresSplitList) {
			if (LisOrSmsIo.getFg_apprule() == "Y") {

				FArrayList2 orderList = LisOrSmsIo.getCilisorinfos();
				AnalyzeLisOrInfo4Sms(orderList);

				getLisOrSmsIoList(LisOrSmsIo);
			} else {
				LisOrSmsIo.setFg_apprule("Y");
				outList.add(LisOrSmsIo);
			}
		}
		}else{
//			outList.addAll(orderpresSplitList);
			throw new BizException("没有读到合单配置文件！！");
		}
	}



	/**
	 * 分解 lisOrInfo4SmsList
	 * @param lisOrInfo4SmsList
	 */
	private void AnalyzeLisOrInfo4Sms(FArrayList2 lisOrInfo4SmsList) {

        bp.htors8lis.clear();
		if (lisOrInfo4SmsList != null && lisOrInfo4SmsList.size() > 0) {
		for (Object d : lisOrInfo4SmsList) {

			CiLisOrInfo4Sms dto = (CiLisOrInfo4Sms) d;
			bp.HandleSmsInfo(dto);
		}
		}
		return ;
	}
	
	/**
	 * 返回的集合
	 * 
	 * @return
	 */
	private void getLisOrSmsIoList(CiLisOrSmsIoDTO sms) {
		
		Hashtable<String, FArrayList2> htors8lis=bp.htors8lis;
		if (htors8lis == null || htors8lis.isEmpty())
			return ;			

		Iterator entrys = htors8lis.entrySet().iterator();

		while (entrys.hasNext()) {
			Map.Entry entry = (Map.Entry) entrys.next();
			String key = (String) entry.getKey();
			FArrayList2 orderList = (FArrayList2) entry.getValue();
			CiLisOrSmsIoDTO smsio=new CiLisOrSmsIoDTO();
			smsio.setId_samptp(sms.getId_samptp());
			smsio.setAnnouncements(sms.getAnnouncements());
			smsio.setId_dep_mp(sms.getId_dep_mp());
			smsio.setFg_apprule(sms.getFg_apprule());
			smsio.setFg_hp(sms.getFg_hp());
			smsio.setFg_opspecial(sms.getFg_opspecial());           
            smsio.setId_sampcollecttimetp( sms.getId_sampcollecttimetp());
            smsio.setId_sampcoltime(sms.getId_sampcoltime());
            smsio.setId_srvca(sms.getId_srvca());
            smsio.setSd_samptp(sms.getSd_samptp());
            smsio.setId_unit_sampcoltime(sms.getId_unit_sampcoltime());
            smsio.setInnercode_srvca(sms.getInnercode_srvca());
            smsio.setLen_sampcoltime(sms.getLen_sampcoltime());
            smsio.setCilisorinfos(orderList);
			if(!key.equals(CiLisOrSmsUtils.CILISOR_SMS_NOTINRULE_ID)){
				String[] tmp=key.split(CiLisOrSmsUtils.CILISOR_SMS_RULEGRP_SPLITCA);
				smsio.setId_samptp(tmp[0]);
				smsio.setId_srvca(tmp[1]);
			}
			
			outList.add(smsio);
			}
	}



}
