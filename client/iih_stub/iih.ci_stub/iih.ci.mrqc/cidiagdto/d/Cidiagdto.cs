using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.d
{
    /// <summary>
    /// Cidiagdto 的摘要说明。
    /// </summary>
    public class Cidiagdto : BaseDTO {

        public Cidiagdto() {
 
        }

        /// <summary>
        /// 主键标识
        /// </summary>
		public string Id_cididt {
            get { return getAttrVal<string>("Id_cididt",null); }
            set { setAttrVal<string>("Id_cididt", value); }
        }

        /// <summary>
        /// 诊断类型
        /// </summary>
		public string Id_disys {
            get { return getAttrVal<string>("Id_disys",null); }
            set { setAttrVal<string>("Id_disys", value); }
        }

        /// <summary>
        /// 诊断名称
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 诊断编码
        /// </summary>
		public string Code {
            get { return getAttrVal<string>("Code",null); }
            set { setAttrVal<string>("Code", value); }
        }

        /// <summary>
        /// 诊断描述
        /// </summary>
		public string Des {
            get { return getAttrVal<string>("Des",null); }
            set { setAttrVal<string>("Des", value); }
        }

        /// <summary>
        /// 诊断日期
        /// </summary>
		public string Dt_di {
            get { return getAttrVal<string>("Dt_di",null); }
            set { setAttrVal<string>("Dt_di", value); }
        }

        /// <summary>
        /// 就诊
        /// </summary>
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }

        /// <summary>
        /// 患者
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 诊断过程
        /// </summary>
		public string Id_ditp {
            get { return getAttrVal<string>("Id_ditp",null); }
            set { setAttrVal<string>("Id_ditp", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_cididt", "Id_disys", "Name", "Code", "Des", "Dt_di", "Id_en", "Id_pat", "Id_ditp"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.d.Cidiagdto";
        }
    }
}
