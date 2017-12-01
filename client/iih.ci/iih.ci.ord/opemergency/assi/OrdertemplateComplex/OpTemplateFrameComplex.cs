using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.opemergency.assi.asscommon.dto;
using iih.ci.ord.opemergency.assi.asscommon.view;
using iih.ci.ord.opemergency.assi.assistantinit;
using iih.ci.ord.opemergency.assi.enthistory.view;
using iih.ci.ord.opemergency.assi.medsrvclass.view;
using iih.ci.ord.opemergency.assi.opmedicaltechnology.view;
using iih.ci.ord.opemergency.assi.OrderTemplate.view;
using iih.en.pv.dto.d;
using xap.cli.sdk.form;
using xap.cli.sdk.render;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.control.forms.view;
using xap.rui.engine;
using iih.ci.ord.ems.d;
using iih.ci.ord.opemergency.assi.OrdertemplatePithy.view;
using iih.ci.ord.opemergency.assi.OrdertemplatePithy.model;
using iih.ci.iih.ci.ord.i;
using xap.rui.engine.xlayouts;
using iih.bd.bc.udi;
using xap.mw.core.data;
using iih.ci.ord.opemergency.assi.OrdertemplateComplex.view;
using iih.ci.ord.opemergency.assi.i;
using iih.ci.ord.opemergency.ems.common;

namespace iih.ci.ord.opemergency.assi.OrdertemplateComplex
{
    public class OpTemplateFrameComplex : XapBaseControl, IViewCommond
    {
        XForm assiViewFrame;
        /// <summary>
        /// banner数据
        /// </summary>
        private Ent4BannerDTO BannerDTO;
        /// <summary>
        /// 当前环境
        /// </summary>
        private BaseContext BaseContext;
       /// <summary>
       /// 
       /// </summary>
        public OrderTemplatePithyTreeViewModel model;
       /// <summary>
       /// 缓存的所有的模板明细，用于加载树的
       /// </summary>
        public Dictionary<string,FArrayList2> modelItemMap;//模板明细
        /// <summary>
        /// 展示就诊历史组件的控件
        /// </summary>
        private XapFormControl xapFormControl;
        private XUserControl xUserControl;

        public OpTemplateFrameComplex()
        {
            xapFormControl = new XapFormControl();
            xapFormControl.Dock = DockStyle.Fill;
            this.Controls.Add(xapFormControl);
            this.Load += EntHistoryTabFrame_Load;

   
        }
        private void EntHistoryTabFrame_Load(object sender, EventArgs e)
        {
            this.model = new OrderTemplatePithyTreeViewModel();
            this.BannerDTO = this.Context["ent4BannerDTO"] as Ent4BannerDTO;
            this.BaseContext = this.Context["context"] as BaseContext;
            model.getTemplateClassIfication(BannerDTO);
            this.xapFormControl.AddRender(setOpOrderTemplateTreeViewOrderAndVisible());
        }
        private XUserControl setOpOrderTemplateTreeViewOrderAndVisible()
        {
            assiViewFrame = this.Context["assiViewFrame"] as XForm;
            AssiBtnDTO assiBtnDTO = this.Context["assiBtnDTO"] as AssiBtnDTO;
            CiEnContextDTO ciEnContext = this.Context["ciEnContext"] as CiEnContextDTO;
            XapBaseControl xapBaseControl = this.Context["sender"] as XapBaseControl;
            xUserControl = new XUserControl();
            xUserControl.Init(Application.StartupPath + "\\modules\\iihci\\ui\\opordertemplate\\Helper_complex.xml");
            OrderHelpButtenComplex helpButon = xUserControl.GetConfig().GetInstance("OrderHelpButten") as OrderHelpButtenComplex;
            helpButon.parentFrame = this;

            OpTemplateControlComplex sysTreeView = xUserControl.GetConfig().GetInstance("sys_OpOrderTemplateControlComplex") as OpTemplateControlComplex;
            OpTemplateControlComplex obsTreeView = xUserControl.GetConfig().GetInstance("obs_OpOrderTemplateControlComplex") as OpTemplateControlComplex;
            OpTemplateControlComplex westDrugTreeView = xUserControl.GetConfig().GetInstance("westdrug_OpOrderTemplateControlComplex") as OpTemplateControlComplex;
            OpTemplateControlComplex labTreeView = xUserControl.GetConfig().GetInstance("lab_OpOrderTemplateControlComplex") as OpTemplateControlComplex;
            OpTemplateControlComplex treateTreeView = xUserControl.GetConfig().GetInstance("treate_OpOrderTemplateControlComplex") as OpTemplateControlComplex;
            sysTreeView.parentFrame = this;
            sysTreeView.model = this.model;
            sysTreeView.BannerDTO = this.BannerDTO;
            sysTreeView.ciEnContext = ciEnContext;
            sysTreeView.xapBaseControl = xapBaseControl;
            sysTreeView.modeltype = BdSrvDictCodeConst.SD_ORTMPLTP_FHMBA;

            obsTreeView.BannerDTO = this.BannerDTO;
            obsTreeView.parentFrame = this;
            obsTreeView.model = this.model;
            obsTreeView.ciEnContext = ciEnContext;
            obsTreeView.xapBaseControl = xapBaseControl;
            obsTreeView.modeltype = BdSrvDictCodeConst.SD_ORTMPLTP_RIS;

            labTreeView.BannerDTO = this.BannerDTO;
            labTreeView.parentFrame = this;
            labTreeView.model = this.model;
            labTreeView.ciEnContext = ciEnContext;
            labTreeView.xapBaseControl = xapBaseControl;
            labTreeView.modeltype = BdSrvDictCodeConst.SD_ORTMPLTP_LIS;

            treateTreeView.BannerDTO = this.BannerDTO;
            treateTreeView.parentFrame = this;
            treateTreeView.model = this.model;
            treateTreeView.ciEnContext = ciEnContext;
            treateTreeView.xapBaseControl = xapBaseControl;
            treateTreeView.modeltype = BdSrvDictCodeConst.SD_ORTMPLTP_TREAT;

            westDrugTreeView.BannerDTO = this.BannerDTO;
            westDrugTreeView.parentFrame = this;
            westDrugTreeView.model = this.model;
            westDrugTreeView.ciEnContext = ciEnContext;
            westDrugTreeView.xapBaseControl = xapBaseControl;
            westDrugTreeView.modeltype = BdSrvDictCodeConst.SD_ORTMPLTP_CZXCY;

            xUserControl.Dock = DockStyle.Fill;
            string paramStr = (string)BaseEmsView.BaseEmsInfoContext[ICiOrdNSysParamConst.OrTmplTypeAndSeqSet4OPOrHelper];
            if (!string.IsNullOrWhiteSpace(paramStr))
            {
                LayoutXTabPanelControl layoutTabl = xUserControl.GetConfig().GetInstance("tablayout1") as LayoutXTabPanelControl;
                if (layoutTabl != null)
                {
                    layoutTabl.XTabPages[0].Visible = paramStr.Contains(BdSrvDictCodeConst.SD_ORTMPLTP_RIS);
                    layoutTabl.XTabPages[1].Visible = paramStr.Contains(BdSrvDictCodeConst.SD_ORTMPLTP_LIS);
                    layoutTabl.XTabPages[2].Visible = paramStr.Contains(BdSrvDictCodeConst.SD_ORTMPLTP_TREAT);
                    layoutTabl.XTabPages[3].Visible = paramStr.Contains(BdSrvDictCodeConst.SD_ORTMPLTP_CZXCY);
                    layoutTabl.XTabPages[4].Visible = paramStr.Contains(BdSrvDictCodeConst.SD_ORTMPLTP_FHMBA);
                }
            }

            xUserControl.Dock = DockStyle.Fill;
            return xUserControl;
        }
        public void saveData() {
            LayoutXTabPanelControl layoutTabl = xUserControl.GetConfig().GetInstance("tablayout1") as LayoutXTabPanelControl;
            (layoutTabl.SelectedPage.PageControl as IViewCommond).saveData();
        }
        public void close() {
            assiViewFrame.Close();
        }
        public object getSaveData() {
            return null;
        }
        public void switchToPithy() {
            (assiViewFrame as AssiViewFrame).switchToPithy();
        }
        public void allChecked() {
            LayoutXTabPanelControl layoutTabl = xUserControl.GetConfig().GetInstance("tablayout1") as LayoutXTabPanelControl;
            (layoutTabl.SelectedPage.PageControl as OpTemplateControlComplex).allChecked();
        }
        public void allCancel() {
            LayoutXTabPanelControl layoutTabl = xUserControl.GetConfig().GetInstance("tablayout1") as LayoutXTabPanelControl;
            (layoutTabl.SelectedPage.PageControl as OpTemplateControlComplex).allCancel();
        }
    }
}
