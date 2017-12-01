
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciorder.ems;
using iih.bd.srv.medsrv.d;
using xap.rui.engine;
using iih.en.pv.dto.d;
using iih.bd.srv.service.i;
using iih.bd.srv.ems.d;
using System.Windows.Forms;
using System.Reflection;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.ems.dp;
using iih.ci.ord.opemergency.ems;
using xap.rui.control.basecontrol;
using xap.mw.serviceframework;
using xap.rui.control.extentions;
using iih.ci.ord.opemergency.view;
using iih.bd.srv.emsqry.d;
using iih.ci.ord.opemergency.tool;
using iih.bd.srv.ems.i;
using xap.mw.core.data;

namespace iih.ci.ord.opemergency.emsfactory
{
    /// <summary>
    /// <para>描    述 :  医疗单驱动管理类                   	</para>
    /// <para>说    明 :  单例模式                  			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.emsfactory    </para>    
    /// <para>类 名 称 :  EmsDriverFactory					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/7/18 15:56:02             </para>
    /// <para>更新时间 :  2016/7/18 15:56:02             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EmsDriverFactory
    {
        // 贪婪方式创建单间实体
        private static readonly EmsDriverFactory instance = new EmsDriverFactory();

        #region 单例模式构造函数约束
        private EmsDriverFactory() { }
        #endregion

        #region 获取实例对象入口
        public static EmsDriverFactory EmsDriverShare()
        {
            return instance;
        }


     
        public BaseEmsDriver DriverWith(String id_srv, String sd_srvtp, BaseFormBizView context, Ent4BannerDTO bannerDto)
        {
            BaseEmsDriver emsFactory = null;

            if (context.Context == null)
            {

                context.SetStatusMsg("Context 上下文信息为空，不能创建医疗单");
                return null;
            }

            if (context.Context.PsnInfo == null)
            {
                context.SetStatusMsg("Context 上下文登录用户信息为空，不能创建医疗单");
                return null;
            }
            
           //读取医疗单匹配信息
            SrvMatchEmsParamDTO dto = EmsMatchTool.GetSrvMatchEmsParamDTO(context.Context.Org.Id_org, context.Context.Group.Id_grp, context.Context.Dept.Id_dep, context.Context.PsnInfo.Id_psndoc, bannerDto.Code_entp, sd_srvtp, id_srv, EmsAppModeEnum.SVEMSAPPMODE);
            SrvMatchEmsRstDTO matchResult = this.GetSrvMatchEmsParamDTO(dto);

            if (matchResult == null)
            {
                context.SetStatusMsg(
                    string.Format("服务类型{0}没有匹配到合适的医疗单，请在【医疗单维护】节点中维护相关数据！", sd_srvtp));
                return null;
            }

            string funcStr = matchResult.Funcclassstr;
            if (String.IsNullOrEmpty(funcStr))
            {
                context.SetStatusMsg(
                    string.Format("服务类型{0}对应的医疗单配置串为空，请从医疗单维护节点检查配置信息,先使用治疗医疗单！", sd_srvtp));
                return null;
            }

            emsFactory = this.GetEmsFactoryFromFuncStr(funcStr);
            emsFactory.Initialize(context, bannerDto, matchResult);

            return emsFactory;
        }
        #endregion

        #region 私有函数
        /// <summary>
        /// 创建默认的医疗单
        /// </summary>
        /// <param name="emsFactory"></param>
        /// <param name="context"></param>
        /// <param name="bannerDto"></param>
        /// <returns></returns>
        private BaseEmsDriver creatDefaultEmsDriver(BaseEmsDriver emsFactory, BaseFormBizView context, Ent4BannerDTO bannerDto)
        {
            emsFactory = this.GetEmsFactoryFromFuncStr("iih.ci.ord.opemergency.emsfactory.EmsTreatDriver,iih.ci.ord.dll,8");
           
            return emsFactory.Initialize(context, bannerDto, null); 
        }

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
        private BaseEmsDriver GetEmsFactoryFromFuncStr(String funcStr, object[] szParam = null)
        {
            EmsFunclassKVDTO funclassDTO = EmsMatchTool.GetEmsFunclassKVDTO(funcStr);
            string clazzStr = funclassDTO.Classpath_dll;
            string dllStr = funclassDTO.Dll;

            //String[] str = funcStr.Split(',');
            //string clazzStr = str[0];
            //string dllStr = str[1];
            try
            {
                //Assembly assembly = Assembly.LoadFrom(Application.StartupPath + "\\CiSheetPlus\\" + libName);
                Assembly assembly = Assembly.LoadFrom(Application.StartupPath + "\\" + dllStr);
                Type type = assembly.GetType(clazzStr);
                BaseEmsDriver r = (szParam == null ? (BaseEmsDriver)Activator.CreateInstance(type) : (BaseEmsDriver)Activator.CreateInstance(type, szParam));
                return r;
            }
            catch //(Exception e)
            {
                throw new Exception(string.Format("反射{0}时出现异常", funcStr));
            }
        }
        #endregion

        #region 内存清理
        public void Clear()
        {
            //srvTypeEmsFuncStrMap.Clear();
            //emsDict.Clear();
        }
        #endregion

    }
}
