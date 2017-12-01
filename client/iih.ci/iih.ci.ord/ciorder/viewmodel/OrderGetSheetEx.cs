using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Reflection;
using System.Windows.Forms;
using iih.bd.srv.ems.d;
using iih.ci.ord.ciorcof.d;
using iih.ci.ord.ciorcof.viewmodel;
using iih.ci.ord.ciorder.utils;
using iih.bd.srv.emsqry.d;
using iih.ci.ord.opemergency.tool;
using xap.mw.serviceframework;
using iih.bd.srv.ems.i;
using xap.mw.core.data;

namespace iih.ci.ord.ciorder.viewmodel {

    /// <summary>
    /// 
    /// </summary>
    class OrderGetSheetEx {
        /// <summary>
        /// 
        /// </summary>
        CiOrdSrvVsSheetViewModel srvVsSheetModel = new CiOrdSrvVsSheetViewModel();
        /// <summary>
        /// 
        /// </summary>
        CiOrdSheetItemViewModel sheetModel = new CiOrdSheetItemViewModel();
        /// <summary>
        /// 
        /// </summary>
        LogicEx logic = LogicEx.GetInstance();

        /// <summary>
        /// 
        /// </summary>
        /// <param name="paramDto"></param>
        /// <returns></returns>
        public SrvMatchEmsRstDTO getSrvMatchEmsParamDTO(SrvMatchEmsParamDTO paramDto)
        {
            //EmsMatchRstDTO emsMatchRstDTO = sheetModel.getmedSrvMatchEms(paramDto);
            IEmsManagementService service = XapServiceMgr.find<IEmsManagementService>();
            FMap map = service.medSrvMatchEms(new SrvMatchEmsParamDTO[] { paramDto });
            SrvMatchEmsRstDTO r = null;
            if (map != null)
            {
                r = (SrvMatchEmsRstDTO)map[paramDto.Id_srv];
            }
            return r;
        }

        /// <summary>
        /// 基于代表医疗单的的字符串反射创建对应的医疗单控件对象
        /// </summary>
        /// <param name="Funcclassstr"></param>
        /// <returns></returns>
        public CiorderBaseControl GetCiorderBaseControl(String funcstr) {
            if (String.IsNullOrEmpty(funcstr)) new Exception("没有匹配到医疗单");
            EmsFunclassKVDTO funclassDTO = EmsMatchTool.GetEmsFunclassKVDTO(funcstr);
            string dllAssembly = funclassDTO.Classpath_dll;
            string libName = funclassDTO.Dll;
            //String[] str = Funcclassstr.Split(',');
            //string dllAssembly = str[0];
            //string libName = str[1];
            try {
                //Assembly assembly = Assembly.LoadFrom(Application.StartupPath + "\\CiSheetPlus\\" + libName);
                Assembly assembly = Assembly.LoadFrom(Application.StartupPath + "\\" + libName);
                Type type = assembly.GetType(dllAssembly);
                CiorderBaseControl canvas = (CiorderBaseControl)Activator.CreateInstance(type);

                return canvas;
            }
            catch //(Exception e)
            {
                throw new Exception("没有匹配到医疗单");
            }
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="strSdsrvtp"></param>
        /// <returns></returns>
        public CiorderBaseControl GetSheet(string strSdsrvtp) {
            CiOrdSheet sheet = GetSheetId(strSdsrvtp);
            if (sheet == null) 
                return null;

            string libName = sheet.Dll_model;
            string dllAssembly = sheet.Dll_assembly;
            try {
                Assembly assembly = Assembly.LoadFrom(Application.StartupPath + "\\CiSheetPlus\\" + libName);
                Type type = assembly.GetType(dllAssembly);
                CiorderBaseControl canvas = (CiorderBaseControl)Activator.CreateInstance(type);

                return canvas;
            }
            catch (Exception e) {
                throw new Exception(e.ToString());
            }
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="strSdsrvtp"></param>
        /// <returns></returns>
        CiOrdSheet GetSheetId(string strSdsrvtp) {
            string strsheetId = srvVsSheetModel.GetSeetIdBySdsrvtp(strSdsrvtp);
            return sheetModel.GetSheetById(strsheetId);
        }

    }

}
