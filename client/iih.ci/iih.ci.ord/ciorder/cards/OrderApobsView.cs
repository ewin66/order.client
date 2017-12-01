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
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.ci.ord.ciorder.Validate;
using iih.ci.ord.ems.d;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.render;
using xap.cli.sdk.render.labelcontrol;
using xap.rui.appfw;
using xap.rui.control.extentions;
using xap.rui.control.forms.model;
using xap.rui.control.refcontrol.events;
using iih.ci.ord.emsdi.d;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciorder.cards
{
    /// <summary>
    /// 检查医嘱单
    /// </summary>
    /// Author:admin
    /// Date:2015-10-13
    public partial class OrderApobsView : CiorderBaseControl
    {
        
        #region 变量定义区域
        EmsUIDTO CiHeadDo { get; set; }

        CiEmsDTO CiEmsDto { get; set; }

        viewmodel.OrderSrvListViewModel model;
        LogicEx logicEx = LogicEx.GetInstance();
        string idDepMps;

        XapFormGridControl gv, gv_drug;
        XLabelBaseUserRender fg_mp_bed;
        #endregion
        public OrderApobsView()
        {
            model = new viewmodel.OrderSrvListViewModel("");
            InitializeComponent();
            this.Load += new EventHandler(OrderApobsView_Load);
            xapFormControl1.FormCreated += xapFormControl1_FormCreated;
            xapFormControl1.ModelFilled += xapFormControl1_ModelFilled;
            xapFormControl1.DataChanged +=new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
           
            SheetName = "检查医疗单";
        }
        void xapFormControl1_AllowEditing(object sender, AllowEditingEventArgs e)
        {
            EmsObsLap obs = e.Object as EmsObsLap;
            // 只读情况，表格不可以编辑;
           
            if (this.IsReadOnly||e.PropName.ToLower().Equals("name_srv"))
            {
                e.Cancel = true;
            }
            else if (e.PropName == "Name_body")
            {
                //if (obs != null)
                //    e.Object.SetPropValue("Name_body", obs.Name_body);
                e.Cancel = true;
            }
            else if (e.PropName.Equals("Name_pos"))
            {
                //if (obs != null)
                    // e.Cancel = (obs.Fg_pos == null || !obs.Fg_pos.Value);
                    e.Cancel = true;
            }
            
        }
        void xapFormControl1_RefFilter(object sender, RefActivatingEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_mp_dep") && !string.IsNullOrWhiteSpace(idDepMps))
            {
                e.WherePart = string.Format("id_dep in ({0})", idDepMps);
            }else if(e.BindingFieldName.Equals("Name_diag")){
                e.RefParams.AddParam("id_ent",CiHeadDo.PatInfo.Id_ent);
            }
        }

        public override IValidate GetOrdValidate()
        {
            return  new OrderApobsValidate();
        }


        public override void SaveBefore()
        {
            xapFormControl1.SaveForm();
            CiHeadDo.Emsapobs.EmsOrObsList = this.xapFormControl1.GetSelected<EmsObsLap>("body");
            foreach (EmsObsLap obslap in CiHeadDo.Emsapobs.EmsOrObsList)
            {
                obslap.Fg_chk = true;
            }
            CiHeadDo.Emsapobs.EmsOrDrugList = (XapDataList<EmsOrDrug>)gv_drug.DataTable.DataSource;
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

        //OrSrvForm frm;
       //MmForm form;
        void xapFormControl1_DataChanged(object sender, DataChangedEventArgs e)
        {
            if (e.PropName.ToLower().Equals("fg_mp_bed"))
            {
               //判断表格是否可编辑.
               gv.ReadOnly = !(bool)e.Input;
            }
            else if (e.PropName.Equals("Dt_plan")) {
                EmsHeadDO.Dt_begin_ui = EmsHeadDO.Emsapobs.Dt_plan;//同步开始时间
            }
        }

     

        void frm_DbClickEvent(OrScArgs obj)
        {
            xapFormControl1.DataChanged -= new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
            EmsOrDrug orDrug = gv_drug.GetFocusedRow().RowDataSource as EmsOrDrug;
            EmsOrSrvSc orsrv = obj.Obj as EmsOrSrvSc;
            orDrug.Name_srv = orsrv.Name_srv;
            orDrug.Id_srv = orsrv.Id_srv;
           
           // this.frm.Close();
        }
       

        #region 父类继承区域
        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            if (CiHeadDo.IsNEW && string.IsNullOrEmpty(CiHeadDo.Emsapobs.Id_di))
            {                
                string[] di = new string[2];
                cof.GetPatDis(CiHeadDo, ref di);
                CiHeadDo.Emsapobs.Id_di = di[0];
                CiHeadDo.Emsapobs.Name_diag = di[1];             
            }

            // 获取医嘱流向科室数据
            OrWfDeptInfoDTO wf = new viewmodel.impext.GetDeptMpImp().GetDept_mp_ids(CiHeadDo.PatInfo.Code_entp, CiHeadDo.PatInfo.Id_entp, CiHeadDo.MedSrvDO.Sd_srvtp, CiHeadDo.MedSrvDO.Id_srvca, CiHeadDo.MedSrvDO.Id_srv, CiHeadDo.MedSrvDO.Id_route, "id_mm", CiHeadDo.PatInfo.Id_dep_nur, CiHeadDo.PatInfo.Id_dep_phy);
            idDepMps = wf == null ? "" : wf.Id_mp_depts;
           
            // 新建时默认选中第一个执行科室
            if (CiHeadDo.IsNEW)
            {
                CiHeadDo.Emsapobs.Id_mp_dep = wf == null ? "" : wf.Firstid_mp_dept;
                CiHeadDo.Emsapobs.Name_mp_dep = wf == null ? "" : wf.Firstname_mp_dept; ;
            }
            if (gv != null)
            {
                gv.DataTable.DataSource = null;
            }
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrderApobsView;// "201510130844470704FZ";
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
                CiEmsDto = e as CiEmsDTO;
            }

            if (this.Created)
            {
                this.LoadData();
            }
        }

        #endregion

        #region 内部事件区域
        void OrderApobsView_Load(object sender, System.EventArgs e)
        {
            OnInit();
        }
        private void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            xapFormControl1.RefFilter += xapFormControl1_RefFilter;
            xapFormControl1.AllowEditing += xapFormControl1_AllowEditing;

            fg_mp_bed = xapFormControl1.GetUserRender("ordobs", "fg_mp_bed") as XLabelBaseUserRender;
            
            //fg_mp_bed.ValueTextChanged += new EventHandler(fg_mp_bed_ValueChanged);
            gv = xapFormControl1.GetGridView("body");//检查部位
            
            gv_drug = this.xapFormControl1.GetGridView("drug");// 药品列表
            gv_drug.Visible = false;
           
            xapFormControl1.GetUserRender("ordobs", "checkdrug").Visible = false; //隐藏检查药品

            UserRender btnDel = xapFormControl1.GetUserRender("ordobs", "btnDel");//删除药品
            btnDel.MouseClick += new MouseEventHandler(btnDel_MouseClick);
            UserRender btnAdd = xapFormControl1.GetUserRender("ordobs", "btnAdd");//添加药品
            btnAdd.MouseClick += new MouseEventHandler(btnAdd_MouseClick);
            btnDel.Visible = false;
            btnAdd.Visible = false;

           // SetGridPolicy(true);
        }



        void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {
            SetGridPolicy(!IsReadOnly);
           
            
            fg_mp_bed.Visible = (CiHeadDo.Emsapobs.Fg_mp_bed != null && (bool)CiHeadDo.Emsapobs.Fg_mp_bed);
           
            //限制开始时间的时间范围，入院日期，最大提前日期
           TimerComboBoxMaxAndMin.GetInstance().setMaxMinTime(xapFormControl1, this.Context, "ordobs", "dt_plan", EmsHeadDO.PatInfo.Id_ent); 
            gv.DataTable.DataSource = CiHeadDo.Emsapobs.EmsOrObsList;
            gv.DataTable.Enabled = true;

            bool allSelectAll = false;
            //如果为套服务，根据fg_edit当BD_SRVSET_DEF.fg_edit可选标志=false时，
            //服务列表为选中状态，且checkbox置灰，不可编辑，
            //反之是true时，checkbox默认为选中状态，用户可编辑
            if (this.CiHeadDo.MedSrvDO.Fg_set == true)
            {
                for (int i = 0; i < CiHeadDo.Emsapobs.EmsOrObsList.Count; i++)
                {
                    if (CiHeadDo.Emsapobs.EmsOrObsList[i].Fg_edit == null ||
                                                !(bool)CiHeadDo.Emsapobs.EmsOrObsList[i].Fg_edit)
                    {
                        gv.DataTable.Rows[i].Selected = true;
                        gv.DataTable.Rows[i].Enabled = false;
                    }
                    else
                    {
                        gv.DataTable.Rows[i].ColumnCellDict["Name_body"].Font = new System.Drawing.Font("微软雅黑", 10F,
                            FontStyle.Italic);
                        allSelectAll = true;
                    }
                    if (CiHeadDo.Emsapobs.EmsOrObsList[i].Fg_chk != null && CiHeadDo.Emsapobs.EmsOrObsList[i].Fg_chk.Value)
                    {
                        gv.DataTable.Rows[i].Selected = true;
                    }     
                }
            }
            else
            {
                //非套服务 fg_body_update部位可修改标志=ture时，部位列字体置灰并斜体，
                //用户鼠标点进去后，部位名称值清空，用户可手工录入部位。体位列可在下拉列表里重新选择。
                //否则 =false时，部位列和体位列为只读不可修改。
                for (int i = 0; i < CiHeadDo.Emsapobs.EmsOrObsList.Count; i++)
                {

                    
                    if (CiHeadDo.Emsapobs.EmsOrObsList[i].Fg_body_update == null ||
                        !(bool) CiHeadDo.Emsapobs.EmsOrObsList[i].Fg_body_update)
                    {
                        gv.DataTable.Rows[i].Selected = true;
                        gv.DataTable.Rows[i].Enabled = false;
                    }
                    else
                    {
                        gv.DataTable.Rows[i].ColumnCellDict["Name_body"].Font = new System.Drawing.Font("微软雅黑", 10F,
                            FontStyle.Italic);
                        allSelectAll = true;
                       
                    }
                    if (CiHeadDo.Emsapobs.EmsOrObsList[i].Fg_chk.Value)
                    {
                        gv.DataTable.Rows[i].Selected = true;
                    }
                }
            }
            gv_drug.DataTable.DataSource = CiHeadDo.Emsapobs.EmsOrDrugList;
            gv.AllowSelectAll(allSelectAll);
            if (this.IsReadOnly)
            {
                gv.DataTable.Enabled = false;
            }

            // 设置默认焦点位置
            xapFormControl1.GetUserRender("ordobs", "des_pps").Focus();
         

        }
       


        void btnDel_MouseClick(object sender, MouseEventArgs e)
        {
            EmsOrDrug orDrug = gv_drug.GetFocusedRow().RowDataSource as EmsOrDrug;
            CiHeadDo.Emsapobs.EmsOrDrugList.Remove(orDrug);
         
        }

        void btnAdd_MouseClick(object sender, MouseEventArgs e)
        {
            
            CiHeadDo.Emsapobs.EmsOrDrugList.AddNew();

        }



        #endregion

        #region 辅助处理函数
        private void SetGridPolicy(bool flag)
        {
            DataPolicy policy = new DataPolicy();
            //policy.ClassName = "iih.ci.ord.ciordems.d.EmsObsItemDO";
            //policy.AllowNew = flag;
            policy.AllowEdit = flag;
            //policy.AllowRemove = flag;
            //policy.AllowSave = false;
            policy.FullEdit = flag;
            //policy.HideOther = true;
            //policy.MultiSelect = true;

            xapFormControl1.SetEditPolicy(flag, new DataPolicy[1] { policy });

          
        }
        #endregion

       
    }
}
