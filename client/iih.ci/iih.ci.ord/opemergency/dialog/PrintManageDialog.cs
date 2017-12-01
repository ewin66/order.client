using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using iih.bd.bc.udi;
using iih.bd.srv.ems.d;
using iih.bd.srv.ems.i;
using iih.ci.ord.ciordems.d;
using xap.rui.control.basecontrol;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.i;
using iih.ci.ord.opemergency.view;
using iih.ci.ord.opemergency.view.printmanage;
using iih.ci.ord.opemergency.viewmodel;
using iih.ci.ord.pres.d;
using iih.ci.ord.pres.i;
using xap.cli.sdk.form;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.engine;
using xap.rui.control.exceptions;
using xap.rui.control.extentions;
using xap.mw.serviceframework.ex;

namespace iih.ci.ord.opemergency.dialog
{
    public partial class PrintManageDialog : XBaseDialog
    {
        private PrintPreviewView bottomView;

        /// <summary>
        /// 打印管理窗口（用于医技补费）
        /// </summary>
        /// <param name="idors"></param>
        /// <param name="id_hp">医保计划ID</param>
        /// <param name="sd_hptp">医保类型编码</param>
        public PrintManageDialog(String[] idors, String id_hp, String sd_hptp)
            : this(2, idors.ToList<String>(), new List<String>(), null, id_hp, sd_hptp, false)
        { }

        /// <summary>
        /// 打印管理窗口
        /// </summary>
        /// <param name="selectedIndex"></param>
        /// <param name="lstIdor"></param>
        /// <param name="lstIdpres"></param>
        /// <param name="ordListView"></param>
        /// <param name="id_hp"></param>
        /// <param name="sd_hptp"></param>
        /// <param name="bShowTools"></param>
        public PrintManageDialog(int selectedIndex, List<String> lstIdor, List<String> lstIdpres, XapBaseControl ordListView, String id_hp, String sd_hptp, bool bShowTools)
        {
            InitializeComponent();
            this.Text = "打印预览";
            this.Formsize = FormSize.ExtraLarge;
            this.Height = 600;
            this.HasbtnBackRec = false;
            this.Closing += new System.ComponentModel.CancelEventHandler(PrintManageDialog_Closing);

            XUserControl userControl = new XUserControl();
            userControl.Init(Application.StartupPath + (bShowTools ? "\\modules\\iihci\\ui\\printmanage\\printmrg_config.xml" : "\\modules\\iihci\\ui\\printmanage\\printmrg_preview_config.xml"));
            userControl.Dock = DockStyle.Fill;
            userControl.LoadData();
            userControl.Size = this.Panel.Size;
            userControl.Location = this.Panel.Location;
            this.Panel = userControl;

            if (bShowTools)
            {
                PrintChooseView topView = userControl.GetConfig().GetInstance("topView") as PrintChooseView;
                if (topView != null)
                {
                    topView.OwnerView = ordListView;
                    topView.IsEditable = selectedIndex < 1;
                }
            }

            this.bottomView = userControl.GetConfig().GetInstance("bottomView") as PrintPreviewView;
            if (this.bottomView != null)
            {
                this.bottomView.OwnerView = ordListView;
                this.bottomView.SelectedIndex = selectedIndex;
                this.bottomView.LstIdor = lstIdor;
                this.bottomView.LstIdpres = lstIdpres;
                this.bottomView.Id_hp = id_hp;
                this.bottomView.Sd_hptp = sd_hptp;
                this.bottomView.bShowTools = bShowTools;
            }
        }
        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="arg"></param>
        private void PrintManageDialog_Closing(object sender, System.ComponentModel.CancelEventArgs arg)
        {
            try
            {
                this.bottomView.UpdatePrnInfo();
            }
            catch(XapBizException ex)
            {
                this.SetStatusMsg(ex.Message);
            }
            catch (XapServiceException ex)
            {
                this.SetStatusMsg(ex.ErrorMsg == null ? "更新打印状态存在未知错误" : ex.ErrorMsg.Message);
            }
            catch (Exception ex)
            {
                this.SetStatusMsg(ex.Message);
            }
        }
    }
}
