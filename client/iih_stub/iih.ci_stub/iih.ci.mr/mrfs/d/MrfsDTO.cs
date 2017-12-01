using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.mrfs.d
{
    /// <summary>
    /// MrfsDTO 的摘要说明。
    /// </summary>
    public class MrfsDTO : BaseDTO {

        public MrfsDTO() {
 
        }

        /// <summary>
        /// 医疗记录主键标识
        /// </summary>
		public string Id_mr {
            get { return getAttrVal<string>("Id_mr",null); }
            set { setAttrVal<string>("Id_mr", value); }
        }

        /// <summary>
        /// 就诊
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 医疗记录名称
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 医疗记录编辑器
        /// </summary>
		public string Id_mred {
            get { return getAttrVal<string>("Id_mred",null); }
            set { setAttrVal<string>("Id_mred", value); }
        }

        /// <summary>
        /// 就诊类型编码
        /// </summary>
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }

        /// <summary>
        /// 前新起一页
        /// </summary>
		public bool? Newtop {
            get { return getAttrVal<FBoolean>("Newtop",null); }
            set { setAttrVal<FBoolean>("Newtop", value); }
        }

        /// <summary>
        /// 后新起一页
        /// </summary>
		public bool? Newend {
            get { return getAttrVal<FBoolean>("Newend",null); }
            set { setAttrVal<FBoolean>("Newend", value); }
        }

        /// <summary>
        /// 医疗记录显示数据流
        /// </summary>
		public byte[] Emrfs {
            get { return getAttrVal<byte[]>("Emrfs",null); }
            set { setAttrVal<byte[]>("Emrfs", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_mr", "Id_ent", "Name", "Id_mred", "Code_entp", "Newtop", "Newend", "Emrfs"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.mrfs.d.MrfsDTO";
        }
    }
}
