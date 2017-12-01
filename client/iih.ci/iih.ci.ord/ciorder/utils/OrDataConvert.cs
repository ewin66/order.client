using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using iih.ci.ord.ems.d;
using iih.ci.ord.ciordems.d;
using xap.mw.core.data;
using iih.bd.bc.udi;
using iih.ci.ord.cior.d;
using xap.mw.coreitf.d;
using xap.rui.appfw;
using iih.ci.ord.ordsrvdose.d;
using xap.cli.context;

using xap.rui.control.extentions;
using iih.ci.ord.ciorder.d;
using iih.en.que.dto.d;
using xap.mw.core.helper;
using iih.bd.srv.medsrv.i;
using xap.mw.serviceframework;
using iih.bd.srv.medsrv.d;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.ci.ord.emsdi.d;
using iih.bd.srv.service.i;
using iih.bd.mm.meterial.i;
using iih.bd.mm.meterial.d;
using iih.bd.pp.primd.i;
using iih.bl.hp.bdhpindicationdto.d;
using iih.mm.itf.material.i;
using iih.mm.itf.material.d;
using iih.ci.ord.ordsrvset.d;

/********************************************************************************

** 作者： 李政

** 创始时间：2016-6-30

** 修改人：李政

** 修改时间：2016-6-30

** 描述： CCiemsDTO  to UIEmsDTO


*********************************************************************************/
namespace iih.ci.ord.ciorder.utils
{
    /// <summary>
    /// uiems to  ems
    /// </summary>
    /// Author:admin
    /// Date:2015-11-30
    public class OrDataConvert
    {
        #region 保存数据转换
        LogicEx cof = LogicEx.GetInstance();
        // 
        public void SaveCiDTO(EmsUIDTO emsHeadDO, CiEmsDTO dto, int Eu_sourcemd)
        {

            List<CiEmsSrvDTO> srvList = new List<CiEmsSrvDTO>();
            CiEmsSrvDTO srvCommon = new CiEmsSrvDTO();
            if (dto.Emssrvs != null && dto.Emssrvs.Count > 0)
            {
                foreach (CiEmsSrvDTO item in dto.Emssrvs)
                {//遍历一下 把多条服务的放到内存集合当中，做什么用呢，后面你就知道了，为了修改时候 直接 把修改的字段赋值
                    srvList.Add(item);
                }
                if (dto.Fg_set == null || !dto.Fg_set.Value) {
                    srvCommon = srvList.FirstOrDefault(p=>p.Eu_sourcemd == (int)OrSrvSourceFromEnum.PHYSIAN&&p.Id_srv==dto.Id_srv);// srvList[0];//srvCommon  公用服务 专门针对那些只有一条服务的 
                }
                
                if(null == srvCommon) {
                    srvCommon = new CiEmsSrvDTO();
                }

                srvCommon.Status = emsHeadDO.Status;
            }
            else {
                // 医嘱来源：服务参照
                dto.Eu_orsrcmdtp = OrSourceFromEnum.IIHSRVREF;
                
            }
            emsHeadDO.Emsapbt.Status = emsHeadDO.Status;
            emsHeadDO.Emsapop.Status = emsHeadDO.Status;
            
             SaveDtoCommonDataBing(dto, emsHeadDO);
             SaveCommonSrvDataBing(srvCommon, emsHeadDO, Eu_sourcemd);
            

            switch (emsHeadDO.EmsType)
            {
                case EmsType.IV:
                case EmsType.HERB:
                case EmsType.COMMONDRUG://通用药品
                    SaveApDrug(dto, emsHeadDO);
                    dto.Emssrvs = SaveOrDrugEmsItemToDto(emsHeadDO, dto.Fg_pres_outp, srvList, Eu_sourcemd);
                    //在修改的情况下，已经存在了医嘱id，为每个服务项目添加id_or
                    if (dto.Status != DOStatus.NEW)
                    {
                        FArrayList emsarr = dto.Emssrvs;
                        foreach (CiEmsSrvDTO emssrvdto in emsarr)
                        {
                            emssrvdto.Id_or = dto.Id_or;
                        }
                    }
                    break;


                case EmsType.RIS://检查
                    //SaveApObs(dto, emsHeadDO);
                    //设置检查申请单
                    setOrderAppObs(emsHeadDO, dto);
                    dto.Emssrvs = SaveEmsApObsItem(emsHeadDO, dto, Eu_sourcemd);

                    break;
                case EmsType.LIS://检验
                    //SaveApLab(dto, emsHeadDO);

                    setOrderAppLab(emsHeadDO, dto);
                    dto.Emssrvs = SaveEmsApLabItem(emsHeadDO, dto, Eu_sourcemd);
                    break;
             
                case EmsType.OPER://手术
                    #region 杂项

                    SaveOpSrv(srvCommon, emsHeadDO);//服务补充

                    dto.Applyno = emsHeadDO.Emsapop.No_applyform;
                    #endregion

                    dto.Emssrvs.Clear();
                    dto.Id_dep_mp = emsHeadDO.Emsapop.Id_mp_dep;//zwq 2016-08-04执行科室id
                    //if (emsHeadDO.MedSrvDO.Fg_set.Value)
                    //{
                    //    dto.Emssrvs.Add(getCiEmsSrvDTO(emsHeadDO, Eu_sourcemd));
                    //}
                    srvCommon.Id_unit_med = emsHeadDO.Emsapop.Id_unit_med;
                    srvCommon.Name_unit_med = emsHeadDO.Emsapop.Name_unit_med;
                    srvCommon.Quan_med = emsHeadDO.Emsapop.Quan_med;
                    dto.Dt_begin = emsHeadDO.Emsapop.Dt_plan;
                    dto.Dt_end = emsHeadDO.Emsapop.Dt_end_ui;
                    dto.Days_or = emsHeadDO.Emsapop.Use_days;
                    dto.Times_cur = emsHeadDO.Emsapop.Times_cur;          //在院执行标识	SINGLE	 	 	 	 	
                    dto.Times_mp_in = emsHeadDO.Emsapop.Times_mp_in;      //在院执行次数

                    dto.Emssrvs.Add(srvCommon);
                    //附加手术
                    dto.Emssrvs.AddRange(SaveOpAppendOpDataBing(srvCommon, emsHeadDO));
                    CiorappsurgeryAggDO aggop;
                    CiorappsurgeryAggDO aggorgin = null;
                    if (dto.Orapplysheet.Keys.Contains(((int)EmsType.OPER).ToString()))
                        aggorgin = dto.Orapplysheet[((int)EmsType.OPER).ToString()] as CiorappsurgeryAggDO;
                    if (srvCommon.IsNEW)
                    {
                        aggop = new CiorappsurgeryAggDO();
                        aggop.setParentDO(SaveApSugDataBing(emsHeadDO, aggorgin));
                        //手术人员
                        aggop.setOrdOpEmpDO(SaveOpSugEmpDataBing(emsHeadDO, aggorgin).ToArray());
                        //特殊物品
                        aggop.setOrdOpMmDO(SaveOpSugMmDataBing(emsHeadDO, aggorgin).ToArray());
                        //术前检查
                        aggop.setOrdApSugViewItemDO(SaveApSugItemDataBing(emsHeadDO, aggorgin).ToArray());
                        if (aggorgin != null)
                            aggop.Status = DOStatus.NEW;
                        dto.Orapplysheet.Add(((int)EmsType.OPER).ToString(), aggop);
                        dto.Applyno = aggop.getParentDO().No_applyform;
                    }
                    else {
                        //更新的时候设置值
                        setOpValue(dto,emsHeadDO);
                    }
                    
                    

                    break;

                case EmsType.PATHGY://病理
                    SaveApPathgyDataBing(emsHeadDO, dto);
                    dto.Emssrvs.Clear();
                    dto.Emssrvs.Add(srvCommon);
                    SavePathgySrv(srvCommon, emsHeadDO);//通用的服务srvCommon  字段不够  新增一些
                    break;

                case EmsType.BT://输血
                    if (srvCommon.IsNEW)
                    {
                        CiorappbtAggDO aggbt = new CiorappbtAggDO();
                        aggbt.setParentDO(SaveApBtDataBing(emsHeadDO));//申请单
                        aggbt.setOrdApBtViewItemDO(SaveApBtItemDataBing(emsHeadDO).ToArray());//输血单关联项目
                        dto.Orapplysheet.Clear();
                        dto.Orapplysheet.Add(((int)EmsType.BT).ToString(), aggbt);
                        dto.Applyno = aggbt.getParentDO().No_applyform;
                        dto.Innercode_srvca = emsHeadDO.MedSrvDO.Srvca_innercode;//服务分类内部编码
                         //是否加急标志：根据备血申请单的输血需求状态判断，“紧急”时加急状态为true
                        if (aggbt.getParentDO().Sd_demandsu_bt == "0")
                        {
                            dto.Fg_urgent = true;
                        }
                        else {
                            dto.Fg_urgent = false;
                        }
                        srvCommon.Fg_set = emsHeadDO.MedSrvDO.Fg_set;
                        srvCommon.Id_freq = emsHeadDO.MedSrvDO.Id_freq;
                    }
                    else { 
                        //更新时
                        updApBtDataBing(dto,emsHeadDO);
                    }
                    
                    //dto.Dt_begin = emsHeadDO.Emsapbt.Dt_bt;
                    dto.Applyno = emsHeadDO.Emsapbt.No_applyform;
                    dto.Dt_begin = emsHeadDO.Emsapbt.Dt_bt;
                    dto.Dt_end = emsHeadDO.Emsapbt.Dt_end_ui;
                    dto.Days_or = emsHeadDO.Emsapbt.Use_days;
                    dto.Times_cur = emsHeadDO.Emsapbt.Times_cur;          //在院执行标识	SINGLE	 	 	 	 	
                    dto.Times_mp_in = emsHeadDO.Emsapbt.Times_mp_in;      //在院执行次数
                    srvCommon.Id_dep =  emsHeadDO.Emsapbt.Id_mp_dep;
                   // srvCommon.Id_freq = emsHeadDO.MedSrvDO.Id_freq;
                    srvCommon.Quan_med = emsHeadDO.Emsapbt.Quan_med;
                    srvCommon.Id_unit_med = emsHeadDO.Emsapbt.Id_unit_med;
                    srvCommon.Name_unit_med = emsHeadDO.Emsapbt.Name_unit_med;
                    //srvCommon.Status = emsHeadDO.Emsapbt.Status;
                    srvCommon.Factor_mb = srvCommon.Factor_mb ?? 1;
                    srvCommon.Id_hp = emsHeadDO.PatInfo.Id_hp;
                    //12/26 11:14 added by yz 
                    //need EmsBtItemDO.cs and EmsBtItemDO_Partial.cs compiled
                    srvCommon.Fg_mm = emsHeadDO.Emsapbt.Fg_mm;
                    srvCommon.Fg_or = emsHeadDO.Emsapbt.Fg_or;
                    //srvCommon.Fg_bl = true;
                    srvCommon.Fg_bl = false;//血液的费用标识为false
                    srvCommon.Fg_selfpay = emsHeadDO.Emsapbt.Fg_selfpay;
                    if (emsHeadDO.Emsapbt.Fg_selfpay!=null && emsHeadDO.Emsapbt.Fg_selfpay.Value)
                   {
                       srvCommon.Fg_hpindicjudged = (int)HpIndicJudgeEnum.SELFPAY;
                   }else{
                         srvCommon.Fg_hpindicjudged = null;
                   }


                    //li_cheng
                    if (emsHeadDO.MedSrvDO.Fg_set != null && (bool)emsHeadDO.MedSrvDO.Fg_set)
                        dto.Emssrvs = SaveEmsApBtItem(emsHeadDO, dto, Eu_sourcemd, srvCommon);
                    else if (srvCommon.IsNEW)
                    {
                        dto.Emssrvs.Clear();
                        dto.Emssrvs.Add(srvCommon);
                    }

                    break;

                case EmsType.BTUSE://用血
                    //可参照病理
                    SaveApBtUseDataBing(emsHeadDO, dto);
                    srvCommon.Name_srv = emsHeadDO.CiordubDTO.Orsrvname;
                    srvCommon.Quan_med = emsHeadDO.CiordubDTO.Quan_medu_ub;
                    srvCommon.Name_unit_med = emsHeadDO.CiordubDTO.Name_unit;
                    srvCommon.Id_unit_med = emsHeadDO.CiordubDTO.Id_unit;
                    srvCommon.Id_dep = emsHeadDO.CiordubDTO.Id_mp_dep;
                    srvCommon.Id_freq = emsHeadDO.MedSrvDO.Id_freq;
                    srvCommon.Fg_mm = emsHeadDO.MedSrvDO.Fg_mm;
                    srvCommon.Id_hp = emsHeadDO.PatInfo.Id_hp;
                    srvCommon.Fg_bl = emsHeadDO.MedSrvDO.Fg_bl;
                    srvCommon.Id_route = emsHeadDO.CiordubDTO.Id_route;
                    if (emsHeadDO.IsNEW)
                    {
                        dto.Emssrvs.Add(srvCommon);
                    }
                    else
                    {
                        dto.Emssrvs.Clear();
                        dto.Emssrvs.Add(srvCommon);
                    }
                    dto.Innercode_srvca = emsHeadDO.MedSrvDO.Srvca_innercode;//服务分类内部编码
                     srvCommon.Fg_selfpay = emsHeadDO.Emsapbt.Fg_selfpay;
                    if (emsHeadDO.Emsapbt.Fg_selfpay!=null && emsHeadDO.Emsapbt.Fg_selfpay.Value)
                   {
                       srvCommon.Fg_hpindicjudged = (int)HpIndicJudgeEnum.SELFPAY;
                   }else{
                         srvCommon.Fg_hpindicjudged = null;
                   }
                    break;

                case EmsType.SKINTEST:
                case EmsType.COMMON://通用
                    SaveApDrug(dto, emsHeadDO);
                    if (srvCommon.Fg_set == FBoolean.True)
                    {
                        dto.Quan_medu = srvCommon.Quan_med;
                        dto.Id_unit_med = srvCommon.Id_unit_med;
                        dto.Name_unit_med = srvCommon.Name_unit_med;
                    }
                    
                    SaveApCommonSrv(srvCommon, emsHeadDO);//补充字段
                    //当医嘱类型是治疗类时，为皮试医嘱 zwq 2016-08-19
                    if (BdSrvDictCodeConst.SD_SRVTP_TREAT_SKINMINGANTEST.Equals(dto.Sd_srvtp)) {
                        dto.Fg_skintest = true;
                    }
                    if (emsHeadDO.MedSrvDO.Fg_set.Value)
                    {
                        getCommonOrdSetItemSrv(dto,srvCommon, emsHeadDO, Eu_sourcemd);
                    }
                    else {
                        dto.Emssrvs.Clear();
                        dto.Emssrvs.Add(srvCommon);
                    }
                    
                    break;

                case EmsType.CONS://会诊
                    SaveApConsDataBing(emsHeadDO, dto);

                    if (dto.Id_or == null)
                    {
                        srvCommon.Id_freq = emsHeadDO.MedSrvDO.Id_freq;
                        srvCommon.Id_route = emsHeadDO.MedSrvDO.Id_route;
                        srvCommon.Id_routedes = emsHeadDO.MedSrvDO.Id_routedes;
                        srvCommon.Name_srv = emsHeadDO.MedSrvDO.Name;
                        srvCommon.Id_unit_med = emsHeadDO.MedSrvDO.Id_unit_med;
                        srvCommon.Fg_set = emsHeadDO.MedSrvDO.Fg_set;
                        if (srvCommon.Quan_med == null)
                        {
                            srvCommon.Quan_med = emsHeadDO.MedSrvDO.Quan_med;
                        }                      
                    }
                    else { // 处理更新会诊

                    }
                  
                    //  SaveApCommonSrv(srvCommon, emsHeadDO);//补充字段
                    //if (emsHeadDO.IsNEW)
                    //{
                    //    dto.Emssrvs.Add(srvCommon);
                    //}
                    //else
                    //{
                        dto.Emssrvs.Clear();
                        dto.Emssrvs.Add(srvCommon);
                    //}
                    if (emsHeadDO.Emsapcons.EmsConsAssistItem.Count > 0)
                        srvCommon.Id_dep = emsHeadDO.Emsapcons.EmsConsAssistItem[0].Id_dep_emp;
                    dto.Dt_begin = emsHeadDO.Emsapcons.Dt_plan;
                    dto.Dt_end = emsHeadDO.Emsapcons.Dt_plan;
                    dto.Name = emsHeadDO.MedSrvDO.Name;
                    dto.Innercode_srvca = emsHeadDO.MedSrvDO.Srvca_innercode;//服务分类内部编码
                    break;
                case EmsType.OUTHOSP://出院
                    SaveApOutDataBing(emsHeadDO, dto);
                        srvCommon.Id_freq = emsHeadDO.MedSrvDO.Id_freq;
                        srvCommon.Id_route = emsHeadDO.MedSrvDO.Id_route;
                        srvCommon.Id_routedes = emsHeadDO.MedSrvDO.Id_routedes;
                        srvCommon.Name_srv = emsHeadDO.MedSrvDO.Name;
                        srvCommon.Id_unit_med = emsHeadDO.MedSrvDO.Id_unit_med;
                        srvCommon.Fg_set = emsHeadDO.MedSrvDO.Fg_set;
                        srvCommon.Quan_med = emsHeadDO.MedSrvDO.Quan_med;
                        if (emsHeadDO.IsNEW)
                        {
                            dto.Emssrvs.Clear();
                            dto.Emssrvs.Add(srvCommon);
                        }
                        else {
                            dto.Emssrvs.Clear();
                            dto.Emssrvs.Add(srvCommon);
                        }
                    break;

                case EmsType.TRANSDEPT://转科
                    SaveApTransDataBing(emsHeadDO, dto);
                    if (emsHeadDO.IsNEW)
                    {
                        OrWfDeptInfoDTO wf = new viewmodel.impext.GetDeptMpImp().GetDept_mp_ids(emsHeadDO.PatInfo.Code_entp, emsHeadDO.PatInfo.Id_entp, emsHeadDO.MedSrvDO.Sd_srvtp, emsHeadDO.MedSrvDO.Id_srvca, emsHeadDO.MedSrvDO.Id_srv, emsHeadDO.MedSrvDO.Id_route, "id_mm", emsHeadDO.PatInfo.Id_dep_nur, emsHeadDO.PatInfo.Id_dep_phy);
                        srvCommon.Id_dep = wf.Firstid_mp_dept;
                        dto.Id_dep_mp = wf.Firstid_mp_dept;
                        dto.Emssrvs.Add(srvCommon);
                    }
                    else { 
                            dto.Emssrvs.Clear();
                            dto.Emssrvs.Add(srvCommon);
                    }
                    //srvCommon.Id_dep = emsHeadDO.Emsaptrans.Id_dep_nur_to;//执行科室为 目标病区 改为 通过新的医嘱流向配置计算执行科室
                        srvCommon.Id_freq = emsHeadDO.MedSrvDO.Id_freq;
                        srvCommon.Id_route = emsHeadDO.MedSrvDO.Id_route;
                        srvCommon.Id_routedes = emsHeadDO.MedSrvDO.Id_routedes;
                        srvCommon.Name_srv = emsHeadDO.MedSrvDO.Name;
                        srvCommon.Id_unit_med = emsHeadDO.MedSrvDO.Id_unit_med;
                        srvCommon.Fg_set = emsHeadDO.MedSrvDO.Fg_set;
                        srvCommon.Quan_med = emsHeadDO.MedSrvDO.Quan_med;
                    
                    break;

                default:
                    break;
            }
            //医嘱项目共同字段处理
            setCiEmsSrvDTOCommon(emsHeadDO, dto, Eu_sourcemd);

            if (dto.Orapplysheet != null && dto.Orapplysheet.Keys.Count == 0)
            {
                dto.Orapplysheet = null;
            }
            if (dto.Emssrvs.Count == 0)
            {
                dto.Emssrvs = null;
            }
            if (dto.Srvsetitms != null && dto.Srvsetitms.Keys.Count == 0)
            {
                dto.Srvsetitms = null;
            }
            if (dto.Ciorfreqtimes != null && dto.Ciorfreqtimes.Count == 0)
            {
                dto.Ciorfreqtimes = null;
            }
        }

        private void setOpValue(CiEmsDTO dto, EmsUIDTO emsHeadDO)
        {
            FMap map = dto.Orapplysheet;
            CiorappsurgeryAggDO aggdo = map[((int)EmsType.OPER).ToString()] as CiorappsurgeryAggDO;
            //主表
            OrdApOpDO apOp = aggdo.getParentDO();

            //apOp.Id_apop = emsHeadDO.Emsapop.Id_apop;
            //麻醉方法
            apOp.Id_anestp = emsHeadDO.Emsapop.Id_anestp;
            apOp.Sd_anestp = emsHeadDO.Emsapop.Sd_anestp;
            //诊断
            apOp.Id_di = emsHeadDO.Emsapop.Id_di;
            apOp.Id_diitm = emsHeadDO.Emsapop.Id_diitm;
            apOp.Name_diag = emsHeadDO.Emsapop.Name_diag;
            apOp.Str_name_di = emsHeadDO.Emsapop.Str_name_di;
            apOp.Str_code_di = emsHeadDO.Emsapop.Str_code_di;
            apOp.Str_id_diitm = emsHeadDO.Emsapop.Str_id_diitm;

            apOp.Id_emp_helper = emsHeadDO.Emsapop.Id_emp_help1;
            apOp.Id_emp_operate = emsHeadDO.Emsapop.Id_emp_operator;
            //切口愈合等级
            apOp.Id_incitp = emsHeadDO.Emsapop.Id_incitp;
            apOp.Sd_incitp = emsHeadDO.Emsapop.Sd_incitp;
            //手术级别
            apOp.Id_lvlsug = emsHeadDO.Emsapop.Id_lvlsug;
            apOp.Sd_lvlsug = emsHeadDO.Emsapop.Sd_lvlsug;
            //apOp.Id_or = emsHeadDO.Id_or;
            apOp.Id_srv_code = emsHeadDO.Emsapop.Code_srv;
            //体位
            apOp.Id_sugbody = emsHeadDO.Emsapop.Id_sugbodycod;
            apOp.Sd_sugbody = emsHeadDO.Emsapop.Sd_sugbodycod;
            //手术申请状态
            apOp.Id_su_op = CiDictCodeConst.ID_SU_OP_YSQ;
            apOp.Sd_su_op = CiDictCodeConst.SD_SU_OP_YSQ;
            apOp.Fg_allergy = emsHeadDO.Emsapop.Fg_allergy;
            apOp.Fg_new_sug = emsHeadDO.Emsapop.Fg_new_sug;
            apOp.Fg_patho = emsHeadDO.Emsapop.Fg_patho;
            apOp.Fg_er_sug = emsHeadDO.Emsapop.Fg_er_sug;
            apOp.Fg_xq_sug = emsHeadDO.Emsapop.Fg_xq_sug;
            apOp.Fg_zq_sug = emsHeadDO.Emsapop.Fg_zq_sug;
            apOp.Dt_plan = emsHeadDO.Emsapop.Dt_plan;
            apOp.No_applyform = emsHeadDO.Emsapop.No_applyform;
            apOp.Quan_bt_paln = emsHeadDO.Emsapop.Quan_bt_plan;
            apOp.Sugplantime = emsHeadDO.Emsapop.Time_sup_plan;
            apOp.Specialdes = emsHeadDO.Emsapop.Specialdes;
            apOp.Specialinstrument = emsHeadDO.Emsapop.Specialinstrument;
            apOp.Specialreq = emsHeadDO.Emsapop.Specialreq;
            apOp.Announcements = emsHeadDO.Emsapop.Announcements;
            apOp.Status = DOStatus.UPDATED;

            //手术人员
           //OrdOpEmpDO[] opempDoArr = aggdo.getOrdOpEmpDO();
           List<OrdOpEmpDO> opempDoList = opempDoList = new List<OrdOpEmpDO>();
           int i = 0;
            emsHeadDO.Emsapop.OpEmpItem.ToList().ForEach(item =>
            {
                OrdOpEmpDO empDo = new OrdOpEmpDO();
                //if (opempDoArr != null)
                //{
                //    empDo = opempDoArr.FirstOrDefault<OrdOpEmpDO>(mm => mm.Id_emp == item.Id_emp_op);
                //}
                //if (empDo == null)
                //{
                //    empDo = new OrdOpEmpDO();
                //    empDo.Id_apop = emsHeadDO.Emsapop.Id_apop;
                //}
                empDo.Id_apopemp = item.Id_oropitem;
                empDo.Id_apop = emsHeadDO.Emsapop.Id_apop;
                empDo.Id_emp = item.Id_emp_op;     //人员	REF	用户	id_emp	varchar	20	用户	用户名称	 				 	 	 	 	 	 
                empDo.Sd_role = item.Sd_role;	     //角色编码	SINGLE	String	sd_role	varchar	50	 	 	 				 	 	 	 
                empDo.Id_role = item.Id_role;	     //角色id	REF	手术角色类型_自定义档案	id_role	varchar	20	手术角色类型_自定义档案	名称	 	
                empDo.Status = item.Status;
                empDo.Sv = item.Sv;
                empDo.Sortno = i++;
                opempDoList.Add(empDo);
            });
            aggdo.setOrdOpEmpDO(opempDoList.ToArray());
        //特殊物品
            i = 0;
            OrdOpMmDO[] opmmDoArr = aggdo.getOrdOpMmDO(); 
            List<OrdOpMmDO> opmmDoList;
            if (opmmDoArr == null)
            {
                opmmDoList = new List<OrdOpMmDO>();
            }
            else {
                opmmDoList = opmmDoArr.ToList<OrdOpMmDO>();
            }
            emsHeadDO.Emsapop.OpMmItem.ToList().ForEach(item =>
            {
                OrdOpMmDO mmDo = null;
                if (opmmDoArr != null) {
                    mmDo = opmmDoArr.FirstOrDefault<OrdOpMmDO>(mm => mm.Id_apopmm == item.Id_oropitem);
                }
                if (mmDo == null)
                {
                    mmDo = new OrdOpMmDO();
                    opmmDoList.Add(mmDo);
                    mmDo.Id_apop = emsHeadDO.Emsapop.Id_apop;
                }
                mmDo.Id_mm = item.Id_mm;	//物品id	REF	医疗物品_基本信息	id_mm	varchar	20	医疗物品	物品名称	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	a16b2
                mmDo.Sd_mmtp = item.Sd_mmtp;	//物品类型编码	SINGLE	String	sd_mmtp	varchar	50	 	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
                mmDo.Id_mmtp = item.Id_mmtp;	//物品类型id	REF	医疗物品类型_自定义档案	id_mmtp	varchar	20	医疗物品类型_自定义档案	名称	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	a16b3
                mmDo.Spec = item.Spec;	    //规格	SINGLE	String	spec	varchar	50	 	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
                mmDo.Id_sup = item.Id_sup;	//厂家	REF	医疗物品_供应商与厂商	id_sup	varchar	20	供应商及厂商	供应商与厂商名称	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	a16b4
                mmDo.Price = item.Price;	//价格	SINGLE	FDouble	price	decimal	16	 	 	 				 	 	 	 	 	2				 	 			 	 	 		 	 	 	 	 
                mmDo.Quan_cur = item.Quan_cur;	//数量	SINGLE	Integer	quan_cur	integer	10	 	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
                mmDo.Id_unit_pkgsp = item.Id_unit_pkgsp;	//单位	REF	医疗物品_包装单位集	id_unit_pkgsp	varchar	20
                mmDo.Status = item.Status;
                i++;
            });
            aggdo.setOrdOpMmDO(opmmDoList.ToArray());
            //动态指标
            i = 0;

            OrdApSugViewItemDO[] items = aggdo.getOrdApSugViewItemDO();
            List<OrdApSugViewItemDO> itemsList;
            if (items == null) {
                itemsList = new List<OrdApSugViewItemDO>();
            }
            else {
                itemsList = items.ToList<OrdApSugViewItemDO>();
            }
            emsHeadDO.Emsapop.OpLabItem.ToList().ForEach(item =>
            {
                OrdApSugViewItemDO mmDo = null;
                if (items != null) {
                    mmDo = items.FirstOrDefault<OrdApSugViewItemDO>(mm => mm.Id_srv == item.Id_srv);
                }
                if (null != mmDo)
                    item.Sv = mmDo.Sv;
                //if (mmDo == null) {
                //    mmDo = new OrdApSugViewItemDO();
                //    itemsList.Add(mmDo);
                //}
                //items[i].Val_rstrptla = item.Val_rstrptla;
                //items[i].Status = item.Status;
                //i++;
            });
           
               aggdo.setOrdApSugViewItemDO(emsHeadDO.Emsapop.OpLabItem.ToArray());

        }

        private void updApBtDataBing(CiEmsDTO dto,EmsUIDTO emsHeadDO)
        {
            FMap map = dto.Orapplysheet;
            CiorappbtAggDO aggdo = map[((int)EmsType.BT).ToString()] as CiorappbtAggDO;
            //主表
            OrdApBtDO bt = aggdo.getParentDO();
            bt.Id_apbt = emsHeadDO.Emsapbt.Id_emsbt;
            //bt.Id_orbt	       // 医嘱输血申请主键标识	  	 	 	 	 				 	 		 
            //bt.Id_or	           // 医嘱	REF	临床医嘱	id_or	
 			//诊断信息 	 			 	 	 		 
            bt.Id_di = emsHeadDO.Emsapbt.Id_di;         // 临床诊断	REF	医疗服务_疾病诊  	
            bt.Id_diitm = emsHeadDO.Emsapbt.Id_diitm;
            bt.Name_diag = emsHeadDO.Emsapbt.Name_diag;
            bt.Str_code_di = emsHeadDO.Emsapbt.Str_code_di;
            bt.Str_id_diitm = emsHeadDO.Emsapbt.Str_id_diitm;
            bt.Str_name_di = emsHeadDO.Emsapbt.Str_name_di;

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
            if (emsHeadDO.Emsapbt.Dt_bt != null)
                bt.Dt_bt_pl = ((DateTime)emsHeadDO.Emsapbt.Dt_bt).ToString("yyyy-MM-dd HH:mm:ss");
            //bt.Des_pps_bt	    //输血目的描述	SING  	 	 	 	 	 				 	 	 
            bt.Fg_db = emsHeadDO.Emsapbt.Fg_db;           //献血史标识	SINGLE	FBoo  	 	 	 				 	 			 
            bt.No_db = emsHeadDO.Emsapbt.No_db;            //献血证号	SINGLE	String	no_db  	 	 				 	 			 	 	 		 	 	 	 	 
            bt.Id_labitmexplain = emsHeadDO.Emsapbt.Id_labitmexplain;	//输血前监测项目说明	S  	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            bt.Sd_labitmexplain = emsHeadDO.Emsapbt.Sd_labitmexplain;	//输血前监测项目说明编  	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            bt.Id_demandsu_bt = emsHeadDO.Emsapbt.Id_demandsu;	//输血需求状态	SINGL 			 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            bt.Sd_demandsu_bt = emsHeadDO.Emsapbt.Sd_demandsu;	//输血需求状态编码	S  				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            bt.Id_mode_bt = emsHeadDO.Emsapbt.Id_mode;	//预定输血方式	SINGLE	S 	 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            bt.Sd_mode_bt = emsHeadDO.Emsapbt.Sd_mode;	//预定输血方式编码	SING  
            bt.Id_su_bt = CiDictCodeConst.ID_SU_BT_YSQ;
            bt.Sd_su_bt = CiDictCodeConst.SD_SU_BT_YSQ;
            bt.Fg_rpt = "N";
            bt.Num_margin_bu = emsHeadDO.Emsapbt.Quan_med;
            bt.Status = emsHeadDO.Emsapbt.Status;
            //是否加急标志：根据备血申请单的输血需求状态判断，“紧急”时加急状态为true
            if (bt.Sd_demandsu_bt == "0")
            {
                dto.Fg_urgent = true;
            }
            else
            {
                dto.Fg_urgent = false;
            }
            //动态指标
           OrdApBtViewItemDO[] doarr = aggdo.getOrdApBtViewItemDO();
            int i=0;
            //对照
            foreach (var elem in emsHeadDO.Emsapbt.BtLabItem)
            {
                OrdApBtViewItemDO itemdo=doarr[i];
                 itemdo.Status = emsHeadDO.Emsapbt.Status;
                 itemdo.Id_srv = elem.Id_srv;
                 itemdo.Id_unit = elem.Id_unit;
                 itemdo.Name_srv = elem.Name_srv;
                 itemdo.Name_unit = elem.Name_unit;
                 itemdo.Sd_restrptlabtp = elem.Sd_restrptlabtp;
                 itemdo.Val_restrptlab = elem.Val_restrptlab;
                 itemdo.Val_rstrptla = elem.Val_rstrptla;
                 itemdo.Id_apbtobsindex = elem.Id_apopobsindex;
                i++;
            }
        }


        #region 保存 公共的dto对照
        //保存公共信息
        /// <summary>
        /// 
        /// </summary>
        /// <param name="dto"></param>
        /// <param name="emsHeadDO"></param>
        public void SaveDtoCommonDataBing(CiEmsDTO dto, EmsUIDTO emsHeadDO)
        {
            //dto.Id_or	        
            //dto.Id_or = emsHeadDO.Id_or;
            dto.Eu_hpindicjudge = emsHeadDO.Eu_hpindicjudge;
            dto.Fg_cp = emsHeadDO.Fg_cp;
            dto.Id_pat = emsHeadDO.PatInfo.Id_pat;
            dto.Id_en = emsHeadDO.PatInfo.Id_ent;
            dto.Id_entp = emsHeadDO.PatInfo.Id_entp;
            dto.Code_entp = emsHeadDO.PatInfo.Code_entp;
            dto.Funcclassstr = emsHeadDO.Funcclassstr;
            dto.Id_srvof = emsHeadDO.Id_srvof;
            if (dto.Id_srvca == null)
            {
                dto.Id_srvca = emsHeadDO.MedSrvDO.Id_srvca;
            }
            if (dto.Innercode_srvca == null)
            {
                dto.Innercode_srvca = emsHeadDO.MedSrvDO.Srvca_innercode;
            }
            //dto.Id_srv_pkg	    
            dto.Emstype = (int)emsHeadDO.EmsType;
            //dto.Id_primd = emsHeadDO.MedSrvDO.Id_primd;
            dto.Id_dept_en = emsHeadDO.PatInfo.Id_dep_phy;
            dto.Id_dept_ns = emsHeadDO.PatInfo.Id_dep_nur;
            dto.Id_dep_phy = UserManager.getInstance().CurrentDept.Id_dep;

            //dto.Dt_begin = CommonExtentions.NowTime(this);
            //从EmsHeadDTO中获得
            //dto.Dt_begin = emsHeadDO.Dt_begin_ui;
            //dto.Dt_end = emsHeadDO.Dt_end_ui;
            //dto.Days_or = emsHeadDO.Days_or;
            //dto.Times_cur = emsHeadDO.Times_cur;
            //dto.Times_mp_in = emsHeadDO.Times_mp_in;

            if (emsHeadDO.Status == DOStatus.NEW)
            {
                dto.Code = emsHeadDO.MedSrvDO.Code;
                dto.Name = emsHeadDO.MedSrvDO.Name;
                dto.Id_srvtp = emsHeadDO.MedSrvDO.Id_srvtp;
                dto.Sd_srvtp = emsHeadDO.MedSrvDO.Sd_srvtp;
                dto.Id_srvca = emsHeadDO.MedSrvDO.Id_srvca;
                dto.Id_freq = emsHeadDO.MedSrvDO.Id_freq;
                dto.Id_srv = emsHeadDO.MedSrvDO.Id_srv;
                dto.Fg_set = emsHeadDO.MedSrvDO.Fg_set;
                //dto.Dt_begin = cof.GetSystemDateTime();
               
                // 天数有问题， 王琪在修改医疗单
                //if (emsHeadDO.Emsdrugs.Use_days != null && emsHeadDO.Emsdrugs.Use_days == 0)
                //{
                //    dto.Dt_end = DateTime.Parse(dto.Dt_begin.Value.ToString("yyyy-MM-dd 23:59:59"));
                //}
                //else
                //{
                //    dto.Dt_end = null;
                //}

                dto.Sd_su_or = CiDictCodeConst.SD_SU_OPEN;
                dto.Id_su_or = CiDictCodeConst.SD_SU_ID_OPEN;
                //dto.Id_emp_phy = UserManager.getInstance().CurrentUser.Id_psn;
                ////dto.Id_emp_phy = UserManager.getInstance().CurrentPsnInfo.Id_psndoc;
                //dto.Id_dep_phy = UserManager.getInstance().CurrentDept.Id_dep;
                //dto.Id_wg_or = UserManager.getInstance().CurrentGroup.Id_grp;
            }
        }
        #endregion 保存 公共的dto对照

        #region 保存 公共的Srv对照


        public void SaveCommonSrvDataBing(CiEmsSrvDTO srv, EmsUIDTO emsHeadDO, int Eu_sourcemd)
        {

           
            if (emsHeadDO.Status == DOStatus.NEW)
            {
                srv.Name_srv = emsHeadDO.MedSrvDO.Name;
                srv.Code_srv = emsHeadDO.MedSrvDO.Code;
                srv.Id_srv = emsHeadDO.MedSrvDO.Id_srv;
                srv.Id_srvca = emsHeadDO.MedSrvDO.Id_srvca;
                srv.Id_srvtp = emsHeadDO.MedSrvDO.Id_srvtp;
                srv.Sd_srvtp = emsHeadDO.MedSrvDO.Sd_srvtp;
                srv.Eu_blmd = emsHeadDO.MedSrvDO.Eu_blmd;
                srv.Dt_create_srv = CommonExtentions.NowTime(this); //开立时间	      SINGL 
                //srv.Id_org_srv = UserManager.getInstance().CurrentGroup.Id_grp;	      //开立机构	SINGL 
                //srv.Id_dep_srv = UserManager.getInstance().CurrentDept.Id_dep;      //开立科室	SINGL 
                //srv.Id_ward_srv = UserManager.getInstance().CurrentDept.Id_dep;      //开立病区	SINGL 
                //srv.Id_emp_srv = UserManager.getInstance().CurrentUser.Id_psn;	      //开立人员	SINGL 

                srv.Eu_sourcemd = Eu_sourcemd;
                srv.Fg_bl = emsHeadDO.MedSrvDO.Fg_bl;
            }
        }
        #endregion  保存 公共的Srv对照

        #region 保存 药品医疗单

        /// <summary>
        /// Saves the 药品医疗单
        /// </summary>
        /// <param name="dto">The dto.</param>
        /// <param name="emsHeadDO">The ems head do.</param>
        /// Author:admin
        /// Date:2015-12-03
        public void SaveApDrug(CiEmsDTO dto, EmsUIDTO emsHeadDO)
        {
            dto.Fg_long = emsHeadDO.Emsdrugs.Fg_long; //长临标识	 	 				 	 	 	 	 	 				 	 			 	 	 			 	 	 	 	 	 				 	 			 	 	 	
            dto.Id_freq = emsHeadDO.Emsdrugs.Id_freq;	        //医嘱频次	REF	医嘱频次定义	 	 	
            dto.Name_freq = emsHeadDO.Emsdrugs.Name_freq;    //医嘱频次名称	SINGLE	String	 	
            dto.Sd_frequnitct = emsHeadDO.Emsdrugs.Sd_frequnitct;
            dto.Freqct = emsHeadDO.Emsdrugs.Freqct;
            dto.Frequnitct = emsHeadDO.Emsdrugs.Freqct;// @Err
            dto.Id_route = emsHeadDO.Emsdrugs.Id_route;	    //用法	REF	医疗服务_医疗用法	 	 	
            dto.Name_route = emsHeadDO.Emsdrugs.Name_route;	    //用法名称	SINGLE	String	 	
            dto.Id_routedes = emsHeadDO.Emsdrugs.Id_routedes;	    //用法要求	REF	医疗用法要求	 	 	 	
            dto.Name_routedes = emsHeadDO.Emsdrugs.Name_routedes;	//用法要求描述	SINGLE	String	 	
            dto.Id_boil = emsHeadDO.Emsdrugs.Id_boil;	        // 煎法	REF	医疗服务中药煎法	 	 	 	 	
            dto.Name_boil = emsHeadDO.Emsdrugs.Name_boil;	    //煎法名称	SINGLE	String	 	
            dto.Id_boildes = emsHeadDO.Emsdrugs.Id_boildes;	    //煎法要求	REF	中药煎法要求	 	 	 	
            dto.Name_boildes = emsHeadDO.Emsdrugs.Name_boildes;	//煎法要求名称	SINGLE	String	 	
            //dto.Fg_boil	=          //代煎标识	SINGLE	FBoolean 	 	
            //dto.Days_or = emsHeadDO.Emsdrugs.Use_days;        //医嘱天数	SINGLE	Integer	 	
            dto.Dt_begin = emsHeadDO.Emsdrugs.Dt_begin_ui;
            dto.Dt_end = emsHeadDO.Emsdrugs.Dt_end_ui;
            dto.Days_or = emsHeadDO.Emsdrugs.Use_days;
            dto.Quan_medu = emsHeadDO.Emsdrugs.Quan_med;
            dto.Name_unit_med = emsHeadDO.Emsdrugs.Name_unit_med;
            dto.Times_cur = emsHeadDO.Emsdrugs.Times_cur;
            dto.Fg_mp_in = emsHeadDO.Emsdrugs.Fg_mp_in;	            //在院执行标识	SINGLE	 	 	 	 	
            dto.Times_mp_in = emsHeadDO.Emsdrugs.Times_mp_in;      //在院执行次数
            dto.Orders = emsHeadDO.Emsdrugs.Orders;	        //医嘱付数	SINGLE	Integer	 	
            dto.Orders_boil = emsHeadDO.Emsdrugs.Orders_boil;	    //代煎付数	SINGLE	Integer	 	
            if (emsHeadDO.Emsdrugs.Orders_boil != null && emsHeadDO.Emsdrugs.Orders_boil > 0)
            {
                dto.Fg_boil = true;
                dto.Name_dep_mp = "";
            }
            else {
                dto.Fg_boil = false;
            }
            //dto.Content=	        //医嘱内容	SINGLE	备注	4000 	
            //dto.Note	        //备注	SINGLE	备注	1000	 
            dto.Id_emp_phy = UserManager.getInstance().CurrentUser.Id_psn;	    //开立医生	REF	人员基本信息	 	
            //dto.Name_emp_phy	//开立医生姓名	SINGLE	String	 	
            dto.Id_dep_phy = UserManager.getInstance().CurrentDept.Id_dep;	    //开立科室	REF	部门	20	 	 
            //dto.Name_dep_phy	//开立科室名称	SINGLE	String	 	
            dto.Id_wg_or = UserManager.getInstance().CurrentUser.Id_group;	    //医疗组	REF	业务组	20	业务 
            //dto.Dt_begin = emsHeadDO.Emsdrugs.Dt_begin_ui;	    //开始日期	SINGLE	FDateTim 	 	
            //dto.Dt_end = emsHeadDO.Emsdrugs.Dt_end_ui;	        //结束日期	SINGLE	FDateTim 	 	
            dto.Dt_invalid = emsHeadDO.Emsdrugs.Dt_fail;    //医嘱过期时间	SINGLE	FDateTim
            dto.Note = emsHeadDO.Emsdrugs.Note_or;
            //dto.Fg_bb	        //婴儿标识	SINGLE	FBoolean 	 	
            //dto.No_bb	        //婴儿序号	SINGLE	Integer	 	
            dto.Fg_pmor = emsHeadDO.Emsdrugs.Fg_pmor;        //备用医嘱标识	SINGLE	FBoolean 	 	
            dto.Des_pmor = emsHeadDO.Emsdrugs.Bak_des;	    //备用医嘱使用条件描述	SINGLE	 	 	
            //dto.Fg_active_pm= //备用医嘱启用标识	SINGLE	FBoo 	 	 	
            //dto.Id_reltp	    //关联医嘱类型编码	SINGLE	Stri 	 	
            //dto.Sd_reltp	    //关联医嘱类型	SINGLE	String	 	
            //dto.Id_or_rel	    //关联医嘱	SINGLE	String	 	
            //dto.Fg_ctlcp	    //临床路径控制标识	SINGLE	FBoo 	 	 	
            //dto.Fg_mr	        //医疗记录联动标识	SINGLE	FBoo 	 	 	
            //dto.Fg_skintest = emsHeadDO.Emsdrugs.Fg_skintest;	    //需皮试标识	SINGLE	FBoolean 	 	
            //dto.Id_skintest_skip_reaso	//不皮试原因	SINGLE	 	 	 	
            //dto.Sd_skintest_skip_reaso	//不皮试原因编码	SING 	 
            //dto.Times_cur = LogicEx.GetInstance().GetDrugUseTotalCount(emsHeadDO);
            
            //dto.Times_mp_in	            //在院执行次数	SINGLE	 	 	 	
            //dto.Fg_mp_bed=emsHeadDO.Emsdrugs	            //床边执行标识	SINGLE	
            dto.Innercode_srvca = emsHeadDO.MedSrvDO.Srvca_innercode;//服务分类内部编码
            dto.Times_firday_mp = emsHeadDO.Emsdrugs.Quan_firday_mp;        //首日执行次数	SINGLE	 	 	 	
            dto.Fg_or_doc = true;	            //医生医嘱标识	SINGLE	
            dto.Id_dep_mp = emsHeadDO.Emsdrugs.Id_dep;//医嘱层面的执行科室 2016-08-03 zwq
            
            EmsOrDrug ems = emsHeadDO.Emsdrugs.EmsOrDrugList.FirstOrDefault(p=>!p.IsDELETED); 
            if (ems != null)
            {
                dto.Id_srv = ems.Id_srv;   //zwq 2016-07-15 药品医疗单的id_srv取服务项目的第一个 
                dto.Name = ems.Name_srv;
            }
        }


        #region 保存时 药品信息Srv对照
        /// <summary>
        ///医嘱药品表单上的 服务关联药品项目
        /// </summary>
        /// <param name="emsHeadDO">The ems head do.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-12-02
        public FArrayList SaveOrDrugEmsItemToDto(EmsUIDTO emsHeadDO,bool? fg_out, List<CiEmsSrvDTO> flist, int Eu_sourcemd)
        {

            FArrayList list = new FArrayList();
            foreach (EmsOrDrug p in emsHeadDO.Emsdrugs.EmsOrDrugList)
            {
                CiEmsSrvDTO srvdto = new CiEmsSrvDTO();
                srvdto.Eu_sourcemd = Eu_sourcemd; //医疗单项目数据来源 
               // srvdto.Eu_sourcemd = 0;	     
                CiEmsSrvDTO srv = flist.FirstOrDefault(x => x.Id_srv == p.Id_srv && x.Id_orsrv==p.Id_orsrv);
                
                if (srv != null)
                {
                    srvdto = srv;
                    if (p.IsDELETED)
                    {
                        srvdto.SetDeleted();
                    }
                    else {
                        srvdto.SetUpdated();
                    }
                }
                else {// 增加该逻辑分支   针对 已保存的 医嘱项目 进行服务项目的修改 -- 2016-11-21 by wangqz
                    if (!string.IsNullOrEmpty(p.Id_orsrv)){
                        srvdto.Status = DOStatus.UPDATED;
                    }
                    if (p.IsDELETED)
                    {
                        srvdto.SetDeleted();
                    }
                }
                srvdto.BdHpIndication = p.BdHpIndication;
                srvdto.Indicitemid = p.Indicitemid;//医保多报销比例id
                srvdto.Id_orsrv = p.Id_orsrv;       //医疗单项目主键标识 
                //srvdto.Id_or	=                   //医疗单	SINGLE	F 
                srvdto.Sortno = p.Sortno;	         //序号	SINGLE	I 
                srvdto.Id_srv = p.Id_srv;	         //医疗服务	REF	 
               

                srvdto.Id_unit_med = p.Id_unit_med;	     //医疗单位	REF	 
                srvdto.Name_unit_med = p.Name_unit_med;  //医疗单位编码	SINGL 
                srvdto.Quan_med = p.Quan_med;	     //剂量	SINGLE	F 
                srvdto.Id_primd = p.Id_pri;
                srvdto.Price = p.Price;        //参考价格	SINGL 
                srvdto.Id_freq = emsHeadDO.Emsdrugs.Id_freq;	         //医嘱频次	REF
                srvdto.Freqct = emsHeadDO.Emsdrugs.Freqct;//zwq 2016-09-06
                srvdto.Sd_frequnitct = emsHeadDO.Emsdrugs.Sd_frequnitct;//zwq 2016-09-06
                srvdto.Name_freq = p.Name_freq;	     //医嘱频次名称	SINGL 
                srvdto.Id_route = emsHeadDO.Emsdrugs.Id_route;	      //用法标识	REF	  	
                srvdto.Name_route = emsHeadDO.Emsdrugs.Name_route;	      //用法	SINGLE	S 
                srvdto.Id_routedes = emsHeadDO.Emsdrugs.Id_routedes;	      //用法要求标识	REF	  	 
                srvdto.Name_routedes = emsHeadDO.Emsdrugs.Name_routedes;	  //用法要求	SINGL 
                srvdto.Id_boil = emsHeadDO.Emsdrugs.Id_boil;	          //煎法标识	REF	  	 	 	
                srvdto.Name_boil = emsHeadDO.Emsdrugs.Name_boil;	      //煎法	SINGLE	S 
                srvdto.Id_boildes = p.Id_boildes;	      //煎法要求标识	REF	  	
                srvdto.Name_boildes = p.Name_boildes;	  //煎法要求	SINGL 
                srvdto.Fg_dose_anoma = emsHeadDO.Emsdrugs.Fg_dose_anoma;	  //变动用药标识	SINGL  	
                //srvdto.//Des_srv	          //备注	SINGLE	 

                srvdto.Fg_outp = fg_out;	          //出院带药标识	SINGL  	zwq 2016-08-11
                srvdto.Fg_bl = p.Fg_bl; // 
                //srvdto.//Id_org_srv	      //开立机构	SINGL 
                //srvdto.//Id_dep_srv	      //开立科室	SINGL 
                //srvdto.//Id_ward_srv	      //开立病区	SINGL 
                //srvdto.//Id_emp_srv	      //开立人员	SINGL 
                srvdto.Dt_create_srv = CommonExtentions.NowTime(this); //开立时间	SINGL 
                //srvdto.//Dt_last_bl	      //最近生成日期	SINGL 
                //srvdto.Eu_blmd	          //划价方式	SINGL 
                //srvdto.Id_orsrvmm = p.Id_emsordrug;	      //服务项目物品	SINGL  	 	
                srvdto.Id_mm = p.Id_mm;	          //物品	SINGLE	 
                srvdto.Code_mm = p.Code_mm;	          //物品编码	SINGL 
                srvdto.Name_mm = p.Name_mm;	          //物品名称	SINGL 
                //srvdto.Spec_mm	          //规格	SINGLE	S 
                srvdto.Id_unit_sale = p.Id_unit_sale;	  //零售单位	REF	 
                srvdto.Name_unit_sale = p.Name_unit_sale;	  //零售单位名称	SINGL 
                srvdto.Id_unit_base = p.Id_unit_base;	  //基本单位	REF	 
                srvdto.Name_unit_base = p.Name_unit_base;	  //基本单位名称	SINGL 
                //srvdto.Quan_num_base = p.Quan_base;	  //单次数量_分子	S  	 	 	
                srvdto.Quan_den_base = 1;	  //单次数量_分母	S 
                srvdto.Price_cur = p.Price;	      //参考价当前	SINGL 
                srvdto.Quan_cur = p.Quan_cur;	      //总量_当前	SINGL 
                srvdto.Quan_base = p.Quan_base;      //总量_基本	SINGL 
                srvdto.Quan_total_medu = srvdto.Quan_cur;
                srvdto.Quan_bed_medu = 0;	  //床边量_医学	SINGL 
                if (p.Fg_ctm != null && p.Fg_ctm == true) // 处理药品自定义服务总量
                {
                    srvdto.Quan_total_medu = p.Quan_cur;
                }
                //srvdto.Factor_cb = p.Factor_cb;	      //当前基本换算系数	S  
                //srvdto.Factor_cb = LogicEx.GetInstance().getDrugFactor(p.Id_mm,p.Id_unit_sale);
                srvdto.Factor_cb = p.Factor_cb;
                srvdto.Factor_mb = (p.Factor_mb == null || p.Factor_mb == 0) ? 1 : p.Factor_mb;	      //医疗基本换算系数	S  	 	
                srvdto.Id_dosage = p.Id_dosage;	      //药品剂型	SINGL 
                srvdto.Sd_dosage = p.Sd_dosage;	      //药品剂型编码	SINGL 
                srvdto.Id_pharm = p.Id_pharm;	      //药理分类	SINGL 
                srvdto.Sd_pharm = p.Sd_pharm;	      //药理分类编码	SINGL 
                srvdto.Id_pois = p.Id_pois;	          //毒麻分类	SINGL 
                srvdto.Sd_pois = p.Sd_pois;	          //毒麻分类编码	SINGL 
                srvdto.Id_anti = p.Id_anti;	          //抗菌药分类	SINGL 
                srvdto.Sd_anti = p.Sd_anti;	          //抗菌药分类编码	S 
                srvdto.Id_mmtp = p.Id_mmtp;	          //物品类型	SINGL 
                srvdto.Sd_mmtp = p.Sd_mmtp;	          //物品类型编码	SINGL 
                srvdto.Id_val = p.Id_val;	          //价值分类	SINGL 
                srvdto.Sd_val = p.Sd_val;	          //价值分类编码	SINGL 
                srvdto.Id_mupkgutp = p.Id_mupkgutp;// 住院取证模式
                srvdto.Sd_mupkgutp = p.Sd_mupkgutp;// 住院取整模式
                srvdto.Id_opmutp = p.Id_opmutp;// 门诊取整模式
                srvdto.Sd_opmutp = p.Sd_opmutp;// 门诊取整模式
                srvdto.Fg_self = p.Fg_self;//自备药标识	SINGL  	
                srvdto.Fg_propc = p.Fg_propc;//预防用药标识	SINGL
                srvdto.Fg_indic = p.Fg_treat;//治疗用药标识	SINGL  	
                srvdto.Id_dep = p.Id_mp_dep;//执行科室	REF	 
                srvdto.Name_dep = p.Name_mp_dep;//执行科室	REF	 
                srvdto.Des_srv = p.Note_or;
                //皮试内容
                srvdto.Fg_skintest = p.Fg_skintest;
                srvdto.Id_skintest_skip_reason = p.Id_skintest_skip_reason;
                srvdto.Sd_reltp = p.Sd_reltp;
                srvdto.Id_or_rel = p.Id_or_rel;
                srvdto.Fg_mm = p.Fg_mm;
                srvdto.Fg_selfsrv = p.Fg_ctm;
                srvdto.Fg_selfpay = p.Fg_selfpay; // 自费标志
                srvdto.Name_srv = p.Name_srv;
                srvdto.Id_dep_wh = p.Id_dep_wh;//库房id 2016-08-03 zwq
                srvdto.Fg_extdispense = p.Fg_extdispense;//外配药标识
                if (srvdto.IsNEW)
                {
                    IMedsrvMDOCrudService medService = XapServiceMgr.find<IMedsrvMDOCrudService>();
                    MedSrvDO medSrvDO = medService.findById(p.Id_srv);
                    srvdto.Id_srvtp = medSrvDO.Id_srvtp;	     //服务类型	REF	 		 	 	 
                    srvdto.Sd_srvtp = medSrvDO.Sd_srvtp;     //服务类型编码	SINGL 
                    srvdto.Code_srv = medSrvDO.Code;	     //医疗服务编码	SINGL 
                    srvdto.Name_srv = p.Name_srv;	     //医疗服务名称	SINGL 
                    srvdto.Id_srvca = medSrvDO.Id_srvca;	     //服务项目基本分类	S 
                    srvdto.Fg_mm = medSrvDO.Fg_mm;	          //物品标识	SINGL 
                    srvdto.Fg_set = medSrvDO.Fg_set;	          //服务套标识	SINGL  	
                    srvdto.Fg_or = medSrvDO.Fg_or;	          //医嘱标识	SINGL 
                    srvdto.Innercode_srvca = medSrvDO.Srvca_innercode;//服务分类内部编码
                    //srvdto.Fg_bl	          //费用标识	SINGL 
                    //srvdto.Id_srv_set	     //所属服务套	SINGL 


                    srvdto.Id_hp = p.Id_hp;//医保计划id zwq 2016-07-12
                    srvdto.Id_hpsrvtp = p.Id_hpsrvtp;//医保目录类型 zwq 2016-07-12
                    srvdto.Sd_hpsrvtp = p.Sd_hpsrvtp;//医保目录类型编码 zwq 2016-07-12
                    //srvdto.Eu_hpdoctorjudge = p.Eu_hpdoctorjudge;//医生是否已判断医保标志
                    srvdto.Limit = p.Limit;
                    srvdto.Eu_blmd = medSrvDO.Eu_blmd;
                    srvdto.Emsagentinfo = p.Agentinfolist;//毒麻药品时核对的患者信息
                    SaveDoseDrug(emsHeadDO,srvdto);
                }
                else if (srv == null && !string.IsNullOrEmpty(p.Id_orsrv) && srvdto.IsUPDATED) {// 增加该逻辑分支   针对 已保存的 医嘱项目 进行服务项目的修改 -- 2016-11-21 by wangqz
                    if (!p.IsDELETED) {
                        IMedsrvMDOCrudService medService = XapServiceMgr.find<IMedsrvMDOCrudService>();
                        MedSrvDO medSrvDO = medService.findById(p.Id_srv);
                        srvdto.Id_srvtp = medSrvDO.Id_srvtp;	     //服务类型	REF	 		 	 	 
                        srvdto.Sd_srvtp = medSrvDO.Sd_srvtp;     //服务类型编码	SINGL 
                        srvdto.Code_srv = medSrvDO.Code;	     //医疗服务编码	SINGL 
                        srvdto.Name_srv = p.Name_srv;	     //医疗服务名称	SINGL 
                        srvdto.Id_srvca = medSrvDO.Id_srvca;	     //服务项目基本分类	S 
                        srvdto.Fg_mm = medSrvDO.Fg_mm;	          //物品标识	SINGL 
                        srvdto.Fg_set = medSrvDO.Fg_set;	          //服务套标识	SINGL  	
                        srvdto.Fg_or = medSrvDO.Fg_or;	          //医嘱标识	SINGL 
                        srvdto.Innercode_srvca = medSrvDO.Srvca_innercode;//服务分类内部编码
                        //srvdto.Fg_bl	          //费用标识	SINGL 
                        //srvdto.Id_srv_set	     //所属服务套	SINGL 


                        srvdto.Id_hp = p.Id_hp;//医保计划id zwq 2016-07-12
                        srvdto.Id_hpsrvtp = p.Id_hpsrvtp;//医保目录类型 zwq 2016-07-12
                        srvdto.Sd_hpsrvtp = p.Sd_hpsrvtp;//医保目录类型编码 zwq 2016-07-12
                        
                        srvdto.Eu_blmd = medSrvDO.Eu_blmd;
                        srvdto.Emsagentinfo = p.Agentinfolist;//毒麻药品时核对的患者信息
                        SaveDoseDrug(emsHeadDO, srvdto);   
                    }
                }
                srvdto.Fg_hpindicjudged = p.Fg_hpindicjudged;
               //srvdto.Fg_hpindicjudged = judgeHpindicjudg(p);
                srvdto.Days_available = CalQuantumUtil.GetInstance().getDaysAvalidate(p.Sd_opmutp, p.Quan_cur, p.Quan_med, p.Factor_cb, p.Factor_mb, p.Id_freq);
               
                list.Add(srvdto);

            };
            //药品医疗单删除的条目
                XapDataList<EmsOrDrug> delItems = emsHeadDO.Emsdrugs.EmsOrDeleteDrugList;
            if (delItems != null)
                foreach (EmsOrDrug ems in delItems)
                {
                    CiEmsSrvDTO ciEmsSrvDTO = flist.FirstOrDefault<CiEmsSrvDTO>(e => e.Id_orsrv == ems.Id_orsrv);//2016-07-06zwq 因为自定义服务存在，修改取对象条件：e.Id_srv==ems.Id_srv --> e.Id_orsrv==ems.Id_orsrv。
                    if (ciEmsSrvDTO != null)
                    {
                        ciEmsSrvDTO.Status = DOStatus.DELETED;
                        list.Add(ciEmsSrvDTO);
                    }
                        
                }

            return list;
        }
        #endregion 保存时 药品信息Srv对照
        private void SaveDoseDrug(EmsUIDTO emsHeadDO, CiEmsSrvDTO srvdto)
        {
            List<OrdSrvDoseDO> doseList = new List<OrdSrvDoseDO>();
            if (srvdto.Emsfreqdose != null)
            {
                foreach (OrdSrvDoseDO item in srvdto.Emsfreqdose)
                {
                    doseList.Add(item);
                }
            }
          

            FArrayList list = new FArrayList();
            //（目前只有通用药 有变动用药 正好通用药品 只有一条 ，只会有一条服务 那就用0条服务id了）
            //--------------------变动用药 save start--------------------------------------------------
            if (emsHeadDO.Emsdrugs.Fg_dose_anoma != null && emsHeadDO.Emsdrugs.Fg_dose_anoma.Value)
            {

                emsHeadDO.Emsdrugs.EmsOrDoseDrug.ToList().ForEach(p =>
                {
                    OrdSrvDoseDO dose = new OrdSrvDoseDO();
                    OrdSrvDoseDO doseTemp = doseList.FirstOrDefault(x => x.Id_orsrvdose == p.Id_emsordrug);
                    if (doseTemp != null)
                    {
                        dose = doseTemp;
                        dose.SetUpdated();
                    }

                    //Status=status,//状态不用修改，每次都是新增，在修改时候 每次都是删除后 再新增的
                    dose.Id_orsrvdose = p.Id_emsordrug;//主键
                    //Id_orsrv = id_orsrv,
                    //Id_or = id_or,
                    dose.Id_freqtime = p.Name_freqtime;//执行时刻
                    //Dt_freq,//日期
                    dose.No_mp = emsHeadDO.Emsdrugs.EmsOrDoseDrug.IndexOf(p) + 1;//排序
                    dose.Quan_dose = p.Quan_med;//剂量
                    dose.Id_unit_dose = srvdto.Id_unit_med;
                    if (dose.IsNEW)
                    {
                        dose.Createdby = UserManager.getInstance().CurrentUser.Id_psn;
                        dose.Createdtime = UserManager.getInstance().CurrentUser.Createdtime;
                        list.Add(dose);
                    }
                    dose.Modifiedby = UserManager.getInstance().CurrentUser.Id_psn;
                    dose.Modifiedtime = UserManager.getInstance().CurrentUser.Createdtime;
                    //Ds,
                    //dose.Sv = p.Sv

                    
                });
            }
            if (list.Count > 0)
            {
                srvdto.Emsfreqdose = list;
            }

        }

        #endregion 保存 药品医疗单

        #region 保存时 通用医疗单srv补充字段

        public void SaveApCommonSrv(CiEmsSrvDTO srv, EmsUIDTO emsHeadDO)
        {
            srv.Id_dep = emsHeadDO.Emsdrugs.Id_dep;
            srv.Id_freq = emsHeadDO.Emsdrugs.Id_freq;
            srv.Id_route = emsHeadDO.Emsdrugs.Id_route;
            srv.Id_routedes = emsHeadDO.Emsdrugs.Id_routedes;
            srv.Name_srv = emsHeadDO.Emsdrugs.Name_srv;
            srv.Id_unit_med = emsHeadDO.Emsdrugs.Id_unit_med;
            srv.Fg_set = emsHeadDO.MedSrvDO.Fg_set;
            srv.Quan_cur = emsHeadDO.Emsdrugs.Quan_cur;
            srv.Name_unit_med = emsHeadDO.Emsdrugs.Name_unit_med;
            srv.Id_srv = emsHeadDO.Emsdrugs.Id_srv;
            srv.Sd_srvtp = emsHeadDO.Emsdrugs.Sd_srvtp;
            srv.Quan_total_medu = (srv.Fg_outp != null && srv.Fg_outp.Value? emsHeadDO.Emsdrugs.Quan_cur:null);
            srv.Quan_med = emsHeadDO.Emsdrugs.Quan_med;
            srv.Fg_selfpay = emsHeadDO.Emsdrugs.Fg_selfpay;
            if (emsHeadDO.Emsdrugs.Fg_selfpay != null && emsHeadDO.Emsdrugs.Fg_selfpay.Value)
            {
                srv.Fg_hpindicjudged = (int)HpIndicJudgeEnum.SELFPAY;
            }
            else
            {
                srv.Fg_hpindicjudged = null;
            }
            if (srv.Quan_med == null)
            {
                srv.Quan_med = emsHeadDO.MedSrvDO.Quan_med;
            }
            srv.Quan_total_medu = srv.Quan_cur;//TODO
        }

        #endregion

        #region 保存时 出院ci_ap_out数据绑定
        public OrdApOutDO SaveApOutDataBing(EmsUIDTO emsHeadDO, CiEmsDTO dto)
        {
            OrdApOutDO apout = new OrdApOutDO();
            if (dto.Orapplysheet != null && dto.Orapplysheet.Keys.Count > 0)
            {
                OrdApOutDO aptem = dto.Orapplysheet[((int)EmsType.OUTHOSP).ToString()] as OrdApOutDO;
                if (aptem != null)
                {
                    apout = aptem;
                    apout.SetUpdated();
                }

            }
            dto.Innercode_srvca = emsHeadDO.MedSrvDO.Srvca_innercode;//服务分类内部编码
            dto.Dt_begin = emsHeadDO.Emsapout.Dt_out;
            dto.Dt_end = emsHeadDO.Emsapout.Dt_end_ui;
            dto.Days_or = emsHeadDO.Emsapout.Use_days;
            dto.Times_cur = emsHeadDO.Emsapout.Times_cur;          //在院执行标识	SINGLE	 	 	 	 	
            dto.Times_mp_in = emsHeadDO.Emsapout.Times_mp_in;      //在院执行次数
            //dto.Dt_begin = emsHeadDO.Emsapout.Dt_out;
            apout.Id_orout = emsHeadDO.Emsapout.Id_emsapout;    //医嘱出院属性主键标识	SINGLE	 
            //apout.Id_or = emsHeadDO.Emsapout.Id_or;	        //医嘱	REF	临床医嘱	id_or	
            apout.Id_dep_out = emsHeadDO.Emsapout.Id_dep_out;	    //出院科室	REF	部门	id_dep_o 
            apout.Id_dep_nur_out = emsHeadDO.Emsapout.Id_dep_nur_out;	//出院病区	REF	部门	id_dep_n 
            apout.Id_bed_out = emsHeadDO.Emsapout.Id_bed_out;	    //出院床位	REF	床位	id_bed_o 
            apout.Fg_again31 = emsHeadDO.Emsapout.Fg_again31;	    //31日内再次计划住院标识	SING 
            apout.Des_again31 = emsHeadDO.Emsapout.Des_again31;	    //31日内再入院目的	SINGLE	备注	 
            apout.Id_outtp = emsHeadDO.Emsapout.Id_outtp;	    //离院方式id	REF	离院方式_自定义 
            apout.Sd_outtp = emsHeadDO.Emsapout.Sd_outtp;	    //离院方式编码	SINGLE	String	 
            apout.Des_outtp = emsHeadDO.Emsapout.Des_outtp;	    //离院描述	SINGLE	String
            apout.Fg_death = emsHeadDO.Emsapout.Fg_death;
            apout.Fg_autopsy = emsHeadDO.Emsapout.Fg_autopsy;
            apout.Dt_timeout = emsHeadDO.Emsapout.Dt_out;

            //apout.Sv = emsHeadDO.Emsapout.Sv;

            if (apout.IsNEW)
            {
                dto.Orapplysheet.Add(((int)EmsType.OUTHOSP).ToString(), apout);
            }
            return apout;
        }
        #endregion 保存时 出院ci_ap_out数据绑定

        #region 保存时 转科ci_ap_trans数据绑定
        public OrdApTransDO SaveApTransDataBing(EmsUIDTO emsHeadDO, CiEmsDTO dto)
        {
            OrdApTransDO trans = new OrdApTransDO();
            if (dto.Orapplysheet != null && dto.Orapplysheet.Keys.Count > 0)
            {
                OrdApTransDO aptem = dto.Orapplysheet[((int)EmsType.TRANSDEPT).ToString()] as OrdApTransDO;
                if (aptem != null)
                {
                    trans = aptem;
                    trans.SetUpdated();
                }
            }
            dto.Innercode_srvca = emsHeadDO.MedSrvDO.Srvca_innercode;//服务分类内部编码
            dto.Id_dep_mp = emsHeadDO.Emsaptrans.Id_dep_nur_to;//执行科室为 目标病区
            dto.Dt_begin = emsHeadDO.Emsaptrans.Dt_effe;
            dto.Dt_end = emsHeadDO.Emsaptrans.Dt_end_ui;
            dto.Days_or = emsHeadDO.Emsaptrans.Use_days;
            dto.Times_cur = emsHeadDO.Emsaptrans.Times_cur;          //在院执行标识	SINGLE	 	 	 	 	
            dto.Times_mp_in = emsHeadDO.Emsaptrans.Times_mp_in;      //在院执行次数
            //trans.Id_ortrans	    //医嘱转科属性主键标识	SINGLE	FID	id_ortrans	char	20	 	 	 				 	 	 	 	 	 				
            //trans. Id_or	        //医嘱	REF	临床医嘱	id_or	varchar	20	 	 	 				 	 	 	 	 	 				 	 			
            trans.Id_dep_to = emsHeadDO.Emsaptrans.Id_dep_to;	    //目标科室	REF	部门	id_dep_to	varchar	20	 	 	 				 	 	 	 	
            trans.Id_dep_nur_to = emsHeadDO.Emsaptrans.Id_dep_nur_to;	//目标病区	REF	部门	id_dep_nur_to	varchar	20	 	 	 				 	 	
            trans.Name_dep_nur_to = emsHeadDO.Emsaptrans.Name_dep_nur_to;
            trans.Name_dep_to = emsHeadDO.Emsaptrans.Name_dep_to;
            trans.Id_dep_from = emsHeadDO.Emsaptrans.Id_dep_from;   //原科室	REF	部门	id_dep_from	varchar	20	 	 	 				 	 	 	 	 	 				 	 		
            trans.Id_dep_nur_from = emsHeadDO.Emsaptrans.Id_dep_nur_from;	//原病区	REF	部门	id_dep_nur_from	varchar	20
            trans.Name_dep_nur_to = emsHeadDO.Emsaptrans.Name_dep_nur_to;
            //else
            //{
            //    trans.Id_su_trans = emsHeadDO.Emsaptrans.Id_su_trans;
            //    trans.Sd_su_trans = emsHeadDO.Emsaptrans.Sd_su_trans;
            //    trans.Dt_trans_apply = emsHeadDO.Emsaptrans.Dt_trans_apply;
            //}
            trans.Des_rea_canc = emsHeadDO.Emsaptrans.Des_rea_canc;	    //转科申请原因	SINGLE	备注	des_rea_canc	varchar	300	 	 	 				
            trans.Fg_tech_trans = false;	//转医技科室	SINGLE	String
            trans.Dt_end = emsHeadDO.Emsaptrans.Dt_end;//跨科失效时间
            if (trans.IsNEW)
            {
                dto.Id_freq = emsHeadDO.MedSrvDO.Id_freq;
                dto.Sd_frequnitct = emsHeadDO.MedSrvDO.Sd_frequnitct;
                dto.Fg_long = emsHeadDO.MedSrvDO.Fg_long;
                trans.Id_su_trans = CiDictCodeConst.ID_TRANSE_STATUS_OPEN;	    //转科过程状态	REF	转科过程状态_自定义档案	id_su_trans	varchar	20	转科过程状态_自定义档案	 	
                trans.Sd_su_trans = CiDictCodeConst.SD_TRANSE_STATUS_OPEN;	    //转科过程状态编码	SINGLE	String	sd_su_trans	varchar	50	 	 	 				 	 	 	 	 	 			
                trans.Dt_trans_apply = CommonExtentions.NowTime(this);	//转科申请时间	SINGLE	FDateTime	dt_trans_apply	char	19
                trans.Fg_crossdept = emsHeadDO.Emsaptrans.Fg_tech_trans;//跨科标志
                if (trans.Fg_crossdept != null && trans.Fg_crossdept == true)
                    //trans.Dt_effe = CommonExtentions.NowTime(this);//跨科生效时间
                    trans.Dt_effe = emsHeadDO.Emsaptrans.Dt_effe;
                dto.Orapplysheet.Add(((int)EmsType.TRANSDEPT).ToString(), trans);//新增时候把医疗单放到 sheet
            }
            return trans;
        }


        #endregion 保存时 转科ci_ap_trans数据绑定

        #region 保存时  输血申请单 ci_ap_bt数据绑定
        private OrdApBtDO SaveApBtDataBing(EmsUIDTO emsHeadDO)
        {
            OrdApBtDO bt = new OrdApBtDO();
            bt.Id_apbt = emsHeadDO.Emsapbt.Id_emsbt;
            //bt.Id_orbt	       // 医嘱输血申请主键标识	  	 	 	 	 				 	 		 
            //bt.Id_or	           // 医嘱	REF	临床医嘱	id_or	 			 	 			 	 	 		 
            bt.Id_di = emsHeadDO.Emsapbt.Id_di;         // 临床诊断	REF	医疗服务_疾病诊  	
            bt.Name_diag = emsHeadDO.Emsapbt.Name_diag; 		//诊断名称		 	 		 
            bt.Str_code_di = emsHeadDO.Emsapbt.Str_code_di;	       // 诊断编码拼接	SINGLE	  	 	 	 	 				 	 		 
            bt.Str_name_di = emsHeadDO.Emsapbt.Str_name_di;	   // 诊断名称拼接	SING  
            bt.Str_id_diitm = emsHeadDO.Emsapbt.Str_id_diitm;	   // 诊断名称拼接	SING 
            bt.Id_diitm = emsHeadDO.Emsapbt.Id_diitm;	
			 	 	 
            bt.No_applyform = emsHeadDO.Emsapbt.No_applyform;	   // 输血申请单号	SING 	 	 	 	 	 	 				 	 
            bt.Pregnant_num = emsHeadDO.Emsapbt.Pregnat_num;   // 孕几胎	SINGLE	  	 	 	 	 	 				 	 	 
            bt.Parturition_cnt = emsHeadDO.Emsapbt.Parturition_cnt;	//生产数量	SING 	 	 	 	 	 	 				 	 
            bt.Id_his_bt = emsHeadDO.Emsapbt.Id_his_bt;         //输血史标识	SINGLE	  	 	 	 	 				 	 		 
            bt.Sd_his_bt = emsHeadDO.Emsapbt.Sd_his_bt;        //输血史标识编码	SINGLE	  	 	 	 	 	 				 	 	 
            bt.Id_pps_bt = emsHeadDO.Emsapbt.Id_pps;         //输血目的	SINGLE	Stri 	 	 	 	 	 	 				 	 
            bt.Sd_pps_bt = emsHeadDO.Emsapbt.Sd_pps;         //输血目的编码	SINGLE
            if (emsHeadDO.Emsapbt.Dt_bt != null)
                bt.Dt_bt_pl = ((DateTime)emsHeadDO.Emsapbt.Dt_bt).ToString("yyyy-MM-dd HH:mm:ss"); 	 	 	 				 	 		 
            //bt.Des_pps_bt	    //输血目的描述	SING  	 	 	 	 	 				 	 	 
            bt.Fg_db = emsHeadDO.Emsapbt.Fg_db;           //献血史标识	SINGLE	FBoo  	 	 	 				 	 			 
            bt.No_db = emsHeadDO.Emsapbt.No_db;            //献血证号	SINGLE	String	no_db  	 	 				 	 			 	 	 		 	 	 	 	 
            bt.Id_labitmexplain = emsHeadDO.Emsapbt.Id_labitmexplain;	//输血前监测项目说明	S  	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            bt.Sd_labitmexplain = emsHeadDO.Emsapbt.Sd_labitmexplain;	//输血前监测项目说明编  	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            bt.Id_demandsu_bt = emsHeadDO.Emsapbt.Id_demandsu;	//输血需求状态	SINGL 			 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            bt.Sd_demandsu_bt = emsHeadDO.Emsapbt.Sd_demandsu;	//输血需求状态编码	S  				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            bt.Id_mode_bt = emsHeadDO.Emsapbt.Id_mode;	//预定输血方式	SINGLE	S 	 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
            bt.Sd_mode_bt = emsHeadDO.Emsapbt.Sd_mode;	//预定输血方式编码	SING  
            bt.Id_su_bt = CiDictCodeConst.ID_SU_BT_YSQ;
            bt.Sd_su_bt = CiDictCodeConst.SD_SU_BT_YSQ;
            bt.Fg_rpt = "N";
            bt.Num_margin_bu = emsHeadDO.Emsapbt.Quan_med;
            bt.Status = emsHeadDO.Emsapbt.Status;

            return bt;
        }
        #endregion 输血申请单 ci_ap_bt数据绑定

        #region 保存时 输血检验项目

        private List<OrdApBtViewItemDO> SaveApBtItemDataBing(EmsUIDTO emsHeadDO)
        {
            List<OrdApBtViewItemDO> list = new List<OrdApBtViewItemDO>();
            //对照
            foreach(var elem in emsHeadDO.Emsapbt.BtLabItem)
            {
                list.Add(new OrdApBtViewItemDO
                {
                    //Id_apbt = elem.Id_apop,
                    //Id_apbtobsindex = elem.Id_apopobsindex,
                    //Id_restrptlabtp = null,
                    Id_srv = elem.Id_srv,
                    Id_unit = elem.Id_unit,
                    Name_srv = elem.Name_srv,
                    Name_unit = elem.Name_unit,
                    Sd_restrptlabtp = elem.Sd_restrptlabtp,
                    Val_restrptlab = elem.Val_restrptlab,
                    Val_rstrptla = elem.Val_rstrptla,
                    //Sv = elem.Sv,
                    Status = elem.Status,
                    Id_apbtobsindex = elem.Id_apopobsindex
                });
            }
            return list;
        }
        #endregion

        #region 保存时 用血申请单 数据绑定

        private OrdAppBtUseDO SaveApBtUseDataBing(EmsUIDTO emsHeadDO, CiEmsDTO dto)
        {
            OrdAppBtUseDO btUse=new OrdAppBtUseDO();
            //做法 参照病理
            //-------------------判断本次是修改 还是新增----------------------------------------------
            if (dto.Orapplysheet != null && dto.Orapplysheet.Keys.Count > 0)
            {
                OrdAppBtUseDO aptem = dto.Orapplysheet[((int)EmsType.BTUSE).ToString()] as OrdAppBtUseDO;
                if (aptem != null)
                {
                    btUse = aptem;
                    btUse.SetUpdated();
                }
            }
            
            //---------------------新增或者 修改时候 需要 插入数据库的字段-----------------------------
            btUse.Dt_bu_plan = emsHeadDO.CiordubDTO.Dt_bu_pl_ub;
            btUse.No_applyform = emsHeadDO.CiordubDTO.No_applyform_ub;
            dto.Applyno = emsHeadDO.CiordubDTO.No_applyform_ub;
            dto.Id_route = emsHeadDO.CiordubDTO.Id_route;
            
            dto.Note = emsHeadDO.CiordubDTO.Des_or;
            dto.Des_or = emsHeadDO.CiordubDTO.Des_or;

            dto.Id_or_rel = emsHeadDO.CiordubDTO.Id_or_rel;

            dto.Sd_reltp = CiDictCodeConst.SD_RELTYPE_BLOOD;
            dto.Id_reltp = CiDictCodeConst.SD_RELTYPE_ID_BLOOD;
            dto.Dt_begin = emsHeadDO.CiordubDTO.Dt_bu_pl_ub;
            dto.Days_or = emsHeadDO.CiordubDTO.Use_days;
            dto.Dt_end = ((DateTime)dto.Dt_begin).AddDays(1);
            dto.Times_cur = emsHeadDO.CiordubDTO.Times_cur;          //在院执行标识	SINGLE	 	 	 	 	
            dto.Times_mp_in = emsHeadDO.CiordubDTO.Times_mp_in;      //在院执行次数
            //-----------------------只有首次新增的时候 才写入的字段---------------------------------------
            if (btUse.IsNEW)
            {
                btUse.Createdby =  UserManager.getInstance().CurrentUser.Id_psn;
                
                dto.Orapplysheet.Add(((int)EmsType.BTUSE).ToString(), btUse);
            }



            return btUse;


        }


        #endregion 保存时 用血申请单 数据绑定

        #region 保存时 手术服务补充

        private void SaveOpSrv(CiEmsSrvDTO srv, EmsUIDTO emsHeadDO)
        {
            srv.Quan_med = 1;
            //son.Id_unit_med = emsHeadDO.Id_medu;
            if (emsHeadDO.Emsapop.Status == DOStatus.NEW)
            {
                srv.Id_freq = emsHeadDO.MedSrvDO.Id_freq;
            }
            srv.Price = null;//TODO
            srv.Id_dep = emsHeadDO.Emsapop.Id_mp_dep;
            srv.Dt_create_srv = emsHeadDO.Emsapop.Dt_creat;
            srv.Price = emsHeadDO.Emsapop.Price;
            srv.Des_srv = emsHeadDO.Emsapop.Des;
            srv.Fg_or = emsHeadDO.MedSrvDO.Fg_or;
            srv.Innercode_srvca = emsHeadDO.MedSrvDO.Srvca_innercode;//服务分类内部编码
            srv.Fg_selfpay = emsHeadDO.Emsapop.Fg_selfpay;
            if (emsHeadDO.Emsapop.Fg_selfpay != null && emsHeadDO.Emsapop.Fg_selfpay.Value)
            {
                srv.Fg_hpindicjudged = (int)HpIndicJudgeEnum.SELFPAY;
            }
            else
            {
                srv.Fg_hpindicjudged = null;
            }
        }

        #endregion 保存时 手术服务补充

        #region 保存时 手术表ci_ap_sug_viewitm数据绑定

        public List<OrdApSugViewItemDO> SaveApSugItemDataBing(EmsUIDTO emsHeadDO, CiorappsurgeryAggDO agg)
        {
            List<OrdApSugViewItemDO> list = new List<OrdApSugViewItemDO>();
            if (agg != null)
            {
                OrdApSugViewItemDO[] items = agg.getOrdApSugViewItemDO();
                if (items != null)
                {
                    list.AddRange(items);
                    foreach (var elem in list)
                    {
                        var t = emsHeadDO.Emsapop.OpLabItem.FirstOrDefault(item => item.Id_apopobsindex == elem.Id_apopobsindex);
                        elem.Val_rstrptla = t.Val_rstrptla;
                        elem.Status = t.Status;
                    }
                }
            }
            else
            {
                return emsHeadDO.Emsapop.OpLabItem.ToList();
            }
            return list;
        }

        #endregion 保存时 手术表ci_ap_sug_viewitm数据绑定

        #region 保存时 手术表ci_ap_sug数据绑定
        public OrdApOpDO SaveApSugDataBing(EmsUIDTO emsHeadDO, CiorappsurgeryAggDO agg)
        {

            OrdApOpDO apOp;
            if (agg == null)
            {
                apOp = new OrdApOpDO();
                apOp.Id_srv = emsHeadDO.MedSrvDO.Id_srv;
                //apOp.Str_code_di = emsHeadDO.Str_code_di;
                //apOp.Str_name_di = emsHeadDO.Str_name_di;
                //apOp.Str_id_diitm = emsHeadDO.Str_id_diitm;
                //apOp.Id_diitm = emsHeadDO.Id_diitm;
            }
            else
            {
                apOp = agg.getParentDO();
            }
            apOp.Id_apop = emsHeadDO.Emsapop.Id_apop;
            //麻醉方法
            apOp.Id_anestp = emsHeadDO.Emsapop.Id_anestp;
            apOp.Sd_anestp = emsHeadDO.Emsapop.Sd_anestp;
            //诊断明细
            apOp.Id_di = emsHeadDO.Emsapop.Id_di;
            apOp.Id_diitm = emsHeadDO.Emsapop.Id_diitm;
            apOp.Name_diag = emsHeadDO.Emsapop.Name_diag;
            apOp.Str_code_di = emsHeadDO.Emsapop.Str_code_di;
            apOp.Str_id_diitm = emsHeadDO.Emsapop.Str_id_diitm;
            apOp.Str_name_di = emsHeadDO.Emsapop.Str_name_di;
            
            apOp.Id_emp_helper = emsHeadDO.Emsapop.Id_emp_help1;
            apOp.Id_emp_operate = emsHeadDO.Emsapop.Id_emp_operator;
            //切口愈合等级
            apOp.Id_incitp = emsHeadDO.Emsapop.Id_incitp;
            apOp.Sd_incitp = emsHeadDO.Emsapop.Sd_incitp;
            //手术级别
            apOp.Id_lvlsug = emsHeadDO.Emsapop.Id_lvlsug;
            apOp.Sd_lvlsug = emsHeadDO.Emsapop.Sd_lvlsug;
            //apOp.Id_or = emsHeadDO.Id_or;
            
            apOp.Id_srv_code = emsHeadDO.Emsapop.Code_srv;
            //体位
            apOp.Id_sugbody = emsHeadDO.Emsapop.Id_sugbodycod;
            apOp.Sd_sugbody = emsHeadDO.Emsapop.Sd_sugbodycod;
            //手术申请状态
            apOp.Id_su_op = CiDictCodeConst.ID_SU_OP_YSQ;
            apOp.Sd_su_op = CiDictCodeConst.SD_SU_OP_YSQ;
            apOp.Fg_allergy = emsHeadDO.Emsapop.Fg_allergy;
            apOp.Fg_new_sug = emsHeadDO.Emsapop.Fg_new_sug;
            apOp.Fg_patho = emsHeadDO.Emsapop.Fg_patho;
            apOp.Fg_er_sug = emsHeadDO.Emsapop.Fg_er_sug;
            apOp.Fg_xq_sug = emsHeadDO.Emsapop.Fg_xq_sug;
            apOp.Fg_zq_sug = emsHeadDO.Emsapop.Fg_zq_sug;
            apOp.Dt_plan = emsHeadDO.Emsapop.Dt_plan;
            apOp.No_applyform = emsHeadDO.Emsapop.No_applyform;
            apOp.Quan_bt_paln = emsHeadDO.Emsapop.Quan_bt_plan;
            apOp.Sugplantime = emsHeadDO.Emsapop.Time_sup_plan;
            apOp.Specialdes = emsHeadDO.Emsapop.Specialdes;
            apOp.Specialinstrument = emsHeadDO.Emsapop.Specialinstrument;
            apOp.Specialreq = emsHeadDO.Emsapop.Specialreq;
            apOp.Announcements = emsHeadDO.Emsapop.Announcements;
            apOp.Status = emsHeadDO.Emsapop.Status;
            if (emsHeadDO.Emsapop.Eu_anesca != null)
            {
                apOp.Eu_anesca = emsHeadDO.Emsapop.Eu_anesca.ToString();
            }
            apOp.Fg_daysug = emsHeadDO.Emsapop.Fg_daysug;
            return apOp;
        }
        #endregion 保存时 手术表ci_ap_sug数据绑定

        #region 保存时 手术人员ci_ap_sug_emp 数据绑定
        public List<OrdOpEmpDO> SaveOpSugEmpDataBing(EmsUIDTO emsHeadDO, CiorappsurgeryAggDO agg)
        {
            List<OrdOpEmpDO> list = new List<OrdOpEmpDO>();
            if (agg != null && null != agg.getOrdOpEmpDO())
            {
                list.AddRange(agg.getOrdOpEmpDO());
            }
            int i=0;
            emsHeadDO.Emsapop.OpEmpItem.ToList().ForEach(item =>
            {
                OrdOpEmpDO emp = new OrdOpEmpDO();				 	 	 
                emp.Id_apop = emsHeadDO.Emsapop.Id_apop;
                emp.Id_emp = item.Id_emp_op;     //人员	REF	用户	id_emp	varchar	20	用户	用户名称	 				 	 	 	 	 	 
                emp.Sd_role = item.Sd_role;	     //角色编码	SINGLE	String	sd_role	varchar	50	 	 	 				 	 	 	 
                emp.Id_role = item.Id_role;	     //角色id	REF	手术角色类型_自定义档案	id_role	varchar	20	手术角色类型_自定义档案	名称	 	
                emp.Sortno = i++;	     //排序
                emp.Status = item.Status;
                list.Add(emp);
            });

            return list;
        }

        #endregion 保存时 手术人员ci_ap_sug_emp 数据绑定

        #region 保存时 手术卫材ci_ap_sug_mm 数据绑定
        public List<OrdOpMmDO> SaveOpSugMmDataBing(EmsUIDTO emsHeadDO, CiorappsurgeryAggDO agg)
        {
            List<OrdOpMmDO> list = new List<OrdOpMmDO>();
            if (agg != null && agg.getOrdOpMmDO() != null )
            {
                list.AddRange(agg.getOrdOpMmDO());
            }

            emsHeadDO.Emsapop.OpMmItem.ToList().ForEach(item =>
            {
                OrdOpMmDO mm;
                if (item.IsNEW)
                    mm = new OrdOpMmDO();
                else
                {
                    mm = list.FirstOrDefault(elem => elem.Id_apopmm == item.Id_oropitem);
                }
                if (mm == null)
                    return;
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
                mm.Status = item.Status;

                if (item.IsNEW)
                    list.Add(mm);
            });

            return list;
        }

        #endregion 保存时 手术卫材ci_ap_sug_mm 数据绑定

        #region 保存时 附加手术orsrv数据绑定
        public List<CiEmsSrvDTO> SaveOpAppendOpDataBing(CiEmsSrvDTO srv, EmsUIDTO emsHeadDO)
        {
            List<CiEmsSrvDTO> list = new List<CiEmsSrvDTO>();
            emsHeadDO.Emsapop.OpAppendOpItem.ToList().ForEach(item =>
            {
                if ((!String.IsNullOrEmpty(item.Id_srv) && !String.IsNullOrEmpty(item.Code_srv))||item.Status==DOStatus.DELETED)
                {
                    CiEmsSrvDTO order = new CiEmsSrvDTO();
                    order = srv.CloneDo<CiEmsSrvDTO>();
                    list.Add(order);
                    order.Status = item.Status;
                    if (item.Status != DOStatus.NEW)
                    {
                        order.Id_orsrv = item.Id_orsrv;
                    }
                    order.Name_srv = item.Name_srv;
                    order.Id_srv = item.Id_srv;
                    order.Code_srv = item.Code_srv;
                    order.Des_srv = item.Des_op;
                    order.Status = item.Status;
                    order.Id_or = srv.Id_or;
                    order.Id_orsrv = item.Id_orsrv;
                    if (!string.IsNullOrEmpty(item.Id_srv)) {
                        MedSrvDO medsrvdo = XapServiceMgr.find<IMedsrvMDOCrudService>().findById(item.Id_srv);
                        order.Fg_or = medsrvdo.Fg_or;
                        order.Fg_bl = medsrvdo.Fg_bl;
                        order.Id_unit_med = medsrvdo.Id_unit_med;
                        order.Quan_med = medsrvdo.Quan_med;
                        order.Id_freq = medsrvdo.Id_freq;
                    }
                }
                
            });

            return list;
        }
        #endregion

        #region 保存时 病理申请单ci_ap_pathgy数据绑定

        public void SavePathgySrv(CiEmsSrvDTO srv, EmsUIDTO emsHeadDO)
        {
            if(srv==null)return;
            srv.Quan_med = emsHeadDO.MedSrvDO.Quan_med;
            srv.Id_unit_med = emsHeadDO.MedSrvDO.Id_unit_med;
            srv.Fg_bl = emsHeadDO.MedSrvDO.Fg_bl;
            srv.Fg_or = emsHeadDO.MedSrvDO.Fg_or;
            srv.Id_freq = emsHeadDO.MedSrvDO.Id_freq;
            srv.Id_route = emsHeadDO.MedSrvDO.Id_route;
            srv.Id_boil = emsHeadDO.MedSrvDO.Id_boil;
            srv.Id_dep = emsHeadDO.Emsappathgy.Id_mp_dep;
            srv.Innercode_srvca = emsHeadDO.MedSrvDO.Srvca_innercode;//服务分类内部编码
            srv.Fg_selfpay = emsHeadDO.Emsappathgy.Fg_selfpay;
            if (emsHeadDO.Emsappathgy.Fg_selfpay != null && emsHeadDO.Emsappathgy.Fg_selfpay.Value)
            {
                srv.Fg_hpindicjudged = (int)HpIndicJudgeEnum.SELFPAY;
            }
            else
            {
                srv.Fg_hpindicjudged = null;
            }

        }

        public void SaveApPathgyDataBing(EmsUIDTO emsHeadDO, CiEmsDTO dto)
        {

            CiorapppathgyAggDO agg = new CiorapppathgyAggDO();
            OrdApPathgyDO path = new OrdApPathgyDO();
            if (dto.Orapplysheet != null && dto.Orapplysheet.Keys.Count > 0)
            {
                CiorapppathgyAggDO aggtemp = dto.Orapplysheet[((int)EmsType.PATHGY).ToString()] as CiorapppathgyAggDO;
                if (aggtemp != null)
                {
                    agg = aggtemp;
                    path = aggtemp.getParentDO();
                    path.SetUpdated();
                }
            }

            //path.Id_orpathgy	      	
            //path.Id_or = emsHeadDO.Emsappathgy.Id_or;
            dto.Applyno = emsHeadDO.Emsappathgy.No_applyform;
            dto.Id_dep_mp = emsHeadDO.Emsappathgy.Id_mp_dep;
            dto.Dt_begin = emsHeadDO.Emsappathgy.Dt_begin_ui;
            dto.Dt_end = emsHeadDO.Emsappathgy.Dt_end_ui;
            dto.Days_or = emsHeadDO.Emsappathgy.Use_days;
            dto.Times_cur = emsHeadDO.Emsappathgy.Times_cur;          //在院执行标识	SINGLE	 	 	 	 	
            dto.Times_mp_in = emsHeadDO.Emsappathgy.Times_mp_in;      //在院执行次数
            path.No_applyform = emsHeadDO.Emsappathgy.No_applyform;
            path.Id_samptp = emsHeadDO.Emsappathgy.Id_samptp;
            path.Sd_samptp = emsHeadDO.Emsappathgy.Sd_samptp;            
            //path.Quan = emsHeadDO.Emsappathgy.Quan;
            path.Quan = emsHeadDO.Emsappathgy.EmsItemInpathgy.Count;

            path.Des_labsamp = emsHeadDO.Emsappathgy.Des_labsamp;         
            path.Fg_urgent = emsHeadDO.Emsappathgy.Fg_urgent; // 申请单中的加急标识不用了，先保持原有逻辑，执行业务以ci_order中的加急标识为准
            dto.Fg_urgent = emsHeadDO.Emsappathgy.Fg_urgent; // 加急标识改为放到医嘱表中，病理未做修改
            //诊断信息
            path.Id_di = emsHeadDO.Emsappathgy.Id_di;
            path.Name_diag = emsHeadDO.Emsappathgy.Name_diag;
            path.Str_code_di = emsHeadDO.Emsappathgy.Str_code_di;        //诊断编码拼接	SINGLE	String	str_id_d
            path.Str_name_di = emsHeadDO.Emsappathgy.Str_name_di;    	//诊断名称拼接	SINGLE	String	str_
            path.Str_id_diitm = emsHeadDO.Emsappathgy.Str_id_diitm;    	//诊断名称拼接	SINGLE	String	str_
            path.Id_diitm = emsHeadDO.Emsappathgy.Id_diitm;//诊断的子项 id

            path.Announcements = emsHeadDO.Emsappathgy.Announcements;    //检查要求	SINGLE	String	announce
            path.Des_sympsign = emsHeadDO.Emsappathgy.Des_sympsign;    //病情描述	SINGLE	String	des_symp
            path.Fg_outer = emsHeadDO.Emsappathgy.Fg_outer;        //是否外院标志	SINGLE	String	fg_outer
            path.No_pathgy_old = emsHeadDO.Emsappathgy.No_pathgy_old;	    //既往病理号	SINGLE	String	
            path.Dt_pathgy_old = emsHeadDO.Emsappathgy.Dt_pathgy_old;    //既往检查日期	SINGLE	FDateTime	
            path.Di_pathgy_old = emsHeadDO.Emsappathgy.Name_di_pathgy_old;    //既往检查诊断	SINGLE	String	
            path.Org_pathgy_old = emsHeadDO.Emsappathgy.Org_pathgy_old;   //既往检查医院	SINGLE	String	
            path.Collectdes = emsHeadDO.Emsappathgy.Collectdes;        //采集所见	SINGLE	String	collectd
            path.Id_emp = emsHeadDO.Emsappathgy.Id_emp_coll;          //采集者编码	REF	人员基本信息	id_e
            path.Name_coll_emp = emsHeadDO.Emsappathgy.Name_emp_coll;
            path.Dt_coll = emsHeadDO.Emsappathgy.Dt_coll;            //标本采集时间	SINGLE	FDateTime	dt_c
            path.Sd_su_pathgy = CiDictCodeConst.SD_PATHOLOGY_STATUS_APPLY;
            path.Id_su_pathgy = CiDictCodeConst.ID_PATHOLOGY_STATUS_APPLY;//病理申请状态	REF	病理采集申请状态_自定义档案	sd_su_pathgy	varchar	20	
            path.No_pathgy = emsHeadDO.Emsappathgy.No_pathgy;	        //病理号	SINGLE	String	no_pathg
            path.Dt_rptpathgy = emsHeadDO.Emsappathgy.Dt_rptpathgy; //报告发布时间	SINGLE	FDateTime	
            path.Def1 = emsHeadDO.Emsappathgy.Def1;
            path.Def2 = emsHeadDO.Emsappathgy.Def2;
            path.Def3 = emsHeadDO.Emsappathgy.Def3;
            path.Def4 = emsHeadDO.Emsappathgy.Def4;
            path.Def5 = emsHeadDO.Emsappathgy.Def5;
            path.Def6 = emsHeadDO.Emsappathgy.Def6;
            path.Def7 = emsHeadDO.Emsappathgy.Def7;
            path.Def8 = emsHeadDO.Emsappathgy.Def8;
            path.Def9 = emsHeadDO.Emsappathgy.Def9;
            path.Def10 = emsHeadDO.Emsappathgy.Def10;
            path.Def11 = emsHeadDO.Emsappathgy.Def11;
            path.Def12 = emsHeadDO.Emsappathgy.Def12;
            path.Def13 = emsHeadDO.Emsappathgy.Def13;
            path.Def14 = emsHeadDO.Emsappathgy.Def14;

            if (path.IsNEW)
            {
                agg.setParentDO(path);
                path.Id_dep = UserManager.getInstance().CurrentDept.Id_dep;          //采集者科室	REF	部门	
                dto.Orapplysheet.Add(((int)EmsType.PATHGY).ToString(), agg);
                //path.Quan = emsHeadDO.Emsappathgy.Quan;
                path.Quan = emsHeadDO.Emsappathgy.EmsItemInpathgy.Count;
                path.Id_colltp = emsHeadDO.Emsappathgy.Id_colltp;
                path.Sd_colltp = emsHeadDO.Emsappathgy.Sd_colltp;
            }


            SavePathgySampDataBing(emsHeadDO, dto, agg);


        }
        #endregion 保存时 病理申请单ci_ap_pathgy数据绑定

        #region 保存时 病理标本ci_pathgy_samp数据绑定
        public void SavePathgySampDataBing(EmsUIDTO emsHeadDO, CiEmsDTO dto, CiorapppathgyAggDO agg)
        {
            List<OrdApPathgySampDO> sampList = new List<OrdApPathgySampDO>();
            List<EmsItemInPathgy> list = emsHeadDO.Emsappathgy.EmsItemInpathgy.ToList();


            if (agg != null && agg.getOrdApPathgySampDO() != null)
            {
                sampList = agg.getOrdApPathgySampDO().ToList();
                //删除原有标本记录后保存，将该记录设置为删除状态
                if (sampList != null && sampList.Count > 0)
                {
                    foreach (OrdApPathgySampDO sampDO in sampList)
                    {
                        EmsItemInPathgy itemTemp = list.FirstOrDefault(x => x.Id_oriteminpathgy == sampDO.Id_appathgysamp);
                        if (itemTemp == null)
                        {
                            sampDO.SetDeleted();
                        }
                    }
                }

            }

            foreach (EmsItemInPathgy item in list)
            {
                OrdApPathgySampDO samp = new OrdApPathgySampDO();

                OrdApPathgySampDO samptemp = sampList.FirstOrDefault(x => x.Id_appathgysamp != null && x.Id_appathgysamp == item.Id_oriteminpathgy);
                if (samptemp != null)
                {
                    samp = samptemp; 
                    samp.SetUpdated();
                }
                else
                {
                    sampList.Add(samp);
                }
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
                samp.Id_appathgysamp = item.Id_oriteminpathgy;
                samp.Status = item.Status;
                samp.Id_body_coll = item.Id_body_coll;//标本采集部位id
                samp.Sd_body_coll = item.Sd_body_coll;//标本采集部位sd
                samp.Id_fixative = item.Id_fixative;//标本固定液id
                samp.Sd_fixative = item.Sd_fixative;//标本固定液sd
                if (samp.Id_appathgysamp != null && samp.Status==DOStatus.NEW)
                {
                    samp.Status = DOStatus.UPDATED;
                }
                if (agg != null || agg.getParentDO() != null) {
                    samp.Id_appathgy = agg.getParentDO().Id_appathgy;//申请单号
                }
                //flist.Add(samp);
            }

            agg.setOrdApPathgySampDO(sampList.ToArray());
        }
        #endregion 保存时 病理标本ci_pathgy_samp数据绑定

        #region 保存时 会诊申请单 数据绑定
        public void SaveApConsDataBing(EmsUIDTO headDo, CiEmsDTO dto)
        {
            //dto.Id_dep_phy = 
            CiorappconsultAggDO agg = new CiorappconsultAggDO();
            OrdApConsDO cons = new OrdApConsDO();
            if (dto.Orapplysheet != null && dto.Orapplysheet.Keys.Count > 0)
            {
                CiorappconsultAggDO aggtemp = dto.Orapplysheet[((int)EmsType.CONS).ToString()] as CiorappconsultAggDO;
                if (aggtemp != null)
                {
                    agg = aggtemp;
                    cons = aggtemp.getParentDO();
                    agg.SetUpdated();
                    cons.SetUpdated();
                }

            }
            //cons.Id_orcons(不赋值)	    // 医嘱会诊申请主键标识	SINGLE	FID	i 
            //cons.Id_or(不赋值)	        //医嘱	REF	临床医嘱	id_or	varch 
            //headDo.Emsapcons.Id_emsconsitem = cons.Id_apcons;	//主键	SINGLE	String	50	  
            cons.Fg_urgent = headDo.Emsapcons.Fg_urgent;    //加急标识	SINGLE	FBoolean
            dto.Fg_urgent = headDo.Emsapcons.Fg_urgent;   //加急标识	由于业务调整，加急标识保存到医嘱表中，原有逻辑保持不变
            dto.Dt_begin = headDo.Emsapcons.Dt_begin_ui;
            dto.Dt_end = headDo.Emsapcons.Dt_end_ui;
            dto.Days_or = headDo.Emsapcons.Use_days;
            dto.Times_cur = headDo.Emsapcons.Times_cur;          //在院执行标识	SINGLE	 	 	 	 	
            dto.Times_mp_in = headDo.Emsapcons.Times_mp_in;      //在院执行次数
            cons.Dt_plan = headDo.Emsapcons.Dt_plan;     	//计划会诊时间	SINGLE	FDateTime 
            cons.Tel = headDo.Emsapcons.Tel;      	//联系电话	SINGLE	String	2 
            //cons.Id_place = headDo.Emsapcons.Id_place;   //申请地点id	REF	地点	20	 	  
            cons.Place = headDo.Emsapcons.Name_place;    //申请地点	SINGLE	String	5 
            cons.Des_emr = headDo.Emsapcons.Des_emr;        //  病理摘要	SINGLE	备注	300	  
            cons.Des_psp = headDo.Emsapcons.Des_psp;        //会诊目的	SINGLE	备注	300	  
            cons.No_applyform = headDo.Emsapcons.No_applyform; //会诊申请单号	 			
            cons.Id_constp = headDo.Emsapcons.Id_constp;   //会诊类型	RE 	 	 	 	
            cons.Sd_constp = headDo.Emsapcons.Sd_constp;  //会诊类型编码				
            cons.Dt_ap = headDo.Emsapcons.Dt_creat;   //申请时间	SI		 	 	
            cons.Des_dep = headDo.Emsapcons.Des_dep;	//医务部意见
            MedSrvConsDO consDo=cof.GetCons(headDo.MedSrvDO.Id_srv);
            if (consDo == null)return;
            cons.Fg_audit_clidep = consDo.Fg_audit_clidep;
            cons.Fg_audit_admdep = consDo.Fg_audit_admdep;
            if (cons.Fg_urgent == true)
            {
                if (consDo.Quan_urg_constimelimit != null || consDo.Id_unit_urg != null)
                {
                cons.Dt_constimelimit = cof.GetConsTimeLimit(consDo.Id_unit_urg, consDo.Quan_urg_constimelimit.Value,
                    cons.Dt_plan);
            }

            }
            else
            {
                if (consDo.Quan_constimelimit != null && consDo.Id_unit != null)
                {
                cons.Dt_constimelimit = cof.GetConsTimeLimit(consDo.Id_unit, consDo.Quan_constimelimit.Value,
                    cons.Dt_plan);
            }

            }
            cons.Fg_audit_clidep = cons.Fg_audit_clidep == null ? false : cons.Fg_audit_clidep;
            cons.Fg_audit_admdep = cons.Fg_audit_admdep == null ? false : cons.Fg_audit_admdep;
            if (cons.IsNEW)
            {
                //if (headDo.Emsapcons.EmsConsItem[0].Sd_constp == "0" || headDo.Emsapcons.EmsConsItem[0].Sd_constp == "1")
                //{
                //    cons.Sd_su_cons = CiDictCodeConst.SD_SU_CONS_CONFIRMING;
                //    cons.Id_su_cons = CiDictCodeConst.SD_SU_CONS_CONFIRMING_ID;
                //}
                //if (headDo.Emsapcons.EmsConsItem[0].Sd_constp == "2" || headDo.Emsapcons.EmsConsItem[0].Sd_constp == "3")
                //{
                //    cons.Sd_su_cons = CiDictCodeConst.SD_SU_CONS_PLAN;
                //    cons.Id_su_cons = CiDictCodeConst.SD_SU_CONS_PLAN_ID;
                //}
                if (cons.Fg_audit_clidep == true)
                {
                    cons.Sd_su_cons = CiDictCodeConst.SD_CIDI_DKSSP;//待科室审批
                    cons.Id_su_cons = CiDictCodeConst.ID_CIDI_DKSSP;
                }
                else
                {
                    if (cons.Fg_audit_admdep == true)
                    {
                        cons.Sd_su_cons = CiDictCodeConst.SD_CIDI_DYWSP;//待医务审批
                        cons.Id_su_cons = CiDictCodeConst.ID_CIDI_DYWSP;
                    }
                    else
                    {
                        cons.Sd_su_cons = CiDictCodeConst.SD_CIDI_DKSYD;//待科室应答
                        cons.Id_su_cons = CiDictCodeConst.ID_CIDI_DKSYD;
                    }
                   
                }
                agg.setParentDO(cons);
                
                dto.Orapplysheet.Add(((int)EmsType.CONS).ToString(), agg);
            }

            SaveConsSampDataBing(headDo, dto, agg);
        }
        //保存会诊受邀对象
        public void SaveConsSampDataBing(EmsUIDTO emsHeadDO, CiEmsDTO dto, CiorappconsultAggDO agg)
        {
            List<CiordInviteConsDO> sampList = new List<CiordInviteConsDO>();
            List<EmsItemInCons> list = emsHeadDO.Emsapcons.EmsConsAssistItem.ToList();
            
            if (agg != null && agg.getCiordInviteConsDO() != null)
            {
                // 用于记录删除对象CiordInviteConsDO的索引值，从助手进来的有受邀科室为空的记录
                List<int> delInviteIndex = new List<int>();
                sampList = agg.getCiordInviteConsDO().ToList();
                for (int i = 0; i < sampList.Count; i++)
                {
                    CiordInviteConsDO inviteCons = (CiordInviteConsDO)sampList[i];
                    if (string.IsNullOrEmpty(inviteCons.Id_dep))
                    {
                        delInviteIndex.Add(i);
                    }
                    if ((list.FirstOrDefault(x => x.Id_emsitemincons == inviteCons.Id_invitecons)) == null)
                        inviteCons.Status = DOStatus.DELETED;
                }

                // 删除受邀科室为空的CiordInviteConsDO
                foreach (int i in delInviteIndex)
                {
                    sampList.RemoveAt(i);
                }
            }

            foreach (EmsItemInCons item in list)
            {
                CiordInviteConsDO samp = new CiordInviteConsDO();

                if (item.Id_emsitemincons != null)
                {
                    samp = sampList.FirstOrDefault(x => x.Id_invitecons == item.Id_emsitemincons);
                    samp.SetUpdated();
                    
                }
                else
                {
                    sampList.Add(samp);
                    if (agg != null && agg.getParentDO()!=null && agg.getParentDO().Id_apcons != null)
                        samp.Id_apcons = agg.getParentDO().Id_apcons;
                }

                samp.Id_org = item.Id_org;//    受邀机构id	REF	组织	20
                samp.Name_org = item.Name_org;//受邀机构	SINGLE	String
                samp.Id_dep = item.Id_dep_emp;//    受邀科室id	REF	部门	20
                samp.Name_dep = item.Name_dep_emp;//受邀科室	SINGLE	String
                samp.Sd_emp_title = item.Sd_emp_title;//受邀职称编码	SINGLE	St
                samp.Id_emp_title = item.Id_emp_title;//受邀职称id	REF	人员聘任职
                samp.Name_emp_title = item.Name_emp_title;//    受邀职称	SINGLE	String
                samp.Id_emp = item.Id_emp_doctor;//受邀人id	REF	用户	20
                samp.Name_emp = item.Name_emp_doctor;//    受邀人	SINGLE	String	50
                samp.Dt_response = item.Dt_response;//    应答时间	SINGLE	FDateT
                samp.Fg_response = item.Fg_response;//应答标志	SINGLE	FBoole
                samp.Id_emp_response = item.Id_emp_response;//    应答人id	REF	用户	20
                samp.Name_emp_respon = item.Name_emp_response; //应答人	SINGLE	String	50
            }

            agg.setCiordInviteConsDO(sampList.ToArray());

        }
        #endregion 保存时 会诊申请单 数据绑定

        /// <summary>
        /// 检验申请单
        /// </summary>
        /// <returns></returns>
        public void setOrderAppLab(EmsUIDTO emsHeadDO, CiEmsDTO dto)
        {
            

            OrdApLabDO lab = new OrdApLabDO();
            if (dto.Orapplysheet != null && dto.Orapplysheet.Keys.Count > 0)
            {
                OrdApLabDO aptem = dto.Orapplysheet[((int)EmsType.LIS).ToString()] as OrdApLabDO;
                if (aptem != null)
                {
                    lab = aptem;
                    lab.SetUpdated();
                    dto.SetUpdated();
                }
            }
            lab.Id_di = emsHeadDO.Emsaplab.Id_di;
            lab.Name_diag = emsHeadDO.Emsaplab.Name_diag;
            lab.Id_diitm = emsHeadDO.Emsaplab.Id_diitm;
            lab.Str_code_di = emsHeadDO.Emsaplab.Str_code_di;
            lab.Str_id_diitm = emsHeadDO.Emsaplab.Str_id_diitm;
            lab.Str_name_di = emsHeadDO.Emsaplab.Str_name_di;

            lab.No_applyform = emsHeadDO.Emsaplab.No_applyobs;
            dto.Applyno = emsHeadDO.Emsaplab.No_applyobs;
            lab.Fg_urgent = emsHeadDO.Emsaplab.Fg_urgent;
            dto.Fg_urgent = emsHeadDO.Emsaplab.Fg_urgent == null ? false : emsHeadDO.Emsaplab.Fg_urgent;//医嘱的加急标志 2016-07-01张万青
            lab.Dt_plan = emsHeadDO.Emsaplab.Dt_plan;
            lab.Id_pps = emsHeadDO.Emsaplab.Id_pps;
            lab.Sd_pps = emsHeadDO.Emsaplab.Sd_pps;
            lab.Des_pps = emsHeadDO.Emsaplab.Des_pps;

            lab.Sd_pps = emsHeadDO.Emsaplab.Sd_pps;
            lab.Des_pps = emsHeadDO.Emsaplab.Name_pos;
            lab.Des_sympsign = emsHeadDO.Emsaplab.Des_sympsign;
            lab.Sd_samptp = emsHeadDO.Emsaplab.Sd_samptp;
            lab.Id_samptp = emsHeadDO.Emsaplab.Id_samptp;
            lab.Fg_urgent = emsHeadDO.Emsaplab.Fg_urgent;
            //标本采集时间
            lab.Id_sampcoltime = emsHeadDO.Emsaplab.Id_sampcoltime;//标本采集时间
            lab.Id_sampcollecttimetp = emsHeadDO.Emsaplab.Id_sampcollecttimetp;//标本采集时间类型
            lab.Sd_sampcollecttimetp = emsHeadDO.Emsaplab.Sd_sampcollecttimetp;//标本采集时间类型编码
            lab.Len_sampcoltime = emsHeadDO.Emsaplab.Len_sampcoltime;//标本采集时长
            lab.Id_unit_sampcoltime = emsHeadDO.Emsaplab.Id_unit_sampcoltime;//标本采集时间时长单位
            // 
            // 总次数
            dto.Days_or = emsHeadDO.Emsaplab.Use_days;
           // dto.Times_cur = (int)(emsHeadDO.Emsaplab.Quan_cur != null && emsHeadDO.Emsaplab.Quan_cur !=0? emsHeadDO.Emsaplab.Quan_cur.DoubleValue() : 1);
            dto.Quan_medu = emsHeadDO.Emsaplab.Quan_med;
            dto.Id_unit_med = emsHeadDO.Emsaplab.Id_unit_med;
            dto.Name_unit_med = emsHeadDO.Emsaplab.Name_unit_med;
            dto.Name_freq = emsHeadDO.Emsaplab.Name_freq;
            //dto.Price = emsHeadDO.Emsaplab.Price;
            dto.Id_dep_mp = emsHeadDO.Emsaplab.Id_mp_dep;//执行科室id 2016-08-02 zwq
            dto.Name_dep_mp = emsHeadDO.Emsaplab.Name_mp_dep;//执行科室 2016-08-02 zwq
            dto.Innercode_srvca = emsHeadDO.MedSrvDO.Srvca_innercode;//服务分类内部编码
            dto.Note = emsHeadDO.Emsaplab.Des_sympsign;//医嘱的描述内容，医嘱中也存储一份 2016-08-03 zwq

            dto.Dt_begin = emsHeadDO.Emsaplab.Dt_plan;
            dto.Days_or = emsHeadDO.Emsaplab.Use_days;
            if (dto.Days_or != null) {
                dto.Dt_end = ((DateTime)dto.Dt_begin).AddDays((int)emsHeadDO.Emsaplab.Use_days);    
            }
            dto.Times_cur = emsHeadDO.Emsaplab.Times_cur;          //在院执行标识	SINGLE	 	 	 	 	
            dto.Times_mp_in = emsHeadDO.Emsaplab.Times_mp_in;      //在院执行次数

            if (emsHeadDO.Emsaplab.EmsOrObsList != null && emsHeadDO.Emsaplab.EmsOrObsList.Count > 0)
            {
                lab.Announcements = emsHeadDO.Emsaplab.EmsOrObsList[0].Announcements;
                lab.Quan = emsHeadDO.Emsaplab.EmsOrObsList[0].Quan;
                lab.Id_unit_quan = emsHeadDO.Emsaplab.EmsOrObsList[0].Id_quan;
                lab.Sd_contp = emsHeadDO.Emsaplab.EmsOrObsList[0].Sd_contp;
                lab.Id_contp = emsHeadDO.Emsaplab.EmsOrObsList[0].Id_contp;
                lab.Sd_colltp = emsHeadDO.Emsaplab.EmsOrObsList[0].Sd_colltp;
                lab.Id_colltp = emsHeadDO.Emsaplab.EmsOrObsList[0].Id_colltp;
                lab.Id_labgroup = emsHeadDO.Emsaplab.EmsOrObsList[0].Id_labgroup;
                lab.Sd_labgroup = emsHeadDO.Emsaplab.EmsOrObsList[0].Sd_labgroup;
            }
            lab.Des_labsamp = emsHeadDO.Emsaplab.Des_labsamp;
          
            if (lab.IsNEW)
            {
                lab.Createdby = UserManager.getInstance().CurrentUser.Id_psn;
                lab.Id_su_lab = CiDictCodeConst.ID_CI_LAB_SQ;//TODO:SD
                lab.Sd_su_lab =  CiDictCodeConst.SD_CI_LAB_SQ;
                dto.Orapplysheet.Add(((int)EmsType.LIS).ToString(), lab);
                lab.Id_srvca = emsHeadDO.MedSrvDO.Id_srvca;
            }
        }
        
        /// <summary>
        /// Saves备血的项目
        /// </summary>
        /// <param name="emsHeadDO">The ems head do.</param>
        /// <param name="dto">The dto.</param>
        /// <returns></returns>
        /// Author:li_cheng
        /// Date:2015-12-19
        public FArrayList SaveEmsApBtItem(EmsUIDTO emsHeadDO, CiEmsDTO dto, int Eu_sourcemd, CiEmsSrvDTO srvdto)
        {
            FArrayList list = new FArrayList();
            List<CiEmsSrvDTO> srvList = new List<CiEmsSrvDTO>();
            if ((bool) emsHeadDO.MedSrvDO.Fg_set)
            {
                IMedSrvSetItemDOCrudService itemservice = XapServiceMgr.find<IMedSrvSetItemDOCrudService>();
                var service = XapServiceMgr.find<IMedsrvMDOCrudService>();
               // MedSrvSetItemDO[] itemdos = itemservice.find("id_srv='" + emsHeadDO.MedSrvDO.Id_srv + "'", null, FBoolean.False);

                dto.Id_srv = emsHeadDO.MedSrvDO.Id_srv;
                dto.Id_srvtp = emsHeadDO.MedSrvDO.Id_srvtp;
                dto.Sd_srvtp = emsHeadDO.MedSrvDO.Sd_srvtp;
               
                dto.Id_freq = emsHeadDO.MedSrvDO.Id_freq;
                dto.Id_unit_med = emsHeadDO.MedSrvDO.Id_unit_med;//zwq 2016-08-19新增 保存时要校验频次和剂量单位
                dto.Id_route = emsHeadDO.MedSrvDO.Id_route;

                dto.Fg_set = emsHeadDO.MedSrvDO.Fg_set;

                CiEmsSrvDTO srvCommon = new CiEmsSrvDTO();


                srvCommon.Name_srv = emsHeadDO.MedSrvDO.Name;
                srvCommon.Code_srv = emsHeadDO.MedSrvDO.Code;
                srvCommon.Id_srv = emsHeadDO.MedSrvDO.Id_srv;
                srvCommon.Id_srvca = emsHeadDO.MedSrvDO.Id_srvca;
                srvCommon.Id_srvtp = emsHeadDO.MedSrvDO.Id_srvtp;
                srvCommon.Sd_srvtp = emsHeadDO.MedSrvDO.Sd_srvtp;
                srvCommon.Eu_blmd = emsHeadDO.MedSrvDO.Eu_blmd;
                srvCommon.Dt_create_srv = CommonExtentions.NowTime(this); //开立时间	      SINGL 


                srvCommon.Eu_sourcemd = Eu_sourcemd;


                srvCommon.Id_dep = emsHeadDO.Emsapbt.Id_mp_dep;
                srvCommon.Id_freq = emsHeadDO.MedSrvDO.Id_freq;//zwq 2016-08-19新增 保存时要校验频次和剂量单位
                srvCommon.Quan_med = emsHeadDO.Emsapbt.Quan_med;
                srvCommon.Id_unit_med = emsHeadDO.Emsapbt.Id_unit_med;
                srvCommon.Name_unit_med = emsHeadDO.Emsapbt.Name_unit_med;
                //srvCommon.Status = emsHeadDO.Emsapbt.Status;
                srvCommon.Factor_mb = srvCommon.Factor_mb ?? 1;
                srvCommon.Id_hp = emsHeadDO.PatInfo.Id_hp;
                //12/26 11:14 added by yz 
                //need EmsBtItemDO.cs and EmsBtItemDO_Partial.cs compiled
                srvCommon.Fg_mm = emsHeadDO.Emsapbt.Fg_mm;
                srvCommon.Fg_or = emsHeadDO.Emsapbt.Fg_or;
                //srvCommon.Fg_bl = emsHeadDO.Emsapbt.Fg_bl;
                srvCommon.Fg_bl = false;//血液的费用标识都为false
                srvCommon.Fg_set = emsHeadDO.MedSrvDO.Fg_set;
                srvCommon.Id_srv = emsHeadDO.MedSrvDO.Id_srv;
                srvCommon.Id_srv_set = emsHeadDO.MedSrvDO.Id_srv;
                srvCommon.Status = emsHeadDO.Status;
                list.Add(srvCommon);
                MedSrvDO srvDo = service.findById(emsHeadDO.Emsapbt.Id_srv);
                FArrayList emssrvs= dto.Emssrvs;
                CiEmsSrvDTO stvdto = new CiEmsSrvDTO();
                foreach (CiEmsSrvDTO ems in emssrvs) {
                    //if (ems.Sd_srvtp != null && ems.Sd_srvtp == BdSrvDictCodeConst.SD_SRVTP_BLOODPROD_BLOODPROD_READYBLOOD)
                    //{
                    //    stvdto = ems;
                    //}
                    if (ems.Eu_sourcemd != null && ems.Eu_sourcemd == (int)OrSrvSourceFromEnum.PHYSIAN && ems.Sd_srvtp == BdSrvDictCodeConst.SD_SRVTP_BLOODPROD_BLOODPROD_READYBLOOD && ems.Fg_set != FBoolean.True) {
                        stvdto = ems;
                    }
                }
                
                stvdto.Name_srv = emsHeadDO.Emsapbt.Name_srv;
                stvdto.Code_srv = srvDo.Code;
                stvdto.Id_srv = srvDo.Id_srv;
                stvdto.Id_srvca = srvDo.Id_srvca;


                stvdto.Id_srvtp = srvDo.Id_srvtp;
                stvdto.Sd_srvtp = srvDo.Sd_srvtp;
                stvdto.Eu_blmd = srvDo.Eu_blmd;
                stvdto.Dt_create_srv = CommonExtentions.NowTime(this); //开立时间	      SINGL 
                stvdto.Status = emsHeadDO.Status;
                stvdto.Id_srv_set = emsHeadDO.MedSrvDO.Id_srv;
                stvdto.Eu_sourcemd = Eu_sourcemd;

                stvdto.Quan_med = emsHeadDO.Emsapbt.Quan_med;
                stvdto.Id_unit_med = emsHeadDO.Emsapbt.Id_unit_med;
                stvdto.Name_unit_med = emsHeadDO.Emsapbt.Name_unit_med;
                stvdto.Id_freq = emsHeadDO.MedSrvDO.Id_freq;//套内项目的频次等于医嘱项目的频次
                stvdto.Id_route = srvDo.Id_route;
                stvdto.Id_primd = srvDo.Id_primd;
                stvdto.Fg_bl = srvDo.Fg_bl;

                stvdto.Fg_mm = srvDo.Fg_mm;
                if (srvdto.Fg_mm != null && srvdto.Fg_mm == true) {
                    IMeterialMDORService mmservice = XapServiceMgr.find<IMeterialMDORService>();
                    MeterialDO[] mms = mmservice.find(string.Format("id_srv='{0}' and fg_active='Y' and ds=0 ", stvdto.Id_srv), "", false);
                    if (mms != null && mms.Length > 0)
                    {
                        stvdto.Id_mm = mms[0].Id_mm;
                        stvdto.Name_mm = mms[0].Name;
                        stvdto.Id_unit_base = mms[0].Id_unit_pkgbase;
                        stvdto.Id_unit_sale = mms[0].Id_unit_pkgsp;
                        stvdto.Code_mm = mms[0].Code;
                        stvdto.Factor_mb = mms[0].Factor_mb;
                    }
                }
                //MedSrvSetItemDO itemdo = itemdos.FirstOrDefault(p => p.Id_srv_itm == emsHeadDO.Emsapbt.Id_srv);
                //stvdto.Fg_or = itemdo.Fg_clinical;
                stvdto.Fg_or = true;
                stvdto.Fg_set = srvDo.Fg_set;
                //stvdto.Id_dep = emsHeadDO.Emsapbt.Id_mp_dep;
                //stvdto.Name_dep = emsHeadDO.Emsaplab.Name_mp_dep;
               list.Add(stvdto);
                //foreach (MedSrvSetItemDO itemdo in itemdos)
                //{
                //    MedSrvDO srvDo = service.findById(itemdo.Id_srv_itm);
                //    CiEmsSrvDTO stvdto = new CiEmsSrvDTO();
                //    stvdto.Name_srv = srvDo.Name;
                //    stvdto.Code_srv = srvDo.Code;
                //    stvdto.Id_srv = srvDo.Id_srv;
                //    stvdto.Id_srvca = srvDo.Id_srvca;


                //    stvdto.Id_srvtp = srvDo.Id_srvtp;
                //    stvdto.Sd_srvtp = srvDo.Sd_srvtp;
                //    stvdto.Eu_blmd = srvDo.Eu_blmd;
                //    stvdto.Dt_create_srv = CommonExtentions.NowTime(this); //开立时间	      SINGL 

                //    stvdto.Id_srv_set = emsHeadDO.MedSrvDO.Id_srv;
                //    stvdto.Eu_sourcemd = Eu_sourcemd;

                //    stvdto.Quan_med = srvDo.Quan_med;
                //    stvdto.Id_unit_med = srvDo.Id_unit_med;
                //    stvdto.Id_freq = srvDo.Id_freq;
                //    stvdto.Id_route = srvDo.Id_route;

                //    stvdto.Fg_mm = srvDo.Fg_mm;
                //    stvdto.Fg_or = itemdo.Fg_clinical;
                //    stvdto.Fg_set = srvDo.Fg_set;
                //    stvdto.Id_dep = emsHeadDO.Emsapbt.Id_mp_dep;
                //    stvdto.Name_dep = emsHeadDO.Emsaplab.Name_mp_dep;
                //  //       stvdto.Id_srv_set=itemdo.
                //    if (stvdto.IsNEW)
                //    {
                //       list.Add(stvdto);
                //    }
                //}
                
            }

            return list;
        } 

        /// <summary>
        /// Saves检验的项目
        /// </summary>
        /// <param name="emsHeadDO">The ems head do.</param>
        /// <param name="dto">The dto.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-12-19
        public FArrayList SaveEmsApLabItem(EmsUIDTO emsHeadDO, CiEmsDTO dto, int Eu_sourcemd)
        {
            FArrayList list = new FArrayList();
            List<CiEmsSrvDTO> srvList = new List<CiEmsSrvDTO>();
            dto.Dt_begin = emsHeadDO.Emsaplab.Dt_plan;
            dto.Days_or = emsHeadDO.Emsaplab.Use_days;
            if (dto.Emssrvs.Count > 0)
            {
                foreach (CiEmsSrvDTO item in dto.Emssrvs)
                {
                    srvList.Add(item);
                }
            }
                if ((bool)emsHeadDO.MedSrvDO.Fg_set)
                {
                    CiEmsSrvDTO stvdto = new CiEmsSrvDTO();

                    stvdto.Id_body = emsHeadDO.Emsaplab.Id_body;         //部位	SINGLE	  	 	
                    stvdto.Sd_body = emsHeadDO.Emsaplab.Sd_body;	          //部位编码	SINGL 
                    stvdto.Id_pos = emsHeadDO.Emsaplab.Id_pos;          //体位	SINGLE	  	 	
                    stvdto.Sd_pos = emsHeadDO.Emsaplab.Sd_pos;          //体位编码	SINGL 
                    stvdto.Body_name = emsHeadDO.Emsaplab.Name_body;	      //部位名称	SINGL 
                    stvdto.Id_srv = emsHeadDO.Emsaplab.Id_srv;
                    stvdto.Id_freq = emsHeadDO.MedSrvDO.Id_freq;
                    stvdto.Id_srvca = emsHeadDO.Emsaplab.Id_srvca;
                    stvdto.Sd_srvtp = emsHeadDO.MedSrvDO.Sd_srvtp;
                    stvdto.Eu_blmd = emsHeadDO.MedSrvDO.Eu_blmd;
                    stvdto.Fg_or = emsHeadDO.MedSrvDO.Fg_or;
                    //stvdto.Quan_med = emsHeadDO.Quan_medu;
                    stvdto.Code_srv = emsHeadDO.MedSrvDO.Code;
                    stvdto.Fg_set = emsHeadDO.MedSrvDO.Fg_set;
                    stvdto.Fg_bl = emsHeadDO.MedSrvDO.Fg_bl;
                    stvdto.Id_srvtp = emsHeadDO.Emsaplab.Id_srvtp;
                    stvdto.Eu_sourcemd = Eu_sourcemd;
                    //stvdto.Quan_med = emsHeadDO.Quan_medu;
                    //stvdto.Id_unit_med = emsHeadDO.Id_medu;

                    // 新增#
                    stvdto.Id_primd = emsHeadDO.MedSrvDO.Id_primd;
                    stvdto.Id_dep = emsHeadDO.Emsaplab.Id_mp_dep;
                    stvdto.Name_dep = emsHeadDO.Emsaplab.Name_mp_dep;
                    stvdto.Id_unit_base = emsHeadDO.Emsaplab.Id_unit_base;
                    stvdto.Name_unit_base = emsHeadDO.Emsaplab.Name_unit_base;
                    stvdto.Quan_base = emsHeadDO.Emsaplab.Quan_base;
                    stvdto.Quan_cur = emsHeadDO.Emsaplab.Quan_cur;
                    stvdto.Id_unit_sale = emsHeadDO.Emsaplab.Id_unit_sale;
                    stvdto.Name_unit_sale = emsHeadDO.Emsaplab.Name_unit_sale;
                    stvdto.Price = emsHeadDO.Emsaplab.Price;
                    stvdto.Fg_indic = emsHeadDO.Emsaplab.Fg_indic;
                    stvdto.Name_srv = emsHeadDO.Emsaplab.Name_srv;
                    stvdto.Id_srv = emsHeadDO.Emsaplab.Id_srv;
                    stvdto.Id_unit_med = emsHeadDO.MedSrvDO.Id_unit_med;//剂量单位 zwq 2016-08-05
                    stvdto.Quan_med = emsHeadDO.MedSrvDO.Quan_med;
                    stvdto.Fg_selfpay = emsHeadDO.Emsaplab.Fg_selfpay;
                    if (emsHeadDO.Emsaplab.Fg_selfpay != null && emsHeadDO.Emsaplab.Fg_selfpay.Value)
                    {
                        stvdto.Fg_hpindicjudged = (int)HpIndicJudgeEnum.SELFPAY;
                    }
                    else
                    {
                        stvdto.Fg_hpindicjudged = null;
                    }
                   list.Add(stvdto);
                }

            foreach (EmsObsLap lab in emsHeadDO.Emsaplab.EmsOrObsList)//检查部位集合
            {
                // 如果部位没有被选中，则不生成服务项目对象
                if (lab.Fg_chk == null || !lab.Fg_chk.Value)
                {
                    continue;
                }
                CiEmsSrvDTO stvdto = new CiEmsSrvDTO();
                CiEmsSrvDTO srvTemp = srvList.FirstOrDefault(p => p.Id_srv == lab.Id_srv);
                if (srvTemp != null)
                {
                    stvdto = srvTemp;
                    stvdto.SetUpdated();
                }
                stvdto.Id_body = lab.Id_body;         //部位	SINGLE	  	 	
                stvdto.Sd_body = lab.Sd_body;	          //部位编码	SINGL 
                stvdto.Id_pos = lab.Id_pos;          //体位	SINGLE	  	 	
                stvdto.Sd_pos = lab.Sd_pos;          //体位编码	SINGL 
                stvdto.Body_name = lab.Name_body;	      //部位名称	SINGL 
                stvdto.Id_srv = lab.Id_srv;
                stvdto.Eu_sourcemd = Eu_sourcemd;
                stvdto.Id_srvca = lab.Id_srvca;
                stvdto.Eu_blmd = lab.Eu_blmd;
                stvdto.Quan_med = lab.Quan_medu;
                stvdto.Id_unit_med = lab.Id_medu;
                stvdto.Id_srvtp = emsHeadDO.Emsaplab.Id_srvtp;
                stvdto.Id_unit_med = lab.Id_medu;
                stvdto.Name_srv = lab.Name_srv;
                stvdto.Id_primd = lab.Id_primd;
                stvdto.Fg_selfpay = emsHeadDO.Emsaplab.Fg_selfpay;
                if (emsHeadDO.Emsaplab.Fg_selfpay != null && emsHeadDO.Emsaplab.Fg_selfpay.Value)
                {
                    stvdto.Fg_hpindicjudged = (int)HpIndicJudgeEnum.SELFPAY;
                }
                else
                {
                    stvdto.Fg_hpindicjudged = null;
                }
                if ((emsHeadDO.MedSrvDO.Fg_set != null && emsHeadDO.MedSrvDO.Fg_set.Value))
                {
                    stvdto.Id_srv_set = emsHeadDO.Emsaplab.Id_srv;
                }
                if (stvdto.IsNEW)
                {
                    if ((emsHeadDO.MedSrvDO.Fg_set != null && emsHeadDO.MedSrvDO.Fg_set.Value))
                    {
                        stvdto.Id_freq = lab.Id_freq;
                        stvdto.Sd_srvtp = lab.Sd_srvtp;
                        stvdto.Id_srv_set = emsHeadDO.Emsaplab.Id_srv;
                        stvdto.Innercode_srvca = emsHeadDO.Emsaplab.Innercode_srvca;
                        // stvdto.Fg_set = true;
                        stvdto.Id_srv = lab.Id_srv;
                        stvdto.Fg_bl = lab.Fg_bl;//zwq  2016-08-22
                    }
                    else
                    {
                        stvdto.Id_freq = emsHeadDO.MedSrvDO.Id_freq;
                        stvdto.Sd_srvtp = emsHeadDO.MedSrvDO.Sd_srvtp;
                        stvdto.Innercode_srvca = emsHeadDO.MedSrvDO.Srvca_innercode;//服务分类内部编码
                        stvdto.Fg_bl = emsHeadDO.MedSrvDO.Fg_bl;//zwq  2016-08-22
                        stvdto.Price = emsHeadDO.Emsaplab.Price;
                        // stvdto.Fg_set = false;
                    }
                    stvdto.Fg_or = emsHeadDO.MedSrvDO.Fg_or;
                    stvdto.Code_srv = emsHeadDO.MedSrvDO.Code;
                    stvdto.Eu_sourcemd = Eu_sourcemd;

                    // 新增#
                    stvdto.Id_primd = lab.Id_primd;
//                     stvdto.Id_dep = emsHeadDO.Emsaplab.Id_mp_dep;
//                     stvdto.Name_dep = emsHeadDO.Emsaplab.Name_mp_dep;
//                     stvdto.Id_unit_base = emsHeadDO.Emsaplab.Id_unit_base;
//                     stvdto.Name_unit_base = emsHeadDO.Emsaplab.Name_unit_base;
//                     stvdto.Quan_base = emsHeadDO.Emsaplab.Quan_base;
//                     stvdto.Id_unit_sale = emsHeadDO.Emsaplab.Id_unit_sale;
//                     stvdto.Name_unit_sale = emsHeadDO.Emsaplab.Name_unit_sale;
                    //stvdto.Price = lab.Price;
//                    stvdto.Fg_indic = lab.Fg_indic;
                }
                stvdto.Quan_cur = cof.getNotDrugTotal();//取得总量 2016-06-28添加 待完善的取值方式
                list.Add(stvdto);
            }
            //处理删除项
            if (emsHeadDO.Emsaplab.EmsOrObsListDel != null && emsHeadDO.Emsaplab.EmsOrObsList.Count > 0)
            {
                foreach (EmsObsLap lab in emsHeadDO.Emsaplab.EmsOrObsListDel)//检查部位集合
                {
                    string id_srv = lab.Id_srv;
                    if (emsHeadDO.Emsaplab.EmsOrObsList.FirstOrDefault(p => p.Id_srv == id_srv&&true==p.Fg_chk) == null)
                    {
                        CiEmsSrvDTO stvdto = new CiEmsSrvDTO();
                        stvdto.Id_orsrv = lab.Id_orsrv;
                        stvdto.Id_srv = lab.Id_srv;
                        stvdto.Id_or = dto.Id_or;
                        stvdto.Id_srv_set = emsHeadDO.Emsaplab.Id_srv;
                        stvdto.SetDeleted();
                        list.Add(stvdto);
                    }
                }
            }
            return list;
        }

        /// <summary>
        ///检查申请单
        /// </summary>
        /// <returns></returns>
        public FMap setOrderAppObs(EmsUIDTO emsHeadDO, CiEmsDTO dto)
        {

            FMap map = new FMap();
            OrdApObsDO obs = new OrdApObsDO();

            if (dto.Orapplysheet != null && dto.Orapplysheet.Keys.Count > 0)
            {
                OrdApObsDO aptem = dto.Orapplysheet[((int) EmsType.RIS).ToString()] as OrdApObsDO;
                if (aptem != null)
                {
                    obs = aptem;
                    obs.SetUpdated();
                    dto.SetUpdated();
                }
            }
            else
            {
                   obs.Str_name_di = emsHeadDO.Str_name_di;
                   obs.Str_code_di = emsHeadDO.Str_code_di;
                   obs.Str_id_diitm = emsHeadDO.Str_id_diitm;
                   obs.Id_diitm = emsHeadDO.Id_diitm;
                  
            }
            //诊断信息拼接
            obs.Name_diag = emsHeadDO.Emsapobs.Name_diag;
            obs.Id_di = emsHeadDO.Emsapobs.Id_di;
            obs.Id_diitm = emsHeadDO.Emsapobs.Id_diitm;
            obs.Str_code_di = emsHeadDO.Emsapobs.Str_code_di;
            obs.Str_name_di = emsHeadDO.Emsapobs.Str_name_di;
            obs.Str_id_diitm = emsHeadDO.Emsapobs.Str_id_diitm;

            obs.No_applyform = emsHeadDO.Emsapobs.No_applyobs;
            obs.Dt_plan = emsHeadDO.Emsapobs.Dt_plan;
            obs.Biopsy = emsHeadDO.Emsapobs.Name_body;
            obs.Fg_urgent = emsHeadDO.Emsapobs.Fg_urgent;
            // 以下注释代码多余
            //if (emsHeadDO.Emsapobs.EmsOrObsList != null && emsHeadDO.Emsapobs.EmsOrObsList.Count > 0)
            //{
            //    obs.Announcements = emsHeadDO.Emsapobs.EmsOrObsList.FirstOrDefault().Announcements;
            //}
            obs.Announcements = emsHeadDO.Emsapobs.Announcements;
            obs.Id_pps = emsHeadDO.Emsapobs.Id_pps;//todo
            obs.Sd_pps = emsHeadDO.Emsapobs.Sd_pps;
            obs.Des_pps = emsHeadDO.Emsapobs.Des_pps;
            obs.Id_su_obs = emsHeadDO.Emsapobs.Id_su_obs;
            obs.Des_sympsign = emsHeadDO.Emsapobs.Des_sympsign;
            //拓展字段
            obs.Def1 = emsHeadDO.Emsapobs.Def1;
            obs.Def2 = emsHeadDO.Emsapobs.Def2;
            obs.Def3 = emsHeadDO.Emsapobs.Def3;
            obs.Def4 = emsHeadDO.Emsapobs.Def4;
            obs.Def5 = emsHeadDO.Emsapobs.Def5;
            obs.Def6 = emsHeadDO.Emsapobs.Def6;
            obs.Def7 = emsHeadDO.Emsapobs.Def7;
            obs.Def8 = emsHeadDO.Emsapobs.Def8;
            obs.Def9 = emsHeadDO.Emsapobs.Def9;
            obs.Def10 = emsHeadDO.Emsapobs.Def10;
            obs.Def11 = emsHeadDO.Emsapobs.Def11;
            obs.Def12 = emsHeadDO.Emsapobs.Def12;
            obs.Def13 = emsHeadDO.Emsapobs.Def13;
            obs.Def14 = emsHeadDO.Emsapobs.Def14;
            obs.Def15 = emsHeadDO.Emsapobs.Def15;
            obs.Def16 = emsHeadDO.Emsapobs.Def16;
            obs.Def17 = emsHeadDO.Emsapobs.Def17;
            obs.Def18 = emsHeadDO.Emsapobs.Def18;
            obs.Def19 = emsHeadDO.Emsapobs.Def19;
            obs.Def20 = emsHeadDO.Emsapobs.Def20;
            obs.Def21 = emsHeadDO.Emsapobs.Def21;
            obs.Def22 = emsHeadDO.Emsapobs.Def22;
            obs.Def23 = emsHeadDO.Emsapobs.Def23;
            obs.Def24 = emsHeadDO.Emsapobs.Def24;
            obs.Def25 = emsHeadDO.Emsapobs.Def25;
            obs.Def26 = emsHeadDO.Emsapobs.Def26;
            obs.Def27 = emsHeadDO.Emsapobs.Def27;
            obs.Def28 = emsHeadDO.Emsapobs.Def28;
            obs.Def29 = emsHeadDO.Emsapobs.Def29;
            obs.Def30 = emsHeadDO.Emsapobs.Def30;
            obs.Clinicalzztz = emsHeadDO.Emsapobs.Clinicalzztz;
            obs.Pastillness = emsHeadDO.Emsapobs.Pastillness;
            obs.Auximtexam = emsHeadDO.Emsapobs.Auximtexam;
            // 
            dto.Fg_mp_bed = emsHeadDO.Emsapobs.Fg_mp_bed;
            dto.Applyno = emsHeadDO.Emsapobs.No_applyobs;
            dto.Fg_urgent = emsHeadDO.Emsapobs.Fg_urgent == null ? false : emsHeadDO.Emsapobs.Fg_urgent;//医嘱的加急标志 2016-07-01张万青
            //dto.Days_or = (emsHeadDO.Emsapobs.Use_days == null || emsHeadDO.Emsapobs.Use_days==0)?1:emsHeadDO.Emsapobs.Use_days;
            //dto.Times_cur = emsHeadDO.MedSrvDO.Freqct * dto.Days_or;// 检查医嘱times_cur 为频次下次数 * 周期数//(int)(emsHeadDO.Emsapobs.Quan_cur == null ? 0 : emsHeadDO.Emsapobs.Quan_cur);
            // 新增医嘱字段匹配 
            dto.Id_unit_med = emsHeadDO.Emsapobs.Id_unit_med;
            dto.Name_unit_med = emsHeadDO.Emsapobs.Name_unit_med;
            dto.Quan_medu = emsHeadDO.Emsapobs.Quan_med;
            dto.Sd_srvtp = emsHeadDO.MedSrvDO.Sd_srvtp;
            dto.Id_srvtp = emsHeadDO.MedSrvDO.Id_srvtp;
            dto.Innercode_srvca = emsHeadDO.MedSrvDO.Srvca_innercode;//服务分类内部编码

            dto.Id_dep_mp = emsHeadDO.Emsapobs.Id_mp_dep;//执行科室id 2016-08-02 zwq
            dto.Name_dep_mp = emsHeadDO.Emsapobs.Name_mp_dep;//执行科室 2016-08-02 zwq
            //dto.Note = emsHeadDO.Emsapobs.Des_sympsign;//医嘱的描述内容，医嘱中也存储一份 2016-08-03 zwq 2017-1-20病情描述不保存到备注中，只有表单中配置备注项des_or才进行保存
            dto.Dt_begin = emsHeadDO.Emsapobs.Dt_plan;
            dto.Dt_end = emsHeadDO.Emsapobs.Dt_end_ui;
            dto.Name_freq = emsHeadDO.Emsapobs.Name_freq;
            dto.Days_or = emsHeadDO.Emsapobs.Use_days;
            if (dto.Days_or != null)
            {
                dto.Dt_end = ((DateTime)dto.Dt_begin).AddDays((int)dto.Days_or);
            }
            dto.Times_cur = emsHeadDO.Emsapobs.Times_cur;          //在院执行标识	SINGLE	 	 	 	 	
            dto.Times_mp_in = emsHeadDO.Emsdrugs.Times_mp_in;      //在院执行次数
            if (obs.IsNEW)  
            {
                obs.Id_su_obs = CiDictCodeConst.ID_CI_OBS_SQ;//TODO: 取sd字段
                obs.Sd_su_obs = CiDictCodeConst.SD_CI_LAB_SQ;
                dto.Orapplysheet.Add(((int)EmsType.RIS).ToString(), obs);
            }

            return map;
        }

        /// <summary>
        /// 检查的项目
        /// </summary>
        /// <param name="dto">The dto.</param>
        /// <param name="emsHeadDO">The ems head do.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-12-03
        public FArrayList SaveEmsApObsItem(EmsUIDTO emsHeadDO, CiEmsDTO dto, int Eu_sourcemd)
        {
            FArrayList list = new FArrayList();
            List<CiEmsSrvDTO> srvList = new List<CiEmsSrvDTO>();
            //dto.Dt_begin = emsHeadDO.Emsapobs.Dt_plan;
            //dto.Note = emsHeadDO.Emsapobs.Des_sympsign; 备注信息只有当表单中有des_or才进行保存，病情描述、临床特征等信息不进行互相赋值2017-1-20 hums
            CiEmsSrvDTO stvdto = new CiEmsSrvDTO();
            if (dto.Emssrvs != null && dto.Emssrvs.Count > 0)
            {
                foreach (CiEmsSrvDTO item in dto.Emssrvs)
                {
                    srvList.Add(item);
                  
                }
                
            }
            if (emsHeadDO.MedSrvDO.Fg_set != null && (bool)emsHeadDO.MedSrvDO.Fg_set)
            {
                stvdto.Fg_or = true;
                stvdto.Id_body = emsHeadDO.Emsapobs.Id_body;         //部位	SINGLE	  	 	
                stvdto.Sd_body = emsHeadDO.Emsapobs.Sd_body;	          //部位编码	SINGL 
                stvdto.Id_pos = emsHeadDO.Emsapobs.Id_pos;          //体位	SINGLE	  	 	
                stvdto.Sd_pos = emsHeadDO.Emsapobs.Sd_pos;          //体位编码	SINGL 
                stvdto.Body_name = emsHeadDO.Emsapobs.Name_body;	      //部位名称	SINGL 
                stvdto.Id_srv = emsHeadDO.Emsapobs.Id_srv;
                stvdto.Fg_selfpay = emsHeadDO.Emsapobs.Fg_selfpay;
                if (emsHeadDO.Emsapobs.Fg_selfpay!=null && emsHeadDO.Emsapobs.Fg_selfpay.Value)
                {
                    stvdto.Fg_hpindicjudged = (int)HpIndicJudgeEnum.SELFPAY;
                }
                else
                {
                    stvdto.Fg_hpindicjudged = null;
                }
                stvdto.Id_dep = dto.Id_dep_mp;
                stvdto.Fg_set = emsHeadDO.MedSrvDO.Fg_set;
                // 将medsrvDo部分属性赋值给CiEmsSrvDTO对象
                this.setMedsrvProperty(stvdto, emsHeadDO.MedSrvDO);

                stvdto.Eu_sourcemd = Eu_sourcemd;
                stvdto.Des_srv = emsHeadDO.Emsapobs.Announcements;
                stvdto.Name_srv = emsHeadDO.Emsapobs.Name_srv;

                // 新增#
                stvdto.Id_dep = emsHeadDO.Emsapobs.Id_mp_dep;
                stvdto.Name_dep = emsHeadDO.Emsapobs.Name_mp_dep;
                stvdto.Id_unit_base = emsHeadDO.Emsapobs.Id_unit_base;
                stvdto.Name_unit_base = emsHeadDO.Emsapobs.Name_unit_base;
                stvdto.Quan_base = emsHeadDO.Emsapobs.Quan_base;
                stvdto.Id_unit_sale = emsHeadDO.Emsapobs.Id_unit_sale;
                stvdto.Name_unit_sale = emsHeadDO.Emsapobs.Name_unit_sale;
                stvdto.Price = emsHeadDO.Emsapobs.Price;
                stvdto.Fg_indic = emsHeadDO.Emsapobs.Fg_indic;
                stvdto.Id_unit_med = emsHeadDO.MedSrvDO.Id_unit_med;//剂量单位 zwq 2016-08-05
                list.Add(stvdto);
                foreach (EmsObsLap lab in emsHeadDO.Emsapobs.EmsOrObsList)//检查部位集合
                {
                    // 如果部位没有被选中，则不生成服务项目对象
                    if (lab.Fg_chk == null || !lab.Fg_chk.Value) {
                        continue;
                    }

                    stvdto = new CiEmsSrvDTO();
                    CiEmsSrvDTO srvTemp = srvList.FirstOrDefault(p => p.Id_srv == lab.Id_srv);
                    if (srvTemp != null)
                    {
                        stvdto = srvTemp;
                        stvdto.SetUpdated();
                        stvdto.Id_srvca = lab.Id_srvca;
                        stvdto.Sd_srvtp = lab.Sd_srvtp;
                        stvdto.Id_srvtp = lab.Id_srvtp;
                        stvdto.Id_freq = lab.Id_freq;
                        stvdto.Quan_med = lab.Quan_medu;
                        stvdto.Id_unit_med = lab.Id_medu;
                        stvdto.Id_body = lab.Id_body;         //部位	SINGLE	  	 	
                        stvdto.Sd_body = lab.Sd_body;	          //部位编码	SINGL 
                        stvdto.Id_pos = lab.Id_pos;          //体位	SINGLE	  	 	
                        stvdto.Sd_pos = lab.Sd_pos;          //体位编码	SINGL 
                        stvdto.Body_name = lab.Name_body;	      //部位名称	SINGL 
                        stvdto.Fg_bl = lab.Fg_bl;//zwq 2016-08-17
                        stvdto.Fg_or = lab.Fg_or;
                        stvdto.Id_srv_set = emsHeadDO.Emsapobs.Id_srv;
                        if (dto.Srvsetitms != null)
                        {
                            OrdSrvSetDO ordsrvsetdo = (dto.Srvsetitms[dto.Id_srv] as FArrayList).ToArray().FirstOrDefault(p => (p as OrdSrvSetDO).Id_srvset == lab.Id_srv) as OrdSrvSetDO;
                            if (dto.Srvsetitms == null || ordsrvsetdo == null)
                            {
                                stvdto.Status = DOStatus.NEW;
                            }
                            else
                            {
                                stvdto.Status = emsHeadDO.Status;
                            }
                        }
                        list.Add(stvdto);
                    }
                    else
                    {
                        stvdto.Id_body = lab.Id_body;         //部位	SINGLE	  	 	
                        stvdto.Sd_body = lab.Sd_body;	          //部位编码	SINGL 
                        stvdto.Id_pos = lab.Id_pos;          //体位	SINGLE	  	 	
                        stvdto.Sd_pos = lab.Sd_pos;          //体位编码	SINGL 
                        stvdto.Body_name = lab.Name_body;	      //部位名称	SINGL 
                        stvdto.Id_srv = lab.Id_srv;
                        stvdto.Id_srvca = lab.Id_srvca;
                        stvdto.Sd_srvtp = lab.Sd_srvtp;
                        stvdto.Code_srv = lab.Code_srv;
                        stvdto.Id_srvtp = lab.Id_srvtp;
                        stvdto.Id_freq = lab.Id_freq;
                        stvdto.Quan_med = lab.Quan_medu;
                        stvdto.Id_unit_med = lab.Id_medu;
                        stvdto.Fg_bl = lab.Fg_bl;//zwq 2016-08-17
                        // 将medsrvDo部分属性赋值给CiEmsSrvDTO对象
                        stvdto.Fg_or = lab.Fg_or;
                        stvdto.Id_srv_set = emsHeadDO.Emsapobs.Id_srv;
                        //this.setMedsrvProperty(stvdto, emsHeadDO.MedSrvDO);
                        if (dto.Srvsetitms != null && dto.Srvsetitms[dto.Id_srv]!=null)
                        {
                            object ordsrvsetdo = (dto.Srvsetitms[dto.Id_srv] as FArrayList).ToArray().FirstOrDefault(p => (p as OrdSrvSetDO).Id_srvset == lab.Id_srv);
                            if (ordsrvsetdo == null)
                            {
                                stvdto.Status = DOStatus.NEW;
                            }
                            else
                            {
                                stvdto.Status = emsHeadDO.Status;
                            }
                        }
                        stvdto.Price = emsHeadDO.Emsapobs.Price;
                        list.Add(stvdto);
                    }
                    stvdto.Id_primd = lab.Id_primd;
                    stvdto.Quan_cur = cof.getNotDrugTotal();//取得总量 2016-06-28添加 待完善的取值方式
                    stvdto.Name_srv = lab.Name_srv;
                    stvdto.Eu_sourcemd = Eu_sourcemd;
                    stvdto.Fg_selfpay = emsHeadDO.Emsapobs.Fg_selfpay;
                    if (emsHeadDO.Emsapobs.Fg_selfpay!=null && emsHeadDO.Emsapobs.Fg_selfpay.Value)
                    {
                        stvdto.Fg_hpindicjudged = (int)HpIndicJudgeEnum.SELFPAY;
                    }
                    else
                    {
                        stvdto.Fg_hpindicjudged = null;
                    }
                    if (emsHeadDO.MedSrvDO.Fg_set != null && (bool)emsHeadDO.MedSrvDO.Fg_set)
                    {
                        stvdto.Id_srv_set = emsHeadDO.MedSrvDO.Id_srv;
                    }
                }
            }
            else {
                EmsObsLap lab = emsHeadDO.Emsapobs.EmsOrObsList[0];
                CiEmsSrvDTO srvTemp = srvList.FirstOrDefault(p => p.Id_srv == lab.Id_srv);
                if (srvTemp != null)
                {
                    stvdto = srvTemp;
                    stvdto.SetUpdated();
                    stvdto.Id_dep = dto.Id_dep_mp;
                    stvdto.Id_srvca = lab.Id_srvca;
                    stvdto.Sd_srvtp = lab.Sd_srvtp;
                    stvdto.Id_srvtp = lab.Id_srvtp;
                    stvdto.Id_freq = lab.Id_freq;
                    stvdto.Quan_med = lab.Quan_medu;
                    stvdto.Id_unit_med = lab.Id_medu;
                    stvdto.Id_body = lab.Id_body;         //部位	SINGLE	  	 	
                    stvdto.Sd_body = lab.Sd_body;	          //部位编码	SINGL 
                    stvdto.Id_pos = lab.Id_pos;          //体位	SINGLE	  	 	
                    stvdto.Sd_pos = lab.Sd_pos;          //体位编码	SINGL 
                    
                    stvdto.Body_name = lab.Name_body;	      //部位名称	SINGL 
                    
                }
                else
                {
                    stvdto.Id_dep = dto.Id_dep_mp;
                    stvdto.Id_body = lab.Id_body;         //部位	SINGLE	  	 	
                    stvdto.Sd_body = lab.Sd_body;	          //部位编码	SINGL 
                    stvdto.Id_pos = lab.Id_pos;          //体位	SINGLE	  	 	
                    stvdto.Sd_pos = lab.Sd_pos;          //体位编码	SINGL 
                    stvdto.Body_name = lab.Name_body;	      //部位名称	SINGL 
                    stvdto.Id_srv = lab.Id_srv;
                    stvdto.Id_srvca = lab.Id_srvca;
                    stvdto.Sd_srvtp = lab.Sd_srvtp;
                    stvdto.Id_srvtp = lab.Id_srvtp;
                    stvdto.Id_freq = lab.Id_freq;
                    stvdto.Quan_med = lab.Quan_medu;
                    stvdto.Id_unit_med = lab.Id_medu;
                    stvdto.Fg_bl = lab.Fg_bl;//zwq 2016-08-17
                    // 将medsrvDo部分属性赋值给CiEmsSrvDTO对象
                    this.setMedsrvProperty(stvdto, emsHeadDO.MedSrvDO);

                    stvdto.Price = emsHeadDO.Emsapobs.Price;
                }
                stvdto.Id_primd = lab.Id_primd;
                //stvdto.Quan_cur = cof.getNotDrugTotal();//取得总量 2016-06-28添加 待完善的取值方式
                stvdto.Name_srv = lab.Name_srv;
                stvdto.Eu_sourcemd = Eu_sourcemd;
                stvdto.Fg_selfpay = emsHeadDO.Emsapobs.Fg_selfpay;
                if (emsHeadDO.Emsapobs.Fg_selfpay != null && emsHeadDO.Emsapobs.Fg_selfpay.Value)
                {
                    stvdto.Fg_hpindicjudged = (int)HpIndicJudgeEnum.SELFPAY;
                }
                else
                {
                    stvdto.Fg_hpindicjudged = null;
                }
                if (dto.Srvsetitms != null && dto.Srvsetitms[dto.Id_srv] != null)
                {
                    object ordsrvsetdo = (dto.Srvsetitms[dto.Id_srv] as FArrayList).ToArray().FirstOrDefault(p => (p as OrdSrvSetDO).Id_srvset == lab.Id_srv);
                    if (ordsrvsetdo == null)
                    {
                        stvdto.Status = DOStatus.NEW;
                    }
                    else
                    {
                        stvdto.Status = emsHeadDO.Status;
                    }
                }
                list.Add(stvdto);
            }

            //处理删除项 将删除项也放到CiEmsDTO.Emssrvs 中，传递到后台对删除状态的服务进行删除
            if (emsHeadDO.Emsapobs.EmsOrObsListDel != null && emsHeadDO.Emsapobs.EmsOrObsList.Count > 0)
            {
                foreach (EmsObsLap lab in emsHeadDO.Emsapobs.EmsOrObsListDel)//检查部位集合
                {
                    string id_srv = lab.Id_srv;
                    if (emsHeadDO.Emsapobs.EmsOrObsList.FirstOrDefault(p => p.Id_srv == id_srv && true == p.Fg_chk) == null) {
                        // 医嘱复制，助手打开的多医疗单，取消套内项目还未保存到数据库，取消勾选时不需要设置删除状态
                        if (string.IsNullOrEmpty(dto.Id_or))
                        {
                            continue;
                        }
                        stvdto = new CiEmsSrvDTO();
                        stvdto.Id_body = lab.Id_body;         //部位	SINGLE	  	 	
                        stvdto.Sd_body = lab.Sd_body;	          //部位编码	SINGL 
                        stvdto.Id_pos = lab.Id_pos;          //体位	SINGLE	  	 	
                        stvdto.Sd_pos = lab.Sd_pos;          //体位编码	SINGL 
                        stvdto.Body_name = lab.Name_body;	      //部位名称	SINGL 
                        stvdto.Id_srv = lab.Id_srv;
                        stvdto.Eu_blmd = emsHeadDO.MedSrvDO.Eu_blmd;
                        stvdto.Fg_or = lab.Fg_or;
                        stvdto.Code_srv = lab.Code_srv;
                        stvdto.Fg_bl = lab.Fg_bl;
                        stvdto.Id_srvca = lab.Id_srvca;
                        stvdto.Sd_srvtp = lab.Sd_srvtp;
                        stvdto.Id_srvtp = lab.Id_srvtp;
                        stvdto.Id_freq = lab.Id_freq;
                        stvdto.Quan_med = lab.Quan_medu;
                        stvdto.Id_unit_med = lab.Id_medu;
                        stvdto.Id_srv_set = emsHeadDO.MedSrvDO.Id_srv;
                        stvdto.Id_or = dto.Id_or;
                        stvdto.Id_orsrv = lab.Id_orsrv;
                        stvdto.SetDeleted();
                        list.Add(stvdto);
                    }
                }
            }
            return list;
        }

        /// <summary>
        /// 将 MedSrvDO部分属性赋值给CiEmsSrvDTO
        /// </summary>
        /// <param name="srvdto"></param>
        /// <param name="medSrvDO"></param>
        private void setMedsrvProperty(CiEmsSrvDTO srvdto, MedSrvDO medSrvDO)
        {

            //stvdto.Id_srv_set = emsHeadDO.MedSrvDO.Id_srvrt;
            srvdto.Id_freq = medSrvDO.Id_freq;
            srvdto.Id_srvca = medSrvDO.Id_srvca;
            srvdto.Sd_srvtp = medSrvDO.Sd_srvtp;
            srvdto.Eu_blmd = medSrvDO.Eu_blmd;
            srvdto.Fg_or = medSrvDO.Fg_or;
            srvdto.Code_srv = medSrvDO.Code;
            srvdto.Fg_bl = medSrvDO.Fg_bl;
            srvdto.Id_srvtp = medSrvDO.Id_srvtp;
            srvdto.Quan_med = medSrvDO.Quan_med;
            srvdto.Id_unit_med = medSrvDO.Id_unit_med;
            srvdto.Innercode_srvca = medSrvDO.Srvca_innercode;//服务分类内部编码
            srvdto.Id_primd = medSrvDO.Id_primd;
        }


        #endregion 保存数据转换


        #region 编辑 检验数据转换

        public void EditApLab(CiEmsDTO dto, EmsUIDTO emsheadDO)
        {
            CiEmsSrvDTO srv = dto.Emssrvs[0] as CiEmsSrvDTO;
            //emsheadDO.Emsaplab.Id_emsobs	//检查申请单主键	SINGLE	String	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsheadDO.Emsaplab.Id_orsrv = srv.Id_orsrv;	//医嘱服务id	SINGLE	FID	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsheadDO.Emsaplab.Id_or = srv.Id_or;	    //医嘱医疗单	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsheadDO.Emsaplab.Id_srv = srv.Id_srv;	    //服务id	SINGLE	String	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsheadDO.Emsaplab.Name_srv = srv.Name_srv;	//服务名称	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsheadDO.Emsaplab.Id_srvtp = srv.Id_srvtp;	//服务类型	SINGLE	String	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //emsheadDO.Emsaplab.Name_srvtp=	//服务类型名称	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //emsheadDO.Emsaplab.Id_obstp	//检查类型id	REF	检查类型_自定义档案	20	检查类型_自定义档案	 				 	 	 	 	 	 				 	 			 	 	 	
            //emsheadDO.Emsaplab.Name_obstp	//检查类型名称	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //emsheadDO.Emsaplab.No_applyobs	//检查申请单号	SINGLE	String	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //emsheadDO.Emsaplab.Fg_urgent	//加急标识	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //emsheadDO.Emsaplab.Fg_mp_bed	//床旁执行标志	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //emsheadDO.Emsaplab.Dt_begin_ui	//计划检查时间	SINGLE	FDateTime	19	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //emsheadDO.Emsaplab.Id_di	      //诊断id	REF	医疗服务_疾病诊断定义	20	疾病诊断	 				 	 	 	 	 	 				 	 			 	 	 	
            //emsheadDO.Emsaplab.Name_di	      //诊断	SINGLE	String	100	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //emsheadDO.Emsaplab.Id_dis	      //诊断字符串拼接	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //emsheadDO.Emsaplab.Name_dis	  //诊断名称拼接	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //emsheadDO.Emsaplab.Sd_pps	      //检查目的编码	SINGLE	String	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //emsheadDO.Emsaplab.Des_pps	      //检查目的描述	SINGLE	String	100	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //emsheadDO.Emsaplab.Des_sympsign	//症状体征描述	SINGLE	String	500	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsheadDO.Emsaplab.Id_body = srv.Id_body;	         //身体部位id	REF	部位编码_自定义档案	20	部位编码_自定义档案	 				 	 	 	 	 	 				 	 			 	 	 	
            emsheadDO.Emsaplab.Sd_body = srv.Sd_body;         //身体部位编码	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //emsheadDO.Emsaplab.Name_body=srv	       //身体部位名称	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsheadDO.Emsaplab.Id_pos = srv.Id_pos;	         //身体体位id	REF	体位编码_自定义档案	20	体位编码_自定义档案	 				 	 	 	 	 	 				 	 			 	 	 	
            emsheadDO.Emsaplab.Sd_pos = srv.Sd_pos;	         //身体体位编码	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            ////emsheadDO.Emsaplab.Name_pos=srv.	     //身体体位名称	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //emsheadDO.Emsaplab.Id_samptp=	     //标本类型id	REF	标本类型_自定义档案	20	标本类型_自定义档案	 				 	 	 	 	 	 				 	 			 	 	 	
            //emsheadDO.Emsaplab.Name_samptp	     //标本类型名称	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //emsheadDO.Emsaplab.Sd_samptp	     //标本类型编码	SINGLE	String	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
            emsheadDO.Emsaplab.Sortno = srv.Sortno;	         //序号	SINGLE	Integer	10	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //emsheadDO.Emsaplab.Fg_chk	         //选择	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //emsheadDO.Emsaplab.Announcements	//注意事项	SINGLE	备注	300	 	 				 	 	 	 	 	 				 	 			 	 	 	
            //emsheadDO.Emsaplab.Sv	            //版本号

        }
        /// <summary>
        /// Edits检验检查单 项目
        /// </summary>
        /// <param name="dto">The dto.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-12-03
        public XapDataList<EmsObsLap> EditApLabItem(CiEmsDTO dto)
        {
            XapDataList<EmsObsLap> list = new XapDataList<EmsObsLap>();


            foreach (CiEmsSrvDTO srv in dto.Emssrvs)
            {
                if (srv.Id_mm == null)
                    continue;
                EmsObsLap lab = new EmsObsLap();
                //lab.Id	 	    //SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
                lab.Sd_body = srv.Sd_body;   	//部位编码	REF	部位编码_自定义档案	20	部位编码_自定义档案	 
                lab.Id_body = srv.Id_body;	    //部位id	SINGLE	String				 	 	 	 	 	 				 	 			 	 	 	
                //lab.Name_body=srv.na	//部位名称	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
                lab.Sd_pos = srv.Sd_pos;	    //体位编码	REF	体位编码_自定义档案	20	体位编码_自定义档案	 	
                lab.Id_pos = srv.Id_pos;	    //体位id	SINGLE	String	50			 	 	 	 	 	 				 	 			 	 	 	
                //lab.Name_pos=s	//体位名称	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
                //lab.If_mp_bed	//是否可床边执行	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
                lab.Id_srv = srv.Id_srv;    //检验编码	REF	医疗服务	20	医疗服务	 				 	 	 	 	 	 				 	 			 	 	 	
                lab.Name_srv = srv.Name_srv;	//检验名称	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
                //lab.Sortno=srv.Sortno;	    //序号	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
                	 	 				 	 	 	 	 	 				 	 			 	 	 	
                list.Add(lab);
            }

            return list;
        }

        #endregion 编辑 检验数据转换
                

        /// <summary>
        /// 套 
        /// </summary>
        /// <param name="emsHeadDO"></param>
        /// <param name="Eu_sourcemd"></param>
        /// <returns></returns>
        private CiEmsSrvDTO getCiEmsSrvDTO(EmsUIDTO emsHeadDO, int Eu_sourcemd)
        {
             CiEmsSrvDTO stvdto = new CiEmsSrvDTO();
             stvdto.Id_srv_set = emsHeadDO.MedSrvDO.Id_srv;
             stvdto.Fg_set = emsHeadDO.MedSrvDO.Fg_set;
             stvdto.Id_srv = emsHeadDO.MedSrvDO.Id_srv;
             stvdto.Fg_set = emsHeadDO.MedSrvDO.Fg_set;
             stvdto.Id_freq = emsHeadDO.MedSrvDO.Id_freq;
             stvdto.Id_srvca = emsHeadDO.MedSrvDO.Id_srvca;
             stvdto.Sd_srvtp = emsHeadDO.MedSrvDO.Sd_srvtp;
             stvdto.Eu_blmd = emsHeadDO.MedSrvDO.Eu_blmd;
             stvdto.Fg_or = emsHeadDO.MedSrvDO.Fg_or;
             stvdto.Code_srv = emsHeadDO.MedSrvDO.Code;
             stvdto.Fg_bl = emsHeadDO.MedSrvDO.Fg_bl;
             stvdto.Id_srvtp = emsHeadDO.MedSrvDO.Id_srvtp;
             stvdto.Quan_med = emsHeadDO.MedSrvDO.Quan_med;
             stvdto.Id_unit_med = emsHeadDO.MedSrvDO.Id_unit_med;
             stvdto.Eu_sourcemd = Eu_sourcemd;
             stvdto.Des_srv = emsHeadDO.Emsapobs.Announcements;
             stvdto.Name_srv = emsHeadDO.Emsapobs.Name_srv;
            return stvdto;
        }
        public void getCommonOrdSetItemSrv(CiEmsDTO dto, CiEmsSrvDTO srvCommon, EmsUIDTO emsHeadDO, int Eu_sourcemd)
        {
            FArrayList Emssrvs = new FArrayList();
            srvCommon.Quan_total_medu = emsHeadDO.Emsdrugs.Quan_cur;
            Emssrvs.Add(srvCommon);
            GetMedSrvImpl medSrvImpl = new GetMedSrvImpl();
            IMeterialMDORService service = XapServiceMgr.find<IMeterialMDORService>();
            MedsrvAggDO medsrvagg = medSrvImpl.getMedSrvAggDOfindById(emsHeadDO.Emsdrugs.Id_srv);
            if (medsrvagg != null)
            {
                MedSrvDO aggParent = medsrvagg.getParentDO();
                MedSrvSetItemDO[] medSrvSetItems = medsrvagg.getMedSrvSetItemDO();
                List<MedSrvSetItemDO> list = new List<MedSrvSetItemDO>();
                for(int i=0;i<medSrvSetItems.Length;i++){
                    if (medSrvSetItems[i].Fg_clinical != null && (bool)(medSrvSetItems[i].Fg_clinical) == true && medSrvSetItems[i].Ds == 0 && medSrvSetItems[i].Fg_active != null && (bool)(medSrvSetItems[i].Fg_active) == true) {
                        list.Add(medSrvSetItems[i]);
                    }
                }
                MedsrvAggDO[] medsrvaggs = medSrvImpl.getMedSrvDO(list);
                foreach(MedsrvAggDO agg in medsrvaggs)
                {
                     MedSrvDO medsrv = agg.getParentDO();
                     CiEmsSrvDTO stvdto = new CiEmsSrvDTO();
                     stvdto.Id_srv_set = emsHeadDO.Emsdrugs.Id_srv;
                     stvdto.Fg_set = medsrv.Fg_set;
                     stvdto.Id_srv = medsrv.Id_srv;
                     stvdto.Id_freq = aggParent.Id_freq;//使用套本身的频次
                     stvdto.Id_srvca = medsrv.Id_srvca;
                     stvdto.Sd_srvtp = medsrv.Sd_srvtp;
                     stvdto.Eu_blmd = medsrv.Eu_blmd;
                     stvdto.Fg_mm = medsrv.Fg_mm;
                     stvdto.Code_srv = medsrv.Code;
                     stvdto.Fg_bl = medsrv.Fg_bl;
                     stvdto.Id_srvtp = medsrv.Id_srvtp;
                     stvdto.Quan_med = medsrv.Quan_med;
                     stvdto.Id_unit_med = medsrv.Id_unit_med;
                     stvdto.Id_route = medsrv.Id_route;
                     stvdto.Eu_sourcemd = Eu_sourcemd;
                     stvdto.Des_srv = emsHeadDO.Emsapobs.Announcements;
                     stvdto.Fg_or = true;
                     stvdto.Id_primd = medsrv.Id_primd;
                     stvdto.Name_srv = medsrv.Name;
                     if (stvdto.Fg_mm != null && stvdto.Fg_mm == true) {
                         MeterialDO[] mms = service.find(string.Format("id_srv='{0}' and fg_active='Y' and ds=0 ",stvdto.Id_srv), "",false);
                         if (mms != null && mms.Length > 0) {
                             stvdto.Id_mm = mms[0].Id_mm;
                             IMaterialBaseInfoService meterialBaseService = XapServiceMgr.find<IMaterialBaseInfoService>();
                             MaterialUnitDTO[] materUnit = meterialBaseService.getMMunitByEntp(new string[]{mms[0].Id_mm}, dto.Code_entp);
                             if (materUnit != null && materUnit.Length > 0)
                             {
                                 stvdto.Id_unit_sale = materUnit[0].Id_measdoc;
                             }
                             else {
                                 stvdto.Id_unit_sale = mms[0].Id_unit_pkgsp;
                             }
                             stvdto.Name_mm = mms[0].Name;
                             stvdto.Id_unit_base = mms[0].Id_unit_pkgbase;
                             
                             stvdto.Code_mm = mms[0].Code;
                             stvdto.Factor_mb = mms[0].Factor_mb;
                             stvdto.Factor_cb = mms[0].Factor_sb;
                             stvdto.Id_val = mms[0].Id_val;
                             stvdto.Sd_val = mms[0].Sd_val;
                             stvdto.Id_mmtp = mms[0].Id_mmtp;
                             stvdto.Sd_mmtp = mms[0].Sd_mmtp;
                             if (dto.Code_entp == EnDictCodeConst.SD_ENTP_INPATIENT)
                             {
                                 stvdto.Sd_roundmd = mms[0].Id_mupkgutp;
                             }
                             else if (dto.Code_entp == EnDictCodeConst.SD_ENTP_OUTPATIENT) {
                                 stvdto.Sd_roundmd = mms[0].Sd_opmutp;
                             }
                             stvdto.Fg_skintest = false;
                             stvdto.Sd_pois = agg.getMedSrvDrugDO()[0].Sd_pois;
                         }
                     }
                    if(dto.Emssrvs!=null){
                        CiEmsSrvDTO ciemsSrvDTO = dto.Emssrvs.Cast<CiEmsSrvDTO>().FirstOrDefault(p => p.Id_srv == stvdto.Id_srv);
                        if (ciemsSrvDTO != null)
                        {
                            stvdto.Id_orsrv = ciemsSrvDTO.Id_orsrv;
                        }  
                    }
                     
                     if (dto.Status != DOStatus.NEW) {
                         stvdto.Status = DOStatus.UNCHANGED;
                     }
                     Emssrvs.Add(stvdto);
                }
            }
            dto.Emssrvs = Emssrvs;
        }

        public void setCiEmsSrvDTOCommon(EmsUIDTO emsHeadDO, CiEmsDTO dto, int Eu_sourcemd)
        {
            if (emsHeadDO != null && dto != null)
            { //id_srvca,id_srvtp,sd_srvtp,id_srv,code_srv,eu_blmd,fg_mm,fg_set,id_primd,fg_selfsrv,fg_bl='Y'(组合与不计费时为N)

                foreach (CiEmsSrvDTO item in dto.Emssrvs)
                {
                    if (emsHeadDO.MedSrvDO.Fg_set != null && !emsHeadDO.MedSrvDO.Fg_set.Value && item.Id_orsrv == null)
                    {
                        if (string.IsNullOrEmpty(item.Id_srvtp)) {
                            item.Id_srvca = emsHeadDO.MedSrvDO.Id_srvca;
                            item.Id_srvtp = emsHeadDO.MedSrvDO.Id_srvtp;
                            item.Sd_srvtp = emsHeadDO.MedSrvDO.Sd_srvtp;
                        }
                        item.Eu_blmd = emsHeadDO.MedSrvDO.Eu_blmd;
                        //item.Fg_mm = emsHeadDO.MedSrvDO.Fg_mm;//张万青 2016-06-30 每个服务项目的物品属性不同
                        //item.Fg_selfsrv = emsHeadDO.MedSrvDO.Fg_ctm;张万青 2016-07-06 每个服务项目的自定义服务属性不同
                        item.Id_primd = string.IsNullOrEmpty(item.Id_primd) ? emsHeadDO.MedSrvDO.Id_primd : item.Id_primd;//0001AA100000000815Q1 组合模式

                        if (emsHeadDO.MedSrvDO.Id_primd == BdPrimdCodeConst.ID_PRI_SRV_COMP)
                        {
                            item.Fg_bl = false;
                        }
                        //else
                        //{
                        //    item.Fg_bl = true;
                        //}

                        item.Fg_or = true;
                    }
                    //设置服务项目的主医保计划 zwq 2016-07013
                    item.Id_hp = emsHeadDO.PatInfo.Id_hp;
                    //非药品的医保信息填充
                    if (item.Sd_srvtp!=null&&!item.Sd_srvtp.StartsWith("01") && !string.IsNullOrEmpty(emsHeadDO.PatInfo.Id_hp))
                    {
                        item.Id_hp = emsHeadDO.PatInfo.Id_hp;
                        //item.Fg_selfpay = false;
                    }
                    if (item.Fg_hpindicjudged != null && item.Fg_hpindicjudged == (int)HpIndicJudgeEnum.SELFPAY)
                    {
                        dto.Eu_hpindicjudge = (int)HpIndicJudgeEnum.SELFPAY;
                    }
                }
            }


        }
        //private int? judgeHpindicjudg(EmsOrDrug drug) {
        //    FArrayList list = drug.BdHpIndicationDTO;
        //    if (list == null || list.Count == 0) return 0;
        //    return 2;
        //}
    }
}
