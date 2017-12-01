using System;
using System.Collections.Generic;
using System.Linq;
using iih.bd.srv.medsrv.i;
using iih.ci.ord.ems.d;
using iih.ci.ord.i;
using xap.mw.serviceframework;
using iih.ci.iih.ci.ord.dto.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using xap.mw.core.data;
using xap.rui.appfw;
using iih.ci.ord.ordsrvmm.d;
using iih.ci.ord.ciorder.utils;
using iih.en.pv.dto.d;
using iih.ci.ord.emsdi.d;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.bl.hp.bdhpindicationdto.d;
using iih.ci.ord.opemergency.ems.common;
using iih.bd.iih.bd.bc.udi;
using iih.bd.bc.udi;
using iih.bd.srv.medsrv.d;
using xap.rui.engine;
using iih.ci.ord.opemergency.tool;

namespace iih.ci.ord.opemergency.view.expenseview.model
{
    /// <summary>
    /// <para>描    述 :  费用模型           			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.view.expenseview.model    </para>    
    /// <para>类 名 称 :  ExpenseModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/7/12 11:16:54             </para>
    /// <para>更新时间 :  2016/7/12 11:16:54             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class ExpenseModel
    {
        #region 变量定义
        private CiEmsDTO emsDto;
        private object emsViewModel;
        protected XapDataList<EmsOrDrug> tableDataSource;

        private ICiOrdQryService ciOrdQryService;
        protected Ent4BannerDTO ent4BannerDTO;
        private int nCurrentSelIndex = -1;
        private EmsOrDrug[] szEmsOrDrug = null;
        //private MedSrvDO medsrv;
        #endregion

        #region 构造方法
        public ExpenseModel(XapDataList<EmsOrDrug> ds)
        {
            this.ciOrdQryService = XapServiceMgr.find<ICiOrdQryService>();

            tableDataSource = ds;
            if (tableDataSource == null)
            {
                this.tableDataSource = new XapDataList<EmsOrDrug>();
            }


        }
        #endregion

        #region 接口

        public LogicEx GetLogicEx()
        {
            return LogicEx.GetInstance();
        }

        public EmsOrDrug[] GetQryBuffer()
        {
            return szEmsOrDrug;
        }

        public void SetNullQryBuffer()
        {
            szEmsOrDrug = null;
        }

        public virtual ExpenseModel Reload(object ems = null)
        {
            if (emsDto == null /*|| emsDto.IsUPDATED*/)
                return this;
          
            this.DeleteAllItems();
            if (this.tableDataSource.Count(p => !p.IsDELETED) == 0) {
                
                //if (this.emsDto.Status == DOStatus.UPDATED )
                //{
                //    emsDto.Status = DOStatus.NEW;
                //    emsDto.Emssrvs.Cast<CiEmsSrvDTO>().ToList().ForEach(p => { if (p.Status != DOStatus.DELETED) p.Status = DOStatus.UPDATED; });
                //}
                CiOrAggAndRelInfo info = this.ciOrdQryService.getCiOrAggAndRelInfo8Ems(this.emsDto, BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO);
               // medsrv = XapServiceMgr.find<IMedsrvMDOCrudService>().findById(emsDto.Id_srv);
                this.emsDto.Fg_prisrvhandled = true;
                if (null == info) {
                    return this;
                }

                // 转化为视图显示模型
                this.szEmsOrDrug = Convert2Drugs(info, this.emsViewModel);

            }


            return this;
        }
        /// <summary>
        /// 刷新数据
        /// </summary>
        /// <param name="ems"></param>
        /// <returns></returns>
        public virtual ExpenseModel Refresh(object ems = null)
        {

            // 清空，数据源存储对象的过程是由医疗单中针对项目的操作来决定的，此处不应该清空数据源。

            if (GetQryBuffer() != null) {
               
                this.GetQryBuffer().ToList().ForEach(p =>
                {
                    this.tableDataSource.Add(p);
                });
                this.SetNullQryBuffer();
            }


            return this;
        }

        public ExpenseModel AppendOtherExpenses(EmsOrDrug[] szExpense)
        {
            if (szExpense != null) {
                szExpense.ToList().ForEach(item =>
                {
                    item.SetUpdated();
                    this.tableDataSource.Add(item);
                });
            }

            return this;
        }

        public ExpenseModel SetEnt4BannerDTO(Ent4BannerDTO ent)
        {
            this.ent4BannerDTO = ent;

            return this;
        }
        public Ent4BannerDTO getEnt4BannerDTO() {
            return this.ent4BannerDTO;
        }
        /// <summary>
        /// 设置医疗单的存储模型
        /// </summary>
        /// <param name="ems"></param>
        /// <returns></returns>
        public ExpenseModel SetEmsSaveModel(CiEmsDTO ems)
        {
            this.emsDto = ems;

            return this;
        }

        public CiEmsDTO GetEmsSaveModel()
        {
            return this.emsDto;
        }

        /// <summary>
        /// 设置医疗单的显示模型
        /// </summary>
        /// <param name="emsViewModel"></param>
        /// <returns></returns>
        public ExpenseModel SetEmsViewModel(object emsViewModel)
        {
            this.emsViewModel = emsViewModel;

            return this;
        }

        public object GetEmsViewModel()
        {
            return this.emsViewModel;
        }

        public void ClearContext()
        {
            if (this.tableDataSource != null)
            {
                this.tableDataSource.Clear();
            
            }
            this.emsViewModel = null;
            this.emsDto = null;
            this.SetNullQryBuffer();
        }

        public void DeleteAllItems()
        {
            if (this.tableDataSource != null)
            {
                this.tableDataSource.ToList().ForEach(p =>
                {
                    this.tableDataSource.Delete(p, p.IsNEW);
                });
            }
        }

        public void ReCalculateInfo(EmsOrDrug newDrug)
        {

            #region 计算总量和价格
            if (null != newDrug)
            {
                newDrug.Quan_cur = this.GetLogicEx().getNotDrugTotal(
                newDrug.Quan_med.ToDouble(),
                newDrug.Id_freq,
                newDrug.Freqct == null ? 1 : newDrug.Freqct.Value,
                newDrug.Use_days == null ? 1 : newDrug.Use_days.Value);

                newDrug.Price = this.GetLogicEx().getSrvNotMMPri(newDrug.Id_srv, newDrug.Id_pri);
                newDrug.Totalprice = newDrug.Price * newDrug.Quan_cur;
            }

            #endregion
        }

        #endregion

        #region 连接方法
        public ExpenseModel And()
        {
            return this;
        }
        #endregion

        #region 辅助方法
        public ExpenseModel SetCurrentSelect(int n)
        {
            this.nCurrentSelIndex = n;

            return this;
        }
        #endregion

        #region 覆盖方法
        protected virtual EmsOrDrug[] Convert2Drugs(CiOrAggAndRelInfo info, object viewModel)
        {

            return null;
        }

        /// <summary>
        /// 将 OrdSrvDO 列表数据转化为 EmsOrDrug 数据
        /// </summary>
        /// <param name="orAggDO"></param>
        /// <param name="tmpCacheSrv"></param>
        /// <returns></returns>
        protected virtual EmsOrDrug[] ToEmsOrDrugs(CiorderAggDO orAggDO, Dictionary<String, object> tmpCacheSrv = null, FMap srvMmMap = null, FMap blsrvFMap = null)
        {
            List<EmsOrDrug> szDrugs = new List<EmsOrDrug>();
            
            // 处理附加项
            for (int i = 0; i < orAggDO.ChildrenList.Count; ++i)
            {
                for (int index = 0; index < orAggDO.ChildrenList[i].Count; ++index)
                {

                    OrdSrvDO obj = orAggDO.ChildrenList[i][index] as OrdSrvDO;

                    // 获取医嘱医疗单相关信息
                    object ordSrvItem = null;

                    // 过滤 Fg_bl = false 的项目
                    //if (obj.Fg_bl == null || obj.Fg_bl == false)
                    //{
                    //    continue;
                    //}
                    if (obj.Status == DOStatus.DELETED) continue;
                    // 检阅 EmsOrDrug 内容，可以根据医疗单数据进行修正
                    EmsOrDrug drug = HandleEmsOrDrug(
                        // 根据医嘱服务创建 UI EmsOrDrug 对象以及数据
                        EmsOrDrugWithOrdSrvDO(
                        obj,
                        orAggDO.getParentDO().Days_or != null ? orAggDO.getParentDO().Days_or.Value : 1,
                        (srvMmMap != null && srvMmMap.Keys.Contains(obj.Id_srv)) ? srvMmMap[obj.Id_srv] as OrdSrvMmDO : null
                        ),
                        ordSrvItem
                        );
                    //费用注意信息
                    if (blsrvFMap != null && blsrvFMap.Keys.Count != 0)
                    {
                        if (blsrvFMap.Keys.Contains(obj.Id_srv))
                            drug.Des = (blsrvFMap[obj.Id_srv] as MedSrvDO).Des;
                    }
                    // 计算总量和总金额
                    if (drug.Fg_mm != null && drug.Fg_mm.Value)
                    {
                        if(drug.Quan_cur == null)
                            GetLogicEx().GetDrugTotal(drug, null, ent4BannerDTO.Code_entp, true);
                        
                        ////药品的总价=总量*单价
                        //if (drug.Quan_cur!=null&&drug.Price!=null)
                        //    drug.Totalprice = drug.Quan_cur * drug.Price;
                    }
                    else {
                        drug.Quan_cur = obj.Quan_total_medu;
                        if (drug.Quan_cur != null && drug.Price != null)
                            drug.Totalprice = drug.Quan_cur * drug.Price;
                    }
                    //只有没有执行科室的时候才查询
                    if (string.IsNullOrEmpty(drug.Id_mp_dep) || string.IsNullOrEmpty(drug.Name_mp_dep)) {
                        // 计算执行科室
                        CalculateDeptMp(drug);    
                    }

                    szDrugs.Add(drug);
                }
            }
            return szDrugs.ToArray();
        }


        public virtual object AddRow(object param = null)
        {
            return tableDataSource.AddNew();
        }

        public virtual ExpenseModel DeleteRow(EmsOrDrug eod)
        {
            if (eod != null && tableDataSource != null)
            {
               
                tableDataSource.Delete(eod, eod.IsNEW);

            }
            return this;
        }

        public bool HasSameFeeSrv(EmsOrDrug newDrug)
        {
            return (tableDataSource.Count(p => !p.IsDELETED && p.Id_srv.Equals(newDrug.Id_srv)) > 1); // 包含自身情况
           
        }
        //医嘱的定价模式是否是不计费
        public bool isNoFeeOrd()
        {
            bool flag = false;
            //if (medsrv.Sd_primd == BdPpDictCodeConst.CODE_PRI_FREE) flag = true;
            return flag;
        }

        public virtual ExpenseModel LoadEmsOrDrug(EmsOrDrug newDrug)
        {
            // if (nCurrentSelIndex >= 0 && nCurrentSelIndex < tableDataSource.Count(p=>!p.IsDELETED))
            {
                
                // 填充默认值
                newDrug.Use_days = 1;
                newDrug.Id_unit_sale = newDrug.Id_unit_med;
                newDrug.Name_unit_sale = newDrug.Name_unit_med;
                newDrug.Fg_or = false;
                newDrug.Fg_bl = true;
                newDrug.Eu_sourcemd = (int)OrSrvSourceFromEnum.PHYSIANFEEADD;
                #region 计算总量和价格
                newDrug.Quan_cur = this.GetLogicEx().getNotDrugTotal(
                    newDrug.Quan_med.ToDouble(),
                    newDrug.Id_freq,
                    newDrug.Freqct == null ? 1 : newDrug.Freqct.Value,
                    newDrug.Use_days == null ? 1 : newDrug.Use_days.Value);

                newDrug.Price = this.GetLogicEx().getSrvNotMMPri(newDrug.Id_srv, newDrug.Id_pri);
                newDrug.Totalprice = newDrug.Price * newDrug.Quan_cur;
                #endregion
                FArrayList list = new FArrayList();
                //判断是否是保外诊断
                CiEnContextDTO ciEnContextDTO = BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO;
                //保外诊断标识
                string eu_hpbeyond = ciEnContextDTO.Eu_hpbeyond;

                if (ent4BannerDTO != null && true == ent4BannerDTO.Fg_hpfundpay && HpBeyondEnum.HPDIAG.Equals(ciEnContextDTO.Eu_hpbeyond)/*保内诊断*/)
                {
                    BdHpIndicationDTO bdhpindication = HpJudgeUtil.getInstance().getBdHpIndicationDTO(newDrug.Id_srv, newDrug.Id_mm, this.ent4BannerDTO);
                    if (bdhpindication != null)
                    {
                        newDrug.Fg_treat = bdhpindication.Fg_indic;
                        newDrug.Id_hp = bdhpindication.Id_hp;
                        newDrug.Sd_hpsrvtp = bdhpindication.Sd_hpsrvtp;
                        newDrug.Id_hpsrvtp = bdhpindication.Id_hpsrvtp;
                        if (string.IsNullOrEmpty(bdhpindication.Id_hpsrvtp)) {
                            newDrug.Id_hpsrvtp = HpJudgeUtil.IdHpSrvtpFromSdHpSrvtp(bdhpindication.Sd_hpsrvtp);
                        }
                        newDrug.Name_hpsrvtp = HpJudgeUtil.NameHpSrvtpFromSdHpSrvtp(bdhpindication.Sd_hpsrvtp);
                        newDrug.Fg_selfpay = HpJudgeUtil.getInstance().isSelfPay(bdhpindication);
                        newDrug.Fg_hpindicjudged = HpJudgeUtil.getInstance().getFg_hpindicjudged(bdhpindication);
                        list.Add(bdhpindication);
                    }
                }
                else if (ciEnContextDTO.Fg_hpfundpay == null || !(bool)ciEnContextDTO.Fg_hpfundpay || (ciEnContextDTO.Eu_hpbeyond != null && !ciEnContextDTO.Eu_hpbeyond.Equals(HpBeyondEnum.HPDIAG)))
                {
                    newDrug.Fg_treat = false;
                    newDrug.Fg_selfpay = true;
                }
                newDrug.BdHpIndicationDTO = list;
                #region 计算执行科室
                CalculateDeptMp(newDrug);
                #endregion


            }
            return this;
        }

        protected void CalculateDeptMp(EmsOrDrug newDrug)
        {
            #region 计算执行科室
            // if (newDrug.Id_mp_dep == null || newDrug.Id_mp_dep.Length == 0) 
            {
                //执行科室
                OrWfDeptInfoDTO wf = new GetDeptMpImp().GetDept_mp_ids(
                   this.ent4BannerDTO.Code_entp,
                   this.ent4BannerDTO.Id_entp,
                   newDrug.Sd_srvtp,
                   newDrug.Id_srvca,
                   newDrug.Id_srv,
                   newDrug.Id_route,
                   "",
                   this.ent4BannerDTO.Id_dep_nur,
                   this.ent4BannerDTO.Id_dep_phy,
                   GetOrdDeptMp());
                if (wf != null) {
                    newDrug.Id_mp_dep = wf.Firstid_mp_dept;
                    newDrug.Name_mp_dep = wf.Firstname_mp_dept;
                    newDrug.setAttrVal("str_id_mp_deps", wf.Id_mp_depts);
                }
            }
            #endregion
        }

        protected virtual String GetOrdDeptMp()
        {
            return "";
        }

        public virtual object GetTableDataSource()
        {
            return tableDataSource;
        }

        public bool HasEmptyRow()
        {
            return tableDataSource.Count(p => !p.IsDELETED && string.IsNullOrEmpty(p.Id_srv)) > 0;
        }

        #endregion

        #region 虚拟方法
        /// <summary>
        /// 
        /// </summary>
        /// <param name="drug"></param>
        /// <param name="ordSrv"></param>
        /// <param name="useDays"></param>
        /// <param name="srvMm"></param>
        /// <returns></returns>
        protected virtual EmsOrDrug EmsOrDrugWithOrdSrvDO( OrdSrvDO ordSrv, int useDays = 1, OrdSrvMmDO srvMm = null)
        {
            EmsOrDrug drug = new EmsOrDrug();
            drug.Code_mm = (srvMm != null ? srvMm.Code_mm : null);
            drug.Code_srv = ordSrv.Code_srv;
            drug.Des = ordSrv.Note_srv;
            drug.Id_srv_src = ordSrv.Id_srv_src; // 服务所属来源
            drug.Id_boil = ordSrv.Id_boil;
            drug.Name_boil = ordSrv.Boil_name;
            drug.Id_routedes = ordSrv.Id_routedes;
            drug.Name_routedes = ordSrv.Routedes_name;
            drug.Priby = ordSrv.Priby;
            drug.Id_pri = ordSrv.Id_primd;

            //             drug.Fact_count 
            drug.Factor_cb = (srvMm != null ? srvMm.Factor : null);
            drug.Factor_mb = (srvMm != null ? srvMm.Factor_mb : null);
            //drug.Fg_anti = ordSrv.Fg_anti;
            drug.Fg_bl = ordSrv.Fg_bl;
            //         drug.Fg_chk = ordSrv
            drug.Fg_ctm = ordSrv.Fg_selfsrv;  //自定义服务
            drug.Fg_dose_anoma = ordSrv.Fg_dose_anoma;
            drug.Fg_mm = ordSrv.Fg_mm;
            drug.Fg_otc = (srvMm != null ? srvMm.Fg_otc : null);
            //          drug.Fg_pois = 
            drug.Fg_propc = ordSrv.Fg_propc;
            drug.Fg_self = ordSrv.Fg_self;
            drug.Fg_selfpay = ordSrv.Fg_selfpay;
            drug.Fg_skintest = ordSrv.Fg_skintest;
            drug.Fg_treat = ordSrv.Fg_indic;
            //        drug.Fg_urgent = ordSrv
            drug.Fg_or = ordSrv.Fg_or;
            drug.Fg_bl = ordSrv.Fg_bl;
            drug.Eu_sourcemd = ordSrv.Eu_sourcemd;
            drug.Freqct = (ordSrv.Freqct == null ? 1 : ordSrv.Freqct);
            //        drug.Hpdes = ordSrv
            drug.Id_anti = (srvMm != null ? srvMm.Id_anti : null);
            drug.Id_antipsy = (srvMm != null ? srvMm.Id_antipsy : null);
            drug.Id_boildes = ordSrv.Id_boildes;
            drug.Id_dosage = (srvMm != null ? srvMm.Id_dosage : null);
            //         drug.Id_emsordrug = ordSrv
            drug.Id_freq = ordSrv.Id_freq;
            drug.Sd_frequnitct = ordSrv.Sd_frequnitct;
            //        drug.Id_freqtime = ordSrv
            drug.Id_hp = ordSrv.Id_hp;
            drug.Id_hpsrvtp = ordSrv.Id_hpsrvtp;
            drug.Sd_hpsrvtp = ordSrv.Sd_hpsrvtp;
            drug.Limit = ordSrv.Des_hplimit;
            //判断医生是否已经处理医保信息的标识
            drug.Fg_hpindicjudged = ordSrv.Fg_hpindicjudged;
            drug.Id_mm = (srvMm != null ? srvMm.Id_mm : null);
            drug.Id_mmtp = (srvMm != null ? srvMm.Id_mmtp : null);
            drug.Id_mp_dep = ordSrv.Id_dep_mp;
            drug.Id_or_rel = ordSrv.Id_or_rel;
            drug.Id_orsrv = ordSrv.Id_orsrv;

            drug.Id_pharm = (srvMm != null ? srvMm.Id_pharm : null);
            drug.Id_pois = (srvMm != null ? srvMm.Id_pois : null);
            drug.Id_pri = ordSrv.Id_primd;
            drug.Id_reltp = ordSrv.Id_reltp;
            drug.Id_route = ordSrv.Id_route;
            drug.Id_skintest_skip_reason = ordSrv.Id_skintest_skip_reason;
            drug.Id_srv = ordSrv.Id_srv;
            drug.Id_srvca = ordSrv.Id_srvca;
            
            drug.Id_srvmm = (srvMm != null ? srvMm.Id_orsrvmm : null);
            //          drug.Id_srvskin = 
            drug.Id_srvtp = ordSrv.Id_srvtp;
            drug.Id_pgku_cur = (srvMm != null ? srvMm.Id_pgku_cur : ordSrv.Id_medu);
            drug.Id_unit_base = (srvMm != null ? srvMm.Id_pgku_base : null);
            drug.Id_unit_med = ordSrv.Id_medu;
            drug.Id_unit_sale = (srvMm != null ? srvMm.Id_pgku_cur : ordSrv.Id_medu);
            drug.Id_val = (srvMm != null ? srvMm.Id_val : null);
            
            drug.Name_boildes = ordSrv.Boil_name;
            drug.Name_freq = ordSrv.Freq_name;
            //         drug.Name_freqtime = ordSrv
            //         drug.Name_hp = ordSrv.n
            drug.Name_hpsrvtp = ordSrv.Name_hpsrvtp;

            drug.Name_mm = (srvMm != null ? srvMm.Name_mm : null);
            //            drug.Name_mmtp = 
            drug.Name_mp_dep = ordSrv.Dep_mp_name;
            drug.Name_pgku_cur = (srvMm != null ? srvMm.Name_pgku_cur : ordSrv.Medu_name);
            drug.Name_unit_sale = (srvMm != null ? srvMm.Name_pgku_cur : ordSrv.Medu_name); // 零售单位 = 总量单位 = 剂量单位
            drug.Name_route = ordSrv.Route_name;
            drug.Name_srv = ordSrv.Name;
            drug.Name_unit_base = (srvMm != null ? srvMm.Name_pgku_base : null);
            drug.Name_unit_med = ordSrv.Medu_name;

            //         drug.Note_ext = ordSrv
            drug.Note_or = ordSrv.Note_srv;
          
            //当服务是物品时，单价应该从物品的do中取得
            if (srvMm != null)
            {
                drug.Price = srvMm.Price_pgku_cur;
            }
            else
            {
                drug.Price = ordSrv.Pri;
            }
            //         drug.Pycode = ordSrv
            drug.Use_days = useDays;
            if (srvMm != null && srvMm.Quan_den_base != null)
                drug.Quan_base = (srvMm != null ? srvMm.Quan_num_base / srvMm.Quan_den_base : null); // 单次数量
            drug.Quan_med = (ordSrv.Quan_medu == null ? 1 : ordSrv.Quan_medu);
            if (ordSrv.Fg_mm != null && ordSrv.Fg_mm.Value && !ordSrv.Sd_srvtp.Equals(BdSrvDictCodeConst.SD_SRVTP_BLOODPROD_BLOODPROD_USEBLOOD))
            {
                drug.Quan_cur = srvMm==null?null:srvMm.Quan_cur;
            }
            else {
                drug.Quan_cur = ordSrv.Quan_total_medu;
            }
            drug.Totalprice = (drug.Quan_cur == null ? 0 : drug.Quan_cur) * (drug.Price == null ? 0 : drug.Price);
            drug.Sd_anti = (srvMm != null ? srvMm.Sd_anti : null);
            drug.Sd_antipsy = (srvMm != null ? srvMm.Sd_antipsy : null);
            drug.Sd_dosage = (srvMm != null ? srvMm.Sd_dosage : null);
            drug.Sd_frequnitct = ordSrv.Sd_frequnitct;
            
            //         drug.Sd_mmbind_ip = ordSrv
            drug.Sd_mmtp = (srvMm != null ? srvMm.Sd_mmtp : null);
            //         drug.Sd_mupkgutp = ordSrv
            drug.Sd_pharm = (srvMm != null ? srvMm.Sd_pharm : null);
            drug.Sd_pois = (srvMm != null ? srvMm.Sd_pois : null);
            drug.Sd_reltp = ordSrv.Sd_reltp;
            drug.Sd_skintest_skip_reason = ordSrv.Sd_skintest_skip_reason;
            drug.Sd_srvtp = ordSrv.Sd_srvtp;
            drug.Sd_val = (srvMm != null ? srvMm.Sd_val : null);
            drug.Sortno = ordSrv.Sortno;
            drug.Spec_mm = (srvMm != null ? srvMm.Spec : null);
            //         drug.Str_unit_pkg_ids = ordSrv
            drug.Sv = ordSrv.Sv;

            //         drug.Vender = ordSrv
            return drug;
        }

        protected virtual EmsOrDrug HandleEmsOrDrug(EmsOrDrug drug, object ordDrug = null)
        {
            return HpJudgeUtil.HandleEmsOrDrugHPInfo(drug);
        }

        public virtual void EmsDataChanged(object sender, xap.rui.engine.DictionaryEventArgs e)
        { 
            if (e == null || e.Data == null) return;
            if (AssToolEx.ObjectOfEventArgs(e, "Fg_treat") != null) {
                var obj = AssToolEx.ObjectOfEventArgs(e, "Fg_treat");
                EmsOrDrug drug = obj as EmsOrDrug;
                object drugObj = this.tableDataSource.Select(p => p.Id_srv == drug.Id_srv);
                if (drugObj != null && drugObj is EmsOrDrug) {
                    drug.Fg_treat = (drugObj as EmsOrDrug).Fg_treat;
                    drug.Fg_selfpay = (drugObj as EmsOrDrug).Fg_selfpay;
                    drug.Fg_hpindicjudged = (drugObj as EmsOrDrug).Fg_hpindicjudged;
                }
            }
            else if (AssToolEx.ObjectOfEventArgs(e, "Fg_selfpay") != null) {
                var obj = AssToolEx.ObjectOfEventArgs(e, "Fg_selfpay");
                EmsOrDrug drug = obj as EmsOrDrug;
                object drugObj = this.tableDataSource.Select(p => p.Id_srv == drug.Id_srv);
                if (drugObj != null && drugObj is EmsOrDrug) {
                    drug.Fg_treat = (drugObj as EmsOrDrug).Fg_treat;
                    drug.Fg_selfpay = (drugObj as EmsOrDrug).Fg_selfpay;
                    drug.Fg_hpindicjudged = (drugObj as EmsOrDrug).Fg_hpindicjudged;
                }
            }
        }
        #endregion
    }
}
