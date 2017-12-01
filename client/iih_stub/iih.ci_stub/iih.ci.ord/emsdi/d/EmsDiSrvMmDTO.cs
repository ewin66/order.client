using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.emsdi.d
{
    /// <summary>
    /// EmsDiSrvMmDTO 的摘要说明。
    /// </summary>
    public class EmsDiSrvMmDTO : BaseDTO {

        public EmsDiSrvMmDTO() {
 
        }

        /// <summary>
        /// 医疗单di服务物品主键
        /// </summary>
		public string Id_emsdisrvmm {
            get { return getAttrVal<string>("Id_emsdisrvmm",null); }
            set { setAttrVal<string>("Id_emsdisrvmm", value); }
        }

        /// <summary>
        /// 医疗单di主键
        /// </summary>
		public string Id_emsdi {
            get { return getAttrVal<string>("Id_emsdi",null); }
            set { setAttrVal<string>("Id_emsdi", value); }
        }

        /// <summary>
        /// 医疗单di服务主键
        /// </summary>
		public string Id_emsdisrv {
            get { return getAttrVal<string>("Id_emsdisrv",null); }
            set { setAttrVal<string>("Id_emsdisrv", value); }
        }

        /// <summary>
        /// 服务id
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 物品
        /// </summary>
		public string Id_mm {
            get { return getAttrVal<string>("Id_mm",null); }
            set { setAttrVal<string>("Id_mm", value); }
        }

        /// <summary>
        /// 药品编码
        /// </summary>
		public string Code_mm {
            get { return getAttrVal<string>("Code_mm",null); }
            set { setAttrVal<string>("Code_mm", value); }
        }

        /// <summary>
        /// 物品名称
        /// </summary>
		public string Name_mm {
            get { return getAttrVal<string>("Name_mm",null); }
            set { setAttrVal<string>("Name_mm", value); }
        }

        /// <summary>
        /// 规格
        /// </summary>
		public string Spec_mm {
            get { return getAttrVal<string>("Spec_mm",null); }
            set { setAttrVal<string>("Spec_mm", value); }
        }

        /// <summary>
        /// 物品类型
        /// </summary>
		public string Id_mmtp {
            get { return getAttrVal<string>("Id_mmtp",null); }
            set { setAttrVal<string>("Id_mmtp", value); }
        }

        /// <summary>
        /// 物品类型编码
        /// </summary>
		public string Sd_mmtp {
            get { return getAttrVal<string>("Sd_mmtp",null); }
            set { setAttrVal<string>("Sd_mmtp", value); }
        }

        /// <summary>
        /// 物品类型名称
        /// </summary>
		public string Name_mmtp {
            get { return getAttrVal<string>("Name_mmtp",null); }
            set { setAttrVal<string>("Name_mmtp", value); }
        }

        /// <summary>
        /// 厂家
        /// </summary>
		public string Id_sup {
            get { return getAttrVal<string>("Id_sup",null); }
            set { setAttrVal<string>("Id_sup", value); }
        }

        /// <summary>
        /// 厂家名称
        /// </summary>
		public string Name_sup {
            get { return getAttrVal<string>("Name_sup",null); }
            set { setAttrVal<string>("Name_sup", value); }
        }

        /// <summary>
        /// 取整方式
        /// </summary>
		public string Sd_roundmd {
            get { return getAttrVal<string>("Sd_roundmd",null); }
            set { setAttrVal<string>("Sd_roundmd", value); }
        }

        /// <summary>
        /// 基本单位
        /// </summary>
		public string Id_unit_base {
            get { return getAttrVal<string>("Id_unit_base",null); }
            set { setAttrVal<string>("Id_unit_base", value); }
        }

        /// <summary>
        /// 名称_基本单位
        /// </summary>
		public string Name_unit_base {
            get { return getAttrVal<string>("Name_unit_base",null); }
            set { setAttrVal<string>("Name_unit_base", value); }
        }

        /// <summary>
        /// 系数_医学基本
        /// </summary>
		public double? Factor_mb {
            get { return getAttrVal<FDouble>("Factor_mb",null); }
            set { setAttrVal<FDouble>("Factor_mb", value); }
        }

        /// <summary>
        /// 单次数量分子
        /// </summary>
		public double? Quan_num_base {
            get { return getAttrVal<FDouble>("Quan_num_base",null); }
            set { setAttrVal<FDouble>("Quan_num_base", value); }
        }

        /// <summary>
        /// 单次数量分母
        /// </summary>
		public string Quan_den_base {
            get { return getAttrVal<string>("Quan_den_base",null); }
            set { setAttrVal<string>("Quan_den_base", value); }
        }

        /// <summary>
        /// 总量单位
        /// </summary>
		public string Id_pgku_cur {
            get { return getAttrVal<string>("Id_pgku_cur",null); }
            set { setAttrVal<string>("Id_pgku_cur", value); }
        }

        /// <summary>
        /// 名称_总量单位
        /// </summary>
		public string Name_pgku_cur {
            get { return getAttrVal<string>("Name_pgku_cur",null); }
            set { setAttrVal<string>("Name_pgku_cur", value); }
        }

        /// <summary>
        /// 系数_当前基本
        /// </summary>
		public double? Factor_cb {
            get { return getAttrVal<FDouble>("Factor_cb",null); }
            set { setAttrVal<FDouble>("Factor_cb", value); }
        }

        /// <summary>
        /// 参考价格
        /// </summary>
		public double? Price {
            get { return getAttrVal<FDouble>("Price",null); }
            set { setAttrVal<FDouble>("Price", value); }
        }

        /// <summary>
        /// 总量
        /// </summary>
		public double? Quan_cur {
            get { return getAttrVal<FDouble>("Quan_cur",null); }
            set { setAttrVal<FDouble>("Quan_cur", value); }
        }

        /// <summary>
        /// 金额
        /// </summary>
		public double? Amt_cur {
            get { return getAttrVal<FDouble>("Amt_cur",null); }
            set { setAttrVal<FDouble>("Amt_cur", value); }
        }

        /// <summary>
        /// 可用库存
        /// </summary>
		public double? Quan_stock {
            get { return getAttrVal<FDouble>("Quan_stock",null); }
            set { setAttrVal<FDouble>("Quan_stock", value); }
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
        /// OTC标识
        /// </summary>
		public bool? Fg_otc {
            get { return getAttrVal<FBoolean>("Fg_otc",null); }
            set { setAttrVal<FBoolean>("Fg_otc", value); }
        }

        /// <summary>
        /// 皮试标识
        /// </summary>
		public bool? Fg_skintest {
            get { return getAttrVal<FBoolean>("Fg_skintest",null); }
            set { setAttrVal<FBoolean>("Fg_skintest", value); }
        }

        /// <summary>
        /// 对应皮试服务
        /// </summary>
		public string Id_srvskin {
            get { return getAttrVal<string>("Id_srvskin",null); }
            set { setAttrVal<string>("Id_srvskin", value); }
        }

        /// <summary>
        /// 关联信息Map键值串
        /// </summary>
		public string Mapkeys {
            get { return getAttrVal<string>("Mapkeys",null); }
            set { setAttrVal<string>("Mapkeys", value); }
        }

        /// <summary>
        /// 服务物品关联信息MAP
        /// </summary>
		public FMap Mapinfo {
            get { return getAttrVal<FMap>("Mapinfo",null); }
            set { setAttrVal<FMap>("Mapinfo", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_emsdisrvmm", "Id_emsdi", "Id_emsdisrv", "Id_srv", "Id_mm", "Code_mm", "Name_mm", "Spec_mm", "Id_mmtp", "Sd_mmtp", "Name_mmtp", "Id_sup", "Name_sup", "Sd_roundmd", "Id_unit_base", "Name_unit_base", "Factor_mb", "Quan_num_base", "Quan_den_base", "Id_pgku_cur", "Name_pgku_cur", "Factor_cb", "Price", "Quan_cur", "Amt_cur", "Quan_stock", "Id_dosage", "Sd_dosage", "Id_pharm", "Sd_pharm", "Id_pois", "Sd_pois", "Id_anti", "Sd_anti", "Id_val", "Sd_val", "Fg_otc", "Fg_skintest", "Id_srvskin", "Mapkeys", "Mapinfo"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.emsdi.d.EmsDiSrvMmDTO";
        }
    }
}
