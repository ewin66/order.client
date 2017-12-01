
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using xap.rui.control.basecontrol;
using xap.rui.appfw;
using iih.ci.ord.ems.d;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.mw.core.data;
using xap.rui.control.forms.model;
using xap.rui.control.forms.control;
using System.Drawing;

namespace iih.ci.ord.ciorder.orreport.scrollpanel.view
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.ciorder.donot    </para>    
    /// <para>类 名 称 :  HealthCheckRepoat					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2016/10/27 14:55:34             </para>
    /// <para>更新时间 :  2016/10/27 14:55:34             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class BaseCheckRepoatView : XapListControl
    {
        #region 变量区
        protected object datalist;
        protected string title;
        protected int key;
        public string[] id_ors;
        protected XapFormGridControl gridView;
        protected int viewWide = 725;
        private bool canEdit = true;
        #endregion
        public BaseCheckRepoatView() { }
        public BaseCheckRepoatView(object datalist,string[] id_ors,string title,int key)
        {
            this.datalist = datalist;
            this.title = title;
            this.key = key;
            this.id_ors = id_ors;
            InitializeComponent();

            //this.Size = new Size(viewWide, this.Size.Height);
            this.Load += new EventHandler(HealthCheckRepoat_Load);
        }

       protected void HealthCheckRepoat_Load(object sender, EventArgs e)
        {
            this.xapFromControl.FormCreated += new EventHandler(xapFromControl_FormCreated);
            this.xapFromControl.ModelFilled += new EventHandler(xapFromControl_ModelFilled);
            this.OnInit();
        }
        
        void xapFromControl_ModelFilled(object sender, EventArgs e)
        {
            
        }
        protected virtual void xapFromControl_FormCreated(object sender, EventArgs e)
        {
            //setEditPolicy();
        }
        public virtual void save() { }
        public virtual void validate(BaseCheckRepoatView view,List<string> errorList)
        { 
            
        }
        public int getKey() {
            return this.key;
        }
        private void setEditPolicy(bool p =true) {
            DataPolicy policy = new DataPolicy();
            // 允许新建
            policy.AllowNew = false;
            // 允许编辑
            policy.AllowEdit = p;
            // 允许删除
            policy.AllowRemove = false;
            // 允许保存
            policy.AllowSave = false;
            // 
            policy.FullEdit = p;
            // 多选
            policy.MultiSelect = true;
            policy.InlineEdit = true;
            // 自动增加新行
            policy.AutoNewRow = false;
            xapFromControl.SetEditPolicy(p, new DataPolicy[1] { policy });
        }
        public XapFormGridControl getGridView() {
            return this.gridView;
        }

        public virtual void setEditPlogy(bool p)
        {
            setEditPolicy(p);
        }
        public void setCanEdit(bool p) {
            this.canEdit = p;
        }
        public bool getCanEdit() {
            return this.canEdit;
        }
    }
}
