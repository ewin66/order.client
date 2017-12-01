using System;
using System.Collections.Generic;
using System.Linq;
using iih.ci.ord.cilab.viewmodel;
using iih.ci.ord.dto.orobsandlab.d;
using iih.en.pv.dto.d;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.control.basecontrol;
using xap.rui.control.tree.events;
using xap.rui.control.tree.otree.loader;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using xap.rui.engine.registers;

namespace iih.ci.ord.cilab.view
{
    public partial class LabDateTree : XapListControl, IWorkStationRegist
    {
        //public PatiVisitDO patDo = new PatiVisitDO();
        public Ent4BannerDTO ent4BannerDto;
        private LabDateTreeModel model;

        public LabDateTree()
        {
            InitializeComponent();
            Load += LabDateTree_Load;
            otree.TreeItemSelected += otree_TreeItemSelected;
        }

        private void otree_TreeItemSelected(object sender, TreeItemEventArgs e)
        {
            var labdto = otree.FocusedUserObject as OrObsAandLabDTO;
            if (labdto == null)
                return;
            FireSelected(labdto);
        }

        private void LabDateTree_Load(object sender, EventArgs e)
        {
            OnInit();
        }

        protected override void OnLoadData()
        {
            if ((Context["PatientData"] as BannerData) != null)
            {
                ent4BannerDto = (Context["PatientData"] as BannerData).Ent4BannerDTO;
            }
            if (ent4BannerDto != null && ent4BannerDto.Id_ent != null)
                model = new LabDateTreeModel(ent4BannerDto.Id_ent, "lab");

        }

        protected override void OnFillData()
        {
            otree.ClearTree();
            var listkey = new List<string>();
            if (model != null)
            {
                listkey.AddRange(model.treedict.Keys);
                var loader = new OTreeKeyLoader();
                foreach (string s in listkey)
                {
                    loader.Root = otree.GetRoot(s);
                    otree.LoadData(model.treedict[s], loader);
                }
            }

            otree.MoveFirst();
        }

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            var uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            var newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            var dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
          //  if (dic != null)

                switch (uiEvent)
                {
                    case UIEvent.LOAD:
                        if (dic != null)
                        {
                            object obj;
                            if (dic.TryGetValue("PatientData", out obj))
                            {
                                ent4BannerDto = (obj as BannerData).Ent4BannerDTO;
                            }
                            else if (dic.TryGetValue("ent4DTO", out obj))
                            {
                                ent4BannerDto = obj as Ent4BannerDTO;
                                if (Created)
                                {
                                    LoadData();
                                }
                            }
                        }
                        break;
                    case UIEvent.RELOAD:

                    {
                        object obj;
                        if (dic.TryGetValue("PatientData", out obj))
                        {
                            ent4BannerDto = (obj as BannerData).Ent4BannerDTO;
                        }
                        else if (dic.TryGetValue("ent4DTO", out obj))
                        {
                            ent4BannerDto = obj as Ent4BannerDTO;
                            if (Created)
                            {
                                LoadData();
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
                OnLoadData();
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
                    LoadData();
            }
        }

        #endregion
    }
}