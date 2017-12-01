
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using xap.rui.control.basecontrol;
//using xap.cli.sdk.controls.webbrowser;
using System.Windows.Forms;
using xap.cli.context.events;
using xap.cli.sdk.controls;
using xap.cli.sdk.form;

namespace iih.ci.ord.opemergency.lis
{
    /// <summary>
    /// <para>描    述 :  检查报告查看</para>
    /// <para>说    明 :  对应轻量级中功能注册编码是 46105570</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.lis    </para>    
    /// <para>类 名 称 :  ListrptView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  hums         				</para> 
    /// <para>修 改 人 :  hums         				</para> 
    /// <para>创建时间 :  2016/9/28 15:40:33             </para>
    /// <para>更新时间 :  2016/9/28 15:40:33             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class ListrptView : XForm
    {

        #region 变量定义区域        

        /// <summary>
        /// 轻量级中检查报告的功能编码
        /// </summary>
        private const string FUN_CODE = "46105570";

        #endregion

        #region 构造函数区域

        public ListrptView()
        {
            InitializeComponent();
        }

        public ListrptView(IContainer container)
        {
            container.Add(this);


            InitializeComponent();
        }

        #endregion

        #region 公开属性区域

        /// <summary>
        /// 医嘱属性
        /// </summary>
        private string IdOr{get;set;}

        #endregion

        #region 命令定义区域

        #endregion

        #region 事件发送区域

        #endregion

        #region 事件接收区域

        #endregion

        #region 父类继承区域

        #endregion

        #region 内部事件区域

        /// <summary>
        /// 加载检验报告
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void ListrptView_Load(object sender, EventArgs e)
        {
            Control ctrl = XapEvents.GetFuncEvent(this, new GetFuncEventArgs(FUN_CODE, new Dictionary<string, object>()));
            ctrl.Dock = DockStyle.Fill;
            this.AddRender(ctrl);         
        }

        //protected override xap.cli.sdk.controls.XBaseControl CreatePanel()
        //{
        //    XBaseControl xbc = new XBaseControl();
        //    Control ctrl = XapEvents.GetFuncEvent(this, new GetFuncEventArgs("46105570", new Dictionary<string, object>()));
        //    ctrl.Dock = DockStyle.Fill;
        //    xbc.AddRender(ctrl);
        //    return xbc;
        //}

        #endregion

        #region 辅助处理函数

        #endregion

        #region 状态处理区域


        #endregion
    }
}
