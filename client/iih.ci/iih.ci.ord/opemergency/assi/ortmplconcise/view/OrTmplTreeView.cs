
using System;
using System.Diagnostics;
using System.Collections.Generic;
using xap.rui.control.basecontrol;
using xap.rui.control.tree.otree.data;
using xap.rui.control.tree.events;
using xap.rui.control.extentions;
using xap.rui.control.tree.otree.node;
using xap.cli.sdk.render;
using iih.bd.srv.ortpl.dto;
using iih.bd.srv.ortpl.d;
using iih.ci.ord.opemergency.assi.ortmplconcise.model;
using iih.ci.ord.ciorder.render.interfaces;
using iih.ci.ord.ciorder.render.order;
using iih.ci.ord.ems.d;
using iih.ci.ord.opemergency.viewmodel;
using iih.ci.ord.dto.newordertemplatedto.d;
using xap.mw.core.data;

namespace iih.ci.ord.opemergency.assi.ortmplconcise.view
{
    /// <summary>
    /// <para>描    述 :  医嘱模板简洁Tree视图	</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.ortmplconcise.view    </para>    
    /// <para>类 名 称 :  OrTmplTreeView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Young         				</para> 
    /// <para>修 改 人 :  Young         				</para> 
    /// <para>创建时间 :  2017/10/20 19:10:21             </para>
    /// <para>更新时间 :  2017/10/20 19:10:21             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public partial class OrTmplTreeView : XapListControl
    {
        #region 变量定义区域
        /// <summary>
        /// 事件交互类，与配置文件内的类进行交互
        /// </summary>
        public XapBaseControl xapBaseControl { get; set; }

        /// <summary>
        /// 上下文对象
        /// </summary>
        public CiEnContextDTO ciEnContext { get; set; }

        /// <summary>
        /// Tree懒加载数据模型
        /// </summary>
        private LazyLoadTreeModel treeModel;

        /// <summary>
        /// 数据模型
        /// </summary>
        private OrTmplTreeViewModel viewModel;

        /// <summary>
        /// 保存模板
        /// </summary>
        private AssButtonViewModel buttonViewModel;

        /// <summary>
        /// 选中的模板明细
        /// </summary>
        private List<OrTplNItmDO> lstOrTplNItmDOs;

        /// <summary>
        /// 记录已加载过明细的模板
        /// </summary>
        private List<String> lstIdortmpls;

        /// <summary>
        /// 选中的模板版明细节点
        /// </summary>
        private List<XAPTreeNodeRender> lstTreeNodes;

        /// <summary>
        /// 医嘱模板类型标记
        /// </summary>
        protected String sdortmpltp = "";

        /// <summary>
        /// 是否已加载
        /// </summary>
        private bool isLoaded;
        #endregion

        #region 构造函数区域
        public OrTmplTreeView()
        {
            this.viewModel = new OrTmplTreeViewModel();
            this.buttonViewModel = new AssButtonViewModel();
            this.lstTreeNodes = new List<XAPTreeNodeRender>();
            this.lstOrTplNItmDOs = new List<OrTplNItmDO>();
            this.lstIdortmpls = new List<string>();
            
            this.Load += new EventHandler(OrTmplTreeView_Load);
            InitializeComponent();
        }
        #endregion

        #region 内部事件区域
        private void OrTmplTreeView_Load(object sender, EventArgs e)
        {
            this.oTree1.ShowNodeIcon = false;
            this.oTree1.ShowCheckBox = true;
            this.oTree1.ShowSearchBox = true;

            this.oTree1.TreeItemGetImageIndex += new TreeItemGetImageIndexEventHandler(oTree1_TreeItemGetImageIndex);
            this.oTree1.TreeItemCheckChanged += new TreeItemEventHandler(oTree1_TreeItemCheckChanged);
            this.oTree1.TreeItemSelected += new TreeItemEventHandler(oTree1_TreeItemSelected);
            this.oTree1.ExpandRectClick += new XAPTreeNodeRender.ExpandRectHandler(nodeTree_ExpandRectClick);
            this.AddRender(this.oTree1);

            OnInit();
        }

        /// <summary>
        /// 选中节点事件，加载模板明细
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void oTree1_TreeItemSelected(object sender, TreeItemEventArgs e)
        {
            XAPTreeNodeRender nodeTree = e.Node as XAPTreeNodeRender;
            loadNodes(nodeTree);
        }

        private void loadNodes(XAPTreeNodeRender nodeTree)
        {
            object userObj = oTree1.GetUserObject(nodeTree);
            if (userObj is OrTmplDTO)
            {
                OrTmplDTO focusObj = userObj as OrTmplDTO;
                String id_ortmpl = focusObj.Id_ortmpl;
                String id_ortmplca = focusObj.Id_ortmplca;
                if (this.lstIdortmpls.Contains(id_ortmplca + id_ortmpl))
                    return;
                else
                    this.lstIdortmpls.Add(id_ortmplca + id_ortmpl);
                List<String> lst = new List<string>();
                lst.Add(id_ortmpl);
                this.viewModel.LoadOrTplNItmDOs(lst);//查询医嘱模板明细数据
                FArrayList modelList = new FArrayList();
                if (this.viewModel.DicOrTplNItm.ContainsKey(id_ortmpl))
                {
                    modelList = this.viewModel.DicOrTplNItm[id_ortmpl] as FArrayList;
                }
                if (modelList != null)
                {
                    this.loadTmplItemNodes(modelList, nodeTree);
                }

                if (nodeTree.ChildrenCount > 1)
                {
                    if (nodeTree.FirstChild is XAPTreeNodeRender)
                    {
                        nodeTree.FirstChild.Remove();
                    }
                }
                else
                {
                    nodeTree.FirstChild.Text = "（空）";
                    nodeTree.FirstChild.Enabled = false;
                }
                nodeTree.ExpandAll();
            }
        }

        /// <summary>
        /// 树节点去除图片
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void oTree1_TreeItemGetImageIndex(object sender, TreeItemGetImageIndexEventArgs e)
        {
            e.ImageKey = "";
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void oTree1_TreeItemCheckChanged(object sender, TreeItemEventArgs e)
        {
            XAPTreeNodeRender nodeTree = e.Node as XAPTreeNodeRender;
            loadNodes(nodeTree);
            if (nodeTree.NodeData != null)
            {
                object nodeObj = (nodeTree.NodeData as BizNode).UserObject;
                if ((nodeObj is OrTmplDTO) || (nodeObj is OrTmplCaDO))
                {
                    //获得选中服务或模板下所有的模板id
                    List<String> idortmpls = this.getAllChildIdOrTmpls(nodeTree.NodeData as BizNode);
                    for (int i = idortmpls.Count - 1; i >= 0; i--)
                    {
                        if (nodeTree.Checked)
                        {
                            FArrayList list = new FArrayList(); ;
                            if (this.viewModel.DicOrTplNItm.ContainsKey(idortmpls[i]))
                            {
                                list = this.viewModel.DicOrTplNItm[idortmpls[i]] as FArrayList;
                            }
                            foreach (NewOrderTemplateDTO templateDTO in list)
                            {
                                FArrayList itmdolist = templateDTO.Itemlist;
                                foreach (OrTplNItmDO itmdo in itmdolist)
                                {
                                    if (!lstOrTplNItmDOs.Contains(itmdo))
                                    {
                                        lstOrTplNItmDOs.Add(itmdo);
                                    }
                                }
                            }
                        }
                        else
                        {
                            for (int j = this.lstOrTplNItmDOs.Count - 1; j >= 0; j--)
                            {
                                if (lstOrTplNItmDOs[j].Id_ortmpl == idortmpls[i])
                                {
                                    lstOrTplNItmDOs.RemoveAt(j);
                                }
                            }
                        }
                    }
                }
            }
            //模板明细的选中事件
            modelItmChecked(sender, e);
        }

        /// <summary>
        /// 获取分类和模板节点所有模板ID
        /// </summary>
        /// <param name="bizNode"></param>
        /// <returns></returns>
        private List<String> getAllChildIdOrTmpls(BizNode bizNode)
        {
            List<String> lstIDs = new List<String>();
            if (bizNode.Children.Count > 0)
            {
                foreach (var childrenNode in bizNode.Children)
                {
                    lstIDs.AddRange(getAllChildIdOrTmpls(childrenNode));
                }
            }

            object nodeObj = bizNode.UserObject;
            List<String> ids = this.viewModel.GetAllChildIdOrTmpls(nodeObj as BaseDO);
            foreach (var id in ids)
            {
                if (!lstIDs.Contains(id))
                {
                    lstIDs.Add(id);
                }
            }
            return lstIDs;
        }

        private void modelItmChecked(object obj, TreeItemEventArgs e)
        {
            if (e.Node is IExtOrder)
            {
                var sender = e.Node;
                if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("1"))//套
                {
                    if (sender is LisFirstOrdrRender)//检查检验一级
                    {
                        bool nowChecked = (sender as LisFirstOrdrRender).Checked;
                        if (nowChecked)
                        {
                            if (!this.lstTreeNodes.Contains(sender as XAPTreeNodeRender))
                                this.lstTreeNodes.Add(sender as XAPTreeNodeRender);
                        }
                        else
                        {
                            this.lstTreeNodes.Remove(sender as XAPTreeNodeRender);
                        }

                        foreach (var temp in (sender as LisFirstOrdrRender).SecondOrderCollections)
                        {
                            temp.IsCanel = true;
                            temp.Checked = nowChecked;
                            temp.IsCanel = false;
                            if (temp.ItemDo.Fg_active == null || temp.ItemDo.Fg_active.Value)
                            {
                                if (nowChecked)
                                {
                                    if (!this.lstOrTplNItmDOs.Contains(temp.ItemDo))
                                    {
                                        this.lstOrTplNItmDOs.Add(temp.ItemDo);
                                        this.lstTreeNodes.Add(temp as XAPTreeNodeRender);
                                    }
                                }
                                else
                                {
                                    this.lstOrTplNItmDOs.Remove(temp.ItemDo);
                                    this.lstTreeNodes.Remove(temp as XAPTreeNodeRender);
                                }
                            }
                        }
                    }
                    else if (sender is LisSecondOrder)//检查二级
                    {
                        LisSecondOrder secondeOrder = sender as LisSecondOrder;
                        bool nowChecked = secondeOrder.Checked;
                        bool flagResult = false;

                        foreach (var temp in secondeOrder.BrotherOrderCollecions)
                        {
                            if (nowChecked)
                            {
                                if (temp.ItemDo.Fg_active == null || temp.ItemDo.Fg_active.Value)
                                {
                                    if (secondeOrder.ItemDo == temp.ItemDo || (temp.ItemDo.Fg_edit != null && !temp.ItemDo.Fg_edit.Value))
                                    {
                                        temp.IsCanel = true;
                                        temp.Checked = nowChecked;
                                        temp.IsCanel = false;
                                        if (!this.lstOrTplNItmDOs.Contains(temp.ItemDo))
                                        {
                                            this.lstOrTplNItmDOs.Add(temp.ItemDo);
                                            this.lstTreeNodes.Add(temp as XAPTreeNodeRender);
                                        }
                                    }
                                }
                            }
                            else
                            {
                                if (temp == secondeOrder)
                                {
                                    if (this.lstOrTplNItmDOs.Contains(temp.ItemDo))
                                    {
                                        this.lstOrTplNItmDOs.Remove(temp.ItemDo);
                                        this.lstTreeNodes.Remove(temp as XAPTreeNodeRender);
                                    }
                                }
                            }

                            flagResult = temp.IsChecked;
                        }

                        if (secondeOrder.ParentRender != null)
                        {
                            secondeOrder.ParentRender.IsCanel = true;
                            secondeOrder.ParentRender.IsCanelCheckedOperation = true;
                            secondeOrder.ParentRender.IsChecked = flagResult;
                            secondeOrder.ParentRender.IsCanelCheckedOperation = false;
                            secondeOrder.ParentRender.IsCanel = false;
                            if (flagResult)
                            {
                                if (!this.lstTreeNodes.Contains(secondeOrder.ParentRender))
                                    this.lstTreeNodes.Add(secondeOrder.ParentRender as XAPTreeNodeRender);
                            }
                            else
                            {
                                this.lstTreeNodes.Remove(secondeOrder.ParentRender as XAPTreeNodeRender);
                            }
                        }
                    }
                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("2"))//成组药
                {
                    if (sender is OrderSingleRender)
                    {
                        OrderSingleRender ordersinglRender = sender as OrderSingleRender;
                        bool nowChecked = ordersinglRender.Checked;
                        if (nowChecked)
                        {
                            List<OrderSingleRender> brotherList = ordersinglRender.BrotherOrderCollecions;
                            foreach (OrderSingleRender brother in brotherList)
                            {
                                brother.Checked = true;
                                if (!this.lstOrTplNItmDOs.Contains(brother.ItemDo))
                                {
                                    this.lstOrTplNItmDOs.Add(brother.ItemDo);
                                    this.lstTreeNodes.Add(brother as XAPTreeNodeRender);
                                }
                            }
                            if (!this.lstOrTplNItmDOs.Contains(ordersinglRender.ItemDo))
                            {
                                this.lstOrTplNItmDOs.Add(ordersinglRender.ItemDo);
                                this.lstTreeNodes.Add(ordersinglRender as XAPTreeNodeRender);
                            }
                        }
                        else
                        {
                            this.lstOrTplNItmDOs.Remove(ordersinglRender.ItemDo);
                            this.lstTreeNodes.Add(ordersinglRender as XAPTreeNodeRender);
                        }
                    }
                    else if (sender is OrderGroupFirstOrder)
                    {
                        if ((sender as OrderGroupFirstOrder).Checked)
                        {
                            if (!this.lstTreeNodes.Contains(sender as XAPTreeNodeRender))
                                this.lstTreeNodes.Add(sender as XAPTreeNodeRender);
                        }
                        else
                        {
                            this.lstTreeNodes.Remove(sender as XAPTreeNodeRender);
                        }
                    }
                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("3"))//单一药品
                {
                    OrderSingleRender ordersinglRender = (sender as OrderSingleRender);
                    bool nowChecked = ordersinglRender.Checked;
                    if (nowChecked)
                    {
                        if (!this.lstOrTplNItmDOs.Contains(ordersinglRender.ItemDo))
                            this.lstOrTplNItmDOs.Add(ordersinglRender.ItemDo);
                    }
                    else
                    {
                        this.lstOrTplNItmDOs.Remove(ordersinglRender.ItemDo);
                    }
                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("4"))//其他（检查检验非套）
                {
                    LisFirstOrdrRender render = (sender as LisFirstOrdrRender);
                    bool nowChecked = render.Checked;
                    if (nowChecked)
                    {
                        if (!this.lstOrTplNItmDOs.Contains(render.ItemDo))
                            this.lstOrTplNItmDOs.Add(render.ItemDo);
                    }
                    else
                    {
                        this.lstOrTplNItmDOs.Remove(render.ItemDo);
                    }
                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("5"))//草药
                {
                    if (sender is ChineseMedicineOrder)
                    {
                        ChineseMedicineOrder render = (sender as ChineseMedicineOrder);
                        bool nowChecked = render.Checked;
                        if (nowChecked)
                        {
                            List<ChineseMedicineOrder> brotherList = render.BrotherOrderCollecions;
                            foreach (ChineseMedicineOrder brother in brotherList)
                            {
                                brother.Checked = true;
                                if (!this.lstOrTplNItmDOs.Contains(brother.ItemDo))
                                    this.lstOrTplNItmDOs.Add(brother.ItemDo);
                            }
                            if (!this.lstOrTplNItmDOs.Contains(render.ItemDo))
                                this.lstOrTplNItmDOs.Add(render.ItemDo);
                        }
                        else
                        {
                            this.lstOrTplNItmDOs.Remove(render.ItemDo);
                        }
                    }
                    else if (sender is ChineseMedcineFirstOrder)
                    {
                        if ((sender as ChineseMedcineFirstOrder).Checked)
                        {
                            if (!this.lstTreeNodes.Contains(sender as XAPTreeNodeRender))
                                this.lstTreeNodes.Add(sender as XAPTreeNodeRender);
                        }
                    }
                    else
                    {
                        this.lstTreeNodes.Remove(sender as XAPTreeNodeRender);
                    }
                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("6"))//诊疗
                {
                    TreatmentOrder render = (sender as TreatmentOrder);
                    bool nowChecked = render.Checked;
                    if (nowChecked)
                    {
                        if (!this.lstOrTplNItmDOs.Contains(render.ItemDo))
                            this.lstOrTplNItmDOs.Add(render.ItemDo);
                    }
                    else
                    {
                        this.lstOrTplNItmDOs.Remove(render.ItemDo);
                    }
                }
            }
        }

        /// <summary>
        /// 展开节点事件
        /// </summary>
        /// <param name="isExpand"></param>
        /// <param name="nodeRender"></param>
        private void nodeTree_ExpandRectClick(bool isExpand, XAPTreeNodeRender nodeRender)
        {
            if (isExpand)
            {
                loadNodes(nodeRender);
            }
        }

        private void render_DoubleClick(object sender, EventArgs e)
        {
            List<OrTplNItmDO> listCanSave = new List<OrTplNItmDO>();
            if (sender is IExtOrder)
            {
                if (!isActive((sender as IExtOrder).ExtAssist.OrderDto))
                {
                    return;
                }
                if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("1"))//套
                {
                    if (sender is LisFirstOrdrRender)//检查检验一级
                    {
                        foreach (var temp in (sender as LisFirstOrdrRender).SecondOrderCollections)
                        {
                            listCanSave.Add(temp.ItemDo);
                        }
                    }
                    else if (sender is LisSecondOrder)//检查检查二级
                    {
                        foreach (var temp in (sender as LisSecondOrder).BrotherOrderCollecions)
                        {
                            listCanSave.Add(temp.ItemDo);
                        }
                    }
                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("2"))//成组药
                {
                    List<OrderSingleRender> brotherRenders = (sender as OrderSingleRender).BrotherOrderCollecions;
                    foreach (OrderSingleRender brotherSingle in brotherRenders)
                    {
                        if (this.isActive(brotherSingle.ItemDo))
                        {
                            listCanSave.Add(brotherSingle.ItemDo);
                        }
                    }
                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("3"))//单一药品
                {
                    OrderSingleRender ordersinglRender = sender as OrderSingleRender;
                    if (this.isActive(ordersinglRender.ItemDo))
                    {
                        listCanSave.Add(ordersinglRender.ItemDo);
                    }
                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("4"))//其他（检查检验非套）
                {
                    LisFirstOrdrRender render = sender as LisFirstOrdrRender;
                    if (this.isActive(render.ItemDo))
                    {
                        listCanSave.Add(render.ItemDo);
                    }
                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("5"))//草药
                {
                    List<ChineseMedicineOrder> brotherRenders = (sender as ChineseMedicineOrder).BrotherOrderCollecions;
                    foreach (ChineseMedicineOrder brotherSingle in brotherRenders)
                    {
                        if (this.isActive(brotherSingle.ItemDo))
                        {
                            listCanSave.Add(brotherSingle.ItemDo);
                        }
                    }
                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("6"))//诊疗
                {
                    TreatmentOrder render = sender as TreatmentOrder;
                    if (this.isActive(render.ItemDo))
                    {
                        listCanSave.Add(render.ItemDo);
                    }
                }
            }
            if (listCanSave.Count == 0)
            {
                return;
            }
            else
            {
                if (this.saveToDb(listCanSave))
                {
                    xapBaseControl.SetStatusMsg("医嘱保存成功！");
                }
            }
        }

        private void render_OrderNodeClick(object sender, EventArgs e)
        {
            if (sender is IExtOrder)
            {
                if ((sender as XAPTreeNodeRender).Checked)
                {
                    lstTreeNodes.Add(sender as XAPTreeNodeRender);
                }
                else
                {
                    lstTreeNodes.Remove(sender as XAPTreeNodeRender);
                }
            }
        }
        #endregion

        #region 父类继承区域
        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            if (!string.IsNullOrWhiteSpace(this.sdortmpltp))
            {
                this.viewModel.LoadOrTmplCaAndTmplData(this.sdortmpltp);
                this.treeModel = this.viewModel.GetTreeKeyModel();
            }
            isLoaded = true;
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            this.oTree1.ClearTree();
            if (this.treeModel == null)
                return;
            this.oTree1.LoadData(this.treeModel);
            this.oTree1.ExpandToLevel(1);
        }
        #endregion

        #region 私有方法区域
        /// <summary>
        /// 模板节点加载明细节点
        /// </summary>
        /// <param name="templDTOs"></param>
        /// <param name="node"></param>
        private void loadTmplItemNodes(FArrayList templDTOs, XAPTreeNodeRender node)
        {
            foreach (NewOrderTemplateDTO templDTO in templDTOs)
            {
                OrderExtAssist render = new OrderExtAssist();
                render.NowTreeNodeRender = node;
                render.OrderDto = templDTO;
                render.DoubleClick += new EventHandler(render_DoubleClick);
                render.OrderNodeClick += new EventHandler(render_OrderNodeClick);
                render.LoadData();
            }
        }

        /// <summary>
        /// 选择需要保存的模板明细
        /// </summary>
        /// <returns></returns>
        private List<OrTplNItmDO> getTmplItemsToSave()
        {
            List<OrTplNItmDO> selectList = new List<OrTplNItmDO>();
            foreach (OrTplNItmDO itmdo in lstOrTplNItmDOs)
            {
                //非临床不处理
                if (itmdo.Fg_clinical.HasValue && !(bool)itmdo.Fg_clinical)
                    continue;
                if (itmdo.Fg_active == null || (itmdo.Fg_active != null && (bool)itmdo.Fg_active))
                {
                    if (!selectList.Contains(itmdo))
                    {
                        selectList.Add(itmdo);
                    }
                }
            }
            return selectList;
        }

        /// <summary>
        /// 判断服务是否被禁用
        /// </summary>
        /// <param name="sender"></param>
        /// <returns></returns>
        private bool isActive(object sender)
        {
            if (sender == null) return false;
            if (sender is NewOrderTemplateDTO)
            {
                if ((sender as NewOrderTemplateDTO).Fg_active != null && !(bool)(sender as NewOrderTemplateDTO).Fg_active)
                {
                    return false;
                }
            }
            else if (sender is OrTplNItmDO)
            {
                if ((sender as OrTplNItmDO).Fg_active != null && !(bool)(sender as OrTplNItmDO).Fg_active)
                {
                    return false;
                }
            }
            return true;
        }
        #endregion

        #region 页面加载外部调用方法
        public void loadView()
        {
            if (isLoaded) 
                return;
            this.LoadData();
        }

        public void clearTreeChecked()
        {
            this.oTree1.TreeItemCheckChanged -= new TreeItemEventHandler(oTree1_TreeItemCheckChanged);
            this.oTree1.TraverseNodes(node1 =>
            {
                XAPTreeNodeRender tempNode = node1 as XAPTreeNodeRender;
                if (tempNode.Checked)
                {
                    tempNode.Checked = false;
                }
            });
            foreach (XAPTreeNodeRender node in lstTreeNodes)
            {
                node.Checked = false;
            }
            this.lstOrTplNItmDOs.Clear();
            this.lstTreeNodes.Clear();
            this.oTree1.TreeItemCheckChanged += new TreeItemEventHandler(oTree1_TreeItemCheckChanged);
        }
        #endregion
        
    }
}
