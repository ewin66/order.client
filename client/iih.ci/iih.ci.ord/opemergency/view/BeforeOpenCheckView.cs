using iih.ci.ord.opemergency.tool;
using xap.cli.context.events;
using xap.rui.control.extentions;
using xap.rui.engine;
using xap.rui.engine.func;

namespace iih.ci.ord.opemergency.view
{
    public class BeforeOpenCheckView : IBeforeOpenFunc
    {
        public bool CanOpenFunc()
        {
            BaseContext context=new BaseContext();
            if (context.PsnInfo != null && context.PsnInfo.Id_psndoc!=null)
            {
                if (!AssToolEx.GetPsnPresRt(context.PsnInfo.Id_psndoc))
                {
                    this.ShowInfo("您的医生执业信息不全，请联系医务处进行维护");
                    XapEvents.CloseFuncEvent(this, new CloseFuncEventArgs(context.FunCode));
                    return false;
                }
            }
            return true;
        }
    }
}
