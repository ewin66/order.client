using iih.ci.ord.doctorhelper.classification.view;
using xap.rui.engine;
using iih.bd.srv.srvcate.d;
using xap.rui.control.basecontrol;
using iih.ci.ord.ciorder.render;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.opemergency.ems.common;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.bd.srv.medsrv.d;
using System.Collections.Generic;
using iih.ci.ord.opemergency.declare;

namespace iih.ci.ord.opemergency.view
{
    /// <summary>
    /// <para>描    述 : 服务录入-分类分类选取-视图             </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.view       </para>    
    /// <para>类 名 称 : AssMedSrvCatgItemView             </para> 
    /// <para>版 本 号 : v1.0.0.0                          </para> 
    /// <para>作    者 : qzwang                            </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05                </para>
    /// <para>修 改 人 :                                   </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05                </para> 
    /// <para>说    明 :                                   </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class AssMedSrvCatgItemView : medSrvRadioView
    {
        private XapBaseControl ownerView = null;
        public override void OnSelected(object sender, TargetEventArgs e)
        {
            // 接受选中树的数据

            if (sender is AssMedSrvCatgTreeView)
            {
                if (e.Object is SrvCateDO)
                {
                    this.Id_srvca = (e.Object as SrvCateDO).Id_srvca;
                    LoadData();
                }
            }            
        }

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {

                case UIEvent.SAVE_SUCCESS:

                    break;
                default:
                    break;
            }
        }

        protected override ciorder.render.OrderRender createOrderRender()
        {
            return new OrderRender(this, true);
        }

        protected override void ThreadRender_Checkchanged(OrderRender render, bool flag)
        {
            base.ThreadRender_Checkchanged(render, flag);
            if (this.ownerView != null && render.ObjDo is MedSrvDO)
            {
                List<EmsCreatedParameter> paramList = new List<EmsCreatedParameter>();
                paramList.Add(new EmsCreatedParameter(render.ObjDo as MedSrvDO, null));

                AssToolEx.SentMessage(this.ownerView, EventCodeType.EVENT_EMS_CREATE, EmsCreatedParameter.TAGKEYLIST, paramList);
            }
        }

        public void setOwnerView(XapBaseControl ctrl)
        {
            this.ownerView = ctrl;
        }

  
    }
}
