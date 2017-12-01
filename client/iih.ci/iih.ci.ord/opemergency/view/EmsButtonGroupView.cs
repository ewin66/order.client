
using iih.ci.ord.opemergency.controls;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.opemergency.view.basic;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.cli.sdk.controls;
using xap.rui.engine;
using iih.ci.ord.opemergency.declare;

namespace iih.ci.ord.opemergency.view
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.view    </para>    
    /// <para>类 名 称 :  Class1					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  vivi         				</para> 
    /// <para>修 改 人 :  vivi         				</para> 
    /// <para>创建时间 :  11/10/2016 11:58:30 AM             </para>
    /// <para>更新时间 :  11/10/2016 11:58:30 AM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EmsButtonGroupView : XBaseControl, IEventDelegate
    {
        private Dictionary<EmsViewType, BaseButtonGroupView> RegisteBottomGroupMap = new Dictionary<EmsViewType, BaseButtonGroupView>();
        private BaseFormBizView ownerView;
        public EmsButtonGroupView(BaseFormBizView o)
        {
            this.ownerView = o;
            InitContext(o);
        }

        private void InitContext(BaseFormBizView ownerView)
        {
            BaseButtonGroupView btng = new BaseButtonGroupView(ownerView) { Dock = DockStyle.Fill };
            this.AddRender(btng);
            RegisteBottomGroupMap.Add(EmsViewType.EmptyEmsViewType, btng);

            btng = new EmsAddDelSaveCancelGroupView(ownerView) { Dock = DockStyle.Fill };
            this.AddRender(btng);
            RegisteBottomGroupMap.Add(EmsViewType.EmsDrugsViewType, btng);

            RegisteBottomGroupMap.Add(EmsViewType.EmsHerbsViewType, RegisteBottomGroupMap[EmsViewType.EmsDrugsViewType]);

            btng = new EmsSaveCancelGroupView(ownerView) { Dock = DockStyle.Fill };
            this.AddRender(btng);
            RegisteBottomGroupMap.Add(EmsViewType.EmsLisViewType, btng);

            RegisteBottomGroupMap.Add(EmsViewType.EmsRisViewType, RegisteBottomGroupMap[EmsViewType.EmsLisViewType]);
            RegisteBottomGroupMap.Add(EmsViewType.EmsConsViewType, RegisteBottomGroupMap[EmsViewType.EmsLisViewType]);
            RegisteBottomGroupMap.Add(EmsViewType.EmsOpsViewType, RegisteBottomGroupMap[EmsViewType.EmsLisViewType]);
            RegisteBottomGroupMap.Add(EmsViewType.EmsTreatViewType, RegisteBottomGroupMap[EmsViewType.EmsLisViewType]);
            RegisteBottomGroupMap.Add(EmsViewType.EmsPathgyViewType, RegisteBottomGroupMap[EmsViewType.EmsLisViewType]);

            btng = new EmsUseSaveCancelGroupView(ownerView) { Dock = DockStyle.Fill };
            this.AddRender(btng);
            RegisteBottomGroupMap.Add(EmsViewType.EmsApbtViewType, btng);
            RegisteBottomGroupMap.Add(EmsViewType.EmsApbuViewType, RegisteBottomGroupMap[EmsViewType.EmsLisViewType]);

            btng = new ExpAddDelSaveGroupView(ownerView) { Dock = DockStyle.Fill };
            this.AddRender(btng);
            RegisteBottomGroupMap.Add(EmsViewType.EmsExpenseViewType, btng);
        }


        public void ShowEmsButtonGroup(EmsViewType t)
        {
            
                this.RenderControls.ToList().ForEach(ctrl =>
                {
                    if (ctrl is BaseButtonGroupView) {
                        (ctrl as BaseButtonGroupView).Visible = false;
                    }
                });
              
            RegisteBottomGroupMap[t].Visible = true;
            RegisteBottomGroupMap[t].AdjustLayout();
        }

        public void ShowEmsButtonGroup(EmsViewType t, bool enable)
        {
            ShowEmsButtonGroup(t);
            SetEditEnable(enable);
        }

        public void SetEditEnable(bool enable)
        {
            this.RenderControls.ToList().ForEach(ctrl =>
            {
                if (ctrl is BaseButtonGroupView) {
                    (ctrl as BaseButtonGroupView).SetDataPolicy(enable);
                }
            });
        }

        private bool HandleEventState(object sender, DictionaryEventArgs e)
        {
            bool bRet = false;
            this.RenderControls.ToList().ForEach(ctrl =>
            {
                if (ctrl is BaseButtonGroupView)
                {
                    bRet|=(ctrl as BaseButtonGroupView).OnEventHandle(sender, e);
                }
            });

            return bRet;

        }

        public IEventDelegate GetEventDelegate()
        {
            return ownerView;
        }

        public bool OnChildNotify(object sender, DictionaryEventArgs e)
        {
            return GetEventDelegate().OnChildNotify(sender,e);
        }

        public bool OnEventHandle(object sender, DictionaryEventArgs e)
        {
           
            return HandleEventState(sender, e); ;
        }

        public bool OnEventSelected(object sender, object bannerData)
        {
            return true;
        }

        public BaseContext GetContext()
        {
            return GetEventDelegate().GetContext(); ;
        }
    }
}
