package iih.ci.ord.s.bp.splitlis;

import java.util.HashMap;
import java.util.Map;

public class SplitLisConst {
	
	//标本类型规则
	public static final String CI_OP_LIS_SPLIT_SAMPTP_RULE1_CODE="CI_OP_LIS_SPLIT_SAMPTP_RULE1";//
	
	public static final String CI_OP_LIS_SPLIT_SAMPTP_RULE2_CODE="CI_OP_LIS_SPLIT_SAMPTP_RULE2";//
	
	public static final String CI_OP_LIS_SPLIT_SAMPTP_RULE3_CODE="CI_OP_LIS_SPLIT_SAMPTP_RULE3";//
	
	public static final String CI_OP_LIS_SPLIT_SAMPTP_RULE4_CODE="CI_OP_LIS_SPLIT_SAMPTP_RULE4";//
	
	public static final String CI_OP_LIS_SPLIT_SAMPTP_RULE5_CODE="CI_OP_LIS_SPLIT_SAMPTP_RULE5";//
	
	public static final String CI_OP_LIS_SPLIT_SAMPTP_RULE0_CODE="CI_OP_LIS_SPLIT_SAMPTP_RULE0";//
	
	//不在标本类型规则中的数据
	public static final String CI_OP_LIS_SPLIT_SAMPTP_NOTRULE_CODE="CI_OP_LIS_SPLIT_SAMPTP_NOTRULE";//
	
	//检验分类规则
	public static final String CI_OP_LIS_SPLIT_SRVCA_RULE1_CODE="CI_OP_LIS_SPLIT_SRVCA_RULE1";//
	
	public static final String CI_OP_LIS_SPLIT_SRVCA_RULE2_CODE="CI_OP_LIS_SPLIT_SRVCA_RULE2";//
	
	public static final String CI_OP_LIS_SPLIT_SRVCA_RULE3_CODE="CI_OP_LIS_SPLIT_SRVCA_RULE3";//
	
	public static final String CI_OP_LIS_SPLIT_SRVCA_RULE4_CODE="CI_OP_LIS_SPLIT_SRVCA_RULE4";//
	
	public static final String CI_OP_LIS_SPLIT_SRVCA_RULE5_CODE="CI_OP_LIS_SPLIT_SRVCA_RULE5";//
	
	public static final String CI_OP_LIS_SPLIT_SRVCA_RULE0_CODE="CI_OP_LIS_SPLIT_SRVCA_RULE0";//
	
	//不在检验分类规则中的数据
	public static final String CI_OP_LIS_SPLIT_SRVCA_NOTRULE_CODE="CI_OP_LIS_SPLIT_SRVCA_NOTRULE";//
	
	//标本采集建议执行时间（IIH添加字典）	
	public static final String CI_OP_LIS_SPLIT_SAMPCOLTIME_RULE0_CODE="CI_OP_LIS_SPLIT_SAMPCOLTIME_RULE0";//
	
	//不在标本采集建议执行时间规则中的数据
	public static final String CI_OP_LIS_SPLIT_SAMPCOLTIME_NOTRULE_CODE="CI_OP_LIS_SPLIT_SAMPCOLTIME_NOTRULE";//
	
	//执行科室	
	public static final String CI_OP_LIS_SPLIT_DEPMP_RULE0_CODE="CI_OP_LIS_SPLIT_DEPMP_RULE0";//
	
	//不在执行科室规则中的数据
	public static final String CI_OP_LIS_SPLIT_DEPMP_NOTRULE_CODE="CI_OP_LIS_SPLIT_DEPMP_NOTRULE";//
	
	//临时方案
	
	private static final Map<String,String> samptpmap=new HashMap<String, String>();
	private static final Map<String,String> srvcamap=new HashMap<String, String>();
	private static final Map<String,String> sampcoltimemap=new HashMap<String, String>();
	private static final Map<String,String> depmpmap=new HashMap<String, String>();
	
	public static Map<String, String> getSamptpmap() {
		samptpmap.put(CI_OP_LIS_SPLIT_SAMPTP_RULE0_CODE, "0;code;{a}");
		samptpmap.put(CI_OP_LIS_SPLIT_SAMPTP_RULE1_CODE, "0;code;{b}");
		samptpmap.put(CI_OP_LIS_SPLIT_SAMPTP_RULE2_CODE, "0;code;{c}");
		samptpmap.put(CI_OP_LIS_SPLIT_SAMPTP_RULE3_CODE, "0;code;{d}");
		samptpmap.put(CI_OP_LIS_SPLIT_SAMPTP_RULE4_CODE, "0;code;{e}");
		samptpmap.put(CI_OP_LIS_SPLIT_SAMPTP_RULE5_CODE, "0;each");
		return samptpmap;
	}
	public static Map<String, String> getSrvcamap() {
		srvcamap.put(CI_OP_LIS_SPLIT_SRVCA_RULE0_CODE, "1;code;{a}");
		srvcamap.put(CI_OP_LIS_SPLIT_SRVCA_RULE1_CODE, "1;code;{a}");
		srvcamap.put(CI_OP_LIS_SPLIT_SRVCA_RULE2_CODE, "1;code;{a}");
		srvcamap.put(CI_OP_LIS_SPLIT_SRVCA_RULE3_CODE, "1;code;{a}");
		srvcamap.put(CI_OP_LIS_SPLIT_SRVCA_RULE4_CODE, "1;code;{a}");
		srvcamap.put(CI_OP_LIS_SPLIT_SRVCA_RULE5_CODE, "1;each");
		return srvcamap;
	}
	public static Map<String, String> getSampcoltimemap() {
		sampcoltimemap.put(CI_OP_LIS_SPLIT_SAMPCOLTIME_RULE0_CODE, "2;each");
		return sampcoltimemap;
	}
	
	public static Map<String, String> getDepmpmap() {
		depmpmap.put(CI_OP_LIS_SPLIT_DEPMP_RULE0_CODE, "3;each");
		return depmpmap;
	}

}
