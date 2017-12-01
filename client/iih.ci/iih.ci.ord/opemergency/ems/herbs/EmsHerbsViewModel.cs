using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.appfw;
using iih.ci.ord.ciordems.d;
using iih.en.pv.dto.d;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.opemergency.ems.common;
using iih.bd.srv.medsrv.d;
using xap.mw.core.data;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.ems.d;
using iih.bd.bc.udi;
using xap.cli.sdk.controls.DataView;
using iih.ci.ord.opemergency.dialog;
using System.Windows.Forms;
using iih.bl.hp.bdhpindicationdto.d;
using iih.ci.ord.ciorder.utils;
using xap.rui.control.extentions;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.dto.emsmain;
using iih.ci.ord.common.utils;
using iih.ci.ord.i;
using xap.mw.serviceframework;
using iih.ci.ord.emsdi.d;
using iih.bd.srv.medsrv.i;
using iih.ci.ord.opemergency.declare;
using iih.bd.srv.ems.d;
using iih.ci.iih.ci.ord.i;

namespace iih.ci.ord.opemergency.ems.dp
{
    /// <summary>
    /// <para>描    述 :  草药数据处理模型            	</para>
    /// <para>说    明 :                      			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.ems.dp    </para>    
    /// <para>类 名 称 :  EmsHerbsViewModel        			</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/6/30 16:27:45             </para>
    /// <para>更新时间 :  2016/6/30 16:27:45             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    class EmsHerbsViewModel : EmsDrugsViewModel
    {

        /// <summary>
        /// 获取医疗单数据接口
        /// </summary>
        private ICiEmsMainService emsMainService = XapServiceMgr.find<ICiEmsMainService>();

        public EmsHerbsViewModel(Ent4BannerDTO ent)
            : base(ent)
        {

        }

        /// <summary>
        /// 初始化方法
        /// </summary>
        public override void Init()
        {
            base.Init();

            this.uiEmsDTO.EmsType = EmsType.HERB;
        }

        /// <summary>
        /// 新增一条空记录，草药医疗单保证列表中只有一条记录
        /// </summary>
        /// <returns></returns>
        public override object AddNew()
        {
            (this.GetTableDataSource() as XapDataList<EmsOrDrug>).Clear();
            EmsOrDrug newDrug = (this.GetTableDataSource() as XapDataList<EmsOrDrug>).AddNew();
            this.SetSelectedObject(newDrug);
            return newDrug;
        }
        /// <summary>
        ///新增草药控件格子
        /// </summary>
        public void AddNewHerbControl()
        {
            if(!(this.GetTableDataSource() is XapDataList<EmsOrDrug>))return;
            EmsOrDrug newDrug = (this.GetTableDataSource() as XapDataList<EmsOrDrug>)[0];
            if (this.uiEmsDTO.Emsdrugs.EmsOrDrugList.Count(p => p== newDrug && !p.IsDELETED) > 0) {return;}                        
            this.uiEmsDTO.Emsdrugs.EmsOrDrugList.Add(newDrug);
            this.SetSelectedObject(newDrug);
        }

        public override object GetSelectedObject()
        {
            if (this.mSelectedObject == null)
            {
                return (this.GetTableDataSource() as XapDataList<EmsOrDrug>)[0];
            }
            return this.mSelectedObject;
        }

        /// <summary>
        /// 获取医疗单列表模型对象
        /// </summary>
        /// <returns></returns>
        public override object GetTableDataSource()
        {
            return this.uiEmsDTO.Emsdrugs.EmsOrDrug;
        }

        public override int GetCountWithOutDelete()
        {
            var itemList = getCardTable();
            if (itemList.Count == 0)
                return 0;

            return itemList.ToList().Count(p => !p.IsDELETED);
        }

        public override bool LoadMedSrv(EmsCreatedParameter emsCreatedParameter, int pos) //EmsCreateParameter
        {    
            MedSrvDO med = emsCreatedParameter.getMedSrvDO();
            String id_mm = emsCreatedParameter.getMmID();

            if (String.IsNullOrEmpty(id_mm))
            {
                this.errorMsgString = "没有物品ID";
                return false;
            }            

            // 获取列表最后一个数据
            EmsOrDrug newDrug = null;
            AssCostTimeTool.Enabled = true;

            AssCostTimeTool t1 = new AssCostTimeTool("加载数据时候，LoadMedSrv2 解析 MedSrv 耗时：", false);

            EmsRstDTO[] rsts = CreateRemote(med.Id_srv, id_mm);
            EmsRstDTO rst = rsts[0];
            if (rst != null)
            {

                EmsDrugItemDO emsDrugItem = (rst.Document[0] as EmsDrugItemDO);
                //String utf8Str = System.Text.Encoding.UTF8.GetString(Convert.FromBase64String(rst.DocumentString));
                //EmsDrugItemDO emsDrugItem = new EmsDrugItemDO();
                //emsDrugItem.deSerializeJson(utf8Str);

                FMap2 emsExtMap = rst.Extension;
               
                MedSrvDO medSrv = emsExtMap["MedSrvDO"] as MedSrvDO;
                OrWfDeptInfoDTO wf = emsExtMap["OrWfDeptInfoDTO"] as OrWfDeptInfoDTO;

                emsDrugItem.EmsOrDrug = new XapDataList<EmsOrDrug>();

                // 列表中显示的物品
                XapDataList<EmsOrDrug> emsOrDrugList = new XapDataList<EmsOrDrug>();
                FArrayList drugList_ex = emsDrugItem.EmsOrDrugListEx;
                foreach (EmsOrDrug drug in drugList_ex)
                {
                    emsOrDrugList.Add(drug);
                    emsDrugItem.EmsOrDrug.Add(drug);
                }

                newDrug = this.GetSelectedObject() as EmsOrDrug;
                if (pos < 0)
                {
                    this.uiEmsDTO.MedSrvDO = med;
                    emsDrugItem.EmsOrDrugList = emsOrDrugList;
                    this.uiEmsDTO.Emsdrugs = emsDrugItem;
                    return true;
                }

                //TODO: 可以放到查询药品前，重复就不用走后台了
                if (this.uiEmsDTO.Emsdrugs.EmsOrDrugList.Count(p => p.Name_srv == newDrug.Name_srv && !p.IsDELETED) > 1)
                {
                    this.errorMsgString = "已经存在服务【" + medSrv.Name + "】！";
                    this.uiEmsDTO.Emsdrugs.EmsOrDrugList.Remove(newDrug);
                    this.logicEx.Clear<EmsOrDrug>(newDrug);
                    newDrug.Status = DOStatus.NEW;
                    this.uiEmsDTO.Emsdrugs.EmsOrDrug.Clear();
                    this.uiEmsDTO.Emsdrugs.EmsOrDrug.Add(newDrug);
                    return false;
                }
                
                // 获取从后台返回的用于医嘱列表显示的数据
                if (emsOrDrugList== null || string.IsNullOrEmpty(emsOrDrugList[0].Id_mm))
                {// TODO 什么情况没有数据
                    this.errorMsgString = "服务未绑定物品，请联系信息科！";
                    this.logicEx.Clear<EmsOrDrug>(newDrug);
                    return false;
                }
                EmsOrDrug tempDrug = emsOrDrugList[0];

                if (!newDrug.IsUPDATED)
                {
                    tempDrug.Status = DOStatus.NEW;
                }
                else
                { // 增加该逻辑分支   针对 已保存的 医嘱项目 进行服务项目的修改 -- 2016-11-21 by wangqz
                    tempDrug.Status = DOStatus.UPDATED;
                    tempDrug.Id_orsrv = newDrug.Id_orsrv;
                }


                // 新加的药品要与已有的保持同频次，同周期，同用法
                tempDrug.Id_route = this.uiEmsDTO.Emsdrugs.Id_route;
                tempDrug.Name_route = this.uiEmsDTO.Emsdrugs.Name_route;

                // 草药外配标识在医疗单中，勾选外配，全为外配
                tempDrug.Fg_extdispense = this.uiEmsDTO.Emsdrugs.Fg_extdispense;

                // 同频次
                tempDrug.Id_freq = this.uiEmsDTO.Emsdrugs.Id_freq;
                tempDrug.Name_freq = this.uiEmsDTO.Emsdrugs.Name_freq;
                tempDrug.Sd_frequnitct = this.uiEmsDTO.Emsdrugs.Sd_frequnitct;
                tempDrug.Freqct = this.uiEmsDTO.Emsdrugs.Freqct;

                // 如果只有一条记录，恢复到服务默认的频次，用法
                fillSameInfoWithMedSrvDO(tempDrug, medSrv);

                // 同周期
                tempDrug.Use_days = this.uiEmsDTO.Emsdrugs.Use_days;

                // 计算总次数 TODO 需要提供前台计算方法，数据都有了，不用走后台了
                int? times_cur = this.uiEmsDTO.Emsdrugs.Times_cur;// CalQuantumUtil.GetInstance().getTotalTimes(tempDrug.Id_freq, (int)this.uiEmsDTO.Emsdrugs.Use_days);


                int? orders = this.uiEmsDTO.Emsdrugs.Orders;
                // 计算总量
                tempDrug.Quan_cur = CalQuantumUtil.GetInstance().getMMQuantum(tempDrug.Sd_mupkgutp, tempDrug.Quan_med, tempDrug.Factor_mb, tempDrug.Factor_cb, orders);

                tempDrug.Totalprice = tempDrug.Price * tempDrug.Quan_cur; // 计算总价

                // 将返回数据加到表格数据源中
                newDrug.Replace(tempDrug);
            }

            return true;
        }

        /// <summary>
        /// 编辑医嘱
        /// </summary>
        /// <param name="ciOrderDO"></param>
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
                       // strMpDepFilter = rst.EmsExtension["MpDepFilter"] as String;
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

                    this.ciEmsDTO.SetUpdated();
                    this.uiEmsDTO.Status = DOStatus.UPDATED;
                    HandleExpenseItems(ciEmsDTO);
                }

        }

        public override void EditEms(CiEmsDTO ems)
        {
            this.ciEmsDTO = ems;
            // 处理分拣费用项目
            this.HandleExpenseItems(ems);

            this.orCiEmsToUiEms.EditDrug(ems, this.uiEmsDTO);
            this.uiEmsDTO.Status = DOStatus.NEW;
            // 修正一些关键信息：执行部门
            foreach (EmsOrDrug item in this.uiEmsDTO.Emsdrugs.EmsOrDrugList)
            {
                if (item.Id_mp_dep == null)
                {
                    item.Id_mp_dep = this.uiEmsDTO.Emsdrugs.Id_dep;
                    item.Name_mp_dep = this.uiEmsDTO.Emsdrugs.Name_dep;
                }
                // 用法
                if (item.Id_route == null)
                {
                    item.Id_route = this.uiEmsDTO.Emsdrugs.Id_route;
                    item.Name_route = this.uiEmsDTO.Emsdrugs.Name_route;
                }
                // 使用天数
                if (item.Use_days == null)
                {
                    item.Use_days = this.uiEmsDTO.Emsdrugs.Use_days;
                }
                // 总价
                //item.Quan_cur = item.Quan_med * (this.uiEmsDTO.Emsdrugs.Orders == null ? 0 : this.uiEmsDTO.Emsdrugs.Orders);

                // 计算 明细总金额
                item.Totalprice = item.Quan_cur * item.Price;
            }
            this.uiEmsDTO.Emsdrugs.EmsOrDrug.Clear();
            this.uiEmsDTO.Emsdrugs.EmsOrDrug.Add(this.uiEmsDTO.Emsdrugs.EmsOrDrugList.FirstOrDefault());
        }

        protected override void OnBeforeCallServiceSave(CiEmsDTO ems)
        {
            base.OnBeforeCallServiceSave(ems);
            ems.Fg_mp_in = false;
            if (ems.Emssrvs != null)
                ems.Emssrvs.Cast<CiEmsSrvDTO>().Where(srv => srv.Eu_sourcemd == (int)OrSrvSourceFromEnum.PHYSIAN).ToList().ForEach(srv =>
                {
                srv.Quan_total_medu = 0;
            });
        }

        public override CiOrderDO Save2Order()
        {
            //处理草药的代煎付数
            if (true == this.uiEmsDTO.Emsdrugs.Fg_boil)
            {
                this.uiEmsDTO.Emsdrugs.Orders_boil = this.uiEmsDTO.Emsdrugs.Orders;
            }
            else
            {
                this.uiEmsDTO.Emsdrugs.Orders_boil = 0;
            }
            return base.Save2Order();
        }

        public CiOrderDO New_Save()
        {
                this.uiEmsDTO.Emsapcons.Id_srvof = emsMgrDTO.Id_ems;
                //处理草药的代煎付数
                if (true == this.uiEmsDTO.Emsdrugs.Fg_boil)
                {
                    this.uiEmsDTO.Emsdrugs.Orders_boil = this.uiEmsDTO.Emsdrugs.Orders;
                }
                else
                {
                    this.uiEmsDTO.Emsdrugs.Orders_boil = 0;
                }

            this.uiEmsDTO.Emsdrugs.EmsOrDrugListEx.Clear();
            XapDataList<EmsOrDrug> drugList = this.uiEmsDTO.Emsdrugs.EmsOrDrugList;
            foreach (EmsOrDrug drug in this.uiEmsDTO.Emsdrugs.EmsOrDrugList)
            {
                this.uiEmsDTO.Emsdrugs.EmsOrDrugListEx.Add(drug);
            }


            EmsRstDTO rst = SaveRemote(this.uiEmsDTO.Emsdrugs);
                if (rst != null)
                {

                    return (rst.Document[0] as CiorderAggDO).getParentDO();

                }

            return null;
        }

        /// <summary>
        /// 删除草药医疗单医嘱项目
        /// </summary>
        /// <param name="value"></param>
        public override void DeleteItemData(object value)
        {
            if (null != value)
            {
                EmsOrDrug drug = value as EmsOrDrug;
                
                this.uiEmsDTO.Emsdrugs.EmsOrDrugList.Delete(drug, drug.IsNEW);

                this.ClearTableDataSource();
                if (this.uiEmsDTO.Emsdrugs.EmsOrDrugList.Count(p => !p.IsDELETED) > 0)
                {
                    // 选择最后一个没有被逻辑删除的草药项目
                    EmsOrDrug item = this.uiEmsDTO.Emsdrugs.EmsOrDrugList.LastOrDefault(p => !p.IsDELETED);
                    this.uiEmsDTO.Emsdrugs.EmsOrDrug.Add(item);
                    this.SetSelectedObject(item);
                }
                else
                {
                    this.AddNew();
                }

            }

        }
        /// <summary>
        /// 选择最后一个没有被逻辑删除的草药项目
        /// </summary>
        public void SelectLastHerbs()
        {
            this.ClearTableDataSource();
            EmsOrDrug item = this.uiEmsDTO.Emsdrugs.EmsOrDrugList.LastOrDefault(p => !p.IsDELETED);
            this.uiEmsDTO.Emsdrugs.EmsOrDrug.Add(item);
            this.SetSelectedObject(item);
        }

        /// <summary>
        /// 医疗单数据改变时候需要处理一些模型中的对应数据
        /// </summary>
        /// <param name="index">列表中数据改变时候，需要给定该值，否则 -1</param>
        /// <param name="fieldName">字段名称</param>
        /// <param name="value">新值</param>
        public override void OnDataChanged(Object ds, string fieldName, string value)
        {

            if (fieldName.Equals("Fg_boil"))
            {
                //                 bool fg_boil = (value != null && value.Equals("true") ? true : false);
                //                 this.uiEmsDTO.Emsdrugs.Fg_boil = fg_boil;
                this.uiEmsDTO.Emsdrugs.Orders_boil = (this.uiEmsDTO.Emsdrugs.Fg_boil.Value ? this.uiEmsDTO.Emsdrugs.Orders : 0);
            }
            else if (fieldName.Equals("Orders"))
            {
                EmsOrDrug drug = this.uiEmsDTO.Emsdrugs.EmsOrDrug[0];
                this.setQauntum(this.uiEmsDTO.Emsdrugs.Orders);
                // 计算 明细总金额
                this.uiEmsDTO.Emsdrugs.EmsOrDrugList.ToList().ForEach(item =>
                {
                    item.Totalprice = (item.Quan_cur == null ? 0 : item.Quan_cur) * (item.Price == null ? 0 : item.Price);
                });
                // 如果勾选了代煎，则需要处理代煎剂数
                if (this.uiEmsDTO.Emsdrugs.Fg_boil != null && this.uiEmsDTO.Emsdrugs.Fg_boil.Value)
                {

                    this.uiEmsDTO.Emsdrugs.Orders_boil = (this.uiEmsDTO.Emsdrugs.Fg_boil.Value ? this.uiEmsDTO.Emsdrugs.Orders : 0);
                }

            }
            else if (fieldName.Equals("customercolumn_med_unit"))
            {
                var drug = this.uiEmsDTO.Emsdrugs.EmsOrDrug[0];
                // 空药品时候，不做处理
                if (String.IsNullOrEmpty(drug.Id_mm) || String.IsNullOrEmpty(drug.Id_srv))
                {
                    return;
                }
                if (this.uiEmsDTO.Emsdrugs.Orders == null || drug.Quan_med == null)
                {
                    drug.Quan_cur = 0;
                }
                else
                {
                    drug.Quan_cur = this.uiEmsDTO.Emsdrugs.Orders * drug.Quan_med;
                }
                // 计算 明细总金额
                if (drug.Quan_cur != null && drug.Price != null)
                {
                    drug.Totalprice = drug.Quan_cur * drug.Price;
                }
                else
                {
                    drug.Totalprice = 0;
                }


            }
            else if (fieldName.Equals("customercolumn_sale_unit"))
            {
                EmsOrDrug drug = this.uiEmsDTO.Emsdrugs.EmsOrDrug[0];
                // 空药品时候，不做处理
                if (String.IsNullOrEmpty(drug.Id_mm) || String.IsNullOrEmpty(drug.Id_srv))
                {
                    return;
                }
                this.setQauntum(this.uiEmsDTO.Emsdrugs.Orders);
                //设置物品的单价
                drug.Price = this.logicEx.getMaterialStocksCount(drug.Id_mm, drug.Id_unit_sale);

                if (drug.Price != null && drug.Quan_cur != null)
                {
                    drug.Totalprice = drug.Quan_cur * drug.Price;
                }
                else
                {
                    drug.Totalprice = 0;
                }
            }
            else if (fieldName.Equals("Use_days"))
            {
                this.uiEmsDTO.Days_or = this.uiEmsDTO.Emsdrugs.Use_days;
                this.HandleOrderTimes();
            }
            else if (fieldName.Equals("Fg_extdispense"))
            {
                setFg_extdispenseForDrugs();
            }
        }

        public override bool OnRefResultData(string fieldName, Object ds)
        {

            if (fieldName.Equals("Name_boil") || fieldName.Equals("Name_freq") ||
                fieldName.Equals("Name_route") || fieldName.Equals("Name_routedes"))
            {
                EmsOrDrug drug = this.uiEmsDTO.Emsdrugs.EmsOrDrug[0];
                if (drug.Quan_med != null && this.uiEmsDTO.Emsdrugs.Orders != null)
                {
                    this.HandleOrderTimes();
                    this.setQauntum( this.uiEmsDTO.Emsdrugs.Orders);
                    //this.logicEx.GetDrugTotal(drug, this.uiEmsDTO.Emsdrugs.Orders.Value, this.GetEnt4BannerDTO().Code_entp);
                }
                // 计算 明细总金额
                drug.Totalprice = (drug.Quan_cur==null?0:drug.Quan_cur)* (drug.Price==null?0:drug.Price);

                foreach (EmsOrDrug d in this.uiEmsDTO.Emsdrugs.EmsOrDrugList)
                {
                    d.Sd_frequnitct = this.uiEmsDTO.Emsdrugs.Sd_frequnitct;
                }
                // 规格化备注
                //this.uiEmsDTO.Emsdrugs.Note_or = string.Format("每日{0}付,{1}至400ml,{2},{3}{4}", 1, this.uiEmsDTO.Emsdrugs.Name_boil, this.uiEmsDTO.Emsdrugs.Name_freq, this.uiEmsDTO.Emsdrugs.Name_routedes, this.uiEmsDTO.Emsdrugs.Name_route)
                //.Replace(",,", ",");
                bool fg_edited = (bool)ds;
                if(!fg_edited)
                logicEx.SetNoteOr(this.uiEmsDTO);
                return true;

            }

            return false;
        }

        /// <summary>
        /// 医疗单
        /// </summary>
        /// <param name="filedName"></param>
        /// <returns></returns>
        public override string OnRefFilterData(string filedName, StringObjectMap sbm)
        {
            String wherePart = base.OnRefFilterData(filedName,sbm);

            switch (filedName)
            {
                case "Name_srv":
                    //sbm.Add("code_entp", "00");
                        string id_hp = GetEnt4BannerDTO().Id_hp;
                        if (id_hp != null && id_hp != "")
                        {
                        if (!sbm.ContainsKey("id_hp"))
                        {
                                sbm.Add("id_hp", id_hp);
                            }
                        }
                        wherePart = "";
                        if (GetCountWithOutDelete() > 0)
                        {
                            String prefixStr = this.uiEmsDTO.Emsdrugs.Sd_srvtp.Substring(0, 4);
                            wherePart = string.Format(" Sd_srvtp = '{0}'", this.uiEmsDTO.Emsdrugs.Sd_srvtp);
                        }
                        if (wherePart != "")
                        {
                            wherePart += string.Format(" and Sd_srvtp!='{0}'", BdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH);
                        }
                        else
                        {
                            wherePart += string.Format(" Sd_srvtp!='{0}'", BdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH);
                        }
                        return wherePart;
                    //if (this.uiEmsDTO.Emsdrugs.EmsOrDrugList.Count > 1)
                    //    wherePart = wherePart == "" ? string.Format(" Sd_srvtp like '0103%'") : wherePart + string.Format(" and Sd_srvtp like '0103%'");
                    //break;
                case "Name_route":
                    wherePart = string.Format("id_route in ({0})", new GetSrvVsRouteImp().GetHerbRounte());
                    break;
                case "Name_freq":
                    wherePart = string.Format("id_freq not in ({0})", "'0001AA1000000006BR2U','0001AA10000000079NW4'");
                    break;
            }

            return wherePart;
        }

        public bool HasEmptyHerbs()
        {
            EmsOrDrug [] szHerbs = (GetFormDataSource() as EmsDrugItemDO).EmsOrDrugList.ToArray();
            if (null != szHerbs)
                return szHerbs.ToList().Count(p => String.IsNullOrEmpty(p.Id_srv) && String.IsNullOrEmpty(p.Sd_srvtp)) > 0;
            else
                return false;
        }

        public XapDataList<EmsOrDrug> getCardTable()
        {
            return this.uiEmsDTO.Emsdrugs.EmsOrDrugList;
        }
        /// <summary>
        /// 设置外配药标识
        /// </summary>
        private void setFg_extdispenseForDrugs()
        {
            foreach (EmsOrDrug item in this.uiEmsDTO.Emsdrugs.EmsOrDrugList)
            {
                item.Fg_extdispense = this.uiEmsDTO.Emsdrugs.Fg_extdispense;
            }
        }
        public override string[] GetHiddenFields()
        {
            return new string[] { "Name_route", "Name_freq", "Fg_skintest", "Fg_urgent", "Use_days", "Name_diag", "Dt_plan", "No_applyform", "Fg_extdispense" };

        }

        public override string[] GetReadonlyFields()
        {
            return new string[] { "Quan_cur", "Price", "Totalprice", "Name_unit_sale","Fg_treat" };
        }
    }



}
