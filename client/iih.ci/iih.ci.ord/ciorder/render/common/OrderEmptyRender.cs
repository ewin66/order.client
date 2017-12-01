/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/15 16:41:29
* Filename    : OrderEmptyRender
* Project     : iih.ci.ord.ciorder.render.common
* Username    : f
* Description : 医嘱模板-复杂模板如果查询的数据为空的渲染实体
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
    ///  医嘱模板-复杂模板如果查询的数据为空的渲染实体
    /// </summary>
    public class OrderEmptyRender:UserRender
    {
        #region 属性

        /// <summary>
        /// 数据为空的提示信息
        /// </summary>
        public String TipText { get; set; }

        /// <summary>
        /// 画刷
        /// </summary>
        public SolidBrush Brush { get; set; }


        /// <summary>
        /// 渲染字体
        /// </summary>
        public Font Font { get; set; }



        #endregion

        #region 构造

        public OrderEmptyRender()
        {
            Init();
        }

        void Init()
        {
            Brush = new SolidBrush(Color.FromArgb(74, 74, 74));
            this.TipText = "未检索到相关数据";
            this.Font = OrderConstAssist.OrderFont;
        }

        #endregion

        #region 渲染

        public override void Render(Graphics g)
        {
            //using (StringFormat stringFormat=)
            //{
                
            //}
            g.DrawString(this.TipText, this.Font,this.Brush,this.Bound);
            base.Render(g);
        }

        #endregion

        #region Dispose

        protected override void DisposeManaged()
        {
            this.Brush.Dispose();
            base.DisposeManaged();
        }

        #endregion
    }
}
