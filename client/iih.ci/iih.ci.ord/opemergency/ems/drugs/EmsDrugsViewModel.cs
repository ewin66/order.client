using System;
using System.Collections.Generic;
using System.Linq;
using iih.ci.ord.ciordems.d;
using iih.en.pv.dto.d;
using iih.bd.srv.medsrv.d;
using xap.rui.appfw;
using iih.ci.ord.ciorder.viewmodel.impext;
using xap.rui.control.extentions;
using iih.ci.ord.i;
using xap.mw.serviceframework;
using iih.ci.ord.ciorder.d;
using xap.mw.core.data;
using iih.bd.pp.hpsrvorca.d;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.ems.d;
using iih.bd.srv.medsrv.i;
using xap.mw.coreitf.d;
using iih.ci.ord.emsdi.d;
using iih.ci.ord.opemergency.tool;
using xap.mw.serviceframework.ex;
using iih.bd.bc.udi;
using iih.ci.ord.common.utils;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.dto.emsmain;
using iih.ci.ord.dto.d;
using iih.ci.ord.opemergency.declare;
using iih.bd.srv.ems.d;
using iih.ci.iih.ci.ord.i;

namespace iih.ci.ord.opemergency.ems.dp
{
    /// <summary>
    /// <para>描    述 :  西城药医疗单数据处理模型       	</para>
    /// <para>说    明 :                      			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.ems.dp    </para>    
    /// <para>类 名 称 :  EmsDrugsViewModel        			</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/6/30 16:27:45             </para>
    /// <para>更新时间 :  2016/6/30 16:27:45             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    class EmsDrugsViewModel : BaseEmsViewModel
    {
        protected object mSelectedObject;
        private string id_dosages = "";

        /// <summary>
        /// 获取医疗单数据接口
        /// </summary>
        private ICiEmsMainService emsMainService = XapServiceMgr.find<ICiEmsMainService>();

        public bool bEdit_Note_or { get; set; }

        /// <summary>
        /// 药品数据处理模型
        /// </summary>
        /// <param name="ent"></param>
        public EmsDrugsViewModel(Ent4BannerDTO ent)
            : base(ent)
        {

        }

        /// <summary>
        /// 药品列表模型
        /// </summary>
        /// <returns></returns>
        public override object GetTableDataSource()
        {
            return this.uiEmsDTO.Emsdrugs.EmsOrDrugList;
        }

        /// <summary>
        /// 药品选项卡数据模型
        /// </summary>
        /// <returns></returns>
        public override object GetFormDataSource()
        {
            return this.uiEmsDTO.Emsdrugs;
        }

        /// <summary>
        /// 初始化方法
        /// </summary>
        public override void Init()
        {
            base.Init();
            uiEmsDTO.EmsType = EmsType.COMMONDRUG;
            SetSelectedObject(null);
        }

        public override CiEmsDTO Save2CiEmsDTO(bool forceUpdate)
        {
            if (this.uiEmsDTO.Emsdrugs.EmsOrDrugList.Count == 1 && String.IsNullOrEmpty(this.uiEmsDTO.Emsdrugs.EmsOrDrugList[0].Id_srv))
                return null;

            return base.Save2CiEmsDTO(forceUpdate);
        }
        public override CiOrderDO Save2Order()
        {
            FArrayList druglist = new FArrayList();
            foreach (EmsOrDrug emsordrug in this.uiEmsDTO.Emsdrugs.EmsOrDrugList)
            {
                druglist.Add(emsordrug);
            }
            this.uiEmsDTO.Emsdrugs.EmsOrDrugListEx = druglist;
            return base.Save2Order();
            //return New_Save();
        }

        public CiOrderDO New_Save()
        {
            this.uiEmsDTO.Emsdrugs.Id_srvof = emsMgrDTO.Id_ems;
            this.uiEmsDTO.Emsdrugs.Status = this.uiEmsDTO.Status;

            EmsRstDTO rst = SaveRemote(this.uiEmsDTO.Emsdrugs);
            if (rst != null)
            {
                return (rst.Document[0] as CiorderAggDO).getParentDO();

            }
            return null;
        }

        public override bool IsEmpty()
        {
            return this.uiEmsDTO.Emsdrugs.EmsOrDrugList == null ||
                GetCountWithOutDelete() == 0 ||
                (GetCountWithOutDelete() == 1 && String.IsNullOrEmpty(this.uiEmsDTO.Emsdrugs.EmsOrDrugList.FirstOrDefault(p => !p.IsDELETED).Id_srv));
        }

        /// <summary>
        /// 列表增加一行空数据
        /// </summary>
        /// <returns></returns>
        public override object AddNew()
        {
            if ((GetTableDataSource() as XapDataList<EmsOrDrug>).Count > 0)
            {
                if ((GetTableDataSource() as XapDataList<EmsOrDrug>)[0].Id_route == null)
                {
                    this.ShowInfo("药品用法不可为空！");
                    return null;
                }
            }
            EmsOrDrug drug = (GetTableDataSource() as XapDataList<EmsOrDrug>).AddNew();
            if (drug != null)
            {

                this.SetSelectedObject(drug);
            }
            return drug;
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
                }
                if (rst.Extension != null && rst.Extension.Keys.Contains("MpDepFilter"))
                {
                    this.uiEmsDTO.Emsdrugs.Str_mp_dep_ids = rst.Extension["MpDepFilter"] as String;
                }
                if (rst.Extension != null && rst.Extension.Keys.Contains("id_dosages"))
                {
                    id_dosages = rst.Extension["id_dosages"] as String;
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
                this.uiEmsDTO.Emsdrugs.EmsOrDrug.Clear();
                this.uiEmsDTO.Emsdrugs.EmsOrDrug.Add(this.uiEmsDTO.Emsdrugs.EmsOrDrugList.FirstOrDefault());

                this.ciEmsDTO.Status = DOStatus.UPDATED;
                this.uiEmsDTO.Status = DOStatus.UPDATED;
                HandleExpenseItems(ciEmsDTO);
            }

        }


        public override void EditEms(CiEmsDTO ems)
        {
            base.EditEms(ems);
            orCiEmsToUiEms.EditDrug(ems, this.uiEmsDTO);
            this.uiEmsDTO.Status = DOStatus.NEW;

            foreach (EmsOrDrug item in this.uiEmsDTO.Emsdrugs.EmsOrDrugList)
            {
                if (String.IsNullOrEmpty(this.uiEmsDTO.Emsdrugs.Id_route))
                {
                    this.uiEmsDTO.Emsdrugs.Name_route = null;
                }
                if (String.IsNullOrEmpty(this.uiEmsDTO.Emsdrugs.Id_freq))
                {
                    this.uiEmsDTO.Emsdrugs.Name_freq = null;
                    this.uiEmsDTO.Emsdrugs.Freqct = null;
                }
                this.fillSameInfoForEmsOrDrug(item, this.uiEmsDTO.Emsdrugs);

                // 计算 明细总金额
                item.Totalprice = item.Quan_cur * item.Price;
            }
            if (this.uiEmsDTO.Emsdrugs.EmsOrDrugList != null && this.uiEmsDTO.Emsdrugs.EmsOrDrugList.Count > 0 && this.uiEmsDTO.Emsdrugs.EmsOrDrugList[0].Id_route != "")
            {
                id_dosages = this.logicEx.getDrugRouteOfDoSages(this.uiEmsDTO.Emsdrugs.EmsOrDrugList[0].Id_route);
            }

            // 物质流向
            OrWfDeptInfoDTO wf = new GetDeptMpImp().GetDept_mp_ids(this.GetEnt4BannerDTO().Code_entp, this.GetEnt4BannerDTO().Id_entp, ems.Sd_srvtp, ems.Id_srvca, ems.Id_srv, ems.Id_route, "id_mm", this.GetEnt4BannerDTO().Id_dep_nur, this.GetEnt4BannerDTO().Id_dep_phy);
            this.uiEmsDTO.Emsdrugs.Str_mp_dep_ids = wf == null ? "" : wf.Id_mp_depts;
            if (this.uiEmsDTO.Emsdrugs.Id_dep == null)
            {
                this.uiEmsDTO.Emsdrugs.Id_dep = wf == null ? "" : wf.Firstid_mp_dept;
                this.uiEmsDTO.Emsdrugs.Name_dep = wf == null ? "" : wf.Firstname_mp_dept;

            }
            if (null != wf)
            {
                foreach (EmsOrDrug drug in uiEmsDTO.Emsdrugs.EmsOrDrugList)
                {
                    //皮试判断逻辑
                    AssToolEx.CheckTestSkinSrv(null, drug, this.GetEnt4BannerDTO());
                    drug.Id_dep_wh = wf.Id_dept_wh;
                }
            }
        }

        /// <summary>
        /// 创建医疗单
        /// </summary>
        /// <param name="emsCreateParameter"></param>
        /// <param name="pos"></param>
        /// <returns></returns>
        //public override bool LoadMedSrv(EmsCreatedParameter emsCreateParameter, int pos) 
        //{
        //    base.LoadMedSrv(emsCreateParameter, pos);
        //    MedSrvDO med = emsCreateParameter.getMedSrvDO();
        //    String id_mm = emsCreateParameter.getMmID();

        //    // 获取列表最后一个数据
        //    EmsOrDrug newDrug = null;

        //    EmsCrtDTO emsCrt = new EmsCrtDTO();
        //    emsCrt.Id_srv = med.Id_srv;
        //    emsCrt.Id_mm = id_mm;
        //    emsCrt.EmsMgrInfo = this.emsMgrDTO;
        //    emsCrt.EnContext = BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO;
        //    emsCrt.EmsDriver = ((int)this.uiEmsDTO.EmsType).ToString();

        //    // 临时用，验证结束需要调整到后台
        //    emsCrt.CustomInfo = emsCreateParameter.GetParameter() == null ? null : emsCreateParameter.GetParameter().ToString();
        //    EmsRstDTO rst = emsMainService.create(emsCrt);
        //    if (rst != null)
        //    {
        //        String utf8Str = System.Text.Encoding.UTF8.GetString(Convert.FromBase64String(rst.EmsDocument));
        //        EmsDrugItemDO emsDrugItem = new EmsDrugItemDO();
        //        emsDrugItem.deSerializeJson(utf8Str);

        //        FMap2 emsExtMap = rst.EmsExtension;

        //        this.id_dosages = emsExtMap["id_dosages"] as string;
        //        MedSrvDO medSrv = emsExtMap["MedSrvDO"] as MedSrvDO;
        //        OrWfDeptInfoDTO wf = emsExtMap["OrWfDeptInfoDTO"] as OrWfDeptInfoDTO;
        //        SkinTestRstDTO skinTestRst = emsExtMap["SkinTestRstDTO"] as SkinTestRstDTO;
        //        if (emsExtMap["isShowWarnInfo"] != null && (bool)emsExtMap["isShowWarnInfo"])
        //        {
        //            this.tipInfoMsgString = emsExtMap["specillDrugWarnInfo"] as string;
        //        }
        //        // 物品参照
        //        XapDataList<EmsOrDrug> emsOrDrugRef = new XapDataList<EmsOrDrug>();
        //        if (emsDrugItem.EmsOrDrugEx == null || emsDrugItem.EmsOrDrugEx.Count == 0) {
        //            this.errorMsgString = "服务"+emsDrugItem.Name_srv+"未绑定物品，请联系信息科！";
        //            return false;
        //        }
        //        foreach (EmsOrDrug drug in emsDrugItem.EmsOrDrugEx)
        //        {
        //            emsOrDrugRef.Add(drug);
        //        }
        //        emsDrugItem.EmsOrDrug = emsOrDrugRef;

        //        // 列表中显示的物品
        //        XapDataList<EmsOrDrug> emsOrDrugList = new XapDataList<EmsOrDrug>();
        //        FArrayList drugList_ex = emsDrugItem.EmsOrDrugListEx;
        //        foreach (EmsOrDrug drug in drugList_ex)
        //        {
        //            emsOrDrugList.Add(drug);
        //        }


        //        if (pos < 0)
        //        {
        //            this.uiEmsDTO.MedSrvDO = med;

        //            emsDrugItem.EmsOrDrugList = emsOrDrugList;
        //            // 当物品id查询不到对应物品时，不做赋值操作
        //            if (emsOrDrugList.Count > 0)
        //            {
        //                this.uiEmsDTO.Emsdrugs = emsDrugItem;
        //            }
        //            newDrug = this.uiEmsDTO.Emsdrugs.EmsOrDrugList.LastOrDefault();
        //        }
        //        else
        //        {
        //            newDrug = this.uiEmsDTO.Emsdrugs.EmsOrDrugList.ElementAt(pos);
        //        }

        //        // 设置当前选择项目
        //        SetSelectedObject(newDrug);

        //        if (emsOrDrugList.Count == 0)
        //        {
        //            this.errorMsgString = med.Name + "(" + id_mm + "), 没有关联物品或者物品数据错误！";
        //            this.logicEx.Clear<EmsOrDrug>(newDrug);
        //            return false;
        //        }

        //        // 获取从后台返回的用于医嘱列表显示的数据
        //        EmsOrDrug tempDrug = emsOrDrugList[0];

        //        //皮试判断逻辑
        //        string skinErrorInfo = AssToolEx.CheckSkinTestRst(tempDrug, skinTestRst, this.GetEnt4BannerDTO());
        //        if (!string.IsNullOrEmpty(skinErrorInfo))
        //        {
        //            this.errorMsgString = skinErrorInfo;
        //            this.logicEx.Clear<EmsOrDrug>(newDrug);
        //            return false;
        //        }

        //        // 加载第一条记录信息已经是全的了，不用执行后边的
        //        if (pos < 0)
        //        {
        //            return true;
        //        }

        //        if (!newDrug.IsUPDATED)
        //        {
        //            tempDrug.Status = DOStatus.NEW;
        //        }
        //        else
        //        { // 增加该逻辑分支   针对 已保存的 医嘱项目 进行服务项目的修改 -- 2016-11-21 by wangqz
        //            tempDrug.Status = DOStatus.UPDATED;
        //        }
        //        // 保留id_orsrv ,当对编辑项通过退格键删除后，在选择其他服务，Id_orsrv存在
        //        tempDrug.Id_orsrv = newDrug.Id_orsrv;

        //        // 新加的药品要与已有的保持同频次，同周期，同用法
        //        tempDrug.Id_route = this.uiEmsDTO.Emsdrugs.Id_route;
        //        tempDrug.Name_route = this.uiEmsDTO.Emsdrugs.Name_route;

        //        // 同频次
        //        tempDrug.Id_freq = this.uiEmsDTO.Emsdrugs.Id_freq;
        //        tempDrug.Name_freq = this.uiEmsDTO.Emsdrugs.Name_freq;
        //        tempDrug.Sd_frequnitct = this.uiEmsDTO.Emsdrugs.Sd_frequnitct;
        //        tempDrug.Freqct = this.uiEmsDTO.Emsdrugs.Freqct;

        //        // 如果只有一条记录，恢复到服务默认的频次，用法
        //        fillSameInfoWithMedSrvDO(tempDrug, medSrv);

        //        // 同周期
        //        tempDrug.Use_days = this.uiEmsDTO.Emsdrugs.Use_days;

        //        // 计算总次数
        //        int times_cur = CalQuantumUtil.GetInstance().getTotalTimes(tempDrug.Id_freq, (int)this.uiEmsDTO.Emsdrugs.Use_days);

        //        // 计算总量
        //        tempDrug.Quan_cur = CalQuantumUtil.GetInstance().getMMQuantum(tempDrug.Sd_opmutp, tempDrug.Quan_med, tempDrug.Factor_mb, tempDrug.Factor_cb, times_cur);

        //        // 计算总价
        //        tempDrug.Totalprice = tempDrug.Price * tempDrug.Quan_cur;               

        //        // 将返回数据加到表格数据源中
        //        newDrug.Replace(tempDrug);
        //    }

        //    return true;
        //}
        public override bool LoadMedSrv(EmsCreatedParameter emsCreateParameter, int pos)
        {
            base.LoadMedSrv(emsCreateParameter, pos);
            MedSrvDO med = emsCreateParameter.getMedSrvDO();
            String id_mm = emsCreateParameter.getMmID();


            Dictionary<String, Object> ctmInfo = new Dictionary<string, object>();
            ctmInfo.Add("CustomInfo", emsCreateParameter.GetParameter() == null ? null : emsCreateParameter.GetParameter().ToString());
            EmsRstDTO[] rsts = CreateRemote(med.Id_srv, id_mm, ctmInfo);
            EmsRstDTO rst = rsts[0];
            if (rst != null)
            {
                // 获取列表最后一个数据
                EmsOrDrug newDrug = null;

                EmsDrugItemDO emsDrugItem = (rst.Document[0] as EmsDrugItemDO);
                //String utf8Str = System.Text.Encoding.UTF8.GetString(Convert.FromBase64String(rst.DocumentString));
                //EmsDrugItemDO emsDrugItem = new EmsDrugItemDO();
                //emsDrugItem.deSerializeJson(utf8Str);

                FMap2 emsExtMap = rst.Extension;

                this.id_dosages = emsExtMap["DosagesFilter"] as string;
                MedSrvDO medSrv = emsExtMap["MedSrvDO"] as MedSrvDO;
                OrWfDeptInfoDTO wf = emsExtMap["OrWfDeptInfoDTO"] as OrWfDeptInfoDTO;
                SkinTestRstDTO skinTestRst = emsExtMap["SkinTestRstDTO"] as SkinTestRstDTO;
                if (emsExtMap["IsShowWarnInfo"] != null && (bool)emsExtMap["IsShowWarnInfo"])
                {
                    this.tipInfoMsgString = emsExtMap["SpecilDrugWarnInfo"] as string;
                }
                // 物品参照
                if (emsDrugItem.EmsOrDrug == null)
                {
                    emsDrugItem.EmsOrDrug = new XapDataList<EmsOrDrug>();
                }
                foreach (EmsOrDrug drug in emsDrugItem.EmsOrDrugListEx)
                {
                    emsDrugItem.EmsOrDrug.Add(drug);
                }

                // 列表中显示的物品
                XapDataList<EmsOrDrug> emsOrDrugList = new XapDataList<EmsOrDrug>();

                foreach (EmsOrDrug drug in emsDrugItem.EmsOrDrugListEx)
                {
                    emsOrDrugList.Add(drug);
                }

                // 获取从后台返回的用于医嘱列表显示的数据
                EmsOrDrug tempDrug = emsOrDrugList[0];

                if (pos < 0)
                {
                    this.uiEmsDTO.MedSrvDO = med;

                    emsDrugItem.EmsOrDrugList = emsOrDrugList;
                    // 当物品id查询不到对应物品时，不做赋值操作
                    if (emsOrDrugList.Count > 0)
                    {
                        this.uiEmsDTO.Emsdrugs = emsDrugItem;
                    }
                    newDrug = this.uiEmsDTO.Emsdrugs.EmsOrDrugList.LastOrDefault();
                    this.uiEmsDTO.Emsdrugs.Id_dep = tempDrug.Id_mp_dep;
                    this.uiEmsDTO.Emsdrugs.Name_dep = tempDrug.Name_mp_dep;
                }
                else
                {
                    newDrug = this.uiEmsDTO.Emsdrugs.EmsOrDrugList.ElementAt(pos);
                }

                // 设置当前选择项目
                SetSelectedObject(newDrug);


                //皮试判断逻辑
                string skinErrorInfo = AssToolEx.CheckSkinTestRst(tempDrug, skinTestRst, this.GetEnt4BannerDTO());
                if (skinErrorInfo != null)
                {
                    this.errorMsgString = skinErrorInfo;
                    this.logicEx.Clear<EmsOrDrug>(newDrug);
                    return false;
                }

                // 加载第一条记录信息已经是全的了，不用执行后边的
                if (pos < 0)
                {
                    return true;
                }

                if (!newDrug.IsUPDATED)
                {
                    tempDrug.Status = DOStatus.NEW;
                }
                else
                { // 增加该逻辑分支   针对 已保存的 医嘱项目 进行服务项目的修改 -- 2016-11-21 by wangqz
                    tempDrug.Status = DOStatus.UPDATED;
                }
                // 保留id_orsrv ,当对编辑项通过退格键删除后，在选择其他服务，Id_orsrv存在
                tempDrug.Id_orsrv = newDrug.Id_orsrv;

                // 新加的药品要与已有的保持同频次，同周期，同用法
                tempDrug.Id_route = this.uiEmsDTO.Emsdrugs.Id_route;
                tempDrug.Name_route = this.uiEmsDTO.Emsdrugs.Name_route;

                // 同频次
                tempDrug.Id_freq = this.uiEmsDTO.Emsdrugs.Id_freq;
                tempDrug.Name_freq = this.uiEmsDTO.Emsdrugs.Name_freq;
                tempDrug.Sd_frequnitct = this.uiEmsDTO.Emsdrugs.Sd_frequnitct;
                tempDrug.Freqct = this.uiEmsDTO.Emsdrugs.Freqct;

                // 如果只有一条记录，恢复到服务默认的频次，用法
                fillSameInfoWithMedSrvDO(tempDrug, medSrv);

                // 同周期
                tempDrug.Use_days = this.uiEmsDTO.Emsdrugs.Use_days;

                // 计算总次数
                int times_cur = CalQuantumUtil.GetInstance().getTotalTimes(tempDrug.Id_freq, (int)this.uiEmsDTO.Emsdrugs.Use_days);

                // 计算总量
                tempDrug.Quan_cur = CalQuantumUtil.GetInstance().getMMQuantum(tempDrug.Sd_opmutp, tempDrug.Quan_med, tempDrug.Factor_mb, tempDrug.Factor_cb, times_cur);

                // 计算总价
                tempDrug.Totalprice = tempDrug.Price * tempDrug.Quan_cur;

                // 将返回数据加到表格数据源中
                newDrug.Replace(tempDrug);
            }

            return true;
        }

        public override void DeleteItemData(int index)
        {
            // 由于列表中可能存在逻辑删除项目，所以此处传递过来的索引值不再是列表的数组索引。而是不包含逻辑删除项目的列表的索引值
            XapDataList<EmsOrDrug> itemList = this.GetTableDataSource() as XapDataList<EmsOrDrug>;
            if (index >= 0 && index < GetCountWithOutDelete()/*itemList.Count*/)
            {
                List<Object> tmpList = new List<Object>();
                itemList.ToList().ForEach(p => { if (!p.IsDELETED) tmpList.Add(p); });
                if (tmpList.Count > 0)
                    this.DeleteItemData(tmpList.ElementAt(index));
            }
        }

        public override void DeleteItemData(object value)
        {
            XapDataList<EmsOrDrug> itemList = this.GetTableDataSource() as XapDataList<EmsOrDrug>;
            if (itemList.Count(p => !p.IsDELETED) > 0)
            {
                EmsOrDrug item = value as EmsOrDrug;
                itemList.Delete(item, item.IsNEW);
            }

            // 如果模型中数据列表为空，则新建一个空数据
            if (GetCountWithOutDelete() == 0)
            {
                SetSelectedObject(AddNew());
                this.uiEmsDTO.Emsdrugs.Fg_self = null;
                this.uiEmsDTO.Emsdrugs.Fg_selfpay = null;
                this.uiEmsDTO.Emsdrugs.Fg_treat = null;
                this.uiEmsDTO.Emsdrugs.Fg_propc = null;
                this.uiEmsDTO.Emsdrugs.Fg_mp_in = null;
                this.uiEmsDTO.Emsdrugs.Id_routedes = null;
                this.uiEmsDTO.Emsdrugs.Name_routedes = null;
                this.uiEmsDTO.Emsdrugs.Note_or = null;
            }
            // 当前选中对象为最后一个可显示的有效数据
            else
            {
                SetSelectedObject(itemList.LastOrDefault(p => !p.IsDELETED));
            }

        }

        public override int GetCountWithOutDelete()
        {
            XapDataList<EmsOrDrug> itemList = this.GetTableDataSource() as XapDataList<EmsOrDrug>;
            if (itemList.Count == 0)
                return 0;

            return itemList.ToList().Count(p => !p.IsDELETED);
        }

        public override void SetSelectedObject(object cursel)
        {
            this.mSelectedObject = cursel;
        }

        public override object GetSelectedObject()
        {
            if (this.mSelectedObject == null)
                return (this.GetTableDataSource() as XapDataList<EmsOrDrug>)[0];

            return mSelectedObject;
        }

        public override string OnRefFilterData(string filedName, StringObjectMap sbm)
        {
            String wherePart = base.OnRefFilterData(filedName, sbm);
            switch (filedName)
            {
                case "Name_srv":
                    if (this.id_dosages != "")
                    {
                        wherePart += string.Format(" and id_srvdrug is not null and id_dosage in ({0}) and BDSRV.fg_mm='Y' and (BDSRV.sd_srvtp like '0101%' or BDSRV.sd_srvtp like '0102%')", this.id_dosages);
                    }
                    else
                    {
                        wherePart += " and id_srvdrug is not null and BDSRV.fg_mm='Y' and (BDSRV.sd_srvtp like '0101%' or BDSRV.sd_srvtp like '0102%')";
                    }
                    break;
                case "Name_dep_wh":
                    EmsOrDrug drug = this.GetSelectedObject() as EmsOrDrug;
                    if (null != drug)
                    {
                        wherePart = string.Format(" id_dep in({0})", drug.Str_wh_dep_ids);
                    }
                    break;
                case "Name_route":
                    List<string> tmpIds = new List<string>();
                    this.uiEmsDTO.Emsdrugs.EmsOrDrugList.Select(p => p.Id_srv).ToList().ForEach(id => { if (id != null) tmpIds.Add(id); });

                    wherePart = string.Format("id_route in ({0})",
                        new GetSrvVsRouteImp().GetDosageVsRounte("'" +
                        string.Join("','", tmpIds) + "'"));
                    break;
                case "Name_dep":
                case "Name_mp_dep":
                    if (this.uiEmsDTO.Emsdrugs.Str_mp_dep_ids != null && this.uiEmsDTO.Emsdrugs.Str_mp_dep_ids != "")
                        wherePart = string.Format(" id_dep in({0})", this.uiEmsDTO.Emsdrugs.Str_mp_dep_ids);
                    break;
                case "Name_unit_sale":
                    if ((GetTableDataSource() as XapDataList<EmsOrDrug>)[0].Str_unit_pkg_ids != null && (GetTableDataSource() as XapDataList<EmsOrDrug>)[0].Str_unit_pkg_ids != "")
                        wherePart = string.Format("id_measdoc in ({0})", (GetTableDataSource() as XapDataList<EmsOrDrug>)[0].Str_unit_pkg_ids);
                    break;
                case "Name_freq":
                    wherePart = " Fg_use_op = 'Y' and bd_freq.FG_ACTIVE='Y'";
                    break;
                case "Name_routedes":
                    wherePart = string.Format("BD_ROUTE_DES.FG_ENTP_IP='Y'");
                    break;
            }
            return wherePart;
        }

        public override bool OnRefResultData(string fieldName, Object ds)
        {
            if (!base.OnRefResultData(fieldName, ds))
            {
                if (fieldName.Equals("Name_freq") && ds != null)
                {
                    EmsOrDrug drug = ds as EmsOrDrug;
                    this.uiEmsDTO.Emsdrugs.Freqct = drug.Freqct;
                    this.uiEmsDTO.Emsdrugs.Id_freq = drug.Id_freq;
                    this.uiEmsDTO.Emsdrugs.Name_freq = drug.Name_freq;
                    this.uiEmsDTO.Emsdrugs.Sd_frequnitct = drug.Sd_frequnitct;
                    this.uiEmsDTO.Emsdrugs.Fg_long = drug.Fg_long;
                    if (drug.Sd_frequnitct == BdSrvDictCodeConst.SD_FREQUNIT_ONCE)
                    {
                        drug.Use_days = 1;
                        this.uiEmsDTO.Emsdrugs.Use_days = 1;
                    }
                    FillSameFreqInfo(this.uiEmsDTO.Emsdrugs.Id_freq, this.uiEmsDTO.Emsdrugs.Name_freq, this.uiEmsDTO.Emsdrugs.Sd_frequnitct, this.uiEmsDTO.Emsdrugs.Fg_long, this.uiEmsDTO.Emsdrugs.Freqct);

                    this.HandleOrderTimes();
                    this.setQauntum((int)this.uiEmsDTO.Emsdrugs.Times_cur);
                    this.uiEmsDTO.Emsdrugs.EmsOrDrugList.ToList().ForEach(item =>
                    {
                        if (item.Price != null && item.Quan_cur != null)
                            item.Totalprice = item.Price * item.Quan_cur;
                    });
                }
                else if (fieldName.Equals("Name_srv") && ds != null)
                {
                    EmsOrDrug drug = ds as EmsOrDrug;


                    if (drug.Fg_ctm != null && drug.Fg_ctm.Value)
                    {
                        drug.Name_mm = String.Format("【{0}】", drug.Name_srv);
                    }
                }


                else if (fieldName.Equals("Name_route"))
                {
                    EmsOrDrug drug = ds as EmsOrDrug;
                    this.FillSameRouteInfo(drug);
                    this.uiEmsDTO.Emsdrugs.Id_route = drug.Id_route;
                    this.uiEmsDTO.Emsdrugs.Name_route = drug.Name_route;
                    this.id_dosages = LogicEx.GetInstance().getDrugRouteOfDoSages(this.uiEmsDTO.Emsdrugs.Id_route);
                }
                else if (fieldName.Equals("Name_mp_dep"))
                {
                    EmsOrDrug drug = ds as EmsOrDrug;
                    this.uiEmsDTO.Emsdrugs.Id_dep = drug.Id_mp_dep;
                    this.uiEmsDTO.Emsdrugs.Name_dep = drug.Name_mp_dep;
                }
                else if (fieldName.Equals("Name_dep"))
                {
                    FillSameMpDeptInfo(this.uiEmsDTO.Emsdrugs);
                }
                else if (fieldName.Equals("Name_routedes"))
                {
                    if (!bEdit_Note_or)
                        logicEx.SetNoteOr(this.uiEmsDTO);
                }
            }
            return false;
        }

        public override void OnDataChanged(Object ds, String fieldName, string value)
        {
            EmsOrDrug drug = ds as EmsOrDrug;
            switch (fieldName)//计算结束日期
            {
                case "Use_days"://医嘱天数
                    {
                        if (string.IsNullOrEmpty(value))
                        {
                            value = "1";
                        }
                        this.uiEmsDTO.Emsdrugs.Use_days = Int16.Parse(value);

                        this.FillSameUseDayInfo(Int16.Parse(value));

                        this.HandleOrderTimes();
                        this.setQauntum(this.uiEmsDTO.Emsdrugs.Times_cur);


                        (GetTableDataSource() as XapDataList<EmsOrDrug>).ToList().ForEach(item =>
                        {
                            if (item.Price != null && item.Quan_cur != null)
                                item.Totalprice = item.Price * item.Quan_cur;
                        });
                    }

                    break;

                case "customercolumn_sale_unit" + "_Quan_cur":

                    drug.Totalprice = (drug.Price == null ? 0 : drug.Price) * (drug.Quan_cur == null ? 0 : drug.Quan_cur);
                    break;
                case "customercolumn_sale_unit" + "_Name_unit_sale":

                    //设置物品的单价
                    drug.Price = this.logicEx.getMaterialStocksCount(drug.Id_mm, drug.Id_unit_sale);
                    this.setQauntum(this.uiEmsDTO.Emsdrugs.Times_cur);
                    drug.Totalprice = (drug.Price == null ? 0 : drug.Price) * (drug.Quan_cur == null ? 0 : drug.Quan_cur);

                    break;

                case "customercolumn_med_unit":
                    this.setQauntum(this.uiEmsDTO.Emsdrugs.Times_cur);
                    if (drug.Price != null && drug.Quan_cur != null)
                        drug.Totalprice = drug.Price * drug.Quan_cur;
                    else
                    {
                        drug.Totalprice = 0;
                    }

                    break;
                case "Times_mp_in":
                    this.uiEmsDTO.Times_mp_in = this.uiEmsDTO.Emsdrugs.Times_mp_in;
                    break;
                default:
                    break;
            }
        }

        private void FillSameMpDeptInfo(EmsDrugItemDO ems)
        {
            foreach (EmsOrDrug item in (GetTableDataSource() as XapDataList<EmsOrDrug>))
            {
                item.Id_mp_dep = ems.Id_dep;
                item.Name_mp_dep = ems.Name_dep;

            }
        }

        private void FillSameFreqInfo(string id, string name, string sd_frequnitct, bool? fg_long, int? freqct)
        {
            foreach (EmsOrDrug item in (GetTableDataSource() as XapDataList<EmsOrDrug>))
            {
                item.Id_freq = id;
                item.Name_freq = name;
                item.Sd_frequnitct = sd_frequnitct;
                item.Freqct = freqct;
                item.Fg_long = fg_long;
            }
        }

        private void FillSameRouteInfo(EmsOrDrug srcDrug)
        {
            foreach (EmsOrDrug item in (GetTableDataSource() as XapDataList<EmsOrDrug>))
            {
                item.Id_route = srcDrug.Id_route;
                item.Name_route = srcDrug.Name_route;
            }
        }

        private void FillSameUseDayInfo(int day)
        {
            foreach (EmsOrDrug item in (GetTableDataSource() as XapDataList<EmsOrDrug>))
            {
                item.Use_days = day;
            }
        }


        protected EmsOrDrug fillSameInfoWithMedSrvDO(EmsOrDrug defEmsOrdrug, MedSrvDO med)
        {
            // 剂量
            //if (med.Quan_med != null)
            {
                defEmsOrdrug.Quan_med = med.Quan_med;
            }
            if (GetCountWithOutDelete() == 1)
            {
                this.uiEmsDTO.Emsdrugs.Id_route = med.Id_route;
                this.uiEmsDTO.Emsdrugs.Name_route = med.Route_name;
            }

            if (GetCountWithOutDelete() == 1)
            {
                this.uiEmsDTO.Emsdrugs.Id_freq = med.Id_freq;
                this.uiEmsDTO.Emsdrugs.Name_freq = med.Freq_name;
                this.uiEmsDTO.Emsdrugs.Sd_frequnitct = med.Sd_frequnitct;
                this.uiEmsDTO.Emsdrugs.Freqct = med.Freqct;
            }


            return defEmsOrdrug;
        }



        protected EmsOrDrug fillSameInfoForEmsOrDrug(EmsOrDrug defEmsOrdrug, EmsDrugItemDO emsdrugs)
        {
            if (GetCountWithOutDelete()/*emsdrugs.EmsOrDrugList.Count*/ == 1)
            {
                if (emsdrugs.Use_days == null || emsdrugs.Use_days == 0)
                {
                    emsdrugs.Use_days = 1;
                }
            }

            // 相同的频次
            {
                defEmsOrdrug.Id_freq = emsdrugs.Id_freq;
                defEmsOrdrug.Name_freq = emsdrugs.Name_freq;
                defEmsOrdrug.Sd_frequnitct = emsdrugs.Sd_frequnitct;
                defEmsOrdrug.Freqct = emsdrugs.Freqct;
            }

            // 相同的用法
            {
                defEmsOrdrug.Id_route = emsdrugs.Id_route;
                defEmsOrdrug.Name_route = emsdrugs.Name_route;
            }
            // 计算不同的执行科室
            {
                OrWfDeptInfoDTO wf = new GetDeptMpImp().GetDept_mp_ids(GetEnt4BannerDTO().Code_entp, GetEnt4BannerDTO().Id_entp, defEmsOrdrug.Sd_srvtp, defEmsOrdrug.Id_srvca, defEmsOrdrug.Id_srv, defEmsOrdrug.Id_route, "", GetEnt4BannerDTO().Id_dep_nur, GetEnt4BannerDTO().Id_dep_phy);

                if (defEmsOrdrug.Id_mp_dep == null)
                {
                    defEmsOrdrug.Id_mp_dep = wf == null ? "" : wf.Firstid_mp_dept;
                    defEmsOrdrug.Name_mp_dep = wf == null ? "" : wf.Firstname_mp_dept;

                }
                if (defEmsOrdrug.Id_dep_wh == null)
                {
                    defEmsOrdrug.Id_dep_wh = wf == null ? "" : wf.Id_dept_wh;
                }
            }

            if (defEmsOrdrug.Use_days == null)
            {
                defEmsOrdrug.Use_days = (emsdrugs.Use_days == null ? 0 : emsdrugs.Use_days);
            }

            if (defEmsOrdrug.Quan_cur == null)
            {
                defEmsOrdrug.Quan_cur = 0;
            }

            return defEmsOrdrug;
        }

        public override string[] GetHiddenFields()
        {
            return new string[] { "Fg_skintest", "Fg_urgent", "Name_samptp", "Name_di", "Name_boildes", "Fg_treat", "Name_diag", "Dt_plan", "No_applyform" };
        }

        public override string[] GetReadonlyFields()
        {
            return new string[] { "Quan_cur", "Price", "Totalprice", "Name_unit_sale" };
        }
        /// <summary>
        /// 计算总量
        /// </summary>
        /// <param name="drug"></param>
        public void setQauntum(int? times_cur)
        {
            foreach (EmsOrDrug item in this.uiEmsDTO.Emsdrugs.EmsOrDrugList)
            {
                if (times_cur == null || item.Quan_med == null || item.Quan_med == 0)
                {
                    item.Quan_cur = 0;
                    continue;
                }
                if (item.Fg_ctm != null && item.Fg_ctm == true)
                {
                    item.Quan_cur = CalQuantumUtil.GetInstance().getUnMMQuantum(item.Quan_med, times_cur);
                }
                else
                {
                    item.Quan_cur = CalQuantumUtil.GetInstance().getMMQuantum(item.Sd_opmutp, item.Quan_med, item.Factor_mb, item.Factor_cb, (int)times_cur);
                }
            }

        }
        /// <summary>
        /// 计算总次数
        /// </summary>
        protected void HandleOrderTimes()
        {
            //总次数
            this.uiEmsDTO.Emsdrugs.Times_cur = CalQuantumUtil.GetInstance().getTotalTimes(this.uiEmsDTO.Emsdrugs.Id_freq, this.uiEmsDTO.Emsdrugs.Use_days);
        }

        /// <summary>
        /// 获取特殊病提示消息
        /// </summary>
        /// <param name="ctx">患者就诊环境</param>
        /// <param name="drugList">EmsOrDrug对象集合</param>
        /// <returns>特殊病诊断提示信息</returns>
        public string GetSpecialDiseaseJudgeRst(CiEnContextDTO ctx, List<EmsOrDrug> drugList)
        {
            FMap mmMap = new FMap();

            // 非特殊病患者，直接返回空串
            if (!CiEnContextUtil.IsHpSpecillPat(ctx.Ent4BannerDTO))
            {
                return "";
            }

            foreach (EmsOrDrug drug in drugList)
            {
                if (drug.Fg_selfpay == FBoolean.True)
                {
                    continue;
                }
                mmMap.Add(drug.Id_mm, drug.Name_srv+"["+drug.Name_mm+"]");
            }
            if (mmMap.Count == 0)
            {
                return "";
            }

            string specialMsg = this.ciOrdMedicalInsuranceService.GetSpecialDiseaseJudgeRst(ctx, mmMap);
            if (!string.IsNullOrEmpty(specialMsg)) {
                specialMsg += "请录入！";
            }

            return specialMsg;
        }
         
    }
}
