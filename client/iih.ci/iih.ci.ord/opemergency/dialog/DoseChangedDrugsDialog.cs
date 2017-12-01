using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.control.basecontrol;
using xap.rui.control.forms.view;
using xap.cli.sdk.render;
using xap.rui.control.forms.control;
using xap.rui.control.formcontrol.model;
using xap.rui.appfw;
using iih.ci.ord.ciordems.d;

namespace iih.ci.ord.opemergency.dialog
{
    public partial class DoseChangedDrugsDialog : XBaseDialog
    {
        #region 构造函数
        public DoseChangedDrugsDialog(XapDataList<EmsOrDrug> emsOrDrugList)
        {
            InitializeComponent();
            this.itemlist = emsOrDrugList;
            this.constructControls();
            // 增加加载事件
            this.Load += new EventHandler(DoseChangedDrugsDialog_Load);
            
        }


        #endregion

        #region 属性
        /// <summary>
        /// 表格控件
        /// </summary>
      
       /* public XapFormControl xapFormControl;*/
        public XapDataList<EmsOrDrug> itemlist;
        #endregion

        #region 事件代理
        
        public event MouseEventHandler SaveEvent;
        public event MouseEventHandler CancelEvent;
        #endregion

        #region 私有变量
        /// <summary>
        /// 表单容器对象
        /// </summary>
        private XapFormControl xapFormControl;

        /// <summary>
        /// 保存按钮
        /// </summary>
        private XButton saveButton;

        /// <summary>
        /// 取消按钮
        /// </summary>
        private XButton cancelButton;
        #endregion

        #region 内部事件
        void DoseChangedDrugsDialog_Load(object sender, EventArgs e)
        {
            OnFillData();
        }

        protected override void OnFillData()
        {
            // 20160611034436205DLJ
            FormFile file = new FormFile
            {
                FormId = "20160611034436205DLJ",
                FormStyle = FormStyle.Card,
                ViewModel = itemlist
            };
            xapFormControl.ViewFile = file;
        }
        #endregion

        #region 私有方法
        
        /// <summary>
        /// 构造窗体中的 UI  对象
        /// </summary>
        private void constructControls()
        {
            // 创建表单容器
            xapFormControl = new XapFormControl
            {
                Location = Panel.Location,
                Width = Panel.Width,
                Height = Panel.Height
            };
            // 设置可编辑状态
            xapFormControl.SetEditPolicy(true);
            // 将表单容器添加到对话框布局容器
            Panel = xapFormControl;


            // 新建保存按钮以及取消按钮
            saveButton = new XButton { Size = new Size(75, 25), Text = "确定" };
            cancelButton = new XButton { Size = new Size(75, 25), Text = "取消" };

            // 注册事件
            saveButton.MouseClick += new MouseEventHandler(saveButton_MouseClick);
            cancelButton.MouseClick += new MouseEventHandler(cancelButton_MouseClick);
            Text = @"变动用药";

            // 将保存按钮以及取消按钮添加到窗体中
            AddRender_Btn(saveButton, cancelButton);

        }

        void cancelButton_MouseClick(object sender, MouseEventArgs e)
        {
            if (this.CancelEvent != null)
            {
                this.CancelEvent(this, e);
            }
        }

        void saveButton_MouseClick(object sender, MouseEventArgs e)
        {
            if (SaveEvent != null)
            {
                this.SaveEvent(this, e);
            }
        }
        #endregion
    }
}
