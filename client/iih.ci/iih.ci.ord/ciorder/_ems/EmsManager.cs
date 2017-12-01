using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Runtime.CompilerServices;
using System.Text;
using System.Windows.Forms;
using iih.bd.srv.ems.d;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.service.i;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.ems;
using iih.ci.ord.ciorder.utils;
using iih.en.pv.dto.d;
using xap.mw.serviceframework;
using xap.rui.control.extentions;
using xap.rui.engine;
using iih.bd.srv.emsqry.d;
using iih.ci.ord.opemergency.tool;
using iih.bd.srv.ems.i;
using xap.mw.core.data;

namespace iih.ci.ord.ciorder._ems {
    /// <summary>
    /// 医疗单管理器类
    /// author:zhou_zhijian 
    ///        li_zheng 修改于2016.7.20 原因：
    /// reviewer:XXX
    /// </summary>
    public class EmsManager {

        #region 成员变量
        LogicEx logic = LogicEx.GetInstance();
        #endregion

        #region singleton

        private static EmsManager instance;

        public static EmsManager GetInstance() {
            if (instance == null) {
                lock (typeof(EmsManager)) {
                    instance = new EmsManager();
                }
            }
            return instance;
        }

        private EmsManager() {
            
        }
        #endregion

        /// <summary>
        /// 基于条件，查找匹配的医疗单的具体创建工厂对象;
        /// 针对住院的
        /// </summary>
        /// <param name="srv">医疗服务对象</param>
        /// <returns></returns>
        public EmsFactoryBase GetEmsFactory(MedSrvDO srv, BaseContext context, Ent4BannerDTO bannerDto) {
            string srvType = srv.Sd_srvtp;
            if (srvType.Length < 4) {
                throw new Exception(string.Format("服务类型有误长度不足4位！目前是{0},请检查", srvType));
            }

            EmsFactoryBase r = null;

            //缓存中没有，则实际获取，然后在缓存
            SrvMatchEmsParamDTO dto = EmsMatchTool.GetSrvMatchEmsParamDTO(context.Org.Id_org, context.Group.Id_grp, context.Dept.Id_dep, context.PsnInfo.Id_psndoc, bannerDto.Code_entp, srv.Sd_srvtp, srv.Id_srv, EmsAppModeEnum.IVEMSAPPMODE);
            SrvMatchEmsRstDTO matchResult = this.GetSrvMatchEmsParamDTO(dto);

            if (matchResult == null) {
                throw new Exception(
                    string.Format("服务类型{0}没有匹配到医疗单，请从检查医疗单维护节点检查配置信息", srvType));
            }

            string funcStr = matchResult.Funcclassstr;
            if (funcStr == null || funcStr == "") {
                throw new Exception(
                    string.Format("服务类型{0}对应的医疗单配置串为空，请从检查医疗单维护节点检查配置信息", srvType));
            }

            r = this.GetEmsFactoryFromFuncStr(funcStr);

            return r;
        }

        #region 私有函数
        /// <summary>
        /// 
        /// </summary>
        /// <param name="dto"></param>
        /// <returns></returns>
        private SrvMatchEmsRstDTO GetSrvMatchEmsParamDTO(SrvMatchEmsParamDTO dto)
        {
            //EmsMatchRstDTO r = bdSrvService.getmedSrvMatchEms(dto);
            IEmsManagementService service = XapServiceMgr.find<IEmsManagementService>();
            FMap map = service.medSrvMatchEms(new SrvMatchEmsParamDTO[] { dto });
            SrvMatchEmsRstDTO r = null;
            if (map != null)
            {
                r = (SrvMatchEmsRstDTO)map[dto.Id_srv];
            }
            return r;
        }

        /// <summary>
        /// 基于代表医疗单的的字符串反射创建对应的医疗单控件对象
        /// </summary>
        /// <param name="funcStr"></param>
        /// <returns></returns>
        private EmsFactoryBase GetEmsFactoryFromFuncStr(String funcStr) {
            EmsFunclassKVDTO funclassDTO = EmsMatchTool.GetEmsFunclassKVDTO(funcStr);
            string clazzStr = funclassDTO.Classpath_dll;
            string dllStr = funclassDTO.Dll;
            //String[] str = funcStr.Split(',');
            //string clazzStr = str[0];
            //string dllStr = str[1];
            try {
                //Assembly assembly = Assembly.LoadFrom(Application.StartupPath + "\\CiSheetPlus\\" + libName);
                Assembly assembly = Assembly.LoadFrom(Application.StartupPath + "\\" + dllStr);
                Type type = assembly.GetType(clazzStr);
                EmsFactoryBase r = (EmsFactoryBase)Activator.CreateInstance(type);
                return r;
            }
            catch //(Exception e)
            {
                throw new Exception(string.Format("反射{0}时出现异常", funcStr));
            }
        } 
        #endregion

    }
}
