using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.opemergency.view;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using xap.cli.sdk.render;
using iih.ci.ord.opemergency.declare;
using iih.ci.ord.opemergency.view.basic;

namespace iih.ci.ord.opemergency.ems.common
{
    /// <summary>
    /// <para>描    述 :  医疗单按钮组数据项        			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.ems.common    </para>    
    /// <para>类 名 称 :  EmsButtonViewCardItem					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  8/3/2016 11:53:31 AM             </para>
    /// <para>更新时间 :  8/3/2016 11:53:31 AM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    
    public class EmsButtonViewCardItem
    {
        private String title;
        private String nmEvent;
        private Object param;
        public EmsButtonViewCardItem(String title, String nmEvt, Object p = null)
        {
            this.title = title;
            this.nmEvent = nmEvt;
            this.param = p;
        }

        public String GetTitle()
        {
            return this.title;
        }

        public String GetNmEvent()
        {
            return this.nmEvent;
        }

        public Object GetParam()
        {
            return this.param;
        }
    }

    /// <summary>
    /// <para>描    述 :  医疗单按钮组         			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.ems.common    </para>    
    /// <para>类 名 称 :  EmsButtonViewCard					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  8/3/2016 11:53:31 AM             </para>
    /// <para>更新时间 :  8/3/2016 11:53:31 AM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class BaseButtonGroupView : BaseFormBizView
    {
        private EmsButtonViewCardItem[] szButtonSchema = null;
        private List<XButton> emsButtonList = new List<XButton>();
        private Size buttonSize = new Size(80,24);
        private int hOffset = 8;
        public BaseButtonGroupView(BaseFormBizView o, EmsButtonViewCardItem[] szButton = null):base(o)
        { 
            this.Load += EmsButtonViewCard_Load;
            szButtonSchema = szButton;
        }

        protected override void InitializeBizView()
        {
            // 禁止基类初始化XapFormControl对象
            //base.InitializeBizView();
        }
        /// <summary>
        /// 设置焦点到按钮
        /// </summary>
        /// <param name="index"></param>
        /// <param name="isFocus"></param>
        protected void SetButtonFocus(int index,bool isFocus = true)
        {
            if (index > emsButtonList.Count-1)return;
            emsButtonList[index].Focus();
            emsButtonList[index].FlagKeyGetFocus = true;
        }

        void EmsButtonViewCard_Load(object sender, EventArgs e)
        {
 	        if (szButtonSchema != null)
            {
                this.AddItems(szButtonSchema);
                
            }
        }

        public BaseButtonGroupView AddItem(EmsButtonViewCardItem item)
        {
            XButton btn = new XButton() { Text = item.GetTitle(), TipText = item.GetTitle(), Location = new Point(0,0), Size = buttonSize,ValueObj = item.GetNmEvent() };
            btn.MouseClick += OnMouseClick;
            this.emsButtonList.Add(btn);
            this.AddRender(btn);
            return this;
        }

        void OnMouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            this.SentNotify((sender as XButton).ValueObj as String);
        }

        public BaseButtonGroupView AddItems(EmsButtonViewCardItem[] items)
        {
            if (null != items)
            {
                items.ToList().ForEach(item =>
                {
                    this.AddItem(item);
                });
            }
            //this.AdjustLayout();
            return this;
        }

        public int GetCount()
        {
            return this.emsButtonList.Count;
        }

        public void Clear()
        {
            this.emsButtonList.Clear();
        }

        //public override void OnActiveForm()
        //{
        //    base.OnActiveForm();

        //    this.AdjustLayout();
        //}

        public override BaseFormBizView AdjustLayout()
        {
            // 居左
            int lx = hOffset;
            int ly = (this.Size.Height - this.buttonSize.Height) / 2;
            // 居中
            int cx = (this.Size.Width - this.GetCount() * buttonSize.Width - (this.GetCount() + 1) * hOffset) / 2;
            int cy = (this.Size.Height - this.buttonSize.Height) / 2;
            // 居右
            int rx = this.Size.Width - (this.buttonSize.Width + hOffset) * this.GetCount();
            int ry = (this.Size.Height - this.buttonSize.Height) / 2;

            int x = rx, y = ry;
            foreach(XButton item in this.emsButtonList)
            {
                item.Location = new Point(x,y);
         
                x += (hOffset + item.Size.Width);
            }
            this.Invalidate();
            return this;
        }

        public override void SetDataPolicy(bool flag)
        {
            this.emsButtonList.ForEach(item => {
                if (!item.ValueObj.Equals(EventCodeType.NM_EMS_CLOSE) && !item.ValueObj.Equals(EventCodeType.NM_EMS_APBU_ADD))
                {
                    item.Enabled = flag;
                }
            });
        }

        public override bool OnEventHandle(object sender, xap.rui.engine.DictionaryEventArgs e)
        {
            switch (AssToolEx.EventCodeOfEventArgs(e))
            {
                case EventCodeType.EVENT_EMS_DISABLE_EDIT:
                    SetDataPolicy(false);
                    break;
                case EventCodeType.EVENT_EMS_ALLOW_EDIT:
                    SetDataPolicy(true);
                    break;
                default:
                    break;
            }
            return base.OnEventHandle(sender, e);
        }

    }
}
