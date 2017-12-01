using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.cli.sdk.form;
using xap.mw.coreitf.d;
using iih.ci.ord.srvref.d;
using iih.ci.ord.orsrvref.util;

namespace iih.ci.ord.orsrvref.view
{
    public partial class IndividualForm : Form
    {

        #region 变量定义区域.

        private bool isLoading = true;

        private bool isSettingCheckState = false;

        private CiSrvRefParamDTO srvRefParamDto;

        /// <summary>
        /// listView 列宽
        /// </summary>
        private const int HEADER_WIDTH = 150;

        /// <summary>
        /// 匹配方式组
        /// </summary>
        private const string MATCHING_MODE = "matchingMode";

        /// <summary>
        /// 过滤条件组
        /// </summary>
        private const string FILTER_CONDITIONS = "filterConditions";

        /// <summary>
        /// 返回记录数组
        /// </summary>
        private const string RESULT_CNT = "resultCnt";

        /// <summary>
        /// 多选，设置ListView分组对应的ListViewItem可多选
        /// </summary>
        private const string MULTI_SELECT = "multiSelect";
        /// <summary>
        /// 单选，设置ListView分组对应的ListViewItem只能单选
        /// </summary>
        private const string SIGNLE_SELECT = "signleSelect";


        /// <summary>
        /// 设置各个分组的ListViewItem选着方式，单选、多选
        /// <para>key : 分组的name属性</para>
        /// <para>value : 组中ListViewItem选着方式，单选、多选</para>
        /// </summary>
        private static Dictionary<string, string> SELECT_MODE_DIC = new Dictionary<string, string>{  
            {MATCHING_MODE,SIGNLE_SELECT},
            {FILTER_CONDITIONS,MULTI_SELECT},
            {RESULT_CNT,SIGNLE_SELECT}   
        };

        #endregion

        #region 构造函数区域

        private IndividualForm()
        {
            InitializeComponent();
        }

        public IndividualForm(CiSrvRefParamDTO srvRefParamDto)
        {
            InitializeComponent();
            this.srvRefParamDto = srvRefParamDto;
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

        #endregion

        #region 内部事件区域

        private void IndividualForm_Load(object sender, System.EventArgs e)
        {

            personalListView.Groups.Clear();
            personalListView.Items.Clear();

            personalListView.View = View.Details;
            ColumnHeader columnHeader0 = new ColumnHeader();
            columnHeader0.Text = "";
            columnHeader0.Width = HEADER_WIDTH;


            personalListView.Columns.AddRange(new ColumnHeader[] { columnHeader0 });

            List<ListViewItem> viewItemList = this.getListViewItems();
            personalListView.Items.AddRange(viewItemList.ToArray());
            isLoading = false;

        }

        /// <summary>
        /// ListItemView选中前触发的事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void personalListView_ItemCheck(object sender, ItemCheckEventArgs e)
        {
            if (!isLoading && !isSettingCheckState)
            {

                if (e.CurrentValue == CheckState.Unchecked || e.CurrentValue == CheckState.Checked) // 只处理选中、未选中状态
                {
                    string selState = "false";
                    if (e.CurrentValue == CheckState.Unchecked)//未选中状态变为选中状态
                    {
                        selState = "true";
                    }
                    this.setItemGrpSelState(e.Index, selState);
                }
            }
        }

        void personalListView_ItemChecked(object sender, ItemCheckedEventArgs e)
        {
            //if (!isLoading)
            //{
            //    string selState = "false";
            //    if (e.Item.Checked)
            //    {
            //        selState = "true";
            //    }
            //    this.setItemGrpSelState(e.Item, selState);
            //}
        }

        /// <summary>
        /// 窗体关闭时间
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void IndividualForm_Deactivate(object sender, System.EventArgs e)
        {
            ListView.ListViewItemCollection items = this.personalListView.Items;
            

            foreach (ListViewItem item in items)
            {
                if (RESULT_CNT.Equals(item.Group.Name))
                {
                    if (item.Checked) {
                        BeanPropertyUtil.SetValue(this.srvRefParamDto, item.SubItems[1].Name, item.SubItems[1].Text);
                    }
                }
                else {

                    BeanPropertyUtil.SetValue(this.srvRefParamDto, item.SubItems[1].Name, Boolean.Parse(item.SubItems[1].Text));
                }
                
            }

            this.Close();
        }


        #endregion

        #region 辅助处理函数

        /// <summary>
        /// 获取listView对象的数据
        /// </summary>
        /// <returns></returns>
        private List<ListViewItem> getListViewItems()
        {

            List<ListViewItem> itemList = new List<ListViewItem>();
            // 匹配方式
            ListViewGroup grpMatch = new ListViewGroup(MATCHING_MODE, "匹配方式");
            personalListView.Groups.Add(grpMatch);
            ListViewItem itemMatch = this.configListViewItem(new string[] { "模糊匹配", "Fg_blurred", "false", "false" }, 0, grpMatch);
            itemList.Add(itemMatch);

            // 过滤条件
            List<string[]> itemConditionParamList = new List<string[]>();
            ListViewGroup grpCondition = new ListViewGroup(FILTER_CONDITIONS, "过滤条件");
            personalListView.Groups.Add(grpCondition);
            itemConditionParamList.Add(new string[] { "拼音码", "Fg_pycode", "true", "true" });
            itemConditionParamList.Add(new string[] { "服务名称", "Fg_name", "true", "true" });
            itemConditionParamList.Add(new string[] { "五笔码", "Fg_wbcode", "false", "false" });
            itemConditionParamList.Add(new string[] { "助记码", "Fg_mnemonic", "false", "false" });
            itemConditionParamList.Add(new string[] { "编码", "Fg_code", "false", "false" });
            //TODO 缺少这个属性
            //itemConditionParamList.Add(new string[] { "英文简称", "Fg_code", "false", "false" }); 
            List<ListViewItem> itemConditionList = this.configListViewItemList(itemConditionParamList, 0, grpCondition);
            itemList.AddRange(itemConditionList);



            // 返回记录数
            List<string[]> itemRowCntParamList = new List<string[]>();
            ListViewGroup grpRowCnt = new ListViewGroup(RESULT_CNT, "返回记录数");
            personalListView.Groups.Add(grpRowCnt);
            itemRowCntParamList.Add(new string[] { "10条", "Result_cnt", "10", "true" });
            itemRowCntParamList.Add(new string[] { "20条", "Result_cnt", "20", "false" });
            itemRowCntParamList.Add(new string[] { "50条", "Result_cnt", "50", "false" });
            itemRowCntParamList.Add(new string[] { "全部", "Result_cnt", "-1", "false" });

            List<ListViewItem> itemRowCntList = this.configListViewItemList(itemRowCntParamList, 0, grpRowCnt);
            itemList.AddRange(itemRowCntList);

            return itemList;
        }

        /// <summary>
        /// 构造ListViewItem集合
        /// </summary>
        /// <param name="itemParams">构造ListViewItem属性集合，数据结构为stirng[] ,
        /// <para>索引值 0：listView显示列</para>
        /// <para>索引值 1、2：ListViewItem对应CiSrvRefParamDTO中属性以及属性值</para>
        /// <para>索引值 3：默认加载ListView时此ListViewItem是否为选中状态</para></param>
        /// <param name="imgIndex">图标的索引值（暂时没用）</param>
        /// <param name="grp">ListViewItem所属分组</param>
        /// <returns></returns>
        private List<ListViewItem> configListViewItemList(List<string[]> itemParams, int imgIndex, ListViewGroup grp)
        {

            List<ListViewItem> itemList = new List<ListViewItem>();
            if (itemParams != null && itemParams.Count > 0)
            {

                foreach (string[] itemParam in itemParams)
                {
                    ListViewItem item = this.configListViewItem(itemParam, imgIndex, grp);
                    itemList.Add(item);
                }
            }

            return itemList;
        }

        /// <summary>
        /// 构造ListViewItem集合
        /// </summary>
        /// <param name="itemParams">构造ListViewItem属性集合，数据结构为stirng[] ,
        /// <para>索引值 0：listView显示列</para>
        /// <para>索引值 1、2：ListViewItem对应CiSrvRefParamDTO中属性以及属性值</para>
        /// <para>索引值 3：默认加载ListView时此ListViewItem是否为选中状态</para></param>
        /// <param name="imgIndex">图标的索引值（暂时没用）</param>
        /// <param name="grp">ListViewItem所属分组</param>
        /// <returns></returns>
        private ListViewItem configListViewItem(string[] itemParam, int imgIndex, ListViewGroup grp)
        {
            // 显示内容
            ListViewItem.ListViewSubItem displayItem = new ListViewItem.ListViewSubItem();
            displayItem.Name = "dispalyContent";
            displayItem.Text = itemParam[0];

            // 对应CiSrvRefParamDTO中属性以及属性值
            ListViewItem.ListViewSubItem propertyItem = new ListViewItem.ListViewSubItem();
            propertyItem.Name = itemParam[1];
            propertyItem.Text = itemParam[2];


            // ListViewItem默认的选中状态
            ListViewItem.ListViewSubItem checkedItem = new ListViewItem.ListViewSubItem();
            checkedItem.Name = "checked";
            checkedItem.Text = itemParam[3];

            ListViewItem listViewItem = new ListViewItem(new ListViewItem.ListViewSubItem[] { displayItem, propertyItem, checkedItem }, imgIndex, grp);
            if ("true".Equals(itemParam[3]))
            {
                listViewItem.Checked = true;
            }
            return listViewItem;

        }

        /// <summary>
        /// 设置ListViewItem选中状态
        /// </summary>
        /// <param name="itemIndex">设置选中状态ListViewItem的索引值</param>
        /// <param name="selState">选中状态 1：选中，0：未选中</param>
        private void setItemGrpSelState(int itemIndex, string selState)
        {
            ListViewItem selItem = this.personalListView.Items[itemIndex];
            selItem.SubItems[2].Text = selState;

            if (SELECT_MODE_DIC.ContainsKey(selItem.Group.Name))
            {

                string selectMode = SELECT_MODE_DIC[selItem.Group.Name];

                if (SIGNLE_SELECT.Equals(selectMode))
                {
                    isSettingCheckState = true;
                    foreach (ListViewItem item in selItem.Group.Items)
                    {
                        if (selItem != item)
                        {
                            item.Checked = false;
                        }
                    }
                    isSettingCheckState = false;

                }

                this.setSelStateVal(selItem, selState);
            }
        }

        /// <summary>
        /// 设置ListViewItem选中状态
        /// </summary>
        /// <param name="itemIndex">设置选中状态ListViewItem的索引值</param>
        /// <param name="selState">选中状态 1：选中，0：未选中</param>
        private void setItemGrpSelState(ListViewItem selItem, string selState)
        {
            selItem.SubItems[2].Text = selState;

            if (SELECT_MODE_DIC.ContainsKey(selItem.Group.Name))
            {

                string selectMode = SELECT_MODE_DIC[selItem.Group.Name];

                if (SIGNLE_SELECT.Equals(selectMode))
                {
                    foreach (ListViewItem item in selItem.Group.Items)
                    {
                        if (selItem != item) {
                            item.Checked = false;
                        }
                        
                    }

                }

                this.setSelStateVal(selItem, selState);
            }
        }

        /// <summary>
        /// 设置选中状态下的属性值
        /// </summary>
        /// <param name="selItem">选中状态变化的ListViewItem</param>
        /// <param name="selState">选中状态 1：选中，0：未选中</param>
        private void setSelStateVal(ListViewItem selItem, string selState)
        {

            if (!RESULT_CNT.Equals(selItem.Group.Name))
            {

                selItem.SubItems[1].Text = selState;
            }
        }

        #endregion

        #region 状态处理区域

        #endregion






    }
}
