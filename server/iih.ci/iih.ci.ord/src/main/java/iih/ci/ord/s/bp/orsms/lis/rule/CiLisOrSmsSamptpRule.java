package iih.ci.ord.s.bp.orsms.lis.rule;

import iih.ci.ord.i.orsms.ICiLisOrSmsRule;

import iih.ci.ord.orsms.d.CiLisOrInfo4Sms;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;

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
public class CiLisOrSmsSamptpRule implements ICiLisOrSmsRule {

	List<CiLisOrSmsIoDTO> outList;

	@Override
	public List<CiLisOrSmsIoDTO> exec(List<CiLisOrSmsIoDTO> lisorlist) throws BizException {

		outList = new ArrayList<CiLisOrSmsIoDTO>();
		if (lisorlist != null) {
			AnalyzeCiLisOrSmsList(lisorlist);
		}
		return outList;

		// return null;
	}

	/**
	 * 
	 * @param orderpresSplitList
	 */
	private void AnalyzeCiLisOrSmsList(List<CiLisOrSmsIoDTO> orderpresSplitList) {
		for (CiLisOrSmsIoDTO LisOrSmsIo : orderpresSplitList) {
			if (LisOrSmsIo.getFg_apprule() == "Y") {

				FArrayList2 orderList = LisOrSmsIo.getCilisorinfos();
				Hashtable<String, FArrayList2> ht = AnalyzeLisOrInfo4Sms(orderList);
			//	AnalyzeCiLisOrSmsDTO(orderList);
				// this.getOrderPresSplitList(orderPresSplit);
				getLisOrSmsIoList(LisOrSmsIo,ht);
			} else {
				LisOrSmsIo.setFg_apprule("Y");
				outList.add(LisOrSmsIo);
			}
		}
	}



	/**
	 * 分解 lisOrInfo4SmsList
	 * @param lisOrInfo4SmsList
	 */
	private Hashtable<String, FArrayList2> AnalyzeLisOrInfo4Sms(FArrayList2 lisOrInfo4SmsList) {

		Hashtable<String, String> htrule = getSmsSamptpRule();
		Hashtable<String, FArrayList2> htors8lis = new Hashtable<String, FArrayList2>(); //
		if (lisOrInfo4SmsList != null && lisOrInfo4SmsList.size() > 0) {
		for (Object d : lisOrInfo4SmsList) {

			CiLisOrInfo4Sms dto = (CiLisOrInfo4Sms) d;
			if (htrule.containsKey(dto.getOrlisapdo().getId_samptp())) {
				String tmp = htrule.get(dto.getOrlisapdo().getId_samptp());
				if (htors8lis.containsKey(tmp)) {
					FArrayList2 list = htors8lis.get(tmp);
					list.add(dto);
				} else {
					FArrayList2 list = new FArrayList2();
					list.add(dto);
					htors8lis.put(tmp, list);
				}

			} else {

				if (htors8lis.containsKey(CiLisOrSmsUtils.CILISOR_SMS_SAMPTP_NOTINRULE_ID)) {

					FArrayList2 list = htors8lis.get(CiLisOrSmsUtils.CILISOR_SMS_SAMPTP_NOTINRULE_ID);
					list.add(dto);
				} else {
					FArrayList2 list = new FArrayList2();
					list.add(dto);
					htors8lis.put(CiLisOrSmsUtils.CILISOR_SMS_SAMPTP_NOTINRULE_ID, list);
				}

			}

		}
		}

		return htors8lis;
	}
	
	/**
	 * 返回的集合
	 * 
	 * @return
	 */
	private void getLisOrSmsIoList(CiLisOrSmsIoDTO sms,Hashtable<String, FArrayList2> htors8lis) {
		
		if (htors8lis == null && htors8lis.isEmpty())
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
			if(!key.equals(CiLisOrSmsUtils.CILISOR_SMS_SAMPTP_NOTINRULE_ID))
			smsio.setId_samptp(key);
			outList.add(smsio);
			}
	}

	/**
	 * @param
	 */
	private Hashtable<String, String> getSmsSamptpRule() {

		String byStr = CiLisOrSmsUtils.getCiLisOrSmsSamptpRuleBy();
		String[] rulegrps = byStr.split(CiLisOrSmsUtils.CILISOR_SMS_RULEGRP_SPLITOR);
		Hashtable<String, String> htrule = new Hashtable<String, String>(); //

		for (String s : rulegrps) {

			String[] rule = s.split(CiLisOrSmsUtils.CILISOR_SMS_RULE_SPLITOR);
			for (String o : rule) {
				htrule.put(o, s);
			}
		}

		return htrule;
	}

}
