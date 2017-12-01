using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.medsrv.i;
using iih.ci.diag.cidiag.d;
using iih.ci.diag.cidiag.i;
using iih.ci.ord.i;
using iih.en.pv.entdi.d;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.sys.xbd.udi.d;
using xap.sys.xbd.udi.i;
using iih.ci.diag_stub.i;


namespace iih.ci.ord.ciorder.viewmodel.impext {
    /// <summary>
    /// 获取患者诊断接口
    /// zhou_zhijian 7.3做阅读注释
    /// </summary>
    public class GetPatDiagImp {
        #region 成员变量
        /// <summary>
        /// 
        /// </summary>
        ICidiagCrudService service;
        /// <summary>
        /// 
        /// </summary>
        private ICiOrdQryService ciOrdQryService;
        /// <summary>
        /// 
        /// </summary>
        private IMedSrvRisDOCrudService srvRisDoCrudService;
        /// <summary>
        /// 
        /// </summary>
        private IUdidocCrudService udidocCrudService;
        /// <summary>
        /// 诊断查询service
        /// </summary>
        private ICidiagQryService diagQryService;
        #endregion

        #region 构造
        public GetPatDiagImp() {
            service = XapServiceMgr.find<ICidiagCrudService>();
            this.srvRisDoCrudService = XapServiceMgr.find<IMedSrvRisDOCrudService>();
            this.udidocCrudService = XapServiceMgr.find<IUdidocCrudService>();
            this.ciOrdQryService = XapServiceMgr.find<ICiOrdQryService>();
            this.diagQryService = XapServiceMgr.find<ICidiagQryService>();
        } 
        #endregion

        /// <summary>
        /// 根据就诊号查询当前诊断
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="mainDi"></param>
        /// <returns></returns>
        public string getEntDiDOList(String id_ent, string code_entp,ref string[] mainDi) {
            //EntDiDO[] dis = ciOrdQryService.getEntDiDOList(id_ent);
            CiDiagItemDO cidiagitemdo = diagQryService.getCiDiagItemDO(id_ent, code_entp);
            if (cidiagitemdo == null)
            {
                mainDi[0] = "";
                mainDi[1] = "";
                return "";
            }
            else {
                mainDi[0] = cidiagitemdo.Id_diitm;
                mainDi[1] = cidiagitemdo.Id_didef_name;
            }
            return "'" + cidiagitemdo.Id_diitm + "'";
        }
        /// <summary>
	    ///本次就诊的就诊数组 （诊断编码和诊断名称）
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        public string[] getDiagArray(string id_ent) {
            return ciOrdQryService.getDiagArray(id_ent);
        }
        /// <summary>
        /// 
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="id_didef"></param>
        /// <param name="mainDi"></param>
        /// <returns></returns>
        public string getDiName(String id_ent, String id_didef, ref string[] mainDi) {
            EntDiDO[] dis = ciOrdQryService.getEntDiDOList(id_ent);
            if (dis == null || dis.Length == 0) return null;
            EntDiDO maindi = dis.FirstOrDefault(x => x.Id_didef_dis == id_didef);
            if (maindi != null) {
                mainDi[0] = maindi.Id_entdi;
                mainDi[1] = maindi.Name_didef_dis;
            }
            else {
                mainDi[0] = dis[0].Id_entdi;
                mainDi[1] = dis[0].Name_didef_dis;
            }
            return null;
        }


        /// <summary>
        /// 检查项目属性 床旁标志
        /// </summary>
        /// <param name="id_srv"></param>
        /// <returns></returns>
        public MedSrvRisDO getBdSrvObs(string id_srv) {
            if (id_srv != null) {
                MedSrvRisDO[] medSrvRisDo = this.srvRisDoCrudService.find("a2.id_srv ='" + id_srv + "'", "id_srv", FBoolean.False);
                if (medSrvRisDo != null && medSrvRisDo.Length > 0) {
                    return medSrvRisDo[0];
                }
            }
            return null;
        }

        /// <summary>
        /// 检查目的 
        /// </summary>
        /// <returns></returns>
        public UdidocDO getBdUdidocList() {
            UdidocDO[] udidoc = this.udidocCrudService.find("id_udidoclist ='0001ZZ20000000000075'", "", FBoolean.False);
            if (udidoc != null && udidoc.Length > 0) {
                return udidoc[0];
            }
            return null;
        }

        #region 无用的
        //public string GetDisById(string id_en)
        //{
        //   CidiagAggDO[] aggs= service.find(string.Format("id_ent='{0}'", id_en), "", false);
        //    string id_dis="'";
        //    aggs.ToList().ForEach(p=>{id_dis += string.Join(",", p.getCiDiagItemDO().Select(pc => pc.Id_di))+"','"; });
        //    return id_dis.Substring(0,id_dis.Length-2);
        //} 
        #endregion
    }
}
