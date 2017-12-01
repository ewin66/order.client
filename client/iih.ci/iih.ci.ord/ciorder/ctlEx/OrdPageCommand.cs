using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.control.formcontrol.model;
using System.Windows.Forms;
using xap.rui.control.commands;
using System.Drawing;

namespace iih.ci.ord.ciorder.ctlEx
{
    class OrdPageCommand
    {
        public XapCommand addCommand;
        public XapCommand delCommand;
        public XapCommand printCommand;
        public PageCommands pageCommands(string pagecode, EventHandler addHandler, EventHandler delHandler,bool fg_deps)
        {
            PageCommands pageCommands = new PageCommands();
            pageCommands.TabCode = pagecode;//页签编码
            string basePath = Application.StartupPath + "\\res\\Image";
            //新增按钮
            addCommand = new XapCommand();
            //addCommand.NormalImage = Image.FromFile(basePath + "\\Pix256\\common\\增加-1.png");
            //addCommand.HoverImage = Image.FromFile(basePath + "\\Pix256\\common\\增加-2.png");
            //addCommand.DownImage = Image.FromFile(basePath + "\\Pix256\\common\\增加-3.png");
            //addCommand.DisableImage = Image.FromFile(basePath + "\\Pix256\\common\\增加-4.png");
            addCommand.ImageName = "增加";
            addCommand.ToolTip = "增加";
            addCommand.Command = "增加";
            //TODO xiaoying 业务处理
            addCommand.ExecuteHandler = addHandler;
            addCommand.Visible = fg_deps;
            addCommand.Enabled = fg_deps;

            //删除按钮
            delCommand = new XapCommand();
            //delCommand.NormalImage = Image.FromFile(basePath + "\\Pix256\\common\\删除-1.png");
            //delCommand.HoverImage = Image.FromFile(basePath + "\\Pix256\\common\\删除-2.png");
            //delCommand.DownImage = Image.FromFile(basePath + "\\Pix256\\common\\删除-3.png");
            //delCommand.DisableImage = Image.FromFile(basePath + "\\Pix256\\common\\删除-4.png");
            delCommand.ImageName = "tab-删除";
            delCommand.ToolTip = "删除";
            delCommand.Command = "移除";
            //TODO xiaoying 业务处理
            delCommand.ExecuteHandler = delHandler;
            delCommand.Visible = fg_deps;
            delCommand.Enabled = fg_deps;


            pageCommands.Commands.AddRange(new XapCommand[] { addCommand,delCommand });
            return pageCommands;
        }
        public PageCommands pageCommands1(string pagecode, EventHandler addHandler, EventHandler delHandler, EventHandler printHandler, bool fg_deps)
        {
            PageCommands pageCommands = new PageCommands();
            pageCommands.TabCode = pagecode;//页签编码
            string basePath = Application.StartupPath + "\\res\\Image";
            //新增按钮
            addCommand = new XapCommand();
            //addCommand.NormalImage = Image.FromFile(basePath + "\\Pix256\\common\\增加-1.png");
            //addCommand.HoverImage = Image.FromFile(basePath + "\\Pix256\\common\\增加-2.png");
            //addCommand.DownImage = Image.FromFile(basePath + "\\Pix256\\common\\增加-3.png");
            //addCommand.DisableImage = Image.FromFile(basePath + "\\Pix256\\common\\增加-4.png");
            addCommand.ImageName = "增加";
            addCommand.ToolTip = "增加";
            addCommand.Command = "增加";
            //TODO xiaoying 业务处理
            addCommand.ExecuteHandler = addHandler;
            addCommand.Visible = fg_deps;
            addCommand.Enabled = fg_deps;

            //删除按钮
            delCommand = new XapCommand();
            //delCommand.NormalImage = Image.FromFile(basePath + "\\Pix256\\common\\删除-1.png");
            //delCommand.HoverImage = Image.FromFile(basePath + "\\Pix256\\common\\删除-2.png");
            //delCommand.DownImage = Image.FromFile(basePath + "\\Pix256\\common\\删除-3.png");
            //delCommand.DisableImage = Image.FromFile(basePath + "\\Pix256\\common\\删除-4.png");
            delCommand.ImageName = "tab-删除";
            delCommand.ToolTip = "删除";
            delCommand.Command = "移除";
            //TODO xiaoying 业务处理
            delCommand.ExecuteHandler = delHandler;
            delCommand.Visible = fg_deps;
            delCommand.Enabled = fg_deps;
            //打印按钮 by yzh 2017-08-17 19:42:46
            printCommand = new XapCommand();
            printCommand.ImageName = "打印床位卡";
            printCommand.ToolTip = "打印";
            printCommand.Command = "打印";
            //业务处理 by yzh 2017-08-17 19:42:40
            printCommand.ExecuteHandler = printHandler;
            printCommand.Visible = fg_deps;
            printCommand.Enabled = fg_deps;


            pageCommands.Commands.AddRange(new XapCommand[] { printCommand, addCommand, delCommand });
            return pageCommands;
        }
    }
}
