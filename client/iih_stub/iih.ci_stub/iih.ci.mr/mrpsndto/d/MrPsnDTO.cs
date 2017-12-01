using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.mrpsndto.d
{
    /// <summary>
    /// MrPsnDTO 的摘要说明。
    /// </summary>
    public class MrPsnDTO : BaseDTO {

        public MrPsnDTO() {
 
        }

        /// <summary>
        /// 用户Id
        /// </summary>
		public string Id_user {
            get { return getAttrVal<string>("Id_user",null); }
            set { setAttrVal<string>("Id_user", value); }
        }

        /// <summary>
        /// 人员Id
        /// </summary>
		public string Id_psn {
            get { return getAttrVal<string>("Id_psn",null); }
            set { setAttrVal<string>("Id_psn", value); }
        }

        /// <summary>
        /// 姓名
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 职称
        /// </summary>
		public string Psndocname {
            get { return getAttrVal<string>("Psndocname",null); }
            set { setAttrVal<string>("Psndocname", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_user", "Id_psn", "Name", "Psndocname"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.mrpsndto.d.MrPsnDTO";
        }
    }
}
