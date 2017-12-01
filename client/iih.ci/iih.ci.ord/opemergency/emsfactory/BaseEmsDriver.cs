
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciorder.ems;
using iih.ci.ord.opemergency.ems.dp;
using iih.ci.ord.opemergency.ems.common;
using xap.rui.control.basecontrol;
using iih.en.pv.dto.d;
using iih.ci.ord.opemergency.view.basic;
using iih.ci.ord.opemergency.view;
using iih.bd.srv.ems.d;

namespace iih.ci.ord.opemergency.emsfactory
{
    /// <summary>
    /// <para>描    述 :  医疗单驱动基类                </para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.emsfactory    </para>    
    /// <para>类 名 称 :  Class1					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/7/19 8:18:28             </para>
    /// <para>更新时间 :  2016/7/19 8:18:28             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class BaseEmsDriver : EmsFactoryBase
    {
       
        protected Ent4BannerDTO ent4Banner;
        protected BaseEmsView emsView;
        protected BaseEmsViewModel emsModel;
        protected SrvMatchEmsRstDTO EmsMgrDTO;


        public BaseEmsDriver SetEmt4Banner(Ent4BannerDTO e)
        {
            this.ent4Banner = e;
            return this;
        }

        public BaseEmsDriver SetEmsMatchRstDTO(SrvMatchEmsRstDTO o)
        {
            this.EmsMgrDTO = o;
            return this;
        }

        public virtual BaseEmsViewModel GetEmsModel()
        {
            if (this.ent4Banner == null)
            {
                return null;
            }
            //if (this.emsModel == null)
            {
                this.emsModel = CreateEmsModel(this.ent4Banner).setEmsMatchRstDTO(this.EmsMgrDTO);
            }
            
            return emsModel;
        }


        public virtual BaseEmsDriver Initialize(BaseFormBizView c, Ent4BannerDTO e, SrvMatchEmsRstDTO eo)
        {
           
            this.ent4Banner = e;
            this.EmsMgrDTO = eo;
            if (null == c) {
                return null;
            }
            //if (null == this.emsView)
            {
                this.emsView = this.CreateEmsView(c);
            }
            BaseEmsViewModel model = this.GetEmsModel();
            model.SetContext(c.Context);
            this.emsView.SetViewModel(model);

            return this;
        }

        public virtual BaseEmsView GetEmsView()
        {
            
            ////if (null == this.emsView)
            //{
            //    this.emsView = this.CreateEmsView(this.contextControl);
            //}
            //BaseEmsViewModel model = this.GetEmsModel();
           
            //this.emsView.SetViewModel(model);
            
            return this.emsView;
        }

        protected virtual BaseEmsView CreateEmsView(IEventDelegate o)
        {
            return null;
        }

        protected virtual BaseEmsViewModel CreateEmsModel(Ent4BannerDTO e)
        {
            return null;
        }
        protected virtual BaseEmsViewModel CreateExpenseModel(Ent4BannerDTO e)
        {
            return null;
        }

        #region 重载方法
        public override ciorder._ems.EmsModelBase GetModel()
        {
            throw new NotImplementedException();
        }
        public override EmsViewBase GetView()
        {
            throw new NotImplementedException();
        }
        #endregion
    }
}
