
using iih.en.pv.dto.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.cli.sdk.form;
using xap.mw.coreitf.d;
using xap.rui.control.basecontrol;
using xap.rui.control.forms.view;
using xap.rui.engine;

namespace iih.ci.ord.opemergency.assi.enthistory.view
{
    /// <summary>
    /// <para>描    述 :  </para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.enthistory.view</para>    
    /// <para>类 名 称 :  EntHistoryTabFrame</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/12/14 16:02:10</para>
    /// <para>更新时间 :  2016/12/14 16:02:10</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EntHistoryTabFrame : XapBaseControl
    {
        /// <summary>
        /// banner数据
        /// </summary>
        private Ent4BannerDTO BannerDTO;
        /// <summary>
        /// 当前环境
        /// </summary>
        private BaseContext BaseContext;
        /// <summary>
        /// 与门诊病历、医嘱、诊断交互的类
        /// </summary>
        private EntHistoryInitEvent EntHistoryInitEvent;

        /// <summary>
        /// 展示就诊历史组件的控件
        /// </summary>
        private XapFormControl xapFormControl;
        

        public EntHistoryTabFrame()
        {
            xapFormControl = new XapFormControl();
            xapFormControl.Dock = DockStyle.Fill;
            this.Controls.Add(xapFormControl);
            this.Load += EntHistoryTabFrame_Load;            
        }

        private void EntHistoryTabFrame_Load(object sender, EventArgs e)
        {
            // 弹出窗口
            XForm assiViewFrame = this.Context["assiViewFrame"] as XForm;
            // 加载窗口对象，用于对外发送事件
            XapBaseControl xapBaseControl = this.Context["sender"] as XapBaseControl;
            // 点击确定按钮时是否关闭窗口
            bool isConfirmCloseAssiFrame = (bool)this.Context["isConfirmCloseAssiFrame"];
            // 关闭按钮名称
            string closeBtnText = this.Context["closeBtnText"].ToString();

            this.BannerDTO = this.Context["ent4BannerDTO"] as Ent4BannerDTO;
            this.BaseContext = this.Context["context"] as BaseContext;
            this.EntHistoryInitEvent = this.Context["entHistoryInitEvent"] as EntHistoryInitEvent;
            

            XUserControl xUserControl = new XUserControl();
            xUserControl.Init(Application.StartupPath + "\\modules\\iihci\\ui\\optrdocstation\\enthistory\\enthistory_config.xml");

            EntHistory entHistory = xUserControl.GetConfig().GetInstance("EntHistory") as EntHistory;
            EntHistoryContent entHistoryContent = xUserControl.GetConfig().GetInstance("EntHistoryContent") as EntHistoryContent;
            EntHistoryBtn entHistoryBtn = xUserControl.GetConfig().GetInstance("EntHistoryBtn") as EntHistoryBtn;

            entHistory.Ent4BannerDTO = this.BannerDTO;

            entHistoryContent.Ent4BannerDTO = this.BannerDTO;
            entHistoryContent.EntHistoryInitEvent = this.EntHistoryInitEvent;
            entHistoryContent.BaseContext = this.BaseContext;
            // 弹出窗口
            entHistoryContent.AssiViewFrame = assiViewFrame;
            // 确定时是否关闭窗口
            entHistoryContent.IsConfirmCloseAssiFrame = isConfirmCloseAssiFrame;

            entHistoryBtn.Ent4BannerDTO = this.BannerDTO;
            entHistoryBtn.CloseBtnText = closeBtnText;
            // 弹出窗口
            entHistoryBtn.AssiViewFrame = assiViewFrame;

            xUserControl.Dock = DockStyle.Fill;
            this.xapFormControl.AddRender(xUserControl);
        }
    }
}