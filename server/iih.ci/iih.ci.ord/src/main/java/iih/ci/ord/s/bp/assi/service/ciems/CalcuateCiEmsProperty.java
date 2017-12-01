package iih.ci.ord.s.bp.assi.service.ciems;

import java.util.Date;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.d.desc.MeterialDODesc;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.bp.assi.config.AssiConifigBP;
import iih.ci.ord.s.bp.assi.config.ExtensionPointEu;
import iih.ci.ord.s.bp.assi.service.AbstractAssiCalcuate;
import iih.ci.ord.s.bp.emscalculate.total.CalTimesCurBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FTime;

/**
 * 获取需要计算的CiEms相关属性
 * 
 * @author HUMS
 *
 */
public abstract class CalcuateCiEmsProperty extends AbstractAssiCalcuate<CiEmsDTO> {

	@Override
	public final void calcuateProperty(CiEmsDTO ciEms) throws BizException {

		// 在执行属性拷贝前处理逻辑
		this.beforeCalcuateCustomProperty(ciEms);
		// 设置执行科室
		this.setMpDeptID(ciEms);
		// 计算在院执行次数
		this.setCalTimesCur(ciEms);
		// 设置在院执行状态标识
		this.setFgMpIn(ciEms);
		// 设置在院执行状态，在院执行次数
		this.setTimesMpIn(ciEms);
		// 设置服务价格
		this.setCiEmsPrice(ciEms);
		// 设置备注信息
		this.setCiEmsNote(ciEms);
		// 设置匹配的医疗单
		this.setEmsMatchRst(ciEms);

		// 执行属性拷贝后处理
		this.afterCalcuateCustomProperty(ciEms);

	}

	/**
	 * 设置执行科室
	 * 
	 * @param ciEms
	 * @throws BizException
	 */
	protected abstract void setMpDeptID(CiEmsDTO ciEms) throws BizException;

	/**
	 * 设置总次数
	 * 
	 * @param ciEms
	 * @throws BizException
	 */
	protected abstract void setCalTimesCur(CiEmsDTO ciEms) throws BizException;

	/**
	 * 获取在院执行状态
	 * 
	 * @param ciEms
	 * @return 是否在院执行
	 * @throws BizException
	 */
	protected abstract void setFgMpIn(CiEmsDTO ciEms) throws BizException;

	/**
	 * 设置在院执行次数
	 * 
	 * @param ciEms
	 * @throws BizException
	 */
	protected abstract void setTimesMpIn(CiEmsDTO ciEms) throws BizException;

	/**
	 * 设置价格
	 * 
	 * @param ciEms
	 * @throws BizException
	 */
	protected abstract void setCiEmsPrice(CiEmsDTO ciEms) throws BizException;

	/**
	 * 设置备注
	 * 
	 * @param ciEms
	 */
	protected abstract void setCiEmsNote(CiEmsDTO ciEms) throws BizException;

	/**
	 * 设置医疗单匹配结果
	 * 
	 * @param ciEms
	 * @throws BizException
	 */
	protected abstract void setEmsMatchRst(CiEmsDTO ciEms) throws BizException;

	/**
	 * 获取执行科室
	 * 
	 * @param envinfo 当前上下文就诊环境
	 * @param medsrvDO 医疗服务
	 * @return
	 * @throws BizException
	 */
	protected OrWfDeptInfoDTO getMpDeptID(CiEnContextDTO envinfo, MedSrvDO medsrvDO) throws BizException {

		OrWfExDeptParamDTO paramdto = new OrWfExDeptParamDTO();
		if (medsrvDO.getFg_mm().booleanValue()) {
			MeterialDO meterial = meterialMap.get(medsrvDO.getId_srv());
			if (meterial == null) {
				String whereStr = MeterialDODesc.TABLE_ALIAS_NAME + "." + MeterialDO.ID_SRV + " = '"
						+ medsrvDO.getId_srv() + "'";
				MeterialDO[] meterals = CiOrdAppUtils.getMaterialQryService().find(whereStr, MeterialDO.ID_SRV,
						FBoolean.FALSE);
				if (meterals != null && meterals.length > 0) {
					meterial = meterals[0];
				}
			}
			if (meterial != null) {
				paramdto.setId_mm(meterial.getId_mm()); // 服务选取的关联物品
			}
		}

		// dto.Innercode_srvca = "";//服务分类内码
		paramdto.setEu_wftp(0); // 0执行与物资 1执行科室 2物资流向
		paramdto.setCode_entp(envinfo.getCode_entp()); // 就诊类型
		paramdto.setId_dept_ns(envinfo.getId_dep_ns()); // 就诊护理病区
		paramdto.setId_dept_or(envinfo.getId_dep_or());// 开单科室
		paramdto.setId_dept_en(envinfo.getId_dep_en()); // id_dept_en;//就诊科室
		// dto.Recurstr = ""; //长临需要的 不知道 就为空
		paramdto.setId_srv(medsrvDO.getId_srv()); // 服务
		paramdto.setSd_srvtp(medsrvDO.getSd_srvtp()); // 服务类型sd
		paramdto.setId_srvca(medsrvDO.getId_srvca());// 服务分类

		paramdto.setId_usage(medsrvDO.getId_route()); // 用法
		// dto.Weekno = "2";//生效日期时间相关的 周#与时间
		Date date = new Date();
		paramdto.setTimestr(new FTime(date));
		// paramdto.setEu_wftp(EnumFlow.EXECUTEFLOW); //只求执行科室
		// 执行科室（新的）
		return iciOrdQryService.getExeDepts4CiOrSrvN(paramdto);

	}

}
