using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.control.basecontrol;
using xap.rui.control.forms.model;
using xap.rui.control.engine.attributes;
using xap.rui.control.refcontrol.events;
using iih.ci.ord.cicheck.viewmodel;
using iih.ci.ord.cirptlab.d;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.engine;
using xap.rui.control.extentions;
using iih.ci.ord.cirptobs.d;
using xap.rui.bizcontrol.BillFormTmplConst;


namespace iih.ci.ord.cicheck.view
{
    public partial class CiCheckCardView : XapCardControl
    {
        #region 变量定义区域
        private CiCheckCardViewModel model;
        #endregion

        #region 构造函数区域

        public CiCheckCardView()
        {
            InitializeComponent();
            this.Load += new EventHandler(CiCheckCardView_Load);
            this.xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl_DataChanged);
            //this.xapFormControl1.LostFocus += new EventHandler(xapFormControl1_LostFocus);
            //this.xapFormControl1.AfterLostFocused += new EventHandler<DataLostFocusedEventArgs>(xapFormControl1_AfterLostFocused);
            this.xapFormControl1.RefFilter += this.OnRefFilter;
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
            this.model = new CiCheckCardViewModel();
           
            model.ciRptObsDO = this.ViewFile.FormDo;
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            if (this.model == null)
                return;

            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_CiCheckCardView;// "20151217114706397QAI";
            file.FormStyle = FormStyle.Card;
            file.ViewModel = model.ciRptObsDO;
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
        protected override void OnRefFilter(object sender, RefActivatingEventArgs e)
        {
           
        }

        /// <summary>
        /// 参照控件数据选中
        /// </summary>
        protected override void OnRefResult(object sender, RefResultEventArgs e)
        {
            switch (e.BindingFieldName)
            {
                case "Applyformno":
                    CiRptObsDO ciRptObsDo=e.DataObject as CiRptObsDO;
                    model.findByIdAF(ciRptObsDo,this.Context);
                    this.OnFillData();
                    this.SetEditable(true);
                    break;
            }
        }

       
        #endregion

        #region 内部事件区域
        public void xapFormControl1_AfterLostFocused(object sender, DataChangedEventArgs e)
        {
            switch (e.PropName)
            {
                case "No_applyform":

                    //CiRptObsDO ciDO = this.model.findByIdAF(e.Data as CiRptObsDO);
                    //if (ciDO != null)
                    //{
                    //    //CiCheckCardFile file = new CiCheckCardFile { FormDo = ciDO };
                    //    //this.File = file;
                    //    ////this.OnFillData();
                    //    this.ciRptObsDO.Replace(ciDO);
                    //    this.SetEditable(true);
                    //}
                    //else
                    //{
                    //    //CiCheckCardFile file = new CiCheckCardFile { FormDo = new CiRptObsDO() };
                    //    //this.File = file;
                    //    //this.OnFillData();
                    //    this.ciRptObsDO.Replace(new CiRptObsDO());
                    //    this.SetEditable(true);
                    //}
                    this.model.findByIdAF((e.Data as CiRptObsDO),this.Context);
                 
                    this.SetEditable(true);
                    break;
            }
        }

        public void xapFormControl_DataChanged(object sender, DataChangedEventArgs e)
        {
            switch (e.PropName)
            {
                case "Applyformno":

                    CiRptObsDO ciDO = e.Data as CiRptObsDO;
                    if (ciDO.Applyformno == null)
                    {
                        CiRptObsDO ciRptDO = new CiRptObsDO();
                        ciRptDO.Dt_rptobs = this.NowTime();
                        ciRptDO.Id_emp = this.Context.PsnInfo.Id_psndoc;
                        ciRptDO.Rpt_name = this.Context.PsnInfo.Name;
                        model.ciRptObsDO.Replace(ciRptDO);
                        this.LoadData();
                        this.SetEditable(true);
                    }  
                  break;
            }
        } 
        private CiCheckCardFile ViewFile
        {
            get { return this.File as CiCheckCardFile; }
        }
        /// <summary>
        /// 加载事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void CiCheckCardView_Load(object sender, EventArgs e)
        {
            CiRptObsDO ciDO = new CiRptObsDO();
            ciDO.Dt_rptobs = this.NowTime();
            ciDO.Id_emp = this.Context.PsnInfo.Id_psndoc;
            ciDO.Rpt_name = this.Context.PsnInfo.Name;
            CiCheckCardFile file = new CiCheckCardFile { FormDo = ciDO };
            this.File = file;
            base.OnInit();
            this.SetEditable(true);
        }
        #endregion

        #region 辅助处理区域
        private void SetEditable(bool editable)
        {
            DataPolicy dpMain = new DataPolicy()
            {
                ClassName = typeof(CiRptObsDO).ToString(),
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
