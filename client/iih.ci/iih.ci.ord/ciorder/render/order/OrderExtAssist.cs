/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/10 10:24:02
* Filename    : OrderExtAssist
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description : 医嘱助手服务点击辅助类
*****************************************************************************/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.ortpl.d;
using iih.ci.ord.dto.newordertemplatedto.d;
using xap.cli.sdk.render;

namespace iih.ci.ord.ciorder.render.order
{
    /// <summary>
    /// 医嘱助手服务点击辅助类
    /// </summary>
    public class OrderExtAssist
    {
        #region 事件
        /// <summary>
        /// 树节点双击事件
        /// </summary>
        public event EventHandler DoubleClick;

        /// <summary>
        /// 树节点点击checkBox事件
        /// </summary>
        public event EventHandler SelectValueChanged;

        /// <summary>
        /// 业务节点单击事件
        /// </summary>
        public event EventHandler OrderNodeClick;
        #endregion

        #region 属性

        /// <summary>
        /// 当前选中树的叶子节点
        /// </summary>
        public XAPTreeNodeRender NowTreeNodeRender { get; set; }

        /// <summary>
        /// 医嘱模板数据源对象
        /// </summary>
        public NewOrderTemplateDTO OrderDto { get; set; }

        /// <summary>
        /// 医嘱数据源明细集合
        /// </summary>
        private List<OrTplNItmDO> ListDo;

        #endregion

        #region 外部接口
        /// <summary>
        /// 根据后台传过来的DTO对象的Ui_flag的不同去创造相应的树节点
        /// </summary>
        public void LoadData()
        {
            //数据源非空 ||数据源的明细为空 ||数据的明细数量==0
            if (OrderDto == null || OrderDto.Itemlist == null || OrderDto.Itemlist.Count == 0)
            {
                return;
            }

            this.ListDo = new List<OrTplNItmDO>();
            foreach (var obj in OrderDto.Itemlist)
            {
                if (obj is OrTplNItmDO)
                {
                    this.ListDo.Add(obj as OrTplNItmDO);
                }
            }

            OrderDto.PropertyChanged += OrderDto_PropertyChanged;

            if (this.OrderDto.Ui_flag == "1") //检验 检查 成套
            {
                LisFirstOrdrRender lisFirstOrdr = new LisFirstOrdrRender(this.OrderDto.Ismuldose);
                lisFirstOrdr.ExtAssist = this;
                lisFirstOrdr.LisGroupDo = this.OrderDto;
                lisFirstOrdr.DoubleClick += lisFirstOrdr_DoubleClick;
                lisFirstOrdr.SelectValueChanged += lisFirstOrdr_SelectValueChanged;
                if (this.OrderDto.Fg_active != null && (bool)this.OrderDto.Fg_active)
                    lisFirstOrdr.Checked = this.NowTreeNodeRender.Checked;
                lisFirstOrdr.TotalWidth = this.NowTreeNodeRender.OwnerTree.Size.Width - 10;

                lisFirstOrdr.ParentNodeRender = this.NowTreeNodeRender;
                lisFirstOrdr.OrderNodeClick += lisFirstOrdr_OrderNodeClick;
              

                List<LisSecondOrder> tempList = new List<LisSecondOrder>();

                foreach (OrTplNItmDO second in this.ListDo)
                {
                    //非临床不显示 
                    if (second.Fg_clinical.HasValue && !(bool)second.Fg_clinical)
                        continue;
                    LisSecondOrder threadRender = CreateSecondOrder(second);
                    threadRender.ParentRender = lisFirstOrdr;
                    threadRender.SelectValueChanged += lisFirstOrdr_SelectValueChanged;
                    threadRender.OrderNodeClick += lisFirstOrdr_OrderNodeClick;
                    threadRender.DoubleClick += lisFirstOrdr_DoubleClick;
                    threadRender.ExtAssist = this;
                    if (second.Fg_active != null && (bool)second.Fg_active)
                         threadRender.Checked = this.NowTreeNodeRender.Checked;
                    threadRender.TotalWidth = this.NowTreeNodeRender.OwnerTree.Size.Width;
                    threadRender.ParentNodeRender = lisFirstOrdr;
                    tempList.Add(threadRender);
                    lisFirstOrdr.Nodes.Add(threadRender);
                }

                lisFirstOrdr.SecondOrderCollections = tempList;

                foreach (var tempOrder in tempList)
                {
                    tempOrder.BrotherOrderCollecions = tempList;
                }

                this.NowTreeNodeRender.Nodes.Add(lisFirstOrdr);
               // this.NowTreeNodeRender.ExpandAll();

            }

            else if (this.OrderDto.Ui_flag == "2")//多药品
            {
                List<OrderSingleRender> tempList = new List<OrderSingleRender>();

                OrderGroupFirstOrder firstOrderNode = new OrderGroupFirstOrder();
                firstOrderNode.Text = this.OrderDto.Name;
                firstOrderNode.ExtAssist = this;
                firstOrderNode.TotalWidth = this.NowTreeNodeRender.OwnerTree.Size.Width-10;
                this.NowTreeNodeRender.Nodes.Add(firstOrderNode);

                foreach (OrTplNItmDO tempDo in ListDo)
                {
                    OrderSingleRender singleRender = new OrderSingleRender();
                    singleRender.SelectValueChanged += lisFirstOrdr_SelectValueChanged;
                    singleRender.DoubleClick += lisFirstOrdr_DoubleClick;
                    singleRender.ExtAssist = this;
                    singleRender.ItemDo = tempDo;
                    if (tempDo.Fg_active != null && (bool)tempDo.Fg_active)
                        singleRender.Checked = this.NowTreeNodeRender.Checked;
                    singleRender.TotalWidth = this.NowTreeNodeRender.OwnerTree.Size.Width-10;
                    singleRender.ParentNodeRender = this.NowTreeNodeRender;
                    singleRender.OrderNodeClick += lisFirstOrdr_OrderNodeClick;
                    tempList.Add(singleRender);
                    singleRender.BrotherOrderCollecions = tempList;// ++++ 
                    firstOrderNode.Nodes.Add(singleRender);
                }

                this.NowTreeNodeRender.IsExpanded = false;

                //foreach (var tempOrder in tempList)
                //{
                //    tempOrder.BrotherOrderCollecions = tempList;
                //}


            }
            else if (this.OrderDto.Ui_flag == "3")//西成药，单一药品
            {
                List<OrderSingleRender> tempList = new List<OrderSingleRender>();

                foreach (OrTplNItmDO tempDo in ListDo)
                {
                    OrderSingleRender singleRender = new OrderSingleRender();
                    singleRender.SelectValueChanged += lisFirstOrdr_SelectValueChanged;
                    singleRender.DoubleClick += lisFirstOrdr_DoubleClick;
                    if (tempDo.Fg_active != null && (bool)tempDo.Fg_active)
                        singleRender.Checked = this.NowTreeNodeRender.Checked;
                    singleRender.ExtAssist = this;
                    singleRender.ItemDo = tempDo;
                    singleRender.TotalWidth = this.NowTreeNodeRender.OwnerTree.Size.Width-10;
                    singleRender.ParentNodeRender = this.NowTreeNodeRender;
                    singleRender.OrderNodeClick += lisFirstOrdr_OrderNodeClick;
                    tempList.Add(singleRender);
                    singleRender.BrotherOrderCollecions = tempList;//++++
                    this.NowTreeNodeRender.Nodes.Add(singleRender);
                }

                this.NowTreeNodeRender.IsExpanded = false;;

                //foreach (var tempOrder in tempList)
                //{
                //    tempOrder.BrotherOrderCollecions = tempList;
                //}

            }
            else if (this.OrderDto.Ui_flag == "4")//检查检验非套
            {
                List<LisFirstOrdrRender> tempList = new List<LisFirstOrdrRender>();

                foreach (OrTplNItmDO itemDo in this.ListDo)
                {
                    LisFirstOrdrRender threadRender = new LisFirstOrdrRender(itemDo.Ismuldose);
                    threadRender.SelectValueChanged += lisFirstOrdr_SelectValueChanged;
                    threadRender.DoubleClick += lisFirstOrdr_DoubleClick;
                    if (itemDo.Fg_active != null && (bool)itemDo.Fg_active)
                        threadRender.Checked = this.NowTreeNodeRender.Checked;
                    threadRender.OrderNodeClick += lisFirstOrdr_OrderNodeClick;
                    threadRender.ExtAssist = this;
                    threadRender.ItemDo = itemDo;
                    threadRender.TotalWidth = this.NowTreeNodeRender.OwnerTree.Size.Width-10;
                    threadRender.ParentNodeRender = this.NowTreeNodeRender;
                    threadRender.BrotherOrderCollecions = tempList;//++++
                    tempList.Add(threadRender);
                    this.NowTreeNodeRender.Nodes.Add(threadRender);
                }
                this.NowTreeNodeRender.IsExpanded = false;
            }
            else if (this.OrderDto.Ui_flag == "5")//草药
            {
                List<ChineseMedicineOrder> tempList = new List<ChineseMedicineOrder>();

                ChineseMedcineFirstOrder firstOrderNode=new ChineseMedcineFirstOrder();
                firstOrderNode.Text = this.OrderDto.Name;
                firstOrderNode.ExtAssist = this;
                firstOrderNode.TotalWidth = this.NowTreeNodeRender.OwnerTree.Size.Width-10;
                this.NowTreeNodeRender.Nodes.Add(firstOrderNode);

                foreach (OrTplNItmDO tempDo in ListDo)
                {
                    ChineseMedicineOrder singleRender = new ChineseMedicineOrder();
                    singleRender.SelectValueChanged += lisFirstOrdr_SelectValueChanged;
                    singleRender.DoubleClick += lisFirstOrdr_DoubleClick;
                    if (tempDo.Fg_active != null && (bool)tempDo.Fg_active)
                         singleRender.Checked = this.NowTreeNodeRender.Checked;
                    singleRender.ExtAssist = this;
                    singleRender.ItemDo = tempDo;
                    singleRender.TotalWidth = this.NowTreeNodeRender.OwnerTree.Size.Width-10;
                    singleRender.ParentNodeRender = this.NowTreeNodeRender;
                    singleRender.OrderNodeClick += lisFirstOrdr_OrderNodeClick;
                    singleRender.DataValueChanged += singleRender_DataValueChanged;
                    tempList.Add(singleRender);
                    singleRender.BrotherOrderCollecions = tempList;//++++
                    firstOrderNode.Nodes.Add(singleRender);
                }

                this.NowTreeNodeRender.IsExpanded = false;
            }
            else if (this.OrderDto.Ui_flag == "6")//诊疗
            {
                List<TreatmentOrder> tempList = new List<TreatmentOrder>();

                foreach (OrTplNItmDO tempDo in ListDo)
                {
                    TreatmentOrder singleRender = new TreatmentOrder(tempDo.Ismuldose);
                    singleRender.ParentNodeRender = this.NowTreeNodeRender;
                    singleRender.SelectValueChanged += lisFirstOrdr_SelectValueChanged;
                    singleRender.DoubleClick += lisFirstOrdr_DoubleClick;
                    singleRender.TreatStyle = tempDo.Opdiagtreattmploropenmode;//诊疗开单模式
                    if (tempDo.Fg_active != null && (bool)tempDo.Fg_active)
                        singleRender.Checked = this.NowTreeNodeRender.Checked;
                    singleRender.OrderNodeClick += lisFirstOrdr_OrderNodeClick;
                    singleRender.ExtAssist = this;
                    singleRender.ItemDo = tempDo;
                    singleRender.TotalWidth = this.NowTreeNodeRender.OwnerTree.Size.Width - 10;
                    tempList.Add(singleRender);
                    singleRender.BrotherOrderCollecions = tempList;//++++
                    this.NowTreeNodeRender.Nodes.Add(singleRender);
                }
                if (this.NowTreeNodeRender != null)
                    this.NowTreeNodeRender.IsExpanded = false;
            }
        }

        //草药剂量发生变化时-回写到其兄弟节点
        void singleRender_DataValueChanged(object sender, EventArgs e)
        {
            if (sender is ChineseMedicineOrder)
            {
                ChineseMedicineOrder nowMedicineOrder = sender as ChineseMedicineOrder;

                int? orders = (sender as ChineseMedicineOrder).ItemDo.Orders;

                List<ChineseMedicineOrder> brotherOrderCollecions = (sender as ChineseMedicineOrder).BrotherOrderCollecions;
                foreach (var render in brotherOrderCollecions)
                {
                    if (render != nowMedicineOrder)
                    {
                        render.ItemDo.Orders = orders;
                    }
                }
            }

        }

        //树节点的点击事件
        void lisFirstOrdr_OrderNodeClick(object sender, EventArgs e)
        {
            if (OrderNodeClick != null)
            {
                OrderNodeClick(sender, EventArgs.Empty);
            }
        }

        void OrderDto_PropertyChanged(object sender, System.ComponentModel.PropertyChangedEventArgs e)
        {
           
        }

        #endregion

        #region 事件处理

        //树节点单选
        void lisFirstOrdr_SelectValueChanged(object sender, EventArgs e)
        {
            if (SelectValueChanged != null)
            {
                SelectValueChanged(sender,EventArgs.Empty);
            }
        }

        //树节点双击
        void lisFirstOrdr_DoubleClick(object sender, EventArgs e)
        {
            if (DoubleClick != null)
            {
                DoubleClick(sender, EventArgs.Empty);
            }
        }

        #endregion

        #region 内部处理

        //创建医嘱（套）的二级节点
        LisSecondOrder CreateSecondOrder(OrTplNItmDO item)
        {
            LisSecondOrder lisSecondOrder = new LisSecondOrder();
            lisSecondOrder.ExtAssist = this;
            lisSecondOrder.ItemDo = item;

            return lisSecondOrder;
        }
        #endregion

    }
}
