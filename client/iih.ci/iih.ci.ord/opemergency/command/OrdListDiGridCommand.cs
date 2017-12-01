
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.control.commands;
using xap.rui.control.formcontrol.model;

namespace iih.ci.ord.opemergency.command
{
    /// <summary>
    /// <para>描    述 : 诊断列表命令                    			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.command    </para>    
    /// <para>类 名 称 :  OrdListDiGridCommand					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  vivi         				</para> 
    /// <para>修 改 人 :  vivi         				</para> 
    /// <para>创建时间 :  11/11/2016 4:16:10 PM             </para>
    /// <para>更新时间 :  11/11/2016 4:16:10 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OrdListDiGridCommand
    {
        public static PageCommands PageCommandsWith(string pagecode, IPageCommand delegateOwner , bool enable)
        {
            PageCommands pageCommands = new PageCommands();
            pageCommands.TabCode = pagecode;//页签编码
            
            //新增按钮
            XapCommand addCommand = new XapCommand();
            
            addCommand.ImageName = "增加";
            addCommand.ToolTip = "增加";
            addCommand.Command = "OpDiAddAction";
            addCommand.Text = "增加";
            addCommand.ExecuteHandler = (sender, e)=> { if (delegateOwner != null) delegateOwner.OnPageCommand(addCommand, e); };
            addCommand.Visible = true;
            addCommand.Enabled = enable;

            //删除按钮
            XapCommand delCommand = new XapCommand();
            delCommand.ImageName = "tab-删除";
            delCommand.Text = "删除";
            delCommand.ToolTip = "删除";
            delCommand.Command = "OpDiDeleteAction";
            delCommand.ExecuteHandler = (sender, e) => { if (delegateOwner != null) delegateOwner.OnPageCommand(delCommand, e); };
            delCommand.Visible = true;
            delCommand.Enabled = enable;

            //保存按钮
            XapCommand saveCommand = new XapCommand();
            saveCommand.ImageName = "保存";
            saveCommand.ToolTip = "保存";
            saveCommand.Text = "保存";
            saveCommand.Command = "OpDiSaveAction";
            saveCommand.ExecuteHandler = (sender, e) => { if (delegateOwner != null) delegateOwner.OnPageCommand(saveCommand, e); };
            saveCommand.Visible = true;
            saveCommand.Enabled = enable;


            pageCommands.Commands.AddRange(new XapCommand[] { saveCommand, delCommand, addCommand });
            return pageCommands;
        }
    }
}
