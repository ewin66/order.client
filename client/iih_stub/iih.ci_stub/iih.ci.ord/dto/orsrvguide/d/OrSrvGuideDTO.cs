using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.orsrvguide.d
{
    /// <summary>
    /// OrSrvGuideDTO 的摘要说明。
    /// </summary>
    public class OrSrvGuideDTO : BaseDTO
    {

        public OrSrvGuideDTO()
        {

        }

        /// <summary>
        /// 医嘱主键
        /// </summary>
        public string Id_or
        {
            get { return getAttrVal<string>("Id_or", null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 医嘱服务主键
        /// </summary>
        public string Id_orsrv
        {
            get { return getAttrVal<string>("Id_orsrv", null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }

        /// <summary>
        /// 服务项目
        /// </summary>
        public string Id_srv
        {
            get { return getAttrVal<string>("Id_srv", null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 剂型编码
        /// </summary>
        public string Dosecode
        {
            get { return getAttrVal<string>("Dosecode", null); }
            set { setAttrVal<string>("Dosecode", value); }
        }

        /// <summary>
        /// 医保计划下剂型编码
        /// </summary>
        public string Dosecode_hp
        {
            get { return getAttrVal<string>("Dosecode_hp", null); }
            set { setAttrVal<string>("Dosecode_hp", value); }
        }

        /// <summary>
        /// 医保计划下剂型名称
        /// </summary>
        public string Dosename_hp
        {
            get { return getAttrVal<string>("Dosename_hp", null); }
            set { setAttrVal<string>("Dosename_hp", value); }
        }

        /// <summary>
        /// 用药频次编码
        /// </summary>
        public string Freqcode
        {
            get { return getAttrVal<string>("Freqcode", null); }
            set { setAttrVal<string>("Freqcode", value); }
        }

        /// <summary>
        /// 医保计划下用药频次编码
        /// </summary>
        public string Freqcode_hp
        {
            get { return getAttrVal<string>("Freqcode_hp", null); }
            set { setAttrVal<string>("Freqcode_hp", value); }
        }

        /// <summary>
        /// 单次用量
        /// </summary>
        public string Dosage
        {
            get { return getAttrVal<string>("Dosage", null); }
            set { setAttrVal<string>("Dosage", value); }
        }

        /// <summary>
        /// 用药天数
        /// </summary>
        public string Days
        {
            get { return getAttrVal<string>("Days", null); }
            set { setAttrVal<string>("Days", value); }
        }

        /// <summary>
        /// 医保计划下频次名称
        /// </summary>
        public string Freqname_hp
        {
            get { return getAttrVal<string>("Freqname_hp", null); }
            set { setAttrVal<string>("Freqname_hp", value); }
        }

        /// <summary>
        /// 药品批准文号
        /// </summary>
        public string Drugapprovalnumber
        {
            get { return getAttrVal<string>("Drugapprovalnumber", null); }
            set { setAttrVal<string>("Drugapprovalnumber", value); }
        }

        /// <summary>
        /// 医疗单位主键
        /// </summary>
        public string Id_medu
        {
            get { return getAttrVal<string>("Id_medu", null); }
            set { setAttrVal<string>("Id_medu", value); }
        }

        /// <summary>
        /// 医疗单位名称
        /// </summary>
        public string Name_medu
        {
            get { return getAttrVal<string>("Name_medu", null); }
            set { setAttrVal<string>("Name_medu", value); }
        }

        /// <summary>
        /// 持有量天数
        /// </summary>
        public string Days_available
        {
            get { return getAttrVal<string>("Days_available", null); }
            set { setAttrVal<string>("Days_available", value); }
        }

        /// <summary>
        /// 药品类型
        /// </summary>
        public string Sd_mmtp
        {
            get { return getAttrVal<string>("Sd_mmtp", null); }
            set { setAttrVal<string>("Sd_mmtp", value); }
        }

        /// <summary>
        /// 医基换算系数
        /// </summary>
        public FDouble Factor_mb
        {
            get { return getAttrVal<FDouble>("Factor_mb", null); }
            set { setAttrVal<FDouble>("Factor_mb", value); }
        }

        /// <summary>
        /// 零基换算系数
        /// </summary>
        public FDouble Factor_sb
        {
            get { return getAttrVal<FDouble>("Factor_sb", null); }
            set { setAttrVal<FDouble>("Factor_sb", value); }
        }

        /// <summary>
        /// 门诊取整模式
        /// </summary>
        public string Sd_opmutp
        {
            get { return getAttrVal<string>("Sd_opmutp", null); }
            set { setAttrVal<string>("Sd_opmutp", value); }
        }

        /// <summary>
        /// 换算率
        /// </summary>
        public FDouble Factor
        {
            get { return getAttrVal<FDouble>("Factor", null); }
            set { setAttrVal<FDouble>("Factor", value); }
        }

        /// <summary>
        /// 频次周期下次数
        /// </summary>
        public int? Freqct
        {
            get { return getAttrVal<int?>("Freqct", null); }
            set { setAttrVal<int?>("Freqct", value); }
        }

        /// <summary>
        /// 服务总量
        /// </summary>
        public FDouble Quan_total_medu
        {
            get { return getAttrVal<FDouble>("Quan_total_medu", null); }
            set { setAttrVal<FDouble>("Quan_total_medu", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Id_or", "Id_orsrv", "Id_srv", "Dosecode", "Dosecode_hp", "Dosename_hp", "Freqcode", "Freqcode_hp", "Dosage", "Days", "Freqname_hp", "Drugapprovalnumber", "Id_medu", "Name_medu", "Days_available", "Sd_mmtp", "Factor_mb", "Factor_sb", "Sd_opmutp", "Factor", "Freqct", "Quan_total_medu" };
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.orsrvguide.d.OrSrvGuideDTO";
        }
    }
}
