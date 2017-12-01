
using System;
using xap.rui.control.basecontrol;
using xap.cli.sdk.render;
using iih.ci.ord.opemergency.assi.entdi.view;
using System.Collections.Generic;
using xap.rui.engine;
using iih.bd.srv.diagdef.d;
using System.Windows.Forms;
using iih.ci.ord.opemergency.assi.entdi.viewmodel;
using xap.rui.control.extentions;

namespace iih.ci.ord.opemergency.assi.entdi
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.entdi    </para>    
    /// <para>类 名 称 :  EntDiAssiView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/4/12 20:29:51             </para>
    /// <para>更新时间 :  2017/4/12 20:29:51             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public partial class EntDiAssiContainer : XapBaseControl
    {
        public delegate void DelegateHelper(object[] dos);
        public DelegateHelper delegateHelper;

        private XUserControl xUserControl;

        private XButton btnOK;
        private XButton btnCancel;

        private List<EntDiAssiView> diAssiViews = new List<EntDiAssiView>();
        private BaseContext context;

        public EntDiAssiContainer(BaseContext context)
        {
            this.context = context;
            this.Load += EntDiAssiContainer_Load;
            InitializeComponent();
        }

        private void EntDiAssiContainer_Load(object sender, System.EventArgs e)
        {
            this.xUserControl = new XUserControl();
            this.xUserControl.Init(Application.StartupPath + "\\modules\\iihci\\ui\\optrdocstation\\assi\\entdi\\assi_entdi_config.xml");
            this.xUserControl.Dock = DockStyle.Top;
            this.xUserControl.Height = 290;
            this.xUserControl.LoadData();

            var diDeptView = this.xUserControl.GetConfig().GetInstance("EntDiDeptAssiView") as EntDiDeptAssiView;
            if (diDeptView != null)
            {
                diDeptView.viewModel = new EntDiDeptAssiViewModel(this.context.Group.Id_grp, this.context.Org.Id_org, this.context.Dept.Id_dep);
                diDeptView.delegateMouseClick += getDiagDefDO;
            }
            diAssiViews.Add(diDeptView);

            var diChronView = this.xUserControl.GetConfig().GetInstance("EntDiChronAssiView") as EntDiChronAssiView;
            if (diChronView != null)
            {
                diChronView.viewModel = new EntDiChronAssiViewModel(this.context.Group.Id_grp, this.context.Org.Id_org);
                diChronView.delegateMouseClick += getDiagDefDO;
            }
            diAssiViews.Add(diChronView);

            var diSpeciView = this.xUserControl.GetConfig().GetInstance("EntDiSpeciAssiView") as EntDiSpeciAssiView;
            if (diSpeciView != null)
            {
                diSpeciView.viewModel = new EntDiSpeciAssiViewModel(this.context.Group.Id_grp, this.context.Org.Id_org);
                diSpeciView.delegateMouseClick += getDiagDefDO;
            }
            diAssiViews.Add(diSpeciView);

            var diInfectView = this.xUserControl.GetConfig().GetInstance("EntDiInfectAssiView") as EntDiInfectAssiView;
            if (diInfectView != null)
            {
                diInfectView.viewModel = new EntDiInfectAssiViewModel(this.context.Group.Id_grp, this.context.Org.Id_org);
                diInfectView.delegateMouseClick += getDiagDefDO;
            }
            diAssiViews.Add(diInfectView);

            this.btnOK = new XButton();
            this.btnOK.Size = new System.Drawing.Size(80, 30);
            this.btnOK.Location = new System.Drawing.Point(760 - this.btnOK.Size.Width * 2 - 50, 300);
            this.btnOK.ForeColor = System.Drawing.Color.White;
            this.btnOK.Text = "批量录入";
            this.btnOK.MouseClick += new MouseEventHandler(btnOK_MouseClick);

            this.btnCancel = new XButton();
            this.btnCancel.Size = new System.Drawing.Size(80, 30);
            this.btnCancel.Location = new System.Drawing.Point(this.btnOK.Location.X + this.btnOK.Size.Width + 25, this.btnOK.Location.Y);
            this.btnCancel.ForeColor = System.Drawing.Color.White;
            this.btnCancel.Text = "取消勾选";
            this.btnCancel.MouseClick += new MouseEventHandler(btnCancel_MouseClick);

            this.xapFormControl.AddRender(this.xUserControl);
            this.xapFormControl.AddRender(this.btnOK);
            this.xapFormControl.AddRender(this.btnCancel);
        }

        private void btnOK_MouseClick(object sender, MouseEventArgs e)
        {
            List<DiagDefDO> lst = new List<DiagDefDO>();
            diAssiViews.ForEach(assiView =>
            {
                DiagDefDO[] dos = assiView.GetDiagDefDOsSelected();
                if (dos != null)
                    lst.AddRange(dos);
            });

            if (0 == lst.Count)
            {
                this.ShowInfo("请勾选诊断！");
                return;
            }

            //去除重复的诊断
            List<string> lstIds = new List<string>();
            List<int> lstIdx = new List<int>();
            for (int i = 0; i < lst.Count; i++)
            {
                if (lstIds.Contains(lst[i].Id_didef))
                    lstIdx.Add(i);
                else
                    lstIds.Add(lst[i].Id_didef);
            }
            lstIdx.ForEach(idx => { lst.RemoveAt(idx); });

            getDiagDefDO(lst.ToArray());

            diAssiViews.ForEach(assiView =>
            {
                assiView.CancelSelectedRows();
            });
        }

        private void getDiagDefDO(object[] dos)
        {
            delegateHelper(dos);
        }

        private void btnCancel_MouseClick(object sender, MouseEventArgs e)
        {
            diAssiViews.ForEach(assiView =>
            {
                assiView.CancelSelectedRows();
            });
        }
    }
}
