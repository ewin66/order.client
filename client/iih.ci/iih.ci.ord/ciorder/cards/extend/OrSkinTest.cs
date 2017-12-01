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
using xap.cli.sdk.render;
using xap.cli.sdk.render.labelcontrol;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciorder.cards.extend
{
    public partial class OrSkinTest : CiorderBaseControl
    {
        public OrSkinTest()
        {
            InitializeComponent();
            this.Load += new EventHandler(OrSkinTest_Load);
            //表单 id  20150925055807508S1S
             xapFormControl1 = new XapFormControl();
            this.Controls.Add(xapFormControl1);
            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
        }
          

        //XLabelBaseUserRender check;
        public event EventHandler btnOkClick;
        void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            UserRender btnSub = xapFormControl1.GetUserRender("skintest", "btnOk");
            btnSub.MouseClick += new MouseEventHandler(btnSub_MouseClick);
        }

        void btnSub_MouseClick(object sender, MouseEventArgs e)
        {
            if (true)
            {//如果为false  将
              // 将CI_OR表中的皮试标志fg_skintest置为false，将界面上录入的不皮试原因记录在sd_skintest_skip_reason上。
                btnOkClick("", null);
            }
        }

        void OrSkinTest_Load(object sender, EventArgs e)
        {
            base.OnInit();

        }

        public string SkinTestInfo()
        {
            return "";//不皮试的原因
        }

        XapFormControl xapFormControl1;
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

            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrSkinTest;// "20150928050019641UA0";
            file.FormStyle = FormStyle.Card;
            //DrugDO = listDrug[0];
            //file.ViewModel = CiHeadDo;// drugDO;
            //file.ViewModel = CiHeadDo.Emsdrugs;// 新的
            this.xapFormControl1.ViewFile = file;
            xapFormControl1.SetEditPolicy(true);

        }

        #endregion

        #region 内部事件区域

        /// <summary>
        /// 发送树节点选中事件到卡上显示数据
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xTree1_TreeItemSelected(object sender, xap.rui.control.tree.events.TreeItemEventArgs e)
        {



            //MrTpDO mrTpDO = oTree1.GetUserObject(e.Node) as MrTpDO;
            //this.Context.Data["mrTpDO"] = mrTpDO;

            //DictionaryEventArgs args = new DictionaryEventArgs();
            //args.Data.Add(UIConst.UI_EVENT, "SelectNode");
            //base.FireEventSent(this, args);
        }

        //private void SetGridPolicy(bool flag)
        //{
        //    DataPolicy policy = new DataPolicy();
        //    policy.AllowNew = flag;
        //    policy.AllowEdit = flag;
        //    policy.AllowRemove = flag;
        //    //policy.AllowSave = false;
        //    //policy.FullEdit = flag;
        //    //policy.HideOther = true;
        //    policy.MultiSelect = true;

        //    xapFormControl1.SetEditPolicy(flag, new DataPolicy[1] { policy });
        //}
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
    
        #endregion




    }
}
