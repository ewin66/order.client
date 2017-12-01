
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ordsrvmm.d;
using iih.common_stub.datong.data;
using iih.common_stub.datong;
using iih.ci.ord.ordsrvmm.i;
using xap.mw.serviceframework;
using iih.ci.ord.ciorder.d;
using xap.sys.permfw.user.d;
using xap.sys.orgfw.dept.d;
using iih.en.pv.dto.d;
using xap.rui.engine.registers;
using xap.rui.engine;
using iih.ci.ord.ems.d;
using xap.rui.bizcontrol.bannercontrol;
using iih.ci.diag.cidiag.d;
using iih.ci.diag_stub.i;
using iih.pi.iih.pi.overview.i;
using iih.pi.overview.overview.d;
using iih.ci.ord.i;
using xap.sys.xbd.udi.i;

namespace iih.ci.ord.opemergency.assi.rationaldrug.viewmodel
{
    /// <summary>
    /// <para>描    述 : 合理用药服务显示接口</para>
    /// <para>说    明 : </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.rationaldrug.viewmodel    </para>    
    /// <para>类 名 称 :  RationalDrugViewModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  hums</para> 
    /// <para>修 改 人 :  hums</para> 
    /// <para>创建时间 :  2016/9/24 9:45:39</para>
    /// <para>更新时间 :  2016/9/24 9:45:39</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class RationalDrugViewModel
    {

        /// <summary>
        /// 医嘱物品服务接口
        /// </summary>
        protected IOrdsrvmmCrudService orderSrvmmService;

        /// <summary>
        /// 获取过敏史、生理状况服务
        /// </summary>
        protected IPiOverviewQryService ipiQryService;

        /// <summary>
        /// 诊断接口
        /// </summary>
        protected ICidiagQryService cidiQryService;

        /// <summary>
        /// 医嘱功能查询接口
        /// </summary>
        protected ICiOrdQryService iCiOrdQryService;

        /// <summary>
        /// 查询SD字典项服务接口
        /// </summary>
        protected IUdidocCrudService udidocService;

        /// <summary>
        /// 患者过敏史，生理情况
        /// </summary>
        protected Dictionary<string, OverviewAggDO> overviewAggDic = new Dictionary<string, OverviewAggDO>();



        public RationalDrugViewModel()
        {           
            orderSrvmmService = XapServiceMgr.find<IOrdsrvmmCrudService>();

            cidiQryService = XapServiceMgr.find<ICidiagQryService>();

            ipiQryService = XapServiceMgr.find<IPiOverviewQryService>();

            iCiOrdQryService = XapServiceMgr.find<ICiOrdQryService>();

            udidocService = XapServiceMgr.find<IUdidocCrudService>();


        }

        #region 子类继承区

        /// <summary>
        /// 初始化合理用药
        /// </summary>
        public virtual void InitRationStatus()
        {

        }

        #region 要点提示

        /// <summary>
        /// 显示医嘱中对应药品说明书
        /// </summary>
        /// <param name="idOr">医嘱id</param>
        public virtual void ShowOrderDrugInstruction(string idOrsrv)
        {

        }

        /// <summary>
        /// 显示指定物品id对应的药品说明书
        /// </summary>
        /// <param name="idMm">药品id</param>
        public virtual void ShowDrugInstruction(string idOrsrvmm)
        {

        }

        /// <summary>
        /// 根据物品对象显示药品说明书
        /// </summary>
        /// <param name="ordSrvMm">药品对象</param>
        public virtual void ShowDrugInstruction(OrdSrvMmDO ordSrvMm)
        {

        }

        /// <summary>
        /// 显示要点提示信息
        /// </summary>
        /// <param name="codeMm">药品编码</param>
        /// <param name="nameMm">药品名称</param>
        public virtual void ShowDrugInstruction(string codeMm, string nameMm)
        {

        }

        #endregion

        #region 合理用药分析

        /// <summary>
        /// 合理用药分析
        /// </summary>
        /// <param name="ent4BannerDTO">banner数据对象</param>
        /// <param name="ciords">当前正在签署的医嘱集合</param>
        /// <param name="msg">提示信息</param>
        /// <returns></returns>
        public virtual int AnalysisPresResult(CiEnContextDTO ctxDTO, CiOrderDO[] ciords, out string msg)
        {

            msg = "";
            return 0;
        }

        #endregion


        #endregion

        /// <summary>
        /// 根据提示信息编码，获取提示信息
        /// </summary>
        /// <param name="msgCode"></param>
        /// <returns></returns>
        public virtual string GetSdMessage(string msgCode)
        {
            return "";
        }

        /// <summary>
        /// 获取本次就诊诊断明细
        /// </summary>
        /// <param name="idEn"></param>
        protected CiDiagItemDO[] getCiDiagItems(string idEn, string sdDitp)
        {
            return cidiQryService.getCiDiagItems(idEn, sdDitp);
        }

        /// <summary>
        /// 获取患者过敏史，生理状况
        /// </summary>
        /// <param name="patId"></param>
        protected OverviewAggDO GetAllergicHistory(String patId)
        {
            if (overviewAggDic.ContainsKey(patId)) {
                return overviewAggDic[patId];
            }

            OverviewAggDO overviewAgg =  ipiQryService.findAlAndPhyData(patId);
            overviewAggDic.Add(patId, overviewAgg);

            return overviewAgg;
        }

    }
}
