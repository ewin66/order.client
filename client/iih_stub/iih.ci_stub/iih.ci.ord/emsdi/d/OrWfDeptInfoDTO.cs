using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.emsdi.d
{
    /// <summary>
    /// OrWfDeptInfoDTO 的摘要说明。
    /// </summary>
    public class OrWfDeptInfoDTO : BaseDTO {

        public OrWfDeptInfoDTO() {
 
        }

        /// <summary>
        /// 医嘱流向执行科室列表
        /// </summary>
		public FArrayList Orwfexedepts {
            get { return getAttrVal<FArrayList>("Orwfexedepts",null); }
            set { setAttrVal<FArrayList>("Orwfexedepts", value); }
        }

        /// <summary>
        /// 物品流向库房科室列表
        /// </summary>
		public FArrayList Pharmwfwhdepts {
            get { return getAttrVal<FArrayList>("Pharmwfwhdepts",null); }
            set { setAttrVal<FArrayList>("Pharmwfwhdepts", value); }
        }

        /// <summary>
        /// 第一个执行科室id
        /// </summary>
		public string Firstid_mp_dept {
            get { return getAttrVal<string>("Firstid_mp_dept",null); }
            set { setAttrVal<string>("Firstid_mp_dept", value); }
        }

        /// <summary>
        /// 第一个执行科室名称
        /// </summary>
		public string Firstname_mp_dept {
            get { return getAttrVal<string>("Firstname_mp_dept",null); }
            set { setAttrVal<string>("Firstname_mp_dept", value); }
        }

        /// <summary>
        /// 执行科室字符串
        /// </summary>
		public string Id_mp_depts {
            get { return getAttrVal<string>("Id_mp_depts",null); }
            set { setAttrVal<string>("Id_mp_depts", value); }
        }

        /// <summary>
        /// 库存id
        /// </summary>
		public string Id_dept_wh {
            get { return getAttrVal<string>("Id_dept_wh",null); }
            set { setAttrVal<string>("Id_dept_wh", value); }
        }

        /// <summary>
        /// 库房名称
        /// </summary>
		public string Name_dept_wh {
            get { return getAttrVal<string>("Name_dept_wh",null); }
            set { setAttrVal<string>("Name_dept_wh", value); }
        }

        /// <summary>
        /// 库房主键字符串拼接
        /// </summary>
		public string Id_dept_whs {
            get { return getAttrVal<string>("Id_dept_whs",null); }
            set { setAttrVal<string>("Id_dept_whs", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Orwfexedepts", "Pharmwfwhdepts", "Firstid_mp_dept", "Firstname_mp_dept", "Id_mp_depts", "Id_dept_wh", "Name_dept_wh", "Id_dept_whs"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.emsdi.d.OrWfDeptInfoDTO";
        }
    }
}
