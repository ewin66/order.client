using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using System.Globalization;

namespace iih.ci.ord.ciorder.Validate
{
    class OrderApbtValidate : IValidate
    {
        public bool OrdValivate(EmsUIDTO uiDto, CiorderBaseControl ci)
        {
            List<string> errList = new List<string>();
            #region 女性年满18岁，生育史必填
            //if (uiDto.PatInfo.Sd_sex == "2" && uiDto.PatInfo.Dt_birth!=null) {
            //    DateTime dt = Convert.ToDateTime(uiDto.PatInfo.Dt_birth);
            //    int age = (DateTime.Now - dt).Days / 365;
            //    if (age >= 18 && (uiDto.Emsapbt.Parturition_cnt == null || uiDto.Emsapbt.Pregnat_num == null))
            //    {
            //        errList.Add("年满18岁的女性患者，生育史必填！");
            //    }
            //}
            #endregion
            //献血史勾选上后，献血证号必填
            //if (uiDto.Emsapbt.Fg_db != null && uiDto.Emsapbt.Fg_db==true && uiDto.Emsapbt.No_db == null)
            //{
            //    errList.Add("请填写献血证号！");
            //}

            if (uiDto.Emsapbt.Parturition_cnt != null && uiDto.Emsapbt.Parturition_cnt >0)
            {
                if (uiDto.Emsapbt.Pregnat_num <=0)
                errList.Add("生育史 孕不能小于0或等于0");
            }

            if (errList.Count > 0)
            {
                ci.OrdErrorList.AddRange(errList);
                return false;
            }
            return true;
        }
    }
}
