using System;
using System.Linq;
using System.Windows.Forms;
using iih.bd.srv.freqdef.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.viewmodel;
using iih.ci.ord.newconfirm.view.baseview;
using iih.ci.ord.newconfirm.viewmodel.bp;
using xap.rui.control.basecontrol;
using xap.rui.control.commands;
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

** 描述： 医嘱确认显示页面


*********************************************************************************
*/

namespace iih.ci.ord.ciorder.view
{
    public partial class OrderConfirmFeeView : FeeInpputBaseView
    {
        #region 变量定义区域



        private readonly string gvcost = "cost";
        private readonly XapFormControl xapFormControl;
        private XapFormGridControl gv_cost;
        private OrderConfirmFeeViewModel model;
        private OrConfirm orcofirm;

        #endregion

        #region 构造函数区域

        public OrderConfirmFeeView()
        {
            InitializeComponent();
            xapFormControl = new XapFormControl {Dock = DockStyle.Fill};
            Controls.Add(xapFormControl);
            Load += OrderConfirmView_Load;
            xapFormControl.RefFilter += xapFormControl_RefFilter;
            xapFormControl.FormCreated += xapFormControl_FormCreated;
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

        #endregion

        #region 父类继承区域

        /// <summary>
        ///     获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            model = new OrderConfirmFeeViewModel(orcofirm,this.xapFormControl);
        }

        /// <summary>
        ///     CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            var f = new FormFile();
            f.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrderConfirmFeeView;// "20161026093208449000";
            f.FormStyle = FormStyle.Card;
            f.ViewModel = model;
            xapFormControl.ViewFile = f;
        }


        public override void OnSelected(object sender, TargetEventArgs e)
        {
           var orcofir = e.Object as OrConfirm;

            if (orcofir != null )
            {
                if (orcofir.Id_confirm != null)
                {
                    orcofirm = orcofir;
                    model.GetFeeList(orcofirm);
                    OnFillData();
                }
                else
                {
                    this.reFreshData();
                }
                this.FireSelected(this);
            }
            else
            {
                ConfirmEvent uiEvent = e.Object as ConfirmEvent;
                if(uiEvent==null)
                    return;
                if (uiEvent.UIEVENT == "addfee")
                {
                    this.setFeeEditable(true);
                }else if (uiEvent.UIEVENT == "uneditable")
                {
                    this.setFeeEditable(false);
                }
            }
        }

        public override bool CanClose()
        {
            return true;
        }

        public override void OnStatus()
        {
        }

        public override bool IsCancel()
        {
            return this.xapFormControl.IsModified;
        }

        public override void CancelFee()
        {
            reFreshData();
            this.setFeeEditable(false);
        }

        #endregion

        #region 内部事件区域

        private void xapFormControl_ModelFilled(object sender, EventArgs e)
        {
            model.getdepSrvInfo(Context.Org.Id_org, Context.Dept.Id_dep);
        }

        private void xapFormControl_RefCanSelect(object sender, RefCanSelectEventArgs e)
        {
            //throw new NotImplementedException();
           this.model.HandleRefCanSelect(sender,e);
        }

        private void xapFormControl_RefFilter(object sender, RefActivatingEventArgs e)
        {
            FreqDefDO freq = null;
            if (orcofirm != null)
            {
                freq = model.GetDefDo(orcofirm.Id_freq);
            }
            model.HandleRefFilter(sender, e, orcofirm, freq);
        }

        private void xapFormControl_RefResult(object sender, RefResultEventArgs e)
        {
            FreqDefDO freq = null;
            if (orcofirm != null)
            {
                freq = model.GetDefDo(orcofirm.Id_freq);
            }
            model.HandleRefResult(sender, e, orcofirm, freq);
        }

        private void OrderConfirmView_Load(object sender, EventArgs e)
        {
            OnInit();
        }

        private void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            gv_cost = xapFormControl.GetGridView(gvcost);

            gv_cost.ReadOnly = false;

            //增加自定义按钮
            var pageComds = new PageCommands();
            pageComds.TabCode = gvcost;
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


        private void xapFormControl_AllowEditing(object sender, AllowEditingEventArgs e)
        {
            model.HandleAllowEditing(sender, e);
        }

        #endregion

        #region 辅助处理函数

        private void setFeeEditable(bool flag2)
        {
            xapFormControl.SetEditPolicy(flag2, new[]
            {
                new DataPolicy
                {
                    AllowEdit = flag2,
                    FullEdit = flag2,
                    ClassName = "iih.ci.ord.ciordems.d.AddFeeDTO",
                    AllowNew = flag2,
                    AutoNewRow = false,
                    AllowRemove = flag2,
                    AllowSave = flag2
                }
            });
        }

        private void reFreshData()
        {
    
            model.GetFeeList(null);
            OnFillData();
            setFeeEditable(false);
        }

        private void addfee()
        {
          //  setFeeEditable(true);

        }

        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            var uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            switch (uiEvent)
            {
                case "Srvfirm":
                    addfee();
                    break;
                case "Ordfirm":
                  //  reFreshData();
                    break;
                case UIEvent.REFRESH:
                    reFreshData();
                    break;
                case UIEvent.CANCEL:
                 //   reFreshData();
                    break;
            }
        }

        #endregion






        private void OnAddtime(object sender, EventArgs e)
        {
            var feeDto = new AddFeeDTO();
            if (orcofirm != null)
            {
                feeDto.Id_hp = orcofirm.Id_hp;
                feeDto.Id_or = orcofirm.Id_confirm;
                FreqDefDO freq = model.GetDefDo(orcofirm.Id_freq);
                if (freq != null && freq.Sd_frequnitct.Equals(BdSrvDictCodeConst.SD_FREQUNIT_ONCE))
                {
                    feeDto.Id_freq = freq.Id_freq;
                    feeDto.Name_freq = freq.Name;
                }
            }
            model.AddFeeDTOList.Add(feeDto);
        }

        public void OnSavetime(object sender, EventArgs e)
        {
           // bool flag=model.save();
         //   OnFillData();
            if (model.save()){
            this.LoadData();
            this.setFeeEditable(true);
            this.SetStatusMsg("保存成功"); 
            }
        }



        public void Ondeletetime(object sender, EventArgs e)
        {
            AddFeeDTO[] ors = xapFormControl.GetSelected<AddFeeDTO>("cost");
            if (ors != null && ors.Count() > 0)
            {
           //     int i = AddFeeDTOList.IndexOf(ors[0]);
                if (this.model.iscontainSrv(ors[0].Id_srv))
                {
                    if (!this.IsDelete())
                        return;

                    this.model.deletefee(ors[0]);
                }
            }
        }
    }
}


