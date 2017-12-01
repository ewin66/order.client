using xap.mw.log;
using xap.cli.sdk.form;
using System.Windows.Forms;
using iih.bd.bc.udi;

namespace iih.ci.ord.opemergency.assi.enthistory.view
{
    /// <summary>
    /// <para>描    述 :  历史就诊操作按钮页面</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.enthistory.view    </para>    
    /// <para>类 名 称 :  EntHistoryBtn					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2016/7/25 10:40:09             </para>
    /// <para>更新时间 :  2016/7/25 10:40:09             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class EntHistoryBtn : EntHistoryBase
    {

        #region 变量定义区域

        /// <summary>
        /// 就诊历史弹出页面中用于事件交互的id
        /// </summary>
        private const string ENT_HISTORY_CONTENT_ID = "EntHistoryContent";

        /// <summary>
        /// 就诊历史弹出页面中用于事件交互对象
        /// </summary>
        private EntHistoryContent entHistoryContent;

        #endregion

        #region 构造函数区域

        public EntHistoryBtn()
        {
            InitializeComponent();
        }

        #endregion

        #region 公开属性区域        

        public EntHistoryFrame EntHistoryFrame { get; set; }

        /// <summary>
        /// 关闭窗口按钮显示名称
        /// </summary>
        public string CloseBtnText { get; set; }

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

        private void EntHistoryBtn_Load(object sender, System.EventArgs e)
        {
            /// 加载事件交互对象            
            entHistoryContent = this.Context.Config.GetInstance(ENT_HISTORY_CONTENT_ID) as EntHistoryContent;
            if (entHistoryContent == null)
            {
                LogManager.GetLogger().ErrorEx("根据Clazz id属性[" + ENT_HISTORY_CONTENT_ID + "]，获取XapBaseControl对象失败失败！");
            }

            // 诊毕状态设置按钮不可用
            if (this.Ent4BannerDTO.Sd_status == EnDictCodeConst.SD_ENSTATUS_OP_FINISH)
            {
                this.xBtnOK.Enabled = false;
            }

            if (!string.IsNullOrEmpty(CloseBtnText))
            {
                // 传入的关闭按钮名称
                this.xBtnClose.Text = CloseBtnText;
            }

        }

        /// <summary>
        /// 点击打印病历按钮
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void XBtnPrint_MouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            if (ValidateEventContent())
            {
                entHistoryContent.FireEmrPrintEvent(null);
            }
        }

        /// <summary>
        /// 点击病历打印预览
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void XBtnPrintView_MouseClick(object sender, MouseEventArgs e)
        {
            if (ValidateEventContent())
            {
                entHistoryContent.FireEmrPrintViewEvent(null);
            }
        }

        /// <summary>
        /// 点击确定按钮事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void XBtnOK_MouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            //string classId = "EntHistoryContent";
            //EntHistoryContent entHistoryContent = this.Context.Config.GetInstance(classId) as EntHistoryContent;
            if (ValidateEventContent())
            {
                entHistoryContent.FireEntContentSel(null);                
            }
        }

        /// <summary>
        /// 点击取消按钮事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void XBtnClose_MouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            if (AssiViewFrame != null)
            {
                this.FindForm().Close();
            }
            else if (EntHistoryFrame != null)
            {
                EntHistoryFrame.Close();
            }
        }

        #endregion

        #region 辅助处理函数

        /// <summary>
        /// 校验事件交互组件是否为空
        /// </summary>
        /// <returns></returns>
        private bool ValidateEventContent()
        {

            if (this.entHistoryContent == null)
            {
                MessageBoxEx.Show("加载事件交互对象【EntHistoryContent】失败！", "就诊历史", MessageBoxButtons.OK, MessageBoxIconEx.Error, MessageBoxDefaultButton.Button1);
                return false;
            }

            return true;
        }

        #endregion

        #region 状态处理区域

        #endregion
    }
}
