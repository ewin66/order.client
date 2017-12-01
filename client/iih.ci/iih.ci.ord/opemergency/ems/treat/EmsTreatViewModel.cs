using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ems.d;
using iih.en.pv.dto.d;
using iih.bd.srv.medsrv.d;
using xap.rui.appfw;
using iih.ci.ord.ciorder.viewmodel.impext;
using xap.rui.control.extentions;
using iih.ci.ord_stub.i;
using iih.ci.ord.i;
using xap.mw.serviceframework;
using iih.ci.ord.ciorder.d;
using xap.mw.core.data;
using iih.ci.ord.emsdi.d;
using iih.ci.ord.opemergency.ems.common;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.bd.bc.udi;
using iih.ci.ord.ciorder.utils;
using iih.bd.srv.medsrv.i;
using xap.mw.coreitf.d;
using iih.bd.srv.freqdef.i;
using iih.ci.ord.common.utils;
using iih.ci.ord.dto.emsmain;
using iih.ci.ord.opemergency.declare;
using iih.ci.iih.ci.ord.i;
using iih.bd.srv.ems.d;

namespace iih.ci.ord.opemergency.ems.dp
{
    /// <summary>
    /// <para>描    述 :  治疗数据处理模型            	</para>
    /// <para>说    明 :                      			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.ems.dp    </para>    
    /// <para>类 名 称 :  EmsTreatViewModel        			</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/6/30 16:27:45             </para>
    /// <para>更新时间 :  2016/6/30 16:27:45             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    class EmsTreatViewModel : BaseEmsViewModel
    {
        private String strMpDepFilter = "";
        /// <summary>
        /// 药品数据处理模型
        /// </summary>
        /// <param name="ent"></param>
        public EmsTreatViewModel(Ent4BannerDTO ent)
            : base(ent)
        {

        }

        /// <summary>
        /// 列表模型
        /// </summary>
        /// <returns></returns>
        public override object GetTableDataSource()
        {
            return this.uiEmsDTO.Emsdrugs.EmsOrDrugList;
        }

        /// <summary>
        /// 选项卡数据模型
        /// </summary>
        /// <returns></returns>
        public override object GetFormDataSource()
        {
            if (this.uiEmsDTO.Emsdrugs.EmsOrDrugList.Count == 0)
            {
                return new EmsOrDrug();
            }
            return this.uiEmsDTO.Emsdrugs.EmsOrDrugList[0];
        }

        /// <summary>
        /// 初始化方法
        /// </summary>
        public override void Init()
        {
            base.Init();
            uiEmsDTO.EmsType = EmsType.COMMON;
        }
        
        public override bool IsEmpty()
        {
            return this.uiEmsDTO.Emsdrugs.EmsOrDrugList == null || this.uiEmsDTO.Emsdrugs.EmsOrDrugList.Count == 0 ||
                (this.uiEmsDTO.Emsdrugs.EmsOrDrugList.Count == 1 && String.IsNullOrEmpty(this.uiEmsDTO.Emsdrugs.EmsOrDrugList[0].Id_srv));
        }

        /// <summary>
        /// 清空列表数据
        /// </summary>
        public override void ClearTableDataSource()
        {
            (GetTableDataSource() as XapDataList<EmsOrDrug>).Clear();
        }

        public override void EditOrder(CiOrderDO ciOrderDO)
        {
            EmsRstDTO[] rsts = LoadRemote(ciOrderDO.Id_or);
            EmsRstDTO rst = rsts[0];
            if (rst != null)
                {
                uiEmsDTO.Emsdrugs.deSerializeJson((rst.Document[0] as EmsDrugItemDO).serializeJson());
                //String utf8Str = System.Text.Encoding.UTF8.GetString(Convert.FromBase64String(rst.DocumentString));
                //uiEmsDTO.Emsdrugs.deSerializeJson(utf8Str);

                    if (rst.Extension != null && rst.Extension.Keys.Contains("CiEmsDTO"))
                    {
                        this.ciEmsDTO = rst.Extension["CiEmsDTO"] as CiEmsDTO;
                    }
                    if (rst.Extension != null && rst.Extension.Keys.Contains("MedSrvDO"))
                    {
                        this.uiEmsDTO.MedSrvDO = rst.Extension["MedSrvDO"] as MedSrvDO;
                        strSd_srvtp = this.uiEmsDTO.MedSrvDO.Sd_srvtp;
                    }
                    if (rst.Extension != null && rst.Extension.Keys.Contains("MpDepFilter"))
                    {
                        strMpDepFilter = rst.Extension["MpDepFilter"] as String;
                    }

                    if (this.uiEmsDTO.Emsdrugs.EmsOrDrugListEx != null)
                    {
                        if (null == this.uiEmsDTO.Emsdrugs.EmsOrDrugList)
                        {
                            this.uiEmsDTO.Emsdrugs.EmsOrDrugList = new XapDataList<EmsOrDrug>();
                        }
                        this.uiEmsDTO.Emsdrugs.EmsOrDrugList.Clear();
                    this.uiEmsDTO.Emsdrugs.EmsOrDrugListEx.Cast<EmsOrDrug>().ToList().ForEach(o =>
                    {
                            this.uiEmsDTO.Emsdrugs.EmsOrDrugList.Add(o);
                        });
                    }

                    this.ciEmsDTO.Status = DOStatus.UPDATED;
                    this.uiEmsDTO.Status = DOStatus.UPDATED;
                    HandleExpenseItems(ciEmsDTO);
                }
        }


        public override void EditEms(CiEmsDTO ems)
        {
            base.EditEms(ems);

            orCiEmsToUiEms.EditCommon(this.ciEmsDTO, uiEmsDTO);
            this.uiEmsDTO.Status = DOStatus.NEW;
            EmsOrDrug drug = new EmsOrDrug();
            drug.Id_srv = this.ciEmsDTO.Id_srv;
            drug.Name_srv = this.ciEmsDTO.Name;
            CiEmsSrvDTO emssrv = this.ciEmsDTO.Emssrvs[0] as CiEmsSrvDTO;
            drug.Id_unit_med = emssrv.Id_unit_med;
            drug.Name_unit_med = emssrv.Name_unit_med;
            drug.Id_freq = emssrv.Id_freq;
            drug.Name_freq = emssrv.Name_freq;
            drug.Sd_frequnitct = emssrv.Sd_frequnitct;
            drug.Freqct = emssrv.Freqct;
            drug.Id_mp_dep = emssrv.Id_dep;
            drug.Name_mp_dep = emssrv.Name_dep;
            drug.Note_or = ciEmsDTO.Note;
            drug.Fg_treat = emssrv.Fg_indic;
            drug.Use_days = this.ciEmsDTO.Days_or;
            drug.Quan_med = (emssrv.Quan_med == null ? 1 : emssrv.Quan_med);
            drug.Quan_cur = (emssrv.Quan_cur == null ? this.logicEx.getNotDrugTotal(drug.Quan_med.ToDouble(), drug.Id_freq, drug.Freqct.Value, drug.Use_days.Value) : emssrv.Quan_cur); ;
            drug.Price = emssrv.Price;
            drug.Totalprice = drug.Price * drug.Quan_cur;
            drug.Fg_bl = emssrv.Fg_bl;
            drug.Id_srvtp = ciEmsDTO.Id_srvtp;
            drug.Sd_srvtp = ciEmsDTO.Sd_srvtp;
            drug.Eu_sourcemd = emssrv.Eu_sourcemd;
            uiEmsDTO.Emsdrugs.EmsOrDrugList.Add(drug);
            //执行科室
            OrWfDeptInfoDTO wf = new GetDeptMpImp().GetDept_mp_ids(this.uiEmsDTO.PatInfo.Code_entp,
               this.uiEmsDTO.PatInfo.Id_entp,
               this.uiEmsDTO.MedSrvDO.Sd_srvtp,
               this.uiEmsDTO.MedSrvDO.Id_srvca,
               this.uiEmsDTO.MedSrvDO.Id_srv,
               this.uiEmsDTO.MedSrvDO.Id_route,
               "", this.uiEmsDTO.PatInfo.Id_dep_nur, this.uiEmsDTO.PatInfo.Id_dep_phy);
            if (wf != null)
            {
                strMpDepFilter = wf.Id_mp_depts;
            }
        }

        public override bool LoadMedSrv(EmsCreatedParameter emsCreatedParameter, int pos)  //EmsCreateParameter
        {
            base.LoadMedSrv(emsCreatedParameter, pos);
            MedSrvDO med = emsCreatedParameter.getMedSrvDO();

            Dictionary<String, Object> ctmInfo = new Dictionary<string, object>();
            ctmInfo.Add("CustomInfo", emsCreatedParameter.GetParameter() == null ? null : emsCreatedParameter.GetParameter().ToString());
            EmsRstDTO[] rsts = CreateRemote(med.Id_srv, null, ctmInfo);
            EmsRstDTO rst = rsts[0];
                if (rst != null)
                {
                uiEmsDTO.Emsdrugs.deSerializeJson((rst.Document[0] as EmsDrugItemDO).serializeJson());
                //String utf8Str = System.Text.Encoding.UTF8.GetString(Convert.FromBase64String(rst.DocumentString));
                //uiEmsDTO.Emsdrugs.deSerializeJson(utf8Str);

                    if (rst.Extension != null && rst.Extension.Keys.Contains("MedSrvDO"))
                    {
                        this.uiEmsDTO.MedSrvDO = rst.Extension["MedSrvDO"] as MedSrvDO;
                        strSd_srvtp = this.uiEmsDTO.MedSrvDO.Sd_srvtp;
                    }
                    if (null != rst.Extension && rst.Extension.Keys.Contains("MpDepFilter"))
                    {
                        this.strMpDepFilter = (String)rst.Extension["MpDepFilter"];
                    }

                    if (null != uiEmsDTO.Emsdrugs.EmsOrDrugListEx)
                    {
                        uiEmsDTO.Emsdrugs.EmsOrDrugList.Clear();
                    uiEmsDTO.Emsdrugs.EmsOrDrugListEx.Cast<EmsOrDrug>().ToList().ForEach(item =>
                    {
                            uiEmsDTO.Emsdrugs.EmsOrDrugList.Add(item);
                        });
                    }
                   
                }

            return true;
        }

        public override void DeleteItemData(int index)
        {

        }
        public override CiEmsDTO Save2CiEmsDTO(bool forceUpdate)
        {
            EmsOrDrug ems = uiEmsDTO.Emsdrugs.EmsOrDrugList[0];
            this.uiEmsDTO.Emsdrugs.Id_srv = ems.Id_srv;
            this.uiEmsDTO.Emsdrugs.Name_srv = ems.Name_srv;
            this.uiEmsDTO.Emsdrugs.Quan_med = ems.Quan_med;
            this.uiEmsDTO.Emsdrugs.Id_unit_med = ems.Id_unit_med;
            this.uiEmsDTO.Emsdrugs.Id_freq = ems.Id_freq;
            this.uiEmsDTO.Emsdrugs.Name_freq = ems.Name_freq;
            this.uiEmsDTO.Emsdrugs.Sd_frequnitct = ems.Sd_frequnitct;
            this.uiEmsDTO.Emsdrugs.Freqct = ems.Freqct;
            this.uiEmsDTO.Emsdrugs.Use_days = ems.Use_days;
            this.uiEmsDTO.Emsdrugs.Quan_cur = ems.Quan_cur;
            this.uiEmsDTO.Emsdrugs.Id_unit_sale = ems.Id_unit_sale;
            this.uiEmsDTO.Emsdrugs.Name_unit_sale = ems.Name_unit_sale;
            this.uiEmsDTO.Emsdrugs.Id_dep = ems.Id_mp_dep;
            this.uiEmsDTO.Emsdrugs.Name_dep = ems.Name_mp_dep;
            this.uiEmsDTO.Emsdrugs.Price = ems.Price;
            this.uiEmsDTO.Emsdrugs.Totalprice = ems.Totalprice.ToString();
            this.uiEmsDTO.Emsdrugs.Note_or = ems.Note_or;
            this.uiEmsDTO.Emsdrugs.Fg_treat = ems.Fg_treat;
            ciEmsDTO.Id_srv = ems.Id_srv;
            ciEmsDTO.Fg_urgent = ems.Fg_urgent;
            ciEmsDTO.Times_cur = this.uiEmsDTO.Emsdrugs.Times_cur;
            CiEmsDTO ciemsDTO = base.Save2CiEmsDTO(forceUpdate); // 
            ciemsDTO.Fg_urgent = ems.Fg_urgent;
            ciemsDTO.Times_cur = this.uiEmsDTO.Emsdrugs.Times_cur;//总的次数
            return ciemsDTO;
        }

        /// <summary>
        /// 保存医嘱
        /// </summary>
        /// <returns></returns>
        public override CiOrderDO Save2Order()
        {
            return Old_Save();
            //return New_Save();
        }
        public CiOrderDO New_Save()
        {
                EmsOrDrug ems = uiEmsDTO.Emsdrugs.EmsOrDrugList[0];
                this.uiEmsDTO.Emsdrugs.Id_srv = ems.Id_srv;
                this.uiEmsDTO.Emsdrugs.Fg_selfpay = ems.Fg_selfpay;
                this.uiEmsDTO.Emsdrugs.Name_srv = ems.Name_srv;
                this.uiEmsDTO.Emsdrugs.Innercode_srvca = ems.Innercode_srvca;
                this.uiEmsDTO.Emsdrugs.Quan_med = ems.Quan_med;
                this.uiEmsDTO.Emsdrugs.Id_unit_med = ems.Id_unit_med;
                this.uiEmsDTO.Emsdrugs.Id_freq = ems.Id_freq;
                this.uiEmsDTO.Emsdrugs.Name_freq = ems.Name_freq;
                this.uiEmsDTO.Emsdrugs.Sd_frequnitct = ems.Sd_frequnitct;
                this.uiEmsDTO.Emsdrugs.Freqct = ems.Freqct;
                this.uiEmsDTO.Emsdrugs.Use_days = ems.Use_days;
                this.uiEmsDTO.Emsdrugs.Quan_cur = ems.Quan_cur;
                this.uiEmsDTO.Emsdrugs.Id_unit_sale = ems.Id_unit_sale;
                this.uiEmsDTO.Emsdrugs.Name_unit_sale = ems.Name_unit_sale;
                this.uiEmsDTO.Emsdrugs.Id_dep = ems.Id_mp_dep;
                this.uiEmsDTO.Emsdrugs.Name_dep = ems.Name_mp_dep;
                this.uiEmsDTO.Emsdrugs.Price = ems.Price;
                this.uiEmsDTO.Emsdrugs.Totalprice = ems.Totalprice.ToString();
                this.uiEmsDTO.Emsdrugs.Note_or = ems.Note_or;
                this.uiEmsDTO.Emsdrugs.Fg_treat = ems.Fg_treat;
                this.uiEmsDTO.Emsdrugs.Id_srvtp = ems.Id_srvtp;
                this.uiEmsDTO.Emsdrugs.Sd_srvtp = ems.Sd_srvtp;
                this.uiEmsDTO.Emsdrugs.Fg_bl = ems.Fg_bl;
                //this.uiEmsDTO.Emsdrugs.Id_srvtp = ems.Id_srvtp;
                //this.uiEmsDTO.Emsdrugs.Sd_srvtp = ems.Sd_srvtp;
                this.uiEmsDTO.Emsdrugs.Fg_urgent = ems.Fg_urgent;
                this.uiEmsDTO.Emsdrugs.Id_srvof = emsMgrDTO.Id_ems;
            this.uiEmsDTO.Emsdrugs.Fg_selfpay = ems.Fg_selfpay;

                this.uiEmsDTO.Emsdrugs.EmsOrDrugListEx.Clear();
                this.uiEmsDTO.Emsdrugs.EmsOrDrugListEx.Add(this.uiEmsDTO.Emsdrugs.EmsOrDrugList[0]);

            EmsRstDTO rst = SaveRemote(this.uiEmsDTO.Emsdrugs);
                if (rst != null)
                {
                    return (rst.Document[0] as CiorderAggDO).getParentDO();
                }

            return null;
        }
        public CiOrderDO Old_Save()
        {
            EmsOrDrug ems = uiEmsDTO.Emsdrugs.EmsOrDrugList[0];
            this.uiEmsDTO.Emsdrugs.Id_srv = ems.Id_srv;
            this.uiEmsDTO.Emsdrugs.Name_srv = ems.Name_srv;
            this.uiEmsDTO.Emsdrugs.Quan_med = ems.Quan_med;
            this.uiEmsDTO.Emsdrugs.Id_unit_med = ems.Id_unit_med;
            this.uiEmsDTO.Emsdrugs.Id_freq = ems.Id_freq;
            this.uiEmsDTO.Emsdrugs.Name_freq = ems.Name_freq;
            this.uiEmsDTO.Emsdrugs.Sd_frequnitct = ems.Sd_frequnitct;
            this.uiEmsDTO.Emsdrugs.Freqct = ems.Freqct;
            this.uiEmsDTO.Emsdrugs.Use_days = ems.Use_days;
            this.uiEmsDTO.Emsdrugs.Quan_cur = ems.Quan_cur;
            this.uiEmsDTO.Emsdrugs.Id_unit_sale = ems.Id_unit_sale;
            this.uiEmsDTO.Emsdrugs.Name_unit_sale = ems.Name_unit_sale;
            this.uiEmsDTO.Emsdrugs.Id_dep = ems.Id_mp_dep;
            this.uiEmsDTO.Emsdrugs.Name_dep = ems.Name_mp_dep;
            this.uiEmsDTO.Emsdrugs.Price = ems.Price;
            this.uiEmsDTO.Emsdrugs.Totalprice = ems.Totalprice.ToString();
            this.uiEmsDTO.Emsdrugs.Note_or = ems.Note_or;
            this.uiEmsDTO.Emsdrugs.Fg_treat = ems.Fg_treat;
            this.uiEmsDTO.Emsdrugs.Id_srvtp = ems.Id_srvtp;
            this.uiEmsDTO.Emsdrugs.Sd_srvtp = ems.Sd_srvtp;
            this.uiEmsDTO.Emsdrugs.Fg_bl = ems.Fg_bl;
            this.uiEmsDTO.Emsdrugs.Id_srvtp = ems.Id_srvtp;
            this.uiEmsDTO.Emsdrugs.Sd_srvtp = ems.Sd_srvtp;
            this.uiEmsDTO.Emsdrugs.Fg_selfpay = ems.Fg_selfpay;
            List<CiEmsSrvDTO> srvList = new List<CiEmsSrvDTO>();
            CiEmsSrvDTO srvCommon = new CiEmsSrvDTO();
            if (ciEmsDTO.Emssrvs != null && ciEmsDTO.Emssrvs.Count > 0)
            {

                foreach (CiEmsSrvDTO item in ciEmsDTO.Emssrvs)
                {//遍历一下 把多条服务的放到内存集合当中，做什么用呢，后面你就知道了，为了修改时候 直接 把修改的字段赋值
                    srvList.Add(item);
                }
                //srvList = ciEmsDTO.Emssrvs.Cast<CiEmsSrvDTO>().ToList();
                CiEmsSrvDTO srvdb = srvList.FirstOrDefault(p => (p.Eu_sourcemd == (int)OrSrvSourceFromEnum.PHYSIAN && p.Id_srv == this.ciEmsDTO.Id_srv));//srvCommon  公用服务 专门针对那些只有一条服务的 
                if (srvdb != null) srvCommon = srvdb;
                //srvCommon = srvList[0];//srvCommon  公用服务 专门针对那些只有一条服务的
                srvCommon.Id_orsrv = ems.Id_orsrv;
                srvCommon.Id_srv = ems.Id_srv;
                srvCommon.Sd_srvtp = ems.Sd_srvtp;
                srvCommon.Id_srvtp = ems.Id_srvtp;
                srvCommon.Id_srvca = ems.Id_srvca;
                srvCommon.Name_srv = ems.Name_srv;
                srvCommon.Quan_med = ems.Quan_med;
                srvCommon.Id_unit_med = ems.Id_unit_med;
                srvCommon.Id_freq = ems.Id_freq;
                srvCommon.Name_freq = ems.Name_freq;
                srvCommon.Sd_frequnitct = ems.Sd_frequnitct;
                srvCommon.Freqct = ems.Freqct;
                srvCommon.Quan_cur = ems.Quan_cur;
                srvCommon.Id_unit_sale = ems.Id_unit_sale;
                srvCommon.Name_unit_sale = ems.Name_unit_sale;
                srvCommon.Id_dep = ems.Id_mp_dep;
                srvCommon.Name_dep = ems.Name_mp_dep;
                srvCommon.Price = ems.Price;
                srvCommon.Fg_treat = ems.Fg_treat;
                srvCommon.Fg_bl = ems.Fg_bl;
                srvCommon.Eu_sourcemd = ems.Eu_sourcemd;
                srvCommon.Status = DOStatus.UPDATED;
                uiEmsDTO.Status = DOStatus.UPDATED;
            }
            else
            {
                srvCommon.Status = DOStatus.NEW;
                uiEmsDTO.Status = DOStatus.NEW;
                uiEmsDTO.Status = DOStatus.NEW;
            }
            ciEmsDTO.Fg_urgent = ems.Fg_urgent;
            ciEmsDTO.Times_cur = this.uiEmsDTO.Emsdrugs.Times_cur;
            this.orDataConvert.SaveDtoCommonDataBing(ciEmsDTO, uiEmsDTO);
            this.orDataConvert.SaveCommonSrvDataBing(srvCommon, this.uiEmsDTO, (int)OrSrvSourceFromEnum.PHYSIAN);
            this.orDataConvert.SaveApDrug(ciEmsDTO, this.uiEmsDTO);
            this.orDataConvert.SaveApCommonSrv(srvCommon, uiEmsDTO);
            srvCommon.Quan_med = ems.Quan_med;
            srvCommon.Fg_indic = ems.Fg_treat;
            srvCommon.Price = ems.Price;
            srvCommon.Price_cur = ems.Totalprice;
            srvCommon.Id_primd = ems.Id_pri;
            srvCommon.Fg_or = uiEmsDTO.MedSrvDO.Fg_or;
            srvCommon.Fg_selfpay = ems.Fg_selfpay;
            if (ems.Fg_selfpay != null && ems.Fg_selfpay.Value)
            {
                srvCommon.Fg_hpindicjudged =(int)HpIndicJudgeEnum.SELFPAY;
                this.ciEmsDTO.Eu_hpindicjudge = (int)HpIndicJudgeEnum.SELFPAY;
            }else{
                srvCommon.Fg_hpindicjudged = null;
            }
            //当医嘱类型是治疗类时，为皮试医嘱 zwq 2016-08-19
            if (BdSrvDictCodeConst.SD_SRVTP_TREAT_SKINMINGANTEST.Equals(this.uiEmsDTO.MedSrvDO.Sd_srvtp))
            {
                this.ciEmsDTO.Fg_skintest = true;
            }
            if (this.uiEmsDTO.MedSrvDO.Fg_set.Value)
            {
                this.orDataConvert.getCommonOrdSetItemSrv(this.ciEmsDTO, srvCommon, this.uiEmsDTO, 0);
            }
            else
            {
                ciEmsDTO.Emssrvs.Clear();
                ciEmsDTO.Emssrvs.Add(srvCommon);
            }
            // TODO: 费用数据 -> ciemsdto(合并)
            if (expenseList.Count > 0)
            {
                this.MergeExpenseSrv(this.expenseList.ToArray(), this.ciEmsDTO);
            }
            
            //医保保外诊断的处理，fg_selfpay=Y,fg_indic=false
            foreach (CiEmsSrvDTO ciemssrvdto in this.ciEmsDTO.Emssrvs)
            {
                HpJudgeUtil.HandleCiEmsSrvDTOHPInfo(ciemssrvdto);
            }
            ciUseDayAndDtEnd(this.ciEmsDTO);
            this.ciEmsDTO.Fg_vip = this.ent4BannerDTO.Fg_gcvip;//vip标识
            return ordMaintainService.SaveCiEmsDTO(this.ciEmsDTO, BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO);
        }
        protected new void ciUseDayAndDtEnd(CiEmsDTO ciemsdto)
        {
            //频次类型为once，使用天数设置为0,长临标识为false
            if ((string.IsNullOrEmpty(ciemsdto.Sd_frequnitct)) && ciemsdto.Id_freq != null)
            {
                var freqdef = XapServiceMgr.find<IFreqdefMDOCrudService>();
                var freq = freqdef.findById(ciemsdto.Id_freq);
                if (freq != null)
                {
                    if (freq.Sd_frequnitct == BdSrvDictCodeConst.SD_FREQUNIT_ONCE)
                    {
                        ciemsdto.Days_or = 0;
                    }
                }
            }
            else if (ciemsdto.Sd_frequnitct == BdSrvDictCodeConst.SD_FREQUNIT_ONCE)
            {
                ciemsdto.Days_or = 0;
            }
            DateTime? dt_begin = ciemsdto.Dt_begin;
            if (dt_begin != null)
            {
                if (ciemsdto.Days_or != null)
                {
                    ciemsdto.Dt_end = ((DateTime)dt_begin).AddDays((int)ciemsdto.Days_or);
                }
            }
            ciemsdto.Days_or = (ciemsdto.Days_or == 0 || ciemsdto.Days_or == null ? 1 : ciemsdto.Days_or);
            ciemsdto.Fg_long = false;
        }
        /// <summary>
        /// 处理参照过滤逻辑
        /// </summary>
        /// <param name="filedName"></param>
        /// <param name="sbm"></param>
        /// <returns></returns>
        public override string OnRefFilterData(string filedName, StringObjectMap sbm)
        {
            string whereString = "";
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
            else if (filedName.Equals("Name_mp_dep") && !string.IsNullOrWhiteSpace(strMpDepFilter))
            {
                whereString = string.Format("id_dep in ({0})", strMpDepFilter);
            }
            else
            {
                whereString = base.OnRefFilterData(filedName, sbm);
            }
            return "";
        }
        /// <summary>
        /// 处理参照结果返回处理逻辑
        /// </summary>
        /// <param name="fieldName"></param>
        /// <param name="ds"></param>
        /// <returns></returns>
        public override bool OnRefResultData(string fieldName, object ds)
        {
            base.OnRefResultData(fieldName, ds);

            EmsOrDrug drug = ds as EmsOrDrug;
            if (fieldName.Equals("Name_freq"))
            {
                this.uiEmsDTO.Emsdrugs.Times_cur = CalQuantumUtil.GetInstance().getTotalTimes(drug.Id_freq, this.uiEmsDTO.Emsdrugs.Use_days);
                drug.Quan_cur = CalQuantumUtil.GetInstance().getUnMMQuantum(drug.Quan_med, this.uiEmsDTO.Emsdrugs.Times_cur);
                if (drug.Price != null && drug.Quan_cur != null)
                    drug.Totalprice = drug.Price * drug.Quan_cur;
                return true;
            }

            return false;
        }
        /// <summary>
        /// 处理模型数据信息改变逻辑
        /// </summary>
        /// <param name="ds"></param>
        /// <param name="fieldName"></param>
        /// <param name="value"></param>
        public override void OnDataChanged(Object ds, String fieldName, string value)
        {
            var drug = ds as EmsOrDrug;
            // 修改计量信息时候，需要重新计算总量以及金额
            if (fieldName.Equals("customercolumn_med_unit") && drug.Quan_med != null)
            {
                this.uiEmsDTO.Emsdrugs.Times_cur = CalQuantumUtil.GetInstance().getTotalTimes(drug.Id_freq, this.uiEmsDTO.Emsdrugs.Use_days);
                drug.Quan_cur = CalQuantumUtil.GetInstance().getUnMMQuantum(drug.Quan_med, this.uiEmsDTO.Emsdrugs.Times_cur);
                if (drug.Price != null && drug.Quan_cur != null)
                    drug.Totalprice = drug.Price * drug.Quan_cur;
            }
            // 修改使用天数的时候，需要修改总量以及金额
            else if ((fieldName.Equals("Use_days")) && !String.IsNullOrEmpty(value))
            {
                this.uiEmsDTO.Emsdrugs.Use_days = drug.Use_days;
                if (this.uiEmsDTO.Emsdrugs.Use_days != null)
                {
                    this.uiEmsDTO.Emsdrugs.Dt_end_ui = ((DateTime)this.uiEmsDTO.Emsdrugs.Dt_begin_ui).AddDays((int)this.uiEmsDTO.Emsdrugs.Use_days);
                }
                this.uiEmsDTO.Emsdrugs.Times_cur = CalQuantumUtil.GetInstance().getTotalTimes(drug.Id_freq, this.uiEmsDTO.Emsdrugs.Use_days);
                drug.Quan_cur = CalQuantumUtil.GetInstance().getUnMMQuantum(drug.Quan_med, this.uiEmsDTO.Emsdrugs.Times_cur);
                if (drug.Price != null && drug.Quan_cur != null)
                    drug.Totalprice = drug.Price * drug.Quan_cur;
            }
            else if ((fieldName.Equals("Price")) && !String.IsNullOrEmpty(value))
            {
                drug.Quan_cur = CalQuantumUtil.GetInstance().getUnMMQuantum(drug.Quan_med, this.uiEmsDTO.Emsdrugs.Times_cur);
                if (drug.Price != null && drug.Quan_cur != null)
                    drug.Totalprice = drug.Price * drug.Quan_cur;
            }
        }
        /// <summary>
        /// 返回需要隐藏的列表字段
        /// </summary>
        /// <returns></returns>
        public override string[] GetHiddenFields()
        {
            /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
            //治疗类的开单模式
            //string paramStr = (string)BaseEmsView.BaseEmsInfoContext[ICiOrdNSysParamConst.OPDiagTreatTmplOrOpenMode];
            //if (paramStr == null || paramStr.Contains("1"))
            //{ //先开单后执行
            //    return new string[] { "Name_route", "Fg_skintest", "Name_boildes", "Spec_mm", "Fg_treat", "Name_diag", "Dt_plan", "No_applyform", "Fg_extdispense", "customercolumn_sale_unit", "Name_freq", "Use_days" };
            //}
            //else
            //{
            //    return new string[] { "Name_route", "Fg_skintest", "Name_boildes", "Spec_mm", "Fg_treat", "Name_diag", "Dt_plan", "No_applyform", "Fg_extdispense" };
            //}

            List<string> lstFields = new List<string>() { "Name_route", "Fg_skintest", "Name_boildes", "Spec_mm", "Fg_treat", "Name_diag", "Dt_plan", "No_applyform", "Fg_extdispense" };
            bool isHideDose = false;
            bool isHideFreq = false;
            if (this.uiEmsDTO.Emsdrugs.Ismuldose == null || !this.uiEmsDTO.Emsdrugs.Ismuldose.Value)
            {
                isHideDose = true;
                lstFields.Add("customercolumn_med_unit");
            }
            if (this.uiEmsDTO.Emsdrugs.Ismulexec == null || !this.uiEmsDTO.Emsdrugs.Ismulexec.Value)
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
        /// <summary>
        /// 返回列表中的只读字段
        /// </summary>
        /// <returns></returns>
        public override string[] GetReadonlyFields()
        {
            return new string[] { };
        }

        /// <summary>
        /// 服务套的情况下计算价格
        /// </summary>
        /// <param name="medsrvdo"></param>
        /// <returns></returns>
        public FDouble getPrice(MedSrvDO medsrvdo)
        {
            FDouble price = 0;
            if (medsrvdo == null) return price;
            if (medsrvdo.Fg_set != null && (bool)medsrvdo.Fg_set)
            {
                List<CiEmsSrvDTO> srvlist = this.logicEx.getSetClinicalSrvDO(medsrvdo.Id_srv, "00", 0);

                foreach (CiEmsSrvDTO emsdto in srvlist)
                {
                    if (emsdto.Fg_mm != null && (bool)emsdto.Fg_mm)
                    {
                        price = price + this.logicEx.getMaterialStocksCount(emsdto.Id_mm, emsdto.Id_unit_sale);
                    }
                }
                price = price + this.logicEx.getSrvNotMMPri(this.uiEmsDTO.MedSrvDO, null);
            }
            return price;
        }

        private string getDeptParam(string openModelParam)
        {
            string paramStr = this.GetContext().GetDeptParam<string>(openModelParam);
            return paramStr;
        }
    }
}
