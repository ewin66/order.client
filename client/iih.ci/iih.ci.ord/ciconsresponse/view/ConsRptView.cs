using System;
using System.Collections.Generic;
using System.Linq;
using iih.bd.bc.udi;
using iih.ci.iih.ci.ord.i;
using iih.ci.ord.ciconsresponse.viewmodel;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.ci.ord.consrpt.d;
using iih.en.pv.dto.d;
using xap.cli.sdk.render;
using xap.cli.sdk.render.Items;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.control.engine.attributes;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.control.forms.control;
using xap.rui.engine;
using iih.ci.ord.cior.d;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciconsresponse.view
{
    /// <summary>
    /// 会诊记录
    /// </summary>
    /// Author:admin
    /// Date:2015-11-18
    public partial class ConsRptView : XapCardControl
    {


        #region 变量定义区域

        private ConsRptViewModel model;
        private string id_orcons;//0001AA10000000050QZ3   0001AA10000000050R1N
        private XapFormGridControl gv_invite;
        private OrdApConsDO consDo;
        private string pattp;
        //banner信息
        public Ent4BannerDTO ent4BannerDto;
        #endregion

          #region 构造函数区域
        public ConsRptView()
        {

            InitializeComponent();
            xapFormControl1.Load += new EventHandler(xapFormControl1_Load);
            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            xapFormControl1.ModelFilled += new EventHandler(xapFormControl1_ModelFilled);
        }
        #endregion

        #region 公开属性区域

        #endregion

        #region 命令定义区域
        [XapCommand(Name = "Save")]
        public void OnSave()
        {
            this.xapFormControl1.SaveForm();
            if (this.xapFormControl1.HasErrors)
            {
                this.ShowAlert("必须输入必填项");
                return;
            }
            if (this.model.SaveConsRpt())
            {
                this.SetStatusMsg("保存成功！");
                this.LoadData();
            }
        }
        [XapCommand(Name = "Submit")]
        public void OnSubmit()
        {
            this.xapFormControl1.SaveForm();
            this.model.SubmitRpt();
            this.ShowInfo("提交成功！");
            this.LoadData();
            this.xapFormControl1.SetEditPolicy(false);
        }

        #endregion


        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            if (string.IsNullOrEmpty(id_orcons)) {
                return;
            }
            this.model=new ConsRptViewModel(id_orcons);
            this.model.GetConsItem(id_orcons);
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_ConsRptView;// "20151118111851985IE3";
            file.FormStyle = FormStyle.Card;
           

            if (model != null)
            {
                file.ViewModel = model.consDTO;             
            }
            this.xapFormControl1.ViewFile = file;


        }
        public override void OnSelected(object sender, TargetEventArgs e)
        {
            if (!(sender is IXapListControl) || !(e.Object is OrdApConsDO))
                return;
            this.iXapListControl = sender as IXapListControl;
            this.consDo = e.Object as OrdApConsDO;
            this.id_orcons = consDo.Id_apcons;
            this.LoadData();
            
        }

        public override void OnStatus()
        {

            if (this.model == null || this.model.rptArray == null)
            {

                this.SetEnable("Submit", false);
                this.SetEnable("Save", false);
                
            }else if (this.model.rptArray.Count() > 0)
            {
                CiOrdConsRptDO conrpt = this.model.rptArray[0];
                if (conrpt.Sd_su_rpt != CiDictCodeConst.SD_SU_RPT_SIGN)
                {
                    if (pattp == "2" || pattp == "9")
                    {
                        this.SetEnable("Submit", false);
                        this.SetEnable("Save", false);
                    }
                    else
                    {
                        this.SetEnable("Submit", true);
                        this.SetEnable("Save", true);
                    }
                }
                else
                {
                    this.SetEnable("Submit", false);
                    this.SetEnable("Save", false);
                }

            }
            else
            {
                if (pattp == "2" || pattp == "9")
                {
                    this.SetEnable("Submit", false);
                    this.SetEnable("Save", false);
                }else{
                this.SetEnable("Save", true);
               this.SetEnable("Submit", false);
                }
            }
        }

        #endregion

        #region 内部事件区域

        void xapFormControl1_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

        void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            this.gv_invite = xapFormControl1.GetGridView("item");
            this.gv_invite.ReadOnly = true;
            //UserRender btnSave = xapFormControl1.GetUserRender("consrpt", "btnSave");//保存
            //btnSave.MouseClick += new MouseEventHandler(btnSave_MouseClick);
            //UserRender btnSub = xapFormControl1.GetUserRender("consrpt", "btnSubmit");//保存
            //btnSub.MouseClick += new MouseEventHandler(btnSub_MouseClick);

           // this.Context
           
        }

       
        void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {
            if (this.model.rptArray.Count() != 0 && this.model.rptArray[0].Sd_su_rpt == CiDictCodeConst.SD_SU_RPT_SIGN)
            {
                xapFormControl1.SetEditPolicy(false);
            }
            else
            {
                xapFormControl1.SetEditPolicy(true);
            }

            this.gv_invite.DataTable.DataSource = this.model.consitemList;
            if (this.model.rptArray.Count() != 0)
            {
                
             //   SenMgs(this.model.rptArray[0].Sd_su_rpt);
            }
            //判断患者类型
            pattp=this.model.getEntpattp(this.ent4BannerDto.Id_ent);
            if (pattp == "2" || pattp == "9")
            {
                this.xapFormControl1.SetEditPolicy(false);
                SenPattp("unity");
            }
            else
            {
                this.xapFormControl1.SetEditPolicy(true);
                SenPattp("ununity");
                if (this.model.rptArray.Count() > 0)
                {
                    CiOrdConsRptDO conrpt = this.model.rptArray[0];
                    if (conrpt.Sd_su_rpt == CiDictCodeConst.SD_SU_RPT_SIGN)
                    {
                        this.xapFormControl1.SetEditPolicy(false);
                    }

                }
            }


            UserRender us = xapFormControl1.GetUserRender("consrpt", "dt_plan");
            XCalendarTimerComboBox time = us.Renders[0] as XCalendarTimerComboBox;
            if (time != null)
            {
                //会诊记录的最大时间暂时不限制，最小时间大于入科时间
           //     DateTime datetime = this.NowTime();
        //        time.TodayDateTime = datetime;
                time.MinDate = new GetInHosTime().GetPatInHosTime(this.ent4BannerDto.Id_ent);
                //int maxHours = Context.GetGroupParam<int>(ICiOrdNSysParamConst.SYS_PARAM_OrEarlyEntryMaxHours);
                //if (maxHours == null)
                //    maxHours = 72;
         //       time.MaxDate = datetime.AddHours(maxHours);

            }
           

        }

        private void SenMgs(string uievent)
        {
            DictionaryEventArgs dic = new DictionaryEventArgs();
            dic.Data[UIConst.UI_EVENT] = uievent;
            this.FireEventSent(this, dic);

        }

        private void SenPattp(string uievent)
        {
            DictionaryEventArgs dic = new DictionaryEventArgs();
            dic.Data[UIConst.UI_EVENT] = uievent;
            this.FireEventSent(this, dic);

        }

        #endregion

        #region 辅助处理函数

     
        #endregion



        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case UIEvent.LOAD:

                    Dictionary<string, object> dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                    if (dic != null)
                    {
                        object obj;
                        if (dic.TryGetValue("PatientData", out obj))
                        {
                            this.ent4BannerDto = (obj as BannerData).Ent4BannerDTO;
                        }
                        else if (dic.TryGetValue("ent4DTO", out obj))
                        {
                            this.ent4BannerDto = obj as Ent4BannerDTO;
                           
                        }
                    }
                    break;
                case UIEvent.SAVE:
                    OnSave();
                    break;

                case UIEvent.SUBMIT:
                    OnSubmit();
                    break;
                default:
                    break;
            }
        }

        #endregion
    }
}
