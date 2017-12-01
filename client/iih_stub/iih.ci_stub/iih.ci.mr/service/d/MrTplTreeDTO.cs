using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;

namespace iih.ci.mr.service.d
{
    public class MrTplTreeDTO : BaseDTO
    {
        public MrTplTreeDTO()
        {

        }

        public string id_mrtp
        {
            get { return getAttrVal<string>("id_mrtp", null); }
            set { setAttrVal<string>("id_mrtp", value); }
        }

        public string code
        {
            get { return getAttrVal<string>("code", null); }
            set { setAttrVal<string>("code", value); }
        }
        public string name
        {
            get { return getAttrVal<string>("name", null); }
            set { setAttrVal<string>("name", value); }
        }



        public String Id_parent
        {
            get { return getAttrVal<string>("Id_parent", null); }
            set { setAttrVal<string>("Id_parent", value); }
        }
        public String num
        {
            get { return getAttrVal<string>("num", null); }
            set { setAttrVal<string>("num", value); }
        }


        public override string[] getAttrNames()
        {
            return new string[] { "id_mrtp", "code", "name", "Id_parent", "num" };
        }
    }
}