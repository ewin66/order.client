using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.qascoredto.d
{
    /// <summary>
    /// QaScoreDTO 的摘要说明。
    /// </summary>
    public class QaScoreDTO : BaseDTO {

        public QaScoreDTO() {
 
        }

        /// <summary>
        /// dto主键
        /// </summary>
		public string Id_qascoredto {
            get { return getAttrVal<string>("Id_qascoredto",null); }
            set { setAttrVal<string>("Id_qascoredto", value); }
        }

        /// <summary>
        /// 质控项id
        /// </summary>
		public string Id_qa_itm {
            get { return getAttrVal<string>("Id_qa_itm",null); }
            set { setAttrVal<string>("Id_qa_itm", value); }
        }

        /// <summary>
        /// 自动质控配置主键
        /// </summary>
		public string Id_qa_auto {
            get { return getAttrVal<string>("Id_qa_auto",null); }
            set { setAttrVal<string>("Id_qa_auto", value); }
        }

        /// <summary>
        /// 评分主键
        /// </summary>
		public string Id_qa_divide {
            get { return getAttrVal<string>("Id_qa_divide",null); }
            set { setAttrVal<string>("Id_qa_divide", value); }
        }

        /// <summary>
        /// 一级分类id
        /// </summary>
		public string Id_fst {
            get { return getAttrVal<string>("Id_fst",null); }
            set { setAttrVal<string>("Id_fst", value); }
        }

        /// <summary>
        /// 一级分类名称(一级分类表)
        /// </summary>
		public string Fst_name {
            get { return getAttrVal<string>("Fst_name",null); }
            set { setAttrVal<string>("Fst_name", value); }
        }

        /// <summary>
        /// 一级分类最大分值(一级分类表)
        /// </summary>
		public double? Score_fstmax {
            get { return getAttrVal<FDouble>("Score_fstmax",null); }
            set { setAttrVal<FDouble>("Score_fstmax", value); }
        }

        /// <summary>
        /// 评分项目(质控项表)
        /// </summary>
		public string Req {
            get { return getAttrVal<string>("Req",null); }
            set { setAttrVal<string>("Req", value); }
        }

        /// <summary>
        /// 扣分类型(质控项表)
        /// </summary>
		public string Id_qa_drp_scr_tp {
            get { return getAttrVal<string>("Id_qa_drp_scr_tp",null); }
            set { setAttrVal<string>("Id_qa_drp_scr_tp", value); }
        }

        /// <summary>
        /// 单次扣分值(质控项表)
        /// </summary>
		public double? Once_drp_scr {
            get { return getAttrVal<FDouble>("Once_drp_scr",null); }
            set { setAttrVal<FDouble>("Once_drp_scr", value); }
        }

        /// <summary>
        /// 扣分标准(质控项表)
        /// </summary>
		public string Deduct_des {
            get { return getAttrVal<string>("Deduct_des",null); }
            set { setAttrVal<string>("Deduct_des", value); }
        }

        /// <summary>
        /// 扣分次数(评分表)
        /// </summary>
		public int? Deduct_scr_times {
            get { return getAttrVal<int?>("Deduct_scr_times",null); }
            set { setAttrVal<int?>("Deduct_scr_times", value); }
        }

        /// <summary>
        /// 扣分说明(评分表)
        /// </summary>
		public string Drp_des {
            get { return getAttrVal<string>("Drp_des",null); }
            set { setAttrVal<string>("Drp_des", value); }
        }

        /// <summary>
        /// 质控医生id(评分表)
        /// </summary>
		public string Id_sbmt_user {
            get { return getAttrVal<string>("Id_sbmt_user",null); }
            set { setAttrVal<string>("Id_sbmt_user", value); }
        }

        /// <summary>
        /// 质控医生(评分表)
        /// </summary>
		public string User_name {
            get { return getAttrVal<string>("User_name",null); }
            set { setAttrVal<string>("User_name", value); }
        }

        /// <summary>
        /// 质控类型(评分表)
        /// </summary>
		public string Id_qa_ty {
            get { return getAttrVal<string>("Id_qa_ty",null); }
            set { setAttrVal<string>("Id_qa_ty", value); }
        }

        /// <summary>
        /// 就诊id
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 自定义分类id(自动质控配置表)
        /// </summary>
		public string Id_mrcactm {
            get { return getAttrVal<string>("Id_mrcactm",null); }
            set { setAttrVal<string>("Id_mrcactm", value); }
        }

        /// <summary>
        /// 自动以分类名称(自动质控配置表)
        /// </summary>
		public string Mrcactm_name {
            get { return getAttrVal<string>("Mrcactm_name",null); }
            set { setAttrVal<string>("Mrcactm_name", value); }
        }

        /// <summary>
        /// 文书类型id(自动质控配置表)
        /// </summary>
		public string Id_mrtp {
            get { return getAttrVal<string>("Id_mrtp",null); }
            set { setAttrVal<string>("Id_mrtp", value); }
        }

        /// <summary>
        /// 文书类型名称(自动质控配置表)
        /// </summary>
		public string Mrtp_name {
            get { return getAttrVal<string>("Mrtp_name",null); }
            set { setAttrVal<string>("Mrtp_name", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_qascoredto", "Id_qa_itm", "Id_qa_auto", "Id_qa_divide", "Id_fst", "Fst_name", "Score_fstmax", "Req", "Id_qa_drp_scr_tp", "Once_drp_scr", "Deduct_des", "Deduct_scr_times", "Drp_des", "Id_sbmt_user", "User_name", "Id_qa_ty", "Id_ent", "Id_mrcactm", "Mrcactm_name", "Id_mrtp", "Mrtp_name"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.qascoredto.d.QaScoreDTO";
        }
    }
}
