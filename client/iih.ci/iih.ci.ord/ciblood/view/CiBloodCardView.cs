using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.control.basecontrol;
using iih.ci.ord.ciblood.viewmodel;
using xap.rui.control.forms.model;
using xap.rui.control.engine.attributes;
using xap.rui.control.extentions;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.control.refcontrol.events;
using xap.rui.engine;
using iih.ci.ord.cior.d;
using xap.rui.appfw;
using xap.cli.sdk.render.labelcontrol;

namespace iih.ci.ord.ciblood.view
{
    public partial class CiBloodCardView : XapCardControl
    {
        #region 变量定义区域
        private CiBloodCardViewModel model;
        private bool checkEdit = true;
        private bool canSubmit = true;
        private XLabelBaseUserRender recheck_name;
        private XLabelBaseUserRender pat_name;
        private XLabelBaseUserRender rh_pat_name;
        private XLabelBaseUserRender des;
        private XLabelBaseUserRender dt_recheck;
        #endregion

        #region 构造函数区域

        public CiBloodCardView()
        {
            InitializeComponent();
            this.Load += new EventHandler(CiCheckCardView_Load);
            this.xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl_DataChanged);
            this.xapFormControl1.DataChanging +=new EventHandler<DataChangingEventArgs>(xapFormControl1_DataChanging);
            this.xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            this.xapFormControl1.RefFilter += this.OnRefFilter;
            this.xapFormControl1.RefResult += this.OnRefResult;
            this.xapFormControl1.AddNewRowNotify += new AddNewRowNotifyHandler(xapFormControl1_AddNewRowNotify);
        }      
        #endregion

        #region 命令定义区域
        /// <summary>
        /// 保存动作
        /// </summary>
        [XapCommand(Name = "Save")]
        public void OnSave()
        {
            if (this.xapFormControl1.HasErrors)
            {
                return;
            }
            CiOrdBtTestItmDO[] result = this.model.XapAggDO.Find(typeof(CiOrdBtTestItmDO).FullName) as XapDataList<CiOrdBtTestItmDO>;
            if (result.Length == 0)
            {
                this.ShowInfo("配血结果列表为空，不能保存！");
                return;
            }
            CiOrdBtTestItmDO[] listItmDo = this.model.checkBarcode_bb(result);
            if (listItmDo.Length != 0)
            {
                string str = "明细列表中下列血袋条形码存在重复" + "\n";
                for (int i = 0; i < listItmDo.Length; i++)
                {
                    str = str + listItmDo[i].Barcode_bb + "\n";
                }
                this.ShowInfo(str);
                return;
            }
            this.model.Save();
            this.xapFormControl1.SaveForm();
            this.SetStatusMsg("保存成功！");
        }

        /// <summary>
        /// 提交动作
        /// </summary>
        [XapCommand(Name = "Submit")]
        public void OnSubmit()
        {
            if (this.xapFormControl1.IsModified)
            {
               this.OnSave();
            }
           string result =  this.model.CiOrdSubmit(this.model.XapAggDO);
           if (result == null)
            {
                this.SetStatusMsg("更新备血余量失败！");
            }
           this.SetStatusMsg("提交成功！");
           this.xapFormControl1.SetEditPolicy(true, new DataPolicy[] { SetEditable(false), SetItemEditable(false) });
           setOtherUserRender(false);
            canSubmit = false;
        }

        #endregion

        #region 父类继承区域
        /// <summary>
        /// 获取控件相关的数据
        /// </summary>
        protected override void OnLoadData()
        {
            this.model = new CiBloodCardViewModel(this.Context);  
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            if (this.model == null)
                return;

            FormFile file = new FormFile();
            file.FormId = "201512220142029681PS";
            file.FormStyle = FormStyle.Card;
            file.ViewModel = this.model.XapAggDO;
            this.xapFormControl1.ViewFile = file;
        }

        /// <summary>
        /// 按钮状态控制
        /// </summary>
        public override void OnStatus()
        {
            bool enabled = false;
            enabled = !this.xapFormControl1.HasErrors && this.xapFormControl1.IsModified && !checkEdit && canSubmit;
            this.SetEnable("Save", enabled);
            enabled = !this.xapFormControl1.HasErrors && canSubmit;
            this.SetEnable("Submit", enabled);
        }
        /// <summary>
        /// 参照控件数据过滤
        /// </summary>
        protected override void OnRefFilter(object sender, RefActivatingEventArgs e)
        {
            switch(e.BindingFieldName)
            {

                case "Mm_name":
                    CiOrdBtTestDO CiDo = this.model.XapAggDO.Parent as CiOrdBtTestDO;
                    e.RefParams.AddParam("id_srv", CiDo.Id_srv_bt);
                    break;            
            }
           
        }

        /// <summary>
        /// 参照控件数据选中
        /// </summary>
        protected override void OnRefResult(object sender, RefResultEventArgs e)
        {
            switch (e.BindingFieldName)
            {
                case "Applyformno":
                    this.model.DataChanged(e.DataObject as CiOrdBtTestDO, this.Context);
                    CiOrdBtTestDO CiDo = this.model.XapAggDO.Parent as CiOrdBtTestDO;
                    CiOrdBtTestItmDO[] result = this.model.XapAggDO.Find(typeof(CiOrdBtTestItmDO).FullName) as XapDataList<CiOrdBtTestItmDO>;
                    canSubmit = CiDo.Sd_su_bttest != "1";
                    checkEdit = result.Any(t => t.Fg_st == true) || !canSubmit;
                    this.OnFillData();
                    this.xapFormControl1.SetEditPolicy(true, new DataPolicy[] { SetEditable(true), SetItemEditable(!checkEdit) });
                    setOtherUserRender(!checkEdit);                
                    break;
            }
        }

       
        #endregion

        #region 内部事件区域
        public void xapFormControl1_AddNewRowNotify(object obj)
        {
            CiOrdBtTestDO CiDo = this.model.XapAggDO.Parent as CiOrdBtTestDO;
             //CiOrdBtTestItmDO[] CiItemDoList = this.model.XapAggDO.FindChildren<CiOrdBtTestItmDO>();
             CiOrdBtTestItmDO[] CiItemDoList = this.model.XapAggDO.Find(typeof(CiOrdBtTestItmDO).FullName) as XapDataList<CiOrdBtTestItmDO>;
            CiOrdBtTestItmDO CiItemDo = obj as CiOrdBtTestItmDO;
            CiItemDo.Id_srv_bt = CiDo.Id_srv_bt;
            CiItemDo.Name_bt_srv = CiDo.Name_bt;
            CiItemDo.Id_unit_bb = CiDo.Id_medu;
            CiItemDo.Unit_bb_name = CiDo.Medu_name;
            CiItemDo.Name_bt = CiDo.Name_bt;
            for (int i = CiItemDoList.Length - 1; i > 0; i--)
            {
                if (CiItemDoList[i-1].IsDELETED == false)
                {
                    CiItemDo.Id_srv_bt = CiItemDoList[i-1].Id_srv_bt;
                    CiItemDo.Code_bt_srv = CiItemDoList[i-1].Code_bt_srv;
                    CiItemDo.Name_bt_srv = CiItemDoList[i - 1].Name_bt_srv;
                    CiItemDo.Num_bb = CiItemDoList[i-1].Num_bb;
                    CiItemDo.Id_abo_bt = CiItemDoList[i-1].Id_abo_bt;
                    CiItemDo.Abo_name = CiItemDoList[i-1].Abo_name;
                    CiItemDo.Id_rh_bt = CiItemDoList[i-1].Id_rh_bt;
                    CiItemDo.Rh_name = CiItemDoList[i-1].Rh_name;
                    CiItemDo.Id_testitmmeth = CiItemDoList[i-1].Id_testitmmeth;
                    CiItemDo.Bt_method_name = CiItemDoList[i-1].Bt_method_name;
                    CiItemDo.Id_testitmres_m = CiItemDoList[i-1].Id_testitmres_m;
                    CiItemDo.Bt_rsm_name = CiItemDoList[i-1].Bt_rsm_name;
                    CiItemDo.Id_testitmres_s = CiItemDoList[i-1].Id_testitmres_s;
                    CiItemDo.Bt_rss_name = CiItemDoList[i-1].Bt_rss_name;
                    CiItemDo.Id_emp_testitm = CiItemDoList[i-1].Id_emp_testitm;
                    CiItemDo.Test_name = CiItemDoList[i-1].Test_name;
                    CiItemDo.Id_emp_retestitm = CiItemDoList[i-1].Id_emp_retestitm;
                    CiItemDo.Retest_name = CiItemDoList[i-1].Retest_name;
                    CiItemDo.Dt_restitm = CiItemDoList[i-1].Dt_restitm;
                    CiItemDo.Id_mm = CiItemDoList[i - 1].Id_mm;
                    CiItemDo.Mm_name = CiItemDoList[i - 1].Mm_name; 
                    return;
                }


            }
        }
        public void xapFormControl_DataChanged(object sender, DataChangedEventArgs e)
        {
            if (e.Data is CiOrdBtTestDO)
            {
                switch (e.PropName)
                {
                    case "Applyformno":
                        CiOrdBtTestDO CiDo = e.Data as CiOrdBtTestDO;

                        if (CiDo.Applyformno == null)
                        {
                            this.LoadData();
                            this.xapFormControl1.SetEditPolicy(true, new DataPolicy[] { SetEditable(true), SetItemEditable(true) });
                        }
                        break;
                }
            }
            //if (e.Data is CiOrdBtTestItmDO)
            //{
            //    CiOrdBtTestItmDO[] CiItemDoList = this.model.XapAggDO.Find(typeof(CiOrdBtTestItmDO).FullName) as XapDataList<CiOrdBtTestItmDO>;
            //    CiOrdBtTestItmDO CiItemDo = e.Data as CiOrdBtTestItmDO;
            //    switch (e.PropName)
            //    {
            //        case "Barcode_bb":
            //            if (CiItemDoList != null &&
            //                CiItemDoList.Any(t => t.IsDELETED != true && !t.Equals(CiItemDo) && t.Barcode_bb == CiItemDo.Barcode_bb))
            //            {
            //                this.ShowInfo("血袋条形码不能重复!");
            //                CiItemDo.Barcode_bb = null;
            //            }
            //            break;
            //    }
            //}

        }
        public void xapFormControl1_DataChanging(object sender, DataChangingEventArgs e)
        {
            if (e.Object is CiOrdBtTestItmDO)
            {
                switch (e.PropName)
                {
                    case "Barcode_bb": 
                         CiOrdBtTestItmDO[] CiItemDoList = this.model.XapAggDO.Find(typeof(CiOrdBtTestItmDO).FullName) as XapDataList<CiOrdBtTestItmDO>;
                        CiOrdBtTestItmDO CiItemDo = e.Object as CiOrdBtTestItmDO;
                        if (CiItemDoList != null &&
                            CiItemDoList.Any(t => t.IsDELETED != true && !t.Equals(CiItemDo) && t.Barcode_bb == e.Input.ToString()))
                        {
                            this.ShowInfo("血袋条形码不能重复!");
                            e.Cancel = true;
                        }
                        break;
                }
            }

        }
        public void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            this.recheck_name = this.xapFormControl1.GetUserRender("Card", "id_emp_recheck.name") as XLabelBaseUserRender;
            this.pat_name = this.xapFormControl1.GetUserRender("Card", "id_abo_pat.name") as XLabelBaseUserRender;
            this.rh_pat_name = this.xapFormControl1.GetUserRender("Card", "id_rh_pat.name") as XLabelBaseUserRender;
            this.des = this.xapFormControl1.GetUserRender("Card", "des") as XLabelBaseUserRender;
            this.dt_recheck = this.xapFormControl1.GetUserRender("Card", "dt_recheck") as XLabelBaseUserRender;
        }
        /// <summary>
        /// 加载事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void CiCheckCardView_Load(object sender, EventArgs e)
        {
            base.OnInit();
            this.xapFormControl1.SetEditPolicy(true, new DataPolicy[] { SetEditable(true), SetItemEditable(true) });
        }
        #endregion

        #region 辅助处理区域

        private void setOtherUserRender(bool enble)
        {
            if (this.recheck_name != null)
            {
                this.recheck_name.Enabled = enble;
            }
            if (this.pat_name != null)
            {
                this.pat_name.Enabled = enble;
            }
            if (this.rh_pat_name != null)
            {
                this.rh_pat_name.Enabled = enble;
            }
            if (this.des != null)
            {
                this.des.Enabled = enble;
            }
            if (this.dt_recheck != null)
            {
                this.dt_recheck.Enabled = enble;
            }
        }

        private DataPolicy SetEditable(bool editable)
        {
            DataPolicy dpMain = new DataPolicy()
            {
                ClassName = typeof(CiOrdBtTestDO).ToString(),
                InlineEdit = true,
                FullEdit = true,
                AllowEdit = true
            };
            return dpMain;            
        }

        private DataPolicy SetItemEditable(bool editable)
        {
            DataPolicy dp = new DataPolicy()
            {
                ClassName = typeof(CiOrdBtTestItmDO).ToString(),
                FullEdit = editable,
                AllowRemove = editable,
                AllowEdit = editable,
                AllowNew = editable
            };
            return dp;
        }  
        #endregion

        #region 状态处理区域
        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case UIEvent.SAVE:
                    this.OnSave();
                    break;
                case UIEvent.SUBMIT:
                    this.OnSubmit();
                    break;
            }
        }
        #endregion
    }
}
