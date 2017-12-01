using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine;
using xap.rui.control.forms.model;
using iih.ci.ord.ciorder;

namespace iih.ci.ord.oporder.cards
{
    public partial class OpOrderOperView : CiorderBaseControl
    {
       
         #region 构造函数区域
        public OpOrderOperView()
        {
            InitializeComponent();
            //this.Load += new EventHandler(DiagcateTreeView_Load);

        }
        #endregion


        #region 变量定义区域
        //private viewmodel.DiagcateTreeViewModel model;
        private String querystr;
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
            //this.model = new viewmodel.DiagcateTreeViewModel(this.querystr);
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {

            
        }

        #endregion

        #region 内部事件区域
       
        /// <summary>
        /// 发送树节点选中事件到卡上显示数据
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void OrderOperView_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

  private void SetGridPolicy(bool flag)
        {
            DataPolicy policy = new DataPolicy();
            policy.AllowNew = flag;
            policy.AllowEdit = flag;
            policy.AllowRemove = flag;
            //policy.AllowSave = false;
            //policy.FullEdit = flag;
            //policy.HideOther = true;
            policy.MultiSelect = true;

            xapFormControl1.SetEditPolicy(flag, new DataPolicy[1] { policy });
        }
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
            querystr = null;
            //this.LoadData();
            SetGridPolicy(true);

        }
        private void Edit()
        {
            FillItem();
            SetGridPolicy(true);
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
           
                querystr = this.Context["img_id"].ToString(); 
            this.LoadData();
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
                    this.LoadData();
                    break;
                case UIEvent.PREVIEW:
                    //this.OnPreview();
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
