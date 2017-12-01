using iih.ci.ord.opemergency.tool;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.control.basecontrol;
using xap.rui.engine;
using xap.rui.engine.registers;

namespace iih.ci.ord.opemergency.view.basic
{
    /// <summary>
    /// 前端业务基础类
    /// </summary>
    public class BaseBizView : XapBaseControl, IEventDelegate, IXEventPublication
    {
        /// <summary>
        /// 代理接口
        /// </summary>
        private IEventDelegate eventDelegate = null;

        #region 构造函数

        public BaseBizView()
        {
            InitializeBizView();
        }

        public BaseBizView(IEventDelegate o)
        {
            this.eventDelegate = o;

            InitializeBizView();
        }

        #endregion

        protected virtual void InitializeBizView()
        {

        }
        public IEventDelegate GetEventDelegate()
        {
            return eventDelegate ;
        }

        public virtual bool OnChildNotify(object sender, DictionaryEventArgs e)
        {
            return (GetEventDelegate() != null && GetEventDelegate().OnChildNotify(sender, e));
        }

        public virtual bool OnEventHandle(object sender, DictionaryEventArgs e)
        {
            return true;
        }

        public virtual bool OnEventSelected(object sender, object bannerData)
            {
            return false;
            }
            

        /// <summary>
        /// <para> 消息通知 </para>
        /// </summary>
        /// <param name="uiEventCode"></param>
        /// <param name="dataTag"></param>
        /// <param name="objData"></param>
        /// <param name="param"></param>
        public void SentMessage(string uiEventCode, string dataTag = null, Object objData = null, object param = null)
        {
            AssToolEx.SentMessage(this, uiEventCode, dataTag, objData, param);
        }

        public bool SentNotify(string uiEventCode, string dataTag = null, Object objData = null, object param = null)
        {
            return this.OnChildNotify(this, AssToolEx.DictionaryEventArgsWith(uiEventCode, dataTag, objData, param));
        }

        #region 对象链方法
        public BaseBizView And()
        {
            return this;
        }

        public T Add<T>() where T : BaseBizView
        {
            return (T)this;
        }

        public virtual BaseContext GetContext()
        {
            return eventDelegate.GetContext();
        }
        #endregion
    }
}
