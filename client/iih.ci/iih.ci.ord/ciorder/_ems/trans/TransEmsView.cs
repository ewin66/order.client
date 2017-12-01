using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.viewmodel;
using xap.mw.core.data;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using iih.ci.ord.ciorder.ems;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciorder._ems.trans {
    /// <summary>
    /// 转科医疗单视图类
    /// 
    /// author:刘晓颖, zhou_zhijian li_zheng
    /// </summary>
    public class TransEmsView : EmsViewBase {

        #region 成员变量
        private const string EMS_DEFAULT_CAPTION = "转科医疗单";
        /// <summary>
        /// 
        /// </summary>
        private xap.rui.control.forms.view.XapFormControl xapFormControl1;
        /// <summary>
        /// 
        /// </summary>
        private FormFile file = new FormFile();
        /// <summary>
        /// 
        /// </summary>
        private TransEmsModel model; 
        #endregion

        #region 构造及初始化
        public TransEmsView() {
            InitializeComponent();
            xapFormControl1.Load += new EventHandler(xapFormControl1_Load);
            xapFormControl1.RefFilter += new EventHandler<xap.rui.control.refcontrol.events.RefActivatingEventArgs>(xapFormControl1_RefFilter);
            SheetName = EMS_DEFAULT_CAPTION;

            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_TransEmsView;// "20151128070645227IVM";
            file.FormStyle = FormStyle.Card;
            xapFormControl1.SetEditPolicy(true);
        }

        private void InitializeComponent() {
            this.SuspendLayout();
            this.xapFormControl1 = new xap.rui.control.forms.view.XapFormControl();
            this.xapFormControl1.AutoSize = true;
            //this.xapFormControl1.AutoValidate = System.Windows.Forms.AutoValidate.EnableAllowFocusChange;
            //this.xapFormControl1.CanShowing = null;
            this.xapFormControl1.Context = null;
            this.xapFormControl1.File = null;
            this.xapFormControl1.Dock = DockStyle.Fill;
            this.xapFormControl1.Location = new System.Drawing.Point(3, 3);
            this.xapFormControl1.Name = "xapFormControl1";
            // 
            // OrderTransView
            // 
            //this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.xapFormControl1);
            this.Name = "TransEmsView";
            this.Size = new System.Drawing.Size(521, 310);
            this.ResumeLayout(false);
        }

        #endregion

        #region 事件处理函数
        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xapFormControl1_Load(object sender, EventArgs e) {
            this.OnInit();
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xapFormControl1_RefFilter(object sender, xap.rui.control.refcontrol.events.RefActivatingEventArgs e) {
            string fieldName = e.BindingFieldName;
            if ("Name_dep_nur_to".Equals(fieldName)) {
                string id_dep = CiHeadDo.Emsaptrans.Id_dep_to;
                if (id_dep == null) return;
                string nurids = model.getNurAreaOfDep(id_dep);
                if (nurids == null) return;
                e.WherePart = string.Format("id_dep in ({0})", nurids);
            }
        }
        #endregion

        #region 父类覆写函数

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData() {
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData() {
            file.ViewModel = CiHeadDo.Emsaptrans; // 新的
            this.xapFormControl1.ViewFile = file;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="headDo"></param>
        /// <param name="e"></param>
        public override void OnRefreshData(EmsUIDTO headDo, object e) {
            if (headDo != null) {
                CiHeadDo = headDo;
            }

            if (this.Created) {
                this.LoadData();
            }
        }

        #endregion

        #region 属性

        /// <summary>
        /// 
        /// </summary>
        public EmsUIDTO CiHeadDo { get; set; }

        /// <summary>
        /// 
        /// </summary>
        public TransEmsModel Model {
            get { return model; }
            set { model = value; }
        }

        #endregion

        //public override void LoadView() {
            
        //}

  //      if (status == DOStatus.NEW) {
  //                                      orDataBing.AddCommonHeadDataBing(emsDO, med);
  //                                      orDataBing.AddTransDataBing(emsDO, med);
  //                                      emsDO.MedSrvDO = med;
  //                                  }
  //                                  else {
  //                                      orCiEmsToUiEms.EditEmsTrans(emsDO, dto);
  //                                  }
  //                                  emsDO.EmsType = EmsType.TRANSDEPT;
  //                                  //ctlKey = srvTp + "trans";
  //                                  if (currentEmsControl == null) {
  //                                      currentEmsControl = new OrderTransView() { Dock = DockStyle.Fill };
  //                                  }
  //                                  break;

  //if (med != null) {
  //              SheetName = med.Name;
  //          }


  //   emsDO.IsOpData = false;
  //              if (orderItemView != null)
  //                  orderItemView.SetTabText(currentEmsControl.SheetName);
  //              emsDO.PatInfo = dto;
  //              currentEmsControl.OnRefreshData(emsDO, this.dto);//数据传递给 医嘱表单
  //              //为医疗单传Context对象
  //              currentEmsControl.Context = this.Context;
  //              currentEmsControl.EmsHeadDO = emsDO;
  //              currentEmsControl.CiEmsDTO = this.dto;
  //              ciControl.Add(currentEmsControl, SheetName);
  //              currentEmsControl.Dock = DockStyle.None;
  //              this.splitContainer1.AddControl(currentEmsControl, xap.cli.sdk.controls.ControlPosition.Center);

    }

}
