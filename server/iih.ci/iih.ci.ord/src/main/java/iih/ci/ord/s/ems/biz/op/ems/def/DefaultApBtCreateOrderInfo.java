package iih.ci.ord.s.ems.biz.op.ems.def;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.biz.meta.ObjectList;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import xap.mw.core.data.BizException;

/**
 * 默认备血医嘱创建逻辑
 * @author wangqingzhu
 *
 */
public class DefaultApBtCreateOrderInfo extends DefaultBaseCreateOrderInfo {


	@Override
	public OrderPackageInfo[] createOrderPakageInfo(CiEnContextDTO ctx, DefaultCreateParam[] szParam) throws BizException {
		// TODO Auto-generated method stub
		OrderPackageInfo[] szOrderPakageInfo = super.createOrderPakageInfo(ctx, szParam);
		//放回备血申请单信息
		for(OrderPackageInfo info:szOrderPakageInfo){
			ObjectList agglist = new ObjectList();
			agglist.add(assembleOrderBtAggInfp());
			info.setExtInfoList(agglist);
		}
		return szOrderPakageInfo;
	}



	public CiorappbtAggDO assembleOrderBtAggInfp(){
		CiorappbtAggDO aggdo=new CiorappbtAggDO();
		aggdo.setParentDO(assembleOrderBtInfo());
		return aggdo;
	}

	public OrdApBtDO assembleOrderBtInfo(){
		OrdApBtDO ordbt=new OrdApBtDO();
		//		ordbt.setid_apbt();//备血申请
		//		ordbt.setid_or();//医嘱
		//		ordbt.setid_di();//临床诊断
		//		ordbt.setstr_id_diitm();//临床诊断明细	
		//		ordbt.setstr_code_di();//诊断编码拼接	
		//		ordbt.setstr_name_di();//诊断名称拼接	
		//		ordbt.setno_applyform();//输血申请单号	
		//		ordbt.setpregnant_num();//孕几胎
		//		ordbt.setparturition_cnt();//生产数量	
		//		ordbt.setid_his_bt();//输血史标识	
		//		ordbt.setsd_his_bt();//输血史标识编码	
		//		ordbt.setid_pps_bt();//输血目的
		//		ordbt.setsd_pps_bt();//输血目的编码	
		//		ordbt.setdes_pps_bt();//输血目的描述	
		//		ordbt.setfg_db();//献血史标识
		//		ordbt.setNo_db();//献血证号
		//		ordbt.setId_labitmexplain();//输血前监测项目说明	
		//		ordbt.setSd_labitmexplain();//输血前监测项目说明编码	
		//		ordbt.setId_demandsu_bt();//输血需求状态	
		//		ordbt.setSd_demandsu_bt();//输血需求状态编码
		//		ordbt.setId_mode_bt();//预定输血方式
		//		ordbt.setSd_mode_bt();//预定输血方式编码	
		//		ordbt.setApbtobsindexs();//观察指标集合	
		//		ordbt.setNum_margin_bu();//可用于血量
		//		ordbt.setDt_bt_pl();//计划输血日期	
		ordbt.setSd_su_bt(ICiDictCodeConst.ID_CI_BT_YSQ);//备血申请状态	
		ordbt.setId_su_bt(ICiDictCodeConst.SD_CI_BT_YSQ);//备血申请状态编码	
		//		ordbt.setFg_rpt();//报告标志	
		//		ordbt.setName_diag();//诊断名称
		//		ordbt.setFg_prn();//打印标识	
		//		ordbt.setCnt_prn();//打印次数
		//		ordbt.setId_diitm();//诊断id明细
		return ordbt;
	}

}
