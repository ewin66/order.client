/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/13 15:49:02
* Filename    : OrderExtAssist
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description : 复杂模板--分割线
*****************************************************************************/
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using xap.cli.sdk.render;

namespace iih.ci.ord.ciorder.render.common
{
    /// <summary>
    /// 复杂模板--分割线
    /// </summary>
    public class OrderLineRender:UserRender
    {
        public Pen LinePen { get; set; }


        public OrderLineRender()
        {
            this.LinePen = new Pen(Color.FromArgb(233,233,233),1);
        }

        public override void Render(Graphics g)
        {
            //g.FillRectangle(new SolidBrush(Color.Red),this.Bound );
            g.DrawLine(this.LinePen, this.Location.X + this.Size.Width/2, this.Location.Y,
                this.Location.X + this.Size.Width/2, this.Bound.Bottom);
            base.Render(g);
        }

        protected override void DisposeManaged()
        {
            this.LinePen.Dispose();
            base.DisposeManaged();
        }
    }
}
