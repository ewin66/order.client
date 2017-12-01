package iih.ci.ord.s.bp.orsms.lis.cfg;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;

import iih.ci.ord.cfg.cirulecfg.d.CiRuleCfg;
import iih.ci.ord.i.cfg.rulecfg.ICiRuleCfgMaintainService;
import xap.lui.core.cache.XapCacheMgr;
import xap.mw.core.utils.StringUtil;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;

public class EmsMergeRulesCfg {
	static EmsMergeRulesCfg cfg;

	private Configure cfgJson;

	private static final String CiOrderBlockCache = "CiOrderBlockCache";
	public static final String CiEmsMergeCfgNode = "/ciord/ordermerge";
	/**
	 * 阿拉伯数字
	 */
	public static final String SYMBOL_ARABIC_INDEX_FORMAT = "#{arabic}";
	/**
	 * 英文字母
	 */
	public static final String SYMBOL_ALPHABET_INDEX_FORMAT = "#{alphabet}";
	/**
	 * 罗马数字
	 */
	public static final String SYMBOL_ROMANNO_INDEX_FORMAT = "#{romanno}";

	/**
	 * 逗点
	 */
	public static final String SYMBOL_INDEX_FORMAT_SUFFIX_DOT = ".";
	/**
	 * 顿号
	 */
	public static final String SYMBOL_INDEX_FORMAT_SUFFIX_COMMA = "、";
	/**
	 * 圆括号
	 */
	public static final String SYMBOL_INDEX_FORMAT_SUFFIX_PARENTTHESIS = ")";

	/**
	 * 注意事项换行符 <br>
	 */
	public static final String SYMBOL_WRAP_LINE_BR = "<br/>";
	public static final String SYMBOL_WRAP_LINE_AND = "&";

	private EmsMergeRulesCfg() {
		init();
	}

	private void init() {
		//try {

			// 是否没有定义配置节点
			/*
			 * if (0 == XapZkCenter.getZkMgr().getNodeId("/ciord")) { if
			 * (!XapZkCenter.getZkMgr().createNode("/", "ciord", "") ||
			 * !XapZkCenter.getZkMgr().createNode("/ciord", "ordermerge", "")) {
			 * Logger.error("[CiOrd] 在ZooKeeper上注册合单配置失败"); return; } }
			 */			

			// 轻量级获取不到 通过数据库获取配置结果
			/*ICiRuleCfgMaintainService ruleCfgService = (ICiRuleCfgMaintainService) ServiceFinder
					.find(ICiRuleCfgMaintainService.class);
			CiRuleCfg ruleCfg = ruleCfgService.getMergeRuleCfg();
			String cfgJsonString = ruleCfg.getCfg_result();*/

			// 从配置节点读取配置流
			// String cfgJsonString = XapZkCenter.getZkMgr().getData(CiEmsMergeCfgNode);
			/*if (StringUtil.isEmpty(cfgJsonString)) {
				Logger.error("没有有效的合单配置,请进行配置");
				return;
			}
			XapCacheMgr.getStrongCacheOnlyRemote(CiOrderBlockCache).put(CiEmsMergeCfgNode, cfgJsonString);

			cfgJson = null;*/

		/*} catch (Exception e) {
			e.printStackTrace();

		} finally {*/
			// XapZkCenter.getZkMgr().returnConn();
		//}

	}

	private Configure getConfigure() {

		try {
			if (cfgJson == null) {
				ICiRuleCfgMaintainService ruleCfgService = (ICiRuleCfgMaintainService) ServiceFinder
						.find(ICiRuleCfgMaintainService.class);
				CiRuleCfg ruleCfg = ruleCfgService.getMergeRuleCfg();
				String cfgString = ruleCfg.getCfg_result();
				
				/*String cfgString = (String) XapCacheMgr.getStrongCacheOnlyRemote(CiOrderBlockCache)
						.get("/ciord/ordermerge");*/
				if (StringUtils.isEmpty(cfgString)) {
					Logger.error("从缓存获取配置信息失败");
				}
				synchronized (this) {
					cfgJson = JSON.parseObject(cfgString, Configure.class);
				}
			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
		}
		return cfgJson;

	}

	private RuntimeConfigure getRuntimeConfigure() {
		if (null == getConfigure()) {
			return null;
		}

		for (RuntimeConfigure cfg : getConfigure().getMergerules()) {
			if (cfg.isDefault()) {
				return cfg;
			}
		}
		return null;
	}

	/**
	 * 单例模式对象接口
	 * 
	 * @return
	 */
	public static EmsMergeRulesCfg getInstance() {
		if (null == cfg) {
			synchronized (EmsMergeRulesCfg.class) {
				if (null == cfg) {
					cfg = new EmsMergeRulesCfg();
				}
			}
		}
		
		return cfg;
	}

	public boolean reload() {
		init();
		return true;
	}

	/**
	 * 根据给定规则ID 获取规则所有值配置
	 * 
	 * @param id
	 * @return
	 */
	public String getRuleStringByID(String id) {
		GroupRuleConfigure cfg = getRuleByID(id);
		if (null == cfg) {
			return null;
		}
		return cfg.getValues();
	}

	/**
	 * 根据给定的规则 id 获取规则描述对象
	 * 
	 * @param id
	 * @return
	 */
	public GroupRuleConfigure getRuleByID(String id) {
		RuntimeConfigure cfg = getRuntimeConfigure();
		if (null == cfg || StringUtils.isEmpty(id)) {
			return null;
		}

		for (GroupRuleConfigure group : cfg.getRules()) {
			if (group.getId().equals(id)) {
				return group;
			}
		}
		return null;
	}

	/**
	 * 返回所有注意事项集合，注意：有几组规则就有几组注意事项（但注意事项可空）
	 * 
	 * @return
	 */
	public List<NoticeConfigure> getNotices() {
		RuntimeConfigure cfg = getRuntimeConfigure();
		if (null == cfg) {
			return null;
		}
		return cfg.getNotices();
	}

	/**
	 * 获取索引格式符号
	 * 
	 * @return
	 */
	public String getNoticeIndexSymbol() {
		RuntimeConfigure cfg = getRuntimeConfigure();
		if (null == cfg) {
			return null;
		}
		return cfg.getIndexformat();
	}

	/**
	 * 获取索引格式符号后缀
	 * 
	 * @return
	 */
	public String getNoticeIndexSuffixSymbol() {
		RuntimeConfigure cfg = getRuntimeConfigure();
		if (null == cfg) {
			return null;
		}
		return cfg.getIndexsuffix();
	}

	/**
	 * 注意事项换行符
	 * 
	 * @return
	 */
	public String getNoticeWrapSymbol() {
		RuntimeConfigure cfg = getRuntimeConfigure();
		if (null == cfg) {
			return null;
		}
		return cfg.getWrap();
	}
}
