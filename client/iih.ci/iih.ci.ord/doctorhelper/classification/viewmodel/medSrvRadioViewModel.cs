using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.medsrv.i;
using iih.ci.ord.i;
using xap.mw.serviceframework;
using xap.rui.appfw;
using iih.en.pv.dto.d;
using xap.mw.core.data;
/********************************************************************************

** 作者： 李政

** 创始时间：2016-6-30

** 修改人：李政

** 修改时间：2016-6-30

** 描述： 分类数据


*********************************************************************************/
namespace iih.ci.ord.doctorhelper.classification.viewmodel
{
    public class medSrvRadioViewModel
    {
        //private IMedsrvCrudService aggService;
        private IMedsrvMDOCrudService service;
        private ICiOrdQryService qryService;
        /// <summary>
        /// 不可用服务id集合，key不可用的服务id，value 不可用原因
        /// </summary>
        public FMap2 SrvStatusMap { get; set; }
        public XapDataList<MedSrvDO> medSrvDOList { get; set; }
        public XapDataList<MedSrvDO> medSrvDOListPyCode { get; set; }
        /// <summary>
        /// 数据源
        /// </summary>
        public FMap2 medSrvDOMap { get; set; }
        public medSrvRadioViewModel(string code_entp ,string fgUse , string strWhere)
        {
            this.service = XapServiceMgr.find<IMedsrvMDOCrudService>();
            this.qryService = XapServiceMgr.find<ICiOrdQryService>();
            if (string.IsNullOrEmpty(strWhere))
            {
                return;
            }
            //medSrvDOList = qryService.getClassMedSrvDOS("  a0.fg_active='Y' and a0.fg_or ='Y' and  a0.Id_srvca = '" + strWhere + "' and "+ fgUse +"='Y'", "Id_srvca",false);

            medSrvDOMap = qryService.getClassMedSrvMap(code_entp, "  a0.fg_active='Y' and a0.fg_or ='Y' and  a0.Id_srvca = '" + strWhere + "' and " + fgUse + "='Y'", "Id_srvca");

            // medSrvDOList.AddRange( map["medSrvList"] as XapDataList<MedSrvDO>);
            SrvStatusMap = medSrvDOMap["srvStatusMap"] as FMap2;



            FArrayList2 objList = medSrvDOMap["medSrvList"] as FArrayList2;
            if (objList!=null)
            {
                medSrvDOList = (XapDataList<MedSrvDO>)objList.Cast<MedSrvDO>().ToArray();
            }

            //medSrvDOList = service.find("  a0.fg_active='Y' and  a0.Id_srvca = '" + strWhere + "'", "Id_srvca", false);
            if (medSrvDOList != null && medSrvDOList.Count > 0)
            {
                medSrvDOListPyCode = new XapDataList<MedSrvDO>();
                foreach (MedSrvDO medSrv in medSrvDOList)
                {
                    if (medSrv.Id_srv == null)
                    {
                        medSrvDOListPyCode.Add(medSrv);
                    }
                }
            }
        }
    }
}
