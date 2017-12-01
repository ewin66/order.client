using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.opemergency.assi.asscommon.dto;
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

namespace iih.ci.ord.opemergency.assi.medsrvclass
{
    public partial class OpMedsrvClassFrame :  XapBaseControl
    {
        /// <summary>
        /// banner数据
        /// </summary>
        private Ent4BannerDTO Ent4BannerDTO;
        /// <summary>
        /// 当前环境
        /// </summary>
        private BaseContext BaseContext;
        /// <summary>
        /// 与门诊病历、医嘱、诊断交互的类
        ///// </summary>
        //private EntHistoryInitEvent EntHistoryInitEvent;

        /// <summary>
        /// 展示就诊历史组件的控件
        /// </summary>
        private XapFormControl xapFormControl;
        //private XButton saveButton;
        //private XButton cancelButton;

        public OpMedsrvClassFrame()
        {
            xapFormControl = new XapFormControl();
            xapFormControl.Dock = DockStyle.Fill;
            this.Controls.Add(xapFormControl);
            this.Load += EntHistoryTabFrame_Load;

   
        }

        private void EntHistoryTabFrame_Load(object sender, EventArgs e)
        {
            this.Ent4BannerDTO = this.Context["ent4BannerDTO"] as Ent4BannerDTO;
            this.BaseContext = this.Context["context"] as BaseContext;
            CiEnContextDTO ciEnContext = this.Context["ciEnContext"] as CiEnContextDTO;
            XForm assiViewFrame = this.Context["assiViewFrame"] as XForm;
            AssiBtnDTO assiBtnDTO = this.Context["assiBtnDTO"] as AssiBtnDTO;
            XapBaseControl xapBaseControl = this.Context["sender"] as XapBaseControl;
         
            XUserControl xUserControl = new XUserControl();

            //if (assiBtnDTO == null)
            //{
            //    this.ShowInfo("按钮异常", "提示");
            //}
            //else
            //{
            //    if (assiBtnDTO.ButtonId == "btnOpTemplateFrame")
            //    {
            //        xUserControl.Init("modules\\iihci\\ui\\opordertemplate\\Helper.xml");
            //        OpOrderTemplateListView orderHelpButten = xUserControl.GetConfig().GetInstance("OpOrderTemplateListView") as OpOrderTemplateListView;
            //        orderHelpButten.BannerDTO = this.BannerDTO;
            //        orderHelpButten.AssiViewFrame = assiViewFrame;
            //        orderHelpButten.xapBaseControl = xapBaseControl;
            //    }
            //    else if (assiBtnDTO.ButtonId == "btnOpMedicalTechnology")
            //    {
            //        xUserControl.Init("modules\\iihci\\ui\\opmedicaltechnology\\Helper.xml");
            //        OPMedicalTechnologyListView orderHelpButten = xUserControl.GetConfig().GetInstance("OPMedicalTechnologyListView") as OPMedicalTechnologyListView;
            //        orderHelpButten.BannerDTO = this.BannerDTO;
            //        orderHelpButten.AssiViewFrame = assiViewFrame;
            //        orderHelpButten.xapBaseControl = xapBaseControl;

            //    }
            //    else if (assiBtnDTO.ButtonId == "btnMedSrv")
            //    {
            //        xUserControl.Init("modules\\iihci\\ui\\medsrvclass\\Helper.xml");
            //        OpmedSrvRadioView orderHelpButten = xUserControl.GetConfig().GetInstance("OpmedSrvRadioView") as OpmedSrvRadioView;
            //        orderHelpButten.BannerDTO = this.BannerDTO;
            //        orderHelpButten.AssiViewFrame = assiViewFrame;
            //        orderHelpButten.xapBaseControl = xapBaseControl;
            //    }

            //}

            xUserControl.Init("modules\\iihci\\ui\\medsrvclass\\Helper.xml");
            OpmedSrvRadioView orderHelpButten = xUserControl.GetConfig().GetInstance("OpmedSrvRadioView") as OpmedSrvRadioView;
            orderHelpButten.Ent4BannerDTO = this.Ent4BannerDTO;
            orderHelpButten.AssiViewFrame = assiViewFrame; // 助手打开最外层窗口
            orderHelpButten.ciEnContext = ciEnContext; // 上下文就诊环境
            orderHelpButten.xapBaseControl = xapBaseControl;
        
           // cancelButton.MouseClick += new MouseEventHandler(cancelButton_MouseClick);

            //EntHistory entHistory = xUserControl.GetConfig().GetInstance("EntHistory") as EntHistory;
            //EntHistoryContent entHistoryContent = xUserControl.GetConfig().GetInstance("EntHistoryContent") as EntHistoryContent;
            //EntHistoryBtn entHistoryBtn = xUserControl.GetConfig().GetInstance("EntHistoryBtn") as EntHistoryBtn;

            //entHistory.Ent4BannerDTO = this.BannerDTO;

            //entHistoryContent.Ent4BannerDTO = this.BannerDTO;
            //entHistoryContent.EntHistoryInitEvent = this.EntHistoryInitEvent;
            //entHistoryContent.BaseContext = this.BaseContext;
            
            //entHistoryBtn.Ent4BannerDTO = this.BannerDTO;

            xUserControl.Dock = DockStyle.Fill;
            this.xapFormControl.AddRender(xUserControl);
         
        }
    }
}
