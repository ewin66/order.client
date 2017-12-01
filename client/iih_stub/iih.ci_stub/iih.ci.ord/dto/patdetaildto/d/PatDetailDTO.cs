using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.patdetaildto.d
{
    /// <summary>
    /// PatDetailDTO 的摘要说明。
    /// </summary>
    public class PatDetailDTO : BaseDTO {

        public PatDetailDTO() {
 
        }

        /// <summary>
        /// 就诊id
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 患者id
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 患者姓名
        /// </summary>
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }

        /// <summary>
        /// 性别
        /// </summary>
		public string Sex_pat {
            get { return getAttrVal<string>("Sex_pat",null); }
            set { setAttrVal<string>("Sex_pat", value); }
        }

        /// <summary>
        /// 联系电话
        /// </summary>
		public string Tel {
            get { return getAttrVal<string>("Tel",null); }
            set { setAttrVal<string>("Tel", value); }
        }

        /// <summary>
        /// 民族
        /// </summary>
		public string Name_nation {
            get { return getAttrVal<string>("Name_nation",null); }
            set { setAttrVal<string>("Name_nation", value); }
        }

        /// <summary>
        /// 患者信用分类
        /// </summary>
		public string Name_patcret {
            get { return getAttrVal<string>("Name_patcret",null); }
            set { setAttrVal<string>("Name_patcret", value); }
        }

        /// <summary>
        /// 主医保计划
        /// </summary>
		public string Name_hp {
            get { return getAttrVal<string>("Name_hp",null); }
            set { setAttrVal<string>("Name_hp", value); }
        }

        /// <summary>
        /// 现住址
        /// </summary>
		public string Addr_pat {
            get { return getAttrVal<string>("Addr_pat",null); }
            set { setAttrVal<string>("Addr_pat", value); }
        }

        /// <summary>
        /// 住院诊断名称
        /// </summary>
		public string Name_didef_dis {
            get { return getAttrVal<string>("Name_didef_dis",null); }
            set { setAttrVal<string>("Name_didef_dis", value); }
        }

        /// <summary>
        /// 当前科室
        /// </summary>
		public string Name_dep_phy {
            get { return getAttrVal<string>("Name_dep_phy",null); }
            set { setAttrVal<string>("Name_dep_phy", value); }
        }

        /// <summary>
        /// 当前病区
        /// </summary>
		public string Name_dep_nur {
            get { return getAttrVal<string>("Name_dep_nur",null); }
            set { setAttrVal<string>("Name_dep_nur", value); }
        }

        /// <summary>
        /// 床位
        /// </summary>
		public string Name_bed {
            get { return getAttrVal<string>("Name_bed",null); }
            set { setAttrVal<string>("Name_bed", value); }
        }

        /// <summary>
        /// 主管医生
        /// </summary>
		public string Name_emp_phy {
            get { return getAttrVal<string>("Name_emp_phy",null); }
            set { setAttrVal<string>("Name_emp_phy", value); }
        }

        /// <summary>
        /// 年龄
        /// </summary>
		public string Pat_age {
            get { return getAttrVal<string>("Pat_age",null); }
            set { setAttrVal<string>("Pat_age", value); }
        }

        /// <summary>
        /// 证件类型
        /// </summary>
		public string Name_idcardtp {
            get { return getAttrVal<string>("Name_idcardtp",null); }
            set { setAttrVal<string>("Name_idcardtp", value); }
        }

        /// <summary>
        /// 证件号
        /// </summary>
		public string Name_idcard {
            get { return getAttrVal<string>("Name_idcard",null); }
            set { setAttrVal<string>("Name_idcard", value); }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_ent", "Id_pat", "Name_pat", "Sex_pat", "Tel", "Name_nation", "Name_patcret", "Name_hp", "Addr_pat", "Name_didef_dis", "Name_dep_phy", "Name_dep_nur", "Name_bed", "Name_emp_phy", "Pat_age", "Name_idcardtp", "Name_idcard", "Code_entp"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.patdetaildto.d.PatDetailDTO";
        }
    }
}
