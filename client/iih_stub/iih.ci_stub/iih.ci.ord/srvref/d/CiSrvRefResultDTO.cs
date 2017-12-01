using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.srvref.d
{
    /// <summary>
    /// CiSrvRefResultDTO 的摘要说明。
    /// </summary>
    public class CiSrvRefResultDTO : BaseDTO {

        public CiSrvRefResultDTO() {
 
        }

        /// <summary>
        /// 服务主键
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 服务名称
        /// </summary>
		public string Srvname {
            get { return getAttrVal<string>("Srvname",null); }
            set { setAttrVal<string>("Srvname", value); }
        }

        /// <summary>
        /// 服务编码
        /// </summary>
		public string Srvcode {
            get { return getAttrVal<string>("Srvcode",null); }
            set { setAttrVal<string>("Srvcode", value); }
        }

        /// <summary>
        /// 服务分类
        /// </summary>
		public string Id_srvca {
            get { return getAttrVal<string>("Id_srvca",null); }
            set { setAttrVal<string>("Id_srvca", value); }
        }

        /// <summary>
        /// 服务分类名称
        /// </summary>
		public string Srvcaname {
            get { return getAttrVal<string>("Srvcaname",null); }
            set { setAttrVal<string>("Srvcaname", value); }
        }

        /// <summary>
        /// 服务类型
        /// </summary>
		public string Id_srvtp {
            get { return getAttrVal<string>("Id_srvtp",null); }
            set { setAttrVal<string>("Id_srvtp", value); }
        }

        /// <summary>
        /// 服务类型编码
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 服务类型名称
        /// </summary>
		public string Name_srvtp {
            get { return getAttrVal<string>("Name_srvtp",null); }
            set { setAttrVal<string>("Name_srvtp", value); }
        }

        /// <summary>
        /// 拼音码
        /// </summary>
		public string Pycode {
            get { return getAttrVal<string>("Pycode",null); }
            set { setAttrVal<string>("Pycode", value); }
        }

        /// <summary>
        /// 五笔码
        /// </summary>
		public string Wbcode {
            get { return getAttrVal<string>("Wbcode",null); }
            set { setAttrVal<string>("Wbcode", value); }
        }

        /// <summary>
        /// 助记码
        /// </summary>
		public string Mnecode {
            get { return getAttrVal<string>("Mnecode",null); }
            set { setAttrVal<string>("Mnecode", value); }
        }

        /// <summary>
        /// 简称
        /// </summary>
		public string Shortname {
            get { return getAttrVal<string>("Shortname",null); }
            set { setAttrVal<string>("Shortname", value); }
        }

        /// <summary>
        /// 套标识
        /// </summary>
		public bool? Fg_set {
            get { return getAttrVal<FBoolean>("Fg_set",null); }
            set { setAttrVal<FBoolean>("Fg_set", value); }
        }

        /// <summary>
        /// 服务备注信息
        /// </summary>
		public string Srvdes {
            get { return getAttrVal<string>("Srvdes",null); }
            set { setAttrVal<string>("Srvdes", value); }
        }

        /// <summary>
        /// 医保计划
        /// </summary>
		public string Id_hp {
            get { return getAttrVal<string>("Id_hp",null); }
            set { setAttrVal<string>("Id_hp", value); }
        }

        /// <summary>
        /// 医保计划名称
        /// </summary>
		public string Hpname {
            get { return getAttrVal<string>("Hpname",null); }
            set { setAttrVal<string>("Hpname", value); }
        }

        /// <summary>
        /// 医保计划目录类型
        /// </summary>
		public string Id_hpsrvtp {
            get { return getAttrVal<string>("Id_hpsrvtp",null); }
            set { setAttrVal<string>("Id_hpsrvtp", value); }
        }

        /// <summary>
        /// 医保计划目录类型编码
        /// </summary>
		public string Sd_hpsrvtp {
            get { return getAttrVal<string>("Sd_hpsrvtp",null); }
            set { setAttrVal<string>("Sd_hpsrvtp", value); }
        }

        /// <summary>
        /// 医保计划目录类型名称
        /// </summary>
		public string Name_hpsrvtp {
            get { return getAttrVal<string>("Name_hpsrvtp",null); }
            set { setAttrVal<string>("Name_hpsrvtp", value); }
        }

        /// <summary>
        /// 限制报销条件
        /// </summary>
		public string Limitreimbursecond {
            get { return getAttrVal<string>("Limitreimbursecond",null); }
            set { setAttrVal<string>("Limitreimbursecond", value); }
        }

        /// <summary>
        /// 报销比例
        /// </summary>
		public double? Reimburserate {
            get { return getAttrVal<FDouble>("Reimburserate",null); }
            set { setAttrVal<FDouble>("Reimburserate", value); }
        }

        /// <summary>
        /// 物品
        /// </summary>
		public string Id_mm {
            get { return getAttrVal<string>("Id_mm",null); }
            set { setAttrVal<string>("Id_mm", value); }
        }

        /// <summary>
        /// 物品名称
        /// </summary>
		public string Mmname {
            get { return getAttrVal<string>("Mmname",null); }
            set { setAttrVal<string>("Mmname", value); }
        }

        /// <summary>
        /// 物品规格
        /// </summary>
		public string Spec {
            get { return getAttrVal<string>("Spec",null); }
            set { setAttrVal<string>("Spec", value); }
        }

        /// <summary>
        /// 物品售价
        /// </summary>
		public double? Salesprice {
            get { return getAttrVal<FDouble>("Salesprice",null); }
            set { setAttrVal<FDouble>("Salesprice", value); }
        }

        /// <summary>
        /// 售价单位
        /// </summary>
		public string Salesunitname {
            get { return getAttrVal<string>("Salesunitname",null); }
            set { setAttrVal<string>("Salesunitname", value); }
        }

        /// <summary>
        /// 价值分类
        /// </summary>
		public string Id_val {
            get { return getAttrVal<string>("Id_val",null); }
            set { setAttrVal<string>("Id_val", value); }
        }

        /// <summary>
        /// 价值分类编码
        /// </summary>
		public string Sd_val {
            get { return getAttrVal<string>("Sd_val",null); }
            set { setAttrVal<string>("Sd_val", value); }
        }

        /// <summary>
        /// 价值分类名称
        /// </summary>
		public string Name_val {
            get { return getAttrVal<string>("Name_val",null); }
            set { setAttrVal<string>("Name_val", value); }
        }

        /// <summary>
        /// 生产厂家
        /// </summary>
		public string Name_sup {
            get { return getAttrVal<string>("Name_sup",null); }
            set { setAttrVal<string>("Name_sup", value); }
        }

        /// <summary>
        /// 进口分类
        /// </summary>
		public string Importtp {
            get { return getAttrVal<string>("Importtp",null); }
            set { setAttrVal<string>("Importtp", value); }
        }

        /// <summary>
        /// 药品产地
        /// </summary>
		public string Madeplace {
            get { return getAttrVal<string>("Madeplace",null); }
            set { setAttrVal<string>("Madeplace", value); }
        }

        /// <summary>
        /// OTC标识 
        /// </summary>
		public bool? Fg_otc {
            get { return getAttrVal<FBoolean>("Fg_otc",null); }
            set { setAttrVal<FBoolean>("Fg_otc", value); }
        }

        /// <summary>
        /// 药品剂型
        /// </summary>
		public string Id_dosage {
            get { return getAttrVal<string>("Id_dosage",null); }
            set { setAttrVal<string>("Id_dosage", value); }
        }

        /// <summary>
        /// 药品剂型编码
        /// </summary>
		public string Sd_dosage {
            get { return getAttrVal<string>("Sd_dosage",null); }
            set { setAttrVal<string>("Sd_dosage", value); }
        }

        /// <summary>
        /// 药品剂型名称
        /// </summary>
		public string Name_dosage {
            get { return getAttrVal<string>("Name_dosage",null); }
            set { setAttrVal<string>("Name_dosage", value); }
        }

        /// <summary>
        /// 药理分类
        /// </summary>
		public string Id_pharm {
            get { return getAttrVal<string>("Id_pharm",null); }
            set { setAttrVal<string>("Id_pharm", value); }
        }

        /// <summary>
        /// 药理分类编码
        /// </summary>
		public string Sd_pharm {
            get { return getAttrVal<string>("Sd_pharm",null); }
            set { setAttrVal<string>("Sd_pharm", value); }
        }

        /// <summary>
        /// 药理分类名称
        /// </summary>
		public string Name_pharm {
            get { return getAttrVal<string>("Name_pharm",null); }
            set { setAttrVal<string>("Name_pharm", value); }
        }

        /// <summary>
        /// 毒麻标识
        /// </summary>
		public bool? Fg_pois {
            get { return getAttrVal<FBoolean>("Fg_pois",null); }
            set { setAttrVal<FBoolean>("Fg_pois", value); }
        }

        /// <summary>
        /// 毒麻分类
        /// </summary>
		public string Id_pois {
            get { return getAttrVal<string>("Id_pois",null); }
            set { setAttrVal<string>("Id_pois", value); }
        }

        /// <summary>
        /// 毒麻分类编码
        /// </summary>
		public string Sd_pois {
            get { return getAttrVal<string>("Sd_pois",null); }
            set { setAttrVal<string>("Sd_pois", value); }
        }

        /// <summary>
        /// 毒麻分类名称
        /// </summary>
		public string Name_pois {
            get { return getAttrVal<string>("Name_pois",null); }
            set { setAttrVal<string>("Name_pois", value); }
        }

        /// <summary>
        /// 抗菌药标识
        /// </summary>
		public bool? Fg_anti {
            get { return getAttrVal<FBoolean>("Fg_anti",null); }
            set { setAttrVal<FBoolean>("Fg_anti", value); }
        }

        /// <summary>
        /// 抗菌药分类
        /// </summary>
		public string Id_anti {
            get { return getAttrVal<string>("Id_anti",null); }
            set { setAttrVal<string>("Id_anti", value); }
        }

        /// <summary>
        /// 抗菌药分类编码
        /// </summary>
		public string Sd_anti {
            get { return getAttrVal<string>("Sd_anti",null); }
            set { setAttrVal<string>("Sd_anti", value); }
        }

        /// <summary>
        /// 抗菌药分类名称
        /// </summary>
		public string Name_anti {
            get { return getAttrVal<string>("Name_anti",null); }
            set { setAttrVal<string>("Name_anti", value); }
        }

        /// <summary>
        /// 手术级别
        /// </summary>
		public string Id_opclass {
            get { return getAttrVal<string>("Id_opclass",null); }
            set { setAttrVal<string>("Id_opclass", value); }
        }

        /// <summary>
        /// 手术级别编码
        /// </summary>
		public string Sd_opclass {
            get { return getAttrVal<string>("Sd_opclass",null); }
            set { setAttrVal<string>("Sd_opclass", value); }
        }

        /// <summary>
        /// 手术级别名称
        /// </summary>
		public string Name_opclass {
            get { return getAttrVal<string>("Name_opclass",null); }
            set { setAttrVal<string>("Name_opclass", value); }
        }

        /// <summary>
        /// 切口等级
        /// </summary>
		public string Id_incitp {
            get { return getAttrVal<string>("Id_incitp",null); }
            set { setAttrVal<string>("Id_incitp", value); }
        }

        /// <summary>
        /// 切口等级编码
        /// </summary>
		public string Sd_incitp {
            get { return getAttrVal<string>("Sd_incitp",null); }
            set { setAttrVal<string>("Sd_incitp", value); }
        }

        /// <summary>
        /// 切口等级名称
        /// </summary>
		public string Name_incitp {
            get { return getAttrVal<string>("Name_incitp",null); }
            set { setAttrVal<string>("Name_incitp", value); }
        }

        /// <summary>
        /// 新开展手术标识
        /// </summary>
		public bool? Fg_new_sug {
            get { return getAttrVal<FBoolean>("Fg_new_sug",null); }
            set { setAttrVal<FBoolean>("Fg_new_sug", value); }
        }

        /// <summary>
        /// 标本类型
        /// </summary>
		public string Id_samptp {
            get { return getAttrVal<string>("Id_samptp",null); }
            set { setAttrVal<string>("Id_samptp", value); }
        }

        /// <summary>
        /// 标本类型编码
        /// </summary>
		public string Sd_samptp {
            get { return getAttrVal<string>("Sd_samptp",null); }
            set { setAttrVal<string>("Sd_samptp", value); }
        }

        /// <summary>
        /// 标本类型名称
        /// </summary>
		public string Name_samptp {
            get { return getAttrVal<string>("Name_samptp",null); }
            set { setAttrVal<string>("Name_samptp", value); }
        }

        /// <summary>
        /// 检查部位
        /// </summary>
		public string Id_body {
            get { return getAttrVal<string>("Id_body",null); }
            set { setAttrVal<string>("Id_body", value); }
        }

        /// <summary>
        /// 检查部位编码
        /// </summary>
		public string Sd_body {
            get { return getAttrVal<string>("Sd_body",null); }
            set { setAttrVal<string>("Sd_body", value); }
        }

        /// <summary>
        /// 检查部位名称
        /// </summary>
		public string Name_body {
            get { return getAttrVal<string>("Name_body",null); }
            set { setAttrVal<string>("Name_body", value); }
        }

        /// <summary>
        /// 检查体位
        /// </summary>
		public string Id_pos {
            get { return getAttrVal<string>("Id_pos",null); }
            set { setAttrVal<string>("Id_pos", value); }
        }

        /// <summary>
        /// 检查体位编码
        /// </summary>
		public string Sd_pos {
            get { return getAttrVal<string>("Sd_pos",null); }
            set { setAttrVal<string>("Sd_pos", value); }
        }

        /// <summary>
        /// 检查体位名称
        /// </summary>
		public string Name_pos {
            get { return getAttrVal<string>("Name_pos",null); }
            set { setAttrVal<string>("Name_pos", value); }
        }

        /// <summary>
        /// 描述信息
        /// </summary>
		public string Srvrefdes {
            get { return getAttrVal<string>("Srvrefdes",null); }
            set { setAttrVal<string>("Srvrefdes", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_srv", "Srvname", "Srvcode", "Id_srvca", "Srvcaname", "Id_srvtp", "Sd_srvtp", "Name_srvtp", "Pycode", "Wbcode", "Mnecode", "Shortname", "Fg_set", "Srvdes", "Id_hp", "Hpname", "Id_hpsrvtp", "Sd_hpsrvtp", "Name_hpsrvtp", "Limitreimbursecond", "Reimburserate", "Id_mm", "Mmname", "Spec", "Salesprice", "Salesunitname", "Id_val", "Sd_val", "Name_val", "Name_sup", "Importtp", "Madeplace", "Fg_otc", "Id_dosage", "Sd_dosage", "Name_dosage", "Id_pharm", "Sd_pharm", "Name_pharm", "Fg_pois", "Id_pois", "Sd_pois", "Name_pois", "Fg_anti", "Id_anti", "Sd_anti", "Name_anti", "Id_opclass", "Sd_opclass", "Name_opclass", "Id_incitp", "Sd_incitp", "Name_incitp", "Fg_new_sug", "Id_samptp", "Sd_samptp", "Name_samptp", "Id_body", "Sd_body", "Name_body", "Id_pos", "Sd_pos", "Name_pos", "Srvrefdes"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.srvref.d.CiSrvRefResultDTO";
        }
    }
}
