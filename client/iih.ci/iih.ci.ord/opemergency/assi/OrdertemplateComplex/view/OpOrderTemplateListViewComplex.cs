using System;
using System.Linq;
using System.Drawing;
using System.Windows.Forms;
using System.Collections.Generic;
using xap.rui.control.basecontrol;
using iih.bd.srv.ortpl.d;
using iih.bd.srv.ortpl.dto;
using xap.cli.sdk.controls;
using iih.ci.ord.ciorder.render.common;
using iih.ci.ord.ciorder.render.complexOrder;
using iih.ci.ord.ciorder.render.interfaces;
using iih.ci.ord.dto.newordertemplatedto.d;
using xap.cli.sdk.common;
using xap.rui.control.extentions;
using iih.ci.ord.doctorhelper;
using iih.ci.ord.opemergency.assi.OrdertemplatePithy.model;
using xap.mw.core.data;
using iih.ci.ord.opemergency.assi.i;

namespace iih.ci.ord.opemergency.assi.OrdertemplateComplex.view
{
    /// <summary>
    /// 医嘱模板
    /// </summary>
    public partial class OpOrderTemplateListViewComplex : HelperListView,IViewCommond
    {
        #region 变量定义区域

        /// <summary>
        /// 医嘱模板-复杂模型-服务实体渲染集合
        /// </summary>
        public List<ComplexOrderAssist> ComplexOrderRenders { get; set; }

        /// <summary>
        /// model 模板明细
        /// </summary>
        private OrderTemplatePithyTreeViewModel model;
        /// <summary>
        /// 分割线的集合
        /// </summary>
        private List<OrderLineRender> _orderLineRenders;

        /// <summary>
        /// 当检索不到数据的时候的文本渲染实体
        /// </summary>
        private OrderEmptyRender _emptyRender;
    
    
        private XAPScrollBarPanel ContainerControl;

        //private String _tiptext;

        //private OrScArgs Args;
        /// <summary>
        /// 展现的模板数组
        /// </summary>
        public NewOrderTemplateDTO[] templateDtoArray;

        /// <summary>
        /// 模板Id
        /// </summary>
        private String id_ortmpl;

        public OpTemplateControlComplex parentControl;

        #endregion

        #region 构造函数区域
        public OpOrderTemplateListViewComplex()
        {

            InitializeComponent();

            Init();

            this.Load += new EventHandler(NewOrderTemplateListView_Load);
        }


        void Init()
        {
            this.ComplexOrderRenders = new List<ComplexOrderAssist>();
            this._orderLineRenders = new List<OrderLineRender>();
            this.model = new OrderTemplatePithyTreeViewModel();
            this.ContainerControl = new XAPScrollBarPanel();
            this.ContainerControl.Dock = DockStyle.Fill;
            this.AddRender(ContainerControl);


            _emptyRender = new OrderEmptyRender();
            _emptyRender.TipText = "未检索到相关数据";
            _emptyRender.Location=new Point(30,10);
            _emptyRender.Size=new Size(200,OrderConstAssist.OrderRenderHeight);
            _emptyRender.Visible = false;
            this.ContainerControl.AddRender(_emptyRender);
        }
        #endregion

        #region 内部事件区域

        private void NewOrderTemplateListView_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

        void assist_DoubleClick(object sender, EventArgs e)
        {
            List<OrTplNItmDO> listCanSave = new List<OrTplNItmDO>();
            string srvNames = "";
            if (sender is IComplexExtOrder)
            {
                if ((sender as IComplexExtOrder).IsTopLevelNode)//一级节点
                {
                    if (sender is GroupOrderTopRender)//一级节点--成组药品
                    {
                        if (!this.isActive((sender as GroupOrderTopRender).OrderDTo))
                        {
                            this.showErrorInfoOnDoubleClick((sender as GroupOrderTopRender).OrderDTo.Name);
                            return;
                        }
                        List<GroupOrderSecondRender> secondOrderCollections =
                            (sender as GroupOrderTopRender).SecondOrderCollections;
                        foreach (var temp in secondOrderCollections)
                        {
                            if (isActive(temp.ItemDo))
                            {
                                listCanSave.Add(temp.ItemDo);
                            }
                            else
                            {
                                srvNames += temp.ItemDo.Ortplnitm_srv_name + ",";
                            }
                        }

                    }
                    else if (sender is LisComplexFirstOrdrRender)//一级节点--检查检验套
                    {
                        if ((sender as LisComplexFirstOrdrRender).OrderDTo.Ui_flag == "1")
                        {
                            List<LisComplexSecondOrder> secondOrderCollections =
                               (sender as LisComplexFirstOrdrRender).SecondOrderCollections;
                            if (secondOrderCollections != null)
                            {
                                foreach (var temp in secondOrderCollections)
                                {
                                    if (isActive(temp.ItemDo))
                                    {
                                        listCanSave.Add(temp.ItemDo);
                                    }
                                    else
                                    {
                                        srvNames += temp.ItemDo.Ortplnitm_srv_name + ",";
                                    }
                                }
                            }
                        }
                        else {
                            if (isActive((sender as LisComplexFirstOrdrRender).ItemDo))
                            {
                                listCanSave.Add((sender as LisComplexFirstOrdrRender).ItemDo);
                            }
                            else
                            {
                                srvNames += (sender as LisComplexFirstOrdrRender).ItemDo.Ortplnitm_srv_name + ",";
                            }       
                        }
                    }
                    else if (sender is ChineseComplexTopRender)//一级节点-中药
                    {
                        List<ChineseComplexSecondOrder> secondOrderCollections =
                           (sender as ChineseComplexTopRender).SecondOrderCollections;
                        foreach (var temp in secondOrderCollections)
                        {

                            if (isActive(temp.ItemDo))
                            {
                                listCanSave.Add(temp.ItemDo);
                            }
                            else
                            {
                                srvNames += temp.ItemDo.Ortplnitm_srv_name + ",";
                            }
                        }
                    }
                    else if (sender is TreatComplexOrder) {//治疗

                        if (isActive((sender as TreatComplexOrder).ItemDo))
                            {
                                listCanSave.Add((sender as TreatComplexOrder).ItemDo);
                            }
                            else
                            {
                                srvNames += (sender as TreatComplexOrder).ItemDo.Ortplnitm_srv_name + ",";
                            }
                    }
                    else if (sender is SingleComplexTopOrderRender) {
                        if (isActive((sender as SingleComplexTopOrderRender).ItemDo))
                        {
                            listCanSave.Add((sender as SingleComplexTopOrderRender).ItemDo);
                        }
                        else
                        {
                            srvNames += (sender as SingleComplexTopOrderRender).ItemDo.Ortplnitm_srv_name + ",";
                        }
                    }
                }
                else
                {
                    if (sender is LisComplexSecondOrder)//套--子
                    {
                        LisComplexSecondOrder secondOrder = (sender as LisComplexSecondOrder);

                        foreach (var temp in secondOrder.BrotherOrderCollecions)
                        {
                            if (isActive(temp.ItemDo))
                            {
                                listCanSave.Add(temp.ItemDo);
                            }
                            else
                            {
                                srvNames += temp.ItemDo.Ortplnitm_srv_name + ",";
                            }
                        }


                    }
                    else if (sender is GroupOrderSecondRender)//成组药-子
                    {
                        GroupOrderTopRender order = (sender as GroupOrderSecondRender).ParentOrderRender;

                        foreach (var second in order.SecondOrderCollections)
                        {
                            if (isActive(second.ItemDo))
                            {
                                listCanSave.Add(second.ItemDo);
                            }
                            else
                            {
                                srvNames += second.ItemDo.Ortplnitm_srv_name + ",";
                            }
                        }
                    }
                    else if (sender is ChineseComplexSecondOrder)//中药--子
                    {
                        ChineseComplexTopRender order = (sender as ChineseComplexSecondOrder).ParentOrderRender;

                        foreach (var second in order.SecondOrderCollections)
                        {
                            if (isActive(second.ItemDo))
                            {
                                listCanSave.Add(second.ItemDo);
                            }
                            else
                            {
                                srvNames += second.ItemDo.Ortplnitm_srv_name + ",";
                            }
                        }
                    }
                }

            }
            if (listCanSave.Count == 0)
            {
                this.showErrorInfoOnDoubleClick(srvNames);
            }
            else {
                if(this.parentControl!=null)
                this.parentControl.saveToDb(listCanSave);
            }
        }
        #endregion

        #region 事件发送区域

        public override void OnSelected(object sender, TargetEventArgs e)
        {
            OrTmplDTO orTmpl = e.Object as OrTmplDTO;
            if (orTmpl != null)
            {
                this.id_ortmpl = orTmpl.Id_ortmpl.Substring(0, orTmpl.Id_ortmpl.Length-1);
            }
            else
            {
                this.id_ortmpl = "";
            }

            this.LoadData();
        }

        #endregion

        #region 父类继承区域
        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            if (!string.IsNullOrWhiteSpace(this.id_ortmpl))
            {
                FMap map = this.model.getNewOrderTemplateDTO2(this.Ent4BannerDTO, new string[] { this.id_ortmpl});
                if (map != null)
                {
                    FArrayList templList = map[this.id_ortmpl] as FArrayList;
                    if (templList!=null)
                    templateDtoArray = templList.Cast<NewOrderTemplateDTO>().ToArray();
                }
            }
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            foreach (var render in ComplexOrderRenders)
            {
                foreach (var item in render.RenderList)
                {
                    this.ContainerControl.RemoveRender(item);
                }
            }

            foreach (var render in _orderLineRenders)
            {
                this.ContainerControl.RemoveRender(render);
            }

            this.ComplexOrderRenders.Clear();
            this._orderLineRenders.Clear();

            //未检索到数据
            if (this.templateDtoArray == null || this.templateDtoArray.Length == 0)
            {
                _emptyRender.Visible = true;

            }
            else
            {
                _emptyRender.Visible = false;
            }


            if (this.templateDtoArray != null)
            {
                foreach (NewOrderTemplateDTO tpl in templateDtoArray)
                {
                    ComplexOrderAssist assist = new ComplexOrderAssist();
                    assist.OrderDto = tpl;
                    assist.Owner = this.ContainerControl;
                    assist.templatRstDTo = this.model.remplRes; 
                    assist.LoadData();
                    assist.DoubleClick += new EventHandler(assist_DoubleClick);
                    foreach (var render in assist.RenderList)
                    {
                        this.ContainerControl.AddRender(render);
                    }
                    this.ComplexOrderRenders.Add(assist);
                   
                }
            }
          

            ReLocate();
        }

        //对界面重新布局
        private new void ReLocate()
        {
            // ContainerControl
            int startX = OrderContext.ComplexFirstEmptyWidth;
            int startY = OrderContext.ComplexTopEmptyHeight;

            int lineHeight = 0;
            if (RelativeUIParam.ScreenSize == ScreenSize.Large)
            {
                lineHeight = OrderContext.ComplexSingleBigScreenHeight;
            }
            else
            {
                lineHeight = OrderContext.ComplexSingleHeight;
            }
            //首列分割线
            OrderLineRender orderLine = new OrderLineRender();
            orderLine.Location = new Point(0, startY);
            orderLine.Size = new Size(OrderContext.ComplexFirstEmptyWidth, this.ContainerControl.Size.Height - startY);
            this.ContainerControl.AddRender(orderLine);
            this._orderLineRenders.Add(orderLine);

            foreach (var complexRender in this.ComplexOrderRenders)
            {
                foreach (var tempRender in complexRender.RenderList)
                {
                    if (tempRender is IComplexExtOrder)
                    {

                        if (!(tempRender as IComplexExtOrder).IsTopLevelNode)
                        {
                            tempRender.Size = new Size(OrderContext.ServerSingleColWidth - OrderContext.ComplexSecondEmptyWidth, lineHeight);
                            tempRender.Location = new Point(startX + OrderContext.ComplexSecondEmptyWidth, startY);
                        }
                        else
                        {
                            tempRender.Size = new Size(OrderContext.ServerSingleColWidth, lineHeight);
                            tempRender.Location = new Point(startX, startY);
                        }

                        startY += lineHeight + OrderContext.ComplexSingleRowHeight;

                        if (startY + lineHeight > ContainerControl.Size.Height)
                        {
                            startY = OrderContext.ComplexTopEmptyHeight;
                            startX += OrderContext.ServerSingleColWidth + OrderContext.ComplexColSpace;

                            OrderLineRender spliteLineRender = new OrderLineRender();
                            spliteLineRender.Location = new Point(startX - OrderContext.ComplexColSpace, OrderContext.ComplexTopEmptyHeight);
                            spliteLineRender.Size = new Size(OrderContext.ComplexColSpace, this.ContainerControl.Size.Height - OrderContext.ComplexTopEmptyHeight);
                            this.ContainerControl.AddRender(spliteLineRender);
                            this._orderLineRenders.Add(spliteLineRender);
                        }
                    }

                }
              

            }

            this.ContainerControl.getScrollBarRect();
            this.ContainerControl.Invalidate();
        }


        #endregion

        #region 辅助处理函数
        public void saveData() { }
        public void close() { }
        public void clearSelectNode()
        {
            if (templateDtoArray != null && templateDtoArray.Count() > 0)
            {
                foreach (NewOrderTemplateDTO newOrderTemplateDTO in templateDtoArray)
                {
                    if (newOrderTemplateDTO.Fg_checked.HasValue && (bool)newOrderTemplateDTO.Fg_checked)
                    {
                        newOrderTemplateDTO.Fg_checked = false;  
                    } 
                    FArrayList ortmplitemdolist = newOrderTemplateDTO.Itemlist;
                    if (ortmplitemdolist != null)
                    {
                        foreach (OrTplNItmDO itmdo in ortmplitemdolist)
                        {
                            if (itmdo.Fg_checked.HasValue && (bool)itmdo.Fg_checked)
                            {
                                itmdo.Fg_checked = false;
                            }
                        }
                    }
                }
            }
        }
        public object getSaveData()
        {
            List<OrTplNItmDO> selecItmList = new List<OrTplNItmDO>();
            if (templateDtoArray != null && templateDtoArray.Count() > 0)
            {
                foreach (NewOrderTemplateDTO newOrderTemplateDTO in templateDtoArray)
                {
                    //newOrderTemplateDTO.Fg_checked = true;
                    FArrayList ortmplitemdolist = newOrderTemplateDTO.Itemlist;
                    if (ortmplitemdolist != null)
                    {
                        foreach (OrTplNItmDO itmdo in ortmplitemdolist)
                        {
                            if (itmdo.Fg_checked != null && (bool)itmdo.Fg_checked)
                            {
                                selecItmList.Add(itmdo);
                            }
                        }
                    }
                }
            }
            return selecItmList;
        }
        public void allChecked()
        {
            if (templateDtoArray != null && templateDtoArray.Count() > 0)
            {
                foreach (NewOrderTemplateDTO newOrderTemplateDTO in templateDtoArray)
                {
                    newOrderTemplateDTO.Fg_checked = true;
                    FArrayList ortmplitemdolist = newOrderTemplateDTO.Itemlist;
                    if (ortmplitemdolist != null)
                    {
                        foreach (OrTplNItmDO itmdo in ortmplitemdolist)
                        {
                            itmdo.Fg_checked = true;
                        }
                    }
                }
            }
        }
        public void allCancel()
        {
            if (templateDtoArray != null && templateDtoArray.Count() > 0)
            {
                foreach (NewOrderTemplateDTO newOrderTemplateDTO in templateDtoArray)
                {
                    newOrderTemplateDTO.Fg_checked = false;
                    FArrayList ortmplitemdolist = newOrderTemplateDTO.Itemlist;
                    if (ortmplitemdolist != null)
                    {
                        foreach (OrTplNItmDO itmdo in ortmplitemdolist)
                        {
                            itmdo.Fg_checked = false;
                        }
                    }
                }
            }
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
        private void showErrorInfoOnDoubleClick(string srv_name)
        {
            string errorInfo = "服务【" + srv_name + "】被禁用，无法保存！";
            this.ShowInfo(errorInfo);
        }
        #endregion


    }
}
