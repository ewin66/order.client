using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using iih.bd.bc.udi;
using iih.bd.srv.medsrv.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.ci.ord.i;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.sys.xbd.udi.d;
using xap.mw.core.utils;
using xap.rui.control.extentions;

/********************************************************************************

** 作者： 李政

** 创始时间：2016-6-30

** 修改人：李政

** 修改时间：2016-6-30

** 描述： 检查检验的 映射类


*********************************************************************************/
namespace iih.ci.ord.ciorder.utils
{

    /// <summary>
    /// 检查检验以及实验室的功能类
    /// zhou_zhijian 7.3做阅读注释
    /// </summary>
    public class AppObsAndlabUtil
    {
        /// <summary>
        /// 
        /// </summary>
        private LogicEx cof = LogicEx.GetInstance();
        /// <summary>
        /// 
        /// </summary>
        private GetPatDiagImp patDiagImp = new GetPatDiagImp();
        /// <summary>
        /// 
        /// </summary>
        private ICiOrdQryService qryService = XapServiceMgr.find<ICiOrdQryService>();

        public AppObsAndlabUtil()
        {
        }


        /// <summary>
        /// Adds the obs load data.
        /// </summary>
        /// <param name="med">The med.</param>
        /// Author:admin
        /// Date:2015-10-14
        public void AddObsLoadData(EmsUIDTO emsDO, MedSrvDO med)
        {
            // 医疗单
            this.AddObsDataBing(emsDO, med);
            // 是服务套
            //if ((bool)med.Fg_set)
            //{
            emsDO.MedSrvDO.Fg_set = med.Fg_set;
            GetSrvSetImp srvset = new GetSrvSetImp();
            //服务套
            MedsrvAggDO[] medsrvagg = null;
            List<MedSrvSetItemDO> medSrvSetItem = null;
            GetMedSrvImpl medSrvImpl = new GetMedSrvImpl();

            if (med != null && (bool)med.Fg_set)
            {
                medSrvSetItem = srvset.GetItemInSet(med.Id_srv);
                medsrvagg = medSrvImpl.getMedSrvDO(medSrvSetItem);
            }
            else
            {
                medsrvagg = medSrvImpl.getMedSrvAggDO(med.Id_srv);
            }


            int i = 1;
            XapDataList<EmsObsLap> list = new XapDataList<EmsObsLap>();
            foreach (MedsrvAggDO agg in medsrvagg)
            {
                MedSrvRisDO[] risdo = agg.getMedSrvRisDO();
                if (risdo != null)
                {
                    foreach (MedSrvRisDO lis in risdo)
                    {
                        EmsObsLap obs = new EmsObsLap();

                        // lab.Id_di = lis.Id_di;
                        // lab.Str_id_di = lis.Str_id_di;
                        // lab.Str_name_di = lis.Str_name_di;
                        //当BD_SRVSET_DEF.fg_edit可选标志=false时，服务列表为选中状态，且checkbox置灰，不可编辑，反之是true时，checkbox默认为选中状态，用户可编辑。（2016-03-03加）
                        if (medSrvSetItem != null && medSrvSetItem.Count() > 0)
                        {
                            MedSrvSetItemDO setItem = medSrvSetItem.FirstOrDefault(itm => itm.Id_srv_itm == agg.getParentDO().Id_srv);
                            if (setItem != null)
                            {
                                obs.Fg_edit = setItem.Fg_edit;
                                obs.Fg_or = setItem.Fg_clinical;
                                //新建时默认全部选中  2016-06-25修改
                                //if (setItem.Fg_edit == null || setItem.Fg_edit==false)
                                //{
                                //    obs.Fg_chk = false; 
                                //}
                                //else
                                //{
                                obs.Fg_chk = true;
                                //}
                            }
                        }
                        else
                        {
                            obs.Fg_or = agg.getParentDO().Fg_or;
                            obs.Fg_edit = false;
                            obs.Fg_chk = true;
                        }
                        obs.Id_primd = agg.getParentDO().Id_primd;
                        obs.Fg_mp_bed = emsDO.Emsapobs.Fg_mp_bed;
                        obs.No_applyform = emsDO.Emsapobs.No_applyobs;
                        obs.Dt_plan = emsDO.Emsapobs.Dt_plan;
                        obs.Biopsy = null;
                        obs.Des_sympsign = emsDO.Emsapobs.Des_sympsign;
                        obs.Fg_urgent = emsDO.Emsapobs.Fg_urgent;
                        obs.Announcements = lis.Note;
                        obs.Name_srv = agg.getParentDO().Name;
                        //部位可修改标识
                        obs.Fg_body_update = lis.Fg_body_update;
                        obs.Name_body = lis.Name_body;
                        obs.Sd_body = lis.Sd_body;
                        obs.Id_body = lis.Id_body;
                        obs.Fg_pos = lis.Fg_pos;
                        obs.Name_pos = lis.Name_pos;
                        obs.Sd_pos = lis.Sd_pos;
                        obs.Id_pos = lis.Id_pos;
                        obs.Id_srv = lis.Id_srvobs;
                        obs.Id_obstp = lis.Id_obstp;

                        obs.Name_obstp = lis.Obstp_name;

                        obs.Fg_pos = lis.Fg_pos;
                        obs.Id_pos = lis.Id_pos;
                        obs.Sd_pos = lis.Sd_pos;
                        obs.Quan_medu = agg.getParentDO().Quan_med;
                        obs.Id_medu = agg.getParentDO().Id_unit_med;
                        obs.Id_freq = agg.getParentDO().Id_freq;
                        obs.Sd_srvtp = agg.getParentDO().Sd_srvtp;
                        obs.Id_srv = lis.Id_srv;
                        obs.Fg_bl = agg.getParentDO().Fg_bl;
                        obs.Announcements = lis.Note;
                        //lab.Quan = lis.;



                        obs.Code_srv = agg.getParentDO().Code;

                        obs.Fg_bl = med.Fg_bl;
                        obs.Id_su_obs = CiDictCodeConst.ID_CI_OBS_SQ;
                        obs.Sd_su_obs = CiDictCodeConst.SD_CI_OBS_SQ;
                        obs.Fg_or = med.Fg_or;
                        obs.Eu_blmd = med.Eu_blmd;
                        obs.Id_srvtp = med.Id_srvtp;
                        obs.Id_srvca = med.Id_srvca;

                        obs.Sortno = i + "";
                        i++;
                        list.Add(obs);
                    }
                }
            }
            emsDO.Emsapobs.EmsOrObsList = list;

            //}

            //else
            //{

            //    EmsObsLap[] emsObsLaps = null;
            //    EmsObsItemDO[] rtn = this.qryService.getEmsObsItemDO(med.Id_srv, "");
            //    if (rtn != null && rtn.Count() > 0)
            //    {
            //        emsObsLaps = new EmsObsLap[rtn.Count()];
            //        int i = 0;
            //        foreach (EmsObsItemDO it in rtn)
            //        {
            //            EmsObsLap item = new EmsObsLap();
            //            item.Announcements = it.Announcements;

            //            item.Id_obstp = it.Id_obstp;
            //            item.Sd_obstp = it.Sd_obstp;
            //            item.Id_body = it.Id_body;
            //            item.Sd_body = it.Sd_body;
            //            item.Id_pos = it.Id_pos;
            //            item.Sd_pos = it.Sd_pos;
            //            item.Id_srv = it.Id_srv;
            //            item.Name_srv = med.Name;
            //            item.Sv = it.Sv;
            //            item.Name_body = it.Name_body;
            //            item.Fg_body_update = it.Fg_body_update;
            //            item.Code_srv = med.Code;

            //            item.Fg_bl = med.Fg_bl;
            //            item.Id_su_obs = CiDictCodeConst.ID_CI_OBS_SQ;
            //            item.Sd_su_obs = CiDictCodeConst.SD_CI_OBS_SQ;
            //            item.Fg_or = med.Fg_or;
            //            item.Eu_blmd = med.Eu_blmd;
            //            item.Id_srvtp = med.Id_srvtp;
            //            item.Id_srvca = med.Id_srvca;
            //            emsObsLaps[i] = item;
            //            i++;
            //        }

            //    }

            //    emsDO.Emsapobs.EmsOrObsList = emsObsLaps;

            //}
        }

        /// <summary>
        /// Adds the lab load data.
        /// </summary>
        /// <param name="med">检验的服务套</param>
        public void AddLabLoadData(EmsUIDTO emsDO, MedSrvDO med)
        {
            this.AddLabDataBing(emsDO, med);
            // 是服务套
            if (med.Fg_set.Value)
            {
                if (med.Fg_set != null)
                {
                    emsDO.MedSrvDO.Fg_set = med.Fg_set;
                    GetSrvSetImp srvset = new GetSrvSetImp();
                    //服务套
                    List<MedSrvSetItemDO> medSrvSetItem = srvset.GetItemInSet(med.Id_srv);
                    MedSrvSetItemDO mainItem = medSrvSetItem.FirstOrDefault(p => CiDictCodeConst.SD_SRVSETITEM_ROLE_MAIN.Equals(p.Sd_srvsetrole));
                    GetMedSrvImpl medSrv = new GetMedSrvImpl();
                    MedsrvAggDO[] medsrvagg = medSrv.getMedSrvDO(medSrvSetItem);
                    
                    if (medSrv != null)
                    {
                        int i = 1;
                        XapDataList<EmsObsLap> list = new XapDataList<EmsObsLap>();
                        foreach (MedsrvAggDO agg in medsrvagg)
                        {
                           
                            MedSrvLisDO[] lisdo = agg.getMedSrvLisDO();

                            if (lisdo != null)
                            {
                                foreach (MedSrvLisDO lis in lisdo)
                                {
                                    EmsObsLap lab = new EmsObsLap();
                                    lab.Id_srv = lis.Id_srv;
                                    lab.Fg_or = agg.getParentDO().Fg_or;
                                    lab.Eu_blmd = agg.getParentDO().Eu_blmd;
                                    lab.Sd_contp = lis.Sd_contp;
                                    lab.Id_contp = lis.Id_contp;
                                    lab.Name_srv = lis.Srv_name;
                                    lab.Id_srvca = agg.getParentDO().Id_srvca;
                                    lab.Id_srvtp = agg.getParentDO().Id_srvtp;
                                    lab.Sd_srvtp = agg.getParentDO().Sd_srvtp;
                                    lab.Id_primd = agg.getParentDO().Id_primd;
                                    //lab.Dt_plan = emsDO.Dt_begin_ui;
                                    lab.Fg_or = agg.getParentDO().Fg_or;
                                    lab.Quan = lis.Quan;//标本量 zwq 2018-08-05
                                    lab.Id_quan = lis.Id_unit_quan;//标本量单位 zwq 2018-08-05
                                    lab.Id_medu = agg.getParentDO().Id_unit_med;//剂量单位
                                    lab.Quan_medu = agg.getParentDO().Quan_med;//剂量
                                    lab.Id_freq = agg.getParentDO().Id_freq;
                                    //lab.Id_pps = lis.Id_pps;
                                    //lab.Sd_pps = lis.Sd_pps;
                                    //lab.Des_pps = lis.Des_pps;
                                    lab.Id_su_obs = CiDictCodeConst.ID_CI_LAB_SQ;
                                    lab.Sd_su_obs = CiDictCodeConst.SD_CI_LAB_SQ;
                                    lab.Des_sympsign = lis.Des_labsamp;
                                    lab.Announcements = lis.Note; // 注意事项 bd_srv_lab
                                    lab.Fg_urgent = emsDO.Emsaplab.Fg_urgent;
                                    lab.Sd_samptp = lis.Sd_samptp;
                                    lab.Id_samptp = lis.Id_samptp;
                                    lab.Sd_samptp = lis.Sd_samptp;
                                    lab.Id_samptp = lis.Id_samptp;

                                    if (mainItem != null)
                                    {
                                        if (mainItem.Id_srv_itm != null && mainItem.Id_srv_itm.Equals(lab.Id_srv))
                                        {
                                            emsDO.Emsaplab.Id_samptp = lis.Id_samptp;
                                            emsDO.Emsaplab.Sd_samptp = lis.Sd_samptp;
                                            emsDO.Emsaplab.Name_samptp = lis.Samptp_name;
                                            //标本采集时间
                                            emsDO.Emsaplab.Id_sampcoltime = lis.Id_sampcoltime;//标本采集时间id
                                            emsDO.Emsaplab.Name_sampcoltime = lis.Name_sampcoltime;//标本采集时间名称
                                            emsDO.Emsaplab.Id_sampcollecttimetp = lis.Id_sampcollecttimetp;//标本采集时间类型
                                            emsDO.Emsaplab.Sd_sampcollecttimetp = lis.Sd_sampcollecttimetp;//标本采集时间类型编码
                                            emsDO.Emsaplab.Len_sampcoltime = lis.Len_sampcoltime;//标本采集时长
                                            emsDO.Emsaplab.Id_unit_sampcoltime = lis.Id_unit_sampcoltime;//标本采集时间时长单位
                                        }
                                    }
                                    else
                                    {
                                        emsDO.Emsaplab.Id_samptp = lis.Id_samptp;
                                        emsDO.Emsaplab.Sd_samptp = lis.Sd_samptp;
                                        emsDO.Emsaplab.Name_samptp = lis.Samptp_name;
                                        emsDO.Emsaplab.Id_sampcoltime = lis.Id_sampcoltime;//标本采集时间id
                                        emsDO.Emsaplab.Name_sampcoltime = lis.Name_sampcoltime;//标本采集时间名称
                                        emsDO.Emsaplab.Id_sampcollecttimetp = lis.Id_sampcollecttimetp;//标本采集时间类型
                                        emsDO.Emsaplab.Sd_sampcollecttimetp = lis.Sd_sampcollecttimetp;//标本采集时间类型编码
                                        emsDO.Emsaplab.Len_sampcoltime = lis.Len_sampcoltime;//标本采集时长
                                        emsDO.Emsaplab.Id_unit_sampcoltime = lis.Id_unit_sampcoltime;//标本采集时间时长单位
                                    }
                                    lab.Fg_bl = agg.getParentDO().Fg_bl;
                                    lab.Sd_colltp = lis.Sd_colltp;
                                    lab.Id_colltp = lis.Id_colltp;
                                    lab.Des_labsamp = lis.Des_labsamp;
                                    lab.Fg_chk = true;//默认全部选中 2016-6-25
                                    lab.Id_labgroup = lis.Id_labgroup;
                                    lab.Sd_labgroup = lis.Sd_labgroup;
                                    MedSrvSetItemDO item = medSrvSetItem.FirstOrDefault(p => p.Id_srv_itm == lis.Id_srv);
                                    if (item != null)
                                    {
                                        lab.Fg_edit = item.Fg_edit;
                                    }
                                    lab.Sortno = i + "";
                                    i++;
                                    list.Add(lab);
                                }
                            }

                        }
                        emsDO.Emsaplab.EmsOrObsList = list;
                    }
                }
            }
            else
            {
                emsDO.Emsaplab.EmsOrObsList = new GetSrvLabImp().GetLabImpList(emsDO, med);
            }
        }
        //绑定数据 检查
        private void AddObsDataBing(EmsUIDTO headDo, MedSrvDO med)
        {   // 诊断
            
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
            headDo.Emsapobs.Name_srvtp = med.Srvca_name;
            // 检查类型id
            headDo.Emsapobs.Id_obstp = med.Id_srv;
            // 检查类型名称
            headDo.Emsapobs.Name_obstp = med.Name;

            // headDo.Emsapobs.Des_sympsign = 

            headDo.MedSrvDO.Id_freq = med.Id_freq;

            headDo.MedSrvDO.Sd_srvtp = med.Sd_srvtp;

            // 检查申请单号   
            headDo.Emsapobs.No_applyobs = qryService.getOrdApObsNoapplyform();
            headDo.Emsapobs.Dt_plan = headDo.Emsapobs.Dt_begin_ui == null ? this.NowTime() : headDo.Emsapobs.Dt_begin_ui;
            // 加急标识
            headDo.Emsapobs.Fg_urgent = false;
            MedSrvRisDO medSrvRisDo = patDiagImp.getBdSrvObs(med.Id_srv);
            if (medSrvRisDo != null && medSrvRisDo.If_mp_bed != null && (bool)medSrvRisDo.If_mp_bed)
            {
                // 床旁执行标志
                headDo.Emsapobs.Fg_mp_bed = true;
                // 症状体征描述
                // headDo.Emsapobs.Des_sympsign 
                // 身体部位id
                headDo.Emsapobs.Id_body = medSrvRisDo.Id_body;
                // 身体部位编码
                headDo.Emsapobs.Sd_body = medSrvRisDo.Sd_body;
                // 身体部位名称
                headDo.Emsapobs.Name_body = medSrvRisDo.Name_body;
                // 身体体位id
                headDo.Emsapobs.Id_pos = medSrvRisDo.Id_pos;
                // 身体体位编码
                headDo.Emsapobs.Sd_pos = medSrvRisDo.Sd_pos;
                // 身体体位名称
                headDo.Emsapobs.Name_pos = medSrvRisDo.Name_pos;
            }
            else
            {

                // 床旁执行标志
                headDo.Emsapobs.Fg_mp_bed = false;
            }

            // 计划检查时间
            // headDo.Emsapobs.Dt_begin_ui  
            // 诊断id
            string[] diagArray = patDiagImp.getDiagArray(headDo.PatInfo.Id_ent);
            if (diagArray != null)
            {
                headDo.Emsapobs.Id_di = diagArray[7];//主诊断的主项目id
                headDo.Emsapobs.Id_diitm = diagArray[3];//主诊断id
                headDo.Emsapobs.Name_diag = diagArray[4];//主诊断名称
                headDo.Emsapobs.Str_code_di = diagArray[1];//诊断编码拼接
                headDo.Emsapobs.Str_name_di = diagArray[0];//诊断名称拼接
                headDo.Emsapobs.Str_id_diitm = diagArray[2];//诊断子项目id拼接
            }

            // 检查目的编码
            UdidocDO udidoc = patDiagImp.getBdUdidocList();
            if (udidoc != null)
            {
                headDo.Emsapobs.Sd_pps = udidoc.Code;
                headDo.Emsapobs.Id_pps = udidoc.Id_udidoc;
                // 检查目的描述
                headDo.Emsapobs.Des_pps = udidoc.Name;
            }
            else
            {  // todo  暂时对应 需要修改
                headDo.Emsapobs.Sd_pps = CiDictCodeConst.SD_PPS_ASSIST;// "0001AA100000000312PC";// ##????
                headDo.Emsapobs.Id_pps = CiDictCodeConst.SD_PPS_ASSIST_ID;
                // 检查目的描述
                headDo.Emsapobs.Des_pps = CiDictCodeConst.SD_PPS_ASSIST_NAME;
            }
            //临床病症及体征内容拼接,住院部门界面没有显示，所以不给赋值，移回到门诊中2017-2-27
            //headDo.Emsapobs.Clinicalzztz = LogicEx.GetInstance().diseaseDescription(headDo.PatInfo.Id_ent);
            //headDo.Emsapobs.Des_sympsign = headDo.Emsapobs.Clinicalzztz;// 病情描述与临床症状及体征 各自保存，不互相复制
        }

        private void AddLabDataBing(EmsUIDTO headDo, MedSrvDO med)
        {
            //headDo.Emsapobs.Id_srv = med.Id_srv;  // 检查申请单主键
            //headDo.Emsapobs.Id_emsobs = "";
            // 医嘱服务id
            headDo.Emsaplab.Id_orsrv = "";
            // 医嘱医疗单
            headDo.Emsaplab.Id_or = "";
            // 服务id    
            headDo.Emsaplab.Id_srv = med.Id_srv;
            // 服务名称
            headDo.Emsaplab.Name_srv = med.Name;
            // 服务类型
            headDo.Emsaplab.Id_srvtp = med.Id_srvtp;
            // 服务类型名称
            headDo.Emsapobs.Name_srvtp = med.Name;
            // 检查类型id
            headDo.Emsaplab.Id_obstp = med.Id_srv;
            // 检查类型名称
            headDo.Emsaplab.Name_obstp = med.Name;
            headDo.Emsaplab.Name_obstp = med.Name;
            headDo.MedSrvDO.Id_freq = med.Id_freq;

            headDo.MedSrvDO.Sd_srvtp = med.Sd_srvtp;

            try
            {
                // 检查申请单号   
                headDo.Emsaplab.No_applyobs = qryService.getOrdApLabNoapplyform();    
            }
            catch (Exception ex)
            {
                ex.Publish();
            }

            headDo.Emsaplab.Dt_plan = headDo.Dt_begin_ui;
            // 诊断id
            string[] diagArray = patDiagImp.getDiagArray(headDo.PatInfo.Id_ent);
            if (diagArray != null)
            {
                headDo.Emsaplab.Id_di = diagArray[7];//主诊断的主项目id
                headDo.Emsaplab.Id_diitm = diagArray[3];//主诊断id
                headDo.Emsaplab.Name_diag = diagArray[4];//主诊断名称
                headDo.Emsaplab.Str_code_di = diagArray[1];//诊断编码拼接
                headDo.Emsaplab.Str_name_di = diagArray[0];//诊断名称拼接
                headDo.Emsaplab.Str_id_diitm = diagArray[2];//诊断子项目id拼接
            }
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
    }
}
