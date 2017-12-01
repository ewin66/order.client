
using System;
using System.Collections.Generic;
using System.ComponentModel;
using xap.rui.engine.eventbroker;
using xap.rui.engine;
using xap.rui.engine.eventbroker.Handlers;
using iih.bd.bc.udi;
using iih.ci.ord.common.utils.msg;
using iih.ci.diag.cidiag.d;
using xap.rui.appfw.async;
using xap.rui.appfw.extentions;

namespace iih.ci.ord.opemergency.assi.enthistory.view
{
    /// <summary>
    /// <para>描    述 :  历史病历、医嘱、诊断交互类</para>
    /// <para>说    明 :  与现就诊历史中病历、医嘱、诊断进行事件交互，获取病历、医嘱、诊断中数据，并返回给EntHistoryInitEvent</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.entphistory.view    </para>    
    /// <para>类 名 称 :  EntpHistoryContentEnvet					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  hums         				</para> 
    /// <para>修 改 人 :  hums         				</para> 
    /// <para>创建时间 :  2016/7/19 14:09:38             </para>
    /// <para>更新时间 :  2016/7/19 14:09:38             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class EntHistoryContentEnvet : EntHistoryBase
    {

        #region 变量定义区域

        //private CiDiagViewModel model;

        /// <summary>
        /// 缓存当前加载的事件类别
        /// 用于判断发送事件后门诊、住院的病历、医嘱、诊断是否都返回响应信息。当全部返回后在进行数据保存
        /// 门诊保存常量为 OUTP_MR、OP_CIDIAG、ORDER_ITEM
        /// 住院保存常量为 IP_CIDIAG、ORDER_ITEM
        /// 每次加载右侧内容区域时先清空，之后再根据加的是门诊还是住院进行辅助
        /// </summary>
        private List<string> currentItemKeyList = new List<string> { OUTP_MR, OP_CIDIAG, ORDER_ITEM };

        /// <summary>
        /// 加载门诊数据项时点击调用返回的数据种类（病历、诊断、医嘱）
        /// </summary>
        private readonly List<string> opItemKeyList = new List<string> { OUTP_MR, OP_CIDIAG, ORDER_ITEM };

        /// <summary>
        /// 加载住院数据项时点击调用返回的数据种类（诊断、医嘱） （注：住院病历不支持选取功能，如需要病历内容手动复制粘贴到门诊病历中）
        /// </summary>
        private readonly List<string> ipItemKeyList = new List<string> { IP_CIDIAG, ORDER_ITEM };

        /// <summary>
        /// 缓存获取的全部选中结果（病历、诊断、医嘱）
        /// 发送获取选择结果事件前先将要获取返回结果的类别设置到dic中，当全部结构都返回时在执行保存
        /// </summary>
        private Dictionary<string, object> selResultDic = new Dictionary<string, object>();
               

        #endregion

        #region 构造函数区域

        public EntHistoryContentEnvet()
        {
            InitializeComponent();

        }

        public EntHistoryContentEnvet(IContainer container)
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
        /// 病历加载事件
        /// </summary>
        [EventPublication("FireEntHistoryEmr")]
        public event EventHandler<DataEventArgs<Dictionary<string, string>>> FireEntHistoryEmr;
        public void fireEntHistoryEmr(DataEventArgs<Dictionary<string, string>> eventArgs)
        {
            if (FireEntHistoryEmr != null)
                this.FireEntHistoryEmr(this, eventArgs);
        }


        /// <summary>
        /// 住院诊断加载事件
        /// </summary>
        [EventPublication("FireSelEntHistory")]
        public event EventHandler<DataEventArgs<Dictionary<string, string>>> FireSelEntHistory;
        public void fireSelEntHistory(DataEventArgs<Dictionary<string, string>> eventArgs)
        {
            if (FireSelEntHistory != null)
                this.FireSelEntHistory(this, eventArgs);
        }

        /// <summary>
        /// 就诊相关内容中控件全选中状态事件
        /// <para>参数值bool true 全选中，false 取消全选中</para>
        /// </summary>
        ///
        [EventPublication("FireEntContentSelAll")]
        public event EventHandler<DataEventArgs<Dictionary<string, string>>> FireEntContentSelAll;
        private void SendEntContentSelAll()
        {
            if (FireEntContentSelAll != null)
            {
                FireEntContentSelAll(this, null);
            }
        }
        public void fireEntContentSelAll(DataEventArgs<bool> eventArgs)
        {

        }

        /// <summary>
        /// 发送就诊相关内容选择事件
        /// <para>与接收事件FireEntpContentSelResult相对应</para>
        /// </summary>
        [EventPublication("FireEntContentSel")]
        public event EventHandler<DataEventArgs<Dictionary<string, string>>> FireEntContentSel;
        public void fireEntContentSel(DataEventArgs<Dictionary<string, string>> eventArgs)
        {
            selResultDic.Clear();

            if (FireEntContentSel != null)
                this.FireEntContentSel(this, null);
        }

        #endregion

        #region 事件接收区域

        /// <summary>
        /// 返回就诊内容选择结果
        /// <para> 与发送事件：FireEntpContentSel相对应 </para>
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="args">Dictionary<string,object> key:返回数据对应来源分类 object 为各个业务页面返回的结果</param>
        [EventSubscription("FireEntContentSelResult", typeof(OnPublisher))]
        public void fireEntContentSelResult(object sender, DataEventArgs<Dictionary<string, object>> args)
        {
            Dictionary<string, object> result = args.Data;

            foreach (string key in result.Keys)
            {
                selResultDic.Add(key, result[key]);
            }

            if (isAllSelHasReturn() )
            {
                if (!isSelectedItem()) {
                    return;                       
                }
                this.EntHistoryInitEvent.SaveSelResultEvent(selResultDic);

                // 模式对话框关闭弹出窗口
                if (IsConfirmCloseAssiFrame)
                {
                    AssiViewFrame.Close();
                }
            }
        }

        #endregion

        #region 父类继承区域

        #endregion

        #region 内部事件区域

        #endregion

        #region 辅助处理函数

        /// <summary>
        /// 刷新右侧显示区
        /// </summary>
        public void refreshEntpContent()
        {
            //清空以已缓存的返回数据种类集合（病历、诊断、医嘱）
            currentItemKeyList.Clear();

            if (BizAssMessageBoxUtil.ShowPatIsNullMsg(this.Ent4BannerDTO, "就诊历史"))
            {
                return;
            }

            if (BdFcDictCodeConst.SD_CODE_ENTP_OP.Equals(this.Code_entp) || BdFcDictCodeConst.SD_CODE_ENTP_ET.Equals(this.Code_entp))// 门诊
            {
                // 缓存点击调用按钮时门诊需要返回的数据种类（病历、诊断、医嘱）
                currentItemKeyList.AddRange(opItemKeyList);                
            }
            else if (BdFcDictCodeConst.SD_CODE_ENTP_IP.Equals(this.Code_entp))// 住院
            {
                // 缓存点击调用按钮时门诊需要返回的数据种类（病历、诊断、医嘱）
                currentItemKeyList.AddRange(ipItemKeyList);                
            }

            // 刷新门诊住院，病历、医嘱、诊断展现
            this.refreshEntpInfo();
        }

        /// <summary>
        /// 刷新门诊/住院的病历，医嘱，诊断
        /// </summary>
        private void refreshEntpInfo()
        {
            Dictionary<string, string> ciDic = new Dictionary<string, string>();
            ciDic.Add("Id_ent", this.Id_ent);
            ciDic.Add("Code_entp", this.Code_entp);
            DataEventArgs<Dictionary<string, string>> eventArgs = new DataEventArgs<Dictionary<string, string>>(ciDic);


            //异步执行的委托
            AsyncExecuteDelegate workDelegate = workArgs =>
            {
                //参数是Argument，这是自己传入的，自行转化类型                
                // 异步调用，远程服务等。返回结果保存在参数的Result中。
                workArgs.Result = eventArgs;
            };
            AsyncDoneDelegate doneDelegate = doneArgs =>
            {
                //如果已经取消了，则返回
                if (doneArgs.Cancelled)
                    return;

                // 病历刷新
                this.fireEntHistoryEmr((DataEventArgs<Dictionary<string, string>>)doneArgs.Result);

                // 诊断刷新
                this.fireSelEntHistory(eventArgs);

            };

            workDelegate.AsyncExecute(eventArgs, doneDelegate);
        }       

        /// <summary>
        /// 判断所有的选择页面是否都返回了数据
        /// </summary>
        /// <returns></returns>
        private bool isAllSelHasReturn()
        {
            // 遍历需要返回的数据项key，如果已返回的数据中不包含待返回的数据项，则选择结果未全部返回，需要继续等待
            foreach (string key in currentItemKeyList)
            {
                if (!selResultDic.ContainsKey(key))
                {
                    return false;
                }
            }
            return true;
        }


        /// <summary>
        /// 判断点确定按钮时就诊历史是否选择内容
        /// </summary>
        /// <returns></returns>
        private bool isSelectedItem()
        {
            foreach (string key in selResultDic.Keys)
            {
                if (selResultDic[key] != null)
                {
                    // 住院诊断返回数据是0
                    List<CiDiagItemDO> list = selResultDic[key] as List<CiDiagItemDO>;
                    if (list != null &&  list.Count == 0) { continue; }
                    return true;
                }
            }
            if (BdFcDictCodeConst.SD_CODE_ENTP_IP.Equals(this.Code_entp))
            {
                BizAssMessageBoxUtil.ShowInforMsg("住院就诊中不支持病历回写，请至少选择一项：诊断、处置！");
            }
            else
            {
                BizAssMessageBoxUtil.ShowInforMsg("请至少选择一项：诊断、病历或处置！");
            }

            return false;
        }

        #endregion

        #region 状态处理区域

        #endregion
    }
}
