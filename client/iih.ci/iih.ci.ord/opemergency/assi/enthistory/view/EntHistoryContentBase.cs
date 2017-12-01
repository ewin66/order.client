
using System;
using System.Collections.Generic;
using System.ComponentModel;
using xap.rui.engine.eventbroker;
using xap.rui.engine;
using xap.rui.engine.eventbroker.Handlers;

namespace iih.ci.ord.opemergency.assi.enthistory.view
{
    /// <summary>
    /// <para>描    述 :  就诊历史右侧展现区域基类</para>
    /// <para>说    明 :  门诊诊断、医嘱，住院医嘱，以及与门诊整体事件交互基类</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.enthistory.view    </para>    
    /// <para>类 名 称 :  EntHistoryContentBase					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2016/8/3 14:34:30             </para>
    /// <para>更新时间 :  2016/8/3 14:34:30             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class EntHistoryContentBase : EntHistoryBase
    {

        #region 变量定义区域


        #endregion

        #region 构造函数区域


        public EntHistoryContentBase()
        {
            InitializeComponent();
        }

        public EntHistoryContentBase(IContainer container)
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
        /// 获取选中医嘱、病历结果事件
        /// </summary>
        [EventPublication("FireEntContentSelResult")]
        public event EventHandler<DataEventArgs<Dictionary<string, object>>> FireEntContentSelResult;
        private void fireEntContentSelResult(Dictionary<string, object> args)
        {
            DataEventArgs<Dictionary<string, object>> eventArgs = new DataEventArgs<Dictionary<string, object>>(args);

            if (FireEntContentSelResult != null)
                this.FireEntContentSelResult(this, eventArgs);
        }

        #endregion

        #region 事件接收区域

        /// <summary>
        /// 接收就诊历史选择事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="agrs"></param>
        [EventSubscription("FireSelEntHistory", typeof(OnPublisher))]
        public void fireSelEntHistory(object sender, DataEventArgs<Dictionary<string, string>> args)
        {
            Dictionary<string, string> entpDic = args.Data as Dictionary<string, string>;
            if (entpDic != null)
            {
                this.Id_ent = entpDic["Id_ent"];
                this.Code_entp = entpDic["Code_entp"];
                if (this.Created)
                {
                    this.LoadData();
                }
                
            }
        }


        /// <summary>
        /// 接收获取当前页面已选内容事件
        /// <para>与接收事件FireEntpContentSelResult相对应</para>
        /// </summary>
        [EventSubscription("FireEntContentSel", typeof(OnPublisher))]
        public void fireEntContentSel(object sender, DataEventArgs<Dictionary<string, string>> args)
        {
            //Dictionary<string, string> entpDic = args.Data as Dictionary<string, string>;
            this.SendEntContentSelResult(sender, null);
        }

        #endregion

        #region 子类继承区域

        /// <summary>
        /// 获取当前页面选中的内容
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="data">null</param>
        /// <returns>Dictionary<string,object> </returns>
        protected virtual Dictionary<string, object> GetEntContentSel(object sender, Dictionary<string, string> data)
        {
            return null;
        }

        #endregion

        #region 父类继承区域

        #endregion

        #region 内部事件区域

        #endregion

        #region 辅助处理函数

        private void SendEntContentSelResult(object sender, Dictionary<string, string> data)
        {
            Dictionary<string, object> selResult = this.GetEntContentSel(sender, data);

            this.fireEntContentSelResult(selResult);
        }

        #endregion

        #region 状态处理区域

        #endregion


        #region 事件接收区域



        #endregion
    }
}
