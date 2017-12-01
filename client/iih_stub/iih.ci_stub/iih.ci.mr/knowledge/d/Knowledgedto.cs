using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.knowledge.d
{
    /// <summary>
    /// Knowledgedto 的摘要说明。
    /// </summary>
    public class Knowledgedto : BaseDTO {

        public Knowledgedto() {
 
        }

        /// <summary>
        /// 类别
        /// </summary>
		public string Category {
            get { return getAttrVal<string>("Category",null); }
            set { setAttrVal<string>("Category", value); }
        }

        /// <summary>
        /// 名称
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 所属
        /// </summary>
		public string Attribute {
            get { return getAttrVal<string>("Attribute",null); }
            set { setAttrVal<string>("Attribute", value); }
        }

        /// <summary>
        /// 个人
        /// </summary>
		public bool? Personal {
            get { return getAttrVal<FBoolean>("Personal",null); }
            set { setAttrVal<FBoolean>("Personal", value); }
        }

        /// <summary>
        /// 科室
        /// </summary>
		public bool? Administrative {
            get { return getAttrVal<FBoolean>("Administrative",null); }
            set { setAttrVal<FBoolean>("Administrative", value); }
        }

        /// <summary>
        /// 所属用户
        /// </summary>
		public string Id_user {
            get { return getAttrVal<string>("Id_user",null); }
            set { setAttrVal<string>("Id_user", value); }
        }

        /// <summary>
        /// 知识内容
        /// </summary>
		public string Knowledge_content {
            get { return getAttrVal<string>("Knowledge_content",null); }
            set { setAttrVal<string>("Knowledge_content", value); }
        }

        /// <summary>
        /// 知识库编码
        /// </summary>
		public string Id_knowledge {
            get { return getAttrVal<string>("Id_knowledge",null); }
            set { setAttrVal<string>("Id_knowledge", value); }
        }

        /// <summary>
        /// ds
        /// </summary>
		public string Ds {
            get { return getAttrVal<string>("Ds",null); }
            set { setAttrVal<string>("Ds", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Category", "Name", "Attribute", "Personal", "Administrative", "Id_user", "Knowledge_content", "Id_knowledge", "Ds"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.knowledge.d.Knowledgedto";
        }
    }
}
