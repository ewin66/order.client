using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.en.pv.dto.d;
using xap.rui.appfw;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ems.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.opemergency.ems.common;
using iih.bd.srv.medsrv.d;
using iih.bd.bc.udi;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.bd.pp.primd.i;
using iih.ci.ord.emsdi.d;
using iih.ci.ord.ciorder.viewmodel.impext;
using xap.mw.core.data;
using iih.ci.ord.dto.emsmain;
using iih.ci.ord.common.utils;
using iih.ci.ord.i;
using xap.mw.serviceframework;
using iih.ci.ord.ciorder.utils;
using xap.rui.control.extentions;
using xap.mw.log;
using xap.mw.core.utils;
using xap.rui.appfw.extentions;
using iih.bd.srv.medsrv.i;
using iih.ci.ord.opemergency.declare;
using xap.mw.coreitf.d;
using iih.bd.srv.ems.d;
using iih.ci.iih.ci.ord.i;

namespace iih.ci.ord.opemergency.ems.dp
{

    /// <summary>
    /// <para>描    述 :  检验数据处理模型            	</para>
    /// <para>说    明 :                      			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.ems.dp    </para>    
    /// <para>类 名 称 :  EmsLisViewModel        			</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/6/30 16:27:45             </para>
    /// <para>更新时间 :  2016/6/30 16:27:45             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EmsLisViewModel : BaseEmsViewModel
    {
        #region 变量
        String strID_Dep_Mps = "";
      
        #endregion

        #region 构造函数
        public EmsLisViewModel(Ent4BannerDTO ent)
            : base(ent)
        {}

        /// <summary>
        /// 初始化方法
        /// 
        /// </summary>
        public override void Init()
        {
            base.Init();
            this.uiEmsDTO.EmsType = EmsType.LIS;
        }
        #endregion

        #region 获取模型数据
        public override object GetTableDataSource()
        {
            return this.uiEmsDTO.Emsaplab.EmsOrDrugList;
        }

        public override object GetFormDataSource()
        {
            return this.uiEmsDTO.Emsaplab;
        }

        public XapDataList<EmsObsLap> getEmsOrObsList()
        {
            return this.uiEmsDTO.Emsaplab.EmsOrObsList;
        }

        public override void ClearTableDataSource()
        {
            base.ClearTableDataSource();
            (GetTableDataSource() as XapDataList<EmsOrDrug>).Clear();

        }

        public override bool IsEmpty()
        {
            return this.uiEmsDTO.Emsaplab.EmsOrDrugList == null ||
                this.uiEmsDTO.Emsaplab.EmsOrDrugList.Count == 0 ||
                (this.uiEmsDTO.Emsaplab.EmsOrDrugList.Count == 1 && String.IsNullOrEmpty(this.uiEmsDTO.Emsaplab.EmsOrDrugList[0].Id_srv));
        }
        public bool checkRadio()
        {
            return (this.uiEmsDTO.Emsaplab.EmsOrDrugList != null &&
                this.uiEmsDTO.Emsaplab.EmsOrDrugList.Count > 0 &&
                this.uiEmsDTO.Emsaplab.EmsOrDrugList[0].Fg_setradio == FBoolean.True)?true:false;
                
        }
        #endregion

        #region 新建和编辑
        public override void EditOrder(CiOrderDO ciOrderDO)
        {
            EmsRstDTO[] rsts = LoadRemote(ciOrderDO.Id_or);
            EmsRstDTO rst = rsts[0];
            if (rst != null)
                {
                uiEmsDTO.Emsaplab.deSerializeJson((rst.Document[0] as EmsObsItemDO).serializeJson());
                //String utf8Str = System.Text.Encoding.UTF8.GetString(Convert.FromBase64String(rst.DocumentString));
                //uiEmsDTO.Emsaplab.deSerializeJson(utf8Str);

                    if (rst.Extension != null && rst.Extension.Keys.Contains("CiEmsDTO"))
                    {
                        this.ciEmsDTO = rst.Extension["CiEmsDTO"] as CiEmsDTO;
                    }
                    if (rst.Extension != null && rst.Extension.Keys.Contains("MedSrvDO"))
                    {
                        this.uiEmsDTO.MedSrvDO = rst.Extension["MedSrvDO"] as MedSrvDO;
                        strSd_srvtp = this.uiEmsDTO.MedSrvDO.Sd_srvtp;
                    }
                    this.ciEmsDTO.Times_cur = ciOrderDO.Times_cur;

                    this.ciEmsDTO.Times_mp_in = ciOrderDO.Times_mp_in;

                    if (this.uiEmsDTO.Emsaplab.EmsOrObsListEx != null)
                    {
                        if (null == this.uiEmsDTO.Emsaplab.EmsOrObsList)
                        {
                            this.uiEmsDTO.Emsaplab.EmsOrObsList = new XapDataList<EmsObsLap>();
                        }
                        this.uiEmsDTO.Emsaplab.EmsOrObsList.Clear();
                        this.uiEmsDTO.Emsaplab.EmsOrObsListEx.Cast<EmsObsLap>().ToList().ForEach(o =>
                        {
                            this.uiEmsDTO.Emsaplab.EmsOrObsList.Add(o);
                        });

                        this.uiEmsDTO.Emsaplab.EmsOrDrugList.Clear();//
                    }
                    uiEmsDTO.Emsaplab.Use_days = this.ciEmsDTO.Days_or;
                    uiEmsDTO.Emsaplab.Dt_begin_ui = this.ciEmsDTO.Dt_begin;
                    uiEmsDTO.Emsaplab.Dt_end_ui = this.ciEmsDTO.Dt_end;
                    uiEmsDTO.Emsaplab.Times_cur = this.ciEmsDTO.Times_cur;
                    uiEmsDTO.Emsaplab.Times_mp_in = this.ciEmsDTO.Times_mp_in;

                    EmsOrDrug item = new EmsOrDrug();
                    item.Status = DOStatus.UPDATED;
                    item.Id_orsrv = this.uiEmsDTO.Emsaplab.Id_orsrv;

                    item.Id_srv = this.uiEmsDTO.Emsaplab.Id_srv;
                    item.Name_srv = this.uiEmsDTO.Emsaplab.Name_srv;
                    // 频次
                    item.Id_freq = ciEmsDTO.Id_freq;
                    item.Name_freq = ciEmsDTO.Name_freq;
                    item.Freqct = this.uiEmsDTO.MedSrvDO.Freqct;
                    item.Sd_frequnitct = this.uiEmsDTO.MedSrvDO.Sd_frequnitct;

                    item.Price = (uiEmsDTO.Emsaplab.Price == null ? 0 : uiEmsDTO.Emsaplab.Price);
                    
                    item.Fg_urgent = this.uiEmsDTO.Emsaplab.Fg_urgent;
                    item.Use_days = uiEmsDTO.Emsaplab.Use_days;

                    // 剂量
                    item.Quan_med = uiEmsDTO.Emsaplab.Quan_med;
                    item.Id_unit_med = uiEmsDTO.Emsaplab.Id_unit_med;
                    item.Name_unit_med = uiEmsDTO.Emsaplab.Name_unit_med;
                    // 执行科室
                    item.Id_mp_dep = uiEmsDTO.Emsaplab.Id_mp_dep;
                    item.Name_mp_dep = uiEmsDTO.Emsaplab.Name_mp_dep;

                    // 总量
                    item.Quan_cur = (ciEmsDTO.Times_cur == null ? 0 : ciEmsDTO.Times_cur);
                    item.Id_unit_sale = item.Id_unit_med;
                    item.Name_unit_sale = item.Name_unit_med;
                    /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
                    item.Quan_medu_virtual = uiEmsDTO.Emsaplab.Quan_med;
                    item.Name_unit_medu_virtual = uiEmsDTO.Emsaplab.Name_unit_med;
                    /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111

                    // 总价
                    item.Totalprice = item.Price * item.Quan_cur;

                    //申请单号
                    item.No_applyform = this.uiEmsDTO.Emsaplab.No_applyobs;

                    //标本类型
                    item.Id_samptp=this.uiEmsDTO.Emsaplab.Id_samptp;
                    item.Sd_samptp=this.uiEmsDTO.Emsaplab.Sd_samptp;
                    item.Name_samptp=this.uiEmsDTO.Emsaplab.Name_samptp;
                    //标本采集时间
                    item.Id_sampcoltime=this.uiEmsDTO.Emsaplab.Id_sampcoltime ;
                    item.Name_sampcoltime=this.uiEmsDTO.Emsaplab.Name_sampcoltime ;
                    item.Id_sampcollecttimetp=this.uiEmsDTO.Emsaplab.Id_sampcollecttimetp;
                    item.Sd_sampcollecttimetp=this.uiEmsDTO.Emsaplab.Sd_sampcollecttimetp;
                    item.Len_sampcoltime =this.uiEmsDTO.Emsaplab.Len_sampcoltime ;
                    item.Id_unit_sampcoltime=this.uiEmsDTO.Emsaplab.Id_unit_sampcoltime;
                    
                    this.uiEmsDTO.Emsaplab.EmsOrDrugList.Add(item);

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
            

            orCiEmsToUiEms.EditEmsLab(this.uiEmsDTO, ems);
            this.uiEmsDTO.Status = DOStatus.NEW;
            this.uiEmsDTO.Emsaplab.EmsOrDrugList.Clear();//


            EmsOrDrug item = new EmsOrDrug();
            item.Status = DOStatus.NEW;
            item.Id_orsrv = this.uiEmsDTO.Emsaplab.Id_orsrv;

            item.Id_srv = this.uiEmsDTO.Emsaplab.Id_srv;
            item.Name_srv = this.uiEmsDTO.Emsaplab.Name_srv;
            // 频次
            item.Id_freq = ems.Id_freq;
            item.Name_freq = ems.Name_freq;
            item.Freqct = this.uiEmsDTO.MedSrvDO.Freqct;
            item.Sd_frequnitct = this.uiEmsDTO.MedSrvDO.Sd_frequnitct;

            item.Price = (uiEmsDTO.Emsaplab.Price == null ? 0 : uiEmsDTO.Emsaplab.Price);

            item.Fg_urgent = this.uiEmsDTO.Emsaplab.Fg_urgent;
            item.Use_days = uiEmsDTO.Emsaplab.Use_days;

            // 剂量
            item.Quan_med = uiEmsDTO.Emsaplab.Quan_med;
            item.Id_unit_med = uiEmsDTO.Emsaplab.Id_unit_med;
            item.Name_unit_med = uiEmsDTO.Emsaplab.Name_unit_med;
            // 执行科室
            item.Id_mp_dep = uiEmsDTO.Emsaplab.Id_mp_dep;
            item.Name_mp_dep = uiEmsDTO.Emsaplab.Name_mp_dep;

            // 总量
            item.Quan_cur = (ems.Times_cur == null ? 0 : ems.Times_cur);
            item.Id_unit_sale = item.Id_unit_med;
            item.Name_unit_sale = item.Name_unit_med;

            // 总价
            item.Totalprice = item.Price * item.Quan_cur;
            //申请单号
            item.No_applyform = this.uiEmsDTO.Emsaplab.No_applyobs;
            item.Fg_setradio = uiEmsDTO.MedSrvDO.Fg_setradio;
            this.uiEmsDTO.Emsaplab.EmsOrDrugList.Add(item);

            this.uiEmsDTO.MedSrvDO = XapServiceMgr.find<IMedsrvMDOCrudService>().findById(ems.Id_srv);
            item.Fg_setradio = this.uiEmsDTO.MedSrvDO.Fg_setradio == FBoolean.True;
            if (this.uiEmsDTO.MedSrvDO.Fg_setradio == FBoolean.True)
            {
                foreach (EmsObsLap o in this.uiEmsDTO.Emsaplab.EmsOrObsList)
                {
                    o.Fg_chk = FBoolean.False;
                }
            }
        }
        /// <summary>
        /// 从药品服务项目创建医嘱
        /// </summary>
        /// <param name="med"></param>
        public override bool LoadMedSrv(EmsCreatedParameter emsCreatedParameter, int pos) //EmsCreateParameter
        {

            base.LoadMedSrv(emsCreatedParameter, pos);
            MedSrvDO med = emsCreatedParameter.getMedSrvDO();
            
            EmsRstDTO[] rsts = CreateRemote(med.Id_srv);
            EmsRstDTO rst = rsts[0];

                if (rst != null)
                {

                uiEmsDTO.Emsaplab.deSerializeJson((rst.Document[0] as EmsObsItemDO).serializeJson());
                //String utf8Str = System.Text.Encoding.UTF8.GetString(Convert.FromBase64String(rst.DocumentString));
                //uiEmsDTO.Emsaplab.deSerializeJson(utf8Str);

                    if (rst.Extension != null && rst.Extension.Keys.Contains("MedSrvDO"))
                    {
                        this.uiEmsDTO.MedSrvDO = rst.Extension["MedSrvDO"] as MedSrvDO;
                        strSd_srvtp = this.uiEmsDTO.MedSrvDO.Sd_srvtp;
                    }
                    // 处理执行科室过滤条件
                    if (null != rst.Extension && rst.Extension.Keys.Contains("MpDepFilter"))
                    {
                        this.strID_Dep_Mps = (String)rst.Extension["MpDepFilter"];
                    }

                    if (this.uiEmsDTO.Emsaplab.EmsOrDrugListEx != null)
                    {
                        if (null == this.uiEmsDTO.Emsaplab.EmsOrDrugList)
                        {
                            this.uiEmsDTO.Emsaplab.EmsOrDrugList = new XapDataList<EmsOrDrug>();
                        }
                        this.uiEmsDTO.Emsaplab.EmsOrDrugList.Clear();
                    this.uiEmsDTO.Emsaplab.EmsOrDrugListEx.Cast<EmsOrDrug>().ToList().ForEach(o =>
                    {
                            this.uiEmsDTO.Emsaplab.EmsOrDrugList.Add(o);
                        });
                    }

                    // 处理套项目信息
                    if (this.uiEmsDTO.Emsaplab.EmsOrObsListEx != null)
                    {
                        if (null == this.uiEmsDTO.Emsaplab.EmsOrObsList)
                        {
                            this.uiEmsDTO.Emsaplab.EmsOrObsList = new XapDataList<EmsObsLap>();
                        }
                        this.uiEmsDTO.Emsaplab.EmsOrObsList.Clear();
                    this.uiEmsDTO.Emsaplab.EmsOrObsListEx.Cast<EmsObsLap>().ToList().ForEach(o =>
                    {
                            this.uiEmsDTO.Emsaplab.EmsOrObsList.Add(o);
                        });
                    }

                }
               

            return true;
        }
        #endregion

        #region 保存

        protected override void OnBeforeCallServiceSave(CiEmsDTO ems)
        {
            base.OnBeforeCallServiceSave(ems);

            ems.Fg_mp_in = true;
            ems.Times_mp_in = ems.Times_cur;
            if (ems.Emssrvs != null)
                ems.Emssrvs.Cast<CiEmsSrvDTO>().Where(srv => srv.Eu_sourcemd == (int)OrSrvSourceFromEnum.PHYSIAN).ToList().ForEach(srv =>
                {
                srv.Quan_total_medu = ems.Times_mp_in * srv.Quan_med;
            });
        }
        
        public override CiEmsDTO Save2CiEmsDTO(bool forceUpdate)
        {
            // 需要将临时存储在列表数据模型中的数据取出来，放置到检验结构中
            EmsOrDrug drug = uiEmsDTO.Emsaplab.EmsOrDrugList.ElementAt(0);

            // 剂量
            uiEmsDTO.Emsaplab.Id_unit_med = drug.Id_unit_med;
            uiEmsDTO.Emsaplab.Name_unit_med = drug.Name_unit_med;
            uiEmsDTO.Emsaplab.Quan_med = drug.Quan_med;

            // 使用天数
            uiEmsDTO.Emsaplab.Use_days = drug.Use_days;

            // 总量
            uiEmsDTO.Emsaplab.Quan_cur = drug.Quan_cur;
            uiEmsDTO.Emsaplab.Id_unit_sale = drug.Id_unit_med;
            uiEmsDTO.Emsaplab.Name_unit_sale = drug.Name_unit_med;

            // 加急
            uiEmsDTO.Emsaplab.Fg_urgent = drug.Fg_urgent;

            // 价格
            uiEmsDTO.Emsaplab.Price = drug.Price;

            // 执行科室
            uiEmsDTO.Emsaplab.Id_mp_dep = drug.Id_mp_dep;
            uiEmsDTO.Emsaplab.Name_mp_dep = drug.Name_mp_dep;
            XapDataList<EmsObsLap> hasItems = new XapDataList<EmsObsLap>();
            foreach (EmsObsLap item in this.uiEmsDTO.Emsaplab.EmsOrObsList)
            {
                if (item.Fg_chk != null && item.Fg_chk.Value)
                {
                    hasItems.Add(item);
                }
            }
            // 暂存
            XapDataList<EmsObsLap> allItems = this.uiEmsDTO.Emsaplab.EmsOrObsList;
            this.uiEmsDTO.Emsaplab.EmsOrObsList = hasItems;
            CiEmsDTO ciEmsDTO = base.Save2CiEmsDTO(forceUpdate);
            this.uiEmsDTO.Emsaplab.EmsOrObsList = allItems;
            return ciEmsDTO;
        }

        public override CiOrderDO Save2Order()
        {
            // 需要将临时存储在列表数据模型中的数据取出来，放置到检验结构中
            EmsOrDrug drug = uiEmsDTO.Emsaplab.EmsOrDrugList.ElementAt(0);

            // 剂量
            uiEmsDTO.Emsaplab.Id_unit_med = drug.Id_unit_med;
            uiEmsDTO.Emsaplab.Name_unit_med = drug.Name_unit_med;
            uiEmsDTO.Emsaplab.Quan_med = drug.Quan_med;

            // 频次
            uiEmsDTO.Emsaplab.Name_freq = drug.Name_freq;

            // 使用天数
            uiEmsDTO.Emsaplab.Use_days = drug.Use_days;

            // 总量
            uiEmsDTO.Emsaplab.Quan_cur = drug.Quan_cur;
            uiEmsDTO.Emsaplab.Id_unit_sale = drug.Id_unit_med;
            uiEmsDTO.Emsaplab.Name_unit_sale = drug.Name_unit_med;

            // 加急
            uiEmsDTO.Emsaplab.Fg_urgent = drug.Fg_urgent;

            // 价格
            uiEmsDTO.Emsaplab.Price = drug.Price;

            // 执行科室
            uiEmsDTO.Emsaplab.Id_mp_dep = drug.Id_mp_dep;
            uiEmsDTO.Emsaplab.Name_mp_dep = drug.Name_mp_dep;
            //标本类型
            uiEmsDTO.Emsaplab.Id_samptp = drug.Id_samptp;
            uiEmsDTO.Emsaplab.Sd_samptp = drug.Sd_samptp;
            uiEmsDTO.Emsaplab.Name_samptp = drug.Name_samptp;
            //标本采集时间
            uiEmsDTO.Emsaplab.Id_sampcoltime = drug.Id_sampcoltime;
            uiEmsDTO.Emsaplab.Name_sampcoltime = drug.Name_sampcoltime;
            uiEmsDTO.Emsaplab.Id_sampcollecttimetp = drug.Id_sampcollecttimetp;
            uiEmsDTO.Emsaplab.Sd_sampcollecttimetp = drug.Sd_sampcollecttimetp;
            uiEmsDTO.Emsaplab.Len_sampcoltime = drug.Len_sampcoltime;
            uiEmsDTO.Emsaplab.Id_unit_sampcoltime=drug.Id_unit_sampcoltime;


            //XapDataList<EmsObsLap> hasItems = new XapDataList<EmsObsLap>();
            foreach (EmsObsLap item in this.uiEmsDTO.Emsaplab.EmsOrObsList)
            {
                if (!String.IsNullOrEmpty(item.Id_orsrv) && item.Fg_chk != FBoolean.True)
                {
                    item.Status = DOStatus.DELETED;
                    this.uiEmsDTO.Emsapobs.EmsOrObsListDel.Add(item);
                }
            }
            //this.uiEmsDTO.Emsaplab.EmsOrObsList = hasItems;
            //foreach (EmsObsLap item in this.uiEmsDTO.Emsaplab.EmsOrObsList)
            //{
            //    if (!String.IsNullOrEmpty(item.Id_orsrv) && item.Fg_chk != FBoolean.True)
            //    {
            //        item.Status = DOStatus.DELETED;
            //        this.uiEmsDTO.Emsaplab.EmsOrObsListDel.Add(item);
            //    }
            //}
            return base.Save2Order();
            
        }

        public CiOrderDO New_Save()
        {


                // 需要将临时存储在列表数据模型中的数据取出来，放置到检验结构中
                EmsOrDrug drug = uiEmsDTO.Emsaplab.EmsOrDrugList.ElementAt(0);

                // 剂量
                uiEmsDTO.Emsaplab.Id_unit_med = drug.Id_unit_med;
                uiEmsDTO.Emsaplab.Name_unit_med = drug.Name_unit_med;
                uiEmsDTO.Emsaplab.Quan_med = drug.Quan_med;

                // 使用天数
                uiEmsDTO.Emsaplab.Use_days = drug.Use_days;

                // 总量
                uiEmsDTO.Emsaplab.Quan_cur = drug.Quan_cur;
                uiEmsDTO.Emsaplab.Id_unit_sale = drug.Id_unit_med;
                uiEmsDTO.Emsaplab.Name_unit_sale = drug.Name_unit_med;

                /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
                // 频次
                uiEmsDTO.Emsaplab.Id_freq = drug.Id_freq;
                uiEmsDTO.Emsaplab.Name_freq = drug.Name_freq;
                uiEmsDTO.Emsaplab.Freqct = drug.Freqct;
                uiEmsDTO.Emsaplab.Sd_frequnitct = drug.Sd_frequnitct;
                /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111

                // 加急
                uiEmsDTO.Emsaplab.Fg_urgent = drug.Fg_urgent;

                // 价格
                uiEmsDTO.Emsaplab.Price = drug.Price;

                // 执行科室
                uiEmsDTO.Emsaplab.Id_mp_dep = drug.Id_mp_dep;
                uiEmsDTO.Emsaplab.Name_mp_dep = drug.Name_mp_dep;
                //标本类型
                uiEmsDTO.Emsaplab.Id_samptp = drug.Id_samptp;
                uiEmsDTO.Emsaplab.Sd_samptp = drug.Sd_samptp;
                uiEmsDTO.Emsaplab.Name_samptp = drug.Name_samptp;
                //标本采集时间
                uiEmsDTO.Emsaplab.Id_sampcoltime = drug.Id_sampcoltime;
                uiEmsDTO.Emsaplab.Name_sampcoltime = drug.Name_sampcoltime;
                uiEmsDTO.Emsaplab.Id_sampcollecttimetp = drug.Id_sampcollecttimetp;
                uiEmsDTO.Emsaplab.Sd_sampcollecttimetp = drug.Sd_sampcollecttimetp;
                uiEmsDTO.Emsaplab.Len_sampcoltime = drug.Len_sampcoltime;
                uiEmsDTO.Emsaplab.Id_unit_sampcoltime = drug.Id_unit_sampcoltime;


                this.uiEmsDTO.Emsaplab.EmsOrObsListEx = new FArrayList();
                foreach (EmsObsLap item in this.uiEmsDTO.Emsaplab.EmsOrObsList)
                {
                    if (item.Fg_chk == FBoolean.True)
                    {
                        this.uiEmsDTO.Emsaplab.EmsOrObsListEx.Add(item);
                    }
                    }

            EmsRstDTO rst = SaveRemote(this.uiEmsDTO.Emsaplab);
                if (rst != null)
                {
                    return (rst.Document[0] as CiorderAggDO).getParentDO();
            }

            return null;
        }
        /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
        public override void OnDataChanged(Object ds, string fieldName, string value)
        {
            if (fieldName.Equals("Use_days") ||
                fieldName.Equals("customercolumn_med_unit") ||
                fieldName.Equals("customercolumn_sale_unit"))
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
                this.uiEmsDTO.Emsaplab.Dt_begin_ui = this.uiEmsDTO.Emsaplab.Dt_plan;
                if (this.uiEmsDTO.Emsaplab.Dt_begin_ui == null)
                {
                    this.uiEmsDTO.Emsaplab.Dt_end_ui = this.uiEmsDTO.Emsaplab.Dt_begin_ui;
                }
                else
                {
                    this.uiEmsDTO.Emsaplab.Dt_end_ui = ((DateTime)this.uiEmsDTO.Emsaplab.Dt_begin_ui).AddDays((int)this.uiEmsDTO.Emsaplab.Use_days);
                }
            }
        }
        /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111

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

        /// <summary>
        /// 处理引用参照过滤条件
        /// </summary>
        /// <param name="filedName"></param>
        /// <returns></returns>
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
                string wherePart = base.OnRefFilterData(filedName, sbm);

                if (wherePart != "")
                {
                    return wherePart;
                }
                return "";
            }
        }

        #endregion

        #region 指定显示字段和只读字段
         /// <summary>
        /// 获取隐藏字段
        /// </summary>
        /// <returns></returns>
        public override string[] GetHiddenFields()
        {
            /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
            List<string> lstFields = new List<string>() { "Totalprice", "Fg_treat" };
            bool isHideDose = false;
            bool isHideFreq = false;
            if (this.uiEmsDTO.Emsaplab.Ismuldose == null || !this.uiEmsDTO.Emsaplab.Ismuldose.Value)
            {
                isHideDose = true;
                lstFields.Add("customercolumn_med_unit");
            }
            if (this.uiEmsDTO.Emsaplab.Ismulexec == null || !this.uiEmsDTO.Emsaplab.Ismulexec.Value)
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
        public override string[] GetFixedFields()
        {
            return new string[] { "Name_srv", "customercolumn_details", "customercolumn_med_unit", "Name_freq", "Use_days", "customercolumn_sale_unit", "Name_samptp", "Name_sampcoltime", "Fg_urgent", "No_applyform", "Name_mp_dep", "Price", "Fg_extdispense", "Totalprice" };
        }

        /// <summary>
        /// 获取只读字段
        /// </summary>
        /// <returns></returns>
        public override string[] GetReadonlyFields()
        {
            return new string[] { };
        }
        #endregion

        #region 检查服务接口
        public bool isSet()
        {
            return this.uiEmsDTO.MedSrvDO.Fg_set != null && this.uiEmsDTO.MedSrvDO.Fg_set.Value;

        }

        #endregion

        #region 额外数据处理
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
                }

            }
            if (drug.Quan_cur == null)
            {
                drug.Quan_cur = this.logicEx.getNotDrugTotal(drug.Quan_med.ToDouble(), drug.Id_freq, drug.Freqct==null?1:drug.Freqct.Value);
            }
            if (drug.Price != null)
            {
                drug.Totalprice = drug.Price * drug.Quan_cur;
            }

            if (drug.Id_unit_sale == null)
            {
                drug.Id_unit_sale = drug.Id_unit_med;
                drug.Name_unit_sale = drug.Name_unit_med;
            }
        }
        public void ReCalcPriceInfo(EmsOrDrug risDrug)
        {
            if (risDrug != null)
            {
               risDrug.Price =  this.logicEx.getSrvNotMMPri(this.uiEmsDTO.MedSrvDO, getSelectedObsLap(),GetEnt4BannerDTO().Id_pripat);
            }
        }
        private XapDataList<EmsObsLap> getSelectedObsLap()
        {
            XapDataList<EmsObsLap> ls = new XapDataList<EmsObsLap>();
            foreach (EmsObsLap item in uiEmsDTO.Emsaplab.EmsOrObsList)
            {
                if ((item.Fg_edit != null && !item.Fg_edit.Value) || (item.Fg_chk!=null && item.Fg_chk.Value))
                {
                    ls.Add(item);
                }
            }

            return ls;
        }

        #endregion
    }
}
