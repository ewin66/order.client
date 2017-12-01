using System;
using System.Linq;
using System.Windows.Forms;
using iih.bd.fc.orwf.d;
using iih.bd.srv.freqdef.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder;
using iih.ci.ord.ciorder.cards.extend;
using iih.ci.ord.nsorconfirmqry.viewmodel;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.controls.DataView.Model;
using xap.cli.sdk.form;
using xap.cli.sdk.render;
using xap.cli.sdk.render.DoctorOrderCard;
using xap.mw.coreitf.d;
using xap.rui.control.basecontrol;
using xap.rui.control.commands;
using xap.rui.control.engine.attributes;
using xap.rui.control.extentions;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.control;
using xap.rui.control.forms.model;
using xap.rui.control.forms.view;
using xap.rui.control.refcontrol.events;
using xap.rui.engine;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.bd.bc.udi;

/*
********************************************************************************

** 作者： 李程

** 创始时间：2016-6-30

** 修改人：李程

** 修改时间：2016-6-30

** 描述： 医嘱确认查看显示页面


*********************************************************************************
*/

namespace iih.ci.ord.nsorconfirmqry.view
{
    public partial class OrderConfirmView : CiorderBaseControl
    {
        #region 变量定义区域

        private OrConfirm dto;
        private bool flag = true;
        //private FreqDefDO freq;
        //private OrSrvForm frm;
        private XapFormGridControl gv_cost;
        private XapFormGridControl gv_or;
        //private string id_pat;
        //private string iddeps = null;
        private OrderConfirmViewModel model;
        //private XDataRow oldrow;
        private OrConfirm or;
        public XapFormControl xapFormControl;

        #endregion

        #region 构造函数区域

        public OrderConfirmView()
        {
            InitializeComponent();
            xapFormControl = new XapFormControl {Dock = DockStyle.Fill};
            Controls.Add(xapFormControl);
            Load += OrderConfirmView_Load;
            xapFormControl.RefFilter += xapFormControl_RefFilter;
            xapFormControl.FormCreated += xapFormControl_FormCreated;
            xapFormControl.AfterFocused += xapFormControl_AfterFocused;
            xapFormControl.DataChanged += xapFormControl_DataChanged;
            xapFormControl.RefResult += xapFormControl_RefResult;
            xapFormControl.RefCanSelect += xapFormControl_RefCanSelect;
            xapFormControl.ModelFilled += xapFormControl_ModelFilled;
            xapFormControl.AllowEditing += xapFormControl_AllowEditing;
        }

        #endregion

        #region 公开属性区域

        #endregion

        #region 命令区域

        [XapCommand(Name = "Cancel")]
        public void OnCancel()
        {
            this.setFeeEditable(false);
            if (or != null)
            {
                model.GetFeeList(or);
                gv_cost.DataTable.DataSource = model.AddFeeDTOList;
            }
        }

        [XapCommand(Name = "Srvfirm")]
        public void OnaddFee()
        {
            SrvInput();
        }

        #endregion

        #region 父类继承区域

        /// <summary>
        ///     获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            model = new OrderConfirmViewModel(Context.Org.Id_org);
        }

        /// <summary>
        ///     CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            var f = new FormFile();
        
            f.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrderConfirmView_Qry;// "20160818014239481F8F";
            f.FormStyle = FormStyle.Card;
            f.ViewModel = model;
            xapFormControl.ViewFile = f;
            xapFormControl.SetEditPolicy(true);
        }


        public override void OnSelected(object sender, TargetEventArgs e)
        {
            //  base.OnSelected(sender, e);
            dto = e.Object as OrConfirm;
            if (dto != null)
            {
                if (dto.Fg_sign != FBoolean.False || dto.Fg_stop != FBoolean.False || dto.Fg_canc != FBoolean.False)
                {
                    model.GetOrConfirmList(dto);
                    model.GetFeeList(null);
                }
                else
                {
                    model.OrderList.Clear();
                    model.GetFeeList(null);
                }
                OnFillData();
                if (xapFormControl.Created)
                {
           //         xapFormControl.CloseTiol(true);
                }
            }
        }

        public override bool CanClose()
        {
            return true;
        }

        public override void OnStatus()
        {
            if (gv_or != null && gv_or.SelectedRowsCount != 0)
            {
             
                SetEnable("Srvfirm", true);
            }
            else
            {
               
                SetEnable("Srvfirm", false);
            }

            if (this.xapFormControl != null && this.xapFormControl.IsEditable)
            {
                SetEnable("Cancel", true);
            }
            else
            {
                SetEnable("Cancel", false);
            }
        }

        #endregion

        #region 内部事件区域

        private void xapFormControl_ModelFilled(object sender, EventArgs e)
        {
            if (model.OrderList.Count() == 0)
            {
                // this.SetStatusMsg("没有查询到数据");   -- 周总 提的 Bug 去掉状态栏的提示，没有查到数据界面已经很明显了，所以不需要提示 -- add by wqz
            }
            else
            {
                model.getdepSrvInfo(Context.Org.Id_org, Context.Dept.Id_dep);
            }

            this.setFeeEditable(false);
        }

        private void xapFormControl_RefCanSelect(object sender, RefCanSelectEventArgs e)
        {
            //throw new NotImplementedException();
            if (e.BindingFieldName.Equals("Name_srv"))
            {
                var name = (string) e.SelectingData["Name"];

                int i = 0;
                foreach (AddFeeDTO routeDo in model.AddFeeDTOList)
                {
                    if (routeDo.Name_srv == name)
                    {
                        i++;
                        if (i == 1)
                        {
                            e.Cancel = true;
                            e.Message = string.Format("因为重复，您选中的数据'{0}'禁止选中！",
                                (e.SelectingData == null) ? "Null" : e.SelectingData.DisplayText);
                            break;
                        }
                    }
                }
            }
            else if (e.BindingFieldName.Equals("Name_mm"))
            {
                var name = (string) e.SelectingData["Name"];

                int i = 0;
                foreach (AddFeeDTO routeDo in model.AddFeeDTOList)
                {
                    if (routeDo.Name_mm == name)
                    {
                        i++;
                        if (i == 1)
                        {
                            e.Cancel = true;
                            e.Message = string.Format("因为重复，您选中的数据'{0}'禁止选中！",
                                (e.SelectingData == null) ? "Null" : e.SelectingData.DisplayText);
                            break;
                        }
                    }
                }
            }
        }

        private void xapFormControl_RefFilter(object sender, RefActivatingEventArgs e)
        {
            var drug = e.DataObject as AddFeeDTO;
            if (e.BindingFieldName.Equals("Name_mm"))
            {
                e.WherePart = " bd_mm.id_srv  = '" + drug.Id_srv + "'";
            }

            if (e.BindingFieldName.Equals("Name_srv"))
            {
                //  this.FireSelected(this.model.orConfirm);
                if (or != null && or.Id_hp != null)
                    e.RefParams.AddParam("hp", or.Id_hp);
                string sql = model.srvScopeSql;
                if (sql != null)
                {
                    e.WherePart = sql;
                }
            }
            if (e.BindingFieldName.Equals("Name_mp_dep"))
            {
                var drugs = e.DataObject as EmsOrDrug;
                OrWfExDeptDTO[] ow = null;
                string depis = "";
                if (drugs != null)
                {
                    ow = model.getMpDept(drugs, or);
                }
                if (ow != null)
                {
                    foreach (OrWfExDeptDTO o in ow)
                    {
                        depis += "'" + o.Id_dept + "',";
                    }

                    e.WherePart = " bd_dep.id_dep in (" + depis.Substring(0, depis.Count() - 1) + ")";
                }
            }
            if (e.BindingFieldName.Equals("Name_freq"))
            {
                //if (freq != null && freq.Sd_frequnitct.Equals(BdSrvDictCodeConst.SD_FREQUNIT_ONCE))
                //{
                //    e.Cancel = true;
                //}
                //else
                {
                    e.Cancel = false;
                    e.WherePart = " bd_freq.fg_active ='Y'";
                }
            }
        }

        private void xapFormControl_RefResult(object sender, RefResultEventArgs e)
        {

            if (e.BindingFieldName.Equals("Name_bed"))
            {
    
            }
            else if (e.BindingFieldName.Equals("Name_dep_nur"))
            {

            }
            if (e.BindingFieldName.Equals("Name_srv"))
            {
               
                var drugs = e.DataObject as AddFeeDTO;
                if (drugs == null || drugs.Id_srv == null)
                    return;
                //OrWfExDeptDTO[] ow = null;
                //string depis = "";

                //如果频次为临时 则不修改频次
                //if (freq != null && freq.Sd_frequnitct.Equals(BdSrvDictCodeConst.SD_FREQUNIT_ONCE))
                //{
                //    drugs.Id_freq = freq.Id_freq;
                //    drugs.Name_freq = freq.Name;
                //}
                if (drugs != null)
                {
                    model.getEmsdrug(drugs, or);
                }
            }
        }

        private void OrderConfirmView_Load(object sender, EventArgs e)
        {
            OnInit();
        }

        private void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            xapFormControl.SetToilHeight(150);
            var pageCommands = new PageCommands();
            pageCommands.TabCode = "ordlist"; //页签编码"cost";//

            gv_or = xapFormControl.GetGridView("ordlist");
            gv_cost = xapFormControl.GetGridView("cost");
            gv_or.DataTable.DataDisplay += tabControl_DataDisplay;
            gv_cost.ReadOnly = false;

            gv_or.DataTable.Rows.DefaultHeight = 36;
            //增加自定义按钮
            var pageComds = new PageCommands();
            pageComds.TabCode = "cost";
            var cmd1 = new XapCommand
            {
                Command = "删除",
                Enabled = false,
                Visible = false,
                ExecuteHandler = Ondeletetime,
            };

            pageComds.Commands.Add(cmd1);

            var cmd = new XapCommand
            {
                Command = "新增",
                Enabled = false,
                Visible = false,
                ExecuteHandler = OnAddtime,
            };
            pageComds.Commands.Add(cmd);

            var cmd2 = new XapCommand
            {
                Command = "保存",
                Enabled = false,
                Visible = false,
                ExecuteHandler = OnSavetime,
            };
            pageComds.Commands.Add(cmd2);
            xapFormControl.SetupCommands(new[] {pageComds});
        }

        private void Ondeletetime(object sender, EventArgs e)
        {
            AddFeeDTO[] ors = xapFormControl.GetSelected<AddFeeDTO>("cost");
            if (ors != null && ors.Count() > 0)
            {
                int i = model.AddFeeDTOList.IndexOf(ors[0]);
                if (iscontainSrv(ors[0].Id_srv))
                    model.deletefee(ors[0]);
            }
        }

        private void OnAddtime(object sender, EventArgs e)
        {
            var feeDto = new AddFeeDTO();
            if (or != null)
            {
                feeDto.Id_hp = or.Id_hp;

                //if (freq != null && freq.Sd_frequnitct.Equals(BdSrvDictCodeConst.SD_FREQUNIT_ONCE))
                //{
                //    feeDto.Id_freq = freq.Id_freq;
                //    feeDto.Name_freq = freq.Name;
                //}
            }
            model.AddFeeDTOList.Add(feeDto);
        }

        private void OnSavetime(object sender, EventArgs e)
        {
            save();
        }

        private void tabControl_DataDisplay(Object sender, XDataDisplayEventArgs e)
        {
            var row = sender as XDataRow;
            if (row != null)
            {
                foreach (UserRender render in row.UserRenderList)
                {
                    if (render is DoctorOrderCard)
                    {
                        var card = render as DoctorOrderCard;


                        card.ConfigPath = "\\modules\\iihci\\ui\\commoncontent\\OrderContent.xml";
                    }
                }
            }
        }

        private void xapFormControl_DataChanged(object sender, DataChangedEventArgs e)
        {
            if (e.PropName == "Quan_med")
            {
                if (gv_cost.GetFocusedRow() != null)
                {
                    var drg = gv_cost.GetFocusedRow().RowDataSource as AddFeeDTO;
                    if (drg != null)
                        drg.Amt_cur = drg.Price*drg.Quan_med;
                }
            }
        }

        private void xapFormControl_AfterFocused(object sender, DataFocusedEventArgs e)
        {
            var oc = e.Data as OrConfirm;

            if (oc != null)
            {
                if (or == null || (or != null && or.Id_confirm != oc.Id_confirm))
                {
                    if (model.IsDrugEdit() && !flag)
                    {
                        if (MessageBoxEx.Show("是否保存修改？", "提示", MessageBoxButtons.YesNo) !=
                            DialogResult.No)
                        {
                            save();
                        }
                        flag = true;
                        //    xapFormControl.CloseTiol(flag);
                        model.AddFeeDTOList.Clear();
                     
                    }
                    else
                    {
                        flag = true;
                        //      xapFormControl.CloseTiol(flag);
                        model.AddFeeDTOList.Clear();

                    }

                    model.GetFeeList(oc);
                    gv_cost.DataTable.DataSource = model.AddFeeDTOList;
                    or = oc;
                    setFeeEditable(false);
                }
            }
        }

        private void xapFormControl_AllowEditing(object sender, AllowEditingEventArgs e)
        {
            var drug = e.Object as AddFeeDTO;
            // ************查询服务是否在可录入范围内*****************
            if (drug != null)
            {
                if (!iscontainSrv(drug.Id_srv))
                {
                    e.Cancel = true;
                }
                else
                {
                    e.Cancel = false;

                    if (e.PropName.Equals("Name_mm"))
                    {
                        if (drug.Fg_mm == false)
                            // ************设置物品为不可录入*****************
                            e.Cancel = true;
                    }
                }

                if (e.PropName.Equals("Name_mm"))
                {
                    if (drug.Id_srv == null)
                        // ************设置物品为不可录入*****************
                        e.Cancel = true;
                }
            }
        }

        #endregion

        #region 辅助处理函数

        /// <summary>
        ///     **************************************************** 物品保存
        /// </summary>
        private bool save()
        {
            bool isvalidate = true;
            if (validate())
            {
                isvalidate = false;
                return isvalidate;
            }
            model.savedrug(or.Id_confirm);
            gv_cost.DataTable.DataSource = model.AddFeeDTOList;
           this.setFeeEditable(true);
            return isvalidate;
        }

        /// <summary>
        ///     *******************************************************************保存校验
        /// </summary>
        /// <returns></returns>
        public bool validate()
        {
            bool flag = false;
            foreach (AddFeeDTO feeDto in model.AddFeeDTOList)
            {
                if (feeDto.Id_srv == null)
                {
                    this.ShowAlert("服务项目不能为空");
                }
                if ((feeDto.Quan_med == null || feeDto.Quan_med == 0) && feeDto.Fg_mm == FBoolean.True)
                {
                    this.ShowAlert("单次数量不能为空");
                    flag = true;
                    break;
                }
                if (feeDto.Id_dep == null)
                {
                    this.ShowAlert("执行科室不能为空");
                    flag = true;
                    break;
                }
            }
            return flag;
        }



        /// <summary>
        ///     ***************************************************************************按钮补费
        /// </summary>
        private void SrvInput()
        {
            setFeeEditable(true);
        }

        private bool iscontainSrv(string idsrv)
        {
            bool flag = false;
            if (idsrv == null) return true;
            if (model.srvScope != null)
            {
                foreach (string s in model.srvScope)
                {
                    if (s == idsrv)
                    {
                        flag = true;
                        break;
                    }
                }
            }
            return flag;
        }

        private void setFeeEditable(bool flag)
        {

            xapFormControl.SetEditPolicy(flag, new[]
                {
                    new DataPolicy
                    {
                        AllowEdit = flag,
                        FullEdit = flag,
                        ClassName = "iih.ci.ord.ciordems.d.AddFeeDTO",
                        AllowNew = flag,
                        AutoNewRow = false,
                        AllowRemove = flag,
                        AllowSave = flag
                    }
                });
        }
        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            var uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            switch (uiEvent)
            {
                case UIEvent.CANCEL:
                    OnCancel();
                    break;
                case "Srvfirm":
                    OnaddFee();
                    break;
            }
        }

        #endregion

       
    }
}