using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.medicalroutinetreedto.d
{
    /// <summary>
    /// Medicalroutinetreedto 的摘要说明。
    /// </summary>
    public class Medicalroutinetreedto : BaseDTO {

        public Medicalroutinetreedto() {
 
        }

        /// <summary>
        /// 主键
        /// </summary>
		public string Id {
            get { return getAttrVal<string>("Id",null); }
            set { setAttrVal<string>("Id", value); }
        }

        /// <summary>
        /// 父id
        /// </summary>
		public string Id_parent {
            get { return getAttrVal<string>("Id_parent",null); }
            set { setAttrVal<string>("Id_parent", value); }
        }

        /// <summary>
        /// 模板分类
        /// </summary>
		public string Id_ortmplca {
            get { return getAttrVal<string>("Id_ortmplca",null); }
            set { setAttrVal<string>("Id_ortmplca", value); }
        }

        /// <summary>
        /// 模板id
        /// </summary>
		public string Id_ortmpl {
            get { return getAttrVal<string>("Id_ortmpl",null); }
            set { setAttrVal<string>("Id_ortmpl", value); }
        }

        /// <summary>
        /// 名称
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 描述
        /// </summary>
		public string Desc {
            get { return getAttrVal<string>("Desc",null); }
            set { setAttrVal<string>("Desc", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id", "Id_parent", "Id_ortmplca", "Id_ortmpl", "Name", "Desc"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.medicalroutinetreedto.d.Medicalroutinetreedto";
        }
    }
}
