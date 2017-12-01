using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.opemergency.assi.asscommon.dto;
using iih.ci.ord.opemergency.assi.asscommon.view;
using iih.ci.ord.opemergency.assi.assistantinit;
using iih.ci.ord.opemergency.assi.enthistory.view;
using iih.ci.ord.opemergency.assi.medsrvclass.view;
using iih.ci.ord.opemergency.assi.opmedicaltechnology.view;
using iih.ci.ord.opemergency.assi.OrderTemplate.view;
using iih.en.pv.dto.d;
using xap.cli.sdk.form;
using xap.cli.sdk.render;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.control.forms.view;
using xap.rui.engine;
using iih.ci.ord.ems.d;
using iih.ci.ord.opemergency.assi.OrdertemplatePithy.model;
using iih.ci.ord.opemergency.assi.i;
using iih.ci.ord.opemergency.viewmodel;
using iih.bd.srv.ortpl.d;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.opemergency.declare;

namespace iih.ci.ord.opemergency.assi.OrdertemplateComplex.view
{
    public class OpTemplateControlComplex : XapBaseControl, IViewCommond
    {
        /// <summary>
        /// 事件交互类，与配置文件内的类进行交互
        /// </summary>
        public XapBaseControl xapBaseControl;
        public OpTemplateFrameComplex parentFrame;
        public OrderTemplatePithyTreeViewModel model;
        XUserControl xUserControl;
        /// <summary>
        /// banner数据
        /// </summary>
        public Ent4BannerDTO BannerDTO;
        /// <summary>
        /// 当前就诊环境
        /// </summary>
        public CiEnContextDTO ciEnContext { get; set; }
       /// <summary>
       /// 模板类型
       /// </summary>
        public string modeltype { get; set; }
        /// <summary>
        /// 保存模板
        /// </summary>
        public AssButtonViewModel Buttonmodel;
        /// <summary>
        /// 展示就诊历史组件的控件
        /// </summary>
        private XapFormControl xapFormControl;

        public OpTemplateControlComplex()
        {
            this.Buttonmodel = new AssButtonViewModel();
            xapFormControl = new XapFormControl();
            xapFormControl.Dock = DockStyle.Fill;
            this.Controls.Add(xapFormControl);
            this.Load += EntHistoryTabFrame_Load;

   
        }

        private void EntHistoryTabFrame_Load(object sender, EventArgs e)
        {
            xUserControl = new XUserControl();
            xUserControl.Init(Application.StartupPath + "\\modules\\iihci\\ui\\opordertemplate\\Helper_complex_control.xml");
            OpOrderTemplateTreeViewComplex templTreeView = xUserControl.GetConfig().GetInstance("complex_OpOrderTemplateTreeView") as OpOrderTemplateTreeViewComplex;
            OpOrderTemplateListViewComplex templListView = xUserControl.GetConfig().GetInstance("complex_OpOrderTemplateListView") as OpOrderTemplateListViewComplex;
            templListView.Ent4BannerDTO = this.BannerDTO;
            templListView.parentControl = this;
            if (!string.IsNullOrWhiteSpace(this.modeltype))
            {
                templTreeView.treeKeyModel = this.model.loadTreeModel(this.modeltype);    
            }

            xUserControl.Dock = DockStyle.Fill;
            this.xapFormControl.AddRender(xUserControl);
         
        }
        public void saveData()
        {
            OpOrderTemplateListViewComplex templListView = xUserControl.GetConfig().GetInstance("complex_OpOrderTemplateListView") as OpOrderTemplateListViewComplex;
            object obj = templListView.getSaveData();
            if (obj == null) return;
            List<OrTplNItmDO> selectList = obj as List<OrTplNItmDO>;
            if (selectList.Count > 0)
            {
                saveToDb(selectList);
            }
            else
            {
                this.ShowInfo("请确认已选择医嘱数据！");
            }
            

        }

        public bool saveToDb(List<OrTplNItmDO> selectList)
        {
            var moreEmsDto = Buttonmodel.getMoreEmsParamDTO(this.ciEnContext, selectList.ToArray());
            if (moreEmsDto != null)
            {
                xapBaseControl.FireEventSent(this, AssToolEx.DictionaryEventArgsWith(EventCodeType.EVENT_EMS_TMPL_EDIT, EventCodeType.ARGKEY_EMS_TMPL_EDIT,
                     moreEmsDto));
            }
            xapBaseControl.SetStatusMsg("保存成功！");
            parentFrame.close();
            return true;
        }
       public void close() { }
       public object getSaveData() { return null; }
       public void allChecked() {
           OpOrderTemplateListViewComplex templListView = xUserControl.GetConfig().GetInstance("complex_OpOrderTemplateListView") as OpOrderTemplateListViewComplex;
           templListView.allChecked();
       }
       public void allCancel() {
           OpOrderTemplateListViewComplex templListView = xUserControl.GetConfig().GetInstance("complex_OpOrderTemplateListView") as OpOrderTemplateListViewComplex;
           templListView.allCancel();
       }
    }
}
