using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Windows.Forms.VisualStyles;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ordsrvmm.d;
using iih.ci.ord.ciorder.viewmodel;
using iih.bd.srv.medsrv.d;
using xap.cli.context;

using iih.bd.bc.udi;
using iih.ci.ord.cior.d;
using xap.mw.core.data;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.ci.ord.ems.d;
using iih.ci.ord.i;
using iih.en.pv.dto.d;
using xap.rui.appfw;

using xap.rui.control.extentions;
using iih.en.pv.pativisit.d;
using xap.mw.serviceframework;
using iih.bd.srv.medsrv.i;
using xap.rui.engine;
using xap.sys.orgfw.dept.d;
using xap.sys.orgfw.dept.i;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciorder.utils {
    /// <summary>
    /// 对数据dto, DO,之间互相转换
    /// zhou_zhijian 7.3做阅读注释
    /// </summary>
    public class OrDataBing {

        #region 成员变量
        /// <summary>
        /// 切换患者时候 赋值
        /// </summary>
        public Ent4BannerDTO patDo = new Ent4BannerDTO();
        /// <summary>
        /// 
        /// </summary>
        private OrderCardViewModel viewModel = new OrderCardViewModel();
        /// <summary>
        /// 
        /// </summary>
        private GetDeptMpImp GetDeptMpImp = new GetDeptMpImp();
        /// <summary>
        /// 
        /// </summary>
        LogicEx cof = LogicEx.GetInstance(); 
        #endregion

        #region 编辑时 数据绑定
        /// <summary>
        /// Heads the data bing.
        /// </summary>
        /// <param name="headDo">The head do.</param>
        /// <param name="agg">The aggregate.</param>
        /// Author:admin
        /// Date:2015-09-01
        internal void EditHeadDataBing(EmsUIDTO headDo, CiorderAggDO agg) {
            headDo.MedSrvDO.Sd_srvtp = agg.getParentDO().Sd_srvtp;//服务类型编码
            headDo.MedSrvDO.Name = agg.getParentDO().Des_or;//医嘱名称
            //headDo.Id_en = agg.getParentDO().Id_en;//就诊
            //headDo.Dt_end_ui = agg.getParentDO().Dt_stop;
            //headDo.Dt_begin_ui = agg.getParentDO().Dt_sign;
            //headDo.Id_wg_or = agg.getParentDO().Id_org_or;//医疗组
            //headDo.Dt_begin_ui = agg.getParentDO().Dt_effe;//开始日期
            //headDo.Dt_end_ui = agg.getParentDO().Dt_stop;//结束日期
            headDo.MedSrvDO.Id_freq = agg.getParentDO().Id_freq;//频次
            headDo.MedSrvDO.Id_route = agg.getParentDO().Id_route;//用法
            //headDo.Name_route = agg.getParentDO().Route_name;//用法名称
            //headDo.Id_routedes = agg.getParentDO().Id_routedes;//用法要求
            //headDo.Name_routedes = agg.getParentDO().Routedes_name;//用法要求描述
            //headDo.Id_boildes = agg.getParentDO().Id_routedes;//煎法要求
            //headDo.Id_boil = agg.getParentDO().Id_route;//煎法
            //headDo.Name_boil = agg.getParentDO().Boil_name;//煎法
            //headDo.Name_routedes = agg.getParentDO().Routedes_name;//用法要求
            //headDo.Name_emp_phy = agg.getParentDO().Emp_phy_name;//开立医生姓名
            //headDo.Name_dep_phy = agg.getParentDO().Dept_or_name;//开立科室名称

            if (agg.getOrdSrvDO() != null && agg.getOrdSrvDO() != null) {
                OrdSrvDO order = agg.getOrdSrvDO()[0];
                //  headDo.Code_entp = order.Code_entp;//就诊类型编码
                headDo.MedSrvDO.Id_srvtp = order.Id_srvtp;//	服务类型
                headDo.MedSrvDO.Id_route = order.Id_route;//用法
                //headDo.Id_routedes = order.Id_routedes;//用法要求
                // headDo.Id_pat = order.Id_pat;//患者
                headDo.MedSrvDO.Id_freq = order.Id_freq;//医嘱频次
                //headDo.Id_en = order.Id_en;//就诊
                //headDo.Id_entp = order.Id_entp;//就诊类型
                //headDo.Id_or = order.Id_or;//医嘱
                //headDo.Id_wg_or = order.Id_wg_or;//医生医疗组
                //headDo.Id_dep_phy = o;//开立科室
                //headDo.Id_emp_phy = order.Id_emp_srv;//服务项目开立医生
                headDo.MedSrvDO.Name = order.Name;//服务项目名称
                headDo.MedSrvDO.Id_srv = order.Id_srv;////服务项目
                //headDo.Name_boil = order.Boil_name;//煎法
                //headDo.Name_boildes = order.Boildes_name;//煎法要求
                //headDo.Name_route = order.Route_name;//用法
                //headDo.Name_routedes = order.Routedes_name;//用法要求
            }
        }

        #region 编辑时 药品数据绑定

        /// <summary>
        /// Drugs the data bing.
        /// </summary>
        /// <param name="headDo">The head do.</param>
        /// <param name="agg">The aggregate.</param>
        /// Author:admin
        /// Date:2015-09-01
        internal void EditDrugDataBing(EmsUIDTO headDo, CiorderAggDO agg) {
            headDo.Emsdrugs.Dt_begin_ui = agg.getParentDO().Dt_effe;//开始日期
            headDo.Emsdrugs.Dt_end_ui = agg.getParentDO().Dt_stop;//结束日期
            headDo.Emsdrugs.Use_days = (headDo.Emsdrugs.Dt_begin_ui != null && headDo.Emsdrugs.Dt_end_ui != null) ? (headDo.Emsdrugs.Dt_end_ui.Value - headDo.Emsdrugs.Dt_begin_ui.Value).Days : 0;
            headDo.Emsdrugs.Id_freq = agg.getParentDO().Id_freq;//频次
            headDo.Emsdrugs.Name_freq = agg.getParentDO().Freq_name;
            headDo.Emsdrugs.Id_route = agg.getParentDO().Id_route;//用法
            headDo.Emsdrugs.Id_routedes = agg.getParentDO().Id_routedes;//用法要求
            headDo.Emsdrugs.Fg_bl = agg.getParentDO().Fg_boil;//代煎标识
            headDo.Emsdrugs.Name_boil = agg.getParentDO().Boil_name;//煎法
            headDo.Emsdrugs.Orders_boil = agg.getParentDO().Orders_boil;//代煎付数
            headDo.Emsdrugs.Orders = agg.getParentDO().Orders;

            headDo.Emsdrugs.Name_boildes = agg.getParentDO().Boildes_name;//煎法要求
            //headDo.Emsdrugs.Name_dep = agg.getParentDO();// TODO: 执行科室名称
            headDo.Emsdrugs.Name_freq = agg.getParentDO().Freq_name;//医嘱频次名称
            headDo.Emsdrugs.Name_route = agg.getParentDO().Route_name;//用法
            headDo.Emsdrugs.Name_routedes = agg.getParentDO().Routedes_name;//用法要求
            headDo.Emsdrugs.Name_srv = agg.getParentDO().Des_or;//医疗服务名称
            headDo.Emsdrugs.Fg_long = agg.getParentDO().Fg_long;//长临标识

            OrdSrvDO order = agg.getOrdSrvDO()[0];
            headDo.Emsdrugs.Id_srv = order.Id_srv;
            headDo.Emsdrugs.Id_orsrv = order.Id_orsrv;
            headDo.Emsdrugs.Id_srvtp = order.Id_srvtp;//服务类型
            headDo.Emsdrugs.Id_route = order.Id_route;//用法标识
            headDo.Emsdrugs.Name_route = order.Route_name;//用法
            headDo.Emsdrugs.Id_routedes = order.Id_routedes;//用法要求标识
            headDo.Emsdrugs.Name_routedes = order.Routedes_name;//用法要求
            headDo.Emsdrugs.Id_freq = order.Id_freq;//医嘱频次
            headDo.Emsdrugs.Id_or = order.Id_or;//医嘱
            //headDo.Emsdrugs.Fg_bl = order.;//费用标识

            headDo.Emsdrugs.Fg_self = order.Fg_self;//自备药标识
            headDo.Emsdrugs.Fg_propc = order.Fg_propc;//预防用药标识
            headDo.Emsdrugs.Name_boil = order.Boil_name;//煎法
            headDo.Emsdrugs.Name_boildes = order.Boildes_name;//煎法要求
            headDo.Emsdrugs.Name_dep = order.Dep_name;//执行科室名称
            headDo.Emsdrugs.Name_freq = order.Freq_name;//医嘱频次名称
            headDo.Emsdrugs.Fg_self = order.Fg_self;//自备药标识
            headDo.Emsdrugs.Fg_treat = order.Fg_indic;//治疗用药
            headDo.Emsdrugs.Fg_propc = order.Fg_propc;//预防用药标识
            headDo.Emsdrugs.Fg_dose_anoma = order.Fg_dose_anoma;//变动用药标识
            headDo.Emsdrugs.Quan_med = order.Quan_medu;//剂量
            headDo.Emsdrugs.Id_unit_med = order.Id_medu;
            headDo.Emsdrugs.Name_unit_med = order.Medu_name;//剂量单位
            headDo.Emsdrugs.Fg_pmor = agg.getParentDO().Fg_pmor;//备用医嘱标识
            headDo.Emsdrugs.Bak_des = agg.getParentDO().Des_pmor;//备用医嘱条件
            headDo.Emsdrugs.Dt_fail = agg.getParentDO().Dt_invalid;//备用医嘱失效日期
            headDo.Emsdrugs.Sd_frequnitct = order.Sd_frequnitct;//频次单位
            headDo.Emsdrugs.Freqct = order.Freqct;//频次下 次数
            headDo.Emsdrugs.Note_or = agg.getParentDO().Note_or;

            //变动用药 绑定
            headDo.Emsdrugs.EmsOrDoseDrug = new OrderSrvDoseViewModel().GetDrugDose(order.Id_freq, order.Id_orsrv, order.Id_or);//变动用药
        }
        #endregion  编辑时 药品数据绑定

        #region 编辑时 检查数据绑定
        public void EditObsDataBing(EmsUIDTO headDo, CiEmsDTO dto) {
            FMap map = dto.Orapplysheet;
            OrdApObsDO obsdDO = map["1"] as OrdApObsDO;
            if (obsdDO != null) {
                headDo.Emsapobs.Dt_plan = obsdDO.Dt_plan;
                headDo.Emsapobs.Des_pps = obsdDO.Announcements;
                headDo.Emsapobs.Fg_chk = obsdDO.Fg_urgent;
                headDo.Emsapobs.Fg_urgent = obsdDO.Fg_urgent;
                //headDo.Emsapobs.Fg_mp_bed = obsdDO.f
                headDo.Emsapobs.No_applyobs = obsdDO.No_applyform;
                headDo.Emsapobs.Des_pps = obsdDO.Des_pps;
                headDo.Emsapobs.Des_sympsign = obsdDO.Des_sympsign;
                headDo.Emsapobs.Fg_mp_bed = dto.Fg_mp_bed;
                //诊断信息
                headDo.Emsapobs.Id_di = obsdDO.Id_di;
                headDo.Emsapobs.Name_diag = obsdDO.Name_diag;
                headDo.Emsapobs.Id_diitm = obsdDO.Id_diitm;
                headDo.Emsapobs.Str_code_di = obsdDO.Str_code_di;
                headDo.Emsapobs.Str_name_di = obsdDO.Str_name_di;
                headDo.Emsapobs.Str_id_diitm = obsdDO.Str_id_diitm;

                CiEmsSrvDTO ordersrv = dto.Emssrvs[0] as CiEmsSrvDTO;
                if (ordersrv != null) {
                    headDo.Emsapobs.Name_srv = ordersrv.Name_srv;


                }

            }
            headDo.Emsapobs.Dt_plan = dto.Dt_end;

            if (dto.Emssrvs != null && dto.Emssrvs.Count > 0) {
                XapDataList<EmsObsLap> obslist = new XapDataList<EmsObsLap>();
                foreach (CiEmsSrvDTO srvdto in dto.Emssrvs) {
                    EmsObsLap obs = new EmsObsLap();
                    obs.Announcements = srvdto.Des_srv;
                    obs.Name_body = srvdto.Body_name;
                    obs.Name_srv = srvdto.Name_srv;
                    obs.Name_pos = srvdto.Pos_name;
                    obslist.Add(obs);
                }

                headDo.Emsapobs.EmsOrObsList = obslist;
                //    headDo.Emsapobs.Name_srvtp = agg.getOrdSrvDO()[0].Name;
                //    headDo.Emsapobs.No_applyobs = agg.getOrdApObsDO()[0].No_applyform;
                //    headDo.Emsapobs.Name_srv = agg.getOrdSrvDO()[0].Name;
                //    headDo.Emsapobs.Fg_urgent = agg.getOrdApObsDO()[0].Fg_urgent;
                //    headDo.Emsapobs.Fg_mp_bed = false;
                //    headDo.Emsapobs.Name_di = agg.getOrdApObsDO()[0].Id_di;
                //    headDo.Emsapobs.Des_pps = agg.getOrdApObsDO()[0].Id_pps;
                //    headDo.Emsapobs.Des_sympsign = agg.getOrdApObsDO()[0].Des_sympsign;
                //    headDo.Emsapobs.Dt_plan = agg.getOrdApObsDO()[0].Dt_plan;
                //    //医嘱服务套表  ci_or_srv_set

                //    //XapDataList<EmsObsItemDO> obsList = new XapDataList<EmsObsItemDO>();


                //    headDo.Emsapobs.Name_body = "检查测试";
                //    headDo.Emsapobs.Name_pos = "检查测试";
                //    EmsOrDrug drug = new EmsOrDrug();
                //    drug.Name_mm = "药品";
                //    drug.Spec_mm = "规格";
                //    XapDataList<EmsOrDrug> list = new XapDataList<EmsOrDrug>();
                //    list.Add(drug);
                //    headDo.Emsapobs.EmsOrDrugList = list;
                //    //headDo.Emsapobs.Fg_chk = agg.getOrdApObsDO()[0].Fg_urgent;
                //    //headDo.Emsapobs.Id_di = agg.getOrdApObsDO()[0].Id_di;
                //    //headDo.Emsapobs.Id_obstp = agg.getOrdApObsDO()[0].Id_di;
                //    //headDo.Emsapobs.Id_orsrv = agg.getOrdSrvDO()[0].Id_orsrv;
                //    //headDo.Emsapobs.Name_body = agg.getOrdApObsDO()[0].Biopsy;
                //    //headDo.Emsapobs.Name_obstp = agg.getOrdApObsDO()[0].Biopsy;
                //    //headDo.Emsapobs.Name_pos = agg.getOrdApObsDO()[0].Str_name_di;
                //    //headDo.Emsapobs.Name_samptp = agg.getOrdApObsDO()[0].Id_pps;
            }




            //待完善





        }

        #endregion 编辑时 检查数据绑定

        #region 编辑时检验 绑定数据

        public void EditLabDataBing(EmsUIDTO headDo, CiorderAggDO agg) {
            //if (agg.getOrdApLabDO() != null && agg.getOrdApLabDO().Count() > 0)
            //{
            //    headDo.Emsaplab.Name_srv = agg.getOrdSrvDO()[0].Name;
            //    headDo.Emsaplab.Id_di = agg.getOrdApLabDO()[0].Id_ordi;
            //    headDo.Emsaplab.Name_di = agg.getOrdApLabDO()[0].Id_ordi;
            //    headDo.Emsaplab.Name_samptp = agg.getOrdApLabDO()[0].Id_srvca;
            //    headDo.Emsaplab.Fg_urgent = false;
            //    headDo.Emsaplab.Des_sympsign = agg.getOrdApLabDO()[0].Announcements;
            //    headDo.Emsaplab.Sortno = 1;
            //    headDo.Emsaplab.No_applyobs = agg.getOrdApLabDO()[0].No_applyform;
            //    headDo.Emsaplab.Dt_plan = agg.getOrdApLabDO()[0].Dt_plan;

            //    headDo.Emsaplab.Id_emsobs = agg.getOrdApLabDO()[0].Id_pps;
            //    headDo.Emsaplab.Des_sympsign = agg.getOrdApLabDO()[0].Des_sympsign;

            //    headDo.Emsaplab.Id_or = agg.getParentDO().Id_or;
            //    headDo.Emsaplab.Id_orsrv = agg.getOrdSrvDO()[0].Id_orsrv;
            //    headDo.Emsaplab.Id_srv = agg.getOrdSrvDO()[0].Id_srv;
            //    EmsObsItemDO item = new EmsObsItemDO();

            //    FArrayList list = new FArrayList();
            //    list.Add(item);


            //}


        }

        #endregion 编辑时检验 绑定数据

        #region 编辑时 输血数据绑定

        public void EditBtDataBing(EmsUIDTO headDo, CiorderAggDO agg) {
            //OrdSrvDO order = agg.getOrdSrvDO()[0];
            //OrdApBtDO bt = agg.getOrdApBtDO()[0];
            //headDo.Emsapbt.Id_emsbt = bt.Id_apbt;	 //输血医疗单主键	 		 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Id_srv = order.Id_srv;	     //服务id	 			 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Name_srv = order.Name_srv;	 //输血成分(服务名称)	 			 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Id_or = order.Id_or;	     //医嘱id	 		 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Id_orsrv = order.Id_orsrv;	 //医嘱服务id	 			 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Quan_med = order.Quan_medu; // 输血数量(医学单位数值)	SINGLE	FDouble	16	 	 			 	 			 	 	 	
            //headDo.Emsapbt.Id_unit_med = order.Id_medu;	 // 输血数量单位(医学单位)	REF	计量单位	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Name_unit_med = order.Medu_name;	//医学单位名称	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Id_di = bt.Id_di;	        //临床诊断id	REF	医疗服务_疾病诊断定义	20	疾病诊断	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Name_di = bt.Name_di;	        //临床诊断	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.No_applyform = bt.No_applyform;	//输血单号	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Parturition_cnt = bt.Parturition_cnt;	//产数量	SINGLE	Integer	10	 	 				 	 	 	 	 	 				 	 			 	 	 	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Sd_pps = bt.Sd_pps_bt;	         // 输血目的编码	SINGLE	String	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Id_pps = bt.Id_pps_bt;	         // 输血目的id	REF	检验目的_自定义档案	20	检验目的_自定义档案	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Name_pps = bt.Des_pps_bt;     // 输血目的	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Fg_db = bt.Fg_db;       // 献血史标志	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.No_db = bt.No_db;	         // 献血证号	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Id_mode = bt.Id_mode_bt;	         // 预定输血方式id	REF	 	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Name_mode = bt.Name_mode_bt;     // 预定输血方式	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	

            //headDo.Emsapbt.Sd_mode = bt.Sd_mode_bt;	            //预定输血方式sd	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Pregnat_num = bt.Pregnant_num;        //孕几胎	SINGLE	Integer	10	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Id_labitmexplain = bt.Id_labitmexplain;	//输血前检查说明id	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Name_labitmexplain = bt.Name_labitmexplain;	//输血前检查说明	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Sd_labitmexplain = bt.Sd_labitmexplain;	//输血前检测项目说明	REF	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Dt_bt = agg.getParentDO().Dt_effe;   // 输血日期	SINGLE	FDateTime	19	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Id_emp_create = order.Id_emp_srv;	  // 申请医生id	REF	人员基本信息	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Name_emp_create = order.Emp_name;	  // 申请医生	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Dt_create = order.Dt_create;      // 开立时间	SINGLE	FDateTime	19	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Id_bttp = order.Id_srv;          // 血液品种id	REF	血液品种_自定义档案	20	血液品种_自定义档案	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Name_bttp = order.Name_srv;	      // 血液品种	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Sd_bttp = order.Sd_srvtp;          //  血液品种sd	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Id_demandsu = bt.Id_demandsu_bt;	      //   输血需求状态id	REF	 	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Name_demandsu = bt.Name_demandsu_bt;    //	输血需求状态
            //headDo.Emsapbt.Sd_demandsu = bt.Sd_demandsu_bt;     //  输血需求状态sd	SINGLE	String	50	 	 			
            //headDo.Emsapbt.Id_his_bt = bt.Id_his_bt;	//输血史id	REF	String	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Sd_his_bt = bt.Sd_his_bt;	//输血史编码	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Name_his_bt = bt.Name_his_bt;	//输血史	SINGLE	
        }

        #endregion 编辑时 输血数据绑定

        #region 编辑时 手术数据绑定
        public void EditOpDataBing(EmsUIDTO headDo, CiorderAggDO agg) {
            //if (agg != null && agg.getOrdApOpDO() != null && agg.getOrdApOpDO().Count() > 0)
            //{

            //    OrdSrvDO srv = agg.getOrdSrvDO()[0];
            //    OrdApOpDO op = agg.getOrdApOpDO()[0];
            //headDo.Emsapop.Id_emsopitem = op.Id_orop;        //手术申请单主键	SINGLE	String	20	 	
            //headDo.Emsapop.Id_orsrv = srv.Id_orsrv;
            //headDo.Emsapop.Id_or = op.Id_or;	            //医嘱id	SINGLE	String	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Id_srv = srv.Id_srv;              //服务id	REF	医疗服务	20	医疗服务	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Name_srv = srv.Name_srv;           //手术名称	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.No_applyform = op.No_applyform;   //申请单号	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Code_srv = srv.Code_srv;         //手术编码	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Fg_er_sug = op.Fg_er_sug;       //急诊手术	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Fg_xq_sug = op.Fg_xq_sug;        //限期手术	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Fg_zq_sug = op.Fg_zq_sug;        //择期手术	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Dt_plan = op.Dt_plan;	            //计划手术时间	SINGLE	FDateTime	19	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Dt_creat	            //开立日期	SINGLE	FDateTime	19	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Id_di = op.Id_di;           //诊断id	REF	医疗服务_疾病诊断定义	20	疾病诊断	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Name_di = op.Name_di; //诊断	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Id_mp_dep = srv.Id_dep_mp; //执行科室id	REF	部门	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Name_mp_dep = srv.Dep_mp_name;        //执行科室	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Sd_lvlsug = op.Sd_lvlsug;	        //手术分级编码	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Name_lvlsug = op.Name_lvlsug;        //手术分级	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Id_lvlsug = op.Id_lvlsug;	        //手术分级id	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Sd_anestp = op.Sd_anestp;	        //麻醉方式编码	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Name_anestp = op.Name_anestp;     //麻醉方式	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Id_anestp = op.Id_anestp;	        //麻醉方式id	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Fg_allergy = op.Fg_allergy;	        //药物过敏史	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Fg_new_sug = op.Fg_new_sug;	        //是否开展新手术	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Fg_patho = op.Fg_patho;            //手术中冰冻处理	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Quan_bt_plan = op.Quan_bt_paln;	        //预期输血量	SINGLE	FDouble	16	 	 				 	 	 	 	  		 	 			 	 	 	
            //headDo.Emsapop.Time_sup_plan = op.Sugplantime;	    //预期手术时长	SINGLE	Integer	10	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Id_emp_operator = op.Id_emp_operate;  //主刀医师id	REF	人员基本信息	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Name_emp_operator = op.Name_emp_operate;	//主刀医师	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Id_emp_help1 = op.Id_emp_helper;      //一助id	REF	人员基本信息	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Name_emp_help1 = op.Name_emp_helper;    //一助	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Sd_sugbodycod = op.Sd_sugbody;	    //体位编码	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Name_sugbodycod = op.Name_sugbody;	    //体位	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Id_sugbodycod = op.Id_sugbody;	    //体位id	REF	体位编码_自定义档案	20	体位编码_自定义档案	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Specialreq = op.Specialreq;	        //特殊器械	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Specialinstrument = op.Specialinstrument;//特殊仪器	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Specialdes = op.Specialdes;     //特殊准备	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Announcements = op.Announcements; //注意事项	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Sd_su = op.Sd_su_op;           //手术申请状态	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Id_role = op.Id_su_op;  //角色id	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Name_role        //角色	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Id_emp_op	        //人员id	REF	人员基本信息	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Name_emp_op	        //人员名称	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Sv	                //版本号	SINGLE	FDateTime	19	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Sortno	            //排序号
            // }
        }
        /// <summary>
        /// 手术人员
        /// </summary>
        /// <param name="headDo">The head do.</param>
        /// <param name="agg">The aggregate.</param>
        /// Author:admin
        /// Date:2015-11-07
        public void EditOpEmpDataBing(EmsUIDTO headDo, CiorderAggDO agg) {
            //headDo.Emsapop.OpEmpItem.Clear();
            //if (agg.getOrdOpEmpDO() != null)
            //{
            //    OrdOpEmpDO[] emps = agg.getOrdOpEmpDO();
            //    emps.ToList().ForEach(p =>
            //    {
            //        headDo.Emsapop.OpEmpItem.Add(new EmsItemInOp
            //        {
            //            Id_emp_op = p.Id_emp,
            //            Name_emp_op = p.Name_emp,
            //            Id_role = p.Id_role,
            //            Name_role = p.Name_role
            //        });
            //    });
            //}
        }
        /// <summary>
        /// 手术卫材
        /// </summary>
        /// <param name="headDo">The head do.</param>
        /// <param name="agg">The aggregate.</param>
        /// Author:admin
        /// Date:2015-11-07
        public void EditOpMmDataBing(EmsUIDTO headDo, CiorderAggDO agg) {
            //headDo.Emsapop.OpMmItem.Clear();
            //if (agg.getOrdOpMmDO() != null)
            //{
            //    OrdOpMmDO[] mms = agg.getOrdOpMmDO();
            //    mms.ToList().ForEach(p =>
            //    {
            //        headDo.Emsapop.OpMmItem.Add(new EmsItemInOp
            //        {

            //            Id_oropitem = p.Id_apopmm,	       //主键	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 	 
            //            Id_mm = p.Id_mm,	           //物品id	REF	医疗物品_基本信息	20	医疗 	 	
            //            Name_mm = p.Name_mm,	           //物品名称	SINGLE	String	50	 	 	 
            //            Id_mmtp = p.Id_mmtp,	           //物品类型id	REF	医疗物品类型_自定义档案	 	 			 	 	 	
            //            Sd_mmtp = p.Sd_mmtp,	           //物品类型编码	SINGLE	String	50	 	 	
            //            Name_mmtp = p.Name_mmtp,	       //物品类型	SINGLE	String	50	 	 	 
            //            Spec = p.Spec,	           //规格	SINGLE	String	50	 	 	 
            //            Id_sup = p.Id_sup,	           //厂商id	REF	医疗物品_供应商与厂商	20	 	 	 	 	
            //            Name_sup = p.Name_sug,	       //厂商	SINGLE	String	50	 	 	 
            //            Price = p.Price,	           //单价	SINGLE	FDouble	16	 	 	 
            //            Quan_cur = p.Quan_cur,	       //数量	SINGLE	Integer	10	 	 	 
            //            Id_unit_pkgsp = p.Id_unit_pkgsp,	   //零售包装单位id	REF	医疗物品_包装单位类 	 	 	 	
            //            Name_unit_pkgsp = p.Name_mmpkguname	   //零售包装单位	SINGLE	String	50	 	 	
            //            //Sortno	           //排序	SINGLE	Integer	10	 	 	 
            //            //Code_srv	       //手术 编码(code_srv)	SINGLE	String	 	 	 	
            //            //Id_srv	           //手术id（id_srv）	REF	医疗服务	20	医疗 	 	
            //            //Name_srv	       //手术名称	SINGLE	String	50	 	 	 
            //            //Des_op	           //手术描述



            //        });
            //    });
            //}
        }


        /// <summary>
        /// 附加手术
        /// </summary>
        /// <param name="headDo">The head do.</param>
        /// <param name="agg">The aggregate.</param>
        /// Author:admin
        /// Date:2015-11-07
        public void EditOpAppendOpDataBing(EmsUIDTO headDo, CiorderAggDO agg) {
            headDo.Emsapop.OpAppendOpItem.Clear();
            OrdSrvDO[] srvs = agg.getOrdSrvDO();
            List<OrdSrvDO> appendOp = srvs.Where(p => p.Fg_or == false).ToList();
            appendOp.ForEach(p => {

                headDo.Emsapop.OpAppendOpItem.Add(new EmsItemInOp {
                    Id_oropitem = p.Id_orsrv,
                    Sortno = p.Sortno,	           //排序	SINGLE	Integer	10	 	 	 
                    Code_srv = p.Code_srv,	       //手术 编码(code_srv)	SINGLE	String	 	 	
                    Id_srv = p.Id_srv,           //手术id（id_srv）	REF	医疗服务	20	医疗 	
                    Name_srv = p.Name_srv,	       //手术名称	SINGLE	String	50	 	 	 
                    Des_op = p.Note_srv	           //手术描述
                });
            });

        }

        #endregion 编辑时 手术数据绑定

        #region 编辑时 会诊数据绑定
        public void EditConsDataBing(EmsUIDTO headDo, CiorderAggDO agg) {

            OrdSrvDO srv = agg.getOrdSrvDO()[0];
            OrdApConsDO cons = new OrdApConsDO();
            //if (agg.getOrdApConsDO() != null)
            //{
            //    cons = agg.getOrdApConsDO()[0];
            //}
            headDo.Emsapcons.Id_emsconsitem = cons.Id_apcons;	//主键	SINGLE	String	50	  
            headDo.Emsapcons.Id_or = cons.Id_or;      //医嘱id	SINGLE	String	50
            headDo.Emsapcons.Id_srv = srv.Id_srv;
            headDo.Emsapcons.Id_orsrv = srv.Id_orsrv;
            headDo.Emsapcons.Fg_urgent = cons.Fg_urgent;    //加急标识	SINGLE	FBoolean  
            headDo.Emsapcons.Dt_plan = cons.Dt_plan;     	//计划会诊时间	SINGLE	FDateTime 
            headDo.Emsapcons.Tel = cons.Tel;      	//联系电话	SINGLE	String	2 
            //headDo.Emsapcons.Id_place = cons.Id_place;   //申请地点id	REF	地点	20	 	  
            headDo.Emsapcons.Name_place = cons.Place;    //申请地点名称	SINGLE	String	5 
            headDo.Emsapcons.Des_emr = cons.Des_emr;        //  病理摘要	SINGLE	备注	300	  
            headDo.Emsapcons.Des_psp = cons.Des_psp;        //会诊目的	SINGLE	备注	300	  
            headDo.Emsapcons.Id_dep_cons = srv.Id_dep_srv;	    // 申请科室id	REF	部门	20	 	  
            headDo.Emsapcons.Name_dep_cons = srv.Dep_name;	//申请科室	SINGLE	String	5 
            headDo.Emsapcons.Dt_creat = srv.Dt_create;	    //申请时间	SINGLE	FDateTime 
            headDo.Emsapcons.Id_emp_cons = srv.Id_emp_srv;	    //申请人id	REF	用户	20	 	  
            headDo.Emsapcons.Name_emp_cons = srv.Emp_name; //申请人	SINGLE	String

        }
        #endregion 编辑时 会诊数据绑定

        #region 编辑时 受邀科室数据绑定
        public void EditIvnteConsDataBing(EmsItemInCons dto, CiordInviteConsDO cons) {
            dto.Id_emsitemincons = cons.Id_invitecons;	//主键	SING  	 	 	
            //dto.Sortno	         =cons.s   //排序号	SING  	 	 	
            dto.Id_org = cons.Id_org;  //受邀机构id	  	 	
            dto.Name_org = cons.Name_org; //受邀机构	 	 	 	 	
            dto.Id_dep_emp = cons.Id_dep;   //受邀科室id	  	 	
            dto.Name_dep_emp = cons.Name_dep;   //受邀科室	 	 	 	 	
            dto.Sd_emp_title = cons.Sd_emp_title;   //受邀职称编码	 	 	 	 	
            dto.Id_emp_title = cons.Id_emp_title;   //受邀职称id	 			 	 			 	 	 	
            dto.Name_emp_title = cons.Name_emp_title;   //受邀职称	 	 	 	 	
            dto.Id_emp_doctor = cons.Id_emp;   //受邀人id	  	 	
            dto.Name_emp_doctor = cons.Name_emp;   //受邀人	SING  	 	 	
            dto.Dt_response = cons.Dt_response;   //应答时间	 		 	 	 	
            dto.Fg_response = cons.Fg_response;   //应答标志	 		 	 	 	
            dto.Id_emp_response = cons.Id_emp_response;   //应答人id	  	 	
            dto.Name_emp_response = cons.Name_emp_respon;	//应答人	SING  	 	 	
            //dto.Id_srv	         =cons.;   //会诊项目id	 	 	 	 	
            //dto.Name_srv	     =cons.;   //会诊项目	 	 	 	 	
            //dto.Sd_constp	     =cons.;   //会诊类型编码	 	 	 	 	
            //dto.Id_constp	     =cons.;   //会诊类型id	 	 	 			 	 	 	
            //dto.Name_constp	     =cons.;   //会诊类型	 	 	 	 	
            dto.Sv = cons.Sv;   //版本号	     
        }
        #endregion 编辑时 受邀科室数据绑定

        #region 编辑时 转科申请单数据绑定

        public void EditTransDataBing(EmsUIDTO headDo, CiorderAggDO agg) {
            //OrdSrvDO srv = agg.getOrdSrvDO()[0];
            //OrdApTransDO trans = agg.getOrdApTransDO()[0];
            //headDo.Emsaptrans.Id_emsaptrans = trans.Id_ortrans;	//主键	SINGLE	String	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsaptrans.Id_or = srv.Id_or;	        // displaynam8	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsaptrans.Id_orsrv = srv.Id_orsrv;	        //displaynam9	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsaptrans.Fg_tech_trans = trans.Fg_tech_trans;	//转科/跨科	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsaptrans.Id_dep_to = trans.Id_dep_to;	    //目标科室id	REF	部门	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsaptrans.Name_dep_to = trans.Name_dep_to;    //目标科室	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsaptrans.Name_dep_nur_to = trans.Name_dep_nur_to;	 //目标病区	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsaptrans.Id_dep_nur_to = trans.Id_dep_nur_to;	 //目标病区id	REF	部门	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsaptrans.Des_rea_canc = trans.Des_rea_canc;     //转科原因	SINGLE
        }
        #endregion 编辑时 转科申请单数据绑定

        #region 编辑时 出院申请单数据绑定
        public void EditOutDataBing(EmsUIDTO headDo, CiorderAggDO agg) {
            OrdSrvDO srv = agg.getOrdSrvDO()[0];
            //OrdApOutDO apout = agg.getOrdApOutDO()[0];
            //headDo.Emsapout.Id_emsapout = apout.Id_orout;	//主键	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapout.Id_or = srv.Id_or;      	//displaynam14	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapout.Id_orsrv = srv.Id_orsrv;   	//displaynam15	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapout.Id_dep_out = apout.Id_dep_out;	//出院科室id	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapout.Name_dep_out = apout.Name_dep_out;	//出院科室	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapout.Id_dep_nur_out = apout.Id_dep_nur_out;	//出院病区id	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapout.Name_dep_nur_out = apout.Name_dep_nur_out;	//出院病区	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapout.Id_bed_out = apout.Id_bed_out;	//出院床位id	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapout.Name_bde_out = apout.Name_bed_out;	//出院床位	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapout.Fg_again31 = apout.Fg_again31;	//31日再入院计划	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapout.Des_again31 = apout.Des_again31;	//31日再入院目的	SINGLE	备注	300	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapout.Id_outtp = apout.Id_outtp;	//离院方式id	REF	离院方式_自定义档案	20	离院方式_自定义档案	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapout.Sd_outtp = apout.Sd_outtp;	//离院方式编码	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapout.Name_outtp = apout.Name_outtp;	//离院方式	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapout.Des_outtp = apout.Des_outtp;	//离院描述	SINGLE
        }
        #endregion 编辑时 出院申请单数据绑定

        #endregion  编辑时 数据绑定

        #region 新增时 数据绑定
        #region 新增时 head数据绑定
        /// <summary>
        /// Adds the data bing.
        /// </summary>
        /// <param name="headDo">The head do.</param>
        /// <param name="med">The med.</param>
        /// Author:admin
        /// Date:2015-09-21
        public void AddCommonHeadDataBing(EmsUIDTO headDo, MedSrvDO med) {
            //medSrv = med;
            //headDo.Id_pat = patDo.Id_pat;
            //headDo.Id_en = patDo.Id_ent;
            //headDo.Id_entp = patDo.Id_entp;//TODO:患者信息不全就诊类型
            //headDo.Code_entp = patDo.Code_entp;// "10";//TODO就诊类型编码
            //headDo.MedSrvDO.Name = med.Name;//服务项目名称
            //headDo.MedSrvDO.Id_srvtp = med.Id_srvtp;//服务项目类型id
            //headDo.MedSrvDO.Sd_srvtp = med.Sd_srvtp;//服务项目类型sd
            //headDo.MedSrvDO.Id_freq = med.Id_freq;//频次
            //headDo.MedSrvDO.Freq_name = med.Freq_name;
            //headDo.MedSrvDO.Id_route = med.Id_route;//用法
            //headDo.Name_route = med.Route_name;
            //headDo.Id_routedes = med.Id_routedes;//用法要求
            //headDo.Name_routedes = med.Routedes_name;
            //headDo.MedSrvDO.Id_srv = med.Id_srv;//服务项目id
            //headDo.MedSrvDO.Code = med.Code;
            //headDo.Id_dep_phy = " ";// UserManager.getInstance().CurrentDept.Id_dep;//开立科室
            //headDo.Id_emp_phy = UserManager.getInstance().CurrentUser.Id_user;//开立用户
            //headDo.Name_emp_phy = UserManager.getInstance().CurrentUser.Name;//开立医生姓名
            //headDo.Name_dep_phy = UserManager.getInstance().CurrentDept.Name;//开立科室名称
            //headDo.Id_en = patDo.Id_ent;   //就诊类型编码  //TODO: 就诊信息拿过来时候再加上
            //headDo.Id_entp = patDo.Id_ent; // 就诊类型
            //headDo.Id_pat = patDo.Id_pat;//患者号
            //headDo.Dt_begin_ui = CommonExtentions.NowTime(this);//.NowTime(); 
            //headDo.MedSrvDO.Id_srvca = med.Id_srvca;
            //headDo.MedSrvDO.Id_srvtp = med.Id_srvtp;

            //headDo.MedSrvDO.Pri = med.Pri;
            //headDo.MedSrvDO.Eu_blmd = med.Eu_blmd;

            //headDo.Quan_medu = med.Quan_med;
            //headDo.Id_medu = med.Id_unit_med;
            //headDo.Fg_set = med.Fg_set;

        }
        #endregion 新增时 head数据绑定

        #region   修改时 备血绑定
        public void editApbtDataBiding(EmsUIDTO emsDO, CiEmsDTO dto) {
            FMap map = dto.Orapplysheet;
            Object obj = map["7"];
            CiorappbtAggDO aggdo = obj as CiorappbtAggDO;
            OrdApBtDO bt = aggdo.getParentDO();
            FArrayList li = dto.Emssrvs;
            CiEmsSrvDTO srvDto = null;
            //通过服务类型查找备血医嘱的主医嘱项目
            foreach (CiEmsSrvDTO ciems in li) {
                //if (ciems.Sd_srvtp != null && ciems.Sd_srvtp == BdSrvDictCodeConst.SD_SRVTP_BLOODPROD_BLOODPROD_READYBLOOD)
                if (ciems.Eu_sourcemd != null && ciems.Eu_sourcemd == (int)OrSrvSourceFromEnum.PHYSIAN && ciems.Sd_srvtp == BdSrvDictCodeConst.SD_SRVTP_BLOODPROD_BLOODPROD_READYBLOOD && ciems.Fg_set != FBoolean.True)
                {
                    srvDto = ciems;
                    break;
                }
            }
            emsDO.Emsapbt.Id_emsbt = bt.Id_apbt;	 //输血医疗单主键 	
 	 	 	//调整为从服务项目中取值 zwq  2016-08-19			 	 			 	 	 	
            //emsDO.Emsapbt.Id_srv = dto.Id_srv;	     //服务id	 			 	 	 	 	 	 				 	 			 	 	 	
            //emsDO.Emsapbt.Name_srv = dto.Name;	 //输血成分(服务名称)	 			 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.Id_or = bt.Id_or;	     //医嘱id
            if (srvDto != null) {
                //调整为从服务项目中取值 zwq  2016-08-19
                emsDO.Emsapbt.Id_srv = srvDto.Id_srv;	     //服务id	 			 	 	 	 	 	 				 	 			 	 	 	
                emsDO.Emsapbt.Name_srv = srvDto.Name_srv;	 //输血成分(服务名称)	
                emsDO.Emsapbt.Quan_med = srvDto.Quan_med; // 输血数量(医学单位数值)	SINGLE	FDouble	16	 
                emsDO.Emsapbt.Id_orsrv = srvDto.Id_orsrv;	 //医嘱服务id	 
                emsDO.Emsapbt.Id_unit_med = srvDto.Id_unit_med;
                emsDO.Emsapbt.Name_unit_med = srvDto.Name_unit_med;
                emsDO.Emsapbt.Dt_create = srvDto.Dt_create_srv;//申请日期
                emsDO.Emsapbt.Id_mp_dep = srvDto.Id_dep;
                emsDO.Emsapbt.Name_mp_dep = srvDto.Name_dep;
            }
            // 输血数量单位(医学单位)	REF	计量单位	20	 				 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.Id_di = bt.Id_di;	        //临床诊断id	REF	医疗服务_疾病诊断定义	20	疾病诊断	 				 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.Name_diag = bt.Name_diag;	        //临床诊断	SINGLE	String	50
            emsDO.Emsapbt.Id_diitm = bt.Id_diitm;
            //诊断信息
            string[] diagArray = new GetPatDiagImp().getDiagArray(emsDO.PatInfo.Id_ent);
            if (diagArray != null)
            {
                emsDO.Emsapbt.Str_code_di = diagArray[1];//诊断编码拼接
                emsDO.Emsapbt.Str_name_di = diagArray[0];//诊断名称拼接
                emsDO.Emsapbt.Str_id_diitm = diagArray[2];//诊断子项目id拼接
            } 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.No_applyform = bt.No_applyform;	//输血单号	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.Parturition_cnt = bt.Parturition_cnt;	//产数量	SINGLE	Integer	10	 	 				 	 	 	 	 	 				 	 			 	 	 	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.Sd_pps = bt.Sd_pps_bt;	         // 输血目的编码	SINGLE	String	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.Id_pps = bt.Id_pps_bt;	         // 输血目的id	REF	检验目的_自定义档案	20	检验目的_自定义档案	 				 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.Name_pps = bt.Name_pps_bt;     // 输血目的	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.Fg_db = bt.Fg_db;       // 献血史标志	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.No_db = bt.No_db;	         // 献血证号	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.Id_mode = bt.Id_mode_bt;	         // 预定输血方式id	REF	 	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.Name_mode = bt.Name_mode_bt;     // 预定输血方式	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	

            emsDO.Emsapbt.Sd_mode = bt.Sd_mode_bt;	            //预定输血方式sd	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.Pregnat_num = bt.Pregnant_num;        //孕几胎	SINGLE	Integer	10	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.Id_labitmexplain = bt.Id_labitmexplain;	//输血前检查说明id	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.Name_labitmexplain = bt.Name_labitmexplain;	//输血前检查说明	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.Sd_labitmexplain = bt.Sd_labitmexplain;	//输血前检测项目说明	REF	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.Dt_bt = Convert.ToDateTime(bt.Dt_bt_pl);   // 输血日期	SINGLE	FDateTime	19	 
            emsDO.Dt_begin_ui = Convert.ToDateTime(bt.Dt_bt_pl);	 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.Id_emp_create = dto.Id_emp_phy;	  // 申请医生id	REF	人员基本信息	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.Name_emp_create = dto.Name_emp_phy;	  // 申请医生	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.Id_demandsu = bt.Id_demandsu_bt;	      //   输血需求状态id	REF	 	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.Name_demandsu = bt.Name_demandsu_bt;    //	输血需求状态
            emsDO.Emsapbt.Sd_demandsu = bt.Sd_demandsu_bt;     //  输血需求状态sd	SINGLE	String	50	 	 			
            emsDO.Emsapbt.Id_his_bt = bt.Id_his_bt;	//输血史id	REF	String	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.Sd_his_bt = bt.Sd_his_bt;	//输血史编码	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsDO.Emsapbt.Name_his_bt = bt.Name_his_bt;	//输血史	SINGLE\
            emsDO.Emsapbt.Dt_begin_ui = dto.Dt_begin;
            emsDO.Emsapbt.Dt_end_ui = dto.Dt_end;
            emsDO.Emsapbt.Use_days = dto.Days_or;
            emsDO.Emsapbt.Times_cur = dto.Times_cur;
            emsDO.Emsapbt.Times_mp_in = dto.Times_mp_in;

            OrdApBtViewItemDO[] arr = aggdo.getOrdApBtViewItemDO();
            if (arr != null)
            {
            foreach (OrdApBtViewItemDO item in arr) {
                emsDO.Emsapbt.BtLabItem.Add(
                    new OrdApSugViewItemDO() {
                        Val_rstrptla = item.Val_rstrptla == null ? "" : item.Val_rstrptla,
                        Val_restrptlab = item.Val_restrptlab == null ? "" : item.Val_restrptlab.Replace(',', '|'),
                        Sd_restrptlabtp = item.Sd_restrptlabtp,
                        Name_srv = item.Name_srv == null ? "" : item.Name_srv,
                        Name_unit = item.Name_unit == null ? "" : item.Name_unit,
                        Id_unit = item.Id_unit,
                        Id_srv = item.Id_srv,
                        Id_apopobsindex = item.Id_apbtobsindex
                    }
                    );
            }
           }
        }
        #endregion 修改时 备血绑定

        #region 新增时 药品绑定
        public void AddDrugDataBing(EmsUIDTO headDo, MedSrvDO med) {
            //把一些能带过来的数据绑定到药品表单
            //配置获取开始时间,
            headDo.Emsdrugs.Dt_begin_ui = headDo.Emsdrugs.Dt_begin_ui==null?this.NowTime():headDo.Emsdrugs.Dt_begin_ui;//门诊在多药品时，该方法可能会被调用多次，当时间不为空时，不用再赋值了
            //执行科室
            //cof.GetDept_Mp(headDo);//暂时没有提供 就诊类型  后面提供了再用
            //药品总量//在 表单里获取
            //药品总量单位
            //cof.GetDrugTotalUnit(headDo);
            if (UserManager.getInstance().CurrentOrg == null) {
                this.ShowInfo("UserManager.getInstance().CurrentOrg =" + UserManager.getInstance().CurrentOrg);
            }
            headDo.Emsdrugs.Id_org = UserManager.getInstance().CurrentOrg.Id_org;

            //headDo.Emsdrugs.Dt_end_ui = ;

            headDo.Emsdrugs.Id_srv = med.Id_srv;//服务项目id
            headDo.Emsdrugs.Name_srv = med.Name;//服务项目名称
            headDo.Emsdrugs.Id_srvtp = med.Id_srvtp;//服务项目类型id
            headDo.Emsdrugs.Sd_srvtp = med.Sd_srvtp;//服务项目类型sd
            headDo.Emsdrugs.Id_freq = med.Id_freq;//频次
            headDo.Emsdrugs.Name_freq = med.Freq_name;
            headDo.Emsdrugs.Freqct = med.Freqct;
            headDo.Emsdrugs.Sd_frequnitct = med.Sd_frequnitct;
            if (med.Id_route != null && !string.IsNullOrEmpty(med.Route_name) && med.Route_name != "null") {
                headDo.Emsdrugs.Id_route = med.Id_route;//用法
                headDo.Emsdrugs.Name_route = med.Route_name;
            }
            if (med.Id_routedes != null && !string.IsNullOrEmpty(med.Routedes_name)  && med.Routedes_name != "null") {
                headDo.Emsdrugs.Id_routedes = med.Id_routedes;//用法要求
                headDo.Emsdrugs.Name_routedes = med.Routedes_name;
            }
            headDo.Emsdrugs.Name_unit_med = med.Med_name;//TODO: 暂时找不到
            headDo.Emsdrugs.Id_unit_med = med.Id_unit_med;
            //headDo.Emsdrugs.First_freq = "2";//首次执行
            //headDo.Emsdrugs.First_time = "12:00;14:00";//首次执行时刻
            // headDo.Emsdrugs.Fg_skintest = false;
            headDo.Emsdrugs.Fg_mm = med.Fg_mm;
            headDo.Emsdrugs.Quan_med = med.Quan_med;
            headDo.Emsdrugs.Fg_long = med.Fg_long;
            if (med.Sd_srvtp.StartsWith("0103")) {
                headDo.Emsdrugs.Name_boil = med.Boil_name;
                headDo.Emsdrugs.Id_boil = med.Id_boil;
                headDo.Emsdrugs.Orders = 1;
                headDo.Emsdrugs.Fg_boil = true;
                headDo.Emsdrugs.Orders_boil = 1;

            }
            headDo.Emsdrugs.Fg_pmor = false;
            headDo.Emsdrugs.Fg_dose_anoma = false;
            headDo.Emsdrugs.Fg_outp = false;
            headDo.Emsdrugs.Use_days = null;

            // 简洁医疗单新增赋值属性
            headDo.Emsdrugs.Note_or = med.Note;
            headDo.Emsdrugs.Fg_bl = med.Fg_bl;
            headDo.Emsdrugs.Name_route = med.Route_name;
            headDo.Emsdrugs.Name_routedes = med.Routedes_name;
            headDo.Emsdrugs.Fg_propc = false;

            //1)	判断当前工作台的就诊类型，当就诊类型是住院时，查询选中服务的BD_SRV.sd_mmbind_ip的值，
            //0开立绑定时，从<BD_SRV_REL_MM医疗服务_项目_物品关系策略>表里找出服务关联的物品，
            if (med.Sd_mmbind_ip == "0") {

            }


        }
        #endregion 新增时 药品绑定

        #region 新增时 检查数据绑定
        public void AddObsDataBing(EmsUIDTO headDo, MedSrvDO med) {
            //headDo.Emsapobs.Id_srv = med.Id_srv;  // 检查申请单主键
            //headDo.Emsapobs.Id_emsobs = "";
            // 医嘱服务id
            headDo.Emsapobs.Id_orsrv = "";
            // 医嘱医疗单
            headDo.Emsapobs.Id_or = "";
            // 服务id    
            headDo.Emsapobs.Id_srv = med.Id_srv;
            // 服务名称
            headDo.Emsapobs.Name_srv = med.Name;
            // 服务类型
            headDo.Emsapobs.Id_srvtp = med.Id_srvtp;
            // 服务类型名称
            headDo.Emsapobs.Name_srvtp = med.Name;
            // 检查类型id
            headDo.Emsapobs.Id_obstp = med.Id_srv;
            // 检查类型名称
            headDo.Emsapobs.Name_obstp = med.Name;
            headDo.Emsapobs.Name_obstp = med.Name;
            headDo.MedSrvDO.Id_freq = med.Id_freq;

            headDo.MedSrvDO.Sd_srvtp = med.Sd_srvtp;
            headDo.Emsapobs.Announcements = med.Note;
            // 检查申请单号   
            headDo.Emsapobs.No_applyobs = cof.getNo();
            headDo.Emsapobs.Dt_plan = cof.GetSystemDateTime();

            headDo.Emsapobs.Announcements = med.Note;
            // 加急标识
            // headDo.Emsapobs.Fg_urgent = true; 
            // 床旁执行标志
            // headDo.Emsapobs.Fg_mp_bed  = true; 
            // 计划检查时间
            // headDo.Emsapobs.Dt_begin_ui  
            // 诊断id
            // headDo.Emsapobs.Id_di  
            // 诊断
            // headDo.Emsapobs.Name_di  
            // 检查目的编码
            // headDo.Emsapobs.Sd_pps 
            // 检查目的描述
            // headDo.Emsapobs.Des_pps  
            // 症状体征描述
            // headDo.Emsapobs.Des_sympsign 
            // 身体部位id
            // headDo.Emsapobs.Id_body 
            // 身体部位编码
            // headDo.Emsapobs.Sd_body  
            // 身体部位名称
            // headDo.Emsapobs.Name_body  
            // 身体体位id
            // headDo.Emsapobs.Id_pos 
            // 身体体位编码
            //      headDo.Emsapobs.Sd_pos  
            // 身体体位名称
            // headDo.Emsapobs.Name_pos  
        }



        #endregion 新增时 检查数据绑定

        #region 新增时 检验数据绑定
        public void AddLabDataBing(EmsUIDTO headDo, MedSrvDO med) {

            // 医嘱服务id
            // headDo.Emsaplab.Id_orsrv = "";
            // 医嘱医疗单
            // headDo.Emsaplab.Id_or = "";

            // 服务id    
            headDo.Emsaplab.Id_srv = med.Id_srv;
            // 服务名称
            headDo.Emsaplab.Name_srv = med.Name;
            // 服务类型
            headDo.Emsaplab.Id_srvtp = med.Id_srvtp;
            // 服务类型名称
            headDo.Emsaplab.Name_srvtp = med.Name;
            // 检查类型id
            headDo.Emsaplab.Id_obstp = med.Id_srv;
            // 检查类型名称
            headDo.Emsaplab.Name_obstp = med.Name;
            // 检查申请单号   
            headDo.Emsaplab.No_applyobs = cof.getNo();
            headDo.Emsaplab.Dt_plan = cof.GetSystemDateTime();
            headDo.MedSrvDO.Id_freq = med.Id_freq;

            //headDo.Emsaplab.Id_samptp = "0001AA1000000003W7UL";
            //headDo.Emsaplab.Sd_samptp = "01";
            //headDo.Emsaplab.Name_samptp = "血液";
            // 加急标识
            // headDo.Emsapobs.Fg_urgent = true; 
            // 床旁执行标志
            // headDo.Emsapobs.Fg_mp_bed  = true; 
            // 计划检查时间
            // headDo.Emsapobs.Dt_begin_ui  
            // 诊断id
            // headDo.Emsapobs.Id_di  
            // 诊断
            // headDo.Emsapobs.Name_di  
            // 检查目的编码
            // headDo.Emsapobs.Sd_pps 
            // 检查目的描述
            // headDo.Emsapobs.Des_pps  
            // 症状体征描述
            // headDo.Emsapobs.Des_sympsign 
            // 身体部位id
            // headDo.Emsapobs.Id_body 
            // 身体部位编码
            // headDo.Emsapobs.Sd_body  
            // 身体部位名称
            // headDo.Emsapobs.Name_body  
            // 身体体位id
            // headDo.Emsapobs.Id_pos 
            // 身体体位编码
            //      headDo.Emsapobs.Sd_pos  
            // 身体体位名称
            // headDo.Emsapobs.Name_pos  
        }


        #endregion  新增时 检验数据绑定

        #region 新增时 输血数据绑定
        public void AddBtDataBing(EmsUIDTO headDo, MedSrvDO med) {
            //headDo.Emsapbt.Id_emsbt	 //输血医疗单主键	
            headDo.Emsapbt.Fg_bl = med.Fg_bl;
            headDo.Emsapbt.Fg_or = med.Fg_or;
            headDo.Emsapbt.Fg_mm = med.Fg_mm;
            //headDo.Emsapbt.Id_or	     //医嘱id	 		 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Id_orsrv	 //医嘱服务id
            //若打开该医疗单的服务是服务套时，输血成分参照是服务套中临床标志为true的明细
            if (med.Fg_set != null && med.Fg_set == true)
            {
                IMedSrvSetItemDOCrudService setService = XapServiceMgr.find<IMedSrvSetItemDOCrudService>();
                MedSrvSetItemDO[] setItems = setService.find(string.Format("a8.id_srv='{0}' and a8.fg_clinical='Y' and a8.fg_active='Y'", med.Id_srv), "", false);
                if (setItems != null && setItems.Length > 0) {
                    headDo.Emsapbt.Id_srv = setItems[0].Id_srv_itm;	     //服务id			 	 	 	
                    headDo.Emsapbt.Name_srv = setItems[0].Set_name;	 //输血成分(服务名称)	 	 	 	 	 	 				 	 			 	 	 	
                    headDo.Emsapbt.Quan_med = setItems[0].Quan_medu; // 输血数量(医学单位数值)	SINGLE	FDouble	16	 	 			 	 			 	 	 	
                    headDo.Emsapbt.Id_unit_med = setItems[0].Id_medu;	 // 输血数量单位(医学单位)	REF	计量单位	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
                    headDo.Emsapbt.Name_unit_med = setItems[0].Medu_name;	//医学单位名称	SINGLE	String	50 
                }
            }
            else {
                headDo.Emsapbt.Id_srv = med.Id_srv;	     //服务id			 	 	 	
                headDo.Emsapbt.Name_srv = med.Name;	 //输血成分(服务名称)	 	 	 	 	 	 				 	 			 	 	 	
                headDo.Emsapbt.Quan_med = med.Quan_med; // 输血数量(医学单位数值)	SINGLE	FDouble	16	 	 			 	 			 	 	 	
                headDo.Emsapbt.Id_unit_med = med.Id_unit_med;	 // 输血数量单位(医学单位)	REF	计量单位	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
                headDo.Emsapbt.Name_unit_med = med.Med_name;	//医学单位名称	SINGLE	String	50
            }	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Id_di	        //临床诊断id	REF	医疗服务_疾病诊断定义	20	疾病诊断	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Name_di	        //临床诊断	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            headDo.Emsapbt.No_applyform = cof.getNoappbtlyform();	//输血单号	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Parturition_cnt	//产数量	SINGLE	Integer	10	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Fg_bt	         // 输血史标志	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Sd_pps	         // 输血目的编码	SINGLE	String	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Id_pps	         // 输血目的id	REF	检验目的_自定义档案	20	检验目的_自定义档案	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Name_pps	     // 输血目的	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Fg_db	         // 献血史标志	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.No_db	         // 献血证号	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Id_mode	         // 预定输血方式id	REF	 	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Name_mode	     // 预定输血方式	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Sd_demandsu      //  输血需求状态sd	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Sd_mode	            //预定输血方式sd	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Pregnat_num	        //孕几胎	SINGLE	Integer	10	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Id_labitmexplain	//输血前检查说明id	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Name_labitmexplain	//输血前检查说明	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Sd_labitmexplain	//输血前检测项目说明	REF	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            headDo.Emsapbt.Dt_bt = this.NowTime(); // 输血日期	SINGLE	FDateTime	19	 	
            headDo.Emsapbt.Dt_begin_ui = headDo.Emsapbt.Dt_bt;	 	 	 	 	 	 				 	 			 	 	 	
            headDo.Emsapbt.Id_emp_create = UserManager.getInstance().CurrentPsnInfo.Id_psndoc;	  // 申请医生id	REF	人员基本信息	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            headDo.Emsapbt.Name_emp_create = UserManager.getInstance().CurrentPsnInfo.Name;	  // 申请医生	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            headDo.Emsapbt.Dt_create = UserManager.getInstance().CurrentUser.Createdtime;	      // 开立时间	SINGLE	FDateTime	19	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Id_bttp	          // 血液品种id	REF	血液品种_自定义档案	20	血液品种_自定义档案	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Name_bttp	      // 血液品种	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Sd_bttp	          //  血液品种sd	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Id_demandsu	      //   输血需求状态id	REF	 	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapbt.Name_demandsu     //	输血需求状态
            //诊断信息
            string[] diagArray = new GetPatDiagImp().getDiagArray(headDo.PatInfo.Id_ent);
            if (diagArray != null)
            {
                headDo.Emsapbt.Id_di = diagArray[7];//主诊断的主项目id
                headDo.Emsapbt.Id_diitm = diagArray[3];//主诊断id
                headDo.Emsapbt.Name_diag = diagArray[4];//主诊断名称
                headDo.Emsapbt.Str_code_di = diagArray[1];//诊断编码拼接
                headDo.Emsapbt.Str_name_di = diagArray[0];//诊断名称拼接
                headDo.Emsapbt.Str_id_diitm = diagArray[2];//诊断子项目id拼接
            }
        }


        #endregion 新增时 输血数据绑定

        #region 新增时 手术数据绑定
        public void AddOpDataBing(EmsUIDTO headDo, MedSrvDO med) {
            MedSrvOpDO op = new GetSrvSugImp().GetSrvSup(med.Id_srv);

            headDo.Emsapop.Id_incitp = op.Id_incitp;
            headDo.Emsapop.Sd_incitp = op.Sd_incitp;
            headDo.Emsapop.Id_unit_med = med.Id_unit_med;
            headDo.Emsapop.Name_unit_med = med.Med_name;
            headDo.Emsapop.Quan_med = med.Quan_med;
            //headDo.Emsapop.Id_emsopitem	        //手术申请单主键	SINGLE	String	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Id_or =   	            //医嘱id	SINGLE	String	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            headDo.Emsapop.Id_srv = med.Id_srv;	            //服务id	REF	医疗服务	20	医疗服务	 				 	 	 	 	 	 				 	 			 	 	 	
            headDo.Emsapop.Name_srv = med.Name;	            //手术名称	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            headDo.Emsapop.No_applyform = cof.getNo();	        //申请单号	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            headDo.Emsapop.Code_srv = op.Code_di;	            //手术编码	SINGLE	String	50	
            //headDo.Emsapop.Fg_er_sug	        //急诊手术	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Fg_xq_sug	        //限期手术	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Fg_zq_sug	        //择期手术	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            headDo.Emsapop.Dt_plan = this.NowTime();          //计划手术时间	SINGLE	FDateTime	19	 	 				 	 	 	 	 	 				 	 			 	 	 	
            headDo.Emsapop.Dt_creat = headDo.Emsapop.Dt_plan;//开立日期	SINGLE	FDateTime	19	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Id_di	            //诊断id	REF	医疗服务_疾病诊断定义	20	疾病诊断	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Name_di	            //诊断	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Id_mp_dep	        //执行科室id	REF	部门	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Name_mp_dep	        //执行科室	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            headDo.Emsapop.Sd_lvlsug = op.Sd_opclass;	        //手术分级编码	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            headDo.Emsapop.Name_lvlsug = op.Name_opclass;	        //手术分级	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            headDo.Emsapop.Id_lvlsug = op.Id_opclass; //手术分级id	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Sd_anestp	        //麻醉方式编码	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Name_anestp	        //麻醉方式	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Id_anestp	        //麻醉方式id	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Fg_allergy	        //药物过敏史	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            headDo.Emsapop.Fg_new_sug = op.Fg_new_sug; //是否开展新手术	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Fg_patho	            //手术中冰冻处理	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Quan_bt_plan	        //预期输血量	SINGLE	FDouble	16	 	 				 	 	 	 	  		 	 			 	 	 	
            //headDo.Emsapop.Time_sup_plan	    //预期手术时长	SINGLE	Integer	10	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Id_emp_operator	    //主刀医师id	REF	人员基本信息	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Name_emp_operator	//主刀医师	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Id_emp_help1	        //一助id	REF	人员基本信息	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Name_emp_help1	    //一助	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Sd_sugbodycod	    //体位编码	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Name_sugbodycod	    //体位	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Id_sugbodycod	    //体位id	REF	体位编码_自定义档案	20	体位编码_自定义档案	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Specialreq	        //特殊器械	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Specialinstrument	//特殊仪器	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Specialdes	        //特殊准备	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Announcements	    //注意事项	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Sd_su	            //手术申请状态	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Id_role	            //角色id	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Name_role	        //角色	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Id_emp_op	        //人员id	REF	人员基本信息	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Name_emp_op	        //人员名称	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Sv	                //版本号	SINGLE	FDateTime	19	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsapop.Sortno	            //排序号
            //诊断信息
            string[] diagArray = new GetPatDiagImp().getDiagArray(headDo.PatInfo.Id_ent);
            if (diagArray != null)
            {
                headDo.Emsapop.Id_di = diagArray[7];//主诊断的主项目id
                headDo.Emsapop.Id_diitm = diagArray[3];//主诊断id
                headDo.Emsapop.Name_diag = diagArray[4];//主诊断名称
                headDo.Emsapop.Str_code_di = diagArray[1];//诊断编码拼接
                headDo.Emsapop.Str_name_di = diagArray[0];//诊断名称拼接
                headDo.Emsapop.Str_id_diitm = diagArray[2];//诊断子项目id拼接
            }
        }

        #endregion 新增时 手术数据绑定

        #region 新增时 病理数据绑定
        public void AddPathgyDataBing(EmsUIDTO headDo, MedSrvDO med) {
            MedSrvLisDO[] labs = new GetSrvLabItemImp().GetSrvLabItem(med.Id_srv);
            MedSrvLisDO lab = new MedSrvLisDO();
            if (labs.Length > 0) {
                lab = labs[0];
            }

            #region 界面展示，绑定赋值数据
            headDo.Emsappathgy.Dt_begin_ui = this.NowTime();
            headDo.Emsappathgy.Id_srv = med.Id_srv; //病理项目id	REF	医疗服务	20	医疗服务
            headDo.Emsappathgy.Name_srv = med.Name;	//病理项目	SINGLE	String	50
            //headDo.Emsappathgy.Id_di // 诊断id REF	医疗服务_疾病诊断定
            //headDo.Emsappathgy.Name_di // 诊断	SINGLE	String	50
            headDo.Emsappathgy.Fg_urgent = true;// 加急标识	SINGLE	FBoolean
            headDo.Emsappathgy.Id_samptp = lab.Id_samptp;//标本类型id	REF	标本类型_自定义档案
            headDo.Emsappathgy.Sd_samptp = lab.Sd_samptp;//标本类型编码	SINGLE	String	50
            headDo.Emsappathgy.Name_samptp = lab.Samptp_name;//标本类型	SINGLE	String	50
            //headDo.Emsappathgy.Id_dep_coll //标本采集科室id REF 部门 20
            //headDo.Emsappathgy.Name_dep_coll //标本采集科室 SINGLE String
            headDo.Emsappathgy.Id_emp_coll = UserManager.getInstance().CurrentPsnInfo.Id_psndoc;//采集者id	REF	人员基本信息	20	 		 	 	 	
            headDo.Emsappathgy.Name_emp_coll = UserManager.getInstance().CurrentPsnInfo.Name; //采集者	SINGLE	String	50
            headDo.Emsappathgy.Dt_coll = CommonExtentions.NowTime(this);//采集时间 SINGLE FDateTime
            #endregion

            #region 界面未展示数据，绑定时获取值
            headDo.Emsappathgy.No_applyform = new ICiOrdQryServiceImpl().getOrdApPathgyDONober("");//申请单号 SINGLE String	50
            headDo.Emsappathgy.Dt_create = headDo.Emsappathgy.Dt_begin_ui;//申请时间 SINGLE	FDateTime
            headDo.Emsappathgy.Id_emp_create = UserManager.getInstance().CurrentPsnInfo.Id_psndoc;//申请医生id	REF	用户 20
            headDo.Emsappathgy.Name_emp_create = UserManager.getInstance().CurrentPsnInfo.Name;//申请医师 SINGLE	String	50
            headDo.Emsappathgy.Quan = (int?)med.Quan_med;//标本数量 
            headDo.Emsappathgy.Sd_colltp = lab.Sd_colltp;//采集方法编号
            headDo.Emsappathgy.Id_colltp = lab.Id_colltp;//采集方法id
            headDo.Emsappathgy.Des_labsamp = lab.Des_labsamp;//标本说明
            #endregion

            #region 界面填写数据，不绑定数据
            //headDo.Emsappathgy.Announcements // 检查要求	SINGLE	String	150
            headDo.Emsappathgy.Des_sympsign = LogicEx.GetInstance().diseaseDescription(headDo.PatInfo.Id_ent); // 病情描述	SINGLE	备注	300
            //headDo.Emsappathgy.Fg_outer //外院标志 SINGLE FBoolean
            //本院：选择既往病理号、既往病理诊断、既往病理日期、既往病理医院为本院
            //外院：医生勾选外院标志，既往病理号置空，既往病理诊断、既往病理日期、既往病理医院手填
            //headDo.Emsappathgy.No_pathgy_old //既往病理号 SINGLE String
            //headDo.Emsappathgy.Id_di_pathgy_old //既往病理诊断id REF 医疗服务_疾病诊
            //headDo.Emsappathgy.Name_di_pathgy_old //既往病理诊断 SINGLE String
            headDo.Emsappathgy.Org_pathgy_old = UserManager.getInstance().CurrentOrg.Name;//既往病理医院 SINGLE	String	50
            //headDo.Emsappathgy.Dt_pathgy_old = CommonExtentions.NowTime(this);//既往病理日期 SINGLE FDateTim
            //headDo.Emsappathgy.Collectdes	//采集所见 SINGLE String 50

           
            //诊断信息
            string[] diagArray = new GetPatDiagImp().getDiagArray(headDo.PatInfo.Id_ent);
            if (diagArray != null)
            {
                headDo.Emsappathgy.Id_di = diagArray[7];//主诊断的主项目id
                headDo.Emsappathgy.Id_diitm = diagArray[3];//主诊断id
                headDo.Emsappathgy.Name_diag = diagArray[4];//主诊断名称
                headDo.Emsappathgy.Str_code_di = diagArray[1];//诊断编码拼接
                headDo.Emsappathgy.Str_name_di = diagArray[0];//诊断名称拼接
                headDo.Emsappathgy.Str_id_diitm = diagArray[2];//诊断子项目id拼接
            }
            #endregion

            #region 界面未展示数据，绑定时未获取值
            //////headDo.Emsappathgy.Id_ordpathgyitem	//主键id	SINGLE	String	50
            //////headDo.Emsappathgy.Id_or	            //医嘱id	SINGLE	String	20
            //////headDo.Emsappathgy.Id_orsrv	        //医嘱服务id	SINGLE	String	50
            //////headDo.Emsappathgy.No_pathgy //病理号 SINGLE String 50
            //////headDo.Emsappathgy.Dt_rptpathgy //报告发布时间 SINGLE FDateTim
            //////headDo.Emsappathgy.Str_id_di /诊断idi拼接字符串	SINGLE Stri
            //////headDo.Emsappathgy.Str_name_di //诊断名字拼接字符串 SINGLE Stri
            //////headDo.Emsappathgy.Sv //版本号
            //////headDo.Emsappathgy.Name_colltp //采集方法名称
            #endregion
        }
        #endregion 新增时 病理数据绑定

        #region 新增时 会诊数据绑定
        public void AddConsDataBing(EmsUIDTO headDo, MedSrvDO med) {
            //headDo.Emsapcons.Id_emsconsitem(不对照)	//主键	SINGLE	String	50	  
            //headDo.Emsapcons.Id_or(不对照)	        //医嘱id	SINGLE	String	50	
            headDo.Emsapcons.No_applyform = cof.getNo();
            headDo.Emsapcons.Id_srv = med.Id_srv;
            headDo.Emsapcons.Name_srv = med.Name;
            headDo.Emsapcons.Fg_urgent = false;	    //加急标识	SINGLE	FBoolean  
            headDo.Emsapcons.Dt_plan = this.NowTime();   	//计划会诊时间	SINGLE	FDateTime 
            headDo.Emsapcons.Tel = UserManager.getInstance().CurrentDept.Tel;        	//联系电话	SINGLE	String	2 
            //headDo.Emsapcons.Id_place	    //申请地点id	REF	地点	20

            Ent4BannerDTO bannerDTO = headDo.PatInfo;            
            if (BdFcDictCodeConst.SD_CODE_ENTP_IP.Equals(bannerDTO.Code_entp)) 
            {
                // 住院 会诊地点是患者床旁 就诊科室+就诊病区+床号
                headDo.Emsapcons.Name_place = bannerDTO.Name_dep_phy + bannerDTO.Name_dep_nur + bannerDTO.Name_bed;    //申请地点名称	SINGLE	String	5 
            }
            else if (BdFcDictCodeConst.SD_CODE_ENTP_OP.Equals(bannerDTO.Code_entp) || BdFcDictCodeConst.SD_CODE_ENTP_ET.Equals(bannerDTO.Code_entp))
            {   
                // 门诊、急诊 会诊地点是就诊科室所在地址，如果地址为空使用就诊科室
                IDeptCrudService deptService = XapServiceMgr.find<IDeptCrudService>();
                DeptDO dept = deptService.findById(bannerDTO.Id_dep_phy);
                headDo.Emsapcons.Name_place = string.IsNullOrEmpty(dept.Id_plc) ? dept.Name : dept.Id_plc;
            }           
            else
            {
                // 其他就诊类型
            }
            
            //headDo.Emsapcons.Des_emr	        //  病理摘要	SINGLE	备注	300	  
            //headDo.Emsapcons.Des_psp	        //会诊目的	SINGLE	备注	300	  

            headDo.Emsapcons.Id_dep_cons = UserManager.getInstance().CurrentDept.Id_dep;    // 申请科室id	REF	部门	20	 	  
            headDo.Emsapcons.Name_dep_cons = UserManager.getInstance().CurrentDept.Name;	//申请科室	SINGLE	String	5 
            headDo.Emsapcons.Dt_creat = CommonExtentions.NowTime(this);	    //申请时间	SINGLE	FDateTime 
            headDo.Emsapcons.Id_emp_cons = UserManager.getInstance().CurrentUser.Id_user;	    //申请人id	REF	用户	20	 	  
            headDo.Emsapcons.Name_emp_cons = UserManager.getInstance().CurrentUser.Name;	//申请人	SINGLE	String
            
            //headDo.Emsapcons.EmsConsAssistItem=UserManager.getInstance().
        }

        #endregion 新增时 会诊数据绑定

        #region 新增时 转科数据绑定
        public void AddTransDataBing(EmsUIDTO headDo, MedSrvDO med) {

            //headDo.Emsaptrans.Id_emsaptrans	 //主键	SINGLE	String	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsaptrans.Id_or	    	 //SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsaptrans.Id_orsrv	 	 //SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsaptrans.Fg_tech_trans  //	转科/跨科	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsaptrans.Id_dep_to	     // 目标科室id	REF	部门	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsaptrans.Name_dep_to	       //目标科室	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsaptrans.Name_dep_nur_to   //目标病区	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsaptrans.Id_dep_nur_to	 // 目标病区id	REF	部门	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsaptrans.Des_rea_canc	 // 转科原因	

            //headDo.Emsaptrans.Fg_tech_trans	    	 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsaptrans.Id_dep_to	         	 	 	 	 				 	 			 	 	 	
            //headDo.Emsaptrans.Name_dep_to	     	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsaptrans.Name_dep_nur_to	  	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsaptrans.Id_dep_nur_to	     	 	 	 	 				 	 			 	 	 	
            //headDo.Emsaptrans.Des_rea_canc	     	 	 	 	 				 	 			 	 	 	
            headDo.Emsaptrans.Id_dep_from = patDo.Id_dep_phy;
            headDo.Emsaptrans.Id_dep_nur_from = patDo.Id_dep_nur;
            //headDo.Emsaptrans.Id_su_trans	     		 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsaptrans.Sd_su_trans	     			 	 	 	 	 	 				 	 			 	 	 	
            headDo.Emsaptrans.Dt_trans_apply = this.NowTime();
            headDo.Emsaptrans.Dt_effe = headDo.Emsaptrans.Dt_trans_apply;
        }

        #endregion 新增时 转科数据绑定

        #region 新增时 出院数据绑定

        public void AddOutDataBing(EmsUIDTO headDo, MedSrvDO med) {
            headDo.Emsapout.Dt_out = cof.GetServerDataTime();
            headDo.Emsapout.Id_dep_out = patDo.Id_dep_phy;	          //出院科室id	SINGLE  	 	
            headDo.Emsapout.Name_dep_out = patDo.Name_dep_phy;	      //出院科室	SINGLE  	 	
            headDo.Emsapout.Id_dep_nur_out = patDo.Id_dep_nur;	      //出院病区id	SINGLE  	 	
            headDo.Emsapout.Name_dep_nur_out = patDo.Name_dep_nur;	  //出院病区	SINGLE  	 	
            //headDo.Emsapout.Id_bed_out=patDo.b	          //出院床位id	SINGLE  	 	
            headDo.Emsapout.Name_bde_out = patDo.Name_bed;	      // 出院床位	SINGLE  	 	
            //headDo.Emsapout.Fg_again31	          // 31日再入院计划	SI 	 	 	 	
            //headDo.Emsapout.Des_again31	          // 31日再入院目的	SI  	 	
            //headDo.Emsapout.Id_outtp	          // 离院方式id	REF	离  			 	 	 	
            //headDo.Emsapout.Sd_outtp	          // 离院方式编码	SI  	 	 	
            //headDo.Emsapout.Name_outtp	          // 离院方式	SINGLE  	 	
            //headDo.Emsapout.Des_outtp	          // 离院描述	SINGLE 
        }
        #endregion 新增时 出院数据绑定
        #endregion 新增时 数据绑定

        #region 保存时  数据绑定

        #region 保存时 医嘱主表共通数据绑定
        public void SaveOrCommonDataBing1(CiorderAggDO agg, EmsUIDTO emsHeadDO) {
            agg.getParentDO().Id_grp = UserManager.getInstance().CurrentOrg.Id_grp;
            agg.getParentDO().Id_org = UserManager.getInstance().CurrentOrg.Id_org;
            agg.getParentDO().Id_pat = emsHeadDO.PatInfo.Id_pat;//患者
            agg.getParentDO().Id_en = emsHeadDO.PatInfo.Id_ent;//就诊
            agg.getParentDO().Id_entp = emsHeadDO.PatInfo.Id_entp;//就诊类型
            agg.getParentDO().Code_entp = emsHeadDO.PatInfo.Code_entp;//就诊类型编码
            agg.getParentDO().Id_srvtp = emsHeadDO.MedSrvDO.Id_srvtp;//医嘱类型
            agg.getParentDO().Sd_srvtp = emsHeadDO.MedSrvDO.Sd_srvtp;//服务类型编码

            if (agg.Status == DOStatus.NEW) {
                agg.getParentDO().Sd_su_or = CiDictCodeConst.SD_SU_OPEN;//sd 医嘱状态 0开立
                agg.getParentDO().Id_su_or = CiDictCodeConst.SD_SU_ID_OPEN;//医嘱状态(默认为开立状态)
            }
            agg.getParentDO().Fg_pkg = false;
            agg.getParentDO().Id_su_mp = "";
            agg.getParentDO().Sd_su_mp = "0";//TODO: 执行状态 0 未执行 后面变成sd
            agg.getParentDO().Id_su_bl = "";
            agg.getParentDO().Sd_su_bl = "0";//记账状态 0未记账
            agg.getParentDO().Des_or = emsHeadDO.MedSrvDO.Name;
            //agg.getParentDO().Id_org_or = emsHeadDO.Emsdrugs.//开立机构
            //agg.getParentDO().Id_dep_or = emsHeadDO.Id_dep_phy; //开立科室
            //agg.getParentDO().Id_wg_or  = emsHeadDO.Emsdrugs.//开立医疗组
            //agg.getParentDO().Id_emp_or = emsHeadDO.Id_emp_phy; //开立医师
            //agg.getParentDO().Id_srv_set= emsHeadDO.Emsdrugs. //服务套
            //agg.getParentDO().Id_srv_pkg = "";//医疗服务包
            agg.getParentDO().Createdby = UserManager.getInstance().CurrentUser.Id_user;
            agg.getParentDO().Createdtime = UserManager.getInstance().CurrentUser.Createdtime;
            agg.getParentDO().Modifiedby = UserManager.getInstance().CurrentUser.Modifiedby;
            agg.getParentDO().Modifiedtime = UserManager.getInstance().CurrentUser.Modifiedtime;
            //agg.getParentDO().Ds = emsHeadDO.Emsdrugs.
            //agg.getParentDO().Sv = emsHeadDO.Emsdrugs.	
        }
        #endregion 保存时 医嘱主表共通数据绑定
        #region 保存时 药品主表数据绑定

        public void SaveDrugOrDataBing1(CiorderAggDO agg, EmsUIDTO emsHeadDO) {
            agg.getParentDO().Fg_long = emsHeadDO.Emsdrugs.Fg_long; //长临标识
            agg.getParentDO().Code_or = emsHeadDO.PatInfo.Id_pat + CommonExtentions.NowTime(this).ToString(); //TODO: CODE 是否有生成标准？？？
            agg.getParentDO().Des_or = emsHeadDO.MedSrvDO.Name;
            agg.getParentDO().Name_or = emsHeadDO.MedSrvDO.Name;//通用品
            agg.getParentDO().Note_or = emsHeadDO.MedSrvDO.Name + "备注";//通用品
            //agg.getParentDO().Content_or = cof.GetOrDes(emsHeadDO); //  根据算法生成 医嘱内容test"; 

            agg.getParentDO().Id_freq = emsHeadDO.Emsdrugs.Id_freq;  //医嘱频次

            agg.getParentDO().Fg_boil = false;//代煎标志
            //agg.getParentDO().Orders_boil= emsHeadDO.Emsdrugs. 
            agg.getParentDO().Id_route = emsHeadDO.Emsdrugs.Id_route;//用法
            agg.getParentDO().Id_routedes = emsHeadDO.Emsdrugs.Id_routedes; //用法要求
            agg.getParentDO().Id_boil = emsHeadDO.Emsdrugs.Id_boil; //煎法
            agg.getParentDO().Id_boildes = emsHeadDO.Emsdrugs.Id_boildes;//煎法要求
            agg.getParentDO().Days_or = emsHeadDO.Emsdrugs.Use_days;//医嘱天数

            agg.getParentDO().Dt_entry = emsHeadDO.Emsdrugs.Dt_begin_ui;//开立日期
            agg.getParentDO().Days_or = emsHeadDO.Emsdrugs.Use_days;//医嘱天数
            //agg.getParentDO().Fg_sign = emsHeadDO.Emsdrugs.//签署标识
            //agg.getParentDO().Id_emp_sign
            //agg.getParentDO().Id_dep_sign
            agg.getParentDO().Fg_long = emsHeadDO.Emsdrugs.Fg_long;//长临标志
            agg.getParentDO().Dt_effe = emsHeadDO.Emsdrugs.Dt_begin_ui;//开始日期 生效日期
            agg.getParentDO().Dt_invalid = emsHeadDO.Emsdrugs.Dt_fail; //备用医嘱失效日期
            agg.getParentDO().Fg_pmor = emsHeadDO.Emsdrugs.Fg_pmor;//备用医嘱标识
            agg.getParentDO().Des_pmor = emsHeadDO.Emsdrugs.Bak_des;//备用医嘱使用条件
            //agg.getParentDO().Dt_lat          = emsHeadDO.Emsdrugs.//最近生成日期
            //agg.getParentDO().Fg_chk        = emsHeadDO.Emsdrugs.//核对日期 TODO: 医嘱确认时候 填充
            //agg.getParentDO().Id_emp_chk= emsHeadDO.Emsdrugs.//核对护士 
            agg.getParentDO().Id_dep_chk = "";//核对病区
            //agg.getParentDO().Dt_chk        = emsHeadDO.Emsdrugs.//核对日期
            //agg.getParentDO().Fg_stop
            //agg.getParentDO().Id_emp_stop= emsHeadDO.Emsdrugs.
            //agg.getParentDO().Id_dep_stop
            agg.getParentDO().Dt_stop = emsHeadDO.Emsdrugs.Dt_end_ui; //结束日期
            //agg.getParentDO().Fg_chk_stop
            //    agg.getParentDO().Id_emp_chk_stop
            //        agg.getParentDO().Id_dep_chk_stop
            //        agg.getParentDO().Dt_chk_stop
            //            agg.getParentDO().Fg_canc

            agg.getParentDO().Quan_firday_mp = int.Parse((emsHeadDO.Emsdrugs.First_freq == null || emsHeadDO.Emsdrugs.First_freq == "") ? "0" : emsHeadDO.Emsdrugs.First_freq);//首日执行次数
            //agg.getParentDO().Id_emp_canc= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Id_dep_canc
            //agg.getParentDO().Dt_canc= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Fg_chk_canc 

            //agg.getParentDO().Id_emp_chk_canc= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Id_dep_mp= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Dt_chk_canc= emsHeadDO.Emsdrugs. //作废核对日期

            agg.getParentDO().Fg_pmor = emsHeadDO.Emsdrugs.Fg_pmor;//备用医嘱标识
            agg.getParentDO().Des_pmor = emsHeadDO.Emsdrugs.Bak_des;//备用医嘱条件
            agg.getParentDO().Dt_invalid = emsHeadDO.Emsdrugs.Dt_fail;//备用医嘱失效日期
            //agg.getParentDO().Fg_active_pm = emsHeadDO.Emsdrugs //备用医嘱启用标识
            //agg.getParentDO().Id_reltp = emsHeadDO.Emsdrugs.
            //agg.getParentDO().Sd_reltp = emsHeadDO.Emsdrugs.//皮试医嘱关联类型
            //agg.getParentDO().Id_or_rel = emsHeadDO.Emsdrugs.
            //agg.getParentDO().Fg_bb = emsHeadDO.Emsdrugs//婴儿标识
            //agg.getParentDO().No_bb    = emsHeadDO.Emsdrugs.//婴儿序号

            agg.getParentDO().Fg_ctlcp = false;//临床路径控制标识
            agg.getParentDO().Fg_mr = false;//医疗记录联动标识
            agg.getParentDO().Orders = emsHeadDO.Emsdrugs.Orders;//医嘱付数
            agg.getParentDO().Orders_boil = emsHeadDO.Emsdrugs.Orders_boil;//代煎标识
            agg.getParentDO().Fg_boil = emsHeadDO.Emsdrugs.Orders_boil != null ? true : false;

            //agg.getParentDO().Fg_skintest = emsHeadDO.Emsdrugs.Fg_skintest;//皮试标识
            agg.getParentDO().Note_or = emsHeadDO.Emsdrugs.Note_or;
            agg.getParentDO().Fg_mp_in = false;//在院执行标识
            //agg.getParentDO().Times_mp_in
            //agg.getParentDO().Fg_mp_bed  = emsHeadDO.Emsdrugs.//床边执行标志
            //agg.getParentDO().Note_or = emsHeadDO.Emsdrugs.


        }
        #endregion 保存时 药品主表数据绑定

        #region 保存时 药品医嘱服务表数据绑定


        public void SaveDrugOrSrvDataBing1(EmsUIDTO emsHeadDO, OrdSrvDO order) {
            order.Id_pat = emsHeadDO.PatInfo.Id_pat;//患者
            order.Id_entp = emsHeadDO.PatInfo.Id_entp; //就诊类型
            order.Code_entp = emsHeadDO.PatInfo.Code_entp;//就诊类型编码
            order.Code_srv = emsHeadDO.MedSrvDO.Code;
            order.Id_en = emsHeadDO.PatInfo.Id_ent;//就诊
            //order.Sortno = 1;//  顺序前面已经赋值
            order.Id_srvtp = emsHeadDO.MedSrvDO.Id_srvtp;//	服务类型
            order.Sd_srvtp = emsHeadDO.MedSrvDO.Sd_srvtp;//服务类型编码
            order.Id_srv = emsHeadDO.MedSrvDO.Id_srv;//服务项目
            order.Name = emsHeadDO.Emsdrugs.Name_mm;//服务项目名称
            order.Fg_dose_anoma = emsHeadDO.Emsdrugs.Fg_dose_anoma;//变动用药标志
            order.Quan_medu = emsHeadDO.Emsdrugs.Quan_med;// medSrv.Quan_med;//数值_医学单位
            order.Id_medu = emsHeadDO.Emsdrugs.Id_unit_med;

            order.Id_route = emsHeadDO.Emsdrugs.Id_route;//用法
            order.Id_routedes = emsHeadDO.Emsdrugs.Id_routedes; //用法要求 
            order.Id_boil = emsHeadDO.Emsdrugs.Id_boil;
            order.Id_boildes = emsHeadDO.Emsdrugs.Id_boildes;
            order.Id_freq = emsHeadDO.Emsdrugs.Id_freq;//医嘱频次
            //order. Dt_lat= emsHeadDO. //
            //order. Id_org_srv= emsHeadDO.
            //order. Id_dep_srv= emsHeadDO.
            order.Id_org_srv = UserManager.getInstance().CurrentOrg.Id_org;	    // 服务项目开立机构 
            order.Id_dep_srv = UserManager.getInstance().CurrentDept.Id_dep;	    // 服务项目开立科室 
            order.Id_wg_or = UserManager.getInstance().CurrentGroup.Id_grp;	    // 医生医疗组	REF	 
            order.Id_emp_srv = UserManager.getInstance().CurrentUser.Id_user;	    // 服务项目开立医生 
            //order.Id_wg_or = emsHeadDO.Id_wg_or;//医生医疗组
            //order. Id_org_mp= emsHeadDO.
            order.Id_dep_mp = emsHeadDO.Emsdrugs.Id_dep;  //执行科室
            //order. Id_su_mp= emsHeadDO.
            //order. Sd_su_mp= emsHeadDO.
            //order. Id_su_bl= emsHeadDO.
            //order. Sd_su_bl= emsHeadDO. 
            //order. Dt_canc_mp= emsHeadDO. 
            //order. Dt_last_mp= emsHeadDO. 
            //order. Dt_bl_last= emsHeadDO. 
            order.Fg_dose_anoma = emsHeadDO.Emsdrugs.Fg_dose_anoma;//变动用药标识
            order.Fg_or = emsHeadDO.Emsdrugs.Fg_or;//医嘱标识
            //order. Fg_bl= emsHeadDO.
            order.Fg_mm = emsHeadDO.Emsdrugs.Fg_mm;//物品标识
            order.Pri = emsHeadDO.Emsdrugs.Price;//价格
            order.Fg_set = emsHeadDO.Emsdrugs.Fg_set;//服务套
            order.Quan_medu = emsHeadDO.Emsdrugs.Quan_med;//剂量
            order.Id_medu = emsHeadDO.Emsdrugs.Id_unit_med;//计量单位
            //order
            //order. Fg_bb= emsHeadDO. 
            //order. No_bb= emsHeadDO. 
            //order. Id_bb= emsHeadDO.
            //order. Fg_cgpause= emsHeadDO. 
            //order.Note_srv = emsHeadDO.//医嘱备注
            //order. Fg_prn= emsHeadDO.
            //order. Fg_skintest= emsHeadDO. 
            //order.Id_skintest = emsHeadDO.Emsdrugs
            //order. Sd_skintest= emsHeadDO. 
            //order. Fg_urgent= emsHeadDO.
            //order. Fg_mp_bed= emsHeadDO.
            //order. Fg_review= emsHeadDO.
            // order.Fg_indic//医保标识
            order.Fg_pres_outp = emsHeadDO.Emsdrugs.Fg_outp;//出院带药
            order.Fg_propc = emsHeadDO.Emsdrugs.Fg_propc;//预防用药标识
            order.Fg_self = emsHeadDO.Emsdrugs.Fg_self;//自备药标识

        }
        #endregion  保存时 药品医嘱服务表数据绑定


        #region 保存时候 药品表数据对照
        public OrdSrvMmDO SaveSrvMmDataBing1(string Id_orsrv, EmsOrDrug p) {
            return new OrdSrvMmDO() {
                Status = p.Status,
                Id_orsrvmm = p.Id_emsordrug,//医嘱服务物品主键标识	
                Id_orsrv = Id_orsrv,//医嘱服务项目          	
                Id_mm = p.Id_mm,//医疗物品                	
                Code_mm = p.Code_mm,//物品编码	                
                Name_mm = p.Name_mm,//物品名称	                
                Id_pgku_cur = p.Id_pgku_cur,//当前包装单位         
                Price_pgku_cur = p.Price,//参考价_当前包装	
                Quan_cur = p.Quan_cur,//总量_当前包装	        
                Id_pgku_base = p.Id_unit_base,//基本包装单位	    
                Quan_num_base = p.Quan_base != null ? (int)p.Quan_base.ToDouble() : 0,// int.Parse(p.Quan_med.Value.ToString()),//单次数量_分子   （单次数量）   
                Quan_den_base = 1,//单次数量_分母	    
                //Quan_bed_medu,//床边剩余量_医学单位
                Factor = p.Factor_mb,//换算系数	                
                Id_dosage = p.Id_dosage,//药品剂型	            
                Sd_dosage = p.Sd_dosage,//药品剂型编码	        
                Id_pharm = p.Id_pharm,//药理分类	            
                Sd_pharm = p.Sd_pharm,//药理分类编码          
                Id_val = p.Id_val,//价值分类                  
                Sd_val = p.Sd_val,//价值分类编码	            
                Id_pois = p.Id_pois,//毒麻分类	                
                Sd_pois = p.Sd_pois,//毒麻分类编码            	
                Id_anti = p.Id_anti,//抗菌药分类	            
                Sd_anti = p.Sd_anti,//抗菌药分类编码	            
                Id_mmtp = p.Id_mmtp,//物品类型	                
                Sd_mmtp = p.Sd_mmtp,//物品类型编码	            
                Id_antipsy = p.Id_antipsy,//抗精神分类编码	        
                Sd_antipsy = p.Sd_antipsy,//抗精神分类	        
                //Fg_otc=p.Fg_otc,//OTC标识                  
                Createdby = UserManager.getInstance().CurrentUser.Id_user,	//最后修改时间      
                Createdtime = UserManager.getInstance().CurrentUser.Createdtime, //最后修改人	        
                Modifiedby = UserManager.getInstance().CurrentUser.Modifiedby, //创建人	            
                Modifiedtime = UserManager.getInstance().CurrentUser.Modifiedtime, //创建时间
                //Ds,
                Sv = p.Sv,
            };
        }
        #endregion  保存时候 药品表数据对照

        #region 保存时 检查OR主表数据对照
        public void SaveObsOrDataBing1(CiorderAggDO agg, EmsUIDTO emsHeadDO, EmsType emsType) {
            agg.getParentDO().Id_grp = UserManager.getInstance().CurrentOrg.Id_grp;
            agg.getParentDO().Id_org = UserManager.getInstance().CurrentOrg.Id_org;
            agg.getParentDO().Id_pat = emsHeadDO.PatInfo.Id_pat;//患者
            agg.getParentDO().Id_en = emsHeadDO.PatInfo.Id_ent;//就诊
            agg.getParentDO().Id_entp = emsHeadDO.PatInfo.Id_entp;//就诊类型
            agg.getParentDO().Code_entp = emsHeadDO.PatInfo.Code_entp;//就诊类型编码
            agg.getParentDO().Id_srvtp = emsHeadDO.MedSrvDO.Id_srvtp;//医嘱类型
            agg.getParentDO().Sd_srvtp = emsHeadDO.MedSrvDO.Sd_srvtp;//服务类型编码
            //agg.getParentDO().Id_srv_set= emsHeadDO.Emsdrugs. //服务套
            //agg.getParentDO().Id_srv_pkg = "";//医疗服务包
            //agg.getParentDO().Fg_long = emsHeadDO.Emsdrugs.Fg_long; //长临标识
            agg.getParentDO().Code_or = emsHeadDO.PatInfo.Id_pat + CommonExtentions.NowTime(this).ToString(); //TODO: CODE 是否有生成标准？？？
            agg.getParentDO().Des_or = emsHeadDO.MedSrvDO.Name;//通用品
            //agg.getParentDO().Content_or = cof.GetOrDes(emsHeadDO); //  根据算法生成 医嘱内容test"; 
            agg.getParentDO().Id_freq = CiDictCodeConst.ID_FREQ_ONCE;//  "0001AA1000000005QWEM";  //医嘱频次  一次

            //agg.getParentDO().Fg_boil = false;//代煎标志
            ////agg.getParentDO().Orders_boil= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Id_route = emsHeadDO.Emsdrugs.Id_route;//用法
            //agg.getParentDO().Id_routedes = emsHeadDO.Emsdrugs.Id_routedes; //用法要求
            //agg.getParentDO().Id_boil = emsHeadDO.Emsdrugs.Id_boil; //煎法
            //agg.getParentDO().Id_boildes = emsHeadDO.Emsdrugs.Id_boildes;//煎法要求
            //agg.getParentDO().Days_or = emsHeadDO.Emsdrugs.Use_day;//医嘱天数
            //if (agg.Status == DOStatus.NEW)
            //{
            //    agg.getParentDO().Sd_su_or = CiDictCodeConst.SD_SU_OPEN;//sd 医嘱状态 0开立
            //    agg.getParentDO().Id_su_or = CiDictCodeConst.SD_SU_ID_OPEN;//医嘱状态(默认为开立状态)
            //}
            //agg.getParentDO().Id_su_mp = "";
            //agg.getParentDO().Sd_su_mp = "0";//TODO: 执行状态 0 未执行 后面变成sd
            //agg.getParentDO().Id_su_bl = "";
            //agg.getParentDO().Sd_su_bl = "0";//记账状态 0未记账

            agg.getParentDO().Id_org_or = emsHeadDO.Emsdrugs.Id_org; //开立机构
            //agg.getParentDO().Id_dep_or = emsHeadDO.Id_dep_phy; //开立科室 TODO:开立科室 取当前用户的科室
            //agg.getParentDO().Id_wg_or  = emsHeadDO.Emsdrugs.//开立医疗组
            //agg.getParentDO().Id_emp_or = emsHeadDO.Id_emp_phy; //开立医师
            //agg.getParentDO().Dt_entry = emsHeadDO.Emsapobs.Dt_plan;//开立日期
            //agg.getParentDO().Days_or = emsHeadDO.Emsdrugs.Use_day;//医嘱天数
            ////agg.getParentDO().Fg_sign       = emsHeadDO.Emsdrugs.//签署标识
            ////agg.getParentDO().Id_emp_sign
            ////agg.getParentDO().Id_dep_sign

            agg.getParentDO().Dt_effe = emsHeadDO.Emsapobs.Dt_plan;//开始日期 生效日期
            //agg.getParentDO().Dt_invalid = emsHeadDO.Emsdrugs.Dt_fail; //备用医嘱失效日期
            //agg.getParentDO().Fg_pmor = emsHeadDO.Emsdrugs.Fg_pmor;//备用医嘱标识
            //agg.getParentDO().Des_pmor = emsHeadDO.Emsdrugs.Bak_des;//备用医嘱使用条件
            ////agg.getParentDO().Dt_lat          = emsHeadDO.Emsdrugs.//最近生成日期
            ////agg.getParentDO().Fg_chk        = emsHeadDO.Emsdrugs.//核对日期 TODO: 医嘱确认时候 填充
            ////agg.getParentDO().Id_emp_chk= emsHeadDO.Emsdrugs.//核对护士 
            //agg.getParentDO().Id_dep_chk = "";//核对病区
            ////agg.getParentDO().Dt_chk        = emsHeadDO.Emsdrugs.//核对日期
            ////agg.getParentDO().Fg_stop
            ////agg.getParentDO().Id_emp_stop= emsHeadDO.Emsdrugs.
            ////agg.getParentDO().Id_dep_stop
            //agg.getParentDO().Dt_stop = emsHeadDO.Emsdrugs.Dt_end_ui; //结束日期
            ////agg.getParentDO().Fg_chk_stop
            ////    agg.getParentDO().Id_emp_chk_stop
            ////        agg.getParentDO().Id_dep_chk_stop
            ////        agg.getParentDO().Dt_chk_stop
            ////            agg.getParentDO().Fg_canc


            ////agg.getParentDO().Id_emp_canc= emsHeadDO.Emsdrugs. 
            ////agg.getParentDO().Id_dep_canc
            ////agg.getParentDO().Dt_canc= emsHeadDO.Emsdrugs. 
            ////agg.getParentDO().Fg_chk_canc 

            ////agg.getParentDO().Id_emp_chk_canc= emsHeadDO.Emsdrugs. 
            ////agg.getParentDO().Id_dep_mp= emsHeadDO.Emsdrugs. 
            ////agg.getParentDO().Dt_chk_canc= emsHeadDO.Emsdrugs. //作废核对日期

            //agg.getParentDO().Fg_pmor = emsHeadDO.Emsdrugs.Fg_pmor;//备用医嘱标识
            //agg.getParentDO().Des_pmor = emsHeadDO.Emsdrugs.Bak_des;//备用医嘱条件
            //agg.getParentDO().Dt_invalid = emsHeadDO.Emsdrugs.Dt_fail;//备用医嘱失效日期
            ////agg.getParentDO().Fg_active_pm = emsHeadDO.Emsdrugs //备用医嘱启用标识
            ////agg.getParentDO().Id_reltp = emsHeadDO.Emsdrugs.
            ////agg.getParentDO().Sd_reltp = emsHeadDO.Emsdrugs.//皮试医嘱关联类型
            ////agg.getParentDO().Id_or_rel = emsHeadDO.Emsdrugs.
            ////agg.getParentDO().Fg_bb = emsHeadDO.Emsdrugs//婴儿标识
            ////agg.getParentDO().No_bb    = emsHeadDO.Emsdrugs.//婴儿序号

            //agg.getParentDO().Fg_ctlcp = false;//临床路径控制标识
            //agg.getParentDO().Fg_mr = false;//医疗记录联动标识


            //agg.getParentDO().Fg_skintest = emsHeadDO.Emsdrugs.Fg_skintest;//皮试标识

            //agg.getParentDO().Fg_mp_in = false;//在院执行标识
            ////agg.getParentDO().Times_mp_in
            ////agg.getParentDO().Fg_mp_bed  = emsHeadDO.Emsdrugs.//床边执行标志
            ////agg.getParentDO().Note_or = emsHeadDO.Emsdrugs.

            //agg.getParentDO().Createdby = UserManager.getInstance().CurrentUser.Id_user;
            //agg.getParentDO().Createdtime = UserManager.getInstance().CurrentUser.Createdtime;
            //agg.getParentDO().Modifiedby = UserManager.getInstance().CurrentUser.Modifiedby;
            //agg.getParentDO().Modifiedtime = UserManager.getInstance().CurrentUser.Modifiedtime;
            ////agg.getParentDO().Ds = emsHeadDO.Emsdrugs.
            ////agg.getParentDO().Sv = emsHeadDO.Emsdrugs.	
            OrdApObsDO bos = new OrdApObsDO();

        }
        #endregion 保存时 检查OR主表数据对照

        #region 保存时 检查orsrv数据绑定
        public void SaveObsOrSrvDataBing1(EmsUIDTO emsHeadDO, OrdSrvDO order) {
            SaveObsLabOrSrvDataBing1(emsHeadDO, order);
        }

        #endregion  保存时 检查orsrv数据绑定

        #region 保存时 检验orsrv数据绑定
        public void SaveLabOrSrvDataBing1(EmsUIDTO emsHeadDO, OrdSrvDO order) {
            SaveObsLabOrSrvDataBing1(emsHeadDO, order);
        }

        #endregion 保存时 检验orsrv数据绑定
        #region 保存时 检查检验公用数据对照逻辑
        private void SaveObsLabOrSrvDataBing1(EmsUIDTO emsHeadDO, OrdSrvDO order) {
            order.Id_pat = emsHeadDO.PatInfo.Id_pat;//患者
            order.Id_entp = emsHeadDO.PatInfo.Id_entp; //就诊类型
            order.Code_entp = emsHeadDO.PatInfo.Code_entp;//就诊类型编码
            order.Id_en = emsHeadDO.PatInfo.Id_ent;//就诊
            order.Sortno = 1;//TODO: 顺序应该是机制生成的 
            order.Id_srvtp = emsHeadDO.MedSrvDO.Id_srvtp;//	服务类型
            order.Sd_srvtp = emsHeadDO.MedSrvDO.Sd_srvtp;//服务类型编码
            order.Id_srv = emsHeadDO.MedSrvDO.Id_srv;//服务项目
            order.Name = emsHeadDO.Emsapobs.Name_srv;//服务项目名称
            order.Id_org_srv = UserManager.getInstance().CurrentOrg.Id_org;	    // 服务项目开立机构 
            order.Id_dep_srv = UserManager.getInstance().CurrentDept.Id_dep;	    // 服务项目开立科室 
            order.Id_wg_or = UserManager.getInstance().CurrentGroup.Id_grp;	    // 医生医疗组	REF	 
            order.Id_emp_srv = UserManager.getInstance().CurrentUser.Id_user;	    // 服务项目开立医生 
            order.Dt_create = CommonExtentions.NowTime(this);	    // 服务项目立时间	 
            //order.Fg_dose_anoma = emsHeadDO.Emsdrugs.Fg_dose_anoma;//变动用药标志
            //order.Quan_medu = emsHeadDO.Emsdrugs.Quan_med;// medSrv.Quan_med;//数值_医学单位
            //order.Id_medu = emsHeadDO.Emsdrugs.Id_unit_med;

            //order.Id_route = emsHeadDO.Emsdrugs.Id_route;//用法
            //order.Id_routedes = emsHeadDO.Emsdrugs.Id_routedes; //用法要求 
            //order.Id_boil = emsHeadDO.Emsdrugs.Id_boil;
            //order.Id_boildes = emsHeadDO.Emsdrugs.Id_boildes;
            //order.Id_freq = emsHeadDO.Emsdrugs.Id_freq;//医嘱频次
            //order. Dt_lat= emsHeadDO. //
            //order. Id_org_srv= emsHeadDO.
            //order. Id_dep_srv= emsHeadDO.
            //order.Id_wg_or = emsHeadDO.Id_wg_or;//医生医疗组
            //order.Id_emp_srv = emsHeadDO.Id_emp_phy;//服务项目开立医生
            //order. Id_org_mp= emsHeadDO.
            //order.Id_dep_mp = emsHeadDO.Id_dep_phy; //执行科室
            //order. Id_su_mp= emsHeadDO.
            //order. Sd_su_mp= emsHeadDO.
            //order. Id_su_bl= emsHeadDO.
            //order. Sd_su_bl= emsHeadDO. 
            //order. Dt_canc_mp= emsHeadDO. 
            //order. Dt_last_mp= emsHeadDO. 
            //order. Dt_bl_last= emsHeadDO. 
            //order.Fg_dose_anoma = emsHeadDO.Emsdrugs.Fg_dose_anoma;//变动用药标识
            //order.Fg_or = emsHeadDO.Emsdrugs.Fg_or;//医嘱标识
            //order. Fg_bl= emsHeadDO.
            //order.Fg_mm = emsHeadDO.Emsdrugs.Fg_mm;//物品标识
            //order.Pri = emsHeadDO.Emsdrugs.Price;//价格
            //order.Fg_set = emsHeadDO.Emsdrugs.Fg_set;//服务套
            //order.Quan_medu = emsHeadDO.Emsdrugs.Quan_med;//剂量
            //order.Id_medu = emsHeadDO.Emsdrugs.Id_unit_med;//计量单位
            //order
            //order. Fg_bb= emsHeadDO. 
            //order. No_bb= emsHeadDO. 
            //order. Id_bb= emsHeadDO.
            //order. Fg_cgpause= emsHeadDO. 
            //order.Note_srv = emsHeadDO.//医嘱备注
            //order. Fg_prn= emsHeadDO.
            //order. Fg_skintest= emsHeadDO. 
            //order.Id_skintest = emsHeadDO.Emsdrugs
            //order. Sd_skintest= emsHeadDO. 
            //order. Fg_urgent= emsHeadDO.
            //order. Fg_mp_bed= emsHeadDO.
            //order. Fg_review= emsHeadDO.
            // order.Fg_indic//医保标识
            //order.Fg_pres_outp = emsHeadDO.Emsdrugs.Fg_outp;//出院带药
            //order.Fg_propc = emsHeadDO.Emsdrugs.Fg_propc;//预防用药标识
            //order.Fg_self = emsHeadDO.Emsdrugs.Fg_self;//自备药标识
        }
        #endregion 保存时 检查检验公用数据对照逻辑

        #region 保存时  检查申请单对照
        public OrdApObsDO SaveObsDataBing1(EmsObsItemDO obs) {
            return new OrdApObsDO {
                //Id_orobs	//医嘱检查申请主键标识	
                //Id_or	    //医嘱	 
                Id_di = obs.Id_di,	    //临床诊断	 
                Str_code_di = obs.Id_di,	//诊断编码拼接	 
                Str_name_di = obs.Str_name_di,	//诊断名称拼接	 
               // Str_id_diitm = obs.Str_id_diitm,	//诊断id拼接	 
                No_applyform = obs.No_applyobs,	//申请单号	 
                Dt_plan = obs.Dt_plan,       	//计划检查日期	 
                //Biopsy = obs.	        //检查组织描述	 
                Des_sympsign = obs.Des_sympsign,	//症状和体征	  
                Fg_urgent = obs.Fg_urgent,	    //加急标识 
                //Announcements	//注意事项	 
                Sd_pps = obs.Sd_pps,	        //检查目的编码	 
                Des_pps = obs.Des_pps	        //检查目的描述
            };
        }
        #endregion  保存时  检查申请单对照


        #region 保存时输血主表or数据绑定
        public void SaveBtOrDataBing1(CiorderAggDO agg, EmsUIDTO emsHeadDO) {
            //agg.getParentDO().Fg_long =   //长临标识
            agg.getParentDO().Code_or = emsHeadDO.PatInfo.Id_pat + CommonExtentions.NowTime(this).ToString(); //TODO: CODE 是否有生成标准？？？
            agg.getParentDO().Des_or = emsHeadDO.MedSrvDO.Name;//通用品
            //agg.getParentDO().Content_or = cof.GetOrDes(emsHeadDO); //  根据算法生成 医嘱内容test"; 

            //agg.getParentDO().Id_freq = emsHeadDO.Emsdrugs.Id_freq;  //医嘱频次

            agg.getParentDO().Fg_boil = false;//代煎标志
            //agg.getParentDO().Orders_boil= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Id_route = emsHeadDO.Emsdrugs.Id_route;//用法
            //agg.getParentDO().Id_routedes = emsHeadDO.Emsdrugs.Id_routedes; //用法要求
            //agg.getParentDO().Id_boil = emsHeadDO.Emsdrugs.Id_boil; //煎法
            //agg.getParentDO().Id_boildes = emsHeadDO.Emsdrugs.Id_boildes;//煎法要求
            agg.getParentDO().Days_or = 1;//医嘱天数

            agg.getParentDO().Dt_entry = emsHeadDO.Emsapbt.Dt_create;//开立日期
            agg.getParentDO().Days_or = emsHeadDO.Emsdrugs.Use_days;//医嘱天数
            //agg.getParentDO().Fg_sign = emsHeadDO.Emsdrugs.//签署标识
            //agg.getParentDO().Id_emp_sign
            //agg.getParentDO().Id_dep_sign
            //agg.getParentDO().Fg_long =  ;//长临标志
            agg.getParentDO().Dt_effe = emsHeadDO.Emsapbt.Dt_bt;//开始日期 生效日期
            //agg.getParentDO().Dt_invalid = ; //备用医嘱失效日期
            //agg.getParentDO().Fg_pmor =  ;//备用医嘱标识
            //agg.getParentDO().Des_pmor =  ;//备用医嘱使用条件
            //agg.getParentDO().Dt_lat          = emsHeadDO.Emsdrugs.//最近生成日期
            //agg.getParentDO().Fg_chk        = emsHeadDO.Emsdrugs.//核对日期 TODO: 医嘱确认时候 填充
            //agg.getParentDO().Id_emp_chk= emsHeadDO.Emsdrugs.//核对护士 
            agg.getParentDO().Id_dep_chk = "";//核对病区
            //agg.getParentDO().Dt_chk        = emsHeadDO.Emsdrugs.//核对日期
            //agg.getParentDO().Fg_stop
            //agg.getParentDO().Id_emp_stop= emsHeadDO.Emsdrugs.
            //agg.getParentDO().Id_dep_stop
            agg.getParentDO().Dt_stop = emsHeadDO.Emsapbt.Dt_bt; //结束日期
            //agg.getParentDO().Fg_chk_stop
            //    agg.getParentDO().Id_emp_chk_stop
            //        agg.getParentDO().Id_dep_chk_stop
            //        agg.getParentDO().Dt_chk_stop
            //            agg.getParentDO().Fg_canc


            //agg.getParentDO().Id_emp_canc= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Id_dep_canc
            //agg.getParentDO().Dt_canc= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Fg_chk_canc 

            //agg.getParentDO().Id_emp_chk_canc= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Id_dep_mp= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Dt_chk_canc= emsHeadDO.Emsdrugs. //作废核对日期

            //agg.getParentDO().Fg_pmor = emsHeadDO.Emsdrugs.Fg_pmor;//备用医嘱标识
            //agg.getParentDO().Des_pmor = emsHeadDO.Emsdrugs.Bak_des;//备用医嘱条件
            //agg.getParentDO().Dt_invalid = emsHeadDO.Emsdrugs.Dt_fail;//备用医嘱失效日期
            //agg.getParentDO().Fg_active_pm = emsHeadDO.Emsdrugs //备用医嘱启用标识
            //agg.getParentDO().Id_reltp = emsHeadDO.Emsdrugs.
            //agg.getParentDO().Sd_reltp = emsHeadDO.Emsdrugs.//皮试医嘱关联类型
            //agg.getParentDO().Id_or_rel = emsHeadDO.Emsdrugs.
            //agg.getParentDO().Fg_bb = emsHeadDO.Emsdrugs//婴儿标识
            //agg.getParentDO().No_bb    = emsHeadDO.Emsdrugs.//婴儿序号

            agg.getParentDO().Fg_ctlcp = false;//临床路径控制标识
            agg.getParentDO().Fg_mr = false;//医疗记录联动标识


            //agg.getParentDO().Fg_skintest = emsHeadDO.Emsdrugs.Fg_skintest;//皮试标识

            agg.getParentDO().Fg_mp_in = false;//在院执行标识
            //agg.getParentDO().Times_mp_in
            //agg.getParentDO().Fg_mp_bed  = emsHeadDO.Emsdrugs.//床边执行标志
            //agg.getParentDO().Note_or = emsHeadDO.Emsdrugs.


        }
        #endregion 保存时输血主表or数据绑定



        #region 保存时 输血orsrv数据绑定

        public void SaveBtOrSrvDataBing1(EmsUIDTO emsHeadDO, OrdSrvDO order) {
            order.Id_pat = emsHeadDO.PatInfo.Id_pat;//患者
            order.Id_entp = emsHeadDO.PatInfo.Id_entp; //就诊类型
            order.Code_entp = emsHeadDO.PatInfo.Code_entp;//就诊类型编码
            order.Id_en = emsHeadDO.PatInfo.Id_ent;//就诊
            //order.Sortno = 1;//  顺序前面已经赋值
            order.Id_srvtp = emsHeadDO.MedSrvDO.Id_srvtp;//	服务类型
            order.Sd_srvtp = emsHeadDO.MedSrvDO.Sd_srvtp;//服务类型编码
            order.Id_srv = emsHeadDO.MedSrvDO.Id_srv;//服务项目
            order.Name = emsHeadDO.Emsapbt.Name_srv;//服务项目名称
            order.Fg_dose_anoma = false;//变动用药标志
            order.Quan_medu = emsHeadDO.Emsapbt.Quan_med;// medSrv.Quan_med;//数值_医学单位
            order.Id_medu = emsHeadDO.Emsapbt.Id_unit_med;//计量单位
            order.Dt_create = emsHeadDO.Emsapbt.Dt_create;//开立时间
            order.Id_org_srv = UserManager.getInstance().CurrentOrg.Id_org;	    // 服务项目开立机构 
            order.Id_dep_srv = UserManager.getInstance().CurrentDept.Id_dep;	    // 服务项目开立科室 
            order.Id_wg_or = UserManager.getInstance().CurrentGroup.Id_grp;	    // 医生医疗组	REF	 
            order.Id_emp_srv = UserManager.getInstance().CurrentUser.Id_user;	    // 服务项目开立医生 
            order.Dt_create = CommonExtentions.NowTime(this);	    // 服务项目立时间	 

            //order.Id_route = emsHeadDO.Emsdrugs.Id_route;//用法
            //order.Id_routedes = emsHeadDO.Emsdrugs.Id_routedes; //用法要求 
            //order.Id_boil = emsHeadDO.Emsdrugs.Id_boil;
            //order.Id_boildes = emsHeadDO.Emsdrugs.Id_boildes;
            //order.Id_freq = emsHeadDO.Emsdrugs.Id_freq;//医嘱频次
            //order. Dt_lat= emsHeadDO. //
            //order. Id_org_srv= emsHeadDO.
            //order. Id_dep_srv= emsHeadDO.
            //order.Id_wg_or = emsHeadDO.Id_wg_or;//医生医疗组
            //order.Id_emp_srv = emsHeadDO.Id_emp_phy;//服务项目开立医生
            //order. Id_org_mp= emsHeadDO.
            //order.Id_dep_mp = emsHeadDO.Emsdrugs.Id_dep;  //执行科室
            //order. Id_su_mp= emsHeadDO.
            //order. Sd_su_mp= emsHeadDO.
            //order. Id_su_bl= emsHeadDO.
            //order. Sd_su_bl= emsHeadDO. 
            //order. Dt_canc_mp= emsHeadDO. 
            //order. Dt_last_mp= emsHeadDO. 
            //order. Dt_bl_last= emsHeadDO. 
            //order.Fg_dose_anoma = emsHeadDO.Emsdrugs.Fg_dose_anoma;//变动用药标识
            //order.Fg_or = emsHeadDO.Emsdrugs.Fg_or;//医嘱标识
            //order. Fg_bl= emsHeadDO.
            //order.Fg_mm = emsHeadDO.Emsdrugs.Fg_mm;//物品标识
            //order.Pri = emsHeadDO.Emsdrugs.Price;//价格
            //order.Fg_set = emsHeadDO.Emsdrugs.Fg_set;//服务套

            //order
            //order. Fg_bb= emsHeadDO. 
            //order. No_bb= emsHeadDO. 
            //order. Id_bb= emsHeadDO.
            //order. Fg_cgpause= emsHeadDO. 
            //order.Note_srv = emsHeadDO.//医嘱备注
            //order. Fg_prn= emsHeadDO.
            //order. Fg_skintest= emsHeadDO. 
            //order.Id_skintest = emsHeadDO.Emsdrugs
            //order. Sd_skintest= emsHeadDO. 
            //order. Fg_urgent= emsHeadDO.
            //order. Fg_mp_bed= emsHeadDO.
            //order. Fg_review= emsHeadDO.
            // order.Fg_indic//医保标识
            //order.Fg_pres_outp = emsHeadDO.Emsdrugs.Fg_outp;//出院带药
            //order.Fg_propc = emsHeadDO.Emsdrugs.Fg_propc;//预防用药标识
            //order.Fg_self = emsHeadDO.Emsdrugs.Fg_self;//自备药标识

        }
        #endregion 保存时 输血orsrv数据绑定

        #region 保存时  输血申请单 ci_ap_bt数据绑定
        public void SaveApBtDataBing1(EmsUIDTO emsHeadDO, OrdApBtDO bt) {
            //bt.Id_orbt	       // 医嘱输血申请主键标识	  	 	 	 	 				 	 		 
            //bt.Id_or	           // 医嘱	REF	临床医嘱	id_or	 			 	 			 	 	 		 
            bt.Id_di = emsHeadDO.Emsapbt.Id_di;         // 临床诊断	REF	医疗服务_疾病诊  	 	 	 	 				 	 		 
            //bt.Id_diitm =	       // 临床诊断明细	REF	临床  	 	 	 	 				 	 		 
            //bt.Str_id_di	       // 诊断编码拼接	SINGLE	  	 	 	 	 				 	 		 
            //bt.Str_name_di	   // 诊断名称拼接	SING  	 	 	 	 	 				 	 	 
            bt.No_applyform = emsHeadDO.Emsapbt.No_applyform;	   // 输血申请单号	SING 	 	 	 	 	 	 				 	 
            bt.Pregnant_num = emsHeadDO.Emsapbt.Pregnat_num;   // 孕几胎	SINGLE	  	 	 	 	 	 				 	 	 
            bt.Parturition_cnt = emsHeadDO.Emsapbt.Parturition_cnt;	//生产数量	SING 	 	 	 	 	 	 				 	 
            bt.Id_his_bt = emsHeadDO.Emsapbt.Id_his_bt;         //输血史标识	SINGLE	  	 	 	 	 				 	 		 
            bt.Sd_his_bt = emsHeadDO.Emsapbt.Sd_his_bt;        //输血史标识编码	SINGLE	  	 	 	 	 	 				 	 	 
            bt.Id_pps_bt = emsHeadDO.Emsapbt.Id_pps;         //输血目的	SINGLE	Stri 	 	 	 	 	 	 				 	 
            bt.Sd_pps_bt = emsHeadDO.Emsapbt.Sd_pps;         //输血目的编码	SINGLE	  	 	 	 	 				 	 		 
            //bt.Des_pps_bt	    //输血目的描述	SING  	 	 	 	 	 				 	 	 
            bt.Fg_db = emsHeadDO.Emsapbt.Fg_db;           //献血史标识	SINGLE	FBoo  	 	 	 				 	 			 
            bt.No_db = emsHeadDO.Emsapbt.No_db;            //献血证号	SINGLE	String	no_db  	 	 				 	 			 	 	 		 	 	 	 	 
            bt.Id_labitmexplain = emsHeadDO.Emsapbt.Id_labitmexplain;	//输血前监测项目说明	S  	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            bt.Sd_labitmexplain = emsHeadDO.Emsapbt.Sd_labitmexplain;	//输血前监测项目说明编  	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            bt.Id_demandsu_bt = emsHeadDO.Emsapbt.Id_demandsu;	//输血需求状态	SINGL 			 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            bt.Sd_demandsu_bt = emsHeadDO.Emsapbt.Sd_demandsu;	//输血需求状态编码	S  				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            bt.Id_mode_bt = emsHeadDO.Emsapbt.Id_mode;	//预定输血方式	SINGLE	S 	 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            bt.Sd_mode_bt = emsHeadDO.Emsapbt.Sd_mode;	//预定输血方式编码	SING  


        }
        #endregion 输血申请单 ci_ap_bt数据绑定

        #region 保存时 手术主表or数据绑定
        public void SaveOpOrDataBing1(CiorderAggDO agg, EmsUIDTO emsHeadDO) {

            //agg.getParentDO().Fg_long =   //长临标识
            agg.getParentDO().Code_or = emsHeadDO.PatInfo.Id_pat + CommonExtentions.NowTime(this).ToString(); //TODO: CODE 是否有生成标准？？？
            agg.getParentDO().Des_or = emsHeadDO.MedSrvDO.Name;//通用品
            //agg.getParentDO().Content_or = cof.GetOrDes(emsHeadDO); //  根据算法生成 医嘱内容test"; 

            //agg.getParentDO().Id_freq = emsHeadDO.Emsdrugs.Id_freq;  //医嘱频次

            agg.getParentDO().Fg_boil = false;//代煎标志
            //agg.getParentDO().Orders_boil= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Id_route = emsHeadDO.Emsdrugs.Id_route;//用法
            //agg.getParentDO().Id_routedes = emsHeadDO.Emsdrugs.Id_routedes; //用法要求
            //agg.getParentDO().Id_boil = emsHeadDO.Emsdrugs.Id_boil; //煎法
            //agg.getParentDO().Id_boildes = emsHeadDO.Emsdrugs.Id_boildes;//煎法要求
            agg.getParentDO().Days_or = 1;//医嘱天数

            agg.getParentDO().Dt_entry = emsHeadDO.Emsapop.Dt_creat;//开立日期
            //agg.getParentDO().Days_or = emsHeadDO.Emsapop.Use_day;//医嘱天数
            //agg.getParentDO().Fg_sign = emsHeadDO.Emsdrugs.//签署标识
            //agg.getParentDO().Id_emp_sign
            //agg.getParentDO().Id_dep_sign
            //agg.getParentDO().Fg_long =  ;//长临标志
            agg.getParentDO().Dt_effe = emsHeadDO.Emsapop.Dt_plan;//开始日期 生效日期
            //agg.getParentDO().Dt_invalid = ; //备用医嘱失效日期
            //agg.getParentDO().Fg_pmor =  ;//备用医嘱标识
            //agg.getParentDO().Des_pmor =  ;//备用医嘱使用条件
            //agg.getParentDO().Dt_lat          = emsHeadDO.Emsdrugs.//最近生成日期
            //agg.getParentDO().Fg_chk        = emsHeadDO.Emsdrugs.//核对日期 TODO: 医嘱确认时候 填充
            //agg.getParentDO().Id_emp_chk= emsHeadDO.Emsdrugs.//核对护士 
            //agg.getParentDO().Id_dep_chk = "";//核对病区
            //agg.getParentDO().Dt_chk        = emsHeadDO.Emsdrugs.//核对日期
            //agg.getParentDO().Fg_stop
            //agg.getParentDO().Id_emp_stop= emsHeadDO.Emsdrugs.
            //agg.getParentDO().Id_dep_stop
            //agg.getParentDO().Dt_stop = emsHeadDO.Emsapbt.Dt_bt; //结束日期
            //agg.getParentDO().Fg_chk_stop
            //    agg.getParentDO().Id_emp_chk_stop
            //        agg.getParentDO().Id_dep_chk_stop
            //        agg.getParentDO().Dt_chk_stop
            //            agg.getParentDO().Fg_canc


            //agg.getParentDO().Id_emp_canc= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Id_dep_canc
            //agg.getParentDO().Dt_canc= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Fg_chk_canc 

            //agg.getParentDO().Id_emp_chk_canc= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Id_dep_mp= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Dt_chk_canc= emsHeadDO.Emsdrugs. //作废核对日期

            //agg.getParentDO().Fg_pmor = emsHeadDO.Emsdrugs.Fg_pmor;//备用医嘱标识
            //agg.getParentDO().Des_pmor = emsHeadDO.Emsdrugs.Bak_des;//备用医嘱条件
            //agg.getParentDO().Dt_invalid = emsHeadDO.Emsdrugs.Dt_fail;//备用医嘱失效日期
            //agg.getParentDO().Fg_active_pm = emsHeadDO.Emsdrugs //备用医嘱启用标识
            //agg.getParentDO().Id_reltp = emsHeadDO.Emsdrugs.
            //agg.getParentDO().Sd_reltp = emsHeadDO.Emsdrugs.//皮试医嘱关联类型
            //agg.getParentDO().Id_or_rel = emsHeadDO.Emsdrugs.
            //agg.getParentDO().Fg_bb = emsHeadDO.Emsdrugs//婴儿标识
            //agg.getParentDO().No_bb    = emsHeadDO.Emsdrugs.//婴儿序号

            agg.getParentDO().Fg_ctlcp = false;//临床路径控制标识
            agg.getParentDO().Fg_mr = false;//医疗记录联动标识


            //agg.getParentDO().Fg_skintest = emsHeadDO.Emsdrugs.Fg_skintest;//皮试标识

            agg.getParentDO().Fg_mp_in = false;//在院执行标识
            //agg.getParentDO().Times_mp_in
            //agg.getParentDO().Fg_mp_bed  = emsHeadDO.Emsdrugs.//床边执行标志
            //agg.getParentDO().Note_or = emsHeadDO.Emsdrugs.

        }
        #endregion 保存时 手术主表or数据绑定

        #region 保存时 手术医嘱服务表srv数据绑定
        public void SaveOpOrSrvDataBing(EmsUIDTO emsHeadDO, OrdSrvDO order) {
            order.Id_pat = emsHeadDO.PatInfo.Id_pat;//患者
            order.Id_entp = emsHeadDO.PatInfo.Id_entp; //就诊类型
            order.Code_entp = emsHeadDO.PatInfo.Code_entp;//就诊类型编码
            order.Id_en = emsHeadDO.PatInfo.Id_ent;//就诊
            //order.Sortno = 1;//  顺序前面已经赋值
            order.Id_srvtp = emsHeadDO.MedSrvDO.Id_srvtp;//	服务类型
            order.Sd_srvtp = emsHeadDO.MedSrvDO.Sd_srvtp;//服务类型编码
            order.Id_srv = emsHeadDO.MedSrvDO.Id_srv;//服务项目
            order.Name = emsHeadDO.Emsapop.Name_srv;//服务项目名称
            order.Fg_dose_anoma = false;//变动用药标志
            //order.Quan_medu = emsHeadDO.Emsapbt.Quan_med;// medSrv.Quan_med;//数值_医学单位
            //order.Id_medu = emsHeadDO.Emsapbt.Id_unit_med;//计量单位
            order.Dt_create = emsHeadDO.Emsapop.Dt_creat;//开立时间
            order.Id_emp_srv = UserManager.getInstance().CurrentUser.Id_user;//开立医生

            //order.Id_route = emsHeadDO.Emsdrugs.Id_route;//用法
            //order.Id_routedes = emsHeadDO.Emsdrugs.Id_routedes; //用法要求 
            //order.Id_boil = emsHeadDO.Emsdrugs.Id_boil;
            //order.Id_boildes = emsHeadDO.Emsdrugs.Id_boildes;
            //order.Id_freq = emsHeadDO.Emsdrugs.Id_freq;//医嘱频次
            //order. Dt_lat= emsHeadDO. //
            //order. Id_org_srv= emsHeadDO.
            //order. Id_dep_srv= emsHeadDO.
            //order.Id_wg_or = emsHeadDO.Id_wg_or;//医生医疗组
            //order.Id_emp_srv = emsHeadDO.Id_emp_phy;//服务项目开立医生
            //order. Id_org_mp= emsHeadDO.
            order.Id_dep_mp = emsHeadDO.Emsapop.Id_mp_dep;  //执行科室
            //order. Id_su_mp= emsHeadDO.
            //order. Sd_su_mp= emsHeadDO.
            //order. Id_su_bl= emsHeadDO.
            //order. Sd_su_bl= emsHeadDO. 
            //order. Dt_canc_mp= emsHeadDO. 
            //order. Dt_last_mp= emsHeadDO. 
            //order. Dt_bl_last= emsHeadDO. 
            //order.Fg_dose_anoma = emsHeadDO.Emsdrugs.Fg_dose_anoma;//变动用药标识
            //order.Fg_or = emsHeadDO.Emsdrugs.Fg_or;//医嘱标识
            //order. Fg_bl= emsHeadDO.
            //order.Fg_mm = emsHeadDO.Emsdrugs.Fg_mm;//物品标识
            //order.Pri = emsHeadDO.Emsdrugs.Price;//价格
            //order.Fg_set = emsHeadDO.Emsdrugs.Fg_set;//服务套

            //order
            //order. Fg_bb= emsHeadDO. 
            //order. No_bb= emsHeadDO. 
            //order. Id_bb= emsHeadDO.
            //order. Fg_cgpause= emsHeadDO. 
            //order.Note_srv = emsHeadDO.//医嘱备注
            //order. Fg_prn= emsHeadDO.
            //order. Fg_skintest= emsHeadDO. 
            //order.Id_skintest = emsHeadDO.Emsdrugs
            //order. Sd_skintest= emsHeadDO. 
            //order. Fg_urgent= emsHeadDO.
            //order. Fg_mp_bed= emsHeadDO.
            //order. Fg_review= emsHeadDO.
            // order.Fg_indic//医保标识
            //order.Fg_pres_outp = emsHeadDO.Emsdrugs.Fg_outp;//出院带药
            //order.Fg_propc = emsHeadDO.Emsdrugs.Fg_propc;//预防用药标识
            //order.Fg_self = emsHeadDO.Emsdrugs.Fg_self;//自备药标识

        }
        #endregion 保存时 手术医嘱服务表srv数据绑定

        #region 保存时 手术表ci_ap_sug数据绑定
        public void SaveOpSugDataBing1(EmsUIDTO emsHeadDO, OrdApOpDO apOp) {

            ////apOp.Id_orop	         //  医嘱手术申请主键标识	SINGLE	FID	id_orop	char	20	 
            ////apOp.Id_or	         //  医嘱	REF	临床医嘱	id_or	varchar	20	 	 	 	 
            //apOp.Id_di = emsHeadDO.Emsapop.Id_di;	         //  临床诊断	REF	临床诊断	id_ordi	varchar	20	 	 	 	 
            ////apOp.Id_ordiitm=emsHeadDO.Emsapop.	     //  临床诊断明细	REF	临床诊断明细	id_ordiitm	varchar	20	 
            ////apOp.Str_id_di	 =emsHeadDO.Emsapop.sd    //  诊断编码拼接	SINGLE	备注	str_id_di	varchar	1000	 
            ////apOp.Str_name_di	     //  诊断名称拼接	SINGLE	备注	str_name_di	varchar	1000	 
            //apOp.No_applyform = emsHeadDO.Emsapop.No_applyform;	 //  手术申请单号	SINGLE	String	no_applyform	varchar	50	 
            //apOp.Dt_plan = emsHeadDO.Emsapop.Dt_plan;	         //  计划手术时间	SINGLE	FDateTime	dt_plan	char	19	 
            //apOp.Sugplantime = emsHeadDO.Emsapop.Time_sup_plan;	     //  计划手术时长	SINGLE	Integer	sugplantime	integer	10	 
            //apOp.Id_lvlsug = emsHeadDO.Emsapop.Id_lvlsug;	     //  手术级别	REF	手术级别_自定义档案	id_lvlsug	varchar	20	 
            //apOp.Sd_lvlsug = emsHeadDO.Emsapop.Sd_lvlsug;	     //  手术级别编码	SINGLE	String	sd_lvlsug	varchar	50	 
            //apOp.Id_anestp = emsHeadDO.Emsapop.Id_anestp;     //  麻醉方法	REF	麻醉方法_自定义档案	id_anestp	varchar	20	 
            //apOp.Sd_anestp = emsHeadDO.Emsapop.Sd_anestp;	     //  麻醉方法编码	SINGLE	String	sd_anestp	varchar	50	 
            //apOp.Id_incitp = emsHeadDO.Emsapop.Id_incitp; //  切口愈合分级	REF	切口愈合分级_自定义档案	id_incitp	varc 
            //apOp.Sd_incitp = emsHeadDO.Emsapop.Sd_incitp; //  切口愈合分级编码	SINGLE	String	sd_incitp	varchar	 
            //apOp.Fg_allergy = emsHeadDO.Emsapop.Fg_allergy;	     // 药物过敏标识	SINGLE	FBoolean	fg_allergy	char	 
            //apOp.Fg_patho = emsHeadDO.Emsapop.Fg_patho;	     // 冰冻病理标识	SINGLE	FBoolean	fg_patho	char	1	 
            ////apOp.Id_su_op	     // 手术申请状态	SINGLE	String	id_su_op	varchar	50	 	 
            //apOp.Sd_su_op = emsHeadDO.Emsapop.Sd_su;	     // 手术申请状态编码	SINGLE	String	sd_su_op	varchar	50	 
            //apOp.Announcements = emsHeadDO.Emsapop.Announcements;	 //  注意事项	SINGLE	备注	announcements	varchar	1000	 
            //apOp.Id_srv = emsHeadDO.Emsapop.Id_srv;	         //  手术名称	REF	医疗服务	id_srv	varchar	20	医疗服务	服务 
            //apOp.Id_srv_code = emsHeadDO.Emsapop.Code_srv;	     //  手术编码	SINGLE	String	id_srv_code	varchar	50	 	 
            //apOp.Quan_bt_paln = emsHeadDO.Emsapop.Quan_bt_plan;	 //  预期输血量	SINGLE	FBoolean	quan_bt_paln	char	 
            //apOp.Id_emp_operate = emsHeadDO.Emsapop.Id_emp_operator;	 //  主刀医生	SINGLE	String	id_emp_operate	varchar	50	 
            //apOp.Id_emp_helper = emsHeadDO.Emsapop.Id_emp_help1;//  第一助手	SINGLE	String	id_emp_helper	varchar	50	 
            //apOp.Id_sugbody = emsHeadDO.Emsapop.Id_sugbodycod;	     //  体位id	REF	体位编码_自定义档案	id_sugbody	varchar	20	 
            //apOp.Sd_sugbody = emsHeadDO.Emsapop.Sd_sugbodycod;	     //  体位编码	SINGLE	String	sd_sugbody	varchar	50	 	 
            //apOp.Specialreq = emsHeadDO.Emsapop.Specialreq;	     //  特殊用物	SINGLE	String	specialreq	varchar	50	 	 
            //apOp.Specialinstrument = emsHeadDO.Emsapop.Specialinstrument;//	特殊仪器	SINGLE	String	specialinstrument	varchar	 
            //apOp.Specialdes = emsHeadDO.Emsapop.Specialdes; //  特殊准备	SINGLE
            //apOp.Fg_er_sug = emsHeadDO.Emsapop.Fg_er_sug;//急诊手术	SINGLE	FBoolean		 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            //apOp.Fg_xq_sug = emsHeadDO.Emsapop.Fg_xq_sug;//限期手术	SINGLE	FBoolean		 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            //apOp.Fg_zq_sug = emsHeadDO.Emsapop.Fg_zq_sug;//择期手术	SINGLE	FBoolean		 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            //apOp.Fg_new_sug = emsHeadDO.Emsapop.Fg_new_sug; //是否新开手术	SINGLE	FBoolean
        }
        #endregion 保存时 手术表ci_ap_sug数据绑定

        #region 保存时 手术人员ci_ap_sug_emp 数据绑定
        public OrdOpEmpDO SaveOpSugEmpDataBing1(EmsItemInOp item, OrdOpEmpDO emp) {

            //emp.Id_oropemp(不赋值)	 //主键	SINGLE	String	id_oropemp	varchar	20	 	 	 				 	 	 
            //emp.Id_or(不赋值)	     //医嘱id	SINGLE	String	id_or	varchar	50	 	 	 				 	 	 
            emp.Id_emp = item.Id_emp_op;     //人员	REF	用户	id_emp	varchar	20	用户	用户名称	 				 	 	 	 	 	 
            emp.Sd_role = item.Sd_role;	     //角色编码	SINGLE	String	sd_role	varchar	50	 	 	 				 	 	 	 
            emp.Id_role = item.Id_role;	     //角色id	REF	手术角色类型_自定义档案	id_role	varchar	20	手术角色类型_自定义档案	名称	 	
            ////emp.Sortno	     //排序
            return emp;
        }

        #endregion 保存时 手术人员ci_ap_sug_emp 数据绑定


        #region 保存时 手术卫材ci_ap_sug_mm 数据绑定
        public OrdOpMmDO SaveOpSugMmDataBing1(EmsItemInOp item, OrdOpMmDO mm) {
            //mm.Id_oropmm=不赋值)	 	//主键	SINGLE	String	id_oropmm	varchar	20	 	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            //   mm.Id_or不赋值)	 	//医嘱id	SINGLE	String	id_or	varchar	20	 	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            mm.Id_mm = item.Id_mm;	//物品id	REF	医疗物品_基本信息	id_mm	varchar	20	医疗物品	物品名称	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	a16b2
            mm.Sd_mmtp = item.Sd_mmtp;	//物品类型编码	SINGLE	String	sd_mmtp	varchar	50	 	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            mm.Id_mmtp = item.Id_mmtp;	//物品类型id	REF	医疗物品类型_自定义档案	id_mmtp	varchar	20	医疗物品类型_自定义档案	名称	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	a16b3
            mm.Spec = item.Spec;	    //规格	SINGLE	String	spec	varchar	50	 	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            mm.Id_sup = item.Id_sup;	//厂家	REF	医疗物品_供应商与厂商	id_sup	varchar	20	供应商及厂商	供应商与厂商名称	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	a16b4
            mm.Price = item.Price;	//价格	SINGLE	FDouble	price	decimal	16	 	 	 				 	 	 	 	 	2				 	 			 	 	 		 	 	 	 	 
            mm.Quan_cur = item.Quan_cur;	//数量	SINGLE	Integer	quan_cur	integer	10	 	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            mm.Id_unit_pkgsp = item.Id_unit_pkgsp;	//单位	REF	医疗物品_包装单位集	id_unit_pkgsp	varchar	20
            return mm;
        }

        #endregion 保存时 手术卫材ci_ap_sug_mm 数据绑定

        #region 保存时 附加手术orsrv数据绑定
        public OrdSrvDO SaveOpAppendOpDataBing1(EmsUIDTO emsHeadDO, EmsItemInOp item, OrdSrvDO order) {
            order.Id_pat = emsHeadDO.PatInfo.Id_pat;//患者
            order.Id_entp = emsHeadDO.PatInfo.Id_entp; //就诊类型
            order.Code_entp = emsHeadDO.PatInfo.Code_entp;//就诊类型编码
            order.Id_en = emsHeadDO.PatInfo.Id_ent;//就诊
            //order.Sortno = 1;//  顺序前面已经赋值
            order.Id_srvtp = emsHeadDO.MedSrvDO.Id_srvtp;//	服务类型
            order.Sd_srvtp = emsHeadDO.MedSrvDO.Sd_srvtp;//服务类型编码
            order.Id_srv = emsHeadDO.Emsapop.Id_srv;//服务项目
            order.Name = emsHeadDO.Emsapop.Name_srv;//服务项目名称
            order.Code_srv = item.Code_srv;
            order.Fg_dose_anoma = false;//变动用药标志
            //order.Quan_medu = emsHeadDO.Emsapbt.Quan_med;// medSrv.Quan_med;//数值_医学单位
            //order.Id_medu = emsHeadDO.Emsapbt.Id_unit_med;//计量单位
            order.Dt_create = emsHeadDO.Emsapop.Dt_creat;//开立时间
            order.Id_emp_srv = UserManager.getInstance().CurrentUser.Id_user;//开立医生

            //order.Id_route = emsHeadDO.Emsdrugs.Id_route;//用法
            //order.Id_routedes = emsHeadDO.Emsdrugs.Id_routedes; //用法要求 
            //order.Id_boil = emsHeadDO.Emsdrugs.Id_boil;
            //order.Id_boildes = emsHeadDO.Emsdrugs.Id_boildes;
            //order.Id_freq = emsHeadDO.Emsdrugs.Id_freq;//医嘱频次
            //order. Dt_lat= emsHeadDO. //
            //order. Id_org_srv= emsHeadDO.
            //order. Id_dep_srv= emsHeadDO.
            //order.Id_wg_or = emsHeadDO.Id_wg_or;//医生医疗组
            //order.Id_emp_srv = emsHeadDO.Id_emp_phy;//服务项目开立医生
            //order. Id_org_mp= emsHeadDO.
            order.Id_dep_mp = emsHeadDO.Emsapop.Id_mp_dep;  //执行科室
            //order. Id_su_mp= emsHeadDO.
            //order. Sd_su_mp= emsHeadDO.
            //order. Id_su_bl= emsHeadDO.
            //order. Sd_su_bl= emsHeadDO. 
            //order. Dt_canc_mp= emsHeadDO. 
            //order. Dt_last_mp= emsHeadDO. 
            //order. Dt_bl_last= emsHeadDO. 
            //order.Fg_dose_anoma = emsHeadDO.Emsdrugs.Fg_dose_anoma;//变动用药标识
            //order.Fg_or = emsHeadDO.Emsdrugs.Fg_or;//医嘱标识
            //order. Fg_bl= emsHeadDO.
            //order.Fg_mm = emsHeadDO.Emsdrugs.Fg_mm;//物品标识
            //order.Pri = emsHeadDO.Emsdrugs.Price;//价格
            //order.Fg_set = emsHeadDO.Emsdrugs.Fg_set;//服务套

            //order
            //order. Fg_bb= emsHeadDO. 
            //order. No_bb= emsHeadDO. 
            //order. Id_bb= emsHeadDO.
            //order. Fg_cgpause= emsHeadDO. 
            //order.Note_srv = emsHeadDO.//医嘱备注
            //order. Fg_prn= emsHeadDO.
            //order. Fg_skintest= emsHeadDO. 
            //order.Id_skintest = emsHeadDO.Emsdrugs
            //order. Sd_skintest= emsHeadDO. 
            //order. Fg_urgent= emsHeadDO.
            //order. Fg_mp_bed= emsHeadDO.
            //order. Fg_review= emsHeadDO.
            // order.Fg_indic//医保标识
            //order.Fg_pres_outp = emsHeadDO.Emsdrugs.Fg_outp;//出院带药
            //order.Fg_propc = emsHeadDO.Emsdrugs.Fg_propc;//预防用药标识
            //order.Fg_self = emsHeadDO.Emsdrugs.Fg_self;//自备药标识
            return order;
        }
        #endregion



        #region 保存时 病理医嘱主表or数据绑定
        public void SavePathgyOrDataBing1(CiorderAggDO agg, EmsUIDTO emsHeadDO) {
            //agg.getParentDO().Fg_long = emsHeadDO.Emsdrugs.Fg_long; //长临标识
            agg.getParentDO().Code_or = emsHeadDO.PatInfo.Id_pat + CommonExtentions.NowTime(this).ToString(); //TODO: CODE 是否有生成标准？？？
            agg.getParentDO().Des_or = emsHeadDO.MedSrvDO.Name;//通用品
            //agg.getParentDO().Content_or = cof.GetOrDes(emsHeadDO); //  根据算法生成 医嘱内容test"; 

            //agg.getParentDO().Id_freq = emsHeadDO.Emsdrugs.Id_freq;  //医嘱频次

            //agg.getParentDO().Fg_boil = false;//代煎标志
            //agg.getParentDO().Orders_boil= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Id_route = emsHeadDO.Emsdrugs.Id_route;//用法
            //agg.getParentDO().Id_routedes = emsHeadDO.Emsdrugs.Id_routedes; //用法要求
            //agg.getParentDO().Id_boil = emsHeadDO.Emsdrugs.Id_boil; //煎法
            //agg.getParentDO().Id_boildes = emsHeadDO.Emsdrugs.Id_boildes;//煎法要求

            agg.getParentDO().Dt_entry = emsHeadDO.Emsappathgy.Dt_create;//开立日期
            agg.getParentDO().Days_or = 1;//医嘱天数
            //agg.getParentDO().Fg_sign = emsHeadDO.Emsdrugs.//签署标识
            //agg.getParentDO().Id_emp_sign
            //agg.getParentDO().Id_dep_sign
            agg.getParentDO().Fg_long = false;//长临标志
            agg.getParentDO().Dt_effe = emsHeadDO.Emsappathgy.Dt_create;//开始日期 生效日期
            //agg.getParentDO().Dt_invalid = emsHeadDO.Emsdrugs.Dt_fail; //备用医嘱失效日期
            //agg.getParentDO().Fg_pmor = emsHeadDO.Emsdrugs.Fg_pmor;//备用医嘱标识
            //agg.getParentDO().Des_pmor = emsHeadDO.Emsdrugs.Bak_des;//备用医嘱使用条件
            //agg.getParentDO().Dt_lat          = emsHeadDO.Emsdrugs.//最近生成日期
            //agg.getParentDO().Fg_chk        = emsHeadDO.Emsdrugs.//核对日期 TODO: 医嘱确认时候 填充
            //agg.getParentDO().Id_emp_chk= emsHeadDO.Emsdrugs.//核对护士 
            agg.getParentDO().Id_dep_chk = "";//核对病区
            //agg.getParentDO().Dt_chk        = emsHeadDO.Emsdrugs.//核对日期
            //agg.getParentDO().Fg_stop
            //agg.getParentDO().Id_emp_stop= emsHeadDO.Emsdrugs.
            //agg.getParentDO().Id_dep_stop
            //agg.getParentDO().Dt_stop = emsHeadDO.Emsdrugs.Dt_end_ui; //结束日期
            //agg.getParentDO().Fg_chk_stop
            //    agg.getParentDO().Id_emp_chk_stop
            //        agg.getParentDO().Id_dep_chk_stop
            //        agg.getParentDO().Dt_chk_stop
            //            agg.getParentDO().Fg_canc


            //agg.getParentDO().Id_emp_canc= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Id_dep_canc
            //agg.getParentDO().Dt_canc= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Fg_chk_canc 

            //agg.getParentDO().Id_emp_chk_canc= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Id_dep_mp= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Dt_chk_canc= emsHeadDO.Emsdrugs. //作废核对日期

            //agg.getParentDO().Fg_pmor = emsHeadDO.Emsdrugs.Fg_pmor;//备用医嘱标识
            //agg.getParentDO().Des_pmor = emsHeadDO.Emsdrugs.Bak_des;//备用医嘱条件
            //agg.getParentDO().Dt_invalid = emsHeadDO.Emsdrugs.Dt_fail;//备用医嘱失效日期
            //agg.getParentDO().Fg_active_pm = emsHeadDO.Emsdrugs //备用医嘱启用标识
            //agg.getParentDO().Id_reltp = emsHeadDO.Emsdrugs.
            //agg.getParentDO().Sd_reltp = emsHeadDO.Emsdrugs.//皮试医嘱关联类型
            //agg.getParentDO().Id_or_rel = emsHeadDO.Emsdrugs.
            //agg.getParentDO().Fg_bb = emsHeadDO.Emsdrugs//婴儿标识
            //agg.getParentDO().No_bb    = emsHeadDO.Emsdrugs.//婴儿序号

            //agg.getParentDO().Fg_ctlcp = false;//临床路径控制标识
            //agg.getParentDO().Fg_mr = false;//医疗记录联动标识


            //agg.getParentDO().Fg_skintest = emsHeadDO.Emsdrugs.Fg_skintest;//皮试标识

            agg.getParentDO().Fg_mp_in = false;//在院执行标识
            //agg.getParentDO().Times_mp_in
            //agg.getParentDO().Fg_mp_bed  = emsHeadDO.Emsdrugs.//床边执行标志
            //agg.getParentDO().Note_or = emsHeadDO.Emsdrugs.

        }
        #endregion 保存时 病理医嘱主表or数据绑定

        #region 保存时 病理医嘱服务表orsrv数据绑定

        public void SavePathgyOrSrvDataBing1(EmsUIDTO emsHeadDO, OrdSrvDO order) {
            order.Id_pat = emsHeadDO.PatInfo.Id_pat;//患者
            order.Id_entp = emsHeadDO.PatInfo.Id_entp; //就诊类型
            order.Code_entp = emsHeadDO.PatInfo.Code_entp;//就诊类型编码
            order.Id_en = emsHeadDO.PatInfo.Id_ent;//就诊
            //order.Sortno = 1;//  顺序前面已经赋值
            order.Id_srvtp = emsHeadDO.MedSrvDO.Id_srvtp;//	服务类型
            order.Sd_srvtp = emsHeadDO.MedSrvDO.Sd_srvtp;//服务类型编码
            order.Id_srv = emsHeadDO.Emsappathgy.Id_srv;//服务项目
            order.Name = emsHeadDO.Emsappathgy.Name_srv;//服务项目名称
            order.Fg_dose_anoma = false;//变动用药标志
            order.Quan_medu = 1;// medSrv.Quan_med;//数值_医学单位
            //order.Id_medu = emsHeadDO.id_.Emsappathgy.Id_unit_med;//计量单位
            order.Dt_create = CommonExtentions.NowTime(this);//开立时间
            order.Id_emp_srv = UserManager.getInstance().CurrentUser.Id_user;//开立医生

            //order.Id_route = emsHeadDO.Emsdrugs.Id_route;//用法
            //order.Id_routedes = emsHeadDO.Emsdrugs.Id_routedes; //用法要求 
            //order.Id_boil = emsHeadDO.Emsdrugs.Id_boil;
            //order.Id_boildes = emsHeadDO.Emsdrugs.Id_boildes;
            //order.Id_freq = emsHeadDO.Emsdrugs.Id_freq;//医嘱频次
            //order. Dt_lat= emsHeadDO. //
            //order. Id_org_srv= emsHeadDO.
            //order. Id_dep_srv= emsHeadDO.
            //order.Id_wg_or = emsHeadDO.Id_wg_or;//医生医疗组
            order.Id_org_srv = UserManager.getInstance().CurrentOrg.Id_org;	    // 服务项目开立机构 
            order.Id_dep_srv = UserManager.getInstance().CurrentDept.Id_dep;	    // 服务项目开立科室 
            order.Id_wg_or = UserManager.getInstance().CurrentGroup.Id_grp;	    // 医生医疗组	REF	 
            order.Id_emp_srv = UserManager.getInstance().CurrentUser.Id_user;	    // 服务项目开立医生 
            order.Dt_create = emsHeadDO.Emsapcons.Dt_creat;     // 服务项目立时间	 
            //order. Id_org_mp= emsHeadDO.
            //order.Id_dep_mp = emsHeadDO.Emsapop.Id_mp_dep;  //执行科室
            //order. Id_su_mp= emsHeadDO.
            ////order. Sd_su_mp= emsHeadDO.
            order.Id_su_bl = CiDictCodeConst.SD_SU_BL_NONE;
            order.Sd_su_bl = CiDictCodeConst.SD_SU_BL_NONE_ID;
            //order. Dt_canc_mp= emsHeadDO. 
            //order. Dt_last_mp= emsHeadDO. 
            //order.Dt_bl_last = CommonExtentions.NowTime(this);
            order.Fg_dose_anoma = false;//变动用药标识
            //order.Fg_or = emsHeadDO.Emsdrugs.Fg_or;//医嘱标识
            //order. Fg_bl= emsHeadDO.
            //order.Fg_mm = emsHeadDO.Emsdrugs.Fg_mm;//物品标识
            //order.Pri = emsHeadDO.Emsdrugs.Price;//价格
            //order.Fg_set = emsHeadDO.Emsdrugs.Fg_set;//服务套

            //order
            //order. Fg_bb= emsHeadDO. 
            //order. No_bb= emsHeadDO. 
            //order. Id_bb= emsHeadDO.
            //order. Fg_cgpause= emsHeadDO. 
            //order.Note_srv = emsHeadDO.//医嘱备注
            //order. Fg_prn= emsHeadDO.
            //order. Fg_skintest= emsHeadDO. 
            //order.Id_skintest = emsHeadDO.Emsdrugs
            //order. Sd_skintest= emsHeadDO. 
            //order. Fg_urgent= emsHeadDO.
            //order. Fg_mp_bed= emsHeadDO.
            //order. Fg_review= emsHeadDO.
            // order.Fg_indic//医保标识
            //order.Fg_pres_outp = emsHeadDO.Emsdrugs.Fg_outp;//出院带药
            //order.Fg_propc = emsHeadDO.Emsdrugs.Fg_propc;//预防用药标识
            //order.Fg_self = emsHeadDO.Emsdrugs.Fg_self;//自备药标识

        }
        #endregion 保存时 病理医嘱服务表orsrv数据绑定
        #region 保存时 病理申请单ci_ap_pathgy数据绑定
        public void SavePathgyDataBing1(EmsUIDTO emsHeadDO, OrdApPathgyDO path) {
            //path.Id_orpathgy	(不赋值)        //病理主键	SINGLE	String	id_orpathgy	varchar	50	 	 	
            //path.Id_or(不赋值)            //医嘱主键	SINGLE	String	id_or	varchar	50	 	 	 		
            path.No_applyform = emsHeadDO.Emsappathgy.No_applyform;	    //病理申请号	SINGLE	String	no_a
            path.Sd_samptp = emsHeadDO.Emsappathgy.Sd_samptp;	        //标本类型	REF	标本类型_自定义档案	
            //path.Quan = emsHeadDO.Emsappathgy.Quan;       //标本需求量	SINGLE	String	quan	varchar	
            //path.Sd_colltp = emsHeadDO.Emsappathgy.Sd_colltp;        //采集方法	REF	采集方法_自定义档案	
            //path.Des_labsamp = emsHeadDO.Emsappathgy.;        //标本说明	SINGLE	String	des_
            path.Fg_urgent = emsHeadDO.Emsappathgy.Fg_urgent;        //加急	SINGLE	FBoolean	fg_urgent	
            path.Id_di = emsHeadDO.Emsappathgy.Id_di;       //诊断	SINGLE	String	id_di	varchar	50	 	
            path.Str_code_di = emsHeadDO.Str_code_di;        //诊断编码拼接	SINGLE	String	str_id_d
            path.Str_name_di = emsHeadDO.Str_name_di;    	//诊断名称拼接	SINGLE	String	str_
            path.Str_id_diitm = emsHeadDO.Str_id_diitm;    	//诊断名称拼接	SINGLE	String	str_
            path.Announcements = emsHeadDO.Emsappathgy.Announcements;    //检查要求	SINGLE	String	announce
            path.Des_sympsign = emsHeadDO.Emsappathgy.Des_sympsign;    //病情描述	SINGLE	String	des_symp
            path.Fg_outer = emsHeadDO.Emsappathgy.Fg_outer;        //是否外院标志	SINGLE	String	fg_outer
            path.No_pathgy_old = emsHeadDO.Emsappathgy.No_pathgy_old;	    //既往病理号	SINGLE	String	
            path.Dt_pathgy_old = emsHeadDO.Emsappathgy.Dt_pathgy_old;    //既往检查日期	SINGLE	FDateTime	
            path.Di_pathgy_old = emsHeadDO.Emsappathgy.Id_di_pathgy_old;    //既往检查诊断	SINGLE	String	
            path.Org_pathgy_old = emsHeadDO.Emsappathgy.Org_pathgy_old;   //既往检查医院	SINGLE	String	
            path.Collectdes = emsHeadDO.Emsappathgy.Collectdes;        //采集所见	SINGLE	String	collectd
            path.Id_emp = emsHeadDO.Emsappathgy.Id_emp_coll;          //采集者编码	REF	人员基本信息	id_e
            path.Id_dep = UserManager.getInstance().CurrentDept.Id_dep;          //采集者科室	REF	部门	
            path.Dt_coll = emsHeadDO.Emsappathgy.Dt_coll;            //标本采集时间	SINGLE	FDateTime	dt_c
            //path.Sd_su_pathgy	    //病理申请状态	REF	病理采集申请状态_自定义档案	sd_su_pathgy	varchar	20	
            path.No_pathgy = emsHeadDO.Emsappathgy.No_pathgy;	        //病理号	SINGLE	String	no_pathg
            path.Dt_rptpathgy = emsHeadDO.Emsappathgy.Dt_rptpathgy; //报告发布时间	SINGLE	FDateTime	
        }
        #endregion 保存时 病理申请单ci_ap_pathgy数据绑定

        #region 保存时 病理标本ci_pathgy_samp数据绑定
        public OrdApPathgySampDO SavePathgySampDataBing1(EmsItemInPathgy item, OrdApPathgySampDO samp) {
            //samp.Id_orpathgysamp(不赋值)	//主键	SINGLE	String	id  
            //samp.Id_or（不赋值）	            //医嘱主键	SINGLE	String  
            samp.Name_labsamp = item.Name_labsamp;	    //标本名称	SINGLE	String  
            samp.Body_coll = item.Body_coll;	        //采集部位	SINGLE	String  
            samp.Quan_coll = item.Quan_coll;	        //标本数量	SINGLE	Intege  
            samp.Fixative = item.Fixative;	        //固定液	SINGLE	Intege  
            samp.Sd_su_labsamp = item.Sd_su_labsamp;	    //检验标本状态编码	SINGLE  
            samp.Id_su_labsamp = item.Id_su_labsamp;	    //检验标本状态id	REF	 	id  
            samp.Id_dep_sign = item.Id_dep_sign;   //标本签收科室id	REF	部门	id  
            samp.Id_emp_sign = item.Id_emp_sign;	    //标本签收人员id	REF	用户	id  
            samp.Dt_sign = item.Dt_coll;        //签收时间	SINGLE	FDateT  
            samp.Sortno = item.Sortno;	            //序号	SINGLE	Integer    
            return samp;
        }


        #endregion 保存时 病理标本ci_pathgy_samp数据绑定

        #region 保存时 会诊医嘱主表or数据绑定
        public void SaveConsOrDataBing1(CiorderAggDO agg, EmsUIDTO emsHeadDO) {
            //agg.getParentDO().Fg_long = emsHeadDO.Emsdrugs.Fg_long; //长临标识
            agg.getParentDO().Code_or = emsHeadDO.PatInfo.Id_pat + CommonExtentions.NowTime(this).ToString(); //TODO: CODE 是否有生成标准？？？
            agg.getParentDO().Des_or = emsHeadDO.Emsapcons.Name_srv;//通用品
            //agg.getParentDO().Content_or = cof.GetOrDes(emsHeadDO); //  根据算法生成 医嘱内容test"; 

            //agg.getParentDO().Id_freq = emsHeadDO.Emsdrugs.Id_freq;  //医嘱频次
            agg.getParentDO().Id_dep_or = UserManager.getInstance().CurrentDept.Id_dep;
            agg.getParentDO().Fg_boil = false;//代煎标志
            //agg.getParentDO().Orders_boil= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Id_route = emsHeadDO.Emsdrugs.Id_route;//用法
            //agg.getParentDO().Id_routedes = emsHeadDO.Emsdrugs.Id_routedes; //用法要求
            //agg.getParentDO().Id_boil = emsHeadDO.Emsdrugs.Id_boil; //煎法
            //agg.getParentDO().Id_boildes = emsHeadDO.Emsdrugs.Id_boildes;//煎法要求

            agg.getParentDO().Dt_entry = CommonExtentions.NowTime(this);//开立日期
            //agg.getParentDO().Days_or = 1;//医嘱天数
            //agg.getParentDO().Fg_sign = emsHeadDO.Emsdrugs.//签署标识
            //agg.getParentDO().Id_emp_sign
            //agg.getParentDO().Id_dep_sign
            agg.getParentDO().Fg_long = false;//长临标志
            agg.getParentDO().Dt_effe = emsHeadDO.Emsapcons.Dt_creat;//开始日期 生效日期
            //agg.getParentDO().Dt_invalid = emsHeadDO.Emsdrugs.Dt_fail; //备用医嘱失效日期
            //agg.getParentDO().Fg_pmor = emsHeadDO.Emsdrugs.Fg_pmor;//备用医嘱标识
            //agg.getParentDO().Des_pmor = emsHeadDO.Emsdrugs.Bak_des;//备用医嘱使用条件
            //agg.getParentDO().Dt_lat          = emsHeadDO.Emsdrugs.//最近生成日期
            //agg.getParentDO().Fg_chk        = emsHeadDO.Emsdrugs.//核对日期 TODO: 医嘱确认时候 填充
            //agg.getParentDO().Id_emp_chk= emsHeadDO.Emsdrugs.//核对护士 
            //agg.getParentDO().Id_dep_chk = "";//核对病区
            //agg.getParentDO().Dt_chk        = emsHeadDO.Emsdrugs.//核对日期
            //agg.getParentDO().Fg_stop
            //agg.getParentDO().Id_emp_stop= emsHeadDO.Emsdrugs.
            //agg.getParentDO().Id_dep_stop
            //agg.getParentDO().Dt_stop = emsHeadDO.Emsdrugs.Dt_end_ui; //结束日期
            //agg.getParentDO().Fg_chk_stop
            //    agg.getParentDO().Id_emp_chk_stop
            //        agg.getParentDO().Id_dep_chk_stop
            //        agg.getParentDO().Dt_chk_stop
            //            agg.getParentDO().Fg_canc


            //agg.getParentDO().Id_emp_canc= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Id_dep_canc
            //agg.getParentDO().Dt_canc= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Fg_chk_canc 

            //agg.getParentDO().Id_emp_chk_canc= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Id_dep_mp= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Dt_chk_canc= emsHeadDO.Emsdrugs. //作废核对日期

            //agg.getParentDO().Fg_pmor = emsHeadDO.Emsdrugs.Fg_pmor;//备用医嘱标识
            //agg.getParentDO().Des_pmor = emsHeadDO.Emsdrugs.Bak_des;//备用医嘱条件
            //agg.getParentDO().Dt_invalid = emsHeadDO.Emsdrugs.Dt_fail;//备用医嘱失效日期
            //agg.getParentDO().Fg_active_pm = emsHeadDO.Emsdrugs //备用医嘱启用标识
            //agg.getParentDO().Id_reltp = emsHeadDO.Emsdrugs.
            //agg.getParentDO().Sd_reltp = emsHeadDO.Emsdrugs.//皮试医嘱关联类型
            //agg.getParentDO().Id_or_rel = emsHeadDO.Emsdrugs.
            //agg.getParentDO().Fg_bb = emsHeadDO.Emsdrugs//婴儿标识
            //agg.getParentDO().No_bb    = emsHeadDO.Emsdrugs.//婴儿序号

            //agg.getParentDO().Fg_ctlcp = false;//临床路径控制标识
            //agg.getParentDO().Fg_mr = false;//医疗记录联动标识


            // agg.getParentDO().Fg_skintest = emsHeadDO.Emsdrugs.Fg_skintest;//皮试标识

            agg.getParentDO().Fg_mp_in = false;//在院执行标识
            //agg.getParentDO().Times_mp_in
            //agg.getParentDO().Fg_mp_bed  = emsHeadDO.Emsdrugs.//床边执行标志
            //agg.getParentDO().Note_or = emsHeadDO.Emsdrugs.

        }

        #endregion 保存时 会诊医嘱主表or数据绑定

        #region 保存时 会诊医嘱服务表orsrv数据绑定
        public void SaveConsOrSrvDataBing1(EmsUIDTO emsHeadDO, OrdSrvDO order) {

            //order.Id_orsrv(不赋值)	    //服务项目主键标识	 
            //order.Id_or(不赋值)	        //医嘱	REF	临床 
            //order.Id_pres	(不赋值)        //药品处方	REF	 
            order.Id_pat = emsHeadDO.PatInfo.Id_pat;	        //患者	REF	患者 
            order.Id_entp = emsHeadDO.PatInfo.Id_entp;	        //就诊类型	REF	 
            order.Code_entp = emsHeadDO.PatInfo.Code_entp;	    //就诊类型编码	SING 
            order.Id_en = emsHeadDO.PatInfo.Id_ent;	        //就诊	REF	患者 
            //order.Sortno=	        //序号	SINGLE	 
            order.Id_srvtp = emsHeadDO.MedSrvDO.Id_srvtp;	    //服务类型	REF	 
            order.Sd_srvtp = emsHeadDO.MedSrvDO.Sd_srvtp;    //服务类型编码	SING 
            order.Id_srv = emsHeadDO.MedSrvDO.Id_srv;	        //服务项目	REF	 
            order.Name = emsHeadDO.Emsapcons.Name_srv;	        //服务项目名称	SING 
            order.Fg_dose_anoma = false;	//不规则剂量标识	 
            order.Quan_medu = emsHeadDO.Emsapcons.Sd_constp == "2" ? emsHeadDO.Emsapcons.EmsConsAssistItem.Count : 1;   // 数值_医疗单位	 
            //order.Id_medu	        // 医疗单位	REF	 
            //order.Id_route	=    // 医疗用法	REF	 
            //order.Id_routedes	    // 用法要求	REF	 
            //order.Id_boil  	    // 煎法	REF	医疗 
            //order.Id_boildes	    // 煎法要求	REF	 
            //order.Id_freq	        // 服务频次	REF	 
            order.Id_org_srv = UserManager.getInstance().CurrentOrg.Id_org;	    // 服务项目开立机构 
            order.Id_dep_srv = UserManager.getInstance().CurrentDept.Id_dep;	    // 服务项目开立科室 
            order.Id_wg_or = UserManager.getInstance().CurrentGroup.Id_grp;	    // 医生医疗组	REF	 
            order.Id_emp_srv = UserManager.getInstance().CurrentUser.Id_user;	    // 服务项目开立医生 
            order.Dt_create = CommonExtentions.NowTime(this);	    // 服务项目立时间	 
            //order.Id_org_mp	    // 执行机构	REF	 
            //order.Id_dep_mp	    // 执行科室	REF	 
            //order.Id_su_mp	    // 执行状态	REF	 
            //order.Sd_su_mp	    // 执行状态编码	 
            order.Id_su_bl = CiDictCodeConst.SD_SU_BL_NONE;    // 记账状态	REF	
            order.Sd_su_bl = CiDictCodeConst.SD_SU_BL_NONE_ID; // 记账状态编码	
            //order.Dt_last_mp	    // 最近执行日期	 
            //order.Dt_last_bl	    // 最近生成日期	 
            //order.Fg_or	        // 医嘱标识	SING 
            //order.Eu_blmd	        // 记费模式	REF	 
            //order.Fg_mm	        // 物品标识	SING 
            order.Pri = emsHeadDO.MedSrvDO.Pri;           // 参考价格	SING 
            //order.Fg_set	        // 服务套标识	SING 
            //order.Fg_indic	    // 医保适应症标识	 
            //order.Fg_propc	    // 是否预防用药	 
            //order.Fg_self   	    // 是否自备药	SING 
            //order.Fg_pres_outp    // 	出院带药标识	 
            order.Note_srv = emsHeadDO.Emsapcons.Name_srv;	    // 服务备注	SING 
            order.Id_srvca = emsHeadDO.MedSrvDO.Id_srvca;    // 服务项目分类	 
            //order.Fg_bl	        // 收费标识	SING 
            order.Code_srv = emsHeadDO.MedSrvDO.Code;	    // 服务项目编码	S 



        }

        #endregion 保存时 会诊医嘱服务表orsrv数据绑定





        #region 保存时 会诊ci_ap_cons数据绑定
        public OrdApConsDO SaveConsDataBing1(EmsUIDTO emsHeadDO, OrdApConsDO cons) {
            //cons.Id_orcons(不赋值)	    // 医嘱会诊申请主键标识	SINGLE	FID	i 
            //cons.Id_or(不赋值)	        //医嘱	REF	临床医嘱	id_or	varch 
            cons.No_applyform = cof.getNo();	//会诊申请单号	SINGLE	String	no_ap 
            //cons.Id_constp=	emsHeadDO.Emsapcons    // 会诊类型	REF	会诊类型_自定义档案	i 
            //cons.Sd_constp	=	emsHeadDO.Emsapcons   // 会诊类型编码	SINGLE	String	s 
            cons.Dt_ap = emsHeadDO.Emsapcons.Dt_creat;   //  申请时间	SINGLE	FDateTime	d 
            cons.Des_emr = emsHeadDO.Emsapcons.Des_emr;   //病历摘要	SINGLE	备注	des_emr	v 
            cons.Dt_plan = emsHeadDO.Emsapcons.Dt_plan;  //计划会诊时间	SINGLE	FDateTime	d 
            //cons.Id_place = emsHeadDO.Emsapcons.Id_place;  //计划会诊地点	REF	地点	id_place	v 
            cons.Des_psp = emsHeadDO.Emsapcons.Des_psp;  //申请目的	SINGLE	备注	des_psp	v 
            cons.Id_su_cons = CiDictCodeConst.SD_SU_CONS_PLAN_ID; //会诊申请状态	REF	会诊申请状态_自定义档 
            cons.Sd_su_cons = CiDictCodeConst.SD_SU_CONS_PLAN;  //会诊申请状态编码	SINGLE	String
            cons.Tel = emsHeadDO.Emsapcons.Tel;
            cons.Fg_urgent = emsHeadDO.Emsapcons.Fg_urgent;//加急标识
            return cons;
        }


        #endregion 保存时 会诊ci_ap_cons数据绑定


        #region 保存时  会诊应邀科室ci_invite_cons数据绑定

        public CiordInviteConsDO SaveConsInvite1(EmsItemInCons item, CiordInviteConsDO cons, string id_cons) {
            cons.Id_invitecons = item.Id_emsitemincons;// 	主键	SINGLE	 
            cons.Id_apcons = id_cons;// 	      会诊申请单id	SIN 
            cons.Id_org = item.Id_org;            //受邀机构id	REF	组织	id_org	 
            cons.Id_dep = item.Id_dep_emp;          //受邀科室id	REF	部门	id_dep	 
            cons.Id_emp = item.Id_emp_doctor;          //受邀人	REF	用户	id_emp	var 
            cons.Sd_emp_title = item.Sd_emp_title;  //受邀人职称编码	SINGLE	 
            cons.Id_emp_title = item.Id_emp_title;   //受邀人职称id	REF	人员 
            cons.Fg_response = item.Fg_response;   //应邀标志	SINGLE	FBo 
            cons.Dt_response = item.Dt_response;   //应答时间	SINGLE	FDa 
            cons.Id_emp_response = item.Id_emp_response;	//应答人	REF	用户 
            cons.Sv = item.Sv;
            cons.Status = item.Status;
            return cons;
        }




        #endregion 保存时  会诊应邀科室ci_invite_cons数据绑定



        #region 保存时 转科or数据绑定
        public void SaveTransOrDataBing1(CiorderAggDO agg, EmsUIDTO emsHeadDO) {
            //agg.getParentDO().Fg_long = emsHeadDO.Emsdrugs.Fg_long; //长临标识
            agg.getParentDO().Code_or = emsHeadDO.PatInfo.Id_pat + CommonExtentions.NowTime(this).ToString(); //TODO: CODE 是否有生成标准？？？
            agg.getParentDO().Des_or = emsHeadDO.MedSrvDO.Name;//通用品
            //agg.getParentDO().Content_or = cof.GetOrDes(emsHeadDO); //  根据算法生成 医嘱内容test"; 

            //agg.getParentDO().Id_freq = emsHeadDO.Emsdrugs.Id_freq;  //医嘱频次
            agg.getParentDO().Id_dep_or = UserManager.getInstance().CurrentDept.Id_dep;
            agg.getParentDO().Fg_boil = false;//代煎标志
            //agg.getParentDO().Orders_boil= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Id_route = emsHeadDO.Emsdrugs.Id_route;//用法
            //agg.getParentDO().Id_routedes = emsHeadDO.Emsdrugs.Id_routedes; //用法要求
            //agg.getParentDO().Id_boil = emsHeadDO.Emsdrugs.Id_boil; //煎法
            //agg.getParentDO().Id_boildes = emsHeadDO.Emsdrugs.Id_boildes;//煎法要求

            agg.getParentDO().Dt_entry = CommonExtentions.NowTime(this);//开立日期
            //agg.getParentDO().Days_or = 1;//医嘱天数
            //agg.getParentDO().Fg_sign = emsHeadDO.Emsdrugs.//签署标识
            //agg.getParentDO().Id_emp_sign
            //agg.getParentDO().Id_dep_sign
            agg.getParentDO().Fg_long = false;//长临标志
            agg.getParentDO().Dt_effe = CommonExtentions.NowTime(this);//开始日期 生效日期
            //agg.getParentDO().Dt_invalid = emsHeadDO.Emsdrugs.Dt_fail; //备用医嘱失效日期
            //agg.getParentDO().Fg_pmor = emsHeadDO.Emsdrugs.Fg_pmor;//备用医嘱标识
            //agg.getParentDO().Des_pmor = emsHeadDO.Emsdrugs.Bak_des;//备用医嘱使用条件
            //agg.getParentDO().Dt_lat          = emsHeadDO.Emsdrugs.//最近生成日期
            //agg.getParentDO().Fg_chk        = emsHeadDO.Emsdrugs.//核对日期 TODO: 医嘱确认时候 填充
            //agg.getParentDO().Id_emp_chk= emsHeadDO.Emsdrugs.//核对护士 
            //agg.getParentDO().Id_dep_chk = "";//核对病区
            //agg.getParentDO().Dt_chk        = emsHeadDO.Emsdrugs.//核对日期
            //agg.getParentDO().Fg_stop
            //agg.getParentDO().Id_emp_stop= emsHeadDO.Emsdrugs.
            //agg.getParentDO().Id_dep_stop
            //agg.getParentDO().Dt_stop = emsHeadDO.Emsdrugs.Dt_end_ui; //结束日期
            //agg.getParentDO().Fg_chk_stop
            //    agg.getParentDO().Id_emp_chk_stop
            //        agg.getParentDO().Id_dep_chk_stop
            //        agg.getParentDO().Dt_chk_stop
            //            agg.getParentDO().Fg_canc


            //agg.getParentDO().Id_emp_canc= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Id_dep_canc
            //agg.getParentDO().Dt_canc= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Fg_chk_canc 

            //agg.getParentDO().Id_emp_chk_canc= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Id_dep_mp= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Dt_chk_canc= emsHeadDO.Emsdrugs. //作废核对日期

            //agg.getParentDO().Fg_pmor = emsHeadDO.Emsdrugs.Fg_pmor;//备用医嘱标识
            //agg.getParentDO().Des_pmor = emsHeadDO.Emsdrugs.Bak_des;//备用医嘱条件
            //agg.getParentDO().Dt_invalid = emsHeadDO.Emsdrugs.Dt_fail;//备用医嘱失效日期
            //agg.getParentDO().Fg_active_pm = emsHeadDO.Emsdrugs //备用医嘱启用标识
            //agg.getParentDO().Id_reltp = emsHeadDO.Emsdrugs.
            //agg.getParentDO().Sd_reltp = emsHeadDO.Emsdrugs.//皮试医嘱关联类型
            //agg.getParentDO().Id_or_rel = emsHeadDO.Emsdrugs.
            //agg.getParentDO().Fg_bb = emsHeadDO.Emsdrugs//婴儿标识
            //agg.getParentDO().No_bb    = emsHeadDO.Emsdrugs.//婴儿序号

            //agg.getParentDO().Fg_ctlcp = false;//临床路径控制标识
            //agg.getParentDO().Fg_mr = false;//医疗记录联动标识


            //agg.getParentDO().Fg_skintest = emsHeadDO.Emsdrugs.Fg_skintest;//皮试标识

            agg.getParentDO().Fg_mp_in = false;//在院执行标识
            //agg.getParentDO().Times_mp_in
            //agg.getParentDO().Fg_mp_bed  = emsHeadDO.Emsdrugs.//床边执行标志
            //agg.getParentDO().Note_or = emsHeadDO.Emsdrugs.
        }

        #endregion 保存时 转科or数据绑定

        #region 保存时 转科orsrv数据绑定
        public void SaveTransOrSrvDataBing1(EmsUIDTO emsHeadDO, OrdSrvDO order) {

            //order.Id_orsrv(不赋值)	    //服务项目主键标识	 
            //order.Id_or(不赋值)	        //医嘱	REF	临床 
            //order.Id_pres	(不赋值)        //药品处方	REF	 
            order.Id_pat = emsHeadDO.PatInfo.Id_pat;	        //患者	REF	患者 
            order.Id_entp = emsHeadDO.PatInfo.Id_entp;	        //就诊类型	REF	 
            order.Code_entp = emsHeadDO.PatInfo.Code_entp;	    //就诊类型编码	SING 
            order.Id_en = emsHeadDO.PatInfo.Id_ent;	        //就诊	REF	患者 
            //order.Sortno=	        //序号	SINGLE	 
            order.Id_srvtp = emsHeadDO.MedSrvDO.Id_srvtp;	    //服务类型	REF	 
            order.Sd_srvtp = emsHeadDO.MedSrvDO.Sd_srvtp;    //服务类型编码	SING 
            order.Id_srv = emsHeadDO.MedSrvDO.Id_srv;	        //服务项目	REF	 
            order.Name = emsHeadDO.MedSrvDO.Name;//服务项目名称	SING 
            order.Fg_dose_anoma = false;	//不规则剂量标识	 
            //order.Quan_medu = emsHeadDO.Emsapcons.Sd_constp == "2" ? emsHeadDO.Emsapcons.EmsConsAssistItem.Count : 1;   // 数值_医疗单位	 
            //order.Id_medu	        // 医疗单位	REF	 
            //order.Id_route	=    // 医疗用法	REF	 
            //order.Id_routedes	    // 用法要求	REF	 
            //order.Id_boil  	    // 煎法	REF	医疗 
            //order.Id_boildes	    // 煎法要求	REF	 
            //order.Id_freq	        // 服务频次	REF	 
            order.Id_org_srv = UserManager.getInstance().CurrentOrg.Id_org;	    // 服务项目开立机构 
            order.Id_dep_srv = UserManager.getInstance().CurrentDept.Id_dep;	    // 服务项目开立科室 
            order.Id_wg_or = UserManager.getInstance().CurrentGroup.Id_grp;	    // 医生医疗组	REF	 
            order.Id_emp_srv = UserManager.getInstance().CurrentUser.Id_user;	    // 服务项目开立医生 
            order.Dt_create = CommonExtentions.NowTime(this);	    // 服务项目立时间	 
            //order.Id_org_mp	    // 执行机构	REF	 
            //order.Id_dep_mp	    // 执行科室	REF	 
            //order.Id_su_mp	    // 执行状态	REF	 
            //order.Sd_su_mp	    // 执行状态编码	 
            order.Id_su_bl = CiDictCodeConst.SD_SU_BL_NONE;    // 记账状态	REF	
            order.Sd_su_bl = CiDictCodeConst.SD_SU_BL_NONE_ID; // 记账状态编码	
            //order.Dt_last_mp	    // 最近执行日期	 
            //order.Dt_last_bl	    // 最近生成日期	 
            //order.Fg_or	        // 医嘱标识	SING 
            //order.Eu_blmd	        // 记费模式	REF	 
            //order.Fg_mm	        // 物品标识	SING 
            order.Pri = emsHeadDO.MedSrvDO.Pri;           // 参考价格	SING 
            //order.Fg_set	        // 服务套标识	SING 
            //order.Fg_indic	    // 医保适应症标识	 
            //order.Fg_propc	    // 是否预防用药	 
            //order.Fg_self   	    // 是否自备药	SING 
            //order.Fg_pres_outp    // 	出院带药标识	 
            order.Note_srv = emsHeadDO.MedSrvDO.Name;	    // 服务备注	SING 
            order.Id_srvca = emsHeadDO.MedSrvDO.Id_srvca;    // 服务项目分类	 
            //order.Fg_bl	        // 收费标识	SING 
            order.Code_srv = emsHeadDO.MedSrvDO.Code;	    // 服务项目编码	S 



        }

        #endregion 保存时 转科orsrv数据绑定

        #region 保存时 转科ci_ap_trans数据绑定
        public OrdApTransDO SaveApTransDataBing1(EmsUIDTO emsHeadDO, OrdApTransDO trans) {
            //trans.Id_ortrans	    //医嘱转科属性主键标识	SINGLE	FID	id_ortrans	char	20	 	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            //trans. Id_or	        //医嘱	REF	临床医嘱	id_or	varchar	20	 	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	aNaNb2
            trans.Id_dep_to = emsHeadDO.Emsaptrans.Id_dep_to;	    //目标科室	REF	部门	id_dep_to	varchar	20	 	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	aNaNb3
            trans.Id_dep_nur_to = emsHeadDO.Emsaptrans.Id_dep_nur_to;	//目标病区	REF	部门	id_dep_nur_to	varchar	20	 	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	aNaNb4
            //trans. Id_dep_from=     //原科室	REF	部门	id_dep_from	varchar	20	 	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	aNaNb5
            //trans. Id_dep_nur_from	//原病区	REF	部门	id_dep_nur_from	varchar	20	 	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	aNaNb6
            //trans. Id_su_trans	    //转科过程状态	REF	转科过程状态_自定义档案	id_su_trans	varchar	20	转科过程状态_自定义档案	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	aNaNb7
            //trans. Sd_su_trans	    //转科过程状态编码	SINGLE	String	sd_su_trans	varchar	50	 	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            trans.Dt_trans_apply = CommonExtentions.NowTime(this);	//转科申请时间	SINGLE	FDateTime	dt_trans_apply	char	19	 	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            trans.Des_rea_canc = emsHeadDO.Emsaptrans.Des_rea_canc;	    //转科申请原因	SINGLE	备注	des_rea_canc	varchar	300	 	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            trans.Fg_tech_trans = emsHeadDO.Emsaptrans.Fg_tech_trans;	//转医技科室	SINGLE	String
            return trans;
        }


        #endregion 保存时 转科ci_ap_trans数据绑定

        #region 保存时 出院or数据绑定
        public void SaveOutOrDataBing1(CiorderAggDO agg, EmsUIDTO emsHeadDO) {
            //agg.getParentDO().Fg_long = emsHeadDO.Emsdrugs.Fg_long; //长临标识
            agg.getParentDO().Code_or = emsHeadDO.PatInfo.Id_pat + CommonExtentions.NowTime(this).ToString(); //TODO: CODE 是否有生成标准？？？
            agg.getParentDO().Des_or = emsHeadDO.MedSrvDO.Name;//通用品
            //agg.getParentDO().Content_or = cof.GetOrDes(emsHeadDO); //  根据算法生成 医嘱内容test"; 

            //agg.getParentDO().Id_freq = emsHeadDO.Emsdrugs.Id_freq;  //医嘱频次
            agg.getParentDO().Id_dep_or = UserManager.getInstance().CurrentDept.Id_dep;
            agg.getParentDO().Fg_boil = false;//代煎标志
            //agg.getParentDO().Orders_boil= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Id_route = emsHeadDO.Emsdrugs.Id_route;//用法
            //agg.getParentDO().Id_routedes = emsHeadDO.Emsdrugs.Id_routedes; //用法要求
            //agg.getParentDO().Id_boil = emsHeadDO.Emsdrugs.Id_boil; //煎法
            //agg.getParentDO().Id_boildes = emsHeadDO.Emsdrugs.Id_boildes;//煎法要求

            agg.getParentDO().Dt_entry = CommonExtentions.NowTime(this);//开立日期
            //agg.getParentDO().Days_or = 1;//医嘱天数
            //agg.getParentDO().Fg_sign = emsHeadDO.Emsdrugs.//签署标识
            //agg.getParentDO().Id_emp_sign
            //agg.getParentDO().Id_dep_sign
            agg.getParentDO().Fg_long = false;//长临标志
            agg.getParentDO().Dt_effe = CommonExtentions.NowTime(this);//开始日期 生效日期
            //agg.getParentDO().Dt_invalid = emsHeadDO.Emsdrugs.Dt_fail; //备用医嘱失效日期
            //agg.getParentDO().Fg_pmor = emsHeadDO.Emsdrugs.Fg_pmor;//备用医嘱标识
            //agg.getParentDO().Des_pmor = emsHeadDO.Emsdrugs.Bak_des;//备用医嘱使用条件
            //agg.getParentDO().Dt_lat          = emsHeadDO.Emsdrugs.//最近生成日期
            //agg.getParentDO().Fg_chk        = emsHeadDO.Emsdrugs.//核对日期 TODO: 医嘱确认时候 填充
            //agg.getParentDO().Id_emp_chk= emsHeadDO.Emsdrugs.//核对护士 
            //agg.getParentDO().Id_dep_chk = "";//核对病区
            //agg.getParentDO().Dt_chk        = emsHeadDO.Emsdrugs.//核对日期
            //agg.getParentDO().Fg_stop
            //agg.getParentDO().Id_emp_stop= emsHeadDO.Emsdrugs.
            //agg.getParentDO().Id_dep_stop
            //agg.getParentDO().Dt_stop = emsHeadDO.Emsdrugs.Dt_end_ui; //结束日期
            //agg.getParentDO().Fg_chk_stop
            //    agg.getParentDO().Id_emp_chk_stop
            //        agg.getParentDO().Id_dep_chk_stop
            //        agg.getParentDO().Dt_chk_stop
            //            agg.getParentDO().Fg_canc


            //agg.getParentDO().Id_emp_canc= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Id_dep_canc
            //agg.getParentDO().Dt_canc= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Fg_chk_canc 

            //agg.getParentDO().Id_emp_chk_canc= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Id_dep_mp= emsHeadDO.Emsdrugs. 
            //agg.getParentDO().Dt_chk_canc= emsHeadDO.Emsdrugs. //作废核对日期

            //agg.getParentDO().Fg_pmor = emsHeadDO.Emsdrugs.Fg_pmor;//备用医嘱标识
            //agg.getParentDO().Des_pmor = emsHeadDO.Emsdrugs.Bak_des;//备用医嘱条件
            //agg.getParentDO().Dt_invalid = emsHeadDO.Emsdrugs.Dt_fail;//备用医嘱失效日期
            //agg.getParentDO().Fg_active_pm = emsHeadDO.Emsdrugs //备用医嘱启用标识
            //agg.getParentDO().Id_reltp = emsHeadDO.Emsdrugs.
            //agg.getParentDO().Sd_reltp = emsHeadDO.Emsdrugs.//皮试医嘱关联类型
            //agg.getParentDO().Id_or_rel = emsHeadDO.Emsdrugs.
            //agg.getParentDO().Fg_bb = emsHeadDO.Emsdrugs//婴儿标识
            //agg.getParentDO().No_bb    = emsHeadDO.Emsdrugs.//婴儿序号

            //agg.getParentDO().Fg_ctlcp = false;//临床路径控制标识
            //agg.getParentDO().Fg_mr = false;//医疗记录联动标识


            //agg.getParentDO().Fg_skintest = emsHeadDO.Emsdrugs.Fg_skintest;//皮试标识

            agg.getParentDO().Fg_mp_in = false;//在院执行标识
            //agg.getParentDO().Times_mp_in
            //agg.getParentDO().Fg_mp_bed  = emsHeadDO.Emsdrugs.//床边执行标志
            //agg.getParentDO().Note_or = emsHeadDO.Emsdrugs.
        }

        #endregion 保存时 出院or数据绑定

        #region 保存时 出院orsrv数据绑定
        public void SaveOutOrSrvDataBing1(EmsUIDTO emsHeadDO, OrdSrvDO order) {
            //order.Id_orsrv(不赋值)	    //服务项目主键标识	 
            //order.Id_or(不赋值)	        //医嘱	REF	临床 
            //order.Id_pres	(不赋值)        //药品处方	REF	 
            order.Id_pat = emsHeadDO.PatInfo.Id_pat;	        //患者	REF	患者 
            order.Id_entp = emsHeadDO.PatInfo.Id_entp;	        //就诊类型	REF	 
            order.Code_entp = emsHeadDO.PatInfo.Code_entp;	    //就诊类型编码	SING 
            order.Id_en = emsHeadDO.PatInfo.Id_ent;	        //就诊	REF	患者 
            //order.Sortno=	        //序号	SINGLE	 
            order.Id_srvtp = emsHeadDO.MedSrvDO.Id_srvtp;	    //服务类型	REF	 
            order.Sd_srvtp = emsHeadDO.MedSrvDO.Sd_srvtp;    //服务类型编码	SING 
            order.Id_srv = emsHeadDO.MedSrvDO.Id_srv;	        //服务项目	REF	 
            order.Name = emsHeadDO.MedSrvDO.Name;//服务项目名称	SING 
            order.Fg_dose_anoma = false;	//不规则剂量标识	 
            //order.Quan_medu = emsHeadDO.Emsapcons.Sd_constp == "2" ? emsHeadDO.Emsapcons.EmsConsAssistItem.Count : 1;   // 数值_医疗单位	 
            //order.Id_medu	        // 医疗单位	REF	 
            //order.Id_route	=    // 医疗用法	REF	 
            //order.Id_routedes	    // 用法要求	REF	 
            //order.Id_boil  	    // 煎法	REF	医疗 
            //order.Id_boildes	    // 煎法要求	REF	 
            //order.Id_freq	        // 服务频次	REF	 
            order.Id_org_srv = UserManager.getInstance().CurrentOrg.Id_org;	    // 服务项目开立机构 
            order.Id_dep_srv = UserManager.getInstance().CurrentDept.Id_dep;	    // 服务项目开立科室 
            order.Id_wg_or = UserManager.getInstance().CurrentGroup.Id_grp;	    // 医生医疗组	REF	 
            order.Id_emp_srv = UserManager.getInstance().CurrentUser.Id_user;	    // 服务项目开立医生 
            order.Dt_create = CommonExtentions.NowTime(this);	    // 服务项目立时间	 
            //order.Id_org_mp	    // 执行机构	REF	 
            //order.Id_dep_mp	    // 执行科室	REF	 
            //order.Id_su_mp	    // 执行状态	REF	 
            //order.Sd_su_mp	    // 执行状态编码	 
            order.Id_su_bl = CiDictCodeConst.SD_SU_BL_NONE;    // 记账状态	REF	
            order.Sd_su_bl = CiDictCodeConst.SD_SU_BL_NONE_ID; // 记账状态编码	
            //order.Dt_last_mp	    // 最近执行日期	 
            //order.Dt_last_bl	    // 最近生成日期	 
            //order.Fg_or	        // 医嘱标识	SING 
            //order.Eu_blmd	        // 记费模式	REF	 
            //order.Fg_mm	        // 物品标识	SING 
            order.Pri = emsHeadDO.MedSrvDO.Pri;           // 参考价格	SING 
            //order.Fg_set	        // 服务套标识	SING 
            //order.Fg_indic	    // 医保适应症标识	 
            //order.Fg_propc	    // 是否预防用药	 
            //order.Fg_self   	    // 是否自备药	SING 
            //order.Fg_pres_outp    // 	出院带药标识	 
            order.Note_srv = emsHeadDO.MedSrvDO.Name;	    // 服务备注	SING 
            order.Id_srvca = emsHeadDO.MedSrvDO.Id_srvca;    // 服务项目分类	 
            //order.Fg_bl	        // 收费标识	SING 
            order.Code_srv = emsHeadDO.MedSrvDO.Code;	    // 服务项目编码	S 

        }
        #endregion 保存时 出院orsrv数据绑定

        #region 保存时 出院ci_ap_out数据绑定
        public OrdApOutDO SaveApOutDataBing1(EmsUIDTO emsHeadDO, OrdApOutDO apout) {
            //apout.Id_orout	    //医嘱出院属性主键标识	SINGLE	 
            //apout.Id_or	        //医嘱	REF	临床医嘱	id_or	 
            apout.Id_dep_out = emsHeadDO.Emsapout.Id_dep_out;	    //出院科室	REF	部门	id_dep_o 
            apout.Id_dep_nur_out = emsHeadDO.Emsapout.Id_dep_nur_out;	//出院病区	REF	部门	id_dep_n 
            apout.Id_bed_out = emsHeadDO.Emsapout.Id_bed_out;	    //出院床位	REF	床位	id_bed_o 
            apout.Fg_again31 = emsHeadDO.Emsapout.Fg_again31;	    //31日内再次计划住院标识	SING 
            apout.Des_again31 = emsHeadDO.Emsapout.Des_again31;	    //31日内再入院目的	SINGLE	备注	 
            apout.Id_outtp = emsHeadDO.Emsapout.Id_outtp;	    //离院方式id	REF	离院方式_自定义 
            apout.Sd_outtp = emsHeadDO.Emsapout.Sd_outtp;	    //离院方式编码	SINGLE	String	 
            apout.Des_outtp = emsHeadDO.Emsapout.Des_outtp;	    //离院描述	SINGLE	String
            return apout;
        }
        #endregion 保存时 出院ci_ap_out数据绑定



        #endregion 保存时  数据绑定

        #region 无用的

        //EmsUIDTO emsDO;
        //OrderSrvSetViewModel orSet = new OrderSrvSetViewModel(); 
        //viewmodel.OrderSaveViewModel model = new OrderSaveViewModel();//不可引用 因为 这个已经引用过OrDataBing 了再引用会造成循环引用 堆栈溢出
        
        #endregion
    }
}
