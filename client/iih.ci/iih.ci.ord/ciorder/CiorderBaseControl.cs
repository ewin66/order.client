using System.Windows.Forms;
using iih.ci.ord.ciordems.d;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using xap.rui.control.basecontrol;
using iih.ci.ord.ems.d;
using iih.bd.srv.medsrv.d;
using System;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.oporder.view;
using System.Collections.Generic;
using iih.ci.ord.ciorder.Validate;
using System.ComponentModel.DataAnnotations;
using xap.rui.appfw;
using xap.sys.xbd.measdoc.d;
using iih.ci.ord.ciorder.cards.thread.dp;
using xap.rui.control.forms.view;
using xap.cli.sdk.controls.DataView;
using xap.rui.control.extentions;
/* 文件头注释
* ==============================================================================
* Filename: PaintToolKit
* Date: 2016/1/29 13:19:37
* Compiler: Visual Studio 2010
* Author: 苏君
* Company: Copyright 2015 by PKU healthcare IT Co.,Ltd.
* Description: 
* ==============================================================================
*/

namespace iih.ci.ord.ciorder {

    /// <summary>
    /// 医嘱部分各种视图的基类 
    /// zhou_zhijian 7.3做阅读注释
    /// </summary>
    public class CiorderBaseControl : XapListControl {
        #region 代理定义
        public delegate bool funDelegateEnterKeyOver(Object o);

        private funDelegateEnterKeyOver delegate_OnEnterKeyOver;
        #endregion

        #region 成员变量
        /// <summary>
        /// 
        /// </summary>
        [Display(Name = "算法，接口调用集合", Description = "各种算法的汇集")]
        public LogicEx cof = LogicEx.GetInstance();

        /// <summary>
        /// 
        /// </summary>
        [Display(Name = "验证通过标识")]
        public bool VerifyOk = true;

        /// <summary>
        /// 错误列表
        /// </summary>
        [Display(Name = "表单验证错误消息列表", Description = "表单验证的各种错误集合")]
        public List<string> OrdErrorList { get; set; }

        /// <summary>
        /// 
        /// </summary>
        public bool fg_save { get; set; }

        /// <summary>
        /// 
        /// </summary>
        public EmsType Type { get; set; }

        /// <summary>
        ///医嘱单名称
        /// </summary>
        [Required(ErrorMessage = "医疗单名称未设置！")]
        public string SheetName { get; set; }

        /// <summary>
        /// 医嘱单描述
        /// </summary>
        public string SheetDes { get; set; }

        /// <summary>
        /// 
        /// </summary>
        public bool IsReadOnly { get; set; }

        //用于缓存剂量单位
        public Dictionary<string, string> cacheUnitMed = new Dictionary<string, string>();
        /// <summary>
        /// 线程处理物品库存量的中间件
        /// </summary>
        public MiddleWareXapDataList middle = new MiddleWareXapDataList();

        public CiorderBaseControl _parent;

        protected List<CiEmsSrvDTO> feelCiEmsSrvs = new List<CiEmsSrvDTO>();
        #endregion

        #region 构造
        public CiorderBaseControl() {
            Dock = DockStyle.Fill;
            OrdErrorList = new List<string>();
            IsReadOnly = false;
        } 
        #endregion

        [Display(Name = "表单数据的输入", Description = "每个表单必须重写此方法，获取外界传入的数据")]
        public virtual void OnRefreshData(EmsUIDTO ems, object e) {
            EmsHeadDO = ems;
            CiEmsDTO = e as CiEmsDTO;
            if (Created)
                LoadData();

        }
        /// <summary>
        /// 公用的界面数据集合
        /// </summary>
        public EmsUIDTO EmsHeadDO {
            get;
            set;
        }

        /// <summary>
        /// 多医疗使用的传输dto（非多医疗单勿用）
        /// </summary>
        public CiEmsDTO CiEmsDTO {
            get;
            set;
        }

        [Obsolete("即将废除，请及时修改")]
        public MedSrvDO MedSrvDO {

            get;
            set;
        }

        /// <summary>
        /// 当前选择了哪些医嘱的容器数据结构对象
        /// </summary>
        protected OrdSelectedContainer ordSelectedContainer;
        /// <summary>
        /// 医嘱的关键字
        /// </summary>
        protected string keyName = "Id_or";
        /// <summary>
        /// 保存前事件
        /// </summary>
        public virtual void SaveBefore() {

        }

        [Display(Name = "获取医疗单验证类", Description = "")]
        public virtual IValidate GetOrdValidate() {
            return null;
        }
        /// <summary>
        /// 自定义服务时，物品名称与项目名称同步
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        public void item_PropertyChanged(object sender, System.ComponentModel.PropertyChangedEventArgs e)
        {
            EmsOrDrug drug = sender as EmsOrDrug;
            string propertyName = e.PropertyName;
            if ("Name_srv".Equals(propertyName))
            {
                if (drug.Name_srv == "")
                {
                    drug.Name_mm = drug.Name_srv;
                }
                else
                {
                    drug.Name_mm = drug.Name_srv;
                }

            }
        }
        /// <summary>
        /// 自定义服务时，为EmsOrDrug绑定属性changed事件和缓存自定义服务的剂量单位
        /// </summary>
        /// <param name="emsordruglist"></param>
        public void drugBindPropertyEventAndCacheUnimed(XapDataList<EmsOrDrug> emsordruglist)
        {
            foreach (EmsOrDrug item in emsordruglist)
            {
                if (true == item.Fg_ctm)
                {
                    item.PropertyChanged += new System.ComponentModel.PropertyChangedEventHandler(item_PropertyChanged);
                }
                if (!cacheUnitMed.ContainsKey(item.Id_unit_med))
                {
                    cacheUnitMed.Add(item.Id_unit_med, item.Name_unit_med);
                }
            }
        }
        /// <summary>
        /// 参照回写是自定义服务时的操作
        /// </summary>
        /// <param name="drugNew"></param>
        public void handleRefResultSrvIsFtmSrv(EmsOrDrug drugNew)
        {
            drugNew.Fg_mm = false;
            drugNew.Fg_ctm = true;
            drugNew.Fg_self = true;
            drugNew.Spec_mm = "";
            if (drugNew.Id_unit_med != null)
            {
                if (cacheUnitMed.ContainsKey(drugNew.Id_unit_med))
                {
                    drugNew.Name_unit_med = cacheUnitMed[drugNew.Id_unit_med];
                }
                else
                {
                    MeasDocDO meas = cof.getMeasDocDoById(drugNew.Id_unit_med);
                    if (meas != null)
                    {
                        drugNew.Name_unit_med = meas.Name;
                    }
                    cacheUnitMed.Add(drugNew.Id_unit_med, drugNew.Name_unit_med);
                }
            }
            cof.concateExtNote(new XapDataList<EmsOrDrug> { drugNew }, EmsHeadDO.PatInfo, EmsHeadDO);
            drugNew.PropertyChanged += new System.ComponentModel.PropertyChangedEventHandler(item_PropertyChanged);
        }
        public void setFeelCiEmsSrvs(List<CiEmsSrvDTO> list)
        {
            this.feelCiEmsSrvs = list;
        }
        /// <summary>
        /// 设置结束时间和停止标志
        /// </summary>
        protected void setEndTime()
        {
            //设置结束时间和停止标志
            if (EmsHeadDO.Emsdrugs.Use_days != null && EmsHeadDO.Emsdrugs.Use_days > 0 && EmsHeadDO.Emsdrugs.Dt_begin_ui != null)
            {
                try {
                    EmsHeadDO.Emsdrugs.Dt_end_ui = ((DateTime)EmsHeadDO.Emsdrugs.Dt_begin_ui).AddDays(Convert.ToDouble(EmsHeadDO.Emsdrugs.Use_days));
                }catch(Exception ex){
                    this.ShowMessage(ex.Message);
                }
                    
            }
        }
        #region 接口

        /// <summary>
        /// 获取表单容器对象
        /// </summary>
        /// <returns></returns>
        public virtual XapFormControl GetXapFormControl()
        {
            throw new NotImplementedException();
        }
        public List<CiEmsSrvDTO> getFeelCiEmsSrvs() {
            return this.feelCiEmsSrvs;
        }
        public bool RegEnterKeyOverEvent(funDelegateEnterKeyOver f, String[] szFields = null)
        {
            this.delegate_OnEnterKeyOver = f;

            if (this.GetXapFormControl() != null) {
                GetXapFormControl().EnterKeyDown += OnXapFormControl_EnterKeyDown;
            }
            return this.GetXapFormControl() != null;
        }

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

            if (row != null && row.ClickCell.FieldName.Equals(row.CellList[row.ColumnCellDict.Count - 1].FieldName)) {

                e.Handled = OnGridEnterKeyOver(row);

            }
        }
        #endregion
    }
}
