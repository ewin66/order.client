
using iih.bd.srv.ortpl.d;
using iih.bd.srv.ortpl.i;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.i;
using iih.ci.ord.moreemsdto.d;
using iih.en.pv.dto.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.engine;

namespace iih.ci.ord.opemergency.assi.asscommon.viewmodel
{
    /// <summary>
    /// <para>描    述 :  助手中医嘱、医嘱模板相关操作</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.asscommon.viewmodel</para>    
    /// <para>类 名 称 :  AssistantCiOrderViewModel</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/10/21 18:16:28</para>
    /// <para>更新时间 :  2016/10/21 18:16:28</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class AssistantCiOrderViewModel
    {
        /// <summary>
        /// banner对象
        /// </summary>
        public Ent4BannerDTO ent4BannerDTO { get; set; }
        /// <summary>
        /// 当前环境
        /// </summary>
        public BaseContext context { get; set; }

        //医嘱模板服务接口
        private IOrtmplCrudService ortmplService;
        // 公共医嘱查询相关接口
        private ICiOrdQryService ciOrdQryService;

        public AssistantCiOrderViewModel()
        {
            ortmplService = XapServiceMgr.find<IOrtmplCrudService>();
            ciOrdQryService = XapServiceMgr.find<ICiOrdQryService>();
        }

        /// <summary>
        /// 保存医疗服务、医嘱模板
        /// </summary>
        /// <param name="mkrMsSrvDOList">医疗服务集合</param>
        /// <param name="mkrMsMrtplDOList">医嘱模板集合</param>
        public MoreEmsParamDTO SaveOrderAndOrtmpl(FArrayList mkrMsSrvDOList, FArrayList mkrMsMrtplDOList)
        {

            if (this.ent4BannerDTO == null)
            {
                return null;
            }

            return ciOrdQryService.getMkrMsMoreEmsParam(mkrMsSrvDOList, mkrMsMrtplDOList, this.ent4BannerDTO);
        }
    }
}
