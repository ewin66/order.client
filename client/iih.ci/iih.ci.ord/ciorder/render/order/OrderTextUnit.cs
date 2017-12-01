/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/111 15:49:02
* Filename    : OrderExtAssist
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description : 扩展的单位控件，只允许输入数字加小数点
*****************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.cli.sdk.render;
using xap.cli.sdk.render.Items;

namespace iih.ci.ord.ciorder.render.order
{
    /// <summary>
    /// 扩展的单位控件，只允许输入数字加小数点
    /// </summary>
    public class OrderTextUnit:XUnitTextBox
    {
        /// <summary>
        /// 是否只允许输入数字（不包含小数点）
        /// </summary>
        public bool IsOnlyNum { get; set; }

        public OrderTextUnit()
        {
            this.IsPersonSetMaxUnitSize = true;
            this.MaxUnitWidth = 20;
            this.CanResize = true;
            this.KeyPress += OrderTextUnit_KeyPress;
            this.KeyUp += OrderTextUnit_KeyUp;
        }

        void OrderTextUnit_KeyUp(object sender, KeyEventArgs e)
        {
           
        }

        void OrderTextUnit_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (this.IsOnlyNum)
            {
                //控制只可以录入数字和退格
                if (!(Char.IsNumber(e.KeyChar)) && e.KeyChar != (char)8)
                {
                    e.Handled = true;
                }
            }
            else
            {
                if (((int)e.KeyChar < 48 || (int)e.KeyChar > 57) && (int)e.KeyChar != 8 && (int)e.KeyChar != 46)
                    e.Handled = true;
                //小数点的处理。
                if ((int)e.KeyChar == 46)                           //小数点
                {
                    if (this.Text.Length <= 0)
                        e.Handled = true;   //小数点不能在第一位
                    else
                    {
                        float f;
                        float oldf;
                        bool b1 = false, b2 = false;
                        b1 = float.TryParse(this.Text, out oldf);
                        b2 = float.TryParse(this.Text + e.KeyChar.ToString(), out f);
                        if (b2 == false)
                        {
                            if (b1 == true)
                                e.Handled = true;
                            else
                                e.Handled = false;
                        }
                    }
                }
            }
          
        }

     
    }
}
