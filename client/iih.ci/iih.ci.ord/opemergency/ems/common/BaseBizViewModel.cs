using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciorder.utils;
using iih.bd.srv.medsrv.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ems.d;
using iih.en.pv.dto.d;
using iih.ci.ord_stub.i;
using iih.ci.ord.i;
using xap.mw.serviceframework;
using xap.rui.control.refcontrol.data;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.bd.bc.udi;
using xap.rui.engine;
using iih.ci.ord.opemergency.declare;

namespace iih.ci.ord.opemergency.ems.dp
{
    /// <summary>
    /// <para>描    述 :  数据模型基类        			</para>
    /// <para>说    明 :  提供通用的接口    			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.ems.dp    </para>    
    /// <para>类 名 称 :  BaseBizViewModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/6/30 16:27:45             </para>
    /// <para>更新时间 :  2016/6/30 16:27:45             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class BaseBizViewModel : IBizModel
    {
        // 逻辑处理工具类
        protected LogicEx logicEx = LogicEx.GetInstance();

        protected Ent4BannerDTO ent4BannerDTO;

        protected string errorMsgString = "";

        protected string tipInfoMsgString = "";

        private object customParameter;

        protected BaseContext context;

        public BaseBizViewModel()
        {
             Init();
        }

        public BaseBizViewModel(Ent4BannerDTO ent)
        {
            if (ent != null)
            {
                this.ent4BannerDTO = ent;
                Init();
            }
            
        }

        /// <summary>
        /// 初始化操作，做一些对象的实例化，以及常量赋值等操作
        /// </summary>
        public virtual void Init()
        {

        }

        public virtual bool IsEmpty()
        {
            return true;
        }

        public void SetContext(BaseContext ctx)
        {
            this.context = ctx;
        }

        public BaseContext GetContext()
        {
            return this.context;
        }

        /// <summary>
        /// <para>获取表格模型绑定对象</para>
        /// </summary>
        /// <returns></returns>
        public virtual object GetTableDataSource()
        {
            throw new NotImplementedException();
            
        }

        /// <summary>
        /// <para>获取选项卡模型绑定对象</para>
        /// </summary>
        /// <returns></returns>
        public virtual object GetFormDataSource()
        {
            throw new NotImplementedException();
            
        }

        /// <summary>
        /// 清空列表模型数据
        /// </summary>
        public virtual void ClearTableDataSource()
        {
           
        }

        /// <summary>
        /// 获取用户参数数据
        /// </summary>
        /// <returns></returns>
        public virtual object GetCustomParam()
        {
            return customParameter;
        }

        /// <summary>
        /// 向模型设置用户自定义参数数据
        /// </summary>
        /// <param name="param"></param>
        public virtual void SetCustomParam(object param)
        {
            customParameter = param;
        }


        /// <summary>
        /// 选择参照过滤器
        /// </summary>
        /// <param name="filedName"> 字段名称 </param>
        /// <returns></returns>
        public virtual string OnRefFilterData(string filedName ,StringObjectMap sbm=null)
        {
            return "";
        }

        public virtual bool OnRefResultData(string fieldName, Object ds)
        {
            return false;
        }

        /// <summary>
        /// 当 UI 中含有 OnDataChanged 事件处理时候，需要改变模型中的数据时候调用
        /// </summary>
        /// <param name="index">列表的话，给定行号，选项卡的话给-1</param>
        /// <param name="fieldName">字段名称</param>
        /// <param name="value"></param>
        public virtual void OnDataChanged(Object ds, String fieldName, string value)
        {
            
        }


        public virtual string GetErrorMsg()
        {
            return errorMsgString;
        }

        public void ClearErrorMsg()
        {
            errorMsgString = "";
        }

        public virtual string GetTipInfoMsg()
        {
            return tipInfoMsgString;
        }

        public void ClearTipInfo()
        {
            tipInfoMsgString = "";
        }

        public virtual string[] GetHiddenFields()
        {
           
            return null;
        }

        public virtual string[] GetReadonlyFields()
        {
            return null;
        }

        /// <summary>
        /// 固定列
        /// </summary>
        /// <returns></returns>
        public virtual string[] GetFixedFields()
        {
            return new string[] { "Name_srv", "Quan_med", "Name_freq", "Quan_cur", "Name_mp_dep", "Use_days", "Fg_extdispense","Totalprice","Price" };
        }

        public void SetEnt4BannerDTO( Ent4BannerDTO ent)
        {
            this.ent4BannerDTO = ent;
        }
        public  Ent4BannerDTO GetEnt4BannerDTO()
        {
            return this.ent4BannerDTO;
        }

        public LogicEx GetLogicEx()
        {
            return logicEx;
        }
    }
}
