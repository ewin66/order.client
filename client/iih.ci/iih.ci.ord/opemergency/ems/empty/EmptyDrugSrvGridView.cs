using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.view.basic;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.control.forms.model;
using xap.rui.control.formcontrol.model;
using xap.rui.control.refcontrol.events;
using xap.cli.sdk.controls.DataView;
using xap.rui.appfw;
using iih.ci.ord.ciordems.d;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.view;
using xap.rui.control.forms.control;
using xap.rui.control.extentions;
using iih.bd.bc.udi;
using iih.bd.srv.ems.d;
using xap.cli.sdk.common;
using xap.cli.sdk.controls.DataView.Model;
using iih.ci.ord.common.utils.msg;
using iih.ci.ord.opemergency.tool;
using xap.rui.control.basecontrol;
using iih.ci.ord.opemergency.declare;
using iih.en.pv.dto.d;
using xap.mw.coreitf.d;
using iih.ci.ord.medicaresharing.mdeicalrule;
using iih.bd.srv.medsrv.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.common.utils;
using iih.ci.ord.dto.d;
using iih.ci.ord.ems.d;
using iih.ci.ord.medicaresharing;
using iih.ci.ord.opemergency.orddi;
using xap.rui.engine;

namespace iih.ci.ord.opemergency.ems
{
    /// <summary>
    /// <para>描    述 : 空医疗单列表                      </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.ems     </para>    
    /// <para>类 名 称 : EmptyEmsViewGrid                </para> 
    /// <para>版 本 号 : v1.0.0.0                        </para> 
    /// <para>作    者 : qzwang                          </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05              </para>
    /// <para>修 改 人 :                                 </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05              </para> 
    /// <para>说    明 : 作为引子用                                </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EmptyEmsViewGrid : EmsDrugSrvGridView
    {
        public EmptyEmsViewGrid(IEventDelegate o)
            : base(o)
        {
            allowEdit = false;
            this.srvItemViewType = EmsViewType.EmptyEmsViewType;
            
        }
        protected override void InitializeBizView()
        {
            base.InitializeBizView();
            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_EmptyEmsViewGrid);
        }

        protected override void OnXapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.OnXapFormControl_FormCreated(sender, e);
            this.GetGridControl().DataTable.GotFocus += new EventHandler(DataTable_GotFocus);
           
            // 禁用必填项
            this.AllowCheckNullWith(this.GetGridControl(), false);
        }

        protected override void OnXapFormControl_RefResult(object sender, RefResultEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_srv"))
            {
                var orDrug = e.DataObject as EmsOrDrug;
                if (string.IsNullOrEmpty(orDrug.Id_srv))
                {
                    this.SetStatusMsg("提示：参照操作过快，不能正常查询数据");
                    return;
                }
                    
                
                Ent4BannerDTO patDo = this.GetViewModel().GetEnt4BannerDTO();
                List<MedicalSharingDTO> infoMedicalSharing = null;
                //医保共享验证
                CiEnContextDTO ciEnContextDto = CiEnContextUtil.GetCiEnContext(patDo, EmsAppModeEnum.SVEMSAPPMODE, this.Context);//诊断是否保外的
                if (patDo != null && ciEnContextDto != null && ciEnContextDto.Eu_hpbeyond == HpBeyondEnum.HPDIAG && !EnDictCodeConst.SD_ENTP_EMERGENCY.Equals(patDo.Code_entp) && patDo.No_hp != null && patDo.Sd_hptp != null && patDo.Sd_hptp.StartsWith("1"))
                {
                    MedicalSharingDTO[] arrMedicalSharingDtos = new MedicalSharingDTO[1];
                    MedicalSharingDTO medicalSharing = new MedicalSharingDTO();
                    medicalSharing.Code = orDrug.Code_hpsrvorca;
                    medicalSharing.Name_srv = orDrug.Name_srv;
                    medicalSharing.Sd_srvtp = orDrug.Sd_srvtp;
                    arrMedicalSharingDtos[0] = medicalSharing;
                    infoMedicalSharing = MedicalSharingDateRule.MedicalSharingValidate(this.Context, arrMedicalSharingDtos, patDo);
                }
                if (infoMedicalSharing != null && infoMedicalSharing.Count > 0)
                {   //弹出医保共享信息
                    using (MedicalSharingInfoForm from = new MedicalSharingInfoForm(infoMedicalSharing))
                    {
                        if (from.ShowDialog() == DialogResult.OK)
                        {
                            orDrug.Fg_selfpay = FBoolean.True;
                            AsynchronousHandle(orDrug);
                        }
                        else
                        {
                            GetLogicEx().clearEmsOrDrugPropety(orDrug);
                            LoadData();
                           
                        }
                    }
                }
                else
                {
                    AsynchronousHandle(orDrug);
                }
            }
        }

        protected override void AsynchronousHandle(object param)
        {
            var drug = param as EmsOrDrug;
            var medSrvDO = new MedSrvDO()
            {
                Id_srv = drug.Id_srv,
                Sd_srvtp = drug.Sd_srvtp,
                Name = drug.Name_srv
            };
            var id_mm = drug.Id_mm;
            this.GetXapFormControl().SetFormModified(true);

            // 清空数据
            XapDataList<EmsOrDrug> defaultModel = this.GetViewModel().GetTableDataSource() as XapDataList<EmsOrDrug>;
            this.GetLogicEx().Clear(defaultModel[0]);

            // 如果新建医疗单成功则返回
            this.CreateNewEms(medSrvDO, id_mm, drug.Fg_selfpay);
          
        }

        private void XapRefManager_RefDataReady(object sender, RefDataReadyEventArgs e)
        {
            foreach( var refData in e.DataSource)
            {
                //e.SetHighlight(refData, xap.rui.control.refcontrol.RefHighlightLevel.Danger);
            }
        }

        protected override void OnXapFormControl_DataChanged(object sender, DataChangedEventArgs e)
        { }

        protected override void OnXapFormControl_DataVisible(object sender, DataVisibleEventArgs e)
        { }

        protected override void OnXapFormControl_DataDisplay(object sender, XDataDisplayEventArgs e)
        {}

        protected override void AttachQuanCurEditor()
        {}
        void DataTable_GotFocus(object sender, EventArgs e)
        {
            if (GetViewModel().GetEnt4BannerDTO() != null && GetViewModel().GetEnt4BannerDTO().Sd_status != EnDictCodeConst.SD_ENSTATUS_OP_FINISH&&!BaseEmsView.EmptyPatDIInfo)
            {
                AssToolEx.SentMessage(this.GetEventDelegate() as XapBaseControl, EventCodeType.EVENT_ASSI_SHOW_ORDERTEMPLATE_OR_EDIT);
            }
        }
        protected override void OnXapFormControl_ModelFilled(object sender, EventArgs e)
        {
            if (null != GetGridControl()) {

                // 重设表格表头外观信息（对齐方式、默认显示）
                ResetColumnsInfo(GetGridControl());

                // 清空数据
                XapDataList<EmsOrDrug> defaultModel = this.GetViewModel().GetTableDataSource() as XapDataList<EmsOrDrug>;
                this.GetLogicEx().Clear(defaultModel[0]);
                GetGridControl().DataTable.DataSource = defaultModel;

                this.SetDataPolicy(true);
                if (GetViewModel().GetEnt4BannerDTO() == null || BaseEmsView.EmptyPatDIInfo ? false : true) {
                    AssToolEx.SentMessage(this.GetEventDelegate() as XapBaseControl, EventCodeType.EVENT_ASSI_SHOW_ORDERTEMPLATE_OR_EDIT);
                   GetGridControl().ShowEditor(defaultModel[0], "Name_srv"); // -- PO 要求 诊断获取焦点
                }

            }

        }


        protected override void OnXapGridFormControl_MouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            
        }

        protected override void OnXapFormControl_AllowEditing(object sender, AllowEditingEventArgs e)
        {
            if (e.PropName.Equals("Name_srv"))
            {
                var grid = sender as XapFormGridControl;
                // 未选择患者提示信息
                //if (BizAssMessageBoxUtil.ShowPatIsNullMsg(GetViewModel().GetEnt4BannerDTO(), ""))
                //{
                //    e.Cancel = true;
                //    return;
                //}

                if (GetViewModel().GetEnt4BannerDTO() == null || GetViewModel().GetEnt4BannerDTO().Sd_status == EnDictCodeConst.SD_ENSTATUS_OP_FINISH)
                {
                    e.Cancel = true;
                }
                else
                {
                    bool rst = true;
                    if (grid.SelectedRowsCount > 0)
                    {
                        //点击处置开立列表，判断诊断是否为空，诊断是否更改
                        if (RelativeUIParam.RELATIVERATIO > RelativeUIParam.TEMPLETECHANGEDRATIO)
                        {
                            var DiListView = this.Context.Config.GetInstance("DiListView") as DiListView;
                            if (null != DiListView)
                            {
                                rst = DiListView.CheckDiEditable(true);
                            }
                        }
                        else
                        {
                            var DiBannerView = this.Context.Config.GetInstance("DiBannerView") as DiBannerView;
                            if (null != DiBannerView)
                            {
                                rst = DiBannerView.CheckDiEditable();
                            }
                        }
                    }

                    if (rst)
                    {
                        this.SetDataPolicy(true);
                        e.Cancel = false;
                    }
                    else
                    {
                        e.Cancel = true;
                        if (RelativeUIParam.RELATIVERATIO <= RelativeUIParam.TEMPLETECHANGEDRATIO)
                            this.SentNotify(EventCodeType.NM_ORDI_EDIT);
                    }
                }
            }
            else
            {
                e.Cancel = true;
            }

        }

        private void AllowCheckNullWith(XapFormGridControl gv, bool allow = true)
        {
            if (null == gv) {
                return;
            }

            foreach (XDataColumn column in gv.DataTable.Columns) {
                column.AllowCheckNull = allow;
            }

        }
    }
}
