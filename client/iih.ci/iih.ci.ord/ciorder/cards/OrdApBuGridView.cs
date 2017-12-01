using iih.bd.srv.medsrv.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.viewmodel;
using iih.ci.ord.dto.d;
using xap.cli.sdk.controls.DataView;
using xap.rui.control.basecontrol;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.model;
using xap.rui.control.forms.view;
using xap.rui.engine;
using xap.cli.sdk.controls.DataView.Base;
using xap.cli.sdk.controls;
using System.Drawing;
using iih.ci.ord.ems.d;
using xap.rui.bizcontrol.BillFormTmplConst;

/*
********************************************************************************

** 作者： 李程

** 创始时间：2016-6-30

** 修改人：李程

** 修改时间：2016-6-30

** 描述： 医嘱确认显示页面


*********************************************************************************
*/

namespace iih.ci.ord.ciorder.cards
{
    public partial class OrdApBuGridView : XapListControl, IControlSizeChanged
    {
        #region 变量定义区域

        //private MedSrvDO med;
        private OrdApBuGridViewModel _model;
        public string Ident ;
        private EmsUIDTO uidto;
        private CiEmsDTO emsdto;
        private CiordubDTO ciordUbDto;
        #endregion

        #region 构造函数区域

        public OrdApBuGridView()
        {
            InitializeComponent();
            xapFormControl.AfterFocused += xapFormControl_AfterFocused;
            this.Load += new System.EventHandler(OrdApBuGridView_Load);
            this.xapFormControl.FormCreated += new System.EventHandler(xapFormControl_FormCreated);
            this.xapFormControl.ModelFilled += new System.EventHandler(xapFormControl_ModelFilled);
        }

        void xapFormControl_ModelFilled(object sender, System.EventArgs e)
        {
            if (this.uidto != null && this.uidto.CiordubDTO != null && this.uidto.CiordubDTO.Id_apbu != null)
            {
                xapFormControl.AfterFocused -= xapFormControl_AfterFocused;
                if (ciordUbDto != null)
                {
                    XDataRow row = this.xapFormControl.GetGridView().DataTable.GetRow(ciordUbDto);
                    if (row != null)
                    {
                        row.Selected = true;
                        ciordUbDto = null;
                    }
                }
                else
                {
                    XDataRow row = this.xapFormControl.GetGridView().DataTable.Rows[0] as XDataRow;
                    if (row != null)
                    {
                        row.Selected = true;
                    }
                }
                xapFormControl.AfterFocused += xapFormControl_AfterFocused;
            }
            if (this.uidto.IsNEW) {
                //默认选中第一行数据
                if (this.xapFormControl.GetGridView().DataTable.Rows != null && this.xapFormControl.GetGridView().DataTable.Rows.Count > 0) {
                    XDataRow row = this.xapFormControl.GetGridView().DataTable.Rows[0] as XDataRow;
                    row.Selected = true;
                    //FireSelected(row.DataSource as CiordubDTO);
                }
            }
        }

        void xapFormControl_FormCreated(object sender, System.EventArgs e)
        {
            //throw new System.NotImplementedException();
        }

        void OrdApBuGridView_Load(object sender, System.EventArgs e)
        {
            this.LoadData();
        }

        #endregion

        #region 内部事件区域

        private void xapFormControl_AfterFocused(object sender, DataFocusedEventArgs e)
        {
            CiordubDTO dto = e.Data as CiordubDTO;
          
          
            dto.Id_route = this.uidto.MedSrvDO.Id_route;
            dto.Quan_medu_ub = dto.Num_margin_bu;
            if (this.uidto.CiordubDTO == null)
                this.uidto.CiordubDTO=new CiordubDTO();
            this._model.Copy(dto, this.uidto.CiordubDTO);
            if (this.uidto.CiordubDTO != null)
                FireSelected(this.uidto.CiordubDTO);
        }
        public event ControlSizeChangedHandler ControlSizeChanged;
        #endregion

        #region 父类继承区域

        /// <summary>
        ///     获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            _model = new OrdApBuGridViewModel();
        }

        /// <summary>
        ///     CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            var file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrdApBuGridView;// "2015120102253457807V";
            file.FormStyle = FormStyle.Card;
            if (this.uidto != null && this.uidto.PatInfo.Id_ent != null)
            {
                if (this.emsdto.Sd_su_or == null || this.emsdto.Sd_su_or == "0")
                {
                    _model.getOrderUBDto(this.uidto.PatInfo.Id_ent);
                    if (this.uidto != null && this.uidto.CiordubDTO != null && this.uidto.CiordubDTO.Id_apbu != null)
                    {
                        foreach (CiordubDTO ciordubDto in this._model.Ciordublist)
                        {
                            if (ciordubDto.Id_or == this.uidto.CiordubDTO.Id_or_rel)
                            {
                                this.uidto.CiordubDTO.Applyform = ciordubDto.Applyform;
                                //用血申请量，在编辑时，显示上次填写的申请量 zwq
                                //if (uidto.IsNEW)
                                {
                                    this.uidto.CiordubDTO.Num_margin_bu = ciordubDto.Num_margin_bu;
                                }
                                this.uidto.CiordubDTO.Quan_medu = ciordubDto.Quan_medu;
                                this.uidto.CiordubDTO.Name_unit = ciordubDto.Name_unit;
                                ciordUbDto = ciordubDto;

                            }
                        }
                    }
                }
            }
            if (_model.Ciordublist != null)
            {
                file.ViewModel = _model.Ciordublist;
            }
            xapFormControl.ViewFile = file;
        }


        public override void OnSelected(object sender, TargetEventArgs e)
        {
        }

        #endregion

        public void LoadGrid(EmsUIDTO ems, CiEmsDTO emsdto)
        {
            this.uidto = ems;
            this.emsdto = emsdto;
            if (emsdto.Sd_su_or == null || emsdto.Sd_su_or == "0")
            {
                ControlSizeChanged(new Size(this.Size.Width, 100));
            }
            else
            {
                ControlSizeChanged(new Size(0, 0));
            }
            this.LoadData();
        
        }

        #region 状态控制区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            var uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;

            switch (uiEvent)
            {
                case UIEvent.LOAD:
                    //var dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                    //if (dic != null)
                    //{
                    //    if (dic.Keys.Contains("ordata"))
                    //    {
                    //        var ordata = dic["ordata"] as OrDataBing;
                    //        this.Ident = ordata.patDo.Id_ent;
                    //        //    this.LoadData();
                    //    }

                    //    if (dic.Keys.Contains("med"))
                    //    {
                    //        this.med = dic["med"] as MedSrvDO;
                           
                    //    }

                    //}

                    break;
            }
        }

        #endregion
    }
}