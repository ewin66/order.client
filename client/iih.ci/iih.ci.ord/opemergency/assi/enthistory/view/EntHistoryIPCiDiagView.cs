
using System;
using System.Collections.Generic;
using System.Linq;
using iih.ci.ord.opemergency.assi.enthistory.viewmodel;
using xap.sys.xbd.udi.d;
using iih.en.pv.dto.d;
using xap.rui.bizcontrol.DiagnosticTimeline;
using System.Drawing;
using System.Windows.Forms;
using iih.ci.diag.cidiag.d;
using xap.rui.engine;
using xap.rui.bizcontrol.bannercontrol;
using iih.bd.bc.udi;
using xap.rui.bizcontrol.DiagnosticTimeline.TimeLineConfig;

namespace iih.ci.ord.opemergency.assi.enthistory.view
{
    /// <summary>
    /// <para>描    述 :  住院诊断</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.enthistory.view    </para>    
    /// <para>类 名 称 :  EntHistoryIPCiDiagView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2016/8/3 10:01:14             </para>
    /// <para>更新时间 :  2016/8/3 10:01:14             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class EntHistoryIPCiDiagView : EntHistoryContentBase
    {
        #region 变量定义区域

        private CiDiagViewModel model;
        private Ent4BannerDTO ent4BannerDto;
        /// <summary>
        /// 诊断类别
        /// </summary>
        private UdidocDO[] disysArr;

        #endregion

        #region 构造函数区域

        public EntHistoryIPCiDiagView()
        {
            InitializeComponent();
        }

        #endregion

        #region 公开属性区域

        #endregion

        #region 命令定义区域

        #endregion

        #region 事件发送区域


        #endregion



        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            if (this.model == null)
            {
                this.model = new CiDiagViewModel(this.BaseContext);
            }
            disysArr = this.model.GetIddisysArr();
        }

        protected override void OnFillData()
        {
            this.xapFormControl.RenderControls.Clear();

            List<CardContainer> cardList = this.getCardInfoList();

            group.Size = new System.Drawing.Size(1000, 568);
            group.Location = new Point(40, 0);
            group.CardContainers = cardList;

            group.Dock = DockStyle.Fill;
            group.IsShowBtn = false;
            this.xapFormControl.AddRender(group);
        }

        /// <summary>
        /// 获取选中的住院诊断
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="data"></param>
        /// <returns></returns>
        protected override Dictionary<string, object> GetEntContentSel(object sender, Dictionary<string, string> data)
        {
            List<CiDiagItemDO> itemList = group.GetSelectedNodes();
            return new Dictionary<string, object>() { { IP_CIDIAG, itemList } };
        }

        #endregion

        #region 内部事件区域

        #endregion

        #region 辅助处理函数
        void IpCiDiagView_Load(object sender, EventArgs e)
        {
            // this.OnInit();
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
                    Dictionary<string, Object> data = eventArgs.Data[UIConst.DATA] as Dictionary<string, Object>;
                    if (data != null)
                    {
                        ent4BannerDto = (data["PatientData"] as BannerData).Ent4BannerDTO;
                        if (ent4BannerDto != null)
                        {
                            this.Id_ent = ent4BannerDto.Id_ent;
                        }
                        this.OnLoadData();

                    }
                    break;
                case UIEvent.ADD:
                    //  this.add();
                    break;
                case "ListSelected":
                    this.LoadData();
                    break;
                default:
                    break;
            }
        }

        #endregion


        public void UpdatePatientInfo(object sender, DictionaryEventArgs eventArgs)
        {
            if (eventArgs.Data.Keys.Contains("PatientData"))
            {
                object obj = eventArgs.Data["PatientData"];
                ent4BannerDto = (obj as BannerData).Ent4BannerDTO;
                this.Id_ent = ent4BannerDto.Id_ent;
                if (Created)
                    this.LoadData();
            }
        }

        /// <summary>
        /// 获取诊断构造的诊断卡集合
        /// </summary>
        /// <returns></returns>
        private List<CardContainer> getCardInfoList()
        {
            if (string.IsNullOrEmpty(this.Id_ent))
            {

                return new List<CardContainer>();
            }

            return this.getCardListByCidiagAgg();
        }

        /// <summary>
        /// 通过诊断Agg获取诊断卡集合
        /// </summary>
        /// <returns></returns>
        private List<CardContainer> getCardListByCidiagAgg()
        {

            //诊断信息卡集合
            List<CardContainer> cardList = new List<CardContainer>();
            CidiagAggDO[] aggDOs = model.GetCidiagAggDOs(this.Id_ent);

            if (aggDOs == null || aggDOs.Length == 0)
            {
                return cardList;
            }

            foreach (CidiagAggDO aggDO in aggDOs)
            {

                CardContainer cardInfo = this.getCardInfo(aggDO.getParentDO());
                cardInfo.RootId = "~";

                //设置诊断卡内容区域显示
                List<CiDiagItemDO>[] t = this.GetCiDiagItemList(aggDO.getCiDiagItemDO());
                cardInfo.DataSource = t;

                cardList.Add(cardInfo);
            }
            return cardList;
        }


        /// <summary>
        /// 通过临床诊断获取诊断展现卡的对象
        /// </summary>
        /// <param name="cidiag">临床诊断</param>
        /// <returns></returns>
        private CardContainer getCardInfo(CiDiagDO cidiag)
        {
            CardContainer cardInfo = new CardContainer(group);

            if (cidiag.Sd_ditp == CiDictCodeConst.SD_OPDI || cidiag.Sd_ditp == CiDictCodeConst.SD_FIRST || cidiag.Sd_ditp == CiDictCodeConst.SD_INHOSPITAL)
            {
                cardInfo.CardPosition = CardPosition.right;
            }
            else
            {
                cardInfo.CardPosition = CardPosition.left;
            }

            cardInfo.CardTitle = cidiag.Name_ditp;

            //info1.CardContent = "1,眼硅胶排异反应\n2,肺移植失败——1321324341435436547667879809-0=-";
            if ((bool)cidiag.Fg_sign)
            {
                cardInfo.CardPerson = cidiag.Signname;
                cardInfo.CardTime = Convert.ToDateTime(cidiag.Dt_sign.ToString());
            }
            else
            {
                cardInfo.CardPerson = cidiag.Empname;
                cardInfo.CardTime = Convert.ToDateTime(cidiag.Dt_di.ToString());
            }

            return cardInfo;
        }

        private List<CiDiagItemDO>[] GetCiDiagItemList(CiDiagItemDO[] cidiItems)
        {
            List<List<CiDiagItemDO>> itemsList = new List<List<CiDiagItemDO>>();

            // 诊断Dic，其中key 为诊断类别
            Dictionary<string, List<CiDiagItemDO>> itemDic = new Dictionary<string, List<CiDiagItemDO>>();

            //遍历诊断明细，将中、西诊断分组
            foreach (CiDiagItemDO item in cidiItems)
            {
                if (!itemDic.ContainsKey(item.Id_disys))
                {
                    itemDic.Add(item.Id_disys, new List<CiDiagItemDO>());
                }

                itemDic[item.Id_disys].Add(item);
            }

            foreach (UdidocDO udidocDO in disysArr)
            {
                if (itemDic.ContainsKey(udidocDO.Id_udidoc))
                {
                    itemsList.Add(itemDic[udidocDO.Id_udidoc]);
                }
            }

            return itemsList.ToArray();
        }

    }
}
