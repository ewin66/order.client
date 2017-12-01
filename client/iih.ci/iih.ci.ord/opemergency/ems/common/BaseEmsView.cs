using System;
using System.Collections.Generic;
using System.Linq;
using xap.cli.sdk.controls;
using xap.rui.control.forms.view;
using xap.rui.control.basecontrol;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ems.d;
using iih.ci.ord.opemergency.validate;
using iih.ci.ord.ciorder.utils;
using xap.rui.control.forms.model;
using xap.rui.engine;
using iih.bd.srv.medsrv.d;
using iih.ci.ord.opemergency.ems.dp;
using System.Drawing;
using iih.ci.iih.ci.ord.ems.d;
using xap.rui.control.forms.control;
using xap.cli.sdk.controls.DataView;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.opemergency.view;
using xap.rui.control.formcontrol.model;
using xap.cli.sdk.render;
using xap.rui.control.extentions;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.dto.d;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.view.basic;
using iih.ci.ord.opemergency.declare;

namespace iih.ci.ord.opemergency.ems.common
{
    /// <summary>
    /// <para>描    述 : 医疗单模型数据处理基类         </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.view    </para>    
    /// <para>类 名 称 : BaseSrvItemView                </para> 
    /// <para>版 本 号 : v1.0.0.0                       </para> 
    /// <para>作    者 : qzwang                         </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05             </para>
    /// <para>修 改 人 :                                </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05             </para> 
    /// <para>说    明 :                                </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class BaseEmsView : BaseFormBizView
    {
        #region 静态属性
        public static bool EmptyPatDIInfo = true;
        /// <summary>
        /// 每个医疗单中的全局变量，用于存储banner信息和医保的相关信息
        /// </summary>
        public static Dictionary<string, object> BaseEmsInfoContext = new Dictionary<string, object>();
        
        #endregion

        #region 保护类型变量

        /// <summary>
        /// 不同模型数据转化工具类对象
        /// </summary>
        protected OrDataConvert orDataConvert = new OrDataConvert();

        /// <summary>
        /// 医嘱医疗单有效性检查对象，这个需要在子类中赋值
        /// </summary>
        protected IEmsValidate iValidate;

        /// <summary>
        /// 申请单类型
        /// </summary>
        protected EmsViewType srvItemViewType;

        /// <summary>
        /// 申请单模型
        /// </summary>
        private BaseEmsViewModel model;


        private bool hasEmptyPatDi = true;


        private String gridTableCode;

        private XapFormGridControl gridTableControl;

        #endregion

        #region 公有方法接口
        public virtual BaseEmsViewModel GetViewModel()
        {
            return this.model;
        }

        public virtual void SetViewModel(BaseEmsViewModel m)
        {
            this.model = m;
        }
        // 获取当前医疗单视图类型
        public virtual EmsViewType GetEmsViewType()
        {
            return this.srvItemViewType;
        }
        public virtual void SetEmsViewType(EmsViewType tpy)
        {
            this.srvItemViewType = tpy;
        }
       

        /// <summary>
        /// 获取医嘱对象转换工具 UI->CI
        /// </summary>
        /// <returns></returns>
        public OrDataConvert GetOrDataConvert()
        {
            return this.orDataConvert;
        }

        #endregion

        #region 代理定义
        public delegate bool funDelegateEnterKeyOver(Object o);

        private funDelegateEnterKeyOver delegate_OnEnterKeyOver;
        #endregion

        #region 键盘工具方法
        [System.Runtime.InteropServices.DllImport("user32.dll")]
        public static extern short GetKeyState(int keyCode);
        const int VK_SHIFT = 0x10;
        const int VK_CONTROL = 0x11;
        const int VK_ALT = 0x12;
        public bool IsControlKeyDown 
        { 
            get
            {
                return IsCombKeyDow(VK_CONTROL);
            }
        }
        public bool IsShiftKeyDown
        {
            get
            {
                return IsCombKeyDow(VK_SHIFT);
            }
        }
        public bool IsAltKeyDown
        {
            get
            {
                return IsCombKeyDow(VK_ALT);
            }
        }
        public bool IsCombKeyDow(int vk)
        {
            return 0 != (GetKeyState(vk) & 0x8000);
        }
        #endregion

        #region 构造函数

        public BaseEmsView()
        {
            this.Name = "医疗单";
        }

        public BaseEmsView(IEventDelegate owner)
            : base(owner)
        {
            this.Name = "医疗单";

        }

        #endregion

        #region 覆盖方法

        public virtual CiOrderDO Save()
        {
            // 保存前映射数据以及有效性检查（由于表格部件为公用，所以医疗单的的选项卡检查数据有效性即可）
            // 判断检查列表中是否含有错误信息
            if (this.OrdValivate())
            {
                return this.GetViewModel().Save2Order();
            }
            else
            {
                this.ShowInfo(" 医疗单有效性验证失败，请检查错误！\n" + this.ErrorDescroption(), "提示:");
            }
            return null;
        }

        /// <summary>
        /// 新的保存返回医嘱集合
        /// </summary>
        /// <returns></returns>
        public virtual CiOrderTransMissionDTO SaveNew()
        {
            // 保存前映射数据以及有效性检查（由于表格部件为公用，所以医疗单的的选项卡检查数据有效性即可）
            // 判断检查列表中是否含有错误信息
            if (this.OrdValivate())
            {
                return this.GetViewModel().SaveNew();
            }
            else
            {
                this.ShowInfo(" 医疗单有效性验证失败，请检查错误！\n" + this.ErrorDescroption(), "提示:");
            }
            return null;
        }




        /// <summary>
        /// 
        /// </summary>
        /// <returns></returns>
        public virtual CiOrderDO againSave()
        {
            // 保存前映射数据以及有效性检查（由于表格部件为公用，所以医疗单的的选项卡检查数据有效性即可）
            // 判断检查列表中是否含有错误信息
            if (this.OrdValivate())
            {
                return this.GetViewModel().Save2Order();
            }
            else
            {
                this.ShowInfo(" 医疗单有效性验证失败，请检查错误！\n" + this.ErrorDescroption(), "提示:");
            }
            return null;
        }


        /// <summary>
        /// 获取费用项目备注信息
        /// </summary>
        /// <param name="ciord"></param>
        /// <returns></returns>
        public virtual List<string> getBlSrvDesList(CiOrderDO ciord)
        {
            return this.model.getBlSrvDesListAftSave(ciord);
        }
        /// <summary>
        /// 
        /// </summary>
        /// <param name="id_or"></param>
        /// <param name="ctx"></param>
        /// <returns></returns>
        public MedicalSharingDTO[] getRepeatMessageOrder(String id_or,CiEnContextDTO ctx)
        {
           return  this.model.getRepeatMessageOrder(id_or, ctx);
        }

        public virtual CiEmsDTO Save2CiEmsDTO(bool forceUpdate)
        {
            this.UnRegFormEvent_DataChanged();
            CiEmsDTO dto = model.Save2CiEmsDTO(forceUpdate);
            this.RegFormEvent_DataChanged();
            return dto;
        }

        /// <summary>
        /// 调整列信息
        /// </summary>
        protected virtual void ResetColumnsInfo(XapFormGridControl gv)
        {
            // 统计备用的宽度总和
            int nUsedWidth = 0;

            string[] hiddenColumns = null;
            string[] readonlyColumns = null;
            string[] fixedColumns = null;

            if (this.model != null)
            {
                hiddenColumns = this.model.GetHiddenFields();
                readonlyColumns = this.model.GetReadonlyFields();
                fixedColumns = this.model.GetFixedFields();
            }
            else
            { // 模型为空时候的隐藏默认值
                hiddenColumns = new string[] { "Fg_skintest", "Fg_urgent", "Name_samptp", "Name_di" };
                fixedColumns = new BaseBizViewModel(null).GetFixedFields();
            }

            var unFixedColumnList = new List<XDataColumn>();

            // 处理过程
            foreach (XDataColumn column in gv.DataTable.Columns)
            {
                // 处理隐藏列
                column.Visible = !(hiddenColumns != null && hiddenColumns.Contains(column.FieldName));

                // 不处理隐藏列
                if (!column.Visible) {
                   
                    continue;
                }
                    

                // 只读设置
                column.ReadOnly = readonlyColumns == null || readonlyColumns.Contains(column.FieldName);

                //if (column.ReadOnly) {
                //    column.BackColor = Color.FromArgb(179, 179, 179);
                //}

                // 固定列
                if (fixedColumns.Contains(column.FieldName))
                {
                    nUsedWidth += column.Width + 1;
                }
                else
                {
                    unFixedColumnList.Add(column);
                }
            }

            gv.DataTable.Columns[0].ReadOnly &= readonlyColumns != null;
            if (nUsedWidth != 0 && unFixedColumnList.Count!=0)
            {
                int w = (this.GetXapFormControl().Size.Width - nUsedWidth - unFixedColumnList.Count*2 - 2) / unFixedColumnList.Count;
                foreach (XDataColumn column in unFixedColumnList)
                {
                    column.Width = w - 1;
                }
            }

        }


        protected override void OnFillData()
        {

            var file = new FormFile();
            file.FormId = this.GetFormId();
            file.FormStyle = FormStyle.Card;
            if (this.GetViewModel() != null)
            {
                file.ViewModel = this.GetViewModel().GetFormDataSource();
            }
            this.GetXapFormControl().ViewFile = file;

            //this.SetDataPolicy(this.allowEdit);

            this.GetXapFormControl().SetFormModified(this.GetEmsViewType() != EmsViewType.EmptyEmsViewType && this.GetViewModel().IsNewStatus());
        }


        public override BaseFormBizView ClearContext()
        {
            if (this.model != null)
                this.model.ClearTableDataSource();

            return base.ClearContext();
        }


        #endregion

        #region 有效性验证接口

        /// <summary>
        /// 表单的有效性检查
        /// </summary>
        /// <returns></returns>
        public virtual bool OrdValivate()
        {
            if (null != iValidate)
            {
                return iValidate.OrdValivate(this.GetViewModel(), this);
            }
            this.OrdErrorList.Add("没有设置有效性检查器");
            return false;
        }

        public void SetEmsValidate(IEmsValidate v)
        {
            this.iValidate = v;
        }
        public IEmsValidate GetEmsValidate()
        {
            return this.iValidate;
        }
        #endregion

        #region 公有接口

        public void SetGridPageCode(String s)
        {
            this.gridTableCode = s;
        }

        public String GetGridPageCode()
        {
            return this.gridTableCode;
        }

        public XapFormGridControl GetGridControl()
        {
            return this.gridTableControl;
        }
       
        public void SetEmptyPatDi(bool b)
        {
            this.hasEmptyPatDi = b;
        }

        public bool HasEmptyPatDi()
        {
            return this.hasEmptyPatDi;
        }

        public virtual BaseFormBizView AddRow(object param = null)
        {
            if (!this.Created || this.IsLoading) return this;

            if (this.GetViewModel() != null)
            {
                this.GetViewModel().AddNew();
                this.SentNotify(EventCodeType.NM_EMS_ORSRV_SELECTCHANGED);
            }
            return this;
        }

        public virtual BaseFormBizView DeleteRow(object param = null)
        {
            if (null == this.GetViewModel()) {
                this.ShowInfo("数据模型为空!");
                return this;
            }
            else if (null == this.GetViewModel().GetSelectedObject()) {
                this.ShowInfo("选中列表中的项目后再删除！");
                return this;
            }

            this.GetViewModel().DeleteItemData(this.GetViewModel().GetSelectedObject());

           
            this.SentNotify(EventCodeType.NM_EMS_ORSRV_SELECTCHANGED);
            
            return this;
        }

        public bool RegEnterKeyOverEvent(funDelegateEnterKeyOver f)
        {
            this.delegate_OnEnterKeyOver = f;

            if (this.GetXapFormControl() != null) {
                GetXapFormControl().EnterKeyDown += OnXapFormControl_EnterKeyDown;
            }
            return this.GetXapFormControl() != null;
        }
        #endregion

        #region  表单事件继承处理

        protected virtual bool OnGridEnterKeyOver(XDataRow row)
        {
            if (this.delegate_OnEnterKeyOver != null) {
                return delegate_OnEnterKeyOver(row);
            }
            return false;
        }

        protected virtual void OnXapFormControl_EnterKeyDown(object sender, System.Windows.Forms.KeyEventArgs e)
        {
            XDataRow row = sender as XDataRow;


            if (row.ClickCell != null && row.CellList != null && row.ClickCell.FieldName.Equals(row.CellList[row.ColumnCellDict.Count - 1].FieldName)) {

                e.Handled = OnGridEnterKeyOver(row);

            }
        }

        protected override void OnXapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.OnXapFormControl_FormCreated(sender, e);

            if (null != this.GetGridPageCode())
            {
                this.gridTableControl = (sender as XapFormControl).GetGridView(this.GetGridPageCode());
            }

            if (this.gridTableControl != null) {
                this.gridTableControl.DataTable.LayoutChanged += OnXapFormGridControl_LayoutChanged;
            }

        }


        protected virtual void OnXapFormGridControl_LayoutChanged(object sender, EventArgs e)
        {
            AdjustLayout();
        }

        public virtual Size GetFixedSize()
        {
            if (this.gridTableControl != null)
            {
                int height = gridTableControl.DataTable.Size.Height + (gridTableControl.HScroll.Visible ? 14 : 0);
                return new System.Drawing.Size(this.Size.Width, height);
            }
            return new Size(0,0);

        }
        public virtual void Cell_MouseClick(object sender)
        { 
        
        }
        public override BaseFormBizView AdjustLayout()
        {
            this.GetXapFormControl().SetToilHeight(this.Size.Height - GetFixedSize().Height - TABLE_HEIGHT_OFFSET);

            return this;
        }
        #endregion

        public virtual CiOrderDO AgainSaveOrder()
        {
            return this.GetViewModel().AgainSaveOrder();
        }
    }
}
