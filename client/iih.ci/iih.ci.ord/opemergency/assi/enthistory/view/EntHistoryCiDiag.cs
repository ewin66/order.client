using System.Collections.Generic;
using System.ComponentModel;
using iih.ci.ord.opemergency.assi.enthistory.viewmodel;
using iih.ci.diag.cidiag.d;
using System.Drawing;
using xap.cli.sdk.render;
using xap.rui.engine;

namespace iih.ci.ord.opemergency.assi.enthistory.view
{
    /// <summary>
    /// <para>描    述 :  门诊诊断列表</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.entphistory.view    </para>    
    /// <para>类 名 称 :  EntpHistoryCiDiag					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  hums         				</para> 
    /// <para>修 改 人 :  hums         				</para> 
    /// <para>创建时间 :  2016/7/20 16:14:35             </para>
    /// <para>更新时间 :  2016/7/20 16:14:35             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class EntHistoryCiDiag : EntHistoryContentBase
    {


        #region 变量定义区域
        /// <summary>
        /// 诊断复选框的名称，用于遍历复选框
        /// </summary>
        private const string CIDI_ITEM = "CiDiItem";

        /// <summary>
        /// 诊断服务
        /// </summary>
        private CiDiagViewModel model;

        private List<CiDiagItemDO> ciDiagItemList;

        /// <summary>
        /// 复选框Size
        /// </summary>
        private static Size BOX_SIZE = new Size(140, 24);
        /// <summary>
        /// 复选框水平间距
        /// </summary>
        private const int HORIZONTAL_SPACE = 12;
        /// <summary>
        /// 复选框垂直间距
        /// </summary>
        private const int VERTICAL_SPACE = 6;

        #endregion

        #region 构造函数区域

        public EntHistoryCiDiag()
        {
            InitializeComponent();
        }

        public EntHistoryCiDiag(IContainer container)
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

        #endregion

        #region 事件接收区域

        #endregion

        #region 父类继承区域

        /// <summary>
        /// 加载诊断数据
        /// </summary>
        protected override void OnLoadData()
        {
            if (!string.IsNullOrEmpty(this.Id_ent))
            {
                if (model == null)
                {
                    model = new CiDiagViewModel(this.BaseContext);
                }
                ciDiagItemList = model.GetCiDiagItemList(this.Id_ent);
            }
        }

        protected override void OnFillData()
        {
            this.scrollBarPanel.RemoveRenderAll();

            if (ciDiagItemList != null && ciDiagItemList.Count > 0)
            {

                this.scrollBarPanel.AddRender(this.ciXCheckBox);

                //ciDiagItemList 中索引值
                int itmeIndex = 0;

                // 动态创建XCheckBox的行、列数
                int rowCnt = this.getRowCnt(ciDiagItemList.Count);
                int columnCnt = this.getColumnCnt();

                // 动态创建XCheckBox的起始坐标
                int startX = this.ciXCheckBox.Location.X + this.ciXCheckBox.Size.Width + HORIZONTAL_SPACE;
                int startY = this.ciXCheckBox.Location.Y;

                // 动态创建XCheckBox控件的坐标
                int tempX = 0;
                int tempY = 0;

                // 按行构建XCheckBox控件
                for (int i = 0; i < rowCnt; i++)
                {
                    tempY = i * (BOX_SIZE.Height + VERTICAL_SPACE) + startY;
                    for (int j = 0; j < columnCnt; j++)
                    {
                        tempX = j * (BOX_SIZE.Width + HORIZONTAL_SPACE) + startX;

                        if (itmeIndex == ciDiagItemList.Count)
                        {
                            break;
                        }

                        CiDiagItemDO ciDiagItem = ciDiagItemList[itmeIndex];
                        itmeIndex++;

                        XCheckBox xCheckBox = new XCheckBox();
                        xCheckBox.Size = BOX_SIZE;
                        //xCheckBox.Alignment = StringAlignment.Near;
                        xCheckBox.Text = ciDiagItem.Id_didef_name;
                        xCheckBox.ValueObj = ciDiagItem;
                        // 设置显示tooltip否则不能文字超出XCheckBox宽度的文字会正常显示，而不是以tooltip方式显示
                        xCheckBox.IsShowToolTip = true;
                        
                        xCheckBox.Location = new Point(tempX, tempY);
                        xCheckBox.Name = CIDI_ITEM;

                        this.scrollBarPanel.AddRender(xCheckBox);
                    }
                }
            }

            this.scrollBarPanel.getScrollBarRect();
            this.scrollBarPanel.Refresh();
            this.Refresh();

        }

        /// <summary>
        /// 获取选中的诊断明细
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="data"></param>
        /// <returns></returns>
        protected override Dictionary<string, object> GetEntContentSel(object sender, Dictionary<string, string> data)
        {
            List<CiDiagItemDO> itemList = this.GendSelectItemList();

            Dictionary<string, object> dic = new Dictionary<string, object>();
            if (itemList == null || itemList.Count == 0)
            {
                dic.Add(OP_CIDIAG, null);
            }
            else
            {
                dic.Add(OP_CIDIAG, itemList);
            }

            return dic;
        }

        #endregion

        #region 内部事件区域

        /// <summary>
        /// 临床诊断复选框选中状态变化事件
        /// <para>相当于全选、取消全选按钮功能</para>
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void ciXCheckBox_ValueTextChanged(object sender, System.EventArgs e)
        {
            List<IXRender> renderList = this.scrollBarPanel.Renders;
            foreach (IXRender render in renderList)
            {
                if (render is XCheckBox)
                {
                    if (sender != render)
                    {
                        XCheckBox checkBox = (XCheckBox)render;
                        checkBox.ValueText = ((XCheckBox)sender).ValueText;
                    }
                }
            }
        }

        #endregion

        #region 辅助处理函数

        /// <summary>
        /// 获取选中的诊断，并通过事件发送给接收对象
        /// </summary>
        private List<CiDiagItemDO> GendSelectItemList()
        {

            List<CiDiagItemDO> cidiItemList = new List<CiDiagItemDO>();

            List<IXRender> renderList = this.scrollBarPanel.Renders;
            foreach (IXRender render in renderList)
            {
                if (render is XCheckBox)
                {
                    XCheckBox cidiCheckBox = (XCheckBox)render;
                    if (CIDI_ITEM.Equals(cidiCheckBox.Name) && cidiCheckBox.Checked)
                    {
                        cidiItemList.Add((CiDiagItemDO)cidiCheckBox.ValueObj);
                    }
                }
            }

            return cidiItemList;
        }

        /// <summary>
        /// 获取显示复选框的列数
        /// </summary>
        /// <returns></returns>
        private int getColumnCnt()
        {

            int columnCnt = this.Width / (BOX_SIZE.Width + VERTICAL_SPACE);
            // 去掉第一个列显示的 “临床诊断”， 剩余列为动态生成的
            return columnCnt == 1 ? 1 : columnCnt - 1;
        }

        /// <summary>
        /// 获取行数
        /// </summary>
        /// <param name="itemCnt">复选框个数</param>
        /// <returns></returns>
        private int getRowCnt(int itemCnt)
        {
            // 获取可放置复选框的列数
            int columnCnt = this.getColumnCnt();
            // 计算复选框显示的行数
            int rowCnt = itemCnt / columnCnt;
            if (itemCnt % columnCnt > 0)
            {
                rowCnt++;
            }
            return rowCnt;

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


                    break;
            }
        }

        #endregion
    }
}
