using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;

namespace iih.ci.iih.ci.ord.dto.InsurDrugDivideInfoDTO.d
{
    public class InsurDrugDivideInfoDTO: BaseDTO {

        public InsurDrugDivideInfoDTO()
        {
 
        }


        public String getId_ent()
        {
            return ((String)getAttrVal("Id_ent"));
        }
        public void setId_ent(String Id_ent)
        {
            setAttrVal("Id_ent", Id_ent);
        }

        public String getId_pres()
        {
            return ((String)getAttrVal("Id_pres"));
        }
        public void setId_pres(String Id_pres)
        {
            setAttrVal("Id_ent", Id_pres);
        }

        public String getId_orsrv()
        {
            return ((String)getAttrVal("Id_orsrv"));
        }
        public void setId_orsrv(String Id_orsrv)
        {
            setAttrVal("Id_orsrv", Id_orsrv);
        }
        public String getId_srv()
        {
            return ((String)getAttrVal("Id_srv"));
        }
        public void setId_srv(String Id_srv)
        {
            setAttrVal("Id_srv", Id_srv);
        }
 


        /// <summary>
        /// 剂型
        /// </summary>
		public string Dose {
            get { return getAttrVal<string>("Dose",null); }
            set { setAttrVal<string>("Dose", value); }
        }

        /// <summary>
        /// 用法
        /// </summary>
		public string Howtouse {
            get { return getAttrVal<string>("Howtouse",null); }
            set { setAttrVal<string>("Howtouse", value); }
        }

        /// <summary>
        /// 单次用量
        /// </summary>
		public string Dosage {
            get { return getAttrVal<string>("Dosage",null); }
            set { setAttrVal<string>("Dosage", value); }
        }

        /// <summary>
        /// 包装单位
        /// </summary>
		public string Packaging {
            get { return getAttrVal<string>("Packaging",null); }
            set { setAttrVal<string>("Packaging", value); }
        }

        /// <summary>
        /// 最小包装
        /// </summary>
		public string Minpackage {
            get { return getAttrVal<string>("Minpackage",null); }
            set { setAttrVal<string>("Minpackage", value); }
        }

        /// <summary>
        /// 用药天数
        /// </summary>
		public string Days {
            get { return getAttrVal<string>("Days",null); }
            set { setAttrVal<string>("Days", value); }
        }

        /// <summary>
        /// 药品批准文字
        /// </summary>
		public string Drugapprovalnumber {
            get { return getAttrVal<string>("Drugapprovalnumber",null); }
            set { setAttrVal<string>("Drugapprovalnumber", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Id_ent", "Id_pres", "Id_orsrv", "Id_srv", "Dose", "Howtouse", "Dosage", "Packaging", "Minpackage", "Days", "Drugapprovalnumber" };
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.InsurDrugDivideInfoDTO.d.InsurDrugDivideInfoDTO";
        }
    }
}
