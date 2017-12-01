using System;
using System.Linq;
using System.Collections.Generic;
using iih.bd.bc.udi;
using iih.ci.ord.dto.ordpres.d;
using iih.ci.ord.opemergency.assi.asscommon.viewmodel;
using xap.cli.sdk.render.labelcontrol;
using xap.rui.control.basecontrol;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.control.refcontrol.control;
using xap.rui.control.refcontrol.events;
using xap.rui.engine;
using iih.ci.ord.opemergency.tool;
using xap.cli.sdk.render;
using xap.rui.control.forms.model;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.opemergency.view.printmanage
{
    public partial class PrintChooseView : XapCardControl
    {
        private OrdPresDTO datasource;

        public bool IsEditable;
        public XapBaseControl OwnerView;

        private UserRender sheettpRender;

        private List<string> lstSheetTp;
        private String sd_sheettp_org = "";
        #region 构造函数区域
        public PrintChooseView()
        {
            InitializeComponent();
            this.Load += new EventHandler(PrintChooseView_Load);
        }
        #endregion

        #region 父类继承区域
        protected override void OnLoadData()
        {
           
        }

        protected override void OnFillData()
        {
            var file = new FormFile();
            file.ViewModel = this.datasource;
            file.FormId = CiOrdBillFormTmplConst.CIORD_OP_PrintChooseView;// "20160829101458979NPY";
            file.FormStyle = FormStyle.Card;
            this.xapFormControl.ViewFile = file;

            bool bEn = lstSheetTp != null && lstSheetTp.Count > 0;
            this.xapFormControl.SetEditPolicy(bEn);
        }

        public override void OnSelected(object sender, TargetEventArgs e)
        {
            if ((e.Object is Dictionary<string, List<string>>))
            {
                var dic = e.Object as Dictionary<string, List<string>>;
                this.lstSheetTp = dic["sd_printtps"];
                this.LoadData();
            }
        }
        #endregion

        #region 内部事件区域
        private void PrintChooseView_Load(object sender, EventArgs e)
        {
            this.xapFormControl.FormCreated += xapFormControl_FormCreated;
            this.xapFormControl.ModelFilled += xapFormControl_ModelFilled;
            this.xapFormControl.RefFilter += xapFormControl_RefFilter;
            this.xapFormControl.RefResult += xapFormControl_RefResult;

            this.datasource = new OrdPresDTO();
            this.lstSheetTp = new List<string>();

            this.OnInit();
        }

        private void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            UserRender printRender = AssXapFormUtils.GetUserRender(xapFormControl, "choose.print");
            printRender.MouseClick += PrintRender_MouseClick;
            UserRender exportRender = AssXapFormUtils.GetUserRender(xapFormControl, "choose.export");
            exportRender.MouseClick += ExportRender_MouseClick;
            exportRender.Visible = false;
            sheettpRender = AssXapFormUtils.GetUserRender(xapFormControl, "choose.name_ciprnsheettp");
            bool bEn = lstSheetTp != null && lstSheetTp.Count > 0;
            sheettpRender.Enabled = bEn && IsEditable;
        }

        private void ExportRender_MouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            this.onMouseClick("All_Export", "Export_Mr");
        }

        private void PrintRender_MouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            this.onMouseClick("All_Print", "Print_Mr");
        }

        private void xapFormControl_ModelFilled(object sender, EventArgs e)
        {
            if (this.lstSheetTp == null || this.lstSheetTp.Count <= 0)
            {
                this.datasource.Id_ciprnsheettp = null;
                this.datasource.Sd_ciprnsheettp = null;
                this.datasource.Name_ciprnsheettp = null;
                return;
            }
            
            string ids = "", codes = "", names = "";
            foreach (string sheettp in lstSheetTp)
            {
                switch (sheettp)
                {
                    case CiDictCodeConst.SD_CIPRNSHEETTP_WESTPRES://西药处方
                        ids += CiDictCodeConst.ID_CIPRNSHEETTP_WESTPRES + ",";
                        codes += CiDictCodeConst.SD_CIPRNSHEETTP_WESTPRES + ",";
                        names += CiDictCodeConst.NAME_CIPRNSHEETTP_WESTPRES + ",";
                        break;
                    case CiDictCodeConst.SD_CIPRNSHEETTP_HERBPRES://草药处方
                        ids += CiDictCodeConst.ID_CIPRNSHEETTP_HERBPRES + ",";
                        codes += CiDictCodeConst.SD_CIPRNSHEETTP_HERBPRES + ",";
                        names += CiDictCodeConst.NAME_CIPRNSHEETTP_HERBPRES + ",";
                        break;
                    case CiDictCodeConst.SD_CIPRNSHEETTP_POISPRES://毒麻处方
                        ids += CiDictCodeConst.ID_CIPRNSHEETTP_POISPRES + ",";
                        codes += CiDictCodeConst.SD_CIPRNSHEETTP_POISPRES + ",";
                        names += CiDictCodeConst.NAME_CIPRNSHEETTP_POISPRES + ",";
                        break;
                    case CiDictCodeConst.SD_CIPRNSHEETTP_RISAPP: //检查申请单
                        ids += CiDictCodeConst.ID_CIPRNSHEETTP_RISAPP + ",";
                        codes += CiDictCodeConst.SD_CIPRNSHEETTP_RISAPP + ",";
                        names += CiDictCodeConst.NAME_CIPRNSHEETTP_RISAPP + ",";
                        break;
                    case CiDictCodeConst.SD_CIPRNSHEETTP_LISAPP:  //检验 申请单
                        ids += CiDictCodeConst.ID_CIPRNSHEETTP_LISAPP + ",";
                        codes += CiDictCodeConst.SD_CIPRNSHEETTP_LISAPP + ",";
                        names += CiDictCodeConst.NAME_CIPRNSHEETTP_LISAPP + ",";
                        break;
                    case CiDictCodeConst.SD_CIPRNSHEETTP_TREATAPP:   //诊疗 申请单
                        ids += CiDictCodeConst.ID_CIPRNSHEETTP_TREATAPP + ",";
                        codes += CiDictCodeConst.SD_CIPRNSHEETTP_TREATAPP + ",";
                        names += CiDictCodeConst.NAME_CIPRNSHEETTP_TREATAPP + ",";
                        break;
                    case CiDictCodeConst.SD_CIPRNSHEETTP_BTAPP:   //输血 申请单
                        ids += CiDictCodeConst.ID_CIPRNSHEETTP_BTAPP + ",";
                        codes += CiDictCodeConst.SD_CIPRNSHEETTP_BTAPP + ",";
                        names += CiDictCodeConst.NAME_CIPRNSHEETTP_BTAPP + ",";
                        break;
                    case CiDictCodeConst.SD_CIPRNSHEETTP_BTUSEAPP:   //取血 申请单
                        ids += CiDictCodeConst.ID_CIPRNSHEETTP_BTUSEAPP + ",";
                        codes += CiDictCodeConst.SD_CIPRNSHEETTP_BTUSEAPP + ",";
                        names += CiDictCodeConst.NAME_CIPRNSHEETTP_BTUSEAPP + ",";
                        break;
                    case CiDictCodeConst.SD_CIPRNSHEETTP_OPAPP:  //手术 申请单
                        ids += CiDictCodeConst.ID_CIPRNSHEETTP_OPAPP + ",";
                        codes += CiDictCodeConst.SD_CIPRNSHEETTP_OPAPP + ",";
                        names += CiDictCodeConst.NAME_CIPRNSHEETTP_OPAPP + ",";
                        break;
                    case CiDictCodeConst.SD_CIPRNSHEETTP_AUXI:  //0103 辅助执行
                        ids += CiDictCodeConst.ID_CIPRNSHEETTP_AUXI + ",";
                        codes += CiDictCodeConst.SD_CIPRNSHEETTP_AUXI + ",";
                        names += CiDictCodeConst.NAME_CIPRNSHEETTP_AUXI + ",";
                        break;
                    case CiDictCodeConst.SD_CIPRNSHEETTP_AUXI_IV:  //010301 注射治疗单
                        ids += CiDictCodeConst.ID_CIPRNSHEETTP_AUXI_IV + ",";
                        codes += CiDictCodeConst.SD_CIPRNSHEETTP_AUXI_IV + ",";
                        names += CiDictCodeConst.NAME_CIPRNSHEETTP_AUXI_IV + ",";
                        break;
                    case CiDictCodeConst.SD_CIPRNSHEETTP_COSTBILL:  //010302 诊疗费用清单
                        ids += CiDictCodeConst.ID_CIPRNSHEETTP_COSTBILL + ",";
                        codes += CiDictCodeConst.SD_CIPRNSHEETTP_COSTBILL + ",";
                        names += CiDictCodeConst.NAME_CIPRNSHEETTP_COSTBILL + ",";
                        break;
                    case CiDictCodeConst.SD_CIPRNSHEETTP_MR:   //0201 病历
                        ids += CiDictCodeConst.ID_CIPRNSHEETTP_MR + ",";
                        codes += CiDictCodeConst.SD_CIPRNSHEETTP_MR + ",";
                        names += CiDictCodeConst.NAME_CIPRNSHEETTP_MR + ",";
                        break;
                    case CiDictCodeConst.SD_CIPRNSHEETTP_MR_OP:   //020101 门诊病历
                        ids += CiDictCodeConst.ID_CIPRNSHEETTP_MR_OP + ",";
                        codes += CiDictCodeConst.SD_CIPRNSHEETTP_MR_OP + ",";
                        names += CiDictCodeConst.NAME_CIPRNSHEETTP_MR_OP + ",";
                        break;
                }
            }
            if (ids.Length > 0 && codes.Length > 0 && names.Length > 0)
            {
                this.datasource.Id_ciprnsheettp = ids.Substring(0, ids.Length - 1);
                this.datasource.Sd_ciprnsheettp = codes.Substring(0, codes.Length - 1);
                this.datasource.Name_ciprnsheettp = names.Substring(0, names.Length - 1);
            }
        }

        private void xapFormControl_RefFilter(object sender, RefActivatingEventArgs e)
        {
            //不走
            if (e.BindingFieldName.Equals("Name_ciprnsheettp"))
            {
                var str = string.Format("length(bd_udidoc.code)  =( select  max( length(code)) from bd_udidoc where  id_udidoclist='{0}')", CiDictCodeTypeConst.ID_CIPRNSHEETTP);
                str += string.Format(" and bd_udidoc.code not in ('{0}','{1}','{2}')",
                    CiDictCodeConst.SD_CIPRNSHEETTP_BTAPP, CiDictCodeConst.SD_CIPRNSHEETTP_BTUSEAPP,
                    CiDictCodeConst.SD_CIPRNSHEETTP_OPAPP);
                e.WherePart = str;
            }
        }

        private void xapFormControl_RefResult(object sender, RefResultEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_ciprnsheettp"))
            {
                var dto = e.DataObject as OrdPresDTO;
                string sd_sheettp = dto.Sd_ciprnsheettp;

                var dic = new Dictionary<string, string>();
                dic.Add("Sd_sheettp", sd_sheettp);
                this.FireSelected(dic);
                // 之前没有选择病历，但本次操作选择了病历时候，需要发送打印病历
                if (sd_sheettp != null && (sd_sheettp_org==null||!sd_sheettp_org.Contains(CiDictCodeConst.SD_CIPRNSHEETTP_MR_OP)) && sd_sheettp.Contains(CiDictCodeConst.SD_CIPRNSHEETTP_MR_OP))
                {
                    AssToolEx.SentMessage(this.OwnerView, AssToolEx.DictionaryEventArgsWith(AssistantConstant.CI_EMR_PRINT_PRIVEW_EVENT));
                }

                this.sd_sheettp_org = sd_sheettp;
            }
        }
        #endregion

        #region 辅助处理区域
        private void onMouseClick(string uiEventCode, string dataTag)
        {
            string sd_sheettp = datasource.Sd_ciprnsheettp;
            if (String.IsNullOrEmpty(sd_sheettp)) return;
            AssToolEx.SentMessage(this, AssToolEx.DictionaryEventArgsWith(uiEventCode, dataTag, sd_sheettp.Contains(CiDictCodeConst.SD_CIPRNSHEETTP_MR_OP) ? "true" : "false"));
        }
        #endregion

        #region 状态处理区域
        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            var uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            //string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case UIEvent.LOAD:
                    break;
            }
        }
        #endregion
    }
}
