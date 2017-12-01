using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciorder.ems;

namespace iih.ci.ord.ciorder._ems.trans {
    /// <summary>
    /// 转科医疗单的具体工厂类
    /// 
    /// author:zhou_zhijian li_zheng
    /// </summary>
    public class TransEmsFactory : EmsFactoryBase {
        /// <summary>
        /// 
        /// </summary>
        private TransEmsView view;
        /// <summary>
        /// 
        /// </summary>
        private TransEmsModel model;
      

        public TransEmsFactory() {
            view = new TransEmsView();
            model = new TransEmsModel();
            view.Model = model;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <returns></returns>
        public override EmsViewBase GetView() {
            return this.view;
        }


        /// <summary>
        /// 
        /// </summary>
        /// <returns></returns>
        public override EmsModelBase GetModel() {
            return this.model;
        }



       
    }
}
