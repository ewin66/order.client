using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.diag.dto.judgedideletedto.d
{
    /// <summary>
    /// Judgedideletedto 的摘要说明。
    /// </summary>
    public class Judgedideletedto : BaseDTO {

        public Judgedideletedto() {
 
        }

        /// <summary>
        /// 医嘱主键
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 医嘱名称
        /// </summary>
		public string Name_or {
            get { return getAttrVal<string>("Name_or",null); }
            set { setAttrVal<string>("Name_or", value); }
        }

        /// <summary>
        /// 医嘱编码
        /// </summary>
		public string Code_or {
            get { return getAttrVal<string>("Code_or",null); }
            set { setAttrVal<string>("Code_or", value); }
        }

        /// <summary>
        /// 医嘱项目主键
        /// </summary>
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }

        /// <summary>
        /// 服务名称
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 结果编码
        /// </summary>
		public string Eu_dpndrsn {
            get { return getAttrVal<string>("Eu_dpndrsn",null); }
            set { setAttrVal<string>("Eu_dpndrsn", value); }
        }

        /// <summary>
        /// 结果原因
        /// </summary>
		public string Desc_dpndrsn {
            get { return getAttrVal<string>("Desc_dpndrsn",null); }
            set { setAttrVal<string>("Desc_dpndrsn", value); }
        }

        /// <summary>
        /// 服务id
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 是否删除
        /// </summary>
		public bool? Fg_delete {
            get { return getAttrVal<FBoolean>("Fg_delete", null); }
            set { setAttrVal<FBoolean>("Fg_delete", value); }
        }

        /// <summary>
        /// displaynam10
        /// </summary>
		public string Name10 {
            get { return getAttrVal<string>("Name10",null); }
            set { setAttrVal<string>("Name10", value); }
        }

        /// <summary>
        /// displaynam11
        /// </summary>
		public string Name11 {
            get { return getAttrVal<string>("Name11",null); }
            set { setAttrVal<string>("Name11", value); }
        }

        /// <summary>
        /// displaynam12
        /// </summary>
		public string Name12 {
            get { return getAttrVal<string>("Name12",null); }
            set { setAttrVal<string>("Name12", value); }
        }

        /// <summary>
        /// displaynam13
        /// </summary>
		public string Name13 {
            get { return getAttrVal<string>("Name13",null); }
            set { setAttrVal<string>("Name13", value); }
        }

        /// <summary>
        /// displaynam14
        /// </summary>
		public string Name14 {
            get { return getAttrVal<string>("Name14",null); }
            set { setAttrVal<string>("Name14", value); }
        }

        /// <summary>
        /// displaynam15
        /// </summary>
		public string Name15 {
            get { return getAttrVal<string>("Name15",null); }
            set { setAttrVal<string>("Name15", value); }
        }

        /// <summary>
        /// displaynam16
        /// </summary>
		public string Name16 {
            get { return getAttrVal<string>("Name16",null); }
            set { setAttrVal<string>("Name16", value); }
        }

        /// <summary>
        /// displaynam17
        /// </summary>
		public string Name17 {
            get { return getAttrVal<string>("Name17",null); }
            set { setAttrVal<string>("Name17", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_or", "Name_or", "Code_or", "Id_orsrv", "Name_srv", "Eu_dpndrsn", "Desc_dpndrsn", "Id_srv", "Fg_delete", "Name10", "Name11", "Name12", "Name13", "Name14", "Name15", "Name16", "Name17"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.diag.dto.judgedideletedto.d.Judgedideletedto";
        }
    }
}
