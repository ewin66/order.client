using System;
using iih.en.pv.dto.d;
using iih.en.pv.entdiprove.d;
using xap.rui.engine;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.control.engine.attributes;
using iih.ci.ord.dicertificate.viewmodel;
using xap.sys.xbd.udi.d;
using iih.bd.bc.udi;
using xap.mw.core.data;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.control.tree.otree.node;

/********************************************************************************

** 作者： 杨敬本

** 创始时间：2016/10/27

** 修改人：杨敬本

** 修改时间：2016/10/28

** 描述：诊断证明树列表

*********************************************************************************/

namespace iih.ci.ord.dicertificate.view
{
    public partial class DiCertificateTreeView : XapListControl
    {
        #region 变量定义区域
        private DiCertificateTreeViewModel viewModel;

        public Ent4BannerDTO ent4BannerDTO;
        public XapBaseControl parentBaseControl;
        public XUserControl parentUserControl;

        private UdidocDO currUdi;//诊断证明分类
        private EntDiProveDO currDi;//诊断证明

        private bool bSelect;
        private string idtp_del;
        #endregion

        #region 构造函数区域
        public DiCertificateTreeView()
        {
            InitializeComponent();

            this.Load += new EventHandler(DiCertificateTreeView_Load);
        }
        #endregion

        #region 命令定义区域
        public void OnAdd()
        {
            createEntDiProveDO();

            onFireEventSent(Utils.TOADD, this.currDi);
        }
        
        public void OnDelete()
        {
            viewModel.Delete(this.currDi);
            this.idtp_del = this.currDi.Id_diprovetp;
            this.currDi = null;
            if (this.parentBaseControl != null)
                this.parentBaseControl.SetStatusMsg("删除成功!");
            else if(this.parentUserControl!=null)
                this.parentUserControl.SetStatusMsg("删除成功!");
        }
        #endregion

        #region 内部事件区域
        private void DiCertificateTreeView_Load(object sender, EventArgs e)
        {
            this.viewModel = new DiCertificateTreeViewModel();
            this.currUdi = viewModel.CurrUdidocDO_DiceType;
            this.currDi = new EntDiProveDO();

            this.oTree1.TreeItemSelected += new xap.rui.control.tree.events.TreeItemEventHandler(oTree1_TreeItemSelected);

            this.OnInit();
        }

        private void oTree1_TreeItemSelected(object sender, xap.rui.control.tree.events.TreeItemEventArgs e)
        {
            bSelect = true;

            string strCommond = "";
            if (e.Node.Level != 1)
            {
                //strCommond = Utils.SELECTROW;
                Type tp = oTree1.FocusedUserObject.GetType();
                switch (tp.Name)
                {
                    case "UdidocDO"://选中诊断证明分类
                        this.currUdi = (UdidocDO)oTree1.FocusedUserObject;
                        //选中分类是数据独一模式（仅保存一条数据）
                        if ("0" == this.currUdi.Ctrl1)
                        {
                            if (this.ent4BannerDTO.Status.ToString() != EnDictCodeConst.SD_ENSTATUS_OP_FINISH)
                            {
                                //准备根据患者是否诊毕，判断是否要打印
                            }

                            //获取当前独一分类的诊断证明数据（唯一）
                            EntDiProveDO[] dos = viewModel.GetEntDiProveDOByDiProveType(this.ent4BannerDTO.Id_ent, this.currUdi.Code);
                            if (dos != null && dos.Length > 0)
                            {
                                this.currDi = dos[0];
                                //0904临时添加，数据保存模式和单据打印模式，需要分开判断
                                strCommond = this.currUdi.Ctrl2 == "0" && this.currDi.Num_print != null && this.currDi.Num_print > 0 ? Utils.SELECTROWONLYPRINTED : Utils.SELECTROWONLYSAVED;
                            }
                            else
                            {
                                this.createEntDiProveDO();//如果还没有保存数据，则新增数据（仅一次）
                                strCommond = Utils.SELECTROWONLYNEW;
                            }
                        }
                        else
                        {
                            //选中分类不是独一模式，
                            strCommond = Utils.SELECTROWNOTONLY;
                            this.currDi = new EntDiProveDO();
                            this.currDi.Id_diprovetp = this.currUdi.Id_udidoc;
                            this.currDi.Sd_diprovetp = this.currUdi.Code;
                        }
                        break;
                    case "EntDiProveDO"://选中诊断证明
                        strCommond = Utils.SELECTROWITEM;
                        this.currUdi = null;
                        this.currDi = (EntDiProveDO)oTree1.FocusedUserObject;
                        break;
                    default:
                        break;
                }
            }
            else
            {
                strCommond = Utils.SELECTROOT;
                this.currDi = null;
            }

            onFireEventSent(strCommond, this.currDi);
        }
        #endregion

        #region 父类继承区域
        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            viewModel.LoadData(ent4BannerDTO.Id_ent);

            this.oTree1.ClearTree();
            if (this.viewModel == null)
                return;

            this.viewModel.GetTreeKeyModel();
            this.oTree1.LoadData(this.viewModel.lazyLoadTreeModel);
            //(this.oTree1.FirstNode as BizNode).Visible = false;
            this.oTree1.ExpandAll();

            if (bSelect)
            {
                if (this.currDi != null && this.currDi.Id_diprove != null && "0" != DiCertificateTreeViewModel.GetDiprovetTp(this.currDi.Sd_diprovetp).Ctrl1)
                {
                    foreach (var di in this.viewModel.lstEntDiProveDOs)
                    {
                        if (di.Id_diprove.Equals(this.currDi.Id_diprove))
                        {
                            this.oTree1.FocusedUserObject = di;
                        }
                    }
                }
                else if (this.currUdi == null)
                {
                    if (idtp_del != null)
                    {
                        foreach (var udi in DiCertificateTreeViewModel.udidocDOs_DiceType)
                        {
                            if (idtp_del.Equals(udi.Id_udidoc))
                                this.oTree1.FocusedUserObject = udi;
                        }
                    }
                }
                else
                    this.oTree1.FocusedUserObject = this.currUdi;
            }
        }
        #endregion

        #region 辅助处理区域
        /// <summary>
        /// 创建新的诊断证明数据
        /// </summary>
        private void createEntDiProveDO()
        {
            this.currDi = new EntDiProveDO();
            this.currDi.Id_pat = this.ent4BannerDTO.Id_pat;
            this.currDi.Name_pat = this.ent4BannerDTO.Name_pat;
            this.currDi.Id_ent = this.ent4BannerDTO.Id_ent;
            this.currDi.Code_ent = this.ent4BannerDTO.Code_ent;
            //this.currDi.Id_di
            //this.currDi.Id_diitm
            //this.currDi.Str_id_di
            this.currDi.Str_name_di = viewModel.GetDiInfo(ent4BannerDTO.Id_ent);
            this.currDi.Sd_sex = this.ent4BannerDTO.Name_sex;
            this.currDi.Age = this.ent4BannerDTO.Age;
            //this.currDi.unit_age
            this.currDi.Id_dep = this.ent4BannerDTO.Id_dep_phy;
            this.currDi.Name_dept = this.ent4BannerDTO.Name_dep_phy;
            this.currDi.Code_dep = this.ent4BannerDTO.Code_entp;
            this.currDi.Dt_acpt = this.ent4BannerDTO.Dt_entry;
            this.currDi.Dt_end = this.ent4BannerDTO.Dt_end;
            //this.currDi.Advice
            this.currDi.Id_emp = this.ent4BannerDTO.Id_emp_phy;
            this.currDi.Name_emp = this.ent4BannerDTO.Name_emp_phy;
            this.currDi.Dt_diprove = DateTime.Now;
            this.currDi.Num_print = 0;
            this.currDi.Fg_seal = false;
            this.currDi.Id_diprovetp = this.currUdi.Id_udidoc;
            this.currDi.Sd_diprovetp = this.currUdi.Code;
            this.currDi.Id_certif = this.ent4BannerDTO.Id_code;
        }

        /// <summary>
        /// 执行保存
        /// </summary>
        private void toSave()
        {
            this.currDi.Status = this.currDi.Id_diprove != null ? DOStatus.UPDATED : DOStatus.NEW;
            this.currDi = viewModel.Save(this.currDi);
            onFireEventSent(Utils.SAVESUCESS, this.currDi);
            if (this.parentBaseControl!=null)
                this.parentBaseControl.SetStatusMsg("保存成功!");
            else if (this.parentUserControl != null)
                this.parentUserControl.SetStatusMsg("保存成功!");
        }

        /// <summary>
        /// 发送事件
        /// </summary>
        /// <param name="strCommond"></param>
        /// <param name="sender"></param>
        protected void onFireEventSent(string strCommond, object sender)
        {
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data.Add(UIConst.UI_EVENT, strCommond);
            this.FireEventSent(sender, args);
        }
        #endregion

        #region 状态处理区域
        /// <summary>
        /// 接收响应事件发送
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="eventArgs"></param>
        public override void HandleState(object sender, xap.rui.engine.DictionaryEventArgs e)
        {
            string uiEvent = e.Data[UIConst.UI_EVENT] as string;

            switch (uiEvent)
            {
                case UIEvent.ADD:
                    this.OnAdd();
                    break;
                case UIEvent.DELETE:
                    if (this.IsContinue("提示:", "是否确认删除？"))
                    {
                        this.OnDelete();
                        this.LoadData();
                    }
                    break;
                case Utils.TOSAVE:
                    //this.currDi = sender as EntDiProveDO;
                    this.toSave();
                    this.LoadData();
                    break;
                case Utils.PRINTSUCESS:
                    EntDiProveDO di = viewModel.GetEntDiProveDOByID(this.currDi.Id_diprove);
                    di.Num_print = this.currDi.Num_print;
                    di.Status = DOStatus.UPDATED;
                    viewModel.Save(di);
                    this.LoadData();
                    break;
                default:
                    break;
            }
        }
        #endregion

    }
}
