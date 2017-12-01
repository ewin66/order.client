
using xap.rui.control.basecontrol;
using iih.ci.ord.opemergency.assi.i;
using xap.rui.engine;
using System.Windows.Forms;
using iih.ci.ord.opemergency.assi.ortmplconcise.view;
using System;
using xap.rui.engine.xlayouts;
using xap.cli.sdk.form;
using iih.ci.ord.opemergency.assi.asscommon.view;
using iih.ci.ord.ems.d;

namespace iih.ci.ord.opemergency.assi.ortmplconcise
{
    /// <summary>
    /// <para>描    述 :  简洁医嘱模板窗体		</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.ortmplconcise    </para>    
    /// <para>类 名 称 :  OrTmplConciseFrame					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Young         				</para> 
    /// <para>修 改 人 :  Young         				</para> 
    /// <para>创建时间 :  2017/10/20 19:03:07             </para>
    /// <para>更新时间 :  2017/10/20 19:03:07             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class OrTmplConciseFrame : XapBaseControl, IViewCommond
    {
        private XForm assiViewFrame;

        private XUserControl xUserControl;

        public OrTmplConciseFrame()
        {
            this.xUserControl = new XUserControl();

            this.Load += new System.EventHandler(OrTmplConciseFrame_Load);
        }

        private void OrTmplConciseFrame_Load(object sender, System.EventArgs e)
        {
            this.xUserControl.Init(Application.StartupPath + "\\modules\\iihci\\ui\\opordertemplate\\Helper_concise.xml");

            this.assiViewFrame = this.Context["assiViewFrame"] as XForm;
            XapBaseControl xapBaseControl = this.Context["sender"] as XapBaseControl;
            CiEnContextDTO ciEnContext = this.Context["ciEnContext"] as CiEnContextDTO;

            var comTreeView = this.xUserControl.GetConfig().GetInstance("OrTmplTreeViewCom") as OrTmplTreeViewCom;
            if (comTreeView != null)
            {
                comTreeView.xapBaseControl = xapBaseControl;
                comTreeView.ciEnContext = ciEnContext;
            }

            var lisTreeView = this.xUserControl.GetConfig().GetInstance("OrTmplTreeViewLis") as OrTmplTreeViewLis;
            if (lisTreeView != null)
            {
                lisTreeView.xapBaseControl = xapBaseControl;
                lisTreeView.ciEnContext = ciEnContext;
            }

            var risTreeView = this.xUserControl.GetConfig().GetInstance("OrTmplTreeViewRis") as OrTmplTreeViewRis;
            if (risTreeView != null)
            {
                risTreeView.xapBaseControl = xapBaseControl;
                risTreeView.ciEnContext = ciEnContext;
            }

            var treatTreeView = this.xUserControl.GetConfig().GetInstance("OrTmplTreeViewTreat") as OrTmplTreeViewTreat;
            if (treatTreeView != null)
            {
                treatTreeView.xapBaseControl = xapBaseControl;
                treatTreeView.ciEnContext = ciEnContext;
            }

            var helpButon = xUserControl.GetConfig().GetInstance("OrderHelpButten") as OrderHelpButten;
            if (helpButon != null)
            {
                helpButon.parentFrame = this;
            }

            this.AddRender(this.xUserControl);
        }

        private void layoutTabl_SelectedIndexChanged(object sender, EventArgs e)
        {
            LayoutXTabPanelPage selectPage = sender as LayoutXTabPanelPage;
            String tabId = selectPage.Id;
            switch (tabId)
            {
                case "OrTmplTreeViewRis":
                case "OrTmplTreeViewLis":
                case "OrTmplTreeViewTreat":
                case "OrTmplTreeViewDrugs":
                case "OrTmplTreeViewCom":
                    (selectPage.PageControl as OrTmplTreeView).loadView();
                    break;
            }
        }

        public void saveData()
        {
            LayoutXTabPanelControl layoutTabl = xUserControl.GetConfig().GetInstance("tablayout1") as LayoutXTabPanelControl;
            (layoutTabl.SelectedPage.PageControl as IViewCommond).saveData();
        }
        public void close()
        {
            assiViewFrame.Close();
        }
        public object getSaveData()
        {
            return null;
        }
        public void switchToComplex()
        {
            (assiViewFrame as AssiViewFrame).switchToComplex();
        }
    }
}
