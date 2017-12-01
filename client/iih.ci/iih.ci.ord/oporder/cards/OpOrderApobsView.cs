using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.cards.extend;
using xap.rui.control.forms.control;
using iih.ci.ord.ciorder.utils;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.render;
using xap.cli.sdk.render.labelcontrol;
using xap.rui.appfw;
using xap.rui.control.forms.model;
using xap.rui.control.refcontrol.events;
using iih.ci.ord.ciorder;
using iih.ci.ord.ciorder.viewmodel;
using iih.ci.ord.ciorder.Validate;
using iih.ci.ord.ems.d;
using iih.en.pv.dto.d;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.engine;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.oporder.cards
{
    /// <summary>
    /// 检查医嘱单
    /// </summary>
    /// Author:admin
    /// Date:2015-10-13
    public partial class OpOrderApobsView : CiorderBaseControl
    {
        private  OrderSrvListViewModel model;
        public Ent4BannerDTO ent4BannerDto;//患者信息DTO

        

        CiEmsDTO CiEmsDto { get; set; }
        public OpOrderApobsView()
        {
            model = new  OrderSrvListViewModel("");
            InitializeComponent();
            this.Load += new EventHandler(OrderApobsView_Load);
            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            xapFormControl1.ModelFilled += new EventHandler(xapFormControl1_ModelFilled);
            xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
            //  xapFormControl1.MouseClick += new MouseEventHandler(xapFormControl1_MouseClick);
            this.xapFormControl1.RefFilter += this.OnRefFilter;
            this.SheetName = "门诊检查";
        }

      

        private Point LocationOnClient(System.Windows.Forms.Control c)
        {
            Point retval = new Point(0, 0);
            for (; c.Parent != null; c = c.Parent)
            {
                retval.Offset(c.Location);
            }
            return retval;
        }

        OrSrvForm frm;
        MmForm form;
        void xapFormControl1_DataChanged(object sender, DataChangedEventArgs e)
        {
            //XDataRow row = sender as XDataRow;

            //Point temp = LocationOnClient(this.gv);
            //frm.Location = new Point(temp.X,
            //                          temp.Y + row.ClickCell.Location.Y + row.ClickCell.Size.Height);
            if (e.ClassName == typeof(EmsOrDrug).FullName)
            {
                switch (e.PropName)
                {
                    case "Name_srv":

                        XapDataList<EmsOrSrvSc> list = model.GetSrv("", e.Input.ToString(), ent4BannerDto.Code_entp);
                        frm = new OrSrvForm(list);
                        //frm = new OrSrvForm();
                        frm.DbClickEvent += new OrSrvForm.DbClickHandle(frm_DbClickEvent);

                        frm.Size = new Size(400, 600);
                        frm.StartPosition = FormStartPosition.CenterScreen;

                        frm.TopMost = true;
                        frm.Show(this);
                        break;
                    case "Name_mm":

                        EmsOrDrug orDrug = gv_drug.GetFocusedRow().RowDataSource as EmsOrDrug;
                        XapDataList<EmsOrDrug> Druglist =cof.GetSrvMm(CiHeadDo,orDrug.Id_srv,CiHeadDo.PatInfo.Code_entp);// model.GetBdSrvMM(orDrug.Id_srv);
                        form = new MmForm(Druglist);
                       
                        form.Show();
                        orDrug.Name_mm = form.drugmm.Name_mm;
                        orDrug.Spec_mm = "";
                        orDrug.Name_hp = "医保？";
                        orDrug.Limit = "";
                        orDrug.Price = 22;
                        break;
                    default:
                        break;

                }
            }

        }

     

        void frm_DbClickEvent(OrScArgs obj)
        {
            xapFormControl1.DataChanged -= new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
            EmsOrDrug orDrug = gv_drug.GetFocusedRow().RowDataSource as EmsOrDrug;
            EmsOrSrvSc orsrv = obj.Obj as EmsOrSrvSc;
            orDrug.Name_srv = orsrv.Name_srv;
            orDrug.Id_srv = orsrv.Id_srv;
            xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
            this.frm.Close();
        }
        #region 变量定义区域
        EmsUIDTO CiHeadDo { get; set; }
        XapFormGridControl gv, gv_drug;
        private XLabelBaseUserRender fg_mp_bed;
        #endregion

        #region 构造函数区域

        #endregion

        #region 公开属性区域

        #endregion


        #region 父类继承区域
        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            string[] di = new string[2];
            cof.GetPatDis(CiHeadDo, ref di);
            CiHeadDo.Emsapobs.Id_di = di[0];
            CiHeadDo.Emsapobs.Name_diag = di[1];
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OpOrderApobsView;// "201510130844470704FZ";
            file.FormStyle = FormStyle.Card;
            file.ViewModel = CiHeadDo.Emsapobs;
            this.xapFormControl1.ViewFile = file;
            this.xapFormControl1.SetEditPolicy(true);

        }
        public override void OnRefreshData(ciordems.d.EmsUIDTO headDo, object e)
        {
            if (headDo != null)
            {
                CiHeadDo = headDo;

                //if (headDo.Status == DOStatus.NEW)
                //{
                //    EmsOrDrug or = new EmsOrDrug();
                //    or = cof.DoCopy<EmsOrDrug>(headDo.Emsdrugs.EmsOrDrug.First());
                //    headDo.Emsdrugs.EmsOrDrugList.Add(or);
                //}

            }

            if (this.Created)
            {
                this.LoadData();
            }
        }



        #endregion

        #region 内部事件区域


        private new void OnRefFilter(object sender, RefActivatingEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_di"))
            {

                e.WherePart = " id_ent ='" + CiHeadDo.PatInfo.Id_ent + "'";
                //if (str_id_dis != null)
                //{
                //    e.RefParams.AddParam("Dis", str_id_dis);
                 
                //}
                //if (this.ent4BannerDto != null)
                //{
                //    e.RefParams.AddParam("id_ent", this.ent4BannerDto.Id_ent);
                //}
               
             
            }
        }
        void OrderApobsView_Load(object sender, System.EventArgs e)
        {
            OnInit();
        }
        private void xapFormControl1_FormCreated(object sender, EventArgs e)
        {

            UserRender userRenderFG = xapFormControl1.GetUserRender("ordobs", "fg_mp_bed") as UserRender;
            fg_mp_bed = userRenderFG as XLabelBaseUserRender;
            fg_mp_bed.ValueTextChanged += new EventHandler(fg_mp_bed_ValueChanged);
            gv = xapFormControl1.GetGridView("body");//检查部位

            //gv.
            gv_drug = this.xapFormControl1.GetGridView("drug");// 药品列表

            gv_drug.Visible = false;
            //UserRender btnOK = xapFormControl1.GetUserRender("ordobs", "btnSave");//保存
            //btnOK.MouseClick += new MouseEventHandler(btnOK_MouseClick);

            UserRender btnDel = xapFormControl1.GetUserRender("ordobs", "btnDel");//删除药品
            btnDel.MouseClick += new MouseEventHandler(btnDel_MouseClick);
            btnDel.Visible = false;
            UserRender btnAdd = xapFormControl1.GetUserRender("ordobs", "btnAdd");//添加药品
            btnAdd.MouseClick += new MouseEventHandler(btnAdd_MouseClick);
            btnAdd.Visible = false;

        }








        void fg_mp_bed_ValueChanged(object sender, EventArgs e)
        {
            if (fg_mp_bed != null)
            {
                if (fg_mp_bed.ValueText == "true")
                {
                    //判断表格是否可编辑.
                    gv.ReadOnly = false;
                }
                else
                {
                    gv.ReadOnly = true;
                }
            }

        }





        void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {

            UserRender us = xapFormControl1.GetUserRender("ordobs", "dt_plan");
            xap.cli.sdk.render.Items.XCalendarTimerComboBox dt_begin = us.Renders[0] as xap.cli.sdk.render.Items.XCalendarTimerComboBox;
            DateTime dataA = (LogicEx.GetInstance()).GetServerDataTime();
            dt_begin.MinDate = dataA;
            dt_begin.MaxDate = cof.GetServerDataTime().AddDays(OrdParam.GetOrdParam.orBeforStartDays);


            gv.DataTable.DataSource = CiHeadDo.Emsapobs.EmsOrObsList;
            gv_drug.DataTable.DataSource = CiHeadDo.Emsapobs.EmsOrDrugList;
            if (CiHeadDo.Emsapobs.EmsOrObsList.Count > 0)
                //gv.DataTable.Rows[0].SetMultiSelectStatus(true);
                gv.DataTable.Rows[0].Selected = true;

        }



        void btnDel_MouseClick(object sender, MouseEventArgs e)
        {
            EmsOrDrug orDrug = gv_drug.GetFocusedRow().RowDataSource as EmsOrDrug;
            CiHeadDo.Emsapobs.EmsOrDrugList.Remove(orDrug);
            // this.ShowInfo("删除");
        }

        void btnAdd_MouseClick(object sender, MouseEventArgs e)
        {
            //this.Save(this);
            //this.SendMgs(this);
            CiHeadDo.Emsapobs.EmsOrDrugList.AddNew();

            // this.ShowInfo("添加");
        }



        #endregion

        #region 辅助处理函数
        public override IValidate GetOrdValidate()
        {
            return new OrderApobsValidate();
        }
        #endregion

        #region 状态处理区域

        public new void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            Dictionary<string, Object> dict = eventArgs.Data[UIConst.DATA] as Dictionary<string, Object>;
            switch (uiEvent)
            {
                case UIEvent.LOAD:
                    Dictionary<string, object> dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                    if (dic != null)
                    {
                        if (dic.ContainsKey("PatientData") && dic["PatientData"] != null)
                        {
                            this.ent4BannerDto = (dic["PatientData"] as BannerData).Ent4BannerDTO;
                        }
                    }
                    break;
                default:
                    break;
            }
        }

        #endregion
    }
}
