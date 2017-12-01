using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.control.basecontrol;
using iih.ci.ord.ciexamine.viewmodel;
using xap.rui.control.engine.attributes;
using xap.rui.control.refcontrol.events;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.control.forms.model;
using xap.rui.engine;
using xap.rui.control.extentions;
using iih.ci.ord.cirptlab.d;
using xap.cli.sdk.controls.DataView.Repository;

using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.models;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciexamine.view
{
    public partial class CiExamCardView : XapCardControl
    {
        #region 变量定义区域
        private CiExamCardViewModel model;
        #endregion

        #region 构造函数区域

        public CiExamCardView()
        {
            InitializeComponent();
            this.Load += new EventHandler(CiCheckCardView_Load);
            this.xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl_DataChanged);
            //this.xapFormControl1.AfterLostFocused += new EventHandler<DataLostFocusedEventArgs>(xapFormControl1_AfterLostFocused);
            this.xapFormControl1.CustomEditor += new EventHandler<CustomEditorEventArgs>(xapFormControl1_CustomEditor);
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
            this.model = new CiExamCardViewModel(this.Context);

        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            if (this.model == null)
                return;

            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_CiExamCardView;// "20151217074446084WHA";
            file.FormStyle = FormStyle.Card;
            file.ViewModel = this.model.XapAggDO;
            this.xapFormControl1.ViewFile = file;
        }

        /// <summary>
        /// 按钮状态控制
        /// </summary>
        public override void OnStatus()
        {
            bool enabled = !this.xapFormControl1.HasErrors &&this.xapFormControl1.IsModified;
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
                    this.model.DataChanged(e.DataObject as CiRptLabDO, this.Context);
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
                    CiRptLabDO CiDo = e.Data as CiRptLabDO;

                    if (CiDo.Applyformno == null)
                    {
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

        public void xapFormControl1_CustomEditor(object sender, CustomEditorEventArgs e)
        {
            switch (e.PropName)
            {

                case "Val_rstrptlab":
                    CiRptLabItmDO ciDo = this.xapFormControl1.GetFocused<CiRptLabItmDO>("List");
                    // 如果 选中数据为 null 则 return  邵远 20160708
                    if (ciDo == null)
                    {
                        return;
                    }
                    switch (ciDo.Sd_restrptlabtp)
                    {
                        case "0":
                            //数值
                            XRepositoryItemNumEdit be = new XRepositoryItemNumEdit(this.xapFormControl1.GetGridView("List"));
                            //be.OriginalPrecision = 2;
                            e.Editor = be;
                            break;
                        case"1":
                            //字符串
                            e.Editor = new XRepositoryItemTextEdit(this.xapFormControl1.GetGridView("List"));                  
                            break;
                        case "2":
                            //下拉
                            string[] strlist = ciDo.Val_range.Split(',');
                            string str = "STRING:[" + strlist[0] + ":" + strlist[0];
                            for (int i = 1; i < strlist.Length;i++ )
                            {
                                str = str+","+strlist[i]+":"+strlist[i];
                            }
                            str = str + "]";
                            DropListConfig list = new DropListConfig(str);
                            XDropList ctrl = new XDropList();
                            ctrl.NullText = "";
                            ctrl.DataSource = list;
                            ctrl.DisplayMember = "Name";
                            ctrl.ValueMember = "Code";
                            e.Editor = ctrl;
                            break;
                    }
                   
                    break;
            }
        } 
        #endregion

        #region 辅助处理区域
        private void SetEditable(bool editable)
        {
            DataPolicy dpMain = new DataPolicy()
            {
                ClassName = typeof(CiRptLabDO).ToString(),
                InlineEdit = true,
                FullEdit = editable,
                AllowEdit = editable
            };
            DataPolicy dp = new DataPolicy()
            {
                ClassName = typeof(CiRptLabItmDO).ToString(),
                InlineEdit = true,
                FullEdit = editable,
                AllowEdit = editable
            };
            this.xapFormControl1.SetEditPolicy(editable, new DataPolicy[] { dpMain,dp});
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
