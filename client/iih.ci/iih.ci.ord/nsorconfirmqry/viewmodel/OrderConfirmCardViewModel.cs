using iih.ci.ord.ciordems.d;
using iih.ci.ord.i;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.sys.xbd.udi.d;
using xap.sys.xbd.udi.i;

/*
********************************************************************************

** 作者： 李程

** 创始时间：2016-6-30

** 修改人：李程

** 修改时间：2016-6-30

** 描述： 医嘱确认显示页面


*********************************************************************************
*/

namespace iih.ci.ord.nsorconfirmqry.viewmodel
{
    public class OrderConfirmCardViewModel
    {
        private readonly ICiOrdQryService qryservice;
        private readonly IUdidocServiceExt usService;

        public OrderConfirmCardViewModel()
        {
            orConfirm = new OrConfirm();
            orConfirm.Fg_sign = FBoolean.False;
            orConfirm.Fg_canc = FBoolean.False;
            orConfirm.Fg_stop = FBoolean.False;
            qryservice = XapServiceMgr.find<ICiOrdQryService>();
            usService = XapServiceMgr.find<IUdidocServiceExt>();
        }

        public OrConfirm orConfirm { get; set; }
        public UdidocDO[] Udis { get; set; }

        public void GetSrvCa(string udicode)
        {
            Udis = usService.findByUdidoclistCode(udicode);
        }

        /// <summary>
        ///     查询是否是大病区
        /// </summary>
        /// <param name="id_dep"></param>
        /// <returns></returns>
        public bool checkDep(string id_dep)
        {
            bool b = false;
            string a = qryservice.getDepsNum(id_dep);
            if (a == "Y")
            {
                b = true;
            }
            else if (a == "N")
            {
            }
            return b;
        }
    }
}