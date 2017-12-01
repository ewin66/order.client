using iih.ci.ord.dto.orobsandlab.d;
using iih.ci.ord.i;
using xap.mw.serviceframework;
using xap.rui.control.tree.otree.data;

namespace iih.ci.ord.cilab.viewmodel
{
    public class CiRptLabTreeViewModel
    {
        private readonly ICiOrdQryService service;

        public CiRptLabTreeViewModel()
        {
            service = XapServiceMgr.find<ICiOrdQryService>();
        }

        public OrObsAandLabDTO[] OrObsAandLab { get; set; }
        public OrObsAandLabDTO[] OrObsAandLabDate { get; set; }


        public KeyNodeDataCollection getObsAndLabList
        {
            get
            {
                //目标数据
                var collection = new KeyNodeDataCollection();

                var moduleAdapter = new KeyNodeDataAdapterFactory<OrObsAandLabDTO>("Id", "Parent");
                //moduleAdapter.CustomCaptionFunc = (dataobj => string.Format("{0}{1}", dataobj.Code, dataobj.Name));
                moduleAdapter.CustomCaptionFunc = (dataobj => string.Format("{0}", dataobj.Name));
                //数据转换
                collection.ConvertAdd(OrObsAandLab, moduleAdapter);

                return collection;
            }
        }

        public KeyNodeDataCollection getObsAndLabListDate
        {
            get
            {
                //目标数据
                var collection = new KeyNodeDataCollection();

                var moduleAdapter = new KeyNodeDataAdapterFactory<OrObsAandLabDTO>("Id", "Parent");
                //moduleAdapter.CustomCaptionFunc = (dataobj => string.Format("{0}{1}", dataobj.Code, dataobj.Name));
                moduleAdapter.CustomCaptionFunc = (dataobj => string.Format("{0}", dataobj.Name));
                //数据转换
                collection.ConvertAdd(OrObsAandLabDate, moduleAdapter);

                return collection;
            }
        }

        /// <summary>
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="type"></param>
        /// <returns></returns>
        public OrObsAandLabDTO[] getOrObsAandLabDTO(string id_ent, string type)
        {
            return service.getOrObsAandLabDTO(id_ent, type);
        }
    }
}