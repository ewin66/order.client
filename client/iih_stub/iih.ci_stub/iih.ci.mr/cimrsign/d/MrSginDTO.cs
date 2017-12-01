using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.d
{
    /// <summary>
    /// MrSginDTO 的摘要说明。
    /// </summary>
    public class MrSginDTO : BaseDTO {

        public MrSginDTO() {
 
        }

        /// <summary>
        /// 流程任务
        /// </summary>
		public string Id_task {
            get { return getAttrVal<string>("Id_task",null); }
            set { setAttrVal<string>("Id_task", value); }
        }

        /// <summary>
        /// 任务状态
        /// </summary>
		public string State {
            get { return getAttrVal<string>("State",null); }
            set { setAttrVal<string>("State", value); }
        }

        /// <summary>
        /// 活动名称
        /// </summary>
		public string Nodeins_name {
            get { return getAttrVal<string>("Nodeins_name",null); }
            set { setAttrVal<string>("Nodeins_name", value); }
        }

        /// <summary>
        /// 审签人
        /// </summary>
		public string Id_owner {
            get { return getAttrVal<string>("Id_owner",null); }
            set { setAttrVal<string>("Id_owner", value); }
        }

        /// <summary>
        /// 文书
        /// </summary>
		public string Id_frmins {
            get { return getAttrVal<string>("Id_frmins",null); }
            set { setAttrVal<string>("Id_frmins", value); }
        }

        /// <summary>
        /// 创建类型
        /// </summary>
		public string Createtype {
            get { return getAttrVal<string>("Createtype",null); }
            set { setAttrVal<string>("Createtype", value); }
        }

        /// <summary>
        /// 医疗记录
        /// </summary>
		public string Id_mr {
            get { return getAttrVal<string>("Id_mr",null); }
            set { setAttrVal<string>("Id_mr", value); }
        }

        /// <summary>
        /// 文书名称
        /// </summary>
		public string Mr_name {
            get { return getAttrVal<string>("Mr_name",null); }
            set { setAttrVal<string>("Mr_name", value); }
        }

        /// <summary>
        /// 床号
        /// </summary>
		public string Mr_bed_name {
            get { return getAttrVal<string>("Mr_bed_name",null); }
            set { setAttrVal<string>("Mr_bed_name", value); }
        }

        /// <summary>
        /// 审签等级
        /// </summary>
		public string Reviewtp_name {
            get { return getAttrVal<string>("Reviewtp_name",null); }
            set { setAttrVal<string>("Reviewtp_name", value); }
        }

        /// <summary>
        /// 提交人
        /// </summary>
		public string Mr_modifiedby {
            get { return getAttrVal<string>("Mr_modifiedby",null); }
            set { setAttrVal<string>("Mr_modifiedby", value); }
        }

        /// <summary>
        /// 提交时间
        /// </summary>
		public string Mr_modifiedtime {
            get { return getAttrVal<string>("Mr_modifiedtime",null); }
            set { setAttrVal<string>("Mr_modifiedtime", value); }
        }

        /// <summary>
        /// 审签意见
        /// </summary>
		public string Mr_sign_suggestion {
            get { return getAttrVal<string>("Mr_sign_suggestion",null); }
            set { setAttrVal<string>("Mr_sign_suggestion", value); }
        }

        /// <summary>
        /// 患者
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 患者姓名
        /// </summary>
		public string Pat_name {
            get { return getAttrVal<string>("Pat_name",null); }
            set { setAttrVal<string>("Pat_name", value); }
        }

        /// <summary>
        /// 患者性别
        /// </summary>
		public string Pat_sex {
            get { return getAttrVal<string>("Pat_sex",null); }
            set { setAttrVal<string>("Pat_sex", value); }
        }

        /// <summary>
        /// 就诊
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 完成类型
        /// </summary>
		public string Finishtype {
            get { return getAttrVal<string>("Finishtype",null); }
            set { setAttrVal<string>("Finishtype", value); }
        }

        /// <summary>
        /// 任务类型
        /// </summary>
		public string Actiontype {
            get { return getAttrVal<string>("Actiontype",null); }
            set { setAttrVal<string>("Actiontype", value); }
        }

        /// <summary>
        /// 说明
        /// </summary>
		public string Opinion {
            get { return getAttrVal<string>("Opinion",null); }
            set { setAttrVal<string>("Opinion", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_task", "State", "Nodeins_name", "Id_owner", "Id_frmins", "Createtype", "Id_mr", "Mr_name", "Mr_bed_name", "Reviewtp_name", "Mr_modifiedby", "Mr_modifiedtime", "Mr_sign_suggestion", "Id_pat", "Pat_name", "Pat_sex", "Id_ent", "Finishtype", "Actiontype", "Opinion"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.d.MrSginDTO";
        }
    }
}
