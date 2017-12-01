using System;
using System.Collections.Generic;
using System.Linq;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.medsrv.i;
using iih.ci.ord.cior.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.ci.ord.dto.d;
using iih.ci.ord.ems.d;
using xap.mw.core.data;
using iih.ci.ord.ordsrvdose.d;
using xap.mw.serviceframework;
using iih.ci.ord.ordsrvset.d;
using iih.bd.bc.udi;
using iih.bd.pp.primd.i;
using iih.ci.ord.ciorder.d;

namespace iih.ci.ord.ciorder.utils {
    /// <summary>
    /// ems to uiems 的编辑类
    /// zhou_zhijian 7.3做阅读注释
    /// </summary>
    public class OrCIEmsTOUIEms {
        /// <summary>
        /// 
        /// </summary>
        LogicEx cof = LogicEx.GetInstance();

        #region 编辑 检验医疗单
        public void EditEmsLab(EmsUIDTO headDo, CiEmsDTO dto) {
            EditHeadCommon(dto, headDo);
            FArrayList lsit = dto.Emssrvs;
            OrdApLabDO aplab = dto.Orapplysheet[((int)EmsType.LIS).ToString()] as OrdApLabDO;
            CiEmsSrvDTO srv = dto.Emssrvs[0] as CiEmsSrvDTO;

            if (dto.Fg_set != null && dto.Fg_set.Value)
            {
               // FMap2 medsrvMap = dto.Mapinfo;
               // MedSrvDO mesrv = (MedSrvDO)medsrvMap[dto.Id_srv];
                srv.Id_dep = dto.Id_dep_mp;
               
            }
            else
            {
                   srv = dto.Emssrvs.Cast<CiEmsSrvDTO>().FirstOrDefault(p => p.Id_srv.Equals(dto.Id_srv)); // 寻找主服务
            }
          
            headDo.Emsaplab.Id_orsrv = srv.Id_orsrv;
            headDo.Emsaplab.Id_srv = dto.Id_srv;	                //服务id	SING  	 	
            headDo.Emsaplab.Name_srv = dto.Name;	            //服务名称	SING  	 	
            headDo.Emsaplab.Id_srvtp = dto.Id_srvtp;	            //服务类型	  	 
            headDo.Emsaplab.No_applyobs = aplab.No_applyform;
            headDo.Emsaplab.Fg_urgent = aplab.Fg_urgent;	            //加急标识	SINGLE	FBoo 	
            headDo.Emsaplab.Dt_plan = aplab.Dt_plan;                //计划检查时间	SINGLE	FDat  	
            headDo.Emsaplab.Id_di = aplab.Id_di;	                //诊断id	REF	医疗服务_疾病诊  	 	
            headDo.Emsaplab.Name_diag = aplab.Name_diag;             //诊断	SINGLE	String	 
            headDo.Emsaplab.Id_diitm = aplab.Id_diitm;
            // 诊断id
            string[] diagArray = new GetPatDiagImp().getDiagArray(headDo.PatInfo.Id_ent);
            if (diagArray != null)
            {
                headDo.Emsaplab.Str_code_di = diagArray[1];//诊断编码拼接
                headDo.Emsaplab.Str_name_di = diagArray[0];//诊断名称拼接
                headDo.Emsaplab.Str_id_diitm = diagArray[2];//诊断子项目id拼接
            }
            headDo.Emsaplab.Sd_pps = aplab.Sd_pps;	                //检查目的编码	SINGLE	Stri 
            headDo.Emsaplab.Id_pps = aplab.Id_pps;	                //检查目的	SINGLE	Stri 
            headDo.Emsaplab.Des_pps = aplab.Des_pps;                //检查目的描述	SINGLE	Stri 
            headDo.Emsaplab.Name_pps = aplab.Name_pps;
            headDo.Emsaplab.Des_sympsign = aplab.Des_sympsign;	        //症状体征描述	SINGLE	Stri 
            headDo.Emsaplab.Id_body = srv.Id_body;                //身体部位id	REF	部位编码_ 	 	 	 	
            headDo.Emsaplab.Sd_body = srv.Sd_body;                //身体部位编码	SINGLE	Stri 
            headDo.Emsaplab.Announcements = aplab.Announcements;
            headDo.Emsaplab.Name_samptp = aplab.Name_samptp;
            headDo.Emsaplab.Id_samptp = aplab.Id_samptp;
            headDo.Emsaplab.Sd_samptp = aplab.Sd_samptp;
            // 新增#
            headDo.Emsaplab.Quan_med = dto.Quan_medu;
            headDo.Emsaplab.Id_unit_med = dto.Id_unit_med;
            headDo.Emsaplab.Name_unit_med = dto.Name_unit_med;
            //             headDo.Emsaplab.Id_unit_base = dto.Id_unit_base;
            //             headDo.Emsaplab.Name_unit_base = dto.Name_unit_base;
            //             headDo.Emsaplab.Quan_base = dto.Quan_base;
            headDo.Emsaplab.Id_unit_sale = dto.Id_unit_med;
            headDo.Emsaplab.Name_unit_sale = dto.Name_unit_med;
            headDo.Emsaplab.Quan_cur = dto.Times_cur;
            headDo.Emsaplab.Price = srv.Price ;
            headDo.Emsaplab.Use_days = dto.Days_or;
            headDo.Emsaplab.Id_mp_dep = srv.Id_dep;
            headDo.Emsaplab.Name_mp_dep = srv.Name_dep;
            headDo.Emsaplab.Fg_indic = srv.Fg_indic;

            //标本采集时间

            headDo.Emsaplab.Id_sampcoltime = aplab.Id_sampcoltime;//标本采集时间
            headDo.Emsaplab.Id_sampcollecttimetp = aplab.Id_sampcollecttimetp;//标本采集时间类型
            headDo.Emsaplab.Sd_sampcollecttimetp = aplab.Sd_sampcollecttimetp;//标本采集时间类型编码
            headDo.Emsaplab.Len_sampcoltime = aplab.Len_sampcoltime;//标本采集时长
            headDo.Emsaplab.Id_unit_sampcoltime = aplab.Id_unit_sampcoltime;//标本采集时间时长单位
            headDo.Emsaplab.Name_sampcoltime = aplab.Name_sampcoltime;//标本采集时间名称

            if ((bool)dto.Fg_set) {
                // 覆盖相关的数据 - wqz  服务套DTO 没有计价模式字段
                IMedsrvMDOCrudService service = XapServiceMgr.find<IMedsrvMDOCrudService>();
                MedSrvDO medSrvDO = service.findById(dto.Id_srv);
                if( null != medSrvDO)
                {
                    headDo.Emsaplab.Price = GetOrderSvrPrice(medSrvDO.Id_primd, dto.Emssrvs);// srv.Price; // 需要根据定价模式来计算一下
                }
                else
                {
                    headDo.Emsaplab.Price = 0;
                }
                
                headDo.Emsaplab.Use_days = dto.Days_or;
                // 执行科室，待定...
                //                 headDo.Emsapobs.Id_mp_dep = dto.Id_dep_mp;
                //                 headDo.Emsapobs.Name_mp_dep = dto.Name_dep_mp;
                headDo.Emsaplab.Id_unit_med = dto.Id_unit_med;
                headDo.Emsaplab.Name_unit_med = dto.Name_unit_med;
                headDo.Emsaplab.Quan_med = dto.Quan_medu;
                headDo.Emsaplab.Id_unit_sale = dto.Id_unit_med;
                headDo.Emsaplab.Name_unit_sale = dto.Name_unit_med;
                headDo.Emsaplab.Quan_cur = dto.Times_cur;
                headDo.Emsaplab.Use_days = dto.Days_or;
                headDo.Emsaplab.Dt_begin_ui = dto.Dt_begin;
                headDo.Emsaplab.Dt_end_ui = dto.Dt_end;
                headDo.Emsaplab.Times_cur = dto.Times_cur;
                headDo.Emsaplab.Times_mp_in = dto.Times_mp_in;
                headDo.Emsaplab.Fg_set = dto.Fg_set;
                FMap map = dto.Srvsetitms;
                FArrayList SetItems = new FArrayList();
                if(map!=null)
                    SetItems = (FArrayList)map[dto.Id_srv];
                OrdSrvSetDO[] selectSetItems = new OrdSrvSetDO[SetItems.Count];
                int i = 0;
                foreach (OrdSrvSetDO item in SetItems) {
                    selectSetItems[i] = item;
                    i++;
                }
                GetSrvSetImp srvset = new GetSrvSetImp();
                List<MedSrvSetItemDO> setitemList = srvset.GetItemInSet(dto.Id_srv);
                GetMedSrvImpl medSrv = new GetMedSrvImpl();
                MedsrvAggDO[] medsrvagg = medSrv.getMedSrvDO(setitemList);
                List<CiEmsSrvDTO> emslist = new List<CiEmsSrvDTO>();
                foreach (CiEmsSrvDTO ems in dto.Emssrvs)
                {
                    emslist.Add(ems);
                }
                foreach(MedsrvAggDO aggDO in medsrvagg){
                    MedSrvDO medsrvdo = aggDO.getParentDO();
                    MedSrvSetItemDO setItem = setitemList.FirstOrDefault(p => p.Id_srv_itm == medsrvdo.Id_srv);
                    if ((bool)setItem.Fg_clinical) {
                        EmsObsLap lab = new EmsObsLap();
                        lab.Name_srv = setItem.Set_name;
                        lab.Id_srv = setItem.Id_srv_itm;
                        lab.Id_or = dto.Id_or;
                        lab.Fg_edit = setItem.Fg_edit;
                        //lab.Quan_medu = dto.Quan_medu;
                        //lab.Id_medu = dto.Id_unit_med;
                        lab.Id_freq = dto.Id_freq;
                        lab.Sd_srvtp = medsrvdo.Sd_srvtp;
                        lab.Fg_bl = medsrvdo.Fg_bl;
                        lab.Eu_blmd = medsrvdo.Eu_blmd;
                        lab.Id_srvca = medsrvdo.Id_srvca;
                        lab.Id_primd = medsrvdo.Id_primd;
                        
                        // lab.Announcements = aggDO.getMedSrvLisDO()[0].Note; 申请单中已保存过，不需要再冲bd中查询重新赋值
                        lab.Announcements = aplab.Announcements;
                        if (aplab.Quan!=null) { // 需求量
                            lab.Quan = aplab.Quan;
                        }
                        lab.Id_quan = aplab.Id_unit_quan; // 需求量单位 EmsObsLap中没有对应字段

                        lab.Id_colltp = aplab.Id_colltp; // 采集方法
                        lab.Sd_colltp = aplab.Sd_colltp; // 采集方法编码

                        lab.Len_sampcoltime = aplab.Len_sampcoltime;// 标本采集时长
                        lab.Id_unit_sampcoltime = aplab.Id_unit_sampcoltime;// 标本采集时长单位

                        lab.Id_contp = aplab.Id_contp; // 容器类型
                        lab.Sd_contp = aplab.Sd_contp; // 容器类型编码
                        lab.Id_labgroup = aplab.Id_labgroup;
                        lab.Sd_labgroup = aplab.Sd_labgroup;
                        CiEmsSrvDTO item = emslist.FirstOrDefault(p => p.Id_srv == lab.Id_srv);
                        if (item != null) {
                            lab.Id_orsrv = item.Id_orsrv;
                            lab.Eu_sourcemd = item.Eu_sourcemd;
                        }
                        OrdSrvSetDO srvsetdo = selectSetItems.FirstOrDefault(p => p.Id_srvset == setItem.Id_srv_itm);
                        if (srvsetdo != null)
                        {
                            lab.Fg_chk = true;
                            lab.Id_freq = srvsetdo.Id_freqdef;
                            lab.Id_medu = srvsetdo.Id_medu;
                            lab.Quan_medu = srvsetdo.Quan_medu;
                            headDo.Emsaplab.EmsOrObsListDel.Add(lab);
                        }
                        headDo.Emsaplab.EmsOrObsList.Add(lab);
                    }
                }
            }
            else {
                GetMedSrvImpl medSrvImpl = new GetMedSrvImpl();
                MedsrvAggDO agg = medSrvImpl.getMedSrvAggDOfindById(dto.Id_srv);
                MedSrvLisDO[] lisdos = agg.getMedSrvLisDO();
                FArrayList emssrvs = dto.Emssrvs;
                List<CiEmsSrvDTO> emslist = new List<CiEmsSrvDTO>();
                foreach (CiEmsSrvDTO ems in emssrvs) {
                    emslist.Add(ems);
                }
                foreach (MedSrvLisDO lisdo in lisdos) {
                    EmsObsLap lab = new EmsObsLap();
                    CiEmsSrvDTO item = emslist.FirstOrDefault(p => p.Id_srv == lisdo.Id_srv);
                    lab.Name_srv = lisdo.Srv_name;
                    lab.Id_srv = lisdo.Id_srv;
                    lab.Sd_srvtp = agg.getParentDO().Sd_srvtp;
                    lab.Id_srvca = agg.getParentDO().Id_srvca;
                    lab.Id_primd = agg.getParentDO().Id_primd;
                    lab.Eu_blmd = agg.getParentDO().Eu_blmd;
                    if (item != null) {
                        lab.Id_orsrv = item.Id_orsrv;
                        lab.Fg_chk = true;
                        lab.Fg_edit = false;
                        lab.Id_or = item.Id_or;
                        lab.Id_medu = item.Id_unit_med;
                        lab.Quan_medu = item.Quan_med;
                        lab.Id_freq = item.Id_freq;
                        lab.Sd_srvtp = item.Sd_srvtp;
                        lab.Id_srvca = item.Id_srvca;
                        lab.Id_orsrv = item.Id_orsrv;
                        lab.Eu_blmd = item.Eu_blmd;
                        lab.Eu_sourcemd = item.Eu_sourcemd;
                    }

                    lab.Announcements = aplab.Announcements;
                    if (aplab.Quan!=null)
                    { // 需求量
                        lab.Quan = aplab.Quan;
                    }
                    lab.Id_quan = aplab.Id_unit_quan; // 需求量单位 EmsObsLap中没有对应字段

                    lab.Id_colltp = aplab.Id_colltp; // 采集方法
                    lab.Sd_colltp = aplab.Sd_colltp; // 采集方法编码

                    lab.Len_sampcoltime = aplab.Len_sampcoltime;// 标本采集时长
                    lab.Id_unit_sampcoltime = aplab.Id_unit_sampcoltime;// 标本采集时长单位

                    lab.Id_contp = aplab.Id_contp; // 容器类型
                    lab.Sd_contp = aplab.Sd_contp; // 容器类型编码
                    lab.Id_labgroup = aplab.Id_labgroup;
                    lab.Sd_labgroup = aplab.Sd_labgroup;
                    headDo.Emsaplab.EmsOrObsList.Add(lab);
                }
            }


        }

        double? GetOrderSvrPrice(String id_primd, FArrayList srvs)
        {
           switch (id_primd)
           {
               case BdPrimdCodeConst.ID_PRI_SRV_COMP:
                   
               case BdPrimdCodeConst.ID_PRI_SRV:
                   return (srvs[0] as CiEmsSrvDTO).Price;
               case BdPrimdCodeConst.ID_PRI_SRVSET_AMOUNT:
                   return (from srv in srvs.Cast<CiEmsSrvDTO>().ToList() 
                           where srv.Fg_or == true && srv.Fg_bl == true 
                           select (srv.Price == null ? 0 : srv.Price)
                           ).Sum();

           }
            return 0;
        }
        #endregion 编辑 检验医疗单

        #region 编辑 检查医疗单
        /// <summary>
        /// 
        /// </summary>
        /// <param name="headDo"></param>
        /// <param name="dto"></param>
        public virtual void EditEmsObs(EmsUIDTO headDo, CiEmsDTO dto) {
            headDo.Dt_begin_ui = dto.Dt_begin;
            headDo.Dt_end_ui = dto.Dt_end;
            headDo.Days_or = dto.Days_or;
            headDo.Times_cur = dto.Times_cur;
            headDo.Times_mp_in = dto.Times_mp_in;
            FMap map = dto.Srvsetitms;
            OrdApObsDO apobs = dto.Orapplysheet[((int)EmsType.RIS).ToString()] as OrdApObsDO;
            headDo.Emsapobs.Id_srv = dto.Id_srv;	                //服务id	SING  	
            headDo.Emsapobs.Name_srv = dto.Name;//服务名称	SING 
            headDo.Emsapobs.Announcements = apobs.Announcements;
            //还原bd_srv todo
            headDo.Emsapobs.Id_srvtp = dto.Id_srvtp;	            //服务类型	 
            headDo.MedSrvDO.Sd_srvtp = dto.Sd_srvtp;
            headDo.MedSrvDO.Id_srvca = dto.Id_srvca;
            headDo.MedSrvDO.Id_srv = dto.Id_srv;
            headDo.MedSrvDO.Name = dto.Name;
            headDo.MedSrvDO.Quan_med = dto.Quan_medu;//zwq  2016-08-18
            headDo.MedSrvDO.Freqct = dto.Freqct;//zwq  2016-09-06
            headDo.MedSrvDO.Sd_frequnitct = dto.Sd_frequnitct;//zwq  2016-09-06
            headDo.MedSrvDO.Fg_set = dto.Fg_set;//是否是套服务标识
            headDo.Emsapobs.Fg_set = dto.Fg_set;
            //if (headDo.MedSrvDO.Fg_or == null) {
            //    headDo.MedSrvDO.Fg_or = (dto.Emssrvs[0] as CiEmsSrvDTO).Fg_or;
            //}
            //if (headDo.MedSrvDO.Id_freq == null) {
            //    headDo.MedSrvDO.Id_freq = (dto.Emssrvs[0] as CiEmsSrvDTO).Id_freq;
            //}
            //if(headDo.Emsapobs.Price == null) {
            //    headDo.Emsapobs.Price = (dto.Emssrvs[0] as CiEmsSrvDTO).Price;
            //}

            headDo.Emsapobs.No_applyobs = apobs.No_applyform;           //检查申请单号	SINGLE	Stri 
            headDo.Emsapobs.Fg_urgent = apobs.Fg_urgent;	            //加急标识	SINGLE	FBoo  	
            headDo.Emsapobs.Fg_mp_bed = dto.Fg_mp_bed;            //床旁执行标志	SINGLE	FBoo  	
            headDo.Emsapobs.Dt_plan = apobs.Dt_plan;                //计划检查时间	SINGLE	FDat  
	        //诊断信息映射
            headDo.Emsapobs.Id_di = apobs.Id_di;	                //诊断主项目id	REF	医疗服务_疾病诊  	 	
            headDo.Emsapobs.Name_diag = apobs.Name_diag;             //医疗单选择诊断的名称 
            headDo.Emsapobs.Id_diitm = apobs.Id_diitm;               //医疗单选择诊断的id
            //诊断的拼接需要取当前最新的值
            string[] diagArray = new GetPatDiagImp().getDiagArray(headDo.PatInfo.Id_ent);
            if (diagArray != null)
            {
                headDo.Emsapobs.Str_code_di = diagArray[1];//诊断编码拼接
                headDo.Emsapobs.Str_name_di = diagArray[0];//诊断名称拼接
                headDo.Emsapobs.Str_id_diitm = diagArray[2];//诊断子项目id拼接
            }

            headDo.Emsapobs.Sd_pps = apobs.Sd_pps;	                //检查目的编码	SINGLE	Stri 
            headDo.Emsapobs.Id_pps = apobs.Id_pps;	                //检查目的	SINGLE	Stri 
            headDo.Emsapobs.Des_pps = apobs.Des_pps;                //检查目的描述	SINGLE	Stri 
            headDo.Emsapobs.Name_pps = apobs.Name_pps;
            headDo.Emsapobs.Des_sympsign = apobs.Des_sympsign;	        //症状体征描述	SINGLE	Stri 

            //拓展字段
            headDo.Emsapobs.Def1 = apobs.Def1;
            headDo.Emsapobs.Def2 = apobs.Def2;
            headDo.Emsapobs.Def3 = apobs.Def3;
            headDo.Emsapobs.Def4 = apobs.Def4;
            headDo.Emsapobs.Def5 = apobs.Def5;
            headDo.Emsapobs.Def6 = apobs.Def6;
            headDo.Emsapobs.Def7 = apobs.Def7;
            headDo.Emsapobs.Def8 = apobs.Def8;
            headDo.Emsapobs.Def9 = apobs.Def9;
            headDo.Emsapobs.Def10 = apobs.Def10;
            headDo.Emsapobs.Def11 = apobs.Def11;
            headDo.Emsapobs.Def12 = apobs.Def12;
            headDo.Emsapobs.Def13 = apobs.Def13;
            headDo.Emsapobs.Def14 = apobs.Def14;
            headDo.Emsapobs.Def15 = apobs.Def15;
            headDo.Emsapobs.Def16 = apobs.Def16;
            headDo.Emsapobs.Def17 = apobs.Def17;
            headDo.Emsapobs.Def18 = apobs.Def18;
            headDo.Emsapobs.Def19 = apobs.Def19;
            headDo.Emsapobs.Def20 = apobs.Def20;
            headDo.Emsapobs.Def21 = apobs.Def21;
            headDo.Emsapobs.Def22 = apobs.Def22;
            headDo.Emsapobs.Def23 = apobs.Def23;
            headDo.Emsapobs.Def24 = apobs.Def24;
            headDo.Emsapobs.Def25 = apobs.Def25;
            headDo.Emsapobs.Def26 = apobs.Def26;
            headDo.Emsapobs.Def27 = apobs.Def27;
            headDo.Emsapobs.Def28 = apobs.Def28;
            headDo.Emsapobs.Def29 = apobs.Def29;
            headDo.Emsapobs.Def30 = apobs.Def30;
            headDo.Emsapobs.Clinicalzztz = apobs.Clinicalzztz;
            headDo.Emsapobs.Auximtexam = apobs.Auximtexam;
            headDo.Emsapobs.Pastillness = apobs.Pastillness;

            headDo.Emsapobs.Use_days = dto.Days_or;
            headDo.Emsapobs.Id_mp_dep = dto.Id_dep_mp;
            headDo.Emsapobs.Name_mp_dep = dto.Name_dep_mp;
            headDo.Emsapobs.Dt_begin_ui = dto.Dt_begin;
            headDo.Emsapobs.Dt_end_ui = dto.Dt_end;
            headDo.Emsapobs.Times_cur = dto.Times_cur;
            headDo.Emsapobs.Times_mp_in = dto.Times_mp_in;
           

            headDo.Status = DOStatus.UPDATED;
            // 医疗服务套项目定义,用于展现检查申请单中的检查部位
            List<MedSrvSetItemDO> medSrvSetItem = null;
            GetMedSrvImpl medSrvImpl = new GetMedSrvImpl();
            MedsrvAggDO[] medsrvagg = null;
            if (dto.Fg_set != null && (bool)dto.Fg_set) {
                // 覆盖相关的数据 - wqz
                //MedsrvAggDO aggdo = medSrvImpl.getMedSrvAggDOfindById(dto.Id_srv);
                headDo.Emsapobs.Price = headDo.MedSrvDO.Pri;
                // 执行科室，待定...
//                 headDo.Emsapobs.Id_mp_dep = dto.Id_dep_mp;
//                 headDo.Emsapobs.Name_mp_dep = dto.Name_dep_mp;
                headDo.Emsapobs.Id_unit_med = dto.Id_unit_med;
                headDo.Emsapobs.Name_unit_med = dto.Name_unit_med;
                headDo.Emsapobs.Quan_med = dto.Quan_medu;
                headDo.Emsapobs.Id_unit_sale = dto.Id_unit_med;
                headDo.Emsapobs.Name_unit_sale = dto.Name_unit_med;
                headDo.Emsapobs.Quan_cur = dto.Times_cur;

                GetSrvSetImp srvset = new GetSrvSetImp();

                medSrvSetItem = srvset.GetItemInSet(dto.Id_srv);
                medsrvagg = medSrvImpl.getMedSrvDO(medSrvSetItem);
                FArrayList SetItems = (FArrayList)dto.Srvsetitms[dto.Id_srv];
                //OrdSrvSetDO[] selectSetItems = new OrdSrvSetDO[SetItems.Count];
                //int i = 0;
                //foreach (OrdSrvSetDO item in SetItems) {
                //    selectSetItems[i] = item;
                //    i++;
                //}
                // 替换更为简洁的处理逻辑
                var selectSetItems = SetItems.Cast<OrdSrvSetDO>().ToArray();

                //FArrayList emssrvs = dto.Emssrvs;
                //var emssrvlist =  new List<CiEmsSrvDTO>();
                //foreach (CiEmsSrvDTO emssrv in emssrvs) {
                //    emssrvlist.Add(emssrv);
                //}
                // 替换更为简洁的处理逻辑
                var emssrvlist = SetItems.Cast<OrdSrvSetDO>().ToList();// -- 
                foreach (MedSrvSetItemDO item in medSrvSetItem)//检查部位
                {
                    EmsObsLap obs = new EmsObsLap() { Fg_edit = item.Fg_edit , Id_srv = item.Id_srv_itm };
                    //obs.Fg_edit = item.Fg_edit;
                    //obs.Id_srv = item.Id_srv_itm;
                    if (dto.Fg_set != null && (bool)dto.Fg_set && emssrvlist != null && emssrvlist.Count > 0) {
                        foreach (MedsrvAggDO agg in medsrvagg) {
                            if (agg.getParentDO().Id_srv == item.Id_srv_itm) {
                                obs.Name_srv = agg.getParentDO().Name;
                                if (agg.getMedSrvRisDO() != null) {
                                    MedSrvRisDO medSrvRis = agg.getMedSrvRisDO()[0];

                                    // 部位id、编码、名称
                                    obs.Id_body = medSrvRis.Id_body;
                                    obs.Sd_body = medSrvRis.Sd_body;
                                    obs.Name_body = medSrvRis.Name_body;

                                    // 体位 Id、编码、名称
                                    obs.Id_pos = medSrvRis.Id_pos;
                                    obs.Sd_pos = medSrvRis.Sd_pos;
                                    obs.Name_pos = medSrvRis.Name_pos;

                                    // 是否有检查部位
                                    obs.Fg_pos = medSrvRis.Fg_pos;
                                    // obs.Announcements = agg.getMedSrvLisDO()[0].Note; // getMedSrvLisDO -》getMedSrvRisDO
                                    obs.Announcements = medSrvRis.Note;
                                    obs.Fg_or = item.Fg_clinical;//todo
                                }
                                obs.Id_srv = agg.getParentDO().Id_srv;
                                obs.Sd_srvtp = agg.getParentDO().Sd_srvtp;
                                obs.Id_srvtp = agg.getParentDO().Id_srvtp;
                                obs.Id_primd = agg.getParentDO().Id_primd;
                                obs.Quan_medu = agg.getParentDO().Quan_med;
                                obs.Id_medu = agg.getParentDO().Id_unit_med;
                                if(dto.Emssrvs!=null){
                                     CiEmsSrvDTO ciemsdto = dto.Emssrvs.Cast<CiEmsSrvDTO>().FirstOrDefault(p=>p.Id_srv==obs.Id_srv);
                                    if(ciemsdto!=null){
                                        obs.Id_orsrv = ciemsdto.Id_orsrv;
                                    }
                                    
                                }
                               
                                break;
                            }
                        }
                        if (selectSetItems.FirstOrDefault(p => p.Id_srvset == item.Id_srv_itm) != null) {
                            obs.Fg_chk = true;
                            headDo.Emsapobs.EmsOrObsListDel.Add(obs);
                        }
                        headDo.Emsapobs.EmsOrObsList.Add(obs);
                    }

                }
            }
            else {
                List<CiEmsSrvDTO> srvs = LogicEx.GetInstance().getPhysignSrv(dto.Emssrvs);
                if (srvs.Count > 0) {
                    CiEmsSrvDTO srv = srvs[0];
                    headDo.Emsapobs.Id_unit_sale = srv.Id_unit_sale;
                    headDo.Emsapobs.Name_unit_sale = srv.Name_unit_sale;
                    headDo.Emsapobs.Quan_cur = srv.Quan_cur;
                    headDo.Emsapobs.Fg_indic = srv.Fg_indic;
                    headDo.Emsapobs.Id_unit_med = srv.Id_unit_med;
                    headDo.Emsapobs.Id_orsrv = srv.Id_orsrv;

                    MedsrvAggDO agg = medSrvImpl.getMedSrvAggDOfindById(dto.Id_srv);
                    headDo.Emsapobs.Id_body = agg.getMedSrvRisDO()[0].Id_body;                //身体部位id	REF	部位编码_ 	 	 	 	
                    headDo.Emsapobs.Sd_body = agg.getMedSrvRisDO()[0].Sd_body;                //身体部位编码	SINGLE	Stri 
                    
                    headDo.MedSrvDO.Id_primd = agg.getParentDO().Id_primd; // 获取定价模式，TODO 这么实属无奈
                    headDo.Emsapobs.Price = agg.getParentDO().Pri;
                    EmsObsLap obs = new EmsObsLap();
                    obs.Id_body = srv.Id_body;
                    obs.Sd_body = srv.Sd_body;
                    obs.Fg_body_update = agg.getMedSrvRisDO()[0].Fg_body_update;
                    obs.Name_body = agg.getMedSrvRisDO()[0].Name_body;
                    obs.Id_pos = srv.Id_pos;
                    obs.Sd_pos = srv.Sd_pos;
                    obs.Name_pos = agg.getMedSrvRisDO()[0].Name_pos;// obs.Sd_pos.Equals(BdSrvDictCodeConst.SD_POS_CEWEI)?"侧位":(obs.Sd_pos.Equals(BdSrvDictCodeConst.SD_POS_ZHENGCEWEI)?"正侧位": "正位");
                    obs.Fg_pos = agg.getMedSrvRisDO()[0].Fg_pos;
                    obs.Name_srv = srv.Name_srv;
                    obs.Id_orsrv = srv.Id_orsrv;
                    obs.Id_srv = srv.Id_srv;
                    obs.Sd_srvtp = srv.Sd_srvtp;
                    obs.Id_srvtp = srv.Id_srvtp;
                    obs.Fg_chk = true;
                    obs.Quan_medu = agg.getParentDO().Quan_med;
                    obs.Id_medu = agg.getParentDO().Id_unit_med;
                    headDo.Emsapobs.EmsOrObsList.Add(obs);
                }
                //foreach (CiEmsSrvDTO srvdto in dto.Emssrvs) {
                //    if (srvdto.Fg_or != null && srvdto.Fg_or==true)
                //    {
                //        EmsObsLap obs = new EmsObsLap();
                //        MedsrvAggDO agg = medSrvImpl.getMedSrvAggDOfindById(srvdto.Id_srv);
                //        if (agg != null && agg.getMedSrvRisDO().Count() > 0)
                //        {
                //            obs.Name_body = agg.getMedSrvRisDO()[0].Name_body;
                //            obs.Name_pos = agg.getMedSrvRisDO()[0].Name_pos;
                //        }
                //        obs.Name_srv = srvdto.Name_srv;
                //        obs.Id_orsrv = srvdto.Id_orsrv;
                //        obs.Id_srv = srvdto.Id_srv;
                //        obs.Sd_srvtp = srvdto.Sd_srvtp;
                //        obs.Id_srvtp = srvdto.Id_srvtp;
                //        obs.Fg_chk = true;
                //        headDo.Emsapobs.EmsOrObsList.Add(obs);
                //    }
                //}

            }
        }
        #endregion 编辑 检查医疗单

        #region 编辑 出院申请单

        /// <summary>
        /// 编辑 出院申请单UI对照
        /// </summary>
        /// <param name="emsHeadDO"></param>
        /// <param name="ciEms"></param>
        public void EditEmsOut(EmsUIDTO emsHeadDO, CiEmsDTO ciEms) {

            emsHeadDO.Dt_begin_ui = ciEms.Dt_begin;
            emsHeadDO.Dt_end_ui = ciEms.Dt_end;
            emsHeadDO.Days_or = ciEms.Days_or;
            emsHeadDO.Times_cur = ciEms.Times_cur;
            emsHeadDO.Times_mp_in = ciEms.Times_mp_in;

            emsHeadDO.MedSrvDO.Id_srvtp = ciEms.Id_srvtp; //服务项目类型id
            emsHeadDO.MedSrvDO.Sd_srvtp = ciEms.Sd_srvtp; //服务项目类型sd
            emsHeadDO.MedSrvDO.Id_freq = ciEms.Id_freq; //频次
            OrdApOutDO outItemDo = ciEms.Orapplysheet[((int)EmsType.OUTHOSP).ToString()] as OrdApOutDO;
            emsHeadDO.Emsapout.Dt_out = outItemDo.Dt_timeout;
            emsHeadDO.Emsapout.Id_emsapout = outItemDo.Id_orout;
            emsHeadDO.Emsapout.Id_or = outItemDo.Id_or;
            emsHeadDO.Emsapout.Id_dep_out = outItemDo.Id_dep_out;
            emsHeadDO.Emsapout.Name_dep_out = outItemDo.Name_dep_out;
            emsHeadDO.Emsapout.Id_dep_nur_out = outItemDo.Id_dep_nur_out;
            emsHeadDO.Emsapout.Name_dep_nur_out = outItemDo.Name_dep_nur_out;
            emsHeadDO.Emsapout.Id_bed_out = outItemDo.Id_bed_out;
            emsHeadDO.Emsapout.Fg_again31 = outItemDo.Fg_again31;
            emsHeadDO.Emsapout.Des_again31 = outItemDo.Des_again31;
            emsHeadDO.Emsapout.Id_outtp = outItemDo.Id_outtp;
            emsHeadDO.Emsapout.Sd_outtp = outItemDo.Sd_outtp;
            emsHeadDO.Emsapout.Name_outtp = outItemDo.Name_outtp;
            emsHeadDO.Emsapout.Des_outtp = outItemDo.Des_outtp;
            emsHeadDO.Emsapout.Sv = outItemDo.Sv;
            emsHeadDO.Emsapout.Fg_death = outItemDo.Fg_death;
            emsHeadDO.Emsapout.Fg_autopsy = outItemDo.Fg_autopsy;
            emsHeadDO.Emsapout.Status = DOStatus.UPDATED;
            emsHeadDO.Emsapout.Dt_begin_ui = ciEms.Dt_begin;
            emsHeadDO.Emsapout.Dt_end_ui = ciEms.Dt_end;
            emsHeadDO.Emsapout.Use_days = ciEms.Days_or;
            emsHeadDO.Emsapout.Times_cur = ciEms.Times_cur;
            emsHeadDO.Emsapout.Times_mp_in = ciEms.Times_mp_in;
        }

        #endregion 编辑 出院申请单s

        #region 编辑 转科申请单

        /// <summary>
        /// 编辑 转科申请单UI对照
        /// </summary>
        /// <param name="emsHeadDO"></param>
        /// <param name="ciEms"></param>
        public void EditEmsTrans(EmsUIDTO emsHeadDO, CiEmsDTO ciEms) {

            emsHeadDO.MedSrvDO.Name = ciEms.Name; //服务项目名称
            emsHeadDO.MedSrvDO.Id_srvtp = ciEms.Id_srvtp; //服务项目类型id
            emsHeadDO.MedSrvDO.Sd_srvtp = ciEms.Sd_srvtp; //服务项目类型sd
            emsHeadDO.MedSrvDO.Id_freq = ciEms.Id_freq; //频次

            OrdApTransDO trans = ciEms.Orapplysheet[((int)EmsType.TRANSDEPT).ToString()] as OrdApTransDO;

            emsHeadDO.Emsaptrans.Id_emsaptrans = trans.Id_ortrans; //医嘱转科属性主键标识	SINGLE	FID	id_ortrans	char	20	 	 	 				
            emsHeadDO.Emsaptrans.Id_or = trans.Id_or; //医嘱	REF	临床医嘱	id_or	varchar	20	 	 	 				 	 	 	 	 	 			
            emsHeadDO.Emsaptrans.Id_dep_to = trans.Id_dep_to; //目标科室	REF	部门	id_dep_to	varchar	20	 	 	 				 	 	 	 	
            emsHeadDO.Emsaptrans.Id_dep_nur_to = trans.Id_dep_nur_to; //目标病区	REF	部门	id_dep_nur_to	varchar	20	 	 	 				 	
            emsHeadDO.Emsaptrans.Name_dep_to = trans.Name_dep_to;
            emsHeadDO.Emsaptrans.Id_dep_from = trans.Id_dep_from;
            //原科室	REF	部门	id_dep_from	varchar	20	 	 	 				 	 	 	 	 	 	
            emsHeadDO.Emsaptrans.Id_dep_nur_from = trans.Id_dep_nur_from;
            emsHeadDO.Emsaptrans.Name_dep_nur_to = trans.Name_dep_nur_to;
            //原病区	REF	部门	id_dep_nur_from	varchar	20	 	 	 				 	 	 	 	 	 				 	
            emsHeadDO.Emsaptrans.Id_su_trans = trans.Id_su_trans;
            //转科过程状态	REF	转科过程状态_自定义档案	id_su_trans	varchar	20	转科过程状态_自定义档案	 	
            emsHeadDO.Emsaptrans.Sd_su_trans = trans.Sd_su_trans;
            //转科过程状态编码	SINGLE	String	sd_su_trans	varchar	50	 	 	 				 	 	 	 	 	 			
            emsHeadDO.Emsaptrans.Dt_trans_apply = trans.Dt_trans_apply;
            //转科申请时间	SINGLE	FDateTime	dt_trans_apply	char	19	 	 	 				
            emsHeadDO.Emsaptrans.Des_rea_canc = trans.Des_rea_canc;
            //转科申请原因	SINGLE	备注	des_rea_canc	varchar	300	 	 	 				
            //emsHeadDO.Emsaptrans.Fg_tech_trans = trans.Fg_tech_trans; //转医技科室	SINGLE	String
            emsHeadDO.Emsaptrans.Fg_tech_trans = trans.Fg_crossdept;
            emsHeadDO.Emsaptrans.Dt_effe = ciEms.Dt_begin;
            emsHeadDO.Emsaptrans.Dt_end = trans.Dt_end;

            emsHeadDO.Emsaptrans.Dt_begin_ui = ciEms.Dt_begin;
            emsHeadDO.Emsaptrans.Dt_end_ui = ciEms.Dt_end;
            emsHeadDO.Emsaptrans.Use_days = ciEms.Days_or;
            emsHeadDO.Emsaptrans.Times_cur = ciEms.Times_cur;
            emsHeadDO.Emsaptrans.Times_mp_in = ciEms.Times_mp_in;

        }

        #endregion 编辑 转科申请单

        #region 编辑 简洁医疗单

        public void EditCommon(CiEmsDTO dto, EmsUIDTO emsHeadDO) {
            EditHeadCommon(dto, emsHeadDO);
            List<CiEmsSrvDTO> srvList = new List<CiEmsSrvDTO>();
            foreach (CiEmsSrvDTO item in dto.Emssrvs) {
                srvList.Add(item);
            }

            //CiEmsSrvDTO srvCommon = srvList[0];
            //srvCommon = srvList.FirstOrDefault(p => p.Eu_sourcemd == (int)OrSrvSourceFromEnum.PHYSIAN);//srvCommon  公用服务 专门针对那些只有一条服务的 

            //EditCommonSrv(srvCommon, emsHeadDO);
            EditApDrug(dto, emsHeadDO);

            //emsHeadDO.Emsdrugs.Name_dep = srvList[0].Name_dep;
            //emsHeadDO.Emsdrugs.Id_dep = srvList[0].Id_dep;
            var srvDto = dto.Emssrvs.Cast<CiEmsSrvDTO>().ToArray().FirstOrDefault(p => p.Id_srv == dto.Id_srv);
            if (srvDto != null)
            {
                emsHeadDO.Emsdrugs.Quan_med = srvDto.Quan_med;
                emsHeadDO.Emsdrugs.Id_unit_med = srvDto.Id_unit_med;
                emsHeadDO.Emsdrugs.Name_unit_med = srvDto.Name_unit_med;
            }
            else {
                emsHeadDO.Emsdrugs.Quan_med = emsHeadDO.MedSrvDO.Quan_med;
                emsHeadDO.Emsdrugs.Id_unit_med = emsHeadDO.MedSrvDO.Id_unit_med;
                emsHeadDO.Emsdrugs.Name_unit_med = emsHeadDO.MedSrvDO.Med_name;
            }
            
            emsHeadDO.Emsdrugs.Id_dep = dto.Id_dep_mp;
            emsHeadDO.Emsdrugs.Name_dep = dto.Name_dep_mp;
            //emsHeadDO.Emsdrugs.Id_freq = dto.Id_freq;
            emsHeadDO.Emsdrugs.Id_route = dto.Id_route;
            emsHeadDO.Emsdrugs.Id_routedes = dto.Id_routedes;
            emsHeadDO.Emsdrugs.Id_srv = dto.Id_srv;
            emsHeadDO.Emsdrugs.Sd_srvtp = dto.Sd_srvtp;
        }

        #endregion

        #region 编辑 药品医疗单

        public void EditDrug(CiEmsDTO dto, EmsUIDTO emsHeadDO) {
            emsHeadDO.Dt_begin_ui = dto.Dt_begin;
            emsHeadDO.Dt_end_ui = dto.Dt_end;
            emsHeadDO.Days_or = dto.Days_or;
            emsHeadDO.Times_cur = dto.Times_cur;
            emsHeadDO.Times_mp_in = dto.Times_mp_in;
            EditHeadCommon(dto, emsHeadDO);
            //FArrayList lsit = dto.Emssrvs;
            List<CiEmsSrvDTO> srvList = new List<CiEmsSrvDTO>();
            foreach (CiEmsSrvDTO item in dto.Emssrvs) {
                srvList.Add(item);
//                 emsHeadDO.MedSrvDO.Id_srvca = item.Id_srvca;
//                 emsHeadDO.MedSrvDO.Id_srvtp = item.Id_srvtp;
            }
            CiEmsSrvDTO srvCommon = srvList.FirstOrDefault(p => p.Eu_sourcemd == (int)OrSrvSourceFromEnum.PHYSIAN);//srvCommon  公用服务 专门针对那些只有一条服务的 
            EditCommonSrv(srvCommon, emsHeadDO);
            EditApDrug(dto, emsHeadDO);
            EditOrDrugEmsItem(dto, emsHeadDO);
            if (srvCommon != null)
            {
                emsHeadDO.Emsdrugs.Fg_treat = srvCommon.Fg_indic;// 医保适应症
            }
   
            //
            //CiEnContextDTO contextdto = LogicEx.GetInstance().getBdHpIndicationDTO(emsHeadDO.PatInfo, emsHeadDO.MedSrvDO);
            //获得物品信息
            emsHeadDO.Emsdrugs.EmsOrDrug = DrugUtils.getMMOfDrug(string.Join("','", srvList.Select(p => p.Id_srv)), emsHeadDO.PatInfo);
            //执行科室填充
            DrugUtils.fillExecDetps(emsHeadDO.Emsdrugs.EmsOrDrug, emsHeadDO.Emsdrugs.Id_route, emsHeadDO.PatInfo);
            emsHeadDO.Emsdrugs.Str_mp_dep_ids = DrugUtils.collectIdDepmps(emsHeadDO.Emsdrugs.EmsOrDrug);
            //emsHeadDO.Emsdrugs.EmsOrDrug = cof.GetSrvMm(emsHeadDO, string.Join("','", srvList.Select(p => p.Id_srv)), emsHeadDO.PatInfo.Code_entp);  //下拉药品列表popo//cof.GetSrvMm(headDo);
            //emsHeadDO.Emsdrugs.EmsOrDrugList.Clear();//医嘱药品绑定
            emsHeadDO.Emsdrugs.EmsOrDrugList = cof.GetOrdMm(emsHeadDO, string.Join("','", srvList.Select(p => p.Id_orsrv)));


        }


        /// <summary>
        /// 编辑 药品公共信息对照
        /// </summary>
        /// <param name="dto"></param>
        /// <param name="emsHeadDO"></param>
        private void EditHeadCommon(CiEmsDTO dto, EmsUIDTO emsHeadDO) {
            emsHeadDO.Dt_begin_ui = dto.Dt_begin;
            emsHeadDO.Dt_end_ui = dto.Dt_end;
            emsHeadDO.Days_or = dto.Days_or;
            emsHeadDO.Times_cur = dto.Times_cur;
            emsHeadDO.Times_mp_in = dto.Times_mp_in;
            //dto.Id_or	        //医嘱主键标识	SINGLE	FID	20	  
            //emsHeadDO.Id_or = dto.Id_or;
            //emsHeadDO.Id_pat = dto.Id_pat; //患者	RE 
            //emsHeadDO.Id_en = dto.Id_en; //就诊	REF	患者就诊 
            //emsHeadDO.Id_entp = dto.Id_entp; //就诊类型	RE 
            //emsHeadDO.Code_entp = dto.Code_entp; //就诊类型编 
            emsHeadDO.MedSrvDO.Id_srvtp = dto.Id_srvtp; //医嘱类型 
            emsHeadDO.MedSrvDO.Sd_srvtp = dto.Sd_srvtp; //医嘱类型编 
            emsHeadDO.MedSrvDO.Id_freq = dto.Id_freq;
            emsHeadDO.MedSrvDO.Fg_set = dto.Fg_set;

            //dto.Id_srv_set = emsHeadDO.Fg_set;   //对应服务	SINGLE	医疗服务 
            //dto.Id_srv_pkg	    //服务包	SINGLE	String	20 
            emsHeadDO.EmsType = (EmsType)dto.Emstype; //医疗单类型	SINGLE	医疗单类型	20	 	 		
            emsHeadDO.MedSrvDO.Code = dto.Code; //编码	SINGLE	String	50	 
            emsHeadDO.MedSrvDO.Name = dto.Name; //医嘱名称	SINGLE	String	 	
           
            emsHeadDO.MedSrvDO.Id_srv = dto.Id_srv;
            emsHeadDO.MedSrvDO.Id_srvca = dto.Id_srvca;



            //emsHeadDO.Dt_begin_ui = srv.Dt_create_srv; //开立时间	      SINGL 
            //emsHeadDO.Id_or = srv.Id_org_srv; //开立机构	SINGL 
            //emsHeadDO.idd=srv.Id_dep_srv =     //开立科室	SINGL 
            //emsHeadDO.Id_ward_srv=srv.Id_ward_srv =    //开立病区	SINGL 
            //emsHeadDO.=srv.Id_emp_srv =        //开立人员	SINGL 

            //emsHeadDO.Id_dep_en = dto.Id_dept_en;//就诊科室
            //emsHeadDO.Id_dep_ns = dto.Id_dept_ns;//护理单元

            //emsHeadDO.Dt_begin_ui = dto.Dt_begin;

            //emsHeadDO.Sd_su_or = dto.Sd_su_or;//sd 医嘱状态 0开立
            //emsHeadDO.Id_su_or = dto.Id_su_or;//医嘱状态(默认为开立状态)
            //emsHeadDO.Id_emp_phy = dto.Id_emp_phy; //开立医生	REF	人员基本信息	 	 	
            //emsHeadDO.Id_dep_phy = dto.Id_dep_phy; //开立科室	REF	部门	20	 	 	
            //dto.Id_wg_or	    //医疗组	REF	业务组	20	业务 
            emsHeadDO.Status = DOStatus.UPDATED;

        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="srv"></param>
        /// <param name="emsHeadDO"></param>
        private void EditCommonSrv(CiEmsSrvDTO srv, EmsUIDTO emsHeadDO)
        {
            if (srv != null)
            {
            emsHeadDO.MedSrvDO.Name = srv.Name_srv;
            emsHeadDO.MedSrvDO.Fg_or = srv.Fg_or; // add by hums 20161114
            //             emsHeadDO.MedSrvDO.Id_srv = srv.Id_srv;
            //             emsHeadDO.MedSrvDO.Id_srvca = srv.Id_srvca;
            //             emsHeadDO.MedSrvDO.Id_srvtp = srv.Id_srvtp;
            //              emsHeadDO.MedSrvDO.Sd_srvtp = srv.Sd_srvtp;
            //             emsHeadDO.MedSrvDO.Eu_blmd = srv.Eu_blmd;
            //             emsHeadDO.MedSrvDO.Fg_or = srv.Fg_or;
            //emsHeadDO.Dt_begin_ui = srv.Dt_create_srv; //开立时间	      SINGL 
            //emsHeadDO.Id_or = srv.Id_org_srv; //开立机构	SINGL 
            //emsHeadDO.idd=srv.Id_dep_srv =     //开立科室	SINGL 
            //emsHeadDO.Id_ward_srv=srv.Id_ward_srv =    //开立病区	SINGL 
            //emsHeadDO.=srv.Id_emp_srv =        //开立人员	SINGL 
            //            srv.Eu_sourcemd = srv.Eu_sourcemd;
        }

    }

        /// <summary>
        /// 编辑 药品医疗单对照
        /// </summary>
        /// <param name="dto"></param>
        /// <param name="emsHeadDO"></param>
        private void EditApDrug(CiEmsDTO dto, EmsUIDTO emsHeadDO) {
            emsHeadDO.Emsdrugs.Dt_begin_ui = dto.Dt_begin; //开始日期	SINGLE	FDateTim 	 	
            emsHeadDO.Emsdrugs.Dt_end_ui = dto.Dt_end; //结束日期	SINGLE	FDateTim 
            emsHeadDO.Emsdrugs.Use_days = dto.Days_or; //医嘱天数	SINGLE	Integer
            emsHeadDO.Emsdrugs.Times_cur = dto.Times_cur;//医嘱次数
            emsHeadDO.Emsdrugs.Times_mp_in = dto.Times_mp_in;//在院执行次数 	

            emsHeadDO.Emsdrugs.Id_srv = dto.Id_srv;
            emsHeadDO.Emsdrugs.Name_srv = dto.Name;
            emsHeadDO.Emsdrugs.Sd_srvtp = dto.Sd_srvtp;
            emsHeadDO.Emsdrugs.Id_srvtp = dto.Id_srvtp;
            emsHeadDO.Emsdrugs.Note_or = dto.Note;
            emsHeadDO.Emsdrugs.Fg_long = dto.Fg_long;
            //长临标识	 	 				 	 	 	 	 	 				 	 			 	 	 			 	 	 	 	 	 				 	 			 	 	 	
            emsHeadDO.Emsdrugs.Id_freq = dto.Id_freq; //医嘱频次	REF	医嘱频次定义	 	 	
            emsHeadDO.Emsdrugs.Name_freq = dto.Name_freq; //医嘱频次名称	SINGLE	String	
            emsHeadDO.Emsdrugs.Freqct = dto.Freqct;//zwq 2016-09-06
            emsHeadDO.Emsdrugs.Sd_frequnitct = dto.Sd_frequnitct;//zwq 2016-09-06
            emsHeadDO.Emsdrugs.Id_route = dto.Id_route; //用法	REF	医疗服务_医疗用法	 	 	
            emsHeadDO.Emsdrugs.Name_route = dto.Name_route; //用法名称	SINGLE	String	 	
            emsHeadDO.Emsdrugs.Id_routedes = dto.Id_routedes; //用法要求	REF	医疗用法要求	 	 	 	
            emsHeadDO.Emsdrugs.Name_routedes = dto.Name_routedes; //用法要求描述	SINGLE	String	 	
            emsHeadDO.Emsdrugs.Id_boil = dto.Id_boil; // 煎法	REF	医疗服务中药煎法	 	 	 	 	
            emsHeadDO.Emsdrugs.Name_boil = dto.Name_boil; //煎法名称	SINGLE	String	 	
            emsHeadDO.Emsdrugs.Id_boildes = dto.Id_boildes; //煎法要求	REF	中药煎法要求	 	 	 	
            emsHeadDO.Emsdrugs.Name_boildes = dto.Name_boildes; //煎法要求名称	SINGLE	String	 	
            emsHeadDO.Emsdrugs.Fg_boil = dto.Fg_boil;          //代煎标识	SINGLE	FBoolean 
            emsHeadDO.Emsdrugs.Orders = dto.Orders; //医嘱付数	SINGLE	Integer	 	
            emsHeadDO.Emsdrugs.Orders_boil = dto.Orders_boil; //代煎付数	SINGLE	Integer	 	
            //dto.Content=	        //医嘱内容	SINGLE	备注	4000 	
            emsHeadDO.Emsdrugs.Note_or = dto.Note; //备注	SINGLE	备注	1000	 
            //emsHeadDO.Emsdrugs.id_edto.Id_emp_phy;	    //开立医生	REF	人员基本信息	 	
            //dto.Name_emp_phy	//开立医生姓名	SINGLE	String	 	
            //dto.Id_dep_phy ;	    //开立科室	REF	部门	20	 	 
            //////dto.Name_dep_phy	//开立科室名称	SINGLE	String	 	
            //dto.Id_wg_or ;	    //医疗组	REF	业务组	20	业务 
            
            if (emsHeadDO.Emsdrugs.Dt_end_ui != null && emsHeadDO.Emsdrugs.Dt_end_ui.Value.Year > 2098) // 时间控件仅支持到 2099年
                emsHeadDO.Emsdrugs.Dt_end_ui = null;
            emsHeadDO.Emsdrugs.Dt_fail = dto.Dt_invalid; //医嘱过期时间	SINGLE	FDateTim 	 	
            //dto.Fg_bb	        //婴儿标识	SINGLE	FBoolean 	 	
            //dto.No_bb	        //婴儿序号	SINGLE	Integer	 	
            emsHeadDO.Emsdrugs.Fg_pmor = dto.Fg_pmor; //备用医嘱标识	SINGLE	FBoolean 	 	
            emsHeadDO.Emsdrugs.Bak_des = dto.Des_pmor; //备用医嘱使用条件描述	SINGLE	 	 	
            //dto.Fg_active_pm= //备用医嘱启用标识	SINGLE	FBoo 	 	 	
            //dto.Id_reltp	    //关联医嘱类型编码	SINGLE	Stri 	 	
            //dto.Sd_reltp	    //关联医嘱类型	SINGLE	String	 	
            //dto.Id_or_rel	    //关联医嘱	SINGLE	String	 	
            //dto.Fg_ctlcp	    //临床路径控制标识	SINGLE	FBoo 	 	 	
            //dto.Fg_mr	        //医疗记录联动标识	SINGLE	FBoo 	 	 	
            // emsHeadDO.Emsdrugs.Fg_skintest = dto.Fg_skintest; //需皮试标识	SINGLE	FBoolean 	 	
            //dto.Id_skintest_skip_reaso	//不皮试原因	SINGLE	 	 	 	
            //dto.Sd_skintest_skip_reaso	//不皮试原因编码	SING 	 	 	 	
            emsHeadDO.Emsdrugs.Fg_mp_in = dto.Fg_mp_in; //在院执行标识	SINGLE
             	
            //dto.Times_mp_in	            //在院执行次数	SINGLE	 	 	 	
            //dto.Fg_mp_bed=emsHeadDO.Emsdrugs	            //床边执行标识	SINGLE	
            //int t;
            //int.TryParse(emsHeadDO.Emsdrugs.First_freq, out t);
            //emsHeadDO.Emsdrugs.First_freq = dto.Times_firday_mp.ToString(); //首日执行次数	SINGLE	 	 	 	
            dto.Fg_or_doc = true;	            //医生医嘱标识	SINGLE	 	 	 
            emsHeadDO.Emsdrugs.Quan_firday_mp = dto.Times_firday_mp;
            emsHeadDO.Emsdrugs.Id_dep = dto.Id_dep_mp;//zwq 2016-08-04
            emsHeadDO.Emsdrugs.Name_dep = dto.Name_dep_mp;//zwq 2016-08-04

        }
        /// <summary>
        /// 编辑 服务关联的物品
        /// </summary>
        /// <param name="emsHeadDO"></param>
        /// <param name="dto"></param>
        public void EditOrDrugEmsItem(CiEmsDTO dto, EmsUIDTO emsHeadDO) {
            if (dto.Emssrvs == null) return;
            foreach (CiEmsSrvDTO p in dto.Emssrvs) {
                if (p.Fg_or == null || (p.Fg_or != null && !p.Fg_or.Value)) {
                    continue;
                }
                emsHeadDO.Emsdrugs.Fg_dose_anoma = p.Fg_dose_anoma;
                emsHeadDO.Emsdrugs.Id_unit_med = p.Id_unit_med;
                emsHeadDO.Emsdrugs.Name_unit_med = p.Name_unit_med;
                emsHeadDO.Emsdrugs.Fg_self = p.Fg_self;
                emsHeadDO.Emsdrugs.Fg_outp = p.Fg_outp;
                emsHeadDO.Emsdrugs.Fg_propc = p.Fg_propc;
                emsHeadDO.Emsdrugs.Fg_treat = p.Fg_indic;// p.Fg_treat;
                emsHeadDO.Emsdrugs.Fg_bl = p.Fg_bl;
                emsHeadDO.Emsdrugs.EmsOrDrugList.Add(new EmsOrDrug() {
                    Id_orsrv = p.Id_orsrv, //医疗单项目主键标识 
                    //Id_or =         //医疗单	SINGLE	F 
                    Sortno = p.Sortno, //序号	SINGLE	I 
                    Id_srv = p.Id_srv, //医疗服务	REF	 
                    //Id_srv_set	     //所属服务套	SINGL 
                    Name_srv = p.Name_srv, //医疗服务名称	SINGL 
                    Id_unit_med = p.Id_unit_med, //医疗单位	REF	 
                    Name_unit_med = p.Name_unit_med, //医疗单位编码	SINGL 
                    Quan_med = p.Quan_med, //剂量	SINGLE	F 
                    Price = p.Price, //参考价格	SINGL 
                    Id_freq = p.Id_freq, //医嘱频次	REF	 
                    Name_freq = p.Name_freq, //医嘱频次名称	SINGL 
                    //Des_srv	          //备注	SINGLE	 
                    //Fg_or	          //医嘱标识	SINGL 
                    //Fg_bl	          //费用标识	SINGL 
                    //Id_org_srv	      //开立机构	SINGL 
                    //Id_dep_srv	      //开立科室	SINGL 
                    //Id_ward_srv	      //开立病区	SINGL 
                    //Id_emp_srv	      //开立人员	SINGL 
                    //Dt_last_bl	      //最近生成日期	SINGL 
                    //Eu_blmd	          //划价方式	SINGL 
                    Id_emsordrug = p.Id_orsrvmm, //服务项目物品	SINGL  	 	
                    Id_mm = p.Id_mm, //物品	SINGLE	 
                    Code_mm = p.Code_mm, //物品编码	SINGL 
                    Name_mm = p.Name_mm, //物品名称	SINGL 
                    //Spec_mm	          //规格	SINGLE	S 

                    Id_pgku_cur = p.Id_unit_sale, //零售单位	REF	 
                    Name_pgku_cur = p.Name_unit_sale, //零售单位名称	SINGL 
                    Id_unit_base = p.Id_unit_base, //基本单位	REF	 
                    Name_unit_base = p.Name_unit_base, //基本单位名称	SINGL 
                    Name_unit_sale = p.Name_unit_sale,
                    Id_unit_sale = p.Id_unit_sale,
                    Quan_cur = p.Quan_cur,//总量
                    Quan_base = p.Quan_base, //总量_基本	SINGL 
                    Factor_cb = p.Factor_cb, //当前基本换算系数	S  	 	
                    Factor_mb = p.Factor_mb, //医疗基本换算系数	S  	 	
                    Id_dosage = p.Id_dosage, //药品剂型	SINGL 
                    Sd_dosage = p.Sd_dosage, //药品剂型编码	SINGL 
                    Id_pharm = p.Id_pharm, //药理分类	SINGL 
                    Sd_pharm = p.Sd_pharm, //药理分类编码	SINGL 
                    Id_pois = p.Id_pois, //毒麻分类	SINGL 
                    Sd_pois = p.Sd_pois, //毒麻分类编码	SINGL 
                    Id_anti = p.Id_anti, //抗菌药分类	SINGL 
                    Sd_anti = p.Sd_anti, //抗菌药分类编码	S 
                    Id_mmtp = p.Id_mmtp, //物品类型	SINGL 
                    Sd_mmtp = p.Sd_mmtp, //物品类型编码	SINGL 
                    Id_val = p.Id_val, //价值分类	SINGL 
                    Sd_val = p.Sd_val, //价值分类编码	SINGL 
                    Id_boildes = p.Id_boildes,//煎法
                    Name_boildes = p.Name_boildes,//煎法名称
                    Fg_propc = p.Fg_propc,//预防用药标识
                    Fg_treat = p.Fg_indic,//治疗用药标识
                    Note_or = p.Des_srv,//备注
                    Id_mp_dep = p.Id_dep,//执行科室id
                    Name_mp_dep = p.Name_dep,//执行科室
                    Fg_self = p.Fg_self,//自备药标识
                    Fg_dose_anoma = p.Fg_dose_anoma,//变动用药标识
                    Fg_ctm = p.Fg_selfsrv,//自定义服务标志
                    Fg_selfpay = p.Fg_selfpay, // 自费标志
                    //Indica	          //适应症	SINGLE	S 
                    //Constr	          //禁忌症	SINGLE	S 
                    //React	          //不良反应	SINGL 
                    //Guide	          //主要作用	SINGL 
                    //Fg_otc	          //OTC标识	SINGL 
                    //Emsfreqdose	      //变动用药安排	SINGL  	
                    //Id_body	          //部位	SINGLE	  	 	
                    //Sd_body	          //部位编码	SINGL 
                    //Id_pos	          //体位	SINGLE	  	 	
                    //Sd_pos	          //体位编码	SINGL 
                    //Body_name	      //部位名称	SINGL 
                    //Fg_indic	      //医保适应症标识	S 
                    Use_days = dto.Days_or, //使用天数
                    //皮试信息
                    Fg_skintest = p.Fg_skintest,//是否皮试
                    Id_or_rel = p.Id_or_rel,//关联皮试id
                    Id_skintest_skip_reason = p.Id_skintest_skip_reason,//强制使用原因
                    Id_reltp = p.Id_reltp,//关联类型id
                    Sd_reltp = p.Sd_reltp,//关联类型sd
                    Id_hp = p.Id_hp,
                    Id_hpsrvtp = p.Id_hpsrvtp,
                    Sd_hpsrvtp = p.Sd_hpsrvtp,
                    Limit = p.Limit,
                    Fg_hpindicjudged = p.Fg_hpindicjudged,
                    Fg_extdispense = p.Fg_extdispense//外配药标识
                });
                EditDoseDrug(emsHeadDO, p);
            }
        }


        private void EditDoseDrug(EmsUIDTO emsHeadDO, CiEmsSrvDTO srv) {
            FArrayList list = srv.Emsfreqdose;
            if (list == null) return;
            foreach (OrdSrvDoseDO item in list) {
                emsHeadDO.Emsdrugs.EmsOrDoseDrug.Add(
                    new EmsOrDrug {
                        Id_emsordrug = item.Id_orsrvdose,
                        Id_orsrv = item.Id_orsrv,
                        Id_freqtime = item.Id_freqtime,
                        Quan_med = item.Quan_dose,
                        Name_freqtime = item.Id_freqtime,
                        Name_unit_med = item.Name_unit_dose,
                        Id_unit_med = item.Id_unit_dose

                    });
            }

        }

        #endregion 编辑 药品医疗单

        #region 编辑 病理申请单

        public void EditPathgy(EmsUIDTO headDo, CiEmsDTO dto) {
            headDo.Dt_begin_ui = dto.Dt_begin;
            headDo.Dt_end_ui = dto.Dt_end;
            headDo.Days_or = dto.Days_or;
            headDo.Times_cur = dto.Times_cur;
            headDo.Times_mp_in = dto.Times_mp_in;
            CiorapppathgyAggDO agg = dto.Orapplysheet[((int)EmsType.PATHGY).ToString()] as CiorapppathgyAggDO;
            FArrayList list = dto.Emssrvs;
            EditPathgyAp(headDo, agg, dto);
            if (agg.getOrdApPathgySampDO() == null)
                return;
            EditPathgyItem(headDo, agg);
        }
        /// <summary>
        /// 编辑 病理医疗单对照
        /// </summary>
        /// <param name="headDo"></param>
        /// <param name="agg"></param>
        private void EditPathgyAp(EmsUIDTO headDo, CiorapppathgyAggDO agg, CiEmsDTO dto) {
            //CiEmsSrvDTO srvdto = dto.Emssrvs[0] as CiEmsSrvDTO;
            CiEmsSrvDTO srvdto = dto.Emssrvs[0] as CiEmsSrvDTO;
            foreach(CiEmsSrvDTO ems in dto.Emssrvs){
                if(ems.Eu_sourcemd == (int)OrSrvSourceFromEnum.PHYSIAN){
                    srvdto = ems;
                    break;
                }
            }
            headDo.Emsappathgy.Times_cur = dto.Times_cur;
            headDo.Emsappathgy.Use_days = dto.Days_or;
            headDo.Emsappathgy.Dt_begin_ui = dto.Dt_begin;
            headDo.Emsappathgy.Dt_end_ui = dto.Dt_end;
            headDo.Emsappathgy.Times_mp_in = dto.Times_mp_in;
            headDo.Emsappathgy.Id_srv = dto.Id_srv;//服务id	REF	医疗服务	20	医疗服务
            headDo.Emsappathgy.Name_srv = srvdto.Name_srv;//病理项目	SINGLE	String	50
            headDo.Emsappathgy.Id_di = agg.getParentDO().Id_di;// 诊断id	REF	医疗服务_疾病诊断定
            headDo.Emsappathgy.Name_diag = agg.getParentDO().Name_diag;// 诊断	SINGLE	String	50
            headDo.Emsappathgy.Id_diitm = agg.getParentDO().Id_diitm;
            string[] diagArray = new GetPatDiagImp().getDiagArray(headDo.PatInfo.Id_ent);
            if (diagArray != null)
            {
                headDo.Emsappathgy.Str_code_di = diagArray[1];//诊断编码拼接
                headDo.Emsappathgy.Str_name_di = diagArray[0];//诊断名称拼接
                headDo.Emsappathgy.Str_id_diitm = diagArray[2];//诊断子项目id拼接
            }
            headDo.Emsappathgy.Fg_urgent = agg.getParentDO().Fg_urgent;// 加急标识	SINGLE	FBoolean
            headDo.Emsappathgy.Id_samptp = agg.getParentDO().Id_samptp;//标本类型id	REF	标本类型_自定义档案
            headDo.Emsappathgy.Sd_samptp = agg.getParentDO().Sd_samptp;//标本类型编码	SINGLE	String	50
            headDo.Emsappathgy.Name_samptp = agg.getParentDO().Name_samptp;//标本类型	SINGLE	String	50
            headDo.Emsappathgy.Id_dep_coll = agg.getParentDO().Id_dep;//  标本采集科室id	REF	部门	20
            headDo.Emsappathgy.Name_dep_coll = agg.getParentDO().Name_dep;//  标本采集科室	SINGLE	String
            headDo.Emsappathgy.Id_emp_coll = agg.getParentDO().Id_emp;//采集者id REF 人员基本信息 20
            headDo.Emsappathgy.Name_emp_coll = agg.getParentDO().Name_coll_emp;//采集者	SINGLE String	50
            headDo.Emsappathgy.Dt_coll = agg.getParentDO().Dt_coll;//采集时间 SINGLE FDateTime
            headDo.Emsappathgy.Announcements = agg.getParentDO().Announcements;//检查要求	SINGLE	String	150
            headDo.Emsappathgy.Des_sympsign = agg.getParentDO().Des_sympsign;//病情描述	SINGLE	备注	300
            headDo.Emsappathgy.Fg_outer = agg.getParentDO().Fg_outer;//外院标志	SINGLE	FBoolean
            headDo.Emsappathgy.No_pathgy_old = agg.getParentDO().No_pathgy_old;//既往病理号	SINGLE	String
            headDo.Emsappathgy.Id_di_pathgy_old = agg.getParentDO().Di_pathgy_old;//既往病理诊断id	REF	医疗服务_疾病诊
            headDo.Emsappathgy.Name_di_pathgy_old = agg.getParentDO().Di_pathgy_old;//既往病理诊断	REF	医疗服务_疾病诊
            headDo.Emsappathgy.No_pathgy = agg.getParentDO().No_pathgy;//病理号
            //headDo.Emsappathgy.Name_di_pathgy_old = agg.getParentDO().Name_pathgy_old;//既往病理诊断 SINGLE	String
            headDo.Emsappathgy.Org_pathgy_old = agg.getParentDO().Org_pathgy_old;//既往病理医院	SINGLE	String
            headDo.Emsappathgy.Dt_pathgy_old = agg.getParentDO().Dt_pathgy_old;//既往病理日期 SINGLE	FDateTim
            headDo.Emsappathgy.Collectdes = agg.getParentDO().Collectdes;//采集所见	SINGLE	String	50

            //headDo.Emsappathgy.Id_ordpathgyitem = path.Id_appathgy;//	主键	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //headDo.Emsappathgy.Id_or = path.Id_or;	          //  医嘱id	SINGLE	String	20	 		 	 	 	
            //headDo.Emsappathgy.Id_orsrv = srv.Id_orsrv;   // 医嘱服务id	SINGLE	String	50	 		 	 	 	
            headDo.Emsappathgy.No_applyform = agg.getParentDO().No_applyform;// 申请单号	SINGLE	String	50	 		 	 	 	
            headDo.Emsappathgy.Dt_create = dto.Dt_begin;//   申请时间	SINGLE	FDateTime	  			 	 	 	
            headDo.Emsappathgy.Id_emp_create = dto.Id_emp_phy;//  申请医生id	REF	用户	20	 	  	 	 	
            headDo.Emsappathgy.Name_emp_create = dto.Name_emp_phy;//  申请医师	SINGLE	String	50	 		 	 	 	
            //headDo.Emsappathgy.No_pathgy = path.No_pathgy;//病理号 SINGLE	String	50	 		 	 	 	
            headDo.Emsappathgy.Dt_rptpathgy = agg.getParentDO().Dt_rptpathgy;//报告发布时间	SINGLE	FDateTim 	 			 	 	 	
            //headDo.Emsappathgy.Str_id_di = agg.getParentDO().Str_code_di;//诊断idi拼接字符串	SINGLE	Stri 	 			 	 	 	
            //headDo.Emsappathgy.Str_name_di = agg.getParentDO().Str_name_di;//诊断名字拼接字符串	SINGLE	Stri 	 			 	 	 	
            //headDo.Emsappathgy.Sv = path.Sv; //  版本号                        
            headDo.Emsappathgy.Id_mp_dep = dto.Id_dep_mp;
            headDo.Emsappathgy.Name_mp_dep = dto.Name_dep_mp;
            headDo.Emsappathgy.Dt_begin_ui = dto.Dt_begin;
            headDo.Emsappathgy.Dt_end_ui = dto.Dt_end;
            headDo.Emsappathgy.Times_cur = dto.Times_cur;
            headDo.Emsappathgy.Times_mp_in = dto.Times_mp_in;
            headDo.Emsappathgy.Use_days = dto.Days_or;

            headDo.Emsappathgy.Def1 = agg.getParentDO().Def1;
            headDo.Emsappathgy.Def2 = agg.getParentDO().Def2;
            headDo.Emsappathgy.Def3 = agg.getParentDO().Def3;
            headDo.Emsappathgy.Def4 = agg.getParentDO().Def4;
            headDo.Emsappathgy.Def5 = agg.getParentDO().Def5;
            headDo.Emsappathgy.Def6 = agg.getParentDO().Def6;
            headDo.Emsappathgy.Def7 = agg.getParentDO().Def7;
            headDo.Emsappathgy.Def8 = agg.getParentDO().Def8;
            headDo.Emsappathgy.Def9 = agg.getParentDO().Def9;
            headDo.Emsappathgy.Def10 = agg.getParentDO().Def10;
            headDo.Emsappathgy.Def11 = agg.getParentDO().Def11;
            headDo.Emsappathgy.Def12 = agg.getParentDO().Def12;
            headDo.Emsappathgy.Def13 = agg.getParentDO().Def13;
            headDo.Emsappathgy.Def14 = agg.getParentDO().Def14;
        }

        /// <summary>
        /// 编辑 病理标本信息对照
        /// </summary>
        /// <param name="headDo"></param>
        /// <param name="agg"></param>
        private void EditPathgyItem(EmsUIDTO headDo, CiorapppathgyAggDO agg) {
            foreach (OrdApPathgySampDO item in agg.getOrdApPathgySampDO()) {
                headDo.Emsappathgy.EmsItemInpathgy.Add(new EmsItemInPathgy() {
                    Id_oriteminpathgy = item.Id_appathgysamp,//	主键	SINGLE	Str
                    //Id_or	         =item;//    医嘱主键	SINGLE	
                    Name_labsamp = item.Name_labsamp,//标本名称	SINGLE	
                    Body_coll = item.Body_coll,//    采集部位	SINGLE	
                    Quan_coll = item.Quan_coll,//    标本数量	SINGLE	
                    Fixative = item.Fixative,  //    固定液	SINGLE	Int
                    //Collectdes	     =item.,//    采集所见	SINGLE	
                    //Dt_coll	         =item.Dt_coll,//    采集时间	SINGLE	
                    //Id_emp_coll	     =item.,//    采集者编码	REF	用户
                    //Name_emp_coll	 =item.,//    采集者名称	SINGLE	
                    Sortno = item.Sortno,//    序号	SINGLE	Int
                    Id_su_labsamp = item.Id_su_labsamp,//    标本状态id	SINGLE	
                    Sd_su_labsamp = item.Sd_su_labsamp,//    标本状态编码	SIN
                    Id_dep_sign = item.Id_dep_sign,//    标本签收科室	REF
                    Id_emp_sign = item.Id_emp_sign,//    标本签收人	REF	用户

                });
            }

        }

        #endregion 编辑 病理申请单

        #region 编辑 会诊申请单
        //会诊
        public void EditCons(EmsUIDTO headDo, CiEmsDTO dto) {
            try {
                EditHeadCommon(dto, headDo);
                List<CiEmsSrvDTO> srvList = new List<CiEmsSrvDTO>();
                foreach (CiEmsSrvDTO item in dto.Emssrvs) {
                    srvList.Add(item);
                }
                CiEmsSrvDTO srvCommon = srvList.FirstOrDefault(p => p.Eu_sourcemd == (int)OrSrvSourceFromEnum.PHYSIAN && dto.Id_srv==p.Id_srv);//srvCommon  公用服务 专门针对那些只有一条服务的 
                EditCommonSrv(srvCommon, headDo);
                List<string> lstSrvid = new List<string>();
                double price = 0.0;
                foreach (var srv in srvList)
                {
                    if (!lstSrvid.Contains(srv.Id_srv) && srv.Fg_bl == true)
                    {
                        lstSrvid.Add(srv.Id_srv);
                        if (srv.Price != null) {
                            price += (double)srv.Price;    
                        }
                    }

                }
                headDo.Emsapcons.Dt_begin_ui = dto.Dt_begin; //开始日期	SINGLE	FDateTim 	 	
                headDo.Emsapcons.Dt_end_ui = dto.Dt_end; //结束日期	SINGLE	FDateTim 
                headDo.Emsapcons.Use_days = dto.Days_or; //医嘱天数	SINGLE	Integer
                headDo.Emsapcons.Times_cur = dto.Times_cur;//医嘱次数
                headDo.Emsapcons.Times_mp_in = dto.Times_mp_in;//在院执行次数
                headDo.Emsapcons.Price = price;// 会诊价格
                headDo.Emsapcons.Id_orsrv = srvCommon.Id_orsrv;
                if (dto.Orapplysheet != null) {
                    CiorappconsultAggDO agg = dto.Orapplysheet[((int)EmsType.CONS).ToString()] as CiorappconsultAggDO;
                    EditApCons(headDo, agg, dto, srvList);
                    EditConsEmp(headDo, agg);
                }
            }
            catch { }
        }


        /// <summary>
        /// Edits 会诊申请单
        /// </summary>
        /// <param name="headDo">The head do.</param>
        /// <param name="dto">The dto.</param>
        /// Author:admin
        /// Date:2015-12-16
        public void EditApCons(EmsUIDTO headDo, CiorappconsultAggDO agg, CiEmsDTO dto, List<CiEmsSrvDTO> srvList) {

            OrdApConsDO cons = agg.getParentDO();
            //if (agg.getOrdApConsDO() != null)
            //{
            //    cons = agg.getOrdApConsDO()[0];
            //}

            CiEmsSrvDTO srvCommon = srvList.FirstOrDefault(p => p.Eu_sourcemd == (int)OrSrvSourceFromEnum.PHYSIAN);//srvCommon  公用服务 专门针对那些只有一条服务的 
            headDo.Emsapcons.Id_emsconsitem = cons.Id_apcons;	//主键	SINGLE	String	50	  
            //headDo.Emsapcons.Id_or = cons.Id_or;      //医嘱id	SINGLE	String	50
            headDo.Emsapcons.Id_srv = srvCommon.Id_srv;
            headDo.Emsapcons.Name_srv = srvCommon.Name_srv;
            //headDo.Emsapcons.Id_orsrv = dto.Id_orsrv;
            headDo.Emsapcons.Fg_urgent = cons.Fg_urgent;    //加急标识	SINGLE	FBoolean  
            headDo.Emsapcons.Dt_plan = cons.Dt_plan;     	//计划会诊时间	SINGLE	FDateTime 
            headDo.Emsapcons.Tel = cons.Tel;      	//联系电话	SINGLE	String	2 
            //headDo.Emsapcons.Id_place = cons.Id_place;   //申请地点id	REF	地点	20	 	  
            headDo.Emsapcons.Name_place = cons.Place;    //申请地点名称	SINGLE	String	5 
            headDo.Emsapcons.Des_emr = cons.Des_emr;        //  病理摘要	SINGLE	备注	300	  
            headDo.Emsapcons.Des_psp = cons.Des_psp;        //会诊目的	SINGLE	备注	300	  
            headDo.Emsapcons.Id_dep_cons = dto.Id_dep_phy;	    // 申请科室id	REF	部门	20	 	  
            headDo.Emsapcons.Name_dep_cons = dto.Name_dep_phy;	//申请科室	SINGLE	String	5 
            headDo.Emsapcons.Dt_creat = dto.Dt_begin;	    //申请时间	SINGLE	FDateTime 
            headDo.Emsapcons.Id_emp_cons = dto.Id_emp_phy;	    //申请人id	REF	用户	20	 	  
            headDo.Emsapcons.Name_emp_cons = dto.Name_emp_phy; //申请人	SINGLE	String
            headDo.Emsapcons.Id_constp = cons.Id_constp;
            headDo.Emsapcons.Sd_constp = cons.Sd_constp;
            headDo.Emsapcons.Name_constp = cons.Name_constp;
        }

        public void EditConsEmp(EmsUIDTO headDo, CiorappconsultAggDO agg) {
            OrdApConsDO cons = agg.getParentDO();
            if (agg.getCiordInviteConsDO() == null)
                return;
            foreach (CiordInviteConsDO item in agg.getCiordInviteConsDO()) {
                headDo.Emsapcons.EmsConsAssistItem.Add(new EmsItemInCons() {
                    Id_emsitemincons = item.Id_invitecons,//主键		主键	SINGLE
                    //Sortno	        =item.//    排序号	SINGLE	Integer	10
                    Id_org = item.Id_org,//    受邀机构id	REF	组织	20
                    Name_org = item.Name_org,//受邀机构	SINGLE	String
                    Id_dep_emp = item.Id_dep,//    受邀科室id	REF	部门	20
                    Name_dep_emp = item.Name_dep,//受邀科室	SINGLE	String
                    Sd_emp_title = item.Sd_emp_title,//受邀职称编码	SINGLE	St
                    Id_emp_title = item.Id_emp_title,//受邀职称id	REF	人员聘任职
                    Name_emp_title = item.Name_emp_title,//    受邀职称	SINGLE	String
                    Id_emp_doctor = item.Id_emp,//受邀人id	REF	用户	20
                    Name_emp_doctor = item.Name_emp,//    受邀人	SINGLE	String	50
                    Dt_response = item.Dt_response,//    应答时间	SINGLE	FDateT
                    Fg_response = item.Fg_response,//应答标志	SINGLE	FBoole
                    Id_emp_response = item.Id_emp_response,//    应答人id	REF	用户	20
                    Name_emp_response = item.Name_emp_respon,//应答人	SINGLE	String	50
                    ////Id_srv	        =item.//    会诊项目id	REF	医疗服务	
                    //Name_srv	        =item.//会诊项目	SINGLE	String
                    Sd_constp = cons.Sd_constp,//会诊类型编码	SINGLE	St
                    Id_constp = cons.Id_constp,//会诊类型id	REF	会诊类型_自
                    Name_constp = cons.Name_constp//    会诊类型	SINGLE	String
                    //Sv                =item.//
                });

            }

        }
        #endregion  编辑 会诊申请单

        #region 编辑 备血医疗单

        private void EditIndicatorDateSource(EmsUIDTO headDo, CiorappbtAggDO agg) {

            if (agg == null)
                return;

            for (int i = 0; i < agg.ChildrenList[0].Count; i++) {
                OrdApBtViewItemDO odo = agg.ChildrenList[0][i] as OrdApBtViewItemDO;
                headDo.Emsapbt.BtLabItem[i].Val_rstrptla = odo.Val_rstrptla;
                headDo.Emsapbt.BtLabItem[i].Id_apop = odo.Id_apbt;
                headDo.Emsapbt.BtLabItem[i].Id_apopobsindex = odo.Id_apbtobsindex;
                headDo.Emsapbt.BtLabItem[i].Sv = odo.Sv;
                headDo.Emsapbt.BtLabItem[i].Status = DOStatus.UNCHANGED;
            }
        }

        public void EditApbt(EmsUIDTO emsHeadDO, CiEmsDTO dto, ref string medUnitName) {
            EditHeadCommon(dto, emsHeadDO);
            List<CiEmsSrvDTO> srvList = new List<CiEmsSrvDTO>();
            foreach (CiEmsSrvDTO item in dto.Emssrvs) {
                srvList.Add(item);
            }

            CiEmsSrvDTO srvCommon = srvList[0];
            srvCommon = srvList.FirstOrDefault(p => p.Eu_sourcemd == (int)OrSrvSourceFromEnum.PHYSIAN);//srvCommon  公用服务 专门针对那些只有一条服务的 
            CiorappbtAggDO agg = dto.Orapplysheet[((int)EmsType.BT).ToString()] as CiorappbtAggDO;

            EditCommonSrv(srvCommon, emsHeadDO);
            //li_cheng 修改
            var service = XapServiceMgr.find<IMedsrvMDOCrudService>();
            emsHeadDO.MedSrvDO = service.findById(dto.Id_srv);
            EditApbtParent(emsHeadDO, dto, srvCommon, ref medUnitName);
            EditIndicatorDateSource(emsHeadDO, agg);

        }

        public void EditApbtParent(EmsUIDTO emsHeadDO, CiEmsDTO dto, CiEmsSrvDTO srv, ref string medUnitName) {
            emsHeadDO.Emsapbt.Dt_bt = dto.Dt_begin;
            CiorappbtAggDO agg = dto.Orapplysheet[((int)EmsType.BT).ToString()] as CiorappbtAggDO;
            if (agg == null)
                return;

            OrdApBtDO bt = agg.getParentDO();
            if (bt == null)
                return;

            // 列表中服务名称
            emsHeadDO.Emsapbt.Components_name = dto.Name;
            //emsHeadDO.Emsapbt.i
            emsHeadDO.Emsapbt.Id_emsbt = bt.Id_apbt;
            emsHeadDO.Emsapbt.No_applyform = bt.No_applyform;
            emsHeadDO.Emsapbt.Pregnat_num = bt.Pregnant_num;
            emsHeadDO.Emsapbt.Parturition_cnt = bt.Parturition_cnt;

            emsHeadDO.Emsapbt.Fg_db = bt.Fg_db;
            emsHeadDO.Emsapbt.No_db = bt.No_db;



            emsHeadDO.Emsapbt.Id_di = bt.Id_di;
            emsHeadDO.Emsapbt.Name_diag = bt.Name_diag;
            emsHeadDO.Emsapbt.Id_diitm = bt.Id_diitm;//主诊断id
            //诊断信息
            string[] diagArray = new GetPatDiagImp().getDiagArray(emsHeadDO.PatInfo.Id_ent);
            if (diagArray != null)
            {
                emsHeadDO.Emsapbt.Str_code_di = diagArray[1];//诊断编码拼接
                emsHeadDO.Emsapbt.Str_name_di = diagArray[0];//诊断名称拼接
                emsHeadDO.Emsapbt.Str_id_diitm = diagArray[2];//诊断子项目id拼接
            }

            emsHeadDO.Emsapbt.Id_his_bt = bt.Id_his_bt;
            emsHeadDO.Emsapbt.Name_his_bt = bt.Name_his_bt;
            emsHeadDO.Emsapbt.Sd_his_bt = bt.Sd_his_bt;

            emsHeadDO.Emsapbt.Id_pps = bt.Id_pps_bt;
            emsHeadDO.Emsapbt.Name_pps = bt.Name_pps_bt;
            emsHeadDO.Emsapbt.Sd_pps = bt.Sd_pps_bt;

            emsHeadDO.Emsapbt.Id_labitmexplain = bt.Id_labitmexplain;
            emsHeadDO.Emsapbt.Name_labitmexplain = bt.Name_labitmexplain;
            emsHeadDO.Emsapbt.Sd_labitmexplain = bt.Sd_labitmexplain;

            emsHeadDO.Emsapbt.Id_demandsu = bt.Id_demandsu_bt;
            emsHeadDO.Emsapbt.Name_demandsu = bt.Name_demandsu_bt;
            emsHeadDO.Emsapbt.Sd_demandsu = bt.Sd_demandsu_bt;

            emsHeadDO.Emsapbt.Id_mode = bt.Id_mode_bt;
            emsHeadDO.Emsapbt.Name_mode = bt.Name_mode_bt;
            emsHeadDO.Emsapbt.Sd_mode = bt.Sd_mode_bt;
            emsHeadDO.Emsapbt.Name_emp_create = dto.Name_emp_phy;


            emsHeadDO.Emsapbt.Id_srv = srv.Id_srv;
            emsHeadDO.Emsapbt.Name_srv = srv.Name_srv;

            emsHeadDO.Emsapbt.Id_emp_create = srv.Id_emp_srv;
            emsHeadDO.Emsapbt.Dt_create = srv.Dt_create_srv;

            emsHeadDO.Emsapbt.Quan_med = srv.Quan_med;
            emsHeadDO.Emsapbt.Id_unit_med = srv.Id_unit_med;

            emsHeadDO.Emsapbt.Name_unit_med = srv.Name_unit_med;
            medUnitName = srv.Name_unit_med;
            emsHeadDO.Emsapbt.Status = DOStatus.UPDATED;
        }

        #endregion

        #region 编辑 用血医疗单

        public void EditApbtuse(EmsUIDTO emsHeadDO, CiEmsDTO dto) {
            OrdAppBtUseDO odp = dto.Orapplysheet[((int)EmsType.BTUSE).ToString()] as OrdAppBtUseDO;
            FArrayList li = dto.Emssrvs;
            CiEmsSrvDTO srvDto = li[0] as CiEmsSrvDTO;
            if (odp != null) {
                emsHeadDO.CiordubDTO = new CiordubDTO();
                emsHeadDO.CiordubDTO.No_applyform_ub = odp.No_applyform;
                emsHeadDO.CiordubDTO.Dt_bu_pl_ub = odp.Dt_bu_plan;
                emsHeadDO.CiordubDTO.Dt_begin_ui = dto.Dt_begin;
                emsHeadDO.CiordubDTO.Dt_end_ui = dto.Dt_end;
                emsHeadDO.CiordubDTO.Times_cur = dto.Times_cur;
                emsHeadDO.CiordubDTO.Use_days = dto.Days_or;
                //emsDO.CiordubDTO.Applyform=odp.
                emsHeadDO.CiordubDTO.Orsrvname = dto.Name;
                emsHeadDO.CiordubDTO.Id_srv = dto.Id_srv;
                emsHeadDO.CiordubDTO.Name_unit = srvDto.Name_unit_med;
                emsHeadDO.CiordubDTO.Quan_medu_ub = srvDto.Quan_med;
                emsHeadDO.CiordubDTO.Id_unit = srvDto.Id_unit_med;
                emsHeadDO.CiordubDTO.Id_route = dto.Id_route;
                emsHeadDO.CiordubDTO.Name_route = dto.Name_route;
                emsHeadDO.CiordubDTO.Status = DOStatus.UPDATED;
                emsHeadDO.CiordubDTO.Id_apbu = odp.Id_apbu;
                emsHeadDO.CiordubDTO.Name_emp_create = dto.Name_emp_phy;
                emsHeadDO.CiordubDTO.Id_emp_create = dto.Id_emp_phy;
                emsHeadDO.CiordubDTO.Id_or_rel = dto.Id_or_rel;
            }

        }

        #endregion

        #region 编辑 手术医疗单

        private void EditIndicatorDateSource(EmsUIDTO headDo, CiorappsurgeryAggDO agg) {
            if (agg == null)
                //agg = dto.Orapplysheet[((int)EmsType.OPER).ToString()] as CiorappbtAggDO;
                return;

            var arr = agg.getOrdApSugViewItemDO();
            headDo.Emsapop.OpLabItem.Clear();
            for (int i = 0; arr != null && i < arr.Count(); i++) {
                OrdApSugViewItemDO odo = arr[i] as OrdApSugViewItemDO;
                headDo.Emsapop.OpLabItem.Add(new OrdApSugViewItemDO() {
                    Val_rstrptla = odo.Val_rstrptla == null ? "" : odo.Val_rstrptla,
                    Val_restrptlab = odo.Val_restrptlab == null ? "" : odo.Val_restrptlab.Replace(',', '|'),
                    Sd_restrptlabtp = odo.Sd_restrptlabtp,
                    Name_srv = odo.Name_srv == null ? "" : odo.Name_srv,
                    Name_unit = odo.Name_unit == null ? "" : odo.Name_unit,
                    Id_unit = odo.Id_unit,
                    Id_srv = odo.Id_srv,
                    Id_apopobsindex = odo.Id_apopobsindex,
                    Status = odo.Status,
                    Id_apop = odo.Id_apop,
                    Sv = odo.Sv,
                    Id_restrptlabtp = odo.Id_restrptlabtp,
                    Ds = odo.Ds

                });

                //headDo.Emsapop.OpLabItem[i].Val_rstrptla = odo.Val_rstrptla;
                ////headDo.Emsapop.OpLabItem[i].Id_apop = odo.Id_apop;
                //headDo.Emsapop.OpLabItem[i].Id_apopobsindex = odo.Id_apopobsindex;
                ////headDo.Emsapop.OpLabItem[i].Sv = odo.Sv;
                //headDo.Emsapop.OpLabItem[i].Status = DOStatus.UNCHANGED;
            }

        }

        public void EditApop(EmsUIDTO emsHeadDO, CiEmsDTO dto) {
            EditHeadCommon(dto, emsHeadDO);
            //{{ 精简代码，去掉循环遍历 -- 2016-11-30 -- wangqzh
//             List<CiEmsSrvDTO> srvList = new List<CiEmsSrvDTO>();
//             foreach (CiEmsSrvDTO item in dto.Emssrvs) {
//                 srvList.Add(item);
//             }
//             dto.Emssrvs.Sort(0, dto.Emssrvs.Count, new CiEmsSrvDTOComparer());
//           CiEmsSrvDTO srvCommon = srvList[0]; // 这样寻找主服务项目有错误
            //}}

            //{{ 寻找主服务项目 -- 2016-11-30 -- wangqzh
            CiEmsSrvDTO srvCommon = dto.Emssrvs.Cast<CiEmsSrvDTO>().ToList().FirstOrDefault(p => p.Id_srv.Equals(dto.Id_srv) && p.Fg_or != null && p.Fg_or.Value);
            //}}
            if (srvCommon == null) {
                throw new Exception("解析手术医疗单时候，没有获取到主服务项目");
            }
            //}}
            int s = srvCommon.Status;
            CiorappsurgeryAggDO agg = dto.Orapplysheet[((int)EmsType.OPER).ToString()] as CiorappsurgeryAggDO;
            emsHeadDO.Emsapop.Id_mp_dep = srvCommon.Id_dep;
            emsHeadDO.Emsapop.Name_mp_dep = srvCommon.Name_dep;
            emsHeadDO.Emsapop.Id_srv = dto.Id_srv;
            emsHeadDO.Emsapop.Name_srv = dto.Name;
            emsHeadDO.Emsapop.Id_orsrv = srvCommon.Id_orsrv;

            EditCommonSrv(srvCommon, emsHeadDO);
            EditApopParent(emsHeadDO, dto, srvCommon);
            EditApopEmpChildren(emsHeadDO, dto, srvCommon);
            EditApopMmChildren(emsHeadDO, dto, srvCommon);
            EditApopAppendSugChildren(emsHeadDO, dto);
            EditIndicatorDateSource(emsHeadDO, agg);
        }

        private void EditApopParent(EmsUIDTO emsHeadDO, CiEmsDTO dto, CiEmsSrvDTO srvCommon) {
            CiorappsurgeryAggDO agg = dto.Orapplysheet[((int)EmsType.OPER).ToString()] as CiorappsurgeryAggDO;
            if (agg == null)
                return;

            var op = agg.getParentDO();
            if (op == null)
                return;
            emsHeadDO.Emsapop.Use_days = dto.Days_or;
            emsHeadDO.Emsapop.Dt_begin_ui = dto.Dt_begin;
            emsHeadDO.Emsapop.Dt_end_ui = dto.Dt_end;
            emsHeadDO.Emsapop.Times_cur = dto.Times_cur;
            emsHeadDO.Emsapop.Times_mp_in = dto.Times_mp_in;

            emsHeadDO.Emsapop.Id_apop = op.Id_apop;
            //麻醉方法
            emsHeadDO.Emsapop.Id_anestp = op.Id_anestp;
            emsHeadDO.Emsapop.Sd_anestp = op.Sd_anestp;
            emsHeadDO.Emsapop.Name_anestp = op.Name_anestp;
            emsHeadDO.Emsapop.Id_di = op.Id_di;
            emsHeadDO.Emsapop.Name_diag = op.Name_didef_dis;
            //诊断信息
            emsHeadDO.Emsapop.Id_di = op.Id_di;//主诊断的主项目id
            emsHeadDO.Emsapop.Id_diitm = op.Id_diitm;//主诊断id
            emsHeadDO.Emsapop.Name_diag = op.Name_diag;//主诊断名称
            string[] diagArray = new GetPatDiagImp().getDiagArray(emsHeadDO.PatInfo.Id_ent);
            if (diagArray != null)
            {
                emsHeadDO.Emsapop.Str_code_di = diagArray[1];//诊断编码拼接
                emsHeadDO.Emsapop.Str_name_di = diagArray[0];//诊断名称拼接
                emsHeadDO.Emsapop.Str_id_diitm = diagArray[2];//诊断子项目id拼接
            }
            //Id_diitm = null,
            emsHeadDO.Emsapop.Id_emp_help1 = op.Id_emp_helper;
            emsHeadDO.Emsapop.Name_emp_help1 = op.Name_helper;
            emsHeadDO.Emsapop.Id_emp_operator = op.Id_emp_operate;
            emsHeadDO.Emsapop.Name_emp_operator = op.Name_operate;
            //切口愈合等级
            emsHeadDO.Emsapop.Id_incitp = op.Id_incitp;
            emsHeadDO.Emsapop.Sd_incitp = op.Sd_incitp;
            //手术级别
            emsHeadDO.Emsapop.Id_lvlsug = op.Id_lvlsug;
            emsHeadDO.Emsapop.Sd_lvlsug = op.Sd_lvlsug;
            emsHeadDO.Emsapop.Name_lvlsug = op.Name_lvlsug;
            //emsHeadDO.Id_or = op.Id_or;
            emsHeadDO.MedSrvDO.Id_srv = op.Id_srv;
            emsHeadDO.Emsapop.Code_srv = op.Id_srv_code;
            //体位
            emsHeadDO.Emsapop.Id_sugbodycod = op.Id_sugbody;
            emsHeadDO.Emsapop.Sd_sugbodycod = op.Sd_sugbody;
            emsHeadDO.Emsapop.Name_sugbodycod = op.Name_sugbody;
            //手术申请状态
            //Id_su_op = null,
            //Sd_su_op = null,
            emsHeadDO.Emsapop.Fg_allergy = op.Fg_allergy;
            emsHeadDO.Emsapop.Fg_new_sug = op.Fg_new_sug;
            emsHeadDO.Emsapop.Fg_patho = op.Fg_patho;
            emsHeadDO.Emsapop.Fg_er_sug = op.Fg_er_sug;
            emsHeadDO.Emsapop.Fg_xq_sug = op.Fg_xq_sug;
            emsHeadDO.Emsapop.Fg_zq_sug = op.Fg_zq_sug;
            emsHeadDO.Emsapop.Dt_plan = op.Dt_plan;
            emsHeadDO.Emsapop.Dt_creat = dto.Dt_begin;
            emsHeadDO.Emsapop.No_applyform = op.No_applyform;
            emsHeadDO.Emsapop.Quan_bt_plan = op.Quan_bt_paln;
            emsHeadDO.Emsapop.Time_sup_plan = op.Sugplantime;
            emsHeadDO.Emsapop.Specialdes = op.Specialdes;
            emsHeadDO.Emsapop.Specialinstrument = op.Specialinstrument;
            emsHeadDO.Emsapop.Specialreq = op.Specialreq;
            emsHeadDO.Emsapop.Announcements = op.Announcements;
            emsHeadDO.Emsapop.Status = DOStatus.UNCHANGED;
            emsHeadDO.Emsapop.Price = srvCommon.Price;
            emsHeadDO.Emsapop.Des = srvCommon.Des_srv;
            // 剂量和频次信息
            emsHeadDO.Emsapop.Id_unit_med = srvCommon.Id_unit_med;
            emsHeadDO.Emsapop.Name_unit_med = srvCommon.Name_unit_med;
            emsHeadDO.Emsapop.Quan_med = srvCommon.Quan_med;
            emsHeadDO.Emsapop.Id_freq = srvCommon.Id_freq;
            emsHeadDO.Emsapop.Name_freq = srvCommon.Name_freq;
            emsHeadDO.Emsapop.Freqct = srvCommon.Freqct;
           
        }

        private void EditApopEmpChildren(EmsUIDTO emsHeadDO, CiEmsDTO dto, CiEmsSrvDTO srvCommon) {
            CiorappsurgeryAggDO agg = dto.Orapplysheet[((int)EmsType.OPER).ToString()] as CiorappsurgeryAggDO;
            if (agg == null)
                return;

            var op = agg.getOrdOpEmpDO();
            if (op == null)
                return;

            emsHeadDO.Emsapop.OpEmpItem.Clear();
            List<OrdOpEmpDO> ops = op.ToList();
            ops.Sort((OrdOpEmpDO emp1, OrdOpEmpDO emp2) =>
            {
                if (emp1 != null && emp2 != null) {
                    if (emp1.Sortno > emp2.Sortno) return 1;
                    if (emp1.Sortno < emp2.Sortno) return -1;
                    return 0;
                }
                return 0;
            });
            foreach (var emp in ops)
            {
                EmsItemInOp empitem = new EmsItemInOp {
                    Id_oropitem = emp.Id_apopemp,
                    Id_emp_op = emp.Id_emp,
                    Name_emp_op = emp.Name_emp,
                    Id_role = emp.Id_role,
                    Sd_role = emp.Sd_role,
                    Name_role = emp.Name_role,
                    Sv = emp.Sv,
                    Status = DOStatus.UNCHANGED
                };
                emsHeadDO.Emsapop.OpEmpItem.Add(empitem);
            }
        }

        private void EditApopMmChildren(EmsUIDTO emsHeadDO, CiEmsDTO dto, CiEmsSrvDTO srvCommon) {
            CiorappsurgeryAggDO agg = dto.Orapplysheet[((int)EmsType.OPER).ToString()] as CiorappsurgeryAggDO;
            if (agg == null)
                return;

            var op = agg.getOrdOpMmDO();
            if (op == null)
                return;

            emsHeadDO.Emsapop.OpMmItem.Clear();
            foreach (var mm in op) {
                EmsItemInOp mmitem = new EmsItemInOp {
                    Id_oropitem = mm.Id_apopmm,
                    Id_mm = mm.Id_mm,
                    Name_mm = mm.Name_mm,
                    Id_mmtp = mm.Id_mmtp,
                    Sd_mmtp = mm.Sd_mmtp,
                    Name_mmtp = mm.Name_mmtp,
                    Spec = mm.Spec,
                    Id_sup = mm.Id_sup,
                    Name_sup = mm.Name_sug,
                    Price = mm.Price,
                    Quan_cur = mm.Quan_cur,
                    Id_unit_pkgsp = mm.Id_unit_pkgsp,
                    Name_unit_pkgsp = mm.Name_unit_pkgsp,
                    Status = DOStatus.UNCHANGED
                };
                emsHeadDO.Emsapop.OpMmItem.Add(mmitem);
            }
        }

        private void EditApopAppendSugChildren(EmsUIDTO emsHeadDO, CiEmsDTO dto) {
            /*
            dto.Emssrvs.Sort(0,dto.Emssrvs.Count,new CiEmsSrvDTOComparer());
            for (int i = 1; i < dto.Emssrvs.Count; i++) {
                CiEmsSrvDTO item = dto.Emssrvs[i] as CiEmsSrvDTO;
                if (item == null)
                    continue;
                //为啥要清空
                // emsHeadDO.Emsapop.OpAppendOpItem.Clear();
                EmsItemInOp sugitem = new EmsItemInOp {
                    Name_srv = item.Name_srv,
                    Id_srv = item.Id_srv,
                    Code_srv = item.Code_srv,
                    Des_op = item.Des_srv,
                    Id_orsrv = item.Id_orsrv,
                    Status = DOStatus.UNCHANGED
                };
                emsHeadDO.Emsapop.OpAppendOpItem.Add(sugitem);
            }
            */
            // 分拣附加手术项目：项目列表中，排除主医嘱项目，排除非临床项目 -- wangqzh
            dto.Emssrvs.Cast<CiEmsSrvDTO>().ToList().Where(p => p.Id_srv != dto.Id_srv && p.Fg_or != null && p.Fg_or.Value).ToList().ForEach(p=> {
                emsHeadDO.Emsapop.OpAppendOpItem.Add(new EmsItemInOp
                {
                    Name_srv = p.Name_srv,
                    Id_srv = p.Id_srv,
                    Code_srv = p.Code_srv,
                    Des_op = p.Des_srv,
                    Id_orsrv = p.Id_orsrv,
                    Status = DOStatus.UNCHANGED
                });
            });
        }
        #endregion
    }
}