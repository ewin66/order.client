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
using iih.ci.ord.opemergency.declare;

namespace iih.ci.ord.opemergency.ems.dp
{
    /// <summary>
    /// <para>描    述 : 口腔检查数据处理模型                </para> 
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
    class EmsStomatologyRisViewModel : EmsRisViewModel
    {
        #region 构造函数
        public EmsStomatologyRisViewModel(Ent4BannerDTO ent)
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
            base.EditOrder(ciOrderDO);
        }

        public override bool LoadMedSrv(EmsCreatedParameter emsCreatedParameter, int pos) //EmsCreateParameter
        {
            base.LoadMedSrv(emsCreatedParameter, pos);
            return true;
        }

        #endregion

        #region 保存
        public override CiEmsDTO Save2CiEmsDTO(bool forceUpdate)
        {
            return base.Save2CiEmsDTO(forceUpdate);
        }

        public override CiOrderDO Save2Order()
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

            // 加急
            uiEmsDTO.Emsapobs.Fg_urgent = drug.Fg_urgent;

            // 价格
            uiEmsDTO.Emsapobs.Price = drug.Price;

            // 执行科室
            uiEmsDTO.Emsapobs.Id_mp_dep = drug.Id_mp_dep;
            uiEmsDTO.Emsapobs.Name_mp_dep = drug.Name_mp_dep;
            //诊断
            uiEmsDTO.Emsapobs.Id_di = drug.Id_di;
            uiEmsDTO.Emsapobs.Id_diitm = drug.Id_diitm;
            uiEmsDTO.Emsapobs.Name_diag = drug.Name_diag;
            //计划检查时间
            uiEmsDTO.Emsapobs.Dt_plan = drug.Dt_plan;
            // 保存之前的存储模型的转化
            this.orDataConvert.SaveCiDTO(this.uiEmsDTO, this.ciEmsDTO, 0);

            // 个性化补充操作
            OnBeforeCallServiceSave(this.ciEmsDTO);

            // 远程调用服务器保存,并返回 CiOrder 
            return ordMaintainService.SaveCiEmsDTO(this.ciEmsDTO,BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO);
        }

        #endregion

        #region 字段信息变化处理
        public override string OnRefFilterData(string filedName, StringObjectMap sbm)
        {
            return base.OnRefFilterData(filedName, sbm);
            //if (filedName.Equals("Name_diag"))
            //{
            //    if (sbm != null && !sbm.ContainsKey("id_ent"))
            //    {
            //        sbm.Add("id_ent", (GetEnt4BannerDTO().Id_ent));
            //    }
            //    return "";

            //}
            //else
            //{
            //    return "";
            //}
        }
        #endregion

        #region 私有方法
        private new XapDataList<EmsObsLap> getSelectedObsLap()
        {
            XapDataList<EmsObsLap> ls = new XapDataList<EmsObsLap>();
            foreach (EmsObsLap item in uiEmsDTO.Emsaplab.EmsOrObsList)
            {
                if ((item.Fg_edit != null && !item.Fg_edit.Value) || (item.Fg_chk != null && item.Fg_chk.Value))
                {
                    ls.Add(item);
                }
            }

            return ls;
        }
        #endregion
        public override string[] GetHiddenFields()
        {
            return new string[] { "Fg_skintest", "Name_route", "Name_boildes", "Spec_mm", "customercolumn_med_unit", "Name_freq", "Use_days", "customercolumn_sale_unit", "Totalprice", "Fg_treat", "Fg_extdispense" };
        }
    }
}
