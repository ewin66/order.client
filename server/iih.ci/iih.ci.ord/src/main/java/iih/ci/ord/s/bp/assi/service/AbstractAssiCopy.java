package iih.ci.ord.s.bp.assi.service;

import java.util.Date;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.d.desc.MeterialDODesc;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.utils.GetDrugDaysOfAvailable;
import iih.ci.ord.s.utils.GetDrugTotalQuan4DoseBP;
import iih.ci.ord.s.utils.GetDrugTotalQuan4HerbsBP;
import iih.ci.ord.s.utils.GetDrugTotalQuanBP;
import iih.ci.ord.s.utils.GetSrvTotalQuanBP;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStockDTO;
import iih.mm.itf.material.i.IMaterialStockService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 
 * @author HUMS
 * @param <T>
 * @param <V>
 *
 */
public abstract class AbstractAssiCopy<T, V> extends AbstractAssiParam {

	/**
	 * 开始进行属性拷贝
	 * @param source
	 * @param target
	 * @throws BizException
	 */
	public void startCopy(T source, V target) throws BizException {

		// 调用验证
		if (beforeCopyValidate(source, target)) {

			this.copyPropertys(source, target);

			// 根据就诊类型、服务类型、数据来源动态获取相关属性拷贝
		}

	}

	/**
	 * 属相拷贝前校验逻辑
	 * @param source
	 * @param target
	 * @return
	 */
	protected boolean beforeCopyValidate(T source, V target) {

		return true;
	}

	/**
	 * 执行属性拷贝
	 * 
	 * @param source 源对象
	 * @param target 目标对象
	 */
	protected abstract void copyPropertys(T source, V target) throws BizException;

	/**
	 * 获取特定属性拷贝对象
	 * 
	 * @throws BizException
	 */
	protected void getDynamicProerty() throws BizException {

	}

	/**
	 * 判断FDouble类型数据是否为空
	 * 
	 * @param doubleData 待判断的数据
	 * @return true doubleData为空，否则不为空
	 */
	protected boolean isFDoubleEmpty(FDouble doubleData) {

		FDouble date1 = new FDouble(0.00000001);
		if (doubleData == null || date1.compareTo(doubleData) > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 计算CiEmsSrvDTO中的总量
	 * 
	 * @param srvdto 服务项目对象
	 * @param useDays 使用天数
	 * @param orders 医嘱付数（草药使用）
	 * @throws BizException
	 */
	protected void setCiEmsSrvMeduPropertys(CiEmsSrvDTO srvdto, Integer useDays, Integer orders) throws BizException {

		useDays = useDays == null ? 1 : useDays;
		orders = orders == null ? 1 : orders;

		// 如果是物品，重新获取物品对象 TODO 计算总量
		if (srvdto.getFg_mm() == FBoolean.TRUE) {
			// 计算药品总量
			if (srvdto.getFg_dose_anoma() == FBoolean.TRUE) { // 变动用药计算总量
				GetDrugTotalQuan4DoseBP bp = new GetDrugTotalQuan4DoseBP();
				srvdto.setQuan_cur(new FDouble(bp.exec(srvdto, useDays)));
			} else {
				if (srvdto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) { // 草药计算总量
					GetDrugTotalQuan4HerbsBP bp = new GetDrugTotalQuan4HerbsBP();
					srvdto.setQuan_cur(bp.exec(srvdto, orders));
				} else {
					GetDrugTotalQuanBP bp = new GetDrugTotalQuanBP();
					srvdto.setQuan_cur(new FDouble(bp.exec(srvdto, useDays)));
				}
			}
			// 领量天数
			srvdto.setDays_available(new GetDrugDaysOfAvailable().exec(srvdto));
		} else {
			// 计算非药品服务总量
			GetSrvTotalQuanBP bp = new GetSrvTotalQuanBP();
			srvdto.setQuan_cur(new FDouble(bp.exec(srvdto, useDays)));
			srvdto.setQuan_total_medu(srvdto.getQuan_cur());
		}
	}

	/**
	 * 获取物品价格
	 * 
	 * @param id_mm 物品id
	 * @param id_unit_sale
	 * @return
	 */
	protected FDouble getMMPrice(String id_mm, String id_unit_sale) throws BizException {
		IMaterialStockService service = ServiceFinder.find(IMaterialStockService.class);
		GetStockReqDTO reqDto = new GetStockReqDTO();
		reqDto.setId_mm(id_mm);
		reqDto.setReq_unit_id(id_unit_sale);
		GetStockReqDTO[] reqDtoArr = new GetStockReqDTO[1];
		reqDtoArr[0] = reqDto;
		MaterialStockDTO[] materials = service.getMaterialStocks(reqDtoArr);
		if (materials != null && materials.length > 0) {
			return materials[0].getPrice_act();
		} else {
			return null;
		}
	}

	/**
	 * 执行科室
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
