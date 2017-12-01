package iih.ci.ord.s.bp.orsms.lis.rule;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import xap.mw.core.data.FArrayList2;
import iih.ci.ord.orsms.d.CiLisOrInfo4Sms;

public class SamptpAndSrcCaBP {

	private Hashtable<String, List<String>> htrule = new Hashtable<String, List<String>>();
	private Hashtable<String, List<String>> htruleop = new Hashtable<String, List<String>>();
	private Hashtable<String, List<String>> nonhtrule = new Hashtable<String, List<String>>();
	public Hashtable<String, FArrayList2> htors8lis = new Hashtable<String, FArrayList2>();

	private String noneval = "noneval";

	/**
	 * 分解规则 根据标本类型规则将不同的规则进行分类
	 * 
	 * @param srule
	 */
	public void AnalyzeRules(String srule) {

		String[] ruleca = srule.split(CiLisOrSmsUtils.CILISOR_SMS_RULEGRP_SPLITOR);

		for (String ruca : ruleca) {
			String[] rulegrps = ruca.split(CiLisOrSmsUtils.CILISOR_SMS_RULEGRP_SPLITCA);
			//
			// Hashtable<String, String> SrvCahtrule = new Hashtable<String,
			// String>(); //
			// 标本类型规则
			if (rulegrps[0] == null || rulegrps[0].trim().length() == 0) {// 规则为空
				if (nonhtrule.containsKey(noneval)) {
					List<String> list = nonhtrule.get(noneval);
					list.add(ruca);
				} else {
					List<String> list = new ArrayList<String>();
					list.add(ruca);
					nonhtrule.put(noneval, list);
				}

			} else if (rulegrps[0].startsWith(CiLisOrSmsUtils.CILISOR_SMS_RULE_NOTIN)) {// 规则为非

				if (htruleop.containsKey(rulegrps[0])) {
					List<String> list = htruleop.get(rulegrps[0]);
					list.add(ruca);
				} else {
					List<String> list = new ArrayList<String>();
					list.add(ruca);
					htruleop.put(rulegrps[0], list);
				}

			} else {
				// 常规规则
				String[] rule = rulegrps[0].split(CiLisOrSmsUtils.CILISOR_SMS_RULE_SPLITOR);

				for (String o : rule) {
					// htrule.put(o, ruca);
					if (htrule.containsKey(o)) {
						List<String> list = htrule.get(o);
						list.add(ruca);
					} else {
						List<String> list = new ArrayList<String>();
						list.add(ruca);
						htrule.put(o, list);
					}
				}

			}

		}

	}

	public void HandleSmsInfo(CiLisOrInfo4Sms dto) {

		boolean flag = false;
		String sampttp = dto.getOrlisapdo().getId_samptp();
		// 处理第一种类型规则
		if (sampttp!=null&&htrule.containsKey(sampttp)) {
			List<String> rules = htrule.get(sampttp);
			for (String rule : rules) {

				flag = handlesrvcarule(dto, rule);
				if (flag)
					break;

			}

		}
		// 处理第二种类型规则
		if (sampttp!=null&&htruleop.size() > 0 && !flag) {
			Iterator entrys = htruleop.entrySet().iterator();

			while (entrys.hasNext()) {
				Map.Entry entry = (Map.Entry) entrys.next();
				String key = (String) entry.getKey();
				if (!key.contains(sampttp)) {

					List<String> rules = (List<String>) entry.getValue();

					for (String rule : rules) {
						flag = handlesrvcarule(dto, rule);
						if (flag)
							break;
					}

				}
			}

		}

		// 处理第三种类型规则  规则为空
		if (nonhtrule.size() > 0 && !flag) {

			List<String> rules = nonhtrule.get(noneval);

			for (String rule : rules) {
				flag = handlesrvcarule(dto, rule);
				if (flag)
					break;
			}

		}

		// 不在任何规则中的数据
		if (!flag) {

			if (htors8lis.containsKey(CiLisOrSmsUtils.CILISOR_SMS_NOTINRULE_ID)) {

				FArrayList2 list = htors8lis.get(CiLisOrSmsUtils.CILISOR_SMS_NOTINRULE_ID);
				list.add(dto);
			} else {
				FArrayList2 list = new FArrayList2();
				list.add(dto);
				htors8lis.put(CiLisOrSmsUtils.CILISOR_SMS_NOTINRULE_ID, list);
			}
		}

	}

	/**
	 * 处理检验分类规则
	 * 
	 * @param dto
	 * @param rule
	 * @return
	 */

	private boolean handlesrvcarule(CiLisOrInfo4Sms dto, String rule) {

		boolean flag = false;
		String[] rulegrps = rule.split(CiLisOrSmsUtils.CILISOR_SMS_RULEGRP_SPLITCA);
		String srvca = dto.getOrdo().getId_srvca();
		if (rulegrps[1] == null || rulegrps[1].trim().length() == 0) {// 规则为空
			flag = true;
			if (htors8lis.containsKey(rule)) {
				FArrayList2 list = htors8lis.get(rule);
				list.add(dto);
			} else {
				FArrayList2 list = new FArrayList2();
				list.add(dto);
				htors8lis.put(rule, list);
			}

		} else if (rulegrps[1].startsWith(CiLisOrSmsUtils.CILISOR_SMS_RULE_NOTIN)) {// 规则为非
			if (srvca!=null&&!rulegrps[1].contains(srvca)) {

				flag = true;
				if (htors8lis.containsKey(rule)) {
					FArrayList2 list = htors8lis.get(rule);
					list.add(dto);
				} else {
					FArrayList2 list = new FArrayList2();
					list.add(dto);
					htors8lis.put(rule, list);
				}

			}
		} else {

			if (srvca!=null&&rulegrps[1].contains(srvca)) {

				flag = true;
				if (htors8lis.containsKey(rule)) {
					FArrayList2 list = htors8lis.get(rule);
					list.add(dto);
				} else {
					FArrayList2 list = new FArrayList2();
					list.add(dto);
					htors8lis.put(rule, list);
				}

			}

		}

		return flag;

	}

}
