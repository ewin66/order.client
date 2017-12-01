using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.opemergency.viewmodel;
using iih.en.pv.dto.d;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using xap.rui.engine.registers;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.opemergency.proofofdiag
{
    public partial class OPProofOfDiagnosisView : XapListControl, IWorkStationRegist
    {
     

        #region 变量定义区域

        private XapFormControl xapFormControl;
        private OPProofOfDiagnosisViewModel model;
       // public PatiVisitDO patDo = null;
        public Ent4BannerDTO ent4BannerDto;
        #endregion

        #region 构造函数区域

        public OPProofOfDiagnosisView()
        {
            
            this.xapFormControl = new XapFormControl();
            this.xapFormControl.Dock = DockStyle.Fill;
            this.Load += new EventHandler(EntDIPorveView_Load);
            this.Controls.Add(this.xapFormControl);

  
        }

       
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

        //[XapEventSent(Name = "Say")]
        //public event EventHandler<XapEventArgs> Say;

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
            this.model = new OPProofOfDiagnosisViewModel(ent4BannerDto.Id_ent);
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            //if (ent4BannerDto.Code_entp == "00")
            //{
            file.FormId = CiOrdBillFormTmplConst.CIORD_OP_OPProofOfDiagnosisView;// "20151218040558955A4B";
            //}
            //else
            //{
            //    file.FormId = "20151120040106530KAR";
            //}
          
            file.FormStyle = FormStyle.Card;
            if (this.model != null)
            {
                this.model.SetEntDiProveDO(ent4BannerDto);
                file.ViewModel = this.model.entDiProveDo;

            }
            this.xapFormControl.ViewFile = file;
            if (this.model.entDiProveDo.Num_print > 0)
            {
                this.xapFormControl.SetEditPolicy(false);
            }
            else
            {
                this.xapFormControl.SetEditPolicy(true);
            }

        }

        public override void OnDeptChanged()
        {
            this.model = new OPProofOfDiagnosisViewModel(ent4BannerDto.Id_ent);
            this.OnFillData();
        }

        #endregion

        #region 内部事件区域
    

        private void Save()
        {
            this.xapFormControl.SaveForm();
            this.model.Save();
            this.SetStatusMsg("保存成功");
        }
         

        private void  print_view()
        {
           // MessageBox.Show("打印");
           // TemplAndDataLogicAssist prt_logic = new TemplAndDataLogicAssist();
	
	// 根据 当前功能节点编码和目标模板名称 加载打印模板
	// 模板名称为空表示自动选择该功能节点下的第1个模板
	//prt_logic.loadPrtTempl(this.Context.FunCode, "诊断");
	// 加载打印数据
	//prt_logic.loadPrtDataSingle(this.model.entDiProveDo);
	// 执行打印，true表示显示打印预览对话框
	// 或者使用 doExportPDF() 导出成PDF文件
	//prt_logic.doPrint(true);
            // 在模板中加载新数据
            // 注意：初始没有数据时也要调用该方法，使用null作为参数。否则模板里录入的常量不会显示
            //this.form_render.loadViewDataSingle(this.model.entDiProveDo);
            ////// 刷新控件
            //this.form_render.getViewPanel().Refresh();
 
        }

        #endregion

        #region 辅助处理函数
        void EntDIPorveView_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }
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
                        if (dic.Keys.Contains("PatientData"))
                        {
                            ent4BannerDto = (dic["PatientData"] as BannerData).Ent4BannerDTO;
                        }
                        if (dic.Keys.Contains("IsInHospitalStation"))
                        {
                            ent4BannerDto.Id_ent = dic["EncounterID"].ToString();
                        }

                        // this.OnLoadData();
                    }

                    break;

                case UIEvent.SAVE:
                 this.Save();
                 break;
                case UIEvent.PRINT:
                    this.print_view();
                 break;

            }
        }

        #endregion
        #region 注册与反注册到工作站
        public void Regist(EventBroker eventBroker)
        {
            eventBroker.Register(this);
            if (Created)
                this.OnLoadData();
        }
        public void UnRegist(EventBroker eventBroker)
        {
            eventBroker.Unregister(this);
            if (Created)
                this.OnLoadData();
        }

        public void UpdatePatientInfo(object sender, DictionaryEventArgs eventArgs)
        {
            if (eventArgs.Data.Keys.Contains("PatientData"))
            {
                object obj = eventArgs.Data["PatientData"];
                this.ent4BannerDto = (obj as BannerData).Ent4BannerDTO;
                if (Created)
                    this.LoadData();

            }
        }

        #endregion


    }
}
