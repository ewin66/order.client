/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/13 15:49:02
* Filename    : OrderExtAssist
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description : 医嘱模板-复杂版专用CheckBox
*****************************************************************************/
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.common_stub.datong.data;
using xap.cli.sdk.common;
using xap.cli.sdk.render;

namespace iih.ci.ord.ciorder.render.common
{
    /// <summary>
    /// 医嘱模板-复杂版专用CheckBox
    /// </summary>
    public class OrderCheckBox:XCheckBox
    {

        public OrderCheckBox()
        {
            Init();
        }

        void Init()
        {
            if (RelativeUIParam.ScreenSize == ScreenSize.Large)
            {
                this.Font = new Font("微软雅黑", 14, GraphicsUnit.Pixel);
            }
            else
            {
                this.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
            }

            //this.WhiteBlue = true;
        }


        protected override void OnMouseDown(object sender, MouseEventArgs e)
        {
            if (this.CheckButtonRect.Contains(e.Location))
                base.OnMouseDown(sender, e);
        }


        public override void Render(Graphics g)
        {
            this.ReadOnly = false;
            this.Enabled = true;
            base.Render(g);
        }
    }
}
