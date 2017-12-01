using iih.ci.ord.i;
using xap.mw.serviceframework;
using iih.en.pv.dto.d;
using iih.ci.ord.tmpl.d;
using iih.ci.ord.moreemsdto.d;
using iih.ci.ord.common.utils;
using xap.rui.engine;
using iih.ci.ord.ems.d;
using iih.bd.srv.ems.d;
using iih.ci.ord.ciorder.d;
using xap.rui.appfw;
using xap.mw.coreitf.d;
using System.Linq;
using xap.rui.control.extentions;
using iih.ci.ord.ciorder.i;
using iih.ci.ord.ciorder.utils;
using xap.mw.core.data;
using System.Collections.Generic;
using iih.bd.bc.udi;

namespace iih.ci.ord.opemergency.assi.enthistory.viewmodel
{
    /// <summary>
    /// <para>描    述 : 医嘱服务接口</para>
    /// <para>说    明 : </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.enthistory.viewmodel    </para>    
    /// <para>类 名 称 :  CiOrdViewModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  hums</para> 
    /// <para>修 改 人 :  hums</para> 
    /// <para>创建时间 :  2016/9/19 10:53:15</para>
    /// <para>更新时间 :  2016/9/19 10:53:15</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class CiOrdViewModel
    {
        /// <summary>
        /// banner数据
        /// </summary>
        private Ent4BannerDTO bannerDTO;
        /// <summary>
        /// 上下文环境
        /// </summary>
        private BaseContext context;

        /// <summary>
        /// 医嘱列表排序字段
        /// </summary>
        private string orderStr;

        /// <summary>
        /// 医嘱查询服务接口
        /// </summary>
        private ICiOrdQryService ciOrdQryService;



        private ICiorderMDOCrudService orderItemMService;

        public XapDataList<CiOrderDO> xapList;
        /// <summary>
        /// 医嘱对应价格map集合
        /// </summary>
        public FMap2 PriMap { get; set; }

        /// <summary>
        /// 医嘱不可用状态map集合
        /// </summary>
        public FMap2 OrdStatusMap { get; set; }



        private LogicEx logic = LogicEx.GetInstance();
        protected string id_en, code_entp;
        public CiOrderDO[] opsignords;//门诊已签署的医嘱（处置刷新到病历用）    


        public CiOrdViewModel(Ent4BannerDTO bannerDTO, BaseContext context)
        {
            this.bannerDTO = bannerDTO;
            this.context = context;
            ciOrdQryService = XapServiceMgr.find<ICiOrdQryService>();
            orderItemMService = XapServiceMgr.find<ICiorderMDOCrudService>();
            //获取医嘱列表排序字段
            orderStr = ciOrdQryService.getOrderSequenceMode();
        }

        /// <summary>
        /// 根据医嘱获取对应的医嘱模板拷贝对象
        /// </summary>
        /// <param name="ordIds">医嘱id集合</param>        
        /// <returns></returns>
        public MoreEmsParamDTO GetMoreEmsParam(string[] ordIds)
        {
            // 获取当前上下文就诊环境，需要包含医嘱来源、医疗单类型属性
            CiEnContextDTO ciEnContext = CiEnContextUtil.GetCiEnContext(bannerDTO, EmsAppModeEnum.SVEMSAPPMODE, OrSourceFromEnum.IIHPATIPASTHELPER, context);
            return ciOrdQryService.getHistoryMoreEmsParam(ordIds, ciEnContext);
        }

        /// <summary>
        /// 就诊历史中显示的医嘱列表
        /// </summary>
        /// <param name="id_en"></param>
        /// <param name="code_entp"></param>
        public void loadOderItems(string id_en, string code_entp)
        {

            if (string.IsNullOrEmpty(id_en) || string.IsNullOrEmpty(code_entp))
            {
                this.xapList.Clear();
                return ;
            }

            CiOrderDO[] ciOrders = null;

            //if (code_entp.Equals(BdFcDictCodeConst.SD_CODE_ENTP_IP))// 住院
            //{
            //    string whereStr = string.Format("a0.id_en='{0}' and a0.code_entp='{1}' and a0.fg_pres_outp='N' ", id_en, code_entp);
            //    ciOrders = this.orderItemMService.find(whereStr, "a0.createdtime  " + orderStr, FBoolean.False);
            //}
            //else if(BdFcDictCodeConst.SD_CODE_ENTP_OP.Equals(code_entp) || BdFcDictCodeConst.SD_CODE_ENTP_ET.Equals(code_entp))
            //{
            //    // 医嘱map结构，包含两项，orderList 医嘱list集合，orderPriMap 医嘱id与价格的map集合
            //    FMap2 map = ciOrdQryService.getEnHistoryCiOrders(id_en, code_entp, orderStr);
            //    FArrayList2 orderList = map["orderList"] as FArrayList2;
            //    ciOrders = orderList.Cast<CiOrderDO>().ToArray<CiOrderDO>();

            //    // 医嘱对应的价格 map中key=id_or，vlaue = 价格
            //    PriMap = map["orderPriMap"] as FMap2;
            //    OrdStatusMap = map["orderStatusMap"] as FMap2;
            //}

            // 医嘱map结构，包含两项，orderList 医嘱list集合，orderPriMap 医嘱id与价格的map集合
            FMap2 map = ciOrdQryService.getEnHistoryCiOrders(id_en, code_entp, orderStr);
            FArrayList2 orderList = map["orderList"] as FArrayList2;
            ciOrders = orderList.Cast<CiOrderDO>().ToArray<CiOrderDO>();

            // 医嘱对应的价格 map中key=id_or，vlaue = 价格
            PriMap = map["orderPriMap"] as FMap2;
            OrdStatusMap = map["orderStatusMap"] as FMap2;

            foreach (CiOrderDO ciOrder in ciOrders)
            {
                ciOrder.Str_long = ciOrder.Fg_long.Value == true ? "长期" : "临时";
                if (ciOrder.Emp_stop_name == null || ciOrder.Emp_stop_name == "")
                {
                    //如果没有停止医生 则医嘱列表停止时间 不显示 王琪需求
                    ciOrder.Dt_end = null;
                }
                if (ciOrder.Fg_long != FBoolean.True)
                { // 临时医嘱没有停止人
                    ciOrder.Emp_stop_name = null;
                }
                if (!string.IsNullOrEmpty(ciOrder.Id_emp_sign) && !ciOrder.Id_emp_sign.Equals(ciOrder.Id_emp_or))
                {   // 签署人与开立人不是同一人是，显示为 签署人/开立人
                    ciOrder.Emp_sign_name = ciOrder.Emp_sign_name + "/" + ciOrder.Emp_phy_name;
                }
                else
                {
                    ciOrder.Emp_sign_name = ciOrder.Emp_phy_name;
                }                
            }
           
            xapList = new XapDataList<CiOrderDO>(orderItemMService, ciOrders);
            
            //设定医嘱状态
            bool isOp = code_entp.Equals("00") ? true : false;
            logic.setOrderDisplayStatus(xapList, isOp);
            
        }
    }
}
