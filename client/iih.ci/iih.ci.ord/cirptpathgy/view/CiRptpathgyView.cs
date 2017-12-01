using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.cirptpathgy.d;
using xap.rui.control.basecontrol;
using iih.ci.ord.cirptpathgy.viewmodel;
using xap.rui.control.forms.model;
using xap.rui.control.engine.attributes;
using xap.rui.control.extentions;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.control.refcontrol.events;
using xap.rui.engine;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.cirptpathgy.view
{
    public partial class CiRptpathgyView : XapCardControl
    {
        #region 变量定义区域
        private CiRptpathgyViewModel model;
        #endregion

        #region 构造函数区域

        public CiRptpathgyView()
        {
            InitializeComponent();
            this.Load += new EventHandler(CiCheckCardView_Load);
            this.xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl_DataChanged);
            this.xapFormControl1.RefResult += this.OnRefResult;
        }    
        #endregion

        #region 命令定义区域
        /// <summary>
        /// 保存动作
        /// </summary>
        [XapCommand(Name = "Save")]
        public void OnSave()
        {
            if (this.xapFormControl1.HasErrors)
            {
                return;
            }
            this.model.Save();
            this.xapFormControl1.SaveForm();
            this.OnFillData();
            this.SetStatusMsg("保存成功！");
        }

        #endregion
         
        #region 父类继承区域
        /// <summary>
        /// 获取控件相关的数据
        /// </summary>
        protected override void OnLoadData()
        {

            this.model = new CiRptpathgyViewModel(this.Context);
        }
        
        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            if (this.model == null)
                return;

            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_CiRptpathgyView;// "20160808011734443UM8";
            file.FormStyle = FormStyle.Card;
            file.ViewModel = this.model.ciDO;
            this.xapFormControl1.ViewFile = file;
        }

        /// <summary>
        /// 按钮状态控制
        /// </summary>
        public override void OnStatus()
        {
            bool enabled = !this.xapFormControl1.HasErrors && this.xapFormControl1.IsModified;
            this.SetEnable("Save", enabled);
        }
        /// <summary>
        /// 参照控件数据选中
        /// </summary>
        protected override void OnRefResult(object sender, RefResultEventArgs e)
        {
            switch (e.BindingFieldName)
            {
                case "Applyformno":
                    CiRptPathgyDO ciDO = this.model.findByIdAF(e.DataObject as CiRptPathgyDO);
                    if (ciDO == null)
                    {
                        ciDO = new CiRptPathgyDO();
                        ciDO.No_applyform = (e.DataObject as CiRptPathgyDO).No_applyform;
                    }
                    ciDO.Applyformno = (e.DataObject as CiRptPathgyDO).Applyformno;
                    ciDO.Dt_rptpathgy = this.NowTime();
                    ciDO.Id_emp_rpt = this.Context.PsnInfo.Id_psndoc;
                    ciDO.Rpt_name = this.Context.PsnInfo.Name;
                    this.model.ciDO.Replace(ciDO);
                    this.OnFillData();
                    this.SetEditable(true);
                    break;
            }
        }

       
        #endregion

        #region 内部事件区域
        public void xapFormControl_DataChanged(object sender, DataChangedEventArgs e)
        {
            switch (e.PropName)
            {
                case "Applyformno":
                    CiRptPathgyDO ciDO = e.Data as CiRptPathgyDO;
                    if (ciDO.Applyformno == null)
                    {
                        CiRptPathgyDO ciRptDO = new CiRptPathgyDO();
                        ciRptDO.Dt_rptpathgy = this.NowTime();
                        ciRptDO.Id_emp_rpt = this.Context.PsnInfo.Id_psndoc;
                        ciRptDO.Rpt_name = this.Context.PsnInfo.Name;
                        this.model.ciDO.Replace(ciRptDO);
                        this.LoadData();
                        this.SetEditable(true);
                    }  
                  break;
            }
        } 
        /// <summary>
        /// 加载事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void CiCheckCardView_Load(object sender, EventArgs e)
        {
            base.OnInit();
            this.SetEditable(true);
        }
        #endregion

        #region 辅助处理区域
        private void SetEditable(bool editable)
        {
            DataPolicy dpMain = new DataPolicy()
            {
                ClassName = typeof(CiRptPathgy).ToString(),
                InlineEdit = true,
                FullEdit = editable,
                AllowEdit = editable
            };
            this.xapFormControl1.SetEditPolicy(editable, new DataPolicy[1] { dpMain });
        }
        #endregion

        #region 状态处理区域
        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case UIEvent.SAVE:
                    this.OnSave();
                    break;
            }
        }
        #endregion
    }
}
