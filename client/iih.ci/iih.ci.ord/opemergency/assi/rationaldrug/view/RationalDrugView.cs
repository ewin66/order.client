
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using xap.rui.control.basecontrol;
using iih.en.pv.dto.d;
using xap.rui.engine;
using iih.ci.ord.ordsrvmm.d;
using iih.ci.ord.ciorder.d;
using xap.rui.bizcontrol.bannercontrol;
using iih.ci.ord.opemergency.assi.rationaldrug.viewmodel;
using iih.pi.reg.pat.d;
using iih.pi.reg.pat.i;
using xap.mw.serviceframework;
using iih.ci.ord.common.utils;
using iih.ci.ord.ems.d;

namespace iih.ci.ord.opemergency.assi.rationaldrug.view
{
    /// <summary>
    /// <para>描    述 :  合理用药验证基类</para>
    /// <para>说    明 :  继承合理用药验证功能，不同的合理用药产品集成时需要实现该类的方法</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.rationaldrug.view    </para>    
    /// <para>类 名 称 :  RationalDrugView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2016/9/27 9:37:04             </para>
    /// <para>更新时间 :  2016/9/27 9:37:04             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class RationalDrugView : XapBaseControl
    {

        #region 变量定义区域

        protected RationalDrugViewModel viewModel { get; set; }

        /// <summary>
        /// 当前就诊环境对象
        /// </summary>
        protected CiEnContextDTO ctxDTO;

        protected PatDO pat { get; set; }        

        /// <summary>
        /// 患者查询服务接口
        /// </summary>        
        private IPatiMDOCrudService patiMDOCrudService;

        #endregion

        #region 构造函数区域

        public RationalDrugView()
        {
            patiMDOCrudService = XapServiceMgr.find<IPatiMDOCrudService>();
            InitializeComponent();
        }

        #endregion

        #region 公开属性区域

        /// <summary>
        /// 当前加载合理用药类
        /// </summary>
        //public string RationalDrugViewClass { get; set; }

        #endregion

        #region 命令定义区域

        #endregion

        #region 事件发送区域

        #endregion

        #region 事件接收区域

        #endregion

        #region 父类继承区

        public override void OnSelected(object sender, TargetEventArgs e)
        {
            BannerData bannerData = e.Object as BannerData;
            if (bannerData != null && bannerData.Ent4BannerDTO != null)
            {
                viewModel.InitRationStatus();
                this.ctxDTO = CiEnContextUtil.GetCiEnContext(bannerData.Ent4BannerDTO, this.Context);                
               // this.pat = patiMDOCrudService.findById(this.ctxDTO.Id_pat);
                
            }
            else
            {
                this.ctxDTO = null;
                this.pat = null;
            }
        }

        #endregion

        #region 子类继承区域

        public virtual void InitRationStatus()
        {

        }

        /// <summary>
        /// 根据物品信息显示
        /// </summary>
        /// <param name="idOrsrv">根据医嘱服务显示物品提示信息</param>
        /// <returns></returns>
        public virtual string ShowDrugInstruction(string idOrsrv)
        {

            return "";
        }

        /// <summary>
        /// 根据物品信息显示
        /// </summary>
        /// <param name="ordSrvMm"></param>
        /// <returns></returns>
        public virtual string ShowDrugInstruction(OrdSrvMmDO ordSrvMm)
        {

            return "";
        }

        /// <summary>
        /// 根据物品编码、名称显示提示
        /// </summary>
        /// <param name="code"></param>
        /// <param name="name"></param>
        public virtual void ShowDrugInstruction(string code, string name)
        {

        }

        /// <summary>
        /// 对医嘱中药品进行分析进行分析
        /// </summary>
        /// <param name="ciords">医嘱集合</param>
        /// <param name="msg">返回的提示信息</param>
        /// <returns>返回的操作状态0，直接执行，1弹出提示框，仅有确定按钮，确定后继续执行，2弹出提示框，包含确定取消按钮，确定继续执行，取消不执行</returns>
        public virtual bool AnalysisPresResult(CiOrderDO[] ciords)
        {
            return true;
        }

        #endregion

        #region 内部事件区域

        #endregion

        #region 辅助处理函数



        #endregion

        #region 状态处理区域

        #endregion



    }
}
