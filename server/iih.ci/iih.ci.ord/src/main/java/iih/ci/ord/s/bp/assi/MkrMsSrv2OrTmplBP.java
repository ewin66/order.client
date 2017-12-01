package iih.ci.ord.s.bp.assi;

import iih.ci.ord.tmpl.d.CiOrTmplDTO;
import iih.ci.ord.tmpl.d.CiOrTmplSrvDTO;
import iih.ci.ord.tmpl.d.LongTempOrEnum;
import iih.mkr.ms.mkrms.d.MkrMsSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 组套中医疗服务转医嘱模板
 * 
 * @author HUMS
 *
 */
public class MkrMsSrv2OrTmplBP {

	private String eu_orsrcmdtp;

	public MkrMsSrv2OrTmplBP() {

	}

	public CiOrTmplDTO exec(MkrMsSrvDO mkrMsSrv, String eu_orsrcmdtp) throws BizException {

		this.eu_orsrcmdtp = eu_orsrcmdtp;

		// 医疗服务转标准模板
		CiOrTmplDTO ciOrTmpl = this.convertMkrMsSrvToCiOrTmpl(mkrMsSrv);
		// 医疗服务转模板项目
		CiOrTmplSrvDTO ciOrTmplSrv = this.convertMkrMsSrvToCiOrTmplSrv(mkrMsSrv);
		FArrayList Ortmplsrvs = new FArrayList();
		Ortmplsrvs.add(ciOrTmplSrv);
		ciOrTmpl.setOrtmplsrvs(Ortmplsrvs);

		return ciOrTmpl;
	}

	/**
	 * 组套中医嘱服务转换为医嘱模板
	 * 
	 * @param mkrMsSrv
	 *            医疗服务
	 * @return
	 */
	private CiOrTmplDTO convertMkrMsSrvToCiOrTmpl(MkrMsSrvDO mkrMsSrv) {

		CiOrTmplDTO ciOrTmpl = new CiOrTmplDTO();

		// OrTmplDO orTemplateDO =
		// CiOrdAppUtils.getIOrtmplMDORService().findById(orTplItem.getId_ortmpl());
		// dto.setId_ciortmpl(orTplItem.getId_ciortmpl());//临床医嘱模板主键标识
		// dto.setOrtmplsrvs(orTplItem.getOrtmplsrvs());//医嘱模板项目列表
		ciOrTmpl.setEu_orsrcmdtp(this.eu_orsrcmdtp);// 临床医嘱来源类型
		ciOrTmpl.setId_orsrc_main(mkrMsSrv.getId_ms());// 来源ID_主 组套定义id
		ciOrTmpl.setId_orsrc_sub(mkrMsSrv.getId_mssrv());// 来源ID_子 组套医疗服务id
		// dto.setId_orsrc_gs(orTplItem.getId_orsrc_gs());//来源ID_孙
		// ciOrTmpl.setCode(mkrMsSrv.getCode_srv());// 编码
		ciOrTmpl.setName(mkrMsSrv.getSrv_name());// 服务名称
		ciOrTmpl.setId_srvtp(mkrMsSrv.getId_srvtp());// 医嘱类型
		ciOrTmpl.setSd_srvtp(mkrMsSrv.getSd_srvtp());// 医嘱类型编码

		// 设置长期临时状态
		if (mkrMsSrv.getFg_long() == FBoolean.TRUE) {
			ciOrTmpl.setEu_long(LongTempOrEnum.LONGOR);// 长期
		} else if (mkrMsSrv.getFg_long() == FBoolean.FALSE) {
			ciOrTmpl.setEu_long(LongTempOrEnum.TEMPORARYOR);// 临时
		} else {
			ciOrTmpl.setEu_long(LongTempOrEnum.LONGTMPNULLOR);// 不关注长临状态设置为空
		}

		ciOrTmpl.setId_freq(mkrMsSrv.getId_freq());// 医嘱频次
		ciOrTmpl.setId_route(mkrMsSrv.getId_route());// 用法
		// ciOrTmpl.setId_routedes(mkrMsSrv.getId_routedes());// 用法要求
		// ciOrTmpl.setId_boil(mkrMsSrv.getId_boil());// 煎法
		// ciOrTmpl.setId_boildes(mkrMsSrv.getId_boildes());// 煎法要求
		// dto.setFg_boil(orTemplateDO.getfg);//代煎标识
		ciOrTmpl.setDays_or(mkrMsSrv.getDays_or());// 医嘱天数
		// ciOrTmpl.setOrders(orTemplateDO.getOrders());// 医嘱付数
		// dto.setTimes(orTemplateDO.getTimes());//医嘱次数
		// dto.setDes_or(orTemplateDO.getDes_or());//医嘱描述
		ciOrTmpl.setId_srv(mkrMsSrv.getId_srv());
		ciOrTmpl.setFg_set(mkrMsSrv.getFg_set());
		return ciOrTmpl;
	}

	/**
	 * 组套中医疗服务转医嘱服务项目
	 * 
	 * @param aggDTO
	 * @param orTplItem
	 */
	private CiOrTmplSrvDTO convertMkrMsSrvToCiOrTmplSrv(MkrMsSrvDO mkrMsSrv) throws BizException {

		CiOrTmplSrvDTO srvDTO = new CiOrTmplSrvDTO();
		// srvDTO.setId_ciortmplsrv(orTplItem.getId_ciortmplsrv());//临床医嘱模板项目主键标识
		// srvDTO.setId_ciortmpl(orTplItem.getId_ciortmpl());//临床医嘱模板
		// srvDTO.setSortno(mkrMsSrv.getSortno());// 序号
		srvDTO.setId_srv(mkrMsSrv.getId_srv());// 服务
		srvDTO.setFg_selfsrv(FBoolean.FALSE);// 自定义服务标识
		// srvDTO.setName_selfsrv(mkrMsSrv.get);//自定义服务名
		// srvDTO.setFg_set(mkrMsSrv.getFg_set());// 套标识
		srvDTO.setId_srvtp(mkrMsSrv.getId_srvtp());// 服务类型
		srvDTO.setSd_srvtp(mkrMsSrv.getSd_srvtp());// 服务类型编码
		srvDTO.setId_freq(mkrMsSrv.getId_freq());// 频次
		srvDTO.setId_route(mkrMsSrv.getId_route());// 用法
		// srvDTO.setId_routedes(medSrvDO.getId_routedes());// 用法要求默认
		// srvDTO.setId_boil(medSrvDO.getId_boil());// 煎法
		// srvDTO.setId_boildes(medSrvDO.getId_boildes());// 中医要求
		 srvDTO.setId_unit_med(mkrMsSrv.getId_unit());// 医学单位
		 srvDTO.setQuan_med(mkrMsSrv.getQuan_medu());// 医学单位数值

		srvDTO.setQuan_total_medu(mkrMsSrv.getQuan_total_medu());// 服务总量
		// srvDTO.setId_dep_mp(orTplItem.getId_dep_mp());// 执行科室
		// srvDTO.setId_mm(orTplItem.getId_mm());// 关联物品
		// srvDTO.setSrvsetitms(orTplItem.getSrvsetitms());//套内项目集合
		srvDTO.setFg_set(FBoolean.FALSE);
		return srvDTO;
	}
}
