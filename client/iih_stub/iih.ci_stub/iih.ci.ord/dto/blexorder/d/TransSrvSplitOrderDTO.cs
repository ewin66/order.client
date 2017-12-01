using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.blexorder.d
{
    /// <summary>
    /// TransSrvSplitOrderDTO 的摘要说明。
    /// </summary>
    public class TransSrvSplitOrderDTO : BaseDTO {

        public TransSrvSplitOrderDTO()
        {
 
        }

        /// <summary>
        /// 医嘱
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
     

        /// <summary>
        /// 生效日期
        /// </summary>
		public DateTime? Dt_effe {
            get { return getAttrVal<FDateTime>("Dt_effe",null); }
            set { setAttrVal<FDateTime>("Dt_effe", value); }
        }

        /// <summary>
        /// 结束日期
        /// </summary>
		public DateTime? Dt_end {
            get { return getAttrVal<FDateTime>("Dt_end",null); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }

    

        /// <summary>
        /// 长临标识
        /// </summary>
		public bool? Fg_long {
            get { return getAttrVal<FBoolean>("Fg_long",null); }
            set { setAttrVal<FBoolean>("Fg_long", value); }
        }

      

        /// <summary>
        /// 停止日期
        /// </summary>
		public DateTime? Dt_stop {
            get { return getAttrVal<FDateTime>("Dt_stop",null); }
            set { setAttrVal<FDateTime>("Dt_stop", value); }
        }

      

        /// <summary>
        /// 医嘱服务项目
        /// </summary>
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }

        /// <summary>
        /// 服务项目
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 服务编码
        /// </summary>
		public string Code_srv {
            get { return getAttrVal<string>("Code_srv",null); }
            set { setAttrVal<string>("Code_srv", value); }
        }

        /// <summary>
        /// 服务名称
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }      

        /// <summary>
        /// 医嘱服务执行状态
        /// </summary>
		public string Orsrv_su_mp {
            get { return getAttrVal<string>("Orsrv_su_mp",null); }
            set { setAttrVal<string>("Orsrv_su_mp", value); }
        }

        /// <summary>
        /// 服务类型
        /// </summary>
		public string Id_srvtp {
            get { return getAttrVal<string>("Id_srvtp",null); }
            set { setAttrVal<string>("Id_srvtp", value); }
        }

        /// <summary>
        /// 服务类型编码
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }


     


        /// <summary>
        /// 计划执行时间
        /// </summary>
		public DateTime? Dt_mp_plan {
            get { return getAttrVal<FDateTime>("Dt_mp_plan",null); }
            set { setAttrVal<FDateTime>("Dt_mp_plan", value); }
        }

        /// <summary>
        /// 频次周期下次数
        /// </summary>
        public int? Freqcnt
        {
            get { return getAttrVal<int?>("Freqcnt", null); }
            set { setAttrVal<int?>("Freqcnt", value); }
        }


        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_or", "Dt_effe", "Dt_end", "Fg_long","Dt_stop", 
                "Id_orsrv", "Id_srv", "Code_srv", "Name_srv",  "Orsrv_su_mp",
                "Id_srvtp", "Sd_srvtp","Dt_mp_plan","Freqcnt"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.blexorder.d.TransSrvSplitOrderDTO";
        }
    }
}
