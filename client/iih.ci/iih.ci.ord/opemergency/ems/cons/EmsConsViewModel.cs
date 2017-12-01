using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.en.pv.dto.d;
using iih.ci.ord.ciordems.d;
using iih.bd.srv.medsrv.d;
using xap.rui.appfw;
using xap.rui.control.refcontrol.data;
using iih.bd.srv.medsrv.i;
using xap.mw.serviceframework;
using iih.ci.ord.opemergency.ems.common;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.ems.d;
using xap.mw.core.data;
using iih.ci.ord.i;
using iih.ci.ord.dto.emsmain;
using iih.ci.ord.common.utils;
using iih.ci.ord.ciorder.utils;
using xap.rui.control.extentions;
using iih.ci.ord.opemergency.declare;
using iih.ci.ord.ciorder.d;
using iih.bd.srv.ems.d;
using iih.ci.iih.ci.ord.i;

namespace iih.ci.ord.opemergency.ems.dp
{
    /// <summary>
    /// <para>描    述 :  会诊医疗单数据处理模型        	</para>
    /// <para>说    明 :                      			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.ems.dp    </para>    
    /// <para>类 名 称 :  EmsConsViewModel        			</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/6/30 16:27:45             </para>
    /// <para>更新时间 :  2016/6/30 16:27:45             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EmsConsViewModel : BaseEmsViewModel
    {
        #region 常量定义

        public enum ConsType
        {
            InDept = 0,
            InOrga,
        };
        #endregion

        #region 变量定义
        private XapDataList<EmsConsItemDO> tableDataSource = new XapDataList<EmsConsItemDO>();

        #endregion

        #region 构造函数
        public EmsConsViewModel(Ent4BannerDTO ent)
            : base(ent)
        {
        }

        public override void Init()
        {
            base.Init();

            this.uiEmsDTO.EmsType = ciordems.d.EmsType.CONS;
        }

        #endregion

        /// <summary>
        /// 获取列表数据源
        /// </summary>
        /// <returns></returns>
        public override object GetTableDataSource()
        {
            return tableDataSource;
        }

        /// <summary>
        /// 获取Form数据源
        /// </summary>
        /// <returns></returns>
        public override object GetFormDataSource()
        {
            return this.uiEmsDTO.Emsapcons;
        }

        protected override void OnBeforeCallServiceSave(CiEmsDTO ems)
        {
            base.OnBeforeCallServiceSave(ems);

            ems.Fg_mp_in = true;
            if (ems.Emssrvs != null)
                ems.Emssrvs.Cast<CiEmsSrvDTO>().Where(srv => srv.Eu_sourcemd == (int)ciorder.d.OrSrvSourceFromEnum.PHYSIAN).ToList().ForEach(srv =>
                {
                srv.Quan_total_medu = 0;
            });
        }

        public override bool IsEmpty()
        {
            return tableDataSource == null || tableDataSource.Count == 0 ||
                (tableDataSource.Count == 1 && String.IsNullOrEmpty(tableDataSource[0].Id_srv));
        }

        /// <summary>
        /// 从服务项新建医疗单医嘱条目
        /// </summary>
        /// <param name="med"></param>
        /// <param name="pos"></param>
        /// <returns></returns>
        public override bool LoadMedSrv(EmsCreatedParameter emsCreateParameter, int pos)  //EmsCreateParameter
        {
            base.LoadMedSrv(emsCreateParameter, pos);
            MedSrvDO med = emsCreateParameter.getMedSrvDO();
            // 暂存药品服务
            this.uiEmsDTO.MedSrvDO = med;
            EmsRstDTO[] rsts = CreateRemote(med.Id_srv);
            EmsRstDTO rst = rsts[0];
                if (rst != null)
                {
                uiEmsDTO.Emsapcons.deSerializeJson((rst.Document[0] as EmsConsItemDO).serializeJson());
                //String utf8Str = System.Text.Encoding.UTF8.GetString(Convert.FromBase64String(rst.DocumentString));
                //uiEmsDTO.Emsapcons.deSerializeJson(utf8Str);

                    if (rst.Extension != null && rst.Extension.Keys.Contains("MedSrvDO"))
                    {
                        this.uiEmsDTO.MedSrvDO = rst.Extension["MedSrvDO"] as MedSrvDO;
                        this.strSd_srvtp = this.uiEmsDTO.MedSrvDO.Sd_srvtp;
                    }
                    this.uiEmsDTO.Emsapcons.Dt_begin_ui = this.uiEmsDTO.Emsapcons.Dt_begin_ui == null ? this.NowTime() : this.uiEmsDTO.Emsapcons.Dt_begin_ui;
                    this.uiEmsDTO.Emsapcons.Use_days = 1;
                    this.uiEmsDTO.Emsapcons.Dt_end_ui = ((DateTime)this.uiEmsDTO.Emsapcons.Dt_begin_ui).AddDays((int)this.uiEmsDTO.Emsapcons.Use_days);
                    this.uiEmsDTO.Emsapcons.Times_cur = CalQuantumUtil.GetInstance().getTotalTimes(med.Id_freq, this.uiEmsDTO.Emsapcons.Use_days);
                    this.tableDataSource.Clear();
                    this.tableDataSource.Add(uiEmsDTO.Emsapcons);

                    if (this.uiEmsDTO.Emsapcons.ConsAssList != null)
                    {
                        if (null == this.uiEmsDTO.Emsapcons.EmsConsAssistItem)
                        {
                            this.uiEmsDTO.Emsapcons.EmsConsAssistItem = new XapDataList<EmsItemInCons>();
                        }
                        this.uiEmsDTO.Emsapcons.EmsConsAssistItem.Clear();
                    this.uiEmsDTO.Emsapcons.ConsAssList.Cast<EmsItemInCons>().ToList().ForEach(o =>
                    {
                            this.uiEmsDTO.Emsapcons.EmsConsAssistItem.Add(o);
                        });
                    }
                    if (this.uiEmsDTO.Emsapcons.ConsItemList != null)
                    {
                        if (null == this.uiEmsDTO.Emsapcons.EmsConsItem)
                        {
                            this.uiEmsDTO.Emsapcons.EmsConsItem = new XapDataList<EmsItemInCons>();
                        }
                        this.uiEmsDTO.Emsapcons.EmsConsItem.Clear();
                    this.uiEmsDTO.Emsapcons.ConsItemList.Cast<EmsItemInCons>().ToList().ForEach(o =>
                    {
                            this.uiEmsDTO.Emsapcons.EmsConsItem.Add(o);
                        });
                    }
                    
                }

            return true;
        }

        /// <summary>
        /// 编辑医嘱条目
        /// </summary>
        /// <param name="ciOrderDO"></param>
        public override void EditOrder(ciorder.d.CiOrderDO ciOrderDO)
        {
            EmsRstDTO[] rsts = LoadRemote(ciOrderDO.Id_or);
            EmsRstDTO rst = rsts[0];
                if (rst != null)
                {
                    uiEmsDTO.Status = DOStatus.UPDATED;

                uiEmsDTO.Emsapcons.deSerializeJson((rst.Document[0] as EmsConsItemDO).serializeJson());
                //String utf8Str = System.Text.Encoding.UTF8.GetString(Convert.FromBase64String(rst.DocumentString));
                //uiEmsDTO.Emsapcons.deSerializeJson(utf8Str);

                    if (rst.Extension != null && rst.Extension.Keys.Contains("CiEmsDTO"))
                    {
                        this.ciEmsDTO = rst.Extension["CiEmsDTO"] as CiEmsDTO;
                    }
                    if (rst.Extension != null && rst.Extension.Keys.Contains("MedSrvDO"))
                    {
                        this.uiEmsDTO.MedSrvDO = rst.Extension["MedSrvDO"] as MedSrvDO;
                    }
                    
                    // 附加手术项目
                    if (uiEmsDTO.Emsapcons.ConsAssList != null)
                    {
                    uiEmsDTO.Emsapcons.ConsAssList.Cast<EmsItemInCons>().ToList().ForEach(p =>
                    {
                            uiEmsDTO.Emsapcons.EmsConsAssistItem.Add(p);
                        });

                        if (uiEmsDTO.Emsapcons.EmsConsAssistItem.Count > 0)
                        {
                            uiEmsDTO.Emsapcons.Id_dep_emp = uiEmsDTO.Emsapcons.EmsConsAssistItem[0].Id_dep_emp;
                            uiEmsDTO.Emsapcons.Name_dep_emp = uiEmsDTO.Emsapcons.EmsConsAssistItem[0].Name_dep_emp;
                            uiEmsDTO.Emsapcons.Id_emp_doctor = uiEmsDTO.Emsapcons.EmsConsAssistItem[0].Id_emp_doctor;
                            uiEmsDTO.Emsapcons.Name_emp_doctor = uiEmsDTO.Emsapcons.EmsConsAssistItem[0].Name_emp_doctor;
                        }
                    }

                    // 状态处理
                    uiEmsDTO.Emsapcons.Status = uiEmsDTO.Status;
                    this.tableDataSource.Add(uiEmsDTO.Emsapcons);
                    this.ciEmsDTO.Status = DOStatus.UPDATED;
                    this.uiEmsDTO.Status = DOStatus.UPDATED;

                    // 处理分拣费用项目
                    HandleExpenseItems(ciEmsDTO);

                }
            }

            
        public override void EditEms(CiEmsDTO ems)
        {
            base.EditEms(ems);

            orCiEmsToUiEms.EditCons(uiEmsDTO, ems);
            this.uiEmsDTO.Status = DOStatus.NEW;

            this.tableDataSource.Clear();

            // 如模型为空  第一次创建
            IMedsrvMDOCrudService service = XapServiceMgr.find<IMedsrvMDOCrudService>();
            MedSrvDO medSrcDO = service.findById(ems.Id_srv);

            uiEmsDTO.Emsapcons.Name_srv = medSrcDO.Name;

            MedSrvConsDO srvcons = this.logicEx.GetCons(this.uiEmsDTO.MedSrvDO.Id_srv);
            if (srvcons != null)
            {
                uiEmsDTO.Emsapcons.Fg_deps = srvcons.Fg_deps;
                uiEmsDTO.Emsapcons.Fg_inorg = srvcons.Fg_inorg;
            }
            if (uiEmsDTO.Emsapcons.EmsConsAssistItem.Count > 0)
            {
                uiEmsDTO.Emsapcons.Id_dep_emp = uiEmsDTO.Emsapcons.EmsConsAssistItem[0].Id_dep_emp;
                uiEmsDTO.Emsapcons.Name_dep_emp = uiEmsDTO.Emsapcons.EmsConsAssistItem[0].Name_dep_emp;
                uiEmsDTO.Emsapcons.Id_emp_doctor = uiEmsDTO.Emsapcons.EmsConsAssistItem[0].Id_emp_doctor;
                uiEmsDTO.Emsapcons.Name_emp_doctor = uiEmsDTO.Emsapcons.EmsConsAssistItem[0].Name_emp_doctor;
            }

            this.tableDataSource.Add(uiEmsDTO.Emsapcons);
        }

        /// <summary>
        /// 会诊保存
        /// </summary>
        /// <returns></returns>
        public override CiOrderDO Save2Order()
        {
            return base.Save2Order();
        }
       
        /// <summary>
        /// 新会诊远程保存逻辑调用
        /// </summary>
        /// <returns></returns>
        public CiOrderDO New_Save()
        {
            ICiEmsMainService emsMainService = XapServiceMgr.find<ICiEmsMainService>();
            if (null != emsMainService)
            {
                var emsSave = new EmsSaveDTO();
                this.uiEmsDTO.Emsapcons.Id_srvof = emsMgrDTO.Id_ems;

                emsSave.Document = new FArrayList();
                emsSave.Document.Add(this.uiEmsDTO.Emsapcons);
                emsSave.EnContext = CiEnContextUtil.GetCiEnContext(this.GetEnt4BannerDTO(), EmsAppModeEnum.SVEMSAPPMODE, OrSourceFromEnum.IIHSRVREF, this.GetContext());
                emsSave.EmsDriver = ((int)this.uiEmsDTO.EmsType).ToString();
                EmsRstDTO rst = emsMainService.save(emsSave);
                if (rst != null)
                {

                    return (rst.Document[0] as CiorderAggDO).getParentDO();

                }
            }

            return null;
        }

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

            string wherePart = base.OnRefFilterData(filedName, sbm);
            if (wherePart != "") return wherePart;
            if (filedName.Equals("Name_emp_doctor"))
            {

                if (this.uiEmsDTO.Emsapcons.Id_dep_emp != null)
                {
                    wherePart = " bd_psndoc.id_dep = '" + this.uiEmsDTO.Emsapcons.Id_dep_emp + "'";

                }

            }
            else if (filedName.Equals("Name_dep_emp"))
            {
                wherePart = string.Format("id_dep <> '{0}' and  SD_DEPTTP = '01'", this.uiEmsDTO.Emsapcons.Id_dep_cons);

            }
            else if (filedName.Equals("Name_di"))
            {
                sbm.Add("id_ent", GetEnt4BannerDTO().Id_ent);
            }
            return wherePart;
        }

        public override bool OnRefResultData(string fieldName, Object ds)
        {
            if (!base.OnRefResultData(fieldName, ds))
            {
                bool result = false;
                if (fieldName.Equals("Name_dep_emp"))
                {
                    uiEmsDTO.Emsapcons.EmsConsAssistItem[0].Id_dep_emp = uiEmsDTO.Emsapcons.Id_dep_emp;
                    uiEmsDTO.Emsapcons.EmsConsAssistItem[0].Name_dep_emp = uiEmsDTO.Emsapcons.Name_dep_emp;
                    result = true;
                }
                else if (fieldName.Equals("Name_emp_doctor"))
                {
                    uiEmsDTO.Emsapcons.EmsConsAssistItem[0].Id_emp_doctor = uiEmsDTO.Emsapcons.Id_emp_doctor;
                    uiEmsDTO.Emsapcons.EmsConsAssistItem[0].Name_emp_doctor = uiEmsDTO.Emsapcons.Name_emp_doctor;
                    result = true;
                }

                return result;
            }

            return true;
        }

        protected override void HandleTotlePriceInfo(EmsOrDrug drug)
        {
            if (drug.Fg_or != null && drug.Fg_or == false
                && drug.Fg_bl != null && drug.Fg_bl == true)
            {

                if (drug.Quan_cur == null || drug.Quan_cur == 0)
                {
                    if (drug.Fg_mm != null && drug.Fg_mm == true)
                    {
                        this.logicEx.GetDrugTotal(drug, null, this.GetEnt4BannerDTO().Code_entp, true);
                    }
                    else
                    {
                        drug.Quan_cur = this.logicEx.getNotDrugTotal(drug.Quan_med.ToDouble(), drug.Id_freq, drug.Freqct.Value);
                    }
                }

            }
            if (drug.Fg_or != null && drug.Fg_or.Value)
            {
                drug.Quan_cur = 1;
            }
            if (drug.Price != null && drug.Quan_cur != null)
            {
                drug.Totalprice = drug.Price * drug.Quan_cur;
            }
        }
        public override string[] GetHiddenFields()
        {
            string[] res = null;
            if (isInDeptCons())
            {
                res = new string[] { "customercolumn_dep_invitors", "Fg_treat", "Name_diag", "Dt_plan", "No_applyform", "Fg_extdispense" };
            }
            else if (isInOrgDeptsCons())
            {
                res = new string[] { "Name_dep_emp", "Name_emp_doctor", "Fg_treat", "Name_diag", "Dt_plan", "No_applyform", "Fg_extdispense" };
            }
            return res;
        }

        public override string[] GetFixedFields()
        {
            return new string[] { "Name_srv", "Fg_urgent", "Dt_plan", "Name_dep_emp" };
        }

        public override string[] GetReadonlyFields()
        {
            return new string[] { };
        }

        /// <summary>
        /// 科间会诊： 院内会诊标志fg_inorg =院内 and 多科会诊标志fg_deps = 一个科室
        /// </summary>
        /// <returns></returns>
        public bool isInDeptCons()
        {
            return (uiEmsDTO.Emsapcons.Fg_inorg != null && uiEmsDTO.Emsapcons.Fg_inorg.Value == true
                && ((uiEmsDTO.Emsapcons.Fg_deps != null && uiEmsDTO.Emsapcons.Fg_deps.Value == false) || uiEmsDTO.Emsapcons.Fg_deps == null));

        }

        /// <summary>
        ///  院内会诊标志fg_inorg =院内 and 多科会诊标志fg_deps = 多个科室
        /// </summary>
        /// <returns></returns>
        public bool isInOrgDeptsCons()
        {
            return (uiEmsDTO.Emsapcons.Fg_inorg != null && uiEmsDTO.Emsapcons.Fg_inorg.Value == true
                && uiEmsDTO.Emsapcons.Fg_deps != null && uiEmsDTO.Emsapcons.Fg_deps.Value == true);
        }

        /// <summary>
        /// 院内会诊标志fg_inorg = 院外
        /// </summary>
        /// <returns></returns>
        public bool isOutOrgCons()
        {
            return (uiEmsDTO.Emsapcons.Fg_inorg != null && uiEmsDTO.Emsapcons.Fg_inorg.Value == true);
        }

    }
}
