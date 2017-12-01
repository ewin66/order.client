using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.d
{
    /// <summary>
    /// PresOrSrvDTO 的摘要说明。
    /// </summary>
    public class PresOrSrvDTO : BaseDTO {

        public PresOrSrvDTO() {
 
        }

        /// <summary>
        /// 处方
        /// </summary>
		public string Id_pres {
            get { return getAttrVal<string>("Id_pres",null); }
            set { setAttrVal<string>("Id_pres", value); }
        }

        /// <summary>
        /// 医嘱项目
        /// </summary>
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }

        /// <summary>
        /// 服务
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 服务编码
        /// </summary>
		public string Code_srv {
            get { return getAttrVal<string>("Code_srv",null); }
            set { setAttrVal<string>("Code_srv", value); }
        }

        /// <summary>
        /// 客户扩展字段1
        /// </summary>
		public string Def1 {
            get { return getAttrVal<string>("Def1",null); }
            set { setAttrVal<string>("Def1", value); }
        }

        /// <summary>
        /// 客户扩展字段2
        /// </summary>
		public string Def2 {
            get { return getAttrVal<string>("Def2",null); }
            set { setAttrVal<string>("Def2", value); }
        }

        /// <summary>
        /// 客户扩展字段3
        /// </summary>
		public string Def3 {
            get { return getAttrVal<string>("Def3",null); }
            set { setAttrVal<string>("Def3", value); }
        }

        /// <summary>
        /// 客户扩展字段4
        /// </summary>
		public string Def4 {
            get { return getAttrVal<string>("Def4",null); }
            set { setAttrVal<string>("Def4", value); }
        }

        /// <summary>
        /// 客户扩展字段5
        /// </summary>
		public string Def5 {
            get { return getAttrVal<string>("Def5",null); }
            set { setAttrVal<string>("Def5", value); }
        }

        /// <summary>
        /// 客户扩展字段6
        /// </summary>
		public string Def6 {
            get { return getAttrVal<string>("Def6",null); }
            set { setAttrVal<string>("Def6", value); }
        }

        /// <summary>
        /// 客户扩展字段7
        /// </summary>
		public string Def7 {
            get { return getAttrVal<string>("Def7",null); }
            set { setAttrVal<string>("Def7", value); }
        }

        /// <summary>
        /// 客户扩展字段8
        /// </summary>
		public string Def8 {
            get { return getAttrVal<string>("Def8",null); }
            set { setAttrVal<string>("Def8", value); }
        }

        /// <summary>
        /// 客户扩展字段9
        /// </summary>
		public string Def9 {
            get { return getAttrVal<string>("Def9",null); }
            set { setAttrVal<string>("Def9", value); }
        }

        /// <summary>
        /// 客户扩展字段10
        /// </summary>
		public string Def10 {
            get { return getAttrVal<string>("Def10",null); }
            set { setAttrVal<string>("Def10", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_pres", "Id_orsrv", "Id_srv", "Code_srv", "Def1", "Def2", "Def3", "Def4", "Def5", "Def6", "Def7", "Def8", "Def9", "Def10"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.d.PresOrSrvDTO";
        }
    }
}
