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

/********************************************************************************

** 作者： 李程

** 创始时间：2016-6-30

** 修改人：李程

** 修改时间：2016-6-30

** 描述： 检验功能树界面


*********************************************************************************/

namespace iih.ci.ord.cilab.view
{
    public partial class LabTree : XapListControl, IWorkStationRegist
    {
        //banner信息
        public Ent4BannerDTO ent4BannerDto;
        private LabTreeModel model;

        public LabTree()
        {
            InitializeComponent();
            Load += LabTree_Load;
            otree.TreeItemSelected += otree_TreeItemSelected;
        }

        private void otree_TreeItemSelected(object sender, TreeItemEventArgs e)
        {
            var labdto = otree.FocusedUserObject as OrObsAandLabDTO;
            if (labdto == null)
                return;
            FireSelected(labdto);
        }

        private void LabTree_Load(object sender, EventArgs e)
        {
            LoadData();
        }

        protected override void OnLoadData()
        {
            // base.OnLoadData();
            if ((Context["PatientData"] as BannerData) != null)
            {
                ent4BannerDto = (Context["PatientData"] as BannerData).Ent4BannerDTO;
            }
            if (ent4BannerDto != null && ent4BannerDto.Id_ent != null)
                model = new LabTreeModel(ent4BannerDto.Id_ent, "lab");
        }

        protected override void OnFillData()
        {
            otree.ClearTree();
            var loader = new OTreeKeyLoader();
            if (model != null)
            {
                otree.LoadData(model.SrvCaCollection, loader);
                otree.LoadData(model.ObsDateCollection, loader);
            }

            otree.MoveFirst();
        }

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            var uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            var newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            var dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
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

        #region 辅助处理函数

        public override void OnSelected(object sender, TargetEventArgs e)
        {
            if (sender == this) //del
                return;
            //obsDTO = e.Object as OrObsAandLabDTO;
            ent4BannerDto = e.Object as Ent4BannerDTO;
            if (ent4BannerDto != null)
            {
                if (Created)
                {
                    LoadData();
                }
            }
        }

        #endregion
    }
}