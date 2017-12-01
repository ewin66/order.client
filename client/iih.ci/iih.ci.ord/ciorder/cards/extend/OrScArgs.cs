using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.ciorder.cards.extend
{
    public class OrScArgs
    {
        public string Id_item { get; set; }
        public string Name_item { get; set; }
        public object Obj { get; set; } // 服务使用
        public List<Object> listObj { get; set; }// 医嘱助手使用（或者其他集合）
    }
}
