using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.iih.ci.ord.ciordems.d
{
    /// <summary>
    /// 医疗安中公共字段
    /// </summary>
   public class OrCommonFieldsDTO : BaseDTO
    {
        /// <summary>
        /// 总次数
        /// </summary>
        public int? Times_cur
        {
            get { return getAttrVal<int?>("Times_cur", null); }
            set { setAttrVal<int?>("Times_cur", value); }
        }
        /// <summary>
        /// 医嘱天数
        /// </summary>
        public int? Use_days
        {
            get { return getAttrVal<int?>("Use_days", null); }
            set { setAttrVal<int?>("Use_days", value); }
        }
        /// <summary>
        /// 开始日期
        /// </summary>
        public DateTime? Dt_begin_ui
        {
            get { return getAttrVal<FDateTime>("Dt_begin_ui", null); }
            set { setAttrVal<FDateTime>("Dt_begin_ui", value); }
        }

        /// <summary>
        /// 结束日期
        /// </summary>
        public DateTime? Dt_end_ui
        {
            get { return getAttrVal<FDateTime>("Dt_end_ui", null); }
            set { setAttrVal<FDateTime>("Dt_end_ui", value); }
        }
        /// <summary>
        /// 在院执行次数
        /// </summary>
        public int? Times_mp_in
        {
            get { return getAttrVal<int?>("Times_mp_in", null); }
            set { setAttrVal<int?>("Times_mp_in", value); }
        }
        /// <summary>
        /// 标准价
        /// </summary>
        public FDouble Pri_std
        {
            get { return getAttrVal<FDouble>("Pri_std", null); }
            set { setAttrVal<FDouble>("Pri_std", value); }
        }

        /// <summary>
        /// 价格系数
        /// </summary>
        public FDouble Pri_ratio
        {
            get { return getAttrVal<FDouble>("Pri_ratio", null); }
            set { setAttrVal<FDouble>("Pri_ratio", value); }
        }

        /// <summary>
        /// 患者价格分类
        /// </summary>
        public string Id_pripat
        {
            get { return getAttrVal<string>("Id_pripat", null); }
            set { setAttrVal<string>("Id_pripat", value); }
        }
       /// <summary>
       /// 申请单号
       /// </summary>
        public string Applyno
        {
            get { return getAttrVal<string>("Applyno", null); }
            set { setAttrVal<string>("Applyno", value); }
        }
       /// <summary>
       /// 医疗单URL
       /// </summary>
        public string Funcclassstr
        {
            get { return getAttrVal<string>("Funcclassstr", null); }
            set { setAttrVal<string>("Funcclassstr", value); }
        }
       /// <summary>
       /// 医疗单id
       /// </summary>
        public string Id_srvof
        {
            get { return getAttrVal<string>("Id_srvof", null); }
            set { setAttrVal<string>("Id_srvof", value); }
        }
       /// <summary>
       /// 医嘱来源方式类型
       /// </summary>
        public string Eu_orsrcmdtp
        {
            get { return getAttrVal<string>("Eu_orsrcmdtp", null); }
            set { setAttrVal<string>("Eu_orsrcmdtp", value); }
        }
       /// <summary>
       /// 简化的流程标识
       /// </summary>
        public bool? Fg_quickwflow
        {
            get { return getAttrVal<bool?>("Fg_quickwflow", null); }
            set { setAttrVal<bool?>("Fg_quickwflow", value); }
        }
    }
}
