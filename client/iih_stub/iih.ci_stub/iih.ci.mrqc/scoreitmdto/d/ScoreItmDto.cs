using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.scoreitmdto.d
{
    /// <summary>
    /// ScoreItmDto 的摘要说明。
    /// </summary>
    public class ScoreItmDto : BaseDTO {

        public ScoreItmDto() {
 
        }

        /// <summary>
        /// dto主键
        /// </summary>
		public string Id_dto {
            get { return getAttrVal<string>("Id_dto",null); }
            set { setAttrVal<string>("Id_dto", value); }
        }

        /// <summary>
        /// 评分主键
        /// </summary>
		public string Id_qa_divide {
            get { return getAttrVal<string>("Id_qa_divide",null); }
            set { setAttrVal<string>("Id_qa_divide", value); }
        }

        /// <summary>
        /// 质控项id
        /// </summary>
		public string Id_qa_itm {
            get { return getAttrVal<string>("Id_qa_itm",null); }
            set { setAttrVal<string>("Id_qa_itm", value); }
        }

        /// <summary>
        /// 评分项目
        /// </summary>
		public string Req {
            get { return getAttrVal<string>("Req",null); }
            set { setAttrVal<string>("Req", value); }
        }

        /// <summary>
        /// 一级分类id
        /// </summary>
		public string Id_fst {
            get { return getAttrVal<string>("Id_fst",null); }
            set { setAttrVal<string>("Id_fst", value); }
        }

        /// <summary>
        /// 一级分类名称
        /// </summary>
		public string Fst_name {
            get { return getAttrVal<string>("Fst_name",null); }
            set { setAttrVal<string>("Fst_name", value); }
        }

        /// <summary>
        /// 一级分类分值
        /// </summary>
		public double? Score {
            get { return getAttrVal<FDouble>("Score",null); }
            set { setAttrVal<FDouble>("Score", value); }
        }

        /// <summary>
        /// 扣分类型
        /// </summary>
		public string Id_qa_drp_scr_tp {
            get { return getAttrVal<string>("Id_qa_drp_scr_tp",null); }
            set { setAttrVal<string>("Id_qa_drp_scr_tp", value); }
        }

        /// <summary>
        /// 单词扣分值
        /// </summary>
		public double? Once_drp_scr {
            get { return getAttrVal<FDouble>("Once_drp_scr",null); }
            set { setAttrVal<FDouble>("Once_drp_scr", value); }
        }

        /// <summary>
        /// 扣分次数
        /// </summary>
		public int? Deduct_scr_times {
            get { return getAttrVal<int?>("Deduct_scr_times",null); }
            set { setAttrVal<int?>("Deduct_scr_times", value); }
        }

        /// <summary>
        /// 扣分标准
        /// </summary>
		public string Deduct_des {
            get { return getAttrVal<string>("Deduct_des",null); }
            set { setAttrVal<string>("Deduct_des", value); }
        }

        /// <summary>
        /// 扣分说明
        /// </summary>
		public string Drp_des {
            get { return getAttrVal<string>("Drp_des",null); }
            set { setAttrVal<string>("Drp_des", value); }
        }

        /// <summary>
        /// 质控医生id
        /// </summary>
		public string Id_sbmt_user {
            get { return getAttrVal<string>("Id_sbmt_user",null); }
            set { setAttrVal<string>("Id_sbmt_user", value); }
        }

        /// <summary>
        /// 质控医生
        /// </summary>
		public string User_name {
            get { return getAttrVal<string>("User_name",null); }
            set { setAttrVal<string>("User_name", value); }
        }

        /// <summary>
        /// 就诊id
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 质控类型
        /// </summary>
		public string Id_qa_ty {
            get { return getAttrVal<string>("Id_qa_ty",null); }
            set { setAttrVal<string>("Id_qa_ty", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_dto", "Id_qa_divide", "Id_qa_itm", "Req", "Id_fst", "Fst_name", "Score", "Id_qa_drp_scr_tp", "Once_drp_scr", "Deduct_scr_times", "Deduct_des", "Drp_des", "Id_sbmt_user", "User_name", "Id_ent", "Id_qa_ty"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.scoreitmdto.d.ScoreItmDto";
        }
    }
}
