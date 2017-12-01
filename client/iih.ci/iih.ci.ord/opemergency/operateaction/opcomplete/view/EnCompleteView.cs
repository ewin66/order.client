
using iih.ci.ord.opemergency.operateaction.baseoperate;
using iih.ci.ord.opemergency.operateaction.dto;
using iih.en.pv.i;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.serviceframework;

namespace iih.ci.ord.opemergency.operateaction.opcomplete.view
{
    /// <summary>
    /// <para>描    述 :  诊毕结束事件</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.operateaction.opcomplete.view</para>    
    /// <para>类 名 称 :  EnCompleteView</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/10/28 19:37:11</para>
    /// <para>更新时间 :  2016/10/28 19:37:11</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EnCompleteView : AbstractActionHandler
    {

        /// <summary>
        /// 就诊服务接口
        /// </summary>
        private IEnOutCmdService ienOutCmdService;

        public EnCompleteView() {
            ienOutCmdService = XapServiceMgr.find<IEnOutCmdService>();
        }
               
        /// <summary>
        /// 执行诊毕操作，并调用下一个处理环节
        /// </summary>
        /// <param name="request"></param>
        protected override void DoSendAction(RequestParam request, ResponseParam response)
        {
            string idEnt = request.ent4BannerDTO.Id_ent;
            ienOutCmdService.DiagnoseFinish(idEnt);
            // 诊毕结束掉下一个链中下一个处理节点
            this.DoReceiveAction(request, response);
        }
    }
}
