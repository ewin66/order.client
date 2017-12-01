
using System;
using System.ComponentModel;
using iih.ci.ord.opemergency.assi.enthistory.viewmodel;
using xap.rui.engine.eventbroker;
using xap.rui.engine;
using iih.en.pv.dto.d;
using xap.rui.bizcontrol.Historyofrecords.card;

namespace iih.ci.ord.opemergency.assi.enthistory.view
{
    /// <summary>
    /// <para>描    述 :  就诊历史列表 </para>
    /// <para>说    明 :  展示历次门诊、住院的就诊记录</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.entphistory    </para>    
    /// <para>类 名 称 :  EntpHistoryInit </para> 
    /// <para>版 本 号 :  v1.0.0.0 </para> 
    /// <para>作    者 :  hums</para> 
    /// <para>修 改 人 :  hums</para> 
    /// <para>创建时间 :  2016/7/14 11:00:39 </para>
    /// <para>更新时间 :  2016/7/14 11:00:39 </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class EntHistory : EntHistoryBase
    {

        #region 变量定义区域

        private EntHistoryViewModel model;

        #endregion

        #region 构造函数区域

        public EntHistory()
        {
            InitializeComponent();
        }

        public EntHistory(IContainer container)
        {
            container.Add(this);

            InitializeComponent();
        }

        #endregion

        #region 公开属性区域

        #endregion

        #region 命令定义区域

        #endregion

        #region 事件发送区域

        /// <summary>
        /// 发送选中就诊历史事件
        /// </summary>
        [EventPublication("FirEntHisDiDTO")]
        public event EventHandler<DataEventArgs<EntHisDiDTO>> FirEntHisDiDTO;
        private void firEntHisDiDTO(RecordCardInfo recordCardInfo)
        {
            var entHisDiDTO = this.model.getEntHisDiDTO(recordCardInfo);
            if (entHisDiDTO != null)
            {
                DataEventArgs<EntHisDiDTO> de = new DataEventArgs<EntHisDiDTO>(entHisDiDTO);
                this.FirEntHisDiDTO(this, de);
            }

        }

        #endregion

        #region 事件接收区域

        protected override void OnLoadData()
        {
            this.model = new EntHistoryViewModel(this.Ent4BannerDTO);
        }

        protected override void OnFillData()
        {
            if (model != null)
            {
                this.recordView.CardDataSource = this.model.Recordinfolist;
                if (this.model.Recordinfolist.Count > 0)
                {
                    this.firEntHisDiDTO(this.model.Recordinfolist[0]);
                }
            }
        }

        #endregion

        #region 父类继承区域

        #endregion

        #region 内部事件区域

        private void EntpHistory_Load(object sender, System.EventArgs e)
        {
            if (this.Created) {
                // 获取就诊历史
                this.OnInit();
            }            
        }

        /// <summary>
        /// 就诊历史点击事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void recordView_CardClick(object sender, System.EventArgs e)
        {
            var recordCard = sender as RecordCard;
            this.firEntHisDiDTO(recordCard.DataSource);
        }

        #endregion

        #region 辅助处理函数

        #endregion

        #region 状态处理区域

        #endregion
    }
}
