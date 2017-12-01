/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/13 15:49:02
* Filename    : OrderExtAssist
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description : 复杂版的医嘱模板--辅助工具类
*****************************************************************************/
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.bd.srv.ortpl.d;
using iih.ci.ord.ciorder.render.interfaces;
using iih.ci.ord.ciorder.render.order;
using iih.ci.ord.dto.newordertemplatedto.d;
using xap.cli.sdk.render;
using xap.rui.control.extentions;
using iih.ci.iih.ci.ord.dto.newordertemplatedto.d;

namespace iih.ci.ord.ciorder.render.complexOrder
{
    /// <summary>
    /// 复杂版的医嘱模板
    /// </summary>
    public class ComplexOrderAssist
    {
        #region 事件

        /// <summary>
        /// 树节点（CheckBox文字区域双击事件）,用于直接开立医嘱
        /// </summary>
        public event EventHandler DoubleClick;

        #endregion

        #region 属性

        public Control Owner { get; set; }

        /// <summary>
        /// 当前的集合
        /// </summary>
        public List<UserRender> RenderList { get; set; } 

        /// <summary>
        /// 医嘱模板数据源对象
        /// </summary>
        public NewOrderTemplateDTO OrderDto { get; set; }
        /// <summary>
        /// 主要用于频次，用法，煎法数据源的获得
        /// </summary>
        public OrderTemplateRstDTO templatRstDTo { get; set; }

        //医嘱数据源明细集合
        private List<OrTplNItmDO> ListDo;



        #endregion

        #region 构造

        public ComplexOrderAssist()
        {
            this.RenderList=new List<UserRender>();
        }

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

            this.RenderList.Clear();

            this.ListDo = new List<OrTplNItmDO>();

            foreach (var obj in OrderDto.Itemlist)
            {
                if (obj is OrTplNItmDO)
                {
                    this.ListDo.Add(obj as OrTplNItmDO);
                }
            }


            if (this.OrderDto == null)
                return;


            if (this.OrderDto.Ui_flag == "1") //检验 检查 成套
            {
                LisComplexFirstOrdrRender lisFirstOrdr = new LisComplexFirstOrdrRender();
                lisFirstOrdr.CheekBoxForeColor = Color.FromArgb(0,153,229);
                lisFirstOrdr.OrderDTo = this.OrderDto;
                lisFirstOrdr.LisGroupDo = this.OrderDto;
                lisFirstOrdr.OrderDoubleClick += lisFirstOrdr_DoubleClick;
                lisFirstOrdr.Owner = this.Owner;
                lisFirstOrdr.ItemCheckChangd += lisFirstOrdr_SelectValueChanged;
                lisFirstOrdr.IsTopLevelNode = true;
                this.RenderList.Add(lisFirstOrdr);

                List<LisComplexSecondOrder> tempList = new List<LisComplexSecondOrder>();
                foreach (OrTplNItmDO second in this.ListDo)
                {
                    //非临床不显示
                    if (second.Fg_clinical.HasValue && !(bool)second.Fg_clinical)
                        continue;
                    LisComplexSecondOrder threadRender = CreateSecondOrder(second);
                    threadRender.ParentOrderRender = lisFirstOrdr;
                    threadRender.ItemCheckChangd += lisFirstOrdr_SelectValueChanged;
                    threadRender.IsTopLevelNode = false;
                    threadRender.Owner = this.Owner;
                    threadRender.OrderDoubleClick += lisFirstOrdr_DoubleClick;
                    tempList.Add(threadRender);
                    this.RenderList.Add(threadRender);
                }

                lisFirstOrdr.SecondOrderCollections = tempList;

                //为所有的节点赋值二级节点（包含本身）
                foreach (var tempOrder in tempList)
                {
                    tempOrder.BrotherOrderCollecions = tempList;
                }

            }

            else if (this.OrderDto.Ui_flag == "2")//多药品
            {
                GroupOrderTopRender lisFirstOrdr = new GroupOrderTopRender();
                lisFirstOrdr.CheekBoxForeColor = Color.FromArgb(0, 153, 229);
                lisFirstOrdr.templatRstDTo = this.templatRstDTo;
                lisFirstOrdr.OrderDTo = this.OrderDto;
                lisFirstOrdr.Owner = this.Owner;
                lisFirstOrdr.ItemDo = this.OrderDto;
                lisFirstOrdr.OrderDoubleClick += lisFirstOrdr_DoubleClick;
                lisFirstOrdr.ItemCheckChangd += lisFirstOrdr_SelectValueChanged;
                lisFirstOrdr.IsTopLevelNode = true;
                this.RenderList.Add(lisFirstOrdr);

                List<GroupOrderSecondRender> tempList = new List<GroupOrderSecondRender>();
                foreach (OrTplNItmDO second in this.ListDo)
                {
                    GroupOrderSecondRender threadRender = new GroupOrderSecondRender();
                    threadRender.Owner = this.Owner;
                    threadRender.OrderDTo = this.OrderDto;
                    threadRender.ItemDo = second;
                    threadRender.ItemCheckChangd += lisFirstOrdr_SelectValueChanged;
                    threadRender.IsTopLevelNode = false;
                    threadRender.OrderDoubleClick += lisFirstOrdr_DoubleClick;
                    threadRender.ParentOrderRender = lisFirstOrdr;
                    tempList.Add(threadRender);
                    this.RenderList.Add(threadRender);
                }

                lisFirstOrdr.SecondOrderCollections = tempList;

            }
            else if (this.OrderDto.Ui_flag == "3")//西成药，单一药品
            {
              
                foreach (OrTplNItmDO tempDo in ListDo)
                {
                    SingleComplexTopOrderRender firstNode=new SingleComplexTopOrderRender();
                    firstNode.CheekBoxForeColor = Color.FromArgb(0, 153, 229);
                    firstNode.Owner = this.Owner;
                    firstNode.OrderDTo = this.OrderDto;
                    firstNode.ItemDo = tempDo;
                    firstNode.IsTopLevelNode = true;
                    firstNode.OrderDoubleClick += lisFirstOrdr_DoubleClick;
                    this.RenderList.Add(firstNode);
                  
                    SingleComplexOrderRender secondNode=new SingleComplexOrderRender();
                    secondNode.ParentSingleOrder = firstNode;
                    secondNode.templatRstDTo = this.templatRstDTo;
                    secondNode.OrderDTo = this.OrderDto;
                    secondNode.Owner = this.Owner;
                    secondNode.ItemDo = tempDo;
                    secondNode.IsTopLevelNode = false;
                    this.RenderList.Add(secondNode);

                }

            }
            else if (this.OrderDto.Ui_flag == "4")//检查检验非套
            {
                foreach (OrTplNItmDO second in this.ListDo)
                {
                    LisComplexFirstOrdrRender lisFirstOrdr = new LisComplexFirstOrdrRender();
                    lisFirstOrdr.CheekBoxForeColor = Color.FromArgb(0, 153, 229);
                    lisFirstOrdr.OrderDTo = this.OrderDto;
                    lisFirstOrdr.Owner = this.Owner;
                    lisFirstOrdr.ItemDo = second;
                    lisFirstOrdr.IsTopLevelNode = true;
                    lisFirstOrdr.OrderDoubleClick += lisFirstOrdr_DoubleClick;
                    lisFirstOrdr.ItemCheckChangd += lisFirstOrdr_SelectValueChanged;
                    this.RenderList.Add(lisFirstOrdr);
                }
            }
            else if (this.OrderDto.Ui_flag == "5")//草药
            {
                ChineseComplexTopRender lisFirstOrdr = new ChineseComplexTopRender();
                lisFirstOrdr.CheekBoxForeColor = Color.FromArgb(0, 153, 229);
                lisFirstOrdr.templatRstDTo = this.templatRstDTo;
                lisFirstOrdr.OrderDTo = this.OrderDto;
                lisFirstOrdr.Owner = this.Owner;
                lisFirstOrdr.ItemDo = this.OrderDto;
                lisFirstOrdr.OrderDoubleClick += lisFirstOrdr_DoubleClick;
                lisFirstOrdr.ItemCheckChangd += lisFirstOrdr_SelectValueChanged;
                lisFirstOrdr.IsTopLevelNode = true;
                this.RenderList.Add(lisFirstOrdr);

                List<ChineseComplexSecondOrder> tempList = new List<ChineseComplexSecondOrder>();
                foreach (OrTplNItmDO second in this.ListDo)
                {
                    ChineseComplexSecondOrder threadRender = new ChineseComplexSecondOrder();
                    threadRender.ParentOrderRender = lisFirstOrdr;
                    threadRender.Owner = this.Owner;
                    threadRender.OrderDTo = this.OrderDto;
                    threadRender.ItemDo = second;
                    threadRender.ItemCheckChangd += lisFirstOrdr_SelectValueChanged;
                    threadRender.IsTopLevelNode = false;
                    threadRender.OrderDoubleClick += lisFirstOrdr_DoubleClick;
                    threadRender.ParentOrderRender = lisFirstOrdr;
                    tempList.Add(threadRender);
                    this.RenderList.Add(threadRender);
                }

                lisFirstOrdr.SecondOrderCollections = tempList;
            }
            else if (this.OrderDto.Ui_flag == "6")//诊疗
            {

                foreach (OrTplNItmDO second in this.ListDo)
                {
                    TreatComplexOrder lisFirstOrdr = new TreatComplexOrder(second.Opdiagtreattmploropenmode);
                    lisFirstOrdr.CheekBoxForeColor = Color.FromArgb(0, 153, 229);
                    lisFirstOrdr.templatRstDTo = this.templatRstDTo;
                    lisFirstOrdr.Owner = this.Owner;
                    lisFirstOrdr.OrderDTo = this.OrderDto;
                    lisFirstOrdr.ItemDo = second;
                    lisFirstOrdr.IsTopLevelNode = true;
                    lisFirstOrdr.OrderDoubleClick += lisFirstOrdr_DoubleClick;
                    lisFirstOrdr.ItemCheckChangd += lisFirstOrdr_SelectValueChanged;
                    this.RenderList.Add(lisFirstOrdr);
                }
            }

        }

     

        #endregion

        #region 事件处理

       

        //树节点单选
        void lisFirstOrdr_SelectValueChanged(object sender, EventArgs e)
        {
            if (sender is IComplexExtOrder)
            {
                if ((sender as IComplexExtOrder).IsTopLevelNode)//一级节点
                {
                    if (sender is GroupOrderTopRender)//一级节点--成组药品
                    {
                        List<GroupOrderSecondRender> secondOrderCollections =
                            (sender as GroupOrderTopRender).SecondOrderCollections;
                        foreach (var temp in secondOrderCollections)
                        {
                            if (temp.ItemDo.Fg_active == null || (bool)temp.ItemDo.Fg_active)//空或者医嘱服务激活
                            {
                                temp.IsCanel = true;
                                temp.ItemDo.Fg_checked = (sender as GroupOrderTopRender).IsChecked;
                                temp.IsChecked = (sender as GroupOrderTopRender).IsChecked;
                                temp.ItemDo.Fg_checked = (sender as GroupOrderTopRender).IsChecked;
                                temp.IsCanel = false;
                            }
                        }

                    }
                    else if (sender is LisComplexFirstOrdrRender)//一级节点--检查检验套
                    {
                        List<LisComplexSecondOrder> secondOrderCollections =
                           (sender as LisComplexFirstOrdrRender).SecondOrderCollections;
                        if (secondOrderCollections != null)
                        {
                            foreach (var temp in secondOrderCollections)
                            {
                                if (temp.ItemDo.Fg_active==null|| (bool)temp.ItemDo.Fg_active)////空或者医嘱服务激活
                                {
                                    temp.IsCanel = true;
                                    temp.ItemDo.Fg_checked = (sender as LisComplexFirstOrdrRender).IsChecked;
                                   // temp.IsChecked = (sender as LisComplexFirstOrdrRender).IsChecked;
                                    temp.IsCanel = false;
                                }
                            }
                        }
                        
                    }
                    else if (sender is ChineseComplexTopRender)//一级节点-中药
                    {
                        List<ChineseComplexSecondOrder> secondOrderCollections =
                           (sender as ChineseComplexTopRender).SecondOrderCollections;
                        foreach (var temp in secondOrderCollections)
                        {
                          
                            if (temp.ItemDo.Fg_active==null|| (bool) temp.ItemDo.Fg_active)
                            {
                                temp.ItemDo.Fg_checked = (sender as ChineseComplexTopRender).IsChecked;
                                temp.IsCanel = true;
                               // temp.IsChecked = (sender as ChineseComplexTopRender).IsChecked;
                                temp.IsCanel = false;
                            }
                        }
                    }
                }
                else
                {
                    if (sender is LisComplexSecondOrder)//套--子
                    {
                        LisComplexFirstOrdrRender order = (sender as LisComplexSecondOrder).ParentOrderRender;

                        LisComplexSecondOrder secondOrder = (sender as LisComplexSecondOrder);

                        if (order != null&&secondOrder.IsChecked)//选中一个父就选中
                        {
                            if (order.LisGroupDo.Fg_active == null || (bool)order.LisGroupDo.Fg_active)//fg_active null或者激活
                            {
                                order.IsCanel = true;
                                //order.IsChecked = true;
                                order.LisGroupDo.Fg_checked = true;
                                order.IsCanel = false;
                            }
                        }

                        if (secondOrder.ItemDo.Fg_edit.HasValue)
                        {
                            bool flag = (bool) secondOrder.ItemDo.Fg_edit;

                            if (flag)  //fg_edit为true
                            {
                                if (secondOrder.IsChecked)//当前节点选中，选中兄弟节点的fg_edit为false的
                                {
                                    foreach(var temp in secondOrder.BrotherOrderCollecions)
                                    {
                                        if ((temp == sender as LisComplexSecondOrder))
                                        {
                                            continue;
                                        }
                                        if (temp.ItemDo.Fg_edit.HasValue)
                                        {
                                            if (!(bool)temp.ItemDo.Fg_edit)
                                            {
                                                if (temp.ItemDo.Fg_active == null || (bool)temp.ItemDo.Fg_active) //fg_active==null或者激活
                                                {
                                                    temp.IsCanel = true;
                                                   // temp.IsChecked = true;
                                                    temp.ItemDo.Fg_checked = true;
                                                    temp.IsCanel = false;
                                                }
                                            }
                                        }
                                    }
                                    
                                }
                                else   
                                {
                                    //不处理
                                }
                            }
                            else  //fg_edit为false  
                            {
                                if (secondOrder.IsChecked) //  当前节点选中，选中所有兄弟节点中fg_edit为false的
                                {
                                    foreach (var temp in secondOrder.BrotherOrderCollecions)
                                    {
                                        if ((temp == sender as LisComplexSecondOrder))
                                        {
                                            continue;
                                        }
                                        if (temp.ItemDo.Fg_edit.HasValue)
                                        {
                                            if (!(bool)temp.ItemDo.Fg_edit)
                                            {
                                                if (temp.ItemDo.Fg_active == null || (bool)temp.ItemDo.Fg_active) //fg_active==null或者激活
                                                {
                                                    temp.IsCanel = true;
                                                   // temp.IsChecked = true;
                                                    temp.ItemDo.Fg_checked = true;
                                                    temp.IsCanel = false;
                                                }
                                            }
                                        }
                                    }
                                }
                                else
                                {
                                    foreach (var temp in secondOrder.BrotherOrderCollecions)
                                    {
                                        temp.IsCanel = true;
                                       // temp.IsChecked = false;
                                        temp.ItemDo.Fg_checked = false;
                                        temp.IsCanel = false;
                                    }
                                }
                            }

                            bool flagResult = false;
                            foreach (var second in order.SecondOrderCollections)
                            {
                                if (second.IsChecked)
                                {
                                    flagResult = true;
                                    break;
                                }
                            }
                            if (!flagResult)
                            {
                                order.IsCanel = true;
                                order.LisGroupDo.Fg_checked = false;
                               // order.IsChecked = false;
                                order.IsCanel = false;
                            }

                        }

                     

                    }
                    else if (sender is GroupOrderSecondRender)//成组药-子
                    {
                        GroupOrderTopRender order = (sender as GroupOrderSecondRender).ParentOrderRender;

                        if (order != null )
                        {
                            if ((sender as GroupOrderSecondRender).IsChecked)
                            {
                                order.IsCanel = true;
                                order.ItemDo.Fg_checked = true;
                                //order.IsChecked = true;
                                order.IsCanel = false;
                            }
                            else
                            {
                                bool flagResult = false;
                                foreach (var second in order.SecondOrderCollections)
                                {
                                    if (second.IsChecked)
                                    {
                                        flagResult = true;
                                        break;
                                    }
                                }
                                if (!flagResult)
                                {
                                    order.IsCanel = true;
                                    //order.IsChecked = false;
                                    order.ItemDo.Fg_checked = false;
                                    order.IsCanel = false;
                                }

                            }
                        }
                    }
                    else if (sender is ChineseComplexSecondOrder)//中药--子
                    {
                        ChineseComplexTopRender order = (sender as ChineseComplexSecondOrder).ParentOrderRender;

                        if (order != null)
                        {
                            if ((sender as ChineseComplexSecondOrder).IsChecked)
                            {
                                order.IsCanel = true;
                                //order.IsChecked = true;
                                order.ItemDo.Fg_checked = true;
                                order.IsCanel = false;
                            }
                            else
                            {
                                bool flagResult = false;
                                foreach (var second in order.SecondOrderCollections)
                                {
                                    if (second.IsChecked)
                                    {
                                        flagResult = true;
                                        break;
                                    }
                                }
                                if (!flagResult)
                                {
                                    order.IsCanel = true;
                                   // order.IsChecked = false;
                                    order.ItemDo.Fg_checked = false;
                                    order.IsCanel = false;
                                }

                            }
                        }
                    }
                }
                
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
        LisComplexSecondOrder CreateSecondOrder(OrTplNItmDO item)
        {
            LisComplexSecondOrder lisSecondOrder = new LisComplexSecondOrder();
            lisSecondOrder.OrderDTo = this.OrderDto;
            lisSecondOrder.ItemDo = item;
            return lisSecondOrder;

        }

        #endregion
    }
}
