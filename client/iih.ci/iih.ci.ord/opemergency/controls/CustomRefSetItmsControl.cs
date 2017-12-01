using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.cli.sdk.render.Items;
using iih.ci.ord.opemergency.view;
using xap.rui.appfw;
using iih.ci.ord.ciordems.d;
using System.Windows.Forms;
using xap.rui.control.forms.control;
using xap.cli.sdk.controls.DataView.Repository;
using xap.cli.sdk.controls.DataView;
using xap.rui.control.basecontrol;
using iih.ci.ord.opemergency.dialog;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.ems.dp;

namespace iih.ci.ord.opemergency.controls
{
    class CustomRefSetItmsControl: XSearchBox
    {
        private BaseEmsView emsView;

        private XRepositoryRefEdit refEdit;

        private XCellRender FocusedCell
        {
            get { return emsView.GetGridControl().FocusedCell; }
        }

        private string FieldName
        {
            get { return FocusedCell.FieldName; }
        }
        private XBaseDialog baseDiagLog;
        /// <summary>
        /// 父对象
        /// </summary>
     
       // private XapDataList<EmsObsLap> dataSource;
        /// <summary>
        /// 套明细是否允许编辑
        /// </summary>
        private bool isAllowEdit;
    
        /// <summary>
        /// 
        /// </summary>
        /// <param name="o">父对象</param>
        /// <param name="emsObsLaps">表格数据源</param>
        /// <param name="isAllowEdit">是否允许编辑</param>
        /// <param name="isLisDiag">区别是检验还是检查</param>
        public CustomRefSetItmsControl(BaseEmsView o, XRepositoryRefEdit refEdit, bool isAllowEdit)
        {
            this.emsView = o;
            this.refEdit = refEdit;
            this.isAllowEdit = isAllowEdit;
            this.ValueTextChanged += MySearchBox_ValueTextChanged;
            this.KeyPress += new KeyPressEventHandler(CustomRefControl_KeyPress);
        }
        void CustomRefControl_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == (char)Keys.Space) {
                showDialog();
            }
        }

        private void MySearchBox_ValueTextChanged(object sender, EventArgs e)
        {
            var dataSource = (emsView.GetViewModel() is EmsLisViewModel) ? ((emsView.GetViewModel() as EmsLisViewModel).GetFormDataSource() as EmsObsItemDO).EmsOrObsList :
                ((emsView.GetViewModel() as EmsRisViewModel).GetFormDataSource() as EmsObsItemDO).EmsOrObsList;
            if (FocusedCell == null || dataSource == null || !refEdit.Visible)
                return;
            FocusedCell.SetValue(ConstructDetialInfo(dataSource));
        }

        protected override void OnButtonClick(object sender, MouseEventArgs e)
        {
            showDialog();

        }

        /// <summary>
        /// 拼接服务套内容
        /// </summary>
        /// <param name="itemList"></param>
        /// <returns></returns>
        public static string ConstructDetialInfo(XapDataList<EmsObsLap> obsLabs)
        {
            string info = "";

            foreach(EmsObsLap obs in obsLabs){
                if (obs.Fg_chk != null && (bool)obs.Fg_chk && !String.IsNullOrEmpty(obs.Name_body) && obs.Sd_srvtp.StartsWith("02")) {
                    info += obs.Name_body + ",";
                }
                else if(obs.Fg_chk != null && (bool)obs.Fg_chk)
                {
                    info += obs.Name_srv + ",";
                }
            }
            if (!string.IsNullOrEmpty(info))
            {
                return info.Remove(info.Length-1);
            }
            return "";
        }
        private void showDialog() {
            if (FocusedCell == null)
                return;
            var dataSource = (emsView.GetViewModel() is EmsLisViewModel) ? ((emsView.GetViewModel() as EmsLisViewModel).GetFormDataSource() as EmsObsItemDO).EmsOrObsList :
                ((emsView.GetViewModel() as EmsRisViewModel).GetFormDataSource() as EmsObsItemDO).EmsOrObsList;
            var setRdaio = (emsView.GetViewModel() is EmsLisViewModel) ? (emsView.GetViewModel() as EmsLisViewModel).checkRadio() : (emsView.GetViewModel() as EmsRisViewModel).checkRadio();
            if ((emsView.GetViewModel() is EmsLisViewModel))
            {
                baseDiagLog = new AplabsSetItemDialog(emsView, dataSource, isAllowEdit,setRdaio);
            }
            else
            {
                baseDiagLog = new ApobsSetItemDialog(emsView, dataSource, isAllowEdit, setRdaio);
            }
            baseDiagLog.Size = new System.Drawing.Size(400, 390);
            baseDiagLog.ShowDialog();
            // 保存
            if (baseDiagLog.DialogResult == DialogResult.OK)
            {
                FocusedCell.SetValue(ConstructDetialInfo(dataSource));
                //gridControl.DataTableShared.CloseEditor(null);
                emsView.GetGridControl().CloseEditor();
            }
        }
    }
}
