
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.pi.reg.pat.d;
using iih.ci.ord.ciorder.d;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.iih.ci.ord.dto.hp
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.iih.ci.ord.dto.hp    </para>    
    /// <para>类 名 称 :  BdHpIndicDTO					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2016/12/3 15:26:12             </para>
    /// <para>更新时间 :  2016/12/3 15:26:12             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class BdHpIndicDTO : BaseDTO
    {
        public BdHpIndicDTO()
        {
 
        }

        /// <summary>
        /// 病人基本信息
        /// </summary>
        public PatDO Pipatdo
        {
            get { return getAttrVal<PatDO>("Pipatdo", null); }
            set { setAttrVal<PatDO>("Pipatdo", value); }
        }

        /// <summary>
        /// 医嘱项目明细
        /// </summary>
        public OrdSrvDO Ci_orsrvdo
        {
            get { return getAttrVal<OrdSrvDO>("Ci_orsrvdo", null); }
            set { setAttrVal<OrdSrvDO>("Ci_orsrvdo", value); }
        }

        /// <summary>
        /// 主医保计划
        /// </summary>
		public string Id_hp {
            get { return getAttrVal<string>("Id_hp",null); }
            set { setAttrVal<string>("Id_hp", value); }
        }

        /// <summary>
        /// 医保目录类型ID
        /// </summary>
		public string Id_hpsrvtp {
            get { return getAttrVal<string>("Id_hpsrvtp",null); }
            set { setAttrVal<string>("Id_hpsrvtp", value); }
        }

        /// <summary>
        /// 医保目录类型SD
        /// </summary>
		public string Sd_hpsrvtp {
            get { return getAttrVal<string>("Sd_hpsrvtp",null); }
            set { setAttrVal<string>("Sd_hpsrvtp", value); }
        }

        /// <summary>
        /// 医保目录类型描述
        /// </summary>
        public string Des_hpsrvtp
        {
            get { return getAttrVal<string>("Des_hpsrvtp", null); }
            set { setAttrVal<string>("Des_hpsrvtp", value); }
        }

        /// <summary>
        /// 医保限制条件
        /// </summary>
		public string Des_hplimit {
            get { return getAttrVal<string>("Des_hplimit",null); }
            set { setAttrVal<string>("Des_hplimit", value); }
        }

        /// <summary>
        /// 系统判断结果
        /// </summary>
		public bool? Fg_indic {
            get { return getAttrVal<FBoolean>("Fg_indic",null); }
            set { setAttrVal<FBoolean>("Fg_indic", value); }
        }

        /// <summary>
        /// 判断方式
        /// </summary>
		public string Code_hpindicjudged {
            get { return getAttrVal<string>("Code_hpindicjudged",null); }
            set { setAttrVal<string>("Code_hpindicjudged", value); }
        }

        /// <summary>
        /// 新生儿标志
        /// </summary>
		public bool? Fg_bb {
            get { return getAttrVal<FBoolean>("Fg_bb",null); }
            set { setAttrVal<FBoolean>("Fg_bb", value); }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }

        /// <summary>
        /// 开单科室
        /// </summary>
		public string Id_dep_or {
            get { return getAttrVal<string>("Id_dep_or",null); }
            set { setAttrVal<string>("Id_dep_or", value); }
        }

        /// <summary>
        /// 开单科室名称
        /// </summary>
		public string Name_dep_or {
            get { return getAttrVal<string>("Name_dep_or",null); }
            set { setAttrVal<string>("Name_dep_or", value); }
        }

        /// <summary>
        /// 临床诊断明细
        /// </summary>
		public FArrayList2 Ci_di_itms {
            get { return getAttrVal<FArrayList2>("Ci_di_itms",null); }
            set { setAttrVal<FArrayList2>("Ci_di_itms", value); }
        }

        /// <summary>
        /// 用药天数
        /// </summary>
		public int? Use_days {
            get { return getAttrVal<int?>("Use_days",null); }
            set { setAttrVal<int?>("Use_days", value); }
        }

        /// <summary>
        /// 性别
        /// </summary>
		public string Sd_sex {
            get { return getAttrVal<string>("Sd_sex",null); }
            set { setAttrVal<string>("Sd_sex", value); }
        }

        /// <summary>
        /// 出生日期
        /// </summary>
		public DateTime? Dt_birth {
            get { return getAttrVal<FDate>("Dt_birth",null); }
            set { setAttrVal<FDate>("Dt_birth", value); }
        }

        /// <summary>
        /// 服务ID
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 数量
        /// </summary>
		public string Quan {
            get { return getAttrVal<string>("Quan",null); }
            set { setAttrVal<string>("Quan", value); }
        }

        /// <summary>
        /// 使用天数
        /// </summary>
		public int? Use_day {
            get { return getAttrVal<int?>("Use_days",null); }
            set { setAttrVal<int?>("Use_days", value); }
        }

        /// <summary>
        /// 服务名称
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 物品标志
        /// </summary>
		public bool? Fg_mm {
            get { return getAttrVal<FBoolean>("Fg_mm",null); }
            set { setAttrVal<FBoolean>("Fg_mm", value); }
        }

        /// <summary>
        /// 频次
        /// </summary>
		public string Id_freq {
            get { return getAttrVal<string>("Id_freq",null); }
            set { setAttrVal<string>("Id_freq", value); }
        }

        /// <summary>
        /// 单次剂量
        /// </summary>
		public string Quan_medu {
            get { return getAttrVal<string>("Quan_medu",null); }
            set { setAttrVal<string>("Quan_medu", value); }
        }

        /// <summary>
        /// 剂型
        /// </summary>
		public string Id_dosage {
            get { return getAttrVal<string>("Id_dosage",null); }
            set { setAttrVal<string>("Id_dosage", value); }
        }
        /// <summary>
        /// 物品ID
        /// </summary>
        public string Id_mm
        {
            get { return getAttrVal<string>("Id_mm", null); }
            set { setAttrVal<string>("Id_mm", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Pipatdo", "Ci_orsrvdo", "Id_hp", "Id_hpsrvtp", "Sd_hpsrvtp", "Des_hpsrvtp", "Des_hplimit", "Fg_indic", "Code_hpindicjudged", "Fg_bb", "Code_entp", "Id_dep_or", "Name_dep_or", "Ci_di_itms", "Use_days", "Sd_sex", "Dt_birth", "Id_srv", "Quan", "Use_days", "Name", "Fg_mm", "Id_freq", "Quan_medu", "Id_dosage","Id_mm" };
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.iih.ci.ord.dto.hp.BdHpIndicDTO";
        }
    }
}
