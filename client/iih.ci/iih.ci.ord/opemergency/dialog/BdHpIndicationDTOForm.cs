using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using iih.bd.bc.udi;
using iih.bd.srv.ems.d;
using iih.bd.srv.ems.i;
using xap.rui.control.basecontrol;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.i;
using iih.ci.ord.opemergency.view.printmanage;
using iih.ci.ord.opemergency.viewmodel;
using iih.ci.ord.pres.d;
using iih.ci.ord.pres.i;
using iih.en.pv.dto.d;
using xap.cli.sdk.form;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.engine;
using System.Drawing;
using iih.bd.pp.mpayratiodf.d;
using iih.ci.ord.ciordsysparam;
using iih.ci.ord.opemergency.tool;
using xap.cli.sdk.controls;
using xap.cli.sdk.render;
using xap.cli.sdk.render.Items;

namespace iih.ci.ord.opemergency.dialog
{
    public partial class BdHpIndicationDTOForm : XSingleDialog
    {
        private XAPScrollBarPanel panel;
        private XBaseControl centerControl;
        public  XButton saveButton;
        public XButton saveButton1;//报销比例1
        public XButton saveButton2;//报销比例2
        public XButton cancelButton;
        private XLabel lblDes;
        public Dictionary<String, MPayRatioDfDO> dic; 
        public BdHpIndicationDTOForm(string limit, string name_srv, bool? isDefault)
        {
            this.IsShowButton = false;
            this.StartPosition = FormStartPosition.CenterScreen;
            this.Formsize = FormSize.Medium;
            this.Text = "是否为医保适应症";
            this.Height = 200;

            panel = new XAPScrollBarPanel();
            panel.Size = this.Panel.Size;
            panel.Location = this.Panel.Location;
            this.Panel = panel;

            centerControl = new XBaseControl();

            lblDes = new XLabel();
            if (!string.IsNullOrEmpty(limit))
            {
                lblDes.ValueText = limit;
            }
            else
            {
                lblDes.ValueText = "没有医保适应症限制条件";
            }

            //string  strParam = SysParamUtils.getSysParam().SYS_PARAM_HPInfoMode.OrgParam;
           //if (strParam != null && strParam =="2")
           // {
           //     lblDes.ValueText = " 医保限制条件 ："+lblDes.ValueText + "\n  院内限制条件：" + hislimit;
           // }
           //else if (strParam != null && strParam == "1")
           // {
           //     lblDes.ValueText = " 院内限制条件：" + hislimit;
           // }



            lblDes.Font = new System.Drawing.Font("微软雅黑", 10.75F);
            lblDes.Size = lblDes.GetPreferredSize(new Size(this.Size.Width - 20, 0));
            lblDes.Location = new Point(10,0);
            
            centerControl.Size = new Size(this.Size.Width - this.Padding.Horizontal ,lblDes.Size.Height +10);
            centerControl.Location = new Point(0, 0);
            centerControl.AddRender(lblDes);
            panel.AddRender(centerControl);
            panel.getScrollBarRect();

            saveButton = new XButton { Size = new Size(90, 25), Text = "符合-医保" };
            saveButton1 = new XButton { Size = new Size(90, 25), Text = "符合-医保1" };
            saveButton2 = new XButton { Size = new Size(90, 25), Text = "符合-医保2" };
            cancelButton = new XButton { Size = new Size(90, 25), Text = "不符合-自费" };
           
            saveButton.MouseClick += new MouseEventHandler(saveButton_MouseClick);
            saveButton1.MouseClick += new MouseEventHandler(saveButton_MouseClick1);
            saveButton2.MouseClick += new MouseEventHandler(saveButton_MouseClick2);
            cancelButton.MouseClick += new MouseEventHandler(cancelButton_MouseClick);

            this.AddRender_Btn(saveButton1, saveButton2, saveButton, cancelButton);
           // this.AddRender_Btn( saveButton1, saveButton2, cancelButton);
            if (isDefault != null && (bool)isDefault)
            {
                this.MouseButton = saveButton;
            }
            else {
                this.MouseButton = cancelButton;
            }
        }

        void cancelButton_MouseClick(object sender, MouseEventArgs e)
        {
            this.DialogResult = DialogResult.No;
        }

        void saveButton_MouseClick(object sender, MouseEventArgs e)
        {
            this.DialogResult = DialogResult.OK;
        }
        void saveButton_MouseClick1(object sender, MouseEventArgs e)
        {
            this.DialogResult = DialogResult.Retry;
        }
        void saveButton_MouseClick2(object sender, MouseEventArgs e)
        {
            this.DialogResult = DialogResult.Yes;
        }
    }
}
