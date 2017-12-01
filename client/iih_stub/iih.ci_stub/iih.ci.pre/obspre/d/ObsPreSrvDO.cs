
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.pre.obspre.d
{
    /// <summary>
    /// ObsPreSrvDO 的摘要说明。
    /// </summary>
    public class ObsPreSrvDO : BaseDO {

        public ObsPreSrvDO() {
        }
		public string Id_preobssrv {
            get { return getAttrVal<string>("Id_preobssrv",null); }
            set { setAttrVal<string>("Id_preobssrv", value); }
        }
		public string Id_obspre {
            get { return getAttrVal<string>("Id_obspre",null); }
            set { setAttrVal<string>("Id_obspre", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }
		public string Val0 {
            get { return getAttrVal<string>("Val0",null); }
            set { setAttrVal<string>("Val0", value); }
        }
		public string Val1 {
            get { return getAttrVal<string>("Val1",null); }
            set { setAttrVal<string>("Val1", value); }
        }
		public string Val2 {
            get { return getAttrVal<string>("Val2",null); }
            set { setAttrVal<string>("Val2", value); }
        }
		public string Val3 {
            get { return getAttrVal<string>("Val3",null); }
            set { setAttrVal<string>("Val3", value); }
        }
		public string Val4 {
            get { return getAttrVal<string>("Val4",null); }
            set { setAttrVal<string>("Val4", value); }
        }
        public int Ds {
            get { return getAttrVal<int>("Ds",0);}
            set { setAttrVal<int>("Ds", value); }
        }

        public DateTime? Sv        {
            get { return getAttrVal<FDateTime>("Sv",null); }
            set { setAttrVal<FDateTime>("Sv", value); }
        }
        
        /// <summary>
        /// 返回表名
        /// </summary>
        /// <returns></returns>
        public override string getTableName()
        {
            return "ci_obs_pre_srv";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_preobssrv";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.pre.obspre.d.ObsPreSrvDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_preobssrv", "Id_obspre", "Id_ent", "Id_srv", "Val0", "Val1", "Val2", "Val3", "Val4"};
        }
        
    }
}
