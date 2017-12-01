using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.rui.control;
using xap.rui.control.extentions;
using xap.rui.engine;

namespace iih.ci.ord.ciordsysparam
{
    public class GetSysParamDTO : BaseDTO
    {
        private  BaseContext context ;
        private string SysParamCode;
        
        public GetSysParamDTO(BaseContext ctx,string sysParamCode)
        {
            this.context = ctx;
            this.SysParamCode = sysParamCode;
        }
       
       
        
        //public string DefaultParam
        //{

        //    get { return getAttrVal<string>("DefaultParam", null); }
        //    set { setAttrVal<string>("DefaultParam", value); }
        //}

      
        public string GlobalParam
        {
            get
            {
                if (string.IsNullOrEmpty(getAttrVal<string>("GlobalParam", null)))
                {
                    string paramvalue = context.GetGlobalParam<string>(SysParamCode);
                    setAttrVal<string>("GlobalParam", paramvalue);
                    return paramvalue;
                }
                else
                {
                    return getAttrVal<string>("GlobalParam", null);

                }
            }
            
        }


        public string GroupParam
        {
            get
            {
                if (string.IsNullOrEmpty(getAttrVal<string>("GroupParam", null)))
                {
                    string paramvalue = context.GetGroupParam<string>(SysParamCode);
                    setAttrVal<string>("GroupParam", paramvalue);
                    return paramvalue;
                }
                else
                {
                    return getAttrVal<string>("GroupParam", null);

                }
            }
        }


        public string OrgParam
        {
            get
            {
                if (string.IsNullOrEmpty(getAttrVal<string>("OrgParam", null)))
                {
                    string paramvalue = context.GetOrgParam<string>(SysParamCode);
                    setAttrVal<string>("OrgParam", paramvalue);
                    return paramvalue;
                }
                else
                {
                    return getAttrVal<string>("OrgParam", null);

                }
            }
        }

        public string DeptParam
        {
            get
            {
                if (string.IsNullOrEmpty(getAttrVal<string>("DeptParam", null)))
                {
                    string paramvalue = context.GetDeptParam<string>(SysParamCode);
                    setAttrVal<string>("DeptParam", paramvalue);
                    return paramvalue;
                }
                else
                {
                    return getAttrVal<string>("DeptParam", null);

                }
            }
        }

        public void Clear()
        {
            this.propStoreMap.Clear();
        }
    }
}
