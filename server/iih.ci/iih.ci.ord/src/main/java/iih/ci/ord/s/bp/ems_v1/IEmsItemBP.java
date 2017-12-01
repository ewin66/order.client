package iih.ci.ord.s.bp.ems_v1;

import java.util.List;

import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.ci.ord.ciorder.d.CiOrderDO;

public interface IEmsItemBP {

	/**
	 * 通过给定医嘱id 加载医疗单
	 * @param id_or
	 * @return
	 */
	public boolean load(String id_or);
	/**
	 * 通过医嘱对象加载医疗单
	 * @param o
	 * @return
	 */
	public boolean load(CiOrderDO o);
	/**
	 * 通过模板加载医疗单
	 * @param tmpl
	 * @return
	 */
	public boolean load(OrTplNItmDO tmpl);
	/**
	 * 通过服务id添加医疗单服务项目
	 * @param id_srv
	 * @return
	 */
	public Object append(String id_srv);
	/**
	 * 通过服务id和物品id添加医疗单服务项目
	 * @param id_srv
	 * @param id_mm
	 * @return
	 */
	public Object append(String id_srv, String id_mm);
	/**
	 * 删除医疗单服务项目
	 * @param id_srv
	 * @return
	 */
	public Object remove(String id_srv);
	
	/**
	 * 医疗单有效性验证
	 * @return
	 */
	public boolean validate();
	/**
	 * 获取医疗单服务列表
	 * @return
	 */
	public List<?> getServiceList();
	/**
	 * 获取主服务信息
	 * @return
	 */
	public Object getMasterService();
	/**
	 * 拷贝医疗单
	 * @return
	 */
	public IEmsItemBP copy();
	/**
	 * 保存医疗单
	 * @return
	 */
	public Object save();
}
