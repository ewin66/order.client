using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;
using iih.ci.ord.ciconsresponse.viewmodel;
using iih.ci.ord.cior.d;
using iih.ci.ord.ciordcons.dialog;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.consrpt.d;
using iih.en.pv.dto.d;
using iih.en.pv.pativisit.d;
using xap.mw.serviceframework.extentions;
using xap.rui.appfw.collections;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.control.tree.events;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using xap.rui.engine.registers;

namespace iih.ci.ord.ciconsresponse.view
{
    public partial class ConsRptTreeView : XapListControl, IWorkStationRegist
    {
        
        #region 变量定义区域

        private ConsItemViewModel model;
        //public PatiVisitDO patDo = new PatiVisitDO();
        public Ent4BannerDTO ent4BannerDto;
        private CiorappconsultAggDO aggDo;
        #endregion

        #region 构造函数区域

        public ConsRptTreeView()
        {
            InitializeComponent();
            this.Load += new EventHandler(ConsRptTreeView_Load);
            this.oTree.TreeItemSelected += new xap.rui.control.tree.events.TreeItemEventHandler(OTreeItemSelected);
        }
        
        #endregion

        #region 公开属性区域
        
        #endregion

        #region 命令定义区域

        
        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            this.ent4BannerDto = (this.Context["PatientData"] as BannerData).Ent4BannerDTO;
            this.model = new ConsItemViewModel(this.ent4BannerDto.Id_ent);
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            this.oTree.ClearTree();

            this.oTree.LoadData(this.model.TreeModel);
            oTree.ExpandToLevel(1);
            this.oTree.MoveFirst();
        }

       

        #endregion

        #region 内部事件区域

        void ConsRptTreeView_Load(object sender, EventArgs e)
        {
            OnInit();
        }

        void ConsComplete()
        {
            if (this.oTree.FocusedUserObject == null) return;
            XapAggDO<CiorappconsultAggDO> aggDo = this.model.GetAggDo((this.oTree.FocusedUserObject as OrdApConsDO).Id_apcons);
            if (aggDo == null) return;
            ConsCompleteDialog dialog = new ConsCompleteDialog(aggDo) { Dock = DockStyle.Fill, Size = new Size(400, 300) };
            //CiorappconsultAggDO appconsultaggDo = this.model.GetAggDo((this.oTree.FocusedUserObject as OrdApConsDO).Id_apcons);
            if (this.aggDo == null) return;
            if (this.aggDo.getParentDO().Sd_su_cons == "4" || this.aggDo.getParentDO().Sd_su_cons == "5" ||
                this.aggDo.getParentDO().Sd_su_cons == "6")
            {
                dialog.ShowDialog();
                if (dialog.DialogResult == DialogResult.OK)
                {
                    CiorappconsultAggDO consAggDo = dialog.aggdo.AggDO;
                    this.model.CompleteCons(consAggDo);
                    FireEvent("completesuccess");
                }
            }
            else
            {
                this.ShowAlert("完成会诊已执行，不能再次操作");
            }


        }
        #endregion

        #region 辅助处理函数

        /// <summary>
        /// 发送树选中事件给card
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="args"></param>
        private void OTreeItemSelected(object sender, TreeItemEventArgs args)
        {
            this.FireSelected(this.oTree.FocusedUserObject);
            aggDo = this.model.GetAggDo((this.oTree.FocusedUserObject as OrdApConsDO).Id_apcons);
            if (aggDo==null)return;
            if (aggDo.getParentDO().Sd_su_cons == "4" || aggDo.getParentDO().Sd_su_cons == "5" ||
                aggDo.getParentDO().Sd_su_cons == "6")
            {
                FireEvent("complete");
            }
        }
        //打印lxy
        private void rptPrint()
        {
            //this.Context.FunCode;
            if (this.aggDo == null)
            {
                this.ShowAlert("请选择一条会诊！");
                return;
            }
            CiOrdConsRptDO rptDo = this.model.findRpt(this.aggDo.getParentDO().Id_apcons);
            if (rptDo == null)
            {
                this.ShowAlert("请先生成会诊记录！");
                return;
            }
            ConsRptPrint printview = new ConsRptPrint(this.ent4BannerDto, this.aggDo, rptDo);
            printview.ToPrint();
        }

        void FireEvent(string eventstr)
        {
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data.Add(UIConst.UI_EVENT, eventstr);
            base.FireEventSent(this, args);
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
                            this.ent4BannerDto = (dic["PatientData"] as BannerData).Ent4BannerDTO;
                        }

                    }

                    break;
                case "conscom":
                    ConsComplete();
                    break;
                case "completesuccess":
                   this.SetStatusInfo("完成会诊");
                    break;
                case "print":
                    this.rptPrint();
                    break;
               default:
                    break;
            }
        }


        #region 注册与反注册到工作站
        public void Regist(EventBroker eventBroker)
        {
            eventBroker.Register(this);
        }
        public void UnRegist(EventBroker eventBroker)
        {
            eventBroker.Unregister(this);
        }
        #endregion

        public override void OnDeptChanged()
        {
            this.ent4BannerDto.Id_ent = "";
            this.LoadData();
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
