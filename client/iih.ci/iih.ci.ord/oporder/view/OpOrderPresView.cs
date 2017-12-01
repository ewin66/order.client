using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;
using iih.ci.ord.ciorder;
using iih.ci.ord.dto.OrderPresSplitDTO.d;
using iih.ci.ord.oporder.cards;
using xap.rui.engine;
using xap.rui.control.forms.view;
using iih.ci.ord.ciorder.viewmodel;
using xap.rui.control.formcontrol.model;
using iih.ci.ord.ciordems.d;
using iih.en.pv.dto.d;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.control.forms.control;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.oporder.view
{
    public partial class OpOrderPresView : CiorderBaseControl
    {
        public OpOrderPresView()
        {
            InitializeComponent();
            this.Load += new EventHandler(OpOrderPresView_Load);
            xapFormControl1 = new XapFormControl() {Dock= DockStyle.Fill };
            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            this.Controls.Add(xapFormControl1);
        
        }
       
        void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            gv = xapFormControl1.GetGridView("fenfang");
            gv.DataTable.CrossBackColor = true;
            
            //gv.OptionsView.AllowCellMerge = true;
            //gv.Columns["Pres_no"].OptionsColumn.AllowMerge = DevExpress.Utils.DefaultBoolean.True;
            //gv.Columns[0].OptionsColumn.AllowMerge = gv.Columns[1].OptionsColumn.AllowMerge = gv.Columns[3].OptionsColumn.AllowMerge = gv.Columns[4].OptionsColumn.AllowMerge = gv.Columns[5].OptionsColumn.AllowMerge = gv.Columns[6].OptionsColumn.AllowMerge = DevExpress.Utils.DefaultBoolean.False;
        }

      

 


        #region 变量定义区域
        private  OrderPresViewModel model;
  
       XapFormControl xapFormControl1;
         List<OpPresList> preList{get;set;}
         //public PatiVisitDO patDo = new PatiVisitDO();
        public Ent4BannerDTO ent4BanerDto;
        XapFormGridControl gv;
       
        #endregion
      

        #region 公开属性区域

        #endregion

        #region 命令定义区域

        //[XapCommand(Name = "Open", Caption = "打开")]
        //public void OnOpen(object sender, EventArgs e)
        //{

        //}

        #endregion

        #region 事件发送区域

        public void SendMgs()
        {
            DictionaryEventArgs dic = new DictionaryEventArgs();
            dic.Data[UIConst.UI_EVENT] = UIEvent.SAVE_SUCCESS;
            this.FireEventSent(this, dic);
        }
        #endregion

        #region 事件接收区域

        //[XapEventRecv(Name = "Recv")]
        //public void OnRecv(object sender, XapEventArgs e)
        //{

        //}
        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            model = new OrderPresViewModel(ent4BanerDto.Id_ent);
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OpOrderPresView;// "20151123024924760NRU";
            file.FormStyle = FormStyle.Card;
            file.ViewModel = model.getOrderPresSplitList(); 
            this.xapFormControl1.ViewFile = file;
          
        }

        #endregion

        #region 内部事件区域

        void OpOrderPresView_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

  //private void SetGridPolicy(bool flag)
  //      {
  //          DataPolicy policy = new DataPolicy();
  //          policy.AllowNew = flag;
  //          policy.AllowEdit = flag;
  //          policy.AllowRemove = flag;
  //          //policy.AllowSave = false;
  //          //policy.FullEdit = flag;
  //          //policy.HideOther = true;
  //          policy.MultiSelect = true;

  //          //xapFormControl1.SetEditPolicy(flag, new DataPolicy[1] { policy });
  //      }
        /// <summary>
        /// 加载事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void DiagcateTreeView_Load(object sender, EventArgs e)
        {
            base.OnInit();
        }
        #endregion

        #region 辅助处理函数
       private void Add()
        {
            //xt_img.SelectedTabPage = xtraTabPage2;
            //querystr = null;
            //this.LoadData();
            //SetGridPolicy(true);

        }
        private void Edit()
        {
            FillItem();
            //SetGridPolicy(true);
        }
        private void Delete()
        {

        }
        private void Save()
        {
            //model.EmrImageDO.getParentDO().Image = ImageToBytes(pic_img.Image);
            //model.Save();
            //SendMgs();
        }
        private void Cancel()
        {
            //xt_img.SelectedTabPage = xtraTabPage1;
        }
        private void FillItem()
        {
           
            //    querystr = this.Context["img_id"].ToString(); 
            //this.LoadData();
        }
        #endregion



        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case UIEvent.SAVE_SUCCESS:
                    if (Created)
                    {
                        this.LoadData();
                    }
                  
                    break;
                case UIEvent.LOAD:

                    Dictionary<string, object> dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                    if (dic != null)
                    {  
                        
                        if (dic.Keys.Contains("PatientData"))
                        {
                            ent4BanerDto = (dic["PatientData"] as BannerData).Ent4BannerDTO;
                        }
                        if (dic.Keys.Contains("EncounterID"))
                        {
                        //    patDo.Id_ent = dic["EncounterID"].ToString();
                        }
                    }
                    break;

                case "Cipres":
                    OrderPresSplitDTO[] PRESS = this.xapFormControl1.GetSelected<OrderPresSplitDTO>();
                    if (PRESS != null || PRESS.Count() >0)
                    {

                        OpOrderPresPrinForm printview = new OpOrderPresPrinForm();
                        printview.presdto = PRESS[0];
                        printview.printPres();
                        printview.Size = new Size(1000, 700);

                        printview.ShowDialog();
                        
                    }
                    break;
                case UIEvent.PRINT:
                    // this.OnPrint();
                    break;
                case UIEvent.ADD:
                    //this.OnAdd();
                    break;
                case UIEvent.DELETE:
                    //this.Delete();
                    break;
                case UIEvent.DISABLE:
                    // this.UpdateActivestate(ActiveStateEnum.STOP);
                    break;
                case UIEvent.ENABLE:
                    //this.UpdateActivestate(ActiveStateEnum.ACTIVE);
                    break;
                default:
                    break;
            }
        }
        #endregion








    }
}
