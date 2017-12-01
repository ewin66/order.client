using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.ciorder.render.common
{
    class OrdStrUtil
    {
        public static string OrdStrMosaic(params string[] nikename)
        {
            string rst = "";
            int i = 0;
            foreach(string name in nikename){
                if (!string.IsNullOrEmpty(name)) {
                    if (i== 0)
                    {
                        rst += ",￥" + name;
                    }
                    else {
                        rst += "," + name;
                    }
                }
                i++;
            }
            if (rst.Length > 0) {
                rst = "("+rst.Substring(1)+")";
            }
            return rst;
        }
    }
}
