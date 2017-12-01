using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.ciorder.utils {
    /// <summary>
    /// 医嘱部分的系统级别参数类
    /// author:?
    /// </summary>
    public class OrdParam {

        #region singleton
        static OrdParam _instance;
        public OrdParam() {

        }

        public static OrdParam GetOrdParam {
            get {
                if (_instance == null) {
                    _instance = new OrdParam();
                }
                return _instance;
            }
        } 
        #endregion

        public const string MESSAGE_TIEMCHECK = "结束时间不能在开始时间之前！";

        /// <summary>
        /// 社会医保号
        /// </summary>
        public string id_hp = "";
        /// <summary>
        /// 临时备用医嘱有效时间
        /// </summary>
        //public int backOrActiveTime = 24;
        /// <summary>
        /// 医生是否可以修改备用医嘱有效时间
        /// </summary>
        public bool doctorEditBackOrTime = true;
        /// <summary>
        /// 医嘱开始时刻
        /// </summary>
        public string orStartTime = "08:50";
        /// <summary>
        /// 医嘱可以提前录入的最大天数
        /// </summary>
        public int orBeforStartDays = 5;
        /// <summary>
        /// 开始时间大于入院时间的限定时间(天)
        /// </summary>
        public int limitedHour = 3;
        /// <summary>
        /// 临时备用医嘱有效时间（小时）
        /// </summary>
        public int sparetime = 12;
        /// <summary>
        /// 当前医嘱是否为住院医嘱,true是住院
        /// </summary>
        private bool _isHos = true;
        public bool isHos{
            set{
                this._isHos = value;
            }
            get {
                return this._isHos;
            }
        }

    }
}
