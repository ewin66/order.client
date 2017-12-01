using System;
using System.Collections.Generic;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.Validate;
using iih.ci.ord.ems.d;
using xap.cli.context.token;
using xap.mw.serviceframework;
using xap.rui.control.extentions;
using xap.rui.engine;

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
    /// <summary>
    /// 用血医疗单
    /// </summary>
    public partial class OrdApBuView : CiorderBaseControl
    {
        #region 变量定义区域
        XUserControl xapUserControl = new XUserControl();
        private object c;
        private object b;
        #endregion
        public OrdApBuView()
        {
            this.fg_save = true;
            InitializeComponent();
            this.Load += new EventHandler(OrdApBuView_Load);
            this.SheetName = "用血申请单";
           
        }
        //这个方法有问题
        //public override void SaveEms(EmsUIDTO emsHeadDO, CiEmsDTO dto)
        //{
        //    object b = xapUserControl.GetBaseContext().Config.GetInstance("OrdApBuCardView");
        //    if (b != null)
        //    {

        //        var emg = b as OrdApBuCardView;

        //        emg.save(this.MedSrvDO, dto);
        //    }
        //}

        public override void SaveBefore()
        {
           
        }
        public string validateBeforeSave() {
            if (b != null)
            {
                var emg = b as OrdApBuCardView;
                return emg.validateBeforeSave();
            }
            return null;
        }
        public override IValidate GetOrdValidate()
        {
            return new OrderApbtUseValidate();
        }

        void OrdApBuView_Load(object sender, EventArgs e)
        {
            xapUserControl.Init("modules\\iihci\\ui\\ordbu\\ordbu_config.xml");
            this.xapFormControl.AddRender(xapUserControl);
            //var a = 0;
            c = xapUserControl.GetBaseContext().Config.GetInstance("OrdApBuGridView");
            if (c != null)
            {
                var emg = c as OrdApBuGridView;
                emg.LoadGrid(EmsHeadDO, this.CiEmsDTO);
            }


            b = xapUserControl.GetBaseContext().Config.GetInstance("OrdApBuCardView");
            if (b != null)
            {
                var emg = b as OrdApBuCardView;
                emg.loadcard(EmsHeadDO, this.CiEmsDTO);
            }

         
        }

        #region 父类继承区域

        public override void OnRefreshData(EmsUIDTO headDo, object e)
        {
            //CiordubDTO dto = new CiordubDTO();
            // headDo.CiordubDTO=dto;
            EmsHeadDO = headDo;
            
            if (c != null)
            {
                var emg = c as OrdApBuGridView;
                emg.LoadGrid(EmsHeadDO, this.CiEmsDTO);
            }


            
            if (b != null)
            {
                var emg = b as OrdApBuCardView;
                emg.loadcard(EmsHeadDO, this.CiEmsDTO);
            }
            if (this.Created)
            {
                this.LoadData();
            }
            
        }
        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {


            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            Dictionary<string, Object> dict = eventArgs.Data[UIConst.DATA] as Dictionary<string, Object>;

            //Dictionary<string, OrderRender> newListSelected = null;


            switch (uiEvent)
            {

                case UIEvent.SAVE_SUCCESS:
                    //var a = 1;
                    break;
                default:
                    break;

            }
        }
        #endregion
    }
}
