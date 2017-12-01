/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/13 15:49:02
* Filename    : OrderExtAssist
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description : 只能录入数字的文本框
*****************************************************************************/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.cli.sdk.render.Items;


namespace iih.ci.ord.ciorder.render.common
{
    /// <summary>
    /// 只能录入数字的文本框
    /// </summary>
    public class OrderNumberTextBox:XTextBox
    {
        /// <summary>
        /// 树节点键盘按下事件，在ExecuteDialogKey转发
        /// </summary>
        public OrderLabel.TreeNodeKeyDownDelegate TreeNodeKeyDownEvent;


        public OrderNumberTextBox()
        {
            this.KeyPress += OrderNumberTextBox_KeyPress;
        }

        void OrderNumberTextBox_KeyPress(object sender, System.Windows.Forms.KeyPressEventArgs e)
        {
            //控制只可以录入数字和退格
            if (!(Char.IsNumber(e.KeyChar))&&e.KeyChar!=(char)8)
            {
                e.Handled = true;
            }
        }


        //重写ExcutedKeyDown，将事件转发到树节点那一层去处理
        public override bool ExecuteDialogKey(Keys keyData)
        {
            if (TreeNodeKeyDownEvent != null)
            {
                TreeNodeKeyDownEvent(keyData);
            }
            return base.ExecuteDialogKey(keyData);
        }
    }
}
