using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Windows.Forms;
using xap.rui.control.basecontrol;
using xap.rui.control.forms.view;
using xap.rui.control.tree.otree;
using iih.bd.srv.ortpl.dto;
using iih.bd.srv.ortpl.d;
using xap.rui.control.tree.events;
using iih.bd.bc.udi;
using iih.ci.ord.ciorder.render.interfaces;
using xap.cli.sdk.form;
using iih.en.pv.dto.d;
using iih.ci.ord.ems.d;
using iih.ci.ord.opemergency.assi.OrdertemplatePithy.model;
using xap.rui.control.tree.otree.model;
using xap.cli.sdk.render;
using iih.ci.ord.dto.newordertemplatedto.d;
using iih.ci.ord.ciorder.render.order;
using iih.ci.ord.common.utils.msg;
using xap.mw.core.data;
using xap.rui.control.tree.otree.node;
using iih.ci.ord.opemergency.viewmodel;
using xap.rui.control.extentions;

namespace iih.ci.ord.opemergency.assi.OrdertemplatePithy.view
{
    public partial class OpOrderTemplateTreeViewPithy : XapListControl
    {
        /// <summary>
        /// 事件交互类，与配置文件内的类进行交互
        /// </summary>
        public XapBaseControl xapBaseControl;
        public XForm AssiViewFrame { get; set; }
        public Ent4BannerDTO BannerDTO;
        /// <summary>
        /// 当前就诊环境
        /// </summary>
        public CiEnContextDTO ciEnContext { get; set; }
        
        private OTree oTree1;
        public TreeKeyModel<OrTmplDTO> treeKeyModel;
       
        public string modeltype { get; set; }//模板类型
        //private List<XAPTreeNodeRender> oneLevelTreeList = new List<XAPTreeNodeRender>();
        /// <summary>
        /// 选中的模板明细
        /// </summary>
        private List<OrTplNItmDO> selectList = new List<OrTplNItmDO>();//被选中的模板数据
        /// <summary>
        /// 选中的模板版明细节点
        /// </summary>
        private List<XAPTreeNodeRender> selectTreeList = new List<XAPTreeNodeRender>();
        public OpTemplateFramePithy parentFrame;
        public OrderTemplatePithyTreeViewModel model;
        /// <summary>
        /// 保存模板
        /// </summary>
        public AssButtonViewModel Buttonmodel;
        //是否已经加载过数据
        public bool isLoaded = false;
        /// <summary>
        /// 当前模板类型下，所有的模板明细
        /// </summary>
        private FMap modelMap;
        private bool isCheckChild = true;


        public OpOrderTemplateTreeViewPithy()
        {
            InitializeComponent();
            Buttonmodel = new AssButtonViewModel();
            this.Load += NewOrderTemplateTreeView_Load;
         
            this.oTree1.ShowNodeIcon = false;
            this.oTree1.ShowCheckBox = true;
            this.oTree1.ShowSearchBox = false;
            this.oTree1.TreeItemGetImageIndex += oTree1_TreeItemGetImageIndex;
            this.oTree1.TreeItemCheckChanged += new TreeItemEventHandler(oTree1_TreeItemCheckChanged);

            this.AddRender(this.oTree1);

            
           
            
        }
 
        

    
    
        /// <summary>
        /// 复选框选中事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void oTree1_TreeItemCheckChanged(object sender, TreeItemEventArgs e)
        {
            XAPTreeNodeRender nodeTree = e.Node as XAPTreeNodeRender;
            if (nodeTree.NodeData != null)
            {
                object nodeObj = (nodeTree.NodeData as BizNode).UserObject;
                if (nodeObj is OrTmplDTO)
                {
                    OrTmplDTO ortmplDO = nodeObj as OrTmplDTO;
                    //获得选中服务或模板下所有的模板id
                    FArrayList ids_Ortmpl = this.model.getAllChildOrTmplDTO(ortmplDO, this.modeltype);

                    if (nodeTree.Checked && ids_Ortmpl!=null)
                    {
                        if (this.parentFrame.cacheModelItem != null)
                        {
                            for (int i = ids_Ortmpl.Count - 1; i >= 0; i--)
                            {
                                if (this.parentFrame.cacheModelItem.ContainsKey(ids_Ortmpl[i] as string))
                                {
                                    FArrayList list = this.parentFrame.cacheModelItem[ids_Ortmpl[i] as string] as FArrayList;
                                    //获得可以保存的模板明细
                            
                                    getCanSaveItmToSelectList(list);
                                }
                            }
                        }
                    }
                    else
                    {//选中取消，将已选的模板明细移除
                        for (int i = ids_Ortmpl.Count - 1; i >= 0; i--)
                        {
                            for (int j = this.selectList.Count - 1; j >= 0; j--)
                            {
                                if (selectList[j].Id_ortmpl == ids_Ortmpl[i] as string)
                                {
                                    selectList.RemoveAt(j);
                                }
                            }
                        }
                    }
                }
            }
            else {
                //模板明细的选中事件
                modelItmChecked(sender,e);
            }
        }
        private void modelItmChecked(object obj, TreeItemEventArgs e)
        {
            if (e.Node is IExtOrder)
            {
                var sender = e.Node;
                if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("1"))//套
                {
                    LisFirstOrdrRender render = (sender as LisFirstOrdrRender);

                    if (sender is LisFirstOrdrRender)//检查检验一级
                    {
                        bool nowChecked = (sender as LisFirstOrdrRender).Checked;
                        if (nowChecked)
                        {
                            if (!this.selectTreeList.Contains(sender))
                                this.selectTreeList.Add(sender as XAPTreeNodeRender);
                        }
                        else {
                            this.selectTreeList.Remove(sender as XAPTreeNodeRender);
                        }
                        if (!isCheckChild) {
                            isCheckChild = true;;  
                        } 
                        foreach (var temp in (sender as LisFirstOrdrRender).SecondOrderCollections)
                        {
                            if (temp.ItemDo.Fg_active == null || (temp.ItemDo.Fg_active != null && (bool)temp.ItemDo.Fg_active))
                            {
                                temp.IsCanel = true;
                                temp.Checked = nowChecked;
                                temp.IsCanel = false;
                                if (nowChecked)
                                {
                                    if (!selectList.Contains(temp.ItemDo))
                                    {
                                        selectList.Add(temp.ItemDo);
                                        this.selectTreeList.Add(temp as XAPTreeNodeRender);
                                    }
                                        
                                }
                                else
                                {
                                    selectList.Remove(temp.ItemDo);
                                    this.selectTreeList.Remove(temp as XAPTreeNodeRender);
                                }
                            }
                            else
                            {
                                temp.IsCanel = true;
                                temp.Checked = nowChecked;
                                temp.IsCanel = false;
                            }
                        }

                    }
                    else if (sender is LisSecondOrder)//检查检查二级
                    {
                        //render.ExtAssist.OrderDto
                        LisSecondOrder secondeOrder = sender as LisSecondOrder;
                        bool nowChecked = secondeOrder.Checked;

                         bool flagResult = false;

                        foreach (var temp in secondeOrder.BrotherOrderCollecions)
                        {
                            //temp.Checked
                            if (nowChecked)
                            {
                                if (temp.ItemDo.Fg_active == null || (temp.ItemDo.Fg_active != null && (bool)temp.ItemDo.Fg_active))
                                {
                                    if (secondeOrder.ItemDo == temp.ItemDo || (temp.ItemDo.Fg_edit != null && !(bool)temp.ItemDo.Fg_edit))
                                    {
                                        temp.IsCanel = true;
                                        temp.Checked = nowChecked;
                                        temp.IsCanel = false;
                                        if (!selectList.Contains(temp.ItemDo))
                                        {
                                            selectList.Add(temp.ItemDo);
                                            this.selectTreeList.Add(temp as XAPTreeNodeRender);
                                        }

                                    }
                                }
                            }
                            else
                            {
                                if (temp == secondeOrder)
                                {
                                    if (selectList.Contains(temp.ItemDo))
                                    {
                                        selectList.Remove(temp.ItemDo);
                                        this.selectTreeList.Remove(temp as XAPTreeNodeRender);
                                    }
                                }
                            }

                            if (temp.IsChecked)
                            {
                              flagResult = true;
                            }

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
                                if (!this.selectTreeList.Contains(secondeOrder.ParentRender))
                                    this.selectTreeList.Add(secondeOrder.ParentRender as XAPTreeNodeRender);
                            }
                            else {
                                this.selectTreeList.Remove(secondeOrder.ParentRender as XAPTreeNodeRender);
                            }
                        }


                    }

                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("2"))//成组药
                {
                    if (sender is OrderSingleRender)
                    {
                        OrderSingleRender ordersinglRender = (sender as OrderSingleRender);
                        bool nowChecked = ordersinglRender.Checked;
                        if (nowChecked)
                        {
                            List<OrderSingleRender> brotherList = ordersinglRender.BrotherOrderCollecions;
                            foreach (OrderSingleRender brother in brotherList)
                            {
                                brother.Checked = true;
                                if (brother.Checked)
                                {
                                    if (!selectList.Contains(brother.ItemDo))
                                    {
                                        selectList.Add(brother.ItemDo);
                                        this.selectTreeList.Add(brother as XAPTreeNodeRender);
                                    }
                                }
                            }
                            if (!selectList.Contains(ordersinglRender.ItemDo))
                            {
                                selectList.Add(ordersinglRender.ItemDo);
                                this.selectTreeList.Add(ordersinglRender as XAPTreeNodeRender);
                            }
                        }
                        else
                        {
                            selectList.Remove(ordersinglRender.ItemDo);
                            this.selectTreeList.Add(ordersinglRender as XAPTreeNodeRender);
                        }
                    }
                    else  if(sender is OrderGroupFirstOrder)
                    {
                        if ((sender as OrderGroupFirstOrder).Checked)
                        {
                            if (!this.selectTreeList.Contains(sender))
                                this.selectTreeList.Add(sender as XAPTreeNodeRender);
                        }
                        else {
                            this.selectTreeList.Remove(sender as XAPTreeNodeRender);
                        }
                    }

                 
                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("3"))//单一药品
                {
                    OrderSingleRender ordersinglRender = (sender as OrderSingleRender);
                    bool nowChecked = ordersinglRender.Checked;
                    if (nowChecked)
                    {
                        if (!selectList.Contains(ordersinglRender.ItemDo))
                            selectList.Add(ordersinglRender.ItemDo);
                    }
                    else
                    {
                        selectList.Remove(ordersinglRender.ItemDo);
                    }
                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("4"))//其他（检查检验非套）
                {
                    LisFirstOrdrRender render = (sender as LisFirstOrdrRender);
                    bool nowChecked = render.Checked;
                    if (nowChecked)
                    {
                        if (!selectList.Contains(render.ItemDo))
                            selectList.Add(render.ItemDo);
                    }
                    else
                    {
                        selectList.Remove(render.ItemDo);
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
                                if (brother.Checked)
                                {
                                    if (!selectList.Contains(brother.ItemDo))
                                        selectList.Add(brother.ItemDo);
                                }
                            }
                            if (!selectList.Contains(render.ItemDo))
                                selectList.Add(render.ItemDo);
                        }
                        else
                        {
                            selectList.Remove(render.ItemDo);
                        }
                    }
                    else  if(sender is ChineseMedcineFirstOrder)
                    {
                        if ((sender as ChineseMedcineFirstOrder).Checked)
                        {
                            if (!this.selectTreeList.Contains(sender))
                                this.selectTreeList.Add(sender as XAPTreeNodeRender);
                        }
                        }
                        else {
                            this.selectTreeList.Remove(sender as XAPTreeNodeRender);
                        }
                        
                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("6"))//诊疗
                {
                    TreatmentOrder render = (sender as TreatmentOrder);
                    bool nowChecked = render.Checked;
                    if (nowChecked)
                    {
                        if (!selectList.Contains(render.ItemDo))
                            selectList.Add(render.ItemDo);
                    }
                    else
                    {
                        selectList.Remove(render.ItemDo);
                    }
                }
            }
        }
        /// <summary>
        /// 树节点去除图片
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void oTree1_TreeItemGetImageIndex(object sender, TreeItemGetImageIndexEventArgs e)
        {
            e.ImageKey = "";
        }

        void render_OrderNodeClick(object sender, EventArgs e)
        {
            
            if(sender is IExtOrder){
                if ((sender as XAPTreeNodeRender).Checked)
                {
                    selectTreeList.Add(sender as XAPTreeNodeRender);
                }
                else {
                    selectTreeList.Remove(sender as XAPTreeNodeRender);
                }
            }
            return;
            /*
            if (sender is IExtOrder)
            {
                if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("1"))//套
                {
                    LisFirstOrdrRender render = (sender as LisFirstOrdrRender);

                    if (sender is LisFirstOrdrRender)//检查检验一级
                    {
                        bool nowChecked = (sender as LisFirstOrdrRender).Checked;
                        foreach (var temp in (sender as LisFirstOrdrRender).SecondOrderCollections)
                        {
                            if (temp.ItemDo.Fg_active == null||(temp.ItemDo.Fg_active != null && (bool)temp.ItemDo.Fg_active))
                            {
                                temp.IsCanel = true;
                                temp.Checked = nowChecked;
                                temp.IsCanel = false;
                                if (nowChecked)
                                {
                                    if (!selectList.Contains(temp.ItemDo))
                                        selectList.Add(temp.ItemDo);
                                }
                                else
                                {
                                    selectList.Remove(temp.ItemDo);
                                }
                            }
                            else
                            {
                                temp.IsCanel = true;
                                temp.Checked = nowChecked;
                                temp.IsCanel = false;
                            }
                        }

                    }
                    else if (sender is LisSecondOrder)//检查检查二级
                    {
                        //render.ExtAssist.OrderDto
                        LisSecondOrder secondeOrder = sender as LisSecondOrder;
                        bool nowChecked = secondeOrder.Checked;

                       bool flagResult = false;

                        foreach (var temp in secondeOrder.BrotherOrderCollecions)
                        {
                            //temp.Checked
                            if (nowChecked)
                            {
                                if (temp.ItemDo.Fg_active==null||(temp.ItemDo.Fg_active != null && (bool)temp.ItemDo.Fg_active))
                                {
                                    if ((secondeOrder.ItemDo == temp.ItemDo)||temp.ItemDo.Fg_edit != null && !(bool)temp.ItemDo.Fg_edit)
                                    {
                                        temp.IsCanel = true;
                                        temp.Checked = nowChecked;
                                        temp.IsCanel = false;
                                        if (!selectList.Contains(temp.ItemDo))
                                        {
                                            selectList.Add(temp.ItemDo);
                                        }

                                    }
                                }
                            }
                            else
                            {
                                if (temp.ItemDo.Fg_active==null||(temp.ItemDo.Fg_active != null && (bool)temp.ItemDo.Fg_active))
                                    {
                                            temp.IsCanel = true;
                                            temp.Checked = nowChecked;
                                            temp.IsCanel = false;
                                            if (selectList.Contains(temp.ItemDo))
                                            selectList.Remove(temp.ItemDo);
                                    }
                            }

                            if (temp.IsChecked)
                            {
                                flagResult = true;
                            }

                        }

                        if (secondeOrder.ParentRender != null)
                        {
                            secondeOrder.ParentRender.IsCanel = true;
                            secondeOrder.ParentRender.NodeCheckBox.ReadOnly = true;
                            secondeOrder.ParentRender.IsChecked = flagResult;
                            secondeOrder.ParentRender.NodeCheckBox.ReadOnly = false;
                            secondeOrder.ParentRender.IsCanel = false;
                        }


                    }

                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("2"))//成组药
                {
                    OrderSingleRender ordersinglRender = (sender as OrderSingleRender);
                    bool nowChecked = ordersinglRender.Checked;
                    if (nowChecked)
                    {
                        if (!selectList.Contains(ordersinglRender.ItemDo))
                            selectList.Add(ordersinglRender.ItemDo);
                    }
                    else
                    {
                        selectList.Remove(ordersinglRender.ItemDo);
                    }
                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("3"))//单一药品
                {
                    OrderSingleRender ordersinglRender = (sender as OrderSingleRender);
                    bool nowChecked = ordersinglRender.Checked;
                    if (nowChecked)
                    {
                        if (!selectList.Contains(ordersinglRender.ItemDo))
                            selectList.Add(ordersinglRender.ItemDo);
                    }
                    else
                    {
                        selectList.Remove(ordersinglRender.ItemDo);
                    }
                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("4"))//其他（检查检验非套）
                {
                    LisFirstOrdrRender render = (sender as LisFirstOrdrRender);
                    bool nowChecked = render.Checked;
                    if (nowChecked)
                    {
                        if (!selectList.Contains(render.ItemDo))
                            selectList.Add(render.ItemDo);
                    }
                    else
                    {
                        selectList.Remove(render.ItemDo);
                    }
                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("5"))//草药
                {
                    ChineseMedicineOrder render = (sender as ChineseMedicineOrder);
                    bool nowChecked = render.Checked;
                    if (nowChecked)
                    {
                        if (!selectList.Contains(render.ItemDo))
                            selectList.Add(render.ItemDo);
                    }
                    else
                    {
                        selectList.Remove(render.ItemDo);
                    }
                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("6"))//诊疗
                {
                    TreatmentOrder render = (sender as TreatmentOrder);
                    bool nowChecked = render.Checked;
                    if (nowChecked)
                    {
                        if (!selectList.Contains(render.ItemDo))
                            selectList.Add(render.ItemDo);
                    }
                    else
                    {
                        selectList.Remove(render.ItemDo);
                    }
                }
            }
            */
        }

        void render_DoubleClick(object sender, EventArgs e)
        {
            List<OrTplNItmDO> listCanSave = new List<OrTplNItmDO>();
           
            string srvNames = "";
            if (sender is IExtOrder)
            {
                if (!isActive((sender as IExtOrder).ExtAssist.OrderDto)) {
                    showErrorInfoOnDoubleClick((sender as IExtOrder).ExtAssist.OrderDto.Name);
                    return;  
                } 
                if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("1"))//套
                {
                    LisFirstOrdrRender render = (sender as LisFirstOrdrRender);

                    if (sender is LisFirstOrdrRender)//检查检验一级
                    {
                        foreach (var temp in (sender as LisFirstOrdrRender).SecondOrderCollections)
                        {
                            listCanSave.Add(temp.ItemDo);
                        }

                    }
                    else if (sender is LisSecondOrder)//检查检查二级
                    {
                        LisSecondOrder secondeOrder = sender as LisSecondOrder;
                        foreach (var temp in secondeOrder.BrotherOrderCollecions)
                        {
                            listCanSave.Add(temp.ItemDo);
                        }
                    }

                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("2"))//成组药
                {
                    OrderSingleRender ordersinglRender = (sender as OrderSingleRender);
                    List<OrderSingleRender> brotherRenders = ordersinglRender.BrotherOrderCollecions;
                    foreach(OrderSingleRender brotherSingle in brotherRenders){
                        if (this.isActive(brotherSingle.ItemDo))
                        {
                            listCanSave.Add(brotherSingle.ItemDo);
                        }
                        else {
                            srvNames += brotherSingle.ItemDo.Ortplnitm_srv_name + ",";
                        }
                    }
                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("3"))//单一药品
                {
                    OrderSingleRender ordersinglRender = (sender as OrderSingleRender);
                    if (this.isActive(ordersinglRender.ItemDo))
                    {
                        listCanSave.Add(ordersinglRender.ItemDo);
                    }
                    else {
                        srvNames += ordersinglRender.ItemDo.Ortplnitm_srv_name + ",";
                    }
                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("4"))//其他（检查检验非套）
                {
                    LisFirstOrdrRender render = (sender as LisFirstOrdrRender);
                    if (this.isActive(render.ItemDo))
                    {
                        listCanSave.Add(render.ItemDo);
                    }
                    else
                    {
                        srvNames += render.ItemDo.Ortplnitm_srv_name + ",";
                    }
                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("5"))//草药
                {
                    ChineseMedicineOrder render = (sender as ChineseMedicineOrder);
                    List<ChineseMedicineOrder> brotherRenders = render.BrotherOrderCollecions;
                    foreach (ChineseMedicineOrder brotherSingle in brotherRenders)
                    {
                        if (this.isActive(brotherSingle.ItemDo))
                        {
                            listCanSave.Add(brotherSingle.ItemDo);
                        }
                        else
                        {
                            srvNames += brotherSingle.ItemDo.Ortplnitm_srv_name + ",";
                        }
                    }
                }
                else if ((sender as IExtOrder).ExtAssist.OrderDto.Ui_flag.Equals("6"))//诊疗
                {
                    TreatmentOrder render = (sender as TreatmentOrder);
                    if (this.isActive(render.ItemDo))
                    {
                        listCanSave.Add(render.ItemDo);
                    }
                    else
                    {
                        srvNames += render.ItemDo.Ortplnitm_srv_name + ",";
                    }
                }
            }
            if (listCanSave.Count == 0)
            {
                this.showErrorInfoOnDoubleClick(srvNames.Substring(0, srvNames.Length - 1));
                return;
            }
            else {
                this.saveToDb(listCanSave);
                xapBaseControl.SetStatusMsg("保存成功！");
            }
        }

        void NewOrderTemplateTreeView_Load(object sender, EventArgs e)
        {
            OnInit();
        }

     
        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            if (!string.IsNullOrWhiteSpace(modeltype))
            {
                this.treeKeyModel = this.model.loadTreeModel(this.modeltype);
            }

            isLoaded = true;
            FArrayList modelIds = this.model.getModelIdByModelType(this.modeltype);
            modelMap = this.model.getNewOrderTemplateDTO2(this.BannerDTO, modelIds.Cast<string>().ToArray());
            foreach (string keyId in modelMap.Keys)
            {
                FArrayList list = modelMap[keyId] as FArrayList;
                if (this.parentFrame.cacheModelItem == null) this.parentFrame.cacheModelItem = new Dictionary<string, FArrayList>();
                if (!this.parentFrame.cacheModelItem.ContainsKey(keyId))
                {
                    this.parentFrame.cacheModelItem.Add(keyId, list);
                }
            }
        }
        #endregion

        #region 内部事件区域
        

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            this.oTree1.ClearTree();
            if (this.treeKeyModel == null)
                return;
            oTree1.LoadData(treeKeyModel);
            //oTree1.MoveFirst();
            if(this.oTree1.FirstNode!=null){
               // this.oTree1.FirstNode.IsExpanded = true;
                //getAllFirstLevelTreeNodes(this.oTree1.FirstNode as XAPTreeNodeRender);
            }
            oTree1.TraverseNodes(node1 =>
            {
                object userObj = oTree1.GetUserObject(node1);
                if (userObj is OrTmplDTO)
                {
                    OrTmplDTO focusObj = userObj as OrTmplDTO;
                    String id_ortmpl = focusObj.Id_ortmpl;
                    //如果不是模板类型就不处理
                    if (focusObj.OrtmplType == "1")
                    {
                        FArrayList modelList = this.modelMap[id_ortmpl.Substring(0,id_ortmpl.Length-1)] as FArrayList;
                        if (modelList != null) {
                            this.loadModelItm(modelList, node1 as XAPTreeNodeRender);
                        }
                    }
                }
            });
            this.oTree1.ExpandToLevel(0);
        }

       
        #endregion

      
        #region 内部工具方法
        //private void getAllFirstLevelTreeNodes(XAPTreeNodeRender treeNode) {
        //    if (treeNode != null) {
        //        this.oneLevelTreeList.Add(treeNode);
        //    }
        //    XAPTreeNodeRender nextNode = treeNode.NextNode;
        //    if (nextNode != null) {
        //        this.oneLevelTreeList.Add(nextNode);
        //        getAllFirstLevelTreeNodes(nextNode);
        //    }
        //    return;
        //}
        /// <summary>
        /// 选择需要保存的模板明细
        /// </summary>
        /// <param name="modelItmList"></param>
        private void getCanSaveItmToSelectList(FArrayList modelItmList) {
            if (modelItmList == null || modelItmList.Count == 0) return;
            foreach (NewOrderTemplateDTO templateDTO in modelItmList)
            {
                if (templateDTO.Fg_active.HasValue && !(bool)templateDTO.Fg_active)
                    continue;
                FArrayList itmdos = templateDTO.Itemlist;
                if (itmdos != null)
                {
                    foreach (OrTplNItmDO itmdo in itmdos)
                    {
                        //非临床不处理
                        if (itmdo.Fg_clinical.HasValue && !(bool)itmdo.Fg_clinical)
                            continue;
                        if (itmdo.Fg_active == null || (itmdo.Fg_active != null && (bool)itmdo.Fg_active))
                        {
                            if (!this.selectList.Contains(itmdo))
                            {
                                this.selectList.Add(itmdo);
                            }
                        }

                    }
                }
            }
        }
        /// <summary>
        /// 一级节点的互斥操作
        /// </summary>
        /// <param name="node"></param>
        //private void noeLevelNodeReact(XAPTreeNodeRender node)
        //{
        //    if (node == null) return;
        //    if (oneLevelTreeList.Contains(node))
        //    {
        //        foreach (XAPTreeNodeRender oneNode in oneLevelTreeList)
        //        {
        //            if (oneNode != node)
        //            {
        //                oneNode.IsExpanded = false;
        //            }
        //        }
        //    }
        //}
        /// <summary>
        /// 加载模板明细
        /// </summary>
        private void loadModelItm(FArrayList list, XAPTreeNodeRender node)
        {
            foreach (NewOrderTemplateDTO templateDTO in list)
            {
                OrderExtAssist render = new OrderExtAssist();
                render.NowTreeNodeRender = node;
                render.OrderDto = templateDTO;
                render.DoubleClick += new EventHandler(render_DoubleClick);
                render.OrderNodeClick += render_OrderNodeClick;
                render.LoadData();
            }
            
        }
        /// <summary>
        /// 判断服务是否被禁用
        /// </summary>
        /// <param name="sender"></param>
        /// <returns></returns>
        private bool isActive(object sender) {
            if (sender == null) return false;
            if (sender is NewOrderTemplateDTO)
            {
                if((sender as NewOrderTemplateDTO).Fg_active!=null&&!(bool)(sender as NewOrderTemplateDTO).Fg_active){
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
        private void showErrorInfoOnDoubleClick(string srv_name) {
            string errorInfo = "服务【" + srv_name + "】被禁用，无法保存！";
            this.ShowInfo(errorInfo);
        }
        #endregion

        #region 页面加载外部调用方法
        public void loadView() {
            if (isLoaded) return;
            this.LoadData();
        }
        public void clearTreeChecked()
        {
            this.oTree1.TreeItemCheckChanged -= new TreeItemEventHandler(oTree1_TreeItemCheckChanged);
            oTree1.TraverseNodes(node1 =>
            {
                XAPTreeNodeRender tempNode =node1 as XAPTreeNodeRender;
                if(tempNode.Checked)
                {
                    tempNode.Checked = false;
                }
            });
            foreach (XAPTreeNodeRender node in selectTreeList)
            {
               node.Checked = false;    
            }
            this.selectList.Clear();
            selectTreeList.Clear();
            this.oTree1.TreeItemCheckChanged += new TreeItemEventHandler(oTree1_TreeItemCheckChanged);
        }
        #endregion
    }
}
