using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.service.d;
using iih.ci.ord.dto.orobsandlab.d;
using iih.ci.ord.i;
using xap.mw.serviceframework;
using xap.rui.control.tree.otree.data;

namespace iih.ci.ord.ciobs.viewmodel
{
    public class CiRptObsTreeViewModel
    {
        private ICiOrdQryService service;

        public OrObsAandLabDTO[] OrObsAandLab { get; set; }
        public OrObsAandLabDTO[] OrObsAandLabDate { get; set; }


        public CiRptObsTreeViewModel()
        {
            service = XapServiceMgr.find<ICiOrdQryService>();
        }
        //public CiRptObsTreeViewModel(string id_ent,string type):this()
        //{
       
        //    OrObsAandLab = service.getOrObsAandLabDTO(id_ent, type);
        //    OrObsAandLabDate = service.getObsAndLabDateList(id_ent, type);

        //}
        /// <summary>
        /// 
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="type"></param>
        /// <returns></returns>
        public OrObsAandLabDTO[] getOrObsAandLabDTO(string id_ent,string type)
        {
            return service.getOrObsAandLabDTO(id_ent,type);

        }


        public KeyNodeDataCollection getObsAndLabList
        {
            get
            {
                //目标数据
                KeyNodeDataCollection collection = new KeyNodeDataCollection();

                var moduleAdapter = new KeyNodeDataAdapterFactory<OrObsAandLabDTO>("Id", "Parent");
                //moduleAdapter.CustomCaptionFunc = (dataobj => string.Format("{0}{1}", dataobj.Code, dataobj.Name));
                moduleAdapter.CustomCaptionFunc = (dataobj => string.Format("{0}", dataobj.Name));
                //数据转换
                collection.ConvertAdd(this.OrObsAandLab, moduleAdapter);

                return collection;
            }

        }

        public KeyNodeDataCollection getObsAndLabListDate
        {
            get
            {
                //目标数据
                KeyNodeDataCollection collection = new KeyNodeDataCollection();

                var moduleAdapter = new KeyNodeDataAdapterFactory<OrObsAandLabDTO>("Id", "Parent");
                //moduleAdapter.CustomCaptionFunc = (dataobj => string.Format("{0}{1}", dataobj.Code, dataobj.Name));
                moduleAdapter.CustomCaptionFunc = (dataobj => string.Format("{0}", dataobj.Name));
                //数据转换
                collection.ConvertAdd(this.OrObsAandLabDate, moduleAdapter);

                return collection;
            }

        }
    }
}
