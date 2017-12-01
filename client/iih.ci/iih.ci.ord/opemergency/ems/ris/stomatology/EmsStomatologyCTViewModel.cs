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
    /// <para>描    述 : 口腔CT检查数据处理模型                </para> 
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
    class EmsStomatologyCTViewModel : EmsRisViewModel
    {
        #region 构造函数
        public EmsStomatologyCTViewModel(Ent4BannerDTO ent)
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
            return base.Save2Order();
        }

        #endregion

        #region 字段信息变化处理
        public override string OnRefFilterData(string filedName, StringObjectMap sbm)
        {
            /*return base.refFilterData(filedName);*/
            if (filedName.Equals("Name_di"))
            {
                return " id_ent ='" + this.uiEmsDTO.PatInfo.Id_ent + "'";

            }
            else
            {
                return "";
            }
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

    }
}
