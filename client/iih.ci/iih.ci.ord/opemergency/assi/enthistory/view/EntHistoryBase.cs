using System.ComponentModel;
using xap.rui.control.basecontrol;
using iih.en.pv.dto.d;
using xap.rui.engine;
using xap.cli.sdk.form;

namespace iih.ci.ord.opemergency.assi.enthistory.view
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.entphistory.view    </para>    
    /// <para>类 名 称 :  EntpHistoryBase					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  hums         				</para> 
    /// <para>修 改 人 :  hums         				</para> 
    /// <para>创建时间 :  2016/7/18 11:32:19             </para>
    /// <para>更新时间 :  2016/7/18 11:32:19             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class EntHistoryBase : XapBaseControl
    {


        #region 变量定义区域

        /// <summary>
        /// 门诊病历数据标志,(发送诊断选中结果时，作为数据分类key值)
        /// </summary>
        protected const string OUTP_MR = "OutpMr";

        /// <summary>
        /// 门诊诊断数据标志,(发送诊断选中结果时，作为数据分类key值)
        /// </summary>
        protected const string OP_CIDIAG = "OpCiDiag";

        /// <summary>
        /// 住院诊断数据标志,(发送诊断选中结果时，作为数据分类key值)
        /// </summary>
        protected const string IP_CIDIAG = "IpCiDiag";
        /// <summary>
        /// 医嘱数据标志,(发送医嘱选中结果时，作为数据分类key值)
        /// </summary>
        protected const string ORDER_ITEM = "OrderItem";


        /// <summary>
        /// 病历
        /// </summary>
        protected const string EMR_HISTORY = "emrHistory";
        /// <summary>
        /// 诊断历史
        /// </summary>
        protected const string CIDI_HISTORY = "cidiHistory";
        /// <summary>
        /// 医嘱历史
        /// </summary>
        protected const string ORDER_ITEM_HISTROY = "orderItemHistory";

        /// <summary>
        /// 加载助手的容器对象
        /// </summary>
        public  XForm AssiViewFrame { get; set; }       

        /// <summary>
        /// 点击确定按钮是否关闭窗口
        /// </summary>
        public bool IsConfirmCloseAssiFrame { get; set; }

        #endregion

        #region 构造函数区域

        public EntHistoryBase()
        {
            InitializeComponent();
        }

        public EntHistoryBase(IContainer container)
        {
            container.Add(this);

            InitializeComponent();
        }

        #endregion

        #region 公开属性区域

        /// <summary>
        /// 与门诊病历、医嘱、诊断交互的类
        /// </summary>
        public EntHistoryInitEvent EntHistoryInitEvent { get; set; }
        /// <summary>
        /// banner数据
        /// </summary>
        public Ent4BannerDTO Ent4BannerDTO { get; set; }
        /// <summary>
        /// 当前环境信息
        /// </summary>
        public BaseContext BaseContext { get; set; }
        /// <summary>
        /// 就诊类型 门诊 00、急诊 01 、体检 02 、住院 10、家庭病床 20
        /// </summary>
        public string Code_entp { get; set; }
        /// <summary>
        /// 就诊id
        /// </summary>
        public string Id_ent { get; set; }

        #endregion

        #region 命令定义区域

        #endregion

        #region 事件发送区域        

        #endregion

        #region 事件接收区域

        #endregion

        #region 父类继承区域

        #endregion

        #region 内部事件区域

        #endregion

        #region 辅助处理函数

        #endregion

        #region 状态处理区域

        #endregion
    }
}
