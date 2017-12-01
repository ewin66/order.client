using System;
using System.Collections.Generic;
using iih.bd.srv.cherbboilmd.d;
using iih.bd.srv.freqdef.d;
using iih.bd.srv.medusage.d;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.sys.xbd.measdoc.d;

namespace iih.ci.ord.dto.newordertemplatedto.d
{
    /// <summary>
    /// NewOrderTemplateDTO 的摘要说明。
    /// </summary>
    public class NewOrderTemplateDTO : BaseDTO {

        public NewOrderTemplateDTO() {
 
        }

		      /// <summary>
        ///  频次集合
        /// </summary>
        public Dictionary<Object, string> getFreqdefdo()
        {
            Dictionary<Object, string> frequcdic = new Dictionary<Object, string>();
            FArrayList freqdefList = (FArrayList)Freqdefdo["FreqDefDO"];
            foreach (FreqDefDO freqcdo in freqdefList)
            {
                frequcdic.Add(freqcdo.Id_freq, freqcdo.Name);
            }
            return frequcdic;

        }

        /// <summary>
        /// 剂量单位
        /// </summary>
        /// <returns></returns>
        public Dictionary<Object, string> getmeasList()
        {
            Dictionary<Object, string> measdic = new Dictionary<Object, string>();
            FArrayList measList = (FArrayList)Measdocdo["MeasDocDO"];
            foreach (MeasDocDO MeasDocdo in measList)
            {
                measdic.Add(MeasDocdo.Id_measdoc, MeasDocdo.Name);
            }
            return measdic;
        }
        /// <summary>
        /// 用法集合
        /// </summary>
        /// <returns></returns>
        public Dictionary<Object, string> getrouteList()
        {
            Dictionary<Object, string> measdic = new Dictionary<Object, string>();
            FArrayList measList = (FArrayList)Routedo["MedUsageDO"];
            foreach (MedUsageDO MeasDocdo in measList)
            {
                measdic.Add(MeasDocdo.Id_route, MeasDocdo.Name);
            }
            return measdic;
        }
        /// <summary>
        /// 用法集合
        /// </summary>
        /// <returns></returns>
        public Dictionary<Object, string> getBoilList()
        {
            Dictionary<Object, string> measdic = new Dictionary<Object, string>();
            FArrayList measList = (FArrayList)Boildo["CHerbBoilMdDO"];
            foreach (CHerbBoilMdDO MeasDocdo in measList)
            {
                measdic.Add(MeasDocdo.Id_boil, MeasDocdo.Name);
            }
            return measdic;
        }
        /// <summary>
        /// 主键
        /// </summary>
		public string Id {
            get { return getAttrVal<string>("Id",null); }
            set { setAttrVal<string>("Id", value); }
        }

        /// <summary>
        /// 显示名称
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 频次
        /// </summary>
		public FMap Freqdefdo {
            get { return getAttrVal<FMap>("Freqdefdo",null); }
            set { setAttrVal<FMap>("Freqdefdo", value); }
        }

        /// <summary>
        /// 剂量单位
        /// </summary>
		public FMap Measdocdo {
            get { return getAttrVal<FMap>("Measdocdo",null); }
            set { setAttrVal<FMap>("Measdocdo", value); }
        }

        /// <summary>
        /// 模板项目
        /// </summary>
		public FMap Item {
            get { return getAttrVal<FMap>("Item",null); }
            set { setAttrVal<FMap>("Item", value); }
        }

        /// <summary>
        /// 模板明细集合
        /// </summary>
		public FArrayList Itemlist {
            get { return getAttrVal<FArrayList>("Itemlist",null); }
            set { setAttrVal<FArrayList>("Itemlist", value); }
        }

        /// <summary>
        /// 页面标志（Ui_flag  1 :套 ,  2:(多药品)药品, 3:(单一药品),  4 :其它）
        /// </summary>
		public string Ui_flag {
            get { return getAttrVal<string>("Ui_flag",null); }
            set { setAttrVal<string>("Ui_flag", value); }
        }

        /// <summary>
        /// 备用
        /// </summary>
		public string Str {
            get { return getAttrVal<string>("Str",null); }
            set { setAttrVal<string>("Str", value); }
        }

        /// <summary>
        /// 备用2
        /// </summary>
		public string Str2 {
            get { return getAttrVal<string>("Str2",null); }
            set { setAttrVal<string>("Str2", value); }
        }

        /// <summary>
        /// 备用3
        /// </summary>
		public string Str3 {
            get { return getAttrVal<string>("Str3",null); }
            set { setAttrVal<string>("Str3", value); }
        }

        /// <summary>
        /// 模板类型 Y 是草药，N其它
        /// </summary>
		public bool? Templatetype {
            get { return getAttrVal<FBoolean>("Templatetype",null); }
            set { setAttrVal<FBoolean>("Templatetype", value); }
        }

        /// <summary>
        /// 草药用法id
        /// </summary>
		public string Id_route {
            get { return getAttrVal<string>("Id_route",null); }
            set { setAttrVal<string>("Id_route", value); }
        }

        /// <summary>
        /// 草药用法名称
        /// </summary>
		public string Name_route {
            get { return getAttrVal<string>("Name_route",null); }
            set { setAttrVal<string>("Name_route", value); }
        }

        /// <summary>
        /// 草药频次
        /// </summary>
		public string Id_freq {
            get { return getAttrVal<string>("Id_freq",null); }
            set { setAttrVal<string>("Id_freq", value); }
        }

        /// <summary>
        /// 频次名称
        /// </summary>
		public string Name_freq {
            get { return getAttrVal<string>("Name_freq",null); }
            set { setAttrVal<string>("Name_freq", value); }
        }

        /// <summary>
        /// 煎法
        /// </summary>
		public string Id_boil {
            get { return getAttrVal<string>("Id_boil",null); }
            set { setAttrVal<string>("Id_boil", value); }
        }

        /// <summary>
        /// 煎法名称
        /// </summary>
		public string Name_boil {
            get { return getAttrVal<string>("Name_boil",null); }
            set { setAttrVal<string>("Name_boil", value); }
        }

        /// <summary>
        /// 煎法集合
        /// </summary>
		public FMap Boildo {
            get { return getAttrVal<FMap>("Boildo",null); }
            set { setAttrVal<FMap>("Boildo", value); }
        }

        /// <summary>
        /// 用法集合
        /// </summary>
		public FMap Routedo {
            get { return getAttrVal<FMap>("Routedo",null); }
            set { setAttrVal<FMap>("Routedo", value); }
        }

        /// <summary>
        /// 价格
        /// </summary>
		public FDouble Price {
            get { return getAttrVal<FDouble>("Price",null); }
            set { setAttrVal<FDouble>("Price", value); }
        }

        /// <summary>
        /// 执行科室名称
        /// </summary>
		public string Ortplnitm_mp_name {
            get { return getAttrVal<string>("Ortplnitm_mp_name",null); }
            set { setAttrVal<string>("Ortplnitm_mp_name", value); }
        }
        /// <summary>
        /// 服务是否被启用
        /// </summary>
        public bool? Fg_active
        {
            get { return getAttrVal<FBoolean>("Fg_active", null); }
            set { setAttrVal<FBoolean>("Fg_active", value); }
        }
        /// <summary>
        /// 停用的描述信息
        /// </summary>
        public string Description
        {
            get { return getAttrVal<string>("Description", null); }
            set { setAttrVal<string>("Description", value); }
        }
        /// <summary>
        /// 服务id
        /// </summary>
        public string Id_srv
        {
            get { return getAttrVal<string>("Id_srv", null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 物品id
        /// </summary>
        public string Id_mm
        {
            get { return getAttrVal<string>("Id_mm", null); }
            set { setAttrVal<string>("Id_mm", value); }
        }

        /// <summary>
        /// 用法要求id
        /// </summary>
        public string Id_routedes
        {
            get { return getAttrVal<string>("Id_routedes", null); }
            set { setAttrVal<string>("Id_routedes", value); }
        }

        /// <summary>
        /// 用法要求
        /// </summary>
        public string Name_routedes
        {
            get { return getAttrVal<string>("Name_routedes", null); }
            set { setAttrVal<string>("Name_routedes", value); }
        }

        /// <summary>
        /// 使用天数
        /// </summary>
        public int? Days_or
        {
            get { return getAttrVal<int?>("Days_or", null); }
            set { setAttrVal<int?>("Days_or", value); }
        }
        /// <summary>
        /// 服务类型编码
        /// </summary>
        public string Sd_srvtp
        {
            get { return getAttrVal<string>("Sd_srvtp", null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 物品标识
        /// </summary>
        public bool? Fg_mm
        {
            get { return getAttrVal<FBoolean>("Fg_mm", null); }
            set { setAttrVal<FBoolean>("Fg_mm", value); }
        }
        /// <summary>
        /// 是否被选中
        /// </summary>
        public bool? Fg_checked
        {
            get { return getAttrVal<FBoolean>("Fg_checked", null); }
            set { setAttrVal<FBoolean>("Fg_checked", value); }
        }
        /// <summary>
        /// 医保目录
        /// </summary>
        public string Name_hp
        {
            get { return getAttrVal<string>("Name_hp", null); }
            set { setAttrVal<string>("Name_hp", value); }
        }
        /// <summary>
        /// 草药剂数
        /// </summary>
        public int? Orders
        {
            get { return getAttrVal<int?>("Orders", null); }
            set { setAttrVal<int?>("Orders", value); }
        }
        /// <summary>
        /// 剂量
        /// </summary>
        public FDouble Quan_med
        {
            get { return getAttrVal<FDouble>("Quan_med", null); }
            set { setAttrVal<FDouble>("Quan_med", value); }
        }
        /// <summary>
        /// 剂量单位
        /// </summary>
        public string Ortplnitm_unit_name
        {
            get { return getAttrVal<string>("Ortplnitm_unit_name", null); }
            set { setAttrVal<string>("Ortplnitm_unit_name", value); }
        }
        public bool? Ismulexec
        {
            get { return getAttrVal<FBoolean>("Ismulexec", null); }
            set { setAttrVal<FBoolean>("Ismulexec", value); }
        }
        public bool? Ismuldose
        {
            get { return getAttrVal<FBoolean>("Ismuldose", null); }
            set { setAttrVal<FBoolean>("Ismuldose", value); }
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Id", "Name", "Freqdefdo", "Measdocdo", "Item", "Itemlist", "Ui_flag", "Str", "Str2", "Str3", "Templatetype", "Id_route", "Name_route", "Id_freq", "Name_freq", "Id_boil", "Name_boil", "Boildo", "Routedo", "Price", "Ortplnitm_mp_name", "Fg_active", "Description", "Id_srv", "Id_mm", "Id_routedes", "Name_routedes", "Days_or", "Sd_srvtp", "Fg_mm", "Fg_checked", "Orders", "Quan_med", "Ortplnitm_unit_name", "Ismulexec", "Ismuldose" };
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.newordertemplatedto.d.NewOrderTemplateDTO";
        }
    }
}
