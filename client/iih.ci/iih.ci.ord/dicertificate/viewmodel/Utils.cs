using xap.sys.xbd.udi.d;
using xap.sys.xbd.udi.i;
using xap.mw.serviceframework;

/********************************************************************************

** 作者： 杨敬本

** 创始时间：2016/6/24 10:51:17

** 修改人：杨敬本

** 修改时间：2016/7/4 10:51:17

** 描述：通用静态类


*********************************************************************************/

namespace iih.ci.ord.dicertificate.viewmodel
{
    public static class Utils
    {
        public const string SELECTROOT = "SelectRoot";


        public const string SELECTROW = "SelectRow";
        public const string SELECTROWONLYNEW = "SelectRowOnlyNew";
        public const string SELECTROWONLYPRINTED = "SelectRowOnlyPrinted";
        public const string SELECTROWONLYSAVED = "SelectRowOnlySaved";
        public const string SELECTROWNOTONLY = "SelectRowNotOnly";
        public const string SELECTROWITEM = "SelectRowItem";

        public const string TOADD = "ToAdd";
        public const string TOSAVE = "ToSave";
        public const string SAVESUCESS = "SaveSucess";
        public const string PRINTSUCESS = "PrintSucess";

        /// <summary>
        /// 获取UdidocDOList
        /// </summary>
        /// <param name="code">编码</param>
        /// <returns>UdidocDO[]</returns>
        public static UdidocDO[] GetUdidocDOList(string code)
        {
            IUdidocServiceExt udidoc_service = XapServiceMgr.find<IUdidocServiceExt>();
            UdidocDO[] docList = udidoc_service.findByUdidoclistCode(code);
            return docList;
        }
    }
}
