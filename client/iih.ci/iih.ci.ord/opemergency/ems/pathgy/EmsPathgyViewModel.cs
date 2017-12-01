
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.en.pv.dto.d;
using iih.bd.srv.medsrv.d;
using iih.ci.ord.ciordems.d;
using xap.rui.appfw;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.ci.ord.emsdi.d;
using iih.ci.ord.opemergency.ems.common;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.ems.d;
using xap.mw.core.data;
using iih.ci.ord.i;
using iih.ci.ord.dto.emsmain;
using iih.ci.ord.common.utils;
using xap.mw.serviceframework;
using xap.rui.control.extentions;
using iih.ci.ord.ciorder.utils;
using iih.bd.srv.medsrv.i;
using iih.ci.ord.opemergency.declare;
using iih.bd.srv.ems.d;
using iih.ci.iih.ci.ord.i;

namespace iih.ci.ord.opemergency.ems.dp
{
    /// <summary>
    /// <para>描    述 :  病理医疗单数据处理模型       	</para>
    /// <para>说    明 :                      			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.ems.dp    </para>    
    /// <para>类 名 称 :  EmsPathgyViewModel        			</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/6/30 16:27:45             </para>
    /// <para>更新时间 :  2016/6/30 16:27:45             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EmsPathgyViewModel : BaseEmsViewModel
    {
        private XapDataList<EmsPathgyItemDO> lstEmsPathgyItemDO;
        private string idDepMps;

        #region 构造函数区域
        public EmsPathgyViewModel(Ent4BannerDTO ent)
            : base(ent)
        {
            lstEmsPathgyItemDO = new XapDataList<EmsPathgyItemDO>();

            uiEmsDTO.EmsType = EmsType.PATHGY;
        }
        #endregion

        /// <summary>
        /// 获取UI模型数据源
        /// </summary>
        /// <returns></returns>
        public override object GetEmsUIDTO()
        {
            return base.GetEmsUIDTO();
        }

        /// <summary>
        /// 病理列表数据模型
        /// </summary>
        /// <returns></returns>
        public override object GetTableDataSource()
        {
            return lstEmsPathgyItemDO;
        }

        /// <summary>
        /// 病理选项卡数据模型
        /// </summary>
        /// <returns></returns>
        public override object GetFormDataSource()
        {
            return this.uiEmsDTO.Emsappathgy;
        }

        /// <summary>
        /// 清空病理项目
        /// </summary>
        public override void ClearTableDataSource()
        {
            this.lstEmsPathgyItemDO.Clear();
        }

        /// <summary>
        /// 保存之前处理
        /// </summary>
        /// <param name="ems"></param>
        protected override void OnBeforeCallServiceSave(CiEmsDTO ems)
        {
            base.OnBeforeCallServiceSave(ems);

            ems.Fg_mp_in = true;
            ems.Times_mp_in = ems.Times_cur;

            //ems.Dt_begin = this.uiEmsDTO.Emsappathgy.Dt_begin_ui;
            //ems.Dt_end = this.uiEmsDTO.Emsappathgy.Dt_end_ui;

            if (ems.Emssrvs != null)
                ems.Emssrvs.Cast<CiEmsSrvDTO>().Where(srv => srv.Eu_sourcemd == (int)OrSrvSourceFromEnum.PHYSIAN).ToList().ForEach(srv =>
                {
                    srv.Quan_total_medu = ems.Times_mp_in * srv.Quan_med;
                });
        }

        /// <summary>
        /// 病理项目空判断
        /// </summary>
        /// <returns></returns>
        public override bool IsEmpty()
        {
            return lstEmsPathgyItemDO == null || lstEmsPathgyItemDO.Count == 0 ||
                (lstEmsPathgyItemDO.Count == 1 && String.IsNullOrEmpty(lstEmsPathgyItemDO[0].Id_srv));
        }

        /// <summary>
        /// 加载病理数据
        /// </summary>
        /// <param name="medSrvDO"></param>
        public override bool LoadMedSrv(EmsCreatedParameter emsCreatedParameter, int pos)
        {
            base.LoadMedSrv(emsCreatedParameter, pos);

            MedSrvDO medSrvDO = emsCreatedParameter.getMedSrvDO();
            this.uiEmsDTO.MedSrvDO = medSrvDO;
            EmsRstDTO[] rsts = CreateRemote(medSrvDO.Id_srv);
            EmsRstDTO rst = rsts[0];
                if (rst != null)
                {
                uiEmsDTO.Emsappathgy.deSerializeJson((rst.Document[0] as EmsPathgyItemDO).serializeJson());
                //String utf8Str = System.Text.Encoding.UTF8.GetString(Convert.FromBase64String(rst.DocumentString));
                //uiEmsDTO.Emsappathgy.deSerializeJson(utf8Str);

                    if (rst.Extension != null && rst.Extension.Keys.Contains("MedSrvDO"))
                    {
                        this.uiEmsDTO.MedSrvDO = rst.Extension["MedSrvDO"] as MedSrvDO;
                        strSd_srvtp = this.uiEmsDTO.MedSrvDO.Sd_srvtp;
                    }
                    this.lstEmsPathgyItemDO.Clear();
                    if (uiEmsDTO.Emsappathgy.EmsItemInpathgy.Count <= 0)
                    {
                        uiEmsDTO.Emsappathgy.EmsItemInpathgy.AddNew();
                        uiEmsDTO.Emsappathgy.EmsItemInpathgy[0].Sortno = 1;
                    }

                    this.lstEmsPathgyItemDO.Add(uiEmsDTO.Emsappathgy);
                }

            return true;
        }

        /// <summary>
        /// 编辑病理数据
        /// </summary>
        /// <param name="ciOrderDO"></param>
        public override void EditOrder(CiOrderDO ciOrderDO)
        {
            New_EditOrder(ciOrderDO);
        }

        /// <summary>
        /// 优化前编辑方法
        /// </summary>
        /// <param name="ord"></param>
        private void Old_EditOrder(CiOrderDO ord)
        {
            OrWfDeptInfoDTO wf = new GetDeptMpImp().GetDept_mp_ids(this.uiEmsDTO.PatInfo.Code_entp,
                this.uiEmsDTO.PatInfo.Id_entp,
                this.uiEmsDTO.MedSrvDO.Sd_srvtp,
                this.uiEmsDTO.MedSrvDO.Id_srvca,
                this.uiEmsDTO.MedSrvDO.Id_srv,
                this.uiEmsDTO.MedSrvDO.Id_route,
                "", this.uiEmsDTO.PatInfo.Id_dep_nur, this.uiEmsDTO.PatInfo.Id_dep_phy);
            idDepMps = (wf == null ? "" : wf.Id_mp_depts);
            base.EditOrder(ord);
            orCiEmsToUiEms.EditPathgy(this.uiEmsDTO, this.ciEmsDTO);
            // 价格
            uiEmsDTO.Emsappathgy.Price = this.logicEx.getSrvNotMMPri(uiEmsDTO.MedSrvDO, null);
            this.lstEmsPathgyItemDO.Add(uiEmsDTO.Emsappathgy);
        }

        /// <summary>
        /// 优化后编辑方法
        /// </summary>
        /// <param name="ord"></param>
        private void New_EditOrder(CiOrderDO ord)
        {
            ICiEmsMainService emsMainService = XapServiceMgr.find<ICiEmsMainService>();
            if (null != emsMainService)
            {
                EmsLoadDTO[] emsloads = new EmsLoadDTO[1];
                var emsload = new EmsLoadDTO();
                emsload.Id_or = ord.Id_or;
                emsload.Extension = new FMap2();
                emsload.EnContext = CiEnContextUtil.GetCiEnContext(this.GetEnt4BannerDTO(), this.GetContext());
                emsload.EmsDriver = ((int)this.uiEmsDTO.EmsType).ToString();
                emsload.OperateSourceFrom = IOprSourceFromConst.IOSF_EMS;
                emsloads[0] = emsload;
                EmsRstDTO[] rsts = emsMainService.load(emsloads);
                EmsRstDTO rst = rsts[0];
                if (rst != null)
                {

                    uiEmsDTO.Emsappathgy.deSerializeJson((rst.Document[0] as EmsPathgyItemDO).serializeJson());
                    //String utf8Str = System.Text.Encoding.UTF8.GetString(Convert.FromBase64String(rst.DocumentString));
                    //uiEmsDTO.Emsappathgy.deSerializeJson(utf8Str);

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
                        idDepMps = rst.Extension["MpDepFilter"] as String;
                    }
                    else
                    {
                        idDepMps = "";
                    }

                    if (this.uiEmsDTO.Emsappathgy.EmsItemInpathgyList != null)
                    {
                        if (null == this.uiEmsDTO.Emsappathgy.EmsItemInpathgy)
                        {
                            this.uiEmsDTO.Emsappathgy.EmsItemInpathgy = new XapDataList<EmsItemInPathgy>();
                        }
                        this.uiEmsDTO.Emsappathgy.EmsItemInpathgy.Clear();
                        this.uiEmsDTO.Emsappathgy.EmsItemInpathgyList.Cast<EmsItemInPathgy>().ToList().ForEach(o =>
                        {
                            this.uiEmsDTO.Emsappathgy.EmsItemInpathgy.Add(o);
                        });
                    }

                    if (uiEmsDTO.Emsappathgy.EmsItemInpathgy.Count <= 0)
                    {
                        uiEmsDTO.Emsappathgy.EmsItemInpathgy.AddNew();
                        uiEmsDTO.Emsappathgy.EmsItemInpathgy[0].Sortno = 1;
                    }

                }

                this.lstEmsPathgyItemDO.Add(uiEmsDTO.Emsappathgy);

                // 其他
                this.ciEmsDTO.Status = DOStatus.UPDATED;
                this.uiEmsDTO.Status = DOStatus.UPDATED;

                // 处理分拣费用项目
                HandleExpenseItems(ciEmsDTO);
            }
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="ems"></param>
        public override void EditEms(CiEmsDTO ems)
        {
            base.EditEms(ems);

            OrWfDeptInfoDTO wf = new GetDeptMpImp().GetDept_mp_ids(this.uiEmsDTO.PatInfo.Code_entp,
               this.uiEmsDTO.PatInfo.Id_entp,
               this.uiEmsDTO.MedSrvDO.Sd_srvtp,
               this.uiEmsDTO.MedSrvDO.Id_srvca,
               this.uiEmsDTO.MedSrvDO.Id_srv,
               this.uiEmsDTO.MedSrvDO.Id_route,
               "", this.uiEmsDTO.PatInfo.Id_dep_nur, this.uiEmsDTO.PatInfo.Id_dep_phy);
            idDepMps = (wf == null ? "" : wf.Id_mp_depts);
           
            orCiEmsToUiEms.EditPathgy(this.uiEmsDTO, ems);
            this.uiEmsDTO.Status = DOStatus.NEW;
            // 价格
            uiEmsDTO.Emsappathgy.Price = this.logicEx.getSrvNotMMPri(uiEmsDTO.MedSrvDO, null);
            this.lstEmsPathgyItemDO.Add(uiEmsDTO.Emsappathgy);
        }

        public override string OnRefFilterData(string filedName,StringObjectMap sbm)
        {
            String wherePart = "";
            
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
                wherePart = String.IsNullOrEmpty(wherePart) ? string.Format(" (Sd_srvtp like '0207%')") : wherePart + string.Format(" and (Sd_srvtp like '0207%')");
            }
            
            else if ((filedName.Equals("Name_mp_dep") ||filedName.Equals("Name_dep_coll")) && !string.IsNullOrWhiteSpace(idDepMps))
            {
                wherePart = string.Format(" id_dep in ({0})", idDepMps);
            }
            else
            {
                wherePart = base.OnRefFilterData(filedName, sbm);
            }

            
            return wherePart;
        }

        public override CiOrderDO Save2Order()
        {
            return base.Save2Order();
            //return this.New_Save();
        }

        /// <summary>
        /// 新病理后台保存逻辑调用
        /// </summary>
        /// <returns></returns>
        private CiOrderDO New_Save()
        {
                this.uiEmsDTO.Emsappathgy.Id_srvof = emsMgrDTO.Id_ems;

                this.uiEmsDTO.Emsappathgy.EmsItemInpathgyList = new FArrayList();
                foreach (var item in this.uiEmsDTO.Emsappathgy.EmsItemInpathgy)
                {
                    this.uiEmsDTO.Emsappathgy.EmsItemInpathgyList.append(item);
                }
               
                EmsRstDTO rst = SaveRemote(this.uiEmsDTO.Emsappathgy);
                if (rst != null)
                {
                    return (rst.Document[0] as CiorderAggDO).getParentDO();
                }
            

            return null;
        }

        /// <summary>
        /// 获取病理下属标本列表
        /// </summary>
        /// <returns></returns>
        public XapDataList<EmsItemInPathgy> getEmsItemInPathgys()
        {
            return this.uiEmsDTO.Emsappathgy.EmsItemInpathgy;
        }

        public override int GetCountWithOutDelete()
        {
            var itemList = this.GetTableDataSource() as XapDataList<EmsPathgyItemDO>;
            if (itemList.Count == 0)
                return 0;

            return itemList.ToList().Count(p => !p.IsDELETED);
        }

        public override string[] GetReadonlyFields()
        {
            return new string[] { "Name_srv" };
        }
    }
}
