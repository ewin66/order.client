
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Windows.Forms;
using xap.cli.sdk.controls;
using xap.cli.sdk.form;
using xap.rui.control.basecontrol;

namespace iih.ci.ord.opemergency.assi.asscommon.util
{
    /// <summary>
    /// <para>描    述 :  鼠标点击事件</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.asscommon.util</para>    
    /// <para>类 名 称 :  AssiMouseEventHandler</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/12/12 15:27:53</para>
    /// <para>更新时间 :  2016/12/12 15:27:53</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class AssiMouseEventHandler : IMessageFilter
    {

        // 鼠标左键keyDown
        private const int WM_LBUTTONDOWN = 0x201;
        // 鼠标右键keyDown
        private const int WM_RBUTTONDOWN = 0x204;

        private List<XBaseControl> xapCtrlList;


        /// <summary>
        /// 相应鼠标事件关闭的control
        /// </summary>
        private XForm xForm;

        /// <summary>  
        /// 获取当前活跃窗口  
        /// </summary>  
        /// <returns></returns>  
        //[DllImport("user32.dll", EntryPoint = "GetActiveWindow")]
        //public static extern IntPtr GetActiveWindow();

        [DllImport("user32.dll", CharSet = CharSet.Auto, ExactSpelling = true)]
        public static extern IntPtr GetActiveWindow();


        public AssiMouseEventHandler(XForm xForm, List<XBaseControl> xapCtrlList)
        {
            this.xForm = xForm;
            this.xapCtrlList = xapCtrlList;
        }

        /// <summary>
        /// 判断control 与 parentForm是否为同一对象
        /// </summary>
        /// <param name="control"></param>
        /// <param name="parentForm"></param>
        /// <returns></returns>
        private static bool isXParentForm(Control control, XForm parentForm)
        {
            if (control == null)
            {
                return false;
            }

            if (control is Form) //找到Form 结束
            {                
                Form ctrlForm = control as Form;
                if (ctrlForm.Modal) {
                    return true;
                }
                                
                //if (ctrlForm.Handle == parentForm.Handle)
                //{
                //    return true;
                //}

                //return isXParentForm(ctrlForm.ParentForm, parentForm); // 递归判断父窗口
            }
            else
            {
                return isXParentForm(control.Parent, parentForm);//递归调用
            }
            return false;
        }

        /// <summary>
        /// 判断xForm是否为当前活动窗口的父窗口
        /// </summary>
        /// <param name="xForm">父窗体</param>
        /// <returns>是否为父窗口true:是；false:否</returns>
        private static bool isXParentForm(XForm xForm)
        {
            IntPtr activeFormHandle = GetActiveWindow();
            Control ctrl = Form.FromHandle(activeFormHandle);
            if (isXParentForm(ctrl, xForm)) {
                return true;
            } 

            return false;
        }

        public bool PreFilterMessage(ref Message m)
        {
            if (m.Msg == WM_LBUTTONDOWN || m.Msg == WM_RBUTTONDOWN)
            {

                if (xForm != null && xapCtrlList != null)
                {

                    if (isXParentForm(this.xForm)) {
                        return false;
                    }

                    // 是否点击辅助录入区域
                    if (mouseClickInXForm())
                    {
                        return false;
                    }

                    // 是否点击病历编辑区
                    if (mouseClickInCtrl())
                    {
                        return false;
                    }

                    xForm.Close();
                }
            }
            return false;
        }

        /// <summary>
        /// 判断鼠标是否在辅助录入窗体区域点击
        /// </summary>
        /// <returns>true 在</returns>
        private bool mouseClickInXForm()
        {

            if (xForm != null)
            {
                Rectangle Rect = new Rectangle(xForm.Location, xForm.Size);
                if (Rect.Contains(Cursor.Position))
                {
                    return true;
                }
            }

            return false;
        }

        /// <summary>
        /// 判断当前鼠标是否在xapCtrlList区域点击，如果是不关闭辅助录入窗体
        /// </summary>
        /// <param name="xapBaseCtrl"></param>
        /// <returns></returns>
        private bool mouseClickInCtrl()
        {
            if (this.xapCtrlList != null)
            {
                foreach (XBaseControl xapCtrl in xapCtrlList)
                {
                    if (xapCtrl != null && xapCtrl.Visible)
                    {
                        Rectangle Rect = new Rectangle(xapCtrl.PointToScreen(new Point(0, 0)), xapCtrl.Size);
                        if (Rect.Contains(Cursor.Position))
                        {
                            return true;
                        }
                    }
                }
            }

            return false;
        }
    }
}
