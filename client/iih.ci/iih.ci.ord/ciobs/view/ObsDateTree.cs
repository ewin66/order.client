using System;
using System.Collections.Generic;
using System.Linq;
using iih.ci.ord.cilab.viewmodel;
using iih.ci.ord.dto.orobsandlab.d;
using iih.en.pv.dto.d;
using iih.en.pv.pativisit.d;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.control.basecontrol;
using xap.rui.control.tree.otree.loader;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using xap.rui.engine.registers;

namespace iih.ci.ord.ciobs.view
{
    public partial class ObsDateTree : XapListControl, IWorkStationRegist
    {
        private LabDateTreeModel model;
       // public PatiVisitDO patDo = new PatiVisitDO();
        public Ent4BannerDTO ent4BannerDto;
        public ObsDateTree()
        {
            InitializeComponent();
            this.Load += new EventHandler(LabDateTree_Load);
            this.otree.TreeItemSelected += new xap.rui.control.tree.events.TreeItemEventHandler(otree_TreeItemSelected);
        }

        void otree_TreeItemSelected(object sender, xap.rui.control.tree.events.TreeItemEventArgs e)
        {
            OrObsAandLabDTO labdto = this.otree.FocusedUserObject as OrObsAandLabDTO;
            if (labdto == null)
                return;
            this.FireSelected(labdto);
        }

        void LabDateTree_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

        protected override void OnLoadData()
        {
            if ((this.Context["PatientData"] as BannerData) != null)
            {
                this.ent4BannerDto = (this.Context["PatientData"] as BannerData).Ent4BannerDTO;

            }
            if (this.ent4BannerDto != null && this.ent4BannerDto.Id_ent != null)
            model = new LabDateTreeModel(this.ent4BannerDto.Id_ent, "obs");

        }

        protected override void OnFillData()
        {
            this.otree.ClearTree();
             List<string> listkey = new List<string>();
             if (this.model != null)
            {
                   listkey.AddRange(this.model.treedict.Keys);
                OTreeKeyLoader loader = new OTreeKeyLoader();
                foreach (string s in listkey)
                {
                    loader.Root = otree.GetRoot(s);
                    otree.LoadData(this.model.treedict[s], loader);
                }
            }

            otree.MoveFirst();
         
        }

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            Dictionary<string, object> dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                
            switch (uiEvent)
            {
                case UIEvent.LOAD:

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
                            if (this.Created)
                            {
                                this.LoadData();
                            }
                        }
 
                    }
                    break;
                case UIEvent.RELOAD:
                    {
                        object obj;
                        if (dic.TryGetValue("PatientData", out obj))
                        {
                            this.ent4BannerDto = (obj as BannerData).Ent4BannerDTO;
                        }
                        else if (dic.TryGetValue("ent4DTO", out obj))
                        {
                            this.ent4BannerDto = obj as Ent4BannerDTO;
                            if (this.Created)
                            {
                                this.LoadData();
                            }
                        }

                    }
                    break;
                case UIEvent.REFRESH:
                    LoadData();
                    break;
                default:
                    break;
            }
        }

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
        }

        public void UpdatePatientInfo(object sender, DictionaryEventArgs eventArgs)
        {

            if (eventArgs.Data.Keys.Contains("PatientData"))
            {
                object obj = eventArgs.Data["PatientData"];
                ent4BannerDto = (obj as BannerData).Ent4BannerDTO;
                if (Created)
                    this.LoadData();

            }
        }

        #endregion
    }
}
