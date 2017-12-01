using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.bd.srv.dto.d;
using iih.ci.ord.ciordcons.viewmodel;
using xap.rui.control.basecontrol;
using xap.rui.engine;

namespace iih.ci.ord.ciordcons.view
{
    public partial class ConsMrTreeView : XapListControl
    {
        #region 变量定义区域

        private ConsMrTreeViewModel model;
        public string id_ent;
        #endregion

        #region 构造函数区域

        public ConsMrTreeView()
        {
            InitializeComponent();
            this.oTree.Load += new EventHandler(oTree_Load);
            this.oTree.TreeItemSelected += new xap.rui.control.tree.events.TreeItemEventHandler(oTree_TreeItemSelected);
        }

        #endregion

        #region 父类继承区域

        protected override void OnLoadData()
        {
            if (id_ent==null)
            {
                return;
                
            }
            this.model = new ConsMrTreeViewModel(id_ent);
        }

        protected override void OnFillData()
        {
            oTree.ClearTree();//清空树
            if (model == null)
                return;

            oTree.LoadData(model.TreeModel1);
            oTree.LoadData(model.TreeModel2);
            oTree.ExpandToLevel(1);
        }

        private void oTree_TreeItemSelected(object sender, xap.rui.control.tree.events.TreeItemEventArgs e)
        {

            MrDTO dto = this.oTree.FocusedUserObject as MrDTO;
            if (dto == null) return;
            var mrDo = this.model.GetCiMrDo(dto.Id_mr);
            this.FireOpenMrPadR(mrDo);

        }
        void oTree_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }
        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            switch (uiEvent)
            {
                case UIEvent.GOBACK:
                    this.FireOpenMrPadR(null);
                    break;
            }
        }
        #endregion
    }
}
