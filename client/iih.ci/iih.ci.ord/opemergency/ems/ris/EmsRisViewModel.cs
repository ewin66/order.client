using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.en.pv.dto.d;
using xap.rui.appfw;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ems.d;
using iih.ci.ord.ciorder.d;
using iih.bd.srv.medsrv.d;
using iih.ci.ord.opemergency.ems.common;
using iih.bd.bc.udi;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.mw.serviceframework;
using iih.ci.mr.mrdocrefvalue.i;
using iih.ci.mr.mrdocrefvalue.d;
using xap.sys.xbd.udi.d;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.ci.ord.emsdi.d;
using iih.ci.ord.opemergency.tool;
using xap.mw.core.data;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.dto.emsmain;
using iih.ci.ord.i;
using iih.ci.ord.common.utils;
using xap.rui.control.extentions;
using iih.bd.srv.medsrv.i;
using iih.ci.ord.opemergency.declare;
using xap.mw.core.utils;
using xap.mw.coreitf.d;
using iih.bd.srv.ems.d;
using iih.ci.iih.ci.ord.i;

namespace iih.ci.ord.opemergency.ems.dp
{
    /// <summary>
    /// <para>描    述 : 检查数据处理模型                </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.ems.dp  </para>    
    /// <para>类 名 称 : ApobsModelDP                    </para> 
    /// <para>版 本 号 : v1.0.0.0                        </para> 
    /// <para>作    者 : qzwang                           </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05              </para>
    /// <para>修 改 人 :                                  </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05             </para> 
    /// <para>说    明 :                     </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    class EmsRisViewModel : BaseEmsViewModel
    {
        #region 变量
        String strID_Dep_Mps = "";
        #endregion

        #region 构造函数
        public EmsRisViewModel(Ent4BannerDTO ent)
            : base(ent)
        {

        }

        public override void Init()
        {
            base.Init();

            this.uiEmsDTO.EmsType = EmsType.RIS;
        }

        public override void ClearTableDataSource()
        {
            (GetTableDataSource() as XapDataList<EmsOrDrug>).Clear();
        }

        public override bool IsEmpty()
        {
            return this.uiEmsDTO.Emsapobs.EmsOrDrugList == null ||
                this.uiEmsDTO.Emsapobs.EmsOrDrugList.Count == 0 ||
                (this.uiEmsDTO.Emsapobs.EmsOrDrugList.Count == 1 && String.IsNullOrEmpty(this.uiEmsDTO.Emsapobs.EmsOrDrugList[0].Id_srv));
        }

        public bool checkRadio()
        {
            return (this.uiEmsDTO.Emsapobs.EmsOrDrugList != null &&
                this.uiEmsDTO.Emsapobs.EmsOrDrugList.Count > 0 &&
                this.uiEmsDTO.Emsapobs.EmsOrDrugList[0].Fg_setradio == FBoolean.True) ? true : false;
        }

        public void ReCalcPriceInfo(EmsOrDrug risDrug)
        {
            if (risDrug != null)
            {
                this.DefaultPriceInfo(risDrug);
            }
        }
        #endregion

        #region 获取模型数据
        public override object GetTableDataSource()
        {
            return this.uiEmsDTO.Emsapobs.EmsOrDrugList;
        }

        public override object GetFormDataSource()
        {
            return this.uiEmsDTO.Emsapobs;
        }
        #endregion

        #region 新建和编辑
        public override void EditOrder(CiOrderDO ciOrderDO)
        {
            EmsRstDTO[] rsts = LoadRemote(ciOrderDO.Id_or);
            EmsRstDTO rst = rsts[0];
            if (rst != null)
                {
                uiEmsDTO.Emsapobs.deSerializeJson((rst.Document[0] as EmsObsItemDO).serializeJson());
                //String utf8Str = System.Text.Encoding.UTF8.GetString(Convert.FromBase64String(rst.DocumentString));
                //uiEmsDTO.Emsapobs.deSerializeJson(utf8Str);

                    if (rst.Extension != null && rst.Extension.Keys.Contains("CiEmsDTO"))
                    {
                        this.ciEmsDTO = rst.Extension["CiEmsDTO"] as CiEmsDTO;
                    }
                    if (rst.Extension != null && rst.Extension.Keys.Contains("MedSrvDO"))
                    {
                        this.uiEmsDTO.MedSrvDO = rst.Extension["MedSrvDO"] as MedSrvDO;
                        strSd_srvtp = this.uiEmsDTO.MedSrvDO.Sd_srvtp;
                    }

                    if (this.uiEmsDTO.Emsapobs.EmsOrObsListEx != null)
                    {
                        if (null == this.uiEmsDTO.Emsapobs.EmsOrObsList)
                        {
                            this.uiEmsDTO.Emsapobs.EmsOrObsList = new XapDataList<EmsObsLap>();
                        }
                        this.uiEmsDTO.Emsapobs.EmsOrObsList.Clear();
                    this.uiEmsDTO.Emsapobs.EmsOrObsListEx.Cast<EmsObsLap>().ToList().ForEach(o =>
                    {
                            this.uiEmsDTO.Emsapobs.EmsOrObsList.Add(o);
                        });
                    }
                    this.uiEmsDTO.Emsapobs.EmsOrDrugList.Clear();

                    uiEmsDTO.Emsapobs.Use_days = this.ciEmsDTO.Days_or;
                    uiEmsDTO.Emsapobs.Dt_begin_ui = this.ciEmsDTO.Dt_begin;
                    uiEmsDTO.Emsapobs.Dt_end_ui = this.ciEmsDTO.Dt_end;
                    uiEmsDTO.Emsapobs.Times_cur = this.ciEmsDTO.Times_cur;
                    uiEmsDTO.Emsapobs.Times_mp_in = this.ciEmsDTO.Times_mp_in;


                    EmsOrDrug item = new EmsOrDrug();
                    item.Status = DOStatus.UPDATED;
                    item.Id_orsrv = this.uiEmsDTO.Emsapobs.Id_orsrv;
                    item.Id_srv = this.uiEmsDTO.Emsapobs.Id_srv;
                    item.Name_srv = this.uiEmsDTO.Emsapobs.Name_srv;
                    item.Id_freq = this.ciEmsDTO.Id_freq;
                    item.Name_freq = this.ciEmsDTO.Name_freq;
                    item.Freqct = this.uiEmsDTO.MedSrvDO.Freqct;
                    item.Sd_frequnitct = this.uiEmsDTO.MedSrvDO.Sd_frequnitct;
                    

                    item.Fg_urgent = this.uiEmsDTO.Emsapobs.Fg_urgent;
                    item.Use_days = uiEmsDTO.Emsapobs.Use_days;


                    // 剂量
                    item.Quan_med = ciEmsDTO.Quan_medu;
                    item.Id_unit_med = ciEmsDTO.Id_unit_med;
                    item.Name_unit_med = ciEmsDTO.Name_unit_med;
                    /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
                    item.Quan_medu_virtual = ciEmsDTO.Quan_medu;
                    item.Name_unit_medu_virtual = ciEmsDTO.Name_unit_med;
                    /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
                    // 总量
                    item.Quan_cur = (ciEmsDTO.Times_cur == null ? 1 : ciEmsDTO.Times_cur);
                    item.Id_unit_sale = item.Id_unit_med;
                    item.Name_unit_sale = item.Name_unit_med;

                    item.Id_mp_dep = uiEmsDTO.Emsapobs.Id_mp_dep;
                    item.Name_mp_dep = uiEmsDTO.Emsapobs.Name_mp_dep;
                    // 总价
                    
                    item.Price = uiEmsDTO.Emsapobs.Price;
                    
                    item.Totalprice = (item.Price == null ? 0 : item.Price) * (item.Quan_cur == null ? 1 : item.Quan_cur);

                    //列表显示的
                    item.Id_di = this.uiEmsDTO.Emsapobs.Id_di;
                    item.Id_diitm = this.uiEmsDTO.Emsapobs.Id_diitm;
                    item.Name_diag = this.uiEmsDTO.Emsapobs.Name_diag;
                    item.Dt_plan = this.uiEmsDTO.Emsapobs.Dt_plan;
                    item.Id_mp_dep = this.uiEmsDTO.Emsapobs.Id_mp_dep;
                    item.Name_mp_dep = this.uiEmsDTO.Emsapobs.Name_mp_dep;
                    //检查目的
                    item.Id_pps=uiEmsDTO.Emsapobs.Id_pps;
                    item.Sd_pps=uiEmsDTO.Emsapobs.Sd_pps;
                    item.Name_pps=uiEmsDTO.Emsapobs.Des_pps;
                  
                    //申请单号
                    item.No_applyform = this.uiEmsDTO.Emsapobs.No_applyobs;
                    this.uiEmsDTO.Emsapobs.EmsOrDrugList.Add(item);

                    //其他处理
                    uiEmsDTO.Id_srvof = ciEmsDTO.Id_srvof;
                    this.ciEmsDTO.Status = DOStatus.UPDATED;
                    this.uiEmsDTO.Status = DOStatus.UPDATED;
                    item.Fg_setradio = uiEmsDTO.MedSrvDO.Fg_setradio;
                    HandleExpenseItems(ciEmsDTO);
                }

        }


        public override void EditEms(CiEmsDTO ems)
        {
            base.EditEms(ems);

            this.orCiEmsToUiEms.EditEmsObs(this.uiEmsDTO, ems);
            this.uiEmsDTO.Emsapobs.EmsOrDrugList.Clear();
            this.uiEmsDTO.Status = DOStatus.NEW;
            EmsOrDrug item = new EmsOrDrug();
            item.Status = DOStatus.NEW;
            item.Id_orsrv = this.uiEmsDTO.Emsapobs.Id_orsrv;
            item.Id_srv = this.uiEmsDTO.Emsapobs.Id_srv;
            item.Name_srv = this.uiEmsDTO.Emsapobs.Name_srv;
            item.Id_freq = ems.Id_freq;
            item.Name_freq = ems.Name_freq;
            item.Freqct = this.uiEmsDTO.MedSrvDO.Freqct;
            item.Sd_frequnitct = this.uiEmsDTO.MedSrvDO.Sd_frequnitct;
            item.Price = this.uiEmsDTO.Emsapobs.Price;

            item.Fg_urgent = this.uiEmsDTO.Emsapobs.Fg_urgent;
            item.Use_days = uiEmsDTO.Emsapobs.Use_days;

            item.Quan_cur = (item.Quan_cur == null || item.Quan_cur == 0 ? 1 : item.Quan_cur);
            //申请单号
            item.No_applyform = this.uiEmsDTO.Emsapobs.No_applyobs;

            //列表显示的
            item.Id_di = this.uiEmsDTO.Emsapobs.Id_di;
            item.Id_diitm = this.uiEmsDTO.Emsapobs.Id_diitm;
            item.Name_diag = this.uiEmsDTO.Emsapobs.Name_diag;
            item.Dt_plan = this.uiEmsDTO.Emsapobs.Dt_plan;
            
            //检查目的
            item.Id_pps = uiEmsDTO.Emsapobs.Id_pps;
            item.Sd_pps = uiEmsDTO.Emsapobs.Sd_pps;
            item.Name_pps = uiEmsDTO.Emsapobs.Des_pps;


            // 剂量
            item.Quan_med = ems.Quan_medu;
            item.Id_unit_med = ems.Id_unit_med;
            item.Name_unit_med = ems.Name_unit_med;
            // 总量
            item.Quan_cur = (ems.Times_cur == null ? 0 : ems.Times_cur);
            item.Id_unit_sale = item.Id_unit_med;
            item.Name_unit_sale = item.Name_unit_med;

            item.Id_mp_dep = uiEmsDTO.Emsapobs.Id_mp_dep;
            item.Name_mp_dep = uiEmsDTO.Emsapobs.Name_mp_dep;
            // 总价
            DefaultPriceInfo(item); // 存在价格为空清空
            if (item.Price != null && item.Quan_cur != null)
            {
                item.Totalprice = item.Price * item.Quan_cur;//TODO 总价格对应哪个字段需要确定，先通过计算获得 ciEmsSrvDTO.Price_cur;
            }

            this.uiEmsDTO.Emsapobs.EmsOrDrugList.Add(item);
            this.ciEmsDTO.Emssrvs.Clear();

            this.uiEmsDTO.MedSrvDO = XapServiceMgr.find<IMedsrvMDOCrudService>().findById(ems.Id_srv);
            item.Fg_setradio = this.uiEmsDTO.MedSrvDO.Fg_setradio == FBoolean.True;
            if (this.uiEmsDTO.MedSrvDO.Fg_setradio == FBoolean.True)
            {
                foreach(EmsObsLap o in this.uiEmsDTO.Emsapobs.EmsOrObsList)
                {
                    o.Fg_chk = FBoolean.False;
                }
            }
        }

        public override bool LoadMedSrv(EmsCreatedParameter emsCreatedParameter, int pos) //EmsCreateParameter
        {
            base.LoadMedSrv(emsCreatedParameter, pos);
            MedSrvDO med = emsCreatedParameter.getMedSrvDO();
            this.uiEmsDTO.MedSrvDO = med;
            EmsRstDTO[] rsts = CreateRemote(med.Id_srv);
            EmsRstDTO rst = rsts[0];
                    if (rst != null)
                    {
                        if (null != rst.Extension && rst.Extension.Keys.Contains("ErrMsgList"))
                        {
                            FArrayList errList = (FArrayList)rst.Extension["ErrMsgList"];
                            if (errList.Count > 0)
                            {
                                this.errorMsgString = errList.ToString();
                                return false;
                            }
                        }

                uiEmsDTO.Emsapobs.deSerializeJson((rst.Document[0] as EmsObsItemDO).serializeJson());
                //String utf8Str = System.Text.Encoding.UTF8.GetString(Convert.FromBase64String(rst.DocumentString));
                //uiEmsDTO.Emsapobs.deSerializeJson(utf8Str);

                    if (null != rst.Extension && rst.Extension.Keys.Contains("MpDepFilter"))
                        {
                            this.strID_Dep_Mps = (String)rst.Extension["MpDepFilter"];
                        }
                        if (rst.Extension != null && rst.Extension.Keys.Contains("MedSrvDO"))
                        {
                            this.uiEmsDTO.MedSrvDO = rst.Extension["MedSrvDO"] as MedSrvDO;
                            strSd_srvtp = this.uiEmsDTO.MedSrvDO.Sd_srvtp;
                        }
                        this.uiEmsDTO.Emsapobs.EmsOrDrugList.Clear();
                        EmsOrDrug item = new EmsOrDrug();
                        item.Id_srv = this.uiEmsDTO.Emsapobs.Id_srv;
                        item.Name_srv = this.uiEmsDTO.Emsapobs.Name_srv;

                        item.Id_di = this.uiEmsDTO.Emsapobs.Id_di;
                        item.Id_diitm = this.uiEmsDTO.Emsapobs.Id_diitm;
                        item.Name_diag = this.uiEmsDTO.Emsapobs.Name_diag;
                        item.Dt_plan = this.uiEmsDTO.Emsapobs.Dt_plan;
                        item.Id_mp_dep = this.uiEmsDTO.Emsapobs.Id_mp_dep;
                        item.Name_mp_dep = this.uiEmsDTO.Emsapobs.Name_mp_dep;

                        item.Quan_med = this.uiEmsDTO.Emsapobs.Quan_med;
                        item.Quan_medu_virtual = this.uiEmsDTO.Emsapobs.Quan_med;/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
                        item.Id_unit_med = this.uiEmsDTO.Emsapobs.Id_unit_med;
                        item.Name_unit_med = this.uiEmsDTO.Emsapobs.Name_unit_med;
                        item.Name_unit_medu_virtual = this.uiEmsDTO.Emsapobs.Name_unit_med;/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
                        item.Id_freq = uiEmsDTO.MedSrvDO.Id_freq;
                        item.Name_freq = uiEmsDTO.MedSrvDO.Freq_name;
                        item.Freqct = uiEmsDTO.MedSrvDO.Freqct;
                        item.Sd_frequnitct = uiEmsDTO.MedSrvDO.Sd_frequnitct;
                        item.Id_pri = uiEmsDTO.MedSrvDO.Id_primd;
                        item.Use_days = this.uiEmsDTO.Emsapobs.Use_days;
                        item.Quan_cur = this.uiEmsDTO.Emsapobs.Quan_cur;// CalQuantumUtil.GetInstance().getUnMMQuantum(item.Quan_med,this.uiEmsDTO.Emsapobs.Times_cur) ;
                        item.Id_unit_sale = this.uiEmsDTO.Emsapobs.Id_unit_med;
                        item.Name_unit_sale = this.uiEmsDTO.Emsapobs.Name_unit_med;

                        //申请单号
                        item.No_applyform = this.uiEmsDTO.Emsapobs.No_applyobs;
                        //检查目的
                        item.Id_pps = uiEmsDTO.Emsapobs.Id_pps;
                        item.Sd_pps = uiEmsDTO.Emsapobs.Sd_pps;
                        item.Name_pps = uiEmsDTO.Emsapobs.Des_pps;

                        item.Totalprice = (item.Price == null ? 0 : item.Price);

                        item.Price = this.uiEmsDTO.Emsapobs.Price;
                        item.Id_mp_dep = this.uiEmsDTO.Emsapobs.Id_mp_dep;
                        item.Name_mp_dep = this.uiEmsDTO.Emsapobs.Name_mp_dep;
                        item.Fg_setradio = uiEmsDTO.MedSrvDO.Fg_setradio;


                    this.uiEmsDTO.Emsapobs.EmsOrDrugList.Clear();
                        this.uiEmsDTO.Emsapobs.EmsOrDrugList.Add(item);

                        if (this.uiEmsDTO.Emsapobs.EmsOrObsListEx != null)
                        {
                            if (null == this.uiEmsDTO.Emsapobs.EmsOrObsList)
                            {
                                this.uiEmsDTO.Emsapobs.EmsOrObsList = new XapDataList<EmsObsLap>();
                            }
                            this.uiEmsDTO.Emsapobs.EmsOrObsList.Clear();
                            this.uiEmsDTO.Emsapobs.EmsOrObsListEx.Cast<EmsObsLap>().ToList().ForEach(o =>
                            {
                                this.uiEmsDTO.Emsapobs.EmsOrObsList.Add(o);
                            });
                        }

                    }

            return true;
        }

        private void DefaultDepInfo(EmsOrDrug item, MedSrvDO med)
        {

            OrWfDeptInfoDTO wf = new GetDeptMpImp().GetDept_mp_ids(GetEnt4BannerDTO().Code_entp, GetEnt4BannerDTO().Id_entp, med.Sd_srvtp, med.Id_srvca, med.Id_srv, med.Id_route, "id_mm", GetEnt4BannerDTO().Id_dep_nur, GetEnt4BannerDTO().Id_dep_phy);

            this.strID_Dep_Mps = wf == null ? "" : wf.Id_mp_depts;
            item.Id_mp_dep = wf == null ? "" : wf.Firstid_mp_dept;
            item.Name_mp_dep = wf == null ? "" : wf.Firstname_mp_dept;

            uiEmsDTO.Emsapobs.Id_mp_dep = item.Id_mp_dep;
            uiEmsDTO.Emsapobs.Name_mp_dep = item.Name_mp_dep;
        }

        private void DefaultDiInfo()
        {
            if (this.uiEmsDTO.Emsapobs.Id_di == null ||
                this.uiEmsDTO.Emsapobs.Name_diag == null)
            {


                string[] di = new string[2];
                this.logicEx.GetPatDis(this.uiEmsDTO, ref di);
                if (di.Length > 0)
                {
                    this.uiEmsDTO.Emsapobs.Id_di = di[0];
                    this.uiEmsDTO.Emsapobs.Name_diag = di[1];
                }
            }
        }

        private void DefaultPriceInfo(EmsOrDrug item)
        {
            //if (item.Price == null||item.Price.DoubleValue() == 0)
                item.Price = this.logicEx.getSrvNotMMPri(this.uiEmsDTO.MedSrvDO, this.uiEmsDTO.Emsapobs.EmsOrObsList,GetEnt4BannerDTO().Id_pripat);
        }

        #endregion

        #region 保存
        public override CiEmsDTO Save2CiEmsDTO(bool forceUpdate)
        {
            // 需要将临时存储在列表数据模型中的数据取出来，放置到检验结构中
            EmsOrDrug drug = uiEmsDTO.Emsapobs.EmsOrDrugList.ElementAt(0);

            // 剂量
            uiEmsDTO.Emsapobs.Id_unit_med = drug.Id_unit_med;
            uiEmsDTO.Emsapobs.Name_unit_med = drug.Name_unit_med;
            uiEmsDTO.Emsapobs.Quan_med = drug.Quan_med;

            // 使用天数
            uiEmsDTO.Emsapobs.Use_days = drug.Use_days;

            // 总量
            uiEmsDTO.Emsapobs.Quan_cur = drug.Quan_cur;
            uiEmsDTO.Emsapobs.Id_unit_sale = drug.Id_unit_sale;
            uiEmsDTO.Emsapobs.Name_unit_sale = drug.Name_unit_sale;
            /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
            //频次
            uiEmsDTO.Emsapobs.Id_freq = drug.Id_freq;
            uiEmsDTO.Emsapobs.Name_freq = drug.Name_freq;
            uiEmsDTO.Emsapobs.Sd_frequnitct = drug.Sd_frequnitct;
            uiEmsDTO.Emsapobs.Freqct = drug.Freqct;
            /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111

            // 加急
            uiEmsDTO.Emsapobs.Fg_urgent = drug.Fg_urgent;

            // 价格
            uiEmsDTO.Emsapobs.Price = drug.Price;

            // 执行科室
            uiEmsDTO.Emsapobs.Id_mp_dep = drug.Id_mp_dep;
            uiEmsDTO.Emsapobs.Name_mp_dep = drug.Name_mp_dep;
            XapDataList<EmsObsLap> hasItems = new XapDataList<EmsObsLap>();
            foreach (EmsObsLap item in this.uiEmsDTO.Emsapobs.EmsOrObsList)
            {
                if (item.Fg_chk != null && item.Fg_chk.Value)
                {
                    hasItems.Add(item);
                }
            }
            // 暂存
            XapDataList<EmsObsLap> allItems = this.uiEmsDTO.Emsapobs.EmsOrObsList;
            this.uiEmsDTO.Emsapobs.EmsOrObsList = hasItems;
            CiEmsDTO ciEmsDTO = base.Save2CiEmsDTO(forceUpdate);
            this.uiEmsDTO.Emsapobs.EmsOrObsList = allItems;
            return ciEmsDTO;
        }

        protected override void OnBeforeCallServiceSave(CiEmsDTO ems)
        {
            base.OnBeforeCallServiceSave(ems);

            ems.Fg_mp_in = true;

            ems.Times_mp_in = ems.Times_cur;


            //ems.Dt_begin = this.uiEmsDTO.Emsapobs.Dt_plan;
            //ems.Dt_end = this.uiEmsDTO.Emsapobs.Dt_plan;


            if (ems.Emssrvs != null)
                ems.Emssrvs.Cast<CiEmsSrvDTO>().Where(srv => srv.Eu_sourcemd == (int)OrSrvSourceFromEnum.PHYSIAN).ToList().ForEach(srv =>
                {
                srv.Quan_total_medu = ems.Times_mp_in * srv.Quan_med;
            });

            
        }

        public override CiOrderDO Save2Order()
        {
            //return New_Save();
            // 需要将临时存储在列表数据模型中的数据取出来，放置到检验结构中
            EmsOrDrug drug = uiEmsDTO.Emsapobs.EmsOrDrugList.ElementAt(0);

            // 剂量
            uiEmsDTO.Emsapobs.Id_unit_med = drug.Id_unit_med;
            uiEmsDTO.Emsapobs.Name_unit_med = drug.Name_unit_med;
            uiEmsDTO.Emsapobs.Quan_med = drug.Quan_med;

            // 使用天数
            uiEmsDTO.Emsapobs.Use_days = drug.Use_days;

            // 总量
            uiEmsDTO.Emsapobs.Quan_cur = drug.Quan_cur;
            uiEmsDTO.Emsapobs.Id_unit_sale = drug.Id_unit_sale;
            uiEmsDTO.Emsapobs.Name_unit_sale = drug.Name_unit_sale;

            // 加急
            uiEmsDTO.Emsapobs.Fg_urgent = drug.Fg_urgent;

            // 价格
            uiEmsDTO.Emsapobs.Price = drug.Price;

            // 执行科室
            uiEmsDTO.Emsapobs.Id_mp_dep = drug.Id_mp_dep;
            uiEmsDTO.Emsapobs.Name_mp_dep = drug.Name_mp_dep;

            //检查目的
            uiEmsDTO.Emsapobs.Id_pps = drug.Id_pps;
            uiEmsDTO.Emsapobs.Sd_pps = drug.Sd_pps;
            uiEmsDTO.Emsapobs.Des_pps = drug.Name_pps;
            //临床诊断
            uiEmsDTO.Emsapobs.Id_di = drug.Id_di;
            uiEmsDTO.Emsapobs.Name_diag = drug.Name_diag;
            //计划时间
            uiEmsDTO.Emsapobs.Dt_plan = drug.Dt_plan;

          
            foreach (EmsObsLap item in this.uiEmsDTO.Emsapobs.EmsOrObsList)
            {
                if (!String.IsNullOrEmpty(item.Id_orsrv) && item.Fg_chk != FBoolean.True)
                {
                    item.Status = DOStatus.DELETED;
                    this.uiEmsDTO.Emsapobs.EmsOrObsListDel.Add(item);
                }
            }

                return base.Save2Order(); 
        }

        /// <summary>
        /// 新的检查医疗单保存逻辑
        /// </summary>
        /// <returns></returns>
        public CiOrderDO New_Save()
        {


                // 需要将临时存储在列表数据模型中的数据取出来，放置到检验结构中
                EmsOrDrug drug = uiEmsDTO.Emsapobs.EmsOrDrugList.ElementAt(0);

                // 剂量
                uiEmsDTO.Emsapobs.Id_unit_med = drug.Id_unit_med;
                uiEmsDTO.Emsapobs.Name_unit_med = drug.Name_unit_med;
                uiEmsDTO.Emsapobs.Quan_med = drug.Quan_med;

                // 使用天数
                uiEmsDTO.Emsapobs.Use_days = drug.Use_days;

                // 总量
                uiEmsDTO.Emsapobs.Quan_cur = drug.Quan_cur;
                uiEmsDTO.Emsapobs.Id_unit_sale = drug.Id_unit_sale;
                uiEmsDTO.Emsapobs.Name_unit_sale = drug.Name_unit_sale;

                /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
                // 频次
                uiEmsDTO.Emsapobs.Id_freq = drug.Id_freq;
                uiEmsDTO.Emsapobs.Name_freq = drug.Name_freq;
                uiEmsDTO.Emsapobs.Freqct = drug.Freqct;
                uiEmsDTO.Emsapobs.Sd_frequnitct = drug.Sd_frequnitct;
                /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
                // 加急
                uiEmsDTO.Emsapobs.Fg_urgent = drug.Fg_urgent;

                // 价格
                uiEmsDTO.Emsapobs.Price = drug.Price;

                // 执行科室
                uiEmsDTO.Emsapobs.Id_mp_dep = drug.Id_mp_dep;
                uiEmsDTO.Emsapobs.Name_mp_dep = drug.Name_mp_dep;

                //检查目的
                uiEmsDTO.Emsapobs.Id_pps = drug.Id_pps;
                uiEmsDTO.Emsapobs.Sd_pps = drug.Sd_pps;
                uiEmsDTO.Emsapobs.Des_pps = drug.Name_pps;
                //临床诊断
                uiEmsDTO.Emsapobs.Id_di = drug.Id_di;
                uiEmsDTO.Emsapobs.Name_diag = drug.Name_diag;
                //计划时间
                uiEmsDTO.Emsapobs.Dt_plan = drug.Dt_plan;

                this.uiEmsDTO.Emsapobs.EmsOrObsListEx = new FArrayList();
                foreach (EmsObsLap item in this.uiEmsDTO.Emsapobs.EmsOrObsList)
                {
                    if (item.Fg_chk == FBoolean.True)
                    {
                        this.uiEmsDTO.Emsapobs.EmsOrObsListEx.Add(item);
                    }

                }
                this.uiEmsDTO.Emsapobs.EmsOrDrugListEx = new FArrayList();
                this.uiEmsDTO.Emsapobs.EmsOrDrugListEx.Add(drug);
                uiEmsDTO.Emsapobs.Id_srvof = this.emsMgrDTO.Id_ems;
                uiEmsDTO.Emsapobs.Fg_quickwflow = this.emsMgrDTO.Fg_quickwflow;

            EmsRstDTO rst = SaveRemote(this.uiEmsDTO.Emsapobs);
                if (rst != null)
                {
                    return (rst.Document[0] as CiorderAggDO).getParentDO();
            }

            return null;
        }

        #endregion

        #region 字段信息变化处理
        public override string OnRefFilterData(string filedName, StringObjectMap sbm)
        {
            if (filedName.Equals("Name_srv"))
            {
                if (!sbm.ContainsKey("code_entp"))
                {
                    sbm.Add("code_entp", "00");
                }
                if (!sbm.ContainsKey("id_pripat"))
                {
                    sbm.Add("id_pripat", this.ent4BannerDTO.Id_pripat);
                }
                CiEnContextDTO ciEnContextDTO = BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO;
                string id_hp = ciEnContextDTO.Id_hp_default;
                if (!string.IsNullOrEmpty(id_hp))
                {
                    if (!sbm.ContainsKey("id_hp"))
                    {
                        sbm.Add("id_hp", id_hp);
                    }
                }
                return string.Format(" Sd_srvtp ='{0}' and quan_med is not null", strSd_srvtp);
            }
            else if (filedName.Equals("Name_diag"))
            {
                if (sbm != null && !sbm.ContainsKey("id_ent"))
                {
                    sbm.Add("id_ent",(GetEnt4BannerDTO().Id_ent));
                }
                return "";

            }
            else if (filedName.Equals("Name_mp_dep"))
            {

                if (string.IsNullOrEmpty(strID_Dep_Mps))
                {
                    OrWfDeptInfoDTO wf = new GetDeptMpImp().GetDept_mp_ids(GetEnt4BannerDTO().Code_entp, GetEnt4BannerDTO().Id_entp, this.uiEmsDTO.MedSrvDO.Sd_srvtp, this.uiEmsDTO.MedSrvDO.Id_srvca, this.uiEmsDTO.MedSrvDO.Id_srv, this.uiEmsDTO.MedSrvDO.Id_route, "id_mm", GetEnt4BannerDTO().Id_dep_nur, GetEnt4BannerDTO().Id_dep_phy);

                    this.strID_Dep_Mps = wf == null ? "" : wf.Id_mp_depts;
                }
                return string.Format("id_dep in ({0})", strID_Dep_Mps);
            }
            else
            {
                return base.OnRefFilterData(filedName, sbm); 
            }
        }

        public override bool OnRefResultData(string fieldName, Object ds)
        {
            if (fieldName.Equals("Name_freq"))
            {
                EmsOrDrug itemDrug = ds as EmsOrDrug;
                if (itemDrug.Sd_frequnitct == BdSrvDictCodeConst.SD_FREQUNIT_ONCE)
                {
                    itemDrug.Quan_cur = 1;
                    itemDrug.Use_days = 1;
                }
                else
                {
                    itemDrug.Quan_cur = this.logicEx.getNotDrugTotal(itemDrug.Quan_med.ToDouble(), itemDrug.Id_freq, itemDrug.Freqct.Value, itemDrug.Use_days.Value);
                }

                itemDrug.Totalprice = itemDrug.Price * itemDrug.Quan_cur;

                return true;
            }
            return false;

        }

        /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
        public override void OnDataChanged(Object ds, string fieldName, string value)
        {
            if (String.IsNullOrEmpty(fieldName))
            {
                return;
            }

            if (fieldName.ToLower().Equals("fg_urgent"))
            {
                this.uiEmsDTO.Emsapobs.Fg_urgent = bool.Parse(value);
            }
            else if (fieldName.Equals("Use_days") || fieldName.Equals("customercolumn_med_unit") || fieldName.Equals("customercolumn_sale_unit"))
            {
                EmsOrDrug itemDrug = ds as EmsOrDrug;
                if (itemDrug != null && itemDrug.Quan_med != null && itemDrug.Id_freq != null && itemDrug.Freqct != null && itemDrug.Use_days != null)
                {
                    itemDrug.Quan_cur = this.logicEx.getNotDrugTotal(itemDrug.Quan_med.ToDouble(), itemDrug.Id_freq, itemDrug.Freqct.Value, itemDrug.Use_days.Value);
                    itemDrug.Totalprice = itemDrug.Price * itemDrug.Quan_cur;
                }
            }
            else if (fieldName.Equals("Dt_plan"))
            {
                this.uiEmsDTO.Emsapobs.Dt_begin_ui = this.uiEmsDTO.Emsapobs.Dt_plan;
                if (this.uiEmsDTO.Emsapobs.Dt_begin_ui == null)
                {
                    this.uiEmsDTO.Emsapobs.Dt_end_ui = this.uiEmsDTO.Emsapobs.Dt_begin_ui;
                }
                else
                {
                    this.uiEmsDTO.Emsapobs.Dt_end_ui = ((DateTime)this.uiEmsDTO.Emsapobs.Dt_begin_ui).AddDays((int)this.uiEmsDTO.Emsapobs.Use_days);
                }
            }
            else if (fieldName.Equals("customercolumn_details"))
            {
                //TODO 后台抽出新的方法后需要替换
                EmsOrDrug itemDrug = ds as EmsOrDrug;
                MedSrvDO medSrv = new MedSrvDO();
                medSrv.Id_srv = itemDrug.Id_srv;
                medSrv.Id_primd = itemDrug.Id_pri;
                LogicEx logicEx = LogicEx.GetInstance();
                itemDrug.Totalprice = logicEx.getSrvNotMMPri(medSrv, this.uiEmsDTO.Emsapobs.EmsOrObsList, this.ent4BannerDTO.Id_pripat);
                itemDrug.Price = itemDrug.Totalprice;
            }
        }
        /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
        #endregion

        #region 设置或获取套明细
        public void setEmsOrObsList(XapDataList<EmsObsLap> obsList)
        {
            this.uiEmsDTO.Emsapobs.EmsOrObsList = obsList;
            if (this.uiEmsDTO.Emsapobs.EmsOrDrugList.Count > 0)
            {
                this.uiEmsDTO.Emsapobs.EmsOrDrugList[0].Price = this.logicEx.getSrvNotMMPri(this.uiEmsDTO.MedSrvDO, getSelectedObsLap());
            }
        }
        public XapDataList<EmsObsLap> getEmsOrObsList()
        {
            return this.uiEmsDTO.Emsapobs.EmsOrObsList;
        }
        #endregion

        #region 定义显示和只读字段
        public override string[] GetHiddenFields()
        {
            /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
            List<string> lstFields = new List<string>() { "Fg_skintest", "Name_route", "Name_boildes", "Spec_mm", "Totalprice", "Fg_treat", "Fg_extdispense" };
            bool isHideDose = false;
            bool isHideFreq = false;
            if (this.uiEmsDTO.Emsapobs.Ismuldose == null || !this.uiEmsDTO.Emsapobs.Ismuldose.Value)
            {
                isHideDose = true;
                lstFields.Add("customercolumn_med_unit");
            }
            if (this.uiEmsDTO.Emsapobs.Ismulexec == null || !this.uiEmsDTO.Emsapobs.Ismulexec.Value)
            {
                isHideFreq = true;
                lstFields.Add("Name_freq");
                lstFields.Add("Use_days");
            }
            if (isHideDose || isHideFreq)
            {
                lstFields.Add("customercolumn_sale_unit");
            }

            return lstFields.ToArray();
            /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
        }

        public override string[] GetReadonlyFields()
        {
            return new string[] { };
        }
        public override string[] GetFixedFields()
        {
            return new string[]{""};
        }
        #endregion

        #region 检查服务接口
        public bool isSet()
        {
            return this.uiEmsDTO.MedSrvDO.Fg_set != null && this.uiEmsDTO.MedSrvDO.Fg_set.Value;

        }


        #endregion

        #region 私有方法
        protected XapDataList<EmsObsLap> getSelectedObsLap()
        {
            XapDataList<EmsObsLap> ls = new XapDataList<EmsObsLap>();
            foreach (EmsObsLap item in uiEmsDTO.Emsapobs.EmsOrObsList)
            {
                if ((item.Fg_edit != null && !item.Fg_edit.Value) || (item.Fg_chk != null && item.Fg_chk.Value))
                {
                    ls.Add(item);
                }
            }

            return ls;
        }
        #endregion

    }
}
