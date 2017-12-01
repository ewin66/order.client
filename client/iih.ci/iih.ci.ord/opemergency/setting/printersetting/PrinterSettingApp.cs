
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.setting;
using xap.cli.sdk.controls;
using xap.cli.sdk.render.Items;
using iih.ci.ord.ciprn.i;
using xap.mw.serviceframework;
using xap.mw.coreitf.d;

namespace iih.ci.ord.opemergency.setting.printersetting
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.setting.printersetting    </para>    
    /// <para>类 名 称 :  PrinterSettingApp					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/9/13 15:07:12             </para>
    /// <para>更新时间 :  2017/9/13 15:07:12             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class PrinterSettingApp : ISettingApp
    {
        private ICiprintExtService service = XapServiceMgr.find<ICiprintExtService>();
        #region 属性  事件（接口实现区域）
        public event EventHandler DataChanged;
        private void FireDataChanged()
        {
            if (DataChanged != null)
            {
                DataChanged(this, null);
            }
        }
        public String MenuItemName
        {
            get { return "打印机设置"; }
        }

        public bool IsModify { get; set; }

        public XAPScrollBarPanel Panel { get; set; }

        public String FunCode
        {
            get
            {
                return "461005";

            }
        }


        public String Code
        {

            get { return "ord" + "_" + "PrinterSettingApp"; }
        }

        public int Order
        {
            get { return 5; }
        }

        /// <summary>
        /// 当前激活节点所对应的Control
        /// </summary>
        public Object ActivedControl { set; get; }
        #endregion

        #region 构造
        public PrinterSettingApp()
        {
            Panel = new PrinterSettingControl(DelegateGetReportPrinter);
            
        }
        #endregion

        #region 事件处理

        string DelegateGetReportPrinter()
        {
            return service.GetReportPrinter();
        }
        #endregion

        #region 重写

        public void LoadMenItemPanel(XAPScrollBarPanel panel, SetMenunrender setMenunrender)
        {
            Panel = panel;
            Panel.Tag = setMenunrender;
        }

        public void Save()
        {
            service.SaveReportPrinter((Panel as PrinterSettingControl).printerName);
            this.IsModify = false;
        }

        public void Revoke()
        {

        }
        #endregion
    }
}
