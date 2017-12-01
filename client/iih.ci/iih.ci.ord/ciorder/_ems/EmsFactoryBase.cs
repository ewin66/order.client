using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.ems.d;
using iih.bd.srv.medsrv.d;
using iih.ci.ord.ciorder._ems;
using xap.rui.control.extentions;

namespace iih.ci.ord.ciorder.ems {
    /// <summary>
    /// 医疗单的抽象工厂的工厂基类;
    /// 同时，也起到医疗单领域的管理器作用
    /// author:zhou_zhijian
    /// </summary>
    public abstract class EmsFactoryBase {
        /// <summary>
        /// 医疗单的显示名字,即标题
        /// </summary>
        protected string sheetCaption;

        #region 构造
        public EmsFactoryBase() {
        } 
        #endregion

        public string SheetCaption {
            get { return sheetCaption; }
            set { sheetCaption = value; }
        }

        /// <summary>
        /// 获取本医疗单的视图对象
        /// </summary>
        /// <returns></returns>
        public abstract EmsViewBase GetView();

        /// <summary>
        /// 获取本医疗单的模型对象
        /// </summary>
        /// <returns></returns>
        public abstract EmsModelBase GetModel();


    }
}
