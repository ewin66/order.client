using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using iih.bd.srv.ortpl.d;
using xap.cli.sdk.render;
using xap.rui.control.forms.model;
using xap.rui.control.inputmethod;
using iih.ci.ord.opemergency.viewmodel;
using xap.rui.appfw;
using iih.ci.diag.dto.d;
using xap.rui.engine;
using xap.cli.sdk.form;
using iih.en.pv.dto.d;
using xap.rui.engine.xactions.standard;
using xap.rui.engine.eventbroker;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.opemergency.ems.common;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.common.log;

namespace iih.ci.ord.opemergency.orddi
{
    /*
    * 门急诊医生工作站- 【诊断维护】视图
    */
    public partial class OrdDiOpenDialog : XSingleDialog, ICallbackAction
    {
        #region 公有属性
        // Banner 上的诊断信息 模型对象
        public Ent4BannerDTO Ent4BannerDto { set; get; }
       
        #endregion
        #region 私有变量
        

        /// <summary>
        /// 消息接收主体对象
        /// </summary>
        private Object msgOwner = null;

        // Xml 配置UI 控件
        private XUserControl xUserControl = new XUserControl();

        private bool isOrdersEmpty;
        #endregion
        #region 构造方法
        public OrdDiOpenDialog(Object owner, Ent4BannerDTO ent4BannerDTO, bool isOrdersEmpty)
        {
            msgOwner = owner;

            this.Ent4BannerDto = ent4BannerDTO;
            this.isOrdersEmpty = isOrdersEmpty;

            this.Formsize = FormSize.Custom;
            this.Size = new Size(766, 596);
            this.Panel.Size = this.Size;
            this.Load += new EventHandler(xapFormControl_Load);
            this.Text = "诊断管理";
            this.HasbtnBackRec = false;
            
        }
        #endregion
        #region 事件处理

        private void xapFormControl_Load(object sender, EventArgs e)
        {

            xUserControl.Init(Application.StartupPath+"\\modules\\iihci\\ui\\opdimodifydialog\\opdimodifydialog_config.xml");

            // 此处不能设置为 Fill 方式，否则 xUserControl 会充满整个窗体，
            // 会将其他通过代码创建的控件全部遮挡
            xUserControl.Dock = DockStyle.Fill;
            xUserControl.Location = this.Panel.Location;
            xUserControl.Size = this.Panel.Size;
            
            DiListView diListView = xUserControl.GetConfig().GetInstance("DiListView") as DiListView;
            if (diListView != null)
            {
                diListView.IsOrdersEmpty = this.isOrdersEmpty;
                diListView.SetOwnerControl(msgOwner as XapBaseControl);
                diListView.SetCallbackAction(this);
                diListView.SetEnt4BannerDTO(this.Ent4BannerDto);
            }

            this.Panel = xUserControl;

            // 触发执行表单中的 onLoadData 和 onFillData 方法
            xUserControl.LoadData();
        }

        

        

        #endregion
        #region 辅助方法
        public Object GetOwnerControl()
        {
            return msgOwner;
        }

        public void OnAddAction(object param = null)
        {
            
        }

        public void OnDeleteAction(object param = null)
        {
           
        }

        public void OnSaveAction(object param = null)
        {
           
        }

        public void OnCancelAction(object param = null)
        {
            this.Close();
        }


        #endregion
    }


}
